package edu.wpi.cs.indefatigable.http;

public class UnmarkVideoResponse {
    public final String vuid;
    public final int statusCode;
    public final String error;

    public UnmarkVideoResponse(String vuid, int statusCode) {
        this.vuid = vuid;
        this.statusCode = statusCode;
        this.error = "";
    }

    public UnmarkVideoResponse(String vuid, int statusCode, String errorMessage) {
        this.vuid = vuid;
        this.statusCode = statusCode;
        this.error = errorMessage;
    }

    public String toString() {
        if (statusCode == 200) {
            return "UnmarkVideoResponse(" + vuid + ")";
        } else {
            return "ErrorResult(" + vuid + ", statusCode=" + statusCode + ", err=" + error + ")";
        }
    }
}
