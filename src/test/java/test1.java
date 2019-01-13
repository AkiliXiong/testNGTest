import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class test1 {

    private static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement> driver;

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

    @Test(retryAnalyzer = MyRetry.class)
    public void test1() throws InterruptedException {
        driver.findElementById("home_search").click();
        WebDriverWait waiter = new WebDriverWait(driver,10);
        WebElement cancelLabel = waiter.
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,'取消')]")));
        Assert.assertEquals(cancelLabel.getText(),"取消");
        Thread.sleep(10);
    }

    @AfterSuite
    public void afterSuite()
    {
        driver.quit();
        service.stop();
    }

    public URL getServiceUrl()
    {
        return service.getUrl();
    }


}
