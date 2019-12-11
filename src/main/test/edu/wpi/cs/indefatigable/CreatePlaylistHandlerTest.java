package edu.wpi.cs.indefatigable;

import org.junit.Assert;
import org.junit.Test;

import edu.wpi.cs.indefatigable.http.CreatePlaylistRequest;
import edu.wpi.cs.indefatigable.http.CreatePlaylistResponse;
import edu.wpi.cs.indefatigable.http.DeletePlaylistRequest;
import edu.wpi.cs.indefatigable.http.DeletePlaylistResponse;



/**
 * A simple test harness for locally invoking your Lambda function handler.
 * Tests both creating and destroying lol
 */
public class CreatePlaylistHandlerTest extends LambdaTest {

    @Test
    public void testCreatePlaylist() {
        CreatePlaylistRequest req = new CreatePlaylistRequest("JUnit");    
        req.toString();
        CreatePlaylistResponse res = new CreatePlaylistHandler().handleRequest(req, createContext("create"));
        Assert.assertEquals(200, res.statusCode); //it was created
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        DeletePlaylistRequest req2 = new DeletePlaylistRequest(res.puid);
        DeletePlaylistResponse res2 = new DeletePlaylistHandler().handleRequest(req2, createContext("delete"));
        Assert.assertEquals(200, res2.statusCode); //it was deleted
        System.out.println(res2.toString());
        DeletePlaylistRequest req3 = new DeletePlaylistRequest(res.puid);
        DeletePlaylistResponse res3 = new DeletePlaylistHandler().handleRequest(req3, createContext("delete"));
        Assert.assertEquals(422, res3.statusCode); //should fail
        System.out.println(res3.toString());
    }

    @Test
    public void testCreateNullPlaylist(){
        CreatePlaylistRequest req = new CreatePlaylistRequest(null);
        CreatePlaylistResponse res = new CreatePlaylistHandler().handleRequest(req, createContext("create"));
        Assert.assertEquals(200, res.statusCode);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DeletePlaylistRequest req2 = new DeletePlaylistRequest(res.puid);
        DeletePlaylistResponse res2 = new DeletePlaylistHandler().handleRequest(req2, createContext("delete"));
        Assert.assertEquals(200, res2.statusCode);
    }
    
}