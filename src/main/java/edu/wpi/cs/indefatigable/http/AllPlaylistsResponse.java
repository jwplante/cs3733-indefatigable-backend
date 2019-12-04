package edu.wpi.cs.indefatigable.http;

import java.util.ArrayList;

import edu.wpi.cs.indefatigable.model.Playlist;

public class AllPlaylistsResponse {
	public final ArrayList<Playlist> playlists;
	public final int statusCode;
	public final String error;
	
	
	/**
	 * Good 
	 * @param playlists ArrayList of playlists to add
	 * @param statusCode HTTP Status code. 200 if good
	 */
	public AllPlaylistsResponse(ArrayList<Playlist> playlists, int statusCode){
		this.playlists = playlists;
		this.statusCode = statusCode;
		this.error = "";
	}
	
	/**
	 * Bad
	 * @param statusCode HTTP Status code. 400 if bad
	 * @param error Error message
	 */
	public AllPlaylistsResponse(int statusCode, String error){
		this.playlists = new ArrayList<Playlist>();
		this.statusCode = statusCode;
		this.error = error;
	}
	
	public String toString() {
		if (playlists == null) { return "No playlists"; }
		return "AllPlaylists(" + playlists.size() + ")";
	}
	
}
