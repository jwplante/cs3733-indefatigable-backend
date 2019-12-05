package edu.wpi.cs.indefatigable.http;

public class CreateVideoResponse {
    public final int statusCode;

    public final String error;


    // Constructors
    public CreateVideoResponse() {
        this.statusCode = 400;
        this.error = "";
    }

    public CreateVideoResponse(int statusCode) {
        this.statusCode = statusCode;
        this.error = "";
    }
    
    public CreateVideoResponse(int statusCode, String err) {
        this.statusCode = statusCode;
        this.error = err;
    }
}
