/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.JHexPanel.ColoredRange;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ColoredRangeManager {
    private final ArrayList ranges = new ArrayList();

    public void addRange(ColoredRange coloredRange) {
        this.ranges.add(coloredRange);
        Collections.sort(this.ranges);
    }

    public void clear() {
        this.ranges.clear();
    }

    public ColoredRange findRange(long l2) {
        ColoredRange coloredRange;
        Iterator iterator = this.ranges.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while ((coloredRange = (ColoredRange)iterator.next()).getStart() < l2);
        return coloredRange;
    }

    public ColoredRange findRangeWith(long l2) {
        ColoredRange coloredRange;
        Iterator iterator = this.ranges.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!(coloredRange = (ColoredRange)iterator.next()).containsOffset(l2));
        return coloredRange;
    }

    public void removeRange(long l2, int n2) {
        ColoredRange coloredRange = this.findRangeWith(l2);
        if (coloredRange == null) {
            coloredRange = this.findRange(l2);
        }
        if (coloredRange == null) {
            return;
        }
        if (l2 <= coloredRange.getStart()) {
            if (coloredRange.getSize() == n2) {
                this.ranges.remove(coloredRange);
                return;
            }
            if (coloredRange.getSize() < n2) {
                this.ranges.remove(coloredRange);
                this.removeRange(coloredRange.getStart() + (long)coloredRange.getSize(), n2 - coloredRange.getSize());
                return;
            }
            this.ranges.remove(coloredRange);
            this.addRange(new ColoredRange(l2 + (long)n2, coloredRange.getSize() - n2, coloredRange.getColor(), coloredRange.getBackgroundColor()));
            return;
        }
        if (l2 + (long)n2 == coloredRange.getStart() + (long)coloredRange.getSize()) {
            this.ranges.remove(coloredRange);
            long l3 = coloredRange.getStart();
            int n3 = coloredRange.getSize() - n2;
            this.addRange(new ColoredRange(l3, n3, coloredRange.getColor(), coloredRange.getBackgroundColor()));
            return;
        }
        if (l2 + (long)n2 < coloredRange.getStart() + (long)coloredRange.getSize()) {
            this.ranges.remove(coloredRange);
            long l4 = coloredRange.getStart();
            int n4 = (int)(l2 - coloredRange.getStart());
            this.addRange(new ColoredRange(l4, n4, coloredRange.getColor(), coloredRange.getBackgroundColor()));
            long l5 = l2 + (long)n2;
            int n5 = (int)(coloredRange.getStart() + (long)coloredRange.getSize() - l2 - (long)n2);
            this.addRange(new ColoredRange(l5, n5, coloredRange.getColor(), coloredRange.getBackgroundColor()));
            return;
        }
        this.ranges.remove(coloredRange);
        long l6 = coloredRange.getStart();
        int n6 = (int)(l2 - coloredRange.getStart());
        this.addRange(new ColoredRange(l6, n6, coloredRange.getColor(), coloredRange.getBackgroundColor()));
        this.removeRange(coloredRange.getStart() + (long)coloredRange.getSize(), n2 - (int)(coloredRange.getStart() + (long)coloredRange.getSize() - l2));
    }
}

