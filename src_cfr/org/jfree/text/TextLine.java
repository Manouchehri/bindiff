/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.text;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.text.TextFragment;
import org.jfree.ui.Size2D;
import org.jfree.ui.TextAnchor;
import org.jfree.util.Log;
import org.jfree.util.LogContext;

public class TextLine
implements Serializable {
    private static final long serialVersionUID = 7100085690160465444L;
    private List fragments;
    protected static final LogContext logger;
    static Class class$org$jfree$text$TextLine;

    public TextLine() {
        this.fragments = new ArrayList();
    }

    public TextLine(String string) {
        this(string, TextFragment.DEFAULT_FONT);
    }

    public TextLine(String string, Font font) {
        this.fragments = new ArrayList();
        TextFragment textFragment = new TextFragment(string, font);
        this.fragments.add(textFragment);
    }

    public TextLine(String string, Font font, Paint paint) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'text' argument.");
        }
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.fragments = new ArrayList();
        TextFragment textFragment = new TextFragment(string, font, paint);
        this.fragments.add(textFragment);
    }

    public void addFragment(TextFragment textFragment) {
        this.fragments.add(textFragment);
    }

    public void removeFragment(TextFragment textFragment) {
        this.fragments.remove(textFragment);
    }

    public void draw(Graphics2D graphics2D, float f2, float f3, TextAnchor textAnchor, float f4, float f5, double d2) {
        float f6 = f2;
        float f7 = this.calculateBaselineOffset(graphics2D, textAnchor);
        Iterator iterator = this.fragments.iterator();
        while (iterator.hasNext()) {
            TextFragment textFragment = (TextFragment)iterator.next();
            Size2D size2D = textFragment.calculateDimensions(graphics2D);
            textFragment.draw(graphics2D, f6, f3 + f7, TextAnchor.BASELINE_LEFT, f4, f5, d2);
            f6 += (float)size2D.getWidth();
        }
    }

    public Size2D calculateDimensions(Graphics2D graphics2D) {
        double d2 = 0.0;
        double d3 = 0.0;
        Iterator iterator = this.fragments.iterator();
        while (iterator.hasNext()) {
            TextFragment textFragment = (TextFragment)iterator.next();
            Size2D size2D = textFragment.calculateDimensions(graphics2D);
            d2 += size2D.getWidth();
            d3 = Math.max(d3, size2D.getHeight());
            if (!logger.isDebugEnabled()) continue;
            logger.debug(new StringBuffer().append("width = ").append(d2).append(", height = ").append(d3).toString());
        }
        return new Size2D(d2, d3);
    }

    public TextFragment getFirstTextFragment() {
        TextFragment textFragment = null;
        if (this.fragments.size() <= 0) return textFragment;
        return (TextFragment)this.fragments.get(0);
    }

    public TextFragment getLastTextFragment() {
        TextFragment textFragment = null;
        if (this.fragments.size() <= 0) return textFragment;
        return (TextFragment)this.fragments.get(this.fragments.size() - 1);
    }

    private float calculateBaselineOffset(Graphics2D graphics2D, TextAnchor textAnchor) {
        float f2 = 0.0f;
        Iterator iterator = this.fragments.iterator();
        while (iterator.hasNext()) {
            TextFragment textFragment = (TextFragment)iterator.next();
            f2 = Math.max(f2, textFragment.calculateBaselineOffset(graphics2D, textAnchor));
        }
        return f2;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof TextLine)) return false;
        TextLine textLine = (TextLine)object;
        return this.fragments.equals(textLine.fragments);
    }

    public int hashCode() {
        if (this.fragments == null) return 0;
        int n2 = this.fragments.hashCode();
        return n2;
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
        Class class_ = class$org$jfree$text$TextLine == null ? (TextLine.class$org$jfree$text$TextLine = TextLine.class$("org.jfree.text.TextLine")) : class$org$jfree$text$TextLine;
        logger = Log.createContext(class_);
    }
}

