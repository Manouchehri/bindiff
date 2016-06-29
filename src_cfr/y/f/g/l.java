/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import java.util.Comparator;
import y.c.A;
import y.c.C;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.X;
import y.f.g.d;
import y.f.g.m;
import y.g.M;
import y.g.a.g;

class l
implements g {
    private X a;
    private i b;
    private y c;
    private A d;
    private A e;
    private y f;
    private final d g;

    l(d d2, X x2, i i2, A a2, y y2) {
        this.g = d2;
        this.a = x2;
        this.b = i2;
        this.e = a2;
        this.c = new y();
        this.d = M.a();
        this.f = y2;
        y2.sort(new m(i2));
    }

    @Override
    public boolean a() {
        return this.c.isEmpty();
    }

    @Override
    public boolean a(q q2) {
        return this.c.contains(q2);
    }

    @Override
    public void a(q q2, int n2) {
        this.c.add(q2);
        this.d.a((Object)q2, n2);
    }

    public q b() {
        q q2;
        q q3;
        block8 : {
            boolean bl2;
            int n2;
            block7 : {
                bl2 = d.d;
                if (this.a()) {
                    return null;
                }
                x x2 = this.f.a();
                while (x2.f()) {
                    q3 = x2.e();
                    n2 = q3.b();
                    if (!bl2) {
                        if (n2 == 0) {
                            this.f.b(x2);
                            this.b.a(q3);
                        }
                        x2.g();
                        if (!bl2) continue;
                    }
                    break block7;
                }
                n2 = Integer.MAX_VALUE;
            }
            int n3 = n2;
            q3 = null;
            double d2 = 0.0;
            x x3 = this.c.a();
            while (x3.f()) {
                q q4;
                q q5 = x3.e();
                double d3 = this.a.p(q5) * this.a.q(q5);
                int n4 = this.b(q5);
                q2 = q4 = (q)this.e.b(q5);
                if (!bl2) {
                    if ((q2 == null || q4.b() == 0) && (n3 > n4 || n3 == n4 && d3 > d2)) {
                        n3 = n4;
                        q3 = q5;
                        d2 = d3;
                    }
                    x3.g();
                    if (!bl2) continue;
                }
                break block8;
            }
            q2 = q3;
        }
        if (q2 != null) return q3;
        throw new RuntimeException("Found no valid element!");
    }

    @Override
    public q c() {
        q q2 = this.b();
        this.c.remove(q2);
        q q3 = (q)this.e.b(q2);
        this.b.a(q3);
        return q2;
    }

    @Override
    public void b(q q2, int n2) {
        this.d.a((Object)q2, n2);
    }

    @Override
    public void d() {
        this.c.clear();
        this.d = M.a();
    }

    @Override
    public int b(q q2) {
        return this.d.a(q2);
    }
}

