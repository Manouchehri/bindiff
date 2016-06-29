package org.jfree.text;

import java.awt.*;

public class G2TextMeasurer implements TextMeasurer
{
    private Graphics2D g2;
    
    public G2TextMeasurer(final Graphics2D g2) {
        this.g2 = g2;
    }
    
    public float getStringWidth(final String s, final int n, final int n2) {
        return (float)TextUtilities.getTextBounds(s.substring(n, n2), this.g2, this.g2.getFontMetrics()).getWidth();
    }
}
