package edu.wpi.cs.indefatigable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.wpi.cs.indefatigable.http.MarkVideoRequest;
import edu.wpi.cs.indefatigable.http.MarkVideoResponse;



/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class MarkVideoTest extends LambdaTest {

    @Test
    public void testMarkVideoRA() {
        //1affc384-cb8b-4682-b3da-c22be13617ee - IT IS illogical
    	MarkVideoRequest req = new MarkVideoRequest("1affc384-cb8b-4682-b3da-c22be13617ee");
    	MarkVideoResponse res = new MarkVideoHandler().handleRequest(req, createContext("mark"));
    	assertEquals(res.statusCode, 200);
    }
}