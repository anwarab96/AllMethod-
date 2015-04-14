package Method;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ScreenShort {

    WebDriver driver = null;

    @BeforeTest
    public void beforeTest(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://www.jquery.com/");

    }

    @Test
    public void test()throws Exception{
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scr, new File("screenShort.jpg"));

    }

    @AfterTest
    public  void afterTest(){
        driver.close();
    }

}
