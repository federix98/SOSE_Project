package it.univaq.disim.sose.ratingupdater.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.univaq.disim.sose.ratingupdater.model.RatingData;

public class RatingDataDAO_SQLLite implements RatingDataDAO {

	// private String FileURL = "/Users/federico/Desktop/Università/COURSE - Service Oriented Software Engineering/eclipse-ws/sose-workspace/RatingUpdaterRESTService/src/main/resources/sqllite/rating_data.sql";
	private String FileURL = "rating_data.sql";
	
	// Queries
	String CHECK_IF_ALREADY_EXISTS_SQL = "SELECT * FROM rating_data where film_id = ? AND user_id = ?";
	String INSERT_RATING_SQL = "INSERT INTO rating_data(film_id,user_id,film_direction_rating,actors_rating,global_score_rating,dialogues_rating,costumer_rating) VALUES(?,?,?,?,?,?,?)";
	String SELECT_ALL_RATINGS_SQL = "SELECT film_id,user_id,film_direction_rating,actors_rating,global_score_rating,dialogues_rating,costumer_rating from rating_data";
	String SELECT_RATINGS_BY_FILMID_SQL = "SELECT film_id,user_id,film_direction_rating,actors_rating,global_score_rating,dialogues_rating,costumer_rating from rating_data WHERE film_id = ?";
	
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
		String sql = "CREATE TABLE IF NOT EXISTS rating_data (film_id VARCHAR(255), user_id INT, film_direction_rating INT,actors_rating INT,global_score_rating INT, dialogues_rating INT, costumer_rating INT)";
		// System.out.println("CREATING");
		Statement statement = connect().createStatement();
		Connection connection = connect();
		if (connection == null) {
			System.out.println("Error creating connection");
		}
		else {
			statement.execute(sql);
		}
	}
	
	public boolean checkIfAlreadyInserted(String filmId, int userId) throws SQLException {
		createDB();
		
		try (Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(CHECK_IF_ALREADY_EXISTS_SQL)) {
			
			pstmt.setString(1, filmId);
			pstmt.setInt(2, userId);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) return true;
			
			return false;
		}
	}
	
	@Override
	public boolean insertRatingData(RatingData toAdd) throws SQLException {
		// TODO Auto-generated method stub
		try {
			createDB();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (checkIfAlreadyInserted(toAdd.getFilmId(), toAdd.getUserId())) {
			System.out.println("Review already inserted. Aborting insert.");
			return false;
		}
		
		String sql = INSERT_RATING_SQL;

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, toAdd.getFilmId());
        	pstmt.setInt(2, toAdd.getUserId());
        	pstmt.setInt(3, toAdd.getFilmDirectionRating());
        	pstmt.setInt(4, toAdd.getActorsRating());
        	pstmt.setInt(5, toAdd.getGlobalScoreRating());
        	pstmt.setInt(6, toAdd.getDialoguesRating());
        	pstmt.setInt(7, toAdd.getCostumerRating());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
		
	}

	@Override
	public boolean insertRatingDatas(List<RatingData> toAdd) throws SQLException{
		// TODO Auto-generated method stub
		
		try {
			createDB();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		toAdd.forEach((ratingData) -> {
			String sql = INSERT_RATING_SQL;

	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        	pstmt.setString(1, ratingData.getFilmId());
	        	pstmt.setInt(2, ratingData.getUserId());
	        	pstmt.setInt(3, ratingData.getFilmDirectionRating());
	        	pstmt.setInt(4, ratingData.getActorsRating());
	        	pstmt.setInt(5, ratingData.getGlobalScoreRating());
	        	pstmt.setInt(6, ratingData.getDialoguesRating());
	        	pstmt.setInt(7, ratingData.getCostumerRating());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		});
		return true;
	}

	@Override
	public List<RatingData> getAllRatingData() throws SQLException{
		
		try {
			createDB();
			
			String sql = SELECT_ALL_RATINGS_SQL;
			
			try (Connection conn = connect();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql) ) {
				
				List<RatingData> returnList = new ArrayList<RatingData>();
				while(rs.next()) {
					returnList.add(
							new RatingData(
									rs.getString(1),
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

	@Override
	public List<RatingData> getAllRatingDataByFilmId(String filmId) throws SQLException {
		createDB();
		
		String sql = SELECT_RATINGS_BY_FILMID_SQL;
		
		try (Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, filmId);
			ResultSet rs = pstmt.executeQuery();
			
			List<RatingData> returnList = new ArrayList<RatingData>();
			while(rs.next()) {
				returnList.add(
						new RatingData(
								rs.getString(1),
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
	}

}
