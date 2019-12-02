package edu.wpi.cs.indefatigable.http;

public class RegisterRemoteSiteRequest {
	public String url;
	public RegisterRemoteSiteRequest(String url) {
		this.url = url;
	}
	public RegisterRemoteSiteRequest() {
		this.url = "http://cs.wpi.edu/~heineman";
	}
	@Override
	public String toString() {
		return "Register site "+url;
	}
}
