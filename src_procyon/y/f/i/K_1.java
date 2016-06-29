package y.f.i;

import y.g.*;
import y.a.*;
import y.g.a.*;
import java.util.*;
import y.c.*;
import y.d.*;
import y.f.*;

public class K extends a
{
    public static final Object a;
    private X b;
    private boolean c;
    private Comparator d;
    private int[] e;
    private int[] f;
    private double g;
    private Object h;
    private boolean i;
    private double n;
    private double o;
    private double p;
    private boolean q;
    private boolean r;
    private boolean s;
    private byte t;
    
    public K() {
        this.g = 10.0;
        this.h = K.a;
        this.n = 10.0;
        this.r = true;
        this.s = true;
        this.d = new L(this);
    }
    
    public void c(final X b) {
        this.a(this.b = b);
        if (b.h() == 0) {
            return;
        }
        final int n = b.g() * 2;
        final byte[] array = new byte[n * (n - 1) / 2];
        this.t = 0;
        this.a(b, array);
        final an an = new an((byte)3);
        an.a(new M(this, array));
        an.c(b);
        this.a(array);
        this.q = true;
        this.t = 0;
        this.b(b);
        final an an2 = new an((byte)3);
        this.q = false;
        an2.a(new N(this));
        an2.c(b);
    }
    
    private void a(final X x, final byte[] array) {
        final List f = this.f(x);
        f.addAll(this.e(x));
        y.g.e.a(f, null);
        this.a(f, array);
    }
    
    private void b(final X x) {
        final List f = this.f(x);
        f.addAll(this.e(x));
        y.g.e.a(f, null);
        this.a(f);
    }
    
    private void a(final List list) {
        final int f = v.f;
        final ArrayList list2 = new ArrayList<W>();
        double j = -1.7976931348623157E308;
        final c c = new c(-1.7976931348623157E308);
        int i = 0;
        while (i < list.size()) {
            final R r = list.get(i);
            final byte k = r.k();
            if (f != 0) {
                return;
            }
            Label_0284: {
                if (k == 0) {
                    if (Math.abs(r.j() - j) < 5.0) {
                        list2.add((W)r);
                        if (f == 0) {
                            break Label_0284;
                        }
                    }
                    if (list2.size() > 0) {
                        this.a(list2, c, i, list);
                    }
                    list2.add((W)r);
                    j = r.j();
                    if (f == 0) {
                        break Label_0284;
                    }
                }
                if (k == 2) {
                    if (list2.size() > 0) {
                        this.a(list2, c, i, list);
                    }
                    final W w = (W)r;
                    c.c(w.b().c().b() - 2.0, w.b().d().b() + 2.0, r.j());
                    if (f == 0) {
                        break Label_0284;
                    }
                }
                if (k == 1) {
                    if (list2.size() > 0) {
                        this.a(list2, c, i, list);
                    }
                    final W w2 = (W)r;
                    c.c(w2.b().c().b(), w2.b().d().b(), r.j());
                }
            }
            ++i;
            if (f != 0) {
                break;
            }
        }
        this.a(list2, c, list.size(), list);
    }
    
    private void a(final List list, final byte[] array) {
        final int f = v.f;
        final ArrayList list2 = new ArrayList<R>();
        double j = -1.7976931348623157E308;
        int i = 0;
        while (true) {
            while (i < list.size()) {
                final R r = list.get(i);
                final byte k = r.k();
                final int size;
                final byte b = (byte)(size = k);
                if (f != 0) {
                    if (size > 1) {
                        this.b(list2, array);
                    }
                    list2.clear();
                    return;
                }
                Label_0198: {
                    if (b == 0) {
                        if (Math.abs(r.j() - j) < 5.0) {
                            list2.add(r);
                            if (f == 0) {
                                break Label_0198;
                            }
                        }
                        if (list2.size() > 1) {
                            this.b(list2, array);
                        }
                        list2.clear();
                        list2.add(r);
                        j = r.j();
                        if (f == 0) {
                            break Label_0198;
                        }
                    }
                    if (k == 2) {
                        if (list2.size() > 1) {
                            this.b(list2, array);
                        }
                        list2.clear();
                        if (f == 0) {
                            break Label_0198;
                        }
                    }
                    if (k == 1) {
                        if (list2.size() > 1) {
                            this.b(list2, array);
                        }
                        list2.clear();
                    }
                }
                ++i;
                if (f != 0) {
                    break;
                }
            }
            int size = list2.size();
            continue;
        }
    }
    
    private void a(final byte[] array) {
        final int i = v.f;
        final i j = new i();
        final q[] array2 = new q[this.b.g() * 2];
        int k = 0;
        while (true) {
            while (k < this.b.g() * 2) {
                array2[k] = j.d();
                ++k;
                if (i != 0) {
                    while (true) {
                        do {
                            int l = k;
                        Label_0069:
                            while (l < this.b.g() * 2) {
                                final int n = 0;
                                if (i == 0) {
                                    int n2 = n;
                                    while (n2 < k) {
                                        final byte b = array[k * (k - 1) / 2 + n2];
                                        final int n3 = l = b;
                                        if (i != 0) {
                                            continue Label_0069;
                                        }
                                        Label_0158: {
                                            if (n3 > 0) {
                                                j.a(array2[k], array2[n2]);
                                                if (i == 0) {
                                                    break Label_0158;
                                                }
                                            }
                                            if (b < 0) {
                                                j.a(array2[n2], array2[k]);
                                            }
                                        }
                                        ++n2;
                                        if (i != 0) {
                                            break;
                                        }
                                    }
                                    ++k;
                                    continue Label_0067;
                                }
                                final int[] array3 = new int[n];
                                final int n4 = j.e() / 2;
                            Label_0355:
                                while (true) {
                                    int n5 = 0;
                                    while (n5 != 0) {
                                        m.b(j, array3);
                                        final y.c.e p = j.p();
                                        while (p.f()) {
                                            final y.c.d a = p.a();
                                            final int d = a.c().d();
                                            final int d2 = a.d().d();
                                            n5 = array3[d];
                                            if (i != 0) {
                                                break;
                                            }
                                            if (n5 < array3[d2]) {
                                                final int n6 = (d >= n4) ? (d - n4) : (d + n4);
                                                final int n7 = (d2 >= n4) ? (d2 - n4) : (d2 + n4);
                                                j.a(a);
                                                j.a(array2[n6].b(array2[n7]));
                                                if (i == 0) {
                                                    break;
                                                }
                                            }
                                            p.g();
                                            if (i != 0) {
                                                break Label_0355;
                                            }
                                        }
                                    }
                                    break;
                                }
                                final d d3 = new d(j);
                                int n8 = 1;
                                final int[] array4 = new int[j.e()];
                                int n9 = 0;
                                while (true) {
                                    while (n9 < array3.length) {
                                        array3[n9] = 0;
                                        ++n9;
                                        if (i != 0) {
                                            while (true) {
                                                while (n9 < array2.length) {
                                                    final q q = array2[n9];
                                                    final int b2 = q.b();
                                                    if (i != 0) {
                                                        int n10 = b2;
                                                        int n13 = 0;
                                                        Label_0737: {
                                                        Label_0736:
                                                            while (true) {
                                                                d3.a();
                                                                int n11 = 0;
                                                            Label_0549:
                                                                while (n11 == 0) {
                                                                    final q c = d3.c();
                                                                    array3[c.d()] = n10++;
                                                                    y.c.d d4 = c.f();
                                                                    while (d4 != null) {
                                                                        final q d5 = d4.d();
                                                                        final int n12 = array4[d5.d()];
                                                                        final int[] array5 = array4;
                                                                        final int d6 = d5.d();
                                                                        --array5[d6];
                                                                        n11 = (n13 = n12);
                                                                        if (i != 0) {
                                                                            break Label_0737;
                                                                        }
                                                                        if (i != 0) {
                                                                            continue Label_0549;
                                                                        }
                                                                        Label_0724: {
                                                                            if (n11 == 1) {
                                                                                final q q2 = (d5.d() < n4) ? array2[d5.d() + n4] : array2[d5.d() - n4];
                                                                                if (array3[q2.d()] != 0) {
                                                                                    d3.a(d5, -array3[q2.d()]);
                                                                                    if (i == 0) {
                                                                                        break Label_0724;
                                                                                    }
                                                                                }
                                                                                array3[d5.d()] = n8;
                                                                                d3.a(d5, n8++);
                                                                            }
                                                                        }
                                                                        d4 = d4.g();
                                                                        if (i != 0) {
                                                                            break Label_0736;
                                                                        }
                                                                    }
                                                                    continue Label_0737;
                                                                }
                                                                break;
                                                            }
                                                            n13 = 0;
                                                        }
                                                        int n14 = n13;
                                                        while (n14 < array3.length) {
                                                            array3[n14] = -array3[n14];
                                                            ++n14;
                                                            if (i != 0) {
                                                                return;
                                                            }
                                                            if (i != 0) {
                                                                break;
                                                            }
                                                        }
                                                        this.e = new int[this.b.g()];
                                                        this.f = new int[this.b.g()];
                                                        System.arraycopy(array3, 0, this.e, 0, this.e.length);
                                                        System.arraycopy(array3, this.e.length, this.f, 0, this.f.length);
                                                        return;
                                                    }
                                                    Label_0531: {
                                                        if (b2 == 0) {
                                                            final int n15 = (n9 < n4) ? (n9 + n4) : (n9 - n4);
                                                            if (array3[n15] != 0) {
                                                                d3.a(q, array3[n9] = -array3[n15]);
                                                                if (i == 0) {
                                                                    break Label_0531;
                                                                }
                                                            }
                                                            array3[n9] = n8;
                                                            d3.a(q, n8++);
                                                            if (i == 0) {
                                                                break Label_0531;
                                                            }
                                                        }
                                                        array4[n9] = q.b();
                                                    }
                                                    ++n9;
                                                    if (i != 0) {
                                                        break;
                                                    }
                                                }
                                                continue;
                                            }
                                        }
                                        if (i != 0) {
                                            break;
                                        }
                                    }
                                    n9 = 0;
                                    continue;
                                }
                            }
                            break;
                        } while (i == 0);
                        j.e();
                        continue;
                    }
                }
                if (i != 0) {
                    break;
                }
            }
            k = 1;
            continue;
        }
    }
    
    private y.c.c d(final X x) {
        y.c.c c = x.c(this.h);
        if (c == null) {
            c = new O(this);
        }
        return c;
    }
    
    private void a(final List list, final c c, final int n, final List list2) {
        final int f = v.f;
        if (list.size() < 2) {
            if (list.size() > 0) {
                this.a(c, list.get(0));
            }
            list.clear();
            if (f == 0) {
                return;
            }
        }
        final ArrayList<P> list3 = new ArrayList<P>(list.size() * 2);
        while (true) {
        Label_0445_Outer:
            for (final Q q : list) {
                final boolean f2 = q.f();
                if (f != 0) {
                    int n2 = f2 ? 1 : 0;
                    double n3 = 0.0;
                    double max = 0.0;
                    final ArrayList<Q> list4 = new ArrayList<Q>();
                    while (true) {
                        for (final P p4 : list3) {
                            if (p4.k() == 3) {
                                Label_0343: {
                                    if (n2 == 0) {
                                        n3 = p4.j();
                                        if (f == 0) {
                                            break Label_0343;
                                        }
                                    }
                                    n3 = Math.min(p4.j(), n3);
                                }
                                list4.add(p4.a());
                                ++n2;
                                if (f == 0) {
                                    continue Label_0445_Outer;
                                }
                            }
                            --n2;
                            max = Math.max(p4.j(), max);
                            if (n2 == 0) {
                                final List<Q> list6;
                                final ArrayList<Q> list5 = (ArrayList<Q>)(list6 = list4);
                                if (f != 0) {
                                    list6.clear();
                                    return;
                                }
                                if (list5.size() > 1) {
                                    this.a(list4, c, this.a(n, list2, list4, n3 - 10.0, max + 10.0));
                                }
                                list4.clear();
                                if (f != 0) {
                                    break;
                                }
                                continue Label_0445_Outer;
                            }
                        }
                        List<Q> list6 = (List<Q>)list;
                        continue;
                    }
                }
                if (f2) {
                    this.a(c, q);
                    if (f == 0) {
                        continue;
                    }
                }
                final double b = q.a().c().b();
                final double b2 = q.a().d().b();
                if (b <= b2) {
                    list3.add(new P((byte)3, b, q));
                    list3.add(new P((byte)4, b2, q));
                    if (f == 0) {
                        continue;
                    }
                }
                list3.add(new P((byte)3, b2, q));
                list3.add(new P((byte)4, b, q));
                if (f != 0) {
                    break;
                }
            }
            y.g.e.a(list3, null);
            continue;
        }
    }
    
    private void a(final c c, final Q q) {
        final double b = q.a().c().b();
        final double b2 = q.a().d().b();
        c.c(Math.min(b, b2), Math.max(b, b2), q.a().c().a());
    }
    
    private void b(final List list, final byte[] array) {
        final int f = v.f;
        final ArrayList<P> list2 = new ArrayList<P>(list.size() * 2);
        while (true) {
            for (final Q q : list) {
                final boolean f2 = q.f();
                if (f != 0) {
                    int n = f2 ? 1 : 0;
                    double n2 = 0.0;
                    double max = 0.0;
                    final ArrayList<Q> list3 = new ArrayList<Q>();
                    for (final P p2 : list2) {
                        if (p2.k() == 3) {
                            Label_0278: {
                                if (n == 0) {
                                    n2 = p2.j();
                                    if (f == 0) {
                                        break Label_0278;
                                    }
                                }
                                n2 = Math.min(p2.j(), n2);
                            }
                            list3.add(p2.a());
                            ++n;
                            if (f == 0) {
                                continue;
                            }
                        }
                        --n;
                        max = Math.max(p2.j(), max);
                        if (n == 0) {
                            if (list3.size() > 1) {
                                this.c(list3, array);
                            }
                            list3.clear();
                            if (f != 0) {
                                break;
                            }
                            continue;
                        }
                    }
                    return;
                }
                if (f2) {
                    continue;
                }
                final double b = q.a().c().b();
                final double b2 = q.a().d().b();
                if (b <= b2) {
                    list2.add(new P((byte)3, b, q));
                    list2.add(new P((byte)4, b2, q));
                    if (f == 0) {
                        continue;
                    }
                }
                list2.add(new P((byte)3, b2, q));
                list2.add(new P((byte)4, b, q));
                if (f != 0) {
                    break;
                }
            }
            y.g.e.a(list2, null);
            continue;
        }
    }
    
    private c a(final int n, final List list, final List list2, final double n2, final double n3) {
        final int f = v.f;
        final int size = list2.size();
        double n4 = -1.7976931348623157E308;
        for (final Q q : list2) {
            final y.c.d e = q.e();
            if (q.h()) {
                final am a = ((X)e.a()).a((Object)e.c());
                n4 = Math.max(n4, a.getX() + a.getWidth() + 1.0);
            }
            if (q.i()) {
                final am a2 = ((X)e.a()).a((Object)e.c());
                n4 = Math.max(n4, a2.getX() + a2.getWidth() + 1.0);
                if (f != 0) {
                    break;
                }
                continue;
            }
        }
        final c c = new c(Double.MAX_VALUE);
        double j;
        final double n5 = j = list.get(n - 1).j() + this.b() * (size + 1);
        int i = n;
        while (i < list.size()) {
            final R r = list.get(i);
            j = r.j();
            if (f != 0) {
                return c;
            }
            if (n4 > -1.7976931348623157E308) {
                if (j > n4) {
                    break;
                }
            }
            else if (j > n5) {
                break;
            }
            final byte k = r.k();
            Label_0484: {
                if (k != 0) {
                    if (k == 2) {
                        final W w = (W)r;
                        final double b = w.b().c().b();
                        final double b2 = w.b().d().b();
                        if (b2 <= n2 || b >= n3) {
                            break Label_0484;
                        }
                        c.a(Math.max(n2, b), Math.min(b2, n3), r.j());
                        if (f == 0) {
                            break Label_0484;
                        }
                    }
                    if (k == 1) {
                        final W w2 = (W)r;
                        final double n6 = w2.b().c().b() - 2.0;
                        final double n7 = w2.b().d().b() + 2.0;
                        if (n7 > n2 && n6 < n3) {
                            c.a(Math.max(n6, n2), Math.min(n7, n3), r.j());
                        }
                    }
                }
            }
            ++i;
            if (f != 0) {
                break;
            }
        }
        c.a(n2 - 20.0, n3 + 20.0, j);
        return c;
    }
    
    private void a(final List list, final c c, final c c2) {
        final int f = v.f;
        final S s = new S();
        s.c(Double.NaN);
        s.a(this.d);
        if (this.i) {
            s.a(this.n);
            s.b(this.q ? this.o : this.p);
        }
        double n = this.n;
        int n2 = 0;
        final int n3 = 0;
        double n5 = 0.0;
    Label_0082:
        while (true) {
            while (true) {
                double b = this.b();
            Label_0199_Outer:
                while (true) {
                    s.a();
                    while (true) {
                        for (final Q q : list) {
                            final y.d.m a = q.a();
                            s.a(q, 0.0, b, a.c().b(), q.b(), a.d().b(), q.c(), q.d());
                            if (f != 0) {
                                b -= s.d() / (list.size() + 1);
                                ++n2;
                                double n4 = this.s ? 1 : 0;
                                while (n4 == 0 || s.d() <= 0.001 || b <= 0.1 || n2 > 20) {
                                    n /= 2.0;
                                    s.a(n);
                                    final boolean b2 = (n4 = (this.i ? 1 : 0)) != 0.0;
                                    if (f == 0) {
                                        if (b2 && this.r && s.d() > 0.0 && n >= 1.0 && n3 <= 20) {
                                            continue Label_0082;
                                        }
                                        n5 = (n4 = dcmpl(s.d(), 0.001));
                                        if (f == 0) {
                                            break Label_0082;
                                        }
                                        continue Label_0199_Outer;
                                    }
                                }
                                continue Label_0199_Outer;
                            }
                            if (f != 0) {
                                break;
                            }
                        }
                        s.a(c2);
                        s.b(c);
                        s.c();
                        continue;
                    }
                }
            }
            break;
        }
        if (n5 > 0) {
            return;
        }
        for (final Q q2 : list) {
            final double a2 = s.a(q2);
            final y.c.d e = q2.e();
            if (!q2.f() && !Double.isNaN(a2)) {
                final D m = ((X)e.a()).m(e);
                final p b3 = m.b(q2.g());
                final t t = (t)b3.c();
                final p b4 = m.b(q2.g() + 1);
                final t t2 = (t)b4.c();
                final t t3 = new t(a2, t.b);
                final t t4 = new t(a2, t2.b);
                double min = Math.min(t3.b, t4.b);
                double max = Math.max(t3.b, t4.b);
                if (min + 2.0 < max - 2.0) {
                    ++min;
                    --max;
                }
                c.b(min, max, a2);
                b3.a(t3);
                b4.a(t4);
                this.b.a(e, m);
                if (f != 0) {
                    break;
                }
                continue;
            }
        }
        s.a();
    }
    
    private void c(final List list, final byte[] array) {
        final int i = v.f;
        final S s = new S();
        final U[] array2 = new U[list.size()];
        int n = 0;
        for (final Q q : list) {
            final y.d.m a = q.a();
            array2[n] = s.a(q, 0.0, 10.0, a.c().b(), q.b(), a.d().b(), q.c());
            ++n;
            if (i != 0) {
                break;
            }
        }
        final V v = new V(null);
        final int g = this.b.g();
        int n2 = 0;
        do {
            Label_0135: {
                final int length = array2.length;
            }
            int j = 0;
            int n3 = 0;
            Label_0140:
            while (j < n3) {
                final U u = array2[n2];
                int k = n2 + 1;
                while (k < array2.length) {
                    final U u2 = array2[k];
                    final int b = Q.a((Q)u.c()).b();
                    final int b2 = Q.a((Q)u2.c()).b();
                    j = b;
                    n3 = b2;
                    if (i != 0) {
                        continue Label_0140;
                    }
                    if (j != n3) {
                        int compare = v.compare(u, u2);
                        final y.d.m a2 = ((Q)u.c()).a();
                        final boolean b3 = a2.c().b() >= a2.d().b();
                        final y.d.m a3 = ((Q)u2.c()).a();
                        final boolean b4 = a3.c().b() >= a3.d().b();
                        if (U.a(u) == 3 && U.a(u2) == 3) {
                            compare = -compare;
                        }
                        this.a(b, b2, b3, b4, g, compare, array);
                        this.a(b, b2, !b3, !b4, g, -compare, array);
                    }
                    ++k;
                    if (i != 0) {
                        break;
                    }
                }
                ++n2;
                continue Label_0135;
            }
            break;
        } while (i == 0);
    }
    
    private void a(int n, int n2, final boolean b, final boolean b2, final int n3, int n4, final byte[] array) {
        if (!b) {
            n += n3;
        }
        if (!b2) {
            n2 += n3;
        }
        if (n < n2) {
            final int n5 = n2;
            n2 = n;
            n = n5;
            n4 = -n4;
        }
        if (n4 != 0) {
            final int n6 = n * (n - 1) / 2 + n2;
            final byte b3 = array[n6];
            if (n4 > 0) {
                if (b3 >= 127) {
                    return;
                }
                array[n6] = (byte)(b3 + 1);
                if (v.f == 0) {
                    return;
                }
            }
            if (b3 > -128) {
                array[n6] = (byte)(b3 - 1);
            }
        }
    }
    
    private List e(final X x) {
        final int f = v.f;
        final ArrayList<W> list = new ArrayList<W>(x.e() * 2);
        final x o = x.o();
        while (o.f()) {
            final q e = o.e();
            list.add(new W(e, (byte)0));
            final ArrayList<W> list3;
            final ArrayList<W> list2 = list3 = list;
            if (f != 0) {
                return list3;
            }
            list2.add(new W(e, (byte)1));
            o.g();
            if (f != 0) {
                break;
            }
        }
        return list;
    }
    
    private List f(final X x) {
        final int i = v.f;
        final y.c.c d = this.d(x);
        final ArrayList<Q> list = new ArrayList<Q>();
        final y.c.c c = x.c(aF.a);
        final y.c.c c2 = x.c(aF.b);
        final y.c.c c3 = x.c(ax.a);
        final y.c.c c4 = x.c(ax.b);
        final x o = x.o();
    Label_0451:
        while (o.f()) {
            final y.c.e l = o.e().l();
            while (true) {
                do {
                    Label_0087: {
                        l.f();
                    }
                    boolean d2 = false;
                    Label_0094:
                    while (d2) {
                        final y.c.d a = l.a();
                        int n = 0;
                        final int n2 = x.l(a).h() - 2;
                        if (i == 0) {
                            final s j = x.l(a).j();
                            while (j.f()) {
                                final y.d.m a2 = j.a();
                                boolean b = false;
                                d2 = d.d(a);
                                if (i != 0) {
                                    continue Label_0094;
                                }
                                Label_0340: {
                                    if (!d2) {
                                        b = true;
                                        if (i == 0) {
                                            break Label_0340;
                                        }
                                    }
                                    if (this.c && (n == 0 || n + 1 == j.k())) {
                                        b = true;
                                        if (i == 0) {
                                            break Label_0340;
                                        }
                                    }
                                    if (n == 0) {
                                        b = (this.a(a, c) || this.a(x, a, c3, true));
                                        if (b || n != n2) {
                                            break Label_0340;
                                        }
                                        b = (this.a(a, c2) || this.a(x, a, c4, false));
                                        if (i == 0) {
                                            break Label_0340;
                                        }
                                    }
                                    if (n == n2) {
                                        b = (this.a(a, c2) || this.a(x, a, c4, false));
                                    }
                                }
                                if (Math.abs(a2.c().a() - a2.d().a()) < 0.001) {
                                    list.add(new Q((byte)0, a2, a, b, n, n == 0, n == n2));
                                }
                                j.g();
                                ++n;
                                if (i != 0) {
                                    break;
                                }
                            }
                            l.g();
                            continue Label_0087;
                        }
                        if (i != 0) {
                            break Label_0451;
                        }
                        continue Label_0451;
                    }
                    break;
                } while (i == 0);
                o.g();
                continue;
            }
        }
        return list;
    }
    
    private boolean a(final X x, final y.c.d d, final y.c.c c, final boolean b) {
        final int f = v.f;
        if (c != null) {
            final Collection collection = (Collection)c.b(d);
            if (collection == null) {
                return false;
            }
            for (final ax ax : collection) {
                if (ax.b()) {
                    final boolean b2 = b;
                    if (f != 0) {
                        return b2;
                    }
                    am am = null;
                    t t = null;
                    Label_0122: {
                        if (b) {
                            am = x.a((Object)d.c());
                            t = x.l(d).c();
                            if (f == 0) {
                                break Label_0122;
                            }
                        }
                        am = x.a((Object)d.d());
                        t = x.l(d).d();
                    }
                    final double n = am.getX() + 0.5 * am.getWidth() + ax.c(this.t);
                    final double n2 = am.getY() + 0.5 * am.getHeight() + ax.d(this.t);
                    final double a = t.a();
                    final double b3 = t.b();
                    if (Math.abs(n - a) < 0.001 && Math.abs(n2 - b3) < 0.001) {
                        return true;
                    }
                    continue;
                }
            }
        }
        return false;
    }
    
    private boolean a(final y.c.d d, final y.c.c c) {
        if (c != null) {
            final aE ae = (aE)c.b(d);
            if (ae != null && ae.a()) {
                return true;
            }
        }
        return false;
    }
    
    public void a(final Object h) {
        this.h = h;
    }
    
    public double b() {
        return this.g;
    }
    
    static int[] a(final K k) {
        return k.e;
    }
    
    static int[] b(final K k) {
        return k.f;
    }
    
    static byte a(final K k, final byte t) {
        return k.t = t;
    }
    
    static void a(final K k, final X x, final byte[] array) {
        k.a(x, array);
    }
    
    static void a(final K k, final X x) {
        k.b(x);
    }
    
    static {
        a = "y.layout.router.OrthogonalSegmentDistributionStage.AFFECTED_EDGES";
    }
}
