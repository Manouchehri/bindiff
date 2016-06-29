/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.renderer.Outlier;
import org.jfree.chart.renderer.OutlierList;

public class OutlierListCollection {
    private List outlierLists = new ArrayList();
    private boolean highFarOut = false;
    private boolean lowFarOut = false;

    public boolean isHighFarOut() {
        return this.highFarOut;
    }

    public void setHighFarOut(boolean bl2) {
        this.highFarOut = bl2;
    }

    public boolean isLowFarOut() {
        return this.lowFarOut;
    }

    public void setLowFarOut(boolean bl2) {
        this.lowFarOut = bl2;
    }

    public boolean add(Outlier outlier) {
        if (this.outlierLists.isEmpty()) {
            return this.outlierLists.add(new OutlierList(outlier));
        }
        boolean bl2 = false;
        Iterator iterator = this.outlierLists.iterator();
        do {
            if (!iterator.hasNext()) {
                if (bl2) return bl2;
                return this.outlierLists.add(new OutlierList(outlier));
            }
            OutlierList outlierList = (OutlierList)iterator.next();
            if (!outlierList.isOverlapped(outlier)) continue;
            bl2 = this.updateOutlierList(outlierList, outlier);
        } while (true);
    }

    public Iterator iterator() {
        return this.outlierLists.iterator();
    }

    private boolean updateOutlierList(OutlierList outlierList, Outlier outlier) {
        boolean bl2 = false;
        bl2 = outlierList.add(outlier);
        outlierList.updateAveragedOutlier();
        outlierList.setMultiple(true);
        return bl2;
    }
}

