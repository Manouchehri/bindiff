/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import com.google.security.zynamics.zylib.general.Pair;
import java.util.Comparator;

public class SimilarityComparator
implements Comparator {
    public int compare(Pair pair, Pair pair2) {
        if ((Double)pair.first() > (Double)pair2.first()) {
            return -1;
        }
        if ((Double)pair.first() >= (Double)pair2.first()) return 0;
        return 1;
    }
}

