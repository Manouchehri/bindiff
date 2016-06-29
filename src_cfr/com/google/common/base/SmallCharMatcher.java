/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$NamedFastMatcher;
import java.util.BitSet;

@GwtIncompatible(value="no precomputation is done in GWT")
final class SmallCharMatcher
extends CharMatcher$NamedFastMatcher {
    static final int MAX_SIZE = 1023;
    private final char[] table;
    private final boolean containsZero;
    private final long filter;
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5;

    private SmallCharMatcher(char[] arrc, long l2, boolean bl2, String string) {
        super(string);
        this.table = arrc;
        this.filter = l2;
        this.containsZero = bl2;
    }

    static int smear(int n2) {
        return 461845907 * Integer.rotateLeft(n2 * -862048943, 15);
    }

    private boolean checkFilter(int n2) {
        if (1 != (1 & this.filter >> n2)) return false;
        return true;
    }

    @VisibleForTesting
    static int chooseTableSize(int n2) {
        if (n2 == 1) {
            return 2;
        }
        int n3 = Integer.highestOneBit(n2 - 1) << 1;
        while ((double)n3 * 0.5 < (double)n2) {
            n3 <<= 1;
        }
        return n3;
    }

    static CharMatcher from(BitSet bitSet, String string) {
        long l2 = 0;
        int n2 = bitSet.cardinality();
        boolean bl2 = bitSet.get(0);
        char[] arrc = new char[SmallCharMatcher.chooseTableSize(n2)];
        int n3 = arrc.length - 1;
        int n4 = bitSet.nextSetBit(0);
        block0 : while (n4 != -1) {
            l2 |= 1 << n4;
            int n5 = SmallCharMatcher.smear(n4) & n3;
            do {
                if (arrc[n5] == '\u0000') {
                    arrc[n5] = (char)n4;
                    n4 = bitSet.nextSetBit(n4 + 1);
                    continue block0;
                }
                n5 = n5 + 1 & n3;
            } while (true);
            break;
        }
        return new SmallCharMatcher(arrc, l2, bl2, string);
    }

    @Override
    public boolean matches(char c2) {
        int n2;
        if (c2 == '\u0000') {
            return this.containsZero;
        }
        if (!this.checkFilter(c2)) {
            return false;
        }
        int n3 = this.table.length - 1;
        int n4 = n2 = SmallCharMatcher.smear(c2) & n3;
        do {
            if (this.table[n4] == '\u0000') {
                return false;
            }
            if (this.table[n4] != c2) continue;
            return true;
        } while ((n4 = n4 + 1 & n3) != n2);
        return false;
    }

    @Override
    void setBits(BitSet bitSet) {
        if (this.containsZero) {
            bitSet.set(0);
        }
        char[] arrc = this.table;
        int n2 = arrc.length;
        int n3 = 0;
        while (n3 < n2) {
            char c2 = arrc[n3];
            if (c2 != '\u0000') {
                bitSet.set(c2);
            }
            ++n3;
        }
    }
}

