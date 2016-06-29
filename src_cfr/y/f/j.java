/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.c.D;
import y.c.d;
import y.c.e;
import y.d.n;
import y.d.q;
import y.d.t;
import y.f.X;
import y.f.ai;
import y.f.aj;
import y.f.al;
import y.f.am;

public class J
implements al {
    private X a;
    private y.c.q b;
    private boolean c;

    public J(X x2, y.c.q q2) {
        this.a = x2;
        this.b = q2;
    }

    @Override
    public Object c() {
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public n a(q q2, am am2, Object object) {
        boolean bl2 = X.j;
        double d2 = am2.getX() + (am2.getWidth() - q2.a()) / 2.0;
        double d3 = am2.getY() + (am2.getHeight() - q2.b()) / 2.0;
        y.c.q q3 = this.b;
        if (this.c) return new n(new t(d2, d3 + q2.b()), q2);
        if (q3 == null) return new n(new t(d2, d3 + q2.b()), q2);
        if (q3.a() <= 0) return new n(new t(d2, d3 + q2.b()), q2);
        this.c = true;
        try {
            double d4;
            double d5;
            block6 : {
                d5 = 0.0;
                d4 = 0.0;
                e e2 = q3.j();
                while (e2.f()) {
                    d d6 = e2.a();
                    y.c.q q4 = d6.a(q3);
                    d5 += this.a.j(q3) - this.a.j(q4);
                    d4 += this.a.k(q3) - this.a.k(q4);
                    e2.g();
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block6;
                }
                d5 /= (double)q3.a();
                d4 /= (double)q3.a();
            }
            if (d5 == 0.0) {
                if (d4 == 0.0) return new n(new t(d2, d3 + q2.b()), q2);
            }
            double d7 = Math.sqrt(d5 * d5 + d4 * d4);
            double d8 = Math.sqrt(this.a.q(q3) * this.a.q(q3) + this.a.p(q3) * this.a.p(q3));
            d5 = d5 * (d8 + 10.0) / d7;
            d4 = d4 * (d8 + 10.0) / d7;
            n n2 = new n(new t(d2 + d5, d3 + d4 + q2.b()), q2);
            return n2;
        }
        finally {
            this.c = false;
        }
    }

    @Override
    public Object a(n n2, am am2) {
        return null;
    }

    @Override
    public D a(aj aj2, am am2) {
        D d2 = new D();
        n n2 = this.a(aj2.getOrientedBox().d(), am2, null);
        d2.add(new ai(n2, null, aj2, false));
        return d2;
    }
}

