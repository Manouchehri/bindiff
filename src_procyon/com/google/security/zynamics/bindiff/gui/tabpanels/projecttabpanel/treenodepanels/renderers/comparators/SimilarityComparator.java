package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import java.util.*;
import com.google.security.zynamics.zylib.general.*;

public class SimilarityComparator implements Comparator
{
    public int compare(final Pair pair, final Pair pair2) {
        if ((double)pair.first() > (double)pair2.first()) {
            return -1;
        }
        if ((double)pair.first() < (double)pair2.first()) {
            return 1;
        }
        return 0;
    }
}
