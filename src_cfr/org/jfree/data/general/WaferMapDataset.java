/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.general;

import java.util.Set;
import java.util.TreeSet;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.general.AbstractDataset;

public class WaferMapDataset
extends AbstractDataset {
    private DefaultKeyedValues2D data = new DefaultKeyedValues2D();
    private int maxChipX;
    private int maxChipY;
    private double chipSpace;
    private Double maxValue = new Double(Double.NEGATIVE_INFINITY);
    private Double minValue = new Double(Double.POSITIVE_INFINITY);
    private static final double DEFAULT_CHIP_SPACE = 1.0;

    public WaferMapDataset(int n2, int n3) {
        this(n2, n3, null);
    }

    public WaferMapDataset(int n2, int n3, Number number) {
        this.maxChipX = n2;
        this.maxChipY = n3;
        if (number == null) {
            this.chipSpace = 1.0;
            return;
        }
        this.chipSpace = number.doubleValue();
    }

    public void addValue(Number number, Comparable comparable, Comparable comparable2) {
        this.setValue(number, comparable, comparable2);
    }

    public void addValue(int n2, int n3, int n4) {
        this.setValue(new Double(n2), new Integer(n3), new Integer(n4));
    }

    public void setValue(Number number, Comparable comparable, Comparable comparable2) {
        this.data.setValue(number, comparable, comparable2);
        if (this.isMaxValue(number)) {
            this.maxValue = (Double)number;
        }
        if (!this.isMinValue(number)) return;
        this.minValue = (Double)number;
    }

    public int getUniqueValueCount() {
        return this.getUniqueValues().size();
    }

    public Set getUniqueValues() {
        TreeSet<Number> treeSet = new TreeSet<Number>();
        int n2 = 0;
        while (n2 < this.data.getRowCount()) {
            for (int i2 = 0; i2 < this.data.getColumnCount(); ++i2) {
                Number number = this.data.getValue(n2, i2);
                if (number == null) continue;
                treeSet.add(number);
            }
            ++n2;
        }
        return treeSet;
    }

    public Number getChipValue(int n2, int n3) {
        return this.getChipValue(new Integer(n2), new Integer(n3));
    }

    public Number getChipValue(Comparable comparable, Comparable comparable2) {
        int n2 = this.data.getRowIndex(comparable);
        if (n2 < 0) {
            return null;
        }
        int n3 = this.data.getColumnIndex(comparable2);
        if (n3 >= 0) return this.data.getValue(n2, n3);
        return null;
    }

    public boolean isMaxValue(Number number) {
        if (number.doubleValue() <= this.maxValue) return false;
        return true;
    }

    public boolean isMinValue(Number number) {
        if (number.doubleValue() >= this.minValue) return false;
        return true;
    }

    public Number getMaxValue() {
        return this.maxValue;
    }

    public Number getMinValue() {
        return this.minValue;
    }

    public int getMaxChipX() {
        return this.maxChipX;
    }

    public void setMaxChipX(int n2) {
        this.maxChipX = n2;
    }

    public int getMaxChipY() {
        return this.maxChipY;
    }

    public void setMaxChipY(int n2) {
        this.maxChipY = n2;
    }

    public double getChipSpace() {
        return this.chipSpace;
    }

    public void setChipSpace(double d2) {
        this.chipSpace = d2;
    }
}

