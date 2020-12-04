package com.tscrypter.retrofitassigment.dto;

import android.util.Pair;
import retrofit2.Retrofit;
import retrofit2.http.Field;

import java.util.List;



public class PokemonList {
    private int count;
    private String next;
    private String previous;
    private List<PokemonListItem> results;

    public PokemonList() {
    }

    public PokemonList(int count, String next, String previous, List<PokemonListItem> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<PokemonListItem> getResults() {
        return results;
    }

    public void setResults(List<PokemonListItem> results) {
        this.results = results;
    }

    public class PokemonListItem {
        private String name;
        private String url;

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
}
