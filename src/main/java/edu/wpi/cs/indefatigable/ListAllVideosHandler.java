package edu.wpi.cs.indefatigable;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.wpi.cs.indefatigable.db.VideoDAO;
import edu.wpi.cs.indefatigable.http.AllVideosResponse;
import edu.wpi.cs.indefatigable.model.Video;
import java.util.ArrayList;

public class ListAllVideosHandler implements RequestHandler<Object, AllVideosResponse> {

    public LambdaLogger logger;
    ArrayList<Video> getVideos() throws Exception{
        logger.log("\nin get Videos\n");
        VideoDAO dao = new VideoDAO();
        return dao.getAllVideos();
    }

    @Override
    public AllVideosResponse handleRequest(Object req, Context context) {
        logger = context.getLogger();
        logger.log("Loading Java Lambda handler to list all videos");
        logger.log(req.toString());
        AllVideosResponse response;
        try {
            ArrayList<Video> videos = getVideos();
            response = new AllVideosResponse(videos, 200);
        } catch (Exception e) {
            logger.log(e.toString());
            response = new AllVideosResponse(403, e.getMessage());
        }
        return response;
    }
}
