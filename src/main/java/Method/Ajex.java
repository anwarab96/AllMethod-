package Method;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ajex {

    WebDriver driver = null;
    @BeforeTest
    public void beforeTest(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //driver.navigate().to("http://www.wgsn.com/en/events/");
        driver.navigate().to("http://www.nfl.com/");
    }
    //.//*[@id='event-list']/div[1]/div[1]/div[1]/img[1]
    //.//*[@id='event-list']/div[1]/div[2]/div[1]/img[1]

    ///html/body/div[8]/ul/li[1]
//    @Test
//    public void test() throws Exception{
//
////        String p1 = ".//*[@id='event-list']/div[1]/div[";
////        String p2;
////        String p3 = "]/div[1]/img[1]";
//        String p1 =".//*[@id='yui_3_10_3_4_1424277071583_397";
//        String p2 = "']";
//        String p3;
//
//        for (int i=111; i<999; i++){
//            p3 = p1 + i + p2;
//            //System.out.println(driver.findElement(By.xpath(p2)).getSize());
//            driver.findElement(By.xpath(p3)).click();
//            //list.get(i).click();
//            Thread.sleep(3000);
//
//        }

   // }

    @Test
    public void test(){
        //driver.findElement(By.xpath("//i[starts-with(@id,'yui')]")).click();
        driver.findElement(By.xpath("//*[id='b-nav-group-scores-single'/div/a/div/i")).click();

    }
}
