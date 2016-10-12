package java.SomeOther.PersistanceFrameWork;

// Bare bones to provide some stubs for other methods to call

import java.sql.Connection;

public class Transaction {

	private Connection connection;
	
	public Transaction() {
		// Handles database transaction - code intentionally blank
	}
	
	public int commit() throws DatabaseException{
		// logic here to commit to database
		//connection.commit();
		
		return java.Schneider.Definitions.Constants.success;
		
	}

	public Connection manageConnectionPool() {
		// handle database connections from pool (assuming more than one exists)
		// code intentionally blank;
		return connection;
	}
}
