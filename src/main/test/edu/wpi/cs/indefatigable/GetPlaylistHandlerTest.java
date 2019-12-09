package edu.wpi.cs.indefatigable;

import org.junit.Assert;
import org.junit.Test;

import edu.wpi.cs.indefatigable.http.GetPlaylistRequest;
import edu.wpi.cs.indefatigable.http.GetPlaylistResponse;



/**
 * A simple test harness for locally invoking your Lambda function handler.
 * Tests both creating and destroying lol
 */
public class GetPlaylistHandlerTest extends LambdaTest {

    @Test
    public void testGetPlaylist() {
    	
        GetPlaylistRequest req = new GetPlaylistRequest("fe2d9e10-1ecf-443c-be0d-1e1b826237a1");    
        GetPlaylistResponse res = new GetPlaylistHandler().handleRequest(req, createContext("create"));
        Assert.assertEquals(200, res.statusCode); //it was found
    }
    
}