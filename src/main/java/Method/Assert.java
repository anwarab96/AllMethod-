package Method;

//import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class Assert {
    WebDriver driver = null;

    @BeforeTest
    public void beforeTest(){
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://www.amazon.com");
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
