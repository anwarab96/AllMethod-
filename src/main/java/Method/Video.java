package Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.sikuli.api.*;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.*;
import org.sikuli.api.visual.Canvas;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by salahakanda on 3/10/15.
 */
public class Video {
    WebDriver driver=null;




    @BeforeTest
    public void Beforetest(){
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://www.youtube.com/watch?v=hutgS2pTGuc");
    }

    @Test
    public void test() throws Exception{
        ScreenRegion screenRegion = new DesktopScreenRegion();
        Target target = new ImageTarget(new File("//Users//salahakanda//Downloads//Snip20150311_3.png"));
        ScreenRegion r = screenRegion.wait(target, 80000);
        r = screenRegion.find(target);
        Canvas canvas = new DesktopCanvas();
        canvas.addBox(r);
        canvas.addLabel(r, "We found it");
        canvas.display(3);

        if (r==null){
            System.out.println("not found");
        }else {
            Mouse mouse = new DesktopMouse();
            mouse.click(r.getCenter());
        }




    }

    @AfterTest
    public void Aftertest(){
        driver.close();
    }

}
