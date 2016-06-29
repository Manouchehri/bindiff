/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a;

import java.util.Collection;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.i;
import y.d.t;
import y.f.X;
import y.f.f.a.a.h;
import y.f.f.a.a.m;
import y.f.f.a.a.p;
import y.f.f.a.b.a;
import y.f.f.a.f;
import y.f.f.a.l;

public class k {
    private a a;
    private X b;
    private p c;
    private y.c.f d;

    public k(a a2, y.c.f f2) {
        this.a = a2;
        this.b = (X)this.a.d();
        this.c = this.a.b();
        this.d = f2;
    }

    public static void a(a a2, y.c.f f2) {
        k k2 = new k(a2, f2);
        k2.a();
    }

    public void a() {
        this.c();
        this.b();
    }

    private void b() {
        boolean bl2 = f.a;
        e e2 = this.d.a();
        do {
            y.c.f f2;
            if (!e2.f()) return;
            y.c.f f3 = new y.c.f();
            D d2 = null;
            d d3 = e2.a();
            if (!this.b.f(d3)) {
                this.b.e(d3);
            }
            if ((f2 = this.a.x(d3)) != null) {
                d2 = this.a(f2.b());
                d2.addAll(this.a(f2.c()));
            } else {
                d2 = this.a(d3);
            }
            this.b.c(d3, (t)d2.f());
            this.b.d(d3, (t)d2.i());
            d2.h(d2.k());
            d2.h(d2.l());
            this.b.b(d3, d2);
            e2.g();
        } while (!bl2);
    }

    private D a(d d2) {
        d d3;
        boolean bl2;
        e e2;
        D d4;
        block7 : {
            boolean bl3;
            bl2 = f.a;
            d4 = new D();
            y.c.f f2 = null;
            d d5 = this.a.w(d2);
            if (d5 != null) {
                f2 = this.a.d(d5);
                e2 = f2.a();
                while (e2.f()) {
                    d3 = e2.a();
                    bl3 = this.a.p(d3);
                    if (!bl2) {
                        if (bl3) {
                            f2.remove(d3);
                        }
                        e2.g();
                        continue;
                    }
                    break block7;
                }
            } else {
                f2 = this.a.d(d2);
            }
            if (f2 == null) {
                f2 = new y.c.f(d2);
            }
            e2 = f2.a();
            e2.i();
            bl3 = d4.add(this.b.p(e2.a()));
        }
        while (e2.f()) {
            d3 = e2.a();
            d4.addAll(this.b.k(d3));
            e2.g();
            if (bl2) return d4;
            if (!bl2) continue;
        }
        e2.j();
        d4.b(this.b.q(e2.a()));
        return d4;
    }

    private void c() {
        m.a((h)new y.f.f.a.m(this, null), this.c);
    }

    static X a(k k2) {
        return k2.b;
    }

    static a b(k k2) {
        return k2.a;
    }
}

