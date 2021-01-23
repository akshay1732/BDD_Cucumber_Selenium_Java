package com.qa.utilities;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Testbase {



    public WebDriver driver;
    public static int implicitwaittime=30;
    public static int pageloadtime=30;
    public static Properties prop;


    public void setup() throws IOException {


        FileInputStream fin = new FileInputStream("C:\\Users\\Akshay\\IdeaProjects\\BDDCucumberProject\\src\\main\\java\\com\\qa\\config\\config.properties");
        prop = new Properties();
        prop.load(fin);
        driver.manage().timeouts().implicitlyWait(implicitwaittime, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageloadtime,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("appurl"));

    }

    public WebDriver getdriverinstance(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Akshay\\IdeaProjects\\BDDCucumberProject\\src\\main\\java\\com\\qa\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
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
