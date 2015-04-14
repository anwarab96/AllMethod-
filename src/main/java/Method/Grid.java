package Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by salahakanda on 4/14/15.
 */
public class Grid {
    WebDriver driver = null;

    @BeforeTest
    public void beforeTest() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        //capabilities.setCapability("version", browserVersion);
        //capabilities.setCapability("platform", os);
        //this.driver = new RemoteWebDriver(new URL("localhost:4444/wd/hub"), capabilities);
        driver.navigate().to("");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void test() throws Exception{
        driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")).sendKeys("selenium");
        driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input")).click();

        String s= driver.findElement(By.xpath(".//*[@id='refinements']/div[1]")).getText();
        System.out.println(s);

        String x = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")).getAttribute("value");
        System.out.println(x);
        //Verify.verify(true, s, "Showing results in Health & Personal .");

        org.testng.Assert.assertEquals( s, "Show results for");


    }




    @AfterTest
    public void afterTest(){
        driver.close();


    }
}
