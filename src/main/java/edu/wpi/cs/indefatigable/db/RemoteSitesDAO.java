package edu.wpi.cs.indefatigable.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
}
