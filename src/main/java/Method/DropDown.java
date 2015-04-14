package Method;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
    WebDriver driver = null;
    @BeforeTest
    public void before(){
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver","/Users/salahakanda/Documents/chromedriver");
        driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://www.amazon.com");
    }

    @Test
    public void dropDown(){
        WebElement element = driver.findElement(By.xpath(".//*[@id='searchDropdownBox']"));
        //List <WebElement> list = driver.findElements(By.xpath(".//*[@id='searchDropdownBox']/option"));
        Select select = new Select(element);
        List<WebElement> list = select.getOptions();
        list.get(3).click();



        System.out.println(list.size());
        for ( int i=0; i<list.size(); i++){
            if (i<list.size()){
                list.get(i).click();
                //continue;
            }

        }


    }

    @AfterTest
    public void afterTest(){
        driver.close();
    }
}
