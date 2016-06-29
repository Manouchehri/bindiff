/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a;

import y.c.d;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.r;
import y.f.f.a.a.b;
import y.f.f.a.a.e;
import y.f.f.a.a.h;
import y.f.f.a.f;
import y.f.f.a.g;
import y.f.h.D;

class j
implements h {
    private final f a;

    private j(f f2) {
        this.a = f2;
    }

    @Override
    public void a(e e2) {
        f f2;
        q q2;
        block11 : {
            Object object;
            y.c.f f3;
            boolean bl2 = f.a;
            if (e2.e()) {
                return;
            }
            if (e2.d()) {
                return;
            }
            b b2 = (b)e2;
            q2 = b2.b_();
            y.c.f f4 = f.a(this.a).b(q2);
            if (f4.size() == 0) {
                return;
            }
            y.c.f f5 = new y.c.f();
            y y2 = new y();
            y.c.e e3 = f4.a();
            e3.j();
            while (e3.f()) {
                d d2;
                d d3;
                d d4;
                d d5;
                block10 : {
                    d3 = e3.a();
                    d4 = f.a(this.a).c(d3);
                    d2 = f.a(this.a).i(d3);
                    if (d2.d() == q2) {
                        d5 = d2;
                        d2 = f.a(this.a).c(d2);
                        if (!bl2) break block10;
                    }
                    d5 = f.a(this.a).c(d2);
                }
                object = f.b(this.a).d();
                f.a(this.a).e((q)object);
                f.b(this.a).a(d3, (q)object, d3.d());
                f.b(this.a).a(d2, (q)object, d2.d());
                f.b(this.a).a(d4, d4.c(), (q)object);
                f.b(this.a).a(d5, d5.c(), (q)object);
                f3 = f.a(this.a).a((q)object);
                f3.b(d3);
                f3.b(d2);
                y2.b(object);
                e3.h();
                if (!bl2) continue;
            }
            object = null;
            if (f.c(this.a) != null) {
                object = r.a(f.c(this.a).b(q2));
            }
            f3 = new y.c.f();
            q q3 = y2.c();
            x x2 = y2.a();
            while (x2.f()) {
                q q4 = x2.e();
                d d6 = f.b(this.a).a(q3, q4);
                f2 = this.a;
                if (!bl2) {
                    if (f.c(f2) != null) {
                        f.d(this.a).a((Object)d6, object);
                    }
                    f.a(this.a).u(d6);
                    f.e(this.a).a((Object)d6, q2);
                    d d7 = f.a(this.a).k(d6);
                    f.a(this.a).u(d7);
                    f.e(this.a).a((Object)d7, q2);
                    f.a(this.a).c().m(d7);
                    f3.b(d6);
                    y.c.f f6 = f.a(this.a).a(q3);
                    f.a(this.a).a(q3, f6.c(), d6);
                    f6 = f.a(this.a).a(q4);
                    f.a(this.a).a(q4, f6.b(), d7);
                    q3 = q4;
                    x2.g();
                    if (!bl2) continue;
                }
                break block11;
            }
            f.a(this.a).c(q2, f3);
            f2 = this.a;
        }
        f.b(f2).c(q2);
    }

    j(f f2, g g2) {
        this(f2);
    }
}

