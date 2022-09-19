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

public class TestCase4 {

    // 1. Launch browser
    // 2. Navigate to url 'http://automationexercise.com'
    // 3. Verify that home page is visible successfully
    // 4. Click on 'Signup / Login' button
    // 5. Verify 'Login to your account' is visible
    // 6. Enter correct email address and password
    // 7. Click 'login' button
    // 8. Verify that 'Logged in as username' is visible
    // 9. Click 'Logout' button
    // 10. Verify that user is navigated to login page

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test1(){
        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.cssSelector("a[style='color: orange;']")).isDisplayed());
    }
    @Test
    public void test2(){
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
    }
    @Test
    public void test3(){
        // 5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());
    }
    @Test
    public void test4(){
        // 6. Enter correct email address and password
        driver.findElement(By.xpath("(//*[@name='email'])[1]")).sendKeys("zzz@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456789");
    }
    @Test
    public void test5(){
        // 7. Click 'login' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
    }
    @Test
    public void test6(){
        // 8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());
    }
    @Test
    public void test7(){
        // 9. Click 'Logout' button
        driver.findElement(By.xpath("(//*[@style='color:brown;'])[1]")).click();
    }
    @Test
    public void test8(){
        // 10. Verify that user is navigated to login page
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='login-form'] h2")).isDisplayed());

    }
}
