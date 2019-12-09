package edu.wpi.cs.indefatigable;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import edu.wpi.cs.indefatigable.db.PlaylistDAO;
import edu.wpi.cs.indefatigable.http.RemoveVideoFromPlaylistRequest;
import edu.wpi.cs.indefatigable.http.RemoveVideoFromPlaylistResponse;

public class RemoveVideoFromPlaylistHandler implements RequestHandler<RemoveVideoFromPlaylistRequest,RemoveVideoFromPlaylistResponse> {
	public LambdaLogger logger = null;
	
	@Override
	public RemoveVideoFromPlaylistResponse handleRequest(RemoveVideoFromPlaylistRequest req, Context context) {
		logger = context.getLogger();
		logger.log("Loading Java lambda handler to remove video from playlist.");
		RemoveVideoFromPlaylistResponse response = null;
		logger.log(req.toString());
		
		PlaylistDAO dao = new PlaylistDAO();
		
		try {
			if(dao.removeSegment(req.vuid, req.puid)) {
				response = new RemoveVideoFromPlaylistResponse(req.vuid, req.puid, 200);
				
			} else {
				response = new RemoveVideoFromPlaylistResponse(req.vuid, req.puid, 403, "Unable to remove segment");
			}
		}catch (Exception e) {
				response = new RemoveVideoFromPlaylistResponse(req.vuid, req.puid, 403, "Unable to remove segment: " + req.vuid + " from playlist: " + req.puid + "("+ e.getMessage() + ")");
				
		}
		return response;
	}
}
