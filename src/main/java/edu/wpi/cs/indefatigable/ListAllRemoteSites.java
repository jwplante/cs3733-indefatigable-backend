package edu.wpi.cs.indefatigable;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.wpi.cs.indefatigable.db.RemoteSitesDAO;
import edu.wpi.cs.indefatigable.http.AllRemoteSitesResponse;

import java.util.ArrayList;

public class ListAllRemoteSites implements RequestHandler<Object, AllRemoteSitesResponse> {

    public LambdaLogger logger;
    ArrayList<String> getRemoteSites() throws Exception{
        logger.log("in get RemoteSites");
        RemoteSitesDAO dao = new RemoteSitesDAO();
        return dao.getRemoteSites();
    }

    @Override
    public AllRemoteSitesResponse handleRequest(Object input, Context context) {
        logger = context.getLogger();
        logger.log("In handle request for all remote sites");
        AllRemoteSitesResponse response;
        try{
            ArrayList<String> urls = getRemoteSites();
            response = new AllRemoteSitesResponse(urls, 200);
        } catch (Exception e) {
            logger.log(e.toString());
            response = new AllRemoteSitesResponse(403, e.getMessage());
        }
        return response;
    }
}
