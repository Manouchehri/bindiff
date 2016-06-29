/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.a;

import y.c.C;
import y.c.D;
import y.f.f.a.a.e;

public class f
implements e {
    protected f b;
    protected D c;
    protected int d;
    public static boolean e;

    public f() {
        this(null);
    }

    public f(f f2) {
        this(f2, null);
    }

    public f(f f2, D d2) {
        this.b = f2;
        this.c = d2;
        if (this.e()) {
            this.d = 0;
            if (!e) return;
        }
        this.d = this.b.d + 1;
    }

    @Override
    public C a() {
        if (!this.d()) return this.c.m();
        this.c = new D();
        return this.c.m();
    }

    @Override
    public int b() {
        return this.d;
    }

    @Override
    public e c() {
        return this.b;
    }

    @Override
    public boolean d() {
        if (this.c == null) {
            return true;
        }
        if (this.c.size() != 0) return false;
        return true;
    }

    @Override
    public boolean e() {
        if (this.b != null) return false;
        return true;
    }

    public void a(f f2) {
        if (this.c == null) {
            this.c = new D();
        }
        this.c.add(f2);
    }

    public void f() {
        if (this.e()) return;
        f f2 = (f)this.c();
        f2.c.remove(this);
    }
}

