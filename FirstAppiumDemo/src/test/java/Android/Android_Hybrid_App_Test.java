package Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Android_Hybrid_App_Test {

    private static By chromeScreen = MobileBy.AccessibilityId("buttonStartWebviewCD");
    private static By gotoHomeScreen = By.id("goBack");

    private AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("app", System.getProperty("user.dir") + "/apps/selendroid.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    public void switchToWebView() {
        Set<String> availableContexts = driver.getContextHandles();
        for (String context : availableContexts) {
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                break;
            }
        }
    }

    @Test
    public void HybridTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(chromeScreen))
                .click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        String context = driver.getContext();
        System.out.println(context);
        switchToWebView();
        String context2 = driver.getContext();
        System.out.println(context2);
       // driver.findElementById("name_input").sendKeys("Opeyemi Gbadamosi");
        WebElement name_input = driver.findElement(By.id("name_input"));
        name_input.clear();
        String name = "Opeyemi Gbadamosi";
        name_input.sendKeys(name);
        driver.context("NATIVE_APP");
        driver.findElement(gotoHomeScreen).click();
    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
