/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.f.c.a.bs;

public class B {
    private bs a = new bs(2);
    private double b = 10.0;
    private double c = 15.0;
    private double d = 20.0;
    private double e = 20.0;
    private double f = 0.3;
    private double g = 10.0;
    private boolean h = false;
    private boolean i = false;

    public B() {
        this.c(false);
    }

    public void a(double d2) {
        this.b = d2;
    }

    public double a() {
        return this.b;
    }

    public void b(double d2) {
        this.c = d2;
    }

    public double b() {
        return this.c;
    }

    public double c() {
        return this.d;
    }

    public double d() {
        return this.g;
    }

    public double e() {
        return this.f;
    }

    public boolean f() {
        return this.h;
    }

    public void a(boolean bl2) {
        this.h = bl2;
    }

    public boolean g() {
        return this.i;
    }

    public void b(boolean bl2) {
        this.i = bl2;
    }

    public void c(boolean bl2) {
        byte by2 = bl2 ? 0 : 2;
        this.a.c(by2);
        this.a.a(0);
        this.a.b(0);
        this.a.d(0);
        this.a.e(0);
    }

    public bs h() {
        return this.a;
    }

    public void a(bs bs2) {
        this.a = bs2;
    }

    public double i() {
        return this.e;
    }
}

