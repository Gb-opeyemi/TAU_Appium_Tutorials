package Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Send_SMS_Test {

   public AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Android Emulator");
        //caps.setCapability("app", System.getProperty("user.dir")+"/apps/Calculator_v7.8 (271241277)_apkpure.com.apk");
        caps.setCapability("appPackage","com.google.android.apps.messaging");
        caps.setCapability("appActivity",".ui.ConversationListActivity");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void sendSMS(){
        driver.sendSMS("08180168064", "Hello from Appium Class");
    }

    @Test
    public void sendAnotherSMS(){
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.id("conversation_text_content")).click();
        driver.findElement(By.id("compose_message_text")).sendKeys("I am a Tester");
        driver.findElement(By.id("send_message_button_icon")).click();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}

