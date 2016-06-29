package y.a;

import y.c.*;

class W extends S
{
    private W() {
    }
    
    double a(final d[] array, final c c, final int n) {
        final boolean a = h.a;
        if (array.length == 0) {
            return -0.5;
        }
        double n2 = 0.0;
        final double[][] b = S.b(array, c, n);
        int i = 0;
        double n5 = 0.0;
        while (i < n) {
            final double n3 = n2 + b[0][i] / array.length;
            final double n4 = b[0][i] + b[1][i];
            n5 = n3 - n4 * n4 / (4.0 * array.length * array.length);
            if (a) {
                return n5;
            }
            n2 = n5;
            ++i;
            if (a) {
                break;
            }
        }
        return n5;
    }
    
    W(final T t) {
        this();
    }
}
