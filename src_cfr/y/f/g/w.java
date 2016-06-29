/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import y.c.A;
import y.c.D;
import y.c.c;
import y.c.e;
import y.c.f;
import y.c.h;
import y.c.q;
import y.c.x;
import y.d.y;
import y.f.C;
import y.f.g.d;
import y.f.g.n;
import y.f.g.t;
import y.g.M;

class w {
    private y.c.y a;
    private D b;
    private boolean c;
    private Object d;
    private final n e;

    w(n n2, Object object, y.c.y y2, boolean bl2, c c2) {
        boolean bl3 = d.d;
        this.e = n2;
        this.d = object;
        this.a = y2;
        this.c = bl2;
        A a2 = M.a();
        x x2 = y2.a();
        while (x2.f()) {
            q q2 = x2.e();
            a2.a((Object)q2, true);
            x2.g();
            if (bl3) return;
            if (!bl3) continue;
        }
        this.a(a2, c2);
    }

    private void a(c c2, c c3) {
        y.c.C c4;
        boolean bl2;
        Object object;
        e e2;
        C[] arrc;
        block7 : {
            bl2 = d.d;
            this.b = new D();
            f f2 = new f();
            h h2 = M.b();
            c4 = this.a.a();
            block0 : do {
                boolean bl3 = c4.f();
                block1 : while (bl3) {
                    q q2 = c4.e();
                    e2 = q2.j();
                    if (bl2) break block7;
                    object = e2;
                    while (object.f()) {
                        arrc = object.a();
                        bl3 = h2.d(arrc);
                        if (bl2) continue block1;
                        if (!bl3) {
                            f2.add(arrc);
                            h2.a((Object)arrc, true);
                        }
                        object.g();
                        if (!bl2) continue;
                    }
                    object = new t(this.e, q2, q2, 0);
                    this.b.add(object);
                    c4.g();
                    if (!bl2) continue block0;
                }
                break block0;
                break;
            } while (true);
            e2 = f2.a();
        }
        c4 = e2;
        block3 : do {
            if (!c4.f()) return;
            y.c.d d2 = c4.a();
            if ((c3 == null || c3.d(d2)) && c2.d(d2.c()) && c2.d(d2.d())) {
                object = new t(this.e, d2, d2, 1);
                this.b.add(object);
                arrc = n.b(this.e).d(d2);
                for (int i2 = 0; i2 < arrc.length; ++i2) {
                    C c5 = arrc[i2];
                    t t2 = new t(this.e, c5, d2, 3);
                    this.b.add(t2);
                    if (bl2) continue block3;
                    if (!bl2) continue;
                }
            }
            c4.g();
        } while (!bl2);
    }

    public void a(double d2, double d3) {
        boolean bl2 = d.d;
        if (d2 == 0.0 && d3 == 0.0) {
            return;
        }
        y.c.C c2 = this.b.m();
        do {
            if (!c2.f()) return;
            t t2 = (t)c2.d();
            t2.a(d2, d3);
            c2.g();
        } while (!bl2);
    }

    public y a() {
        y y2;
        boolean bl2 = d.d;
        double d2 = Double.MAX_VALUE;
        double d3 = Double.MAX_VALUE;
        double d4 = -1.7976931348623157E308;
        double d5 = -1.7976931348623157E308;
        y.c.C c2 = this.b.m();
        while (c2.f()) {
            t t2 = (t)c2.d();
            y2 = t2.h();
            if (bl2) return y2;
            y y3 = y2;
            d2 = Math.min(d2, y3.c);
            d3 = Math.min(d3, y3.d);
            d4 = Math.max(d4, y3.c + y3.a);
            d5 = Math.max(d5, y3.d + y3.b);
            c2.g();
            if (!bl2) continue;
        }
        y2 = new y(d2, d3, d4 - d2, d5 - d3);
        return y2;
    }

    public boolean b() {
        return this.c;
    }

    public D c() {
        return this.b;
    }
}

