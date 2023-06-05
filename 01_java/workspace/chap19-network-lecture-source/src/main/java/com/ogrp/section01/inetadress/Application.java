package com.ogrp.section01.inetadress;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Application {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localIp=InetAddress.getLocalHost();

        System.out.println(localIp.getHostAddress());
        System.out.println(localIp.getHostName());

        InetAddress naverIp= InetAddress.getByName("www.naver.com");
        System.out.println("네이버 서버 IP : "+naverIp.getHostAddress());

    }
}
