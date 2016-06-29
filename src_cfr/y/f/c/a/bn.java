/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.q;
import y.d.c;
import y.f.X;
import y.f.am;
import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.aY;
import y.f.c.a.z;

class bN
implements z {
    @Override
    public double a(X x2, aQ aQ2, aV aV2, q q2, q q3) {
        if (q2 == null || q3 == null) {
            c c2;
            am am2;
            aX aX2;
            double d2 = 0.0;
            if (q3 != null) {
                aX2 = aV2.a(q3);
                am2 = x2.a(q3);
                c2 = aX2.a(3);
                if (aX2.i() != null) {
                    d2 = Math.max(d2, aX2.i().d());
                }
                if (c2 != null) {
                    d2 = Math.max(d2, - c2.c());
                }
            }
            if (q2 == null) return d2;
            aX2 = aV2.a(q2);
            am2 = x2.a(q2);
            c2 = aX2.a(1);
            if (aX2.i() != null) {
                d2 = Math.max(d2, aX2.i().d());
            }
            if (c2 == null) return d2;
            return Math.max(d2, c2.d() - am2.getWidth());
        }
        aX aX3 = aV2.a(q3);
        am am3 = x2.a(q3);
        aX aX4 = aV2.a(q2);
        am am4 = x2.a(q2);
        c c3 = aX3.a(3);
        c c4 = aX4.a(1);
        double d3 = 0.0;
        if (c3 != null) {
            double d4 = am3.getY();
            double d5 = am3.getX();
            d3 = Math.max(d3, - c3.c());
            if (c4 == null) return d3;
            c3.b(d4);
            c3.a(d5);
            double d6 = am4.getX();
            double d7 = am4.getY();
            d3 = Math.max(d3, c4.d() - am4.getWidth());
            c4.b(d7);
            c4.a(d6);
            double d8 = c4.c(c3);
            if (d8 != Double.MAX_VALUE) {
                double d9 = am3.getX() - (am4.getX() + am4.getWidth());
                d3 = Math.max(d3, d9 - d8);
            }
            c4.a(- d6);
            c4.b(- d7);
            c3.a(- d5);
            c3.b(- d4);
            if (!N.x) return d3;
        }
        if (c4 == null) return d3;
        return Math.max(d3, c4.d() - am4.getWidth());
    }

    @Override
    public void b(X x2, aU aU2, aV aV2) {
    }

    @Override
    public void a(X x2, aU aU2, aV aV2) {
    }
}

