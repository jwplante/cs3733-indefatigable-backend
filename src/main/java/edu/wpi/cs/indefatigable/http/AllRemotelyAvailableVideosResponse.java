package edu.wpi.cs.indefatigable.http;

import edu.wpi.cs.indefatigable.model.RemotelyAvailableVideo;
import edu.wpi.cs.indefatigable.model.Video;

import java.util.ArrayList;
import java.util.List;

public class AllRemotelyAvailableVideosResponse {
    public final List<RemotelyAvailableVideo> list;
    public final int statusCode;
    public final String error;

    public AllRemotelyAvailableVideosResponse(ArrayList<RemotelyAvailableVideo> videos, int code) {
        this.list = videos;
        this.statusCode = code;
        this.error = "";
    }

    public AllRemotelyAvailableVideosResponse(int code, String errormessage) {
        this.list = new ArrayList<RemotelyAvailableVideo>();
        this.statusCode = code;
        this.error = errormessage;
    }

    public String toString() {
        if (list == null) {
            return "EmptyVideos";
        }
        return "AllVideos(" + list.size() + ")";
    }
}
