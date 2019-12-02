package edu.wpi.cs.indefatigable.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class RemoteSitesDAO {
    java.sql.Connection conn;

    public RemoteSitesDAO(){
        try{
            conn = DatabaseUtil.connect();
        } catch (Exception e) {
            conn = null;
        }
    }

    public ArrayList<String> getRemoteSites() throws Exception {
        try{
            ArrayList<String> urls = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM RemoteApi");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                urls.add(resultSet.getString("url"));
            }
            resultSet.close();
            ps.close();
            return urls;
        } catch (SQLException e){
            e.printStackTrace();
            throw new Exception("Failed getting Remote URLS");
        }
    }
    
    public boolean addRemoteSite(String url) throws Exception{
    	try {
    		PreparedStatement ps = conn.prepareStatement("INSERT INTO RemoteApi(uid,url) VALUES (?,?)");
    		ps.setString(1,UUID.randomUUID().toString());
    		ps.setString(2, url);
    		int affected = ps.executeUpdate();
    		ps.close();
    		return (affected==1);
    	}
    	catch(Exception e) {
            e.printStackTrace();
            throw new Exception("Could not add site: "+e.getMessage());
    	}
    }
    
}
