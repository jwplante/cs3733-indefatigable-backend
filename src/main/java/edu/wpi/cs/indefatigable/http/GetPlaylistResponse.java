package edu.wpi.cs.indefatigable.http;

import edu.wpi.cs.indefatigable.model.Playlist;

public class GetPlaylistResponse {
    public final int statusCode;
    public final Playlist p;

    public GetPlaylistResponse(Playlist p) {
        this.statusCode = 200;
        this.p = p;
    }

    public GetPlaylistResponse() {
        this.statusCode = 400;
        this.p = null;
    }

}
