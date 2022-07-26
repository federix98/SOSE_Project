package it.univaq.disim.sose.service.DAO;

public abstract class DAOFactory {
	
	public static final int SQLITE = 1;
	public static final int MYSQL = 0;
	
	public abstract UserDAO getUserDAO();
	
	public static DAOFactory getDAOFactory(int database) {
		switch (database) {
		case SQLITE:
			return new SQLiteDAOFactory();
		case MYSQL:
			return null;
		default:
			return null;
		}
	}
}
