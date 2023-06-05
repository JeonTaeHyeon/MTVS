package com.ogrp.section02.TCP;

import javax.script.ScriptContext;
import java.io.*;
import java.net.Socket;
import java.nio.file.LinkPermission;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        int port=8800;

        String serverIP="192.168.0.10";

        Socket socket = new Socket(serverIP,port);

        if(socket!=null){
            InputStream input=socket.getInputStream();
            OutputStream output=socket.getOutputStream();

           BufferedReader br=new BufferedReader(new InputStreamReader(input));
            PrintWriter pw=new PrintWriter(output);

            Scanner sc=new Scanner(System.in);

            do{
                System.out.println("대화 입력 : ");
                String message = sc.nextLine();

                pw.println(message);
                pw.flush();

                if(message.equals("exit")){
                    break;
                }

                String recieveMessage = br.readLine();
                System.out.println(recieveMessage);

            }while (true);


            br.close();
            pw.close();
            socket.close();
        }
    }
}
