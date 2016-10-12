package java.Schneider.ToDoListHandler;

import java.Schneider.Definitions.Constants;
import java.Schneider.Definitions.PersonalToDoItem;
import java.Schneider.Definitions.SchneiderFile;
import java.Schneider.Definitions.ToDoItem;
import java.Schneider.Definitions.WorkToDoItem;
import java.Schneider.Utilities.FileHandler;
import java.SomeOther.PersistanceFrameWork.DatabaseException;
import java.SomeOther.PersistanceFrameWork.EntityHandler;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ToDoList {

	public ToDoList() {
		// TODO Auto-generated constructor stub
	}

	public int updateToDoItem(ToDoItem item) throws Exception{
		// Update the database row for the given item
		EntityHandler pfEntityHandler = new EntityHandler();

		try{
			// Check  if its an update or an insert
			if (item.getItemKey() == null){
				// this must be a new item, so validate it has a name (all others can be blank)
				if (item.getItemName() == null || item.getItemName().isEmpty())
					throw (new Exception()); // throw appropriate exception so GUI can tell user the item name is missing -needs coding
				
				if (item.getItemType() == ToDoItem.typePersonal)
					if ( ((PersonalToDoItem) item).isAttachmentExists() && ((PersonalToDoItem) item).getAttachment().size() == 0)
						throw (new Exception()); // throw appropriate exception so GUI can tell user no attachment exists - needs coding
				
				// Validation passed, insert the item
				pfEntityHandler.setEntity(item);
				pfEntityHandler.insert();
			}
			else{
				// Must be an update
				pfEntityHandler.setEntity(item);
				pfEntityHandler.update();				
			}

		
		}catch(Exception e) {
			// handle particular error in some fancy way
		
		} 
		finally {
			return Constants.success;
		}
		
	}
	
	
		
		public ArrayList getToDoList(String toDoListType, String person) throws DatabaseException{
			// Gets the to do list of specific type for a named person
			
		ArrayList toDoList = null;
		ToDoItem toDoItem = null;
		EntityHandler pfEntityHandler = new EntityHandler();
		

		// Query the database to get the data - depending on the type
		if (toDoListType.equals(ToDoItem.typePersonal))
			toDoItem = new PersonalToDoItem();
		else
			if (toDoListType.equals(ToDoItem.typeWork))
				toDoItem = new WorkToDoItem();
			else{
				//  error in type - throw suitable exception to be handled by calling code;
				// throw....
			}
		
		toDoItem.setItemName(person);	
		toDoItem.setItemType(toDoListType);

		pfEntityHandler.setEntity(toDoItem);
		toDoList = pfEntityHandler.fetch(); // this will get all the rows from the database and populate an arraylist of PersonalToDoItems
		
		// For Personal work items there might be an attachment - if so, go get them from file storage
		if (toDoListType.equals(ToDoItem.typePersonal)){
			// Loop thru all the personal work items
			FileHandler fileHandler = new FileHandler();
			SchneiderFile file = null;
			int index = 0;
			PersonalToDoItem p;
			ByteArrayOutputStream attachment;
			while (toDoList != null && index < toDoList.size()){
				p = (PersonalToDoItem) toDoList.get(index);	
				if (p.isAttachmentExists()){
					file = new SchneiderFile(Constants.pathName);
					file.setFileName(p.getFileName());
					attachment = fileHandler.readFile(file);
					p.setAttachment(attachment);
				}
				index++;
			}
			
		}
		
		return toDoList;
		

		
	}
}
