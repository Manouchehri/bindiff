package y.f.c.a;

import y.f.*;
import java.util.*;
import y.a.*;
import y.c.*;

final class dA
{
    private final i a;
    private final A b;
    private final h c;
    private final Map d;
    private final i e;
    private final aV f;
    private final boolean g;
    private final boolean h;
    private int[] i;
    private boolean[][] j;
    private q k;
    
    dA(final i e, final aV f, final boolean g, final boolean h) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.a = new i();
        this.b = this.a.t();
        this.c = this.a.u();
        this.d = new HashMap();
        this.k = null;
    }
    
    boolean a(final q q) {
        final aX a = this.f.a(q);
        return a != null && 1 == a.b();
    }
    
    private boolean a(final dy dy) {
        if (dy.a != null) {
            final aX a = this.f.a(dy.a);
            return a != null && 1 == a.b();
        }
        return false;
    }
    
    boolean a(final d d) {
        return this.c.d(d);
    }
    
    int b(final q q) {
        return this.i[this.c(q).d()];
    }
    
    dA a(final dA da) {
        final boolean x = N.x;
        final ArrayList<Object> list = new ArrayList<Object>();
        final ArrayList<q> list2 = new ArrayList<q>();
        final x o = da.a.o();
        while (o.f()) {
            final dy e = da.e(o.e());
            Label_0157: {
                if (e.a != null && this.c(e.a) == null) {
                    final q d = this.a.d();
                    this.d.put(e.a, d);
                    this.b.a(d, e);
                    if (e.b == 1) {
                        list.add(d);
                        if (!x) {
                            break Label_0157;
                        }
                    }
                    if (e.b == 2) {
                        list2.add(d);
                    }
                }
            }
            o.g();
            if (x) {
                break;
            }
        }
        int n = 0;
        int n2 = list.size();
        while (true) {
            do {
                int i = 0;
                Label_0180: {
                    i = n;
                }
                int n3 = n2;
                q q;
                x o2;
                x x2;
                q e2;
                byte b;
                int n4;
                x x3;
                q e3;
                int b3;
                byte b2;
                int n6;
                int n5;
                i a = null;
                e p;
                d a2;
                dy e4;
                dy e5;
                q c;
                q c2;
                q c3;
                Label_0184:
                Label_0345_Outer:Label_0317_Outer:
                while (i < n3) {
                    q = list.get(n);
                    o2 = this.a.o();
                    if (!x) {
                        x2 = o2;
                        while (x2.f()) {
                            e2 = x2.e();
                            b = (byte)(i = this.e(e2).b);
                            n4 = (n3 = 1);
                            if (x) {
                                continue Label_0184;
                            }
                            if (b != n4 && q.a(e2) == null) {
                                this.c.a(this.a.a(q, e2), true);
                            }
                            x2.g();
                            if (x) {
                                break;
                            }
                        }
                        ++n;
                        continue Label_0180;
                    }
                    Label_0435: {
                    Label_0317:
                        while (true) {
                            Label_0427: {
                                while (true) {
                                    x3 = o2;
                                    while (x3.f()) {
                                        e3 = x3.e();
                                        b2 = (byte)(b3 = this.e(e3).b);
                                        n5 = (n6 = 2);
                                        if (x) {
                                            break Label_0317;
                                        }
                                        if (b2 != n5 && e3.a(q) == null) {
                                            this.c.a(this.a.a(e3, q), true);
                                        }
                                        x3.g();
                                        if (x) {
                                            break;
                                        }
                                    }
                                    break Label_0427;
                                    if (b3 >= n6) {
                                        break Label_0435;
                                    }
                                    q = list2.get(n);
                                    a = this.a;
                                    if (!x) {
                                        a.o();
                                        continue Label_0317_Outer;
                                    }
                                    break;
                                }
                                break Label_0435;
                            }
                            ++n;
                            if (!x) {
                                b3 = n;
                                n6 = n2;
                                continue Label_0317;
                            }
                            break;
                        }
                    }
                    p = a.p();
                    while (true) {
                        while (p.f()) {
                            a2 = p.a();
                            e4 = da.e(a2.c());
                            e5 = da.e(a2.d());
                            if (!x) {
                                Label_0671: {
                                    if (e4.a != null) {
                                        c = this.c(e4.a);
                                        if (e5.a == null) {
                                            break Label_0671;
                                        }
                                        c2 = this.c(e5.a);
                                        if (c.a(c2) == null) {
                                            this.c.a(this.a.a(c, c2), da.a(a2));
                                            if (!x) {
                                                break Label_0671;
                                            }
                                        }
                                        if (c.a(this.k) != null) {
                                            break Label_0671;
                                        }
                                        this.c.a(this.a.a(c, this.k), da.a(a2));
                                        if (!x) {
                                            break Label_0671;
                                        }
                                    }
                                    if (e5.a != null) {
                                        c3 = this.c(e5.a);
                                        if (this.k.a(c3) == null) {
                                            this.c.a(this.a.a(this.k, c3), da.a(a2));
                                        }
                                    }
                                }
                                p.g();
                                if (x) {
                                    break;
                                }
                                continue Label_0345_Outer;
                            }
                            else {
                                if (!m.a(this.a, this.i)) {
                                    throw new IllegalArgumentException("Cyclic sequence constraints!");
                                }
                                return this;
                            }
                        }
                        if (this.i.length < this.a.f()) {
                            this.i = new int[this.a.f()];
                        }
                        continue;
                    }
                }
                break;
            } while (!x);
            n = 0;
            n2 = list2.size();
            continue;
        }
    }
    
    void a() {
        final boolean x = N.x;
        final i i = (i)this.e.c(bw.a).b(this.e);
        final Map map = (Map)i.c(cA.a).b(null);
        final c c = i.c(cA.b);
        final A t = i.t();
        final HashSet set = new HashSet<q>();
        final c c2 = this.e.c(ah.f_);
        final int[] array = new int[this.e.e()];
        int n = -1;
        final x o = this.e.o();
        while (o.f()) {
            aX a = this.f.a(o.e());
            q a2;
            if (a != null && (12 == a.b() || 13 == a.b())) {
                a2 = a.l();
                a = null;
            }
            else {
                a2 = o.e();
            }
            int n2 = 0;
            Label_0236: {
                if (a != null) {
                    final bK h = a.h();
                    n2 = ((h != null) ? h.j() : -1);
                    if (n2 <= n) {
                        break Label_0236;
                    }
                    n = n2;
                    if (!x) {
                        break Label_0236;
                    }
                }
                n2 = -1;
            }
            array[o.e().d()] = n2;
            if (!set.contains(a2)) {
                set.add(a2);
                final Object value = map.get((c2 != null) ? c2.b(a2) : a2);
                if (value != null || n2 >= 0) {
                    final q d = this.d(a2);
                    final dy e = this.e(d);
                    e.a = a2;
                    if (value != null) {
                        final Object b = c.b(value);
                        Label_0390: {
                            if (Boolean.TRUE.equals(b)) {
                                e.b = 1;
                                if (!x) {
                                    break Label_0390;
                                }
                            }
                            if (Boolean.FALSE.equals(b)) {
                                e.b = 2;
                            }
                        }
                        t.a(value, d);
                    }
                }
            }
            o.g();
            if (x) {
                break;
            }
        }
        final e p = i.p();
        while (true) {
        Label_2679_Outer:
            while (p.f()) {
                final q q = (q)t.b(p.a().c());
                final q q2 = (q)t.b(p.a().d());
                final Object b2;
                final q q3 = (q)(b2 = q);
                if (x) {
                    final E e2 = (E)b2;
                    Label_1600: {
                        if (!this.h && e2.k()) {
                            final e p2 = this.a.p();
                            while (p2.f()) {
                                final d a3 = p2.a();
                                final q a4 = this.e(a3.c()).a;
                                final q a5 = this.e(a3.d()).a;
                                q q4 = e2.i(a4);
                                q q5 = e2.i(a5);
                                if (x) {
                                    break Label_1600;
                                }
                                Label_1332: {
                                    Label_1325: {
                                        if (q4 != q5) {
                                            if (q4 == null) {
                                                q a6 = q5;
                                                while (q5 != null) {
                                                    a6 = q5;
                                                    q5 = e2.i(q5);
                                                    if (x) {
                                                        break Label_1332;
                                                    }
                                                    if (x) {
                                                        break;
                                                    }
                                                }
                                                q q6 = this.c(a6);
                                                if (q6 == null) {
                                                    q6 = this.d(a6);
                                                    this.e(q6).a = a6;
                                                }
                                                if (p2.a().c() != q6) {
                                                    this.a.a(p2.a(), p2.a().c(), q6);
                                                    if (!x) {
                                                        break Label_1325;
                                                    }
                                                }
                                                this.a.a(p2.a());
                                                if (!x) {
                                                    break Label_1325;
                                                }
                                            }
                                            if (q5 == null) {
                                                q a7 = q4;
                                                while (q4 != null) {
                                                    a7 = q4;
                                                    q4 = e2.i(q4);
                                                    if (x) {
                                                        break Label_1332;
                                                    }
                                                    if (x) {
                                                        break;
                                                    }
                                                }
                                                q q7 = this.c(a7);
                                                if (q7 == null) {
                                                    q7 = this.d(a7);
                                                    this.e(q7).a = a7;
                                                }
                                                if (p2.a().d() != q7) {
                                                    this.a.a(p2.a(), q7, p2.a().d());
                                                    if (!x) {
                                                        break Label_1325;
                                                    }
                                                }
                                                this.a.a(p2.a());
                                                if (!x) {
                                                    break Label_1325;
                                                }
                                            }
                                            final ArrayList<Object> list = new ArrayList<Object>();
                                            list.add(a4);
                                            final HashSet set2 = new HashSet<q>();
                                            q j = q4;
                                            while (true) {
                                                while (j != null) {
                                                    list.add(j);
                                                    set2.add(j);
                                                    j = e2.i(j);
                                                    if (x) {
                                                        q k = a5;
                                                        while (!set2.contains(e2.i(k))) {
                                                            k = e2.i(k);
                                                            if (x) {
                                                                break Label_1332;
                                                            }
                                                            if (x) {
                                                                break;
                                                            }
                                                        }
                                                        final q a8 = k;
                                                        final q a9 = list.get(list.indexOf(e2.i(k)) - 1);
                                                        if (a9 != a8) {
                                                            q q8 = this.c(a8);
                                                            if (q8 == null) {
                                                                q8 = this.d(a8);
                                                                this.e(q8).a = a8;
                                                            }
                                                            q q9 = this.c(a9);
                                                            if (q9 == null) {
                                                                q9 = this.d(a9);
                                                                this.e(q9).a = a9;
                                                            }
                                                            this.a.a(p2.a(), q9, q8);
                                                            if (!x) {
                                                                break Label_1325;
                                                            }
                                                        }
                                                        this.a.a(p2.a());
                                                        break Label_1325;
                                                    }
                                                    if (x) {
                                                        break;
                                                    }
                                                }
                                                list.add(j);
                                                set2.add(j);
                                                continue Label_2679_Outer;
                                            }
                                        }
                                    }
                                    p2.g();
                                }
                                if (x) {
                                    break;
                                }
                            }
                        }
                        if (this.g) {
                            final c c3 = this.e.c(N.t);
                            if (c3 != null) {
                                final ArrayList<Object> list2 = new ArrayList<Object>(this.a.h());
                                final e p3 = this.a.p();
                                while (true) {
                                    while (p3.f()) {
                                        final d a10 = p3.a();
                                        final int d2;
                                        final int n3 = d2 = (c3.d(this.e(a10.c()).a) ? 1 : 0);
                                        if (x) {
                                            int l = d2;
                                            while (l < list2.size()) {
                                                this.a.a(list2.get(l));
                                                ++l;
                                                if (x) {
                                                    break Label_1600;
                                                }
                                                if (x) {
                                                    break;
                                                }
                                            }
                                            final x o2 = this.a.o();
                                            while (o2.f()) {
                                                final dy e3 = this.e(o2.e());
                                                if (e3.b != 0 && !c3.d(e3.a)) {
                                                    e3.b = 0;
                                                }
                                                o2.g();
                                                if (x) {
                                                    break;
                                                }
                                            }
                                            break Label_1600;
                                        }
                                        if (n3 == 0 && !c3.d(this.e(a10.d()).a)) {
                                            list2.add(a10);
                                        }
                                        p3.g();
                                        if (x) {
                                            break;
                                        }
                                    }
                                    int d2 = 0;
                                    continue Label_2679_Outer;
                                }
                            }
                        }
                    }
                    final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                    final HashMap<Object, List> hashMap2 = new HashMap<Object, List>();
                    final ArrayList<Object> list3 = new ArrayList<Object>();
                    final HashSet<q> set3 = new HashSet<q>();
                    final x o3 = this.e.o();
                    while (o3.f()) {
                        final q e4 = o3.e();
                        final aX a11 = this.f.a(e4);
                        q a12 = null;
                        boolean b3 = false;
                        Label_1865: {
                            Label_1791: {
                                switch ((a11 != null) ? a11.b() : -128) {
                                    case 12: {
                                        a12 = a11.l();
                                        List<?> list4 = hashMap.get(a12);
                                        if (list4 == null) {
                                            list4 = new ArrayList<Object>();
                                            hashMap.put(a12, list4);
                                        }
                                        list4.add(e4);
                                        b3 = true;
                                        if (x) {
                                            break Label_1791;
                                        }
                                        break Label_1865;
                                    }
                                    case 13: {
                                        a12 = a11.l();
                                        List<q> list5 = hashMap2.get(a12);
                                        if (list5 == null) {
                                            list5 = new ArrayList<q>();
                                            hashMap2.put(a12, list5);
                                        }
                                        list5.add(e4);
                                        b3 = true;
                                        if (x) {
                                            break;
                                        }
                                        break Label_1865;
                                    }
                                }
                            }
                            a12 = e4;
                            b3 = false;
                        }
                        if (b3 && !set3.contains(a12)) {
                            list3.add(a12);
                            set3.add(a12);
                        }
                        q q10 = this.c(a12);
                        if (q10 == null) {
                            q10 = this.d(a12);
                        }
                        this.e(q10).a = a12;
                        o3.g();
                        if (x) {
                            break;
                        }
                    }
                    final HashMap<Object, q> hashMap3 = new HashMap<Object, q>();
                    final HashMap<Object, q> hashMap4 = new HashMap<Object, q>();
                    int n4 = 0;
                    int size = list3.size();
                Label_1976:
                    while (true) {
                        q q11;
                        q c4;
                        dy e5;
                        int n5;
                        byte b4;
                        q d3;
                        e m;
                        d a13;
                        q c5;
                        d a14;
                        int n6;
                        List<?> list6;
                        q[] array2;
                        int n7;
                        q c6;
                        q q12;
                        q q13;
                        e l2;
                        d a15;
                        q d4;
                        Object o4;
                        d d5;
                        List list7;
                        q[] array3;
                        int n8;
                        q c7;
                        q q14;
                        int j2;
                        int j3;
                        q q15;
                        HashMap hashMap5;
                        int n9;
                        q q16;
                        int n10;
                        x o5;
                        dA da;
                        double[] array4;
                        double[][] array5;
                        int n11;
                        int n12;
                        x o6;
                        boolean d6 = false;
                        q e6;
                        byte b5;
                        byte b6 = 0;
                        int n13 = 0;
                        x o7;
                        q e7;
                        dy e8;
                        boolean b8;
                        boolean b7;
                        d d7;
                        x o8;
                        q e9;
                        dy e10;
                        byte b9;
                        d d8;
                        aX a16;
                        q l3;
                        x a17;
                        q q17;
                        aX a18;
                        q c8;
                        x a19;
                        boolean d9;
                        q q18;
                        aX a20;
                        q c9;
                        int n14 = 0;
                        q[] array6;
                        int n15;
                        x o9;
                        q e11;
                        int n17;
                        int n16;
                        Label_2345_Outer:Label_3920_Outer:Label_3870_Outer:
                        while (n4 < size) {
                            q11 = list3.get(n4);
                            c4 = this.c(q11);
                            e5 = this.e(c4);
                            b4 = (byte)(n5 = e5.b);
                        Label_2739:
                            while (true) {
                                Label_2730: {
                                    if (!x) {
                                        if (b4 != 0) {
                                            this.a(e2, e2.h(q11), e5.b);
                                        }
                                        d3 = this.a.d();
                                        this.b.a(d3, new dy());
                                        hashMap3.put(q11, d3);
                                        m = c4.k();
                                        while (m.f()) {
                                            a13 = m.a();
                                            c5 = a13.c();
                                            a14 = c5.a(d3);
                                            if (x) {
                                                break Label_2730;
                                            }
                                            if (a14 == null) {
                                                this.c.a(this.a.a(c5, d3), this.c.d(a13));
                                            }
                                            m.g();
                                            if (x) {
                                                break;
                                            }
                                        }
                                        n6 = Integer.MAX_VALUE;
                                        list6 = hashMap.get(q11);
                                        array2 = list6.toArray(new q[list6.size()]);
                                        n7 = 0;
                                        while (true) {
                                            while (n7 < array2.length) {
                                                this.d.put(array2[n7], d3);
                                                q12 = (c6 = this.c(array2[n7]));
                                                if (x) {
                                                    q13 = c6;
                                                    this.b.a(q13, new dy());
                                                    hashMap4.put(q11, q13);
                                                    l2 = c4.l();
                                                    while (true) {
                                                        while (l2.f()) {
                                                            a15 = l2.a();
                                                            d4 = a15.d();
                                                            d5 = (d)(o4 = d4.b(q13));
                                                            if (x) {
                                                                list7 = (List)o4;
                                                                array3 = list7.toArray(new q[list7.size()]);
                                                                n8 = 0;
                                                                while (true) {
                                                                    while (n8 < array3.length) {
                                                                        this.d.put(array3[n8], q13);
                                                                        q14 = (c7 = this.c(array3[n8]));
                                                                        if (!x) {
                                                                            if (c7 != null && q13 != q14) {
                                                                                this.a.a(q14);
                                                                            }
                                                                            j2 = this.f.a(array3[n8]).j();
                                                                            if (n6 > j2) {
                                                                                n6 = j2;
                                                                                this.e(q13).a = array3[n8];
                                                                            }
                                                                            ++n8;
                                                                            if (x) {
                                                                                break;
                                                                            }
                                                                            continue Label_2345_Outer;
                                                                        }
                                                                        else {
                                                                            if (c7 != q13 && d3.a(q13) == null) {
                                                                                this.a.a(d3, q13);
                                                                            }
                                                                            ++n4;
                                                                            if (x) {
                                                                                break Label_2345_Outer;
                                                                            }
                                                                            continue Label_1976;
                                                                        }
                                                                    }
                                                                    continue Label_2679_Outer;
                                                                }
                                                            }
                                                            if (d5 == null) {
                                                                this.c.a(this.a.a(q13, d4), this.c.d(a15));
                                                            }
                                                            l2.g();
                                                            if (x) {
                                                                break;
                                                            }
                                                        }
                                                        n6 = Integer.MAX_VALUE;
                                                        o4 = hashMap2.get(q11);
                                                        continue Label_2679_Outer;
                                                    }
                                                }
                                                if (c6 != null && d3 != q12) {
                                                    this.a.a(q12);
                                                }
                                                j3 = this.f.a(array2[n7]).j();
                                                if (n6 > j3) {
                                                    n6 = j3;
                                                    this.e(d3).a = array2[n7];
                                                }
                                                ++n7;
                                                if (x) {
                                                    break;
                                                }
                                            }
                                            this.a.d();
                                            continue Label_2679_Outer;
                                        }
                                    }
                                    size = n5;
                                    if (n4 >= size) {
                                        break Label_2739;
                                    }
                                    q15 = list3.get(n4);
                                    this.a.a(this.c(q15));
                                    this.d.remove(q15);
                                }
                                ++n4;
                                if (!x) {
                                    continue Label_3920_Outer;
                                }
                                break;
                            }
                            hashMap5 = new HashMap();
                            n9 = 0;
                        Label_3877_Outer:
                            while (true) {
                            Label_3877:
                                while (true) {
                                Label_3920:
                                    while (true) {
                                        while (n9 < list3.size()) {
                                            q16 = list3.get(n9);
                                            n10 = (this.a(q16, hashMap5, e2) & 0x1);
                                            if (!x) {
                                                if (n10 != 0) {
                                                    this.e(hashMap3.get(q16)).b = 1;
                                                }
                                                if ((this.a(q16, hashMap5, e2) & 0x2) != 0x0) {
                                                    this.e(hashMap4.get(q16)).b = 2;
                                                }
                                                ++n9;
                                                if (x) {
                                                    break;
                                                }
                                                continue Label_2679_Outer;
                                            }
                                            else {
                                                if (n10 == 0) {
                                                    throw new IllegalArgumentException("Cyclic sequence constraints!");
                                                }
                                                o5 = this.a.o();
                                                while (true) {
                                                    while (o5.f()) {
                                                        da = this;
                                                        if (x) {
                                                            array4 = new double[da.a.h()];
                                                            array5 = new double[this.a.f()][this.a.f()];
                                                            Arrays.fill(array4, 1.0);
                                                            v.a(this.a, true, array4, array5);
                                                            this.j = new boolean[array5.length][array5.length];
                                                            n11 = 0;
                                                            while (n11 < this.j.length) {
                                                                n12 = 0;
                                                                while (n12 < this.j[n11].length) {
                                                                    this.j[n11][n12] = !Double.isInfinite(array5[n11][n12]);
                                                                    ++n12;
                                                                    if (x) {
                                                                        break;
                                                                    }
                                                                }
                                                                ++n11;
                                                                if (x) {
                                                                    break;
                                                                }
                                                            }
                                                            return;
                                                        }
                                                        this.e(o5.e()).c = o5.e().d();
                                                        o5.g();
                                                        if (x) {
                                                            break;
                                                        }
                                                    }
                                                    da = this;
                                                    continue Label_3870_Outer;
                                                }
                                            }
                                        }
                                        o6 = this.a.o();
                                        do {
                                            Label_2873: {
                                                o6.f();
                                            }
                                            Label_2880:
                                            while (d6) {
                                                e6 = o6.e();
                                                if (!x) {
                                                    if (e6 != this.k) {
                                                        b5 = this.e(e6).b;
                                                        Label_2923:
                                                        while (true) {
                                                            Label_3053: {
                                                                if (b6 == n13) {
                                                                    o7 = this.a.o();
                                                                    while (o7.f()) {
                                                                        e7 = o7.e();
                                                                        e8 = this.e(e7);
                                                                        b6 = e8.b;
                                                                        b7 = (b8 = true);
                                                                        if (x) {
                                                                            continue Label_2923;
                                                                        }
                                                                        if (b6 != (b7 ? 1 : 0) && !this.a(e2, this.f, e6, e7) && !this.a(e8)) {
                                                                            d7 = e6.a(e7);
                                                                            if (d7 == null) {
                                                                                d7 = this.a.a(e6, e7);
                                                                            }
                                                                            this.c.a(d7, true);
                                                                        }
                                                                        o7.g();
                                                                        if (x) {
                                                                            break Label_3053;
                                                                        }
                                                                    }
                                                                    break;
                                                                }
                                                            }
                                                            if (2 == b5) {
                                                                o8 = this.a.o();
                                                                while (o8.f()) {
                                                                    e9 = o8.e();
                                                                    e10 = this.e(e9);
                                                                    b9 = e10.b;
                                                                    n13 = 2;
                                                                    if (x) {
                                                                        continue Label_2923;
                                                                    }
                                                                    if (b9 != n13 && !this.b(e2, this.f, e6, e9) && !this.a(e10)) {
                                                                        d8 = e6.b(e9);
                                                                        if (d8 == null) {
                                                                            d8 = this.a.a(e9, e6);
                                                                        }
                                                                        this.c.a(d8, true);
                                                                    }
                                                                    o8.g();
                                                                    if (x) {
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            }
                                                            break;
                                                        }
                                                        a16 = this.f.a(this.e(e6).a);
                                                        if (a16 != null) {
                                                            l3 = a16.l();
                                                            Label_3465: {
                                                                switch (a16.b()) {
                                                                    case 12: {
                                                                        a17 = e2.h(l3).a();
                                                                        while (a17.f()) {
                                                                            d6 = e2.d(a17.e());
                                                                            if (x) {
                                                                                continue Label_2880;
                                                                            }
                                                                            Label_3453: {
                                                                                if (d6) {
                                                                                    q17 = hashMap3.get(a17.e());
                                                                                    if (e6 == q17 || q17 == null || e6.a(q17) != null) {
                                                                                        break Label_3453;
                                                                                    }
                                                                                    this.a.a(e6, q17);
                                                                                    if (!x) {
                                                                                        break Label_3453;
                                                                                    }
                                                                                }
                                                                                a18 = this.f.a(a17.e());
                                                                                if (a18 != null) {
                                                                                    if (12 == a18.b()) {
                                                                                        break Label_3453;
                                                                                    }
                                                                                    if (13 == a18.b()) {
                                                                                        break Label_3453;
                                                                                    }
                                                                                }
                                                                                c8 = this.c(a17.e());
                                                                                if (e6 != c8 && c8 != null && e6.a(c8) == null) {
                                                                                    this.a.a(e6, c8);
                                                                                }
                                                                            }
                                                                            a17.g();
                                                                            if (x) {
                                                                                break Label_3465;
                                                                            }
                                                                        }
                                                                        break;
                                                                    }
                                                                    case 13: {
                                                                        a19 = e2.h(l3).a();
                                                                        while (a19.f()) {
                                                                            d9 = e2.d(a19.e());
                                                                            if (x) {
                                                                                continue Label_2880;
                                                                            }
                                                                            Label_3662: {
                                                                                if (d9) {
                                                                                    q18 = hashMap4.get(a19.e());
                                                                                    if (e6 == q18 || q18 == null || e6.b(q18) != null) {
                                                                                        break Label_3662;
                                                                                    }
                                                                                    this.a.a(q18, e6);
                                                                                    if (!x) {
                                                                                        break Label_3662;
                                                                                    }
                                                                                }
                                                                                a20 = this.f.a(a19.e());
                                                                                if (a20 != null) {
                                                                                    if (12 == a20.b()) {
                                                                                        break Label_3662;
                                                                                    }
                                                                                    if (13 == a20.b()) {
                                                                                        break Label_3662;
                                                                                    }
                                                                                }
                                                                                c9 = this.c(a19.e());
                                                                                if (e6 != c9 && c9 != null && e6.b(c9) == null) {
                                                                                    this.a.a(c9, e6);
                                                                                }
                                                                            }
                                                                            a19.g();
                                                                            if (x) {
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    o6.g();
                                                    continue Label_2873;
                                                }
                                                this.a.g();
                                                y.f.c.a.m.a(this.a, new dx(this, n14));
                                                this.i = new int[this.a.f()];
                                                y.a.m.a(this.a, this.i);
                                                continue Label_3920;
                                            }
                                            break;
                                        } while (!x);
                                        break;
                                    }
                                    if (n > 0) {
                                        array6 = new q[n];
                                        n15 = 0;
                                        while (n15 < array6.length) {
                                            array6[n15] = this.d((q)null);
                                            n14 = n15;
                                            if (x) {
                                                continue Label_3877;
                                            }
                                            if (n14 > 0) {
                                                this.a.a(array6[n15 - 1], array6[n15]);
                                            }
                                            ++n15;
                                            if (x) {
                                                break;
                                            }
                                        }
                                        o9 = this.e.o();
                                        while (o9.f()) {
                                            e11 = o9.e();
                                            n16 = (n17 = array[e11.d()]);
                                            if (x) {
                                                continue Label_3877;
                                            }
                                            if (n17 >= 0) {
                                                if (n16 > 0) {
                                                    this.a.a(array6[n16 - 1], this.c(e11));
                                                }
                                                if (n16 < array6.length) {
                                                    this.a.a(this.c(e11), array6[n16]);
                                                }
                                            }
                                            o9.g();
                                            if (x) {
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }
                                continue Label_3877_Outer;
                            }
                        }
                        n4 = 0;
                        n5 = list3.size();
                        continue;
                    }
                }
                if (q3 != null && q2 != null) {
                    final q a21 = this.e(q).a;
                    final int n18 = (a21.e() == this.e) ? array[a21.d()] : -1;
                    final q a22 = this.e(q2).a;
                    final int n19 = (a22.e() == this.e) ? array[a22.d()] : -1;
                    if (n18 < 0 || n19 < 0 || n18 == n19) {
                        this.c.a(this.a.a(q, q2), true);
                    }
                }
                p.g();
                if (x) {
                    break;
                }
            }
            i.a(t);
            this.k = this.a.d();
            this.b.a(this.k, new dy());
            Object b2 = this.e.c(N.w).b(this.e);
            continue;
        }
    }
    
    void b() {
        this.j = null;
    }
    
    private dy e(final q q) {
        return (dy)this.b.b(q);
    }
    
    q c(final q q) {
        return this.d.get(q);
    }
    
    q d(final q q) {
        final q d = this.a.d();
        this.d.put(q, d);
        this.b.a(d, new dy());
        return d;
    }
    
    private boolean a(final E e, final aV av, final q q, final q q2) {
        final q a = this.e(q).a;
        final q a2 = this.e(q2).a;
        if (a == null || a2 == null) {
            return false;
        }
        final aX a3 = av.a(a2);
        return a3 != null && a3.b() == 12 && e.a(a, a3.l());
    }
    
    private boolean b(final E e, final aV av, final q q, final q q2) {
        final q a = this.e(q).a;
        final q a2 = this.e(q2).a;
        if (a == null || a2 == null) {
            return false;
        }
        final aX a3 = av.a(a2);
        return a3 != null && a3.b() == 13 && e.a(a, a3.l());
    }
    
    private void a(final E e, final y y, final byte b) {
        final boolean x = N.x;
        final x a = y.a();
        while (a.f()) {
            final q c = this.c(a.e());
            if (c != null && this.e(c).b == 0) {
                this.e(c).b = b;
            }
            final byte b2 = (byte)((c != null) ? this.e(c).b : 0);
            if (b2 != 0 && e.d(a.e())) {
                this.a(e, e.h(a.e()), b2);
            }
            a.g();
            if (x) {
                break;
            }
        }
    }
    
    private int a(final q q, final Map map, final E e) {
        final boolean x = N.x;
        Integer value = map.get(q);
        if (value == null) {
            byte b = 0;
            final x a = e.g(q).a();
            while (a.f()) {
                final q c = this.c(a.e());
                final Object o;
                final q q2 = (q)(o = c);
                if (x) {
                    return (int)o;
                }
                if (q2 != null) {
                    b |= this.e(c).b;
                }
                a.g();
                if (x) {
                    break;
                }
            }
            value = new Integer(b);
            map.put(q, value);
        }
        Object o = value;
        return (int)o;
    }
    
    static dy a(final dA da, final q q) {
        return da.e(q);
    }
    
    static boolean[][] b(final dA da) {
        return da.j;
    }
    
    static i c(final dA da) {
        return da.a;
    }
    
    static q d(final dA da) {
        return da.k;
    }
    
    static int[] e(final dA da) {
        return da.i;
    }
    
    static int[] a(final dA da, final int[] i) {
        return da.i = i;
    }
    
    static h f(final dA da) {
        return da.c;
    }
}
