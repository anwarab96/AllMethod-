package Method;


import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class IFrame {

    WebDriver driver = null;
    @BeforeTest
    public void beforeTest(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://www.characterarcade.com/");
    }

    @Test
    public void iFrame()throws Exception{


        try {
            driver.findElement(By.cssSelector(".login_btn")).click();
        }catch (ElementNotFoundException e){
            System.out.println("Element not found " + e);
        }

        try {
            WebElement element =  driver.findElement(By.cssSelector("#surf-xdm iframe:nth-child(1)"));
            driver.switchTo().frame(element);
        } catch (NoSuchElementException e){
            System.out.println("No such element" + e);
        }

        WebElement element1 = driver.findElement(By.cssSelector("#display-frame"));
        driver.switchTo().frame(element1);
        driver.findElement(By.cssSelector("#input_username")).sendKeys("sldh");


    }

    @AfterTest
    public  void afterTest(){
        driver.close();
    }
}
