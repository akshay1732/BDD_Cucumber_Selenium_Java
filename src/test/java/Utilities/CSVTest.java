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

        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        Reader in = new FileReader(Path);
        CSVParser parser = new CSVParser(in, CSVFormat.EXCEL.withHeader());
        List<String> headers = parser.getHeaderNames();

        for (CSVRecord row : parser) {
            Map rowmap = new HashMap<String, String>();
            for (int i = 0; i < headers.size(); i++) {
                rowmap.put(headers.get(i).trim(), row.get(i).trim());
            }
            result.add(rowmap);
        }
        //System.out.println(result.get(0));
        return result;


    }

    public static List<Map<String, String>> readusingguava(String Path) throws IOException {

        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        Reader in = new FileReader(Path);
        CSVParser parser = new CSVParser(in, CSVFormat.EXCEL.withHeader());
        List<String> headers = parser.getHeaderNames();

        for (CSVRecord row : parser) {
            Map rowmap = new HashMap<String, String>();
            for (int i = 0; i < headers.size(); i++) {
                rowmap.put(headers.get(i), row.get(i));
            }
            result.add(rowmap);
        }
        System.out.println(result.get(0) + ", " + result.get(1) + ", " + result.get(2));
        return result;
    }


    public static void writetocsv(String filepath, List<Map<String, String>> actual_result) throws IOException {

        FileWriter writer = new FileWriter(filepath);
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.EXCEL
                .withHeader(actual_result.get(0).keySet().toArray(new String[actual_result.get(0).size()])));


        for (Map m : actual_result) {
            csvPrinter.printRecord(m.values());
        }
        csvPrinter.flush();

    }


    public static void main(String[] args) throws IOException {


        /*

        read("/Users/akshay.kurale/Automation/Demo/BDD_Cucumber_Selenium_Java/src/test/resources/Sheet.csv");

        List<Map<String,String>> l1 = read("/Users/akshay.kurale/Automation/Demo/BDD_Cucumber_Selenium_Java/src/test/resources/Sheet.csv");
        List<Map<String,String>> l2 = read("/Users/akshay.kurale/Automation/Demo/BDD_Cucumber_Selenium_Java/src/test/resources/TestData.csv");

        List<Map<String, MapDifference.ValueDifference<String>>> r = new ArrayList<>();

        for(int i=0;i<l1.size();i++){

            if(l1.get(i).keySet().equals(l2.get(i).keySet())) {
                MapDifference<String, String> diff = Maps.difference(l1.get(i), l2.get(i));
                System.out.println(diff);
                Map<String, MapDifference.ValueDifference<String>> entriesDiffering = diff.entriesDiffering();

                if (entriesDiffering.size() > 0) {
                    r.add(entriesDiffering);
                }

                System.out.println("Differences: "+entriesDiffering);
            }else{

                System.out.println("headers not same");
            }
        }

        */

        FileReader reader = new FileReader("src/test/resources/Features/file.sql");
        StringBuilder text = new StringBuilder();
        int i;
        while ((i = reader.read()) != -1) {
            text = text.append((char) i);
        }
        ///String query= text.toString().trim();
        String[] queries = text.toString().trim().split(";");
        //Arrays.parallelSetAll(queries,j->queries[j].trim());
        Arrays.stream(queries).map(String::trim).toArray(trimmed -> queries);

        Arrays.stream(queries).forEach(e-> System.out.println(e));



    }
}
