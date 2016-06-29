/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import y.d.n;
import y.d.t;
import y.d.y;
import y.f.d.a;

final class m {
    private static boolean a(n n2) {
        if (n2.g() == 0.0) {
            if (n2.i() == -1.0) return true;
        }
        if (n2.g() == 0.0) {
            if (n2.i() == 1.0) return true;
        }
        if (n2.g() == -1.0) {
            if (n2.i() == 0.0) return true;
        }
        if (n2.g() != 1.0) return false;
        if (n2.i() != 0.0) return false;
        return true;
    }

    private static y b(n n2) {
        double d2;
        double d3;
        double d4;
        double d5;
        int n3 = a.f;
        if (n2.g() == 0.0 && n2.i() == -1.0) {
            d3 = n2.b();
            d5 = n2.c() - n2.f();
            d4 = n2.f();
            d2 = n2.e();
            if (n3 == 0) return new y(d3, d5, d2, d4);
        }
        if (n2.g() == 0.0 && n2.i() == 1.0) {
            d3 = n2.b() - n2.e();
            d5 = n2.c();
            d4 = n2.f();
            d2 = n2.e();
            if (n3 == 0) return new y(d3, d5, d2, d4);
        }
        if (n2.g() == 1.0 && n2.i() == 0.0) {
            d3 = n2.b();
            d5 = n2.c();
            d4 = n2.e();
            d2 = n2.f();
            if (n3 == 0) return new y(d3, d5, d2, d4);
        }
        if (n2.g() != -1.0) return null;
        if (n2.i() != 0.0) return null;
        d3 = n2.b() - n2.e();
        d5 = n2.c() - n2.f();
        d4 = n2.e();
        d2 = n2.f();
        if (n3 == 0) return new y(d3, d5, d2, d4);
        return null;
    }

    static double a(y y2, n n2) {
        if (m.a(n2)) {
            return m.a(y2, m.b(n2));
        }
        if (!n.a(n2, y2, 0.001)) return m.a(y2, n.a(n2));
        return 0.0;
    }

    static double a(y y2, y y3) {
        if (y.a(y2, y3)) {
            return 0.0;
        }
        double d2 = m.a(y2, y3, false);
        double d3 = m.a(y2, y3, true);
        return Math.sqrt(d2 * d2 + d3 * d3);
    }

    private static double a(y y2, y y3, boolean bl2) {
        double d2 = bl2 ? y2.c() : y2.d();
        double d3 = bl2 ? y2.c() + y2.a() : y2.d() + y2.b();
        double d4 = bl2 ? y3.c() : y3.d();
        double d5 = bl2 ? y3.c() + y3.a() : y3.d() + y3.b();
        return m.a(d2, d3, d4, d5);
    }

    private static double a(double d2, double d3, double d4, double d5) {
        if (d5 < d2) {
            return d5 - d2;
        }
        if (d3 >= d4) return 0.0;
        return d4 - d3;
    }

    private static double a(y.d.m m2, y.d.m m3) {
        if (y.d.m.a(m2, m3) != null) {
            return 0.0;
        }
        double d2 = m.a(m2, m3.c());
        d2 = Math.min(d2, m.a(m2, m3.d()));
        d2 = Math.min(d2, m.a(m3, m2.c()));
        return Math.min(d2, m.a(m3, m2.d()));
    }

    private static double a(y y2, t[] arrt) {
        int n2 = a.f;
        t t2 = y2.e();
        t t3 = new t(t2.a, t2.b + y2.b());
        t t4 = new t(t3.a + y2.a(), t3.b);
        t t5 = new t(t4.a, t2.b);
        y.d.m[] arrm = new y.d.m[]{new y.d.m(t2, t3), new y.d.m(t5, t4), new y.d.m(t2, t5), new y.d.m(t3, t4)};
        double d2 = Double.MAX_VALUE;
        int n3 = 0;
        block0 : do {
            if (n3 >= arrt.length) return d2;
            y.d.m m2 = new y.d.m(arrt[n3], arrt[(n3 + 1) % arrt.length]);
            for (int i2 = 0; i2 < arrm.length; ++i2) {
                d2 = Math.min(d2, m.a(m2, arrm[i2]));
                if (n2 != 0) continue block0;
                if (n2 == 0) continue;
            }
            ++n3;
        } while (n2 == 0);
        return d2;
    }

    static double a(n n2, t t2) {
        double d2;
        int n3 = a.f;
        if (m.a(n2)) {
            return m.a(m.b(n2), t2);
        }
        if (n.a(n2, t2, 0.001)) {
            return 0.0;
        }
        t[] arrt = n.a(n2);
        double d3 = Double.MAX_VALUE;
        for (int i2 = 0; i2 < arrt.length; ++i2) {
            y.d.m m2 = new y.d.m(arrt[i2], arrt[(i2 + 1) % arrt.length]);
            d2 = Math.min(d3, m.a(m2, t2));
            if (n3 != 0) return d2;
            d3 = d2;
            if (n3 == 0) continue;
        }
        d2 = d3;
        return d2;
    }

    private static double a(y y2, t t2) {
        if (y2.a(t2)) {
            return 0.0;
        }
        t t3 = y2.e();
        t t4 = new t(t3.a, t3.b + y2.b());
        t t5 = new t(t4.a + y2.a(), t4.b);
        t t6 = new t(t5.a, t3.b);
        double d2 = Double.MAX_VALUE;
        y.d.m m2 = new y.d.m(t3, t4);
        d2 = Math.min(d2, m.a(m2, t2));
        y.d.m m3 = new y.d.m(t6, t5);
        d2 = Math.min(d2, m.a(m3, t2));
        y.d.m m4 = new y.d.m(t3, t6);
        d2 = Math.min(d2, m.a(m4, t2));
        y.d.m m5 = new y.d.m(t4, t5);
        return Math.min(d2, m.a(m5, t2));
    }

    /*
     * Unable to fully structure code
     */
    static double a(y.d.m var0, t var1_1) {
        var2_2 = var0.c().a;
        var4_3 = var0.d().a;
        var6_4 = var0.c().b;
        var8_5 = var0.d().b;
        var10_6 = var1_1.a();
        var12_7 = var1_1.b();
        var14_8 = 0.0;
        var16_9 = (var10_6 -= var2_2) * (var4_3 -= var2_2) + (var12_7 -= var6_4) * (var8_5 -= var6_4);
        if (var16_9 <= 0.0) ** GOTO lbl15
        var16_9 = (var10_6 = var4_3 - var10_6) * var4_3 + (var12_7 = var8_5 - var12_7) * var8_5;
        if (var16_9 > 0.0) ** GOTO lbl-1000
        var14_8 = 0.0;
        if (a.f != 0) lbl-1000: // 2 sources:
        {
            var14_8 = var16_9 * var16_9 / (var4_3 * var4_3 + var8_5 * var8_5);
        }
lbl15: // 4 sources:
        if ((var18_10 = var10_6 * var10_6 + var12_7 * var12_7 - var14_8) >= 0.0) return Math.sqrt(var18_10);
        return 0.0;
    }
}

