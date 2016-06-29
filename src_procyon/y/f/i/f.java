package y.f.i;

import java.util.*;
import y.g.*;

class f implements Comparator, g
{
    private final b a;
    
    private f(final b a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final e e = (e)o;
        final e e2 = (e)o2;
        final byte a = e.a(b.a(this.a));
        final byte a2 = e2.a(b.a(this.a));
        if (a != a2) {
            return y.g.e.a(a, a2);
        }
        switch (a) {
            case 0: {
                if (e.b.a > e2.b.a && e.c.a < e2.c.a) {
                    return -1;
                }
                if (e2.b.a > e.b.a && e2.c.a < e.c.a) {
                    return 1;
                }
                if (e.c.a < e2.b.a) {
                    return -1;
                }
                if (e2.c.a < e.b.a) {
                    return 1;
                }
                break;
            }
            case 1: {
                if (e.b.a > e2.b.a && e.c.a > e2.c.a) {
                    return -1;
                }
                if (e2.b.a > e.b.a && e2.c.a > e.c.a) {
                    return 1;
                }
                if (e.b.a == e2.b.a) {
                    return (e.c.a > e2.c.a) ? -1 : 1;
                }
                if (e.c.a == e2.c.a) {
                    return (e.b.a > e2.b.a) ? -1 : 1;
                }
                return (e.b.a <= e2.b.a) ? -1 : 1;
            }
            case 2: {
                if (e.b.a < e2.b.a && e.c.a < e2.c.a) {
                    return -1;
                }
                if (e2.b.a < e.b.a && e2.c.a < e.c.a) {
                    return 1;
                }
                if (e.b.a == e2.b.a) {
                    return (e.c.a < e2.c.a) ? -1 : 1;
                }
                if (e.c.a == e2.c.a) {
                    return (e.b.a < e2.b.a) ? -1 : 1;
                }
                return (e.b.a >= e2.b.a) ? -1 : 1;
            }
            case 3: {
                if (e.b.a < e2.b.a && e.c.a > e2.c.a) {
                    return -1;
                }
                if (e2.b.a < e.b.a && e2.c.a > e.c.a) {
                    return 1;
                }
                if (e.c.a < e2.b.a) {
                    return -1;
                }
                if (e2.c.a < e.b.a) {
                    return 1;
                }
                break;
            }
        }
        final int a3 = y.g.e.a(e.b.a, e2.b.a);
        if (a3 != 0) {
            return a3;
        }
        final int a4 = y.g.e.a(e.c.a, e2.c.a);
        if (a4 == 0) {
            return -y.g.e.a(e.b.a, e2.b.a);
        }
        return a4;
    }
    
    f(final b b, final c c) {
        this(b);
    }
}
