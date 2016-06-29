package org.jfree.chart.axis;

import java.io.*;
import org.jfree.ui.*;
import org.jfree.util.*;

public abstract class Tick implements Serializable, Cloneable
{
    private static final long serialVersionUID = 6668230383875149773L;
    private String text;
    private TextAnchor textAnchor;
    private TextAnchor rotationAnchor;
    private double angle;
    
    public Tick(final String text, final TextAnchor textAnchor, final TextAnchor rotationAnchor, final double angle) {
        if (textAnchor == null) {
            throw new IllegalArgumentException("Null 'textAnchor' argument.");
        }
        if (rotationAnchor == null) {
            throw new IllegalArgumentException("Null 'rotationAnchor' argument.");
        }
        this.text = text;
        this.textAnchor = textAnchor;
        this.rotationAnchor = rotationAnchor;
        this.angle = angle;
    }
    
    public String getText() {
        return this.text;
    }
    
    public TextAnchor getTextAnchor() {
        return this.textAnchor;
    }
    
    public TextAnchor getRotationAnchor() {
        return this.rotationAnchor;
    }
    
    public double getAngle() {
        return this.angle;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Tick) {
            final Tick tick = (Tick)o;
            return ObjectUtilities.equal(this.text, tick.text) && ObjectUtilities.equal(this.textAnchor, tick.textAnchor) && ObjectUtilities.equal(this.rotationAnchor, tick.rotationAnchor) && this.angle == tick.angle;
        }
        return false;
    }
    
    public Object clone() {
        return super.clone();
    }
    
    public String toString() {
        return this.text;
    }
}
