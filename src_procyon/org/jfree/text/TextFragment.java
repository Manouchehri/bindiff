package org.jfree.text;

import org.jfree.ui.*;
import java.awt.geom.*;
import java.awt.font.*;
import org.jfree.io.*;
import java.io.*;
import java.awt.*;
import org.jfree.util.*;

public class TextFragment implements Serializable
{
    private static final long serialVersionUID = 4465945952903143262L;
    public static final Font DEFAULT_FONT;
    public static final Paint DEFAULT_PAINT;
    private String text;
    private Font font;
    private transient Paint paint;
    private float baselineOffset;
    protected static final LogContext logger;
    static Class class$org$jfree$text$TextFragment;
    
    public TextFragment(final String s) {
        this(s, TextFragment.DEFAULT_FONT, TextFragment.DEFAULT_PAINT);
    }
    
    public TextFragment(final String s, final Font font) {
        this(s, font, TextFragment.DEFAULT_PAINT);
    }
    
    public TextFragment(final String s, final Font font, final Paint paint) {
        this(s, font, paint, 0.0f);
    }
    
    public TextFragment(final String text, final Font font, final Paint paint, final float baselineOffset) {
        if (text == null) {
            throw new IllegalArgumentException("Null 'text' argument.");
        }
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.text = text;
        this.font = font;
        this.paint = paint;
        this.baselineOffset = baselineOffset;
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
    
    public void draw(final Graphics2D graphics2D, final float n, final float n2, final TextAnchor textAnchor, final float n3, final float n4, final double n5) {
        graphics2D.setFont(this.font);
        graphics2D.setPaint(this.paint);
        TextUtilities.drawRotatedString(this.text, graphics2D, n, n2 + this.baselineOffset, textAnchor, n5, n3, n4);
    }
    
    public Size2D calculateDimensions(final Graphics2D graphics2D) {
        final Rectangle2D textBounds = TextUtilities.getTextBounds(this.text, graphics2D, graphics2D.getFontMetrics(this.font));
        return new Size2D(textBounds.getWidth(), textBounds.getHeight());
    }
    
    public float calculateBaselineOffset(final Graphics2D graphics2D, final TextAnchor textAnchor) {
        float ascent = 0.0f;
        final LineMetrics lineMetrics = graphics2D.getFontMetrics(this.font).getLineMetrics("ABCxyz", graphics2D);
        if (textAnchor == TextAnchor.TOP_LEFT || textAnchor == TextAnchor.TOP_CENTER || textAnchor == TextAnchor.TOP_RIGHT) {
            ascent = lineMetrics.getAscent();
        }
        else if (textAnchor == TextAnchor.BOTTOM_LEFT || textAnchor == TextAnchor.BOTTOM_CENTER || textAnchor == TextAnchor.BOTTOM_RIGHT) {
            ascent = -lineMetrics.getDescent() - lineMetrics.getLeading();
        }
        return ascent;
    }
    
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o instanceof TextFragment) {
            final TextFragment textFragment = (TextFragment)o;
            return this.text.equals(textFragment.text) && this.font.equals(textFragment.font) && this.paint.equals(textFragment.paint);
        }
        return false;
    }
    
    public int hashCode() {
        return 29 * (29 * ((this.text != null) ? this.text.hashCode() : 0) + ((this.font != null) ? this.font.hashCode() : 0)) + ((this.paint != null) ? this.paint.hashCode() : 0);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        DEFAULT_FONT = new Font("Serif", 0, 12);
        DEFAULT_PAINT = Color.black;
        logger = Log.createContext((TextFragment.class$org$jfree$text$TextFragment == null) ? (TextFragment.class$org$jfree$text$TextFragment = class$("org.jfree.text.TextFragment")) : TextFragment.class$org$jfree$text$TextFragment);
    }
}
