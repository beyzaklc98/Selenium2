package homework9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ReadExcel {

    // 1.satirdaki 2.hucreye gidelim ve yazdiralim
    // 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
    // 2.satir 4.cell'in afganistan'in baskenti oldugunu test edelim
    // Satir sayisini bulalim
    // Fiziki olarak kullanilan satir sayisini bulun
    // Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

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
        driver.close();
    }
    @Test
    public void test() throws IOException {
        String filePath = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        // 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString());

        // 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String actualData1 = workbook.getSheet("Sayfa1").getRow(0).getCell(2).toString();

        // 2.satir 4.cell'in afganistan'in baskenti oldugunu test edelim
        String actualData2 = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedAfganistanBaskent = "Kabil";
        Assert.assertEquals(actualData2,"Kabil");
        // Satir sayisini bulalim
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum()); // 190
        // Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows()); // 191

        // Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Sheet sheet = workbook.getSheet("Sayfa1");
        int rowCount = sheet.getLastRowNum();
        Map<String, String> mapList = new LinkedHashMap<>();
        for (int i = 0; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            Cell keyCell = row.getCell(0);
            String key = keyCell.getStringCellValue();
            Cell valuCell = row.getCell(1);
            String value = valuCell.getStringCellValue();
            mapList.put(key, value);
        }
        //alt alta yazdirmak icin
        Set<Map.Entry<String, String>> entryList = mapList.entrySet();
        entryList.forEach(System.out::println);
    }
}