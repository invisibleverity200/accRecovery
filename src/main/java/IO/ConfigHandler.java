/*package IO;

import Network.Websites;
import Objects.LoginDom;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigHandler {
    private static final String configPath = "config.json";
    private static Websites websites = new Websites();
    private static int i = 0;

    public static Websites getWebsites() {
        JsonParser jsonParser = new JsonParser();
        try (FileReader reader = new FileReader("employees.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

            //Iterate over employee array
            employeeList.forEach(website -> parseWebsiteObject((JSONObject) website));

            return websites;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseWebsiteObject(JSONObject employee) {
        websites.list.add(new LoginDom(null, null, null, null, null, null));
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("website");


        //Get employee first name
        String username = (String) employeeObject.get("username");
        websites.list.get(i).usernameXPath = username;
        System.out.println(username);

        //Get employee last name
        String password = (String) employeeObject.get("password");
        websites.list.get(i).passwordXPath = password;
        System.out.println(password);

        //Get employee website name
        String loginButton = (String) employeeObject.get("login Button");
        websites.list.get(i).loginXPath = loginButton;

        String message = (String) employeeObject.get("message");
        websites.list.get(i).message = message;

        JSONArray checkForList = (JSONArray) employeeObject.get("CheckFor");

        checkForList.forEach(checkFor -> parseWebsiteObject((JSONObject) checkFor));

        i++;
    }

    private static void parseCheckForObject(JSONObject employee) {
        String checkFor = (String) employee.get("checkFor");
        websites.list.get(i).checkForXPath.add(checkFor);
    }
}
*/