package edu.wpi.cs.indefatigable;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.wpi.cs.indefatigable.db.VideoDAO;
import edu.wpi.cs.indefatigable.http.AllVideosResponse;
import edu.wpi.cs.indefatigable.model.Video;

import java.util.List;

public class ListAllVideosHandler implements RequestHandler<Object, AllVideosResponse> {

    public LambdaLogger logger;
    /** Load from RDS, if it exists
     *
     * @throws Exception
     */
    List<Video> getVideos() throws Exception{
        logger.log("in getVideos");
        VideoDAO dao = new VideoDAO();
        return dao.getAllVideos();
    }

    @Override
    public AllVideosResponse handleRequest(Object input, Context context) {
        logger = context.getLogger();
        logger.log("Loading Java Lambda handler to list all constants");
        AllVideosResponse response;
        try {
            List<Video> list = getVideos();
            response = new AllVideosResponse(list, 200);
        } catch (Exception e) {
            response = new AllVideosResponse(403, e.getMessage());
        }
        return response;
    }
}
