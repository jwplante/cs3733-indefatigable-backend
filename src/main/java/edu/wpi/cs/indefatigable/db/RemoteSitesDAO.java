package edu.wpi.cs.indefatigable.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class RemoteSitesDAO {
    java.sql.Connection conn;

    public RemoteSitesDAO() {
        try {
            conn = DatabaseUtil.connect();
        } catch (Exception e) {
            conn = null;
        }
    }

    public ArrayList<String> getRemoteSites() throws Exception {
        try {
            ArrayList<String> urls = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM RemoteApi");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                urls.add(resultSet.getString("url"));
            }
            resultSet.close();
            ps.close();
            return urls;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Failed getting Remote URLS");
        }
    }

    public String addRemoteSite(String url) throws Exception {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO RemoteApi(uid,url) VALUES (?,?)");
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, url);
            ps.executeUpdate();
            ps.close();
            PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM RemoteApi WHERE url=?;");
            ps2.setString(1, url);
            ResultSet result = ps2.executeQuery();
            String uid = "";
            while (result.next()) {
                uid = result.getString("uid");
            }
            result.close();
            return uid;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Could not add site: " + e.getMessage());
        }
    }

    public boolean removeRemoteSite(String url) throws Exception {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM RemoteApi WHERE url=?");
            ps.setString(1, url);
            int affected = ps.executeUpdate();
            ps.close();
            return (affected == 1);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Could not remove site: " + e.getMessage());
        }

    }

}
