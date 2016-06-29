package y.f.i.a;

import y.f.*;
import java.util.*;
import y.a.*;
import y.c.*;

class aj implements Comparator
{
    private final D a;
    private final ac b;
    private final Map c;
    private final Z d;
    private int[] e;
    private int[] f;
    
    public aj(final D a, final ac b, final Z d) {
        this.a = a;
        this.b = b;
        this.d = d;
        this.c = new HashMap();
        this.a();
    }
    
    public int compare(final Object o, final Object o2) {
        final ai ai = (ai)o;
        final ai ai2 = (ai)o2;
        final ai ai3 = (ai.k() != null) ? ai.k().c() : ai;
        final ai ai4 = (ai2.k() != null) ? ai2.k().c() : ai2;
        final ap ap = new ap(this, ai3, ai4);
        if (this.c.containsKey(ap)) {
            return (int)this.c.get(ap);
        }
        final ap ap2 = new ap(this, ai4, ai3);
        if (this.c.containsKey(ap2)) {
            return -(int)this.c.get(ap2);
        }
        return ((ai.g() ? (y.a == ai.h()) : (y.b == ai.h())) ? this.e[ai.i().b()] : this.f[ai.i().b()]) - ((ai2.g() ? (y.a == ai2.h()) : (y.b == ai2.h())) ? this.e[ai2.i().b()] : this.f[ai2.i().b()]);
    }
    
    private void a() {
        final int a = ab.a;
        final am am = new am(this.d.a());
        final C m = this.a.m();
        while (m.f()) {
            this.a((h)m.d(), am);
            m.g();
            if (a != 0) {
                return;
            }
            if (a != 0) {
                break;
            }
        }
        this.a(am);
    }
    
    private void a(final h h, final am am) {
        final int a = ab.a;
        final ai[] array = new ai[h.d().size()];
        final an[] array2 = new an[array.length];
        final al[] a2 = this.a(h);
        final Iterator<ai> iterator = (Iterator<ai>)h.d().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final ai ai = iterator.next();
            array[n] = ai;
            array2[n] = this.a(ai);
            ++n;
            if (a != 0) {
                break;
            }
        }
        final D d = new D();
        int i = 0;
    Label_1134:
        while (true) {
            while (i < array.length) {
                final ai ai2 = array[i];
                final an an = array2[i];
                final d j = ai2.i();
            Label_0134:
                while (true) {
                    ai ai3 = null;
                    final M c = ai3.c();
                    final al al = a2[i];
                    final int n2 = i + 1;
                    if (a == 0) {
                        int k = n2;
                        while (k < array.length) {
                            byte b = 0;
                            final ai ai4 = array[k];
                            ai3 = ai2;
                            if (a != 0) {
                                continue Label_0134;
                            }
                            Label_1113: {
                                if (ai3.k() == null || ai2.k() != ai4.k()) {
                                    final an an2 = array2[k];
                                    final d l = ai4.i();
                                    final M c2 = ai4.c();
                                    final al al2 = a2[k];
                                    boolean b2 = false;
                                    Label_0650: {
                                        if (c.b() <= c2.a() || c.a() >= c2.b()) {
                                            final boolean b3 = c.a() < c2.b();
                                            final boolean b4 = c2.a() < c.b();
                                            if (b3) {
                                                b = -5;
                                                b2 = true;
                                                if (a == 0) {
                                                    break Label_0650;
                                                }
                                            }
                                            if (b4) {
                                                b = 5;
                                                b2 = true;
                                                if (a == 0) {
                                                    break Label_0650;
                                                }
                                            }
                                            b = 0;
                                            if (a == 0) {
                                                break Label_0650;
                                            }
                                        }
                                        final M b5 = this.b(ai2);
                                        final M c3 = this.c(ai2);
                                        final M b6 = this.b(ai4);
                                        final M c4 = this.c(ai4);
                                        int n3 = 0;
                                        int n4 = 0;
                                        Label_0429: {
                                            if (this.b(b5, ai4)) {
                                                if (this.a(b5, ai4)) {
                                                    n3 += an.a();
                                                    if (a == 0) {
                                                        break Label_0429;
                                                    }
                                                }
                                                n4 += an.a();
                                            }
                                        }
                                        Label_0476: {
                                            if (this.b(c3, ai4)) {
                                                if (this.a(c3, ai4)) {
                                                    n3 += an.b();
                                                    if (a == 0) {
                                                        break Label_0476;
                                                    }
                                                }
                                                n4 += an.b();
                                            }
                                        }
                                        Label_0523: {
                                            if (this.b(b6, ai2)) {
                                                if (this.a(b6, ai2)) {
                                                    n3 -= an2.a();
                                                    if (a == 0) {
                                                        break Label_0523;
                                                    }
                                                }
                                                n4 -= an2.a();
                                            }
                                        }
                                        Label_0570: {
                                            if (this.b(c4, ai2)) {
                                                if (this.a(c4, ai2)) {
                                                    n3 -= an2.b();
                                                    if (a == 0) {
                                                        break Label_0570;
                                                    }
                                                }
                                                n4 -= an2.b();
                                            }
                                        }
                                        if (n3 != 0) {
                                            b += (byte)n3;
                                            b2 = true;
                                            if (a == 0) {
                                                break Label_0650;
                                            }
                                        }
                                        if (n4 != 0) {
                                            b += (byte)n4;
                                            if (a == 0) {
                                                break Label_0650;
                                            }
                                        }
                                        final int a3 = this.a(c, c2);
                                        if (a3 != 0) {
                                            b += (byte)a3;
                                            if (a == 0) {
                                                break Label_0650;
                                            }
                                        }
                                        b += (byte)(ai2.d() - ai4.d());
                                    }
                                    if (b != 0) {
                                        if (y.f.i.a.al.a(al) == 0 && y.f.i.a.al.a(al2) == 0) {
                                            if (b2) {
                                                this.a(ai2, ai4, b, d);
                                            }
                                            am.a(ai2, ai4, b);
                                            if (a == 0) {
                                                break Label_1113;
                                            }
                                        }
                                        if (al.equals(al2)) {
                                            if (y.f.i.a.al.a(al) == 1) {
                                                this.a(ai2, ai4, b, d);
                                                if (a == 0) {
                                                    break Label_1113;
                                                }
                                            }
                                            if (b2) {
                                                this.a(ai2, ai4, b, d);
                                                if (a == 0) {
                                                    break Label_1113;
                                                }
                                            }
                                            b = (byte)(-b);
                                            this.a(ai2, ai4, b, d);
                                            if (a == 0) {
                                                break Label_1113;
                                            }
                                        }
                                        if (y.f.i.a.al.a(al) == 2 && y.f.i.a.al.a(al2) == 2) {
                                            if (y.f.i.a.al.b(al).h() == y.f.i.a.al.b(al2).h()) {
                                                am.a(ai2, ai4, b);
                                                if (a == 0) {
                                                    break Label_1113;
                                                }
                                            }
                                            this.a(ai2, ai4, b, d);
                                            if (a == 0) {
                                                break Label_1113;
                                            }
                                        }
                                        if (y.f.i.a.al.a(al) == 2 || y.f.i.a.al.a(al2) == 2) {
                                            if (y.f.i.a.al.a(al) == 1 || y.f.i.a.al.a(al2) == 1) {
                                                this.a(ai2, ai4, b, d);
                                                final ai b7 = this.b.a(j).b(y.f.i.a.al.b(al));
                                                final ai b8 = this.b.a(l).b(y.f.i.a.al.b(al2));
                                                if (y.f.i.a.al.a(al) == 2) {
                                                    final y h2 = y.f.i.a.al.b(al).h();
                                                    am.a(b7, b8, (h2 == y.b || h2 == y.c) ? (-Math.abs(b)) : Math.abs(b));
                                                    if (a == 0) {
                                                        break Label_1113;
                                                    }
                                                }
                                                final y h3 = y.f.i.a.al.b(al2).h();
                                                am.a(b8, b7, (h3 == y.b || h3 == y.c) ? (-Math.abs(b)) : Math.abs(b));
                                                if (a == 0) {
                                                    break Label_1113;
                                                }
                                            }
                                            this.a(ai2, ai4, b, d);
                                            if (a == 0) {
                                                break Label_1113;
                                            }
                                        }
                                        if (b2) {
                                            this.a(ai2, ai4, b, d);
                                        }
                                        am.a(ai2, ai4, b);
                                    }
                                }
                            }
                            ++k;
                            if (a != 0) {
                                break;
                            }
                        }
                        break;
                    }
                    break Label_1134;
                }
                ++i;
                if (a != 0) {
                    break;
                }
                continue;
                int n2 = 0;
                if (n2 > 0) {
                    this.a(h.d(), d);
                }
                return;
            }
            d.size();
            continue Label_1134;
        }
    }
    
    private boolean a(final M m, final ai ai) {
        return ai.a() != null && m.c(new M(ai.a().a() - 1.0, ai.a().b() + 1.0));
    }
    
    private boolean b(final M m, final ai ai) {
        return m.b(ai.b()) <= 1.0;
    }
    
    private void a(final ai ai, final ai ai2, final int n, final D d) {
        final ai ai3 = (ai.k() != null) ? ai.k().c() : ai;
        final ai ai4 = (ai2.k() != null) ? ai2.k().c() : ai2;
        if (ai3 != ai4) {
            this.c.put(new ap(this, ai3, ai4), new Integer(n));
            d.add((n < 0) ? new ap(this, ai3, ai4) : new ap(this, ai4, ai3));
        }
    }
    
    private void a(final List list, final D d) {
        final int a = ab.a;
        final i i = new i();
        final y.c.h u = i.u();
        final D d2 = new D();
        final D d3 = new D();
        final HashSet<ai> set = new HashSet<ai>(list.size());
        final A t = i.t();
        final HashMap<Object, q> hashMap = new HashMap<Object, q>();
        for (final ap ap : d) {
            final ai a2 = ap.a;
            if (set.add(a2)) {
                final q d4 = i.d();
                d2.add(d4);
                hashMap.put(a2, d4);
                t.a(d4, a2);
                d3.add(a2);
            }
            final ai b = ap.b;
            if (set.add(b)) {
                final q d5 = i.d();
                d2.add(d5);
                hashMap.put(b, d5);
                t.a(d5, b);
                d3.add(b);
            }
            u.a(i.a(hashMap.get(a2), hashMap.get(b)), 1);
            if (a != 0) {
                break;
            }
        }
        final q[] array = (q[])d2.toArray(new q[d2.size()]);
        final int[] a3 = this.a(i, array, u);
        final HashMap<Object, Integer> hashMap2 = new HashMap<Object, Integer>();
        int j = 0;
        while (true) {
            while (j < array.length) {
                hashMap2.put(t.b(array[j]), new Integer(a3[j]));
                ++j;
                if (a != 0) {
                    final D d6 = new D();
                    for (final ai ai : d3) {
                        if (ai.k() != null) {
                            final List b2 = ai.k().b();
                            set.addAll((Collection<?>)b2);
                            d6.addAll(b2);
                            if (a == 0) {
                                continue;
                            }
                        }
                        d6.add(ai);
                        if (a != 0) {
                            break;
                        }
                    }
                    int n = 0;
                    for (final ai ai2 : list) {
                        final boolean add = set.add(ai2);
                        if (a != 0) {
                            return;
                        }
                        if (add) {
                            d6.add(n, ai2);
                        }
                        ++n;
                        if (a != 0) {
                            break;
                        }
                    }
                    list.clear();
                    list.addAll(d6);
                    return;
                }
                if (a != 0) {
                    break;
                }
            }
            d3.sort(new ak(this, hashMap2));
            continue;
        }
    }
    
    private al[] a(final h h) {
        final int a = ab.a;
        final List d = h.d();
        final al[] array = new al[d.size()];
        final HashMap<Object, Object> hashMap = (HashMap<Object, Object>)new HashMap<Object, al>();
        int n = 0;
        for (final ai ai : d) {
            final d i = ai.i();
            al al = null;
            Label_0130: {
                if (hashMap.containsKey(i)) {
                    al = hashMap.get(i);
                    al.a(ai);
                    if (a == 0) {
                        break Label_0130;
                    }
                }
                al = new al(ai);
                hashMap.put(i, al);
            }
            array[n] = al;
            ++n;
            if (a != 0) {
                break;
            }
        }
        return array;
    }
    
    private an a(final ai ai) {
        final w a = this.b.a(ai.i());
        return new an(a.a(ai), ai, a.b(ai));
    }
    
    private M b(final ai ai) {
        return (ai.a() == null) ? ai.b() : (ai.g() ? new M(ai.a().b(), ai.b().b()) : new M(ai.b().a(), ai.a().a()));
    }
    
    private M c(final ai ai) {
        return (ai.a() == null) ? ai.b() : (ai.g() ? new M(ai.b().a(), ai.a().a()) : new M(ai.a().b(), ai.b().b()));
    }
    
    private int a(final M m, final M i) {
        return (int)a(m.c() - i.c());
    }
    
    private static double a(final double n) {
        if (Double.isNaN(n)) {
            return Double.NaN;
        }
        if (n > 0.0) {
            return 1.0;
        }
        if (n < 0.0) {
            return -1.0;
        }
        return n;
    }
    
    private void a(final am am) {
        final int i = ab.a;
        final i j = new i();
        final int a = am.a();
        final q[] array = new q[a];
        int k = 0;
        while (k < a) {
            array[k] = j.d();
            ++k;
            if (i != 0) {
                break;
            }
        }
        final y.c.h u = j.u();
        int n = 1;
        do {
            int l = 0;
            Label_0059: {
                l = n;
            }
            Label_0061:
            while (l < a) {
                int n2 = 0;
                while (n2 < n) {
                    final byte a2 = am.a(n, n2);
                    final int n3 = l = a2;
                    if (i != 0) {
                        continue Label_0061;
                    }
                    Label_0152: {
                        if (n3 > 0) {
                            u.a(j.a(array[n], array[n2]), a2);
                            if (i == 0) {
                                break Label_0152;
                            }
                        }
                        if (a2 < 0) {
                            u.a(j.a(array[n2], array[n]), -a2);
                        }
                    }
                    ++n2;
                    if (i != 0) {
                        break;
                    }
                }
                ++n;
                continue Label_0059;
            }
            break;
        } while (i == 0);
        final int[] a3 = this.a(j, array, u);
        this.e = new int[this.d.a().g()];
        this.f = new int[this.d.a().g()];
        System.arraycopy(a3, 0, this.e, 0, this.e.length);
        System.arraycopy(a3, this.e.length, this.f, 0, this.f.length);
    }
    
    private int[] a(final i i, final q[] array, final y.c.h h) {
        final int a = ab.a;
        this.a(i, h);
        final y.g.a.d d = new y.g.a.d(i);
        int n = 1;
        final int[] array2 = new int[i.e()];
        final int[] array3 = new int[i.e()];
        final int n2 = i.e() / 2;
        int j = 0;
        while (true) {
            while (j < array.length) {
                final q q = array[j];
                final int b = q.b();
                if (a != 0) {
                    int n3 = b;
                    int n5 = 0;
                    Label_0379: {
                    Label_0378:
                        while (true) {
                            d.a();
                            int k = 0;
                        Label_0191:
                            while (k == 0) {
                                final q c = d.c();
                                array3[c.d()] = n3++;
                                d d2 = c.f();
                                while (d2 != null) {
                                    final q d3 = d2.d();
                                    final int n4 = array2[d3.d()];
                                    final int[] array4 = array2;
                                    final int d4 = d3.d();
                                    --array4[d4];
                                    k = (n5 = n4);
                                    if (a != 0) {
                                        continue Label_0191;
                                    }
                                    if (a != 0) {
                                        break Label_0379;
                                    }
                                    Label_0366: {
                                        if (k == 1) {
                                            final q q2 = (d3.d() < n2) ? array[d3.d() + n2] : array[d3.d() - n2];
                                            if (array3[q2.d()] != 0) {
                                                d.a(d3, -array3[q2.d()]);
                                                if (a == 0) {
                                                    break Label_0366;
                                                }
                                            }
                                            array3[d3.d()] = n;
                                            d.a(d3, n++);
                                        }
                                    }
                                    d2 = d2.g();
                                    if (a != 0) {
                                        break Label_0378;
                                    }
                                }
                                continue Label_0379;
                            }
                            break;
                        }
                        n5 = 0;
                    }
                    int l = n5;
                    int[] array5 = null;
                    while (l < array3.length) {
                        array5 = array3;
                        if (a != 0) {
                            return array5;
                        }
                        array5[l] = -array3[l];
                        ++l;
                        if (a != 0) {
                            break;
                        }
                    }
                    return array5;
                }
                Label_0173: {
                    if (b == 0) {
                        final int n6 = (j < n2) ? (j + n2) : (j - n2);
                        if (array3[n6] != 0) {
                            d.a(q, array3[j] = -array3[n6]);
                            if (a == 0) {
                                break Label_0173;
                            }
                        }
                        array3[j] = n;
                        d.a(q, n++);
                        if (a == 0) {
                            break Label_0173;
                        }
                    }
                    array2[j] = q.b();
                }
                ++j;
                if (a != 0) {
                    break;
                }
            }
            continue;
        }
    }
    
    void a(final i i, final c c) {
        final int a = ab.a;
        if (g.a(i)) {
            return;
        }
        final y.c.h b = y.g.M.b();
        final e p2 = i.p();
        while (p2.f()) {
            final d a2 = p2.a();
            b.a(a2, c.a(a2));
            p2.g();
            if (a != 0) {
                break;
            }
        }
        final q[] m = i.m();
        final int n = i.e() / 2;
        final D d = new D();
    Label_0398:
        while (true) {
            f a3;
        Label_0385:
            while (!(a3 = y.a.c.a(i, true)).isEmpty()) {
                a3.size();
                int j = 0;
                int n2 = 0;
            Label_0113:
                while (j != n2) {
                    int n3 = Integer.MAX_VALUE;
                    final e a4 = a3.a();
                    while (a4.f()) {
                        final int n4 = j = b.a(a4.a());
                        n2 = n3;
                        if (a != 0) {
                            continue Label_0113;
                        }
                        if (j < n2) {
                            n3 = n4;
                        }
                        a4.g();
                        if (a != 0) {
                            break;
                        }
                    }
                    final e a5 = a3.a();
                    while (a5.f()) {
                        final d a6 = a5.a();
                        final int d2 = a6.c().d();
                        final int d3 = a6.d().d();
                        if (a != 0) {
                            break Label_0398;
                        }
                        final int n5 = d2;
                        final int n6 = n;
                        if (a != 0) {
                            continue Label_0113;
                        }
                        final d b2 = m[(n5 >= n6) ? (d2 - n) : (d2 + n)].b(m[(d3 >= n) ? (d3 - n) : (d3 + n)]);
                        final int n7 = b.a(a6) - n3;
                        b.a(a6, n7);
                        b.a(b2, n7);
                        if (n7 == 0) {
                            final aq aq = new aq(i, a6, b2, null);
                            aq.b();
                            d.add(aq);
                        }
                        a5.g();
                        if (a != 0) {
                            break Label_0385;
                        }
                    }
                    continue Label_0398;
                }
                throw new IllegalStateException("Selfloop in Order Graph!");
                final C k = d.m();
                while (k.f()) {
                    final aq aq2 = (aq)k.d();
                    aq2.a();
                    if (!g.a(i)) {
                        aq2.b();
                    }
                    k.g();
                    if (a != 0) {
                        break;
                    }
                }
                return;
            }
            d.sort(new ao(c));
            continue Label_0398;
        }
    }
}
