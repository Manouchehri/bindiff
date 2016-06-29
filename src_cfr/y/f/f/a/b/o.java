/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import java.util.Collection;
import y.c.C;
import y.c.d;
import y.c.e;
import y.c.f;
import y.f.f.a.a.h;
import y.f.f.a.a.m;
import y.f.f.a.b.a;
import y.f.f.a.b.i;
import y.f.f.a.b.p;
import y.f.f.a.b.q;

public class o {
    private y.c.i a;
    private y.f.f.a.a.p b;
    private i c;
    private f d;
    private f e;

    public o(y.c.i i2, y.f.f.a.a.p p2) {
        this.a = i2;
        this.b = p2;
        this.c = new i(this.a, this.b);
        this.d = new f();
        this.e = new f();
    }

    public void a() {
        this.c.d();
    }

    public f b() {
        return this.e;
    }

    public f c() {
        return this.d;
    }

    public void d() {
        boolean bl2 = a.c;
        this.d.clear();
        this.e.clear();
        this.e.a(this.a.p());
        this.c.h();
        this.c.e();
        this.e();
        e e2 = this.d.a();
        e2.j();
        while (e2.f()) {
            d d2 = e2.a();
            d d3 = this.c.a(d2);
            if (bl2) return;
            if (d3 != null) {
                this.d.b(d3);
                this.d.remove(d2);
            }
            e2.h();
            if (!bl2) continue;
        }
        this.e.removeAll(this.d);
        this.c.i();
    }

    private void e() {
        this.c.f();
        m.a((h)new q(this, null), this.c);
        this.c.g();
    }

    static y.c.i a(o o2) {
        return o2.a;
    }

    static f b(o o2) {
        return o2.d;
    }
}

