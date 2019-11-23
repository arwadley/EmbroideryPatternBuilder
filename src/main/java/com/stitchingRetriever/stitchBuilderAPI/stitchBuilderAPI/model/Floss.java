package com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="FLOSSES" )
public class Floss implements Serializable {

    @Id
    @Column(name="DMC_COLOR")
    private int dmcColor;
    @Column(name="COLOR_NAME")
    private String colorName;
    @Column(name="COLOR_HEX_VALUE")
    private String colorHexValue;

    public Floss(String colorName, int dmcColor, String colorHexValue){
        this.colorName = colorName;
        this.dmcColor = dmcColor;
        this.colorHexValue = colorHexValue;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColor(String color) {
        this.colorName = color;
    }

    public int getDmcColor() {
        return dmcColor;
    }

    public void setDmcColor(int dmcColor) {
        this.dmcColor = dmcColor;
    }

    public String getColorHexValue() {
        return colorHexValue;
    }

    public void setColorHexValue(String colorHexValue) {
        this.colorHexValue = colorHexValue;
    }

}
