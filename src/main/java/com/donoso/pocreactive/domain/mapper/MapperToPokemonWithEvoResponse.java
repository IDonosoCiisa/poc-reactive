package com.donoso.pocreactive.domain.mapper;

import com.donoso.pocreactive.api.entities.PokemonResponseWithEvolutions;
import com.donoso.pocreactive.data.entities.EvolutionChain.Chain;
import com.donoso.pocreactive.data.entities.EvolutionChain.PokemonChain;
import com.donoso.pocreactive.data.entities.Pokemon.Pokemon;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class MapperToPokemonWithEvoResponse {
    public Flux<PokemonResponseWithEvolutions> mapToResponsePokemonWithEvolutions(Flux<Pokemon> pokemonFlux, Flux<Chain> evolutions){
        List<String> evolutionList = new ArrayList<>();
        evolutionList.add(evolutions.blockFirst().getSpecies().getName());
        Chain pokemonChain = evolutions.blockFirst();
        getEvolutions(pokemonChain.getEvolvesTo().get(0), evolutionList);

        return pokemonFlux.map(pokemon ->
                new PokemonResponseWithEvolutions.Builder()
                        .withName(pokemon.getName())
                        .withId(pokemon.getId())
                        .withAbilities(pokemon.getAbilities().stream().map(abilities -> abilities.getAbility().getName()).collect(Collectors.toList()))
                        .withTypes(pokemon.getTypes().stream().map(types -> types.getType().getName()).collect(Collectors.toList()))
                        .withMoves(pokemon.getMoves().stream().map(moves -> moves.getMove().getName()).collect(Collectors.toList()))
                        .withEvolutions(evolutionList)
                        .build()
        );
    }

    private List<String> getEvolutions(PokemonChain pokemonChainFlux, List<String> evolutionList){
        evolutionList.add(pokemonChainFlux.getSpecies().getName());
        if (!pokemonChainFlux.getEvolvesTo().isEmpty()){
            pokemonChainFlux.getEvolvesTo().stream().forEach(pokemonChain -> getEvolutions(pokemonChain,evolutionList));
        }
        return evolutionList;
    }

}
