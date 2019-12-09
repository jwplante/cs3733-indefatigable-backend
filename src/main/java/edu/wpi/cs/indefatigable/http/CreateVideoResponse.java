package edu.wpi.cs.indefatigable.http;

public class CreateVideoResponse {
    public final int statusCode;
	public String vuid;

    public final String error;


    // Constructors
    public CreateVideoResponse() {
        this.statusCode = 400;
        this.vuid = "";
        this.error = "";
    }

    public CreateVideoResponse(int statusCode, String vuid) {
        this.statusCode = statusCode;
        this.vuid = vuid;
        this.error = "";
    }
}
