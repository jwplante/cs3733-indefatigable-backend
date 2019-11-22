package edu.wpi.cs.indefatigable.http;

public class GetPlaylistRequest {
    String id;

    public GetPlaylistRequest(String id) {
        this.id = id;
    }

    public String getID() {return this.id;}

    public String toString() {return this.id;}

}
