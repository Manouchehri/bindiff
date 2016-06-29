/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import y.c.f;
import y.f.f.a.a.h;
import y.f.f.a.a.m;
import y.f.f.a.a.p;
import y.f.f.a.b.F;
import y.f.f.a.b.G;
import y.f.f.a.b.H;
import y.f.f.a.b.i;

public class E {
    private y.c.i a;
    private p b;
    private i c;
    private f d;
    private int e;

    public E(y.c.i i2, p p2) {
        this.a = i2;
        this.b = p2;
        this.c = new i(this.a, this.b);
        this.d = new f();
    }

    public void a() {
        this.c.d();
    }

    public f b() {
        return this.d;
    }

    public static f a(y.c.i i2, p p2) {
        E e2 = new E(i2, p2);
        e2.c();
        e2.a();
        return e2.b();
    }

    public static boolean b(y.c.i i2, p p2) {
        E e2 = new E(i2, p2);
        boolean bl2 = e2.f();
        e2.a();
        return bl2;
    }

    private void c() {
        this.e = 0;
        this.d();
    }

    private void d() {
        this.d.clear();
        this.c.h();
        this.c.e();
        this.e();
        this.c.i();
    }

    private void e() {
        this.c.f();
        m.a((h)new H(this, null), this.c);
        this.c.g();
    }

    private boolean f() {
        this.c.h();
        this.c.e();
        this.c.f();
        G g2 = new G(this, null);
        m.a((h)g2, this.c);
        this.c.g();
        this.c.i();
        return g2.b;
    }

    static y.c.i a(E e2) {
        return e2.a;
    }

    static int b(E e2) {
        return e2.e;
    }

    static f c(E e2) {
        return e2.d;
    }
}

