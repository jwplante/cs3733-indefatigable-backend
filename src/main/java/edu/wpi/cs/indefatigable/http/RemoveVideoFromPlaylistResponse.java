package edu.wpi.cs.indefatigable.http;

public class RemoveVideoFromPlaylistResponse {
	public final String vuid;
	public final String puid;
	public final int statusCode;
	public final String error;
	
	public RemoveVideoFromPlaylistResponse(String vuid, String puid, int statusCode) {
		this.vuid = vuid;
		this.puid = puid;
		this.statusCode = statusCode;
		this.error = "";
	}
	
	public RemoveVideoFromPlaylistResponse(String vuid, String puid, int statusCode,String errorMessage) {
		this.statusCode = statusCode;
		this.error = errorMessage;
		this.puid = puid;
		this.vuid = vuid;
		
	}
	
	public String toString() {
		if(statusCode / 100 == 2) {
			return "RemoveVideoFromPlaylistResponse(" + vuid + "," + puid + ")";

		} else {
			return "ErrorResult(" + vuid+ "," + puid + ", statusCode=" + statusCode + ", err=" + error + ")";
		}

	}

}
