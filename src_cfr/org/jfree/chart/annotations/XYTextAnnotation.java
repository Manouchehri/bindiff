/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.annotations;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.HashUtilities;
import org.jfree.chart.annotations.AbstractXYAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class XYTextAnnotation
extends AbstractXYAnnotation
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -2946063342782506328L;
    public static final Font DEFAULT_FONT = new Font("SansSerif", 0, 10);
    public static final Paint DEFAULT_PAINT = Color.black;
    public static final TextAnchor DEFAULT_TEXT_ANCHOR = TextAnchor.CENTER;
    public static final TextAnchor DEFAULT_ROTATION_ANCHOR = TextAnchor.CENTER;
    public static final double DEFAULT_ROTATION_ANGLE = 0.0;
    private String text;
    private Font font;
    private transient Paint paint;
    private double x;
    private double y;
    private TextAnchor textAnchor;
    private TextAnchor rotationAnchor;
    private double rotationAngle;

    public XYTextAnnotation(String string, double d2, double d3) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'text' argument.");
        }
        this.text = string;
        this.font = DEFAULT_FONT;
        this.paint = DEFAULT_PAINT;
        this.x = d2;
        this.y = d3;
        this.textAnchor = DEFAULT_TEXT_ANCHOR;
        this.rotationAnchor = DEFAULT_ROTATION_ANCHOR;
        this.rotationAngle = 0.0;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'text' argument.");
        }
        this.text = string;
    }

    public Font getFont() {
        return this.font;
    }

    public void setFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.font = font;
    }

    public Paint getPaint() {
        return this.paint;
    }

    public void setPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.paint = paint;
    }

    public TextAnchor getTextAnchor() {
        return this.textAnchor;
    }

    public void setTextAnchor(TextAnchor textAnchor) {
        if (textAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        this.textAnchor = textAnchor;
    }

    public TextAnchor getRotationAnchor() {
        return this.rotationAnchor;
    }

    public void setRotationAnchor(TextAnchor textAnchor) {
        if (textAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        this.rotationAnchor = textAnchor;
    }

    public double getRotationAngle() {
        return this.rotationAngle;
    }

    public void setRotationAngle(double d2) {
        this.rotationAngle = d2;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double d2) {
        this.x = d2;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double d2) {
        this.y = d2;
    }

    @Override
    public void draw(Graphics2D graphics2D, XYPlot xYPlot, Rectangle2D rectangle2D, ValueAxis valueAxis, ValueAxis valueAxis2, int n2, PlotRenderingInfo plotRenderingInfo) {
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        RectangleEdge rectangleEdge = Plot.resolveDomainAxisLocation(xYPlot.getDomainAxisLocation(), plotOrientation);
        RectangleEdge rectangleEdge2 = Plot.resolveRangeAxisLocation(xYPlot.getRangeAxisLocation(), plotOrientation);
        float f2 = (float)valueAxis.valueToJava2D(this.x, rectangle2D, rectangleEdge);
        float f3 = (float)valueAxis2.valueToJava2D(this.y, rectangle2D, rectangleEdge2);
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            float f4 = f2;
            f2 = f3;
            f3 = f4;
        }
        graphics2D.setFont(this.getFont());
        graphics2D.setPaint(this.getPaint());
        TextUtilities.drawRotatedString(this.getText(), graphics2D, f2, f3, this.getTextAnchor(), this.getRotationAngle(), this.getRotationAnchor());
        Shape shape = TextUtilities.calculateRotatedStringBounds(this.getText(), graphics2D, f2, f3, this.getTextAnchor(), this.getRotationAngle(), this.getRotationAnchor());
        String string = this.getToolTipText();
        String string2 = this.getURL();
        if (string == null) {
            if (string2 == null) return;
        }
        this.addEntity(plotRenderingInfo, shape, n2, string, string2);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYTextAnnotation)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        XYTextAnnotation xYTextAnnotation = (XYTextAnnotation)object;
        if (!this.text.equals(xYTextAnnotation.text)) {
            return false;
        }
        if (this.x != xYTextAnnotation.x) {
            return false;
        }
        if (this.y != xYTextAnnotation.y) {
            return false;
        }
        if (!this.font.equals(xYTextAnnotation.font)) {
            return false;
        }
        if (!PaintUtilities.equal(this.paint, xYTextAnnotation.paint)) {
            return false;
        }
        if (!this.rotationAnchor.equals(xYTextAnnotation.rotationAnchor)) {
            return false;
        }
        if (this.rotationAngle != xYTextAnnotation.rotationAngle) {
            return false;
        }
        if (this.textAnchor.equals(xYTextAnnotation.textAnchor)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int n2 = 193;
        n2 = 37 * this.text.hashCode();
        n2 = 37 * this.font.hashCode();
        n2 = 37 * n2 + HashUtilities.hashCodeForPaint(this.paint);
        long l2 = Double.doubleToLongBits(this.x);
        n2 = 37 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.y);
        n2 = 37 * n2 + (int)(l2 ^ l2 >>> 32);
        n2 = 37 * n2 + this.textAnchor.hashCode();
        n2 = 37 * n2 + this.rotationAnchor.hashCode();
        l2 = Double.doubleToLongBits(this.rotationAngle);
        return 37 * n2 + (int)(l2 ^ l2 >>> 32);
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
    }
}

