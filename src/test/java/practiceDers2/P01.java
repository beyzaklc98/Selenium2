package practiceDers2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBaseBeforeAfter {

    // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    // ikinci emojiye tıklayın (hayvan emojisini seçin)
    // tüm hayvan emojilerine tıklayın
    // formu doldurun (dilediğinizi yazabilirsiniz)
    // apply butonuna tıklayın


    @Test
    public void test() throws InterruptedException {

        // 1)go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        //2) ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iframe= driver.findElement(By.xpath("//iframe[@id='emoojis']")); //ikinci hayvani icin locate ettim tıkladık
        driver.switchTo().frame(iframe);//iframe de bulundukarı icin iframe e gecis yapıyorum.
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click(); //ikinci hayvana tıkladım
        //3) tüm hayvan emojilerine tıklayın
        /*
        //emoji locate ini aldığımızda web sayfasında bulunan tüm emojileri döndüürdü ama test cesa bezdin sadece animal emojilerinin
        //locaterlarını istiyor, bunun icin parent child iliskisi oldugundan parent class in locate ini alıp listeyi buradan alacağız
        //parentten child a basamak basamak gittik ve 64 tane locate i aldık
        //parentten child a giderken araya /div (child) /img basamak basamak gidiyoruz. koyuyoruz
        //  /div yazmazsak // iki tane ile //img yazabiliriz.
        */
        List<WebElement> animals= driver.findElements(By.xpath("div[@class='mdl-tabs__panel is-active']/div/img"));
        //"//div[3]//img"
        //tamamını liste attım.
        for (WebElement w:animals) { //w ile tüm listeyi gezip
            w.click(); //tıklıyorum
            //LAMBDA ILE----- animals.forEach(t->t.click());
        }
        driver.switchTo().defaultContent(); //doldurmadan önce Iframe den cıkmalıyız.
        // formu doldurun (dilediğinizi yazabilirsiniz)
        List<WebElement> textBox=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        //tüm textBox ları bir liste koydum.
        //bu listimde 11 tane textbox um var
        List<String> text=new ArrayList<>(Arrays.asList("bu","listi","kullanarak","her","bir","webelementi","kolayca","boxes","listinde","yazacağız","okay"));
        //text göndereceğim icin string list olusturdum.
        //bu listimde de 11 tane yazacağım stringim var.
        //bu listi kullanarak her bir web elementi kolayca boxes listinde bulunan web elementlerimize gönderebileceğiz.
        //simdi bir for loop olusturum her bir yazımı (String listim) tek tek textime(WebElement listime) göndereceğim
        for (int i = 0; i <textBox.size() ; i++) {//boxun size ına kadar gel diyorum.
            textBox.get(i).sendKeys(text.get(i));//birinci boxa textin (stringimi)birinci indexini koydum yani 0. indexten baslayacak.
            //ve loopta dönerek tamamını dolduracak.
        }


        //apply butonuna tıklayınız.
        driver.findElement(By.xpath("//button[@id='send']")).click();
    }
}

