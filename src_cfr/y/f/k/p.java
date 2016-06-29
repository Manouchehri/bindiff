/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.List;
import y.d.c;
import y.f.k.A;
import y.f.k.d;
import y.f.k.l;
import y.f.k.n;

class P {
    private A a;
    private l b;
    private A c;

    protected P() {
    }

    P(l l2, A a2) {
        if (a2 == null) {
            throw new NullPointerException("originalShape was null");
        }
        if (l2 == null) {
            throw new NullPointerException("modificationMatrix was null");
        }
        this.a = a2;
        this.b = l2;
        this.c = a2.a(l2.a());
    }

    void a(double d2, double d3) {
        this.c.a(d2, d3);
    }

    c a(int n2) {
        return this.c.a(n2);
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

    void a(P p2) {
        this.c.a(p2.c);
        this.j();
        p2.j();
    }

    void a(double d2) {
        this.b(0.0, d2);
    }

    void b(double d2) {
        this.b(d2, 0.0);
    }

    void b(double d2, double d3) {
        this.c.b(d2, d3);
    }

    A i() {
        return this.a;
    }

    void j() {
        this.c.a(this.a, this.b);
    }

    n a(c c2, double d2) {
        return this.a(n.d, c2, d2, false);
    }

    private n a(n n2, c c2, double d2, boolean bl2) {
        n n3 = this.b(n2, c2, d2, bl2);
        this.b(n3.a(0), n3.a(1));
        return n3;
    }

    private n b(n n2, c c2, double d2, boolean bl2) {
        double d3 = this.a(n2, c2) - d2;
        if (!bl2) return n2.a(d3);
        if (d3 >= 0.0) return n2.a(d3);
        return n.e;
    }

    double a(n n2, c c2) {
        if (n2.a() >= 0.0) return this.a(n2).c(c2);
        double d2 = c2.c(this.a(n2));
        if (d.g == 0) return d2;
        return this.a(n2).c(c2);
    }

    c a(n n2) {
        if (n2.equals(n.a)) {
            return this.a(0);
        }
        if (n2.equals(n.b)) {
            return this.a(1);
        }
        if (!n2.equals(n.c)) return this.a(3);
        return this.a(2);
    }

    void a(List list) {
        int n2 = d.g;
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) return;
            P p2 = (P)iterator.next();
            this.a(p2);
        } while (n2 == 0);
    }

    l k() {
        return this.b;
    }

    double l() {
        return this.e() - this.f();
    }
}

