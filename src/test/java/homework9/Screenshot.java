package homework9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Screenshot {

     /*
    Yeni bir class olusturun : amazonNutellaSearch
    1- amazon anasayfaya gidin
    2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
    3- Nutella icin arama yapin
    4- sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test() throws IOException {
        // 1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // 2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(formater);
        FileUtils.copyFile(tumSayfaResmi, new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));
        // 3- Nutella icin arama yapin
        WebElement nutella = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        nutella.sendKeys("Nutella", Keys.ENTER);
        // 4- sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
        WebElement sonuc = driver.findElement(By.xpath("//*[text()='Nutella']"));
        Assert.assertTrue(sonuc.getText().contains("Nutella"));

        TakesScreenshot ts1=(TakesScreenshot) driver;
        WebElement logoElement=driver.findElement(By.xpath("//*[@data-image-index='1']"));
        File logo=logoElement.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(logo,new File ("target/nutella/element.jpeg"));


    }

}
