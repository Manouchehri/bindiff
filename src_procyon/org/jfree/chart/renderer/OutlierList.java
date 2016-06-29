package org.jfree.chart.renderer;

import java.awt.geom.*;
import java.util.*;

public class OutlierList
{
    private List outliers;
    private Outlier averagedOutlier;
    private boolean multiple;
    
    public OutlierList(final Outlier averagedOutlier) {
        this.multiple = false;
        this.outliers = new ArrayList();
        this.setAveragedOutlier(averagedOutlier);
    }
    
    public boolean add(final Outlier outlier) {
        return this.outliers.add(outlier);
    }
    
    public int getItemCount() {
        return this.outliers.size();
    }
    
    public Outlier getAveragedOutlier() {
        return this.averagedOutlier;
    }
    
    public void setAveragedOutlier(final Outlier averagedOutlier) {
        this.averagedOutlier = averagedOutlier;
    }
    
    public boolean isMultiple() {
        return this.multiple;
    }
    
    public void setMultiple(final boolean multiple) {
        this.multiple = multiple;
    }
    
    public boolean isOverlapped(final Outlier outlier) {
        return outlier != null && outlier.overlaps(this.getAveragedOutlier());
    }
    
    public void updateAveragedOutlier() {
        double n = 0.0;
        double n2 = 0.0;
        final int itemCount = this.getItemCount();
        for (final Outlier outlier : this.outliers) {
            n += outlier.getX();
            n2 += outlier.getY();
        }
        this.getAveragedOutlier().getPoint().setLocation(new Point2D.Double(n / itemCount, n2 / itemCount));
    }
}
