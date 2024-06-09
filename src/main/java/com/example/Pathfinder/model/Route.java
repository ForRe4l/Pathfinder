package com.example.Pathfinder.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "gpx_coordinates",columnDefinition = "LongText")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(name = "video_url")
    private String videoUrl;

    @ManyToOne(optional = false)
    private User author;

    @OneToMany(targetEntity = Comments.class,mappedBy = "route")
    private Set<Comments> comments;

    @OneToMany(targetEntity = Pictures.class,mappedBy = "route")
    private Set<Pictures> pictures;

    @ManyToMany
    private Set<Categories> categories;

    public Route(){
        this.comments = new HashSet<>();
        this.pictures = new HashSet<>();
        this.categories = new HashSet<>();
    }

    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }

    public long getId() {
        return id;
    }

    public Set<Comments> getComments() {
        return comments;
    }

    public String getDescription() {
        return description;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }

    public Set<Pictures> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Pictures> pictures) {
        this.pictures = pictures;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGpx_coordinates() {
        return gpxCoordinates;
    }

    public void setGpx_coordinates(String gpx_coordinates) {
        this.gpxCoordinates = gpx_coordinates;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
