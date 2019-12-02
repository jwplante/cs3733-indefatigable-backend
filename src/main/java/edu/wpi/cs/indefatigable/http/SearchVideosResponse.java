package edu.wpi.cs.indefatigable.http;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.cs.indefatigable.model.Video;

public class SearchVideosResponse {
	
	public int responseCode;
	public List<Video> videos;

	public SearchVideosResponse(int responseCode, List<Video> videos) {
		this.responseCode = responseCode;
		this.videos = videos;
	}
	
	public SearchVideosResponse() {
		this.responseCode = 400;
		this.videos = new ArrayList<Video>();
	}
	
}
