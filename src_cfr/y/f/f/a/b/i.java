/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import y.c.d;
import y.c.q;
import y.f.f.a.a.b;
import y.f.f.a.a.e;
import y.f.f.a.a.f;
import y.f.f.a.a.g;
import y.f.f.a.a.h;
import y.f.f.a.a.l;
import y.f.f.a.a.m;
import y.f.f.a.a.p;
import y.f.f.a.b.a;
import y.f.f.a.b.j;
import y.f.f.a.b.k;
import y.f.f.a.b.n;

public class i
implements g,
l {
    protected y.c.i a;
    protected p b;
    protected y.f.f.a.a.j c;
    private y.c.f d;
    private y.c.h e;

    public i(y.c.i i2, p p2) {
        this.a = i2;
        this.b = p2;
        this.c = this.b.b();
        this.d = new y.c.f();
        this.e = this.a.u();
        this.c();
    }

    public void c() {
        this.c.a(this);
    }

    public void d() {
        this.b.a(this.c);
        this.a.a(this.e);
    }

    @Override
    public Object b() {
        return new n();
    }

    @Override
    public e a() {
        return this.c.a();
    }

    public void e() {
        boolean bl2 = a.c;
        this.c();
        y.c.e e2 = this.a.p();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            b b2 = this.b.a(e2.a().c());
            b b3 = this.b.a(e2.a().d());
            if (b2.c() != b3.c()) {
                throw new RuntimeException("Replace edges by their representatives!");
            }
            n n2 = (n)this.c.a((f)b2.c());
            n2.a(d2);
            e2.g();
        } while (!bl2);
    }

    public void a(b b2) {
        n n2 = (n)this.c.a(b2);
        n2.a(this.a);
    }

    public void b(b b2) {
        n n2 = (n)this.c.a(b2);
        n2.b(this.a);
    }

    public void f() {
        m.a((h)new j(this), this.c);
    }

    public void g() {
        m.a((h)new k(this), this.c);
    }

    public void h() {
        boolean bl2 = a.c;
        b b2 = null;
        b b3 = null;
        y.c.e e2 = this.a.p();
        do {
            b b4;
            if (!e2.f()) return;
            d d2 = e2.a();
            b b5 = this.b.a(d2.c());
            if (!y.f.f.a.a.n.a(b5, b4 = this.b.a(d2.d()))) {
                e[] arre = y.f.f.a.a.n.b(b5, b4);
                b2 = (b)arre[0];
                b3 = (b)arre[1];
                d d3 = this.a.a(b2.b_(), b3.b_());
                this.d.add(d3);
                this.e.a((Object)d3, d2);
                this.a.d(d2);
            }
            e2.g();
        } while (!bl2);
    }

    public void i() {
        boolean bl2 = a.c;
        y.c.e e2 = this.d.a();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            this.a.e((d)this.e.b(d2));
            this.a.a(d2);
            e2.g();
        } while (!bl2);
    }

    public d a(d d2) {
        return (d)this.e.b(d2);
    }
}

