package com.donoso.pocreactive.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonPropertyOrder({ "id", "name", "types", "abilities", "moves" })
public class PokemonResponse {
    private int id;
    private String name;
    private List<String> moves;
    private List<String> types;
    private List<String> abilities;
    public PokemonResponse() {
    }

    private PokemonResponse(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setMoves(builder.moves);
        setTypes(builder.types);
        setAbilities(builder.abilities);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMoves() {
        return moves;
    }

    public void setMoves(List<String> moves) {
        this.moves = moves;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    public static final class Builder {
        private int id;
        private String name;
        private List<String> moves;
        private List<String> types;
        private List<String> abilities;

        public Builder() {
        }

        public Builder withId(int val) {
            id = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withMoves(List<String> val) {
            moves = val;
            return this;
        }

        public Builder withTypes(List<String> val) {
            types = val;
            return this;
        }

        public Builder withAbilities(List<String> val) {
            abilities = val;
            return this;
        }

        public PokemonResponse build() {
            return new PokemonResponse(this);
        }
    }
}
