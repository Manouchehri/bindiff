/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.c.q;
import y.f.am;
import y.f.e.a.Z;
import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.k;
import y.f.e.a.m;

public class ag
implements m {
    private a a;
    private double b;
    private double c;
    private double d;
    private a e;
    private q f;
    private double g;
    private double h;
    private m i;
    private short j;
    private double k;
    private final af l;

    ag(af af2, q q2) {
        this.l = af2;
        this.a = new Z();
        this.d = 0.9;
        this.e = new Z();
        this.j = 0;
        this.f = q2;
        this.o();
    }

    @Override
    public boolean m() {
        if (this.i == null) return false;
        return true;
    }

    @Override
    public boolean n() {
        if (this.j != 3) return false;
        return true;
    }

    public void a(boolean bl2) {
        if (bl2) {
            this.j = (short)(this.j | 2);
            if (!af.b) return;
        }
        this.j = (short)(this.j & -3);
    }

    public void a(m m2) {
        this.i = m2;
    }

    @Override
    public boolean k() {
        if (this.j == 0) return false;
        return true;
    }

    @Override
    public m l() {
        return this.i;
    }

    public void b(boolean bl2) {
        if (bl2) {
            this.j = (short)(this.j | 1);
            if (!af.b) return;
        }
        this.j = (short)(this.j & -2);
    }

    public void o() {
        am am2 = af.a(this.l).h(this.f);
        this.a(am2.getWidth(), am2.getHeight());
        this.a(am2.getX() + am2.getWidth() / 2.0, am2.getY() + am2.getHeight() / 2.0, 0.0);
    }

    public void a(double d2, double d3) {
        this.b = d2;
        this.c = d3;
        this.q();
    }

    private void q() {
        this.h = (this.b + this.c) / 4.0;
    }

    private void b(double d2, double d3) {
        af.b(this.l).a(af.b(this.l).d() - d2 + d3);
        af.c(this.l).a(af.c(this.l).d() + (d3 * d3 - d2 * d2));
    }

    private void c(double d2, double d3) {
        af.b(this.l).b(af.b(this.l).e() - d2 + d3);
        af.c(this.l).b(af.c(this.l).e() + (d3 * d3 - d2 * d2));
    }

    private void d(double d2, double d3) {
        af.b(this.l).c(af.b(this.l).f() - d2 + d3);
        af.c(this.l).c(af.c(this.l).f() + (d3 * d3 - d2 * d2));
    }

    public void a(double d2, double d3, double d4) {
        double d5 = this.a.d();
        double d6 = this.a.e();
        double d7 = this.a.f();
        this.b(this.a.d(), d2);
        this.a.a(d2);
        this.c(this.a.e(), d3);
        this.a.b(d3);
        this.d(this.a.f(), d4);
        this.a.c(d4);
        this.l.a(this, d5, d6, d7, d2, d3, d4);
    }

    public void a(double d2) {
        double d3 = this.a.d();
        this.b(this.a.d(), d2);
        this.a.a(d2);
        this.l.a(this, d3, this.a.e(), this.a.f(), d2, this.a.e(), this.a.f());
    }

    public void b(double d2) {
        double d3 = this.a.e();
        this.c(this.a.e(), d2);
        this.a.b(d2);
        this.l.a(this, this.a.d(), d3, this.a.f(), this.a.d(), d2, this.a.f());
    }

    @Override
    public k a() {
        return this.a;
    }

    @Override
    public double b() {
        return this.a.d();
    }

    @Override
    public double c() {
        return this.a.e();
    }

    @Override
    public double d() {
        return this.a.f();
    }

    @Override
    public double e() {
        return this.d;
    }

    public void c(double d2) {
        this.e(this.d, d2);
        this.d = d2;
    }

    private void e(double d2, double d3) {
        af.a(this.l, d3 - d2);
        af.b(this.l, d3 * d3 - d2 * d2);
        af.d(this.l);
    }

    public void p() {
        this.e.a();
    }

    @Override
    public k f() {
        return this.e;
    }

    public void a(k k2) {
        this.e.a(k2);
    }

    public void b(k k2) {
        this.a(k2.d() + this.a.d(), k2.e() + this.a.e(), k2.f() + this.a.f());
    }

    @Override
    public q j() {
        return this.f;
    }

    public void d(double d2) {
        this.g = d2;
    }

    @Override
    public double g() {
        return this.g;
    }

    @Override
    public double h() {
        return this.h;
    }

    public void e(double d2) {
        this.k = d2;
    }

    @Override
    public double i() {
        return this.k;
    }

    public void f(double d2) {
        this.h = d2;
    }
}

