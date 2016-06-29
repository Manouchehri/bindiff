/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.renderer.Outlier;

public class OutlierList {
    private List outliers = new ArrayList();
    private Outlier averagedOutlier;
    private boolean multiple = false;

    public OutlierList(Outlier outlier) {
        this.setAveragedOutlier(outlier);
    }

    public boolean add(Outlier outlier) {
        return this.outliers.add(outlier);
    }

    public int getItemCount() {
        return this.outliers.size();
    }

    public Outlier getAveragedOutlier() {
        return this.averagedOutlier;
    }

    public void setAveragedOutlier(Outlier outlier) {
        this.averagedOutlier = outlier;
    }

    public boolean isMultiple() {
        return this.multiple;
    }

    public void setMultiple(boolean bl2) {
        this.multiple = bl2;
    }

    public boolean isOverlapped(Outlier outlier) {
        if (outlier != null) return outlier.overlaps(this.getAveragedOutlier());
        return false;
    }

    public void updateAveragedOutlier() {
        double d2 = 0.0;
        double d3 = 0.0;
        int n2 = this.getItemCount();
        Iterator iterator = this.outliers.iterator();
        do {
            if (!iterator.hasNext()) {
                this.getAveragedOutlier().getPoint().setLocation(new Point2D.Double(d2 / (double)n2, d3 / (double)n2));
                return;
            }
            Outlier outlier = (Outlier)iterator.next();
            d2 += outlier.getX();
            d3 += outlier.getY();
        } while (true);
    }
}

