package edu.wpi.cs.indefatigable.http;

public class CreatePlaylistResponse {
    public final int statusCode;
    public final String error;
    public final String puid;

    public CreatePlaylistResponse(int code, String puid){
        this.statusCode = code;
        this.puid = puid;
        this.error="";
    }

    public CreatePlaylistResponse(int code, String errormessage, String puid){
        this.statusCode = code;
        this.puid = puid;
        this.error = errormessage;
    }
}
