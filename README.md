# AutomationTask
AutomationTask

## Build ##
Install [maven](https://maven.apache.org/), [git](https://git-scm.com/) and  [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* Clone this repo
* Navigate to the AutomationTask/todo-task module in the cloned repo
* Run: `mvn clean package` from cmd.

## TestCases ##
#### Positive scenarios ###
* CreateNewTodoItemValidation - To validate the user can Add tasks and view the added task in List
* MarkAsCompleteValidation - To validate the user can Mark the tasks as completed in the list using checkbox
* EditTaskValidation- To validate user can update the task by double clicking the added task in the List.
* ClearMultipleTasksValidation - To validate user can remove multiple task at once using multiselect option 

#### Negative scenarios ###
* AddMultipleTasksNegativeValidation - To validate user can add more than 20 tasks in the List
* CancelEditValidation - To validate the user can cancel the Edit operation 
* HtmlInjectionValidation - To validate the Input field should not allow the HTML tags as an input
* ValidateInputBoundaryNegativeCase - To validate the user is able to add a task having more than 100 char in input text.



