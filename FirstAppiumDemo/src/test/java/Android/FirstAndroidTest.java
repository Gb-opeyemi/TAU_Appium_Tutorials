package Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FirstAndroidTest {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Android Emulator");
        //caps.setCapability("deviceName", "Infinix HOT 9");
        caps.setCapability("app", System.getProperty("user.dir")+"/apps/ApiDemos-debug.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void click_App_Button(){
        //driver.findElementByAccessibilityId("App").click();
        driver.findElementByAccessibilityId("Preference").click();
        driver.findElementByAccessibilityId("3. Preference dependencies").click();
        driver.findElement(By.id("android:id/checkbox")).click();
        List<WebElement> childElements =  driver.findElements(By.className("android.widget.RelativeLayout"));
        WebElement mainElement = childElements.get(1);
        mainElement.click();
        driver.findElement(By.id("android:id/edit")).sendKeys("Hello Ama, My boss");
        driver.findElement(By.id("android:id/button1"));

    }

    @AfterTest
    public void tearDown(){
        if(null != driver){
            driver.quit();
        }
    }
}
