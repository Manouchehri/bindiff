package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.*;
import com.google.security.zynamics.zylib.general.*;
import java.awt.*;

public class PercentageTwoBarExtendedCellData
{
    private final EPercentageBarSortType sortRelevance;
    private Triple data;
    
    public PercentageTwoBarExtendedCellData(final int n, final int n2, final int n3) {
        this(n, n2, n3, EPercentageBarSortType.SORT_BY_CENTER_VALUE, false);
    }
    
    public PercentageTwoBarExtendedCellData(final int n, final int n2, final int n3, final EPercentageBarSortType ePercentageBarSortType, final boolean b) {
        this.data = new Triple(n, n2, n3);
        this.sortRelevance = ((ePercentageBarSortType == null) ? EPercentageBarSortType.SORT_BY_CENTER_VALUE : ePercentageBarSortType);
    }
    
    public double getInnerLeftBarPercent() {
        return (int)this.data.second() / this.getTotalBarValue() * 100.0;
    }
    
    public int getInnerLeftBarValue() {
        return (int)this.data.second();
    }
    
    public double getLeftBarPercent() {
        return (int)this.data.first() / this.getTotalBarValue() * 100.0;
    }
    
    public String getLeftBarString(final boolean b, final boolean b2) {
        String concat = "";
        if (b2) {
            String s = String.format("%d", this.getInnerLeftBarValue());
            if (b && Toolkit.getDefaultToolkit().getScreenSize().width > 1024) {
                s = String.format("%s (%.1f%s)", s, this.getInnerLeftBarPercent(), "%");
            }
            concat = String.valueOf(s).concat(" / ");
        }
        String s2 = String.format("%d", this.getLeftBarValue());
        if (b) {
            s2 = String.format("%s (%.1f%s)", s2, this.getLeftBarPercent(), "%");
        }
        final String value = String.valueOf(concat);
        final String value2 = String.valueOf(s2);
        return (value2.length() != 0) ? value.concat(value2) : new String(value);
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
            s = String.format("%s (%.1f%s)", s, this.getRightBarPercent(), "%");
        }
        return s;
    }
    
    public int getRightBarValue() {
        return (int)this.data.third();
    }
    
    public double getSortByValue() {
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_LEFT_VALUE) {
            return (int)this.data.first();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_RIGHT_VALUE) {
            return (int)this.data.third();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_INNERRIGHT) {
            return (int)this.data.second();
        }
        return this.getTotalBarValue();
    }
    
    public int getTotalBarValue() {
        final int n = (int)this.data.first() + (int)this.data.third();
        return (n == 0) ? 1 : n;
    }
    
    public void updateData(final int n, final int n2, final int n3) {
        this.data = new Triple(n, n2, n3);
    }
}
