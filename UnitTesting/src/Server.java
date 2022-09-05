import java.net.*;
import java.io.*;
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server comon!");
        int client=0;
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("client accept"+client++);

            BufferedWriter writer=new BufferedWriter(
                    new OutputStreamWriter(
                            socket.getOutputStream()));
            BufferedReader reader=new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            String request= reader.readLine();
            String respon=client+"You suck\n"+request.length();

            writer.write(respon);
            writer.newLine();
            writer.flush();

            writer.close();
            reader.close();
            socket.close();
    }
  //  serverSocket.close();
    }
}
