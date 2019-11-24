package edu.wpi.cs.indefatigable.http;

public class DeletePlaylistResponse {
    public final String puid;
    public final int statusCode;
    public final String error;

    public DeletePlaylistResponse(String puid, int statusCode){
        this.puid = puid;
        this.statusCode = statusCode;
        this.error="";
    }

    public DeletePlaylistResponse(String puid, int statusCode, String errorMessage){
        this.statusCode = statusCode;
        this.error = errorMessage;
        this.puid = puid;
    }

    public String toString(){
        if(statusCode == 200){
            return "DeleteResponse(" + puid + ")";
        }else{
            return "ErrorResult(" + puid + ", statusCode=" + statusCode + ", err=" + error + ")";
        }
    }
}
