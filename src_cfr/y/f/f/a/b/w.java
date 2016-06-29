/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import y.c.D;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.h;
import y.c.i;
import y.f.f.a.a.p;
import y.f.f.a.b.E;
import y.f.f.a.b.a;
import y.f.f.a.b.g;
import y.f.f.a.b.l;
import y.f.f.a.b.m;
import y.f.f.a.b.r;
import y.f.f.a.b.u;
import y.f.f.a.b.x;
import y.f.f.a.b.y;
import y.f.f.a.b.z;
import y.f.f.b;
import y.f.h.o;

public class w
implements o {
    private i a;
    private p b;
    private y.f.h.D c;
    private a d;
    private f e;
    private f f;
    private int g = 0;
    private boolean h = true;
    private boolean i = false;

    public w(a a2, f f2) {
        this.a(a2);
        this.e = f2;
    }

    @Override
    public void a() {
    }

    public void a(a a2) {
        this.d = a2;
        this.a = this.d.d();
        this.b = this.d.b();
    }

    @Override
    public void a(y.f.h.D d2) {
        this.c = d2;
    }

    public a b() {
        return this.d;
    }

    public void a(int n2) {
        this.g = n2;
    }

    public void a(boolean bl2) {
        this.h = bl2;
    }

    public void b(boolean bl2) {
        this.i = bl2;
    }

    private f d() {
        f f2;
        boolean bl2 = a.c;
        f f3 = new f();
        f[] arrf = y.a.h.d(this.a);
        for (int i2 = 0; i2 < arrf.length; ++i2) {
            f f4;
            f2 = f4 = arrf[i2];
            if (bl2) return f2;
            if (f2.size() <= 1) continue;
            f3.a(f4);
            if (!bl2) continue;
        }
        f2 = f3;
        return f2;
    }

    @Override
    public void c() {
        boolean bl2 = a.c;
        d[] arrd = this.c.g().n();
        this.d.a(this.c);
        f f2 = this.d();
        l l2 = this.e();
        l2.a(this.d);
        this.f = l2.a();
        if (this.g == 1) {
            this.b(this.f);
        }
        f f3 = m.a(this.d);
        r.a(this.d);
        this.d.g();
        y y2 = new y(this.d);
        y2.a(this.h);
        y2.a(this.f);
        y2.a();
        if (this.i) {
            u u2 = new u(this.d);
            u2.a(f2);
        }
        this.d.h();
        z.a(this.d, this.e);
        int n2 = 0;
        do {
            if (n2 >= arrd.length) return;
            this.a(arrd[n2], this.d.d(arrd[n2]));
            ++n2;
        } while (!bl2);
        i.g = !i.g;
    }

    private f a(f f2) {
        boolean bl2 = a.c;
        if (f2 == null) {
            return null;
        }
        f f3 = new f();
        e e2 = f2.a();
        do {
            if (!e2.f()) return f3;
            d d2 = e2.a();
            if (!this.d.p(d2)) {
                f3.add(d2);
            }
            e2.g();
        } while (!bl2);
        return f3;
    }

    private void a(d d2, f f2) {
        boolean bl2 = a.c;
        h h2 = (h)this.a.c(b.n);
        y.f.f.a a2 = (y.f.f.a)h2.b(d2);
        f f3 = this.a(f2);
        if (a2 == null) return;
        if (f3 == null) return;
        int n2 = 0;
        e e2 = f3.a();
        do {
            if (!e2.f()) return;
            y.f.f.a a3 = a2.d();
            if (n2 > 0) {
                a3.a(0.0);
            }
            if (n2 < f3.size() - 1) {
                a3.b(0.0);
            }
            h2.a((Object)e2.a(), a3);
            e2.g();
            ++n2;
        } while (!bl2);
    }

    private l e() {
        switch (this.g) {
            case 0: {
                return new x();
            }
            case 1: {
                return new g();
            }
        }
        throw new RuntimeException("Bad subgraph algorithm!");
    }

    private void b(f f2) {
        Object object;
        block6 : {
            boolean bl2;
            block5 : {
                w w2;
                bl2 = a.c;
                this.d.g();
                if (E.b(this.a, this.b)) {
                    this.d.h();
                    return;
                }
                d[] arrd = this.a.n();
                for (int i2 = 0; i2 < arrd.length; ++i2) {
                    d d2 = arrd[i2];
                    w2 = this;
                    if (!bl2) {
                        if (!w2.d.a(d2)) continue;
                        this.a.a(d2);
                        if (!bl2) continue;
                    }
                    break block5;
                }
                w2 = this;
            }
            object = w2.f.a();
            while (object.f()) {
                this.a.e(object.a());
                object.g();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block6;
            }
            this.f = null;
            this.a(0);
        }
        object = this.e();
        object.a(this.d);
        this.f = object.a();
    }
}

