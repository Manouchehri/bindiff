/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Comparator;
import y.c.d;
import y.c.i;
import y.c.q;
import y.d.t;
import y.f.X;
import y.f.aE;
import y.g.e;

class aH
implements Comparator {
    protected int[] a;
    protected byte b;

    public aH(int[] arrn, byte by2) {
        this.a = arrn;
        this.b = by2;
    }

    public int compare(Object object, Object object2) {
        switch (this.b) {
            case 1: {
                int n2;
                d d2 = (d)object;
                d d3 = (d)object2;
                X x2 = (X)d2.a();
                q q2 = d2.c();
                q q3 = d3.c();
                int n3 = e.a(this.a[q2.d()], this.a[q3.d()]);
                if (n3 != 0) return n3;
                int n4 = aH.a(aE.d(x2, d2), x2.n(d2));
                int n5 = e.a(n4, n2 = aH.a(aE.d(x2, d3), x2.n(d3)));
                if (n5 != 0) return n5;
                int n6 = e.a(this.a[d2.d().d()], this.a[d3.d().d()]);
                if (n6 != 0) return n6;
                int n7 = aH.b(aE.e(x2, d2), x2.o(d2));
                int n8 = aH.b(aE.e(x2, d3), x2.o(d3));
                return e.a(n7, n8);
            }
            case 0: {
                int n9;
                d d4 = (d)object;
                d d5 = (d)object2;
                X x3 = (X)d4.a();
                q q4 = d4.d();
                q q5 = d5.d();
                int n10 = e.a(this.a[q4.d()], this.a[q5.d()]);
                if (n10 != 0) return n10;
                int n11 = aH.b(aE.e(x3, d4), x3.o(d4));
                int n12 = e.a(n11, n9 = aH.b(aE.e(x3, d5), x3.o(d5)));
                if (n12 != 0) return n12;
                int n13 = e.a(this.a[d4.c().d()], this.a[d5.c().d()]);
                if (n13 != 0) return n13;
                int n14 = aH.a(aE.d(x3, d4), x3.n(d4));
                int n15 = aH.a(aE.d(x3, d5), x3.n(d5));
                return e.a(n14, n15);
            }
            case 2: {
                return e.a(this.a[((q)object).d()], this.a[((q)object2).d()]);
            }
            case 3: {
                d d6 = (d)object;
                d d7 = (d)object2;
                X x4 = (X)d6.a();
                int n16 = aH.a(aE.d(x4, d6), x4.n(d6));
                int n17 = aH.a(aE.d(x4, d7), x4.n(d7));
                return e.a(n16, n17);
            }
            case 4: {
                d d8 = (d)object;
                d d9 = (d)object2;
                X x5 = (X)d8.a();
                int n18 = aH.b(aE.e(x5, d8), x5.o(d8));
                int n19 = aH.b(aE.e(x5, d9), x5.o(d9));
                return e.a(n18, n19);
            }
            case 6: {
                d d10 = (d)object;
                d d11 = (d)object2;
                X x6 = (X)d10.a();
                q q6 = d10.c();
                q q7 = d11.c();
                int n20 = e.a(this.a[q6.d()], this.a[q7.d()]);
                if (n20 != 0) return n20;
                double d12 = x6.n((d)d10).a;
                double d13 = x6.n((d)d11).a;
                int n21 = e.a(d12, d13);
                if (n21 != 0) return n21;
                return e.a(x6.o((d)d10).a, x6.o((d)d10).a);
            }
            case 5: {
                d d14 = (d)object;
                d d15 = (d)object2;
                X x7 = (X)d14.a();
                q q8 = d14.d();
                q q9 = d15.d();
                int n22 = e.a(this.a[q8.d()], this.a[q9.d()]);
                if (n22 != 0) return n22;
                double d16 = x7.o((d)d14).a;
                double d17 = x7.o((d)d15).a;
                int n23 = e.a(d16, d17);
                if (n23 != 0) return n23;
                return e.a(x7.n((d)d14).a, x7.n((d)d14).a);
            }
        }
        throw new IllegalStateException(new StringBuffer().append("Unknown mode ").append(this.b).toString());
    }

    public static final int a(aE aE2, t t2) {
        int n2;
        if (aE2 == null) {
            return 0;
        }
        int n3 = aE2.a() ? (int)t2.a : 0;
        int n4 = n2 = aE2.a() ? (int)t2.b : 0;
        if (aE2.e()) {
            return 10000 - n2;
        }
        if (aE2.f()) {
            return -10000 + n2;
        }
        if (!aE2.c()) return n3;
        return -20000 - n3;
    }

    public static final int b(aE aE2, t t2) {
        int n2;
        if (aE2 == null) {
            return 0;
        }
        int n3 = aE2.a() ? (int)t2.a : 0;
        int n4 = n2 = aE2.a() ? (int)t2.b : 0;
        if (aE2.e()) {
            return 10000 + n2;
        }
        if (aE2.f()) {
            return -10000 - n2;
        }
        if (!aE2.d()) return n3;
        return -20000 - n3;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof aH)) {
            return false;
        }
        if (this == object) return true;
        if (this.a != ((aH)object).a) return false;
        if (this.b != ((aH)object).b) return false;
        return true;
    }

    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : 0;
        return 31 * n2 + this.b;
    }
}

