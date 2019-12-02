package edu.wpi.cs.indefatigable;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import edu.wpi.cs.indefatigable.db.RemoteSitesDAO;
import edu.wpi.cs.indefatigable.http.DeregisterRemoteSiteResponse;
import edu.wpi.cs.indefatigable.http.DeregisterRemoteSiteRequest;

public class DeregisterRemoteSiteHandler implements RequestHandler<DeregisterRemoteSiteRequest, DeregisterRemoteSiteResponse>{
	public LambdaLogger log = null;
	@Override
	public DeregisterRemoteSiteResponse handleRequest(DeregisterRemoteSiteRequest input, Context context) {
		log = context.getLogger();
		log.log("Deregistering Remote Site");
		RemoteSitesDAO rsd= new RemoteSitesDAO();
		try{
			boolean result = rsd.removeRemoteSite(input.url);
			if(result) {
				return new DeregisterRemoteSiteResponse(200);
			}
			else return new DeregisterRemoteSiteResponse(400,"Removing failed");
		}
		catch(Exception e) {
			log.log(e.getMessage());
			return new DeregisterRemoteSiteResponse(400, e.getMessage());
		}
	}
	
	
}
