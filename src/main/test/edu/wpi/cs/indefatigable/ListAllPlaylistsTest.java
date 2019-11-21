package edu.wpi.cs.indefatigable;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import edu.wpi.cs.indefatigable.http.AllPlaylistsResponse;
import edu.wpi.cs.indefatigable.model.Playlist;

public class ListAllPlaylistsTest extends LambdaTest {
	
    @Test
    public void testGetList() throws IOException {
    	ListAllPlaylistsHandler handler = new ListAllPlaylistsHandler();

        AllPlaylistsResponse resp = handler.handleRequest(null, createContext("list"));
        
        boolean hasTest = false;
        for (Playlist p : resp.playlists) {
        	if (p.getName().equals("First Playlist - so funny")) { hasTest = true; break; }
        }
        assertTrue("Is First Playlist in the db?", hasTest);
        assertEquals(200, resp.statusCode);
    }

}