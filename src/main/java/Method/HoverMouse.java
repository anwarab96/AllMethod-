package Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoverMouse {

    WebDriver driver = null;
    @BeforeTest
    public  void beforeTest(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://www.healthfirst.com");
    }

    @Test
    public  void hoverMouse()  throws Exception{
        try {
            WebElement element = driver.findElement(By.cssSelector(".products"));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
            try {
                Thread.sleep(3000);
            }catch (Exception e){

            }
            List<WebElement> list = driver.findElements(By.xpath(".//*[@id='topnav']/ul/li[1]/div/div[1]/ul[1]/li"));
            System.out.println(list.size());
            for (int i=0; i<list.size(); i++){
                if (i<list.size()){
                    list.get(i).findElement(By.tagName("a")).click();
                    Thread.sleep(3000);
                }
                driver.navigate().back();
                list = driver.findElements(By.xpath(".//*[@id='topnav']/ul/li[1]/div/div[1]/ul[1]/li"));
                WebElement element1 = driver.findElement(By.cssSelector(".products"));
                Actions actions1 = new Actions(driver);
                actions1.moveToElement(element1).perform();

            }
        }catch (MoveTargetOutOfBoundsException e){
            System.out.println("Target not found " + e);

        }

    }

    @AfterTest
    public void afterTest(){
        driver.close();
    }

}
