package homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Homework3 {
    /*
    1. "https://www.saucedemo.com" Adresine gidin
    2. Username kutusuna "standard_user" yazdirin
    3. Password kutusuna "secret_sauce" yazdirin
    4. Login tusuna basin
    5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    6. Add to Cart butonuna basin
    7. Alisveris sepetine tiklayin
    8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    9. Sayfayi kapatin
     */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test() {
        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna "standard_user" yazdirin
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        //3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        System.out.println(driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).getText());
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        System.out.println("sectiğimiz ürün başarılı şekilde eklendi mi :   "
                + driver.findElement(By.className("inventory_item_name")).isDisplayed());
        //9. Sayfayi kapatin
    }
    @After
    public void tearDown() {
        driver.close();
    }
}