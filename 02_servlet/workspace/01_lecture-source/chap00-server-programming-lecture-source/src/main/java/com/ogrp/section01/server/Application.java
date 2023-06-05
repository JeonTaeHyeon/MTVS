package com.ogrp.section01.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(19204);

        Socket client;
        while ((client = serverSocket.accept()) != null) {
//            new Thread(new Runnable() {
//                // A Runnable은 interface라 객체를 만들지 못하지만
//                // A 상속받아서 만드는 익명 class임
//                @Override
//                public void run() {
//                }
//            });
            Socket finalClient = client;
            // A 여기는 또 다른 class이기 때문에 client를 다시 작성해줘야한다.
            new Thread(() -> {
                //A 람다 문법을 이용하여 간단하게 구현
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(finalClient.getInputStream()));
                    //client가 보낸 mesg를 읽을 수 있는 통로(stream)
                    // A 한번에 출력
//                    String line;
//                    while((line = reader.readLine())!=null){
//                        System.out.println("Line = " +line);
//                    }

                    // A 분리해서 출력
                    String generalHeader = reader.readLine();
                    System.out.println("generalHeader : " + generalHeader);

                    String requestMethod = generalHeader.split(" ")[0]; // A 공백 기준으로 잘라서 배열로 반환
                    String requsetPath = generalHeader.split(" ")[1];

                    System.out.println("requestMethod : " + requestMethod);
                    System.out.println("requsetPath : " + requsetPath);

                    Map<String, String> requestHeader = new HashMap<>();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.isBlank()) {
                            break;
                        }

                        String key = line.split(": ")[0];
                        String value = line.split(": ")[1];

                        requestHeader.put(key, value);
                    }
                    System.out.println("requestHeader : " + requestHeader);

                    String body = null;
                    if ("POST".equals(requestMethod)) {
                        //A post방식으로 넘어올때만 실행
                        int contentLength = Integer.parseInt(requestHeader.get("Content-Length"));
                        char[] temp = new char[contentLength];
                        reader.read(temp);
                        body = new String(temp).trim();
                        // A trim() 으로 NULL 제거
                    }
                    System.out.println("body : " + body);


                    StringBuilder responseText = new StringBuilder();
                    if ("/".equals(requsetPath) && "GET".equals(requestMethod)) {

                        System.out.println("작동?");


                        String responseGeneralHeader = "HTTP/1.1 200 OK\r\n";
                        String contentType = "Content-Type: text/html; charset=UTF-8\r\n";
                        String whiteLine = "\r\n";

                        responseText.append(responseGeneralHeader);
                        responseText.append(contentType);
                        responseText.append(whiteLine);

                        BufferedReader br = new BufferedReader(
                                new FileReader("src/main/resources/index.html"));
                        String htmlLine = null;
                        while ((htmlLine = br.readLine()) != null) {
                            responseText.append(htmlLine);
                        }
                        responseText.append(whiteLine);
                    }

                    System.out.println("responseText : " + responseText);

                    OutputStream out = finalClient.getOutputStream();
                    out.write(responseText.toString().getBytes());

                    out.flush();
                    out.close();

                    reader.close();
                    finalClient.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();//A Thread가 가지고 있는 start호출

            // A 모든 요청을 Thread 단위로 처리해서 socket을 만들기 떄문에
            // A 여러개의 요청도 받을 수 있다.
        }

    }
}