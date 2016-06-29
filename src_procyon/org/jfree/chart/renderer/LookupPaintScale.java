package org.jfree.chart.renderer;

import java.awt.*;
import org.jfree.util.*;
import java.util.*;
import org.jfree.io.*;
import java.io.*;

public class LookupPaintScale implements Serializable, PaintScale, PublicCloneable
{
    private double lowerBound;
    private double upperBound;
    private transient Paint defaultPaint;
    private List lookupTable;
    
    public LookupPaintScale() {
        this(0.0, 1.0, Color.lightGray);
    }
    
    public LookupPaintScale(final double lowerBound, final double upperBound, final Paint defaultPaint) {
        if (lowerBound >= upperBound) {
            throw new IllegalArgumentException("Requires lowerBound < upperBound.");
        }
        if (defaultPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.defaultPaint = defaultPaint;
        this.lookupTable = new ArrayList();
    }
    
    public Paint getDefaultPaint() {
        return this.defaultPaint;
    }
    
    public double getLowerBound() {
        return this.lowerBound;
    }
    
    public double getUpperBound() {
        return this.upperBound;
    }
    
    public void add(final Number n, final Paint paint) {
        final LookupPaintScale$PaintItem lookupPaintScale$PaintItem = new LookupPaintScale$PaintItem(this, n, paint);
        final int binarySearch = Collections.binarySearch(this.lookupTable, lookupPaintScale$PaintItem);
        if (binarySearch >= 0) {
            this.lookupTable.set(binarySearch, lookupPaintScale$PaintItem);
        }
        else {
            this.lookupTable.add(-(binarySearch + 1), lookupPaintScale$PaintItem);
        }
    }
    
    public Paint getPaint(final double n) {
        if (n < this.lowerBound) {
            return this.defaultPaint;
        }
        if (n > this.upperBound) {
            return this.defaultPaint;
        }
        Paint paint = this.defaultPaint;
        for (int size = this.lookupTable.size(), n2 = 0; size > 0 && n2 == 0; n2 = 1) {
            final LookupPaintScale$PaintItem lookupPaintScale$PaintItem = this.lookupTable.get(--size);
            if (n >= lookupPaintScale$PaintItem.value.doubleValue()) {
                paint = lookupPaintScale$PaintItem.paint;
            }
        }
        return paint;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LookupPaintScale)) {
            return false;
        }
        final LookupPaintScale lookupPaintScale = (LookupPaintScale)o;
        return this.lowerBound == lookupPaintScale.lowerBound && this.upperBound == lookupPaintScale.upperBound && PaintUtilities.equal(this.defaultPaint, lookupPaintScale.defaultPaint) && this.lookupTable.equals(lookupPaintScale.lookupTable);
    }
    
    public Object clone() {
        final LookupPaintScale lookupPaintScale = (LookupPaintScale)super.clone();
        lookupPaintScale.lookupTable = new ArrayList(this.lookupTable);
        return lookupPaintScale;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.defaultPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.defaultPaint = SerialUtilities.readPaint(objectInputStream);
    }
}
