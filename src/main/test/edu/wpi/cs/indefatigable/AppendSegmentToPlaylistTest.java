package edu.wpi.cs.indefatigable;

import org.junit.Assert;
import org.junit.Test;

import edu.wpi.cs.indefatigable.http.AppendSegmentToPlaylistRequest;
import edu.wpi.cs.indefatigable.http.AppendSegmentToPlaylistResponse;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class AppendSegmentToPlaylistTest extends LambdaTest {

    @Test
    public void testAppendToPlaylist() {
    	
        AppendSegmentToPlaylistRequest req = new AppendSegmentToPlaylistRequest("5459776a-f644-422f-916c-a15a0366d072", "32b7976c-cd4d-4fb3-805c-018053d1bf01");    
        AppendSegmentToPlaylistResponse res = new AppendSegmentToPlaylistHandler().handleRequest(req, createContext("append"));
        Assert.assertEquals(200, res.statusCode);
    }
    
}