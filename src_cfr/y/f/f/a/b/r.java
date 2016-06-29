/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import java.util.Collection;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.p;
import y.c.q;
import y.f.f.a.a.h;
import y.f.f.a.a.m;
import y.f.f.a.b.a;
import y.f.f.a.b.s;
import y.f.f.a.b.t;

public class r {
    private a a;
    private i b;
    private y.f.f.a.a.p c;

    public r(a a2) {
        this.a = a2;
        this.b = this.a.d();
        this.c = this.a.b();
    }

    public static void a(a a2) {
        r r2 = new r(a2);
        r2.a();
    }

    public void a() {
        this.a.g();
        m.b((h)new t(this, null), this.c);
    }

    public void a(q q2) {
        boolean bl2 = a.c;
        f f2 = this.a.b(q2);
        f f3 = new f();
        d d2 = (d)f2.f();
        d d3 = this.a.l(d2);
        f3.a(d2);
        while (d2 != d3) {
            if (d3.d() == q2) {
                d3 = this.a.c(d3);
                if (!bl2) continue;
            }
            if (d3.c() == q2) {
                f3.a(d3);
            }
            d3 = this.a.l(d3);
            if (!bl2) continue;
        }
        this.a.b(q2, f3);
    }

    public void b(q q2) {
        boolean bl2 = a.c;
        f f2 = this.a.b(q2);
        f f3 = this.a.a(q2);
        f f4 = new f();
        e e2 = f2.a();
        while (e2.f()) {
            d d2 = e2.a();
            d d3 = this.a.i(d2);
            if (bl2) return;
            if (q2 == d3.d()) {
                d3 = this.a.c(d3);
            }
            f4.a(d3);
            f3.remove(d3);
            e2.g();
            if (!bl2) continue;
        }
        f4.addAll(f3);
        this.a.a(q2, f4);
    }

    static a a(r r2) {
        return r2.a;
    }
}

