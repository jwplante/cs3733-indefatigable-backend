package edu.wpi.cs.indefatigable.http;

public class CreateVideoResponse {
    public final int statusCode;

    // Constructors
    public CreateVideoResponse() {
        this.statusCode = 400;
    }

    public CreateVideoResponse(int statusCode) {
        this.statusCode = statusCode;
    }
}
