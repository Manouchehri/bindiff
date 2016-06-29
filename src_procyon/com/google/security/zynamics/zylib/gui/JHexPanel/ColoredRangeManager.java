package com.google.security.zynamics.zylib.gui.JHexPanel;

import java.util.*;

public class ColoredRangeManager
{
    private final ArrayList ranges;
    
    public ColoredRangeManager() {
        this.ranges = new ArrayList();
    }
    
    public void addRange(final ColoredRange coloredRange) {
        this.ranges.add(coloredRange);
        Collections.sort((List<Comparable>)this.ranges);
    }
    
    public void clear() {
        this.ranges.clear();
    }
    
    public ColoredRange findRange(final long n) {
        for (final ColoredRange coloredRange : this.ranges) {
            if (coloredRange.getStart() >= n) {
                return coloredRange;
            }
        }
        return null;
    }
    
    public ColoredRange findRangeWith(final long n) {
        for (final ColoredRange coloredRange : this.ranges) {
            if (coloredRange.containsOffset(n)) {
                return coloredRange;
            }
        }
        return null;
    }
    
    public void removeRange(final long n, final int n2) {
        ColoredRange coloredRange = this.findRangeWith(n);
        if (coloredRange == null) {
            coloredRange = this.findRange(n);
        }
        if (coloredRange == null) {
            return;
        }
        if (n <= coloredRange.getStart()) {
            if (coloredRange.getSize() == n2) {
                this.ranges.remove(coloredRange);
            }
            else if (coloredRange.getSize() < n2) {
                this.ranges.remove(coloredRange);
                this.removeRange(coloredRange.getStart() + coloredRange.getSize(), n2 - coloredRange.getSize());
            }
            else {
                this.ranges.remove(coloredRange);
                this.addRange(new ColoredRange(n + n2, coloredRange.getSize() - n2, coloredRange.getColor(), coloredRange.getBackgroundColor()));
            }
        }
        else if (n + n2 == coloredRange.getStart() + coloredRange.getSize()) {
            this.ranges.remove(coloredRange);
            this.addRange(new ColoredRange(coloredRange.getStart(), coloredRange.getSize() - n2, coloredRange.getColor(), coloredRange.getBackgroundColor()));
        }
        else if (n + n2 < coloredRange.getStart() + coloredRange.getSize()) {
            this.ranges.remove(coloredRange);
            this.addRange(new ColoredRange(coloredRange.getStart(), (int)(n - coloredRange.getStart()), coloredRange.getColor(), coloredRange.getBackgroundColor()));
            this.addRange(new ColoredRange(n + n2, (int)(coloredRange.getStart() + coloredRange.getSize() - n - n2), coloredRange.getColor(), coloredRange.getBackgroundColor()));
        }
        else {
            this.ranges.remove(coloredRange);
            this.addRange(new ColoredRange(coloredRange.getStart(), (int)(n - coloredRange.getStart()), coloredRange.getColor(), coloredRange.getBackgroundColor()));
            this.removeRange(coloredRange.getStart() + coloredRange.getSize(), n2 - (int)(coloredRange.getStart() + coloredRange.getSize() - n));
        }
    }
}
