package com.google.common.math;

enum LongMath$MillerRabinTester$1
{
    LongMath$MillerRabinTester$1(final String s, final int n) {
    }
    
    @Override
    long mulMod(final long n, final long n2, final long n3) {
        return n * n2 % n3;
    }
    
    @Override
    long squareMod(final long n, final long n2) {
        return n * n % n2;
    }
}
