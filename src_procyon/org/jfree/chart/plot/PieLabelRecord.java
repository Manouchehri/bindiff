package org.jfree.chart.plot;

import org.jfree.text.*;

public class PieLabelRecord implements Comparable
{
    private Comparable key;
    private double angle;
    private double baseY;
    private double allocatedY;
    private TextBox label;
    private double labelHeight;
    private double gap;
    private double linkPercent;
    
    public PieLabelRecord(final Comparable key, final double angle, final double n, final TextBox label, final double labelHeight, final double gap, final double linkPercent) {
        this.key = key;
        this.angle = angle;
        this.baseY = n;
        this.allocatedY = n;
        this.label = label;
        this.labelHeight = labelHeight;
        this.gap = gap;
        this.linkPercent = linkPercent;
    }
    
    public double getBaseY() {
        return this.baseY;
    }
    
    public void setBaseY(final double baseY) {
        this.baseY = baseY;
    }
    
    public double getLowerY() {
        return this.allocatedY - this.labelHeight / 2.0;
    }
    
    public double getUpperY() {
        return this.allocatedY + this.labelHeight / 2.0;
    }
    
    public double getAngle() {
        return this.angle;
    }
    
    public Comparable getKey() {
        return this.key;
    }
    
    public TextBox getLabel() {
        return this.label;
    }
    
    public double getLabelHeight() {
        return this.labelHeight;
    }
    
    public double getAllocatedY() {
        return this.allocatedY;
    }
    
    public void setAllocatedY(final double allocatedY) {
        this.allocatedY = allocatedY;
    }
    
    public double getGap() {
        return this.gap;
    }
    
    public double getLinkPercent() {
        return this.linkPercent;
    }
    
    public int compareTo(final Object o) {
        int n = 0;
        if (o instanceof PieLabelRecord) {
            final PieLabelRecord pieLabelRecord = (PieLabelRecord)o;
            if (this.baseY < pieLabelRecord.baseY) {
                n = -1;
            }
            else if (this.baseY > pieLabelRecord.baseY) {
                n = 1;
            }
        }
        return n;
    }
    
    public String toString() {
        return this.baseY + ", " + this.key.toString();
    }
}
