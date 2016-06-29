package y.f.c.a;

import y.g.*;
import y.c.*;
import y.f.*;
import y.d.*;
import java.util.*;

class cB
{
    private static final Object a;
    private static final Comparator b;
    private boolean c;
    private F d;
    
    public cB(final F d) {
        this.c = false;
        this.d = d;
        this.c = true;
    }
    
    static void a(final cB cb, final i i) {
        i.a(cB.a, q.a(cb));
    }
    
    static void a(final i i) {
        if (i != null && i.c(cB.a) != null) {
            i.d_(cB.a);
        }
    }
    
    static cB b(final i i) {
        final c c = i.c(cB.a);
        if (c == null) {
            return null;
        }
        return (cB)c.b(i);
    }
    
    public List a(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        if (!this.b(x)) {
            return null;
        }
        final ArrayList<aQ> list = new ArrayList<aQ>(60);
        final c a = this.a(x);
        int i = 0;
    Label_0036:
        while (true) {
        Label_0265_Outer:
            while (i < au.b()) {
                final aQ a2 = au.a(i);
                final int c = this.c ? 1 : 0;
                if (!x2) {
                    boolean b = c == 0;
                    p p4 = a2.d().k();
                Label_0265:
                    while (true) {
                        while (p4 != null) {
                            final boolean b2 = b;
                            if (!x2) {
                                if (b2) {
                                    break;
                                }
                                final y.c.q q = (y.c.q)p4.c();
                                if (av.a(q).b() != 1) {
                                    d d = q.f();
                                    while (d != null) {
                                        final boolean b3 = b;
                                        if (x2) {
                                            break Label_0265;
                                        }
                                        if (b3) {
                                            break;
                                        }
                                        final aX a3 = av.a(d.d());
                                        S[] array = null;
                                        Label_0218: {
                                            if (a3.b() == 1) {
                                                array = (S[])a.b(a3.g());
                                                if (!x2) {
                                                    break Label_0218;
                                                }
                                            }
                                            array = (S[])a.b(d);
                                        }
                                        if (array != null && array.length > 0) {
                                            b = true;
                                            if (!x2) {
                                                break;
                                            }
                                        }
                                        d = d.g();
                                        if (x2) {
                                            break;
                                        }
                                    }
                                }
                                p4 = p4.a();
                                if (x2) {
                                    break;
                                }
                                continue Label_0265_Outer;
                            }
                            if (!b2 || b) {
                                if (i < au.b() - 1) {
                                    ++i;
                                    list.add(ap.a(true, i));
                                }
                            }
                            ++i;
                            if (x2) {
                                break Label_0265_Outer;
                            }
                            continue Label_0036;
                        }
                        final boolean c2 = this.c;
                        continue Label_0265;
                    }
                }
                final y.c.q[] array2 = new y.c.q[c];
                final A t = x.t();
                x.a(this.getClass().getName() + ".map", t);
                final e p5 = x.p();
                do {
                    Label_0372: {
                        p5.f();
                    }
                    byte e = 0;
                    Label_0379:
                    while (e != 0) {
                        final d a4 = p5.a();
                        final aX a5 = av.a(a4.c());
                        final aX a6 = av.a(a4.d());
                        if (!x2) {
                            if (a5.b() != 1 && a6.b() == 1) {
                                final d g = a6.g();
                                final y.f.c.a.A a7 = av.a(g);
                                final S[] a8 = this.a(x, g);
                                if (a8 != null && a8.length > 0) {
                                    int n = 0;
                                    d f = a4;
                                    aX ax = av.a(f.d());
                                    while (ax.b() == 1) {
                                        final y.c.q d2 = f.d();
                                        final byte b4 = e = au.a(ax.j()).e();
                                        if (x2) {
                                            continue Label_0379;
                                        }
                                        if (e == 0 || b4 == 1) {
                                            array2[n++] = d2;
                                        }
                                        f = d2.f();
                                        ax = av.a(f.d());
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    if (n < 1) {
                                        throw new IllegalStateException("Did not find edge label position");
                                    }
                                    final boolean j = a7.i();
                                    int k = 0;
                                    while (k < a8.length) {
                                        final aG f2 = a8[k].f();
                                        final boolean l;
                                        final boolean b5 = l = f2.i();
                                        if (x2) {
                                            continue Label_0379;
                                        }
                                        y.c.q q2 = null;
                                        Label_0758: {
                                            if (b5) {
                                                q2 = array2[j ? (n - 1) : 0];
                                                if (!x2) {
                                                    break Label_0758;
                                                }
                                            }
                                            if (f2.j()) {
                                                q2 = array2[n / 2];
                                                if (!x2) {
                                                    break Label_0758;
                                                }
                                            }
                                            if (f2.k()) {
                                                q2 = array2[j ? 0 : (n - 1)];
                                                if (!x2) {
                                                    break Label_0758;
                                                }
                                            }
                                            if (a(f2) == 0) {
                                                q2 = array2[n / 2];
                                                if (!x2) {
                                                    break Label_0758;
                                                }
                                            }
                                            q2 = array2[0];
                                        }
                                        this.a(q2, a8[k], t);
                                        ++k;
                                        if (x2) {
                                            break;
                                        }
                                    }
                                }
                            }
                            p5.g();
                            continue Label_0372;
                        }
                        return list;
                    }
                    break;
                } while (!x2);
                this.a(x, av, t);
                return list;
            }
            au.b();
            continue;
        }
    }
    
    protected c a(final X x) {
        return x.c(U.a);
    }
    
    private void a(final y.c.q q, final S s, final A a) {
        List<S> list = (List<S>)a.b(q);
        if (list == null) {
            list = new ArrayList<S>(6);
            a.a(q, list);
        }
        list.add(s);
    }
    
    private void a(final X x, final aV av, final A a) {
        final boolean x2 = N.x;
        final ArrayList<Object> list = new ArrayList<Object>(10);
        final ArrayList<Object> list2 = new ArrayList<Object>(10);
        final ArrayList<Object> list3 = new ArrayList<Object>(10);
        final x o = x.o();
    Label_0961:
        do {
            boolean f = o.f();
        Label_0315_Outer:
            while (f) {
                final y.c.q e = o.e();
                final List list4 = (List)a.b(e);
                Label_0954: {
                    if (list4 != null) {
                        final S[] array = list4.toArray(new S[list4.size()]);
                        final d g = av.a(e).g();
                        if (g == null) {
                            throw new IllegalStateException("realEdge == null: Cannot be!!!");
                        }
                        final int i = av.a(g).i() ? 1 : 0;
                        double max = 0.0;
                        double max2 = 0.0;
                        double max3 = 0.0;
                        int j = 0;
                        while (true) {
                            while (j < array.length) {
                                final S s = array[j];
                                final double n2;
                                final int n = (int)(n2 = i);
                                if (!x2) {
                                    this.d.a(x, s, (n != 0) ? y.a : y.c);
                                    final aG f2 = s.f();
                                    Label_0298: {
                                        if (f2.m()) {
                                            max3 = Math.max(max3, s.b());
                                            if (!x2) {
                                                break Label_0298;
                                            }
                                        }
                                        if (((f2.l() ? 1 : 0) ^ i) != 0x0) {
                                            max = Math.max(max, s.b() + this.a(s));
                                            if (!x2) {
                                                break Label_0298;
                                            }
                                        }
                                        max2 = Math.max(max2, s.b() + this.a(s));
                                    }
                                    ++j;
                                    if (x2) {
                                        break;
                                    }
                                    continue Label_0315_Outer;
                                }
                                else {
                                    if (n2 > 0) {
                                        max = max3 / 2.0;
                                    }
                                    if (max3 > max2 * 2.0) {
                                        max2 = max3 / 2.0;
                                    }
                                    final byte[] array2 = { 1, 4, 0, 2 };
                                    double max4 = 0.0;
                                    int n3 = 0;
                                Label_0804:
                                    do {
                                        double a2 = n3;
                                    Label_0796:
                                        while (true) {
                                            int length = array2.length;
                                        Label_0378:
                                            while (a2 < length) {
                                                list.clear();
                                                list2.clear();
                                                list3.clear();
                                                final int n4 = (f = false) ? 1 : 0;
                                                if (!x2) {
                                                    int k = n4;
                                                    while (k < array.length) {
                                                        final S s2 = array[k];
                                                        final aG f3 = s2.f();
                                                        final byte b = (byte)(a2 = a(f3));
                                                        final byte b2 = (byte)(length = array2[n3]);
                                                        if (x2) {
                                                            continue Label_0378;
                                                        }
                                                        Label_0513: {
                                                            if (b == b2) {
                                                                if (f3.m()) {
                                                                    list3.add(s2);
                                                                    if (!x2) {
                                                                        break Label_0513;
                                                                    }
                                                                }
                                                                if (((f3.l() ? 1 : 0) ^ i) != 0x0) {
                                                                    list.add(s2);
                                                                    if (!x2) {
                                                                        break Label_0513;
                                                                    }
                                                                }
                                                                list2.add(s2);
                                                            }
                                                        }
                                                        ++k;
                                                        if (x2) {
                                                            break;
                                                        }
                                                    }
                                                    double n5 = max4;
                                                    double n6 = max4;
                                                    int l = 0;
                                                    while (true) {
                                                        while (l < list.size()) {
                                                            final double n7 = dcmpl(n5, 0.0);
                                                            if (x2) {
                                                                double n8 = n7;
                                                                while (true) {
                                                                    while (n8 < list2.size()) {
                                                                        final double n9 = dcmpl(n6, 0.0);
                                                                        if (x2) {
                                                                            double n10 = n9;
                                                                            while (n10 < list3.size()) {
                                                                                final double n11 = a2 = dcmpl(max4, 0.0);
                                                                                if (x2) {
                                                                                    continue Label_0796;
                                                                                }
                                                                                if (n11 > 0) {
                                                                                    max4 += 10.0;
                                                                                }
                                                                                final S s3 = list3.get((int)n10);
                                                                                s3.a(max2 - s3.b() * 0.5, max4);
                                                                                max4 += s3.c();
                                                                                ++n10;
                                                                                if (x2) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                            break Label_0796;
                                                                        }
                                                                        if (n9 > 0) {
                                                                            n6 += 10.0;
                                                                        }
                                                                        final S s4 = list2.get((int)n8);
                                                                        s4.a(max2 - s4.b() - this.a(s4), n6);
                                                                        n6 += s4.c();
                                                                        ++n8;
                                                                        if (x2) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    max4 = Math.max(n5, n6);
                                                                    continue;
                                                                }
                                                            }
                                                            if (n7 > 0) {
                                                                n5 += 10.0;
                                                            }
                                                            final S s5 = list.get(l);
                                                            s5.a(max2 + this.a(s5), n5);
                                                            n5 += s5.c();
                                                            ++l;
                                                            if (x2) {
                                                                break;
                                                            }
                                                        }
                                                        continue;
                                                    }
                                                }
                                                continue Label_0315_Outer;
                                            }
                                            break Label_0804;
                                        }
                                        ++n3;
                                    } while (!x2);
                                    x.b(e, max + max2, max4);
                                    x.b(e.g(), new t(max2 - (max + max2) * 0.5, -max4 * 0.5));
                                    x.a(e.f(), new t(max2 - (max + max2) * 0.5, max4 * 0.5));
                                    if (i != 0) {
                                        int n12 = 0;
                                        while (n12 < array.length) {
                                            final S s6 = array[n12];
                                            s6.a(s6.d(), max4 - s6.c() - s6.e());
                                            ++n12;
                                            if (x2) {
                                                continue Label_0961;
                                            }
                                            if (x2) {
                                                break;
                                            }
                                        }
                                    }
                                    break Label_0954;
                                }
                            }
                            double n2 = dcmpl(max3, max * 2.0);
                            continue;
                        }
                    }
                }
                o.g();
                continue Label_0961;
            }
            break;
        } while (!x2);
    }
    
    public S[] a(final X x, final d d) {
        final c a = this.a(x);
        if (a == null) {
            return null;
        }
        return (S[])a.b(d);
    }
    
    private S[] a(final y.c.q q, final A a) {
        final List list = (List)a.b(q);
        if (list != null) {
            return list.toArray(new S[list.size()]);
        }
        return null;
    }
    
    private boolean b(final X x) {
        return this.a(x) != null;
    }
    
    public void a(final X x, final aU au, final aV av, final aP ap, final List list) {
        final boolean x2 = N.x;
        if (!this.b(x)) {
            return;
        }
        final String string = this.getClass().getName() + ".map";
        final A a = (A)x.c(string);
        x.d_(string);
        final x o = x.o();
        while (o.f()) {
            final y.c.q e = o.e();
            final S[] a2 = this.a(e, a);
            Label_0295: {
                if (a2 != null && a2.length > 0) {
                    if (av.a(e).g() == null) {
                        throw new IllegalStateException("realEdge == null: Cannot be!!!");
                    }
                    final am h = x.h(e);
                    final double x3 = h.getX();
                    final double y = h.getY();
                    int i = 0;
                    while (i < a2.length) {
                        final S s = a2[i];
                        s.a(s.d() + x3, s.e() + y);
                        this.d.a(x, s);
                        ++i;
                        if (x2) {
                            break Label_0295;
                        }
                        if (x2) {
                            break;
                        }
                    }
                    final double a3 = x.q(e.g()).a;
                    final double k = x.k(e);
                    h.setSize(0.0, 0.0);
                    x.a(e.f(), t.c);
                    x.b(e.g(), t.c);
                    h.setLocation(a3, k);
                }
                o.g();
            }
            if (x2) {
                break;
            }
        }
        int j = 0;
        while (j < list.size()) {
            list.get(j).a();
            ++j;
            if (x2) {
                return;
            }
            if (x2) {
                break;
            }
        }
        x.a(a);
    }
    
    boolean a(final d d, final v v) {
        final m a = v.a(0);
        return !d.e() || !a.b() || v.i() != 3;
    }
    
    public void a(final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        final e p3 = x.p();
        while (p3.f()) {
            final d a = p3.a();
            Label_0321: {
                if (a.e()) {
                    final S[] a2 = this.a(x, a);
                    if (a2 != null && a2.length > 0) {
                        final v l = x.l(a);
                        final int i = l.i();
                        final boolean a3 = this.a(a, l);
                        int b2 = 0;
                        Label_0274: {
                            Label_0273: {
                                if (i >= 3) {
                                    int j = 1;
                                    while (true) {
                                        while (j < i - 1) {
                                            final m a4 = l.a(j);
                                            final int b;
                                            final int n = b = (a4.b() ? 1 : 0);
                                            if (x2) {
                                                int k = b;
                                                while (k > 0) {
                                                    final m a5 = l.a(k);
                                                    final int n2 = b2 = (a5.b() ? 1 : 0);
                                                    if (x2) {
                                                        break Label_0274;
                                                    }
                                                    if (n2 && a3) {
                                                        this.a(a5, a2, false, false, x);
                                                        if (!x2) {
                                                            break;
                                                        }
                                                    }
                                                    if (a5.a() && !a3) {
                                                        this.a(a5, a2, false, x);
                                                        if (!x2) {
                                                            break;
                                                        }
                                                    }
                                                    --k;
                                                    if (x2) {
                                                        break;
                                                    }
                                                }
                                                break Label_0273;
                                            }
                                            if (n && a3) {
                                                this.a(a4, a2, true, true, x);
                                                if (!x2) {
                                                    break;
                                                }
                                            }
                                            if (a4.a() && !a3) {
                                                this.a(a4, a2, true, x);
                                                if (!x2) {
                                                    break;
                                                }
                                            }
                                            ++j;
                                            if (x2) {
                                                break;
                                            }
                                        }
                                        int b = i - 2;
                                        continue;
                                    }
                                }
                            }
                            b2 = 0;
                        }
                        int n3 = b2;
                        while (n3 < a2.length) {
                            this.d.a(x, a2[n3]);
                            ++n3;
                            if (x2) {
                                break Label_0321;
                            }
                            if (x2) {
                                break;
                            }
                        }
                    }
                }
                p3.g();
            }
            if (x2) {
                break;
            }
        }
    }
    
    private boolean a(final v v, final boolean b) {
        final int n = v.h() - 1;
        if (n == 3 || (b && n == 5)) {
            final m a = v.a(0);
            final m a2 = v.a(n - 1);
            return a.b() && a2.b();
        }
        return false;
    }
    
    public void b(final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        int i = 0;
    Label_0367_Outer:
        while (i < au.b()) {
            p p3 = au.a(i).f().k();
            while (true) {
                while (p3 != null) {
                    final d d = (d)p3.c();
                    final S[] a = this.a(x, d);
                    if (!x2) {
                        Label_0359: {
                            if (a != null && a.length > 0) {
                                final v l = x.l(d);
                                boolean b = false;
                                Label_0220: {
                                    if (this.a(l, av.a(d).k().h().d() != 0)) {
                                        this.a(l.a(0), a, true, false, x);
                                        if (!x2) {
                                            break Label_0220;
                                        }
                                    }
                                    int j = 1;
                                    while (j < l.i()) {
                                        final m a2 = l.a(j);
                                        b = a2.b();
                                        if (x2) {
                                            break;
                                        }
                                        if (b) {
                                            this.a(a2, a, true, true, x);
                                            if (!x2) {
                                                break;
                                            }
                                        }
                                        ++j;
                                        if (x2) {
                                            break;
                                        }
                                    }
                                }
                                int b2 = 0;
                                Label_0312: {
                                    Label_0311: {
                                        if (b) {
                                            this.a(l.a(l.i() - 1), a, false, true, x);
                                            if (!x2) {
                                                break Label_0311;
                                            }
                                        }
                                        int k = l.i() - 2;
                                        while (k >= 0) {
                                            final m a3 = l.a(k);
                                            final int n = b2 = (a3.b() ? 1 : 0);
                                            if (x2) {
                                                break Label_0312;
                                            }
                                            if (n != 0) {
                                                this.a(a3, a, false, false, x);
                                                if (!x2) {
                                                    break;
                                                }
                                            }
                                            --k;
                                            if (x2) {
                                                break;
                                            }
                                        }
                                    }
                                    b2 = 0;
                                }
                                int n2 = b2;
                                while (n2 < a.length) {
                                    this.d.a(x, a[n2]);
                                    ++n2;
                                    if (x2) {
                                        break Label_0359;
                                    }
                                    if (x2) {
                                        break;
                                    }
                                }
                            }
                            p3 = p3.a();
                        }
                        if (x2) {
                            break;
                        }
                        continue Label_0367_Outer;
                    }
                    else {
                        if (x2) {
                            break Label_0367_Outer;
                        }
                        continue Label_0367_Outer;
                    }
                }
                ++i;
                continue;
            }
        }
    }
    
    private void a(final m m, final S[] array, final boolean b, final X x) {
        final boolean x2 = N.x;
        final t c = m.c();
        final t d = m.d();
        final S[] array2 = new S[array.length];
        int i = 0;
        while (true) {
            while (i < array.length) {
                array2[i] = array[i];
                ++i;
                if (x2) {
                    final y y = (m.k() > 0.0) ? y.f.y.c : y.f.y.a;
                    final boolean b2 = (y == y.f.y.c && b) || (y == y.f.y.a && !b);
                    final double a = c.a();
                    double n2;
                    double n = n2 = (b2 ? (Math.min(c.b(), d.b()) + 10.0) : (Math.max(c.b(), d.b()) - 10.0));
                    double n3 = -1.0;
                    int n4 = b ? 0 : (array2.length - 1);
                    do {
                        Label_0217: {
                            final int n5;
                            if (b) {
                                n5 = n4;
                                if (!x2) {
                                    if (n5 < array2.length) {
                                        break Label_0217;
                                    }
                                    break;
                                }
                            }
                            if (n5 < 0) {
                                break;
                            }
                        }
                        final S s = array2[n4];
                        final aG f = s.f();
                        if (f.a() != n3) {
                            n2 = (n = (b2 ? Math.max(n, n2) : Math.min(n, n2)));
                            n3 = f.a();
                        }
                        Label_0543: {
                            if (!b || !f.k()) {
                                if (b || f.k()) {
                                    final double b3 = s.b();
                                    final double c2 = s.c();
                                    if (f.l() || f.n()) {
                                        if (this.a(f, y)) {
                                            s.a(a - b3 - this.a(s), b2 ? n : (n - c2));
                                            n += (c2 + 10.0) * (b2 ? 1 : -1);
                                            if (!x2) {
                                                break Label_0543;
                                            }
                                        }
                                        s.a(a + this.a(s), b2 ? n2 : (n2 - c2));
                                        n2 += (c2 + 10.0) * (b2 ? 1 : -1);
                                        if (!x2) {
                                            break Label_0543;
                                        }
                                    }
                                    final double n6 = b2 ? Math.max(n, n2) : (Math.min(n, n2) - c2);
                                    s.a(a - b3 * 0.5, n6);
                                    n2 = (n = n6 + (b2 ? (c2 + 10.0) : -10.0));
                                }
                            }
                        }
                        n4 += (b ? 1 : -1);
                    } while (!x2);
                    return;
                }
                if (x2) {
                    break;
                }
            }
            this.a(array2);
            continue;
        }
    }
    
    private void a(final S[] array) {
        y.g.e.a(array, cB.b);
    }
    
    private void a(final List list) {
        y.g.e.a(list, cB.b);
    }
    
    private void a(final m m, final S[] array, final boolean b, final boolean b2, final X x) {
        final boolean x2 = N.x;
        final t c = m.c();
        final t d = m.d();
        final S[] array2 = new S[array.length];
        int i = 0;
        while (true) {
            while (i < array.length) {
                array2[i] = array[i];
                ++i;
                if (x2) {
                    final y y = (m.j() > 0.0) ? y.f.y.b : y.f.y.d;
                    final boolean b3 = (y == y.f.y.b && b2) || (y == y.f.y.d && !b2);
                    final double b4 = c.b();
                    double n2;
                    double n = n2 = (b3 ? (Math.min(c.a(), d.a()) + 10.0) : (Math.max(c.a(), d.a()) - 10.0));
                    final boolean b5 = (b && b2) || (!b && !b2);
                    double n3 = -1.0;
                    int n4 = b5 ? 0 : (array2.length - 1);
                    do {
                        Label_0246: {
                            final int n5;
                            if (b5) {
                                n5 = n4;
                                if (!x2) {
                                    if (n5 < array2.length) {
                                        break Label_0246;
                                    }
                                    break;
                                }
                            }
                            if (n5 < 0) {
                                break;
                            }
                        }
                        final S s = array2[n4];
                        final aG f = s.f();
                        if (f.a() != n3) {
                            n2 = (n = (b3 ? Math.max(n, n2) : Math.min(n, n2)));
                            n3 = f.a();
                        }
                        Label_0572: {
                            if (!b || !f.k()) {
                                if (b || f.k()) {
                                    final double b6 = s.b();
                                    final double c2 = s.c();
                                    if (f.l() || f.n()) {
                                        if (this.a(f, y)) {
                                            s.a(b3 ? n : (n - b6), b4 - c2 - this.a(s));
                                            n += (b6 + 10.0) * (b3 ? 1 : -1);
                                            if (!x2) {
                                                break Label_0572;
                                            }
                                        }
                                        s.a(b3 ? n2 : (n2 - b6), b4 + this.a(s));
                                        n2 += (b6 + 10.0) * (b3 ? 1 : -1);
                                        if (!x2) {
                                            break Label_0572;
                                        }
                                    }
                                    final double n6 = b3 ? Math.max(n, n2) : (Math.min(n, n2) - b6);
                                    s.a(n6, b4 - c2 * 0.5);
                                    n2 = (n = n6 + (b3 ? (b6 + 10.0) : -10.0));
                                }
                            }
                        }
                        n4 += (b5 ? 1 : -1);
                    } while (!x2);
                    return;
                }
                if (x2) {
                    break;
                }
            }
            this.a(array2);
            continue;
        }
    }
    
    private boolean a(final aG ag, final y y) {
        return (ag.l() && (y == y.a || y == y.b)) || (ag.n() && (y == y.c || y == y.d));
    }
    
    public y.d.q a(final X x, final d d, final byte b, final double[] array, final boolean b2, final boolean b3) {
        return this.a(x, d, b, array, b2, b3, (byte)0);
    }
    
    public y.d.q a(final X x, final d d, final byte b, final double[] array, final boolean b2, final boolean b3, final byte b4) {
        final boolean x2 = N.x;
        final y y = b2 ? (b3 ? y.f.y.b : y.f.y.d) : (b3 ? y.f.y.c : y.f.y.a);
        final double[] array2 = { 0.0, 0.0 };
        final double[] array3 = { 0.0, 0.0 };
        final S[] a = this.a(x, d);
        byte a3 = 0;
        Label_1097: {
            if (a != null && a.length > 0) {
                final ArrayList<S> list = new ArrayList<S>();
                int i = 0;
                while (true) {
                    while (i < a.length) {
                        final S s = a[i];
                        final aG f = s.f();
                        final byte b5 = b4;
                        if (x2) {
                            byte a2 = b5;
                            for (final S s2 : list) {
                                final aG f2 = s2.f();
                                a3 = f2.a();
                                if (x2) {
                                    break Label_1097;
                                }
                                if (a3 != a2) {
                                    Label_0318: {
                                        if (b2) {
                                            array2[0] = (array2[1] = Math.max(array2[0], array2[1]));
                                            if (!x2) {
                                                break Label_0318;
                                            }
                                        }
                                        array3[0] = (array3[1] = Math.max(array3[0], array3[1]));
                                    }
                                    a2 = f2.a();
                                }
                                if (f2.l() || f2.n()) {
                                    final boolean a4 = this.a(f2, y);
                                    final int n = a4 ? 0 : 1;
                                    final int n2 = a4 ? 0 : 1;
                                    if (b == 0) {
                                        Label_0436: {
                                            if (array2[n] > 0.0) {
                                                final double[] array4 = array2;
                                                final int n3 = n;
                                                array4[n3] += 10.0;
                                                if (!x2) {
                                                    break Label_0436;
                                                }
                                            }
                                            if (!b2) {
                                                final double[] array5 = array2;
                                                final int n4 = n;
                                                array5[n4] += this.a(s2);
                                            }
                                        }
                                        final double[] array6 = array2;
                                        final int n5 = n;
                                        array6[n5] += s2.b();
                                        double c = s2.c();
                                        if (b2) {
                                            c += this.a(s2);
                                        }
                                        array3[n2] = Math.max(array3[n2], c);
                                        if (!x2) {
                                            continue;
                                        }
                                    }
                                    Label_0537: {
                                        if (array3[n2] > 0.0) {
                                            final double[] array7 = array3;
                                            final int n6 = n2;
                                            array7[n6] += 10.0;
                                            if (!x2) {
                                                break Label_0537;
                                            }
                                        }
                                        if (b2) {
                                            final double[] array8 = array3;
                                            final int n7 = n2;
                                            array8[n7] += this.a(s2);
                                        }
                                    }
                                    final double[] array9 = array3;
                                    final int n8 = n2;
                                    array9[n8] += s2.c();
                                    double b6 = s2.b();
                                    if (!b2) {
                                        b6 += this.a(s2);
                                    }
                                    array2[n] = Math.max(array2[n], b6);
                                    if (!x2) {
                                        continue;
                                    }
                                }
                                if (b == 0) {
                                    if (b2) {
                                        if (array2[0] > 0.0) {
                                            final double[] array10 = array2;
                                            final int n9 = 0;
                                            array10[n9] += 10.0;
                                        }
                                        if (array2[1] > 0.0) {
                                            final double[] array11 = array2;
                                            final int n10 = 1;
                                            array11[n10] += 10.0;
                                        }
                                        final double[] array12 = array2;
                                        final int n11 = 0;
                                        array12[n11] += s2.b();
                                        final double[] array13 = array2;
                                        final int n12 = 1;
                                        array13[n12] += s2.b();
                                        array3[0] = Math.max(array3[0], s2.c() * 0.5);
                                        array3[1] = Math.max(array3[1], s2.c() * 0.5);
                                        if (!x2) {
                                            continue;
                                        }
                                    }
                                    double n13 = s2.b() * 0.5;
                                    if (array2[0] > 0.0 || array2[1] > 0.0) {
                                        n13 += 5.0;
                                    }
                                    final double[] array14 = array2;
                                    final int n14 = 0;
                                    array14[n14] += n13;
                                    final double[] array15 = array2;
                                    final int n15 = 1;
                                    array15[n15] += n13;
                                    array3[0] = Math.max(array3[0], s2.c());
                                    array3[1] = Math.max(array3[1], s2.c());
                                    if (!x2) {
                                        continue;
                                    }
                                }
                                if (b2) {
                                    array2[0] = Math.max(array2[0], s2.b());
                                    array2[1] = Math.max(array2[1], s2.b());
                                    double n16 = s2.c() * 0.5;
                                    if (array3[0] > 0.0 || array3[1] > 0.0) {
                                        n16 += 5.0;
                                    }
                                    final double[] array16 = array3;
                                    final int n17 = 0;
                                    array16[n17] += n16;
                                    final double[] array17 = array3;
                                    final int n18 = 1;
                                    array17[n18] += n16;
                                    if (!x2) {
                                        continue;
                                    }
                                }
                                array2[0] = Math.max(array2[0], s2.b() * 0.5);
                                array2[1] = Math.max(array2[1], s2.b() * 0.5);
                                if (array3[0] > 0.0) {
                                    final double[] array18 = array3;
                                    final int n19 = 0;
                                    array18[n19] += 10.0;
                                }
                                if (array3[1] > 0.0) {
                                    final double[] array19 = array3;
                                    final int n20 = 1;
                                    array19[n20] += 10.0;
                                }
                                final double[] array20 = array3;
                                final int n21 = 0;
                                array20[n21] += s2.c();
                                final double[] array21 = array3;
                                final int n22 = 1;
                                array21[n22] += s2.c();
                                if (x2) {
                                    break;
                                }
                            }
                            final double[] array22 = array2;
                            final int n23 = 0;
                            array22[n23] += ((array2[0] != 0.0) ? 10.0 : 0.0);
                            final double[] array23 = array2;
                            final int n24 = 1;
                            array23[n24] += ((array2[1] != 0.0) ? 10.0 : 0.0);
                            final double[] array24 = array3;
                            final int n25 = 0;
                            array24[n25] += ((array3[0] != 0.0) ? 10.0 : 0.0);
                            final double[] array25 = array3;
                            final int n26 = 1;
                            array25[n26] += ((array3[1] != 0.0) ? 10.0 : 0.0);
                            break Label_1097;
                        }
                        if (b4 == 0 || (b4 == 2 && f.i()) || f.j() || (b4 == 1 && !f.i() && !f.j())) {
                            list.add(s);
                            this.d.a(x, s, y);
                        }
                        ++i;
                        if (x2) {
                            break;
                        }
                    }
                    this.a(list);
                    final byte b5 = -1;
                    continue;
                }
            }
        }
        if (a3 != 0) {
            array[0] = array3[0];
            array[1] = array3[1];
            final double max = Math.max(array2[0], array2[1]);
            final double n27 = max + ((max != 0.0) ? 10.0 : 0.0);
            final double n28 = array3[0] + array3[1];
            if (!x2) {
                return new y.d.q(n27, n28);
            }
        }
        array[0] = array2[0];
        array[1] = array2[1];
        final double n27 = array2[0] + array2[1];
        final double max2 = Math.max(array3[0], array3[1]);
        final double n28 = max2 + ((max2 != 0.0) ? 10.0 : 0.0);
        return new y.d.q(n27, n28);
    }
    
    public double a(final X x, final aV av, final y.c.q q, final y.c.q q2) {
        final boolean x2 = N.x;
        double n = 0.0;
        if (q != null && q2 != null) {
            aX ax = av.a(q);
            if (ax.b() == 3 && ax.k() > av.a(ax.f()).k()) {
                ax = av.a(ax.f());
            }
            p p4 = ax.d();
            while (p4 != null) {
                final d d = (d)p4.c();
                final aX a = av.a(q2);
                final boolean b = a.b() == 3 && a.g() == d && a.k() < av.a(a.f()).k();
                Label_0331: {
                    if (d.d() == q2 || (b && d.d() == a.f())) {
                        n = Math.max(n, this.a(x, d, (byte)0, new double[2], true, true).a() + 2.0 * this.a(av, d));
                        if (!x2) {
                            break Label_0331;
                        }
                    }
                    if (d.c() == q2 || (b && d.c() == a.f())) {
                        n = Math.max(n, this.a(x, d, (byte)0, new double[2], true, false).a() + 2.0 * this.a(av, d));
                    }
                }
                p4 = p4.a();
                if (x2) {
                    break;
                }
            }
        }
        return n;
    }
    
    private double a(final aV av, final d d) {
        final B k = av.a(d).k();
        return (k.h().d() == 1) ? (k.i() / Math.sqrt(2.0)) : 0.0;
    }
    
    private double a(final S s) {
        final aG f = s.f();
        return (f.l() || f.n()) ? Math.max(0.0, f.h()) : 0.0;
    }
    
    private static byte a(final aG ag) {
        final byte a = ag.a();
        if (a == 7) {
            return 0;
        }
        return a;
    }
    
    static {
        a = "y.layout.hierarchic.incremental.EdgeLabelingSupport.InstanceDPKey";
        b = new cC(false);
    }
}
