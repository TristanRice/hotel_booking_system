package hotel_booking;

import java.lang.Exception;

public class AlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public AlreadyExistsException( ) {
		super( );
	}
	
	public AlreadyExistsException(String message) {
		super(message);
	}
	
	public AlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public AlreadyExistsException(Throwable cause) {
		super(cause);
	}
}
