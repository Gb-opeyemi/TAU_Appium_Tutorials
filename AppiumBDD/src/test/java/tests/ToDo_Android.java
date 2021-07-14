package tests;

import org.testng.annotations.Test;
import pageObjects.CreateTaskPage;
import pageObjects.TaskListPage;

import java.net.MalformedURLException;

public class ToDo_Android extends TestBase {

    CreateTaskPage createTaskPage ;
    TaskListPage tasksListPage;

    @Test
    public void test_add_task() throws MalformedURLException {
        Android_setUp();
        tasksListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName("Finish Appium Course");
        createTaskPage.enterTaskDesc("Finishing my course ASAP");
        driver.hideKeyboard();
        createTaskPage.clickSaveBtn();
        tearDown();
    }
}