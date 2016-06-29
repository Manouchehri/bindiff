/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.math.LongMath$1;
import com.google.common.math.LongMath$MillerRabinTester;

final class LongMath$MillerRabinTester$1
extends LongMath$MillerRabinTester {
    LongMath$MillerRabinTester$1(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    long mulMod(long l2, long l3, long l4) {
        return l2 * l3 % l4;
    }

    @Override
    long squareMod(long l2, long l3) {
        return l2 * l2 % l3;
    }
}

