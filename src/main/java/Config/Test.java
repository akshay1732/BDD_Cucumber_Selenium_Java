package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Test {

        public static void main(String args[]) throws IOException {
            HashMap<String,String> map=new HashMap<String,String>();
            //Creating HashMap
            map.put("1","Mango");  //Put elements in Map
            map.put("2","Apple");
            map.put("3","Banana");
            map.put("1","Grapes"); //trying duplicate key

            Properties prop = new Properties();
            FileInputStream fin = new FileInputStream("C:\\Users\\Akshay\\IdeaProjects\\BDDCucumberProject\\src\\main\\java\\com\\qa\\config\\config.properties");
            prop.load(fin);

            System.out.println(prop.getProperty("Username"));

            System.out.println("Iterating Hashmap...");
            for(Map.Entry m : map.entrySet()){
                System.out.println(m.getKey()+" "+m.getValue());
            }
        }

}
