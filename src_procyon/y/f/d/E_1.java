package y.f.d;

import java.util.*;
import y.d.*;

class E implements Comparator
{
    private t a;
    private static final z b;
    
    private E(final t[] array) {
        final int f = y.f.d.a.f;
        double n = 0.0;
        double n2 = 0.0;
        int i = 0;
        while (i < array.length) {
            n += array[i].a;
            n2 += array[i].b;
            ++i;
            if (f != 0) {
                return;
            }
            if (f != 0) {
                break;
            }
        }
        this.a = new t(n / array.length, n2 / array.length);
    }
    
    public int compare(final Object o, final Object o2) {
        final z z = new z(this.a, (t)o);
        final z z2 = new z(this.a, (t)o2);
        final double d = y.d.z.d(E.b, z);
        final double d2 = y.d.z.d(E.b, z2);
        if (d < d2) {
            return -1;
        }
        if (d > d2) {
            return 1;
        }
        return 0;
    }
    
    E(final t[] array, final D d) {
        this(array);
    }
    
    static {
        b = new z(0.0, -1.0);
    }
}
