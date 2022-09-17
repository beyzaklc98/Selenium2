package homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Homework2 {
    /*
    1-C01_TekrarTesti isimli bir class olusturun
    2- https://www.google.com/ adresine gidin
    3- cookies uyarisini kabul ederek kapatin
    4-Sayfa basliginin "Google" ifadesi icerdigini test edin
    5- Arama cubuguna "Nutella" yazip aratin
    6-Bulunan sonuc sayisini yazdirin
    7- sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
    8-Sayfayi kapatin
     */
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test() {

        //2- https://www.google.com/ adresine gidin
        driver.get("https://google.com");

        //3- cookies uyarisini kabul ederek kapatin
        //4-Sayfa basliginin "Google" ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title testi PASSED");
        } else System.out.println("Title testi FAILED");

        //5- Arama cubuguna "Nutella" yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("Nutella", Keys.ENTER);

        //6-Bulunan sonuc sayisini yazdirin
        WebElement aramaSonuc = driver.findElement(By.xpath("//*[text()='Yaklaşık 106.000.000 sonuç bulundu']"));
        String[] arr = aramaSonuc.getText().split(" ");
        System.out.println(arr[1]);

        //7- sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        int sonuc = Integer.parseInt(arr[1].replaceAll("\\D", ""));
        if (sonuc > 10000000) {
            System.out.println("10 milyondan fazla sonuc var");
        } else System.out.println("Failed");
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }
}