package hotel_booking;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class Database {
	
	protected ConnectionSource connectionsource;
	protected String username;
	protected String password;
	protected String connectionURL;
		
	Database(String username, String password, String host, String port, String database) {
		this.connectionURL = String.format("jdbc:mysql://%s:%s/%s", host, port, database);
		this.username = username;
		this.password = password;
		System.out.println(connectionURL);
	}
	
	public ConnectionSource connect( ) {
		try {
			this.connectionsource = new JdbcConnectionSource(this.connectionURL, this.username, this.password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.connectionsource;
	}
}
