package edu.wpi.cs.indefatigable;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.wpi.cs.indefatigable.db.VideoDAO;
import edu.wpi.cs.indefatigable.http.MarkVideoRequest;
import edu.wpi.cs.indefatigable.http.MarkVideoResponse;

public class MarkVideoHandler implements RequestHandler<MarkVideoRequest, MarkVideoResponse> {
    public LambdaLogger logger = null;

    @Override
    public MarkVideoResponse handleRequest(MarkVideoRequest input, Context context) {
        logger = context.getLogger();
        logger.log("Loading Java Lambda handler to mark Video as remote available");
        MarkVideoResponse res;
        VideoDAO dao = new VideoDAO();
        try{
            if(dao.markVideoAsRemote(input.getVuid())){
                res = new MarkVideoResponse(input.getVuid(), 200);
            }else{
                res = new MarkVideoResponse(input.getVuid(), 422, "Unable to mark video");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res = new MarkVideoResponse(input.getVuid(), 403, "Unable to mark video");
        }
        return res;
    }
}
