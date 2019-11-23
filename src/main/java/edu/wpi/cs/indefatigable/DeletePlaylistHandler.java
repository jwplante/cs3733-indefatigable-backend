package edu.wpi.cs.indefatigable;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.wpi.cs.indefatigable.db.PlaylistDAO;
import edu.wpi.cs.indefatigable.http.DeletePlaylistRequest;
import edu.wpi.cs.indefatigable.http.DeletePlaylistResponse;

public class DeletePlaylistHandler implements RequestHandler<DeletePlaylistRequest, DeletePlaylistResponse> {
public LambdaLogger logger = null;

    @Override
    public DeletePlaylistResponse handleRequest(DeletePlaylistRequest input, Context context) {
        logger = context.getLogger();
        logger.log("Loading Java Lambda handler to delete playlist");
        DeletePlaylistResponse res;
        PlaylistDAO dao = new PlaylistDAO();
        try{
            if(dao.deletePlaylist(input.puid)){
                res = new DeletePlaylistResponse(input.puid, 200);
            }else{
                res = new DeletePlaylistResponse(input.puid, 422, "Unable to delete playlist");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res = new DeletePlaylistResponse(input.puid, 403, "Unable to delete playlist");
        }
        return res;
    }
}
