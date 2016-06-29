package y.f.f.d;

import y.f.f.b.*;
import java.util.*;
import y.f.h.*;
import y.c.*;
import y.g.*;

public class o implements b
{
    protected i a;
    protected h b;
    protected y.c.h c;
    protected y.c.h d;
    protected y.c.h e;
    protected y.c.h f;
    protected y.c.h g;
    protected y.c.h h;
    protected y.c.h i;
    protected int j;
    protected static final Integer k;
    protected static final Integer l;
    protected static final Integer m;
    protected boolean n;
    protected v o;
    private boolean q;
    public static boolean p;
    
    public o() {
        this.j = 0;
        this.n = false;
        this.o = new q();
        this.q = false;
    }
    
    public void a(final h b) {
        this.b = b;
        this.a = b.a();
    }
    
    public void a(final boolean q) {
        this.q = q;
    }
    
    public int b() {
        return this.j;
    }
    
    public void a() {
        final y.c.h u = this.a.u();
        this.a(u);
        this.b.a(u, this.a.p().a(), y.f.f.b.o.a);
        this.a.a(u);
    }
    
    public void a(final y.c.h h) {
        final i i = new i();
        final y.c.h u = i.u();
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final A t = i.t();
        final y.c.q[] array = new y.c.q[2];
        this.a(i, this.a(i, u, list, array, t, list2), u, array, list, list2, h, t);
        if (this.q) {
            this.a(this.b, h);
        }
        i.a(u);
        i.a(t);
    }
    
    protected int a(final i i, final y.c.h h, final ArrayList list, final y.c.q[] array, final A a, final ArrayList list2) {
        final boolean p6 = y.f.f.d.o.p;
        this.f = this.a.u();
        this.g = this.a.u();
        this.c = this.a.u();
        this.d = this.a.u();
        this.e = this.a.u();
        final A t = this.a.t();
        final r g = this.b.g();
        this.i = i.u();
        this.h = i.u();
        final y.c.q d = i.d();
        a.a(d, "S");
        final y.c.q d2 = i.d();
        a.a(d2, "T");
        array[0] = d;
        array[1] = d2;
        int n = 0;
        final x o = this.a.o();
        while (true) {
        Label_0686_Outer:
            while (o.f()) {
                final y.c.q e = o.e();
                final y.c.q d3 = i.d();
                a.a(d3, "V(" + e + ")");
                t.a(e, d3);
                final int b = e.b();
                if (p6) {
                    int n2 = b;
                    y.f.h.q q = this.b.c();
                Label_0686:
                    while (true) {
                        while (q.f()) {
                            final p a2 = q.a();
                            final y.c.q d4 = i.d();
                            a.a(d4, "F(" + n2++ + ")");
                            final int j = a2.a().k();
                            if (p6) {
                            Label_0970:
                                while (true) {
                                    while (j != 0) {
                                        final p a3 = q.a();
                                        final y.c.q q2 = (y.c.q)g.b(a3);
                                        final e a4 = a3.a();
                                        while (a4.f()) {
                                            final d a5 = a4.a();
                                            final y.c.q q3 = (y.c.q)t.b(a5.c());
                                            final int c = a5.c().c();
                                            if (p6) {
                                                continue Label_0693;
                                            }
                                            if (c <= 4) {
                                                final d a6 = i.a(q3, q2);
                                                h.a(a6, y.f.f.d.o.k);
                                                Label_0850: {
                                                    if (this.b.b(a5.c())) {
                                                        list.add(new a(a6, 0));
                                                        if (!p6) {
                                                            break Label_0850;
                                                        }
                                                    }
                                                    list.add(new a(a6, 3));
                                                }
                                                this.f.a(a5, a6);
                                            }
                                            final d a7 = i.a(q2, (y.c.q)g.b(this.b.b(this.b.a(a5))));
                                            h.a(a7, y.f.f.d.o.l);
                                            this.c.a(a5, a7);
                                            list.add(new a(a7, 10000));
                                            a4.g();
                                            if (p6) {
                                                break;
                                            }
                                        }
                                        q.g();
                                        if (p6) {
                                            break;
                                        }
                                        break Label_0686;
                                    }
                                    break Label_0970;
                                    q.f();
                                    continue Label_0686_Outer;
                                }
                                final y.c.h u = this.a.u();
                                final x o2 = this.a.o();
                                while (o2.f()) {
                                    final y.c.q e2 = o2.e();
                                    final int b3;
                                    final boolean b2 = (b3 = (this.b.b(e2) ? 1 : 0)) != 0;
                                    if (p6) {
                                        return b3;
                                    }
                                    if (!b2) {
                                        if (!this.n || e2.b() > 4) {
                                            Object b4 = t.b(e2);
                                            I k = null;
                                            Object o3 = null;
                                            Object o4 = null;
                                            Object o5 = null;
                                            ArrayList<a> list3 = null;
                                        Label_1689:
                                            while (true) {
                                                final y.c.q q4 = (y.c.q)b4;
                                                final e l = e2.l();
                                                while (true) {
                                                    while (l.f()) {
                                                        final y.c.q d5 = i.d();
                                                        a.a(d5, "H(" + e2 + "," + a.b(g.b(this.b.b(l.a()))) + ")");
                                                        u.a(l.a(), d5);
                                                        final d a8 = i.a(d5, q4);
                                                        h.a(a8, y.f.f.d.o.k);
                                                        list.add(new a(a8, 1));
                                                        this.g.a(l.a(), a8);
                                                        l.g();
                                                        if (p6) {
                                                            d d6 = l.a();
                                                            k = null;
                                                            o3 = null;
                                                            o4 = null;
                                                            o5 = null;
                                                            list3 = new ArrayList<a>();
                                                            int n3 = 0;
                                                            while (n3 < e2.c()) {
                                                                l.b();
                                                                final d d7 = d6;
                                                                d6 = l.a();
                                                                final p b5 = this.b.b(d6);
                                                                final p b6 = this.b.b(d7);
                                                                final y.c.q d8 = i.d();
                                                                final y.c.q d9 = i.d();
                                                                a.a(d8, "NC-L (" + d7.d() + "," + e2 + ")");
                                                                a.a(d9, "NC-R (" + d7.d() + "," + e2 + ")");
                                                                final d a9 = i.a((y.c.q)g.b(b5), (y.c.q)u.b(d7));
                                                                h.a(a9, y.f.f.d.o.l);
                                                                this.e.a(d7, a9);
                                                                final d a10 = i.a((y.c.q)g.b(b6), (y.c.q)u.b(d6));
                                                                h.a(a10, y.f.f.d.o.l);
                                                                this.d.a(d7, a10);
                                                                final y.c.q q5 = (y.c.q)(b4 = k);
                                                                if (p6) {
                                                                    continue Label_1689;
                                                                }
                                                                if (q5 != null) {
                                                                    this.h.a(a9, k);
                                                                    this.i.a(k, a9);
                                                                }
                                                                if (o3 != null) {
                                                                    this.i.a(a10, o3);
                                                                    this.h.a(o3, a10);
                                                                }
                                                                o3 = a10;
                                                                k = a9;
                                                                if (o5 == null) {
                                                                    o5 = o3;
                                                                }
                                                                if (o4 == null) {
                                                                    o4 = k;
                                                                }
                                                                final a a11 = new a(1);
                                                                a11.a(a10);
                                                                a11.a(a9);
                                                                list.add(a11);
                                                                list3.add(a11);
                                                                ++n3;
                                                                if (p6) {
                                                                    break;
                                                                }
                                                            }
                                                            break Label_1689;
                                                        }
                                                        if (p6) {
                                                            break;
                                                        }
                                                    }
                                                    l.i();
                                                    continue;
                                                }
                                            }
                                            list2.add(list3);
                                            this.h.a(o4, k);
                                            this.i.a(k, o4);
                                            this.i.a(o5, o3);
                                            this.h.a(o3, o5);
                                        }
                                    }
                                    o2.g();
                                    if (p6) {
                                        break;
                                    }
                                }
                                this.a.a(u);
                                this.a.a(t);
                                return n;
                            }
                            if (j < 4 && this.b.d() != a2) {
                                final d a12 = i.a(d, d4);
                                h.a(a12, y.f.f.d.o.k);
                                list.add(new a(a12, 4 - a2.a().k()));
                                n += 4 - a2.a().k();
                            }
                            if (a2.a().k() > 4 && this.b.d() != a2) {
                                final d a13 = i.a(d4, d2);
                                h.a(a13, y.f.f.d.o.k);
                                list.add(new a(a13, a2.a().k() - 4));
                            }
                            if (this.b.d() == a2) {
                                final d a14 = i.a(d4, d2);
                                h.a(a14, y.f.f.d.o.k);
                                list.add(new a(a14, a2.a().k() + 4));
                            }
                            g.a(a2, d4);
                            q.g();
                            if (p6) {
                                break;
                            }
                        }
                        q = this.b.c();
                        continue Label_0686;
                    }
                }
                if (b < 4) {
                    final d a15 = i.a(d, d3);
                    h.a(a15, y.f.f.d.o.k);
                    list.add(new a(a15, 4 - e.b()));
                    n += 4 - e.b();
                }
                if (e.b() > 4) {
                    final d a16 = i.a(d3, d2);
                    h.a(a16, y.f.f.d.o.k);
                    list.add(new a(a16, e.b() - 4));
                }
                o.g();
                if (p6) {
                    break;
                }
            }
            continue;
        }
    }
    
    protected double a(final i i, final int n, final y.c.h h, final y.c.q[] array, final ArrayList list, final ArrayList list2, final y.c.h h2, final A a) {
        final boolean p8 = y.f.f.d.o.p;
        final al al = new al();
        final y.c.h u = i.u();
        final double n2 = this.o.a(i, array[0], array[1], h, u, n, list, list2, this.h, this.i);
        y.g.o.a(this, "---> Solving Network took " + al);
        al.e();
        final StringBuffer sb = new StringBuffer(12);
        final e p9 = this.a.p();
        while (p9.f()) {
            final d a2 = p9.a();
            final d a3 = this.b.a(p9.a());
            sb.setLength(0);
            final Object b = this.e.b(a2);
            if (p8) {
                return n2;
            }
            final int n3 = (b != null) ? u.a(b) : 0;
            final Object b2 = this.d.b(a2);
            a(sb, (b2 != null) ? u.a(b2) : 0, '<');
            a(sb, n3, '>');
            final int a4 = u.a(this.c.b(a2));
            a(sb, u.a(this.c.b(a3)), '>');
            a(sb, a4, '<');
            final Object b3 = this.e.b(a3);
            final int n4 = (b3 != null) ? u.a(b3) : 0;
            final Object b4 = this.d.b(a3);
            final int n5 = (b4 != null) ? u.a(b4) : 0;
            a(sb, n4, '<');
            a(sb, n5, '>');
            this.j += sb.length();
            h2.a(a2, sb.toString());
            final Object b5 = this.f.b(a2);
            final int n6 = (b5 != null) ? u.a(b5) : 0;
            final Object b6 = this.g.b(a2);
            this.b.a(a2, n6 - ((b6 != null) ? u.a(b6) : 0) + 1);
            p9.g();
            if (p8) {
                break;
            }
        }
        y.g.o.a(this, 1, "Number of bends: " + this.j / 2);
        this.j /= 2;
        y.g.o.a(this, 3, "---> Parsing Network solution took " + al);
        this.a.a(this.f);
        this.a.a(this.g);
        this.a.a(this.c);
        this.a.a(this.d);
        this.a.a(this.e);
        return n2;
    }
    
    protected void a(final h h, final y.c.h h2) {
        final boolean p2 = y.f.f.d.o.p;
        final y.f.h.q c = h.c();
    Label_0172_Outer:
        while (c.f()) {
            d d = null;
            final p a = c.a();
            final e a2 = a.a();
            int n = 0;
            int n2 = 0;
            int n3 = 0;
            int a3 = 0;
            while (true) {
                while (a2.f()) {
                    final d a4 = a2.a();
                    final int a5 = a4.c().a();
                    final int n4 = 4;
                    if (!p2) {
                        Label_0154: {
                            if (a5 == n4) {
                                ++n;
                                if (!p2) {
                                    break Label_0154;
                                }
                            }
                            if (a4.c().a() == 6) {
                                ++n2;
                                if (d != null) {
                                    break Label_0154;
                                }
                                d = a4;
                                a3 = 6;
                                if (!p2) {
                                    break Label_0154;
                                }
                            }
                            if (a4.c().a() > a3) {
                                d = a4;
                                a3 = a4.c().a();
                            }
                        }
                        ++n3;
                        a2.g();
                        if (p2) {
                            break;
                        }
                        continue Label_0172_Outer;
                    }
                    else {
                        Label_0559: {
                            if ((a5 > n4 && n > 0) || n2 > 0) {
                                final d[] array = new d[n3];
                                int n5 = 0;
                                int n6 = 0;
                                final e a6 = a.a();
                                Label_0249: {
                                    if (d != null) {
                                        while (a6.a() != d) {
                                            a6.b();
                                            if (p2) {
                                                break Label_0249;
                                            }
                                            if (p2) {
                                                break;
                                            }
                                        }
                                    }
                                    a6.c();
                                }
                                p b = h.b(h.a(a6.a()));
                                a6.b();
                                int i = 0;
                                while (true) {
                                    while (i < n3) {
                                        final d a7 = a6.a();
                                        final int a8 = a7.c().a();
                                        final p b2 = h.b(h.a(a7));
                                        final Object b3 = h2.b(a7);
                                        final int n7 = (b3 instanceof String) ? 1 : 0;
                                        if (!p2) {
                                            final boolean b4 = n7 != 0 && ((String)b3).length() > 0;
                                            final int n8 = h.d(a7) - 2;
                                            final boolean b5 = n8 < -1 || n8 > 1;
                                            if (b2 != b || b4 || b5) {
                                                if (n5 > 0) {
                                                    this.a(h2, array, n5, n6, a, b);
                                                }
                                                n5 = 0;
                                                n6 = 0;
                                                b = b2;
                                            }
                                            Label_0520: {
                                                if (!b5 && (n5 == 0 || a8 == 4 || a8 == 6) && !b4) {
                                                    if (n5 > 0) {
                                                        n6 += n8;
                                                    }
                                                    array[n5++] = a7;
                                                    if (!p2) {
                                                        break Label_0520;
                                                    }
                                                }
                                                if (n5 > 0) {
                                                    this.a(h2, array, n5, n6, a, b);
                                                }
                                                n5 = 0;
                                                n6 = 0;
                                                b = b2;
                                            }
                                            a6.b();
                                            ++i;
                                            if (p2) {
                                                break;
                                            }
                                            continue Label_0172_Outer;
                                        }
                                        else {
                                            if (n7 > 0) {
                                                this.a(h2, array, n5, n6, a, b);
                                            }
                                            break Label_0559;
                                        }
                                    }
                                    continue;
                                }
                            }
                        }
                        c.g();
                        if (p2) {
                            break Label_0172_Outer;
                        }
                        continue Label_0172_Outer;
                    }
                }
                continue;
            }
        }
        final x o = this.a.o();
        while (o.f()) {
            final y.c.q e = o.e();
            if (e.a() == 4) {
                final d f = e.f();
                final d h3 = e.h();
                if (h.b(f) == h.b(h3)) {
                    h.a(f, 2);
                    h.a(h3, 2);
                }
            }
            o.g();
            if (p2) {
                break;
            }
        }
    }
    
    private final void a(final y.c.h h, final d[] array, final int n, int i, final p p6, final p p7) {
        final boolean p8 = y.f.f.d.o.p;
        if (n <= 1) {
            return;
        }
        final d d = array[0];
        d d2 = (d.i() == null) ? d.c().h() : d.i();
        if (this.b.b(d2) != p7 && d.c().a() == 6) {
            d2 = ((d2.i() == null) ? d2.c().h() : d2.i());
        }
        Label_0272: {
            if (this.b.b(d2) == p7) {
                while (true) {
                    while (i < 0) {
                        final int d3 = this.b.d(d);
                        final int n2 = 1;
                        if (!p8) {
                            if (d3 <= n2 || this.b.d(d2) >= 3) {
                                break;
                            }
                            ++i;
                            this.b.a(d, this.b.d(d) - 1);
                            this.b.a(d2, this.b.d(d2) + 1);
                            if (p8) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (d3 <= n2 || this.b.d(d) >= 3) {
                                break Label_0272;
                            }
                            --i;
                            this.b.a(d, this.b.d(d) + 1);
                            this.b.a(d2, this.b.d(d2) - 1);
                            if (p8) {
                                break Label_0272;
                            }
                            break;
                        }
                    }
                    if (i > 0) {
                        this.b.d(d2);
                        continue;
                    }
                    break;
                }
            }
        }
        final d d4 = array[n - 1];
        final y.c.q d5 = d4.d();
        final d a = this.b.a(d4);
        d d6 = d5.f();
    Label_0460_Outer:
        while (true) {
            while (true) {
            Label_0524:
                while (true) {
                    while (this.b.b(d6) != p6) {
                        d6 = d6.g();
                        if (!p8) {
                            if (p8) {
                                break;
                            }
                            continue Label_0460_Outer;
                        }
                        else {
                            final int n3 = 1;
                            int j = n3;
                            while (j < n) {
                                final y.c.q c = array[j].c();
                                final d d7 = array[j];
                                if (p8) {
                                    return;
                                }
                                final d d8 = (d7.i() == null) ? c.h() : d7.i();
                                if (this.b.b(d8) != p7) {
                                    throw new IllegalStateException("Wrong face!");
                                }
                                final int d9 = this.b.d(d7);
                                int n4 = 0;
                                Label_0664: {
                                    if (i < 0) {
                                        ++i;
                                        n4 = 1;
                                        if (!p8) {
                                            break Label_0664;
                                        }
                                    }
                                    if (i > 0) {
                                        if (c.a() == 4) {
                                            --i;
                                            n4 = 3;
                                            if (!p8) {
                                                break Label_0664;
                                            }
                                        }
                                        n4 = 2;
                                        if (!p8) {
                                            break Label_0664;
                                        }
                                    }
                                    n4 = 2;
                                }
                                final int n5 = n4 - d9;
                                Label_0880: {
                                    if (n5 != 0) {
                                        final int d10 = this.b.d(d8);
                                        if (d10 - n5 >= 1 && d10 - n5 < 4) {
                                            this.b.a(d8, d10 - n5);
                                            this.b.a(d7, d9 + n5);
                                            if (!p8) {
                                                break Label_0880;
                                            }
                                        }
                                        if (c.a() != 6) {
                                            throw new IllegalStateException("Incompatible degree!");
                                        }
                                        final d d11 = (d8.i() == null) ? c.h() : d8.i();
                                        if (this.b.b(d11) != p7) {
                                            throw new IllegalStateException("Wrong face!");
                                        }
                                        final int d12 = this.b.d(d11);
                                        if (d12 - n5 >= 1 && d12 - n5 < 4) {
                                            this.b.a(d11, d12 - n5);
                                            this.b.a(d7, d9 + n5);
                                            if (!p8) {
                                                break Label_0880;
                                            }
                                        }
                                        throw new IllegalStateException("Could not assign new angle!");
                                    }
                                }
                                ++j;
                                if (p8) {
                                    break;
                                }
                            }
                            if (i != 0) {
                                throw new IllegalStateException("Could not compensate directions changes.");
                            }
                            return;
                        }
                    }
                    if (d6 == d4 || this.b.b(a) != p7) {
                        continue Label_0524;
                    }
                    while (i < 0) {
                        final int d13 = this.b.d(d6);
                        final int n6 = 1;
                        if (!p8) {
                            if (d13 <= n6 || this.b.d(a) >= 3) {
                                break;
                            }
                            ++i;
                            this.b.a(d6, this.b.d(d6) - 1);
                            this.b.a(a, this.b.d(a) + 1);
                            if (p8) {
                                break;
                            }
                            continue Label_0460_Outer;
                        }
                        else {
                            if (d13 <= n6 || this.b.d(d6) >= 3) {
                                continue Label_0524;
                            }
                            --i;
                            this.b.a(d6, this.b.d(d6) + 1);
                            this.b.a(a, this.b.d(a) - 1);
                            if (p8) {
                                continue Label_0524;
                            }
                            break;
                        }
                    }
                    if (i <= 0) {
                        continue Label_0524;
                    }
                    break;
                }
                final int d14;
                final int n3 = d14 = this.b.d(a);
                if (!p8) {
                    continue;
                }
                break;
            }
            continue Label_0460_Outer;
        }
    }
    
    protected static void a(final StringBuffer sb, final int n, final char c) {
        final boolean p3 = o.p;
        int i = 0;
        while (i < n) {
            sb.append(c);
            ++i;
            if (p3) {
                break;
            }
        }
    }
    
    static {
        k = new Integer(0);
        l = new Integer(1);
        m = new Integer(3);
    }
}
