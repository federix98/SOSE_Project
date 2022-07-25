package it.univaq.disim.sose.ratingupdater.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.univaq.disim.sose.ratingupdater.model.GlobalScoreData;
import it.univaq.disim.sose.ratingupdater.utils.UtilityMethods;

public class GlobalScoreDAO_SQLLite implements GlobalScoreDAO{

	// private String FileURL = "/Users/federico/Desktop/Università/COURSE - Service Oriented Software Engineering/eclipse-ws/sose-workspace/RatingUpdaterRESTService/src/main/resources/sqllite/rating_data.sql";
	private String FileURL = "rating_data.sql";
	
	private Connection connect() {
        // SQLite connection string
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        String url = "jdbc:sqlite:" + FileURL;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            UtilityMethods.consoleLog(e.getMessage());
        }
        return conn;
    }
	
	private void createDB() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS gloabl_score_data (film_id VARCHAR(255), global_score REAL, number_of_ratings INT)";
		UtilityMethods.consoleLog("CREATING GlobalScore");
		Statement statement = connect().createStatement();
		Connection connection = connect();
		if (connection == null) {
			UtilityMethods.consoleLog("Error creating connection");
		}
		else {
			statement.execute(sql);
		}
	}
	
	@Override
	public GlobalScoreData readGlobalScore(String filmId) {
		try {
			createDB();
			
			String sql = "SELECT film_id,global_score,number_of_ratings FROM gloabl_score_data WHERE film_id = ?";
			
			
			try (Connection conn = connect();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					 ) {
				
				pstmt.setString(1, filmId);
				UtilityMethods.consoleLog(pstmt.toString());
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					UtilityMethods.consoleLog("Reading global score from film " + filmId + ", : " + rs.getDouble(2));
					return new GlobalScoreData(rs.getString(1), rs.getDouble(2), rs.getInt(3));
				}
				
			}
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateGlobalScore(GlobalScoreData newValue) {
		
		try {
			createDB();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		UtilityMethods.consoleLog("UPDATE SCORE");
		String sql = "";
		if (readGlobalScore(newValue.getFilmId()) != null) {
			// TODO Auto-generated method stub
			sql = "UPDATE gloabl_score_data SET global_score = ?, number_of_ratings = ? WHERE film_id = ?";
			
			try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            // set the corresponding param
	            pstmt.setDouble(1, newValue.getGlobalScore());
	            pstmt.setInt(2, newValue.getNumberOfRatings());
	            pstmt.setString(2, newValue.getFilmId());
	            // update 
	            pstmt.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	        	UtilityMethods.consoleLog(e.getMessage());
	        }
		}
		else {
			UtilityMethods.consoleLog("INSERTING SCORE");
			sql = "INSERT INTO gloabl_score_data(film_id,global_score,number_of_ratings) VALUES(?,?,?)";
			
			try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            // set the corresponding param
	            pstmt.setString(1, newValue.getFilmId());
	            pstmt.setDouble(2, newValue.getGlobalScore());
	            pstmt.setInt(3, newValue.getNumberOfRatings());
	            // update 
	            pstmt.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	        	UtilityMethods.consoleLog(e.getMessage());
	        }
		}
		
		
		return false;
	}

}
