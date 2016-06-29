package y.f.c.a;

import y.f.*;
import y.c.*;
import y.d.*;

class bF
{
    private d a;
    private aE b;
    private aE c;
    private X d;
    private boolean e;
    
    private bF(final d a, final X d, final aV av, final boolean e) {
        this.a = a;
        this.d = d;
        final A a2 = av.a(a);
        this.b = (e ? a2.e() : a2.c());
        this.c = (e ? a2.c() : a2.e());
        this.e = e;
    }
    
    public q a() {
        if (this.e) {
            return this.a.d();
        }
        return this.a.c();
    }
    
    public q b() {
        if (!this.e) {
            return this.a.d();
        }
        return this.a.c();
    }
    
    public aE c() {
        return this.b;
    }
    
    public aE d() {
        return this.c;
    }
    
    public boolean a(final d d) {
        return this.a.equals(d);
    }
    
    public t e() {
        if (this.e) {
            return this.d.q(this.a);
        }
        return this.d.p(this.a);
    }
    
    public void a(final t t) {
        if (this.e) {
            this.d.d(this.a, t);
            if (!N.x) {
                return;
            }
        }
        this.d.c(this.a, t);
    }
    
    public t f() {
        if (!this.e) {
            return this.d.q(this.a);
        }
        return this.d.p(this.a);
    }
    
    public void b(final t t) {
        if (!this.e) {
            this.d.d(this.a, t);
            if (!N.x) {
                return;
            }
        }
        this.d.c(this.a, t);
    }
    
    public t g() {
        if (this.e) {
            return this.d.o(this.a);
        }
        return this.d.n(this.a);
    }
    
    public void c(final t t) {
        if (this.e) {
            this.d.b(this.a, t);
            if (!N.x) {
                return;
            }
        }
        this.d.a(this.a, t);
    }
    
    public t h() {
        if (!this.e) {
            return this.d.o(this.a);
        }
        return this.d.n(this.a);
    }
    
    public void d(final t t) {
        if (!this.e) {
            this.d.b(this.a, t);
            if (!N.x) {
                return;
            }
        }
        this.d.a(this.a, t);
    }
    
    bF(final d d, final X x, final aV av, final boolean b, final bz bz) {
        this(d, x, av, b);
    }
}
