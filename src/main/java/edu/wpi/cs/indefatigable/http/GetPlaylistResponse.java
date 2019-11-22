package edu.wpi.cs.indefatigable.http;


import java.util.ArrayList;
import java.util.List;

import edu.wpi.cs.indefatigable.model.Playlist;
import edu.wpi.cs.indefatigable.model.Video;

public class GetPlaylistResponse {
    public final int statusCode;
    public final String id;
    public final String name;
    public final List<Video> videos;

    public GetPlaylistResponse(Playlist p) {
        this.statusCode = 200;
        this.videos = p.getVideos();
        this.name = p.getName();
        this.id = p.getID();
    }

    public GetPlaylistResponse() {
        this.statusCode = 400;
        this.name = "";
        this.videos = new ArrayList<Video>();
        this.id = "";
    }

}
