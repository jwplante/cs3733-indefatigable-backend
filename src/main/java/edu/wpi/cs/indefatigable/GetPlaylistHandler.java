package edu.wpi.cs.indefatigable;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.wpi.cs.indefatigable.db.PlaylistDAO;
import edu.wpi.cs.indefatigable.http.GetPlaylistRequest;
import edu.wpi.cs.indefatigable.http.GetPlaylistResponse;
import edu.wpi.cs.indefatigable.model.Playlist;

public class GetPlaylistHandler implements RequestHandler<GetPlaylistRequest, GetPlaylistResponse> {
    LambdaLogger logger;

    // Cosntructor
    public GetPlaylistHandler() {}

     /*
     * Load Playlist from the RDS
     * @throws Exception
     */
    Playlist loadValueFromRDS(String arg) throws Exception {
        if (logger != null) { logger.log("in loadValue"); }
        PlaylistDAO dao = new PlaylistDAO();
        Playlist playlist = dao.getPlaylist(arg);
        return playlist;
    }

    @Override
    public GetPlaylistResponse handleRequest(GetPlaylistRequest input, Context context) {
        try {
            // Getting the playlist ID
            String puid = input.getID();
            Playlist playlistToSend = loadValueFromRDS(puid);

            return new GetPlaylistResponse(playlistToSend);
        } catch (Exception e) {
            return new GetPlaylistResponse();
        }
    }
}
