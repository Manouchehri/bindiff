/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import y.c.A;
import y.c.a;
import y.c.b;
import y.c.c;
import y.c.h;
import y.g.Q;
import y.g.p;

public final class P
implements A,
h {
    private int a;
    private final a b;
    private final c c;
    private int d;
    private Integer e;

    public P(b b2, int n2) {
        this(b2, b2, n2);
    }

    public P(c c2, a a2, int n2) {
        this.c = c2;
        this.b = a2;
        this.a(n2);
    }

    public void a(int n2) {
        this.d = n2;
        this.e = new Integer(n2);
        ++this.a;
    }

    @Override
    public Object b(Object object) {
        Q q2 = (Q)this.c.b(object);
        if (q2 == null) {
            return this.e;
        }
        if (q2.a == this.a) return new Integer(q2.b);
        return this.e;
    }

    @Override
    public void a(Object object, Object object2) {
        this.a(object, ((Number)object2).intValue());
    }

    @Override
    public boolean d(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double c(Object object) {
        return this.a(object);
    }

    @Override
    public int a(Object object) {
        Q q2 = (Q)this.c.b(object);
        if (q2 == null) {
            return this.d;
        }
        if (q2.a == this.a) return q2.b;
        return this.d;
    }

    @Override
    public void a(Object object, boolean bl2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void a(Object object, double d2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void a(Object object, int n2) {
        Q q2 = (Q)this.c.b(object);
        if (q2 == null) {
            Q q3 = new Q();
            q3.b = n2;
            q3.a = this.a;
            this.b.a(object, q3);
            if (!p.c) return;
        }
        q2.b = n2;
        q2.a = this.a;
    }
}

