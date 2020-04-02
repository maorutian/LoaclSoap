/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapservice.models;

/**
 *
 * @author tomorrow
 */
public class Movie {
    private int id;
    private String title;
    private int year;
    private String category;
    private String producer;
    private String director;
    private String thumbnail;
    private byte[] thumbnailFile;

    public Movie() {
    }

    public Movie(int id, String title, int year, String category, String producer, String director, String thumbnail) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.category = category;
        this.producer = producer;
        this.director = director;
        this.thumbnail = thumbnail;
    }
    
    

    public Movie(String title, int year, String category, String producer, String director, String thumbnail) {
        this.title = title;
        this.year = year;
        this.category = category;
        this.producer = producer;
        this.director = director;
        this.thumbnail = thumbnail;
    }

    public Movie(int id, String title, int year, String category, String producer, String director, String thumbnail, byte[] thumbnailFile) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.category = category;
        this.producer = producer;
        this.director = director;
        this.thumbnail = thumbnail;
        this.thumbnailFile = thumbnailFile;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public byte[] getThumbnailFile() {
        return thumbnailFile;
    }

    public void setThumbnailFile(byte[] thumbnailFile) {
        this.thumbnailFile = thumbnailFile;
    }
    
    
    
    

    
    
    
}
