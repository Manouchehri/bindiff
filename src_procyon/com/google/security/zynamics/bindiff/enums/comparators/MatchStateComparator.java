package com.google.security.zynamics.bindiff.enums.comparators;

import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;

public class MatchStateComparator implements Comparator
{
    public int compare(final EMatchState eMatchState, final EMatchState eMatchState2) {
        final int n = EMatchState.getOrdinal(eMatchState) - EMatchState.getOrdinal(eMatchState2);
        if (n < 0) {
            return 1;
        }
        if (n > 0) {
            return -1;
        }
        return 0;
    }
}
