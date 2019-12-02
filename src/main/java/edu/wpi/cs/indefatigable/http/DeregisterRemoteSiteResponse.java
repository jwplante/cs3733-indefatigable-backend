package edu.wpi.cs.indefatigable.http;

public class DeregisterRemoteSiteResponse {
	public int responseCode;
	public String errmsg;
	public DeregisterRemoteSiteResponse() {
		responseCode = 200;
		errmsg = "";
	}
	public DeregisterRemoteSiteResponse(int statusCode) {
		responseCode = statusCode;
		errmsg = "";
	}
	public DeregisterRemoteSiteResponse(int statusCode, String errmsg) {
		responseCode = statusCode;
		this.errmsg = errmsg;
		
	}
}
