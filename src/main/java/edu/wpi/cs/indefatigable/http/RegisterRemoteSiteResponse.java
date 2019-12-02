package edu.wpi.cs.indefatigable.http;

public class RegisterRemoteSiteResponse {
	public int responseCode;
	public String errmsg;
	public RegisterRemoteSiteResponse() {
		responseCode = 200;
		errmsg = "";
	}
	public RegisterRemoteSiteResponse(int statusCode) {
		responseCode = statusCode;
		errmsg = "";
	}
	public RegisterRemoteSiteResponse(int statusCode, String errmsg) {
		responseCode = statusCode;
		this.errmsg = errmsg;
		
	}
}
