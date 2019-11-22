package edu.wpi.cs.indefatigable;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.wpi.cs.indefatigable.db.VideoDAO;
import edu.wpi.cs.indefatigable.http.AllRemotelyAvailableVideosResponse;
import edu.wpi.cs.indefatigable.model.RemotelyAvailableVideo;
import edu.wpi.cs.indefatigable.model.Video;
import java.util.ArrayList;

public class ListAllRemotelyAvailableVideosHandler implements RequestHandler<Object, AllRemotelyAvailableVideosResponse> {

    public LambdaLogger logger;
    ArrayList<RemotelyAvailableVideo> getRemotelyAvailableVideos() throws Exception{
        logger.log("\nin get Videos\n");
        VideoDAO dao = new VideoDAO();
        return dao.getAllRAVideos();
    }

    @Override
    public AllRemotelyAvailableVideosResponse handleRequest(Object req, Context context) {
        logger = context.getLogger();
        logger.log("Loading Java Lambda handler to list all RA videos");
        //logger.log(req.toString());
        AllRemotelyAvailableVideosResponse response;
        try {
            ArrayList<RemotelyAvailableVideo> videos = getRemotelyAvailableVideos();
            response = new AllRemotelyAvailableVideosResponse(videos, 200);
        } catch (Exception e) {
            logger.log(e.toString());
            response = new AllRemotelyAvailableVideosResponse(403, e.getMessage());
        }
        return response;
    }
}
