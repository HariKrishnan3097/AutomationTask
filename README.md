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


![image](https://user-images.githubusercontent.com/96883288/176601864-6108c344-9f77-41b6-b565-85fc1a4d105d.png)


![image](https://user-images.githubusercontent.com/96883288/176602049-26e1e056-9415-44a1-8f3f-baba32fc867b.png)

Framework uses page object model design pattern and The @FindBy annotation is used in Page Objects in Selenium tests to specify the object location strategy for a WebElement or a list of WebElements. Using the PageFactory, these WebElements are usually initialized when a Page Object is created. 


![image](https://user-images.githubusercontent.com/96883288/176602227-b435d724-b98a-43bf-9224-dac5e2125e0c.png)

AutomationFramework uses TestNg framework and TestNG.xml file which contains all the Test configuration and this XML file can be used to run and organize our test.
Tests can be organized based on the priority.

![image](https://user-images.githubusercontent.com/96883288/176685100-3e97cd66-b399-4ed0-bfc5-898f986def90.png)


### Reporting ###

ExtentReports is used as reporting library for the framework which creates HTML reports that is running from maven. It is integrated with TestNG framework using the listeners.

Please find the sample HTML report under todo-task\TestReport folder in repo




