/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarCellData;
import java.util.Comparator;

public class PercentageTwoBarCellDataComparator
implements Comparator {
    public int compare(PercentageTwoBarCellData percentageTwoBarCellData, PercentageTwoBarCellData percentageTwoBarCellData2) {
        double d2 = percentageTwoBarCellData.getSortByValue() - percentageTwoBarCellData2.getSortByValue();
        if (d2 > 0.0) {
            return 1;
        }
        if (d2 >= 0.0) return 0;
        return -1;
    }
}

