package edu.wpi.cs.indefatigable.db;

import edu.wpi.cs.indefatigable.model.Video;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {
    java.sql.Connection conn;

    public VideoDAO() {
        try {
            conn = DatabaseUtil.connect();
        } catch (Exception e) {
            conn = null;
        }
    }

    public Video getVideo(String vuid) throws Exception {
        try {
            Video video = null;
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Video WHERE vuid=?;");
            ps.setString(1, vuid);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                video = generateVideo(resultSet);
            }
            resultSet.close();
            ps.close();

            return video;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed in getting video: " + e.getMessage());
        }
    }
    //todo create remaining methods like ConstantsDAO

    private Video generateVideo(ResultSet resultSet) throws SQLException {
        String vuid = resultSet.getString("vuid");
        String url = resultSet.getString("url");
        boolean remoteAvailability = resultSet.getBoolean("remoteAvailability");
        boolean isRemote = resultSet.getBoolean("isRemote");
        String character = resultSet.getString("character");
        String transcript = resultSet.getString("transcript");
        String title = resultSet.getString("title");
        return new Video(vuid, url, remoteAvailability, isRemote, character, transcript, title);

    }

    public List<Video> getAllVideos() throws Exception {
        List<Video> allVideos = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM Video";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Video v = generateVideo(resultSet);
                allVideos.add(v);
            }
            resultSet.close();
            return allVideos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
