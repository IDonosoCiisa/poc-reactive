package com.donoso.pocreactive.data.entities.EvolutionChain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokemonChain {
    private EvolutionSpecies species;
    @JsonProperty("evolves_to")
    List<PokemonChain> evolvesTo;

    public PokemonChain() {
    }
    public List<PokemonChain> getEvolvesTo() {
        return evolvesTo;
    }

    public void setEvolvesTo(List<PokemonChain> evolvesTo) {
        this.evolvesTo = evolvesTo;
    }

    public EvolutionSpecies getSpecies() {
        return species;
    }

    public void setSpecies(EvolutionSpecies species) {
        this.species = species;
    }
}
