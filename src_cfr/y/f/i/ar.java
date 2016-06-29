/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.c.c;
import y.c.d;
import y.c.e;
import y.c.h;
import y.f.X;
import y.f.i.as;
import y.f.i.at;
import y.f.i.v;
import y.g.M;
import y.g.p;

class ar {
    private X a;
    private v b;
    private byte c;
    private c d;
    private h e;

    public ar(X x2, v v2) {
        this.a = x2;
        this.b = v2;
    }

    h a() {
        return this.e;
    }

    public void b() {
        if (this.b.p() == 2) {
            Object object = this.b.c();
            c c2 = this.a.c(object);
            if (c2 != null) return;
            throw new IllegalStateException(new StringBuffer().append("No DataProvider ").append(object).append(" registered with graph!").toString());
        }
        if (this.b.p() != 4) return;
        Object object = this.b.b();
        c c3 = this.a.c(object);
        if (c3 != null) return;
        throw new IllegalStateException(new StringBuffer().append("No DataProvider ").append(object).append(" registered with graph!").toString());
    }

    public void c() {
        int n2 = v.f;
        this.d();
        Object object = this.b.c();
        c c2 = this.a.c(object);
        if (c2 == null) return;
        this.e = M.b();
        e e2 = this.a.p();
        while (e2.f()) {
            this.e.a((Object)e2.a(), c2.d(e2.a()));
            e2.g();
            if (n2 != 0) return;
            if (n2 == 0) continue;
        }
        this.a.a(object, this.e);
    }

    public void d() {
        this.c = this.b.p();
        this.b.b(2);
        Object object = this.b.c();
        this.d = this.a.c(object);
        c c2 = this.a.c(this.b.b());
        p p2 = null;
        if (this.c == 0) {
            p2 = new as(this);
        } else if (this.c == 4) {
            p2 = new at(this, c2);
        }
        if (p2 == null) return;
        this.b.b(2);
        this.a.a(object, p2);
    }

    public void e() {
        if (this.c != 2) {
            block3 : {
                Object object = this.b.c();
                if (this.d != null) {
                    this.a.a(object, this.d);
                    if (v.f == 0) break block3;
                }
                this.a.d_(object);
            }
            this.b.b(this.c);
        }
        if (this.e == null) return;
        this.e = null;
    }
}

