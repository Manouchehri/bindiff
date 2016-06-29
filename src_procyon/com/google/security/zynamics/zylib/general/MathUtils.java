package com.google.security.zynamics.zylib.general;

@Deprecated
public class MathUtils
{
    public static long pow(final long n, final long n2) {
        if (n2 == 0L) {
            return 1L;
        }
        long n3 = n;
        for (int n4 = 1; n4 < n2; ++n4) {
            n3 *= n;
        }
        return n3;
    }
}
