package com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI.model;


import reactor.util.annotation.NonNull;

import javax.persistence.*;
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
    @Column(name="prototype_image", columnDefinition ="BLOB")
    private byte[] prototypeImage;
    @Column(name="pattern_image", columnDefinition = "BLOB")
    private byte[] patternImage;

    public Pattern() {};

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pattern pattern = (Pattern) o;
        return id == pattern.id &&
                Arrays.equals(patternImage, pattern.patternImage);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(patternImage);
        return result;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getPrototypeImage() {
        return prototypeImage;
    }

    public void setPrototypeImage(byte[] prototypeImage) {
        this.prototypeImage = prototypeImage;
    }

    public byte[] getPatternImage() {
        return patternImage;
    }

    public void setPatternImage(byte[] patternImage) {
        this.patternImage = patternImage;
    }

    public Pattern(long id, byte[] prototypeImage, byte[] patternImage) {
        this.id = id;
        this.prototypeImage = prototypeImage;
        this.patternImage = patternImage;
    }


}
