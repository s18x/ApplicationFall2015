package hackbulgariatasks;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DepedenciesResolving {

     public static void main(String[] args) {
        JSONParser parser = new JSONParser();
 
        try {
 
            Object obj = parser.parse(new FileReader("C:/Users/Creech/Documents/NetBeansProjects/HackBulgariaTasks/src/hackbulgariatasks/installed_modules/all_packages.txt"));
 
            JSONObject jsonObject = (JSONObject) obj;
 
            String backbone = (String) jsonObject.get("backbone");
            String jQuery = (String) jsonObject.get("jQuery");
            String underscore = (String) jsonObject.get("underscore");
 
            System.out.println("backbone: " + backbone);
            System.out.println("jQuery: " + jQuery);
            System.out.println("underscore: " + underscore);
            System.out.println("\nCompany List:");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
