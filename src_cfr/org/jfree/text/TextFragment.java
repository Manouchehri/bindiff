/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.text;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.Size2D;
import org.jfree.ui.TextAnchor;
import org.jfree.util.Log;
import org.jfree.util.LogContext;

public class TextFragment
implements Serializable {
    private static final long serialVersionUID = 4465945952903143262L;
    public static final Font DEFAULT_FONT = new Font("Serif", 0, 12);
    public static final Paint DEFAULT_PAINT = Color.black;
    private String text;
    private Font font;
    private transient Paint paint;
    private float baselineOffset;
    protected static final LogContext logger;
    static Class class$org$jfree$text$TextFragment;

    public TextFragment(String string) {
        this(string, DEFAULT_FONT, DEFAULT_PAINT);
    }

    public TextFragment(String string, Font font) {
        this(string, font, DEFAULT_PAINT);
    }

    public TextFragment(String string, Font font, Paint paint) {
        this(string, font, paint, 0.0f);
    }

    public TextFragment(String string, Font font, Paint paint, float f2) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'text' argument.");
        }
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.text = string;
        this.font = font;
        this.paint = paint;
        this.baselineOffset = f2;
    }

    public String getText() {
        return this.text;
    }

    public Font getFont() {
        return this.font;
    }

    public Paint getPaint() {
        return this.paint;
    }

    public float getBaselineOffset() {
        return this.baselineOffset;
    }

    public void draw(Graphics2D graphics2D, float f2, float f3, TextAnchor textAnchor, float f4, float f5, double d2) {
        graphics2D.setFont(this.font);
        graphics2D.setPaint(this.paint);
        TextUtilities.drawRotatedString(this.text, graphics2D, f2, f3 + this.baselineOffset, textAnchor, d2, f4, f5);
    }

    public Size2D calculateDimensions(Graphics2D graphics2D) {
        FontMetrics fontMetrics = graphics2D.getFontMetrics(this.font);
        Rectangle2D rectangle2D = TextUtilities.getTextBounds(this.text, graphics2D, fontMetrics);
        return new Size2D(rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public float calculateBaselineOffset(Graphics2D graphics2D, TextAnchor textAnchor) {
        float f2 = 0.0f;
        FontMetrics fontMetrics = graphics2D.getFontMetrics(this.font);
        LineMetrics lineMetrics = fontMetrics.getLineMetrics("ABCxyz", graphics2D);
        if (textAnchor == TextAnchor.TOP_LEFT) return lineMetrics.getAscent();
        if (textAnchor == TextAnchor.TOP_CENTER) return lineMetrics.getAscent();
        if (textAnchor == TextAnchor.TOP_RIGHT) {
            return lineMetrics.getAscent();
        }
        if (textAnchor == TextAnchor.BOTTOM_LEFT) return - lineMetrics.getDescent() - lineMetrics.getLeading();
        if (textAnchor == TextAnchor.BOTTOM_CENTER) return - lineMetrics.getDescent() - lineMetrics.getLeading();
        if (textAnchor != TextAnchor.BOTTOM_RIGHT) return f2;
        return - lineMetrics.getDescent() - lineMetrics.getLeading();
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof TextFragment)) return false;
        TextFragment textFragment = (TextFragment)object;
        if (!this.text.equals(textFragment.text)) {
            return false;
        }
        if (!this.font.equals(textFragment.font)) {
            return false;
        }
        if (this.paint.equals(textFragment.paint)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.text != null ? this.text.hashCode() : 0;
        n2 = 29 * n2 + (this.font != null ? this.font.hashCode() : 0);
        return 29 * n2 + (this.paint != null ? this.paint.hashCode() : 0);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }

    static {
        Class class_ = class$org$jfree$text$TextFragment == null ? (TextFragment.class$org$jfree$text$TextFragment = TextFragment.class$("org.jfree.text.TextFragment")) : class$org$jfree$text$TextFragment;
        logger = Log.createContext(class_);
    }
}

