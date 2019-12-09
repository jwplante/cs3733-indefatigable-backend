package edu.wpi.cs.indefatigable.db;

import edu.wpi.cs.indefatigable.model.Playlist;
import edu.wpi.cs.indefatigable.model.Video;

import java.nio.charset.Charset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class PlaylistDAO {
    java.sql.Connection conn;
    VideoDAO videoInterface;

    public PlaylistDAO() {
        try {
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
            ps.setString(1, puid);
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

    public String createPlaylist(String name) throws Exception {
        try {
            if (name == null) {
                byte[] array = new byte[5]; // length is bounded by 7
                new Random().nextBytes(array);
                name = new String(array, Charset.forName("UTF-8"));
            }
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Playlist(puid, name) VALUES (?,?)");
            String uuid = String.valueOf(UUID.randomUUID());
            ps.setString(1, uuid);
            ps.setString(2, name);
            int numAffected = ps.executeUpdate();
            ps.close();
            if(numAffected == 1) return (uuid);
            else throw new Exception("Failed in creating playlist");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Failed in creating playlist: " + e.getMessage());
        }
    }

    public boolean deletePlaylist(String puid) throws Exception {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Playlist WHERE puid=?;");
            ps.setString(1, puid);
            int numAffected = ps.executeUpdate();
            ps.close();
            return (numAffected == 1);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed in deleting playlist: " + e.getMessage());
        }
    }

    public ArrayList<Playlist> getAllPlaylists() throws Exception {
        try {
            ArrayList<Playlist> playlist = new ArrayList<>();
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
            throw new Exception("Failed in getting playlists: " + e.getMessage());
        }
    }
    //todo create remaining methods like ConstantsDAO

    private Playlist generatePlaylist(String puid, ResultSet playlist) throws Exception {
        try {
            // Goes to the association table
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM PlaylistVideo WHERE puid=?;");
            ps.setString(1, puid);
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
    
    public boolean appendSegment(Video v, Playlist p) {
    	try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO PlaylistVideo(vuid,puid) VALUES (?,?)");
			ps.setString(1, v.getVuid());
			ps.setString(2, p.getID());
			int affected = ps.executeUpdate();
			ps.close();
			return affected==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	return false;
    }
    
    public boolean removeSegment(String vuid, String puid) {
    	try {
    		PreparedStatement ps = conn.prepareStatement("DELETE FROM PlaylistVideo WHERE (vuid,puid)=(?,?)");
    		ps.setString(1, vuid);
    		ps.setString(2, puid);
    		int affected = ps.executeUpdate();
    		ps.close();
    		return affected == 1;
    		
    				
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return false;
    }

}

