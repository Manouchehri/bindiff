/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarExtendedCellData;
import java.util.Comparator;

public class PercentageTwoBarExtendedCellDataComparator
implements Comparator {
    public int compare(PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData, PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData2) {
        double d2 = percentageTwoBarExtendedCellData.getSortByValue() - percentageTwoBarExtendedCellData2.getSortByValue();
        if (d2 > 0.0) {
            return 1;
        }
        if (d2 >= 0.0) return 0;
        return -1;
    }
}

