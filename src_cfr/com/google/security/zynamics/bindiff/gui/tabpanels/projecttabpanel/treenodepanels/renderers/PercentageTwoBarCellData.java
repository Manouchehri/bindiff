/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.EPercentageBarSortType;
import com.google.security.zynamics.zylib.general.Pair;

public class PercentageTwoBarCellData {
    private final Pair data;
    private final EPercentageBarSortType sortRelevance;
    private final boolean inverted;

    public PercentageTwoBarCellData(int n2, int n3) {
        this(n2, n3, EPercentageBarSortType.SORT_BY_CENTER_VALUE, false);
    }

    public PercentageTwoBarCellData(int n2, int n3, EPercentageBarSortType ePercentageBarSortType, boolean bl2) {
        this.data = new Pair(n2, n3);
        this.sortRelevance = ePercentageBarSortType == null ? EPercentageBarSortType.SORT_BY_CENTER_VALUE : ePercentageBarSortType;
        this.inverted = bl2;
    }

    public double getLeftBarPercent() {
        if (!this.inverted) return (double)((Integer)this.data.first() / this.getTotalBarValue()) * 100.0;
        return (double)((Integer)this.data.second() / this.getTotalBarValue()) * 100.0;
    }

    public String getLeftBarString(boolean bl2) {
        String string = "%d";
        Object[] arrobject = new Object[1];
        arrobject[0] = this.inverted ? this.getRightBarValue() : this.getLeftBarValue();
        string = String.format(string, arrobject);
        if (!bl2) return string;
        string = String.valueOf(string).concat("%s(%.1f)");
        Object[] arrobject2 = new Object[1];
        arrobject2[0] = this.inverted ? this.getRightBarPercent() : this.getLeftBarPercent();
        return String.format(string, arrobject2);
    }

    public int getLeftBarValue() {
        if (!this.inverted) return (Integer)this.data.first();
        return (Integer)this.data.second();
    }

    public double getRightBarPercent() {
        if (!this.inverted) return (double)((Integer)this.data.second() / this.getTotalBarValue()) * 100.0;
        return (double)((Integer)this.data.first() / this.getTotalBarValue()) * 100.0;
    }

    public String getRightBarString(boolean bl2) {
        String string = "%d";
        Object[] arrobject = new Object[1];
        arrobject[0] = this.inverted ? this.getLeftBarValue() : this.getRightBarValue();
        string = String.format(string, arrobject);
        if (!bl2) return string;
        string = String.valueOf(string).concat("%s(%.1f)");
        Object[] arrobject2 = new Object[1];
        arrobject2[0] = this.inverted ? this.getLeftBarPercent() : this.getRightBarPercent();
        return String.format(string, arrobject2);
    }

    public int getRightBarValue() {
        if (!this.inverted) return (Integer)this.data.second();
        return (Integer)this.data.first();
    }

    public double getSortByValue() {
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_LEFT_VALUE) {
            return ((Integer)this.data.first()).intValue();
        }
        if (this.sortRelevance != EPercentageBarSortType.SORT_BY_RIGHT_VALUE) return this.getTotalBarValue();
        return ((Integer)this.data.second()).intValue();
    }

    public int getTotalBarValue() {
        return (Integer)this.data.first() + (Integer)this.data.second();
    }
}

