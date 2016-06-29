/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import java.util.Comparator;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.t;
import y.f.X;
import y.f.a.H;
import y.f.a.f;
import y.f.ah;

class G
implements ah {
    private A e;
    private t f = new t();
    boolean a = true;
    boolean b = false;
    double c = 0.0;
    private double g;
    private y h;
    double d;

    G() {
    }

    public void a(t t2) {
        this.f = t2;
    }

    void a(boolean bl2) {
        this.a = bl2;
    }

    public void a(double d2) {
        this.c = d2;
    }

    void b(double d2) {
        this.g = d2;
    }

    public y a() {
        return this.h;
    }

    private D a(X x2, double d2, double d3, double d4) {
        int n2 = f.u;
        D d5 = new D();
        d5.add(this.a(d3, d4, d2, 0, 0));
        q[] arrq = x2.m();
        int n3 = 1;
        block0 : do {
            if (n3 >= 2 * arrq.length) return d5;
            for (int i2 = 1; i2 < 2 * n3; i2 += 2) {
                t t2 = this.a(d3, d4, d2, i2, n3);
                d5.add(t2);
                if (n2 != 0) continue block0;
                if (n2 == 0) continue;
            }
            n3 <<= 1;
        } while (n2 == 0);
        return d5;
    }

    private double a(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d4 - d2;
        double d9 = d5 - d3;
        double d10 = d6 - d2;
        double d11 = d7 - d3;
        double d12 = d8 * d10 + d9 * d11;
        double d13 = Math.sqrt(d8 * d8 + d9 * d9) * Math.sqrt(d10 * d10 + d11 * d11);
        if (d13 == 0.0) {
            return 0.0;
        }
        double d14 = Math.acos(d12 / d13);
        return d14;
    }

    private q a(t t2, X x2, q[] arrq, A a2, double d2, double d3) {
        q q2;
        int n2 = f.u;
        q q3 = null;
        double d4 = Double.MAX_VALUE;
        double d5 = Double.MAX_VALUE;
        for (int i2 = 0; i2 < arrq.length; ++i2) {
            double d6;
            double d7;
            q2 = arrq[i2];
            if (n2 != 0) return q2;
            q q4 = q2;
            double d8 = x2.j(q4);
            double d9 = this.a(t2.a, t2.b, d8, d6 = x2.k(q4), d7 = this.a(t2.a, t2.b, d8, d6, d2, d3));
            if (d9 >= d4) continue;
            d4 = d9;
            q3 = q4;
            if (n2 == 0) continue;
        }
        q2 = q3;
        return q2;
    }

    double a(double d2, double d3, double d4, double d5, double d6) {
        double d7 = t.a(d2, d3, d4, d5);
        if (d7 != 0.0) return d7 * (1.0 + Math.pow(4.0 * d6 / 3.141592653589793, 8.0));
        return d7;
    }

    private t a(double d2, double d3, double d4, int n2, int n3) {
        double d5 = n2 == 0 ? 0.0 : 3.141592653589793 * (double)n2 / (double)n3;
        double d6 = Math.cos(d5);
        double d7 = Math.sin(d5);
        return new t(d2 + d6 * d4, d3 + d7 * d4);
    }

    public double b() {
        return this.d;
    }

    public void b(boolean bl2) {
        this.b = bl2;
    }

    @Override
    public void c(X x2) {
        Object object;
        Object object2;
        Object object3;
        A a2;
        int n2;
        A a3;
        int n3;
        block11 : {
            double d2;
            double d3;
            block10 : {
                n2 = f.u;
                d2 = this.f.a();
                d3 = this.f.b();
                if (this.a) {
                    this.d = this.a(x2, d2, d3);
                    if (n2 == 0) break block10;
                }
                this.d = this.g;
            }
            D d4 = this.a(x2, this.d + this.c, d2, d3);
            a2 = x2.t();
            a3 = x2.t();
            q[] arrq = x2.m();
            int n4 = 0;
            this.h = new y();
            object3 = d4.m();
            while (object3.f()) {
                n3 = n4;
                if (n2 == 0) {
                    if (n3 > arrq.length) break;
                    object = (t)object3.d();
                    object2 = this.a((t)object, x2, arrq, a2, d2, d3);
                    if (object2 != null && !a2.d(object2)) {
                        a3.a(object2, object);
                        this.h.add(object2);
                        if (this.e != null) {
                            this.e.a(object2, true);
                        }
                        ++n4;
                        a2.a(object2, true);
                    }
                    object3.g();
                    if (n2 == 0) continue;
                }
                break block11;
            }
            n3 = this.b;
        }
        if (n3 == 0) {
            block12 : {
                object3 = x2.o();
                while (object3.f()) {
                    object = object3.e();
                    object2 = (t)a3.b(object);
                    if (n2 == 0) {
                        if (object2 != null) {
                            x2.a((q)object, (t)object2);
                        }
                        object3.g();
                        if (n2 == 0) continue;
                    }
                    break block12;
                }
                this.h.sort(new H(this, a3));
            }
            object3 = new f();
            object3.h(false);
            object3.c(this.d);
            object = this.h.b();
            double d5 = Math.atan2(x2.n((q)object), x2.m((q)object));
            object3.a(d5);
            object3.b(this.h.a(), d5);
        }
        x2.a(a3);
        x2.a(a2);
    }

    private double a(X x2, double d2, double d3) {
        double d4;
        int n2 = f.u;
        double d5 = 0.0;
        x x3 = x2.o();
        while (x3.f()) {
            t t2 = x2.l(x3.e());
            d4 = Math.max(d5, t2.a(d2, d3));
            if (n2 != 0) return d4;
            d5 = d4;
            x3.g();
            if (n2 == 0) continue;
        }
        d4 = d5;
        return d4;
    }

    public void a(A a2) {
        this.e = a2;
    }
}

