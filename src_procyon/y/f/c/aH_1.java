package y.f.c;

import java.util.*;
import y.g.*;
import y.f.*;
import y.c.*;
import y.d.*;

class aH implements Comparator
{
    protected int[] a;
    protected byte b;
    
    public aH(final int[] a, final byte b) {
        this.a = a;
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        switch (this.b) {
            case 1: {
                final d d = (d)o;
                final d d2 = (d)o2;
                final X x = (X)d.a();
                final int a = e.a(this.a[d.c().d()], this.a[d2.c().d()]);
                if (a != 0) {
                    return a;
                }
                final int a2 = e.a(a(aE.d(x, d), x.n(d)), a(aE.d(x, d2), x.n(d2)));
                if (a2 != 0) {
                    return a2;
                }
                final int a3 = e.a(this.a[d.d().d()], this.a[d2.d().d()]);
                if (a3 == 0) {
                    return e.a(b(aE.e(x, d), x.o(d)), b(aE.e(x, d2), x.o(d2)));
                }
                return a3;
            }
            case 0: {
                final d d3 = (d)o;
                final d d4 = (d)o2;
                final X x2 = (X)d3.a();
                final int a4 = e.a(this.a[d3.d().d()], this.a[d4.d().d()]);
                if (a4 != 0) {
                    return a4;
                }
                final int a5 = e.a(b(aE.e(x2, d3), x2.o(d3)), b(aE.e(x2, d4), x2.o(d4)));
                if (a5 != 0) {
                    return a5;
                }
                final int a6 = e.a(this.a[d3.c().d()], this.a[d4.c().d()]);
                if (a6 == 0) {
                    return e.a(a(aE.d(x2, d3), x2.n(d3)), a(aE.d(x2, d4), x2.n(d4)));
                }
                return a6;
            }
            case 2: {
                return e.a(this.a[((q)o).d()], this.a[((q)o2).d()]);
            }
            case 3: {
                final d d5 = (d)o;
                final d d6 = (d)o2;
                final X x3 = (X)d5.a();
                return e.a(a(aE.d(x3, d5), x3.n(d5)), a(aE.d(x3, d6), x3.n(d6)));
            }
            case 4: {
                final d d7 = (d)o;
                final d d8 = (d)o2;
                final X x4 = (X)d7.a();
                return e.a(b(aE.e(x4, d7), x4.o(d7)), b(aE.e(x4, d8), x4.o(d8)));
            }
            case 6: {
                final d d9 = (d)o;
                final d d10 = (d)o2;
                final X x5 = (X)d9.a();
                final int a7 = e.a(this.a[d9.c().d()], this.a[d10.c().d()]);
                if (a7 != 0) {
                    return a7;
                }
                final int a8 = e.a(x5.n(d9).a, x5.n(d10).a);
                if (a8 == 0) {
                    return e.a(x5.o(d9).a, x5.o(d9).a);
                }
                return a8;
            }
            case 5: {
                final d d11 = (d)o;
                final d d12 = (d)o2;
                final X x6 = (X)d11.a();
                final int a9 = e.a(this.a[d11.d().d()], this.a[d12.d().d()]);
                if (a9 != 0) {
                    return a9;
                }
                final int a10 = e.a(x6.o(d11).a, x6.o(d12).a);
                if (a10 == 0) {
                    return e.a(x6.n(d11).a, x6.n(d11).a);
                }
                return a10;
            }
            default: {
                throw new IllegalStateException("Unknown mode " + this.b);
            }
        }
    }
    
    public static final int a(final aE ae, final t t) {
        if (ae == null) {
            return 0;
        }
        final int n = ae.a() ? ((int)t.a) : 0;
        final int n2 = ae.a() ? ((int)t.b) : 0;
        if (ae.e()) {
            return 10000 - n2;
        }
        if (ae.f()) {
            return -10000 + n2;
        }
        if (ae.c()) {
            return -20000 - n;
        }
        return n;
    }
    
    public static final int b(final aE ae, final t t) {
        if (ae == null) {
            return 0;
        }
        final int n = ae.a() ? ((int)t.a) : 0;
        final int n2 = ae.a() ? ((int)t.b) : 0;
        if (ae.e()) {
            return 10000 + n2;
        }
        if (ae.f()) {
            return -10000 - n2;
        }
        if (ae.d()) {
            return -20000 - n;
        }
        return n;
    }
    
    public boolean equals(final Object o) {
        return o instanceof aH && (this == o || (this.a == ((aH)o).a && this.b == ((aH)o).b));
    }
    
    public int hashCode() {
        return 31 * ((this.a != null) ? this.a.hashCode() : 0) + this.b;
    }
}
