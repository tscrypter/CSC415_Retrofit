package com.tscrypter.retrofitassigment;

import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public class Pokemon {

    private static final Logger logger = Logger.getLogger(Pokemon.class.getName());

    private String name, officialArtworkUrl;
    private int height, weight, baseExperience, hp, attack, defense, speed;

    public Pokemon() {}

    public Pokemon(String name, int height, int weight, int baseExperience, int hp, int attack, int defense, int speed,
                   String officialArtworkUrl) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.baseExperience = baseExperience;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.officialArtworkUrl = officialArtworkUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getOfficialArtworkUrl() {
        return officialArtworkUrl;
    }

    public void setOfficialArtworkUrl(String officialArtworkUrl) {
        this.officialArtworkUrl = officialArtworkUrl;
    }
}
