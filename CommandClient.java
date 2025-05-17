import java.io.*;
import java.net.*;

public class CommandClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            out.println("notepad");
            System.out.println("■ コマンド送信: notepad");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
