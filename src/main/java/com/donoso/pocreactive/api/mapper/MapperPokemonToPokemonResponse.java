package com.donoso.pocreactive.api.mapper;

import com.donoso.pocreactive.api.entities.PokemonResponse;
import com.donoso.pocreactive.data.entities.Pokemon.Pokemon;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.stream.Collectors;

@Component
public class MapperPokemonToPokemonResponse {
    public Flux<PokemonResponse> fromPokemonToPokemonResponse(Flux<Pokemon> pokemonFlux){
        return pokemonFlux.map(pokemon ->
                new PokemonResponse.Builder()
                        .withName(pokemon.getName())
                        .withId(pokemon.getId())
                        .withAbilities(pokemon.getAbilities().stream().map(abilities -> abilities.getAbility().getName()).collect(Collectors.toList()))
                        .withTypes(pokemon.getTypes().stream().map(types -> types.getType().getName()).collect(Collectors.toList()))
                        .withMoves(pokemon.getMoves().stream().map(moves -> moves.getMove().getName()).collect(Collectors.toList()))
                        .build()
        );
    }
}
