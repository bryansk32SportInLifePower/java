package com;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8000);


        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));


        writer.write("I got www\n");
        writer.newLine();
        writer.flush();

        String respons = reader.readLine();
        System.out.println(respons);
        




            writer.close();
            reader.close();
            socket.close();
        }
    }
