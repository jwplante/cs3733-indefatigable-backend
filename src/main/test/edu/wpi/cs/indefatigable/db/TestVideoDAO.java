package edu.wpi.cs.indefatigable.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.Test;

import edu.wpi.cs.indefatigable.model.Video;

public class TestVideoDAO {

	@Test
	public void VideoDAOTest() {
		VideoDAO vdao = new VideoDAO();
		boolean fail = false;
		try {
			vdao.getAllVideos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail = true;
		}
		assertFalse(fail);
		
		fail = false;
		try {
			ArrayList<Video> justin = vdao.queryAllVideos("Justin", "");
			assertEquals(justin.size(),1); // only one video with me as a character
			justin = vdao.queryAllVideos("", "Justin");
			assertEquals(justin.size(),2); // only two videos with me mentioned
			justin = vdao.queryAllVideos("Justin", "not Justin");
			assertEquals(justin.size(),0); //there is no video with me saying not Justin
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail=true;
		}
		assertFalse(fail);
		
	}
}
