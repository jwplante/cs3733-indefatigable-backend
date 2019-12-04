package edu.wpi.cs.indefatigable;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import edu.wpi.cs.indefatigable.http.AllRemotelyAvailableVideosResponse;

public class ListAllRAVideoTest extends LambdaTest {
	
    @Test
    public void testGetList() throws IOException {
    	ListAllRemotelyAvailableVideosHandler handler = new ListAllRemotelyAvailableVideosHandler();

        AllRemotelyAvailableVideosResponse resp = handler.handleRequest(null, createContext("list"));
        
        boolean hasTest = false;
        
        if (resp.segments.size()==1 && resp.segments.get(0).getText().equals("It is illogical. *ZAP*")) { hasTest = true;}
        assertTrue("Is \"It is illogical. *ZAP*?\" the only video in the list?", hasTest);
        assertEquals(200, resp.statusCode);
    }

}