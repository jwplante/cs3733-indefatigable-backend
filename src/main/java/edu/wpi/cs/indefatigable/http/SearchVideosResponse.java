package edu.wpi.cs.indefatigable.http;

public class SearchVideosResponse {
	
	public int reponseCode;
	
	// Cosntructors
	public SearchVideosResponse() {
		this.reponseCode = 400;
	}
	
	public SearchVideosResponse(int responseCode) {
		this.reponseCode = responseCode;
	}
	
}
