/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.statistics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.statistics.HistogramBin;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class HistogramDataset
extends AbstractIntervalXYDataset
implements Serializable,
Cloneable,
IntervalXYDataset,
PublicCloneable {
    private static final long serialVersionUID = -6341668077370231153L;
    private List list = new ArrayList();
    private HistogramType type = HistogramType.FREQUENCY;

    public HistogramType getType() {
        return this.type;
    }

    public void setType(HistogramType histogramType) {
        if (histogramType == null) {
            throw new IllegalArgumentException("Null 'type' argument");
        }
        this.type = histogramType;
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }

    public void addSeries(Comparable comparable, double[] arrd, int n2) {
        double d2 = this.getMinimum(arrd);
        double d3 = this.getMaximum(arrd);
        this.addSeries(comparable, arrd, n2, d2, d3);
    }

    public void addSeries(Comparable comparable, double[] arrd, int n2, double d2, double d3) {
        int n3;
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        if (arrd == null) {
            throw new IllegalArgumentException("Null 'values' argument.");
        }
        if (n2 < 1) {
            throw new IllegalArgumentException("The 'bins' value must be at least 1.");
        }
        double d4 = (d3 - d2) / (double)n2;
        double d5 = d2;
        ArrayList<HistogramBin> arrayList = new ArrayList<HistogramBin>(n2);
        for (n3 = 0; n3 < n2; ++n3) {
            HistogramBin histogramBin;
            if (n3 == n2 - 1) {
                histogramBin = new HistogramBin(d5, d3);
            } else {
                double d6 = d2 + (double)(n3 + 1) * d4;
                histogramBin = new HistogramBin(d5, d6);
                d5 = d6;
            }
            arrayList.add(histogramBin);
        }
        n3 = 0;
        do {
            if (n3 >= arrd.length) {
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                hashMap.put("key", comparable);
                hashMap.put("bins", arrayList);
                hashMap.put("values.length", new Integer(arrd.length));
                hashMap.put("bin width", new Double(d4));
                this.list.add(hashMap);
                return;
            }
            int n4 = n2 - 1;
            if (arrd[n3] < d3) {
                double d7 = (arrd[n3] - d2) / (d3 - d2);
                if (d7 < 0.0) {
                    d7 = 0.0;
                }
                if ((n4 = (int)(d7 * (double)n2)) >= n2) {
                    n4 = n2 - 1;
                }
            }
            HistogramBin histogramBin = (HistogramBin)arrayList.get(n4);
            histogramBin.incrementCount();
            ++n3;
        } while (true);
    }

    private double getMinimum(double[] arrd) {
        if (arrd == null) throw new IllegalArgumentException("Null or zero length 'values' argument.");
        if (arrd.length < 1) {
            throw new IllegalArgumentException("Null or zero length 'values' argument.");
        }
        double d2 = Double.MAX_VALUE;
        int n2 = 0;
        while (n2 < arrd.length) {
            if (arrd[n2] < d2) {
                d2 = arrd[n2];
            }
            ++n2;
        }
        return d2;
    }

    private double getMaximum(double[] arrd) {
        if (arrd == null) throw new IllegalArgumentException("Null or zero length 'values' argument.");
        if (arrd.length < 1) {
            throw new IllegalArgumentException("Null or zero length 'values' argument.");
        }
        double d2 = -1.7976931348623157E308;
        int n2 = 0;
        while (n2 < arrd.length) {
            if (arrd[n2] > d2) {
                d2 = arrd[n2];
            }
            ++n2;
        }
        return d2;
    }

    List getBins(int n2) {
        Map map = (Map)this.list.get(n2);
        return (List)map.get("bins");
    }

    private int getTotal(int n2) {
        Map map = (Map)this.list.get(n2);
        return (Integer)map.get("values.length");
    }

    private double getBinWidth(int n2) {
        Map map = (Map)this.list.get(n2);
        return (Double)map.get("bin width");
    }

    @Override
    public int getSeriesCount() {
        return this.list.size();
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        Map map = (Map)this.list.get(n2);
        return (Comparable)map.get("key");
    }

    @Override
    public int getItemCount(int n2) {
        return this.getBins(n2).size();
    }

    @Override
    public Number getX(int n2, int n3) {
        List list = this.getBins(n2);
        HistogramBin histogramBin = (HistogramBin)list.get(n3);
        double d2 = (histogramBin.getStartBoundary() + histogramBin.getEndBoundary()) / 2.0;
        return new Double(d2);
    }

    @Override
    public Number getY(int n2, int n3) {
        List list = this.getBins(n2);
        HistogramBin histogramBin = (HistogramBin)list.get(n3);
        double d2 = this.getTotal(n2);
        double d3 = this.getBinWidth(n2);
        if (this.type == HistogramType.FREQUENCY) {
            return new Double(histogramBin.getCount());
        }
        if (this.type == HistogramType.RELATIVE_FREQUENCY) {
            return new Double((double)histogramBin.getCount() / d2);
        }
        if (this.type != HistogramType.SCALE_AREA_TO_1) throw new IllegalStateException();
        return new Double((double)histogramBin.getCount() / (d3 * d2));
    }

    @Override
    public Number getStartX(int n2, int n3) {
        List list = this.getBins(n2);
        HistogramBin histogramBin = (HistogramBin)list.get(n3);
        return new Double(histogramBin.getStartBoundary());
    }

    @Override
    public Number getEndX(int n2, int n3) {
        List list = this.getBins(n2);
        HistogramBin histogramBin = (HistogramBin)list.get(n3);
        return new Double(histogramBin.getEndBoundary());
    }

    @Override
    public Number getStartY(int n2, int n3) {
        return this.getY(n2, n3);
    }

    @Override
    public Number getEndY(int n2, int n3) {
        return this.getY(n2, n3);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof HistogramDataset)) {
            return false;
        }
        HistogramDataset histogramDataset = (HistogramDataset)object;
        if (!ObjectUtilities.equal(this.type, histogramDataset.type)) {
            return false;
        }
        if (ObjectUtilities.equal(this.list, histogramDataset.list)) return true;
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

