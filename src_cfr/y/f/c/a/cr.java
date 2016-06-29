/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.d;
import y.c.q;
import y.d.t;
import y.f.X;
import y.f.aE;
import y.f.c.a.A;
import y.f.c.a.N;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.g.e;

final class cR
implements Comparator {
    private final aV a;
    private final X b;
    private final aU c;

    public cR(X x2, aU aU2, aV aV2) {
        this.b = x2;
        this.a = aV2;
        this.c = aU2;
    }

    final float a(d d2) {
        float f2;
        boolean bl2 = N.x;
        aE aE2 = this.a.a(d2).c();
        t t2 = this.b.n(d2);
        if (aE2 == null || aE2.g()) {
            f2 = (float)(t2.a / 10000.0);
            if (!bl2) return (float)this.a.a(d2.c()).k() + f2;
        }
        switch (aE2.b()) {
            case 4: {
                f2 = 0.3f - (float)(t2.b / 10000.0);
                if (!bl2) return (float)this.a.a(d2.c()).k() + f2;
            }
            case 8: {
                f2 = -0.3f + (float)(t2.b / 10000.0);
                if (!bl2) return (float)this.a.a(d2.c()).k() + f2;
            }
        }
        f2 = (float)(t2.a / 10000.0);
        return (float)this.a.a(d2.c()).k() + f2;
    }

    public int compare(Object object, Object object2) {
        d d2 = (d)object;
        d d3 = (d)object2;
        byte by2 = this.a.a(d2.d()).b();
        if (by2 != 12) {
            if (by2 != 13) return e.a(this.a(d2), this.a(d3));
        }
        boolean bl2 = by2 == 12;
        aX aX2 = this.a.a(d2.c());
        aX aX3 = this.a.a(d3.c());
        if (by2 == aX2.b() && by2 != aX3.b()) {
            if (!bl2) return 1;
            return -1;
        }
        if (by2 == aX2.b()) return e.a(this.a(d2), this.a(d3));
        if (by2 != aX3.b()) return e.a(this.a(d2), this.a(d3));
        if (!bl2) return -1;
        return 1;
    }
}

