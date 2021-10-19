package ru.itis.dis.lab2.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    private static Socket clientSocket;
    private static ServerSocket serverSocket;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {

        int tries = 1;
        int countClients = 0;


        serverSocket = new ServerSocket(2023);
        System.out.println("Сервер запущен!");

        while (true) {
            try {

                clientSocket = serverSocket.accept();
                int number = generateNumber();

                System.out.println("Client " + (++countClients) + " accepted");
                System.out.println(number);

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                try {
                    while (true) {

                        String messageRes = in.readLine();
                        System.out.println("message " + messageRes);

                        if (Integer.parseInt(messageRes) == number) {
                            out.write("TRUE");
                            out.newLine();
                            out.flush();
                            break;

                        } else if (tries == 3) {
                            out.write("Try again!");
                            out.newLine();
                            out.flush();
                            number = generateNumber();
                            System.out.println("New generated number: " + number);
                            tries = 1;

                        } else {
                            out.write("Answer is incorrect " + messageRes);
                            out.newLine();
                            out.flush();
                            tries++;
                        }


                    }
                } catch (Exception e) {
                    System.err.println("Client" + countClients + " has left");
                }
                System.out.println("Сервер в ожидании!");
                tries = 1;
                clientSocket.close();
                out.close();
                in.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private static int generateNumber() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }
}