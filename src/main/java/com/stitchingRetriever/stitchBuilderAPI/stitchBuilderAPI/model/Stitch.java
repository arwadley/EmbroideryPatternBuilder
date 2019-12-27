package com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI.model;

import reactor.util.annotation.NonNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="STITCHES")
public class Stitch {

    @Id
    @NonNull
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NonNull
    @Column(name="STITCH_NAME")
    private String stitchName;
    @Column(name="STITCH_CATEGORY")
    private String stitchCategory;
    @Column(name="STITCH_INSTRUCTIONS")
    private String stitchInstructions;

    public Stitch(){};

    public Stitch(String name, String instructions, String category) {
        this.stitchName = name;
        this.stitchInstructions = instructions;
        this.stitchCategory = category;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stitch stitch = (Stitch) o;
        return id.equals(stitch.id) &&
                stitchName.equals(stitch.stitchName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stitchName);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStitchName() {
        return stitchName;
    }

    public void setStitchName(String stitchName) {
        this.stitchName = stitchName;
    }

    public String getStitchCategory() {
        return stitchCategory;
    }

    public void setStitchCategory(String stitchCategory) {
        this.stitchCategory = stitchCategory;
    }

    public String getStitchInstructions() {
        return stitchInstructions;
    }

    public void setStitchInstructions(String stitchInstructions) {
        this.stitchInstructions = stitchInstructions;
    }
}
