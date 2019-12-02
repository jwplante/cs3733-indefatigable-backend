package edu.wpi.cs.indefatigable;
import edu.wpi.cs.indefatigable.db.*;
import edu.wpi.cs.indefatigable.http.*;
import edu.wpi.cs.indefatigable.model.Playlist;
import edu.wpi.cs.indefatigable.model.Video;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class AppendSegmentToPlaylistHandler implements RequestHandler<AppendSegmentToPlaylistRequest, AppendSegmentToPlaylistResponse> {
	PlaylistDAO pDAO;
	VideoDAO vDAO;
	LambdaLogger logger;
	@Override
	public AppendSegmentToPlaylistResponse handleRequest(AppendSegmentToPlaylistRequest input, Context context) {
		logger = context.getLogger();
		logger.log("Appending segment "+ input.getVuid()+" to playlist "+input.getPuid());
		pDAO = new PlaylistDAO();
		vDAO = new VideoDAO();
		logger.log(input.toString());
		boolean result = false;
		try {
			Video v = vDAO.getVideo(input.getVuid());
			Playlist p = pDAO.getPlaylist(input.getPuid());
			result = pDAO.appendSegment(v, p);
			
		}
		catch (Exception e) {
			//something has gone wrong in accessing the videos or playlists.
			logger.log(e.toString());
		}
		if (result == true) {
			return new AppendSegmentToPlaylistResponse(200);
		}
		else return new AppendSegmentToPlaylistResponse(400);
	}
	
}
