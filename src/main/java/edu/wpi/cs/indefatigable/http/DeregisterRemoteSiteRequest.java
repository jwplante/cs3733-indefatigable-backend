package edu.wpi.cs.indefatigable.http;

public class DeregisterRemoteSiteRequest {
	public String url;
	public DeregisterRemoteSiteRequest(String url) {
		this.url = url;
	}
	public DeregisterRemoteSiteRequest() {
		this.url= null;
	}
	@Override
	public String toString() {
		return "Deregister site "+url;
	}
}
