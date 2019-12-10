package edu.wpi.cs.indefatigable.http;

public class RegisterVideoRequest {

    public String transcript;
    public String character;
    public String url;
    public String remoteApiID;
    
    // Constructors
    public RegisterVideoRequest() {}
    
    public RegisterVideoRequest(String title, String transcript, String character, String url, boolean isRemote, String remoteApiID) {
        this.transcript = transcript;
        this.character = character;
        this.url = url;
        this.remoteApiID = remoteApiID;
    }

    public String getTranscript() {
        return transcript;
    }

    public String getCharacter() {
        return character;
    }
    
    public String getURL() {
    	return url;
    }
    
    public String getRemoteID() {
    	return remoteApiID;
    }
}
