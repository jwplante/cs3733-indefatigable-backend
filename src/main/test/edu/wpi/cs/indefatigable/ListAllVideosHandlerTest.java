package edu.wpi.cs.indefatigable;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import edu.wpi.cs.indefatigable.TestContext;
import edu.wpi.cs.indefatigable.http.AllVideosResponse;

public class ListAllVideosHandlerTest {
	
	@Test
	public void getAllVideos() {
		boolean retVal = false;
		ListAllVideosHandler handler = new ListAllVideosHandler();
		AllVideosResponse vid = handler.handleRequest(new Object(), new TestContext());
		if (vid.list.size() >= 1) {	
			retVal = true;
		}
		assertTrue(retVal);
	}
}
