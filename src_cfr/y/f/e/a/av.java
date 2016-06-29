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

public class av
implements ax {
    private double a = 0.0;
    private double b = 0.0;
    private k c = new Z();

    public void a(double d2) {
        this.a = d2;
    }

    public void b(double d2) {
        this.b = d2;
    }

    @Override
    public k a(m m2, l l2, a a2) {
        k k2 = m2.a();
        double d2 = this.c.d() - k2.d();
        double d3 = this.c.e() - k2.e();
        double d4 = Math.sqrt(d2 * d2 + d3 * d3);
        double d5 = this.b - this.a;
        if (this.a <= 0.0) return a2;
        if (d5 <= 0.0) return a2;
        if (d4 < d5) {
            return a2;
        }
        double d6 = (d4 - d5) / this.a;
        double d7 = d2 / d4 * d6;
        double d8 = d3 / d4 * d6;
        a2.a(d7);
        a2.b(d8);
        a2.c(0.0);
        return a2;
    }
}

