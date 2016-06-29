/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import y.c.A;
import y.c.a;
import y.c.b;
import y.c.c;
import y.c.h;
import y.c.i;
import y.g.aq;
import y.g.p;

public class ap
implements c {
    private c a;
    private Object b;
    private i c;
    private c d;
    private b e;

    public ap(c c2, i i2, Object object) {
        this.d = c2;
        this.c(i2, object);
        this.a(c2);
    }

    public b a() {
        if (this.e != null) return this.e;
        throw new IllegalStateException("wrapper must be of type DataAcceptor");
    }

    private void a(c c2) {
        if (!(c2 instanceof a)) return;
        this.e = new aq(this);
    }

    public static ap a(i i2, Object object) {
        return new ap(i2.u(), i2, object);
    }

    public static ap b(i i2, Object object) {
        return new ap(i2.t(), i2, object);
    }

    public void c(i i2, Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Key must be non-null!");
        }
        this.a = i2.c(object);
        this.b = object;
        this.c = i2;
        if (this.a != null) {
            i2.d_(object);
            i2.a(object, this);
            if (!p.c) return;
        }
        i2.a(object, this.d);
    }

    public void b() {
        if (this.b == null) {
            throw new IllegalStateException("Provider must have been wrapped previously!");
        }
        c c2 = this.c.c(this.b);
        if (c2 != null) {
            this.c.d_(this.b);
        }
        if (this.a == null) return;
        this.c.a(this.b, this.a);
    }

    @Override
    public Object b(Object object) {
        Object object2 = this.d.b(object);
        if (object2 != null) {
            return object2;
        }
        if (this.a == null) return null;
        return this.a.b(object);
    }

    @Override
    public boolean d(Object object) {
        throw new UnsupportedOperationException("Object supported only!");
    }

    @Override
    public double c(Object object) {
        throw new UnsupportedOperationException("Object supported only!");
    }

    @Override
    public int a(Object object) {
        throw new UnsupportedOperationException("Object supported only!");
    }

    public c c() {
        return this.a;
    }

    public c d() {
        return this.d;
    }

    public void e() {
        this.b();
        if (this.d instanceof A) {
            this.c.a((A)this.d);
        }
        if (this.d instanceof h) {
            this.c.a((h)this.d);
        }
        this.d = null;
        this.a = null;
        this.c = null;
    }

    static c a(ap ap2) {
        return ap2.a;
    }

    static c b(ap ap2) {
        return ap2.d;
    }
}

