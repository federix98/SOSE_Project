package it.univaq.disim.sose.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.univaq.disim.sose.model.RatingData;

public class RatingDataDAO_SQLLite implements RatingDataDAO {

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
		String sql = "CREATE TABLE IF NOT EXISTS rating_data (film_id INT, user_id INT, film_direction_rating INT,actors_rating INT,global_score_rating INT, dialogues_rating INT, costumer_rating INT)";
		System.out.println("CREATING");
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
	public boolean insertRatingData(RatingData toAdd) {
		// TODO Auto-generated method stub
		try {
			createDB();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql = "INSERT INTO rating_data(film_id,user_id,film_direction_rating,actors_rating,global_score_rating,dialogues_rating,costumer_rating) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setInt(1, toAdd.getFilm_id());
        	pstmt.setInt(2, toAdd.getUser_id());
        	pstmt.setInt(3, toAdd.getFilm_direction_rating());
        	pstmt.setInt(4, toAdd.getActors_rating());
        	pstmt.setInt(5, toAdd.getGlobal_score_rating());
        	pstmt.setInt(6, toAdd.getDialogues_rating());
        	pstmt.setInt(7, toAdd.getCostumer_rating());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
		
	}

	@Override
	public boolean insertRatingDatas(List<RatingData> toAdd) {
		// TODO Auto-generated method stub
		
		try {
			createDB();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		toAdd.forEach((ratingData) -> {
			String sql = "INSERT INTO rating_data(film_id,user_id,film_direction_rating,actors_rating,global_score_rating,dialogues_rating,costumer_rating) VALUES(?,?,?,?,?,?,?)";

	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        	pstmt.setInt(1, ratingData.getFilm_id());
	        	pstmt.setInt(2, ratingData.getUser_id());
	        	pstmt.setInt(3, ratingData.getFilm_direction_rating());
	        	pstmt.setInt(4, ratingData.getActors_rating());
	        	pstmt.setInt(5, ratingData.getGlobal_score_rating());
	        	pstmt.setInt(6, ratingData.getDialogues_rating());
	        	pstmt.setInt(7, ratingData.getCostumer_rating());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		});
		return true;
	}

	@Override
	public List<RatingData> getAllRatingData() {
		
		try {
			createDB();
			
			String sql = "SELECT film_id,user_id,film_direction_rating,actors_rating,global_score_rating,dialogues_rating,costumer_rating from rating_data";
			
			try (Connection conn = connect();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql) ) {
				
				List<RatingData> returnList = new ArrayList<RatingData>();
				while(rs.next()) {
					returnList.add(
							new RatingData(
									rs.getInt(1),
									rs.getInt(2),
									rs.getInt(3),
									rs.getInt(4),
									rs.getInt(5),
									rs.getInt(6),
									rs.getInt(7)
									));
				}
				return returnList;
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}

}
