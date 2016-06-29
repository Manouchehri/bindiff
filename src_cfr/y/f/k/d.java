/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import y.c.b;
import y.c.c;
import y.c.i;
import y.c.q;
import y.c.y;
import y.f.X;
import y.f.k.A;
import y.f.k.B;
import y.f.k.C;
import y.f.k.E;
import y.f.k.F;
import y.f.k.K;
import y.f.k.P;
import y.f.k.d;
import y.f.k.l;
import y.f.k.x;

class D
implements K {
    private x a;
    private X b;
    private q c;
    private q d;
    private y.c.A e;
    private int f;
    private int g;
    private double h;
    private final B i;

    D(B b2, x x2, X x3, q q2) {
        this.i = b2;
        this.a = x2;
        this.b = x3;
        this.d = q2;
        y.c.A a2 = x3.t();
        this.c = y.a.A.d(x3);
        y.a.A.b(x3, a2);
        this.f = a2.a(this.c);
        this.g = a2.a(q2);
    }

    @Override
    public void a(b b2, b b3, b b4) {
        if (this.b.c(B.h) == null) {
            this.e = this.b.t();
            this.b.a(B.h, this.e);
        }
        this.a((y.c.A)this.b.c(B.h), b2);
    }

    E a(y.c.A a2, b b2) {
        F[] arrf;
        Object object;
        Object object2;
        Object object3;
        E e2;
        int n2;
        block11 : {
            n2 = d.g;
            e2 = new E(this.i, this.b);
            e2.a(this.h);
            arrf = new F[this.f];
            for (int i2 = 0; i2 < this.f; ++i2) {
                arrf[i2] = e2.a(i2);
                if (n2 == 0) continue;
            }
            y y2 = new y();
            if (!this.b.i()) {
                object3 = this.b.k();
                object2 = this.b.o();
                while (object2.f()) {
                    object = object2;
                    if (n2 == 0) {
                        if (object.e().b() == 0) {
                            object3 = object2.e();
                            if (n2 == 0) break;
                        }
                        object2.g();
                        if (n2 == 0) continue;
                    }
                    break block11;
                }
                object2 = new C(this, y2);
                object2.a(true);
                object2.a(this.b, (q)object3);
            }
            y2.n();
            object = y2.a();
        }
        object3 = object;
        do {
            block12 : {
                int n3;
                Object object4;
                Object object5;
                F f2;
                int n4 = object3.f();
                block3 : do {
                    A a3;
                    if (n4 == 0) return e2;
                    object2 = object3.e();
                    if (object2.c() == 0) {
                        f2 = arrf[this.f - 1];
                        a3 = this.a.f((q)object2);
                        object4 = new P(this.i.c, a3);
                        f2.a((q)object2, (P)object4, this.i.c);
                        a2.a(object2, f2);
                        if (n2 == 0) break block12;
                    }
                    if (object2 == this.c) {
                        f2 = arrf[0];
                        a3 = this.a.f((q)object2);
                        object4 = new P(this.i.c, a3);
                        f2.a((q)object2, (P)object4, this.i.c);
                        a2.a(object2, f2);
                        if (n2 == 0) break block12;
                    }
                    n3 = Integer.MAX_VALUE;
                    object4 = object2.o();
                    while (object4.f()) {
                        object5 = object4.e();
                        F f3 = (F)a2.b(object5);
                        n4 = f3.c();
                        if (n2 != 0) continue block3;
                        if (n4 < n3) {
                            n3 = f3.c();
                        }
                        object4.g();
                        if (n2 == 0) continue;
                    }
                    break block3;
                    break;
                } while (true);
                f2 = arrf[n3 - 1];
                object4 = this.a.f((q)object2);
                object5 = new P(this.i.c, (A)object4);
                f2.a((q)object2, (P)object5, this.i.c);
                a2.a(object2, f2);
            }
            object3.g();
        } while (n2 == 0);
        return e2;
    }

    @Override
    public void a() {
    }

    public void a(double d2) {
        this.h = d2;
    }
}

