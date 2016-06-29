package y.f.e.a;

class c
{
    static double a(double n, int i) {
        final boolean b = af.b;
        while (i >= 0) {
            switch (i) {
                case 0: {
                    return 1.0;
                }
                case 1: {
                    return n;
                }
                case 2: {
                    return n * n;
                }
                case 3: {
                    return n * n * n;
                }
                case 4: {
                    return n * n * n * n;
                }
                case 5: {
                    return n * n * n * n * n;
                }
                default: {
                    if (a(i)) {
                        n *= n;
                        i >>= 1;
                        if (!b) {
                            continue;
                        }
                    }
                    return n * a(n * n, i - 1 >> 1);
                }
            }
        }
        throw new IllegalArgumentException("Negative exponents not allowed");
    }
    
    static boolean a(final long n) {
        return (n & 0x1L) == 0x0L;
    }
    
    static double a(final int n, final double n2, final double n3) {
        if (n == 0) {
            return 0.0;
        }
        if (n == 1) {
            return 0.0;
        }
        if (n2 == 0.0 && n3 == 0.0) {
            return 0.0;
        }
        final double n4 = n * n3 - n2 * n2;
        if (n4 < 0.0) {
            return 0.0;
        }
        final double sqrt = Math.sqrt(n4 / (n * (n - 1)));
        if (sqrt < 0.001) {
            return 0.0;
        }
        if (Double.isNaN(sqrt)) {
            throw new IllegalArgumentException("deviation is NaN");
        }
        return sqrt;
    }
}
