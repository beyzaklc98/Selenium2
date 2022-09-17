package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase2 {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter correct email address and password
    7. Click 'login' button
    8. Verify that 'Logged in as username' is visible
    9. Click 'Delete Account' button
    10. Verify that 'ACCOUNT DELETED!' is visible
     */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
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
        // 3. Verify that home page is visible successfully
        WebElement home =driver.findElement(By.xpath("//*[@style='color: orange;']"));
        Assert.assertTrue(home.isDisplayed());
    }
    @Test
    public void test2(){
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
    }
    @Test
    public void test3(){
        // 5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount= driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(loginToYourAccount.isDisplayed());
    }
    @Test
    public void test4(){
        // 6. Enter correct email address and password
        driver.findElement(By.xpath("(//*[@name='email'])[1]")).sendKeys("beyzaklc@gmail.com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("beyza");
    }
    @Test
    public void test5(){
        // 7. Click 'login' button
        driver.findElement(By.xpath("//*[text()='Login']")).click();

    }
}
