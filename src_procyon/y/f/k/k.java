package y.f.k;

import java.util.*;
import java.awt.geom.*;
import y.f.*;
import y.c.*;

class k extends m
{
    protected void a(final P p4, final List list, final Rectangle2D rectangle2D, final double n) {
        final int g = y.f.k.d.g;
        final l k = p4.k();
        final q i = p4.i().k();
        final O o = (O)i.e();
        double n2 = Double.MAX_VALUE;
        double n3 = -1.7976931348623157E308;
        y.c.d d = i.f();
        while (true) {
            while (d != null) {
                final T t = new T(l.a(k), o.a(d.d()));
                final double c = t.c();
                final double b = t.b();
                final double n4 = c;
                if (g != 0) {
                    p4.b(-p4.f() + ((n2 + n3) / 2.0 - n4 / 2.0));
                    return;
                }
                if (n4 < n2) {
                    n2 = c;
                }
                if (c + b > n3) {
                    n3 = c + b;
                }
                d = d.g();
                if (g != 0) {
                    break;
                }
            }
            p4.l();
            continue;
        }
    }
}
