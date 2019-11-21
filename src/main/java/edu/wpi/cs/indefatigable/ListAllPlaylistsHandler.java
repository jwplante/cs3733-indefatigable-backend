package edu.wpi.cs.indefatigable;
import java.util.ArrayList;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;


import edu.wpi.cs.indefatigable.db.PlaylistDAO;
import edu.wpi.cs.indefatigable.http.AllPlaylistsResponse;
import edu.wpi.cs.indefatigable.model.Playlist;

public class ListAllPlaylistsHandler implements RequestHandler<Object,AllPlaylistsResponse>{
	public LambdaLogger log;
	
	@Override
	public AllPlaylistsResponse handleRequest(Object input, Context context) {
		log = context.getLogger();
		log.log("Snatching all playlists from playlist DAO");
		AllPlaylistsResponse res;
		try {
			ArrayList<Playlist> playlists = getPlaylists();
			res = new AllPlaylistsResponse(playlists, 200);
		}
		catch (Exception e) {
			log.log("Error: "+e.toString());
			res = new AllPlaylistsResponse(400, e.toString());
		}
		return res;
	}
	
	ArrayList<Playlist> getPlaylists() throws Exception{
		//get playlists from RDS
		PlaylistDAO dao = new PlaylistDAO();
		return dao.playlists();
	}
}
