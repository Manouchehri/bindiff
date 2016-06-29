package org.jfree.data.statistics;

import java.io.*;
import org.jfree.data.xy.*;
import org.jfree.data.general.*;
import org.jfree.data.*;
import org.jfree.util.*;
import java.util.*;

public class SimpleHistogramDataset extends AbstractIntervalXYDataset implements Serializable, Cloneable, IntervalXYDataset, PublicCloneable
{
    private static final long serialVersionUID = 7997996479768018443L;
    private Comparable key;
    private List bins;
    private boolean adjustForBinSize;
    
    public SimpleHistogramDataset(final Comparable key) {
        this.key = key;
        this.bins = new ArrayList();
        this.adjustForBinSize = true;
    }
    
    public boolean getAdjustForBinSize() {
        return this.adjustForBinSize;
    }
    
    public void setAdjustForBinSize(final boolean adjustForBinSize) {
        this.adjustForBinSize = adjustForBinSize;
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }
    
    public int getSeriesCount() {
        return 1;
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.key;
    }
    
    public DomainOrder getDomainOrder() {
        return DomainOrder.ASCENDING;
    }
    
    public int getItemCount(final int n) {
        return this.bins.size();
    }
    
    public void addBin(final SimpleHistogramBin simpleHistogramBin) {
        final Iterator<SimpleHistogramBin> iterator = this.bins.iterator();
        while (iterator.hasNext()) {
            if (simpleHistogramBin.overlapsWith(iterator.next())) {
                throw new RuntimeException("Overlapping bin");
            }
        }
        this.bins.add(simpleHistogramBin);
        Collections.sort((List<Comparable>)this.bins);
    }
    
    public void addObservation(final double n) {
        this.addObservation(n, true);
    }
    
    public void addObservation(final double n, final boolean b) {
        int n2 = 0;
        for (Iterator iterator = this.bins.iterator(); iterator.hasNext() && n2 == 0; n2 = 1) {
            final SimpleHistogramBin simpleHistogramBin = iterator.next();
            if (simpleHistogramBin.accepts(n)) {
                simpleHistogramBin.setItemCount(simpleHistogramBin.getItemCount() + 1);
            }
        }
        if (n2 == 0) {
            throw new RuntimeException("No bin.");
        }
        if (b) {
            this.notifyListeners(new DatasetChangeEvent(this, this));
        }
    }
    
    public void addObservations(final double[] array) {
        for (int i = 0; i < array.length; ++i) {
            this.addObservation(array[i], false);
        }
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }
    
    public Number getX(final int n, final int n2) {
        return new Double(this.getXValue(n, n2));
    }
    
    public double getXValue(final int n, final int n2) {
        final SimpleHistogramBin simpleHistogramBin = this.bins.get(n2);
        return (simpleHistogramBin.getLowerBound() + simpleHistogramBin.getUpperBound()) / 2.0;
    }
    
    public Number getY(final int n, final int n2) {
        return new Double(this.getYValue(n, n2));
    }
    
    public double getYValue(final int n, final int n2) {
        final SimpleHistogramBin simpleHistogramBin = this.bins.get(n2);
        if (this.adjustForBinSize) {
            return simpleHistogramBin.getItemCount() / (simpleHistogramBin.getUpperBound() - simpleHistogramBin.getLowerBound());
        }
        return simpleHistogramBin.getItemCount();
    }
    
    public Number getStartX(final int n, final int n2) {
        return new Double(this.getStartXValue(n, n2));
    }
    
    public double getStartXValue(final int n, final int n2) {
        return this.bins.get(n2).getLowerBound();
    }
    
    public Number getEndX(final int n, final int n2) {
        return new Double(this.getEndXValue(n, n2));
    }
    
    public double getEndXValue(final int n, final int n2) {
        return this.bins.get(n2).getUpperBound();
    }
    
    public Number getStartY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    public double getStartYValue(final int n, final int n2) {
        return this.getYValue(n, n2);
    }
    
    public Number getEndY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    public double getEndYValue(final int n, final int n2) {
        return this.getYValue(n, n2);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SimpleHistogramDataset)) {
            return false;
        }
        final SimpleHistogramDataset simpleHistogramDataset = (SimpleHistogramDataset)o;
        return this.key.equals(simpleHistogramDataset.key) && this.adjustForBinSize == simpleHistogramDataset.adjustForBinSize && this.bins.equals(simpleHistogramDataset.bins);
    }
    
    public Object clone() {
        final SimpleHistogramDataset simpleHistogramDataset = (SimpleHistogramDataset)super.clone();
        simpleHistogramDataset.bins = (List)ObjectUtilities.deepClone(this.bins);
        return simpleHistogramDataset;
    }
}
