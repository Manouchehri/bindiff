package com.google.common.math;

import com.google.common.primitives.*;

enum LongMath$MillerRabinTester$2
{
    LongMath$MillerRabinTester$2(final String s, final int n) {
    }
    
    private long plusMod(final long n, final long n2, final long n3) {
        return (n >= n3 - n2) ? (n + n2 - n3) : (n + n2);
    }
    
    private long times2ToThe32Mod(long remainder, final long n) {
        int i = 32;
        do {
            final int min = Math.min(i, Long.numberOfLeadingZeros(remainder));
            remainder = UnsignedLongs.remainder(remainder << min, n);
            i -= min;
        } while (i > 0);
        return remainder;
    }
    
    @Override
    long mulMod(final long n, final long n2, final long n3) {
        final long n4 = n >>> 32;
        final long n5 = n2 >>> 32;
        final long n6 = n & 0xFFFFFFFFL;
        final long n7 = n2 & 0xFFFFFFFFL;
        long remainder = this.times2ToThe32Mod(n4 * n5, n3) + n4 * n7;
        if (remainder < 0L) {
            remainder = UnsignedLongs.remainder(remainder, n3);
        }
        return this.plusMod(this.times2ToThe32Mod(remainder + n6 * n5, n3), UnsignedLongs.remainder(n6 * n7, n3), n3);
    }
    
    @Override
    long squareMod(final long n, final long n2) {
        final long n3 = n >>> 32;
        final long n4 = n & 0xFFFFFFFFL;
        final long times2ToThe32Mod = this.times2ToThe32Mod(n3 * n3, n2);
        long remainder = n3 * n4 * 2L;
        if (remainder < 0L) {
            remainder = UnsignedLongs.remainder(remainder, n2);
        }
        return this.plusMod(this.times2ToThe32Mod(times2ToThe32Mod + remainder, n2), UnsignedLongs.remainder(n4 * n4, n2), n2);
    }
}
