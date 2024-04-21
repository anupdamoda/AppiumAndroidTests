import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {

    static AppiumDriver driver;
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
      openMobileApp();
    }

    public static void openMobileApp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName","OPPO Find X3 Pro");
        cap.setCapability("udid","4d897317");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","11");
        cap.setCapability("automationName","uiAutomator2");
        cap.setCapability("appPackage","com.reddit.frontpage");
        cap.setCapability("appActivity","com.reddit.launch.main.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url,cap);
        Thread.sleep(20000);

        driver.findElement(new AppiumBy.ByAccessibilityId("Search")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.reddit.frontpage:id/search\")")).sendKeys("Australia");
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.reddit.frontpage:id/toolbar_search_icon\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"search_typeahead_item\").instance(0)")).isDisplayed();

        System.out.println("Application started");

    }

}
