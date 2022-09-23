package day09;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class C01_Iframe {
    /*
 ● Bir class olusturun: IframeTest
 ● https://the-internet.herokuapp.com/iframe adresine gidin.
 ● Bir metod olusturun: iframeTest
    ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    ○ Text Box’a “Merhaba Dunya!” yazin.
    ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
      dogrulayin ve konsolda yazdirin
  */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        //● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        System.out.println(iframeYazisi.getText());
        //○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBox = driver.findElement(By.id("mce_0_ifr")); // Frame'e geçiş yapmadan önce orayı locate ederiz, dısını
        driver.switchTo().frame(textBox); // Locate ettiğimiz frame geçmek için bu methodu kullanırız
        WebElement textBoxFrame = driver.findElement(By.xpath("//p")); // icine yazı yazmak icin locate ettik
        textBoxFrame.clear(); // Clear methodu text box'ın içini temizler
        Thread.sleep(2000);
        textBoxFrame.sendKeys("Merhaba Dunya!");//yazimi gönderiyorum
        //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent(); // Iframe'den çıkıp ana sayfaya geçmek için bu method kullanılır
        WebElement elemantal = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemantal.isDisplayed());
        System.out.println(elemantal.getText());
    }
}

/*
- driver.switchTo() methodu ile geçilebilecek 3 farklı yapı vardır:
    1) alert
    2) iframe
    3) window (sonraki konu)

- Bir websitesi içinde farklı bir websitesi olabilir (embedded).

- Iframe genellkikle bir web sayfasına doküman, video veya interaktif medya gibi
  başka bir kaynaktan içerik eklemek için kullanılır.

- <iframe> tag'ı bir inline frame belirtir.

- iframe tagı'ı bulunan web sayfalarında locate işlemi yapabilmek için iframe'i handle etmek gerekir.

- Diğer bir deyişle, bir web sayfasında doğruluğundan emin olduğumuz bir locate işlemi varsa
  ancak bu düzgün çalışmıyorsa, SAYFADA IFRAME TAG'I BULUNUP BULUNMADIĞINI KONTROL ETMEMİZ GEREKİR.
  Bu durumda, önce iframe'i locate edip switchTo() method'u ile geçiş yapmamız gerekir.

- Bir web sayfasında iframe varsa switchTo() method'unu kullanmak gerekir.
  switchTo() method'u ile iframe'e geçmenin 3 yolu vardır:

    1) index ile
        driver.switchTo().frame(index of the iframe);   //index 0'dan başlar

    2) id veya name value ile
        driver.switchTo().frame("id of the frame");

    3) WebElement ile
        driver.switchTo().frame(WebElement of the iframe);

- iframe'den çıkmak için 2 komut vardır:

    1) driver.switchTo( ).parentFrame( ); ===> 1 ust seviyedeki frame'e cikartir

    2) driver.switchTo( ).defaultContent( ); ===> En ustteki frame'e cikmak icin kullanilir

- Birden fazla iframe varsa gecislerde dikkatli olmak lazim.
  Gecisler her zaman basit olamayabilir
 */
