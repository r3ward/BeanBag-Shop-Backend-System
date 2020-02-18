import java.io.*;
public class CheckedApp {
    public static void main(String[] args) {
        String fileName = "rooms.txt";
        readTxtFile(fileName);
        System.out.println("Finish");
    }

    public static void readTxtFile(String fileName) {
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
