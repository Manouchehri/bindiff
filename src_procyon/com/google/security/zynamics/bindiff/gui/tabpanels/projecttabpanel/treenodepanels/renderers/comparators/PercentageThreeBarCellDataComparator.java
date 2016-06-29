package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import java.util.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;

public class PercentageThreeBarCellDataComparator implements Comparator
{
    public int compare(final PercentageThreeBarCellData percentageThreeBarCellData, final PercentageThreeBarCellData percentageThreeBarCellData2) {
        if (percentageThreeBarCellData == null && percentageThreeBarCellData2 == null) {
            return 0;
        }
        if (percentageThreeBarCellData == null) {
            return 1;
        }
        if (percentageThreeBarCellData2 == null) {
            return -1;
        }
        final double n = percentageThreeBarCellData.getSortByValue() - percentageThreeBarCellData2.getSortByValue();
        if (n > 0.0) {
            return 1;
        }
        if (n < 0.0) {
            return -1;
        }
        return 0;
    }
}
