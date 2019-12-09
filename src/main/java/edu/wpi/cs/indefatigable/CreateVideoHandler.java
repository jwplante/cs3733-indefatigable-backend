package edu.wpi.cs.indefatigable;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.util.Base64;
import edu.wpi.cs.indefatigable.db.VideoDAO;
import edu.wpi.cs.indefatigable.http.CreatePlaylistResponse;
import edu.wpi.cs.indefatigable.http.CreateVideoRequest;
import edu.wpi.cs.indefatigable.http.CreateVideoResponse;
import edu.wpi.cs.indefatigable.model.Video;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class CreateVideoHandler implements RequestHandler<CreateVideoRequest, CreateVideoResponse> {  // HACK TO TRY OUT DIFF RESP

    LambdaLogger logger;
    private AmazonS3 s3 = null;

    // Video Upload Settings
    private final String BUCKET_NAME = "cs3733-indefatigable";
    private final String VIDEO_PATH = "/media/";
    private final boolean DEFAULT_REMOTE_AVAILABILITY = false;
    private final boolean DEFAULT_IS_REMOTE = false;

    /***
     * Takes in the name of the video and the video file in base64 encoding,
     * decodes the string inserts into the S3 bucket. Returns a String containing
     * the URL of the public S3 bucket.
     * @param name - Name of the video file (unique)
     * @param videoFile - Contents of the video file in Base64
     * @return (String) URL of the newly created S3 bucket
     * @throws Exception
     */
    private String putVideoInS3(String name, String videoFile) throws Exception {
            // Take the base64 and decode it
            byte[] contents = Base64.decode(videoFile);

            if (logger != null) {
                logger.log("in putVideoInS3");
            }

            if (s3 == null) {
                logger.log("attach to S3 request");
                s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
                logger.log("attach to S3 succeed");
            }

            ByteArrayInputStream bais = new ByteArrayInputStream(contents);
            ObjectMetadata omd = new ObjectMetadata();
            omd.setContentLength(contents.length);

            // Add video to bucket with public read permission
            logger.log(VIDEO_PATH + name + ".ogg"); 
            PutObjectResult res = s3.putObject(new PutObjectRequest(BUCKET_NAME,VIDEO_PATH+ name + ".ogg", bais, omd)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
            // if we ever get here, then whole thing was stored
            return s3.getUrl(BUCKET_NAME, VIDEO_PATH + name + ".ogg").toString();
    }

    @Override
    public CreateVideoResponse handleRequest(CreateVideoRequest input, Context context) {
        logger = context.getLogger();
        logger.log("Initializing CreateVideoHandler!");

        try {
        	String randomUID = UUID.randomUUID().toString();
            // To avoid duplicates take the name of the videoFile and add a UUID to the end
            String uniqueFileName = input.getTitle() + "-" + randomUID;
            // Upload to S3 BUCKET WOOOOO!
            String url = putVideoInS3(uniqueFileName, input.getVideo());
            // Put everything into a temporary video object
            Video tempVideoHolder = new Video(randomUID,
                    url,
                    DEFAULT_REMOTE_AVAILABILITY,
                    DEFAULT_IS_REMOTE,
                    input.getCharacter(),
                    input.getTranscript(),
                    input.getTitle());

            // Insert the video into the database
            logger.log("upload complete:" + url);

            VideoDAO dao = new VideoDAO();
            dao.addVideo(tempVideoHolder);
            logger.log("db updated");
            return new CreateVideoResponse(200,randomUID);
        } catch (Exception e) {
            // FAIL
            e.printStackTrace();
            logger.log("handleRequest: Upload failed!");
            return new CreateVideoResponse(403);
        }
    }
}
