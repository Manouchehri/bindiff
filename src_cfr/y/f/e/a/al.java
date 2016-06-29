/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.f.e.a.Z;
import y.f.e.a.a;
import y.f.e.a.k;

class al {
    private a a = new Z();
    private a b = new Z();
    private double c;
    private double d;

    al() {
    }

    public void a(k k2) {
        this.b.a(this.a.d());
        this.b.b(this.a.e());
        this.b.c(this.a.f());
        this.a.a(k2.d());
        this.a.b(k2.e());
        this.a.c(k2.f());
        this.c();
    }

    private void c() {
        this.d = this.c;
        double d2 = this.a.c();
        double d3 = this.b.c();
        if (d2 != 0.0 && d3 != 0.0) {
            this.c = (this.a.d() * this.b.d() + this.a.e() * this.b.e() + this.a.f() * this.b.f()) / (d2 * d3);
            return;
        }
        this.c = 0.0;
    }

    public double a() {
        return this.c;
    }

    public double b() {
        return this.d;
    }
}

