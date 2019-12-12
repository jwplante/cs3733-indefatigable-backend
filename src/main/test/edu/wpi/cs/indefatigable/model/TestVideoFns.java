package edu.wpi.cs.indefatigable.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import edu.wpi.cs.indefatigable.model.Video;

public class TestVideoFns {
	@Test
	public void testVideoEquality() {
		Video v1 = new Video("https://cs.wpi.edu/~heineman", true, false, "George Heineman", "I hope you'll take software engineering", "God");
		Video v2 = new Video("https://cs.wpi.edu/~heineman", true, false, "George Heineman", "I hope you'll take software engineering", "God");
		Video v3 = new Video("https://cs.wpi.edu/~jwaquilante", true, false, "Justin", "Time to grind out some anime", "God");
		Video v4 = new Video("https://cs.wpi.edu/~jwaquilante", false, true, "Justin", "Time to grind out some anime", "God");
		Video v5 = new Video("https://cs.wpi.edu/~jwaquilante", true, false, "Justin", "Time to grind out some manga", "God");
		v1.vuid = v2.vuid;
		assertEquals(v1,v2);
		assertNotEquals(v1, v3);
		assertNotEquals(v3, v4);
		assertNotEquals(v3, v5);
	}
	
	@Test
	public void testRemoteVideoEquality() {
		RemotelyAvailableVideo rv1 = new RemotelyAvailableVideo("google.com", "SSSSSSSPOCK", "Hello I am the Spock.");
		RemotelyAvailableVideo rv2 = new RemotelyAvailableVideo("google.com", "SSSSSSSPOCK", "Hello I am the Spock.");
		RemotelyAvailableVideo rv3 = new RemotelyAvailableVideo("yahoo.com", "SSSSSSSPOCK", "Hello I am the Spock.");
		RemotelyAvailableVideo rv4 = new RemotelyAvailableVideo("google.com", "SSSSSSSPOC", "Hello I am the Spock.");
		RemotelyAvailableVideo rv5 = new RemotelyAvailableVideo("google.com", "SSSSSSSPOCK", "Hello I am the Spocc.");
		assertEquals(rv2, rv1);
		assertNotEquals(rv3, rv1);
		assertNotEquals(rv4, rv1);
		assertNotEquals(rv5, rv1);
	}
}
