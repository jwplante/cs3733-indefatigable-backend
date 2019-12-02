package edu.wpi.cs.indefatigable.http;

public class CreateVideoRequest {

    public String title;
    public String transcript;
    public String character;
    public String video;

    // Constructors
    public CreateVideoRequest() {}
    public CreateVideoRequest(String title, String transcript, String character, String video) {
        this.title = title;
        this.transcript = transcript;
        this.character = character;
        this.video = video;
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
}
