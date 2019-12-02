package edu.wpi.cs.indefatigable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.wpi.cs.indefatigable.http.DeregisterRemoteSiteRequest;
import edu.wpi.cs.indefatigable.http.DeregisterRemoteSiteResponse;
import edu.wpi.cs.indefatigable.http.RegisterRemoteSiteRequest;
import edu.wpi.cs.indefatigable.http.RegisterRemoteSiteResponse;

public class RemoteSiteHandlerTest extends LambdaTest {

    @Test
    public void testRegisterAndDeregisterSite() {
    	
    	RegisterRemoteSiteRequest req = new RegisterRemoteSiteRequest("http://cs.wpi.edu/~heineman"); //  heineman's homepage
    	
    	RegisterRemoteSiteResponse res = new RegisterRemoteSiteHandler().handleRequest(req, new TestContext());
        assertEquals(200, res.responseCode);
        
        DeregisterRemoteSiteRequest req2 = new DeregisterRemoteSiteRequest("http://cs.wpi.edu/~heineman");
        DeregisterRemoteSiteResponse res2 = new DeregisterRemoteSiteHandler().handleRequest(req2, new TestContext());
        assertEquals(200, res2.responseCode);
    }
    
}
