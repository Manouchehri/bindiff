/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.EPercentageBarSortType;
import com.google.security.zynamics.zylib.general.Triple;

public class PercentageThreeBarCellData {
    private final Triple data;
    private final EPercentageBarSortType sortRelevance;

    public PercentageThreeBarCellData(int n2, int n3, int n4) {
        this(n2, n3, n4, EPercentageBarSortType.SORT_BY_CENTER_VALUE);
    }

    public PercentageThreeBarCellData(int n2, int n3, int n4, EPercentageBarSortType ePercentageBarSortType) {
        this.data = new Triple(n2, n3, n4);
        this.sortRelevance = ePercentageBarSortType == null ? EPercentageBarSortType.SORT_BY_CENTER_VALUE : ePercentageBarSortType;
    }

    public double getCenterBarPercent() {
        return (double)((Integer)this.data.second() / this.getTotalBarValue()) * 100.0;
    }

    public String getCenterBarString(boolean bl2) {
        String string = "%d";
        string = String.format(string, this.getCenterBarValue());
        if (!bl2) return string;
        string = String.valueOf(string).concat("%s(%.1f)");
        return String.format(string, this.getCenterBarPercent());
    }

    public int getCenterBarValue() {
        return (Integer)this.data.second();
    }

    public double getLeftBarPercent() {
        return (double)((Integer)this.data.first() / this.getTotalBarValue()) * 100.0;
    }

    public String getLeftBarString(boolean bl2) {
        String string = "%d";
        string = String.format(string, this.getLeftBarValue());
        if (!bl2) return string;
        string = String.valueOf(string).concat("%s(%.1f)");
        return String.format(string, this.getLeftBarPercent());
    }

    public int getLeftBarValue() {
        return (Integer)this.data.first();
    }

    public double getRightBarPercent() {
        return (double)((Integer)this.data.third() / this.getTotalBarValue()) * 100.0;
    }

    public String getRightBarString(boolean bl2) {
        String string = "%d";
        string = String.format(string, this.getRightBarValue());
        if (!bl2) return string;
        string = String.valueOf(string).concat("%s(%.1f)");
        return String.format(string, this.getRightBarPercent());
    }

    public int getRightBarValue() {
        return (Integer)this.data.third();
    }

    public double getSortByValue() {
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_TOTAL_SUM) {
            return (Integer)this.data.first() + (Integer)this.data.second() + (Integer)this.data.third();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_LEFT_AND_CENTER_SUM) {
            return (Integer)this.data.first() + (Integer)this.data.second();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_RIGHT_AND_CENTER_SUM) {
            return (Integer)this.data.second() + (Integer)this.data.third();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_LEFT_VALUE) {
            return ((Integer)this.data.first()).intValue();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_CENTER_VALUE) {
            return ((Integer)this.data.second()).intValue();
        }
        if (this.sortRelevance != EPercentageBarSortType.SORT_BY_RIGHT_VALUE) return this.getTotalBarValue();
        return ((Integer)this.data.third()).intValue();
    }

    public int getTotalBarValue() {
        return (Integer)this.data.first() + (Integer)this.data.second() + (Integer)this.data.third();
    }

    public String toString() {
        return String.format("%d\t%d\t%d", this.data.first(), this.data.second(), this.data.third());
    }
}

