/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jfree.chart.plot.PieLabelRecord;

public class PieLabelDistributor {
    private List labels;
    private double minGap = 4.0;

    public PieLabelDistributor(int n2) {
        this.labels = new ArrayList(n2);
    }

    public PieLabelRecord getPieLabelRecord(int n2) {
        return (PieLabelRecord)this.labels.get(n2);
    }

    public void addPieLabelRecord(PieLabelRecord pieLabelRecord) {
        this.labels.add(pieLabelRecord);
    }

    public int getItemCount() {
        return this.labels.size();
    }

    public void distributeLabels(double d2, double d3) {
        this.sort();
        if (this.isOverlap()) {
            this.adjustInwards();
        }
        if (this.isOverlap()) {
            this.adjustDownwards(d2, d3);
        }
        if (this.isOverlap()) {
            this.adjustUpwards(d2, d3);
        }
        if (!this.isOverlap()) return;
        this.spreadEvenly(d2, d3);
    }

    private boolean isOverlap() {
        double d2 = 0.0;
        int n2 = 0;
        while (n2 < this.labels.size()) {
            PieLabelRecord pieLabelRecord = this.getPieLabelRecord(n2);
            if (d2 > pieLabelRecord.getLowerY()) {
                return true;
            }
            d2 = pieLabelRecord.getUpperY();
            ++n2;
        }
        return false;
    }

    protected void adjustInwards() {
        int n2 = 0;
        int n3 = this.labels.size() - 1;
        while (n3 > n2) {
            PieLabelRecord pieLabelRecord;
            double d2;
            PieLabelRecord pieLabelRecord2;
            if (n2 < n3 - 1) {
                pieLabelRecord = this.getPieLabelRecord(n2);
                pieLabelRecord2 = this.getPieLabelRecord(n2 + 1);
                if (pieLabelRecord2.getLowerY() < pieLabelRecord.getUpperY()) {
                    d2 = pieLabelRecord.getUpperY() - pieLabelRecord2.getLowerY() + this.minGap;
                    pieLabelRecord2.setAllocatedY(pieLabelRecord2.getAllocatedY() + d2);
                }
            }
            pieLabelRecord = this.getPieLabelRecord(n3 - 1);
            pieLabelRecord2 = this.getPieLabelRecord(n3);
            if (pieLabelRecord.getUpperY() > pieLabelRecord2.getLowerY()) {
                d2 = pieLabelRecord.getUpperY() - pieLabelRecord2.getLowerY() + this.minGap;
                pieLabelRecord.setAllocatedY(pieLabelRecord.getAllocatedY() - d2);
            }
            ++n2;
            --n3;
        }
    }

    protected void adjustDownwards(double d2, double d3) {
        int n2 = 0;
        while (n2 < this.labels.size() - 1) {
            PieLabelRecord pieLabelRecord = this.getPieLabelRecord(n2);
            PieLabelRecord pieLabelRecord2 = this.getPieLabelRecord(n2 + 1);
            if (pieLabelRecord2.getLowerY() < pieLabelRecord.getUpperY()) {
                pieLabelRecord2.setAllocatedY(Math.min(d2 + d3, pieLabelRecord.getUpperY() + this.minGap + pieLabelRecord2.getLabelHeight() / 2.0));
            }
            ++n2;
        }
    }

    protected void adjustUpwards(double d2, double d3) {
        int n2 = this.labels.size() - 1;
        while (n2 > 0) {
            PieLabelRecord pieLabelRecord = this.getPieLabelRecord(n2);
            PieLabelRecord pieLabelRecord2 = this.getPieLabelRecord(n2 - 1);
            if (pieLabelRecord2.getUpperY() > pieLabelRecord.getLowerY()) {
                pieLabelRecord2.setAllocatedY(Math.max(d2, pieLabelRecord.getLowerY() - this.minGap - pieLabelRecord2.getLabelHeight() / 2.0));
            }
            --n2;
        }
    }

    protected void spreadEvenly(double d2, double d3) {
        double d4 = d2;
        double d5 = 0.0;
        for (int i2 = 0; i2 < this.labels.size(); d5 += this.getPieLabelRecord((int)i2).getLabelHeight(), ++i2) {
        }
        double d6 = d3 - d5;
        if (this.labels.size() > 1) {
            d6 /= (double)(this.labels.size() - 1);
        }
        int n2 = 0;
        while (n2 < this.labels.size()) {
            PieLabelRecord pieLabelRecord = this.getPieLabelRecord(n2);
            pieLabelRecord.setAllocatedY(d4 += pieLabelRecord.getLabelHeight() / 2.0);
            d4 = d4 + pieLabelRecord.getLabelHeight() / 2.0 + d6;
            ++n2;
        }
    }

    public void sort() {
        Collections.sort(this.labels);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = 0;
        while (n2 < this.labels.size()) {
            stringBuffer.append(this.getPieLabelRecord(n2).toString()).append("\n");
            ++n2;
        }
        return stringBuffer.toString();
    }
}

