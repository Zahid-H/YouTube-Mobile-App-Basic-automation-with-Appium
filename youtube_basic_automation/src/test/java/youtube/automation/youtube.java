package youtube.automation;

import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;

public class youtube {
    public static AppiumDriver<MobileElement> driver;
    String url;

    @BeforeTest
    public void setup() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        String url;
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.google.android.youtube");
        capabilities.setCapability("appActivity", "com.google.android.apps.youtube.app.watchwhile.WatchWhileActivity");
        capabilities.setCapability("noReset", true);
        url = "http://127.0.0.1:4723/wd/hub";
        driver = new AndroidDriver<MobileElement>(new URL(url), capabilities);
        System.out.println("Clicked on the App");

    }

    @Test
    public void Youtube_test_search() throws InterruptedException {
        driver.findElementByAccessibilityId("Search").click();

        driver.findElementByClassName("android.widget.EditText").sendKeys("sqa");
        ((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

        Thread.sleep(3000);
    }
}
