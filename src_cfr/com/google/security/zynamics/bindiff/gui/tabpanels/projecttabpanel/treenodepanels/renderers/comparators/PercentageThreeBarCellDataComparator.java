/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarCellData;
import java.util.Comparator;

public class PercentageThreeBarCellDataComparator
implements Comparator {
    public int compare(PercentageThreeBarCellData percentageThreeBarCellData, PercentageThreeBarCellData percentageThreeBarCellData2) {
        if (percentageThreeBarCellData == null && percentageThreeBarCellData2 == null) {
            return 0;
        }
        if (percentageThreeBarCellData == null) {
            return 1;
        }
        if (percentageThreeBarCellData2 == null) {
            return -1;
        }
        double d2 = percentageThreeBarCellData.getSortByValue() - percentageThreeBarCellData2.getSortByValue();
        if (d2 > 0.0) {
            return 1;
        }
        if (d2 >= 0.0) return 0;
        return -1;
    }
}

