package y.g.a;

import y.c.*;

public class a implements g
{
    private A a;
    private boolean b;
    private D[] c;
    private D d;
    private b[] e;
    private q f;
    private int g;
    private i h;
    
    public a(final i i, final int n) {
        this.a = null;
        this.b = false;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.a(i, i.t(), n);
        this.b = true;
    }
    
    private void a(final i h, final A a, final int n) {
        final boolean a2 = y.g.a.d.a;
        this.h = h;
        this.a = a;
        this.c = new D[n + 1];
        this.f = null;
        this.d = new D();
        this.e = new b[this.h.f()];
        int n2 = 0;
        final D d = new D();
        final x o = this.h.o();
        while (o.f()) {
            this.e[n2] = new b(o.e(), d);
            ++n2;
            o.g();
            if (a2) {
                break;
            }
        }
    }
    
    public void d() {
        final boolean a = y.g.a.d.a;
        final C m = this.d.m();
        while (m.f()) {
            final q q = (q)m.d();
            this.c[this.a.a(q)].clear();
            this.e[q.d()].c = false;
            m.g();
            if (a) {
                return;
            }
            if (a) {
                break;
            }
        }
        this.d.clear();
        this.f = null;
    }
    
    public boolean a() {
        return this.d.size() == 0;
    }
    
    public boolean a(final q q) {
        return this.e[q.d()].c;
    }
    
    public void a(final q f, final int g) {
        final int d = f.d();
        this.a.a(f, g);
        this.e[d].c = true;
        this.a(g).a(this.e[d].a);
        this.d.a(this.e[d].b);
        if (this.f == null || g < this.g) {
            this.f = f;
            this.g = g;
        }
    }
    
    public void c(final q q) {
        final boolean a = y.g.a.d.a;
        final int d = q.d();
        this.e[d].c = false;
        this.c[this.a.a(q)].h(this.e[d].a);
        this.d.h(this.e[d].b);
        if (this.d.size() > 0) {
            while (true) {
                while (this.g < this.c.length) {
                    final a a2 = this;
                    if (!a) {
                        if (this.c[this.g] != null && this.c[this.g].size() > 0) {
                            break;
                        }
                        ++this.g;
                        if (a) {
                            break;
                        }
                        continue;
                    }
                    else {
                        if (!a2.e[this.f.d()].c) {
                            throw new RuntimeException("Consistency check failed: Tried to make " + this.f + " with " + this.g + " to new minimal node which is not part of the actual list !");
                        }
                        return;
                    }
                }
                this.f = (q)this.c[this.g].f();
                final a a2 = this;
                continue;
            }
        }
        this.f = null;
    }
    
    public void b(final q f, final int g) {
        final D d = this.c[this.a.a(f)];
        final p a = this.e[f.d()].a;
        d.h(a);
        this.a(g).a(a);
        this.a.a(f, g);
        if (g < this.g) {
            this.f = f;
            this.g = g;
        }
    }
    
    public q c() {
        final q f = this.f;
        this.c(f);
        return f;
    }
    
    public int b(final q q) {
        return this.a.a(q);
    }
    
    public void b() {
        if (this.b) {
            this.h.a(this.a);
        }
    }
    
    protected D a(final int n) {
        if (this.c[n] == null) {
            this.c[n] = new D();
        }
        return this.c[n];
    }
}
