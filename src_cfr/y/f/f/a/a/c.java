/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.a;

import y.c.C;
import y.f.f.a.a.d;
import y.f.f.a.a.e;
import y.f.f.a.a.f;
import y.f.f.a.a.j;

public abstract class c
implements e {
    protected f a;
    protected j b;

    public void a(f f2) {
        this.a = f2;
    }

    public void a(j j2) {
        this.b = j2;
    }

    @Override
    public C a() {
        C c2 = this.a.a();
        return new d(this, c2);
    }

    @Override
    public int b() {
        return this.a.b();
    }

    @Override
    public e c() {
        f f2 = (f)this.a.c();
        return (e)this.b.a(f2);
    }

    @Override
    public boolean d() {
        return this.a.d();
    }

    @Override
    public boolean e() {
        return this.a.e();
    }
}

