package edu.wpi.cs.indefatigable.http;

import edu.wpi.cs.indefatigable.model.RemotelyAvailableVideo;
import java.util.ArrayList;
import java.util.List;

public class AllRemotelyAvailableVideosResponse {
    public final List<RemotelyAvailableVideo> segments;
    public final int statusCode;
    public final String error;

    public AllRemotelyAvailableVideosResponse(ArrayList<RemotelyAvailableVideo> videos, int code) {
        this.segments = videos;
        this.statusCode = code;
        this.error = "";
    }

    public AllRemotelyAvailableVideosResponse(int code, String errormessage) {
        this.segments = new ArrayList<RemotelyAvailableVideo>();
        this.statusCode = code;
        this.error = errormessage;
    }

    public String toString() {
        if (segments == null) {
            return "EmptyVideos";
        }
        return "AllVideos(" + segments.size() + ")";
    }
}
