/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import y.d.y;

class t {
    static y a(y y2, y y3) {
        y y4;
        if (y2 != null && y3 != null) {
            double d2 = Math.min(y2.c(), y3.c());
            double d3 = Math.max(y2.c() + y2.a(), y3.c() + y3.a());
            double d4 = Math.min(y2.d(), y3.d());
            double d5 = Math.max(y2.d() + y2.b(), y3.d() + y3.b());
            return new y(d2, d4, d3 - d2, d5 - d4);
        }
        if (y2 == null) {
            y4 = y3;
            return y4;
        }
        y4 = y2;
        return y4;
    }

    static double b(y y2, y y3) {
        if (y.a(y2, y3)) {
            return 0.0;
        }
        double d2 = t.a(y2, y3, false);
        double d3 = t.a(y2, y3, true);
        return Math.sqrt(d2 * d2 + d3 * d3);
    }

    private static double a(y y2, y y3, boolean bl2) {
        double d2 = bl2 ? y2.c() : y2.d();
        double d3 = bl2 ? y2.c() + y2.a() : y2.d() + y2.b();
        double d4 = bl2 ? y3.c() : y3.d();
        double d5 = bl2 ? y3.c() + y3.a() : y3.d() + y3.b();
        return t.a(d2, d3, d4, d5);
    }

    private static double a(double d2, double d3, double d4, double d5) {
        if (d5 < d2) {
            return d5 - d2;
        }
        if (d3 >= d4) return 0.0;
        return d4 - d3;
    }
}

