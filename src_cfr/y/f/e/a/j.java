/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.f.e.a.K;
import y.f.e.a.L;
import y.f.e.a.M;
import y.f.e.a.N;
import y.f.e.a.O;
import y.f.e.a.P;
import y.f.e.a.Q;
import y.f.e.a.R;
import y.f.e.a.S;
import y.f.e.a.T;
import y.f.e.a.U;
import y.f.e.a.V;
import y.f.e.a.W;
import y.f.e.a.X;
import y.f.e.a.Y;
import y.f.e.a.a;
import y.f.e.a.ax;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;

public class J
implements ax {
    public static final Y a = new R();
    public static final Y b = new V();
    public static final Y c = new Q();
    public static final Y d = new K();
    public static final Y e = new W();
    public static final Y f = new T();
    public static final Y g = new X();
    public static final Y h = new L();
    public static final Y i = new M();
    public static final Y j = new S();
    public static final Y k = new N();
    public static final Y l = new O();
    public static final Y m = new U();
    public static final Y n = new P();
    public static final Y[] o = new Y[]{c, a, b, h, i, d, e, f, g, j, k, l, m, n};
    private final double s;
    private final double t;
    protected ax p;
    protected Y q;
    protected Y r = c;
    private final double u;
    private double v = 1.0;

    public J(ax ax2, Y y2, double d2, double d3) {
        this.p = ax2;
        this.q = y2;
        this.t = d2;
        this.s = d3;
        this.u = d3 - d2;
        if (this.u != 0.0) return;
        throw new IllegalArgumentException("Length must not be 0");
    }

    public void a(Y y2) {
        this.r = y2;
    }

    @Override
    public k a(m m2, l l2, a a2) {
        if (this.a(l2)) {
            return a2;
        }
        a a3 = (a)this.p.a(m2, l2, a2);
        this.a(a3);
        this.a(l2, a3);
        return a3;
    }

    private void a(l l2, a a2) {
        a2.d(this.b(l2.a()));
    }

    private boolean a(l l2) {
        if (this.r.b(l2.a())) return true;
        if (this.v == 0.0) return true;
        return false;
    }

    void a(a a2) {
        if (this.v == 0.0) {
            a2.a();
            return;
        }
        double d2 = a2.c();
        if (d2 == 0.0) {
            return;
        }
        double d3 = this.a(d2);
        if (d3 == 0.0) {
            a2.a();
            return;
        }
        double d4 = d3 * this.v / d2;
        a2.a(a2.d() * d4);
        a2.b(a2.e() * d4);
        a2.c(a2.f() * d4);
    }

    double a(double d2) {
        return this.q.a((d2 - this.t) / this.u);
    }

    double b(double d2) {
        return this.r.a(d2);
    }

    public double a() {
        return this.v;
    }

    public void c(double d2) {
        this.v = d2;
    }

    public ax b() {
        return this.p;
    }

    public String toString() {
        return new StringBuffer().append("WeightedCalculator{coreCalculator=").append(this.p).append(", factor=").append(this.v).append(", model=").append(this.q).append(", timeModel=").append(this.r).append("}").toString();
    }
}

