package Utilities;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Testbase {

    //test
    public static String remote_url_chrome = "http://localhost:4445/wd/hub";
    public WebDriver driver;
    public static int implicitwaittime=40;
    public static int pageloadtime=30;
    public static Properties prop;


    public void setup() throws IOException {

        //testing pipeline
        FileInputStream fin = new FileInputStream("src/test/java/Config/config.properties");
        prop = new Properties();
        prop.load(fin);
        driver.manage().timeouts().implicitlyWait(implicitwaittime, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageloadtime,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("appurl"));

    }

    public WebDriver getdriverinstance() {
        System.setProperty("webdriver.chrome.driver","src/test/java/Drivers/chromedriver_Mac");

        try {
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            driver = new ChromeDriver(options);
           // driver = new RemoteWebDriver(new URL(remote_url_chrome), options);
        }catch(Exception e){

        }
        return driver;
    }



    public static List<Map> readexcel() throws IOException {

        FileInputStream fin = new FileInputStream("D:\\Book1.xls");
        Workbook wb  = new HSSFWorkbook(fin);
        Sheet sheet = wb.getSheet("Sheet1");


        List<String> Headers =new ArrayList<String>();
        Row headerrow = sheet.getRow(0);
        for(int i=0;i<headerrow.getLastCellNum();i++) {
            Headers.add(headerrow.getCell(i).getStringCellValue());
        }

        List<Map> table = new ArrayList<Map>();
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();



            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                HashMap<String,String> data= new HashMap<String,String>();
                for(int i=0;i<row.getLastCellNum();i++) {

                    data.put(Headers.get(i),row.getCell(i).getStringCellValue());

                }
                table.add(data);
            }

        return table;
        }


    public void destroy(){
        driver.quit();
    }
}
