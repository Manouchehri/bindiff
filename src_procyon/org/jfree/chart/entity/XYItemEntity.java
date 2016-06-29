package org.jfree.chart.entity;

import org.jfree.data.xy.*;
import java.awt.*;

public class XYItemEntity extends ChartEntity
{
    private static final long serialVersionUID = -3870862224880283771L;
    private transient XYDataset dataset;
    private int series;
    private int item;
    
    public XYItemEntity(final Shape shape, final XYDataset dataset, final int series, final int item, final String s, final String s2) {
        super(shape, s, s2);
        this.dataset = dataset;
        this.series = series;
        this.item = item;
    }
    
    public XYDataset getDataset() {
        return this.dataset;
    }
    
    public void setDataset(final XYDataset dataset) {
        this.dataset = dataset;
    }
    
    public int getSeriesIndex() {
        return this.series;
    }
    
    public void setSeriesIndex(final int series) {
        this.series = series;
    }
    
    public int getItem() {
        return this.item;
    }
    
    public void setItem(final int item) {
        this.item = item;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof XYItemEntity && super.equals(o)) {
            final XYItemEntity xyItemEntity = (XYItemEntity)o;
            return this.series == xyItemEntity.series && this.item == xyItemEntity.item;
        }
        return false;
    }
    
    public String toString() {
        return "XYItemEntity: series = " + this.getSeriesIndex() + ", item = " + this.getItem() + ", dataset = " + this.getDataset();
    }
}
