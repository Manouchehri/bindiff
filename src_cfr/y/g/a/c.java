/*
 * Decompiled with CFR 0_115.
 */
package y.g.a;

import y.c.i;
import y.c.q;
import y.c.x;
import y.g.a.d;
import y.g.a.e;
import y.g.a.n;
import y.g.a.o;

public class c
implements e {
    private n a;
    private o[] b;
    private i c;

    public c(i i2) {
        this.c = i2;
        this.a = new n(i2.f());
        this.b = new o[i2.f()];
    }

    @Override
    public void a(q q2, double d2) {
        o o2 = this.a.a(d2, q2);
        if (q2.d() < this.b.length) {
            this.b[q2.d()] = o2;
            if (!d.a) return;
        }
        o[] arro = new o[java.lang.Math.max(2 * this.b.length, q2.d() + 1)];
        System.arraycopy(this.b, 0, arro, 0, this.b.length);
        this.b = arro;
        this.b[q2.d()] = o2;
    }

    @Override
    public void b(q q2, double d2) {
        o o2 = this.b[q2.d()];
        this.a.a(o2, d2);
    }

    public void c(q q2, double d2) {
        o o2 = this.b[q2.d()];
        this.a.b(o2, d2);
    }

    public void d(q q2, double d2) {
        this.a.c(this.b[q2.d()], d2);
    }

    @Override
    public q a() {
        o o2 = this.a.b();
        this.a.a(o2);
        q q2 = (q)o2.b;
        this.b[q2.d()] = null;
        return q2;
    }

    @Override
    public boolean a(q q2) {
        if (this.b[q2.d()] == null) return false;
        return true;
    }

    @Override
    public boolean b() {
        return this.a.c();
    }

    public void b(q q2) {
        this.a.a(this.b[q2.d()]);
        this.b[q2.d()] = null;
    }

    public void c() {
        block3 : {
            c c2;
            boolean bl2 = d.a;
            x x2 = this.c.o();
            while (x2.f()) {
                c2 = this;
                if (!bl2) {
                    if (c2.a(x2.e())) {
                        this.b[x2.e().d()] = null;
                    }
                    x2.g();
                    if (!bl2) continue;
                }
                break block3;
            }
            c2 = this;
        }
        c2.a.a();
    }
}

