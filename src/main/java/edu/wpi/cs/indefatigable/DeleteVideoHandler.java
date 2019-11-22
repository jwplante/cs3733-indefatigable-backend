package edu.wpi.cs.indefatigable;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import edu.wpi.cs.indefatigable.db.VideoDAO;
import edu.wpi.cs.indefatigable.http.DeleteVideoRequest;
import edu.wpi.cs.indefatigable.http.DeleteVideoResponse;
//THANK YOU TO PROFESSOR GEORGE HEINEMAN FOR HIS CALCULATOR IMPLEMENTATION, WHICH WE HAVE ADAPTED FOR OUR PROJECT.
public class DeleteVideoHandler implements RequestHandler<DeleteVideoRequest,DeleteVideoResponse> {

	public LambdaLogger logger = null;

	@Override
	public DeleteVideoResponse handleRequest(DeleteVideoRequest req, Context context) {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to delete");

		DeleteVideoResponse response = null;
		logger.log(req.toString());

		VideoDAO dao = new VideoDAO();

		// See how awkward it is to call delete with an object, when you only
		// have one part of its information?
		try {
			if (dao.deleteVideo(req.vuid)) {
				response = new DeleteVideoResponse(req.vuid, 200);
			} else {
				response = new DeleteVideoResponse(req.vuid, 422, "Unable to delete video.");
			}
		} catch (Exception e) {
			response = new DeleteVideoResponse(req.vuid, 403, "Unable to delete video: " + req.vuid + "(" + e.getMessage() + ")");
		}

		return response;
	}
}
