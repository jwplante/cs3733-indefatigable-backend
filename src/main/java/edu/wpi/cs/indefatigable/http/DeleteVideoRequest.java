package edu.wpi.cs.indefatigable.http;

//THANK YOU TO PROFESSOR GEORGE HEINEMAN FOR HIS CALCULATOR IMPLEMENTATION, WHICH WE HAVE ADAPTED FOR OUR PROJECT.
public class DeleteVideoRequest {
	public String vuid;
	
	public void setVuid(String vuid) {this.vuid= vuid; }
	public String getVuid() {return vuid; }
	
	public DeleteVideoRequest (String n) {
		this.vuid = n;
	}

	public DeleteVideoRequest() {
		
	}
	
	public String toString() {
		return "Delete(" + vuid + ")";
	}
}

