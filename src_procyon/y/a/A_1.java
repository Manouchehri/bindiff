package y.a;

import y.c.*;
import y.g.*;
import java.util.*;

public class A
{
    public static f[] a(final i i, final y[] array) {
        final boolean a = h.a;
        final f[] array2 = new f[array.length];
        final int[] array3 = new int[i.f()];
        int n = 1;
        int n2 = 0;
    Label_0225:
        do {
            final int length = array.length;
            int j = 0;
            int n3 = 0;
        Label_0028:
            while (j < n3) {
                final y y = array[n2];
                final f f = new f();
                x x = y.a();
                while (true) {
                    while (x.f()) {
                        array3[x.e().d()] = n;
                        x.g();
                        if (a) {
                            while (x.f()) {
                                final q e = x.e();
                                if (a) {
                                    continue Label_0225;
                                }
                                final e l = e.l();
                                while (l.f()) {
                                    final d a2 = l.a();
                                    j = array3[a2.a(e).d()];
                                    n3 = n;
                                    if (a) {
                                        continue Label_0028;
                                    }
                                    if (j == n3 && !a2.e()) {
                                        f.c(a2);
                                    }
                                    l.g();
                                    if (a) {
                                        break;
                                    }
                                }
                                x.g();
                                if (a) {
                                    break;
                                }
                            }
                            array2[n2] = f;
                            ++n2;
                            ++n;
                            continue Label_0225;
                        }
                        if (a) {
                            break;
                        }
                    }
                    x = y.a();
                    continue;
                }
            }
            break;
        } while (!a);
        return array2;
    }
    
    public static y[] a(final i i) {
        final boolean a = h.a;
        final int[] array = new int[i.f()];
        final D d = new D();
        final y y = new y();
        final x o = i.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                array[e.d()] = e.c();
                final int c = e.c();
                if (a) {
                    if (c == 0) {
                        final q d2 = y.d();
                        if (d2.b() <= 0) {
                            break;
                        }
                        final q c2 = d2.g().c();
                        final int[] array2 = array;
                        final int d3 = c2.d();
                        --array2[d3];
                        if (c2.b() > 1 || array[c2.d()] != 0) {
                            break;
                        }
                        y.b(c2);
                        if (!a) {
                            break;
                        }
                    }
                    final x o2 = i.o();
                    do {
                        Label_0188: {
                            o2.f();
                        }
                        int j = 0;
                        Label_0195:
                        while (j != 0) {
                            final q e2 = o2.e();
                            final int n = array[e2.d()];
                            Label_0390: {
                                if (n == 0 && e2.b() != 1 && e2.c() > 0) {
                                    final y y2 = new y();
                                    y2.b(e2);
                                    a(e2, y2);
                                    d.b(y2);
                                    if (!a) {
                                        break Label_0390;
                                    }
                                }
                                if (n > 0 && n < e2.c()) {
                                    final y y3 = new y();
                                    y3.b(e2);
                                    final x o3 = e2.o();
                                    while (o3.f()) {
                                        final q e3 = o3.e();
                                        j = array[e3.d()];
                                        if (a) {
                                            continue Label_0195;
                                        }
                                        if (j == 0 && e3.b() == 1) {
                                            y3.b(e3);
                                            a(e3, y3);
                                        }
                                        o3.g();
                                        if (a) {
                                            break;
                                        }
                                    }
                                    d.b(y3);
                                }
                            }
                            o2.g();
                            continue Label_0188;
                        }
                        break;
                    } while (!a);
                    return (y[])d.toArray(new y[d.size()]);
                }
                if (c == 0 && e.b() == 1) {
                    y.b(e);
                }
                o.g();
                if (a) {
                    break;
                }
            }
            y.isEmpty();
            continue;
        }
    }
    
    public static boolean b(final i i) {
        if (i.i()) {
            return true;
        }
        if (i.e() != i.g() + 1) {
            return false;
        }
        final C c = new C();
        try {
            c.a(i);
            return true;
        }
        catch (B b) {
            return false;
        }
    }
    
    public static y a(final i i, final boolean b) {
        final boolean a = h.a;
        final y y = new y();
        final x o = i.o();
        while (o.f()) {
            final q e = o.e();
            if ((b && e.c() == 0) || (!b && e.a() == 1)) {
                y.add(e);
            }
            o.g();
            if (a) {
                break;
            }
        }
        return y;
    }
    
    public static q c(final i i) {
        if (i.e() == 1) {
            return i.k();
        }
        final y[] a = b.a(i, a(i, false));
        return a[a.length - 1].b();
    }
    
    public static q d(final i i) {
        final boolean a = h.a;
        final x o = i.o();
        q q = null;
        int n = 0;
        o.i();
        while (true) {
        Label_0130_Outer:
            while (o.f()) {
                final int b = o.e().b();
                if (!a) {
                    if (b == 0) {
                        q = o.e();
                        ++n;
                    }
                    o.g();
                    if (a) {
                        break;
                    }
                    continue;
                }
                else {
                    if (b == 1) {
                        return q;
                    }
                    int n2 = 0;
                    o.i();
                    while (true) {
                        while (o.f()) {
                            final int c = o.e().c();
                            if (!a) {
                                if (c == 0) {
                                    q = o.e();
                                    ++n2;
                                }
                                o.g();
                                if (a) {
                                    break;
                                }
                                continue Label_0130_Outer;
                            }
                            else {
                                if (c == 1) {
                                    return q;
                                }
                                return f(i);
                            }
                        }
                        continue;
                    }
                }
            }
            continue;
        }
    }
    
    public static f e(final i i) {
        return a(i, d(i));
    }
    
    public static q f(final i i) {
        return a(i, M.a(new int[i.f()]));
    }
    
    public static q a(final i i, final y.c.A a) {
        final boolean a2 = h.a;
        final q k = i.k();
        final q[] array = { null };
        final int[] array2 = new int[i.f()];
        Arrays.fill(array2, -1);
        final f a3 = a(i, k);
        a(k, a, array, array2, -1);
        final e a4 = a3.a();
        while (a4.f()) {
            i.c(a4.a());
            a4.g();
            if (a2) {
                break;
            }
        }
        return array[0];
    }
    
    private static int a(final q q, final y.c.A a, final q[] array, final int[] array2, int n) {
        final boolean a2 = h.a;
        int n2 = 0;
        d d = q.f();
        while (true) {
        Label_0205_Outer:
            while (d != null) {
                final q d2 = d.d();
                final int a3;
                final int n3 = a3 = a(d2, a, array, array2, n);
                final int n4 = n;
                if (a2) {
                    int n5 = a3 * n4;
                    d d3 = q.f();
                Label_0101:
                    while (true) {
                    Label_0181_Outer:
                        while (d3 != null) {
                            final q d4 = d3.d();
                            if (!a2) {
                                d d5 = d3.g();
                                while (true) {
                                    while (d5 != null) {
                                        n5 += array2[d4.d()] * array2[d5.d().d()];
                                        d5 = d5.g();
                                        if (!a2) {
                                            if (a2) {
                                                break;
                                            }
                                            continue Label_0181_Outer;
                                        }
                                        else {
                                            if (a2) {
                                                break Label_0181_Outer;
                                            }
                                            continue Label_0101;
                                        }
                                    }
                                    d3 = d3.g();
                                    continue Label_0205_Outer;
                                }
                            }
                            if (n5 > n) {
                                n = n5;
                                array[0] = q;
                            }
                            return n;
                        }
                        a.a(q, n5);
                        array2[q.d()] = n2 + 1;
                        continue;
                    }
                }
                if (a3 > n4) {
                    n = n3;
                }
                n2 += array2[d2.d()];
                d = d.g();
                if (a2) {
                    break;
                }
            }
            final int n6 = q.e().e() - 1 - n2;
            continue;
        }
    }
    
    public static f a(final i i, final q q) {
        final boolean a = h.a;
        final f f = new f();
        final y.a.B b = new y.a.B(f);
        b.a(false);
        b.a(i, q);
        final e a2 = f.a();
        while (a2.f()) {
            i.c(a2.a());
            a2.g();
            if (a) {
                break;
            }
        }
        return f;
    }
    
    private static void a(final q q, final y y) {
        final boolean a = h.a;
        final x o = q.o();
        while (o.f()) {
            final q e = o.e();
            y.b(e);
            a(e, y);
            o.g();
            if (a) {
                break;
            }
        }
    }
    
    public static q a(final i i, final q q, final boolean b, final y y) {
        final boolean a = h.a;
        if (y.size() == 0) {
            return null;
        }
        final int[] array = new int[i.e()];
        final x a2 = y.a();
        q q2 = a2.e();
        if (q2 == q) {
            return q;
        }
        int n = 1;
        while (true) {
            while (q2 != q) {
                array[q2.d()] = n++;
                q2 = a(q2, b);
                if (a) {
                    q q3 = a(a2.e(), b);
                    a2.g();
                Label_0233_Outer:
                    while (q3 != q && a2.f()) {
                        q q4 = a2.e();
                        if (q4 == q) {
                            return q;
                        }
                        Label_0256: {
                            if (array[q4.d()] >= array[q3.d()]) {
                                q3 = a(q4, b);
                                if (!a) {
                                    break Label_0256;
                                }
                            }
                            while (true) {
                                while (array[q4.d()] == 0) {
                                    array[q4.d()] = 1;
                                    q4 = a(q4, b);
                                    if (!a) {
                                        if (a) {
                                            break;
                                        }
                                        continue Label_0233_Outer;
                                    }
                                    else {
                                        if (array[q4.d()] > array[q3.d()]) {
                                            q3 = q4;
                                        }
                                        break Label_0256;
                                    }
                                }
                                if (array[q4.d()] != 1) {
                                    continue;
                                }
                                break;
                            }
                        }
                        a2.g();
                        if (a) {
                            break;
                        }
                    }
                    return q3;
                }
                if (a) {
                    break;
                }
            }
            array[q2.d()] = n;
            continue;
        }
    }
    
    private static q a(final q q, final boolean b) {
        return b ? q.g().c() : q.f().d();
    }
    
    public static void b(final i i, final y.c.A a) {
        a(d(i), a);
    }
    
    private static int a(final q q, final y.c.A a) {
        final boolean a2 = h.a;
        int max = 0;
        d d = q.f();
        while (d != null) {
            max = Math.max(max, a(d.d(), a));
            d = d.g();
            if (a2) {
                return max + 1;
            }
            if (a2) {
                break;
            }
        }
        a.a(q, max + 1);
        return max + 1;
    }
}
