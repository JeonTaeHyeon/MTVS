package com.ohgiraffers.section03.properties.subsection01.value;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("section03/properties/subsection01/value/product-info.properties")
public class ContextConfiguration {

    @Value("${bread.carpbread.name2:팥붕어빵}")
    //${}는 치환자 properties파일에서 불러올 key값을 대입
    //키값이 존재하지 않을 경우를 대비하여 : 을 사용하여 대체할 값을 넣어줄 수 있음
    private String carpBreadName;
    @Value("${bread.carpbread.price2:0}")
    //int 형은 변환해주어야 하기 때문에 변환이 불가능한 값이 넘어가게 되면 에러가 발생할 수 있음.
    private int carpBreadPrice;

//    @Value("${bread.carpbread.name:밭붕어빵")
//    private  String carpBread2;
    // 재사용 가능

    @Value("${beverage.milk.name:}")
    private String milkname;

    @Value("${beverage.milk.price:0:}")
    private int milkPrice;

    @Value("${beverage.milk.capacity:0:}")
    private int milkCapaacity;

    @Bean
    public Product carpBread() {
        return new Bread(carpBreadName, carpBreadPrice, new java.util.Date());
    }
    @Bean
    public Product milk(){
        return  new Beverage(milkname,milkPrice,milkCapaacity);
    }
    @Bean
    public Product water(@Value("${beverage.water.name}") String waterName,
                         @Value("${beverage.water.price:0}")int waterPrice,
                         @Value("${beverage.water.capacity:0}")int waterCapacity){
        return new Beverage(waterName,waterPrice,waterCapacity);
    }


}
