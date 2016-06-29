package org.jfree.chart.annotations;

import org.jfree.ui.*;
import org.jfree.util.*;
import org.jfree.chart.*;
import org.jfree.io.*;
import java.io.*;
import java.awt.*;

public class TextAnnotation implements Serializable
{
    private static final long serialVersionUID = 7008912287533127432L;
    public static final Font DEFAULT_FONT;
    public static final Paint DEFAULT_PAINT;
    public static final TextAnchor DEFAULT_TEXT_ANCHOR;
    public static final TextAnchor DEFAULT_ROTATION_ANCHOR;
    public static final double DEFAULT_ROTATION_ANGLE = 0.0;
    private String text;
    private Font font;
    private transient Paint paint;
    private TextAnchor textAnchor;
    private TextAnchor rotationAnchor;
    private double rotationAngle;
    
    protected TextAnnotation(final String text) {
        if (text == null) {
            throw new IllegalArgumentException("Null 'text' argument.");
        }
        this.text = text;
        this.font = TextAnnotation.DEFAULT_FONT;
        this.paint = TextAnnotation.DEFAULT_PAINT;
        this.textAnchor = TextAnnotation.DEFAULT_TEXT_ANCHOR;
        this.rotationAnchor = TextAnnotation.DEFAULT_ROTATION_ANCHOR;
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
        this.rotationAnchor = rotationAnchor;
    }
    
    public double getRotationAngle() {
        return this.rotationAngle;
    }
    
    public void setRotationAngle(final double rotationAngle) {
        this.rotationAngle = rotationAngle;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TextAnnotation)) {
            return false;
        }
        final TextAnnotation textAnnotation = (TextAnnotation)o;
        return ObjectUtilities.equal(this.text, textAnnotation.getText()) && ObjectUtilities.equal(this.font, textAnnotation.getFont()) && PaintUtilities.equal(this.paint, textAnnotation.getPaint()) && ObjectUtilities.equal(this.textAnchor, textAnnotation.getTextAnchor()) && ObjectUtilities.equal(this.rotationAnchor, textAnnotation.getRotationAnchor()) && this.rotationAngle == textAnnotation.getRotationAngle();
    }
    
    public int hashCode() {
        final int n = 37 * (37 * (37 * 193 + this.font.hashCode()) + HashUtilities.hashCodeForPaint(this.paint)) + this.rotationAnchor.hashCode();
        final long doubleToLongBits = Double.doubleToLongBits(this.rotationAngle);
        return 37 * (37 * (37 * n + (int)(doubleToLongBits ^ doubleToLongBits >>> 32)) + this.text.hashCode()) + this.textAnchor.hashCode();
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
