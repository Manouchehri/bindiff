/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import java.util.Set;
import y.c.c;

final class M
implements c {
    private Set a;

    M(Set set) {
        this.a = set;
    }

    @Override
    public Object b(Object object) {
        throw new UnsupportedOperationException("Objects not supported!");
    }

    @Override
    public boolean d(Object object) {
        return this.a.contains(object);
    }

    @Override
    public double c(Object object) {
        throw new UnsupportedOperationException("doubles not supported!");
    }

    @Override
    public int a(Object object) {
        throw new UnsupportedOperationException("ints not supported!");
    }
}

