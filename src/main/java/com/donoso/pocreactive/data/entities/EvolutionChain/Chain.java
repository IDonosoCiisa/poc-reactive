package com.donoso.pocreactive.data.entities.EvolutionChain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Chain {
    @JsonProperty("evolves_to")
    private List<PokemonChain> evolvesTo;
    private EvolutionSpecies species;

    public Chain() {
    }

    public EvolutionSpecies getSpecies() {
        return species;
    }

    public void setSpecies(EvolutionSpecies species) {
        this.species = species;
    }

    public List<PokemonChain> getEvolvesTo() {
        return evolvesTo;
    }

    public void setEvolvesTo(List<PokemonChain> evolvesTo) {
        this.evolvesTo = evolvesTo;
    }
}
