package Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by salahakanda on 2/8/15.
 */
public class HandelWiondows {
    WebDriver driver = null;

    @BeforeTest
    public void beforeTest(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://www.jquery.com/");

    }

    @Test
    public void handelWiondows()throws Exception{


        driver.findElement(By.xpath(".//*[@id='broadcast']/a/img")).click();
        String homewindow = driver.getWindowHandle();
        Set<String> homewindow1 = driver.getWindowHandles();
        for (String hnd : homewindow1) {
            if (!hnd.equals(homewindow)) {
                driver.switchTo().window(hnd);
            }
        }

        System.out.println(driver.getTitle());
        Thread.sleep(4000);
        driver.close();
        driver.switchTo().window(homewindow);
        System.out.println(driver.getTitle());
        Thread.sleep(4000);


        List<WebElement> list = driver.findElements(By.cssSelector("#menu-top li"));
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size()) {
                list.get(i).findElement(By.tagName("a")).click();
                Thread.sleep(4000);
            }
            driver.navigate().back();
            list = driver.findElements(By.cssSelector("#menu-top li"));


        }





    }
    @AfterTest
    public  void afterTest(){
        driver.close();
    }
}
