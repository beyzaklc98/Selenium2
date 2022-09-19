package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase5 {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and already registered email address
    //7. Click 'Signup' button
    //8. Verify error 'Email Address already exist!' is visible

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1() {
        // Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[normalize-space()='Home']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());

       //6. Enter name and already registered email address
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Nida");
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("dsdfkndd@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();

        //8. Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Email Address already exist!']")).isDisplayed());
    }

}
