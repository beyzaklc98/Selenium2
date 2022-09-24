package homework6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class homework3 {

    /*
    Test01
    1-amazon gidin
    2-Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
    3-dropdown menude 40 eleman olduğunu doğrulayın

    Test02
    1-dropdown menuden elektronik bölümü seçin
    2-arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
    3-sonuc sayisi bildiren yazinin iphone icerdigini test edin
    4-ikinci ürüne relative locater kullanarak tıklayin
    5-ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim

    Test03
    1-yeni bir sekme açarak amazon anasayfaya gidin
    2-dropdown’dan bebek bölümüne secin
    3-bebek puset aratıp bulundan sonuç sayısını yazdırın
    4-sonuç yazsının puset içerdiğini test edin
    5-üçüncü ürüne relative locater kullanarak tıklayin
    6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin

    Test04
    1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
     */
    WebDriver driver;
    @Before
    public void setup(){
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
    public void test1(){
        // 1-amazon gidin
        driver.get("https://amazon.com");
        // 2-Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        WebElement dropDownMenu=driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDownMenu);
        List<WebElement> dropList=select.getOptions();
        for (WebElement each:dropList ) {
            System.out.println(each.getText());
        }
        // 3-dropdown menude 40 eleman olduğunu doğrulayın
    }



}
