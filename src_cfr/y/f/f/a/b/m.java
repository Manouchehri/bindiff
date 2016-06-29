/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import y.c.D;
import y.c.d;
import y.c.f;
import y.c.i;
import y.c.p;
import y.c.q;
import y.f.f.a.a.b;
import y.f.f.a.a.e;
import y.f.f.a.a.n;
import y.f.f.a.b.a;

public class m {
    private a a;
    private i b;
    private y.f.f.a.a.p c;

    public m(a a2) {
        this.a = a2;
        this.b = this.a.d();
        this.c = this.a.b();
    }

    public static f a(a a2) {
        m m2 = new m(a2);
        return m2.a();
    }

    public f a() {
        f f2;
        boolean bl2 = a.c;
        f f3 = new f();
        this.a.g();
        d[] arrd = this.b.n();
        for (int i2 = 0; i2 < arrd.length; ++i2) {
            f2 = this.a(arrd[i2]);
            if (bl2) return f2;
            if (f2 == null) continue;
            f3.add(arrd[i2]);
            if (!bl2) continue;
        }
        this.a.h();
        f2 = f3;
        return f2;
    }

    public f a(d d2) {
        boolean bl2;
        D d3;
        b b2;
        d d4;
        f f2;
        b b3;
        d d5;
        p p2;
        d d6;
        d d7;
        block10 : {
            p p3;
            bl2 = a.c;
            if (!this.b.f(d2)) {
                return null;
            }
            if (this.a.a(d2)) {
                d2 = this.a.c(d2);
            }
            d7 = this.a.c(d2);
            f2 = null;
            b2 = this.c.a(d2.c());
            if (n.a(b2, b3 = this.c.a(d2.d()))) {
                return null;
            }
            d3 = new D();
            f2 = new f();
            this.a.a(d2, f2);
            while (b3.b() > b2.b()) {
                d3.c(b3);
                b3 = (b)b3.c();
                if (!bl2) continue;
            }
            d5 = null;
            Object var8_9 = null;
            d6 = null;
            while (!n.a(b2, b3)) {
                b b4 = (b)b2.c();
                d4 = this.b.a(b2.b_(), b4.b_());
                this.a.k(d4);
                p3 = f2.b(d4);
                if (!bl2) {
                    p2 = p3;
                    this.a.a(d4, p2);
                    this.a.b(d4, d2);
                    if (d5 != null) {
                        this.a.c(d5, d4);
                    }
                    if (b2.b() == b3.b()) {
                        d3.c(b3);
                        b3 = (b)b3.c();
                    }
                    d5 = d4;
                    b2 = b4;
                    if (!bl2) continue;
                }
                break block10;
            }
            p3 = d3.c(b3);
        }
        while (!d3.isEmpty()) {
            b3 = (b)d3.g();
            d4 = this.b.a(b2.b_(), b3.b_());
            this.a.k(d4);
            p2 = f2.b(d4);
            this.a.a(d4, p2);
            this.a.b(d4, d2);
            this.a.c(d4, d6);
            if (bl2) return f2;
            if (d5 != null && d6 == null) {
                this.a.c(d5, d4);
            }
            d6 = d4;
            d5 = d4;
            b2 = b3;
            if (!bl2) continue;
        }
        this.a.c(d2.c(), d2, f2.b());
        this.a.c(d2.d(), d7, this.a.c(f2.c()));
        this.b.d(d2);
        this.b.d(d7);
        return f2;
    }
}

