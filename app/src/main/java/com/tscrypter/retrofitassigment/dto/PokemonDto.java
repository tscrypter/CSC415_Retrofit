package com.tscrypter.retrofitassigment.dto;

import android.util.Pair;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonDto {
    private String name;
    private int base_experience, height, weight;
    private Sprites sprites;
    private List<BaseStat> stats;

    public PokemonDto() {
    }

    public PokemonDto(String name, int baseExperience, int height, int weight, Sprites sprites, List<BaseStat> stats) {
        this.name = name;
        this.base_experience = baseExperience;
        this.height = height;
        this.weight = weight;
        this.sprites = sprites;
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseExperience() {
        return base_experience;
    }

    public void setBaseExperience(int baseExperience) {
        this.base_experience = baseExperience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<BaseStat> getStats() {
        return stats;
    }

    public void setStats(List<BaseStat> stats) {
        this.stats = stats;
    }

    public class Sprites {
        private String back_default, front_default;
        private Other other;

        public Sprites() {
        }

        public Sprites(String back_default, String front_default, Other other) {
            this.back_default = back_default;
            this.front_default = front_default;
            this.other = other;
        }

        public String getBack_default() {
            return back_default;
        }

        public void setBack_default(String back_default) {
            this.back_default = back_default;
        }

        public String getFront_default() {
            return front_default;
        }

        public void setFront_default(String front_default) {
            this.front_default = front_default;
        }

        public Other getOther() {
            return other;
        }

        public void setOther(Other other) {
            this.other = other;
        }
    }

    public class Other {

        @SerializedName("official-artwork")
        private Sprites official_artwork;

        public Other() {
        }

        public Other(Sprites official_artwork) {
            this.official_artwork = official_artwork;
        }

        public Sprites getOfficial_artwork() {
            return official_artwork;
        }

        public void setOfficial_artwork(Sprites official_artwork) {
            this.official_artwork = official_artwork;
        }
    }

    public class BaseStat {
        private int base_stat, effort;
        private Stat stat;

        public BaseStat() {
        }

        public BaseStat(int base_stat, int effort, Stat stat) {
            this.base_stat = base_stat;
            this.effort = effort;
            this.stat = stat;
        }

        public int getBase_stat() {
            return base_stat;
        }

        public void setBase_stat(int base_stat) {
            this.base_stat = base_stat;
        }

        public int getEffort() {
            return effort;
        }

        public void setEffort(int effort) {
            this.effort = effort;
        }

        public Stat getStat() {
            return stat;
        }

        public void setStat(Stat stat) {
            this.stat = stat;
        }
    }

    public class Stat {
        private String name, url;

        public Stat() {
        }

        public Stat(String name, String url) {
            this.name = name;
            this.url = url;
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
}
