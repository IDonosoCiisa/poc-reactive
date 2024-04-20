package com.donoso.pocreactive.domain;

import com.donoso.pocreactive.api.entities.PokemonResponseWithEvolutions;
import com.donoso.pocreactive.data.entities.EvolutionChain.EvolutionChain;
import com.donoso.pocreactive.data.entities.Pokemon.Pokemon;
import com.donoso.pocreactive.data.entities.Species.Species;
import com.donoso.pocreactive.domain.gateway.PokemonGateway;
import com.donoso.pocreactive.domain.mapper.MapperToPokemonWithEvoResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;


@Component
public class PokemonService {
    private final PokemonGateway pokemonGateway;
    private final MapperToPokemonWithEvoResponse mapper;

    public PokemonService(PokemonGateway pokemonGateway, MapperToPokemonWithEvoResponse mapper) {
        this.pokemonGateway = pokemonGateway;
        this.mapper = mapper;
    }

    public Flux<Pokemon> getPokemon(int id){
        return pokemonGateway.getPokemon(id);
    }
    public Flux<EvolutionChain> getPokemonEvolutions(int id){
        return pokemonGateway.getEvolutionChainPokemons(id);
    }
    public Flux<Species> getPokemonSpecies(int id){
        return pokemonGateway.getEvolutionChainUri(id);
    }

    public Flux<PokemonResponseWithEvolutions> getPokemonWithEvol(int id){
        Flux<Pokemon> pokemon = pokemonGateway.getPokemon(id);
        Flux<Species> species = pokemonGateway.getEvolutionChainUri(id);
        String evoUri = StringUtils.delete(species.blockFirst().getEvolutionChain().getUrl().substring(species.blockFirst().getEvolutionChain().getUrl().lastIndexOf("n")+1), "/");
        Flux<EvolutionChain> evolutionChainFlux = pokemonGateway.getEvolutionChainPokemons(Integer.parseInt(evoUri));
        return mapper.mapToResponsePokemonWithEvolutions(pokemon, evolutionChainFlux.map(evolutionChain -> evolutionChain.getChain()));
    }

}
