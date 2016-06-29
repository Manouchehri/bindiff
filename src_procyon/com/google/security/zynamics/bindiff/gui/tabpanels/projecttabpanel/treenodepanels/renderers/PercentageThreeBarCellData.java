package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.*;

public class PercentageThreeBarCellData
{
    private final Triple data;
    private final EPercentageBarSortType sortRelevance;
    
    public PercentageThreeBarCellData(final int n, final int n2, final int n3) {
        this(n, n2, n3, EPercentageBarSortType.SORT_BY_CENTER_VALUE);
    }
    
    public PercentageThreeBarCellData(final int n, final int n2, final int n3, final EPercentageBarSortType ePercentageBarSortType) {
        this.data = new Triple(n, n2, n3);
        this.sortRelevance = ((ePercentageBarSortType == null) ? EPercentageBarSortType.SORT_BY_CENTER_VALUE : ePercentageBarSortType);
    }
    
    public double getCenterBarPercent() {
        return (int)this.data.second() / this.getTotalBarValue() * 100.0;
    }
    
    public String getCenterBarString(final boolean b) {
        String s = String.format("%d", this.getCenterBarValue());
        if (b) {
            s = String.format(String.valueOf(s).concat("%s(%.1f)"), this.getCenterBarPercent());
        }
        return s;
    }
    
    public int getCenterBarValue() {
        return (int)this.data.second();
    }
    
    public double getLeftBarPercent() {
        return (int)this.data.first() / this.getTotalBarValue() * 100.0;
    }
    
    public String getLeftBarString(final boolean b) {
        String s = String.format("%d", this.getLeftBarValue());
        if (b) {
            s = String.format(String.valueOf(s).concat("%s(%.1f)"), this.getLeftBarPercent());
        }
        return s;
    }
    
    public int getLeftBarValue() {
        return (int)this.data.first();
    }
    
    public double getRightBarPercent() {
        return (int)this.data.third() / this.getTotalBarValue() * 100.0;
    }
    
    public String getRightBarString(final boolean b) {
        String s = String.format("%d", this.getRightBarValue());
        if (b) {
            s = String.format(String.valueOf(s).concat("%s(%.1f)"), this.getRightBarPercent());
        }
        return s;
    }
    
    public int getRightBarValue() {
        return (int)this.data.third();
    }
    
    public double getSortByValue() {
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_TOTAL_SUM) {
            return (int)this.data.first() + (int)this.data.second() + (int)this.data.third();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_LEFT_AND_CENTER_SUM) {
            return (int)this.data.first() + (int)this.data.second();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_RIGHT_AND_CENTER_SUM) {
            return (int)this.data.second() + (int)this.data.third();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_LEFT_VALUE) {
            return (int)this.data.first();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_CENTER_VALUE) {
            return (int)this.data.second();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_RIGHT_VALUE) {
            return (int)this.data.third();
        }
        return this.getTotalBarValue();
    }
    
    public int getTotalBarValue() {
        return (int)this.data.first() + (int)this.data.second() + (int)this.data.third();
    }
    
    @Override
    public String toString() {
        return String.format("%d\t%d\t%d", this.data.first(), this.data.second(), this.data.third());
    }
}
