package tests;

import org.testng.annotations.Test;
import pageObjects.CreateTaskPage;
import pageObjects.TaskListPage;

import java.net.MalformedURLException;

public class iOS_ToDo_Test extends TestBase{

    CreateTaskPage createTaskPage;
    TaskListPage taskListPage;

    @Test
    public void test_add_task() throws MalformedURLException {
        iOS_setUp();
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        taskListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName("Finish Appium Course");
        createTaskPage.enterTaskDesc("Finishing by Friday by God's Grace");
        createTaskPage.clickSaveBtn();
        tearDown();
    }

}
