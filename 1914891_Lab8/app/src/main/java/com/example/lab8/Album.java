package com.example.lab8;

public class Album {
    private String albumName;
    private String imageName;
    private int population;

    public Album(String albumName, String imageName, int population){
        this.albumName = albumName;
        this.imageName = imageName;
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return this.albumName + "(Population: " + this.population + ")";
    }
}
