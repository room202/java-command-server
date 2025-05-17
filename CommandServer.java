import java.io.*;
import java.net.*;

public class CommandServer {

    public static void main(String[] args) {
        int port = 5000; // 任意のポート

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("■ サーバー起動中... ポート: " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("■ クライアント接続: " + clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String command = in.readLine();
                System.out.println("■ 受信したコマンド: " + command);

                if (command != null && !command.isEmpty()) {
                    // メモ帳などを起動
                    ProcessBuilder builder = new ProcessBuilder(command);
                    builder.start();
                    System.out.println("■ コマンド実行: " + command);
                }

                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
