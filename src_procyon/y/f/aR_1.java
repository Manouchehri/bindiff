package y.f;

import y.g.*;
import y.c.*;
import java.util.*;

public class aR
{
    public static void a(final i i, final c c, final int n, final int n2) {
        final boolean j = X.j;
        if (i == null || c == null) {
            return;
        }
        final i k = new i();
        final h u = k.u();
        final A t = k.t();
        a(k, u, i, c, t, n2);
        final int[] array = new int[k.f()];
        final int[] array2 = new int[k.f()];
        double n3 = Double.MAX_VALUE;
        final ar ar = new ar(7L);
        final A a = M.a(new boolean[k.f()]);
        final y y = new y();
        final y y2 = new y();
        final x o = k.o();
        while (o.f()) {
            final q e = o.e();
            Label_0203: {
                if (((aT)t.b(e)).b()) {
                    y.add(e);
                    a.a(e, false);
                    if (!j) {
                        break Label_0203;
                    }
                }
                y2.add(e);
                a.a(e, true);
            }
            o.g();
            if (j) {
                break;
            }
        }
        final q[] e2 = y.e();
        final q[] e3 = y2.e();
        e.a(e3, new aS(t));
        q[] array3 = a(e2, e3, ar);
        int l = 0;
    Label_0265:
        while (l < n) {
            int n4 = 0;
            while (n4 < array3.length) {
                array[array3[n4].d()] = n4;
                ++n4;
                if (j) {
                    continue Label_0265;
                }
                if (j) {
                    break;
                }
            }
            double a2 = a(k, u, array);
            double n7 = 0.0;
        Label_0319:
            while (true) {
                while (true) {
                    int n5 = 1;
                Label_0325:
                    while (true) {
                        double n6 = n5;
                        do {
                            final boolean d;
                            if (n6 < array3.length) {
                                d = a.d(array3[n5 - 1]);
                                if (!j) {
                                    if (!d || !a.d(array3[n5])) {
                                        final double a3 = a(array3[n5 - 1], array3[n5], array, u);
                                        if (a3 < 0.0) {
                                            final int[] array4 = array;
                                            final int d2 = array3[n5 - 1].d();
                                            ++array4[d2];
                                            final int[] array5 = array;
                                            final int d3 = array3[n5].d();
                                            --array5[d3];
                                            final q q = array3[n5 - 1];
                                            array3[n5 - 1] = array3[n5];
                                            array3[n5] = q;
                                            a2 += a3;
                                        }
                                    }
                                    ++n5;
                                    if (!j) {
                                        continue Label_0325;
                                    }
                                }
                            }
                            if (d) {
                                continue Label_0319;
                            }
                            n7 = (n6 = dcmpl(n3, a2));
                        } while (j);
                        break Label_0319;
                    }
                }
                break;
            }
            Label_0546: {
                if (n7 > 0) {
                    int n8 = 0;
                    while (n8 < array.length) {
                        array2[n8] = array[n8];
                        ++n8;
                        if (j) {
                            break Label_0546;
                        }
                        if (j) {
                            break;
                        }
                    }
                    n3 = a2;
                }
                array3 = a(e2, e3, ar);
                ++l;
            }
            if (j) {
                break;
            }
        }
        final x o2 = k.o();
        while (o2.f()) {
            final q e4 = o2.e();
            ((aT)t.b(e4)).a(array2[e4.d()]);
            o2.g();
            if (j) {
                return;
            }
            if (j) {
                break;
            }
        }
        k.a(t);
        k.a(u);
        k.j();
    }
    
    private static q[] a(final q[] array, final q[] array2, final ar ar) {
        final boolean j = X.j;
        ar.a(array);
        final q[] array3 = new q[array.length + array2.length];
        int n = 0;
        int n2 = 0;
        int i = 0;
        while (i < array3.length) {
            final q[] array4 = array;
            if (j) {
                return array4;
            }
            Label_0094: {
                if (ar.nextInt(array.length - n + array2.length - n2) < array.length - n) {
                    array3[i] = array[n++];
                    if (!j) {
                        break Label_0094;
                    }
                }
                array3[i] = array2[n2++];
            }
            ++i;
            if (j) {
                break;
            }
        }
        return array3;
    }
    
    private static void a(final i i, final h h, final i j, final c c, final A a, final int n) {
        final boolean k = X.j;
        final HashMap hashMap = new HashMap<Object, q>();
        final x o = j.o();
        while (o.f()) {
            final Object b = c.b(o.e());
            if (b != null && !hashMap.containsKey(b)) {
                final q d = i.d();
                hashMap.put(b, d);
                a.a(d, b);
            }
            o.g();
            if (k) {
                break;
            }
        }
        final d[][] array = new d[i.f()][i.f()];
        if (n == 1 || n == 2) {
            b(j, i, c, hashMap, h, array);
        }
        if (n == 0 || n == 2) {
            a(j, i, c, hashMap, h, array);
        }
    }
    
    private static void a(final i i, final i j, final c c, final Map map, final h h, final d[][] array) {
        final boolean k = X.j;
        final q[] m = j.m();
        final y.c.e p6 = i.p();
        while (p6.f()) {
            final d a = p6.a();
            final Object b = c.b(a.c());
            final Object b2 = c.b(a.d());
            Label_0221: {
                if (b != null && b2 != null) {
                    final q q = map.get(b);
                    final q q2 = map.get(b2);
                    if (q != q2) {
                        final int min = Math.min(q.d(), q2.d());
                        final int max = Math.max(q.d(), q2.d());
                        if (array[min][max] == null) {
                            h.a(array[min][max] = j.a(m[min], m[max]), 1);
                            if (!k) {
                                break Label_0221;
                            }
                        }
                        final d d = array[min][max];
                        h.a(d, h.a(d) + 1);
                    }
                }
            }
            p6.g();
            if (k) {
                break;
            }
        }
    }
    
    private static void b(final i i, final i j, final c c, final Map map, final h h, final d[][] array) {
        final boolean k = X.j;
        if (!y.f.b.c.b(i)) {
            return;
        }
        final y.f.b.c c2 = new y.f.b.c(i);
        final A t = j.t();
        final x o = i.o();
    Label_0468:
        do {
            o.f();
            int l = 0;
        Label_0042:
            while (l != 0) {
                final q e = o.e();
                if (!k) {
                    if (c2.d(e)) {
                        final y y = new y();
                        final x a = c2.c(e).a();
                        while (a.f()) {
                            final q e2 = a.e();
                            final boolean d;
                            final boolean b = d = c2.d(e2);
                            if (k) {
                                continue Label_0042;
                            }
                            if (!b) {
                                final Object b2 = c.b(e2);
                                if (b2 != null) {
                                    final q q = map.get(b2);
                                    if (!t.d(q)) {
                                        y.add(q);
                                        t.a(q, true);
                                    }
                                }
                            }
                            a.g();
                            if (k) {
                                break;
                            }
                        }
                        final q[] e3 = y.e();
                        int n = 0;
                        do {
                            Label_0204: {
                                final int n2 = e3.length - 1;
                            }
                            int d2 = 0;
                            int d3 = 0;
                            Label_0211:
                            while (d2 < d3) {
                                final q q2 = e3[n];
                                l = n + 1;
                                if (!k) {
                                    int n3 = l;
                                    while (n3 < e3.length) {
                                        final q q3 = e3[n3];
                                        d2 = q2.d();
                                        d3 = q3.d();
                                        if (k) {
                                            continue Label_0211;
                                        }
                                        final q q4 = (d2 < d3) ? q2 : q3;
                                        final q q5 = (q2.d() < q3.d()) ? q3 : q2;
                                        Label_0396: {
                                            if (array[q4.d()][q5.d()] == null) {
                                                h.a(array[q4.d()][q5.d()] = j.a(q4, q5), 10);
                                                if (!k) {
                                                    break Label_0396;
                                                }
                                            }
                                            final d d4 = array[q4.d()][q5.d()];
                                            h.a(d4, h.a(d4) + 10);
                                        }
                                        ++n3;
                                        if (k) {
                                            break;
                                        }
                                    }
                                    ++n;
                                    continue Label_0204;
                                }
                                continue Label_0042;
                            }
                            break;
                        } while (!k);
                        final x a2 = y.a();
                        while (a2.f()) {
                            t.a(a2.e(), false);
                            a2.g();
                            if (k) {
                                continue Label_0468;
                            }
                            if (k) {
                                break;
                            }
                        }
                    }
                    o.g();
                    continue Label_0468;
                }
                return;
            }
            break;
        } while (!k);
        j.a(t);
    }
    
    private static double a(final q q, final q q2, final int[] array, final c c) {
        final boolean j = X.j;
        int n = 0;
        final int n2 = array[q.d()];
        final int n3 = array[q2.d()];
        y.c.e e = q.j();
        while (true) {
            while (e.f()) {
                d d = e.a();
                final int n5;
                int n4 = n5 = array[d.a(q).d()];
                final int n6 = n3;
                if (j) {
                    while (true) {
                        if (n5 != n6) {
                            n += (int)(c.a(d) * (a(n3 - 1, n4) - a(n3, n4)));
                        }
                        e.g();
                        if (!j) {
                            if (e.f()) {
                                d = e.a();
                                n4 = array[d.a(q2).d()];
                                final int n8;
                                final int n7 = n8 = n4;
                                if (!j) {
                                    continue;
                                }
                                return n7;
                            }
                        }
                        break;
                    }
                    return n;
                }
                if (n5 != n6) {
                    n += (int)(c.a(d) * (a(n2 + 1, n4) - a(n2, n4)));
                }
                e.g();
                if (j) {
                    break;
                }
            }
            e = q2.j();
            continue;
        }
    }
    
    private static double a(final i i, final c c, final int[] array) {
        final boolean j = X.j;
        double n = 0.0;
        final x o = i.o();
    Label_0123_Outer:
        while (o.f()) {
            final q e = o.e();
            final int n2 = array[e.d()];
            final y.c.e l = e.l();
            while (true) {
                while (l.f()) {
                    final d a = l.a();
                    n += c.a(a) * a(n2, array[a.d().d()]);
                    l.g();
                    if (!j) {
                        if (j) {
                            break;
                        }
                        continue Label_0123_Outer;
                    }
                    else {
                        if (j) {
                            break Label_0123_Outer;
                        }
                        continue Label_0123_Outer;
                    }
                }
                o.g();
                continue;
            }
        }
        return n;
    }
    
    private static double a(final int n, final int n2) {
        return Math.pow(Math.abs(n - n2), 2.0);
    }
}
