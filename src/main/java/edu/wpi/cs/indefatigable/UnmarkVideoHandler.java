package edu.wpi.cs.indefatigable;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.wpi.cs.indefatigable.db.VideoDAO;
import edu.wpi.cs.indefatigable.http.UnmarkVideoRequest;
import edu.wpi.cs.indefatigable.http.UnmarkVideoResponse;

public class UnmarkVideoHandler implements RequestHandler<UnmarkVideoRequest, UnmarkVideoResponse> {
    public LambdaLogger logger = null;

    @Override
    public UnmarkVideoResponse handleRequest(UnmarkVideoRequest input, Context context) {
        logger = context.getLogger();
        logger.log("Loading Java Lambda handler to unmark Video as remote available");
        UnmarkVideoResponse res;
        VideoDAO dao = new VideoDAO();
        try{
            if(dao.unmarkVideoAsRemote(input.getVuid())){
                res = new UnmarkVideoResponse(input.getVuid(), 200);
            }else{
                res = new UnmarkVideoResponse(input.getVuid(), 422, "Unable to unmark video");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res = new UnmarkVideoResponse(input.getVuid(), 403, "Unable to unmark video");
        }
        return res;
    }
}

