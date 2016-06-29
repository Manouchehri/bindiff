/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y.c.q;
import y.c.x;
import y.f.X;
import y.f.aj;
import y.f.i.a.I;
import y.f.i.a.K;
import y.f.i.a.N;
import y.f.i.a.R;
import y.f.i.a.T;
import y.f.i.a.Z;
import y.f.i.a.ab;
import y.f.i.a.bY;
import y.f.i.a.bZ;
import y.f.i.a.y;

class bX
extends K {
    boolean a;

    bX() {
    }

    @Override
    public void a(Z z2, I i2) {
        int n2 = ab.a;
        super.a(z2, i2);
        this.a = z2.c().i();
        if (!this.a) {
            return;
        }
        X x2 = z2.a();
        x x3 = x2.o();
        block0 : do {
            if (!x3.f()) return;
            q q2 = x3.e();
            aj[] arraj = x2.a_(q2);
            for (int i3 = 0; i3 < arraj.length; ++i3) {
                aj aj2 = arraj[i3];
                y.d.y y2 = bX.a(aj2);
                i2.a(y2, new bZ(aj2, null));
                if (n2 != 0) continue block0;
                if (n2 == 0) continue;
            }
            x3.g();
        } while (n2 == 0);
    }

    private static y.d.y a(aj aj2) {
        y.d.y y2 = aj2.getBox();
        return new y.d.y(y2.c() - 3.0, y2.d() - 3.0, y2.a() + 6.0, y2.b() + 6.0);
    }

    @Override
    public void b(R r2) {
        int n2 = ab.a;
        if (!this.a) return;
        Iterator iterator = this.b().e(r2).iterator();
        ArrayList<aj> arrayList = new ArrayList<aj>();
        while (iterator.hasNext()) {
            N n3 = (N)iterator.next();
            if (!(n3.b() instanceof bZ)) continue;
            arrayList.add(bZ.a((bZ)n3.b()));
            if (n2 != 0) return;
            if (n2 == 0) continue;
        }
        if (arrayList.size() <= 0) return;
        r2.a(T.c, arrayList);
    }
}

