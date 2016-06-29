/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.io.Serializable;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;

public abstract class Tick
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 6668230383875149773L;
    private String text;
    private TextAnchor textAnchor;
    private TextAnchor rotationAnchor;
    private double angle;

    public Tick(String string, TextAnchor textAnchor, TextAnchor textAnchor2, double d2) {
        if (textAnchor == null) {
            throw new IllegalArgumentException("Null 'textAnchor' argument.");
        }
        if (textAnchor2 == null) {
            throw new IllegalArgumentException("Null 'rotationAnchor' argument.");
        }
        this.text = string;
        this.textAnchor = textAnchor;
        this.rotationAnchor = textAnchor2;
        this.angle = d2;
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

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Tick)) return false;
        Tick tick = (Tick)object;
        if (!ObjectUtilities.equal(this.text, tick.text)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.textAnchor, tick.textAnchor)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.rotationAnchor, tick.rotationAnchor)) {
            return false;
        }
        if (this.angle == tick.angle) return true;
        return false;
    }

    public Object clone() {
        return (Tick)super.clone();
    }

    public String toString() {
        return this.text;
    }
}

