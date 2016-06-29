/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a;

import y.c.i;
import y.f.f.a.a.h;
import y.f.f.a.a.m;
import y.f.f.a.a.p;
import y.f.f.a.b.a;
import y.f.f.a.d;
import y.f.f.a.e;
import y.f.f.a.f;
import y.f.f.d.G;

public class c
extends G {
    private a u;
    private p v;

    public void a(a a2) {
        this.u = a2;
    }

    public void a(p p2) {
        this.v = p2;
    }

    @Override
    public void a() {
        y.c.h h2;
        y.c.d d2;
        y.c.e e2;
        boolean bl2;
        block3 : {
            bl2 = f.a;
            h2 = this.b.a().u();
            e2 = this.b.a().p();
            while (e2.f()) {
                d2 = e2.a();
                h2.a((Object)d2, 1);
                e2.g();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block3;
            }
            e2 = this.c().a();
        }
        while (e2.f()) {
            d2 = e2.a();
            h2.a((Object)this.b.a(d2), 50000);
            e2.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        this.a(h2);
        super.a();
        this.b.a().a(h2);
    }

    private y.c.f c() {
        e e2 = new e(this, null);
        m.a((h)e2, this.v);
        return e2.a;
    }

    static a a(c c2) {
        return c2.u;
    }
}

