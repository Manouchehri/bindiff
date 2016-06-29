package y.f.c;

import java.util.*;
import y.c.*;
import y.g.*;
import y.f.*;
import y.d.*;

class aG implements Comparator
{
    protected A a;
    protected byte b;
    
    public aG(final A a, final byte b) {
        this.a = a;
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        switch (this.b) {
            case 1: {
                final d d = (d)o;
                final d d2 = (d)o2;
                final X x = (X)d.a();
                final int a = e.a(this.a.c(d.c()), this.a.c(d2.c()));
                if (a != 0) {
                    return a;
                }
                final int a2 = e.a(a(aE.d(x, d), x.n(d)), a(aE.d(x, d2), x.n(d2)));
                if (a2 != 0) {
                    return a2;
                }
                final int a3 = e.a(this.a.c(d.d()), this.a.c(d2.d()));
                if (a3 == 0) {
                    return e.a(b(aE.e(x, d), x.o(d)), b(aE.e(x, d2), x.o(d2)));
                }
                return a3;
            }
            case 0: {
                final d d3 = (d)o;
                final d d4 = (d)o2;
                final X x2 = (X)d3.a();
                final int a4 = e.a(this.a.c(d3.d()), this.a.c(d4.d()));
                if (a4 != 0) {
                    return a4;
                }
                final int a5 = e.a(b(aE.e(x2, d3), x2.o(d3)), b(aE.e(x2, d4), x2.o(d4)));
                if (a5 != 0) {
                    return a5;
                }
                final int a6 = e.a(this.a.c(d3.c()), this.a.c(d4.c()));
                if (a6 == 0) {
                    return e.a(a(aE.d(x2, d3), x2.n(d3)), a(aE.d(x2, d4), x2.n(d4)));
                }
                return a6;
            }
            case 2: {
                return e.a(this.a.c(o), this.a.c(o2));
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
            default: {
                throw new IllegalStateException("Unknown mode " + this.b);
            }
        }
    }
    
    public static double a(final aE ae, final t t) {
        if (ae == null) {
            return 0.0;
        }
        final double a = t.a;
        final double b = t.b;
        if (ae.e()) {
            return 0.1 - b / 10000.0;
        }
        if (ae.f()) {
            return -0.1 + b / 10000.0;
        }
        if (ae.c()) {
            return -0.3 - a / 10000.0;
        }
        return a / 10000.0;
    }
    
    public static double b(final aE ae, final t t) {
        if (ae == null) {
            return 0.0;
        }
        final double a = t.a;
        final double b = t.b;
        if (ae.e()) {
            return 0.1 + b / 10000.0;
        }
        if (ae.f()) {
            return -0.1 - b / 10000.0;
        }
        if (ae.d()) {
            return -0.3 - a / 10000.0;
        }
        return a / 10000.0;
    }
    
    public boolean equals(final Object o) {
        return o instanceof aG && (this == o || (this.a == ((aG)o).a && this.b == ((aG)o).b));
    }
    
    public int hashCode() {
        return 31 * ((this.a != null) ? this.a.hashCode() : 0) + this.b;
    }
}
