package edu.wpi.cs.indefatigable.http;

public class CreatePlaylistResponse {
    public final int statusCode;
    public final String error;

    public CreatePlaylistResponse(int code){
        this.statusCode = code;
        this.error="";
    }

    public CreatePlaylistResponse(int code, String errormessage){
        this.statusCode = code;
        this.error = errormessage;
    }
}
