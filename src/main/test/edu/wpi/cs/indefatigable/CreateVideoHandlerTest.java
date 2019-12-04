package edu.wpi.cs.indefatigable;

import org.junit.Assert;
import org.junit.Test;

import edu.wpi.cs.indefatigable.http.CreateVideoRequest;
import edu.wpi.cs.indefatigable.http.CreateVideoResponse;
import edu.wpi.cs.indefatigable.http.DeleteVideoRequest;
import edu.wpi.cs.indefatigable.http.DeleteVideoResponse;



/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class CreateVideoHandlerTest extends LambdaTest {

    @Test
    public void testCreateVideo() {
    	/*
        CreateVideoResponse res = new CreateVideoHandler().handleRequest(req, createContext("create"));
        Assert.assertEquals(200, res.statusCode); //it was created
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        DeleteVideoRequest req2 = new DeleteVideoRequest(res.vuid);
        DeleteVideoResponse res2 = new DeleteVideoHandler().handleRequest(req2, createContext("delete"));
        Assert.assertEquals(200, res2.statusCode); //it was deleted
    }
    */
}