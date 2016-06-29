package org.jfree.chart.annotations;

import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.text.*;
import org.jfree.ui.*;
import org.jfree.util.*;
import org.jfree.chart.*;
import org.jfree.io.*;
import java.io.*;
import java.awt.*;

public class XYTextAnnotation extends AbstractXYAnnotation implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -2946063342782506328L;
    public static final Font DEFAULT_FONT;
    public static final Paint DEFAULT_PAINT;
    public static final TextAnchor DEFAULT_TEXT_ANCHOR;
    public static final TextAnchor DEFAULT_ROTATION_ANCHOR;
    public static final double DEFAULT_ROTATION_ANGLE = 0.0;
    private String text;
    private Font font;
    private transient Paint paint;
    private double x;
    private double y;
    private TextAnchor textAnchor;
    private TextAnchor rotationAnchor;
    private double rotationAngle;
    
    public XYTextAnnotation(final String text, final double x, final double y) {
        if (text == null) {
            throw new IllegalArgumentException("Null 'text' argument.");
        }
        this.text = text;
        this.font = XYTextAnnotation.DEFAULT_FONT;
        this.paint = XYTextAnnotation.DEFAULT_PAINT;
        this.x = x;
        this.y = y;
        this.textAnchor = XYTextAnnotation.DEFAULT_TEXT_ANCHOR;
        this.rotationAnchor = XYTextAnnotation.DEFAULT_ROTATION_ANCHOR;
        this.rotationAngle = 0.0;
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(final String text) {
        if (text == null) {
            throw new IllegalArgumentException("Null 'text' argument.");
        }
        this.text = text;
    }
    
    public Font getFont() {
        return this.font;
    }
    
    public void setFont(final Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.font = font;
    }
    
    public Paint getPaint() {
        return this.paint;
    }
    
    public void setPaint(final Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.paint = paint;
    }
    
    public TextAnchor getTextAnchor() {
        return this.textAnchor;
    }
    
    public void setTextAnchor(final TextAnchor textAnchor) {
        if (textAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        this.textAnchor = textAnchor;
    }
    
    public TextAnchor getRotationAnchor() {
        return this.rotationAnchor;
    }
    
    public void setRotationAnchor(final TextAnchor rotationAnchor) {
        if (rotationAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        this.rotationAnchor = rotationAnchor;
    }
    
    public double getRotationAngle() {
        return this.rotationAngle;
    }
    
    public void setRotationAngle(final double rotationAngle) {
        this.rotationAngle = rotationAngle;
    }
    
    public double getX() {
        return this.x;
    }
    
    public void setX(final double x) {
        this.x = x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setY(final double y) {
        this.y = y;
    }
    
    public void draw(final Graphics2D graphics2D, final XYPlot xyPlot, final Rectangle2D rectangle2D, final ValueAxis valueAxis, final ValueAxis valueAxis2, final int n, final PlotRenderingInfo plotRenderingInfo) {
        final PlotOrientation orientation = xyPlot.getOrientation();
        final RectangleEdge resolveDomainAxisLocation = Plot.resolveDomainAxisLocation(xyPlot.getDomainAxisLocation(), orientation);
        final RectangleEdge resolveRangeAxisLocation = Plot.resolveRangeAxisLocation(xyPlot.getRangeAxisLocation(), orientation);
        float n2 = (float)valueAxis.valueToJava2D(this.x, rectangle2D, resolveDomainAxisLocation);
        float n3 = (float)valueAxis2.valueToJava2D(this.y, rectangle2D, resolveRangeAxisLocation);
        if (orientation == PlotOrientation.HORIZONTAL) {
            final float n4 = n2;
            n2 = n3;
            n3 = n4;
        }
        graphics2D.setFont(this.getFont());
        graphics2D.setPaint(this.getPaint());
        TextUtilities.drawRotatedString(this.getText(), graphics2D, n2, n3, this.getTextAnchor(), this.getRotationAngle(), this.getRotationAnchor());
        final Shape calculateRotatedStringBounds = TextUtilities.calculateRotatedStringBounds(this.getText(), graphics2D, n2, n3, this.getTextAnchor(), this.getRotationAngle(), this.getRotationAnchor());
        final String toolTipText = this.getToolTipText();
        final String url = this.getURL();
        if (toolTipText != null || url != null) {
            this.addEntity(plotRenderingInfo, calculateRotatedStringBounds, n, toolTipText, url);
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYTextAnnotation)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final XYTextAnnotation xyTextAnnotation = (XYTextAnnotation)o;
        return this.text.equals(xyTextAnnotation.text) && this.x == xyTextAnnotation.x && this.y == xyTextAnnotation.y && this.font.equals(xyTextAnnotation.font) && PaintUtilities.equal(this.paint, xyTextAnnotation.paint) && this.rotationAnchor.equals(xyTextAnnotation.rotationAnchor) && this.rotationAngle == xyTextAnnotation.rotationAngle && this.textAnchor.equals(xyTextAnnotation.textAnchor);
    }
    
    public int hashCode() {
        final int n = 37 * this.text.hashCode();
        final int n2 = 37 * (37 * this.font.hashCode()) + HashUtilities.hashCodeForPaint(this.paint);
        final long doubleToLongBits = Double.doubleToLongBits(this.x);
        final int n3 = 37 * n2 + (int)(doubleToLongBits ^ doubleToLongBits >>> 32);
        final long doubleToLongBits2 = Double.doubleToLongBits(this.y);
        final int n4 = 37 * (37 * (37 * n3 + (int)(doubleToLongBits2 ^ doubleToLongBits2 >>> 32)) + this.textAnchor.hashCode()) + this.rotationAnchor.hashCode();
        final long doubleToLongBits3 = Double.doubleToLongBits(this.rotationAngle);
        return 37 * n4 + (int)(doubleToLongBits3 ^ doubleToLongBits3 >>> 32);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
    }
    
    static {
        DEFAULT_FONT = new Font("SansSerif", 0, 10);
        DEFAULT_PAINT = Color.black;
        DEFAULT_TEXT_ANCHOR = TextAnchor.CENTER;
        DEFAULT_ROTATION_ANCHOR = TextAnchor.CENTER;
    }
}
