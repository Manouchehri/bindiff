package y.f.c.a;

import y.f.*;
import y.g.*;
import y.c.*;

class bQ
{
    private static final Object a;
    private static final Object b;
    
    private static boolean a(final d d, final aV av, final boolean b, final c c) {
        if (b) {
            if (c != null && c.b(d.c()) != null) {
                return false;
            }
            final A a = av.a(d);
            if (a != null) {
                if (a.c() != null && !a.c().g()) {
                    return false;
                }
                if (a.d() != null && !a.d().isEmpty()) {
                    return false;
                }
            }
            return true;
        }
        else {
            if (c != null && c.b(d.d()) != null) {
                return false;
            }
            final A a2 = av.a(d);
            if (a2 != null) {
                if (a2.e() != null && !a2.e().g()) {
                    return false;
                }
                if (a2.f() != null && !a2.f().isEmpty()) {
                    return false;
                }
            }
            return true;
        }
    }
    
    static void a(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        final c c = x.c(ay.a);
        final y.c.A a = M.a();
        int i = 0;
    Label_0105_Outer:
        while (i < au.b()) {
            final x a2 = au.a(i).d().a();
            while (true) {
                while (a2.f()) {
                    a.a(a2.e(), i);
                    a2.g();
                    if (!x2) {
                        if (x2) {
                            break;
                        }
                        continue Label_0105_Outer;
                    }
                    else {
                        if (x2) {
                            break Label_0105_Outer;
                        }
                        continue Label_0105_Outer;
                    }
                }
                ++i;
                continue;
            }
        }
        final h b = M.b();
        final h b2 = M.b();
        final y.g.a.d d = new y.g.a.d(x);
        final y.g.a.d d2 = new y.g.a.d(x);
        final y.g.a.d d3 = new y.g.a.d(x);
        final y.g.a.d d4 = new y.g.a.d(x);
        final x o = x.o();
        while (true) {
            do {
                Label_0166: {
                    o.f();
                }
                boolean e = false;
                Label_0173:
            Label_1409_Outer:
                while (e) {
                    final q e2 = o.e();
                    int n = 0;
                    int n2 = 0;
                    final e l = e2.l();
                    if (!x2) {
                        final e e3 = l;
                        while (true) {
                            while (e3.f()) {
                                final d a3 = e3.a();
                                final boolean e4 = a3.e();
                                if (x2) {
                                    int n3 = e4 ? 1 : 0;
                                    int n4 = 0;
                                    final e k = e2.k();
                                    while (k.f()) {
                                        final d a4 = k.a();
                                        e = a4.e();
                                        if (x2) {
                                            continue Label_0173;
                                        }
                                        Label_0378: {
                                            if (!e && a(a4, av, false, c)) {
                                                if (a(a4, a)) {
                                                    ++n4;
                                                    if (!x2) {
                                                        break Label_0378;
                                                    }
                                                }
                                                ++n3;
                                            }
                                        }
                                        k.g();
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    d2.a(e2, -n3);
                                    d4.a(e2, -n4);
                                    o.g();
                                    continue Label_0166;
                                }
                                Label_0268: {
                                    if (!e4 && a(a3, av, true, c)) {
                                        if (a(a3, a)) {
                                            ++n2;
                                            if (!x2) {
                                                break Label_0268;
                                            }
                                        }
                                        ++n;
                                    }
                                }
                                e3.g();
                                if (x2) {
                                    break;
                                }
                            }
                            d.a(e2, -n);
                            d3.a(e2, -n2);
                            continue Label_1409_Outer;
                        }
                    }
                    final e e5 = l;
                    while (true) {
                        while (e5.f()) {
                            final d a5 = e5.a();
                            ap.a(a5, b.b(a5), b2.b(a5));
                            e5.g();
                            if (x2) {
                                if (x.c(bQ.b) instanceof a) {
                                    final a a6 = (a)x.c(bQ.b);
                                    final e p4 = x.p();
                                    while (p4.f()) {
                                        final d a7 = p4.a();
                                        a6.a(a7, b2.b(a7));
                                        p4.g();
                                        if (x2) {
                                            break;
                                        }
                                    }
                                }
                                return;
                            }
                            if (x2) {
                                break;
                            }
                        }
                        if (x.c(bQ.a) instanceof a) {
                            final a a8 = (a)x.c(bQ.a);
                            final e p5 = x.p();
                            while (p5.f()) {
                                final d a9 = p5.a();
                                a8.a(a9, b.b(a9));
                                p5.g();
                                if (x2) {
                                    return;
                                }
                                if (x2) {
                                    break;
                                }
                            }
                        }
                        continue;
                    }
                }
                break;
            } while (!x2);
            int n5;
            boolean b3;
            int n6;
            boolean b4;
            q q = null;
            e e6 = null;
            d d5 = null;
            Object b5 = null;
            Object b6;
            Object o2;
            Label_0930_Outer:Label_0958_Outer:Label_1093_Outer:
            while ((!d.a() || !d3.a()) && (!d2.a() || !d4.a())) {
                n5 = 0;
                b3 = false;
                n6 = 0;
                b4 = false;
                if (!d.a()) {
                    n6 = -d.e();
                }
                if (!d3.a() && -d3.e() >= n6) {
                    n6 = -d3.e();
                    b4 = true;
                }
                if (!d2.a()) {
                    n5 = -d2.e();
                }
                if (!d4.a() && -d4.e() >= n5) {
                    n5 = -d4.e();
                    b3 = true;
                }
                if (n5 <= 1 && n6 <= 1) {
                    break;
                }
                while (true) {
                    Label_1131: {
                        Label_0911: {
                            if (n5 > n6) {
                                Label_0748: {
                                    if (b3) {
                                        q = d4.c();
                                        e6 = q.k();
                                        while (e6.f()) {
                                            d5 = e6.a();
                                            b5 = b.b(d5);
                                            if (x2) {
                                                break Label_1131;
                                            }
                                            if (b5 == null && !d5.e() && a(d5, av, false, c) && a(d5, a)) {
                                                b2.a(d5, "inbackward" + q.d());
                                                if (d3.a(d5.c())) {
                                                    d3.c(d5.c(), d3.b(d5.c()) + 1);
                                                }
                                            }
                                            e6.g();
                                            if (x2) {
                                                break Label_0748;
                                            }
                                        }
                                        continue Label_0958_Outer;
                                    }
                                }
                                q = d2.c();
                                e6 = q.k();
                                while (e6.f()) {
                                    d5 = e6.a();
                                    b6 = b.b(d5);
                                    if (x2) {
                                        break Label_1131;
                                    }
                                    if (b6 == null && !d5.e() && a(d5, av, false, c) && !a(d5, a)) {
                                        b2.a(d5, "inforward" + q.d());
                                        if (d.a(d5.c())) {
                                            d.c(d5.c(), d.b(d5.c()) + 1);
                                        }
                                    }
                                    e6.g();
                                    if (x2) {
                                        break Label_0911;
                                    }
                                }
                                continue Label_0958_Outer;
                            }
                        }
                        while (true) {
                            Label_1079: {
                                if (!b4) {
                                    break Label_1079;
                                }
                                q = d3.c();
                                e6 = q.l();
                                while (true) {
                                    if (!e6.f()) {
                                        continue Label_0930_Outer;
                                    }
                                    d5 = e6.a();
                                    o2 = b2.b(d5);
                                    if (x2) {
                                        break Label_1131;
                                    }
                                    if (o2 == null && !d5.e() && a(d5, av, true, c) && a(d5, a)) {
                                        b.a(d5, "outbackward" + q.d());
                                        if (d4.a(d5.d())) {
                                            d4.c(d5.d(), d4.b(d5.d()) + 1);
                                        }
                                    }
                                    e6.g();
                                    if (!x2) {
                                        continue Label_0958_Outer;
                                    }
                                    break;
                                }
                            }
                            q = d.c();
                            e6 = q.l();
                            if (!e6.f()) {
                                continue Label_0958_Outer;
                            }
                            d5 = e6.a();
                            o2 = b2.b(d5);
                            if (x2 || x2) {
                                continue Label_1093_Outer;
                            }
                            break;
                        }
                    }
                    if (b5 == null && !d5.e() && a(d5, av, true, c) && !a(d5, a)) {
                        b.a(d5, "outforward" + q.d());
                        if (d2.a(d5.d())) {
                            d2.c(d5.d(), d2.b(d5.d()) + 1);
                        }
                    }
                    e6.g();
                    if (x2) {
                        break;
                    }
                    continue;
                }
            }
            x.p();
            continue;
        }
    }
    
    private static boolean a(final d d, final y.c.A a) {
        return a.a(d.c()) > a.a(d.d());
    }
    
    static {
        a = "AutoEdgeGroupConstraintHandler.TEST_SOURCE_GROUP_ID";
        b = "AutoEdgeGroupConstraintHandler.TEST_TARGET_GROUP_ID";
    }
}
