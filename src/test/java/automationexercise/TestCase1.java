package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase1 {

     /*
        1. Tarayıcıyı başlatın
        2. 'http://automationexercise.com' url'sine gidin
        3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        6. Adı ve e-posta adresini girin
        7. 'Kaydol' düğmesini tıklayın
        8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        13. 'Hesap Oluştur düğmesini' tıklayın
        14. 'HESAP OLUŞTURULDU!' görünür
        15. 'Devam' düğmesini tıklayın
        16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        17. 'Hesabı Sil' düğmesini tıklayın
        18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın
     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void testCase1() throws InterruptedException {

        // 2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.cssSelector("img[alt='Website for automation practice']")).isDisplayed());

        // 4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        // 5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        System.out.println(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());

        // 6. Adı ve e-posta adresini girin
        WebElement name=driver.findElement(By.xpath("//*[@name='name']"));
        name.sendKeys("baaa");
        WebElement ePosta=driver.findElement(By.xpath("(//*[@type='email'])[2]"));
        ePosta.sendKeys("xbb@gmail.com");

        // 7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Signup']")).click();
        //'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        WebElement enterAccountInformation = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        System.out.println("Enter Account Information displayed test "+enterAccountInformation.isDisplayed());

        // 8. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        WebElement title = driver.findElement(By.xpath("//*[text()='Title']"));
        Thread.sleep(2000);

        // password
        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
        password.sendKeys("12345678");
        Thread.sleep(2000);

        // day
        WebElement day = driver.findElement(By.xpath("//*[@id='days']"));
        day.sendKeys("2");
        Thread.sleep(2000);

        // month
        WebElement month =driver.findElement(By.xpath("//*[@id='months']"));
        month.sendKeys("December");
        Thread.sleep(2000);

        // year
        WebElement year = driver.findElement(By.xpath("//*[@id='years']"));
        year.sendKeys("2022");
        Thread.sleep(2000);

        // 9. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası

        // First name
        driver.findElement(By.xpath("//*[@name='first_name']")).sendKeys("Beyza");
        Thread.sleep(2000);

        // Last name
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("Kılıç");
        Thread.sleep(2000);

        // Company
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("x");
        Thread.sleep(2000);

        // Address(Street address, P.O. Box, Company name, etc.)
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("Techproeducation company");
        Thread.sleep(2000);

        // Country
        driver.findElement(By.xpath("//*[@id='country']")).sendKeys("Canada");

        // State
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("TC");

        // City
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("EDMONTON");

        // Zipcode
        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("C0A");

        // Mobile Number
        driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys("+1-780");

        //'Hesap Oluştur düğmesini' tıklayın    //*[text()='Create Account']
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();


        //'HESAP OLUŞTURULDU!' görünür    //*[text()='Account Created!']
        WebElement created = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        System.out.println("Hesap Olusturuldu TEST -> " + created.isDisplayed());

        //'Devam' düğmesini tıklayın  //*[text()='Continue']
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

        //'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        String expectedLoggedIn =driver.findElement(By.xpath("//*[text()=' Logged in as ']")).getText();
        System.out.println(expectedLoggedIn);
        WebElement expextedLog = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        System.out.println(" Kullanici adi ile giris yapildi -> " + expextedLog.isDisplayed());

        // 'Hesabı Sil' düğmesini tıklayın  TODO
        driver.findElement(By.xpath("(//*[@style='color:brown;'])[2]")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[text()='DELETE']")).click();
        //Thread.sleep(2000);

        // 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın TODO



    }
}







