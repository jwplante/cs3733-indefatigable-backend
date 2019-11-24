package edu.wpi.cs.indefatigable;

import org.junit.Assert;
import org.junit.Test;

import edu.wpi.cs.indefatigable.http.DeleteVideoRequest;
import edu.wpi.cs.indefatigable.http.DeleteVideoResponse;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class DeleteSegmentHandlerTest extends LambdaTest {

    @Test
    public void testCreateAndDeleteVideo() {
        // now delete
        DeleteVideoRequest dvr = new DeleteVideoRequest("uhoh");
        DeleteVideoResponse d_resp = new DeleteVideoHandler().handleRequest(dvr, createContext("delete"));
        Assert.assertEquals("uhoh", d_resp.vuid);
        
        // try again and this should fail
        d_resp = new DeleteVideoHandler().handleRequest(dvr, createContext("delete"));
        Assert.assertEquals(422, d_resp.statusCode);
    }
    
}