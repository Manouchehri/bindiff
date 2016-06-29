package y.f.h;

import y.g.*;
import y.c.*;
import y.f.*;
import y.d.a.*;
import y.d.b.*;
import java.util.*;
import y.d.*;

public class d implements o
{
    private static final ArrayList a;
    private D b;
    private boolean c;
    private h d;
    private A e;
    
    public d() {
        this.c = false;
    }
    
    public void a(final D b) {
        this.b = b;
    }
    
    public void a(final h d) {
        this.d = d;
    }
    
    public void a(final A e) {
        this.e = e;
    }
    
    public void a(final boolean c) {
        this.c = c;
    }
    
    public void c() {
        final boolean d = N.d;
        if (this.b == null) {
            return;
        }
        final X x = (X)this.b.g();
        final y y = new y();
        final A a = M.a();
        Label_0448: {
            if (this.e != null) {
                final y.g.a.d d2 = new y.g.a.d(x);
                final int h = x.h();
                final x o = x.o();
                while (true) {
                Label_0197:
                    do {
                        Label_0065: {
                            o.f();
                        }
                        boolean d3 = false;
                        Label_0072:
                        while (d3) {
                            final q e = o.e();
                            final boolean d4 = this.e.d(e);
                            if (!d) {
                                if (d4) {
                                    int n = 0;
                                    final e j = e.j();
                                    while (j.f()) {
                                        d3 = this.e.d(j.a().a(e));
                                        if (d) {
                                            continue Label_0072;
                                        }
                                        if (!d3) {
                                            ++n;
                                        }
                                        j.g();
                                        if (d) {
                                            break;
                                        }
                                    }
                                    d2.a(e, h - n);
                                }
                                o.g();
                                continue Label_0065;
                            }
                        Label_0312:
                            while (!d4) {
                                final q c = d2.c();
                                y.add(c);
                                final e i = c.j();
                                while (i.f()) {
                                    final q a2 = i.a().a(c);
                                    if (d) {
                                        break Label_0448;
                                    }
                                    final boolean a3 = d2.a(a2);
                                    if (d) {
                                        continue Label_0204;
                                    }
                                    if (a3) {
                                        d2.b(a2, d2.b(a2) - 1);
                                    }
                                    i.g();
                                    if (d) {
                                        break Label_0312;
                                    }
                                }
                                break Label_0197;
                            }
                            y.c.p p = y.l();
                            while (p != null) {
                                final q q = (q)p.c();
                                a.a(q, new f(q.j()));
                                final e k = q.j();
                                do {
                                    Label_0360:
                                    k.f();
                                    boolean f = false;
                                    while (f) {
                                        final y.c.d a4 = k.a();
                                        f = x.f(a4);
                                        if (!d) {
                                            if (f) {
                                                x.d(a4);
                                                if (this.d != null) {
                                                    this.d.a(a4, true);
                                                }
                                            }
                                            k.g();
                                            continue Label_0360;
                                        }
                                    }
                                    break;
                                } while (!d);
                                x.c(q);
                                p = p.b();
                                if (d) {
                                    break;
                                }
                            }
                            break Label_0448;
                        }
                        break;
                    } while (!d);
                    d2.a();
                    continue;
                }
            }
        }
        final f f2 = new f();
        int d5 = 0;
        Label_0547: {
            if (this.d != null) {
                final e p2 = x.p();
                while (p2.f()) {
                    final y.c.d a5 = p2.a();
                    d5 = (this.d.d(a5) ? 1 : 0);
                    if (d) {
                        break Label_0547;
                    }
                    if (d5 != 0 && x.f(a5)) {
                        x.d(a5);
                        f2.add(a5);
                    }
                    p2.g();
                    if (d) {
                        break;
                    }
                }
            }
            x.h();
        }
        if (d5 > 0) {
            this.a(x, f2);
        }
        Label_1391: {
            e a7 = null;
            Label_1280: {
                boolean empty = false;
                Label_1201: {
                    Label_1194: {
                        if (x.h() > 0) {
                            y.g.o.a(this, "==================== Route ====================");
                            final n n2 = new n(this.b);
                            final x a6 = y.a();
                            while (a6.f()) {
                                final q e2 = a6.e();
                                x.d(e2);
                                final f f3 = (f)a.b(e2);
                                empty = f3.isEmpty();
                                if (d) {
                                    break Label_1201;
                                }
                                if (!empty) {
                                    y.c.d d6 = null;
                                    int n3 = Integer.MAX_VALUE;
                                    final C m = new y.c.D(this.b.h()).m();
                                    do {
                                        Label_0670: {
                                            m.f();
                                        }
                                        boolean f4 = false;
                                        Label_0677:
                                        while (f4) {
                                            final p p3 = (p)m.d();
                                            y.c.d d7 = null;
                                            a7 = p3.a();
                                            if (!d) {
                                                final e e3 = a7;
                                                while (e3.f()) {
                                                    final y.c.d a8 = e3.a();
                                                    f4 = this.b.f(a8.d());
                                                    if (d) {
                                                        continue Label_0677;
                                                    }
                                                    if (f4) {
                                                        d7 = a8;
                                                        break;
                                                    }
                                                    e3.g();
                                                }
                                                if (d7 != null) {
                                                    final y.c.d a9 = x.a(d7.d(), e2);
                                                    this.b.a(a9, d7, null);
                                                    final int b = n2.b(f3);
                                                    if (b < n3 || (b == n3 && this.b.i(a9) == this.b.i())) {
                                                        n3 = b;
                                                        d6 = d7;
                                                    }
                                                    this.b.a(a9);
                                                    x.e(a9);
                                                    x.a(a9);
                                                    x.e(this.b.h(a9));
                                                    x.a(this.b.h(a9));
                                                }
                                                m.g();
                                                continue Label_0670;
                                            }
                                            break Label_1280;
                                        }
                                        break;
                                    } while (!d);
                                    final y.c.d a10 = x.a(d6.d(), e2);
                                    this.b.a(a10, d6, null);
                                    n2.a(f3);
                                    this.b.a(a10);
                                    x.e(a10);
                                    x.a(a10);
                                    x.e(this.b.h(a10));
                                    x.a(this.b.h(a10));
                                }
                                a6.g();
                                if (d) {
                                    break;
                                }
                            }
                            n2.a(f2);
                            if (!d) {
                                break Label_1194;
                            }
                        }
                        final c c2 = new c();
                        final e a11 = f2.a();
                        while (a11.f()) {
                            x.e(a11.a());
                            a11.g();
                            if (d) {
                                break Label_1391;
                            }
                            if (d) {
                                break;
                            }
                        }
                        final x a12 = y.a();
                        do {
                            Label_1067: {
                                a12.f();
                            }
                            boolean f5 = false;
                            Label_1074:
                            while (f5) {
                                final q e4 = a12.e();
                                x.d(e4);
                                final e a13 = ((f)a.b(e4)).a();
                                if (!d) {
                                    final e e5 = a13;
                                    while (e5.f()) {
                                        final y.c.d a14 = e5.a();
                                        f5 = x.f(a14);
                                        if (d) {
                                            continue Label_1074;
                                        }
                                        if (!f5) {
                                            x.e(a14);
                                        }
                                        e5.g();
                                        if (d) {
                                            break;
                                        }
                                    }
                                    a12.g();
                                    continue Label_1067;
                                }
                                break Label_1280;
                            }
                            break;
                        } while (!d);
                        c2.a(this.b);
                        c2.c();
                    }
                    this.b.o();
                }
                if (!empty) {
                    y.g.o.a((Object)"Outer face");
                    this.b.b(this.b.i(x.p().a()));
                    y.g.o.a((Object)("New Outer face: " + this.b.i()));
                }
                this.b.k();
                if (this.d == null) {
                    break Label_1391;
                }
                f2.a();
            }
            final e e6 = a7;
        Label_1386_Outer:
            while (e6.f()) {
                final e c3 = this.b.c(e6.a());
                while (true) {
                    while (c3.f()) {
                        final y.c.d a15 = c3.a();
                        this.d.a(a15, true);
                        this.d.a(this.b.h(a15), true);
                        c3.g();
                        if (!d) {
                            if (d) {
                                break;
                            }
                            continue Label_1386_Outer;
                        }
                        else {
                            if (d) {
                                break Label_1391;
                            }
                            continue Label_1386_Outer;
                        }
                    }
                    e6.g();
                    continue;
                }
            }
        }
        final x a16 = y.a();
        while (a16.f()) {
            ((f)a.b(a16.e())).a();
        Label_1546:
            while (true) {
                e c4 = null;
                final e e7 = c4;
            Label_1541_Outer:
                while (e7.f()) {
                    c4 = this.b.c(e7.a());
                    if (!d) {
                        final e e8 = c4;
                        while (true) {
                            while (e8.f()) {
                                final y.c.d a17 = e8.a();
                                this.d.a(a17, true);
                                this.d.a(this.b.h(a17), true);
                                e8.g();
                                if (!d) {
                                    if (d) {
                                        break;
                                    }
                                    continue Label_1541_Outer;
                                }
                                else {
                                    if (d) {
                                        break Label_1546;
                                    }
                                    continue Label_1541_Outer;
                                }
                            }
                            e7.g();
                            continue;
                        }
                    }
                    continue Label_1546;
                }
                break;
            }
            a16.g();
            if (d) {
                break;
            }
        }
    }
    
    private void a(final X x, final f f) {
        final boolean d = N.d;
        ae.d(x);
        final y.d.b.n f2 = y.d.b.n.f();
        y.g.o.a(this, "==================== Planarize ====================");
        final A t = x.t();
        final A t2 = x.t();
        final h u = x.u();
        HashMap<Object, q> hashMap = new HashMap<Object, q>();
        final x o = x.o();
        while (true) {
        Label_0429_Outer:
            while (o.f()) {
                final q e = o.e();
                final double j = x.j(e);
                final double k = x.k(e);
                final double n = j;
                if (d) {
                    final double n2 = n;
                    final x o2 = x.o();
                Label_0179:
                    while (true) {
                    Label_0567_Outer:
                        while (o2.f()) {
                            final q e2 = o2.e();
                            final double floor = Math.floor(x.m(e2));
                            final double floor2 = Math.floor(x.n(e2));
                            final double floor3 = Math.floor(x.p(e2));
                            final X x2 = x;
                            if (d) {
                                final A t3 = x2.t();
                                final HashMap hashMap2 = new HashMap<Object, q>(hashMap.size());
                            Label_0460:
                                while (true) {
                                Label_0563:
                                    for (final Object next : hashMap.keySet()) {
                                        final ArrayList<ArrayList> list = (ArrayList<ArrayList>)hashMap.get(next);
                                        if (!d) {
                                            int i = 1;
                                            while (true) {
                                                while (i < list.size()) {
                                                    t3.a(list.get(i), true);
                                                    ++i;
                                                    if (!d) {
                                                        if (d) {
                                                            break;
                                                        }
                                                        continue Label_0429_Outer;
                                                    }
                                                    else {
                                                        if (d) {
                                                            break Label_0563;
                                                        }
                                                        continue Label_0460;
                                                    }
                                                }
                                                hashMap2.put(next, (q)list.get(0));
                                                continue Label_0567_Outer;
                                            }
                                        }
                                        final e p2 = x.p();
                                        while (p2.f()) {
                                            final y.c.d a = p2.a();
                                            if (t3.d(a.c()) || t3.d(a.d())) {
                                                f.add(a);
                                                x.d(a);
                                            }
                                            p2.g();
                                            if (d) {
                                                break;
                                            }
                                        }
                                        final y y = new y();
                                        final x o3 = x.o();
                                        while (true) {
                                        Label_1067_Outer:
                                            while (o3.f()) {
                                                final q e3 = o3.e();
                                                if (d) {
                                                    final y.c.D d2 = new y.c.D();
                                                    final HashMap<Object, y.c.d> hashMap3 = new HashMap<Object, y.c.d>();
                                                    final e p3 = x.p();
                                                Label_0758:
                                                    while (true) {
                                                    Label_1060:
                                                        while (p3.f()) {
                                                            final y.c.d a2 = p3.a();
                                                            final ArrayList list2 = new ArrayList<Object>();
                                                            final Object b = t2.b(a2.c());
                                                            final Object b2 = t2.b(a2.d());
                                                            list2.add(b);
                                                            Object o4 = b;
                                                            final i l = x;
                                                            if (!d) {
                                                                final y.d.u b3 = x.l(a2).b();
                                                                while (true) {
                                                                    while (b3.f()) {
                                                                        final t a3 = b3.a();
                                                                        final Object a4 = a(a3.a(), a3.b(), f2);
                                                                        final boolean equals = a4.equals(o4);
                                                                        if (d) {
                                                                            if (!equals) {
                                                                                list2.add(b2);
                                                                            }
                                                                            final ArrayList list3 = new ArrayList<Object>(list2.size() - 1);
                                                                            int n3 = 1;
                                                                            while (true) {
                                                                                while (n3 < list2.size()) {
                                                                                    final Object c = f2.c(list2.get(n3 - 1), list2.get(n3));
                                                                                    d2.add(c);
                                                                                    list3.add(c);
                                                                                    hashMap3.put(f.a(c), a2);
                                                                                    ++n3;
                                                                                    if (!d) {
                                                                                        if (d) {
                                                                                            break;
                                                                                        }
                                                                                        continue Label_0429_Outer;
                                                                                    }
                                                                                    else {
                                                                                        if (d) {
                                                                                            break Label_1060;
                                                                                        }
                                                                                        continue Label_0758;
                                                                                    }
                                                                                }
                                                                                u.a(a2, list3);
                                                                                p3.g();
                                                                                continue Label_1067_Outer;
                                                                            }
                                                                        }
                                                                        if (!equals) {
                                                                            list2.add(a4);
                                                                        }
                                                                        o4 = a4;
                                                                        b3.g();
                                                                        if (d) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    b2.equals(o4);
                                                                    continue Label_1067_Outer;
                                                                }
                                                            }
                                                            final i m = l;
                                                            final N n4 = new N(m);
                                                            final A t4 = m.t();
                                                            final h u2 = m.u();
                                                            new a(f2).a(d2, n4, t4, u2);
                                                            final h u3 = m.u();
                                                            final A t5 = m.t();
                                                            final e p4 = m.p();
                                                            while (true) {
                                                                while (p4.f()) {
                                                                    final y.c.d a5 = p4.a();
                                                                    final y.c.d d3 = hashMap3.get(f.a(u2.b(a5)));
                                                                    u3.a(a5, d3);
                                                                    final h h = u3;
                                                                    if (d) {
                                                                        final h h2 = h;
                                                                        final h u4 = m.u();
                                                                        final x o5 = m.o();
                                                                        while (true) {
                                                                        Label_2298_Outer:
                                                                            while (o5.f()) {
                                                                                final q e4 = o5.e();
                                                                                final int n5 = 0;
                                                                                if (d) {
                                                                                    int n6 = n5;
                                                                                Label_2678_Outer:
                                                                                    while (true) {
                                                                                    Label_2678:
                                                                                        while (true) {
                                                                                            x x3;
                                                                                            q q;
                                                                                            Object b4;
                                                                                            int n7;
                                                                                            e l2;
                                                                                            int d4;
                                                                                            boolean b5;
                                                                                            e l3;
                                                                                            q d5;
                                                                                            Object b6;
                                                                                            y.f.h.q h3;
                                                                                            p a6;
                                                                                            y.c.D d6;
                                                                                            e a7;
                                                                                            e p5;
                                                                                            e e5;
                                                                                            boolean d7;
                                                                                            y.c.d a8;
                                                                                            h h4 = null;
                                                                                            h h5;
                                                                                            h u5;
                                                                                            h u6;
                                                                                            e e6;
                                                                                            y.c.d a9;
                                                                                            q q2;
                                                                                            q q3;
                                                                                            boolean n8;
                                                                                            y.c.d a10;
                                                                                            y.c.d a11;
                                                                                            q q4;
                                                                                            q q5;
                                                                                            y.c.d a12;
                                                                                            f f3;
                                                                                            e p6;
                                                                                            y.c.d a13;
                                                                                            x o6;
                                                                                            boolean n9 = false;
                                                                                            q e7;
                                                                                            e l4;
                                                                                            y.c.d d8;
                                                                                            f f4;
                                                                                            Object b7 = null;
                                                                                            y.c.d d9 = null;
                                                                                            q d10;
                                                                                            e l5;
                                                                                            g g;
                                                                                            x o7;
                                                                                            x x4 = null;
                                                                                            q e8;
                                                                                            boolean f5 = false;
                                                                                            e a14;
                                                                                            boolean d11 = false;
                                                                                            y.c.d d12;
                                                                                            t t6;
                                                                                            t p7;
                                                                                            Object b8;
                                                                                            q d13;
                                                                                            Object b9;
                                                                                            q e9;
                                                                                            boolean e10;
                                                                                            e a15;
                                                                                            e a16;
                                                                                            Label_2222:Label_2671_Outer:Label_2945_Outer:
                                                                                            while (n6 != 0) {
                                                                                                n6 = 0;
                                                                                                x3 = m.o();
                                                                                                Label_2481: {
                                                                                                Label_2331:
                                                                                                    while (true) {
                                                                                                        while (x3.f()) {
                                                                                                            q = x3.e();
                                                                                                            b4 = t5.b(q);
                                                                                                            if (d || d) {
                                                                                                                break Label_2331;
                                                                                                            }
                                                                                                            Label_2210: {
                                                                                                                if (b4 == null) {
                                                                                                                    n7 = 0;
                                                                                                                    l2 = q.l();
                                                                                                                    while (true) {
                                                                                                                        while (l2.f()) {
                                                                                                                            b5 = ((d4 = (h2.d(u3.b(l2.a())) ? 1 : 0)) != 0);
                                                                                                                            if (!d) {
                                                                                                                                if (!b5) {
                                                                                                                                    ++n7;
                                                                                                                                }
                                                                                                                                l2.g();
                                                                                                                                if (d) {
                                                                                                                                    break;
                                                                                                                                }
                                                                                                                                continue Label_0429_Outer;
                                                                                                                            }
                                                                                                                            else {
                                                                                                                                if (d4 != 4 && n7 != 2) {
                                                                                                                                    l3 = q.l();
                                                                                                                                    while (true) {
                                                                                                                                        while (l3.f()) {
                                                                                                                                            h2.a(u3.b(l3.a()), true);
                                                                                                                                            l3.g();
                                                                                                                                            if (d) {
                                                                                                                                                n6 = 1;
                                                                                                                                                break Label_2210;
                                                                                                                                            }
                                                                                                                                            if (d) {
                                                                                                                                                break;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        m.a(q);
                                                                                                                                        continue Label_2298_Outer;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                break Label_2210;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        d4 = n7;
                                                                                                                        continue Label_2298_Outer;
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                            x3.g();
                                                                                                            if (d) {
                                                                                                                break Label_2222;
                                                                                                            }
                                                                                                        }
                                                                                                        continue Label_0429_Outer;
                                                                                                        Label_2464: {
                                                                                                            if (b4 == null) {
                                                                                                                d5 = x.d();
                                                                                                                x.b(d5, 0.0, 0.0);
                                                                                                                t2.a(d5, t4.b(q));
                                                                                                                b6 = t4.b(q);
                                                                                                                x.a(d5, new t(f2.k(b6).e(), f2.l(b6).e()));
                                                                                                                t5.a(q, d5);
                                                                                                                if (q.c() == 4) {
                                                                                                                    this.b.c(d5);
                                                                                                                    if (!d) {
                                                                                                                        break Label_2464;
                                                                                                                    }
                                                                                                                }
                                                                                                                if (q.c() == 2) {
                                                                                                                    this.b.d(d5);
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        x3.g();
                                                                                                        if (!d) {
                                                                                                            if (x3.f()) {
                                                                                                                q = x3.e();
                                                                                                                if (!d) {
                                                                                                                    t5.b(q);
                                                                                                                    continue Label_2331;
                                                                                                                }
                                                                                                                break Label_2481;
                                                                                                            }
                                                                                                        }
                                                                                                        break;
                                                                                                    }
                                                                                                    n4.l();
                                                                                                }
                                                                                                h3 = n4.h();
                                                                                                Label_2742: {
                                                                                                Label_2671:
                                                                                                    while (true) {
                                                                                                        while (true) {
                                                                                                            while (h3.f()) {
                                                                                                                a6 = h3.a();
                                                                                                                d6 = new y.c.D();
                                                                                                                a7 = a6.a();
                                                                                                                if (d) {
                                                                                                                    p5 = a7;
                                                                                                                    break Label_2671;
                                                                                                                }
                                                                                                                e5 = a7;
                                                                                                                while (e5.f()) {
                                                                                                                    d6.add(t4.b(e5.a().c()));
                                                                                                                    e5.g();
                                                                                                                    if (d) {
                                                                                                                        continue Label_2742;
                                                                                                                    }
                                                                                                                    if (d) {
                                                                                                                        break;
                                                                                                                    }
                                                                                                                }
                                                                                                                if (new y.d.b.a(d6.toArray(), true, f2).a() == 0) {
                                                                                                                    n4.b(a6);
                                                                                                                    if (!d) {
                                                                                                                        break;
                                                                                                                    }
                                                                                                                }
                                                                                                                h3.g();
                                                                                                                if (d) {
                                                                                                                    break;
                                                                                                                }
                                                                                                            }
                                                                                                            if (n4.i() == null && n4.j() > 0) {
                                                                                                                n4.b(n4.h().a());
                                                                                                            }
                                                                                                            x.p();
                                                                                                            continue Label_2671_Outer;
                                                                                                        }
                                                                                                        p5.f();
                                                                                                        if (d7) {
                                                                                                            a8 = p5.a();
                                                                                                            h4 = h2;
                                                                                                            if (d) {
                                                                                                                break Label_2742;
                                                                                                            }
                                                                                                            if (h4.d(a8)) {
                                                                                                                f.add(a8);
                                                                                                                x.d(a8);
                                                                                                            }
                                                                                                            p5.g();
                                                                                                            if (!d) {
                                                                                                                continue Label_2671;
                                                                                                            }
                                                                                                        }
                                                                                                        break;
                                                                                                    }
                                                                                                    x.a(h2);
                                                                                                    x.u();
                                                                                                }
                                                                                                h5 = h4;
                                                                                                u5 = x.u();
                                                                                                u6 = m.u();
                                                                                                e6 = m.p();
                                                                                                while (true) {
                                                                                                    while (e6.f()) {
                                                                                                        a9 = e6.a();
                                                                                                        q2 = (q)t5.b(a9.c());
                                                                                                        q3 = (q)t5.b(a9.d());
                                                                                                        n8 = n4.n(a9);
                                                                                                        if (!d) {
                                                                                                            if (!n8) {
                                                                                                                if (!this.b.f(q2) || !this.b.f(q3)) {
                                                                                                                    a10 = x.a(q2, q3);
                                                                                                                }
                                                                                                                else {
                                                                                                                    a10 = (y.c.d)u3.b(a9);
                                                                                                                }
                                                                                                                h5.a(a10, a9);
                                                                                                                u6.a(a9, a10);
                                                                                                                u5.a(a10, u4.a(a9));
                                                                                                            }
                                                                                                            e6.g();
                                                                                                            if (d) {
                                                                                                                break;
                                                                                                            }
                                                                                                            continue Label_0429_Outer;
                                                                                                        }
                                                                                                        else {
                                                                                                            while (true) {
                                                                                                                if (n8) {
                                                                                                                    a11 = e6.a();
                                                                                                                    q4 = (q)t5.b(a11.c());
                                                                                                                    q5 = (q)t5.b(a11.d());
                                                                                                                    if (n4.n(a11)) {
                                                                                                                        a12 = x.a(q4, q5);
                                                                                                                        this.b.m(a12);
                                                                                                                        this.b.b(a12, (y.c.d)u6.b(n4.h(a11)));
                                                                                                                        h5.a(a12, a11);
                                                                                                                        u6.a(a11, a12);
                                                                                                                        u5.a(a12, u4.a(a11));
                                                                                                                    }
                                                                                                                    e6.g();
                                                                                                                    if (!d) {
                                                                                                                        e6.f();
                                                                                                                        continue Label_2945_Outer;
                                                                                                                    }
                                                                                                                }
                                                                                                                break;
                                                                                                            }
                                                                                                            f3 = new f();
                                                                                                            p6 = x.p();
                                                                                                            while (p6.f()) {
                                                                                                                a13 = p6.a();
                                                                                                                if (h5.b(a13) == null) {
                                                                                                                    f3.add(a13);
                                                                                                                    x.d(a13);
                                                                                                                }
                                                                                                                p6.g();
                                                                                                                if (d) {
                                                                                                                    break;
                                                                                                                }
                                                                                                            }
                                                                                                            o6 = x.o();
                                                                                                            do {
                                                                                                                Label_3186: {
                                                                                                                    o6.f();
                                                                                                                }
                                                                                                                Label_3193:
                                                                                                                while (n9) {
                                                                                                                    e7 = o6.e();
                                                                                                                    if (this.b.f(e7)) {
                                                                                                                        l4 = e7.l();
                                                                                                                        while (l4.f()) {
                                                                                                                            d8 = l4.a();
                                                                                                                            n9 = this.b.n(d8);
                                                                                                                            if (d) {
                                                                                                                                continue Label_3193;
                                                                                                                            }
                                                                                                                            if (!n9) {
                                                                                                                                if (!this.b.f(d8.d())) {
                                                                                                                                    f4 = new f();
                                                                                                                                    u3.b(h5.b(d8));
                                                                                                                                    Label_3306:
                                                                                                                                Label_3413:
                                                                                                                                    while (true) {
                                                                                                                                        d9 = (y.c.d)b7;
                                                                                                                                        while (!this.b.f(d8.d())) {
                                                                                                                                            d10 = d8.d();
                                                                                                                                            f4.add(d8);
                                                                                                                                            l5 = d10.l();
                                                                                                                                            while (l5.f()) {
                                                                                                                                                d8 = l5.a();
                                                                                                                                                b7 = u3.b(h5.b(d8));
                                                                                                                                                if (d || d) {
                                                                                                                                                    continue Label_3306;
                                                                                                                                                }
                                                                                                                                                if (b7 == d9) {
                                                                                                                                                    break;
                                                                                                                                                }
                                                                                                                                                l5.g();
                                                                                                                                                if (d) {
                                                                                                                                                    break Label_3413;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        break;
                                                                                                                                    }
                                                                                                                                    f4.add(d8);
                                                                                                                                    this.b.a(d9, f4.e());
                                                                                                                                    this.b.a(d9, f4, 0);
                                                                                                                                }
                                                                                                                            }
                                                                                                                            l4.g();
                                                                                                                            if (d) {
                                                                                                                                break;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                    o6.g();
                                                                                                                    continue Label_3186;
                                                                                                                }
                                                                                                                break;
                                                                                                            } while (!d);
                                                                                                            g = new g(u5);
                                                                                                            o7 = x.o();
                                                                                                            while (true) {
                                                                                                            Label_4162_Outer:
                                                                                                                while (o7.f()) {
                                                                                                                    o7.e().b(g);
                                                                                                                    o7.g();
                                                                                                                    if (d) {
                                                                                                                        while (true) {
                                                                                                                            Label_4074: {
                                                                                                                                Label_4006: {
                                                                                                                                    Label_3942: {
                                                                                                                                        if (this.c) {
                                                                                                                                            x4 = x.o();
                                                                                                                                            while (x4.f()) {
                                                                                                                                                e8 = x4.e();
                                                                                                                                                f5 = this.b.f(e8);
                                                                                                                                                if (d) {
                                                                                                                                                    break Label_4074;
                                                                                                                                                }
                                                                                                                                                Label_3937: {
                                                                                                                                                    if (f5) {
                                                                                                                                                        a14 = new f(e8.l()).a();
                                                                                                                                                        do {
                                                                                                                                                            Label_3660: {
                                                                                                                                                                a14.f();
                                                                                                                                                            }
                                                                                                                                                            Label_3667:
                                                                                                                                                            while (d11) {
                                                                                                                                                                d12 = a14.a();
                                                                                                                                                                t2.b(e8);
                                                                                                                                                                t6 = null;
                                                                                                                                                                p7 = null;
                                                                                                                                                                if (!d) {
                                                                                                                                                                    b8 = t.b(e8);
                                                                                                                                                                    while (this.b.e(d12.d())) {
                                                                                                                                                                        d13 = d12.d();
                                                                                                                                                                        b9 = t2.b(d13);
                                                                                                                                                                        d11 = f2.d(b8, b9);
                                                                                                                                                                        if (d) {
                                                                                                                                                                            continue Label_3667;
                                                                                                                                                                        }
                                                                                                                                                                        if (!d11) {
                                                                                                                                                                            break;
                                                                                                                                                                        }
                                                                                                                                                                        p7 = x.p((d12 == d13.g()) ? d13.i() : d13.g());
                                                                                                                                                                        d12 = this.b.h(d13);
                                                                                                                                                                        if (d12.c() != e8) {
                                                                                                                                                                            d12 = this.b.h(d12);
                                                                                                                                                                        }
                                                                                                                                                                        t6 = new t(f2.k(b9).e(), f2.l(b9).e());
                                                                                                                                                                        if (d) {
                                                                                                                                                                            break;
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                    if (t6 != null) {
                                                                                                                                                                        x.c(d12, t6);
                                                                                                                                                                        x.d(this.b.h(d12), t6);
                                                                                                                                                                    }
                                                                                                                                                                    if (p7 != null) {
                                                                                                                                                                        x.d(d12, p7);
                                                                                                                                                                        x.c(this.b.h(d12), p7);
                                                                                                                                                                    }
                                                                                                                                                                    a14.g();
                                                                                                                                                                    continue Label_3660;
                                                                                                                                                                }
                                                                                                                                                                break Label_3937;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        } while (!d);
                                                                                                                                                    }
                                                                                                                                                    x4.g();
                                                                                                                                                }
                                                                                                                                                if (d) {
                                                                                                                                                    break Label_3942;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            break Label_4006;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    x4 = x.o();
                                                                                                                                    while (x4.f()) {
                                                                                                                                        e9 = x4.e();
                                                                                                                                        e10 = this.b.e(e9);
                                                                                                                                        if (d) {
                                                                                                                                            break Label_4074;
                                                                                                                                        }
                                                                                                                                        if (e10) {
                                                                                                                                            this.b.h(e9);
                                                                                                                                        }
                                                                                                                                        x4.g();
                                                                                                                                        if (d) {
                                                                                                                                            break;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                m.a(t4);
                                                                                                                                m.a(t5);
                                                                                                                                m.a(u2);
                                                                                                                                m.a(u3);
                                                                                                                                m.a(u4);
                                                                                                                                m.a(u6);
                                                                                                                                x.a(t2);
                                                                                                                                x.a(t);
                                                                                                                                x4 = y.a();
                                                                                                                                x4.f();
                                                                                                                            }
                                                                                                                            if (f5) {
                                                                                                                                x.d(x4.e());
                                                                                                                                x4.g();
                                                                                                                                if (!d) {
                                                                                                                                    continue Label_4162_Outer;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            break;
                                                                                                                        }
                                                                                                                        a15 = f.a();
                                                                                                                        while (true) {
                                                                                                                            while (a15.f()) {
                                                                                                                                x.e(a15.a());
                                                                                                                                a15.g();
                                                                                                                                if (d) {
                                                                                                                                    a16 = f.a();
                                                                                                                                    while (a16.f()) {
                                                                                                                                        x.d(a16.a());
                                                                                                                                        a16.g();
                                                                                                                                        if (d) {
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (d) {
                                                                                                                                            break;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    n4.e();
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                                if (d) {
                                                                                                                                    break;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            x.a(u);
                                                                                                                            x.a(u5);
                                                                                                                            x.a(h5);
                                                                                                                            continue;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    if (d) {
                                                                                                                        break;
                                                                                                                    }
                                                                                                                }
                                                                                                                if (n4.i() != null) {
                                                                                                                    this.b.l();
                                                                                                                    this.b.b(this.b.i((y.c.d)u6.b(n4.i().a().a())));
                                                                                                                }
                                                                                                                continue;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    e6 = m.p();
                                                                                                    continue;
                                                                                                }
                                                                                            }
                                                                                            p5 = m.p();
                                                                                            while (p5.f()) {
                                                                                                final y.c.d a17 = p5.a();
                                                                                                d7 = h2.d(u3.b(a17));
                                                                                                if (d) {
                                                                                                    continue Label_2678;
                                                                                                }
                                                                                                if (d7) {
                                                                                                    m.a(a17);
                                                                                                }
                                                                                                p5.g();
                                                                                                if (d) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        }
                                                                                        x x3 = m.o();
                                                                                        continue Label_2678_Outer;
                                                                                    }
                                                                                }
                                                                                int n10 = n5;
                                                                                Label_1990: {
                                                                                Label_1983:
                                                                                    while (true) {
                                                                                        q c2 = null;
                                                                                        Object o8 = c2.l();
                                                                                        while (true) {
                                                                                        Label_1732_Outer:
                                                                                            while (((C)o8).f()) {
                                                                                                u4.a(((e)o8).a(), n10++);
                                                                                                ((C)o8).g();
                                                                                                if (d) {
                                                                                                    final q q6 = hashMap.get(o8);
                                                                                                    Label_1800: {
                                                                                                        if (q6 == null) {
                                                                                                            boolean b10 = true;
                                                                                                            final y.c.d[] array = new y.c.d[e4.c()];
                                                                                                            final y.c.d[] array2 = new y.c.d[e4.b()];
                                                                                                            int n11 = 0;
                                                                                                            final e l6 = e4.l();
                                                                                                            while (l6.f()) {
                                                                                                                array[n11++] = l6.a();
                                                                                                                l6.g();
                                                                                                                if (d) {
                                                                                                                    break Label_1990;
                                                                                                                }
                                                                                                                if (d) {
                                                                                                                    break;
                                                                                                                }
                                                                                                            }
                                                                                                            int n12 = 0;
                                                                                                            final e k2 = e4.k();
                                                                                                        Label_1732:
                                                                                                            while (true) {
                                                                                                                while (true) {
                                                                                                                    while (k2.f()) {
                                                                                                                        array2[n12++] = k2.a();
                                                                                                                        k2.g();
                                                                                                                        if (!d) {
                                                                                                                            if (d) {
                                                                                                                                break;
                                                                                                                            }
                                                                                                                            continue Label_0429_Outer;
                                                                                                                        }
                                                                                                                        else {
                                                                                                                            if (e4.c() == 4 && e4.b() == 4) {
                                                                                                                                if (u3.b(array[0]) == u3.b(array[2]) && u3.b(array[1]) == u3.b(array[3]) && u3.b(array[0]) != u3.b(array[1])) {
                                                                                                                                    b10 = true;
                                                                                                                                    if (!d) {
                                                                                                                                        break Label_1732;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                b10 = false;
                                                                                                                                if (!d) {
                                                                                                                                    break Label_1732;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            final e l7 = e4.l();
                                                                                                                            while (l7.f()) {
                                                                                                                                h2.a(u3.b(l7.a()), true);
                                                                                                                                l7.g();
                                                                                                                                if (d) {
                                                                                                                                    break Label_1990;
                                                                                                                                }
                                                                                                                                if (d) {
                                                                                                                                    break;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            if (!b10) {
                                                                                                                                final e l8 = e4.l();
                                                                                                                                while (l8.f()) {
                                                                                                                                    h2.a(u3.b(l8.a()), true);
                                                                                                                                    l8.g();
                                                                                                                                    if (d) {
                                                                                                                                        break Label_1990;
                                                                                                                                    }
                                                                                                                                    if (d) {
                                                                                                                                        break Label_1800;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                break Label_1983;
                                                                                                                            }
                                                                                                                            break Label_1983;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    if (e4.c() != 2 || e4.b() != 2) {
                                                                                                                        continue Label_1732_Outer;
                                                                                                                    }
                                                                                                                    if (u3.b(array[0]) == u3.b(array[1]) && u3.b(array2[0]) == u3.b(array2[1])) {
                                                                                                                        continue Label_1732;
                                                                                                                    }
                                                                                                                    b10 = false;
                                                                                                                    if (d) {
                                                                                                                        continue Label_1732_Outer;
                                                                                                                    }
                                                                                                                    break;
                                                                                                                }
                                                                                                                continue Label_1732;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    final e l9 = e4.l();
                                                                                                    while (l9.f()) {
                                                                                                        t5.a(e4, q6);
                                                                                                        final y.c.d a18 = l9.a();
                                                                                                        final Object b11 = u2.b(a18);
                                                                                                        final y.c.d d14 = (y.c.d)u3.b(a18);
                                                                                                        final ArrayList list4 = (ArrayList)u.b(d14);
                                                                                                        final Object value = list4.get(0);
                                                                                                        final Object value2 = list4.get(list4.size() - 1);
                                                                                                        c2 = d14.c();
                                                                                                        if (d) {
                                                                                                            continue Label_1990;
                                                                                                        }
                                                                                                        final boolean b12 = c2 == q6 && b11 == value;
                                                                                                        final boolean b13 = d14.d() == q6 && b11 == value2;
                                                                                                        if (!b12 && !b13) {
                                                                                                            h2.a(d14, true);
                                                                                                        }
                                                                                                        l9.g();
                                                                                                        if (d) {
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                    break Label_1983;
                                                                                                }
                                                                                                if (d) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            o8 = t4.b(e4);
                                                                                            continue;
                                                                                        }
                                                                                    }
                                                                                    o5.g();
                                                                                }
                                                                                if (d) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                            continue;
                                                                        }
                                                                    }
                                                                    h.a(n4.h(a5), d3);
                                                                    p4.g();
                                                                    if (d) {
                                                                        break;
                                                                    }
                                                                }
                                                                x.u();
                                                                continue;
                                                            }
                                                        }
                                                        final i l = new i();
                                                        continue;
                                                    }
                                                }
                                                if (t3.d(e3)) {
                                                    y.add(e3);
                                                    x.c(e3);
                                                }
                                                o3.g();
                                                if (d) {
                                                    break;
                                                }
                                            }
                                            x.a(t3);
                                            a(x);
                                            continue;
                                        }
                                    }
                                    hashMap = (HashMap<Object, q>)hashMap2;
                                    continue;
                                }
                            }
                            final double floor4 = Math.floor(x.q(e2));
                            final b[] array3 = { (b)f2.a(floor - n2, floor2 - n2), (b)f2.a(floor + floor3 + 2.0 * n2, floor2 - n2), (b)f2.a(floor + floor3 + 2.0 * n2, floor2 + floor4 + 2.0 * n2), (b)f2.a(floor - n2, floor2 + floor4 + 2.0 * n2) };
                            int n13 = 0;
                            while (n13 < array3.length) {
                                array3[n13].g();
                                ++n13;
                                if (d) {
                                    continue Label_0179;
                                }
                                if (d) {
                                    break;
                                }
                            }
                            t.a(e2, f2.a(array3));
                            o2.g();
                            if (d) {
                                break;
                            }
                        }
                        final X x2 = x;
                        continue;
                    }
                }
                final Object a19 = a(n, k, f2);
                t2.a(e, a19);
                ArrayList<ArrayList> list5 = (ArrayList<ArrayList>)hashMap.get(a19);
                if (list5 == null) {
                    list5 = new ArrayList<ArrayList>();
                    hashMap.put(a19, (q)list5);
                }
                list5.add((ArrayList)e);
                o.g();
                if (d) {
                    break;
                }
            }
            continue;
        }
    }
    
    public void a() {
        this.b.b();
        this.b.e();
    }
    
    public static void a(final X x) {
        final boolean d = N.d;
        final y.d.b.n f = y.d.b.n.f();
        final x o = x.o();
        while (o.f()) {
            a(x, o.e(), f);
            o.g();
            if (d) {
                break;
            }
        }
    }
    
    private static void a(final X x, final q q, final l l) {
        final boolean d = N.d;
        final HashMap<Object, ArrayList> hashMap = new HashMap<Object, ArrayList>();
        final HashMap<Object, ArrayList> hashMap2 = new HashMap<Object, ArrayList>();
        final HashMap<Object, y.c.d> hashMap3 = new HashMap<Object, y.c.d>();
        final HashMap<Object, y.c.d> hashMap4 = new HashMap<Object, y.c.d>();
        final HashSet set = new HashSet();
        final ArrayList<Object> list = new ArrayList<Object>();
        e e = q.l();
        while (true) {
        Label_0197_Outer:
            while (e.f()) {
                y.c.d d2 = e.a();
                final Object a;
                Object o = a = a(x.l(d2).f(), l, hashMap, hashMap2, set, list);
                if (d) {
                    while (true) {
                        if (a != null) {
                            hashMap4.put(o, d2);
                        }
                        e.g();
                        if (!d) {
                            if (e.f()) {
                                d2 = e.a();
                                final Object a2;
                                o = (a2 = a(x.l(d2).g().f(), l, hashMap, hashMap2, set, list));
                                continue;
                            }
                        }
                        break;
                    }
                    for (final Object next : list) {
                        ArrayList a3 = hashMap.get(next);
                        ArrayList a4 = hashMap2.get(next);
                        if (a3 == null) {
                            a3 = y.f.h.d.a;
                        }
                        if (a4 == null) {
                            a4 = y.f.h.d.a;
                        }
                        if (a3.size() + a4.size() < 2) {
                            continue Label_0197_Outer;
                        }
                        y.g.e.a(a3, new y.f.h.h(l, null));
                        y.g.e.a(a4, new y.f.h.h(l, null));
                        final double n = 1.0 / q.a();
                        a(a3, l, -n, hashMap4, x, hashMap3);
                        a(a4, l, n, hashMap4, x, hashMap3);
                        if (d) {
                            break;
                        }
                    }
                    return;
                }
                if (a != null) {
                    hashMap3.put(o, d2);
                }
                e.g();
                if (d) {
                    break;
                }
            }
            e = q.k();
            continue;
        }
    }
    
    private static void a(final ArrayList list, final l l, final double n, final Map map, final X x, final Map map2) {
        final boolean d = N.d;
        int i = 0;
        while (i < list.size()) {
            final Object value = list.get(i);
            final z c = z.c(new z(l.k(l.c(value)).e(), l.l(l.c(value)).e(), l.k(l.d(value)).e(), l.l(l.d(value)).e()));
            c.b((i + 1) * n);
            if (map.get(value) != null) {
                final y.c.d d2 = map.get(value);
                x.d(d2, z.a(x.q(d2), c));
                final int n2 = x.b((Object)d2).pointCount() - 1;
                final t a = z.a(x.b((Object)d2).getPoint(n2), c);
                x.b((Object)d2).setPoint(n2, a.a(), a.b());
            }
            if (map2.get(value) != null) {
                final y.c.d d3 = map2.get(value);
                x.c(d3, z.a(x.p(d3), c));
                final t a2 = z.a(x.b((Object)d3).getPoint(0), c);
                x.b((Object)d3).setPoint(0, a2.a(), a2.b());
            }
            ++i;
            if (d) {
                break;
            }
        }
    }
    
    private static Object a(final t[] array, final l l, final Map map, final Map map2, final Set set, final ArrayList list) {
        final boolean d = N.d;
        if (array.length == 2) {
            return null;
        }
        final Object a = a(array[0], l);
        final Object a2 = a(array[1], l);
        final Object c = l.c(a, a2);
        boolean a3 = false;
        if (array.length > 2) {
            a3 = l.a(a, a2, a(array[2], l));
        }
        ArrayList<Object> list2 = a3 ? map.get(a) : map2.get(a);
        if (list2 == null) {
            list2 = new ArrayList<Object>();
            list2.add(c);
            Label_0161: {
                if (a3) {
                    map.put(a, list2);
                    if (!d) {
                        break Label_0161;
                    }
                }
                map2.put(a, list2);
            }
            if (!set.add(a)) {
                return c;
            }
            list.add(a);
            if (!d) {
                return c;
            }
        }
        if (l.b(l.d(list2.get(0)), a, a2)) {
            list2.add(c);
        }
        return c;
    }
    
    private static Object a(final t t, final l l) {
        return a(t.a(), t.b(), l);
    }
    
    private static Object a(final double n, final double n2, final l l) {
        final b b = (b)l.a((int)Math.floor(100.0 * n + 0.5) / 100.0, (int)Math.floor(100.0 * n2 + 0.5) / 100.0);
        b.g();
        return b;
    }
    
    static {
        a = new ArrayList();
    }
}
