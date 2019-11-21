package edu.wpi.cs.indefatigable.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class Playlist {
	String puid;
	ArrayList<Video> videos;
	
	// Constructors
	Playlist(String puid, ArrayList<Video> videos) {
		this.puid = puid;
		this.videos = videos;
	}
	
	Playlist() {
		this.videos = new ArrayList<Video>();
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
	 * @param (Video) v - Video to be added
	 * @return (boolean) true if added, false if not
	 */
	public boolean addVideo(Video v) {
		return true;
	}
	
	/***
	 * Remvoe video from the Playlist
	 * @param (Video) v - Video to be removed
	 * @return (boolean) true if removed, false if not
	 */
	public boolean removeVideo(Video v) {
		return true;
	}
	
}
