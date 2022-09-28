package homework8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
public class homework1 {

    /*
Bir class oluşturun : D18_WebTables
1- login( ) metodun oluşturun ve oturum açın.
2- https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
    Username : manager  ○ Password : Manager2!
3- table( ) metodu oluşturun
4- Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
5- Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
6- printRows( ) metodu oluşturun //tr
7- table body’sinde bulunan toplam satir(row) sayısını bulun.
8- Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
9- 4.satirdaki(row) elementleri konsolda yazdırın.
10- printCells( ) metodu oluşturun //td
11- table body’sinde bulunan toplam hücre(cell) sayısını bulun.
12- Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
13- printColumns( ) metodu oluşturun
14- table body’sinde bulunan toplam sutun(column) sayısını bulun.
15- Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
16- 5.column daki elementleri konsolda yazdırın.
 */
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown() throws Exception {
        //driver.close();
    }
    @Test
    public void test() throws Exception {
        //1
        login();
        //3
        table();
        //6
        printRows();
        //10
        printcells();
        //13
        printColumns();
    }
    private void login() {
        //Bir class oluşturun : D18_WebTables
        //1- login( ) metodun oluşturun ve oturum açın.
        //2- https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        //    Username : manager  ○ Password : Manager2!
        driver.get("https://www.concorthotel.com/admin/HotelRoomAdmin");
        driver.findElement(By.cssSelector("input#UserName")).sendKeys("manager");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("Manager1!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    private void table() {
        //3- table( ) metodu oluşturun
        //4- Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//th"));
        System.out.println("Sutun Sayisi : " + sutunSayisi.size() + " adettir");
        System.out.println("\n");
        //5- Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        List<String> basliklar = List.of(driver.findElement(By.xpath("//thead//tr")).getText().split(" "));
        basliklar.stream().forEach(t-> System.out.print(t + " "));
        System.out.println("\n");
    }
    private void printRows() {
        //6- printRows( ) metodu oluşturun //tr
        //7- table body’sinde bulunan toplam satir(row) sayısını bulun.

        List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir Sayisi : " + satirSayisi.size());
        System.out.println("\n");
        //8- Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        List<String> satirBilgileri = List.of(driver.findElement(By.xpath("//tbody")).getText().split(","));
        satirBilgileri.stream().forEach(t-> System.out.print(t));
        System.out.println("\n");
        //9- 4.satirdaki(row) elementleri konsolda yazdırın.
        List<String> dorduncuSatir = List.of(driver.findElement(By.xpath("//tbody//tr[4]")).getText().split(","));
        dorduncuSatir.stream().forEach(t-> System.out.print(t));
        System.out.println("\n");
    }
    private void printcells() {
        //10- printCells( ) metodu oluşturun //td
        //11- table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> hucreSayisi = driver.findElements(By.xpath("//tbody//td"));
        System.out.println("Hucre Sayisi : " + hucreSayisi.size());
        System.out.println("\n");
        //12- Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        List<String> hucreButun = List.of(driver.findElement(By.xpath("//tbody")).getText().split(","));
        hucreButun.stream().forEach(t-> System.out.print(t + " "));
        System.out.println("\n");
    }
    private void printColumns() {
        //13- printColumns( ) metodu oluşturun
        //14- table body’sinde bulunan toplam sutun(column) sayısını bulun. 4 un aynisi
        List<WebElement> toplamSutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Body Toplam Sutun Sayisi : " + toplamSutunSayisi.size());
        System.out.println("\n");
        //15- Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        toplamSutunSayisi.forEach(t -> System.out.print(t.getText() + " "));
        System.out.println("\n");
        //16- 5.column daki elementleri konsolda yazdırın.
        List<WebElement> besinciColumnYazilari = driver.findElements(By.xpath("//tbody//td[5][1]"));
        besinciColumnYazilari.forEach(t-> System.out.print(t.getText() + " "));
    }
    /*
    Sutun Sayisi : 9 adettir
    Id IDHotel Code Name Location Price IDGroupRoomType IsAvailable Actions
    Satir Sayisi : 10
    13 Sawyer B. Hind 10151 ALba Hotel Romania 51100.00 Double DETAILS
    15 emrah 111 T1 Agri 200.00 Single DETAILS
    16 yusufahmetportakal 1005 Happy Hotel USA 700.00 Single DETAILS
    19 asdf 1001 asdf izmir 200.00 Single DETAILS
    21 yusufahmetportakal 1 gamze ITALY 700.00 Single DETAILS
    22 Cizgi Dusler Hotel 3900 gonca ITALY 700.00 Queen DETAILS
    24 Cizgi Dusler Hotel 3900 gonca ITALY 700.00 Queen DETAILS
    28 yusufahmetportakal 202002 Pirlanta Akyaka Mugla 400.00 Triple DETAILS
    29 Test1002 Hotel 234 veli Austin 700.00 Queen DETAILS
    31 NT-Team Hotel 5678 Guzelbahce Austin 500.00 Double DETAILS
    19 asdf 1001 asdf izmir 200.00 Single DETAILS
    Hucre Sayisi : 90
    13 Sawyer B. Hind 10151 ALba Hotel Romania 51 100.00 Double DETAILS
    15 emrah 111 T1 Agri 200.00 Single DETAILS
    16 yusufahmetportakal 1005 Happy Hotel USA 700.00 Single DETAILS
    19 asdf 1001 asdf izmir 200.00 Single DETAILS
    21 yusufahmetportakal 1 gamze ITALY 700.00 Single DETAILS
    22 Cizgi Dusler Hotel 3900 gonca ITALY 700.00 Queen DETAILS
    24 Cizgi Dusler Hotel 3900 gonca ITALY 700.00 Queen DETAILS
    28 yusufahmetportakal 202002 Pirlanta Akyaka Mugla 400.00 Triple DETAILS
    29 Test1002 Hotel 234 veli Austin 700.00 Queen DETAILS
    31 NT-Team Hotel 5678 Guzelbahce Austin 500.00 Double DETAILS
    Body Toplam Sutun Sayisi : 9
    Id IDHotel Code Name Location Price IDGroupRoomType IsAvailable Actions

    Romania Agri USA izmir ITALY ITALY ITALY Akyaka Mugla Austin Austin
     */
}



