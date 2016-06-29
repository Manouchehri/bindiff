/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import y.f.am;
import y.f.k.l;
import y.f.k.n;

class T {
    private l a;
    private am b;
    private double c;
    private double d;
    private double e;
    private double f;

    T(l l2, am am2) {
        this.a = l2;
        this.b = am2;
        n n2 = n.a(am2.getWidth(), am2.getHeight());
        n n3 = n2.a(l2);
        this.c = n3.a(0);
        this.d = n3.a(1);
        n n4 = n.a(am2.getX(), am2.getY());
        n n5 = n4.a(l2);
        this.e = n5.a(0);
        this.f = n5.a(1);
        if (this.c < 0.0) {
            this.e += this.c;
            this.c = - this.c;
        }
        if (this.d >= 0.0) return;
        this.f += this.d;
        this.d = - this.d;
    }

    public double a() {
        return this.d;
    }

    public double b() {
        return this.c;
    }

    public double c() {
        return this.e;
    }

    public double d() {
        return this.f;
    }

    public double e() {
        return this.e + this.c / 2.0;
    }
}

