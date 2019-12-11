package edu.wpi.cs.indefatigable.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.Test;

import edu.wpi.cs.indefatigable.model.Playlist;

public class PlaylistModelTest {
	
	@Test
	public void constructorTests() {
		// Should have different UIDs
		Playlist p1 = new Playlist("Justin");
		Playlist p2 = new Playlist("Justin");
		assertFalse(p1.equals(p2));
		
		// Should have the same uid;
		Playlist p5 = new Playlist("foo", "bar", new ArrayList<Video>());
		Playlist p6 = new Playlist("foo", "bar", new ArrayList<Video>());
		assertEquals(p5, p6);
		
		// Should have the same uid;
		Playlist p3 = new Playlist("foo", "bar", new ArrayList<Video>());
		Playlist p4 = new Playlist("foo", "bar", new ArrayList<Video>());
		assertEquals(p3, p4);
			
	}
	
}
