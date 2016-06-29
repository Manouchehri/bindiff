package org.jfree.chart.plot;

import java.io.*;
import java.awt.*;
import org.jfree.ui.*;
import org.jfree.chart.event.*;
import org.jfree.util.*;

public class IntervalMarker extends Marker implements Serializable, Cloneable
{
    private static final long serialVersionUID = -1762344775267627916L;
    private double startValue;
    private double endValue;
    private GradientPaintTransformer gradientPaintTransformer;
    
    public IntervalMarker(final double n, final double n2) {
        this(n, n2, Color.gray, new BasicStroke(0.5f), Color.gray, new BasicStroke(0.5f), 0.8f);
    }
    
    public IntervalMarker(final double startValue, final double endValue, final Paint paint, final Stroke stroke, final Paint paint2, final Stroke stroke2, final float n) {
        super(paint, stroke, paint2, stroke2, n);
        this.startValue = startValue;
        this.endValue = endValue;
        this.gradientPaintTransformer = null;
        this.setLabelOffsetType(LengthAdjustmentType.CONTRACT);
    }
    
    public double getStartValue() {
        return this.startValue;
    }
    
    public void setStartValue(final double startValue) {
        this.startValue = startValue;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public double getEndValue() {
        return this.endValue;
    }
    
    public void setEndValue(final double endValue) {
        this.endValue = endValue;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public GradientPaintTransformer getGradientPaintTransformer() {
        return this.gradientPaintTransformer;
    }
    
    public void setGradientPaintTransformer(final GradientPaintTransformer gradientPaintTransformer) {
        this.gradientPaintTransformer = gradientPaintTransformer;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IntervalMarker)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final IntervalMarker intervalMarker = (IntervalMarker)o;
        return this.startValue == intervalMarker.startValue && this.endValue == intervalMarker.endValue && ObjectUtilities.equal(this.gradientPaintTransformer, intervalMarker.gradientPaintTransformer);
    }
    
    public Object clone() {
        return super.clone();
    }
}
