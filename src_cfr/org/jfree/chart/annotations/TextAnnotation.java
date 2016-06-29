/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.annotations;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.HashUtilities;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class TextAnnotation
implements Serializable {
    private static final long serialVersionUID = 7008912287533127432L;
    public static final Font DEFAULT_FONT = new Font("SansSerif", 0, 10);
    public static final Paint DEFAULT_PAINT = Color.black;
    public static final TextAnchor DEFAULT_TEXT_ANCHOR = TextAnchor.CENTER;
    public static final TextAnchor DEFAULT_ROTATION_ANCHOR = TextAnchor.CENTER;
    public static final double DEFAULT_ROTATION_ANGLE = 0.0;
    private String text;
    private Font font;
    private transient Paint paint;
    private TextAnchor textAnchor;
    private TextAnchor rotationAnchor;
    private double rotationAngle;

    protected TextAnnotation(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'text' argument.");
        }
        this.text = string;
        this.font = DEFAULT_FONT;
        this.paint = DEFAULT_PAINT;
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
        this.rotationAnchor = textAnchor;
    }

    public double getRotationAngle() {
        return this.rotationAngle;
    }

    public void setRotationAngle(double d2) {
        this.rotationAngle = d2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TextAnnotation)) {
            return false;
        }
        TextAnnotation textAnnotation = (TextAnnotation)object;
        if (!ObjectUtilities.equal(this.text, textAnnotation.getText())) {
            return false;
        }
        if (!ObjectUtilities.equal(this.font, textAnnotation.getFont())) {
            return false;
        }
        if (!PaintUtilities.equal(this.paint, textAnnotation.getPaint())) {
            return false;
        }
        if (!ObjectUtilities.equal(this.textAnchor, textAnnotation.getTextAnchor())) {
            return false;
        }
        if (!ObjectUtilities.equal(this.rotationAnchor, textAnnotation.getRotationAnchor())) {
            return false;
        }
        if (this.rotationAngle == textAnnotation.getRotationAngle()) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 193;
        n2 = 37 * n2 + this.font.hashCode();
        n2 = 37 * n2 + HashUtilities.hashCodeForPaint(this.paint);
        n2 = 37 * n2 + this.rotationAnchor.hashCode();
        long l2 = Double.doubleToLongBits(this.rotationAngle);
        n2 = 37 * n2 + (int)(l2 ^ l2 >>> 32);
        n2 = 37 * n2 + this.text.hashCode();
        return 37 * n2 + this.textAnchor.hashCode();
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

