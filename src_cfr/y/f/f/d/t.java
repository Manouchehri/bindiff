/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.d;

import y.c.A;
import y.c.D;
import y.c.i;
import y.f.X;
import y.f.f.b.h;
import y.f.f.b.m;
import y.f.f.b.p;
import y.f.f.c.f;
import y.f.f.c.k;
import y.f.f.c.l;
import y.f.f.c.n;
import y.f.f.c.r;
import y.f.f.d.K;
import y.f.f.d.g;
import y.f.f.d.y;
import y.g.al;
import y.g.o;

public class t
implements p {
    public static final Object a = "y.layout.orthogonal.kandinsky.KanCompactor.BORDER_DPKEY";
    protected h b;
    protected X c;
    private f g = new g();
    private short h = 0;
    protected short d = 0;
    protected int e = 3;
    protected int f = 50;
    private boolean i = false;
    private m j;
    private boolean k = false;

    @Override
    public void a(h h2) {
        this.c = (X)h2.a();
        this.b = h2;
    }

    public boolean b() {
        return this.k;
    }

    @Override
    public void a(int n2) {
        this.f = n2;
    }

    @Override
    public void a(m m2) {
        this.j = m2;
    }

    public short c() {
        return this.h;
    }

    public void a(short s2) {
        this.h = s2;
    }

    public void b(short s2) {
        this.d = s2;
    }

    public void b(int n2) {
        this.e = n2;
    }

    public void a(boolean bl2) {
        this.i = bl2;
    }

    public void a(f f2) {
        this.g = f2;
    }

    @Override
    public void a() {
        o.a(this, 1, "------->>> Entering Compaction Phase");
        al al2 = new al();
        o.a(this, 2, "-----> Introduce dummy nodes for labels");
        o.a(this, 2, "-----> Split nodes");
        y y2 = new y(this.b, this.h, this.f);
        y.a(this.i);
        y2.b(this.b());
        y2.c();
        this.j.h = (int)al2.d();
        al2.e();
        o.a(this, 2, "-----> Do compaction");
        r r2 = new r();
        r2.a(this.d());
        r2.a(y2.a());
        A a2 = y2.a().a().t();
        D d2 = y2.b();
        if (this.g instanceof g) {
            ((g)this.g).a(d2);
        }
        r2.a(this.g);
        r2.a(this.e);
        r2.a(a2);
        this.j.i = (int)al2.d();
        al2.e();
        y2.a(a2, this.c);
        y2.a().a().a(a2);
        this.j.n = (int)al2.d();
        this.j.q = y2.g();
        this.j.s = y2.f();
        this.j.r = y2.e();
        this.j.j = r2.a();
        this.j.k = r2.b();
        this.j.l = r2.c();
        this.j.m = r2.d();
        o.a(this, 3, new StringBuffer().append("-> Total running time of compaction Phase: ").append(al2).toString());
        o.a(this, 1, "<<<------- Leaving Compaction Phase");
    }

    protected l d() {
        switch (this.d) {
            case 0: {
                return new k();
            }
            case 1: {
                return new y.f.f.c.h();
            }
            case 2: {
                return new n();
            }
        }
        o.a((Object)"Unknown Compactor !");
        return null;
    }
}

