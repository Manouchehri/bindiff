/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import y.c.A;
import y.c.a;
import y.c.b;
import y.c.c;
import y.c.h;
import y.g.O;
import y.g.p;

public final class N
implements A,
h {
    private int a;
    private final c b;
    private final a c;
    private double d;
    private Double e;

    public N(b b2, double d2) {
        this(b2, b2, d2);
    }

    public N(c c2, a a2, double d2) {
        this.b = c2;
        this.c = a2;
        this.a(d2);
    }

    public void a(double d2) {
        this.d = d2;
        this.e = new Double(d2);
        ++this.a;
    }

    @Override
    public Object b(Object object) {
        O o2 = (O)this.b.b(object);
        if (o2 == null) {
            return this.e;
        }
        if (o2.a == this.a) return new Double(o2.b);
        return this.e;
    }

    @Override
    public void a(Object object, Object object2) {
        this.a(object, ((Number)object2).doubleValue());
    }

    @Override
    public boolean d(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double c(Object object) {
        O o2 = (O)this.b.b(object);
        if (o2 == null) {
            return this.d;
        }
        if (o2.a == this.a) return o2.b;
        return this.d;
    }

    @Override
    public int a(Object object) {
        return (int)Math.rint(this.c(object));
    }

    @Override
    public void a(Object object, boolean bl2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void a(Object object, double d2) {
        O o2 = (O)this.b.b(object);
        if (o2 == null) {
            O o3 = new O();
            o3.b = d2;
            o3.a = this.a;
            this.c.a(object, o3);
            if (!p.c) return;
        }
        o2.b = d2;
        o2.a = this.a;
    }

    @Override
    public void a(Object object, int n2) {
        this.a(object, (double)n2);
    }
}

