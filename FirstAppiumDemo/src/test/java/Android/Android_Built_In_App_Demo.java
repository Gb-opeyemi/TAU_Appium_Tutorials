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

public class Android_Built_In_App_Demo {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app", System.getProperty("user.dir")+"/apps/Calculator_v7.8 (271241277)_apkpure.com.apk");
        //caps.setCapability("appPackage","com.android.deskclock");
        //caps.setCapability("appActivity",".DeskClock");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void calculate(){
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.id("digit_1")).click();
        driver.findElementByAccessibilityId("plus").click();
        driver.findElement(By.id("digit_3")).click();
        Assert.assertEquals(driver.findElement(By.id("result_preview")).getText(), "4");
    }


    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}

