package com.company.model;

import java.io.Serializable;

public class Song implements Serializable {

    private Long id;
    private String name;
    private String artist;
    private String genre;
    private Integer duration;
    private String album;
    private Integer numberOfDownloads;

    private static long nextId = 1;
    public Song(
                String name,
                String artist,
                String genre,
                Integer duration,
                String album) {
        this.id = nextId++;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
        this.album = album;
        this.numberOfDownloads = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getNumberOfDownloads() {
        return numberOfDownloads;
    }

    public void setNumberOfDownloads(Integer numberOfDownloads) {
        this.numberOfDownloads = numberOfDownloads;
    }

    @Override
    public String toString() {
        return "Song{" + "id=" + id + ", name=" + name + ", artist=" + artist + ", genre=" + genre + ", duration=" + duration + ", album=" + album + ", numberOfDownloads=" + numberOfDownloads + '}';
    }
}
