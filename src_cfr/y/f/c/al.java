/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Set;
import y.c.h;
import y.f.c.a;

final class al
implements h {
    private final Set a;

    al(Set set) {
        this.a = set;
    }

    @Override
    public Object b(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void a(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void a(Object object, boolean bl2) {
        if (bl2) {
            this.a.add(object);
            if (!a.i) return;
        }
        this.a.remove(object);
    }

    @Override
    public boolean d(Object object) {
        return this.a.contains(object);
    }

    @Override
    public void a(Object object, double d2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double c(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void a(Object object, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int a(Object object) {
        throw new UnsupportedOperationException();
    }
}

