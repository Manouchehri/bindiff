/*
 * Decompiled with CFR 0_115.
 */
package y.g.a;

import y.c.i;
import y.c.x;
import y.g.a.g;
import y.g.a.p;
import y.g.a.q;

public class d
implements g {
    private p b;
    private q[] c;
    private i d;
    public static boolean a;

    public d(i i2) {
        this.d = i2;
        this.b = new p(i2.f());
        this.c = new q[i2.f()];
    }

    @Override
    public void a(y.c.q q2, int n2) {
        q q3 = this.b.a(n2, q2);
        if (q2.d() < this.c.length) {
            this.c[q2.d()] = q3;
            if (!a) return;
        }
        q[] arrq = new q[java.lang.Math.max(2 * this.c.length, q2.d() + 1)];
        System.arraycopy(this.c, 0, arrq, 0, this.c.length);
        this.c = arrq;
        this.c[q2.d()] = q3;
    }

    @Override
    public void b(y.c.q q2, int n2) {
        q q3 = this.c[q2.d()];
        this.b.a(q3, n2);
    }

    public void c(y.c.q q2, int n2) {
        this.b.c(this.c[q2.d()], n2);
    }

    @Override
    public y.c.q c() {
        q q2 = this.b.b();
        this.b.a(q2);
        y.c.q q3 = (y.c.q)q2.b;
        this.c[q3.d()] = null;
        return q3;
    }

    public y.c.q b() {
        return (y.c.q)this.b.b().b;
    }

    public int e() {
        return this.b.b().a;
    }

    @Override
    public boolean a(y.c.q q2) {
        if (this.c[q2.d()] == null) return false;
        return true;
    }

    @Override
    public boolean a() {
        return this.b.c();
    }

    @Override
    public int b(y.c.q q2) {
        return this.c[q2.d()].a;
    }

    public void c(y.c.q q2) {
        this.b.a(this.c[q2.d()]);
        this.c[q2.d()] = null;
    }

    @Override
    public void d() {
        block3 : {
            d d2;
            boolean bl2 = a;
            x x2 = this.d.o();
            while (x2.f()) {
                d2 = this;
                if (!bl2) {
                    if (d2.a(x2.e())) {
                        this.c[x2.e().d()] = null;
                    }
                    x2.g();
                    if (!bl2) continue;
                }
                break block3;
            }
            d2 = this;
        }
        d2.b.a();
    }

    public void f() {
    }
}

