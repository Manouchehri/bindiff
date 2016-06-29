/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer;

import java.awt.Color;
import java.awt.Paint;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jfree.chart.renderer.LookupPaintScale$PaintItem;
import org.jfree.chart.renderer.PaintScale;
import org.jfree.io.SerialUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class LookupPaintScale
implements Serializable,
PaintScale,
PublicCloneable {
    private double lowerBound;
    private double upperBound;
    private transient Paint defaultPaint;
    private List lookupTable;

    public LookupPaintScale() {
        this(0.0, 1.0, Color.lightGray);
    }

    public LookupPaintScale(double d2, double d3, Paint paint) {
        if (d2 >= d3) {
            throw new IllegalArgumentException("Requires lowerBound < upperBound.");
        }
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.lowerBound = d2;
        this.upperBound = d3;
        this.defaultPaint = paint;
        this.lookupTable = new ArrayList();
    }

    public Paint getDefaultPaint() {
        return this.defaultPaint;
    }

    @Override
    public double getLowerBound() {
        return this.lowerBound;
    }

    @Override
    public double getUpperBound() {
        return this.upperBound;
    }

    public void add(Number number, Paint paint) {
        LookupPaintScale$PaintItem lookupPaintScale$PaintItem = new LookupPaintScale$PaintItem(this, number, paint);
        int n2 = Collections.binarySearch(this.lookupTable, lookupPaintScale$PaintItem);
        if (n2 >= 0) {
            this.lookupTable.set(n2, lookupPaintScale$PaintItem);
            return;
        }
        this.lookupTable.add(- n2 + 1, lookupPaintScale$PaintItem);
    }

    @Override
    public Paint getPaint(double d2) {
        if (d2 < this.lowerBound) {
            return this.defaultPaint;
        }
        if (d2 > this.upperBound) {
            return this.defaultPaint;
        }
        Paint paint = this.defaultPaint;
        int n2 = this.lookupTable.size();
        boolean bl2 = false;
        while (n2 > 0) {
            if (bl2) return paint;
            LookupPaintScale$PaintItem lookupPaintScale$PaintItem = (LookupPaintScale$PaintItem)this.lookupTable.get(--n2);
            if (d2 < lookupPaintScale$PaintItem.value.doubleValue()) continue;
            paint = lookupPaintScale$PaintItem.paint;
            bl2 = true;
        }
        return paint;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof LookupPaintScale)) {
            return false;
        }
        LookupPaintScale lookupPaintScale = (LookupPaintScale)object;
        if (this.lowerBound != lookupPaintScale.lowerBound) {
            return false;
        }
        if (this.upperBound != lookupPaintScale.upperBound) {
            return false;
        }
        if (!PaintUtilities.equal(this.defaultPaint, lookupPaintScale.defaultPaint)) {
            return false;
        }
        if (this.lookupTable.equals(lookupPaintScale.lookupTable)) return true;
        return false;
    }

    @Override
    public Object clone() {
        LookupPaintScale lookupPaintScale = (LookupPaintScale)super.clone();
        lookupPaintScale.lookupTable = new ArrayList(this.lookupTable);
        return lookupPaintScale;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.defaultPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.defaultPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

