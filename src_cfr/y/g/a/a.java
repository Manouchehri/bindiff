/*
 * Decompiled with CFR 0_115.
 */
package y.g.a;

import y.c.A;
import y.c.C;
import y.c.D;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.g.a.b;
import y.g.a.d;
import y.g.a.g;

public class a
implements g {
    private A a = null;
    private boolean b = false;
    private D[] c = null;
    private D d = null;
    private b[] e = null;
    private q f = null;
    private int g = 0;
    private i h;

    public a(i i2, int n2) {
        A a2 = i2.t();
        this.a(i2, a2, n2);
        this.b = true;
    }

    private void a(i i2, A a2, int n2) {
        boolean bl2 = d.a;
        this.h = i2;
        this.a = a2;
        this.c = new D[n2 + 1];
        this.f = null;
        this.d = new D();
        this.e = new b[this.h.f()];
        int n3 = 0;
        D d2 = new D();
        x x2 = this.h.o();
        do {
            if (!x2.f()) return;
            this.e[n3] = new b(x2.e(), d2);
            ++n3;
            x2.g();
        } while (!bl2);
    }

    @Override
    public void d() {
        boolean bl2 = d.a;
        C c2 = this.d.m();
        while (c2.f()) {
            q q2 = (q)c2.d();
            this.c[this.a.a(q2)].clear();
            this.e[q2.d()].c = false;
            c2.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        this.d.clear();
        this.f = null;
    }

    @Override
    public boolean a() {
        if (this.d.size() != 0) return false;
        return true;
    }

    @Override
    public boolean a(q q2) {
        return this.e[q2.d()].c;
    }

    @Override
    public void a(q q2, int n2) {
        int n3 = q2.d();
        this.a.a((Object)q2, n2);
        this.e[n3].c = true;
        D d2 = this.a(n2);
        d2.a(this.e[n3].a);
        this.d.a(this.e[n3].b);
        if (this.f != null) {
            if (n2 >= this.g) return;
        }
        this.f = q2;
        this.g = n2;
    }

    public void c(q q2) {
        block3 : {
            a a2;
            boolean bl2 = d.a;
            int n2 = q2.d();
            this.e[n2].c = false;
            D d2 = this.c[this.a.a(q2)];
            d2.h(this.e[n2].a);
            this.d.h(this.e[n2].b);
            if (this.d.size() <= 0) {
                this.f = null;
                return;
            }
            while (this.g < this.c.length) {
                a2 = this;
                if (!bl2) {
                    if (a2.c[this.g] != null && this.c[this.g].size() > 0) break;
                    ++this.g;
                    if (!bl2) continue;
                }
                break block3;
            }
            this.f = (q)this.c[this.g].f();
            a2 = this;
        }
        if (a2.e[this.f.d()].c) return;
        throw new RuntimeException(new StringBuffer().append("Consistency check failed: Tried to make ").append(this.f).append(" with ").append(this.g).append(" to new minimal node which is not part of the actual list !").toString());
    }

    @Override
    public void b(q q2, int n2) {
        D d2 = this.c[this.a.a(q2)];
        p p2 = this.e[q2.d()].a;
        d2.h(p2);
        this.a(n2).a(p2);
        this.a.a((Object)q2, n2);
        if (n2 >= this.g) return;
        this.f = q2;
        this.g = n2;
    }

    @Override
    public q c() {
        q q2 = this.f;
        this.c(q2);
        return q2;
    }

    @Override
    public int b(q q2) {
        return this.a.a(q2);
    }

    public void b() {
        if (!this.b) return;
        this.h.a(this.a);
    }

    protected D a(int n2) {
        if (this.c[n2] != null) return this.c[n2];
        this.c[n2] = new D();
        return this.c[n2];
    }
}

