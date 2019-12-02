package edu.wpi.cs.indefatigable;

import java.util.ArrayList;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import edu.wpi.cs.indefatigable.db.VideoDAO;
import edu.wpi.cs.indefatigable.http.SearchVideosRequest;
import edu.wpi.cs.indefatigable.http.SearchVideosResponse;
import edu.wpi.cs.indefatigable.model.Video;

public class SearchVideosHandler implements RequestHandler<SearchVideosRequest, SearchVideosResponse>{

	public SearchVideosHandler() {}

	@Override
	public SearchVideosResponse handleRequest(SearchVideosRequest input, Context context) {
		try {
			VideoDAO dao = new VideoDAO();
			ArrayList<Video> results = dao.queryAllVideos(input.getCharacter(), input.getTranscript());
			return new SearchVideosResponse(200, results);
		} catch (Exception e) {
			e.printStackTrace();
			return new SearchVideosResponse();
		}
	}
}
