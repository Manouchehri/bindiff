/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer;

import java.awt.Color;
import java.awt.Paint;
import java.io.Serializable;
import org.jfree.chart.renderer.PaintScale;
import org.jfree.util.PublicCloneable;

public class GrayPaintScale
implements Serializable,
PaintScale,
PublicCloneable {
    private double lowerBound;
    private double upperBound;

    public GrayPaintScale() {
        this(0.0, 1.0);
    }

    public GrayPaintScale(double d2, double d3) {
        if (d2 >= d3) {
            throw new IllegalArgumentException("Requires lowerBound < upperBound.");
        }
        this.lowerBound = d2;
        this.upperBound = d3;
    }

    @Override
    public double getLowerBound() {
        return this.lowerBound;
    }

    @Override
    public double getUpperBound() {
        return this.upperBound;
    }

    @Override
    public Paint getPaint(double d2) {
        double d3 = Math.max(d2, this.lowerBound);
        d3 = Math.min(d3, this.upperBound);
        int n2 = (int)((d2 - this.lowerBound) / (this.upperBound - this.lowerBound) * 255.0);
        return new Color(n2, n2, n2);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof GrayPaintScale)) {
            return false;
        }
        GrayPaintScale grayPaintScale = (GrayPaintScale)object;
        if (this.lowerBound != grayPaintScale.lowerBound) {
            return false;
        }
        if (this.upperBound == grayPaintScale.upperBound) return true;
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

