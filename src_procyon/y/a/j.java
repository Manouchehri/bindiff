package y.a;

import y.g.*;
import java.util.*;
import y.c.*;

public class j
{
    public static int a(final i i, final A a, final boolean b, final int n, final int n2, final c c) {
        if (i.i()) {
            return 0;
        }
        if (n > n2) {
            throw new IllegalArgumentException("minGroupCount (" + n + ") must not be greater than maxGroupCount (" + n2 + ")");
        }
        if (n > i.e()) {
            throw new IllegalArgumentException("minGroupCount (" + n + ") must not be greater than graph.N() (" + i.e() + ")");
        }
        if (n2 <= 0) {
            throw new IllegalArgumentException("maxGroupCount (" + n2 + ") must be greater than 0");
        }
        final aa aa = new aa(i);
        b u = null;
        if (c != null) {
            u = aa.u();
            aa.b(aa.p(), c, u);
        }
        final A t = aa.t();
        aa.a(aa.o(), a, t);
        final int a2 = new ad().a(aa, t, n, n2, b, u);
        aa.c(i.o(), t, a);
        return a2;
    }
    
    public static int a(final i i, final A a, final double n, final int n2, final int n3, final boolean b) {
        final boolean a2 = h.a;
        if (i.i()) {
            return 0;
        }
        if (n2 > n3) {
            throw new IllegalArgumentException("minGroupCount (" + n2 + ") must not be greater than maxGroupCount (" + n3 + ")");
        }
        if (n2 > i.e()) {
            throw new IllegalArgumentException("minGroupCount (" + n2 + ") must not be greater than graph.N() (" + i.e() + ")");
        }
        if (n3 <= 0) {
            throw new IllegalArgumentException("maxGroupCount (" + n3 + ") must be greater than 0");
        }
        final aa aa = new aa(i);
        final A t = aa.t();
        aa.a(aa.o(), a, t);
        final I j = new I(aa);
        j.d();
        if (b) {
            final e p6 = aa.p();
            while (p6.f()) {
                final d a3 = p6.a();
                if (t.a(a3.c()) != t.a(a3.d())) {
                    j.a(a3);
                }
                p6.g();
                if (a2) {
                    break;
                }
            }
        }
        final ag ag = new ag();
        ag.a((n < 0.0 || n > 1.0) ? 0.5 : n);
        ag.c(n2);
        ag.b(n3);
        final int a4 = ag.a(aa, t);
        aa.c(i.o(), t, a);
        return a4;
    }
    
    public static int a(final i i, final A a) {
        final boolean a2 = h.a;
        if (g.c(i)) {
            return b(i, a);
        }
        final aa aa = new aa(i);
        final A t = aa.t();
        final A t2 = aa.t();
        final int a3 = h.a(aa, t2);
        final J j = new J(aa, t2);
        j.a();
        int n = 0;
        int n2 = 0;
        int k = 0;
        int b = 0;
    Label_0192_Outer:
        while (k < a3) {
            j.c(new Integer(k));
            int n3 = b = b(aa, t);
            if (!a2) {
                if (b == 0) {
                    n3 = 1;
                }
                n += n3;
                final x o = aa.o();
                while (true) {
                    while (o.f()) {
                        final q e = o.e();
                        t.a(e, t.a(e) + n2);
                        o.g();
                        if (!a2) {
                            if (a2) {
                                break;
                            }
                            continue Label_0192_Outer;
                        }
                        else {
                            if (a2) {
                                break Label_0192_Outer;
                            }
                            continue Label_0192_Outer;
                        }
                    }
                    n2 = n;
                    ++k;
                    continue;
                }
            }
            return b;
        }
        j.b();
        aa.c(i.o(), t, a);
        return b;
    }
    
    private static int b(final i i, final A a) {
        final boolean a2 = h.a;
        final A a3 = M.a(new Object[i.e()]);
        final A a4 = M.a(new boolean[i.e()]);
        final y.c.h b = M.b(new int[i.g()]);
        final int a5 = h.a(i, b, a4);
        if (a5 < 1) {
            return 0;
        }
        final f[] a6 = h.a(i, b, a5);
        final y.c.h b2 = M.b(new Object[i.g()]);
        int j = 0;
    Label_0079:
        while (true) {
        Label_0152_Outer:
            while (j < a6.length) {
                final f f2;
                final f f = f2 = a6[j];
                if (!a2) {
                    final e a7 = f2.a();
                    while (true) {
                        while (a7.f()) {
                            b2.a(a7.a(), f);
                            a7.g();
                            if (!a2) {
                                if (a2) {
                                    break;
                                }
                                continue Label_0152_Outer;
                            }
                            else {
                                if (a2) {
                                    break Label_0152_Outer;
                                }
                                continue Label_0079;
                            }
                        }
                        ++j;
                        continue;
                    }
                }
                a(f2, a4, b2, new HashMap(), a3);
                final HashMap<Object, Integer> hashMap = new HashMap<Object, Integer>();
                int n = 0;
                final x o = i.o();
                while (o.f()) {
                    final Object b3 = a3.b(o.e());
                    Integer n2 = (b3 == null) ? new Integer(n++) : hashMap.get(b3);
                    if (n2 == null) {
                        n2 = new Integer(n++);
                        hashMap.put(b3, n2);
                    }
                    a.a(o.e(), (int)n2);
                    o.g();
                    if (a2) {
                        break;
                    }
                }
                return n;
            }
            a(a4, a6);
            continue;
        }
    }
    
    static f a(final A a, final f[] array) {
        final boolean a2 = h.a;
        int size = -1;
        int i = 0;
        f f2 = null;
        while (i < array.length) {
            final f f = f2 = array[i];
            if (a2) {
                return f2;
            }
            if (f2.size() > size) {
                size = f.size();
            }
            ++i;
            if (a2) {
                break;
            }
        }
        return f2;
    }
    
    static void a(final f f, final A a, final y.c.h h, final HashMap hashMap, final A a2) {
        final boolean a3 = h.a;
        if (hashMap.containsKey(f)) {
            return;
        }
        hashMap.put(f, Boolean.TRUE);
        final q[] array = new q[2];
        final e a4 = f.a();
        do {
            Label_0035: {
                a4.f();
            }
            boolean d = false;
            Label_0042:
            while (d) {
                final d a5 = a4.a();
                array[0] = a5.c();
                array[1] = a5.d();
                int n = 0;
                do {
                    int i = 0;
                    Label_0077:
                    while (i < 2) {
                        final q q = array[n];
                        d = a.d(q);
                        if (a3) {
                            continue Label_0042;
                        }
                        Label_0221: {
                            Label_0211: {
                                if (d) {
                                    if (a2.b(q) == null) {
                                        if (f.size() > 1) {
                                            a2.a(q, f);
                                        }
                                        final e j = q.j();
                                        while (j.f()) {
                                            final d a6 = j.a();
                                            i = (a6.e() ? 1 : 0);
                                            if (a3) {
                                                continue Label_0077;
                                            }
                                            if (i == 0) {
                                                a((f)h.b(a6), a, h, hashMap, a2);
                                            }
                                            j.g();
                                            if (a3) {
                                                break Label_0211;
                                            }
                                        }
                                    }
                                    break Label_0221;
                                }
                            }
                            a2.a(q, f);
                        }
                        ++n;
                    }
                    break;
                } while (!a3);
                a4.g();
                continue Label_0035;
            }
            break;
        } while (!a3);
    }
}
