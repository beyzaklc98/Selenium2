package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase6 {

    // 1. Launch browser
    // 2. Navigate to url 'http://automationexercise.com'
    // 3. Verify that home page is visible successfully
    // 4. Click on 'Contact Us' button
    // 5. Verify 'GET IN TOUCH' is visible
    // 6. Enter name, email, subject and message
    // 7. Upload file
    // 8. Click 'Submit' button
    // 9. Click OK button
    // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    // 11. Click 'Home' button and verify that landed to home page successfully
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test(){
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@style='color: orange;']")).isDisplayed());
        // 4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[@href='/contact_us']")).click();
        // 5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='title text-center'])[2]")).isDisplayed());
        // 6. Enter name, email, subject and message
        WebElement name =driver.findElement(By.xpath("//*[@name='name']"));
        name.sendKeys("beyza");
        WebElement email =driver.findElement(By.xpath("(//*[@class='form-control'])[2]"));
        email.sendKeys("b@gmail.com");
        WebElement subject =driver.findElement(By.xpath("//*[@name='subject']"));
        subject.sendKeys("konu");
        WebElement message  =driver.findElement(By.xpath("//*[@id='message']"));
        message.sendKeys("mesaj");
        // 7. Upload file
        WebElement uploadFile = driver.findElement(By.cssSelector("input[type='file']"));

        // 8. Click 'Submit' button

        // 9. Click OK button
        // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        // 11. Click 'Home' button and verify that landed to home page successfully
    }

}
