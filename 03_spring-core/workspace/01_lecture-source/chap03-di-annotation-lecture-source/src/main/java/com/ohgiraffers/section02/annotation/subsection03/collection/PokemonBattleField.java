package com.ohgiraffers.section02.annotation.subsection03.collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("fieldCollection")
public class PokemonBattleField {

//    @Autowired
    private List<Pokemon> pokemons;

    @Autowired
    public PokemonBattleField(List<Pokemon> pokemons) {
        System.out.println("pokemons = " + pokemons);
        this.pokemons = pokemons;
    }

    public void fight() {
        for(Pokemon pokemon : pokemons) {
            pokemon.attack();
        }
    }
}
