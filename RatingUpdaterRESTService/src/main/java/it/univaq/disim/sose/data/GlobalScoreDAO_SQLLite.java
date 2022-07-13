package it.univaq.disim.sose.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.univaq.disim.sose.model.GlobalScoreData;
import it.univaq.disim.sose.model.RatingData;

public class GlobalScoreDAO_SQLLite implements GlobalScoreDAO{

private String FileURL = "/Users/federico/Desktop/Università/COURSE - Service Oriented Software Engineering/eclipse-ws/sose-workspace/RatingUpdaterRESTService/src/main/resources/sqllite/rating_data.sql";
	
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
            System.out.println(e.getMessage());
        }
        return conn;
    }
	
	private void createDB() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS gloabl_score_data (film_id INT, global_score REAL, number_of_ratings INT)";
		System.out.println("CREATING GlobalScore");
		Statement statement = connect().createStatement();
		Connection connection = connect();
		if (connection == null) {
			System.out.println("Error creating connection");
		}
		else {
			statement.execute(sql);
		}
	}
	
	@Override
	public GlobalScoreData readGlobalScore(int filmId) {
		try {
			createDB();
			
			String sql = "SELECT film_id,global_score,number_of_ratings FROM gloabl_score_data WHERE film_id = " + filmId;
			
			try (Connection conn = connect();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql) ) {
				
				if(rs.next()) {
					System.out.println("Reading global score from film " + filmId + ", : " + rs.getDouble(2));
					return new GlobalScoreData(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
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
		System.out.println("UPDATE SCORE");
		String sql = "";
		if (readGlobalScore(newValue.getFilm_id()) != null) {
			// TODO Auto-generated method stub
			sql = "UPDATE gloabl_score_data SET global_score = ?, number_of_ratings = ? WHERE film_id = ?";
			
			try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            // set the corresponding param
	            pstmt.setDouble(1, newValue.getGlobal_score());
	            pstmt.setInt(2, newValue.getNumber_of_ratings());
	            pstmt.setInt(2, newValue.getFilm_id());
	            // update 
	            pstmt.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		}
		else {
			System.out.println("INSERTING SCORE");
			sql = "INSERT INTO gloabl_score_data(film_id,global_score,number_of_ratings) VALUES(?,?,?)";
			
			try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            // set the corresponding param
	            pstmt.setInt(1, newValue.getFilm_id());
	            pstmt.setDouble(2, newValue.getGlobal_score());
	            pstmt.setInt(2, newValue.getNumber_of_ratings());
	            // update 
	            pstmt.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		}
		
		
		return false;
	}

}
