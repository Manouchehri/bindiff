package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.*;

public class PercentageThreeBarExtendedCellData
{
    private final Quad data;
    private final EPercentageBarSortType sortRelevance;
    
    public PercentageThreeBarExtendedCellData(final int n, final int n2, final int n3, final int n4) {
        this(n, n2, n3, n4, EPercentageBarSortType.SORT_BY_CENTER_VALUE);
    }
    
    public PercentageThreeBarExtendedCellData(final int n, final int n2, final int n3, final int n4, final EPercentageBarSortType ePercentageBarSortType) {
        this.data = new Quad(n, n2, n3, n4);
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
    
    public double getInnerCenterBarPercent() {
        return (int)this.data.third() / this.getTotalBarValue() * 100.0;
    }
    
    public int getInnerCenterBarValue() {
        return (int)this.data.third();
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
        return (int)this.data.fourth() / this.getTotalBarValue() * 100.0;
    }
    
    public String getRightBarString(final boolean b) {
        String s = String.format("%d", this.getRightBarValue());
        if (b) {
            s = String.format(String.valueOf(s).concat("%s(%.1f)"), this.getRightBarPercent());
        }
        return s;
    }
    
    public int getRightBarValue() {
        return (int)this.data.fourth();
    }
    
    public double getSortByValue() {
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_TOTAL_SUM) {
            return (int)this.data.first() + (int)this.data.second() + (int)this.data.fourth();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_LEFT_AND_CENTER_SUM) {
            return (int)this.data.first() + (int)this.data.second();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_RIGHT_AND_CENTER_SUM) {
            return (int)this.data.second() + (int)this.data.fourth();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_LEFT_VALUE) {
            return (int)this.data.first();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_CENTER_VALUE) {
            return (int)this.data.second();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_RIGHT_VALUE) {
            return (int)this.data.fourth();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_INNERCENTER) {
            return (int)this.data.third();
        }
        return this.getTotalBarValue();
    }
    
    public int getTotalBarValue() {
        return (int)this.data.first() + (int)this.data.second() + (int)this.data.fourth();
    }
}
