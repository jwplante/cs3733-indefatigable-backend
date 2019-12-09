package edu.wpi.cs.indefatigable.http;

public class RemoveVideoFromPlaylistRequest {
	public String vuid;
	public String puid;
	
	public void setVuid(String vuid) {this.vuid = vuid; }
	public String getVuid() { return vuid;}
	public void setPuid(String puid) {this.puid = puid; }
	public String getPuid() { return puid;}
	
	public RemoveVideoFromPlaylistRequest (String vuid, String puid) {
		this.vuid = vuid;
		this.puid = puid;
	}
	
	public RemoveVideoFromPlaylistRequest() {
		
	}
	
	public String toString() {
		return "Delete("+vuid+") from (" + puid + ")";
	}

}
