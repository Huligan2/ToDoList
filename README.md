# ToDoList
This is my example TDL code

This is a bare bones Java code sample.  It has a stub persistence framework for the classes to call for accessing a database.  The external
interface sits in the ToDoList class itself.  If I had time, these would be generated as web services to create the WSDL.

The code only includes 2 basic web services, one to get the To Do List for a user, and one to update (or add) a To Do List item.  
Enhancements would include :
More indepth validation
A web service to allow GUI to get limited To Do List items (e.g. 10 at a time) to enhance performance
Better exception handling (bespoke exception class with optional logging)
More use of the Work specific To Do List item

Testing
Check basic get call works with valid parameters
Call getToDoList("WORK","JULIAN")
Call getToDoList("PERSONAL","JULIAN")
Call getToDoList("WORK","FRED")


Check invalid get call functions as expected
Call getToDoList("ABCD","JULIAN")
Call getToDoList("WORK","ABCD")
Call getToDoList("ABCD","ABCD")

Check basic update call works







