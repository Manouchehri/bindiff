/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.q;
import y.c.x;
import y.d.c;
import y.f.S;
import y.f.U;
import y.f.X;
import y.f.am;
import y.f.c.a.N;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.aY;

class de {
    public void a(X x2, aV aV2, byte by2, boolean bl2) {
        boolean bl3 = N.x;
        x x3 = x2.o();
        do {
            if (!x3.f()) return;
            aY aY2 = aV2.a(x3.e()).i();
            if (aY2 != null && aY2.b() == by2 || aY2 == null && bl2) {
                this.a(x2, x3.e(), aV2);
            }
            x3.g();
        } while (!bl3);
    }

    public void a(X x2, q q2, aV aV2) {
        boolean bl2 = N.x;
        aX aX2 = aV2.a(q2);
        if (aX2.b() != 0) return;
        S[] arrs = this.a(x2, q2);
        if (arrs == null) return;
        if (arrs.length <= 0) return;
        am am2 = x2.a(q2);
        double d2 = am2.getX();
        double d3 = am2.getY();
        am2.setLocation(0.0, 0.0);
        for (int i2 = 0; i2 < arrs.length; ++i2) {
            S s2 = arrs[i2];
            double d4 = am2.getWidth() * 0.5;
            double d5 = am2.getHeight() * 0.5;
            this.a(aX2, am2, s2.d() + d4, s2.e() + d5, s2.b(), s2.c(), true);
            if (bl2) return;
            if (!bl2) continue;
        }
        am2.setLocation(d2, d3);
    }

    protected S[] a(X x2, q q2) {
        y.c.c c2 = x2.c(U.b);
        if (c2 == null) return null;
        return (S[])c2.b(q2);
    }

    public void a(aX aX2, am am2, double d2, double d3, double d4, double d5, boolean bl2) {
        c c2;
        c c3;
        c c4;
        c c5 = c4 = bl2 ? aX2.a(0, am2) : aX2.a(0);
        if (c4 != null) {
            c4.a(d2, d2 + d4, d3);
        }
        c c6 = c2 = bl2 ? aX2.a(1, am2) : aX2.a(1);
        if (c2 != null) {
            c2.b(d3, d3 + d5, d2 + d4);
        }
        c c7 = c3 = bl2 ? aX2.a(2, am2) : aX2.a(2);
        if (c3 != null) {
            c3.b(d2, d2 + d4, d3 + d5);
        }
        c c8 = bl2 ? aX2.a(3, am2) : aX2.a(3);
        if (c8 == null) return;
        c8.a(d3, d3 + d5, d2);
    }
}

