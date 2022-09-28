package day16;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;
import java.io.File;
import java.io.IOException;

public class C01_GetScreenShotWE extends TestBaseBeforeAfter {

    @Test
    public void test1() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Nutelle aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        //Arama sonuc yazısının resmini alalım
        WebElement aramaSonucu = driver.findElement
                (By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutellaAramaSonucu = aramaSonucu.getScreenshotAs(OutputType.FILE);
        //Sadece Web elementin resmini alacaksak TakeScreenShot classını kullanmama gerek yok
        //Locate ettiğimiz webelementi direk geçici bir file'a atıp FileUtils ile kopyalayıp yolunu(path) belirtiriz
        FileUtils.copyFile(nutellaAramaSonucu,new File("target/ekranGoruntusuWE/WebESS"+tarih+".jpeg"));
    }
}