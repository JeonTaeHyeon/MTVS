package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Member;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class ContextComfiguration {

    @Bean
    public Member getMember(){
    return new Member(1,"User01","pass01","홍길동");
    }
}
