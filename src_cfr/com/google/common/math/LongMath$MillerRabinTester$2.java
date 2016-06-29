/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.math.LongMath$1;
import com.google.common.math.LongMath$MillerRabinTester;
import com.google.common.primitives.UnsignedLongs;

final class LongMath$MillerRabinTester$2
extends LongMath$MillerRabinTester {
    LongMath$MillerRabinTester$2(String string2, int n3) {
        super(string, n2, null);
    }

    private long plusMod(long l2, long l3, long l4) {
        long l5;
        if (l2 >= l4 - l3) {
            l5 = l2 + l3 - l4;
            return l5;
        }
        l5 = l2 + l3;
        return l5;
    }

    private long times2ToThe32Mod(long l2, long l3) {
        int n2;
        int n3 = 32;
        do {
            n2 = Math.min(n3, Long.numberOfLeadingZeros(l2));
            l2 = UnsignedLongs.remainder(l2 << n2, l3);
        } while ((n3 -= n2) > 0);
        return l2;
    }

    @Override
    long mulMod(long l2, long l3, long l4) {
        long l5 = l2 >>> 32;
        long l6 = l3 >>> 32;
        long l7 = l2 & 0xFFFFFFFFL;
        long l8 = l3 & 0xFFFFFFFFL;
        long l9 = this.times2ToThe32Mod(l5 * l6, l4);
        if ((l9 += l5 * l8) < 0) {
            l9 = UnsignedLongs.remainder(l9, l4);
        }
        l9 += l7 * l6;
        l9 = this.times2ToThe32Mod(l9, l4);
        return this.plusMod(l9, UnsignedLongs.remainder(l7 * l8, l4), l4);
    }

    @Override
    long squareMod(long l2, long l3) {
        long l4 = l2 >>> 32;
        long l5 = l2 & 0xFFFFFFFFL;
        long l6 = this.times2ToThe32Mod(l4 * l4, l3);
        long l7 = l4 * l5 * 2;
        if (l7 < 0) {
            l7 = UnsignedLongs.remainder(l7, l3);
        }
        l6 += l7;
        l6 = this.times2ToThe32Mod(l6, l3);
        return this.plusMod(l6, UnsignedLongs.remainder(l5 * l5, l3), l3);
    }
}

