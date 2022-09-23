package practice2;

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
import java.util.List;

public class Pratic1 {

         /*
           ●https://www.amazon.com/ adresine gidin.
           -Test1
           Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
           oldugunu testedin
           -Test2
           1.Kategori menusunden Books seceneginisecin
           2.Arama kutusuna Java yazin ve aratin
           3.Bulunan sonuc sayisini yazdirin
           4.Sonucun Java kelimesini icerdigini testedin
         */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1(){
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45 oldugunu testedin
        List<WebElement> drops = driver.findElements(By.xpath("//option"));
        System.out.println("Size : "+drops.size());
        for (WebElement each : drops) {
            System.out.println(each.getText());
        }
        int dropDownList = drops.size();
        int expectedSayi = 45 ;
        Assert.assertNotEquals(dropDownList, expectedSayi);
    }
    @Test
    public void test2(){
//           1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Books");
//           2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);
//           3.Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
//           4.Sonucun Java kelimesini icerdigini testedin
        String expectedKelime = "Java";
        String actualSonucYazisi = sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

    }

}
