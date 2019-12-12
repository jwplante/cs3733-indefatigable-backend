package edu.wpi.cs.indefatigable.model;

import java.util.Objects;

public class RemotelyAvailableVideo {
    public final String url;
    public final String character;
    public final String text;

    public RemotelyAvailableVideo(String url,String character, String text) {
        this.url = url;
        this.character = character;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RemotelyAvailableVideo)) return false;
        RemotelyAvailableVideo video = (RemotelyAvailableVideo) o;
        return  Objects.equals(url, video.url) &&
                Objects.equals(character, video.character) &&
                Objects.equals(text, video.text);
    }
}
