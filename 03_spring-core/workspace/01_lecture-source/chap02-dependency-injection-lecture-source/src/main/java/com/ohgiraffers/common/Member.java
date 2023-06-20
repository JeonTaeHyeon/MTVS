package com.ohgiraffers.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Member {

    private int sequence;
    private String name;
    private String phone;
    private String email;
    private Account personalAccount;
}
