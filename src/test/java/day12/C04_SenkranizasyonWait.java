package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;
import java.time.Duration;
public class C04_SenkranizasyonWait extends TestBaseBeforeAfter {
    @Test
    public void isEnabletest1() {
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());
        //Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        //“It’s enabled!” mesajinin goruntulendigini dogrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
        //Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textBox.isEnabled());
    }
}
// Selenium'da Senkronizasyonu nasıl sağlarız?
// Waitler ile 3 çeşit Wait Vardır.
// 1) Thread.sleep(3000);  Java tabanlı waittir. Kodları yazılan süre kadar bekler,Süre dolduktan sonra alt satıra geçer.

// 2) İmplicitlyWait: Selenium tabanlı waittir.  Sayfadaki tüm öğeler için global bir zaman aşımıdır.(timeout)
//  Arkadaşım 10 dakika içinde gelirse beraber gideriz, 10 dakikadan önce gelirse yine beraber gideriz, 10 dakika içinde gelmezse ben eve dönerim. :) İmplicitlyWait
// Her işlem için tanıdığımız süre kadar bekler, işlem daha önce biterse devam eder.
// Bekle dediğimiz sürece bulamazsa "NoSuchElemtExeption" hatasını verir.

// Not : Implicitlywait ile çözülebilecek durumlar için, explicitlyWait kullanıma ihtiyaç yoktur.

// 3) ExplicitWait: Selenium tabanlı waittir. Çoğunlukla belirli öğeler için belirli bir koşul(expected condition) için kullanılır.
// Arkadaşın gelene kadar bekle, gelince beraber gidin. Dosya indirilinceye kadar bekle.
// WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
// WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));