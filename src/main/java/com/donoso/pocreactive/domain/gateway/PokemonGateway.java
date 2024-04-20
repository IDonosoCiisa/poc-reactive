package com.donoso.pocreactive.domain.gateway;

import com.donoso.pocreactive.data.entities.EvolutionChain.EvolutionChain;
import com.donoso.pocreactive.data.entities.Species.Species;
import com.donoso.pocreactive.data.entities.Pokemon.Pokemon;
import reactor.core.publisher.Flux;

public interface PokemonGateway {
    Flux<Pokemon> getPokemon(int id);
    Flux<EvolutionChain> getEvolutionChainPokemons(int id);
    Flux<Species> getEvolutionChainUri(int id);
}
