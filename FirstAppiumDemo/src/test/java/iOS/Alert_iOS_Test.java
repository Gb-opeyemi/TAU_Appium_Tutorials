package iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Alert_iOS_Test {

    //AppiumDriver driver;
    public IOSDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformVersion", "14.5");
        //caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("deviceName", "iPhone 12 Pro Max");
        caps.setCapability("app", System.getProperty("user.dir")+"/apps/UIKitCatalog-iphonesimulator.app");

        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void testSimpleAlert(){

        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByAccessibilityId("Simple").click();
        driver.switchTo().alert().accept();
    }

    @Test
    public void testOkayCancelAlert() {
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByAccessibilityId("Okay / Cancel").click();
        driver.switchTo().alert().dismiss();

    }

    @Test
    public void testSendTextAlert() {
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByAccessibilityId("Text Entry").click();
        driver.switchTo().alert().sendKeys("Hello TAU");
        driver.switchTo().alert().accept();
        //driver.switchTo().alert().dismiss();
    }


    @AfterTest
    public void tearDown(){
        if(null != driver){
            driver.quit();
        }
    }
}
