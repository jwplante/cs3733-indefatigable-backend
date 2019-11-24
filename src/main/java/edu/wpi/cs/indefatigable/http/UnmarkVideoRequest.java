package edu.wpi.cs.indefatigable.http;

public class UnmarkVideoRequest {
    public String vuid;

    public String getVuid() {
        return vuid;
    }

    public UnmarkVideoRequest(String vuid) {
        this.vuid = vuid;
    }

    public UnmarkVideoRequest() {

    }

    public String toString() {
        return "Mark(" + vuid + ")";
    }
}