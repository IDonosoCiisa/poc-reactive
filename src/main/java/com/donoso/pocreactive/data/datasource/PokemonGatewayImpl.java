package com.donoso.pocreactive.data.datasource;

import com.donoso.pocreactive.data.entities.EvolutionChain.EvolutionChain;
import com.donoso.pocreactive.data.entities.Species.Species;
import com.donoso.pocreactive.data.entities.Pokemon.Pokemon;
import com.donoso.pocreactive.domain.gateway.PokemonGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


@Component
public class PokemonGatewayImpl implements PokemonGateway {

    @Value("${endpoints.getPokemon}")
    private String getPokemonUri;
    @Value("${endpoints.getEvolutions}")
    private String getEvolutionsUri;

    @Value("${endpoints.getSpecies}")
    private String getEvolutionChainsUri;

    @Override
    public Flux<Pokemon> getPokemon(int id) {
        WebClient webClient = WebClient.create();
        return webClient
                .get()
                .uri(getPokemonUri.concat(String.valueOf(id)))
                .retrieve()
                .bodyToFlux(Pokemon.class)
                .doOnError(throwable -> new RuntimeException(throwable.getMessage()));
    }

    @Override
    public Flux<EvolutionChain> getEvolutionChainPokemons(int id) {
        WebClient webClient = WebClient.create();
        return webClient
                .get()
                .uri(getEvolutionsUri.concat(String.valueOf(id)))
                .retrieve()
                .bodyToFlux(EvolutionChain.class)
                .doOnError(throwable -> new RuntimeException(throwable.getMessage()));
    }

    @Override
    public Flux<Species> getEvolutionChainUri(int id) {
        WebClient webClient = WebClient.create();
        return webClient
                .get()
                .uri(getEvolutionChainsUri.concat(String.valueOf(id)))
                .retrieve()
                .bodyToFlux(Species.class)
                .doOnError(throwable -> new RuntimeException(throwable.getMessage()));
    }
}
