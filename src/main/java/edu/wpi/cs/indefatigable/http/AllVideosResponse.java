package edu.wpi.cs.indefatigable.http;

import edu.wpi.cs.indefatigable.model.Video;

import java.util.ArrayList;
import java.util.List;

public class AllVideosResponse {
    public final List<Video> list;
    public final int statusCode;
    public final String error;

    public AllVideosResponse(List<Video> list, int code) {
        this.list = list;
        this.statusCode = code;
        this.error = "";
    }

    public AllVideosResponse(int code, String errormessage) {
        this.list = new ArrayList<Video>();
        this.statusCode = code;
        this.error = errormessage;
    }

}
