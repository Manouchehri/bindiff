package com.google.common.math;

enum LongMath$MillerRabinTester
{
    SMALL("SMALL", 0), 
    LARGE("LARGE", 1);
    
    private LongMath$MillerRabinTester(final String s, final int n) {
    }
    
    static boolean test(final long n, final long n2) {
        return ((n2 <= 3037000499L) ? LongMath$MillerRabinTester.SMALL : LongMath$MillerRabinTester.LARGE).testWitness(n, n2);
    }
    
    abstract long mulMod(final long p0, final long p1, final long p2);
    
    abstract long squareMod(final long p0, final long p1);
    
    private long powMod(long squareMod, long n, final long n2) {
        long mulMod = 1L;
        while (n != 0L) {
            if ((n & 0x1L) != 0x0L) {
                mulMod = this.mulMod(mulMod, squareMod, n2);
            }
            squareMod = this.squareMod(squareMod, n2);
            n >>= 1;
        }
        return mulMod;
    }
    
    private boolean testWitness(long n, final long n2) {
        final int numberOfTrailingZeros = Long.numberOfTrailingZeros(n2 - 1L);
        final long n3 = n2 - 1L >> numberOfTrailingZeros;
        n %= n2;
        if (n == 0L) {
            return true;
        }
        long n4 = this.powMod(n, n3, n2);
        if (n4 == 1L) {
            return true;
        }
        int n5 = 0;
        while (n4 != n2 - 1L) {
            if (++n5 == numberOfTrailingZeros) {
                return false;
            }
            n4 = this.squareMod(n4, n2);
        }
        return true;
    }
}
