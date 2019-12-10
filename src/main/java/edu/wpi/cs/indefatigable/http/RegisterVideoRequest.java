package edu.wpi.cs.indefatigable.http;

public class RegisterVideoRequest {

    public String title;
    public String transcript;
    public String character;
    public boolean isRemote;
    public String remoteApiID;
    
    private static final boolean DEFAULT_IS_REMOTE = false;
    private static final String DEFAULT_REMOTE_API_ID = "";

    // Constructors
    public RegisterVideoRequest() {}
    public RegisterVideoRequest(String title, String transcript, String character) {
        this.title = title;
        this.transcript = transcript;
        this.character = character;
        this.isRemote = DEFAULT_IS_REMOTE;
        this.remoteApiID = DEFAULT_REMOTE_API_ID;
    }
    
    public RegisterVideoRequest(String title, String transcript, String character, boolean isRemote, String remoteApiID) {
        this.title = title;
        this.transcript = transcript;
        this.character = character;
        this.isRemote = isRemote;
        this.remoteApiID = remoteApiID;
    }

    public String getTitle() {
        return title;
    }

    public String getTranscript() {
        return transcript;
    }

    public String getCharacter() {
        return character;
    }
    
    public boolean getIsRemote() {
    	return isRemote;
    }
    
    public String getRemoteID() {
    	return remoteApiID;
    }
}
