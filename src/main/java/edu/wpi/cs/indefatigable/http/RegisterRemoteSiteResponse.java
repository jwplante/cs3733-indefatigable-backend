package edu.wpi.cs.indefatigable.http;

public class RegisterRemoteSiteResponse {
	public int responseCode;
	public String errmsg;
	public String uid;
	public RegisterRemoteSiteResponse() {
		responseCode = 200;
		errmsg = "";
	}
	public RegisterRemoteSiteResponse(int statusCode, String uid) {
		responseCode = statusCode;
		errmsg = "";
		this.uid = uid;
	}
	public RegisterRemoteSiteResponse(int statusCode, String errmsg, String uid) {
		responseCode = statusCode;
		this.errmsg = errmsg;
		this.uid = uid;

	}
}
