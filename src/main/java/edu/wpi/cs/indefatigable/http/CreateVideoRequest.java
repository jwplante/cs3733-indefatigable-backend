package edu.wpi.cs.indefatigable.http;

public class CreateVideoRequest {

    public String title;
    public String transcript;
    public String character;
    public String video;
    public boolean isRemote;
    public String remoteApiID;
    
    private static final boolean DEFAULT_IS_REMOTE = false;
    private static final String DEFAULT_REMOTE_API_ID = "";

    // Constructors
    public CreateVideoRequest() {}
    public CreateVideoRequest(String title, String transcript, String character, String video) {
        this.title = title;
        this.transcript = transcript;
        this.character = character;
        this.video = video;
        this.isRemote = DEFAULT_IS_REMOTE;
        this.remoteApiID = DEFAULT_REMOTE_API_ID;
    }
    
    public CreateVideoRequest(String title, String transcript, String character, String video, boolean isRemote, String remoteID) {
        this.title = title;
        this.transcript = transcript;
        this.character = character;
        this.video = video;
        this.isRemote = isRemote;
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

    public String getVideo() {
        return video;
    }
    
    public boolean getIsRemote() {
    	return isRemote;
    }
    
    public String getRemoteID() {
    	return remoteApiID;
    }
}
