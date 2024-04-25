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
        //Setting capabilities of the mobile phone app
        DesiredCapabilities cap = new DesiredCapabilities();

        // device name which is obtained from the settings of the phone
        cap.setCapability("deviceName","OPPO Find X3 Pro");
        // udid this one you will get from the adb devices
        cap.setCapability("udid","4d897317");
        // this depends on the OS of the phone
        cap.setCapability("platformName","Android");
        // this depends on the platform version of the phone
        cap.setCapability("platformVersion","11");
        // this the appium driver based on the Android phone
        cap.setCapability("automationName","uiAutomator2");
        // this is dependent on the mobile application that you want to launch
        cap.setCapability("appPackage","com.reddit.frontpage");
        // this is the activity for e.g: launching the mobile application
        cap.setCapability("appActivity","com.reddit.launch.main.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url,cap);
        Thread.sleep(20000);

        // this performs the search button click
        driver.findElement(new AppiumBy.ByAccessibilityId("Search")).click();
        // searching for the 'Australia' text in search textbox
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.reddit.frontpage:id/search\")")).sendKeys("Australia");
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.reddit.frontpage:id/toolbar_search_icon\")")).click();
        // checking if the results are appearing in the result
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"search_typeahead_item\").instance(0)")).isDisplayed();

        System.out.println("Application started");

    }

}
