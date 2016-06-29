/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a;

import y.c.C;
import y.c.c;
import y.c.q;
import y.c.x;
import y.f.f.a.a.b;
import y.f.f.a.a.e;
import y.f.f.a.a.h;
import y.f.f.a.a.m;
import y.f.f.a.a.p;
import y.f.f.a.b.a;
import y.f.f.a.b.z;
import y.f.f.a.g;
import y.f.f.a.i;
import y.f.f.a.j;
import y.f.f.a.k;
import y.f.f.b.d;
import y.f.h.D;
import y.f.h.Q;

public class f
implements d {
    private a b;
    private y.c.i c;
    private p d;
    private y.c.f e;
    private D f;
    private c g;
    private y.c.h h;
    private y.c.h i;
    private Q j;
    public static boolean a;

    public f(a a2, y.c.f f2) {
        this.b = a2;
        this.e = f2;
        this.c = a2.d();
        this.g = this.c.c(y.f.b.f.e);
        if (this.g != null) {
            this.h = this.c.u();
            this.c.a("y.layout.orthogonal.cluster.NodeSplitter.INSETS_KEY", this.h);
        }
        this.i = this.c.u();
        this.c.a("y.layout.orthogonal.cluster.NodeSplitter.BORDER_INFO_KEY", this.i);
        this.d = a2.b();
    }

    @Override
    public void a(D d2) {
    }

    @Override
    public void a(int n2) {
    }

    @Override
    public void a() {
        boolean bl2;
        Object object;
        Object object2;
        block8 : {
            block7 : {
                f f2;
                bl2 = a;
                z.a(this.b, this.e);
                this.b.g();
                m.a((h)new j(this, null), this.d);
                this.b.h();
                this.f = new D(this.b.d());
                object = this.b.d().p();
                while (object.f()) {
                    y.c.d d2 = object.a();
                    y.c.d d3 = this.b.c(d2);
                    this.f.b(d2, d3);
                    f2 = this;
                    if (!bl2) {
                        if (f2.b.a(d2)) {
                            this.f.m(d2);
                        }
                        object.g();
                        if (!bl2) continue;
                    }
                    break block7;
                }
                f2 = this;
            }
            object = f2.c.o();
            while (object.f()) {
                q q2 = object.e();
                object2 = this.b;
                if (!bl2) {
                    if (object2.f(q2) || this.b.d(q2)) {
                        this.f.c(q2);
                    }
                    object.g();
                    if (!bl2) continue;
                }
                break block8;
            }
            this.f.l();
            if (this.h != null) {
                this.j = new i(this.h);
                this.f.a(this.j);
            }
            this.f.a(new y.f.f.a.h(this.i));
            object2 = this.d.a().a().d();
        }
        object = (b)object2;
        y.c.d d4 = this.b.a(object.b_()).a().a();
        this.f.b(this.f.i(d4));
        if (!y.c.i.g) return;
        a = !bl2;
    }

    @Override
    public D b() {
        return this.f;
    }

    @Override
    public void c() {
        if (this.h != null) {
            this.c.a(this.h);
        }
        if (this.j != null) {
            this.f.b(this.j);
        }
        this.c.a(this.i);
        this.f.b();
        k.a(this.b, this.e);
    }

    static a a(f f2) {
        return f2.b;
    }

    static y.c.i b(f f2) {
        return f2.c;
    }

    static c c(f f2) {
        return f2.g;
    }

    static y.c.h d(f f2) {
        return f2.h;
    }

    static y.c.h e(f f2) {
        return f2.i;
    }
}

