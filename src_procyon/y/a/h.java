package y.a;

import y.g.*;
import y.c.*;

public class h
{
    public static boolean a;
    
    public static y[] a(final i i) {
        final A a = M.a(new int[i.e()]);
        return a(i, a, a(i, a));
    }
    
    public static int a(final i i, final A a) {
        final boolean a2 = h.a;
        final x o = i.o();
        while (o.f()) {
            a.a(o.e(), -1);
            o.g();
            if (a2) {
                break;
            }
        }
        int n = 0;
        final d d = new d(i.e());
        final x o2 = i.o();
        int a3 = 0;
        while (o2.f()) {
            final q e = o2.e();
            a3 = a.a(e);
            if (a2) {
                return a3;
            }
            if (a3 == -1) {
                a(e, d, a, n++);
            }
            o2.g();
            if (a2) {
                break;
            }
        }
        return a3;
    }
    
    public static f b(final i i) {
        final boolean a = h.a;
        final f f = new f();
        final y[] a2 = a(i);
        int j = 0;
        f f2 = null;
        while (j < a2.length - 1) {
            final y.c.d a3 = i.a(a2[j].b(), a2[j + 1].c());
            f2 = f;
            if (a) {
                return f2;
            }
            f2.add(a3);
            ++j;
            if (a) {
                break;
            }
        }
        return f2;
    }
    
    public static y[] a(final i i, final A a, final int n) {
        final boolean a2 = h.a;
        final y[] array = new y[n];
        int j = 0;
        while (j < n) {
            array[j] = new y();
            ++j;
            if (a2) {
                break;
            }
        }
        final x o = i.o();
        y[] array2 = null;
        while (o.f()) {
            array2 = array;
            if (a2) {
                return array2;
            }
            array2[a.a(o.e())].b(o.e());
            o.g();
            if (a2) {
                break;
            }
        }
        return array2;
    }
    
    public static boolean c(final i i) {
        return i.i() || (i.g() >= i.e() - 1 && a(i, M.a(new int[i.e()])) <= 1);
    }
    
    private static void a(q q, final d d, final A a, final int n) {
        final boolean a2 = h.a;
        d.a(q);
        a.a(q, n);
    Label_0157:
        while (!d.c()) {
            q = (q)d.b();
            y.c.d d2 = q.f();
            q q2 = null;
            int n3;
            int n2 = 0;
            int n5;
            int n4 = 0;
            Label_0065_Outer:Label_0101_Outer:
            while (true) {
                while (true) {
                    while (true) {
                        Label_0122: {
                            Label_0095: {
                                if (d2 == null) {
                                    break Label_0095;
                                }
                                q2 = d2.d();
                                n2 = (n3 = a.a(q2));
                                n4 = (n5 = -1);
                                if (a2) {
                                    break Label_0122;
                                }
                                if (n3 == n5) {
                                    a.a(q2, n);
                                    d.a(q2);
                                }
                                d2 = d2.g();
                                if (!a2) {
                                    continue Label_0065_Outer;
                                }
                            }
                            d2 = q.g();
                            if (d2 == null) {
                                break;
                            }
                            q2 = d2.c();
                            n2 = (n3 = a.a(q2));
                            n4 = (n5 = -1);
                        }
                        if (a2) {
                            continue Label_0101_Outer;
                        }
                        break;
                    }
                    if (n2 == n4) {
                        a.a(q2, n);
                        d.a(q2);
                    }
                    d2 = d2.h();
                    if (a2) {
                        break Label_0157;
                    }
                    continue;
                }
            }
        }
    }
    
    public static f[] d(final i i) {
        final y.c.h b = M.b(new int[i.g()]);
        return a(i, b, a(i, b));
    }
    
    public static int a(final i i, final y.c.h h) {
        return a(i, h, M.a(new boolean[i.e()]));
    }
    
    public static int a(final i i, final y.c.h h, final A a) {
        final y.a.i j = new y.a.i(h, a);
        j.a(i);
        return j.k;
    }
    
    public static f[] a(final i i, final y.c.h h, final int n) {
        final boolean a = h.a;
        final f[] array = new f[n];
        int j = 0;
        while (j < n) {
            array[j] = new f();
            ++j;
            if (a) {
                break;
            }
        }
        final e p3 = i.p();
        while (p3.f()) {
            final int a2 = h.a(p3.a());
            if (a2 > -1) {
                array[a2].add(p3.a());
            }
            p3.g();
            if (a) {
                break;
            }
        }
        return array;
    }
    
    public static f e(final i i) {
        final boolean a = h.a;
        final f f = new f();
        final A a2 = M.a(new boolean[i.e()]);
        final y.c.h b = M.b(new int[i.g()]);
        final f[] a3 = a(i, b, a(i, b, a2));
        f f3 = null;
        if (a3.length > 1) {
            final y y = new y();
            int n = 0;
            do {
                int j = 0;
            Label_0071:
                while (j < a3.length) {
                    final f f2 = a3[n];
                    q q = null;
                    f3 = f2;
                    if (a) {
                        return f3;
                    }
                    Label_0330: {
                        if (f3.size() == 1) {
                            final y.c.d b2 = f2.b();
                            if (b2.c().a() == 1) {
                                q = b2.c();
                            }
                            else if (b2.d().a() == 1) {
                                q = b2.d();
                            }
                        }
                        else {
                            final e a4 = f2.a();
                            while (a4.f()) {
                                final y.c.d a5 = a4.a();
                                j = (a2.d(a5.c()) ? 1 : 0);
                                if (a) {
                                    continue Label_0071;
                                }
                                Label_0230: {
                                    if (j != 0) {
                                        if (q == null) {
                                            q = a5.c();
                                            if (!a) {
                                                break Label_0230;
                                            }
                                        }
                                        if (q != a5.c()) {
                                            q = null;
                                            break;
                                        }
                                    }
                                }
                                Label_0277: {
                                    if (a2.d(a5.d())) {
                                        if (q == null) {
                                            q = a5.d();
                                            if (!a) {
                                                break Label_0277;
                                            }
                                        }
                                        if (q != a5.d()) {
                                            q = null;
                                            break;
                                        }
                                    }
                                }
                                a4.g();
                                if (a) {
                                    break;
                                }
                            }
                            if (q != null) {
                                final y.c.d b3 = f2.b();
                                if (b3.c() != q) {
                                    q = b3.c();
                                    if (!a) {
                                        break Label_0330;
                                    }
                                }
                                q = b3.d();
                            }
                        }
                    }
                    if (q != null) {
                        y.add(q);
                    }
                    ++n;
                }
                break;
            } while (!a);
            q d = y.d();
            while (!y.isEmpty()) {
                final q d2 = y.d();
                final f f4 = f;
                if (a) {
                    break;
                }
                f4.c(i.a(d, d2));
                d = d2;
                if (a) {
                    break;
                }
            }
        }
        return f3;
    }
    
    public static void a(final i i, final q q, final boolean b, final boolean[] array) {
        final boolean a = h.a;
        int j = 0;
        while (j < array.length) {
            array[j] = false;
            ++j;
            if (a) {
                return;
            }
            if (a) {
                break;
            }
        }
        a(q, b, array);
    }
    
    public static void a(final i i, final q q, final boolean b, final boolean[] array, final boolean[] array2) {
        final boolean a = h.a;
        int j = 0;
        while (j < array2.length) {
            array2[j] = false;
            ++j;
            if (a) {
                return;
            }
            if (a) {
                break;
            }
        }
        a(q, b, array, array2);
    }
    
    private static void a(final q q, final boolean b, final boolean[] array, final boolean[] array2) {
        final boolean a = h.a;
        array2[q.d()] = true;
        final e e = b ? q.l() : q.j();
        while (e.f()) {
            final y.c.d a2 = e.a();
            if (!array[a2.b()]) {
                final q a3 = a2.a(q);
                if (!array2[a3.d()]) {
                    a(a3, b, array, array2);
                }
            }
            e.g();
            if (a) {
                break;
            }
        }
    }
    
    private static void a(final q q, final boolean b, final boolean[] array) {
        final boolean a = h.a;
        array[q.d()] = true;
        final x x = b ? q.o() : q.m();
        while (x.f()) {
            final q e = x.e();
            if (!array[e.d()]) {
                a(e, b, array);
            }
            x.g();
            if (a) {
                break;
            }
        }
    }
}
