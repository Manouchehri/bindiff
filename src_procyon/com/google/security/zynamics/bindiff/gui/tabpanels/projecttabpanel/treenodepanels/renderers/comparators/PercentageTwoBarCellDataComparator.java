package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import java.util.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;

public class PercentageTwoBarCellDataComparator implements Comparator
{
    public int compare(final PercentageTwoBarCellData percentageTwoBarCellData, final PercentageTwoBarCellData percentageTwoBarCellData2) {
        final double n = percentageTwoBarCellData.getSortByValue() - percentageTwoBarCellData2.getSortByValue();
        if (n > 0.0) {
            return 1;
        }
        if (n < 0.0) {
            return -1;
        }
        return 0;
    }
}
