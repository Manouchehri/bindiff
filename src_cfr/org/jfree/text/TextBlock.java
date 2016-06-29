/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.text;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.text.TextBlockAnchor;
import org.jfree.text.TextLine;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.Size2D;
import org.jfree.ui.TextAnchor;
import org.jfree.util.Log;
import org.jfree.util.LogContext;
import org.jfree.util.ShapeUtilities;

public class TextBlock
implements Serializable {
    private static final long serialVersionUID = -4333175719424385526L;
    private List lines = new ArrayList();
    private HorizontalAlignment lineAlignment = HorizontalAlignment.CENTER;
    protected static final LogContext logger;
    static Class class$org$jfree$text$TextBlock;

    public HorizontalAlignment getLineAlignment() {
        return this.lineAlignment;
    }

    public void setLineAlignment(HorizontalAlignment horizontalAlignment) {
        if (horizontalAlignment == null) {
            throw new IllegalArgumentException("Null 'alignment' argument.");
        }
        this.lineAlignment = horizontalAlignment;
    }

    public void addLine(String string, Font font, Paint paint) {
        this.addLine(new TextLine(string, font, paint));
    }

    public void addLine(TextLine textLine) {
        this.lines.add(textLine);
    }

    public TextLine getLastLine() {
        TextLine textLine = null;
        int n2 = this.lines.size() - 1;
        if (n2 < 0) return textLine;
        return (TextLine)this.lines.get(n2);
    }

    public List getLines() {
        return Collections.unmodifiableList(this.lines);
    }

    public Size2D calculateDimensions(Graphics2D graphics2D) {
        double d2 = 0.0;
        double d3 = 0.0;
        Iterator iterator = this.lines.iterator();
        do {
            if (!iterator.hasNext()) {
                if (!logger.isDebugEnabled()) return new Size2D(d2, d3);
                logger.debug(new StringBuffer().append("width = ").append(d2).append(", height = ").append(d3).toString());
                return new Size2D(d2, d3);
            }
            TextLine textLine = (TextLine)iterator.next();
            Size2D size2D = textLine.calculateDimensions(graphics2D);
            d2 = Math.max(d2, size2D.getWidth());
            d3 += size2D.getHeight();
        } while (true);
    }

    public Shape calculateBounds(Graphics2D graphics2D, float f2, float f3, TextBlockAnchor textBlockAnchor, float f4, float f5, double d2) {
        Size2D size2D = this.calculateDimensions(graphics2D);
        float[] arrf = this.calculateOffsets(textBlockAnchor, size2D.getWidth(), size2D.getHeight());
        Rectangle2D.Double double_ = new Rectangle2D.Double(f2 + arrf[0], f3 + arrf[1], size2D.getWidth(), size2D.getHeight());
        return ShapeUtilities.rotateShape(double_, d2, f4, f5);
    }

    public void draw(Graphics2D graphics2D, float f2, float f3, TextBlockAnchor textBlockAnchor) {
        this.draw(graphics2D, f2, f3, textBlockAnchor, 0.0f, 0.0f, 0.0);
    }

    public void draw(Graphics2D graphics2D, float f2, float f3, TextBlockAnchor textBlockAnchor, float f4, float f5, double d2) {
        Size2D size2D = this.calculateDimensions(graphics2D);
        float[] arrf = this.calculateOffsets(textBlockAnchor, size2D.getWidth(), size2D.getHeight());
        Iterator iterator = this.lines.iterator();
        float f6 = 0.0f;
        while (iterator.hasNext()) {
            TextLine textLine = (TextLine)iterator.next();
            Size2D size2D2 = textLine.calculateDimensions(graphics2D);
            float f7 = 0.0f;
            if (this.lineAlignment == HorizontalAlignment.CENTER) {
                f7 = (float)(size2D.getWidth() - size2D2.getWidth()) / 2.0f;
            } else if (this.lineAlignment == HorizontalAlignment.RIGHT) {
                f7 = (float)(size2D.getWidth() - size2D2.getWidth());
            }
            textLine.draw(graphics2D, f2 + arrf[0] + f7, f3 + arrf[1] + f6, TextAnchor.TOP_LEFT, f4, f5, d2);
            f6 += (float)size2D2.getHeight();
        }
    }

    private float[] calculateOffsets(TextBlockAnchor textBlockAnchor, double d2, double d3) {
        float[] arrf = new float[2];
        float f2 = 0.0f;
        float f3 = 0.0f;
        if (textBlockAnchor == TextBlockAnchor.TOP_CENTER || textBlockAnchor == TextBlockAnchor.CENTER || textBlockAnchor == TextBlockAnchor.BOTTOM_CENTER) {
            f2 = (float)(- d2) / 2.0f;
        } else if (textBlockAnchor == TextBlockAnchor.TOP_RIGHT || textBlockAnchor == TextBlockAnchor.CENTER_RIGHT || textBlockAnchor == TextBlockAnchor.BOTTOM_RIGHT) {
            f2 = (float)(- d2);
        }
        if (textBlockAnchor == TextBlockAnchor.TOP_LEFT || textBlockAnchor == TextBlockAnchor.TOP_CENTER || textBlockAnchor == TextBlockAnchor.TOP_RIGHT) {
            f3 = 0.0f;
        } else if (textBlockAnchor == TextBlockAnchor.CENTER_LEFT || textBlockAnchor == TextBlockAnchor.CENTER || textBlockAnchor == TextBlockAnchor.CENTER_RIGHT) {
            f3 = (float)(- d3) / 2.0f;
        } else if (textBlockAnchor == TextBlockAnchor.BOTTOM_LEFT || textBlockAnchor == TextBlockAnchor.BOTTOM_CENTER || textBlockAnchor == TextBlockAnchor.BOTTOM_RIGHT) {
            f3 = (float)(- d3);
        }
        arrf[0] = f2;
        arrf[1] = f3;
        return arrf;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TextBlock)) return false;
        TextBlock textBlock = (TextBlock)object;
        return this.lines.equals(textBlock.lines);
    }

    public int hashCode() {
        if (this.lines == null) return 0;
        int n2 = this.lines.hashCode();
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
        Class class_ = class$org$jfree$text$TextBlock == null ? (TextBlock.class$org$jfree$text$TextBlock = TextBlock.class$("org.jfree.text.TextBlock")) : class$org$jfree$text$TextBlock;
        logger = Log.createContext(class_);
    }
}

