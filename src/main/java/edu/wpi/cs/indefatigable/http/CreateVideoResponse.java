package edu.wpi.cs.indefatigable.http;

public class CreateVideoResponse {
    public final int statusCode;
	public String vuid;

    // Constructors
    public CreateVideoResponse() {
        this.statusCode = 400;
        this.vuid = "";
    }

    public CreateVideoResponse(int statusCode, String vuid) {
        this.statusCode = statusCode;
        this.vuid = vuid;
    }
}
