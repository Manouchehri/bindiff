package y.f.e.a;

import y.c.*;

public class h extends d
{
    J a;
    J b;
    J c;
    J d;
    J e;
    
    public h() {
        final boolean b = af.b;
        (this.a = new J(this.b(), J.a, 0.0, 50.0)).a(J.c);
        this.a.c(1.0);
        (this.b = new J(this.c(), J.a, 0.0, 50.0)).a(J.c);
        this.b.c(1.0);
        (this.c = new J(this.a(), J.a, 0.0, 200.0)).a(J.f);
        this.c.c(0.3);
        (this.e = new J(this.d(), J.a, 0.0, 10000.0)).a(J.c);
        this.e.c(0.0);
        (this.d = new J(new ad(), J.a, 0.0, 1.0)).a(J.m);
        this.d.c(0.01);
        if (b) {
            i.g = !i.g;
        }
    }
    
    I a() {
        return new I();
    }
    
    ax b() {
        return new ae();
    }
    
    ax c() {
        return new ar();
    }
    
    ax d() {
        return new ac();
    }
    
    public void a(final ay ay) {
        super.a(ay);
        ay.a(this.a);
        ay.a(this.b);
        ay.a(this.d);
        ay.a(this.c);
        ay.a(this.e);
    }
    
    public double e() {
        return this.b.a();
    }
    
    public void a(final double n) {
        this.b.c(n);
    }
    
    public double f() {
        return this.c.a();
    }
    
    public void b(final double n) {
        this.e.c(n);
    }
    
    public void c(final double n) {
        this.c.c(n);
    }
    
    public void a(final int n) {
        ((ar)this.b.b()).a(n);
    }
    
    public void b(final int n) {
        ((ae)this.a.b()).a(n);
    }
    
    public void d(final double n) {
        final boolean b = af.b;
        if (n == 0.0) {
            this.b(0.0);
            this.b(1);
            this.a(1);
            if (!b) {
                return;
            }
        }
        if (n < 0.2) {
            this.b(0.0);
            this.b(2);
            this.a(1);
            if (!b) {
                return;
            }
        }
        if (n < 0.4) {
            this.b(0.0);
            this.b(2);
            this.a(2);
            if (!b) {
                return;
            }
        }
        if (n < 0.5) {
            this.b(0.0);
            this.b(2);
            this.a(2);
            if (!b) {
                return;
            }
        }
        if (n < 0.6) {
            this.b(0.0);
            this.b(3);
            this.a(2);
            if (!b) {
                return;
            }
        }
        if (n < 0.7) {
            this.b(0.0);
            this.b(3);
            this.a(3);
            if (!b) {
                return;
            }
        }
        if (n < 0.8) {
            this.b(0.1);
            this.b(3);
            this.a(3);
            if (!b) {
                return;
            }
        }
        if (n < 0.9) {
            this.b(0.3);
            this.b(3);
            this.a(3);
            if (!b) {
                return;
            }
        }
        if (n < 1.0) {
            this.b(0.6);
            this.b(3);
            this.a(3);
            if (!b) {
                return;
            }
        }
        this.b(2.0);
        this.b(3);
        this.a(3);
    }
}
