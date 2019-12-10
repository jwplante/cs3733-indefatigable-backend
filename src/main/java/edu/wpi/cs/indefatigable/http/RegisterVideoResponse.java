package edu.wpi.cs.indefatigable.http;

public class RegisterVideoResponse {

    public final int statusCode;
    public final String error;


    // Constructors
    public RegisterVideoResponse() {
        this.statusCode = 400;
        this.error = "";
    }

    public RegisterVideoResponse(int statusCode) {
        this.statusCode = statusCode;
        this.error = "";
    }
    
    public RegisterVideoResponse(int statusCode, String err) {
        this.statusCode = statusCode;
        this.error = err;
    }
}
