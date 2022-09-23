package practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Pratik1 {

    /*
    Bir class oluşturun : RadioButtonTest
    Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    https://www.facebook.com adresine gidin
    Cookies’i kabul edin
    “Create an Account” button’una basin
    “radio buttons” elementlerini locate edin
    Secili degilse cinsiyet butonundan size uygun olani secin
     */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://www.facebook.com");
    }

    @AfterClass
    public static void tearDown(){
    //driver.close();
    }

    @Test
    public void test1(){
        // Cookies’i kabul edin
        //“Create an Account” button’una basin
        driver.findElement(By.xpath("(//*[@class='_6ltg'])[2]")).click();
    }

    @Test
    public void test2(){
        //“radio buttons” elementlerini locate edin
        // Secili degilse cinsiyet butonundan size uygun olani secin
        WebElement femaleButton=driver.findElement(By.xpath("(//*[@class='_58mt'])[1]"));
        WebElement maleButton= driver.findElement(By.xpath("//*[text()='Male']"));
        WebElement customButton= driver.findElement(By.xpath("(//*[@class='_58mt'])[3]"));
        if(!maleButton.isSelected()){
            maleButton.click();

        }

    }

}
