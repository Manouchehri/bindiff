package org.jfree.data.statistics;

import java.io.*;
import org.jfree.data.xy.*;
import org.jfree.data.general.*;
import java.util.*;
import org.jfree.util.*;

public class HistogramDataset extends AbstractIntervalXYDataset implements Serializable, Cloneable, IntervalXYDataset, PublicCloneable
{
    private static final long serialVersionUID = -6341668077370231153L;
    private List list;
    private HistogramType type;
    
    public HistogramDataset() {
        this.list = new ArrayList();
        this.type = HistogramType.FREQUENCY;
    }
    
    public HistogramType getType() {
        return this.type;
    }
    
    public void setType(final HistogramType type) {
        if (type == null) {
            throw new IllegalArgumentException("Null 'type' argument");
        }
        this.type = type;
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }
    
    public void addSeries(final Comparable comparable, final double[] array, final int n) {
        this.addSeries(comparable, array, n, this.getMinimum(array), this.getMaximum(array));
    }
    
    public void addSeries(final Comparable comparable, final double[] array, final int n, final double n2, final double n3) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        if (array == null) {
            throw new IllegalArgumentException("Null 'values' argument.");
        }
        if (n < 1) {
            throw new IllegalArgumentException("The 'bins' value must be at least 1.");
        }
        final double n4 = (n3 - n2) / n;
        double n5 = n2;
        final ArrayList list = new ArrayList<Object>(n);
        for (int i = 0; i < n; ++i) {
            HistogramBin histogramBin;
            if (i == n - 1) {
                histogramBin = new HistogramBin(n5, n3);
            }
            else {
                final double n6 = n2 + (i + 1) * n4;
                histogramBin = new HistogramBin(n5, n6);
                n5 = n6;
            }
            list.add(histogramBin);
        }
        for (int j = 0; j < array.length; ++j) {
            int n7 = n - 1;
            if (array[j] < n3) {
                double n8 = (array[j] - n2) / (n3 - n2);
                if (n8 < 0.0) {
                    n8 = 0.0;
                }
                n7 = (int)(n8 * n);
                if (n7 >= n) {
                    n7 = n - 1;
                }
            }
            ((HistogramBin)list.get(n7)).incrementCount();
        }
        final HashMap<String, Double> hashMap = new HashMap<String, Double>();
        hashMap.put("key", (Double)comparable);
        hashMap.put("bins", (ArrayList<HistogramBin>)list);
        hashMap.put("values.length", (Double)new Integer(array.length));
        hashMap.put("bin width", new Double(n4));
        this.list.add(hashMap);
    }
    
    private double getMinimum(final double[] array) {
        if (array == null || array.length < 1) {
            throw new IllegalArgumentException("Null or zero length 'values' argument.");
        }
        double n = Double.MAX_VALUE;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] < n) {
                n = array[i];
            }
        }
        return n;
    }
    
    private double getMaximum(final double[] array) {
        if (array == null || array.length < 1) {
            throw new IllegalArgumentException("Null or zero length 'values' argument.");
        }
        double n = -1.7976931348623157E308;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] > n) {
                n = array[i];
            }
        }
        return n;
    }
    
    List getBins(final int n) {
        return this.list.get(n).get("bins");
    }
    
    private int getTotal(final int n) {
        return this.list.get(n).get("values.length");
    }
    
    private double getBinWidth(final int n) {
        return this.list.get(n).get("bin width");
    }
    
    public int getSeriesCount() {
        return this.list.size();
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.list.get(n).get("key");
    }
    
    public int getItemCount(final int n) {
        return this.getBins(n).size();
    }
    
    public Number getX(final int n, final int n2) {
        final HistogramBin histogramBin = this.getBins(n).get(n2);
        return new Double((histogramBin.getStartBoundary() + histogramBin.getEndBoundary()) / 2.0);
    }
    
    public Number getY(final int n, final int n2) {
        final HistogramBin histogramBin = this.getBins(n).get(n2);
        final double n3 = this.getTotal(n);
        final double binWidth = this.getBinWidth(n);
        if (this.type == HistogramType.FREQUENCY) {
            return new Double(histogramBin.getCount());
        }
        if (this.type == HistogramType.RELATIVE_FREQUENCY) {
            return new Double(histogramBin.getCount() / n3);
        }
        if (this.type == HistogramType.SCALE_AREA_TO_1) {
            return new Double(histogramBin.getCount() / (binWidth * n3));
        }
        throw new IllegalStateException();
    }
    
    public Number getStartX(final int n, final int n2) {
        return new Double(this.getBins(n).get(n2).getStartBoundary());
    }
    
    public Number getEndX(final int n, final int n2) {
        return new Double(this.getBins(n).get(n2).getEndBoundary());
    }
    
    public Number getStartY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    public Number getEndY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HistogramDataset)) {
            return false;
        }
        final HistogramDataset histogramDataset = (HistogramDataset)o;
        return ObjectUtilities.equal(this.type, histogramDataset.type) && ObjectUtilities.equal(this.list, histogramDataset.list);
    }
    
    public Object clone() {
        return super.clone();
    }
}
