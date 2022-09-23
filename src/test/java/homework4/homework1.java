package homework4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class homework1 {

    //●Bir class olusturun:IframeTest02
    //1)"http://demo.guru99.com/test/guru99home/"sitesine gidiniz
    //2)sayfadaki iframe sayısınıbulunuz.
    //3)ilk iframe'deki (Youtube) play butonunatıklayınız.
    //4)ilk iframe'den çıkıp ana sayfayadönünüz
    //5)ikinci iframe'deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html) tıklayınız

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
    public void test(){
        //1)"http://demo.guru99.com/test/guru99home/"sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2)sayfadaki iframe sayısınıbulunuz.
        List<WebElement> iframeList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        System.out.println(iframeList.size());
        //3)ilk iframe'deki (Youtube) play butonunatıklayınız.
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@width='560']")));
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
        //4)ilk iframe'den çıkıp ana sayfayadönünüz
        driver.switchTo().defaultContent();
        //5)ikinci iframe'deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html) tıklayınız
        driver.switchTo().frame(driver.findElement(By.id("a077aa5e")));
        driver.findElement(By.cssSelector("img[src='Jmeter720.png']")).click();
    }
}
