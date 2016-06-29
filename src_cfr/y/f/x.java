/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.p;
import y.c.x;
import y.d.q;
import y.d.t;
import y.d.u;
import y.d.v;
import y.d.y;
import y.f.C;
import y.f.I;
import y.f.O;
import y.f.aj;
import y.f.am;

public abstract class X
extends i
implements O {
    public static boolean j;

    public X() {
    }

    public X(X x2, y.c.C c2) {
        super(x2, c2);
    }

    @Override
    protected abstract y.g.C b();

    public abstract am h(y.c.q var1);

    public abstract I g(d var1);

    public abstract aj[] i(y.c.q var1);

    public abstract C[] h(d var1);

    public abstract y.c.q a(aj var1);

    public abstract d a(C var1);

    @Override
    public am a(Object object) {
        return this.h((y.c.q)object);
    }

    @Override
    public I b(Object object) {
        return this.g((d)object);
    }

    @Override
    public aj[] a_(Object object) {
        return this.i((y.c.q)object);
    }

    @Override
    public C[] d(Object object) {
        return this.h((d)object);
    }

    public double j(y.c.q q2) {
        am am2 = this.h(q2);
        return am2.getX() + am2.getWidth() / 2.0;
    }

    public double k(y.c.q q2) {
        am am2 = this.h(q2);
        return am2.getY() + am2.getHeight() / 2.0;
    }

    public t l(y.c.q q2) {
        return new t(this.j(q2), this.k(q2));
    }

    public double m(y.c.q q2) {
        return this.h(q2).getX();
    }

    public double n(y.c.q q2) {
        return this.h(q2).getY();
    }

    public t o(y.c.q q2) {
        am am2 = this.h(q2);
        return new t(am2.getX(), am2.getY());
    }

    public double p(y.c.q q2) {
        return this.h(q2).getWidth();
    }

    public double q(y.c.q q2) {
        return this.h(q2).getHeight();
    }

    public q r(y.c.q q2) {
        return new q(this.p(q2), this.q(q2));
    }

    public y s(y.c.q q2) {
        return new y(this.o(q2), this.r(q2));
    }

    public void a(y.c.q q2, t t2) {
        this.a(q2, t2.a(), t2.b());
    }

    public void a(y.c.q q2, double d2, double d3) {
        am am2 = this.h(q2);
        am2.setLocation(d2 - am2.getWidth() / 2.0, d3 - am2.getHeight() / 2.0);
    }

    public void b(y.c.q q2, double d2, double d3) {
        this.h(q2).setSize(d2, d3);
    }

    public void a(y.c.q q2, q q3) {
        this.b(q2, q3.a(), q3.b());
    }

    public void c(y.c.q q2, double d2, double d3) {
        this.h(q2).setLocation(d2, d3);
    }

    public void b(y.c.q q2, t t2) {
        this.c(q2, t2.a(), t2.b());
    }

    public void d(y.c.q q2, double d2, double d3) {
        am am2 = this.h(q2);
        am2.setLocation(am2.getX() + d2, am2.getY() + d3);
    }

    public v j(d d2) {
        boolean bl2 = j;
        I i2 = this.g(d2);
        ArrayList<t> arrayList = new ArrayList<t>(i2.pointCount());
        int n2 = 0;
        do {
            if (n2 >= i2.pointCount()) return new v(arrayList);
            arrayList.add(i2.getPoint(n2));
            ++n2;
        } while (!bl2);
        return new v(arrayList);
    }

    public D k(d d2) {
        D d3;
        boolean bl2 = j;
        I i2 = this.g(d2);
        D d4 = new D();
        for (int i3 = 0; i3 < i2.pointCount(); ++i3) {
            d3 = d4;
            if (bl2) return d3;
            d3.add(i2.getPoint(i3));
            if (!bl2) continue;
        }
        d3 = d4;
        return d3;
    }

    public v l(d d2) {
        boolean bl2 = j;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add(this.p(d2));
        u u2 = this.j(d2).b();
        while (u2.f()) {
            arrayList.add(u2.d());
            u2.g();
            if (bl2) return new v(arrayList);
            if (!bl2) continue;
        }
        arrayList.add(this.q(d2));
        return new v(arrayList);
    }

    public D m(d d2) {
        boolean bl2 = j;
        D d3 = new D();
        d3.add(this.p(d2));
        u u2 = this.j(d2).b();
        while (u2.f()) {
            d3.add(u2.d());
            u2.g();
            if (bl2) return d3;
            if (!bl2) continue;
        }
        d3.add(this.q(d2));
        return d3;
    }

    public void a(d d2, v v2) {
        boolean bl2 = j;
        I i2 = this.g(d2);
        i2.clearPoints();
        u u2 = v2.b();
        t t2 = u2.a();
        this.c(d2, t2);
        t t3 = v2.d();
        u2.g();
        while (u2.d() != t3) {
            t2 = u2.a();
            i2.addPoint(t2.a(), t2.b());
            u2.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        this.d(d2, t3);
    }

    public void a(d d2, D d3) {
        boolean bl2 = j;
        I i2 = this.g(d2);
        i2.clearPoints();
        y.c.C c2 = d3.m();
        t t2 = (t)c2.d();
        this.c(d2, t2);
        t t3 = (t)d3.i();
        c2.g();
        while (c2.d() != t3) {
            t2 = (t)c2.d();
            i2.addPoint(t2.a(), t2.b());
            c2.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        this.d(d2, t3);
    }

    public void b(d d2, v v2) {
        boolean bl2 = j;
        I i2 = this.g(d2);
        i2.clearPoints();
        u u2 = v2.b();
        do {
            if (!u2.f()) return;
            t t2 = u2.a();
            i2.addPoint(t2.a(), t2.b());
            u2.g();
        } while (!bl2);
    }

    public void b(d d2, D d3) {
        boolean bl2 = j;
        I i2 = this.g(d2);
        i2.clearPoints();
        p p2 = d3.k();
        do {
            if (p2 == null) return;
            t t2 = (t)p2.c();
            i2.addPoint(t2.a(), t2.b());
            p2 = p2.a();
        } while (!bl2);
    }

    public void a(d d2, t t2, t t3) {
        this.c(d2, t2);
        this.d(d2, t3);
    }

    public t n(d d2) {
        return this.g(d2).getSourcePoint();
    }

    public t o(d d2) {
        return this.g(d2).getTargetPoint();
    }

    public void a(d d2, t t2) {
        this.g(d2).setSourcePoint(t2);
    }

    public void b(d d2, t t2) {
        this.g(d2).setTargetPoint(t2);
    }

    public t p(d d2) {
        t t2 = this.g(d2).getSourcePoint();
        if (t2 != null) return new t(this.j(d2.c()) + t2.a(), this.k(d2.c()) + t2.b());
        return this.l(d2.c());
    }

    public t q(d d2) {
        t t2 = this.g(d2).getTargetPoint();
        if (t2 != null) return new t(this.j(d2.d()) + t2.a(), this.k(d2.d()) + t2.b());
        return this.l(d2.d());
    }

    public void c(d d2, t t2) {
        t t3 = new t(t2.a() - this.j(d2.c()), t2.b() - this.k(d2.c()));
        this.g(d2).setSourcePoint(t3);
    }

    public void d(d d2, t t2) {
        t t3 = new t(t2.a() - this.j(d2.d()), t2.b() - this.k(d2.d()));
        this.g(d2).setTargetPoint(t3);
    }

    public f E() {
        return new f(this.p());
    }

    @Override
    public Rectangle a() {
        y.c.C c2;
        q q2;
        double d2;
        double d3;
        boolean bl2;
        double d4;
        double d5;
        Object object;
        X x2;
        block6 : {
            bl2 = j;
            d5 = Double.MAX_VALUE;
            d3 = Double.MAX_VALUE;
            d2 = -1.7976931348623157E308;
            d4 = -1.7976931348623157E308;
            c2 = this.o();
            while (c2.f()) {
                object = this.o(c2.e());
                x2 = this;
                if (!bl2) {
                    q2 = x2.r(c2.e());
                    d3 = Math.min(object.a(), d3);
                    d5 = Math.min(object.b(), d5);
                    d4 = Math.max(object.a() + q2.a(), d4);
                    d2 = Math.max(object.b() + q2.b(), d2);
                    c2.g();
                    if (!bl2) continue;
                }
                break block6;
            }
            x2 = this;
        }
        c2 = x2.p();
        while (c2.f()) {
            block7 : {
                object = this.j(c2.a()).a();
                while (object.f()) {
                    q2 = (t)object.d();
                    d3 = Math.min(q2.a(), d3);
                    d5 = Math.min(q2.b(), d5);
                    d4 = Math.max(q2.a(), d4);
                    d2 = Math.max(q2.b(), d2);
                    object.g();
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block7;
                }
                c2.g();
            }
            if (!bl2) continue;
        }
        if (d3 == Double.MAX_VALUE && d5 == Double.MAX_VALUE) {
            return new Rectangle(0, 0, -1, -1);
        }
        d3 = Math.floor(d3);
        d5 = Math.floor(d5);
        d4 = Math.ceil(d4);
        d2 = Math.ceil(d2);
        return new Rectangle((int)d3, (int)d5, (int)(d4 - d3), (int)(d2 - d5));
    }
}

