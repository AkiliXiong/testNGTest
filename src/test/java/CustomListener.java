
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr)
    {
        File srcFile = (test1.driver).getScreenshotAs(OutputType.FILE);
        // System.out.println(srcFile.getAbsolutePath().toString());
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmss");
        File location = new File("screenshots");
        String dest = tr.getMethod().getRealClass().getSimpleName() + "." + tr.getMethod().getMethodName();
        File targetFile =
                new File(location.getAbsolutePath() + File.separator + dest + "_" + dateFormat.format(new Date()) + ".png");
        System.out.println("截图位置：");
        System.out.println("----------------- file is " + targetFile.getPath());
        try
        {
            FileUtils.copyFile(srcFile, targetFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
