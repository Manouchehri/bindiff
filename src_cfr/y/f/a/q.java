/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import y.c.x;
import y.f.X;
import y.f.a.f;
import y.f.a.j;
import y.f.e.a.af;
import y.f.e.a.ag;
import y.f.e.a.am;
import y.f.e.a.l;
import y.f.e.a.m;

class q
implements am {
    private double a;
    private double b;
    private final j c;

    q(j j2) {
        this.c = j2;
    }

    public void a(double d2) {
        this.a = d2;
    }

    public void b(double d2) {
        this.b = d2;
    }

    @Override
    public void a(l l2, af af2) {
        double d2;
        double d3;
        int n2;
        block5 : {
            q q2;
            n2 = f.u;
            X x2 = af2.f();
            if (x2.e() - j.a(this.c).size() <= 0) {
                return;
            }
            d3 = 0.0;
            double d4 = 1.0 / af2.c();
            x x3 = x2.o();
            while (x3.f()) {
                y.c.q q3 = x3.e();
                q2 = this;
                if (n2 == 0) {
                    if (!j.c(q2.c).d(q3)) {
                        d2 = af2.a(q3).e() * d4;
                        d3 += j.b(this.c).c(q3) * d2;
                    }
                    x3.g();
                    if (n2 == 0) continue;
                }
                break block5;
            }
            d3 /= (double)(x2.e() - j.a(this.c).size());
            q2 = this;
        }
        double d5 = q2.a;
        d2 = 1.0 - l2.a();
        double d6 = this.a * d3 * d2;
        if (d3 == 0.0) return;
        if (d6 < d5) return;
        double d7 = this.b;
        this.b += d6;
        j.d(this.c).b(this.b);
        double d8 = this.b / d7;
        x x4 = j.a(this.c).a();
        do {
            if (!x4.f()) return;
            y.c.q q4 = x4.e();
            ag ag2 = af2.c(q4);
            double d9 = ag2.b() * d8;
            double d10 = ag2.c() * d8;
            ag2.a(d9, d10, 0.0);
            x4.g();
        } while (n2 == 0);
    }
}

