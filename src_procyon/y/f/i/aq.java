package y.f.i;

import java.util.*;
import y.f.*;
import y.d.*;
import y.c.*;

class aq implements Comparator
{
    X a;
    q b;
    
    public aq(final X a, final q b) {
        this.a = a;
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        int f = v.f;
        final d d = (d)o;
        final d d2 = (d)o2;
        final boolean b = this.b == d.c();
        final boolean b2 = this.b == d2.c();
        final D m = this.a.m(d);
        final int size = m.size();
        final boolean b3 = size == 2;
        final int n = b ? 0 : (size - 1);
        final t t = (t)m.a(n);
        final int n2 = n + (b ? 1 : -1);
        final t t2 = (t)m.a(n2);
        final boolean a = this.a(t, t2);
        boolean a2 = false;
        if (!b3) {
            a2 = this.a(t, t2, (t)m.a(n2 + (b ? 1 : -1)));
        }
        final D i = this.a.m(d2);
        final int size2 = i.size();
        final boolean b4 = size2 == 2;
        final int n3 = b2 ? 0 : (size2 - 1);
        final t t3 = (t)i.a(n3);
        final int n4 = n3 + (b2 ? 1 : -1);
        final t t4 = (t)i.a(n4);
        final boolean a3 = this.a(t3, t4);
        boolean a4 = false;
        if (!b4) {
            a4 = this.a(t3, t4, (t)i.a(n4 + (b2 ? 1 : -1)));
        }
        if (b3 && b4) {
            if (a != a3) {
                return 0;
            }
            final double n5 = a ? t.a : t.b;
            final double n6 = a3 ? t3.a : t3.b;
            if (n5 < n6) {
                return -1;
            }
            if (n5 > n6) {
                return 1;
            }
            return 0;
        }
        else if (b3) {
            if (!a4) {
                return -1;
            }
            return 1;
        }
        else if (b4) {
            if (!a2) {
                return 1;
            }
            return -1;
        }
        else {
            if (a2 && !a4) {
                return -1;
            }
            if (!a2 && a4) {
                return 1;
            }
            final double a5 = this.a(t2, a);
            final double a6 = this.a(t4, a3);
            if (a2) {
                if (a5 < a6) {
                    return -1;
                }
                if (a5 > a6) {
                    return 1;
                }
                return 0;
            }
            else {
                if (a6 < a5) {
                    return -1;
                }
                if (a6 > a5) {
                    return 1;
                }
                final boolean b5 = false;
                if (y.c.i.g) {
                    v.f = ++f;
                }
                return b5 ? 1 : 0;
            }
        }
    }
    
    private final double a(final t t, final boolean b) {
        if (b) {
            return Math.abs(t.b - this.a.k(this.b));
        }
        return Math.abs(t.a - this.a.j(this.b));
    }
    
    private final boolean a(final t t, final t t2, final t t3) {
        if (Math.abs(t.a - t2.a) < Math.abs(t.b - t2.b)) {
            return t3.a <= t2.a;
        }
        return t3.b <= t2.b;
    }
    
    private final boolean a(final t t, final t t2) {
        return Math.abs(t.a - t2.a) < Math.abs(t.b - t2.b);
    }
}
