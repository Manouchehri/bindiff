package y.g.a;

import y.c.*;

public class d implements g
{
    private p b;
    private q[] c;
    private i d;
    public static boolean a;
    
    public d(final i d) {
        this.d = d;
        this.b = new p(d.f());
        this.c = new q[d.f()];
    }
    
    public void a(final y.c.q q, final int n) {
        final q a = this.b.a(n, q);
        if (q.d() < this.c.length) {
            this.c[q.d()] = a;
            if (!y.g.a.d.a) {
                return;
            }
        }
        final q[] c = new q[Math.max(2 * this.c.length, q.d() + 1)];
        System.arraycopy(this.c, 0, c, 0, this.c.length);
        (this.c = c)[q.d()] = a;
    }
    
    public void b(final y.c.q q, final int n) {
        this.b.a(this.c[q.d()], n);
    }
    
    public void c(final y.c.q q, final int n) {
        this.b.c(this.c[q.d()], n);
    }
    
    public y.c.q c() {
        final q b = this.b.b();
        this.b.a(b);
        final y.c.q q = (y.c.q)b.b;
        this.c[q.d()] = null;
        return q;
    }
    
    public y.c.q b() {
        return (y.c.q)this.b.b().b;
    }
    
    public int e() {
        return this.b.b().a;
    }
    
    public boolean a(final y.c.q q) {
        return this.c[q.d()] != null;
    }
    
    public boolean a() {
        return this.b.c();
    }
    
    public int b(final y.c.q q) {
        return this.c[q.d()].a;
    }
    
    public void c(final y.c.q q) {
        this.b.a(this.c[q.d()]);
        this.c[q.d()] = null;
    }
    
    public void d() {
        final boolean a = y.g.a.d.a;
        final x o = this.d.o();
        while (true) {
            while (o.f()) {
                final d d = this;
                if (a) {
                    d.b.a();
                    return;
                }
                if (this.a(o.e())) {
                    this.c[o.e().d()] = null;
                }
                o.g();
                if (a) {
                    break;
                }
            }
            final d d = this;
            continue;
        }
    }
    
    public void f() {
    }
}
