/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.text;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import org.jfree.text.TextMeasurer;
import org.jfree.text.TextUtilities;

public class G2TextMeasurer
implements TextMeasurer {
    private Graphics2D g2;

    public G2TextMeasurer(Graphics2D graphics2D) {
        this.g2 = graphics2D;
    }

    @Override
    public float getStringWidth(String string, int n2, int n3) {
        FontMetrics fontMetrics = this.g2.getFontMetrics();
        Rectangle2D rectangle2D = TextUtilities.getTextBounds(string.substring(n2, n3), this.g2, fontMetrics);
        return (float)rectangle2D.getWidth();
    }
}

