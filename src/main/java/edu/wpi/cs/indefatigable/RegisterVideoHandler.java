package edu.wpi.cs.indefatigable;

import java.util.UUID;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;

import edu.wpi.cs.indefatigable.db.VideoDAO;
import edu.wpi.cs.indefatigable.http.RegisterVideoRequest;
import edu.wpi.cs.indefatigable.http.RegisterVideoResponse;
import edu.wpi.cs.indefatigable.model.Video;

public class RegisterVideoHandler implements RequestHandler<RegisterVideoRequest, RegisterVideoResponse> {

    LambdaLogger logger;

    // Video Upload Settings
    private static final boolean DEFAULT_REMOTE_AVAILABILITY = false;
    private static final boolean DEFAULT_IS_REMOTE = true;
    private static final String REMOTE_VIDEO_TITLE = "[Remote Video]";


    @Override
    public RegisterVideoResponse handleRequest(RegisterVideoRequest input, Context context) {
        logger = context.getLogger();
        logger.log("Initializing CreateVideoHandler!");

        try {
        	String randomUID = UUID.randomUUID().toString();
            // To avoid duplicates take the name of the videoFile and add a UUID to the end
        	
            // Put everything into a temporary video object
            Video tempVideoHolder = new Video(randomUID,
                    input.getURL(),
                    DEFAULT_REMOTE_AVAILABILITY,
                    DEFAULT_IS_REMOTE,
                    input.getCharacter(),
                    input.getTranscript(),
                    REMOTE_VIDEO_TITLE);

            // Insert the video into the database
            logger.log("upload complete:" + input.getURL());

            VideoDAO dao = new VideoDAO();
            dao.addVideo(tempVideoHolder);

            logger.log("db updated");
            return new RegisterVideoResponse(200);
        } catch (Exception e) {
            // FAIL
            e.printStackTrace();
            logger.log("handleRequest: Upload failed!");
            return new RegisterVideoResponse(403);
        }
    }
}
