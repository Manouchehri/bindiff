/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.EPercentageBarSortType;
import com.google.security.zynamics.zylib.general.Quad;

public class PercentageThreeBarExtendedCellData {
    private final Quad data;
    private final EPercentageBarSortType sortRelevance;

    public PercentageThreeBarExtendedCellData(int n2, int n3, int n4, int n5) {
        this(n2, n3, n4, n5, EPercentageBarSortType.SORT_BY_CENTER_VALUE);
    }

    public PercentageThreeBarExtendedCellData(int n2, int n3, int n4, int n5, EPercentageBarSortType ePercentageBarSortType) {
        this.data = new Quad(n2, n3, n4, n5);
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

    public double getInnerCenterBarPercent() {
        return (double)((Integer)this.data.third() / this.getTotalBarValue()) * 100.0;
    }

    public int getInnerCenterBarValue() {
        return (Integer)this.data.third();
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
        return (double)((Integer)this.data.fourth() / this.getTotalBarValue()) * 100.0;
    }

    public String getRightBarString(boolean bl2) {
        String string = "%d";
        string = String.format(string, this.getRightBarValue());
        if (!bl2) return string;
        string = String.valueOf(string).concat("%s(%.1f)");
        return String.format(string, this.getRightBarPercent());
    }

    public int getRightBarValue() {
        return (Integer)this.data.fourth();
    }

    public double getSortByValue() {
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_TOTAL_SUM) {
            return (Integer)this.data.first() + (Integer)this.data.second() + (Integer)this.data.fourth();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_LEFT_AND_CENTER_SUM) {
            return (Integer)this.data.first() + (Integer)this.data.second();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_RIGHT_AND_CENTER_SUM) {
            return (Integer)this.data.second() + (Integer)this.data.fourth();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_LEFT_VALUE) {
            return ((Integer)this.data.first()).intValue();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_CENTER_VALUE) {
            return ((Integer)this.data.second()).intValue();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_RIGHT_VALUE) {
            return ((Integer)this.data.fourth()).intValue();
        }
        if (this.sortRelevance != EPercentageBarSortType.SORT_BY_INNERCENTER) return this.getTotalBarValue();
        return ((Integer)this.data.third()).intValue();
    }

    public int getTotalBarValue() {
        return (Integer)this.data.first() + (Integer)this.data.second() + (Integer)this.data.fourth();
    }
}

