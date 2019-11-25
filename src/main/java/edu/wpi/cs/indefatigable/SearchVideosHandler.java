package edu.wpi.cs.indefatigable;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import edu.wpi.cs.indefatigable.http.SearchVideosRequest;
import edu.wpi.cs.indefatigable.http.SearchVideosResponse;

public class SearchVideosHandler implements RequestHandler<SearchVideosRequest, SearchVideosResponse>{
	
	public SearchVideosHandler() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public SearchVideosResponse handleRequest(SearchVideosRequest input, Context context) {
		
	}
	
}
