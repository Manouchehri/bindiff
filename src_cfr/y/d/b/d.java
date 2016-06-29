/*
 * Decompiled with CFR 0_115.
 */
package y.d.b;

import java.util.Comparator;
import y.d.b.a;
import y.d.b.b;
import y.d.b.c;
import y.d.b.e;
import y.d.b.f;
import y.d.b.g;
import y.d.b.h;
import y.d.b.i;
import y.d.b.j;
import y.d.b.k;
import y.d.b.m;
import y.d.b.t;
import y.d.b.y;
import y.d.b.z;

public class d
extends c {
    private static d i = new d();
    public static int b = 0;
    public static int c = 0;
    public static int d = 0;
    public static int e = 0;
    protected boolean f = true;
    protected boolean g = true;
    protected static final double h = Math.pow(0.5, 52.0);
    private Comparator j;
    private Comparator k;
    private Comparator l;
    private Comparator m;
    private Comparator n;
    private Comparator o;
    private Comparator p;

    public d() {
        this.j = new h(this);
        this.k = new g(this);
        this.l = new e(this);
        this.m = new j(this);
        this.n = new f(this);
        this.o = new k(this);
        this.p = new i(this);
    }

    public static d a() {
        return i;
    }

    @Override
    public Object c(Object object, Object object2) {
        return new m((b)object, (b)object2, this);
    }

    public boolean d(Object object, Object object2) {
        a a2 = (a)object;
        if (a2.b(object2) <= 0) return false;
        return true;
    }

    @Override
    public boolean b(Object object, Object object2) {
        m m2 = (m)object;
        b b2 = (b)object2;
        return m2.b(b2);
    }

    @Override
    public boolean e(Object object, Object object2) {
        m m2 = (m)object;
        b b2 = (b)object2;
        return m2.a(b2);
    }

    @Override
    public Object f(Object object, Object object2) {
        m m2 = (m)object;
        m m3 = (m)object2;
        return m2.b(m3);
    }

    @Override
    public Object g(Object object, Object object2) {
        m m2 = (m)object;
        m m3 = (m)object2;
        return m2.a(m3);
    }

    @Override
    public Object c(Object object) {
        return ((m)object).a();
    }

    @Override
    public Object d(Object object) {
        return ((m)object).b();
    }

    public z e(Object object) {
        return ((b)object).a();
    }

    public z f(Object object) {
        return ((b)object).b();
    }

    public z g(Object object) {
        return ((b)object).c();
    }

    public double h(Object object) {
        return ((b)object).d();
    }

    public double i(Object object) {
        return ((b)object).e();
    }

    public double j(Object object) {
        return ((b)object).f();
    }

    @Override
    public z k(Object object) {
        return new y(this.h(object) / this.j(object));
    }

    @Override
    public z l(Object object) {
        return new y(this.i(object) / this.j(object));
    }

    @Override
    public Comparator b() {
        return this.p;
    }

    @Override
    public double h(Object object, Object object2) {
        t t2 = (t)object;
        t t3 = (t)object2;
        return t2.a(t3);
    }

    @Override
    public Object i(Object object, Object object2) {
        b b2 = (b)object;
        b b3 = (b)object2;
        return b3.a(b2);
    }

    @Override
    public Comparator c() {
        if (!this.f) return this.k;
        return this.j;
    }

    @Override
    public Comparator d() {
        if (!this.f) return this.m;
        return this.l;
    }

    @Override
    public Comparator e() {
        if (!this.f) return this.o;
        return this.n;
    }

    @Override
    public int c(Object object, Object object2, Object object3) {
        if (!this.g) return this.d(object, object2, object3);
        ++e;
        double d2 = this.h(object);
        double d3 = this.i(object);
        double d4 = this.j(object);
        double d5 = this.h(object2);
        double d6 = this.i(object2);
        double d7 = this.j(object2);
        double d8 = this.h(object3);
        double d9 = this.i(object3);
        double d10 = this.j(object3);
        double d11 = d3 * d7;
        double d12 = d6 * d4;
        double d13 = d2 * d10;
        double d14 = d8 * d4;
        double d15 = d2 * d7;
        double d16 = d5 * d4;
        double d17 = d3 * d10;
        double d18 = d9 * d4;
        double d19 = (d15 - d16) * (d17 - d18) - (d11 - d12) * (d13 - d14);
        double d20 = 40.0 * (((d11 = Math.abs(d11)) + (d12 = Math.abs(d12))) * ((d13 = Math.abs(d13)) + (d14 = Math.abs(d14))) + ((d15 = Math.abs(d15)) + (d16 = Math.abs(d16))) * ((d17 = Math.abs(d17)) + (d18 = Math.abs(d18)))) * h;
        if (d19 > d20) {
            return 1;
        }
        if (d19 < - d20) {
            return -1;
        }
        if (d20 < 1.0) {
            return 0;
        }
        --e;
        return this.d(object, object2, object3);
    }

    protected int j(Object object, Object object2) {
        int n2;
        m m2 = (m)object;
        m m3 = (m)object2;
        z z2 = m2.c();
        z z3 = m3.c();
        z z4 = m2.d();
        z z5 = m3.d();
        z z6 = z2.a();
        boolean bl2 = m2.equals(z6);
        boolean bl3 = m3.equals(z6);
        if (bl3 || bl2) {
            if (bl3 && bl2) {
                return 0;
            }
            if (!bl3) return 1;
            return -1;
        }
        z z7 = z4.c(z3).b(z5.c(z2));
        int n3 = z7.c();
        if (z2.c() * z3.c() < 0) {
            n2 = - n3;
            return n2;
        }
        n2 = n3;
        return n2;
    }

    protected int d(Object object, Object object2, Object object3) {
        ++d;
        z z2 = this.e(object);
        z z3 = this.f(object);
        z z4 = this.g(object);
        z z5 = this.e(object2);
        z z6 = this.f(object2);
        z z7 = this.g(object2);
        z z8 = this.e(object3);
        z z9 = this.f(object3);
        z z10 = this.g(object3);
        z z11 = d.b(d.a(z5, z4), d.a(z2, z7));
        z z12 = d.b(d.a(z6, z4), d.a(z3, z7));
        z z13 = d.b(d.a(z12, d.b(d.a(z2, z10), d.a(z8, z4))), d.a(z11, d.b(d.a(z3, z10), d.a(z9, z4))));
        return z13.c();
    }

    protected int k(Object object, Object object2) {
        z z2;
        ++b;
        z z3 = d.a(this.e(object), this.g(object2));
        if (z3.f(z2 = d.a(this.e(object2), this.g(object))) < 0) {
            return -1;
        }
        if (z3.f(z2) <= 0) return 0;
        return 1;
    }

    protected int l(Object object, Object object2) {
        z z2;
        ++b;
        z z3 = d.a(this.f(object), this.g(object2));
        if (z3.f(z2 = d.a(this.f(object2), this.g(object))) < 0) {
            return -1;
        }
        if (z3.f(z2) <= 0) return 0;
        return 1;
    }

    protected int m(Object object, Object object2) {
        z z2;
        z z3;
        ++b;
        z z4 = d.a(this.e(object), this.g(object2));
        if (z4.f(z3 = d.a(this.e(object2), this.g(object))) < 0) {
            return -1;
        }
        if (z4.f(z3) > 0) {
            return 1;
        }
        z z5 = d.a(this.f(object), this.g(object2));
        if (z5.f(z2 = d.a(this.f(object2), this.g(object))) < 0) {
            return -1;
        }
        if (z5.f(z2) <= 0) return 0;
        return 1;
    }

    private static z a(z z2, z z3) {
        return z2.c(z3);
    }

    private static z b(z z2, z z3) {
        return z2.b(z3);
    }
}

