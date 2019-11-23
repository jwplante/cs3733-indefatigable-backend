package edu.wpi.cs.indefatigable.http;

public class DeletePlaylistRequest {
    public String puid;

    public String getPuid(){
        return puid;
    }

    public DeletePlaylistRequest(String puid){
        this.puid = puid;
    }

    public DeletePlaylistRequest(){

    }

    public String toString(){
        return "Delete(" + puid + ")";
    }
}
