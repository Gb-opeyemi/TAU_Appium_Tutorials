import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TaskListPage extends PageBase{

    public TaskListPage(AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    @AndroidFindBy(id = "fab")
    @iOSXCUITFindBy(accessibility = "plus.circle")
    MobileElement addTaskBtn;

    public void clickAddTaskBtn(){
        click(addTaskBtn);
    }


}
