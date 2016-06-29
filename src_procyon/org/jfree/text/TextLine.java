package org.jfree.text;

import java.io.*;
import java.awt.*;
import java.util.*;
import org.jfree.ui.*;
import org.jfree.util.*;

public class TextLine implements Serializable
{
    private static final long serialVersionUID = 7100085690160465444L;
    private List fragments;
    protected static final LogContext logger;
    static Class class$org$jfree$text$TextLine;
    
    public TextLine() {
        this.fragments = new ArrayList();
    }
    
    public TextLine(final String s) {
        this(s, TextFragment.DEFAULT_FONT);
    }
    
    public TextLine(final String s, final Font font) {
        (this.fragments = new ArrayList()).add(new TextFragment(s, font));
    }
    
    public TextLine(final String s, final Font font, final Paint paint) {
        if (s == null) {
            throw new IllegalArgumentException("Null 'text' argument.");
        }
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        (this.fragments = new ArrayList()).add(new TextFragment(s, font, paint));
    }
    
    public void addFragment(final TextFragment textFragment) {
        this.fragments.add(textFragment);
    }
    
    public void removeFragment(final TextFragment textFragment) {
        this.fragments.remove(textFragment);
    }
    
    public void draw(final Graphics2D graphics2D, final float n, final float n2, final TextAnchor textAnchor, final float n3, final float n4, final double n5) {
        float n6 = n;
        final float calculateBaselineOffset = this.calculateBaselineOffset(graphics2D, textAnchor);
        for (final TextFragment textFragment : this.fragments) {
            final Size2D calculateDimensions = textFragment.calculateDimensions(graphics2D);
            textFragment.draw(graphics2D, n6, n2 + calculateBaselineOffset, TextAnchor.BASELINE_LEFT, n3, n4, n5);
            n6 += (float)calculateDimensions.getWidth();
        }
    }
    
    public Size2D calculateDimensions(final Graphics2D graphics2D) {
        double n = 0.0;
        double max = 0.0;
        final Iterator<TextFragment> iterator = this.fragments.iterator();
        while (iterator.hasNext()) {
            final Size2D calculateDimensions = iterator.next().calculateDimensions(graphics2D);
            n += calculateDimensions.getWidth();
            max = Math.max(max, calculateDimensions.getHeight());
            if (TextLine.logger.isDebugEnabled()) {
                TextLine.logger.debug("width = " + n + ", height = " + max);
            }
        }
        return new Size2D(n, max);
    }
    
    public TextFragment getFirstTextFragment() {
        TextFragment textFragment = null;
        if (this.fragments.size() > 0) {
            textFragment = this.fragments.get(0);
        }
        return textFragment;
    }
    
    public TextFragment getLastTextFragment() {
        TextFragment textFragment = null;
        if (this.fragments.size() > 0) {
            textFragment = this.fragments.get(this.fragments.size() - 1);
        }
        return textFragment;
    }
    
    private float calculateBaselineOffset(final Graphics2D graphics2D, final TextAnchor textAnchor) {
        float max = 0.0f;
        final Iterator<TextFragment> iterator = this.fragments.iterator();
        while (iterator.hasNext()) {
            max = Math.max(max, iterator.next().calculateBaselineOffset(graphics2D, textAnchor));
        }
        return max;
    }
    
    public boolean equals(final Object o) {
        return o != null && (o == this || (o instanceof TextLine && this.fragments.equals(((TextLine)o).fragments)));
    }
    
    public int hashCode() {
        return (this.fragments != null) ? this.fragments.hashCode() : 0;
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
        logger = Log.createContext((TextLine.class$org$jfree$text$TextLine == null) ? (TextLine.class$org$jfree$text$TextLine = class$("org.jfree.text.TextLine")) : TextLine.class$org$jfree$text$TextLine);
    }
}
