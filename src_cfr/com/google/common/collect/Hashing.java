/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
final class Hashing {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static int MAX_TABLE_SIZE = 1073741824;

    private Hashing() {
    }

    static int smear(int n2) {
        return 461845907 * Integer.rotateLeft(n2 * -862048943, 15);
    }

    static int smearedHash(@Nullable Object object) {
        int n2;
        if (object == null) {
            n2 = 0;
            return Hashing.smear(n2);
        }
        n2 = object.hashCode();
        return Hashing.smear(n2);
    }

    static int closedTableSize(int n2, double d2) {
        int n3;
        int n4;
        if ((n2 = Math.max(n2, 2)) <= (int)(d2 * (double)(n4 = Integer.highestOneBit(n2)))) return n4;
        if ((n4 <<= 1) > 0) {
            n3 = n4;
            return n3;
        }
        n3 = MAX_TABLE_SIZE;
        return n3;
    }

    static boolean needsResizing(int n2, int n3, double d2) {
        if ((double)n2 <= d2 * (double)n3) return false;
        if (n3 >= MAX_TABLE_SIZE) return false;
        return true;
    }
}

