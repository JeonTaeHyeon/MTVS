package com.ohgiraffers.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

//@Data 위에꺼 전부 추가
public class Member {
    private int sequence;
    private String id;
    private String pwd;
    private String name;

}
