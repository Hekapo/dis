package ru.itis.dis.lab2.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static Socket clientSocket;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static Scanner scanner;

    public static void main(String[] args) throws IOException {
        try {

            clientSocket = new Socket("127.0.0.1", 2023);

            scanner = new Scanner(System.in);

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            while (true) {
                System.out.println("Enter number:");
                String messageToSend = scanner.nextLine();

                out.write(messageToSend);
                out.newLine();
                out.flush();
                String read = in.readLine();
                System.out.println("Server: " + read);

                if (read.equals("TRUE")) {
                    break;
                }


            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Завершаю сессию...");
            clientSocket.close();
            scanner.close();
            in.close();
            out.close();

        }


    }
}