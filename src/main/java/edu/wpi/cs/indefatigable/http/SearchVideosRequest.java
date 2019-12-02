package edu.wpi.cs.indefatigable.http;

public class SearchVideosRequest {
	
	public String transcript;
	public String character;
	
	// Constructors

	public SearchVideosRequest() {
	}

	public SearchVideosRequest(String transcript, String character) {
		this.transcript = transcript;
		this.character = character;
	}

	public String getTranscript() {
		return transcript;
	}

	public String getCharacter() {
		return character;
	}
	
}
