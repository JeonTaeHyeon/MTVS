package com.ohgiraffers.section02.annotation.subsection03.collection;

import org.springframework.stereotype.Component;

@Component
//@Primary
public class Pikachu implements Pokemon {

    @Override
    public void attack() {
        System.out.println("피카츄 백만볼트!!");
    }
}
