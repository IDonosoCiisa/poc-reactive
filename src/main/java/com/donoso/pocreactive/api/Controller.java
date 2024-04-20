package com.donoso.pocreactive.api;

import com.donoso.pocreactive.api.entities.PokemonResponseWithEvolutions;
import com.donoso.pocreactive.api.mapper.MapperPokemonToPokemonResponse;
import com.donoso.pocreactive.api.entities.PokemonResponse;
import com.donoso.pocreactive.data.entities.EvolutionChain.EvolutionChain;
import com.donoso.pocreactive.data.entities.Species.Species;
import com.donoso.pocreactive.domain.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/v1")
public class Controller {
    private final PokemonService pokemonService;
    private final MapperPokemonToPokemonResponse mapper;

    public Controller(PokemonService pokemonService, MapperPokemonToPokemonResponse mapper) {
        this.pokemonService = pokemonService;
        this.mapper = mapper;
    }

    @GetMapping("/pokemon/{id}")
    public Flux<PokemonResponse> getPokemon(@PathVariable int id){
        return mapper.fromPokemonToPokemonResponse(pokemonService.getPokemon(id));
    }
    @GetMapping("/evolution/{id}")
    public Flux<EvolutionChain> getPokemonEvolutions(@PathVariable int id){
        return pokemonService.getPokemonEvolutions(id);
    }
    @GetMapping("/species/{id}")
    public Flux<Species> getPokemonSpecies(@PathVariable int id){
        return pokemonService.getPokemonSpecies(id);
    }
    @GetMapping("/pokemon/evos/{id}")
    public Flux<PokemonResponseWithEvolutions> getPokemonWithEvo(@PathVariable int id){
        return pokemonService.getPokemonWithEvol(id);
    }

}
