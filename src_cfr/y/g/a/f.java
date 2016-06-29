/*
 * Decompiled with CFR 0_115.
 */
package y.g.a;

import y.c.a;
import y.c.c;
import y.g.a.n;
import y.g.a.o;

public class f {
    private n a;
    private c b;
    private a c;

    public f(int n2, c c2, a a2) {
        this.b = c2;
        this.c = a2;
        this.a = new n(n2);
    }

    public void a(Object object, double d2) {
        o o2 = this.a.a(d2, object);
        this.c.a(object, o2);
    }

    public void b(Object object, double d2) {
        o o2 = (o)this.b.b(object);
        this.a.a(o2, d2);
    }

    public void c(Object object, double d2) {
        o o2 = (o)this.b.b(object);
        this.a.c(o2, d2);
    }

    public Object a() {
        o o2 = this.a.b();
        this.a.a(o2);
        Object object = o2.b;
        this.c.a(object, null);
        return object;
    }

    public double b() {
        return this.a.b().a;
    }

    public boolean c() {
        return this.a.c();
    }

    public double a(Object object) {
        o o2 = (o)this.b.b(object);
        return o2.a;
    }

    public void b(Object object) {
        o o2 = (o)this.b.b(object);
        this.a.a(o2);
        this.c.a(object, null);
    }

    public void d() {
        this.b = null;
        this.c = null;
        this.a = null;
    }
}

