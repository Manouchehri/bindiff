package y.a;

import java.util.*;
import y.c.*;

public class y
{
    public static f a(final i i, final c c) {
        return b(i, c);
    }
    
    public static f b(final i i, final c c) {
        final boolean a = h.a;
        final f f = new f();
        final y.g.a.c c2 = new y.g.a.c(i);
        final double[] array = new double[i.e()];
        Arrays.fill(array, Double.POSITIVE_INFINITY);
        final d[] array2 = new d[i.e()];
        final x o = i.o();
    Label_0326:
        while (true) {
            while (o.f()) {
                c2.a(o.e(), Double.POSITIVE_INFINITY);
                o.g();
                if (a) {
                    return f;
                }
                if (a) {
                    break;
                }
            }
        Label_0096:
            while (true) {
                double b = c2.b() ? 1 : 0;
            Label_0102:
                while (b == 0) {
                    final q a2 = c2.a();
                    final int d = a2.d();
                    if (array[d] != Double.POSITIVE_INFINITY) {
                        f.add(array2[d]);
                    }
                    array[d] = Double.NEGATIVE_INFINITY;
                    d d2 = a2.f();
                    while (d2 != null) {
                        final q d3 = d2.d();
                        final int d4 = d3.d();
                        final double c3 = c.c(d2);
                        final double n = b = dcmpg(c3, array[d4]);
                        if (a) {
                            continue Label_0102;
                        }
                        if (n < 0) {
                            c2.b(d3, c3);
                            array[d4] = c3;
                            array2[d4] = d2;
                        }
                        d2 = d2.g();
                        if (a) {
                            break;
                        }
                    }
                    d d5 = a2.g();
                    while (d5 != null) {
                        final q c4 = d5.c();
                        final int d6 = c4.d();
                        final double c5 = c.c(d5);
                        final double n2 = b = dcmpg(c5, array[d6]);
                        if (a) {
                            continue Label_0102;
                        }
                        if (n2 < 0) {
                            c2.b(c4, c5);
                            array[d6] = c5;
                            array2[d6] = d5;
                        }
                        d5 = d5.h();
                        if (a) {
                            continue Label_0326;
                        }
                    }
                    continue Label_0096;
                }
                return f;
            }
            break;
        }
    }
    
    public static f a(final i i) {
        final boolean a = h.a;
        final f f = new f();
        final Q q = new Q(i);
        final e p = i.p();
        while (p.f()) {
            final d a2 = p.a();
            final q c = a2.c();
            final q d = a2.d();
            if (!q.b(c, d)) {
                f.add(a2);
                q.a(c, d);
            }
            p.g();
            if (a) {
                break;
            }
        }
        return f;
    }
}
