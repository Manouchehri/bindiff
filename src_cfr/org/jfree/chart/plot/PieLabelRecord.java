/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import org.jfree.text.TextBox;

public class PieLabelRecord
implements Comparable {
    private Comparable key;
    private double angle;
    private double baseY;
    private double allocatedY;
    private TextBox label;
    private double labelHeight;
    private double gap;
    private double linkPercent;

    public PieLabelRecord(Comparable comparable, double d2, double d3, TextBox textBox, double d4, double d5, double d6) {
        this.key = comparable;
        this.angle = d2;
        this.baseY = d3;
        this.allocatedY = d3;
        this.label = textBox;
        this.labelHeight = d4;
        this.gap = d5;
        this.linkPercent = d6;
    }

    public double getBaseY() {
        return this.baseY;
    }

    public void setBaseY(double d2) {
        this.baseY = d2;
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

    public void setAllocatedY(double d2) {
        this.allocatedY = d2;
    }

    public double getGap() {
        return this.gap;
    }

    public double getLinkPercent() {
        return this.linkPercent;
    }

    public int compareTo(Object object) {
        int n2 = 0;
        if (!(object instanceof PieLabelRecord)) return n2;
        PieLabelRecord pieLabelRecord = (PieLabelRecord)object;
        if (this.baseY < pieLabelRecord.baseY) {
            return -1;
        }
        if (this.baseY <= pieLabelRecord.baseY) return n2;
        return 1;
    }

    public String toString() {
        return new StringBuffer().append(this.baseY).append(", ").append(this.key.toString()).toString();
    }
}

