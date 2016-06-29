package org.jfree.chart.entity;

import java.io.*;
import java.awt.*;

public class LegendItemEntity extends ChartEntity implements Serializable, Cloneable
{
    private static final long serialVersionUID = -7435683933545666702L;
    private int seriesIndex;
    
    public LegendItemEntity(final Shape shape) {
        super(shape);
    }
    
    public int getSeriesIndex() {
        return this.seriesIndex;
    }
    
    public void setSeriesIndex(final int seriesIndex) {
        this.seriesIndex = seriesIndex;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof LegendItemEntity && super.equals(o) && this.seriesIndex == ((LegendItemEntity)o).seriesIndex);
    }
    
    public Object clone() {
        return super.clone();
    }
}
