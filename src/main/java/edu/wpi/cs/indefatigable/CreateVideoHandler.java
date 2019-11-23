package edu.wpi.cs.indefatigable;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import edu.wpi.cs.indefatigable.http.CreateVideoRequest;
import edu.wpi.cs.indefatigable.http.CreateVideoResponse;

import java.io.ByteArrayInputStream;

public class CreateVideoHandler implements RequestHandler<CreateVideoRequest, CreateVideoResponse> {

    LambdaLogger logger;
    private AmazonS3 s3 = null;


    private boolean putVideoInS3(String name, String videoFile) throws Exception {
        try {
            byte[] contents = videoFile.getBytes();
            if (logger != null) { logger.log("in createSystemConstant"); }

            if (s3 == null) {
                logger.log("attach to S3 request");
                s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
                logger.log("attach to S3 succeed");
            }

            ByteArrayInputStream bais = new ByteArrayInputStream(contents);
            ObjectMetadata omd = new ObjectMetadata();
            omd.setContentLength(contents.length);

            PutObjectResult res = s3.putObject(new PutObjectRequest("cs3733wpi", "constants/" + name, bais, omd));

            // if we ever get here, then whole thing was stored
            return true;
        } catch (Exception e) {
            logger.log("Unable to store video in S3 bucket!");
            return false;
        }
    }

    @Override
    public CreateVideoResponse handleRequest(CreateVideoRequest input, Context context) {
        logger = context.getLogger();
        logger.log("Initializing CreateVideoHandler!");
    }
}
