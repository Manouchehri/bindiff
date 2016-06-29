package y.g.a;

import y.c.*;

public class c implements e
{
    private n a;
    private o[] b;
    private i c;
    
    public c(final i c) {
        this.c = c;
        this.a = new n(c.f());
        this.b = new o[c.f()];
    }
    
    public void a(final q q, final double n) {
        final o a = this.a.a(n, q);
        if (q.d() < this.b.length) {
            this.b[q.d()] = a;
            if (!d.a) {
                return;
            }
        }
        final o[] b = new o[Math.max(2 * this.b.length, q.d() + 1)];
        System.arraycopy(this.b, 0, b, 0, this.b.length);
        (this.b = b)[q.d()] = a;
    }
    
    public void b(final q q, final double n) {
        this.a.a(this.b[q.d()], n);
    }
    
    public void c(final q q, final double n) {
        this.a.b(this.b[q.d()], n);
    }
    
    public void d(final q q, final double n) {
        this.a.c(this.b[q.d()], n);
    }
    
    public q a() {
        final o b = this.a.b();
        this.a.a(b);
        final q q = (q)b.b;
        this.b[q.d()] = null;
        return q;
    }
    
    public boolean a(final q q) {
        return this.b[q.d()] != null;
    }
    
    public boolean b() {
        return this.a.c();
    }
    
    public void b(final q q) {
        this.a.a(this.b[q.d()]);
        this.b[q.d()] = null;
    }
    
    public void c() {
        final boolean a = d.a;
        final x o = this.c.o();
        while (true) {
            while (o.f()) {
                final c c = this;
                if (a) {
                    c.a.a();
                    return;
                }
                if (this.a(o.e())) {
                    this.b[o.e().d()] = null;
                }
                o.g();
                if (a) {
                    break;
                }
            }
            final c c = this;
            continue;
        }
    }
}
