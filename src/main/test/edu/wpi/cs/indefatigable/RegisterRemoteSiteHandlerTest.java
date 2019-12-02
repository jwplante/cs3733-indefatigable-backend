package edu.wpi.cs.indefatigable;

import org.junit.Assert;
import org.junit.Test;

import edu.wpi.cs.indefatigable.http.RegisterRemoteSiteRequest;
import edu.wpi.cs.indefatigable.http.RegisterRemoteSiteResponse;

public class RegisterRemoteSiteHandlerTest extends LambdaTest {

    @Test
    public void testRegisterSite() {
    	
    	RegisterRemoteSiteRequest req = new RegisterRemoteSiteRequest(); // default: heineman's homepage
    	
    	RegisterRemoteSiteResponse res = new RegisterRemoteSiteHandler().handleRequest(req, new TestContext());
        Assert.assertEquals(200, res.responseCode);
    }
    
}
