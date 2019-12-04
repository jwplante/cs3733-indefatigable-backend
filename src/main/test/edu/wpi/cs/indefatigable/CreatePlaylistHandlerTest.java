package edu.wpi.cs.indefatigable;

import org.junit.Assert;
import org.junit.Test;

import edu.wpi.cs.indefatigable.http.CreatePlaylistRequest;
import edu.wpi.cs.indefatigable.http.CreatePlaylistResponse;
import edu.wpi.cs.indefatigable.http.DeletePlaylistRequest;
import edu.wpi.cs.indefatigable.http.DeletePlaylistResponse;



/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class CreatePlaylistHandlerTest extends LambdaTest {

    @Test
    public void testCreatePlaylist() {
    	
        CreatePlaylistRequest req = new CreatePlaylistRequest("JUnit");    
        CreatePlaylistResponse res = new CreatePlaylistHandler().handleRequest(req, createContext("create"));
        Assert.assertEquals(200, res.statusCode); //it was created
        
        DeletePlaylistRequest req2 = new DeletePlaylistRequest(res.puid);
        DeletePlaylistResponse res2 = new DeletePlaylistHandler().handleRequest(req2, createContext("delete"));
        Assert.assertEquals(200, res2.statusCode); //it was deleted
    }
    
}