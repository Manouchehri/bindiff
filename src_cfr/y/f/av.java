/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.d.m;
import y.d.n;
import y.d.t;
import y.d.y;
import y.f.X;

final class aV {
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
        boolean bl2 = X.j;
        if (n2.g() == 0.0 && n2.i() == -1.0) {
            d3 = n2.b();
            d5 = n2.c() - n2.f();
            d4 = n2.f();
            d2 = n2.e();
            if (!bl2) return new y(d3, d5, d2, d4);
        }
        if (n2.g() == 0.0 && n2.i() == 1.0) {
            d3 = n2.b() - n2.e();
            d5 = n2.c();
            d4 = n2.f();
            d2 = n2.e();
            if (!bl2) return new y(d3, d5, d2, d4);
        }
        if (n2.g() == 1.0 && n2.i() == 0.0) {
            d3 = n2.b();
            d5 = n2.c();
            d4 = n2.e();
            d2 = n2.f();
            if (!bl2) return new y(d3, d5, d2, d4);
        }
        if (n2.g() != -1.0) return null;
        if (n2.i() != 0.0) return null;
        d3 = n2.b() - n2.e();
        d5 = n2.c() - n2.f();
        d4 = n2.e();
        d2 = n2.f();
        if (!bl2) return new y(d3, d5, d2, d4);
        return null;
    }

    static double a(y y2, n n2) {
        if (aV.a(n2)) {
            return aV.a(y2, aV.b(n2));
        }
        if (!n.a(n2, y2, 0.001)) return aV.a(y2, n.a(n2));
        return 0.0;
    }

    static double a(y y2, y y3) {
        if (y.a(y2, y3)) {
            return 0.0;
        }
        double d2 = aV.a(y2, y3, false);
        double d3 = aV.a(y2, y3, true);
        return Math.sqrt(d2 * d2 + d3 * d3);
    }

    private static double a(y y2, y y3, boolean bl2) {
        double d2 = bl2 ? y2.c() : y2.d();
        double d3 = bl2 ? y2.c() + y2.a() : y2.d() + y2.b();
        double d4 = bl2 ? y3.c() : y3.d();
        double d5 = bl2 ? y3.c() + y3.a() : y3.d() + y3.b();
        return aV.a(d2, d3, d4, d5);
    }

    private static double a(double d2, double d3, double d4, double d5) {
        if (d5 < d2) {
            return d5 - d2;
        }
        if (d3 >= d4) return 0.0;
        return d4 - d3;
    }

    static double a(m m2, m m3) {
        if (m.a(m2, m3) != null) {
            return 0.0;
        }
        double d2 = aV.a(m2, m3.c());
        d2 = Math.min(d2, aV.a(m2, m3.d()));
        d2 = Math.min(d2, aV.a(m3, m2.c()));
        return Math.min(d2, aV.a(m3, m2.d()));
    }

    private static double a(y y2, t[] arrt) {
        boolean bl2 = X.j;
        t t2 = y2.e();
        t t3 = new t(t2.a, t2.b + y2.b());
        t t4 = new t(t3.a + y2.a(), t3.b);
        t t5 = new t(t4.a, t2.b);
        m[] arrm = new m[]{new m(t2, t3), new m(t5, t4), new m(t2, t5), new m(t3, t4)};
        double d2 = Double.MAX_VALUE;
        int n2 = 0;
        block0 : do {
            if (n2 >= arrt.length) return d2;
            m m2 = new m(arrt[n2], arrt[(n2 + 1) % arrt.length]);
            for (int i2 = 0; i2 < arrm.length; ++i2) {
                d2 = Math.min(d2, aV.a(m2, arrm[i2]));
                if (bl2) continue block0;
                if (!bl2) continue;
            }
            ++n2;
        } while (!bl2);
        return d2;
    }

    /*
     * Unable to fully structure code
     */
    static double a(m var0, t var1_1) {
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
        if (X.j) lbl-1000: // 2 sources:
        {
            var14_8 = var16_9 * var16_9 / (var4_3 * var4_3 + var8_5 * var8_5);
        }
lbl15: // 4 sources:
        if ((var18_10 = var10_6 * var10_6 + var12_7 * var12_7 - var14_8) >= 0.0) return Math.sqrt(var18_10);
        return 0.0;
    }
}

