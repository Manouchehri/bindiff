package y.d;

import y.g.*;
import java.util.*;
import y.c.*;

public class f
{
    public static void a(final D d, final g g) {
        final boolean d2 = t.d;
        final k[] a = a(d);
        final al al = new al();
        double min = Double.MAX_VALUE;
        double max = -1.7976931348623157E308;
        p p2 = d.k();
        while (p2 != null) {
            final y h = ((o)p2.c()).h();
            final double b = h.b;
            if (b >= 0.0) {
                min = Math.min(min, h.d);
                max = Math.max(max, h.d + b);
            }
            p2 = p2.a();
            if (d2) {
                break;
            }
        }
        final l l = new l(min, max, 15);
        final al al2 = new al();
        int i = 0;
        while (i < a.length) {
            final k k = a[i];
            Label_0204: {
                switch (k.b) {
                    case 0: {
                        l.a(k.c, g);
                        l.a(k.c);
                        if (d2) {
                            break Label_0204;
                        }
                        break;
                    }
                    case 1: {
                        l.b(k.c);
                        break;
                    }
                }
            }
            ++i;
            if (d2) {
                break;
            }
        }
    }
    
    static k[] a(final D d) {
        final boolean d2 = t.d;
        final D d3 = new D();
        final C m = d.m();
        while (true) {
            while (m.f()) {
                final o o = (o)m.d();
                final y h = o.h();
                final double b = h.b;
                final double a = h.a;
                final double n = dcmpg(b, 0.0);
                if (d2) {
                    final k[] array = new k[n];
                    d3.toArray(array);
                    e.a(array, new i());
                    return array;
                }
                if (n >= 0) {
                    if (a >= 0.0) {
                        final h h2 = new h(h.d, h.d + b, o);
                        final k k = new k(h.c, 0, h2);
                        final k i = new k(h.c + a, 1, h2);
                        d3.add(k);
                        d3.add(i);
                    }
                }
                m.g();
                if (d2) {
                    break;
                }
            }
            d3.size();
            continue;
        }
    }
}
