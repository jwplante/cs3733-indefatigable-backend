package edu.wpi.cs.indefatigable.model;

import java.util.Objects;

public class Video {
    public final String vuid;
    public final String url;
    public final boolean remoteAvailability;
    public final boolean isRemote;
    public final String character;
    public final String transcript;
    public final String title;

    public Video(String vuid, String url, boolean remoteAvailability, boolean isRemote, String character, String transcript, String title) {
        this.vuid = vuid;
        this.url = url;
        this.remoteAvailability = remoteAvailability;
        this.isRemote = isRemote;
        this.character = character;
        this.transcript = transcript;
        this.title = title;
    }

    public String getVuid() {
        return vuid;
    }

    public String getUrl() {
        return url;
    }

    public boolean isRemoteAvailability() {
        return remoteAvailability;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public String getCharacter() {
        return character;
    }

    public String getTranscript() {
        return transcript;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Video)) return false;
        Video video = (Video) o;
        return remoteAvailability == video.remoteAvailability &&
                isRemote == video.isRemote &&
                vuid.equals(video.vuid) &&
                Objects.equals(url, video.url) &&
                Objects.equals(character, video.character) &&
                Objects.equals(transcript, video.transcript) &&
                Objects.equals(title, video.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vuid, url, remoteAvailability, isRemote, character, transcript, title);
    }
}
