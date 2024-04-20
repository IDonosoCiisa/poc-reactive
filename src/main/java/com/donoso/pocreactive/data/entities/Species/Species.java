package com.donoso.pocreactive.data.entities.Species;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Species {
    @JsonProperty("evolution_chain")
    private EvolutionChain evolutionChain;

    public Species() {
    }

    public EvolutionChain getEvolutionChain() {
        return evolutionChain;
    }

    public void setEvolutionChain(EvolutionChain evolutionChain) {
        this.evolutionChain = evolutionChain;
    }
}
