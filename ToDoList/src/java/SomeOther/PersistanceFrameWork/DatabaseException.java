package java.SomeOther.PersistanceFrameWork;

// Bare bones only

public class DatabaseException extends Exception{

	private int errorCode;
	
	public DatabaseException() {
		// Handles specifics of a database error - sets error code to generic value
		new DatabaseException(java.Schneider.Definitions.Constants.failure);
	}

	public DatabaseException(int errorCode) {
		// Handles specifics of a database error - nothing coded tho
		
		this.errorCode = errorCode;
	}

}
