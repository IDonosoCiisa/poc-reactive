package com.donoso.pocreactive.data.entities.Pokemon;

public class Form {
    private String name;
    private String url;

    public Form(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Form() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
