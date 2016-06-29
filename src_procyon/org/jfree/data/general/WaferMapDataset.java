package org.jfree.data.general;

import org.jfree.data.*;
import java.util.*;

public class WaferMapDataset extends AbstractDataset
{
    private DefaultKeyedValues2D data;
    private int maxChipX;
    private int maxChipY;
    private double chipSpace;
    private Double maxValue;
    private Double minValue;
    private static final double DEFAULT_CHIP_SPACE = 1.0;
    
    public WaferMapDataset(final int n, final int n2) {
        this(n, n2, null);
    }
    
    public WaferMapDataset(final int maxChipX, final int maxChipY, final Number n) {
        this.maxValue = new Double(Double.NEGATIVE_INFINITY);
        this.minValue = new Double(Double.POSITIVE_INFINITY);
        this.data = new DefaultKeyedValues2D();
        this.maxChipX = maxChipX;
        this.maxChipY = maxChipY;
        if (n == null) {
            this.chipSpace = 1.0;
        }
        else {
            this.chipSpace = n.doubleValue();
        }
    }
    
    public void addValue(final Number n, final Comparable comparable, final Comparable comparable2) {
        this.setValue(n, comparable, comparable2);
    }
    
    public void addValue(final int n, final int n2, final int n3) {
        this.setValue(new Double(n), new Integer(n2), new Integer(n3));
    }
    
    public void setValue(final Number n, final Comparable comparable, final Comparable comparable2) {
        this.data.setValue(n, comparable, comparable2);
        if (this.isMaxValue(n)) {
            this.maxValue = (Double)n;
        }
        if (this.isMinValue(n)) {
            this.minValue = (Double)n;
        }
    }
    
    public int getUniqueValueCount() {
        return this.getUniqueValues().size();
    }
    
    public Set getUniqueValues() {
        final TreeSet<Number> set = new TreeSet<Number>();
        for (int i = 0; i < this.data.getRowCount(); ++i) {
            for (int j = 0; j < this.data.getColumnCount(); ++j) {
                final Number value = this.data.getValue(i, j);
                if (value != null) {
                    set.add(value);
                }
            }
        }
        return set;
    }
    
    public Number getChipValue(final int n, final int n2) {
        return this.getChipValue(new Integer(n), new Integer(n2));
    }
    
    public Number getChipValue(final Comparable comparable, final Comparable comparable2) {
        final int rowIndex = this.data.getRowIndex(comparable);
        if (rowIndex < 0) {
            return null;
        }
        final int columnIndex = this.data.getColumnIndex(comparable2);
        if (columnIndex < 0) {
            return null;
        }
        return this.data.getValue(rowIndex, columnIndex);
    }
    
    public boolean isMaxValue(final Number n) {
        return n.doubleValue() > this.maxValue;
    }
    
    public boolean isMinValue(final Number n) {
        return n.doubleValue() < this.minValue;
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
    
    public void setMaxChipX(final int maxChipX) {
        this.maxChipX = maxChipX;
    }
    
    public int getMaxChipY() {
        return this.maxChipY;
    }
    
    public void setMaxChipY(final int maxChipY) {
        this.maxChipY = maxChipY;
    }
    
    public double getChipSpace() {
        return this.chipSpace;
    }
    
    public void setChipSpace(final double chipSpace) {
        this.chipSpace = chipSpace;
    }
}
