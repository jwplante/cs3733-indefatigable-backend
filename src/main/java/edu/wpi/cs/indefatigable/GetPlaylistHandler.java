package edu.wpi.cs.indefatigable;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.wpi.cs.indefatigable.http.GetPlaylistRequest;
import edu.wpi.cs.indefatigable.http.GetPlaylistResponse;

public class GetPlaylistHandler implements RequestHandler<GetPlaylistRequest, GetPlaylistResponse> {

    // Cosntructor
    public GetPlaylistHandler() {}

    @Override
    public GetPlaylistResponse handleRequest(GetPlaylistRequest input, Context context) {
        return null;
    }
}
