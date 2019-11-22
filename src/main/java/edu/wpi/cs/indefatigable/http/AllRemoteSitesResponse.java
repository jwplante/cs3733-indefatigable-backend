package edu.wpi.cs.indefatigable.http;

import java.util.ArrayList;
import java.util.List;

public class AllRemoteSitesResponse {
    public final List<String> urls;
    public final int statusCode;
    public final String error;

    public AllRemoteSitesResponse(List<String> urls, int code) {
        this.urls = urls;
        this.statusCode = code;
        this.error = "";
    }

    public AllRemoteSitesResponse(int code, String errormessage){
        this.urls = new ArrayList<String>();
        this.statusCode = code;
        this.error = errormessage;
    }

    public String toString(){
        if(urls == null){
            return "EmptyRemoteSites";
        }
        return "AllRemoteSites(" + urls.size() + ")";
    }
}
