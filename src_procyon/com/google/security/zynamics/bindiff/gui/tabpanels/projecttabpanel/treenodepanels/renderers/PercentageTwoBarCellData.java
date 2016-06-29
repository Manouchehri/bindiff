package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.*;

public class PercentageTwoBarCellData
{
    private final Pair data;
    private final EPercentageBarSortType sortRelevance;
    private final boolean inverted;
    
    public PercentageTwoBarCellData(final int n, final int n2) {
        this(n, n2, EPercentageBarSortType.SORT_BY_CENTER_VALUE, false);
    }
    
    public PercentageTwoBarCellData(final int n, final int n2, final EPercentageBarSortType ePercentageBarSortType, final boolean inverted) {
        this.data = new Pair(n, n2);
        this.sortRelevance = ((ePercentageBarSortType == null) ? EPercentageBarSortType.SORT_BY_CENTER_VALUE : ePercentageBarSortType);
        this.inverted = inverted;
    }
    
    public double getLeftBarPercent() {
        if (this.inverted) {
            return (int)this.data.second() / this.getTotalBarValue() * 100.0;
        }
        return (int)this.data.first() / this.getTotalBarValue() * 100.0;
    }
    
    public String getLeftBarString(final boolean b) {
        String s = String.format("%d", this.inverted ? this.getRightBarValue() : this.getLeftBarValue());
        if (b) {
            s = String.format(String.valueOf(s).concat("%s(%.1f)"), this.inverted ? this.getRightBarPercent() : this.getLeftBarPercent());
        }
        return s;
    }
    
    public int getLeftBarValue() {
        if (this.inverted) {
            return (int)this.data.second();
        }
        return (int)this.data.first();
    }
    
    public double getRightBarPercent() {
        if (this.inverted) {
            return (int)this.data.first() / this.getTotalBarValue() * 100.0;
        }
        return (int)this.data.second() / this.getTotalBarValue() * 100.0;
    }
    
    public String getRightBarString(final boolean b) {
        String s = String.format("%d", this.inverted ? this.getLeftBarValue() : this.getRightBarValue());
        if (b) {
            s = String.format(String.valueOf(s).concat("%s(%.1f)"), this.inverted ? this.getLeftBarPercent() : this.getRightBarPercent());
        }
        return s;
    }
    
    public int getRightBarValue() {
        if (this.inverted) {
            return (int)this.data.first();
        }
        return (int)this.data.second();
    }
    
    public double getSortByValue() {
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_LEFT_VALUE) {
            return (int)this.data.first();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_RIGHT_VALUE) {
            return (int)this.data.second();
        }
        return this.getTotalBarValue();
    }
    
    public int getTotalBarValue() {
        return (int)this.data.first() + (int)this.data.second();
    }
}
