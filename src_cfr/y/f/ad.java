/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import java.util.Collection;
import java.util.Comparator;
import y.c.D;
import y.c.d;
import y.c.p;
import y.f.X;
import y.f.aA;
import y.f.aB;
import y.f.ax;
import y.f.ay;
import y.f.az;

final class aD
implements az {
    D a;
    private final ay b;

    aD(ay ay2, Collection collection) {
        boolean bl2 = X.j;
        this.b = ay2;
        this.a = new D();
        for (aB aB2 : collection) {
            this.a.add(new aB(aB2));
            if (bl2) return;
            if (!bl2) continue;
        }
        this.a.sort(ay.b);
    }

    @Override
    public aA a(d d2, boolean bl2, int n2) {
        Object object;
        Object object2;
        Object object3;
        block4 : {
            boolean bl3 = X.j;
            if (this.a.isEmpty()) {
                throw new IllegalStateException("No candidates left");
            }
            object2 = null;
            double d3 = -1.7976931348623157E308;
            for (object = this.a.k(); object != null; object = object.a()) {
                aB aB2 = (aB)object.c();
                object3 = aB2.a;
                if (!bl3) {
                    double d4;
                    if (!object3.a(n2) || (d4 = this.b.a(aB2, d2, bl2)) <= d3) continue;
                    d3 = d4;
                    object2 = object;
                    if (!bl3) continue;
                }
                break block4;
            }
            if (object2 == null) {
                throw new IllegalStateException("No candidates left");
            }
            object3 = object2.c();
        }
        object = (aB)object3;
        --object.c;
        if (object.c > 0) return object;
        this.a.h((p)object2);
        return object;
    }
}

