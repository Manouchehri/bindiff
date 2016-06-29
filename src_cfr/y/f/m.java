/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.c.D;
import y.d.n;
import y.d.q;
import y.f.N;
import y.f.ae;
import y.f.ai;
import y.f.aj;
import y.f.al;
import y.f.am;

public class M
implements al {
    @Override
    public Object c() {
        return new N(-20.0, -20.0);
    }

    @Override
    public n a(q q2, am am2, Object object) {
        N n2 = (N)object;
        double d2 = q2.b();
        return new n(n2.a - d2 * n2.c + am2.getX(), n2.b - d2 * n2.d + am2.getY(), q2.a(), d2, n2.c, n2.d);
    }

    @Override
    public D a(aj aj2, am am2) {
        D d2 = new D();
        d2.add(new ai(aj2.getOrientedBox(), aj2.getModelParameter(), aj2, false));
        return d2;
    }

    @Override
    public Object a(n n2, am am2) {
        if (ae.a(n2)) {
            throw new IllegalArgumentException(new StringBuffer().append("Invalid label bounds: ").append(n2).toString());
        }
        double d2 = n2.g();
        double d3 = n2.i();
        double d4 = n2.f();
        return new N(n2.b() + d4 * d2 - am2.getX(), n2.c() + d4 * d3 - am2.getY(), d2, d3);
    }
}

