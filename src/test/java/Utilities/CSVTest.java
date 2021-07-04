package Utilities;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.*;


public class CSVTest {



    public static List<Map<String, String>> read(String Path) throws IOException {

        List<Map<String,String>> result = new ArrayList<Map<String,String>>();
        Reader in = new FileReader(Path);
        CSVParser parser = new CSVParser(in, CSVFormat.EXCEL.withHeader());
        List<String> headers = parser.getHeaderNames();

        for(CSVRecord row:parser){
        Map rowmap = new HashMap<String,String>();
             for(int i=0;i<headers.size();i++){
                 rowmap.put(headers.get(i),row.get(i));
             }
             result.add(rowmap);
        }
        System.out.println(result.get(0)+", "+result.get(1)+", "+result.get(2));
        return result;
    }

    public static List<Map<String, String>> readusingguava(String Path) throws IOException {

        List<Map<String,String>> result = new ArrayList<Map<String,String>>();
        Reader in = new FileReader(Path);
        CSVParser parser = new CSVParser(in, CSVFormat.EXCEL.withHeader());
        List<String> headers = parser.getHeaderNames();

        for(CSVRecord row:parser){
            Map rowmap = new HashMap<String,String>();
            for(int i=0;i<headers.size();i++){
                rowmap.put(headers.get(i),row.get(i));
            }
            result.add(rowmap);
        }
        System.out.println(result.get(0)+", "+result.get(1)+", "+result.get(2));
        return result;
    }


    public static void writetocsv(String filepath, List<Map<String,String>> actual_result) throws IOException {

        FileWriter writer = new FileWriter(filepath);
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.EXCEL
                .withHeader(actual_result.get(0).keySet().toArray(new String[actual_result.get(0).size()])));


         for(Map m:actual_result) {
             csvPrinter.printRecord(m.values());
         }
        csvPrinter.flush();

    }



    public static void main(String[] args) throws IOException {

        /*
        read("/Users/akshay.kurale/Automation/Demo/BDD_Cucumber_Selenium_Java/src/main/resources/TestData.csv");

        Map<String, String> asia1 = new HashMap<String, String>();
        asia1.put("Japan", "Tokyo");
        asia1.put("South Korea", "Seoul");
        asia1.put("India", "New Delhi");
        Map<String, String> asia2 = new HashMap<String, String>();
        asia2.put("Japan", "Tokyo");
        asia2.put("China", "Beijing");
        asia2.put("India", "Delhi");
        MapDifference<String, String> diff = Maps.difference(asia1, asia2);
        Map<String, MapDifference.ValueDifference<String>> entriesDiffering = diff.entriesDiffering();
        //System.out.println(entriesDiffering);

        Map m1 = new HashMap();
        m1.put("ID", "01");
        m1.put("Name", "Akshay");
        m1.put("Designation", "Pro");
        m1.put("Company", "Globant");
        List<Map<String, String>> actual_result = new ArrayList<Map<String, String>>();
        actual_result.add(m1);

        writetocsv("/Users/akshay.kurale/Automation/Demo/BDD_Cucumber_Selenium_Java/src/main/resources/Create.csv", actual_result);

        String expectedvalue = "null";
        String actualvalue = null;

        System.out.println("Method One");

        if (expectedvalue != null && actualvalue != null) {
            if (!(actualvalue.equals(expectedvalue))) {
                System.out.println("1. Expected: " + expectedvalue + " Actual :" + actualvalue);
            }

        } else if (expectedvalue == null && actualvalue != null) {

            if (!(actualvalue.equals(expectedvalue))) {
                System.out.println("2. Expected: " + expectedvalue + " Actual :" + actualvalue);
            }
        } else if (expectedvalue != null && actualvalue == null) {

            if (!(expectedvalue.equals(actualvalue))) {
                System.out.println("3. Expected: " + expectedvalue + " Actual :" + actualvalue);
            }
        }

        System.out.println("\n\nMethod Two");
        if (expectedvalue != null && actualvalue != null) {
            if (!(actualvalue.equals(expectedvalue))) {

                System.out.println("1. Expected: " + expectedvalue + " Actual :" + actualvalue);
            }
        } else if (!(actualvalue == expectedvalue)) {

            System.out.println("2. Expected: " + expectedvalue + " Actual :" + actualvalue);
        }

         */




    }

}
