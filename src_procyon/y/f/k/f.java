package y.f.k;

import java.util.*;
import java.awt.geom.*;
import y.f.*;
import y.c.*;

class f extends m
{
    protected void a(final P p4, final List list, final Rectangle2D rectangle2D, final double n) {
        final q k = p4.i().k();
        final O o = (O)k.e();
        double b = 0.0;
        Label_0119: {
            if (list.size() % 2 == 0) {
                b = (list.get(list.size() / 2).b() + list.get(list.size() / 2 - 1).b()) / 2.0;
                if (y.f.k.d.g == 0) {
                    break Label_0119;
                }
            }
            b = list.get(list.size() / 2).b();
        }
        p4.b(-new T(p4.k().a(), o.a(k)).e() + b);
    }
}
