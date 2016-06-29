package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import java.util.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;

public class PercentageTwoBarExtendedCellDataComparator implements Comparator
{
    public int compare(final PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData, final PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData2) {
        final double n = percentageTwoBarExtendedCellData.getSortByValue() - percentageTwoBarExtendedCellData2.getSortByValue();
        if (n > 0.0) {
            return 1;
        }
        if (n < 0.0) {
            return -1;
        }
        return 0;
    }
}
