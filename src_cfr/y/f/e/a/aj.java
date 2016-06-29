/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import java.awt.geom.Rectangle2D;
import y.c.d;
import y.c.q;
import y.c.x;
import y.f.X;
import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.aq;
import y.f.e.a.ax;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.w;

public class aj
implements ax {
    private double a = 50.0;
    private boolean b = false;

    public void a(boolean bl2) {
        this.b = bl2;
    }

    public void a(double d2) {
        this.a = d2;
    }

    @Override
    public k a(m m2, l l2, a a2) {
        boolean bl2 = af.b;
        q q2 = m2.j();
        w w2 = l2.b();
        k k2 = m2.a();
        double d2 = k2.d();
        double d3 = k2.e();
        double d4 = k2.f();
        double d5 = this.a * 5.0;
        Rectangle2D.Double double_ = new Rectangle2D.Double(d2 - d5, d3 - d5, 2.0 * d5, 2.0 * d5);
        double d6 = 0.0;
        double d7 = 0.0;
        double d8 = 0.0;
        x x2 = l2.b().f().o();
        while (x2.f()) {
            q q3 = x2.e();
            if (bl2) return a2;
            q q4 = q3;
            q q5 = q2;
            block1 : while (q4 != q5 && q3.f() != null) {
                k k3 = w2.a(q3).a();
                double d9 = k3.d();
                double d10 = d2 - d9;
                double d11 = k3.e();
                double d12 = d3 - d11;
                double d13 = k3.f();
                double d14 = d4 - d13;
                double d15 = Math.max(Math.sqrt(d10 * d10 + d12 * d12 + d14 * d14), 0.001);
                double d16 = 1.0 / d15;
                for (d d17 = q3.f(); d17 != null; d17 = d17.g()) {
                    double d18;
                    double d19;
                    double d20;
                    double d21;
                    q4 = q2;
                    q5 = d17.d();
                    if (bl2) continue block1;
                    if (q4 == q5) continue;
                    double d22 = w2.a(d17).a();
                    double d23 = this.a + m2.h();
                    double d24 = Math.sqrt(d23 * d23 + d22 * d22);
                    k k4 = w2.a(d17.d()).a();
                    if (this.b && !double_.intersectsLine(d9, d11, k4.d(), k4.e()) || (d20 = Math.sqrt((d19 = k4.d() - d9) * d19 + (d18 = k4.e() - d11) * d18 + (d21 = k4.f() - d13) * d21)) < 0.001) continue;
                    double d25 = 1.0 / d20;
                    double d26 = (d10 * d19 + d12 * d18 + d14 * d21) * d25;
                    double d27 = (- d26) * d25;
                    double d28 = d10 + d27 * d19;
                    double d29 = d12 + d27 * d18;
                    double d30 = d14 + d27 * d21;
                    d27 = d28 * d28 + d29 * d29 + d30 * d30;
                    if (d27 < 0.001) {
                        d27 = 0.001;
                    }
                    double d31 = - d26;
                    double d32 = d31 + d20;
                    double d33 = 1.0 / Math.sqrt(d32 * d32 + d27);
                    double d34 = (d33 - d16) * d25 * d24;
                    double d35 = (d32 * d33 - d31 * d16) * d24 / d27;
                    d6 += d19 * d34 + d28 * d35;
                    d7 += d18 * d34 + d29 * d35;
                    d8 += d21 * d34 + d30 * d35;
                    if (!bl2) continue;
                }
            }
            x2.g();
            if (!bl2) continue;
        }
        a2.b(d6, d7, d8);
        return a2;
    }
}

