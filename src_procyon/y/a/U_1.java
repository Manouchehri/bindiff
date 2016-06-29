package y.a;

import y.c.*;

class U extends S
{
    private U() {
    }
    
    double a(final d[] array, final c c, final int n) {
        final boolean a = h.a;
        int n2 = 0;
        int i = 0;
        int a2 = 0;
        while (i < array.length) {
            final d d = array[i];
            a2 = c.a(d.c());
            if (a) {
                return a2;
            }
            if (a2 == c.a(d.d())) {
                ++n2;
            }
            ++i;
            if (a) {
                break;
            }
        }
        return a2;
    }
    
    U(final T t) {
        this();
    }
}
