package edu.wpi.cs.indefatigable;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import edu.wpi.cs.indefatigable.db.RemoteSitesDAO;
import edu.wpi.cs.indefatigable.http.RegisterRemoteSiteRequest;
import edu.wpi.cs.indefatigable.http.RegisterRemoteSiteResponse;

public class RegisterRemoteSiteHandler implements RequestHandler<RegisterRemoteSiteRequest, RegisterRemoteSiteResponse> {
    public LambdaLogger log = null;

    @Override
    public RegisterRemoteSiteResponse handleRequest(RegisterRemoteSiteRequest input, Context context) {
        log = context.getLogger();
        log.log("Registering Remote Site");
        RemoteSitesDAO rsd = new RemoteSitesDAO();
        try {
            String uid = rsd.addRemoteSite(input.url);
            if (uid != null) {
                return new RegisterRemoteSiteResponse(200, uid);
            } else return new RegisterRemoteSiteResponse(400, "Adding failed", "");
        } catch (Exception e) {
            log.log(e.getMessage());
            return new RegisterRemoteSiteResponse(400, e.getMessage());
        }
    }
}
