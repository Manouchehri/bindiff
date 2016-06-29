package org.jfree.chart.renderer.xy;

import org.jfree.data.xy.*;
import org.jfree.data.*;
import org.jfree.data.general.*;

public class CyclicXYItemRenderer$OverwriteDataSet implements XYDataset
{
    protected XYDataset delegateSet;
    Double[] x;
    Double[] y;
    
    public CyclicXYItemRenderer$OverwriteDataSet(final double[] array, final double[] array2, final XYDataset delegateSet) {
        this.delegateSet = delegateSet;
        this.x = new Double[array.length];
        this.y = new Double[array2.length];
        for (int i = 0; i < array.length; ++i) {
            this.x[i] = new Double(array[i]);
            this.y[i] = new Double(array2[i]);
        }
    }
    
    public DomainOrder getDomainOrder() {
        return DomainOrder.NONE;
    }
    
    public int getItemCount(final int n) {
        return this.x.length;
    }
    
    public Number getX(final int n, final int n2) {
        return this.x[n2];
    }
    
    public double getXValue(final int n, final int n2) {
        double doubleValue = Double.NaN;
        final Number x = this.getX(n, n2);
        if (x != null) {
            doubleValue = x.doubleValue();
        }
        return doubleValue;
    }
    
    public Number getY(final int n, final int n2) {
        return this.y[n2];
    }
    
    public double getYValue(final int n, final int n2) {
        double doubleValue = Double.NaN;
        final Number y = this.getY(n, n2);
        if (y != null) {
            doubleValue = y.doubleValue();
        }
        return doubleValue;
    }
    
    public int getSeriesCount() {
        return this.delegateSet.getSeriesCount();
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.delegateSet.getSeriesKey(n);
    }
    
    public int indexOf(final Comparable comparable) {
        return this.delegateSet.indexOf(comparable);
    }
    
    public void addChangeListener(final DatasetChangeListener datasetChangeListener) {
    }
    
    public void removeChangeListener(final DatasetChangeListener datasetChangeListener) {
    }
    
    public DatasetGroup getGroup() {
        return this.delegateSet.getGroup();
    }
    
    public void setGroup(final DatasetGroup datasetGroup) {
    }
}
