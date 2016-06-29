package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import java.util.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;

public class PercentageThreeBarExtendedCellDataComparator implements Comparator
{
    public int compare(final PercentageThreeBarExtendedCellData percentageThreeBarExtendedCellData, final PercentageThreeBarExtendedCellData percentageThreeBarExtendedCellData2) {
        final double n = percentageThreeBarExtendedCellData.getSortByValue() - percentageThreeBarExtendedCellData2.getSortByValue();
        if (n > 0.0) {
            return 1;
        }
        if (n < 0.0) {
            return -1;
        }
        return 0;
    }
}
