package com;

import java.net.*;
import java.io.*;
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("com.Server comon!");
        int client = 0;
        int tests = 3;
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("client accept" + client++);

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));
            String respon = " vvedi chislo ot 0 do 8\n";
            writer.write(respon);
            writer.newLine();
            writer.flush();
            int request = Integer.parseInt(reader.readLine());
            String resp = reader.readLine();
            System.out.println(request);
            System.out.println(resp);
            if (request != tests) {
                String responded = " try again\n";
                writer.write(responded);
                writer.newLine();
                writer.flush();


                String respo = " you win\n";
                writer.write(respo);
                writer.newLine();
                writer.flush();
                writer.close();
                reader.close();
                socket.close();


            }


        }


    }
}
