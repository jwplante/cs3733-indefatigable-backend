package edu.wpi.cs.indefatigable;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import edu.wpi.cs.indefatigable.http.SearchVideosRequest;
import edu.wpi.cs.indefatigable.http.SearchVideosResponse;

public class SearchVideosHandlerTest extends LambdaTest {
	SearchVideosHandler obj;

	@Before
	public void setUp() {
		obj = new SearchVideosHandler();
	}

	@Test
	public void testSearchWithTranscript() {
		SearchVideosRequest req = new SearchVideosRequest("Jim", "");
		SearchVideosResponse res = obj.handleRequest(req, createContext("search"));
		Assert.assertEquals(res.responseCode, 200);
	}
	
	@Test()
	public void testSearchWithError() {
		SearchVideosRequest req = new SearchVideosRequest("Jim", null);
		SearchVideosResponse res = obj.handleRequest(req, createContext("search"));
		Assert.assertEquals(res.responseCode, 400);
	}

}