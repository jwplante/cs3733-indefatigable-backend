package edu.wpi.cs.indefatigable.db;

import edu.wpi.cs.indefatigable.model.Playlist;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PlaylistDAO {
    java.sql.Connection conn;
    VideoDAO videoInterface;

    public PlaylistDAO() {
        try  {
            conn = DatabaseUtil.connect();
            videoInterface = new VideoDAO(conn);
        } catch (Exception e) {
            conn = null;
        }
    }

    public Playlist getPlaylist(String puid) throws Exception {
        try {
            Playlist playlist = null;
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Playlist WHERE puid=?;");
            ps.setString(1,  puid);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                playlist = generatePlaylist(puid, resultSet);
            }

            resultSet.close();
            ps.close();

            return playlist;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed in getting video: " + e.getMessage());
        }
    }
    
    public ArrayList<Playlist> getAllPlaylists() throws Exception{
        try {
            ArrayList<Playlist> playlist = new ArrayList<Playlist>();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Playlist;");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
            	String puid = resultSet.getString("puid");
                playlist.add(generatePlaylist(puid, resultSet));
            }

            resultSet.close();
            ps.close();

            return playlist;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed in getting video: " + e.getMessage());
        }
    }
    //todo create remaining methods like ConstantsDAO

    private Playlist generatePlaylist(String puid, ResultSet playlist) throws Exception{
        try {
            // Goes to the association table
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM PlaylistVideo WHERE puid=?;");
            ps.setString(1,  puid);
            ResultSet resultSet = ps.executeQuery();
            String name = playlist.getString("name");
            Playlist p = new Playlist(puid, name);

            // Get each video and add it to the playlist
            while (resultSet.next()) {
                String vuid = resultSet.getString("vuid");
                p.addVideo(videoInterface.getVideo(vuid));
            }

            resultSet.close();
            ps.close();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed in getting playlist: " + e.getMessage());
        }
    }

}
