/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.Serializable;
import org.jfree.chart.event.MarkerChangeEvent;
import org.jfree.chart.plot.Marker;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.util.ObjectUtilities;

public class IntervalMarker
extends Marker
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -1762344775267627916L;
    private double startValue;
    private double endValue;
    private GradientPaintTransformer gradientPaintTransformer;

    public IntervalMarker(double d2, double d3) {
        this(d2, d3, Color.gray, new BasicStroke(0.5f), Color.gray, new BasicStroke(0.5f), 0.8f);
    }

    public IntervalMarker(double d2, double d3, Paint paint, Stroke stroke, Paint paint2, Stroke stroke2, float f2) {
        super(paint, stroke, paint2, stroke2, f2);
        this.startValue = d2;
        this.endValue = d3;
        this.gradientPaintTransformer = null;
        this.setLabelOffsetType(LengthAdjustmentType.CONTRACT);
    }

    public double getStartValue() {
        return this.startValue;
    }

    public void setStartValue(double d2) {
        this.startValue = d2;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    public double getEndValue() {
        return this.endValue;
    }

    public void setEndValue(double d2) {
        this.endValue = d2;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    public GradientPaintTransformer getGradientPaintTransformer() {
        return this.gradientPaintTransformer;
    }

    public void setGradientPaintTransformer(GradientPaintTransformer gradientPaintTransformer) {
        this.gradientPaintTransformer = gradientPaintTransformer;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof IntervalMarker)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        IntervalMarker intervalMarker = (IntervalMarker)object;
        if (this.startValue != intervalMarker.startValue) {
            return false;
        }
        if (this.endValue != intervalMarker.endValue) {
            return false;
        }
        if (ObjectUtilities.equal(this.gradientPaintTransformer, intervalMarker.gradientPaintTransformer)) return true;
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

