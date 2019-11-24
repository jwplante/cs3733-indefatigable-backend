package edu.wpi.cs.indefatigable.http;

public class AppendSegmentToPlaylistRequest {
	public String vuid;
	public String puid;
    public AppendSegmentToPlaylistRequest() {
    	
    }

	public String getVuid() {
		return vuid; 
		}

	public String getPuid() {
		return puid; 
		}
	public AppendSegmentToPlaylistRequest(String vuid, String puid) {
		this.vuid = vuid;
		this.puid = puid;
	}
	
	public String toString() {
		return "Append("+vuid+","+puid+")";
	}
}

