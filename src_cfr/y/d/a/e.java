/*
 * Decompiled with CFR 0_115.
 */
package y.d.a;

import y.c.p;
import y.c.q;
import y.d.a.b;

public class e {
    q a;
    p b;
    Object c;
    Object d;
    Object e;
    int f;
    Object g;
    e h;
    private final b i;

    public e(b b2, Object object, Object object2, Object object3, int n2) {
        this.i = b2;
        this.c = object;
        this.d = object2;
        this.f = n2;
        this.e = object3;
        this.g = b.a(b2).c(this.c, this.d);
        this.h = null;
    }

    public void a(e e2) {
        this.h = e2;
    }

    public void a(p p2) {
        this.b = p2;
    }

    public String toString() {
        return new StringBuffer().append(this.c).append(" ").append(this.d).toString();
    }

    public boolean a() {
        return this.c.equals(b.a(this.i).c(this.e));
    }

    public int b() {
        return this.f;
    }
}

