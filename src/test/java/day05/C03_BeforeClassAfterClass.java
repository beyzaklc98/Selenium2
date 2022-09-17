package day05;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class C03_BeforeClassAfterClass {

    /*
    BeforeClass ve AfterClass notasyonları kullanıyorsak oluşturacağımız method'u static yapmamız gerekiyor
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown() {

        driver.close();
    }

    @Test
    @Ignore
    /*
    Çalışmasını istemediğimiz test için @Ignore notasyonu kullanılır
     */
    public void method1() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://amazon.com");
    }
    @Test
    public void method2() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://techproeducation.com");
    }
    @Test
    public void method3() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://hepsiburada.com");
    }
}
// BeforeClass-AfterClass ---> BeforeClass+Test+Test+Test+AfterClass çalışıyor sırayla (toplam 5 method çalışıyor)
// Tüm testleri aynı browser'da açtı, son testten sonra browser'ı kapattı
// Before-After ---> Before+Test+After    Before+Test+After   Before+Test+After şeklinde (toplam 9 method çalışıyor)