package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02.annotation.subsection02.qualifier");
        PokemonBattleField pokemonBattleField = context.getBean("fieldQualifier", PokemonBattleField.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for(String name : beanNames) {
            System.out.println("name = " + name);
        }

        pokemonBattleField.fight();
    }
}
