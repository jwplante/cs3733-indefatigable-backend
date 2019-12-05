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
        assertEquals(resp.statusCode,200);
    }

}