package com.ohgiraffers.section02.annotation.subsection01.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("fieldPrimary")
public class PokemonBattleField {

    private final Pokemon pokemon;

    @Autowired
    public PokemonBattleField(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void fight() {
        pokemon.attack();
    }
}
