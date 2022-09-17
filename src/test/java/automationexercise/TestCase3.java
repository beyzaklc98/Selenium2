package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase3 {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter incorrect email address and password
    7. Click 'login' button
    8. Verify error 'Your email or password is incorrect!' is visible
     */

    static WebDriver driver;
    @BeforeClass
        public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationexercise.com");
    }
    @AfterClass
    public static void tearDown(){
        //driver.close();
    }
    @Test
    public void test1(){
        // Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@style='color: orange;']")).isDisplayed());

    }
    @Test
    public void test2(){
        // Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
    }
    @Test
    public void test3(){
        // Verify 'Login to your account' is visible
        //WebElement loginToYourAccount =driver.findElement(By.xpath("//*[text()='Login to your account']"));
        //Assert.assertTrue(loginToYourAccount.isDisplayed());
    }


}
