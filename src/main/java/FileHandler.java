import Objects.LoginData;

import java.io.*;
import java.util.Scanner;

public class FileHandler {
    public static LoginList readFile(String path) throws IOException {
        LoginList list = new LoginList();
        File myObj = new File(path);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] splitData = data.split(" ");
            splitData = splitData[0].split(":");
            list.list.add(new LoginData(splitData[0], splitData[1]));
        }
        myReader.close();
        return list;
    }

    public static void addAcc(File file, LoginData data) throws IOException {
        PrintWriter output = new PrintWriter(new FileWriter(file, true));
        output.printf("%s\r\n", data.username + ":" + data.password);
        output.close();
    }
}
