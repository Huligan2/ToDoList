package java.SomeOther.PersistanceFrameWork;

import java.Schneider.Definitions.*;
import java.sql.SQLDataException;

// Raw bare bones of persistance framework - to provide calling methods some stub entry points 


import java.util.ArrayList;
import java.util.List;


public class EntityHandler {

	private Object entity = null; // maps to a database table with all columns as attributes
	private Transaction trans = null; // used throughout the class, created on demand



	public EntityHandler() {

	}

	public EntityHandler(Object entity) {
		// Create instance of Entity
		this.entity = (Entity) entity; // cast to Entity type
	}

	public int close() throws DatabaseException {
		// Handles closing the transaction, COMMIT change to database and then release connection to pool
		// Throws a database exception  in the event of a db failure


		if (this.commitTransaction(trans) != Constants.success){
			// Failed condition recognised
			DatabaseException databaseException = new DatabaseException();
			throw databaseException;
		}
		else{
			return Constants.success;
		}
	}


	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public ArrayList<Entity> fetch()  throws DatabaseException {
		// Selects multiple rows from database and returns an ArrayList of Entity objects
		// Persistence framework uses Entity attributes to build select statement and predicates

		ArrayList<Entity> entities = new ArrayList<Entity>();

		// Create the db transaction if not already there
		if (trans == null)
			trans = new Transaction();

		// calls further private methods to get connection, create SQL statement, execute and populate all the entity/attributes
		// throws database error in the event of a failure


		return entities;
	}

	public int insert()  throws DatabaseException  {
		// Inserts a database with single row 
		// Framework logic handles all of the complexity, e.g. assigning new PK value

		// Create the db transaction if not already there
		if (trans == null)
			trans = new Transaction();

		// calls further private methods to get connection, create SQL statement and execute
		// throws database error in the event of a failure

		return Constants.success;
	}

	public int update()  throws DatabaseException  {
		// Updates a database with single row 
		// Framework logic handles all of the complexity

		// Create the db transaction if not already there
		if (trans == null)
			trans = new Transaction();

		// calls further private methods to get connection, create SQL statement and execute
		// throws database error in the event of a failure
		
		// Predicates will include LastUpdatedBy & LastUpdatedTstmp to ensure integrity of data & prevent overwriting someone 
		// elses changes
		

		return Constants.success;
	}

	public int update(ArrayList<Entity> entities)  throws DatabaseException  {
		// Handles multiple row updates based on list of Entities
		// Validate each entry is of type Entity and call update() for each one


		return Constants.success;
	}


	public int delete() throws DatabaseException  {
		// Deletes the entity row from the database
		return this.delete(this.entity);
	}	

	public int delete(Object entity) throws DatabaseException  {
		// Deletes the entity row from the database - framework code creates the Delete statement from the Entity attributes


		// Create the db transaction if not already there
		if (trans == null)
			trans = new Transaction();

		// code intentionally left blank

		return Constants.success;
	}	

	
	private int commitTransaction(Transaction trans) throws DatabaseException {
		// Commit changes to the database
		// Not accessible to external classes
		int returnCode = Constants.success;

		try{
			returnCode = trans.commit();

			if (returnCode != Constants.success){

				throw new java.sql.SQLDataException(); // just an example but not fully coded
			}

		} catch(SQLDataException e){
			// Do some logging of some sort
		} catch(Exception e){
			// Do some other logging of some sort
		} finally {
			return Constants.success;
		}
		

	}
}
