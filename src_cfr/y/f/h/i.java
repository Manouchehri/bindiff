/*
 * Decompiled with CFR 0_115.
 */
package y.f.h;

import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.f.h.D;
import y.f.h.N;
import y.f.h.p;
import y.f.h.q;

public class I {
    private f a = new f();
    private D b;

    public I(D d2) {
        this.b = d2;
    }

    public void a() {
        boolean bl2 = N.d;
        i i2 = this.b.g();
        e e2 = i2.p();
        do {
            if (!e2.f()) return;
            if (e2.a().e()) {
                this.a.c(e2.a());
                i2.d(e2.a());
            }
            e2.g();
        } while (!bl2);
    }

    public void b() {
        boolean bl2 = N.d;
        i i2 = this.b.g();
        e e2 = this.a.a();
        do {
            block6 : {
                d d2;
                d d3;
                if (!e2.f()) return;
                d d4 = d2 = e2.a();
                block1 : do {
                    if (d4.c().a() == 0) {
                        i2.e(d2);
                        this.b.g(d2);
                        this.b.l();
                        this.b.b(this.b.h().a());
                        if (!bl2) break block6;
                    }
                    d3 = null;
                    e e3 = d2.c().l();
                    while (e3.f()) {
                        d4 = d3;
                        if (bl2) continue block1;
                        if (d4 == null) {
                            d3 = e3.a();
                        }
                        if (this.b.i(e3.a()).a().k() == 1) {
                            d3 = e3.a();
                        }
                        e3.g();
                        if (!bl2) continue;
                    }
                    break block1;
                    break;
                } while (true);
                i2.e(d2);
                this.b.a(d3, d2);
                this.b.k();
            }
            e2.g();
        } while (!bl2);
    }
}

