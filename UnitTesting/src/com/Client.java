package com;

import java.io.*;
import java.net.*;


public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8000);


        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));

        String respons = reader.readLine();
        System.out.println(respons);



            for (int i=1;i<5;i++){

                String ss= String.valueOf(i);
                writer.write(ss);
                writer.newLine();
                writer.flush();
                String res=reader.readLine();
                System.out.println(res);
            }



            writer.close();
            reader.close();
            socket.close();

    }
}