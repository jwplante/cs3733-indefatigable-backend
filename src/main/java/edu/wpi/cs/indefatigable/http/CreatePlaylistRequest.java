package edu.wpi.cs.indefatigable.http;

public class CreatePlaylistRequest {
    String name;

    public CreatePlaylistRequest(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return "Create("+ name + ")";
    }
}
