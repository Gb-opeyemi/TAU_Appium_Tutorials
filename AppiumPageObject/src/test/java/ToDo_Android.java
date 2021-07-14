import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ToDo_Android extends TestBase {

    CreateTaskPage createTaskPage;
    TaskListPage taskListPage;

    @Test
    public void test_add_task() throws MalformedURLException {
        Android_setUp();
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        taskListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName("Finish Appium Course");
        createTaskPage.enterTaskDesc("Finishing by Friday by God's Grace");
        driver.hideKeyboard();
        createTaskPage.clickSaveBtn();
        tearDown();
    }

}
