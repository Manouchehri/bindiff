/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import y.f.c.a.bk;
import y.f.c.a.bt;
import y.h.b.F;

final class D
implements F {
    private final bk a;

    D(bk bk2) {
        this.a = bk2;
    }

    @Override
    public void a(Object object, boolean bl2) {
        ((bt)object).a(bl2);
    }

    @Override
    public double a(Object object) {
        return ((bt)object).b();
    }

    @Override
    public void a(Object object, double d2) {
        ((bt)object).a(d2);
    }

    @Override
    public double b(Object object) {
        return ((bt)object).c();
    }

    @Override
    public void b(Object object, double d2) {
        ((bt)object).b(d2);
    }

    @Override
    public double c(Object object) {
        return ((bt)object).d();
    }

    @Override
    public void c(Object object, double d2) {
        ((bt)object).c(d2);
    }

    @Override
    public Object a(int n2) {
        return this.a.a(n2);
    }

    @Override
    public int a() {
        return this.a.e().size();
    }
}

