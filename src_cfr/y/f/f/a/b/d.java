/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import java.util.HashMap;
import java.util.Map;
import y.c.A;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.i;
import y.f.f.a.b.a;
import y.f.h.p;
import y.f.h.q;
import y.g.M;

public class D {
    protected a a;
    protected i b;
    protected i c;
    protected y.f.f.a.a.p d;
    private h e;
    private h f;
    private Map g;
    private A h;

    public D(a a2) {
        this.a = a2;
        this.b = this.a.d();
        this.d = this.a.b();
        this.c = new i();
        this.e = this.c.u();
        this.f = M.b();
        this.g = new HashMap();
        this.h = this.c.t();
    }

    public void a() {
        this.c.a(this.e);
        this.b.a(this.f);
        this.g.clear();
        this.c.a(this.h);
        this.c.j();
    }

    public d d(d d2) {
        return (d)this.e.b(d2);
    }

    public d e(d d2) {
        return (d)this.f.b(d2);
    }

    public y.c.q a(p p2) {
        return (y.c.q)this.g.get(p2);
    }

    public p a(y.c.q q2) {
        return (p)this.h.b(q2);
    }

    protected void a(d d2, d d3) {
        this.e.a((Object)d3, d2);
        this.f.a((Object)d2, d3);
    }

    protected void a(p p2, y.c.q q2) {
        this.g.put(p2, q2);
        this.h.a((Object)q2, p2);
    }

    public void b() {
        y.c.q q2;
        q q3;
        p p2;
        boolean bl2;
        block4 : {
            bl2 = a.c;
            this.c.j();
            this.g.clear();
            this.a.f();
            q3 = this.a.e();
            while (q3.f()) {
                p2 = q3.a();
                q2 = this.c.d();
                this.a(p2, q2);
                q3.g();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block4;
            }
            q3 = this.a.e();
        }
        block1 : do {
            if (!q3.f()) return;
            p2 = q3.a();
            q2 = this.a(p2);
            e e2 = p2.a();
            while (e2.f()) {
                d d2 = e2.a();
                d d3 = this.a.c(d2);
                y.c.q q4 = this.a(this.a.b(d3));
                d d4 = this.c.a(q2, q4);
                this.a(d2, d4);
                e2.g();
                if (bl2) continue block1;
                if (!bl2) continue;
            }
            q3.g();
        } while (!bl2);
    }
}

