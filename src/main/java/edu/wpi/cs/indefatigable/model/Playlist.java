package edu.wpi.cs.indefatigable.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;

public class Playlist {
	String uid;
	String name;
	ArrayList<Video> videos;
	
	// Constructors
	public Playlist(String uid, String name, ArrayList<Video> videos) {
		this.uid = uid;
		this.name = name;
		this.videos = videos;
	}

	public Playlist(String uid, String name) {
		this.videos = new ArrayList<Video>();
		this.name = name;
		this.uid = uid;
	}

	public Playlist(String name) {
		this.videos = new ArrayList<Video>();
		this.name = name;
		this.uid = UUID.randomUUID().toString();
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
		return Objects.hash(this.uid, this.videos);
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Playlist)) { return false; }
		else {
			Playlist p = (Playlist) o;
			return (p.uid.equals(this.uid)) &&
					(p.videos.equals(this.videos) &&
					(p.name.equals(this.name)));
		}
	}
	
	public String getName() {
		return this.name;
	}
}
