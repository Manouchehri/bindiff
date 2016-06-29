package y.a;

import y.c.*;

class V extends S
{
    private V() {
    }
    
    double a(final d[] array, final c c, final int n) {
        final boolean a = h.a;
        if (array.length == 0) {
            return 0.0;
        }
        final i e = array[0].c().e();
        final double a2 = S.b().a(array, c, n);
        final int[] a3 = S.a(e, c, n);
        int n2 = 0;
        int i = 0;
        while (i < a3.length) {
            if (a3[i] > 0) {
                n2 += a3[i] * (a3[i] - 1);
            }
            ++i;
            if (a) {
                break;
            }
        }
        return 1.0 - 2.0 / (e.e() * (e.e() - 1)) * ((1.0 - 2.0 * a2 / array.length) * array.length + 0.5 * n2);
    }
    
    V(final T t) {
        this();
    }
}
