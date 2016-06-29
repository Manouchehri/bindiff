/*
 * Decompiled with CFR 0_115.
 */
package y.d.b;

import java.util.Comparator;
import y.d.a;
import y.d.b.c;
import y.d.b.l;
import y.d.b.p;
import y.d.b.q;
import y.d.b.r;
import y.d.b.s;
import y.d.b.y;
import y.d.m;
import y.d.t;
import y.d.z;

public class o
extends c
implements l {
    private static final o b = new o();
    private Comparator c = new p();
    private Comparator d = new r();
    private Comparator e = new s();

    @Override
    public Object a(double d2, double d3) {
        return new t(d2, d3);
    }

    @Override
    public Object a(y.d.b.z z2, y.d.b.z z3) {
        return new t(z2.e(), z3.e());
    }

    @Override
    public y.d.b.z k(Object object) {
        return new y(((t)object).a());
    }

    @Override
    public y.d.b.z l(Object object) {
        return new y(((t)object).b());
    }

    @Override
    public Object c(Object object, Object object2) {
        return new m((t)object, (t)object2);
    }

    @Override
    public boolean e(Object object, Object object2) {
        m m2 = (m)object;
        t t2 = (t)object2;
        return m2.a(t2);
    }

    @Override
    public Object c(Object object) {
        m m2 = (m)object;
        return m2.c();
    }

    @Override
    public Object d(Object object) {
        m m2 = (m)object;
        return m2.d();
    }

    @Override
    public Object f(Object object, Object object2) {
        m m2 = (m)object;
        m m3 = (m)object2;
        a a2 = new a(m2.c(), m2.d());
        a a3 = new a(m3.c(), m3.d());
        return a.a(a2, a3);
    }

    @Override
    public Object g(Object object, Object object2) {
        m m2 = (m)object;
        m m3 = (m)object2;
        return m.a(m2, m3);
    }

    @Override
    public Comparator b() {
        return new q();
    }

    @Override
    public Object i(Object object, Object object2) {
        t t2 = (t)object;
        t t3 = (t)object2;
        return new z(t3, t2);
    }

    @Override
    public double h(Object object, Object object2) {
        z z2 = (z)object;
        z z3 = (z)object2;
        return z.d(z2, z3);
    }

    @Override
    public Comparator c() {
        return this.c;
    }

    @Override
    public Comparator d() {
        return this.d;
    }

    @Override
    public Comparator e() {
        return this.e;
    }

    @Override
    public int c(Object object, Object object2, Object object3) {
        t t2 = (t)object;
        t t3 = (t)object2;
        t t4 = (t)object3;
        return this.a(t2.a(), t2.b(), t3.a(), t3.b(), t4.a(), t4.b());
    }

    public int a(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = (d6 -= d2) * (d5 -= d3) - (d7 -= d3) * (d4 -= d2);
        if (d8 < 0.0) {
            return 1;
        }
        if (d8 <= 0.0) return 0;
        return -1;
    }
}

