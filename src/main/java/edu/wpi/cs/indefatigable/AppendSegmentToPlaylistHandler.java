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
		AppendSegmentToPlaylistResponse res;
		logger.log(input.toString());
		try {
			Video v = vDAO.getVideo(input.getVuid());
			Playlist p = pDAO.getPlaylist(input.getPuid());
		}
		catch (Exception e) {
			//uhoh
			//stinky
			logger.log(e.toString());
		}
		return null;
	}
	
}
