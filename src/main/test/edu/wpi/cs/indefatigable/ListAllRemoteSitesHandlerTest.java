package edu.wpi.cs.indefatigable;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import edu.wpi.cs.indefatigable.http.AllRemoteSitesResponse;


public class ListAllRemoteSitesHandlerTest extends LambdaTest {
	
    @Test
    public void testGetList() throws IOException {
    	ListAllRemoteSites handler = new ListAllRemoteSites();

        AllRemoteSitesResponse resp = handler.handleRequest(null, createContext("list"));
        
        assertEquals(resp.statusCode,200);
    }

}