package y.h;

import java.util.*;
import y.c.*;
import y.g.*;
import y.d.*;

class ee extends ez
{
    private final bu a;
    private final Collection b;
    private final Collection c;
    private final dU d;
    
    ee(final dU d, final bu a, final Collection b, final Collection c) {
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
        final double y = t.getY();
        final double n = y + t.getHeight();
        final double n2 = (y + n) * 0.5;
        final fj t2 = this.a.t(q2);
        final double y2 = t2.getY();
        final double n3 = y2 + t2.getHeight();
        min = Math.min(t.getX(), t2.getX());
        max = Math.max(t.getX() + t.getWidth(), t2.getX() + t2.getWidth());
        min -= dU.a(this.d);
        max += dU.a(this.d);
        final double max2 = Math.max(t.getX(), t2.getX());
        final double min2 = Math.min(t.getX() + t.getWidth(), t2.getX() + t2.getWidth());
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
        if (n < y2) {
            if (dU.b(this.d)) {
                final er er = new er((byte)0, (byte)16, new t(n4, (n + y2) * 0.5), min, max, o, 1.0, n, y2);
                this.b.add(er);
                this.c.add(er);
                this.b.add(new et((byte)0, (byte)1, new t(n4, n3 + (y2 - n)), min, max, a2, 0.5, y2, n, n3));
                this.b.add(new et((byte)0, (byte)2, new t(n4, y - (y2 - n)), min, max, a, 0.5, y2, n, y));
            }
            if (!dU.c(this.d)) {
                return;
            }
            final double n5 = (y2 + n3) * 0.5;
            this.b.add(new gy((byte)0, (byte)16, new t(n4, n5 + n5 - n2), min, max, a2, 0.1));
            this.b.add(new gy((byte)0, (byte)16, new t(n4, n2 - (n5 - n2)), min, max, a, 0.1));
            this.b.add(new gy((byte)0, (byte)16, new t(n4, (n2 + n5) * 0.5), min, max, o, 0.25));
            if (!z) {
                return;
            }
        }
        if (n3 < y) {
            if (dU.b(this.d)) {
                final er er2 = new er((byte)0, (byte)16, new t(n4, (n3 + y) * 0.5), min, max, o, 1.0, n3, y);
                this.b.add(er2);
                this.c.add(er2);
                this.b.add(new et((byte)0, (byte)1, new t(n4, n + (y - n3)), min, max, a, 0.5, y, n3, n));
                this.b.add(new et((byte)0, (byte)2, new t(n4, y2 - (y - n3)), min, max, a2, 0.5, y, n3, y2));
            }
            if (dU.c(this.d)) {
                final double n6 = (y2 + n3) * 0.5;
                this.b.add(new gy((byte)0, (byte)16, new t(n4, n2 + n2 - n6), min, max, a, 0.1));
                this.b.add(new gy((byte)0, (byte)16, new t(n4, n6 - (n2 - n6)), min, max, a2, 0.1));
                this.b.add(new gy((byte)0, (byte)16, new t(n4, (n2 + n6) * 0.5), min, max, o, 0.25));
            }
        }
    }
}
