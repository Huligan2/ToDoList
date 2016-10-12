# ToDoList
This is my my rather raw and basic example TDL code

This is a bare bones Java code sample.  It has a stub persistence framework for the classes to call for accessing a database.  The external interface sits in the ToDoList class itself.  If I had time, these would be generated as web services to create the WSDL.

I have created only 2  web services, one to get the To Do List for a user, and one to update (or add) a To Do List item.  My aim was to produce an API that could be called by a GUI to get data from a database, and update single entries. So the persistence framework is used to select data and for each row it creates an instance of an item entity, populating the attributes from the columns.  The update API allows a GUI to send an existing Item back in the Item entity and the persistence framework maps the attributes of the Item to SQL to either update or insert the data.  Basic referential integrity checks against the last update user id and timestamp prevent one update overwriting another (e.g. user has 2 sessions open), as each API call is stateless.  I also threw in an abstract class for the To Do List Item to inherit from, so we then have a Personal To Do List item with different extended attributes.  This personal To Do List item allows for an attachment (e.g. a picture or file) to be stored & this is written to a file rather than to the database.  The Work To Do List item doesn't feature heavily in the code but is there to show the difference in handling.  The code is far from complete and hopefully serves its purpose to give a flavour of coding style/ability.  Below I have suggested a few things to do as they are obvious ommisions from a 3 hour coding session!

Enhancements would include :
More indepth validation
Authentication of user id
A web service to allow GUI to get limited To Do List items (e.g. 10 at a time) to enhance performance
Better exception handling (bespoke exception class with optional logging)
More use of the Work specific To Do List item

Testing
Check basic get call works with valid parameters
Call getToDoList("WORK","JULIAN") - should return To Do List for Julians Work items
Call getToDoList("PERSONAL","JULIAN") - should return To Do List for Julians Personal items
Call getToDoList("WORK","FRED") - should return To Do List for Freds Work items


Check invalid get call functions as expected
Call getToDoList("ABCD","JULIAN") - should return exception message for invalid item type
Call getToDoList("WORK","ABCD") - should return exception message for invalid user name
Call getToDoList("ABCD","ABCD") - should return exception message for invalid item type & invalid user name

Check basic update call works
Call updateToDoItem(PersonalToDoItem) - fully populated with some changes - should return success
Call updateToDoItem(PersonalToDoItem) - populated with new item attrbutes - should return success

Call updateToDoItem(PersonalToDoItem) from 2 sessions for same item - fully populated with some changes - 2nd call should return exception message as the To Do Item has been changed by another session

Some stress testing should be carried out to check servers/database can handle high volumes of users at a time
Performance testing should be carried out to check code, database and server performance

These tests cover the basic checks.  Further scenarios should be created to test variations of updates and inserts checking that that all validation rules fire and capture issues







