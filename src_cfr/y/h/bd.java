/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.Map;
import y.c.d;
import y.c.i;
import y.c.m;
import y.c.q;
import y.f.Y;
import y.g.C;
import y.h.aB;
import y.h.bu;
import y.h.fj;

public class bD
implements m,
C {
    private static final C a = new Y();

    @Override
    public i a(Object object) {
        if (!(object instanceof bu)) return new bu();
        return new bu((bu)object);
    }

    @Override
    public q a(i i2, Object object) {
        if (!(object instanceof q)) return i2.d();
        q q2 = (q)object;
        if (!(q2.e() instanceof bu)) return i2.d();
        bu bu2 = (bu)q2.e();
        return ((bu)i2).a(this.a(bu2.t(q2)));
    }

    protected aB a(aB aB2) {
        return aB2.createCopy();
    }

    @Override
    public q a(i i2, q q2) {
        i i3 = q2.e();
        if (!(i3 instanceof bu)) return a.a(i2, q2);
        bu bu2 = (bu)i2;
        return bu2.a(this.a(((bu)i3).t(q2)));
    }

    protected fj a(fj fj2) {
        return fj2.createCopy();
    }

    @Override
    public d a(i i2, q q2, q q3, d d2) {
        i i3 = d2.a();
        if (!(i3 instanceof bu)) return a.a(i2, q2, q3, d2);
        return ((bu)i2).a(q2, q3, this.a(((bu)i3).i(d2)));
    }

    @Override
    public void a(i i2, i i3) {
    }

    @Override
    public void a(i i2, i i3, Map map, Map map2) {
    }
}

