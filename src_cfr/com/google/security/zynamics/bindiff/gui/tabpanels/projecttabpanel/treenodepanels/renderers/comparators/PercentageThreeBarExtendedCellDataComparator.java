/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarExtendedCellData;
import java.util.Comparator;

public class PercentageThreeBarExtendedCellDataComparator
implements Comparator {
    public int compare(PercentageThreeBarExtendedCellData percentageThreeBarExtendedCellData, PercentageThreeBarExtendedCellData percentageThreeBarExtendedCellData2) {
        double d2 = percentageThreeBarExtendedCellData.getSortByValue() - percentageThreeBarExtendedCellData2.getSortByValue();
        if (d2 > 0.0) {
            return 1;
        }
        if (d2 >= 0.0) return 0;
        return -1;
    }
}

