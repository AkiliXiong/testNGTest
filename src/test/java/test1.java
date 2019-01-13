import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class test1 {

    private static AppiumDriverLocalService service;
    private static AndroidDriver<AndroidElement> driver;
    @BeforeSuite
    public void beforeSuite()
    {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "iPhone 6");
        capabilities.setCapability("appPackage", "com.xueqiu.android");
        capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        capabilities.setCapability("automationName", "uiautomator2");
        //capabilities.setCapability("recreateChromeDriverSessions", "true");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("showChromedriverLog", true);
        //capabilities.setCapability("dontStopAppOnReset", true);
        driver= new AndroidDriver<AndroidElement>(getServiceUrl(),capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws InterruptedException {
        driver.findElementById("home_search").click();
        Thread.sleep(10);
    }


    @AfterSuite
    public void afterSuite()
    {
        service.stop();
    }

    public URL getServiceUrl()
    {
        return service.getUrl();
    }


}
