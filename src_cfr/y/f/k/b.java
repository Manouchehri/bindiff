/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import java.util.List;
import y.c.q;
import y.d.c;
import y.d.t;
import y.f.I;
import y.f.X;
import y.f.aE;
import y.f.am;
import y.f.k.D;
import y.f.k.E;
import y.f.k.F;
import y.f.k.G;
import y.f.k.K;
import y.f.k.P;
import y.f.k.T;
import y.f.k.W;
import y.f.k.Y;
import y.f.k.d;
import y.f.k.l;
import y.f.k.m;
import y.f.k.n;
import y.f.k.x;

public class B
extends d {
    public static final Object h = "LayeredNodePlacer.DP_KEY_DISTANCE_TO_PARENT_MAP";
    private m i = m.g;
    private double j = 0.5;
    private double k = 0.3;
    private boolean l;
    private boolean m = false;
    private Object n;
    private double o = 40.0;
    private int p;

    public B(l l2, Object object) {
        super(l2);
        this.n = object;
    }

    public B() {
        this(l.a, "TheDefaultKey");
    }

    public boolean b() {
        return this.m;
    }

    @Override
    protected byte d(q q2) {
        return 0;
    }

    @Override
    protected P a(q q2, byte by2) {
        P p2;
        B b2;
        block13 : {
            P p3;
            y.c.d d2;
            Y y2;
            int n2;
            P p4;
            Object object;
            q q3;
            block12 : {
                n2 = d.g;
                p2 = this.a(q2);
                if (q2.c() == 0) {
                    this.a(q2, by2, p2);
                    return p2;
                }
                y.c.c c2 = this.b.c(h);
                if (c2 == null) {
                    throw new IllegalStateException("distances not set!");
                }
                F f2 = (F)c2.b(q2);
                T t2 = new T(this.a().a(), this.b.h(q2));
                double d3 = t2.d() + t2.a() * this.j;
                double d4 = d3 + f2.a();
                t t3 = new t(0.0, d4 + this.o * this.k);
                y2 = new Y(t3);
                P p5 = null;
                boolean bl2 = false;
                for (d2 = q2.f(); d2 != null; d2 = d2.g()) {
                    q3 = d2.d();
                    p3 = this.b(q3);
                    object = (F)c2.b(q3);
                    double d5 = this.a(f2, (F)object);
                    double d6 = d3 + d5;
                    T t4 = new T(this.a().a(), this.b.h(q3));
                    double d7 = t4.d() + t4.a() * this.j;
                    double d8 = d6 - d7;
                    p3.a(d8);
                    p4 = p5;
                    if (n2 == 0) {
                        if (p4 != null) {
                            c c3 = p5.a(1);
                            if (bl2 || f2.c() - object.c() < -1) {
                                bl2 = f2.c() - object.c() < -1;
                                c3 = new c(c3.a(), c3.b(), c3.d());
                            }
                            p3.a(c3, this.a);
                        }
                        p3.h();
                        p3.j();
                        if (p5 == null) {
                            p5 = p3;
                            if (n2 == 0) continue;
                        }
                        p5.a(p3);
                        if (n2 == 0) continue;
                    }
                    break block12;
                }
                this.i.a(p2, this.f, this.a);
                p4 = p2;
            }
            p4.j();
            for (d2 = q2.f(); d2 != null; d2 = d2.g()) {
                q3 = d2.d();
                b2 = this;
                if (n2 == 0) {
                    if (b2.e() || this.d() || this.b()) {
                        p3 = this.b(q3);
                        object = this.a(d2, p3);
                        if (this.e() || this.b()) {
                            object.a(y2);
                            object.d(1);
                            if (this.e()) {
                                object.c(0);
                            }
                        }
                        object.e();
                        if (n2 == 0) continue;
                    }
                    this.b.b(d2).clearPoints();
                    if (n2 == 0) continue;
                }
                break block13;
            }
            p2.a(this.f);
            b2 = this;
        }
        b2.a(q2, by2, p2);
        return p2;
    }

    private double a(F f2, F f3) {
        double d2;
        int n2 = d.g;
        double d3 = f2.a() + f3.b() + (double)(f3.c() - f2.c()) * this.o;
        E e2 = f2.d();
        for (int i2 = f2.c() + 1; i2 < f3.c(); ++i2) {
            F f4 = e2.b(i2);
            d2 = d3 + (f4.a() + f4.b());
            if (n2 != 0) return d2;
            d3 = d2;
            if (n2 == 0) continue;
        }
        d2 = d3;
        return d2;
    }

    private boolean e() {
        if (this.p != 1) return false;
        return true;
    }

    private void a(q q2, byte by2, P p2) {
        int n2 = d.g;
        if (this.p == 0) {
            return;
        }
        if (q2.g() == null) {
            return;
        }
        aE aE2 = this.c(q2);
        y.f.k.X x2 = this.a(q2, p2);
        block0 : switch (by2) {
            case 0: {
                switch (aE2.b()) {
                    default: {
                        if (n2 == 0) break block0;
                    }
                    case 4: {
                        x2.a(0, true);
                        if (n2 == 0) break block0;
                    }
                    case 2: {
                        x2.d(0, true);
                        x2.b(0, true);
                        if (n2 == 0) break block0;
                    }
                    case 8: 
                }
                x2.b(0, true);
                if (n2 == 0) break;
            }
            case 1: {
                switch (aE2.b()) {
                    case 1: {
                        x2.c(1, true);
                        if (n2 == 0) break block0;
                    }
                    default: {
                        if (n2 == 0) break block0;
                    }
                    case 2: {
                        x2.d(0, true);
                        if (n2 == 0) break block0;
                    }
                    case 8: 
                }
                x2.b(0, true);
                x2.c(1, true);
                if (n2 == 0) break;
            }
            case 2: {
                switch (aE2.b()) {
                    case 1: {
                        x2.c(0, true);
                        x2.b(1, true);
                        if (n2 == 0) break block0;
                    }
                    case 4: {
                        x2.a(1, true);
                        if (n2 == 0) break block0;
                    }
                    case 2: {
                        x2.d(0, true);
                        x2.b(1, true);
                        if (n2 == 0) break block0;
                    }
                }
                x2.b(1, true);
                if (n2 == 0) break;
            }
            case 3: {
                switch (aE2.b()) {
                    case 1: {
                        x2.c(0, true);
                        if (n2 == 0) break block0;
                    }
                    case 4: {
                        x2.a(0, true);
                        x2.c(1, true);
                        if (n2 == 0) break block0;
                    }
                    case 2: {
                        x2.d(0, true);
                        if (n2 == 0) break block0;
                    }
                }
                break;
            }
        }
        p2.h();
    }

    @Override
    public K a(x x2, X x3, q q2) {
        D d2;
        y.c.c c2 = x3.c(h);
        if (c2 != null && c2.b(q2) != null) {
            return null;
        }
        if (this.m) {
            d2 = new D(this, x2, x3, q2);
            d2.a(this.a);
            if (d.g == 0) return d2;
        }
        d2 = new G(this, x2, x3, q2);
        ((G)((Object)d2)).a(this.a);
        return d2;
    }

    public Object c() {
        return this.n;
    }

    public boolean d() {
        return this.l;
    }

    static double a(B b2) {
        return b2.o;
    }

    static double b(B b2) {
        return b2.j;
    }
}

