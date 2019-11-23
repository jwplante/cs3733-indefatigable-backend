package edu.wpi.cs.indefatigable.http;

public class MarkVideoResponse {
    public final String vuid;
    public final int statusCode;
    public final String error;

    public MarkVideoResponse(String vuid, int statusCode) {
        this.vuid = vuid;
        this.statusCode = statusCode;
        this.error = "";
    }

    public MarkVideoResponse(String vuid, int statusCode, String errorMessage) {
        this.vuid = vuid;
        this.statusCode = statusCode;
        this.error = errorMessage;
    }

    public String toString() {
        if (statusCode == 200) {
            return "MarkVideoResponse(" + vuid + ")";
        } else {
            return "ErrorResult(" + vuid + ", statusCode=" + statusCode + ", err=" + error + ")";
        }
    }
}
