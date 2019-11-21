package edu.wpi.cs.indefatigable.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;

public class Playlist {
	String puid;
	String name;
	ArrayList<Video> videos;
	
	// Constructors
	public Playlist(String puid, String name, ArrayList<Video> videos) {
		this.puid = puid;
		this.name = name;
		this.videos = videos;
	}

	public Playlist(String puid, String name) {
		this.videos = new ArrayList<Video>();
		this.name = name;
		this.puid = puid;
	}

	public Playlist(String name) {
		this.videos = new ArrayList<Video>();
		this.name = name;
		this.puid = UUID.randomUUID().toString();
	}
	
	/***
	 * Get an iterator containing all videos in the Playlist
	 * @return (Iterator<Video>) An iterator containing all videos in the Playlist
	 */
	public Iterator<Video> getAllVideos() {	
		return this.videos.iterator();
	}
	
	/***
	 * Add video to the Playlist
	 * @param  v - Video to be added
	 * @return (boolean) true if added, false if not
	 */
	public boolean addVideo(Video v) {
		return this.videos.add(v);
	}
	
	/***
	 * Remove video from the Playlist
	 * @param v - Video to be removed
	 * @return (boolean) true if removed, false if not
	 */
	public boolean removeVideo(Video v) {
		return this.videos.remove(v);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.puid, this.videos);
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Playlist)) { return false; }
		else {
			Playlist p = (Playlist) o;
			return (p.puid.equals(this.puid)) &&
					(p.videos.equals(this.videos) &&
					(p.name.equals(this.name)));
		}
	}
}
