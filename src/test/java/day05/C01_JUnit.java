package day05;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class C01_JUnit {

    // method olusturtuk, burada junit ile testlerimizi yapabilmek icin üzerine @ annotations dedigimiz @ isaretini
    // koyuyoruz ve test yazıyoruz
    // run tusu, main method yazarsak veya test notasyonunu yazarsak cıkar.
    // JUnit ten run yaparsak buradaki bütün methodlar calisir yani aynı anda birden fazla yerin testini yapabiliriz.
    // kod calıstıktan sonra asağıda kac saniyede calıstığı ve test passed veya failed seklinde cıkar.

    @Test
    public void method1() {
        WebDriverManager.chromedriver().setup(); // kutuphaneyi alir
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @Test
    public void method2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://techproeducation.com");
    }
    @Test
    public void method3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://hepsiburada.com");
    }
}