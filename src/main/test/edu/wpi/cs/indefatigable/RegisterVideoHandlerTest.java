package edu.wpi.cs.indefatigable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;
import edu.wpi.cs.indefatigable.TestContext;
import edu.wpi.cs.indefatigable.db.VideoDAO;
import edu.wpi.cs.indefatigable.http.RegisterVideoRequest;
import edu.wpi.cs.indefatigable.http.RegisterVideoResponse;
import edu.wpi.cs.indefatigable.model.Video;

public class RegisterVideoHandlerTest {
	
	@Test
	public void addVidToDatabase() throws Exception {
		VideoDAO vdao = new VideoDAO();
		RegisterVideoRequest req = new RegisterVideoRequest("foo-test", "bar-test", "baz-test", "foobar-test", false, "ac74b07f-1b17-4a11-9669-6aa3725629e4");
		RegisterVideoHandler handler = new RegisterVideoHandler();
		RegisterVideoResponse response = handler.handleRequest(req, new TestContext());
		
		ArrayList<Video> videos = vdao.queryAllVideos(req.getCharacter(), req.getTranscript());
		vdao.deleteVideo(videos.get(0).vuid);
		
		assertEquals(response.statusCode, 200);
	}
}
