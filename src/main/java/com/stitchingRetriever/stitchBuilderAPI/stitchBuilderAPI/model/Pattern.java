package com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI.model;


import reactor.util.annotation.NonNull;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name="PATTERNS")
public class Pattern {

    @Id
    @NonNull
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column(name="project_title")
    private String title;
    @Column(name="prototype_image")
    private String prototypeImage;
    @Column(name="pattern_image")
    private String patternImage;

    public Pattern() {};

    public void setId(long id) {
        this.id = id;
    }

    public String getPrototypeImage() {
        return prototypeImage;
    }

    public void setPrototypeImage(String prototypeImage) {
        this.prototypeImage = prototypeImage;
    }

    public String getPatternImage() {
        return patternImage;
    }

    public void setPatternImage(String patternImage) {
        this.patternImage = patternImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }


}
