/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.f.e.a.Z;
import y.f.e.a.a;
import y.f.e.a.ax;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;

public class an
implements ax {
    private double a = 0.0;
    private double b = 0.0;
    private double c = 0.0;
    private k d = new Z();

    @Override
    public k a(m m2, l l2, a a2) {
        k k2 = m2.a();
        double d2 = this.c / this.b;
        double d3 = this.d.d() - k2.d();
        double d4 = this.d.e() - k2.e();
        double d5 = Math.sqrt(d3 * d3 + d4 * (d4 /= d2));
        double d6 = this.b - this.a;
        if (this.a <= 0.0) return a2;
        if (d6 <= 0.0) return a2;
        if (d5 < d6) {
            return a2;
        }
        double d7 = (d5 - d6) / this.a;
        double d8 = d3 / d5 * d7;
        double d9 = d4 / d5 * d7;
        a2.a(d8);
        a2.b(d9 *= d2);
        a2.c(0.0);
        return a2;
    }
}

