/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import java.util.Collection;
import y.h.b.T;
import y.h.b.W;
import y.h.b.a;
import y.h.b.c;
import y.h.b.d;
import y.h.b.i;

final class V
implements W {
    private final c a;
    private final T b;

    V(T t2, c c2) {
        this.b = t2;
        this.a = c2;
    }

    @Override
    public boolean a() {
        return this.a.e();
    }

    @Override
    public void a(boolean bl2) {
        this.b.a(this.a, bl2);
    }

    @Override
    public boolean a(i i2) {
        return i2.b().isEmpty();
    }

    @Override
    public a b() {
        int n2 = a.H;
        d d2 = this.a.a();
        while (d2 instanceof c) {
            d2 = ((c)d2).a();
            if (n2 != 0) return null;
            if (n2 == 0) continue;
        }
        if (!(d2 instanceof i)) return null;
        return ((i)d2).a();
    }
}

