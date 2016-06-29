/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.ui.RectangleEdge;

public class ClipPath
implements Cloneable {
    private double[] xValue = null;
    private double[] yValue = null;
    private boolean clip = true;
    private boolean drawPath = false;
    private boolean fillPath = false;
    private Paint fillPaint = null;
    private Paint drawPaint = null;
    private Stroke drawStroke = null;
    private Composite composite = null;

    public ClipPath() {
    }

    public ClipPath(double[] arrd, double[] arrd2) {
        this(arrd, arrd2, true, false, true);
    }

    public ClipPath(double[] arrd, double[] arrd2, boolean bl2, boolean bl3, boolean bl4) {
        this.xValue = arrd;
        this.yValue = arrd2;
        this.clip = bl2;
        this.fillPath = bl3;
        this.drawPath = bl4;
        this.fillPaint = Color.gray;
        this.drawPaint = Color.blue;
        this.drawStroke = new BasicStroke(1.0f);
        this.composite = AlphaComposite.Src;
    }

    public ClipPath(double[] arrd, double[] arrd2, boolean bl2, boolean bl3, Paint paint, Paint paint2, Stroke stroke, Composite composite) {
        this.xValue = arrd;
        this.yValue = arrd2;
        this.fillPath = bl2;
        this.drawPath = bl3;
        this.fillPaint = paint;
        this.drawPaint = paint2;
        this.drawStroke = stroke;
        this.composite = composite;
    }

    public GeneralPath draw(Graphics2D graphics2D, Rectangle2D rectangle2D, ValueAxis valueAxis, ValueAxis valueAxis2) {
        GeneralPath generalPath = this.generateClipPath(rectangle2D, valueAxis, valueAxis2);
        if (!this.fillPath) {
            if (!this.drawPath) return generalPath;
        }
        Composite composite = graphics2D.getComposite();
        Paint paint = graphics2D.getPaint();
        Stroke stroke = graphics2D.getStroke();
        if (this.fillPaint != null) {
            graphics2D.setPaint(this.fillPaint);
        }
        if (this.composite != null) {
            graphics2D.setComposite(this.composite);
        }
        if (this.fillPath) {
            graphics2D.fill(generalPath);
        }
        if (this.drawStroke != null) {
            graphics2D.setStroke(this.drawStroke);
        }
        if (this.drawPath) {
            graphics2D.draw(generalPath);
        }
        graphics2D.setPaint(paint);
        graphics2D.setComposite(composite);
        graphics2D.setStroke(stroke);
        return generalPath;
    }

    public GeneralPath generateClipPath(Rectangle2D rectangle2D, ValueAxis valueAxis, ValueAxis valueAxis2) {
        GeneralPath generalPath = new GeneralPath();
        double d2 = valueAxis.valueToJava2D(this.xValue[0], rectangle2D, RectangleEdge.BOTTOM);
        double d3 = valueAxis2.valueToJava2D(this.yValue[0], rectangle2D, RectangleEdge.LEFT);
        generalPath.moveTo((float)d2, (float)d3);
        int n2 = 0;
        do {
            if (n2 >= this.yValue.length) {
                generalPath.closePath();
                return generalPath;
            }
            d2 = valueAxis.valueToJava2D(this.xValue[n2], rectangle2D, RectangleEdge.BOTTOM);
            d3 = valueAxis2.valueToJava2D(this.yValue[n2], rectangle2D, RectangleEdge.LEFT);
            generalPath.lineTo((float)d2, (float)d3);
            ++n2;
        } while (true);
    }

    public Composite getComposite() {
        return this.composite;
    }

    public Paint getDrawPaint() {
        return this.drawPaint;
    }

    public boolean isDrawPath() {
        return this.drawPath;
    }

    public Stroke getDrawStroke() {
        return this.drawStroke;
    }

    public Paint getFillPaint() {
        return this.fillPaint;
    }

    public boolean isFillPath() {
        return this.fillPath;
    }

    public double[] getXValue() {
        return this.xValue;
    }

    public double[] getYValue() {
        return this.yValue;
    }

    public void setComposite(Composite composite) {
        this.composite = composite;
    }

    public void setDrawPaint(Paint paint) {
        this.drawPaint = paint;
    }

    public void setDrawPath(boolean bl2) {
        this.drawPath = bl2;
    }

    public void setDrawStroke(Stroke stroke) {
        this.drawStroke = stroke;
    }

    public void setFillPaint(Paint paint) {
        this.fillPaint = paint;
    }

    public void setFillPath(boolean bl2) {
        this.fillPath = bl2;
    }

    public void setXValue(double[] arrd) {
        this.xValue = arrd;
    }

    public void setYValue(double[] arrd) {
        this.yValue = arrd;
    }

    public boolean isClip() {
        return this.clip;
    }

    public void setClip(boolean bl2) {
        this.clip = bl2;
    }

    public Object clone() {
        ClipPath clipPath = (ClipPath)super.clone();
        clipPath.xValue = (double[])this.xValue.clone();
        clipPath.yValue = (double[])this.yValue.clone();
        return clipPath;
    }
}

