/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.data.Range;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.ObjectUtilities;

public class MarkerAxisBand
implements Serializable {
    private static final long serialVersionUID = -1729482413886398919L;
    private NumberAxis axis;
    private double topOuterGap;
    private double topInnerGap;
    private double bottomOuterGap;
    private double bottomInnerGap;
    private Font font;
    private List markers;

    public MarkerAxisBand(NumberAxis numberAxis, double d2, double d3, double d4, double d5, Font font) {
        this.axis = numberAxis;
        this.topOuterGap = d2;
        this.topInnerGap = d3;
        this.bottomOuterGap = d4;
        this.bottomInnerGap = d5;
        this.font = font;
        this.markers = new ArrayList();
    }

    public void addMarker(IntervalMarker intervalMarker) {
        this.markers.add(intervalMarker);
    }

    public double getHeight(Graphics2D graphics2D) {
        double d2 = 0.0;
        if (this.markers.size() <= 0) return d2;
        LineMetrics lineMetrics = this.font.getLineMetrics("123g", graphics2D.getFontRenderContext());
        return this.topOuterGap + this.topInnerGap + (double)lineMetrics.getHeight() + this.bottomInnerGap + this.bottomOuterGap;
    }

    private void drawStringInRect(Graphics2D graphics2D, Rectangle2D rectangle2D, Font font, String string) {
        graphics2D.setFont(font);
        FontMetrics fontMetrics = graphics2D.getFontMetrics(font);
        Rectangle2D rectangle2D2 = TextUtilities.getTextBounds(string, graphics2D, fontMetrics);
        double d2 = rectangle2D.getX();
        if (rectangle2D2.getWidth() < rectangle2D.getWidth()) {
            d2 += (rectangle2D.getWidth() - rectangle2D2.getWidth()) / 2.0;
        }
        LineMetrics lineMetrics = font.getLineMetrics(string, graphics2D.getFontRenderContext());
        graphics2D.drawString(string, (float)d2, (float)(rectangle2D.getMaxY() - this.bottomInnerGap - (double)lineMetrics.getDescent()));
    }

    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, double d2, double d3) {
        double d4 = this.getHeight(graphics2D);
        Iterator iterator = this.markers.iterator();
        while (iterator.hasNext()) {
            IntervalMarker intervalMarker = (IntervalMarker)iterator.next();
            double d5 = Math.max(intervalMarker.getStartValue(), this.axis.getRange().getLowerBound());
            double d6 = Math.min(intervalMarker.getEndValue(), this.axis.getRange().getUpperBound());
            double d7 = this.axis.valueToJava2D(d5, rectangle2D2, RectangleEdge.BOTTOM);
            double d8 = this.axis.valueToJava2D(d6, rectangle2D2, RectangleEdge.BOTTOM);
            Rectangle2D.Double double_ = new Rectangle2D.Double(d7, d3 + this.topOuterGap, d8 - d7, d4 - this.topOuterGap - this.bottomOuterGap);
            Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, intervalMarker.getAlpha()));
            graphics2D.setPaint(intervalMarker.getPaint());
            graphics2D.fill(double_);
            graphics2D.setPaint(intervalMarker.getOutlinePaint());
            graphics2D.draw(double_);
            graphics2D.setComposite(composite);
            graphics2D.setPaint(Color.black);
            this.drawStringInRect(graphics2D, double_, this.font, intervalMarker.getLabel());
        }
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MarkerAxisBand)) {
            return false;
        }
        MarkerAxisBand markerAxisBand = (MarkerAxisBand)object;
        if (this.topOuterGap != markerAxisBand.topOuterGap) {
            return false;
        }
        if (this.topInnerGap != markerAxisBand.topInnerGap) {
            return false;
        }
        if (this.bottomInnerGap != markerAxisBand.bottomInnerGap) {
            return false;
        }
        if (this.bottomOuterGap != markerAxisBand.bottomOuterGap) {
            return false;
        }
        if (!ObjectUtilities.equal(this.font, markerAxisBand.font)) {
            return false;
        }
        if (ObjectUtilities.equal(this.markers, markerAxisBand.markers)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 37;
        n2 = 19 * n2 + this.font.hashCode();
        return 19 * n2 + this.markers.hashCode();
    }
}

