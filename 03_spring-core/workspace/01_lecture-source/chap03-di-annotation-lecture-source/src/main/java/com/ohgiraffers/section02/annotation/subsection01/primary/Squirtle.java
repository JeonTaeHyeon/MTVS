package com.ohgiraffers.section02.annotation.subsection01.primary;

import org.springframework.stereotype.Component;

@Component
public class Squirtle implements Pokemon {

    @Override
    public void attack() {
        System.out.println("꼬부기 물대포 발사!!");
    }
}
