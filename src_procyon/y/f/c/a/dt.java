package y.f.c.a;

import y.g.*;
import y.a.*;
import java.util.*;
import y.c.*;

class dt extends cA implements bR
{
    private final boolean c;
    private dA d;
    private dA e;
    
    dt(final boolean c) {
        this.c = c;
    }
    
    public void a() {
        if (this.e != null) {
            throw new IllegalStateException("Internal sequence constraints not disposed.");
        }
        this.d = null;
    }
    
    public boolean a(final i i, final q q, final q q2) {
        if (this.d == null) {
            return false;
        }
        if (this.d.a(q) || this.d.a(q2)) {
            return false;
        }
        final q c = this.d.c(q);
        final q c2 = this.d.c(q2);
        if (c == null) {
            return c2 != null && dA.a(this.d, c2).b();
        }
        final dy a = dA.a(this.d, c);
        if (c2 == null) {
            return a.a();
        }
        final dy a2 = dA.a(this.d, c2);
        if (a.c > -1) {
            if (a2.c > -1) {
                return dA.b(this.d)[a.c][a2.c];
            }
            return a.a();
        }
        else {
            if (a2.c > -1) {
                return a2.b();
            }
            return a.b != a2.b;
        }
    }
    
    public void a(final i i, final int[] array, final int[] array2) {
        final boolean x = N.x;
        if (this.d == null) {
            throw new IllegalStateException("SequenceConstraintSupport has not been initialized.");
        }
        final i c = dA.c(this.d);
        final q d = dA.d(this.d);
        final int[] array3 = new int[c.f()];
        final int[] array4 = new int[c.f()];
        int n = Integer.MIN_VALUE;
        int n2 = Integer.MAX_VALUE;
        int n3 = Integer.MIN_VALUE;
        final A t = c.t();
        final int a = h.a(c, t);
        final J j = new J(c, t);
        final A t2 = c.t();
        j.a();
        int k = 0;
        while (true) {
            while (k < a) {
                final Integer n4 = new Integer(k);
                j.b(n4);
                a(c, t2);
                j.a(n4);
                ++k;
                if (x) {
                    final x o = c.o();
                    while (true) {
                    Label_0494:
                        while (true) {
                            while (o.f()) {
                                final int a2 = t2.a(o.e());
                                array3[o.e().d()] = a2;
                                final int n5 = n3;
                                final int n6 = a2;
                                if (x) {
                                    final int n7 = n5 + n6;
                                    final int n8 = n2 - n7;
                                    final x o2 = i.o();
                                    while (o2.f()) {
                                        final q c2 = this.d.c(o2.e());
                                        final int n9 = (c2 != null && !this.d.a(o2.e())) ? c2.d() : -1;
                                        Label_0642: {
                                            if (n9 > -1) {
                                                array[o2.e().d()] = array3[n9];
                                                array2[o2.e().d()] = array4[n9];
                                                if (!x) {
                                                    break Label_0642;
                                                }
                                            }
                                            array[o2.e().d()] = n7;
                                            array2[o2.e().d()] = n8;
                                        }
                                        o2.g();
                                        if (x) {
                                            break;
                                        }
                                    }
                                    return;
                                }
                                if (n5 < n6) {
                                    n3 = a2;
                                }
                                o.g();
                                if (x) {
                                    break;
                                }
                            }
                            c.a(t2);
                            final x o3 = c.o();
                            while (o3.f()) {
                                final q e = o3.e();
                                int n10 = n3 + 1;
                                final q q = e;
                                if (x) {
                                    if (q.b() == 0) {
                                        n = -1;
                                    }
                                    if (d.c() == 0) {
                                        n2 = n3 + 1;
                                    }
                                    continue Label_0494;
                                }
                                final e l = q.l();
                                while (l.f()) {
                                    final int d2 = l.a().d().d();
                                    final int n11 = n10;
                                    final int n12 = array3[d2];
                                    if (x) {
                                        continue Label_0494;
                                    }
                                    if (n11 > n12) {
                                        n10 = array3[d2];
                                    }
                                    l.g();
                                    if (x) {
                                        break;
                                    }
                                }
                                array4[e.d()] = n10 - array3[e.d()];
                                final dy a3 = dA.a(this.d, e);
                                Label_0454: {
                                    if (a3.a()) {
                                        if (n >= array3[e.d()]) {
                                            break Label_0454;
                                        }
                                        n = array3[e.d()];
                                        if (!x) {
                                            break Label_0454;
                                        }
                                    }
                                    if (a3.b() && n2 > array3[e.d()]) {
                                        n2 = array3[e.d()];
                                    }
                                }
                                o3.g();
                                if (x) {
                                    break;
                                }
                            }
                            break;
                        }
                        continue;
                    }
                }
                if (x) {
                    break;
                }
            }
            j.b();
            continue;
        }
    }
    
    private static void a(final i i, final A a) {
        final boolean x = N.x;
        final x a2 = m.a(i).a();
        do {
            Label_0015: {
                a2.f();
            }
            int j = 0;
            Label_0021:
            while (j != 0) {
                final q e = a2.e();
                int n = -1;
                final e k = e.k();
                while (k.f()) {
                    final int a3 = a.a(k.a().c());
                    j = n;
                    if (x) {
                        continue Label_0021;
                    }
                    if (j < a3) {
                        n = a3;
                    }
                    k.g();
                    if (x) {
                        break;
                    }
                }
                a.a(e, ++n);
                a2.g();
                continue Label_0015;
            }
            break;
        } while (!x);
    }
    
    public void a(final i i, final aU au, final aV av) {
        final boolean x = N.x;
        if (this.d == null) {
            return;
        }
        if (!this.a(new dB(au), null)) {
            return;
        }
        final du du = new du(this);
        q[] array = new q[0];
        int j = 0;
        final int b = au.b();
    Label_0161_Outer:
        while (j < b) {
            final y d = au.a(j).d();
            if (array.length < d.size()) {
                array = new q[d.size()];
            }
            int n = 0;
            p p3 = d.k();
            while (true) {
                while (p3 != null) {
                    array[n++] = (q)p3.c();
                    p3 = p3.a();
                    if (x) {
                        p p4 = d.k();
                        while (true) {
                            while (p4 != null) {
                                p4.a(array[n++]);
                                p4 = p4.a();
                                if (!x) {
                                    if (x) {
                                        break;
                                    }
                                    continue Label_0161_Outer;
                                }
                                else {
                                    if (x) {
                                        break Label_0161_Outer;
                                    }
                                    continue Label_0161_Outer;
                                }
                            }
                            au.a(j).a(d);
                            ++j;
                            continue;
                        }
                    }
                    if (x) {
                        break;
                    }
                }
                y.g.e.a(array, 0, n, du);
                n = 0;
                continue;
            }
        }
    }
    
    public Comparator a(final i i, final D[] array, final int[] array2) {
        if (this.d == null) {
            throw new IllegalStateException("SequenceConstraintSupport has not been initialized.");
        }
        this.a(new dz(array), array2);
        return new dv(this);
    }
    
    private boolean a(final Iterator iterator, final int[] array) {
        final boolean x = N.x;
        final i c = dA.c(this.d);
        boolean b = false;
        final HashSet set = new HashSet<d>();
        final D d = new D();
    Label_0314:
        while (iterator.hasNext()) {
            Object o = iterator.next();
        Label_0049:
            while (true) {
                final D d2 = (D)o;
                if (d2.size() < 2) {
                    break;
                }
                Iterator iterator2 = null;
                Label_0125: {
                    if (array != null) {
                        final q[] array2 = new q[d2.size()];
                        d2.toArray(array2);
                        y.g.e.a(array2, new dw(this, array));
                        iterator2 = new dz(array2);
                        if (!x) {
                            break Label_0125;
                        }
                    }
                    iterator2 = d2.iterator();
                }
                final y y = new y();
                y.add(iterator2.next());
                while (iterator2.hasNext()) {
                    final q q = iterator2.next();
                    final x x2 = (x)(o = y.a());
                    if (x) {
                        continue Label_0049;
                    }
                    final x x3 = x2;
                    while (x3.f()) {
                        final q e = x3.e();
                        q q2 = this.d.c(e);
                        final D d3 = (D)(o = q2);
                        if (x) {
                            continue Label_0049;
                        }
                        if (d3 == null) {
                            q2 = this.d.d(e);
                        }
                        q q3 = this.d.c(q);
                        if (q3 == null) {
                            q3 = this.d.d(q);
                        }
                        final d a = c.a(q2, q3);
                        set.add(a);
                        d.add(a);
                        x3.g();
                        if (x) {
                            break;
                        }
                    }
                    y.add(q);
                    if (x) {
                        break Label_0314;
                    }
                }
                break;
            }
        }
        int[] e2 = dA.e(this.d);
        if (e2.length < c.f()) {
            e2 = new int[c.f()];
        }
        Label_0562: {
            if (!m.a(c, e2)) {
                b = true;
                final y.c.h u = c.u();
                final y.c.h u2 = c.u();
                final int n = 2 * set.size();
                final e p2 = c.p();
                while (p2.f()) {
                    Label_0446: {
                        if (set.contains(p2.a())) {
                            u2.a(p2.a(), 1.0);
                            if (!x) {
                                break Label_0446;
                            }
                        }
                        u2.a(p2.a(), (double)n);
                    }
                    p2.g();
                    if (x) {
                        break;
                    }
                }
                y.a.c.a(c, u, u2);
                final Iterator<d> iterator3 = d.iterator();
                while (iterator3.hasNext()) {
                    final d d4 = iterator3.next();
                    if (u.d(d4)) {
                        c.a(d4);
                        iterator3.remove();
                        if (x) {
                            break Label_0562;
                        }
                        if (x) {
                            break;
                        }
                        continue;
                    }
                }
                if (!m.a(c, e2)) {
                    throw new IllegalArgumentException("Cyclic sequence constraints!");
                }
            }
            dA.a(this.d, e2);
        }
        final Iterator<d> iterator4 = d.iterator();
        while (iterator4.hasNext()) {
            c.a(iterator4.next());
            if (x) {
                break;
            }
        }
        return b;
    }
    
    public void b(final i i, final aV av, final boolean b) {
        if (this.e != null) {
            this.d = this.e.a(this.d);
            this.e = null;
        }
        this.d.b();
    }
    
    public void a(final i i, final aV av, final boolean b) {
        this.e = this.d;
        (this.d = new dA(i, av, b, this.c)).a();
    }
    
    static dA a(final dt dt) {
        return dt.d;
    }
}
