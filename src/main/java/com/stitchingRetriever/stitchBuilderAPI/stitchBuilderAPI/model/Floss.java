package com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="FLOSSES" )
public class Floss implements Serializable {

    @Id
    @Column(name="DMC_COLOR")
    private int dmcColor;
    @Column(name="COLOR_HEX_VALUE")
    private String colorHexValue;
    @Column(name="PRIMARY_COLOR")
    private String primaryColor;

    public Floss(int dmcColor, String colorHexValue, String primaryColor){
        this.dmcColor = dmcColor;
        this.colorHexValue = colorHexValue;
        this.primaryColor = primaryColor;
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
