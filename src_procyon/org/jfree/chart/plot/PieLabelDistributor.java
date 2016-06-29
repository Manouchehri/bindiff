package org.jfree.chart.plot;

import java.util.*;

public class PieLabelDistributor
{
    private List labels;
    private double minGap;
    
    public PieLabelDistributor(final int n) {
        this.minGap = 4.0;
        this.labels = new ArrayList(n);
    }
    
    public PieLabelRecord getPieLabelRecord(final int n) {
        return this.labels.get(n);
    }
    
    public void addPieLabelRecord(final PieLabelRecord pieLabelRecord) {
        this.labels.add(pieLabelRecord);
    }
    
    public int getItemCount() {
        return this.labels.size();
    }
    
    public void distributeLabels(final double n, final double n2) {
        this.sort();
        if (this.isOverlap()) {
            this.adjustInwards();
        }
        if (this.isOverlap()) {
            this.adjustDownwards(n, n2);
        }
        if (this.isOverlap()) {
            this.adjustUpwards(n, n2);
        }
        if (this.isOverlap()) {
            this.spreadEvenly(n, n2);
        }
    }
    
    private boolean isOverlap() {
        double upperY = 0.0;
        for (int i = 0; i < this.labels.size(); ++i) {
            final PieLabelRecord pieLabelRecord = this.getPieLabelRecord(i);
            if (upperY > pieLabelRecord.getLowerY()) {
                return true;
            }
            upperY = pieLabelRecord.getUpperY();
        }
        return false;
    }
    
    protected void adjustInwards() {
        for (int n = 0, i = this.labels.size() - 1; i > n; ++n, --i) {
            if (n < i - 1) {
                final PieLabelRecord pieLabelRecord = this.getPieLabelRecord(n);
                final PieLabelRecord pieLabelRecord2 = this.getPieLabelRecord(n + 1);
                if (pieLabelRecord2.getLowerY() < pieLabelRecord.getUpperY()) {
                    pieLabelRecord2.setAllocatedY(pieLabelRecord2.getAllocatedY() + (pieLabelRecord.getUpperY() - pieLabelRecord2.getLowerY() + this.minGap));
                }
            }
            final PieLabelRecord pieLabelRecord3 = this.getPieLabelRecord(i - 1);
            final PieLabelRecord pieLabelRecord4 = this.getPieLabelRecord(i);
            if (pieLabelRecord3.getUpperY() > pieLabelRecord4.getLowerY()) {
                pieLabelRecord3.setAllocatedY(pieLabelRecord3.getAllocatedY() - (pieLabelRecord3.getUpperY() - pieLabelRecord4.getLowerY() + this.minGap));
            }
        }
    }
    
    protected void adjustDownwards(final double n, final double n2) {
        for (int i = 0; i < this.labels.size() - 1; ++i) {
            final PieLabelRecord pieLabelRecord = this.getPieLabelRecord(i);
            final PieLabelRecord pieLabelRecord2 = this.getPieLabelRecord(i + 1);
            if (pieLabelRecord2.getLowerY() < pieLabelRecord.getUpperY()) {
                pieLabelRecord2.setAllocatedY(Math.min(n + n2, pieLabelRecord.getUpperY() + this.minGap + pieLabelRecord2.getLabelHeight() / 2.0));
            }
        }
    }
    
    protected void adjustUpwards(final double n, final double n2) {
        for (int i = this.labels.size() - 1; i > 0; --i) {
            final PieLabelRecord pieLabelRecord = this.getPieLabelRecord(i);
            final PieLabelRecord pieLabelRecord2 = this.getPieLabelRecord(i - 1);
            if (pieLabelRecord2.getUpperY() > pieLabelRecord.getLowerY()) {
                pieLabelRecord2.setAllocatedY(Math.max(n, pieLabelRecord.getLowerY() - this.minGap - pieLabelRecord2.getLabelHeight() / 2.0));
            }
        }
    }
    
    protected void spreadEvenly(final double n, final double n2) {
        double n3 = n;
        double n4 = 0.0;
        for (int i = 0; i < this.labels.size(); ++i) {
            n4 += this.getPieLabelRecord(i).getLabelHeight();
        }
        double n5 = n2 - n4;
        if (this.labels.size() > 1) {
            n5 /= this.labels.size() - 1;
        }
        for (int j = 0; j < this.labels.size(); ++j) {
            final PieLabelRecord pieLabelRecord = this.getPieLabelRecord(j);
            final double allocatedY = n3 + pieLabelRecord.getLabelHeight() / 2.0;
            pieLabelRecord.setAllocatedY(allocatedY);
            n3 = allocatedY + pieLabelRecord.getLabelHeight() / 2.0 + n5;
        }
    }
    
    public void sort() {
        Collections.sort((List<Comparable>)this.labels);
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.labels.size(); ++i) {
            sb.append(this.getPieLabelRecord(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
