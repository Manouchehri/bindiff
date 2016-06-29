/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.c.D;
import y.d.n;
import y.d.q;
import y.d.t;
import y.d.y;
import y.f.B;
import y.f.C;
import y.f.E;
import y.f.I;
import y.f.L;
import y.f.X;
import y.f.ae;
import y.f.am;

public class K
implements E {
    @Override
    public Object c() {
        return new L(20.0, 20.0, 0.0);
    }

    @Override
    public Object a(n n2, I i2, am am2, am am3) {
        t t2;
        t t3;
        block3 : {
            if (ae.a(n2)) {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid label bounds: ").append(n2).toString());
            }
            t3 = i2.getSourcePoint();
            t3 = new t(t3.a() + am2.getX() + am2.getWidth() / 2.0, t3.b() + am2.getY() + am2.getHeight() / 2.0);
            if (i2.pointCount() == 0) {
                t2 = i2.getTargetPoint();
                t2 = new t(t2.a() + am3.getX() + am3.getWidth() / 2.0, t2.b() + am3.getY() + am3.getHeight() / 2.0);
                if (!X.j) break block3;
            }
            t2 = i2.getPoint(0);
        }
        double d2 = this.a(t3, t2);
        y y2 = n2.h();
        t t4 = new t(y2.c() + y2.a() / 2.0, y2.d() + y2.b() / 2.0);
        double d3 = this.a(t3, t4);
        double d4 = d3 - d2;
        double d5 = t4.a() - t3.a();
        double d6 = t4.b() - t3.b();
        double d7 = d5 != 0.0 || d6 != 0.0 ? Math.sqrt(d5 * d5 + d6 * d6) : 0.0;
        return this.a(d7, d4, n2.j());
    }

    private Object a(double d2, double d3, double d4) {
        return new L(d2, d3, d4);
    }

    private double a(t t2, t t3) {
        double d2 = t3.a() - t2.a();
        double d3 = t3.b() - t2.b();
        if (d2 == 0.0) {
            if (d3 == 0.0) return 0.0;
        }
        double d4 = Math.atan2(d3, d2);
        return d4;
    }

    @Override
    public n a(q q2, I i2, am am2, am am3, Object object) {
        t t2;
        t t3;
        block2 : {
            t2 = i2.getSourcePoint();
            t2 = new t(t2.a() + am2.getX() + am2.getWidth() / 2.0, t2.b() + am2.getY() + am2.getHeight() / 2.0);
            if (i2.pointCount() == 0) {
                t3 = i2.getTargetPoint();
                t3 = new t(t3.a() + am3.getX() + am3.getWidth() / 2.0, t3.b() + am3.getY() + am3.getHeight() / 2.0);
                if (!X.j) break block2;
            }
            t3 = i2.getPoint(0);
        }
        double d2 = this.a(t2, t3);
        L l2 = object != null ? (L)object : (L)this.c();
        double d3 = d2 + l2.b;
        double d4 = Math.cos(d3);
        double d5 = Math.sin(d3);
        n n2 = new n(0.0, 0.0, q2.a(), q2.b());
        n2.a(l2.a());
        y y2 = n2.h();
        t t4 = new t(t2.a() + d4 * l2.a - y2.a() / 2.0, t2.b() + d5 * l2.a - y2.b() / 2.0);
        n2.e(t4.a + y2.a() * 0.5, t4.b + y2.b() * 0.5);
        return n2;
    }

    @Override
    public D a(C c2, I i2, am am2, am am3) {
        D d2 = new D();
        d2.add(new B(c2.getOrientedBox(), c2.getModelParameter(), c2));
        return d2;
    }
}

