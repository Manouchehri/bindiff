/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import java.util.Map;
import y.c.d;
import y.c.i;
import y.c.k;
import y.c.q;
import y.d.n;
import y.d.t;
import y.f.C;
import y.f.D;
import y.f.E;
import y.f.I;
import y.f.X;
import y.f.aG;
import y.f.aj;
import y.f.ak;
import y.f.al;
import y.f.am;
import y.f.w;

public class Y
implements y.g.C {
    private static final y.g.C a = new k();

    @Override
    public q a(i i2, q q2) {
        i i3 = q2.e();
        if (!(i3 instanceof X)) return a.a(i2, q2);
        X x2 = (X)i3;
        am am2 = x2.h(q2);
        q q3 = i2.d();
        X x3 = (X)i2;
        am am3 = x3.h(q3);
        am3.setSize(am2.getWidth(), am2.getHeight());
        am3.setLocation(am2.getX(), am2.getY());
        this.a(x2, q2, x3, q3);
        return q3;
    }

    protected void a(X x2, q q2, X x3, q q3) {
        boolean bl2 = X.j;
        if (!(x3 instanceof w)) return;
        aj[] arraj = x2.i(q2);
        w w2 = (w)x3;
        aj[] arraj2 = new aj[arraj.length];
        for (int i2 = 0; i2 < arraj.length; ++i2) {
            aj aj2 = arraj[i2];
            arraj2[i2] = this.a(aj2);
            if (bl2) return;
            if (!bl2) continue;
        }
        w2.a(q3, arraj2);
    }

    protected aj a(aj aj2) {
        ak ak2 = new ak();
        ak2.a(aj2.a());
        ak2.setModelParameter(aj2.getModelParameter());
        ak2.a(aj2.getOrientedBox());
        return ak2;
    }

    @Override
    public d a(i i2, q q2, q q3, d d2) {
        boolean bl2 = X.j;
        i i3 = d2.a();
        if (!(i3 instanceof X)) return a.a(i2, q2, q3, d2);
        X x2 = (X)i2;
        d d3 = x2.a(q2, q3);
        I i4 = x2.g(d3);
        X x3 = (X)i3;
        I i5 = x3.g(d2);
        i4.setSourcePoint(i5.getSourcePoint());
        i4.setTargetPoint(i5.getTargetPoint());
        for (int i6 = 0; i6 < i5.pointCount(); ++i6) {
            t t2 = i5.getPoint(i6);
            i4.addPoint(t2.a(), t2.b());
            if (bl2) return d3;
            if (!bl2) continue;
        }
        this.a(x3, d2, x2, d3);
        return d3;
    }

    protected void a(X x2, d d2, X x3, d d3) {
        boolean bl2 = X.j;
        if (!(x3 instanceof w)) return;
        C[] arrc = x2.h(d2);
        w w2 = (w)x3;
        C[] arrc2 = new C[arrc.length];
        for (int i2 = 0; i2 < arrc.length; ++i2) {
            C c2 = arrc[i2];
            arrc2[i2] = this.a(c2);
            if (bl2) return;
            if (!bl2) continue;
        }
        w2.a(d3, arrc2);
    }

    protected C a(C c2) {
        D d2 = new D();
        d2.a(c2.getLabelModel());
        d2.setModelParameter(c2.getModelParameter());
        d2.a(c2.getPreferredPlacementDescriptor());
        d2.a(c2.getOrientedBox());
        return d2;
    }

    @Override
    public void a(i i2, i i3) {
    }

    @Override
    public void a(i i2, i i3, Map map, Map map2) {
    }
}

