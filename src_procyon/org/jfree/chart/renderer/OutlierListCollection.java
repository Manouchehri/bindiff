package org.jfree.chart.renderer;

import java.util.*;

public class OutlierListCollection
{
    private List outlierLists;
    private boolean highFarOut;
    private boolean lowFarOut;
    
    public OutlierListCollection() {
        this.highFarOut = false;
        this.lowFarOut = false;
        this.outlierLists = new ArrayList();
    }
    
    public boolean isHighFarOut() {
        return this.highFarOut;
    }
    
    public void setHighFarOut(final boolean highFarOut) {
        this.highFarOut = highFarOut;
    }
    
    public boolean isLowFarOut() {
        return this.lowFarOut;
    }
    
    public void setLowFarOut(final boolean lowFarOut) {
        this.lowFarOut = lowFarOut;
    }
    
    public boolean add(final Outlier outlier) {
        if (this.outlierLists.isEmpty()) {
            return this.outlierLists.add(new OutlierList(outlier));
        }
        boolean b = false;
        for (final OutlierList list : this.outlierLists) {
            if (list.isOverlapped(outlier)) {
                b = this.updateOutlierList(list, outlier);
            }
        }
        if (!b) {
            b = this.outlierLists.add(new OutlierList(outlier));
        }
        return b;
    }
    
    public Iterator iterator() {
        return this.outlierLists.iterator();
    }
    
    private boolean updateOutlierList(final OutlierList list, final Outlier outlier) {
        final boolean add = list.add(outlier);
        list.updateAveragedOutlier();
        list.setMultiple(true);
        return add;
    }
}
