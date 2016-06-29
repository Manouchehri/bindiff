package y.a;

import y.g.a.*;
import y.c.*;

public class v
{
    public static void a(final i i, final q q, final boolean b, final double[] array, final double[] array2, final d[] array3) {
        final boolean a = h.a;
        final c c = new c(i);
        final int e = i.e();
        int j = 0;
        while (true) {
            while (j < e) {
                array3[j] = null;
                array2[j] = Double.POSITIVE_INFINITY;
                ++j;
                if (a) {
                    c.a(q, 0.0);
                Label_0368:
                    while (!c.b()) {
                        final q a2 = c.a();
                        final double n = array2[a2.d()];
                        a2.f();
                    Label_0113:
                        while (true) {
                            d d = null;
                            d g = d;
                            while (g != null) {
                                final q d2 = g.d();
                                final int d3 = d2.d();
                                final double n2 = n + array[g.b()];
                                d = array3[d3];
                                if (a) {
                                    continue Label_0113;
                                }
                                Label_0224: {
                                    Label_0217: {
                                        if (d == null && d2 != q) {
                                            c.a(d2, array2[d3] = n2);
                                            if (!a) {
                                                break Label_0217;
                                            }
                                        }
                                        if (n2 >= array2[d3]) {
                                            break Label_0224;
                                        }
                                        c.b(d2, array2[d3] = n2);
                                    }
                                    array3[d3] = g;
                                }
                                g = g.g();
                                if (a) {
                                    break;
                                }
                            }
                            if (!b) {
                                d d4 = a2.g();
                                while (d4 != null) {
                                    final q c2 = d4.c();
                                    final int d5 = c2.d();
                                    final double n3 = n + array[d4.b()];
                                    final d d6 = array3[d5];
                                    if (a) {
                                        continue Label_0113;
                                    }
                                    Label_0356: {
                                        Label_0349: {
                                            if (d6 == null && c2 != q) {
                                                c.a(c2, array2[d5] = n3);
                                                if (!a) {
                                                    break Label_0349;
                                                }
                                            }
                                            if (n3 >= array2[d5]) {
                                                break Label_0356;
                                            }
                                            c.b(c2, array2[d5] = n3);
                                        }
                                        array3[d5] = d4;
                                    }
                                    d4 = d4.h();
                                    if (a) {
                                        break Label_0368;
                                    }
                                }
                                break;
                            }
                            break;
                        }
                    }
                    return;
                }
                if (a) {
                    break;
                }
            }
            array2[q.d()] = 0.0;
            continue;
        }
    }
    
    public static double a(final i i, final q q, final q q2, final boolean b, final double[] array, final d[] array2) {
        return b(i, q, q2, b, array, array2);
    }
    
    public static f a(final i i, final q q, final q q2, final boolean b, final double[] array) {
        final d[] array2 = new d[i.e()];
        if (a(i, q, q2, b, array, array2) != Double.POSITIVE_INFINITY) {
            return a(q, q2, array2);
        }
        return new f();
    }
    
    private static double b(final i i, final q q, final q q2, final boolean b, final double[] array, final d[] array2) {
        final boolean a = h.a;
        final q[] array3 = { q, q2 };
        final double[][] array4 = new double[2][i.e()];
        final d[][] array5 = new d[2][i.e()];
        final e[] array6 = { new c(i), new c(i) };
        array6[0].a(array3[0], 0.0);
        array6[1].a(array3[1], 0.0);
        int n = (q != q2) ? 1 : 0;
        double n2 = 0.0;
    Label_0760:
        while (true) {
            int b2 = array6[0].b() ? 1 : 0;
        Label_0319_Outer:
            while (b2 == 0 || !array6[1].b()) {
                int b3 = 0;
                q a2 = null;
            Block_9:
                while (true) {
                    int n3 = b3;
                    do {
                        int j = 0;
                        Label_0143: {
                            j = n3;
                        }
                        Label_0145:
                    Label_0431_Outer:
                        while (j < 2) {
                            final int n4 = b2 = (b3 = (array6[n3].b() ? 1 : 0));
                            if (a) {
                                continue Label_0319_Outer;
                            }
                            if (!a) {
                                Label_0752: {
                                    if (n4 == 0) {
                                        a2 = array6[n3].a();
                                        final int d = a2.d();
                                        if ((a2 == array3[1 - n3] || array5[1 - n3][d] != null) && !array6[1 - n3].a(a2) && array4[0][d] + array4[1][d] == n2) {
                                            break Block_9;
                                        }
                                        int n5 = 0;
                                        while (true) {
                                            Label_0404: {
                                                if (b) {
                                                    break Label_0404;
                                                }
                                                d d2 = a2.f();
                                                if (d2 == null) {
                                                    d2 = a2.g();
                                                    n5 = 1;
                                                    if (a) {
                                                        break Label_0404;
                                                    }
                                                }
                                                while (d2 != null) {
                                                    final int b4 = d2.b();
                                                    final q a3 = d2.a(a2);
                                                    final int d3 = a3.d();
                                                    final double n6 = array4[n3][d] + array[b4];
                                                    Label_0622: {
                                                        if (array5[n3][d3] == null && a3 != array3[n3]) {
                                                            array4[n3][d3] = n6;
                                                            array6[n3].a(a3, n6);
                                                            if (!a) {
                                                                break Label_0622;
                                                            }
                                                        }
                                                        if (n6 < array4[n3][d3]) {
                                                            array6[n3].b(a3, n6);
                                                            array4[n3][d3] = n6;
                                                            if (!a) {
                                                                break Label_0622;
                                                            }
                                                        }
                                                        d2 = ((n5 != 0) ? d2.h() : d2.g());
                                                        if (d2 != null) {
                                                            continue Label_0431_Outer;
                                                        }
                                                        j = (b ? 1 : 0);
                                                        if (a) {
                                                            continue Label_0145;
                                                        }
                                                        if (b || n5 != 0) {
                                                            continue Label_0431_Outer;
                                                        }
                                                        d2 = a2.g();
                                                        n5 = 1;
                                                        if (!a) {
                                                            continue Label_0431_Outer;
                                                        }
                                                    }
                                                    array5[n3][d3] = d2;
                                                    if ((a3 == array3[1 - n3] || array5[1 - n3][d3] != null) && (n != 0 || array4[0][d3] + array4[1][d3] < n2)) {
                                                        n = 0;
                                                        n2 = array4[0][d3] + array4[1][d3];
                                                    }
                                                    d2 = ((n5 != 0) ? d2.h() : d2.g());
                                                    if (d2 == null && !b && n5 == 0) {
                                                        d2 = a2.g();
                                                        n5 = 1;
                                                        if (a) {
                                                            break;
                                                        }
                                                        continue Label_0431_Outer;
                                                    }
                                                }
                                                break Label_0752;
                                            }
                                            if (n3 == 0) {
                                                final d d2 = a2.f();
                                                if (!a) {
                                                    continue Label_0319_Outer;
                                                }
                                            }
                                            d d2 = a2.g();
                                            n5 = 1;
                                            continue Label_0319_Outer;
                                        }
                                    }
                                }
                                ++n3;
                                continue Label_0143;
                            }
                            continue Block_9;
                        }
                        continue Label_0760;
                    } while (!a);
                    break Label_0760;
                }
                q q3 = a2;
                int n7 = q3.d();
                while (true) {
                    while (q3 != q) {
                        array2[n7] = array5[0][n7];
                        q3 = array2[n7].a(q3);
                        n7 = q3.d();
                        if (a) {
                            int n8 = q3.d();
                            d d4;
                            while ((d4 = array5[1][n8]) != null) {
                                q3 = d4.a(q3);
                                n8 = q3.d();
                                array2[n8] = d4;
                                if (a) {
                                    break;
                                }
                            }
                            return n2;
                        }
                        if (a) {
                            break;
                        }
                    }
                    q3 = a2;
                    continue;
                }
            }
            break;
        }
        array2[q2.d()] = null;
        return Double.POSITIVE_INFINITY;
    }
    
    public static boolean b(final i i, final q q, final boolean b, final double[] array, final double[] array2, final d[] array3) {
        final boolean a = h.a;
        final int e = i.e();
        int j = 0;
        final y.g.c c = new y.g.c(e + 1);
        final boolean[] array4 = new boolean[e];
        int k = 0;
        while (true) {
        Label_0413_Outer:
            while (k < e) {
                array3[k] = null;
                array2[k] = Double.POSITIVE_INFINITY;
                ++k;
                if (a) {
                    c.b(null);
                Label_0413:
                    while (true) {
                        q q2;
                        int d;
                        double n;
                        d d2;
                        q d3;
                        int d4;
                        double n2;
                        d d5;
                        d h;
                        q c2;
                        int d6;
                        double n3;
                        d d7;
                        boolean[] array5;
                        boolean[] array6;
                        y.c.e e2;
                        d a3;
                        d a2;
                        d d8;
                        d d9;
                        boolean[] array7;
                        x o;
                        q e3;
                        int d10;
                        boolean b2;
                        Label_0291_Outer:Label_0511_Outer:Label_0572_Outer:
                        while (j < e) {
                            q2 = (q)c.b();
                            if (q2 == null) {
                                ++j;
                                if (c.e()) {
                                    return true;
                                }
                                c.b(null);
                                if (!a) {
                                    continue Label_0291_Outer;
                                }
                            }
                            d = q2.d();
                            array4[d] = false;
                            n = array2[d];
                            d2 = q2.f();
                            while (true) {
                                while (d2 != null) {
                                    d3 = d2.d();
                                    d4 = d3.d();
                                    n2 = n + array[d2.b()];
                                    d5 = array3[d4];
                                    if (a) {
                                        h = d5;
                                        while (h != null) {
                                            c2 = h.c();
                                            d6 = c2.d();
                                            n3 = n + array[h.b()];
                                            d7 = array3[d6];
                                            if (a || a) {
                                                break Label_0413;
                                            }
                                            if ((d7 == null && c2 != q) || n3 < array2[d6]) {
                                                array2[d6] = n3;
                                                array3[d6] = h;
                                                if (!array4[d6]) {
                                                    c.b(c2);
                                                    array4[d6] = true;
                                                }
                                            }
                                            h = h.h();
                                            if (a) {
                                                break Label_0291_Outer;
                                            }
                                        }
                                        continue Label_0413;
                                    }
                                    if ((d5 == null && d3 != q) || n2 < array2[d4]) {
                                        array2[d4] = n2;
                                        array3[d4] = d2;
                                        if (!array4[d4]) {
                                            c.b(d3);
                                            array4[d4] = true;
                                        }
                                    }
                                    d2 = d2.g();
                                    if (a) {
                                        break;
                                    }
                                }
                                if (b) {
                                    continue Label_0291_Outer;
                                }
                                q2.g();
                                continue Label_0413_Outer;
                            }
                            if (d7 != null) {
                                return false;
                            }
                            array5 = new boolean[i.e()];
                            array6 = new boolean[i.g()];
                            e2 = i.p();
                            while (true) {
                                while (true) {
                                    while (e2.f()) {
                                        a2 = (a3 = e2.a());
                                        d8 = array3[a2.d().d()];
                                        if (a) {
                                            Label_0582: {
                                                while (true) {
                                                    if (a3 != d8) {
                                                        array6[a2.b()] = true;
                                                    }
                                                    e2.g();
                                                    if (!a) {
                                                        if (e2.f()) {
                                                            a2 = e2.a();
                                                            if (!a) {
                                                                d9 = array3[a2.c().d()];
                                                                continue Label_0511_Outer;
                                                            }
                                                            break Label_0582;
                                                        }
                                                    }
                                                    break;
                                                }
                                                y.a.h.a(i, q, b, array6, array5);
                                            }
                                            array7 = new boolean[i.e()];
                                            o = i.o();
                                            while (o.f()) {
                                                e3 = o.e();
                                                d10 = e3.d();
                                                b2 = array4[d10];
                                                if (a) {
                                                    return b2;
                                                }
                                                if (b2 && !array7[d10]) {
                                                    a(i, e3, b, array5, array7, array3);
                                                }
                                                o.g();
                                                if (a) {
                                                    break;
                                                }
                                            }
                                            return b2;
                                        }
                                        if (a3 != d8) {
                                            array6[a2.b()] = true;
                                        }
                                        e2.g();
                                        if (a) {
                                            break;
                                        }
                                    }
                                    if (!b) {
                                        e2 = i.p();
                                        continue Label_0572_Outer;
                                    }
                                    break;
                                }
                                continue;
                            }
                        }
                        final d d11 = array3[q.d()];
                        continue Label_0413;
                    }
                }
                if (a) {
                    break;
                }
            }
            array2[q.d()] = 0.0;
            c.b(q);
            array4[q.d()] = true;
            continue;
        }
    }
    
    private static void a(final i i, final q q, final boolean b, final boolean[] array, final boolean[] array2, final d[] array3) {
        final boolean a = h.a;
        array2[q.d()] = true;
        d d = q.f();
        while (true) {
            while (d != null) {
                final q d2 = d.d();
                final int d3 = d2.d();
                final boolean b2 = array2[d3];
                if (a) {
                    if (!b2) {
                        d d4 = q.g();
                        while (d4 != null) {
                            final q c = d4.c();
                            final int d5 = c.d();
                            if (!array2[d5]) {
                                if (array[d5]) {
                                    array3[d5] = d4;
                                }
                                a(i, c, b, array, array2, array3);
                            }
                            d4 = d4.h();
                            if (a) {
                                break;
                            }
                        }
                    }
                    return;
                }
                if (!b2) {
                    if (array[d3]) {
                        array3[d3] = d;
                    }
                    a(i, d2, b, array, array2, array3);
                }
                d = d.g();
                if (a) {
                    break;
                }
            }
            continue;
        }
    }
    
    public static boolean a(final i i, final boolean b, final double[] array, final double[][] array2) {
        final boolean a = h.a;
        final int g = i.g();
        final q d = i.d();
        final f f = new f();
        final x o = i.o();
        while (o.f()) {
            final q e = o.e();
            if (e != d) {
                f.c(i.a(d, e));
            }
            o.g();
            if (a) {
                break;
            }
        }
        final double[] array3 = new double[i.g()];
        final double[] array4 = new double[i.e()];
        final d[] array5 = new d[i.e()];
        System.arraycopy(array, 0, array3, 0, g);
        final boolean b2 = !b(i, d, b, array3, array4, array5);
        while (true) {
        Label_0324_Outer:
            while (!f.isEmpty()) {
                i.a(f.d());
                if (!a) {
                    if (a) {
                        break;
                    }
                    continue;
                }
                else {
                    if (b2) {
                        return false;
                    }
                    final y.c.e p4 = i.p();
                    while (p4.f()) {
                        final d a2 = p4.a();
                        final int b3 = a2.b();
                        array3[b3] = array4[a2.c().d()] + array[b3] - array4[a2.d().d()];
                        p4.g();
                        if (a) {
                            break;
                        }
                    }
                    final x o2 = i.o();
                    while (true) {
                        while (o2.f()) {
                            final i j = i;
                            if (a) {
                                final int min = Math.min(j.e(), array2.length);
                                int k = 0;
                                int n2 = 0;
                            Label_0417:
                                while (k < min) {
                                    final double n = array4[k];
                                    final int min2 = Math.min(i.e(), array4.length);
                                    n2 = 0;
                                    if (!a) {
                                        int l = n2;
                                        while (true) {
                                            while (l < min2) {
                                                final double[] array6 = array2[k];
                                                final int n3 = l;
                                                array6[n3] += array4[l] - n;
                                                ++l;
                                                if (!a) {
                                                    if (a) {
                                                        break;
                                                    }
                                                    continue Label_0324_Outer;
                                                }
                                                else {
                                                    if (a) {
                                                        break Label_0417;
                                                    }
                                                    continue Label_0417;
                                                }
                                            }
                                            ++k;
                                            continue;
                                        }
                                    }
                                    return n2 != 0;
                                }
                                return n2 != 0;
                            }
                            a(i, o2.e(), b, array3, array2[o2.e().d()], array5);
                            o2.g();
                            if (a) {
                                break;
                            }
                        }
                        final i j = i;
                        continue;
                    }
                }
            }
            i.a(d);
            continue;
        }
    }
    
    public static double[] a(final i i) {
        final boolean a = h.a;
        final double[] array = new double[i.g()];
        int j = 0;
        double[] array2 = null;
        while (j < i.g()) {
            array2 = array;
            if (a) {
                return array2;
            }
            array2[j] = 1.0;
            ++j;
            if (a) {
                break;
            }
        }
        return array2;
    }
    
    public static f a(final q q, final q q2, final d[] array) {
        return a(q, q2, y.g.q.a(array));
    }
    
    public static f a(final q q, q a, final y.c.c c) {
        final boolean a2 = h.a;
        final f f = new f();
        d d = (d)c.b(a);
        f f2 = null;
        while (d != null) {
            f2 = f;
            if (a2) {
                return f2;
            }
            f2.c(d);
            a = d.a(a);
            d = (d)c.b(a);
            if (a2) {
                break;
            }
        }
        return f2;
    }
}
