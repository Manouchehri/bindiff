/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import y.c.q;
import y.c.y;
import y.f.X;
import y.f.am;
import y.f.k.A;
import y.f.k.E;
import y.f.k.P;
import y.f.k.T;
import y.f.k.l;
import y.f.k.x;

class F {
    private int a;
    private E b;
    private y c = new y();
    private double d;
    private double e;
    private double f;
    private double g;

    F(int n2, E e2) {
        this.b = e2;
        this.a = n2;
    }

    void a(q q2, P p2, l l2) {
        this.c.add(q2);
        T t2 = new T(l2.a(), this.b.a().a(q2));
        double d2 = t2.d() + t2.a() * this.g;
        double d3 = d2 - p2.g();
        double d4 = p2.d() - d2;
        if (d3 > this.e) {
            this.e = d3;
        }
        if (d4 <= this.f) return;
        this.f = d4;
    }

    void a(q q2, x x2, l l2, double d2, double d3) {
        A a2 = x2.f(q2);
        P p2 = new P(l2, a2);
        T t2 = new T(l2.a(), this.b.a().a(q2));
        double d4 = t2.d() + t2.a() * this.g;
        double d5 = d4 - p2.g() + d2;
        double d6 = p2.d() - d4 + d3;
        if (d5 > this.e) {
            this.e = d5;
        }
        if (d6 <= this.f) return;
        this.f = d6;
    }

    public double a() {
        return this.f;
    }

    public double b() {
        return this.e;
    }

    int c() {
        return this.a;
    }

    E d() {
        return this.b;
    }

    F e() {
        return E.a(this.d(), this.a + 1);
    }

    public void a(double d2) {
        this.d = d2;
    }

    public void b(double d2) {
        this.g = d2;
    }
}

