package iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class iOS_BuiltIn_Test {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformVersion", "14.5");
        //caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("deviceName", "iPhone 12 Pro Max");
        //caps.setCapability("app", System.getProperty("user.dir")+"/apps/UIKitCatalog-iphonesimulator.app");
        caps.setCapability("bundleId", "com.apple.MobileAddressBook");

        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void click_App_Button(){

        driver.findElementByAccessibilityId("Add").click();
        driver.findElementByAccessibilityId("First name").sendKeys("Opeyemi");
        driver.findElementByAccessibilityId("Last name").sendKeys("Gbadamosi");
        driver.findElementByAccessibilityId("Done").click();
    }

    @AfterTest
    public void tearDown(){
        if(null != driver){
            driver.quit();
        }
    }
}
