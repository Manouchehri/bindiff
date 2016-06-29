/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.enums.comparators;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import java.util.Comparator;

public class MatchStateComparator
implements Comparator {
    public int compare(EMatchState eMatchState, EMatchState eMatchState2) {
        int n2 = EMatchState.getOrdinal(eMatchState) - EMatchState.getOrdinal(eMatchState2);
        if (n2 < 0) {
            return 1;
        }
        if (n2 <= 0) return 0;
        return -1;
    }
}

