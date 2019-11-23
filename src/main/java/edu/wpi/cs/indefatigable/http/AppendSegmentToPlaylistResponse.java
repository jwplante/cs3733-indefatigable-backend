package edu.wpi.cs.indefatigable.http;

public class AppendSegmentToPlaylistResponse {
    public final int statusCode;
    public final String error;

    public AppendSegmentToPlaylistResponse(int code) {
        this.statusCode = code;
        this.error = "";
    }

    public AppendSegmentToPlaylistResponse(int code, String errormessage) {
        this.statusCode = code;
        this.error = errormessage;
    }

    public String toString() {
        return "AppendSegmentToPlaylistResponse(" + statusCode + ")";
    }
}
