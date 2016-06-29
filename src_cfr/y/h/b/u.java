/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import java.util.Collection;
import y.h.b.T;
import y.h.b.W;
import y.h.b.a;
import y.h.b.f;
import y.h.b.g;
import y.h.b.i;

final class U
implements W {
    private final f a;
    private final T b;

    U(T t2, f f2) {
        this.b = t2;
        this.a = f2;
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
        return i2.c().isEmpty();
    }

    @Override
    public a b() {
        int n2 = a.H;
        g g2 = this.a.a();
        while (g2 instanceof f) {
            g2 = ((f)g2).a();
            if (n2 != 0) return null;
            if (n2 == 0) continue;
        }
        if (!(g2 instanceof i)) return null;
        return ((i)g2).a();
    }
}

