/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import com.google.security.zynamics.zylib.general.Pair;
import java.util.Comparator;

public class ConfidenceComparator
implements Comparator {
    public int compare(Pair pair, Pair pair2) {
        if ((Double)pair.second() > (Double)pair2.second()) {
            return -1;
        }
        if ((Double)pair.second() >= (Double)pair2.second()) return 0;
        return 1;
    }
}

