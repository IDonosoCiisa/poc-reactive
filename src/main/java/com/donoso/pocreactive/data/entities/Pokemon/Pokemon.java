package com.donoso.pocreactive.data.entities.Pokemon;
import java.util.List;

public class Pokemon {
        private List<Abilities> abilities;
        private List<Form> forms;
        private int height;
        private int id;
        private boolean is_default;
        private String location_area_encounters;
        private List<Moves> moves;
        private String name;
        private int order;
        private Species species;
        private List<Types> types;
        private int weight;

        public Pokemon() {
        }

        public List<Abilities> getAbilities() {
                return abilities;
        }

        public void setAbilities(List<Abilities> abilities) {
                this.abilities = abilities;
        }

        public List<Form> getForms() {
                return forms;
        }

        public void setForms(List<Form> forms) {
                this.forms = forms;
        }

        public int getHeight() {
                return height;
        }

        public void setHeight(int height) {
                this.height = height;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public boolean isIs_default() {
                return is_default;
        }

        public void setIs_default(boolean is_default) {
                this.is_default = is_default;
        }

        public String getLocation_area_encounters() {
                return location_area_encounters;
        }

        public void setLocation_area_encounters(String location_area_encounters) {
                this.location_area_encounters = location_area_encounters;
        }

        public List<Moves> getMoves() {
                return moves;
        }

        public void setMoves(List<Moves> moves) {
                this.moves = moves;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getOrder() {
                return order;
        }

        public void setOrder(int order) {
                this.order = order;
        }

        public Species getSpecies() {
                return species;
        }

        public void setSpecies(Species species) {
                this.species = species;
        }

        public List<Types> getTypes() {
                return types;
        }

        public void setTypes(List<Types> types) {
                this.types = types;
        }

        public int getWeight() {
                return weight;
        }

        public void setWeight(int weight) {
                this.weight = weight;
        }
}

