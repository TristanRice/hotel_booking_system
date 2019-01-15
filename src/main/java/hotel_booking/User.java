package hotel_booking;

import java.sql.SQLException;
import java.util.regex.*;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "users")
public class User {
	
	//strings for column names
	protected final String NAME_FIELD_NAME     = "name";
	protected final String USERNAME_FIELD_NAME = "username";
	protected final String PASSWORD_FIELD_NAME = "password";
	protected final String EMAIL_FIELD_NAME    = "email";
	protected final String ADMIN_FIELD_NAME    = "admin";
	protected final String DELETED_FIELD_NAME  = "deleted";
	protected final String USERID_FIELD_NAME   = "user_id";
	protected final String AGE_FIELD_NAME      = "age";
	protected final String CAN_COMMENT_FIELD   = "can_comment";
	
	@DatabaseField(canBeNull = false, columnName = NAME_FIELD_NAME)
	protected String name;
	
	@DatabaseField(canBeNull = false, columnName = USERNAME_FIELD_NAME, unique = true)
	protected String username;
	
	@DatabaseField(canBeNull = false, columnName = PASSWORD_FIELD_NAME)
	protected String password;
	
	@DatabaseField(canBeNull = false, columnName = EMAIL_FIELD_NAME, unique = true)
	protected String email;
	
	
	@DatabaseField(canBeNull = false, columnName = ADMIN_FIELD_NAME)
	protected boolean admin = false;
	
	@DatabaseField(canBeNull = false, columnName = DELETED_FIELD_NAME)
	protected boolean deleted = false;
	
	@DatabaseField(canBeNull = false, columnName = CAN_COMMENT_FIELD)
	protected boolean muted = false;
	
	
	@DatabaseField(id = true, columnName = USERID_FIELD_NAME)
	protected int userId;
	
	@DatabaseField(canBeNull = false, columnName = AGE_FIELD_NAME)
	protected int age;
	
	
	protected final int MAX_AGE = 200;
	protected final int MIN_AGE = 18;
	protected final int MAX_NAME_LENGTH = 20;
	protected final int MIN_NAME_LENGTH = 3;
	protected final int MAX_USERNAME_LENGTH = 30;
	protected final int MIN_USERNAME_LENGTH = 3;
	
	User( ) {
		super( );
	}
	
	public void setAge(int age) {
		if (age > this.MAX_AGE || age < this.MIN_AGE) {
			throw new IllegalArgumentException("Age must be between "+this.MIN_AGE+" and "+this.MAX_AGE);
		}
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) throws IllegalArgumentException {
		if (name.length() > this.MAX_NAME_LENGTH || name.length() < this.MIN_NAME_LENGTH) {
			throw new IllegalArgumentException("Name length must be lower than "+this.MAX_NAME_LENGTH);
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setUsername(String username) throws IllegalArgumentException {
		if (username.length() > this.MAX_USERNAME_LENGTH || username.length() < this.MIN_USERNAME_LENGTH) {
			throw new IllegalArgumentException("Username length must be lower than " + this.MAX_USERNAME_LENGTH);
		}
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean verifyPassword(String password) {
		return true;
	}

	public void setPassword(String password) {
		String BCryptHashedPassword = password; //TODO: hash this
		this.password = BCryptHashedPassword;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		Pattern pattern = Pattern.compile("^.+@.+\\..+$");
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("You must provide a valid email address");
		}
		this.email = email;
	}
	
	public boolean isMuted() {
		return muted;
	}
	
	public void setMuted (boolean muted) {
		this.muted = muted;
	}
	
	public void alreadyExists(Dao<User, String> accountDao,
							  ConnectionSource connection) throws AlreadyExistsException, SQLException {
	}
}
