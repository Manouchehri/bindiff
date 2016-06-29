/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.EPercentageBarSortType;
import com.google.security.zynamics.zylib.general.Triple;
import java.awt.Dimension;
import java.awt.Toolkit;

public class PercentageTwoBarExtendedCellData {
    private final EPercentageBarSortType sortRelevance;
    private Triple data;

    public PercentageTwoBarExtendedCellData(int n2, int n3, int n4) {
        this(n2, n3, n4, EPercentageBarSortType.SORT_BY_CENTER_VALUE, false);
    }

    public PercentageTwoBarExtendedCellData(int n2, int n3, int n4, EPercentageBarSortType ePercentageBarSortType, boolean bl2) {
        this.data = new Triple(n2, n3, n4);
        this.sortRelevance = ePercentageBarSortType == null ? EPercentageBarSortType.SORT_BY_CENTER_VALUE : ePercentageBarSortType;
    }

    public double getInnerLeftBarPercent() {
        return (double)((Integer)this.data.second()).intValue() / (double)this.getTotalBarValue() * 100.0;
    }

    public int getInnerLeftBarValue() {
        return (Integer)this.data.second();
    }

    public double getLeftBarPercent() {
        return (double)((Integer)this.data.first()).intValue() / (double)this.getTotalBarValue() * 100.0;
    }

    public String getLeftBarString(boolean bl2, boolean bl3) {
        String string;
        String string2 = "";
        if (bl3) {
            string2 = String.format("%d", this.getInnerLeftBarValue());
            if (bl2 && Toolkit.getDefaultToolkit().getScreenSize().width > 1024) {
                string2 = String.format("%s (%.1f%s)", string2, this.getInnerLeftBarPercent(), "%");
            }
            string2 = String.valueOf(string2).concat(" / ");
        }
        String string3 = String.format("%d", this.getLeftBarValue());
        if (bl2) {
            string3 = String.format("%s (%.1f%s)", string3, this.getLeftBarPercent(), "%");
        }
        String string4 = String.valueOf(string2);
        String string5 = String.valueOf(string3);
        if (string5.length() != 0) {
            string = string4.concat(string5);
            return string;
        }
        string = new String(string4);
        return string;
    }

    public int getLeftBarValue() {
        return (Integer)this.data.first();
    }

    public double getRightBarPercent() {
        return (double)((Integer)this.data.third()).intValue() / (double)this.getTotalBarValue() * 100.0;
    }

    public String getRightBarString(boolean bl2) {
        String string = "%d";
        string = String.format(string, this.getRightBarValue());
        if (!bl2) return string;
        return String.format("%s (%.1f%s)", string, this.getRightBarPercent(), "%");
    }

    public int getRightBarValue() {
        return (Integer)this.data.third();
    }

    public double getSortByValue() {
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_LEFT_VALUE) {
            return ((Integer)this.data.first()).intValue();
        }
        if (this.sortRelevance == EPercentageBarSortType.SORT_BY_RIGHT_VALUE) {
            return ((Integer)this.data.third()).intValue();
        }
        if (this.sortRelevance != EPercentageBarSortType.SORT_BY_INNERRIGHT) return this.getTotalBarValue();
        return ((Integer)this.data.second()).intValue();
    }

    public int getTotalBarValue() {
        int n2 = (Integer)this.data.first() + (Integer)this.data.third();
        if (n2 == 0) {
            return 1;
        }
        int n3 = n2;
        return n3;
    }

    public void updateData(int n2, int n3, int n4) {
        this.data = new Triple(n2, n3, n4);
    }
}

