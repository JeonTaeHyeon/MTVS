package com.ohgiraffers.section03.subsection01.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//Configuration annotation을 사용하여 설정파일을 만듦
@ComponentScan(basePackages = {"com.ohgiraffers"})
// a basePackages를 사용하여 탐색할 패키지 범위를 설정할 수 있다.
public class ContextConfiguration {

}