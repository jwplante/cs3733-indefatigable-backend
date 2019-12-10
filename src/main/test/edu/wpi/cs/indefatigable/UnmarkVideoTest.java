package edu.wpi.cs.indefatigable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.wpi.cs.indefatigable.http.UnmarkVideoRequest;
import edu.wpi.cs.indefatigable.http.UnmarkVideoResponse;



/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class UnmarkVideoTest extends LambdaTest {

    @Test
    public void testUnmarkVideoRA() {
        //1affc384-cb8b-4682-b3da-c22be13617ee - IT IS illogical
    	UnmarkVideoRequest req = new UnmarkVideoRequest("1affc384-cb8b-4682-b3da-c22be13617ee");
    	UnmarkVideoResponse res = new UnmarkVideoHandler().handleRequest(req, createContext("unmark"));
    	assertEquals(res.statusCode, 200);
    	System.out.println(res.toString());
    	//uhoh time
    	UnmarkVideoRequest req2 = new UnmarkVideoRequest("hehe haha hoohoo");
    	UnmarkVideoResponse res2 = new UnmarkVideoHandler().handleRequest(req2, createContext("unmark"));
    	assertEquals(res2.statusCode, 422); 
    	System.out.println(res2.toString());
    }
}