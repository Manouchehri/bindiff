/*
 * Decompiled with CFR 0_115.
 */
package y.g.a;

import y.c.A;
import y.c.D;
import y.c.c;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.g.a.d;
import y.g.a.g;
import y.g.a.i;

public class h
implements g {
    A a;
    A b;
    y.c.i c;
    D d;
    int e;

    public h(y.c.i i2) {
        this.c = i2;
        this.a = i2.t();
        this.b = i2.t();
        this.d = new D();
        this.e = 0;
    }

    public h(y.c.i i2, c c2, int n2, int n3) {
        this(i2, c2, n2, n3, null);
    }

    public h(y.c.i i2, c c2, int n2, int n3, c c3) {
        this(i2);
        this.a(c2, n2, n3, c3);
    }

    void a(c c2, int n2, int n3, c c3) {
        int n4;
        boolean bl2;
        Object object;
        y[] arry;
        block6 : {
            bl2 = d.a;
            arry = new y[n3 - n2 + 1];
            for (n4 = n2; n4 <= n3; ++n4) {
                arry[n4] = new i(n4);
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block6;
            }
            x x2 = this.c.o();
            while (x2.f()) {
                object = x2.e();
                if (c3 == null || c3.d(object)) {
                    this.a.a(object, arry[c2.a(object) - n2].a(object));
                    ++this.e;
                }
                x2.g();
                if (!bl2) continue;
            }
            n4 = 0;
        }
        block2 : do {
            if (n4 >= arry.length) return;
            object = arry[n4];
            p p2 = this.d.b(object);
            x x3 = object.a();
            while (x3.f()) {
                this.b.a((Object)x3.e(), p2);
                x3.g();
                if (bl2) continue block2;
                if (!bl2) continue;
            }
            ++n4;
        } while (!bl2);
    }

    public void b() {
        this.c.a(this.b);
        this.c.a(this.a);
    }

    @Override
    public boolean a() {
        if (this.e != 0) return false;
        return true;
    }

    @Override
    public boolean a(q q2) {
        if (this.b.b(q2) == null) return false;
        return true;
    }

    @Override
    public void a(q q2, int n2) {
        p p2;
        boolean bl2 = d.a;
        ++this.e;
        if (this.d.isEmpty()) {
            i i2 = new i(n2);
            this.a(this.d.a((Object)i2), i2.b(q2), q2);
            return;
        }
        i i3 = (i)this.d.f();
        if (i3.p() > n2) {
            while (i3.p() > n2) {
                i3 = new i(i3.p() - 1);
                this.d.a((Object)i3);
                if (bl2) return;
                if (!bl2) continue;
            }
            this.a(this.d.k(), i3.b(q2), q2);
            return;
        }
        i3 = (i)this.d.i();
        if (i3.p() < n2) {
            while (i3.p() < n2) {
                i3 = new i(i3.p() + 1);
                this.d.b(i3);
                if (bl2) return;
                if (!bl2) continue;
            }
            this.a(this.d.l(), i3.b(q2), q2);
            return;
        }
        for (p2 = this.d.k(); p2 != null; p2 = p2.a()) {
            i3 = (i)p2.c();
            if (bl2) return;
            if (i3.p() == n2) break;
            if (!bl2) continue;
        }
        this.a(p2, i3.b(q2), q2);
    }

    private void a(p p2, p p3, q q2) {
        this.b.a((Object)q2, p2);
        this.a.a((Object)q2, p3);
    }

    @Override
    public void b(q q2, int n2) {
        boolean bl2 = d.a;
        p p2 = (p)this.a.b(q2);
        p p3 = (p)this.b.b(q2);
        i i2 = (i)p3.c();
        int n3 = i2.p();
        do {
            if (n2 >= n3) return;
            this.d(q2);
            --n3;
        } while (!bl2);
    }

    @Override
    public int b(q q2) {
        p p2 = (p)this.b.b(q2);
        i i2 = (i)p2.c();
        return i2.p();
    }

    @Override
    public void d() {
        this.d.clear();
        this.e = 0;
    }

    @Override
    public q c() {
        return this.e();
    }

    public q e() {
        block2 : {
            boolean bl2 = d.a;
            while (((y)this.d.f()).isEmpty()) {
                this.d.g();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block2;
            }
            --this.e;
        }
        q q2 = ((y)this.d.f()).d();
        this.b.a((Object)q2, null);
        this.a.a((Object)q2, null);
        return q2;
    }

    public q f() {
        block2 : {
            boolean bl2 = d.a;
            while (((y)this.d.i()).isEmpty()) {
                this.d.j();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block2;
            }
            --this.e;
        }
        q q2 = ((y)this.d.i()).d();
        this.b.a((Object)q2, null);
        this.a.a((Object)q2, null);
        return q2;
    }

    public void c(q q2) {
        p p2 = (p)this.a.b(q2);
        p p3 = (p)this.b.b(q2);
        i i2 = (i)p3.c();
        y y2 = null;
        p p4 = p3.a();
        if (p4 != null) {
            y2 = (y)p4.c();
            this.b.a((Object)q2, p4);
        } else {
            y2 = new i(i2.p() + 1);
            this.b.a((Object)q2, this.d.b(y2));
        }
        i2.h(p2);
        this.a.a((Object)q2, y2.a(q2));
    }

    public void d(q q2) {
        boolean bl2 = d.a;
        p p2 = (p)this.a.b(q2);
        p p3 = (p)this.b.b(q2);
        i i2 = (i)p3.c();
        y y2 = null;
        p p4 = p3.b();
        if (p4 != null) {
            y2 = (y)p4.c();
            this.b.a((Object)q2, p4);
        } else {
            y2 = new i(i2.p() - 1);
            this.b.a((Object)q2, this.d.a((Object)y2));
        }
        i2.h(p2);
        this.a.a((Object)q2, y2.a(q2));
        if (!y.c.i.g) return;
        d.a = !bl2;
    }
}

