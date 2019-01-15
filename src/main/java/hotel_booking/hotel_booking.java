package hotel_booking;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import com.blade.Blade;

import routes.IndexController;

public class hotel_booking {

	public static void main(String[] args) throws SQLException {
		Database database = new Database("root", "apple", "localhost", "3306", "hotel_book_system");
		ConnectionSource connection = database.connect();	
		System.out.println(connection);
		Blade.of().start(IndexController.class);
		//setUpDatabase(connection);		
	}
	
	private static void setUpDatabase(ConnectionSource connection) {
		Dao<User, String> accountDao;
		try {
			accountDao = DaoManager.createDao(connection, User.class);
			TableUtils.createTable(connection, User.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
