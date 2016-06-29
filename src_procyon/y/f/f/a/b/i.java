package y.f.f.a.b;

import y.c.*;
import y.f.f.a.a.*;

public class i implements g, l
{
    protected y.c.i a;
    protected p b;
    protected j c;
    private f d;
    private h e;
    
    public i(final y.c.i a, final p b) {
        this.a = a;
        this.b = b;
        this.c = this.b.b();
        this.d = new f();
        this.e = this.a.u();
        this.c();
    }
    
    public void c() {
        this.c.a(this);
    }
    
    public void d() {
        this.b.a(this.c);
        this.a.a(this.e);
    }
    
    public Object b() {
        return new n();
    }
    
    public e a() {
        return this.c.a();
    }
    
    public void e() {
        final boolean c = y.f.f.a.b.a.c;
        this.c();
        final y.c.e p = this.a.p();
        while (p.f()) {
            final d a = p.a();
            final b a2 = this.b.a(p.a().c());
            if (a2.c() != this.b.a(p.a().d()).c()) {
                throw new RuntimeException("Replace edges by their representatives!");
            }
            ((n)this.c.a((y.f.f.a.a.f)a2.c())).a(a);
            p.g();
            if (c) {
                break;
            }
        }
    }
    
    public void a(final b b) {
        ((n)this.c.a(b)).a(this.a);
    }
    
    public void b(final b b) {
        ((n)this.c.a(b)).b(this.a);
    }
    
    public void f() {
        m.a(new y.f.f.a.b.j(this), this.c);
    }
    
    public void g() {
        m.a(new k(this), this.c);
    }
    
    public void h() {
        final boolean c = y.f.f.a.b.a.c;
        final y.c.e p = this.a.p();
        while (p.f()) {
            final d a = p.a();
            final b a2 = this.b.a(a.c());
            final b a3 = this.b.a(a.d());
            if (!y.f.f.a.a.n.a(a2, a3)) {
                final e[] b = y.f.f.a.a.n.b(a2, a3);
                final d a4 = this.a.a(((b)b[0]).b_(), ((b)b[1]).b_());
                this.d.add(a4);
                this.e.a(a4, a);
                this.a.d(a);
            }
            p.g();
            if (c) {
                break;
            }
        }
    }
    
    public void i() {
        final boolean c = y.f.f.a.b.a.c;
        final y.c.e a = this.d.a();
        while (a.f()) {
            final d a2 = a.a();
            this.a.e((d)this.e.b(a2));
            this.a.a(a2);
            a.g();
            if (c) {
                break;
            }
        }
    }
    
    public d a(final d d) {
        return (d)this.e.b(d);
    }
}
