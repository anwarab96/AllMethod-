package Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinkList {

    WebDriver driver = null;
    @BeforeTest
    public  void  beforeTest(){
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/salahakanda/Documents/chromedriver");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //driver.navigate().to("http://www.healthfirst.com");
//        driver.navigate().to("http://www.wgsn.com");
        driver.navigate().to("http://www.amazon.com");
    }

    @Test
    public void linkList() throws Exception{
//        List<WebElement> list = driver.findElements(By.tagName("a"));
//        System.out.println(list.size());
//        for (int i=0; i<list.size(); i++){
//            System.out.println(list.get(i).getAttribute("href"));
//
//        }

        List<WebElement> list = driver.findElements(By.cssSelector("#nav-cross-shop"));
       System.out.println(list.size());
        for (int i=0; i<list.size(); i++){

            list.get(i).findElement(By.tagName("a")).click();
            Thread.sleep(3000);
        }
        driver.navigate().back();
        list = driver.findElements(By.cssSelector("#nav-cross-shop"));


    }


    @AfterTest
    public  void afterTest(){
        driver.close();
    }
}
