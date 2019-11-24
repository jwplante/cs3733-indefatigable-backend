package edu.wpi.cs.indefatigable.http;

/**
 * Sends back the name of the video deleted -- easier to handle on client-side.
 */
// THANK YOU TO PROFESSOR GEORGE HEINEMAN FOR HIS CALCULATOR IMPLEMENTATION, WHICH WE HAVE ADAPTED FOR OUR PROJECT.
public class DeleteVideoResponse {
    public final String vuid;
    public final int statusCode;
    public final String error;

    public DeleteVideoResponse(String vuid, int statusCode) {
        this.vuid = vuid;
        this.statusCode = statusCode;
        this.error = "";
    }

    // 200 means success
    public DeleteVideoResponse(String vuid, int statusCode, String errorMessage) {
        this.statusCode = statusCode;
        this.error = errorMessage;
        this.vuid = vuid;
    }

    public String toString() {
        if (statusCode / 100 == 2) {  // too cute?
            return "DeleteResponse(" + vuid + ")";
        } else {
            return "ErrorResult(" + vuid + ", statusCode=" + statusCode + ", err=" + error + ")";
        }
    }
}
