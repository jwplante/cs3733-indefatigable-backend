package edu.wpi.cs.indefatigable.http;

public class CreatePlaylistRequest {
    public String name;

    public CreatePlaylistRequest(String name){
        this.name = name;
    }
    public CreatePlaylistRequest(){}

    public String getName(){
        return this.name;
    }

    public String toString(){
        return "Create("+ name + ")";
    }
}
