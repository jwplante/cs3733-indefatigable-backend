package edu.wpi.cs.indefatigable;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.wpi.cs.indefatigable.db.PlaylistDAO;
import edu.wpi.cs.indefatigable.http.CreatePlaylistRequest;
import edu.wpi.cs.indefatigable.http.CreatePlaylistResponse;

public class CreatePlaylistHandler implements RequestHandler<CreatePlaylistRequest, CreatePlaylistResponse> {
    public LambdaLogger log;

    @Override
    public CreatePlaylistResponse handleRequest(CreatePlaylistRequest req, Context context) {
        log = context.getLogger();
        log.log("In CreatePlaylistResponse");
        CreatePlaylistResponse res;
        PlaylistDAO dao = new PlaylistDAO();
        try{
            if(dao.createPlaylist(req.getName())){
                res = new CreatePlaylistResponse(200);
            }else{
                res = new CreatePlaylistResponse(403, "error occurred");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res = new CreatePlaylistResponse(403, "error occurred");
        }
        return res;
    }
}
