/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Comparator;
import y.c.A;
import y.c.d;
import y.c.i;
import y.c.q;
import y.d.t;
import y.f.X;
import y.f.aE;
import y.g.e;

class aG
implements Comparator {
    protected A a;
    protected byte b;

    public aG(A a2, byte by2) {
        this.a = a2;
        this.b = by2;
    }

    public int compare(Object object, Object object2) {
        switch (this.b) {
            case 1: {
                double d2;
                d d3 = (d)object;
                d d4 = (d)object2;
                X x2 = (X)d3.a();
                q q2 = d3.c();
                q q3 = d4.c();
                int n2 = e.a(this.a.c(q2), this.a.c(q3));
                if (n2 != 0) return n2;
                double d5 = aG.a(aE.d(x2, d3), x2.n(d3));
                int n3 = e.a(d5, d2 = aG.a(aE.d(x2, d4), x2.n(d4)));
                if (n3 != 0) return n3;
                int n4 = e.a(this.a.c(d3.d()), this.a.c(d4.d()));
                if (n4 != 0) return n4;
                double d6 = aG.b(aE.e(x2, d3), x2.o(d3));
                double d7 = aG.b(aE.e(x2, d4), x2.o(d4));
                return e.a(d6, d7);
            }
            case 0: {
                double d8;
                d d9 = (d)object;
                d d10 = (d)object2;
                X x3 = (X)d9.a();
                q q4 = d9.d();
                q q5 = d10.d();
                int n5 = e.a(this.a.c(q4), this.a.c(q5));
                if (n5 != 0) return n5;
                double d11 = aG.b(aE.e(x3, d9), x3.o(d9));
                int n6 = e.a(d11, d8 = aG.b(aE.e(x3, d10), x3.o(d10)));
                if (n6 != 0) return n6;
                int n7 = e.a(this.a.c(d9.c()), this.a.c(d10.c()));
                if (n7 != 0) return n7;
                double d12 = aG.a(aE.d(x3, d9), x3.n(d9));
                double d13 = aG.a(aE.d(x3, d10), x3.n(d10));
                return e.a(d12, d13);
            }
            case 2: {
                return e.a(this.a.c(object), this.a.c(object2));
            }
            case 3: {
                d d14 = (d)object;
                d d15 = (d)object2;
                X x4 = (X)d14.a();
                double d16 = aG.a(aE.d(x4, d14), x4.n(d14));
                double d17 = aG.a(aE.d(x4, d15), x4.n(d15));
                return e.a(d16, d17);
            }
            case 4: {
                d d18 = (d)object;
                d d19 = (d)object2;
                X x5 = (X)d18.a();
                double d20 = aG.b(aE.e(x5, d18), x5.o(d18));
                double d21 = aG.b(aE.e(x5, d19), x5.o(d19));
                return e.a(d20, d21);
            }
        }
        throw new IllegalStateException(new StringBuffer().append("Unknown mode ").append(this.b).toString());
    }

    public static double a(aE aE2, t t2) {
        if (aE2 == null) {
            return 0.0;
        }
        double d2 = t2.a;
        double d3 = t2.b;
        if (aE2.e()) {
            return 0.1 - d3 / 10000.0;
        }
        if (aE2.f()) {
            return -0.1 + d3 / 10000.0;
        }
        if (!aE2.c()) return d2 / 10000.0;
        return -0.3 - d2 / 10000.0;
    }

    public static double b(aE aE2, t t2) {
        if (aE2 == null) {
            return 0.0;
        }
        double d2 = t2.a;
        double d3 = t2.b;
        if (aE2.e()) {
            return 0.1 + d3 / 10000.0;
        }
        if (aE2.f()) {
            return -0.1 - d3 / 10000.0;
        }
        if (!aE2.d()) return d2 / 10000.0;
        return -0.3 - d2 / 10000.0;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof aG)) {
            return false;
        }
        if (this == object) return true;
        if (this.a != ((aG)object).a) return false;
        if (this.b != ((aG)object).b) return false;
        return true;
    }

    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : 0;
        return 31 * n2 + this.b;
    }
}

