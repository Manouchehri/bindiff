package org.jfree.chart.axis;

import java.io.*;
import org.jfree.chart.plot.*;
import java.awt.geom.*;
import org.jfree.text.*;
import org.jfree.ui.*;
import java.awt.*;
import java.util.*;
import org.jfree.util.*;

public class MarkerAxisBand implements Serializable
{
    private static final long serialVersionUID = -1729482413886398919L;
    private NumberAxis axis;
    private double topOuterGap;
    private double topInnerGap;
    private double bottomOuterGap;
    private double bottomInnerGap;
    private Font font;
    private List markers;
    
    public MarkerAxisBand(final NumberAxis axis, final double topOuterGap, final double topInnerGap, final double bottomOuterGap, final double bottomInnerGap, final Font font) {
        this.axis = axis;
        this.topOuterGap = topOuterGap;
        this.topInnerGap = topInnerGap;
        this.bottomOuterGap = bottomOuterGap;
        this.bottomInnerGap = bottomInnerGap;
        this.font = font;
        this.markers = new ArrayList();
    }
    
    public void addMarker(final IntervalMarker intervalMarker) {
        this.markers.add(intervalMarker);
    }
    
    public double getHeight(final Graphics2D graphics2D) {
        double n = 0.0;
        if (this.markers.size() > 0) {
            n = this.topOuterGap + this.topInnerGap + this.font.getLineMetrics("123g", graphics2D.getFontRenderContext()).getHeight() + this.bottomInnerGap + this.bottomOuterGap;
        }
        return n;
    }
    
    private void drawStringInRect(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Font font, final String s) {
        graphics2D.setFont(font);
        final Rectangle2D textBounds = TextUtilities.getTextBounds(s, graphics2D, graphics2D.getFontMetrics(font));
        double x = rectangle2D.getX();
        if (textBounds.getWidth() < rectangle2D.getWidth()) {
            x += (rectangle2D.getWidth() - textBounds.getWidth()) / 2.0;
        }
        graphics2D.drawString(s, (float)x, (float)(rectangle2D.getMaxY() - this.bottomInnerGap - font.getLineMetrics(s, graphics2D.getFontRenderContext()).getDescent()));
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final double n, final double n2) {
        final double height = this.getHeight(graphics2D);
        for (final IntervalMarker intervalMarker : this.markers) {
            final double max = Math.max(intervalMarker.getStartValue(), this.axis.getRange().getLowerBound());
            final double min = Math.min(intervalMarker.getEndValue(), this.axis.getRange().getUpperBound());
            final double valueToJava2D = this.axis.valueToJava2D(max, rectangle2D2, RectangleEdge.BOTTOM);
            final Rectangle2D.Double double1 = new Rectangle2D.Double(valueToJava2D, n2 + this.topOuterGap, this.axis.valueToJava2D(min, rectangle2D2, RectangleEdge.BOTTOM) - valueToJava2D, height - this.topOuterGap - this.bottomOuterGap);
            final Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, intervalMarker.getAlpha()));
            graphics2D.setPaint(intervalMarker.getPaint());
            graphics2D.fill(double1);
            graphics2D.setPaint(intervalMarker.getOutlinePaint());
            graphics2D.draw(double1);
            graphics2D.setComposite(composite);
            graphics2D.setPaint(Color.black);
            this.drawStringInRect(graphics2D, double1, this.font, intervalMarker.getLabel());
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MarkerAxisBand)) {
            return false;
        }
        final MarkerAxisBand markerAxisBand = (MarkerAxisBand)o;
        return this.topOuterGap == markerAxisBand.topOuterGap && this.topInnerGap == markerAxisBand.topInnerGap && this.bottomInnerGap == markerAxisBand.bottomInnerGap && this.bottomOuterGap == markerAxisBand.bottomOuterGap && ObjectUtilities.equal(this.font, markerAxisBand.font) && ObjectUtilities.equal(this.markers, markerAxisBand.markers);
    }
    
    public int hashCode() {
        return 19 * (19 * 37 + this.font.hashCode()) + this.markers.hashCode();
    }
}
