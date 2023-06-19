package com.ohgiraffers.section01.aop;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
    private Long id;
    private String name;

    public Long getId() {
        return id;

    }
    public String getName() {
        return name;
    }
}
