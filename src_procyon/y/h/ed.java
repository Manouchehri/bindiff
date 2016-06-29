package y.h;

import java.util.*;
import y.c.*;
import y.g.*;
import y.d.*;

class ed extends ez
{
    private final bu a;
    private final Collection b;
    private final Collection c;
    private final dU d;
    
    ed(final dU d, final bu a, final Collection b, final Collection c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    protected void a(final q q, final q q2, final boolean b, double min, double max) {
        final boolean z = fj.z;
        if (max - min < 10.0) {
            return;
        }
        final fj t = this.a.t(q);
        final double x = t.getX();
        final double n = x + t.getWidth();
        final double n2 = (x + n) * 0.5;
        final fj t2 = this.a.t(q2);
        final double x2 = t2.getX();
        final double n3 = x2 + t2.getWidth();
        min = Math.min(t.getY(), t2.getY());
        max = Math.max(t.getY() + t.getHeight(), t2.getY() + t2.getHeight());
        min -= dU.a(this.d);
        max += dU.a(this.d);
        final double max2 = Math.max(t.getY(), t2.getY());
        final double min2 = Math.min(t.getY() + t.getHeight(), t2.getY() + t2.getHeight());
        final Object a = am.a(q, b ? Boolean.TRUE : Boolean.FALSE);
        final Object a2 = am.a(q2, b ? Boolean.TRUE : Boolean.FALSE);
        Object o = null;
        Label_0285: {
            if (q.d() < q2.d()) {
                o = am.a(q, q2, b ? Boolean.TRUE : Boolean.FALSE);
                if (!z) {
                    break Label_0285;
                }
            }
            o = am.a(q2, q, b ? Boolean.TRUE : Boolean.FALSE);
        }
        final double n4 = (max2 + min2) * 0.5;
        if (n < x2) {
            if (dU.b(this.d)) {
                final er er = new er((byte)1, (byte)16, new t((n + x2) * 0.5, n4), min, max, o, 1.0, n, x2);
                this.b.add(er);
                this.c.add(er);
                this.b.add(new et((byte)1, (byte)4, new t(n3 + (x2 - n), n4), min, max, a2, 0.5, x2, n, n3));
                this.b.add(new et((byte)1, (byte)8, new t(x - (x2 - n), n4), min, max, a, 0.5, x2, n, x));
            }
            if (!dU.c(this.d)) {
                return;
            }
            final double n5 = (x2 + n3) * 0.5;
            this.b.add(new gy((byte)1, (byte)16, new t(n5 + n5 - n2, n4), min, max, a2, 0.1));
            this.b.add(new gy((byte)1, (byte)16, new t(n2 - (n5 - n2), n4), min, max, a, 0.1));
            this.b.add(new gy((byte)1, (byte)16, new t((n2 + n5) * 0.5, n4), min, max, o, 0.25));
            if (!z) {
                return;
            }
        }
        if (n3 < x) {
            if (dU.b(this.d)) {
                final er er2 = new er((byte)1, (byte)16, new t((n3 + x) * 0.5, n4), min, max, o, 1.0, n3, x);
                this.b.add(er2);
                this.c.add(er2);
                this.b.add(new et((byte)1, (byte)4, new t(n + (x - n3), n4), min, max, a, 0.5, x, n3, n));
                this.b.add(new et((byte)1, (byte)8, new t(x2 - (x - n3), n4), min, max, a2, 0.5, x, n3, x2));
            }
            if (dU.c(this.d)) {
                final double n6 = (x2 + n3) * 0.5;
                this.b.add(new gy((byte)1, (byte)16, new t(n2 + n2 - n6, n4), min, max, a, 0.1));
                this.b.add(new gy((byte)1, (byte)16, new t(n6 - (n2 - n6), n4), min, max, a2, 0.1));
                this.b.add(new gy((byte)1, (byte)16, new t((n2 + n6) * 0.5, n4), min, max, o, 0.25));
            }
        }
    }
}
