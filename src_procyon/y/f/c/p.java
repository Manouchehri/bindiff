package y.f.c;

import java.util.*;
import y.c.*;
import y.g.*;

class p implements Comparator
{
    private final h a;
    
    p(final h a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final d d2 = (d)o2;
        final int a = e.a(this.a.a[d.c().d()], this.a.a[d2.c().d()]);
        if (a != 0) {
            return a;
        }
        final int b;
        final int b2;
        final int a2 = e.a(this.a.e[b = d.b()], this.a.e[b2 = d2.b()]);
        if (a2 != 0) {
            return a2;
        }
        final int n = this.a.g[b];
        final int n2 = this.a.g[b2];
        if (n > 0) {
            if (n2 > 0) {
                return e.a(n, n2);
            }
            return -1;
        }
        else {
            if (n2 > 0) {
                return 1;
            }
            final int a3 = e.a(this.a.a[d.d().d()], this.a.a[d2.d().d()]);
            if (a3 != 0) {
                return a3;
            }
            final int a4 = e.a(this.a.f[b], this.a.f[b2]);
            if (a4 != 0) {
                return a4;
            }
            final int n3 = this.a.h[b];
            final int n4 = this.a.h[b2];
            if (n3 > 0) {
                if (n4 > 0) {
                    return e.a(n3, n4);
                }
                return -1;
            }
            else {
                if (n4 > 0) {
                    return 1;
                }
                return 0;
            }
        }
    }
}
