package com.ogrp.section02.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLDataException;

public class Server {
    public static void main(String[] args) throws IOException {
        /*
        port는 65535까지 사용가능 , 8000미만은 직접 설정하지 않음
         */
        int port = 12398;

        ServerSocket server = new ServerSocket(port);

        while (true) {
            Socket client = server.accept();

            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader((input)));
            PrintWriter pw = new PrintWriter(output);
            /*
            읽기 전용, 쓰기 전용 통로 연결
             */

            while (true) {
                String Message = br.readLine();

                if (!Message.equals("exit")) {
                    System.out.println(client.getInetAddress().getHostAddress() + "가 보낸 메세지 : " + Message);
                    pw.println("메세지 받기 성공");
                    pw.flush();
                } else {
                    System.out.println("접속 종료");
                    break;
                }
            }
            br.close();
            pw.close();
            client.close();
        }
    }
}
