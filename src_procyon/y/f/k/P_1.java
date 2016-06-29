package y.f.k;

import y.d.*;
import java.awt.geom.*;
import java.util.*;

class P
{
    private A a;
    private l b;
    private A c;
    
    protected P() {
    }
    
    P(final l b, final A a) {
        if (a == null) {
            throw new NullPointerException("originalShape was null");
        }
        if (b == null) {
            throw new NullPointerException("modificationMatrix was null");
        }
        this.a = a;
        this.b = b;
        this.c = a.a(b.a());
    }
    
    void a(final double n, final double n2) {
        this.c.a(n, n2);
    }
    
    c a(final int n) {
        return this.c.a(n);
    }
    
    Rectangle2D a() {
        return this.c.a();
    }
    
    double b() {
        return this.c.b();
    }
    
    double c() {
        return this.c.c();
    }
    
    double d() {
        return this.c.h();
    }
    
    double e() {
        return this.c.g();
    }
    
    double f() {
        return this.c.e();
    }
    
    double g() {
        return this.c.f();
    }
    
    void h() {
        this.c.d();
    }
    
    void a(final P p) {
        this.c.a(p.c);
        this.j();
        p.j();
    }
    
    void a(final double n) {
        this.b(0.0, n);
    }
    
    void b(final double n) {
        this.b(n, 0.0);
    }
    
    void b(final double n, final double n2) {
        this.c.b(n, n2);
    }
    
    A i() {
        return this.a;
    }
    
    void j() {
        this.c.a(this.a, this.b);
    }
    
    n a(final c c, final double n) {
        return this.a(n.d, c, n, false);
    }
    
    private n a(final n n, final c c, final double n2, final boolean b) {
        final n b2 = this.b(n, c, n2, b);
        this.b(b2.a(0), b2.a(1));
        return b2;
    }
    
    private n b(final n n, final c c, final double n2, final boolean b) {
        final double n3 = this.a(n, c) - n2;
        if (b && n3 < 0.0) {
            return n.e;
        }
        return n.a(n3);
    }
    
    double a(final n n, final c c) {
        if (n.a() < 0.0) {
            final double n2 = c.c(this.a(n));
            if (d.g == 0) {
                return n2;
            }
        }
        return this.a(n).c(c);
    }
    
    c a(final n n) {
        if (n.equals(n.a)) {
            return this.a(0);
        }
        if (n.equals(n.b)) {
            return this.a(1);
        }
        if (n.equals(n.c)) {
            return this.a(2);
        }
        return this.a(3);
    }
    
    void a(final List list) {
        final int g = d.g;
        final Iterator<P> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.a(iterator.next());
            if (g != 0) {
                break;
            }
        }
    }
    
    l k() {
        return this.b;
    }
    
    double l() {
        return this.e() - this.f();
    }
}
