package edu.wpi.cs.indefatigable.http;

public class MarkVideoRequest {
    public String vuid;
    public String getVuid(){
        return vuid;
    }
    public MarkVideoRequest(String vuid){
        this.vuid = vuid;
    }

    public MarkVideoRequest(){

    }

    public String toString(){
        return "Mark(" + vuid + ")";
    }
}
