package y.f.c.a;

import y.g.*;
import java.util.*;
import y.d.*;
import y.f.*;
import y.c.*;

class dp
{
    private static final double a;
    private D b;
    private D c;
    private Map d;
    private Map e;
    private db f;
    
    void a(final db f) {
        this.f = f;
    }
    
    public void a(final X x, final aU au, final aV av, final aP ap, final h h, final ap ap2) {
        final boolean x2 = N.x;
        final c c = x.c(N.w);
        final boolean b = ((c != null) ? ((E)c.b(x)) : null).a() && this.f != null;
        x.c(U.a);
        this.d = new HashMap();
        this.e = new HashMap();
        final ArrayList<d> list = new ArrayList<d>(255);
        final HashSet<d> set = new HashSet<d>();
        this.b = new D();
        this.c = new D();
        final HashMap<Object, ds> hashMap = new HashMap<Object, ds>();
        final HashMap<Object, ds> hashMap2 = new HashMap<Object, ds>();
        final HashMap<Object, Object> hashMap3 = new HashMap<Object, Object>();
        final ArrayList list2 = new ArrayList<Object>(255);
        final ArrayList<Object> list3 = new ArrayList<Object>();
        final ArrayList<S> list4 = new ArrayList<S>();
        final ArrayList list5 = new ArrayList();
        final ArrayList<Object> list6 = new ArrayList<Object>();
        int n = 0;
        while (true) {
            do {
                Label_0210: {
                    final int n2 = au.b() - 1;
                }
                int i = 0;
                int c2 = 0;
                Label_0220:
                while (i < c2) {
                    final aQ a = au.a(n);
                    final aQ a2 = au.a(n + 1);
                    hashMap3.clear();
                    final ArrayList<d> list8;
                    final ArrayList<d> list7 = list8 = (ArrayList<d>)list2;
                    if (!x2) {
                        list7.clear();
                        p p6 = a.d().k();
                        Label_3129: {
                            d d2;
                            d d = null;
                            d g;
                            Object g2;
                            ds ds;
                            aQ aq;
                            int n3;
                            ds ds2 = null;
                            q q = null;
                            Object value;
                            ds ds3 = null;
                            ds ds5;
                            ds ds4 = null;
                            d a3;
                            ds ds6;
                            ds ds7;
                            d d3;
                            bK bk;
                            bK bk2;
                            bK bk3;
                            bK bk4;
                            Object a4;
                            p p7;
                            d d4;
                            boolean j;
                            q c3;
                            Object value2 = null;
                            d d5;
                            aX a5;
                            bK h2;
                            int k;
                            S[] array;
                            int l;
                            boolean b2;
                            d a6;
                            aX a7;
                            bK h3;
                            int m;
                            int n4 = 0;
                            bK a8;
                            d h4;
                            int j2;
                            int c4;
                            Object h5;
                            ds ds8;
                            bK bk5;
                            bK bk6;
                            bK bk7;
                            bK bk8;
                            Object a9;
                            p p8;
                            d d6;
                            int i2;
                            q d7;
                            ds ds9;
                            aX a10;
                            bK h6;
                            int j3;
                            S[] array2;
                            int n5;
                            aG f;
                            int n6;
                            int n7;
                            bK a11;
                            Object g3;
                            ds g4;
                            d a12;
                            ds ds10;
                            int j4;
                            int j5;
                            int n8;
                            ds ds11;
                            ds g5;
                            d a13;
                            d d8;
                            S[] array3;
                            int n9;
                            aX a14;
                            bK h7;
                            int j6;
                            Label_0296_Outer:Label_0562_Outer:
                            while (true) {
                            Label_2950:
                                while (true) {
                                    Label_0562:Label_1724_Outer:
                                    while (true) {
                                    Label_1724:
                                        while (true) {
                                        Label_1814:
                                            while (true) {
                                                Label_1802: {
                                                Label_1689:
                                                    while (true) {
                                                    Label_1541:
                                                        while (true) {
                                                            Label_0449: {
                                                                if (p6 == null) {
                                                                    break Label_0449;
                                                                }
                                                                d = (d2 = ((q)p6.c()).f());
                                                                if (x2) {
                                                                    break Label_1541;
                                                                }
                                                                g = d2;
                                                                while (g != null) {
                                                                    i = av.a(g.d()).j();
                                                                    c2 = a.c();
                                                                    if (x2) {
                                                                        continue Label_0220;
                                                                    }
                                                                    if (i > c2) {
                                                                        g2 = av.a(g).g();
                                                                        if (g2 != null) {
                                                                            ds = hashMap3.get(g2);
                                                                            if (ds == null) {
                                                                                ds = new ds(g2);
                                                                                hashMap3.put(g2, ds);
                                                                                list2.add((d)ds);
                                                                            }
                                                                            ds.b.add(g);
                                                                        }
                                                                    }
                                                                    g = g.g();
                                                                    if (x2) {
                                                                        break;
                                                                    }
                                                                }
                                                                p6 = p6.a();
                                                                if (!x2) {
                                                                    continue Label_0296_Outer;
                                                                }
                                                            }
                                                            Label_1490: {
                                                                if (hashMap3.size() <= 0) {
                                                                    break Label_1490;
                                                                }
                                                                ++n;
                                                                aq = au.a((byte)2, n);
                                                                n3 = list2.size() - 1;
                                                                while (true) {
                                                                    if (n3 < 0) {
                                                                        break Label_1490;
                                                                    }
                                                                    ds2 = list2.get(n3);
                                                                    this.b.add(ds2);
                                                                    q = ap.a(aq, ds2.a);
                                                                    ds2.d = q;
                                                                    this.d.put(q, ds2);
                                                                    value = hashMap.get(ds2.a);
                                                                    ds3 = (ds)value;
                                                                    ds4 = (ds5 = ds3);
                                                                    if (x2) {
                                                                        break Label_1814;
                                                                    }
                                                                    if (ds5 != null) {
                                                                        a3 = ap.a(ds3.d, q, ds3.c.isEmpty() ? null : ds3.c.iterator().next());
                                                                        ds6 = ds3;
                                                                        ds7 = ds2;
                                                                        d3 = a3;
                                                                        ds7.f = d3;
                                                                        ds6.e = d3;
                                                                        ds2.g = ds3;
                                                                        ds3.h = ds2;
                                                                        ds2.c.addAll(ds3.c);
                                                                        ds3.c.clear();
                                                                        ds3.c = null;
                                                                    }
                                                                    bk = null;
                                                                    bk2 = null;
                                                                    bk3 = null;
                                                                    bk4 = null;
                                                                    a4 = null;
                                                                    list3.clear();
                                                                    p7 = ds2.b.k();
                                                                    while (p7 != null) {
                                                                        d4 = (d)p7.c();
                                                                        j = av.a(d4).i();
                                                                        list6.clear();
                                                                        c3 = d4.c();
                                                                        d5 = (d)(value2 = a4);
                                                                        if (x2) {
                                                                            break Label_1802;
                                                                        }
                                                                        if (d5 == null || c3 != ((d)a4).c()) {
                                                                            if (list3.size() > 0 && a4 != null) {
                                                                                h.a(a4, list3.toArray((Object[])new S[list3.size()]));
                                                                                list3.clear();
                                                                            }
                                                                            a4 = ap.a(c3, q, d4, true, false);
                                                                            if (b) {
                                                                                a5 = av.a(c3);
                                                                                if (a5 != null) {
                                                                                    h2 = a5.h();
                                                                                    if (h2 != null) {
                                                                                        k = h2.j();
                                                                                        if (bk == null || bk.j() > k) {
                                                                                            bk = h2;
                                                                                        }
                                                                                        if (bk2 == null || bk2.j() < k) {
                                                                                            bk2 = h2;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        Label_1161: {
                                                                            if (h != null) {
                                                                                array = (S[])ap2.b(d4);
                                                                                if (array != null && array.length > 0) {
                                                                                    l = array.length - 1;
                                                                                    while (l >= 0) {
                                                                                        b2 = j;
                                                                                        if (x2) {
                                                                                            break Label_1161;
                                                                                        }
                                                                                        Label_1045: {
                                                                                            if ((!b2 && array[l].f().i()) || (j && array[l].f().k())) {
                                                                                                list3.add(array[l]);
                                                                                                if (!x2) {
                                                                                                    break Label_1045;
                                                                                                }
                                                                                            }
                                                                                            list6.add(array[l]);
                                                                                        }
                                                                                        --l;
                                                                                        if (x2) {
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            if (av.a(d4).h() == null) {
                                                                                a6 = ap.a(q, d4.d(), d4, false, true);
                                                                                ds2.i.put(d4, a6);
                                                                                if (list6.size() <= 0) {
                                                                                    break Label_1161;
                                                                                }
                                                                                h.a(a6, list6.toArray(new S[list6.size()]));
                                                                                if (!x2) {
                                                                                    break Label_1161;
                                                                                }
                                                                            }
                                                                            ds2.c.add(d4);
                                                                        }
                                                                        if (b) {
                                                                            a7 = av.a(d4.d());
                                                                            if (a7 != null) {
                                                                                h3 = a7.h();
                                                                                if (h3 != null) {
                                                                                    m = h3.j();
                                                                                    if (bk3 == null || bk3.j() > m) {
                                                                                        bk3 = h3;
                                                                                    }
                                                                                    if (bk4 == null || bk4.j() < m) {
                                                                                        bk4 = h3;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        if (set.add(d4)) {
                                                                            list.add(d4);
                                                                        }
                                                                        p7 = p7.a();
                                                                        if (x2) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    if (list3.size() > 0 && a4 != null) {
                                                                        h.a(a4, list3.toArray((Object[])new S[list3.size()]));
                                                                        list3.clear();
                                                                    }
                                                                    if (!ds2.c.isEmpty()) {
                                                                        hashMap.put(ds2.a, ds2);
                                                                    }
                                                                    if (b) {
                                                                        Label_1442: {
                                                                            if (bk3 != null) {
                                                                                n4 = (bk3.j() + bk4.j()) / 2;
                                                                                if (bk != null) {
                                                                                    if (n4 < bk.j()) {
                                                                                        n4 = bk.j();
                                                                                        if (!x2) {
                                                                                            break Label_1442;
                                                                                        }
                                                                                    }
                                                                                    if (n4 > bk2.j()) {
                                                                                        n4 = bk2.j();
                                                                                    }
                                                                                }
                                                                            }
                                                                            else if (bk != null) {
                                                                                n4 = bk.j();
                                                                            }
                                                                            else {
                                                                                n4 = -1;
                                                                            }
                                                                        }
                                                                        if (n4 > -1) {
                                                                            a8 = this.f.a(n4);
                                                                            if (a8 != null) {
                                                                                ((as)av.a(q)).a(a8);
                                                                            }
                                                                        }
                                                                    }
                                                                    --n3;
                                                                    if (!x2) {
                                                                        continue Label_0562_Outer;
                                                                    }
                                                                    break;
                                                                }
                                                            }
                                                            hashMap3.clear();
                                                            list2.clear();
                                                            p6 = a2.d().k();
                                                            if (p6 == null) {
                                                                break Label_1689;
                                                            }
                                                            d = (d2 = ((q)p6.c()).g());
                                                            if (x2) {
                                                                continue Label_0562_Outer;
                                                            }
                                                            break;
                                                        }
                                                        h4 = d;
                                                        while (h4 != null) {
                                                            j2 = av.a(h4.c()).j();
                                                            c4 = a2.c();
                                                            if (x2) {
                                                                continue Label_0220;
                                                            }
                                                            if (j2 < c4) {
                                                                h5 = av.a(h4).h();
                                                                if (h5 != null) {
                                                                    ds8 = hashMap3.get(h5);
                                                                    if (ds8 == null) {
                                                                        ds8 = new ds(h5);
                                                                        hashMap3.put(h5, ds8);
                                                                        list2.add(ds8);
                                                                    }
                                                                    ds8.b.add(h4);
                                                                }
                                                            }
                                                            h4 = h4.h();
                                                            if (x2) {
                                                                break;
                                                            }
                                                        }
                                                        p6 = p6.a();
                                                        if (!x2) {
                                                            continue Label_1724_Outer;
                                                        }
                                                        break;
                                                    }
                                                    if (hashMap3.size() <= 0) {
                                                        break;
                                                    }
                                                    ++n;
                                                    aq = au.a((byte)3, n);
                                                    n3 = list2.size() - 1;
                                                    if (n3 < 0) {
                                                        break;
                                                    }
                                                    ds2 = list2.get(n3);
                                                    this.c.add(ds2);
                                                    q = ap.a(aq, ds2.a);
                                                    ds2.d = q;
                                                    this.e.put(q, ds2);
                                                    value2 = hashMap2.get(ds2.a);
                                                }
                                                ds3 = (ds)value2;
                                                ds4 = (ds5 = ds3);
                                                if (x2) {
                                                    continue Label_1724_Outer;
                                                }
                                                break;
                                            }
                                            if (ds4 != null) {
                                                ds3.h = ds2;
                                                ds2.g = ds3;
                                            }
                                            hashMap2.put(ds2.a, ds2);
                                            bk5 = null;
                                            bk6 = null;
                                            bk7 = null;
                                            bk8 = null;
                                            a9 = null;
                                            list4.clear();
                                            p8 = ds2.b.k();
                                            while (p8 != null) {
                                                list6.clear();
                                                list3.clear();
                                                d6 = (d)p8.c();
                                                i2 = (av.a(d6).i() ? 1 : 0);
                                                d7 = d6.d();
                                                ds9 = (ds)(value = a9);
                                                if (x2) {
                                                    continue Label_0562;
                                                }
                                                if (ds9 == null || d7 != ((d)a9).d()) {
                                                    if (list4.size() > 0 && a9 != null) {
                                                        h.a(a9, list4.toArray(new S[list4.size()]));
                                                        list4.clear();
                                                    }
                                                    a9 = ap.a(q, d7, d6, false, true);
                                                    if (b) {
                                                        a10 = av.a(d7);
                                                        if (a10 != null) {
                                                            h6 = a10.h();
                                                            if (h6 != null) {
                                                                j3 = h6.j();
                                                                if (bk7 == null || bk7.j() > j3) {
                                                                    bk7 = h6;
                                                                }
                                                                if (bk8 == null || bk8.j() < j3) {
                                                                    bk8 = h6;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                Label_2257: {
                                                    if (h != null) {
                                                        array2 = (S[])ap2.b(d6);
                                                        if (array2 != null && array2.length > 0) {
                                                            n5 = array2.length - 1;
                                                            while (n5 >= 0) {
                                                                f = array2[n5].f();
                                                                n6 = i2;
                                                                if (x2) {
                                                                    break Label_2950;
                                                                }
                                                                Label_2249: {
                                                                    if ((n6 == 0 && f.k()) || (i2 != 0 && f.i())) {
                                                                        list4.add(array2[n5]);
                                                                        if (!x2) {
                                                                            break Label_2249;
                                                                        }
                                                                    }
                                                                    if ((i2 == 0 && f.i()) || (i2 != 0 && f.k())) {
                                                                        list3.add(array2[n5]);
                                                                        if (!x2) {
                                                                            break Label_2249;
                                                                        }
                                                                    }
                                                                    list6.add(array2[n5]);
                                                                }
                                                                --n5;
                                                                if (x2) {
                                                                    break;
                                                                }
                                                            }
                                                            break Label_2257;
                                                            if (n6 > 0 && a9 != null) {
                                                                h.a(a9, list4.toArray(new S[list4.size()]));
                                                                list4.clear();
                                                            }
                                                            if (b) {
                                                                Label_3081: {
                                                                    if (bk5 != null) {
                                                                        n7 = (bk5.j() + bk6.j()) / 2;
                                                                        if (bk7 != null) {
                                                                            if (n7 < bk7.j()) {
                                                                                n7 = bk7.j();
                                                                                if (!x2) {
                                                                                    break Label_3081;
                                                                                }
                                                                            }
                                                                            if (n7 > bk8.j()) {
                                                                                n7 = bk8.j();
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (bk7 != null) {
                                                                        n7 = bk7.j();
                                                                    }
                                                                    else {
                                                                        n7 = -1;
                                                                    }
                                                                }
                                                                if (n7 > -1) {
                                                                    a11 = this.f.a(n7);
                                                                    if (a11 != null) {
                                                                        ((as)av.a(q)).a(a11);
                                                                    }
                                                                }
                                                            }
                                                            --n3;
                                                            if (x2) {
                                                                break Label_3129;
                                                            }
                                                            continue Label_1724;
                                                        }
                                                    }
                                                }
                                                g3 = av.a(d6).g();
                                                g4 = ds2;
                                                Label_2829: {
                                                    if (g3 == null) {
                                                        a12 = ap.a(d6.c(), g4.d, d6, true, false);
                                                        g4.i.put(d6, a12);
                                                        if (list6.size() > 0) {
                                                            if (list3.size() > 0) {
                                                                list3.addAll(list6);
                                                                h.a(a12, list3.toArray(new S[list3.size()]));
                                                                if (!x2) {
                                                                    break Label_2829;
                                                                }
                                                            }
                                                            h.a(a12, list6.toArray(new S[list6.size()]));
                                                            if (!x2) {
                                                                break Label_2829;
                                                            }
                                                        }
                                                        if (list3.size() <= 0) {
                                                            break Label_2829;
                                                        }
                                                        h.a(a12, list3.toArray(new S[list3.size()]));
                                                        if (!x2) {
                                                            break Label_2829;
                                                        }
                                                    }
                                                    ds10 = hashMap.get(g3);
                                                    j4 = av.a(ds10.d).j();
                                                    while (g4.g != null) {
                                                        j5 = av.a(g4.g.d).j();
                                                        n8 = j4;
                                                        if (x2) {
                                                            continue Label_0220;
                                                        }
                                                        if (j5 <= n8) {
                                                            break;
                                                        }
                                                        if (g4.f == null) {
                                                            ds11 = g4;
                                                            g5 = g4.g;
                                                            a13 = ap.a(g4.g.d, g4.d, d6);
                                                            g5.e = a13;
                                                            ds11.f = a13;
                                                        }
                                                        g4 = g4.g;
                                                        if (x2) {
                                                            break;
                                                        }
                                                    }
                                                    d8 = ds10.d.a(g4.d);
                                                    Label_2806: {
                                                        Label_2763: {
                                                            if (d8 == null) {
                                                                d8 = ap.a(ds10.d, g4.d, d6);
                                                                if (list6.size() <= 0) {
                                                                    break Label_2763;
                                                                }
                                                                h.a(d8, list6.toArray(new S[list6.size()]));
                                                                if (!x2) {
                                                                    break Label_2763;
                                                                }
                                                            }
                                                            if (list6.size() > 0) {
                                                                array3 = (S[])h.b(d8);
                                                                if (array3 != null) {
                                                                    n9 = array3.length - 1;
                                                                    while (n9 >= 0) {
                                                                        list6.add(array3[n9]);
                                                                        --n9;
                                                                        if (x2) {
                                                                            break Label_2806;
                                                                        }
                                                                        if (x2) {
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                                h.a(d8, list6.toArray(new S[list6.size()]));
                                                            }
                                                        }
                                                        ds10.i.put(d6, d8);
                                                        g4.i.put(d6, d8);
                                                        ds10.c.remove(d6);
                                                    }
                                                    if (ds10.c.isEmpty()) {
                                                        hashMap.remove(g3);
                                                    }
                                                }
                                                if (b) {
                                                    a14 = av.a(d6.c());
                                                    if (a14 != null) {
                                                        h7 = a14.h();
                                                        if (h7 != null) {
                                                            j6 = h7.j();
                                                            if (bk5 == null || bk5.j() > j6) {
                                                                bk5 = h7;
                                                            }
                                                            if (bk6 == null || bk6.j() < j6) {
                                                                bk6 = h7;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (set.add(d6)) {
                                                    list.add(d6);
                                                }
                                                p8 = p8.a();
                                                if (x2) {
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                    }
                                    list4.size();
                                    continue Label_2950;
                                }
                            }
                        }
                        ++n;
                        continue Label_0210;
                    }
                    int n10 = list8.size() - 1;
                    while (n10 >= 0) {
                        x.d(list.get(n10));
                        --n10;
                        if (x2) {
                            break;
                        }
                    }
                    return;
                }
                break;
            } while (!x2);
            ArrayList<d> list8 = list;
            continue;
        }
    }
    
    private static boolean a(final aV av, final d d) {
        return av != null && av.a(d) != null && av.a(d).k() != null && av.a(d).k().h().b() == 1;
    }
    
    private static double b(final aV av, final d d) {
        if (av == null || av.a(d) == null || av.a(d).k() == null) {
            return 0.0;
        }
        return av.a(d).k().i();
    }
    
    public void a(final X x, final aU au, final aV av, final HashSet set) {
        final boolean x2 = N.x;
        final ArrayList<Object> list = new ArrayList<Object>(50);
        p p4 = this.b.k();
        while (true) {
            ds ds;
            p k;
            p p5;
            d d = null;
            boolean f = false;
            I i = null;
            d d2;
            I b;
            q c;
            q c2;
            t p6;
            int j;
            t q;
            t p7;
            int l;
            t t;
            boolean contains;
            d d3;
            I b2;
            q d4;
            q d5;
            t q2;
            int n;
            t p8;
            t t2;
            int n2;
            t t3;
            boolean contains2;
            p m = null;
            Object c3 = null;
            q d6;
            q q3 = null;
            boolean f2 = false;
            Label_0566_Outer:Label_1197_Outer:
            while (p4 != null) {
                ds = (ds)p4.c();
                k = ds.b.k();
                while (true) {
                    Label_1221: {
                        Label_1207: {
                            Label_1136: {
                            Label_0669_Outer:
                                while (true) {
                                    if (x2) {
                                        p4 = k;
                                        break Label_0566;
                                    }
                                    p5 = k;
                                Label_0669:
                                    while (true) {
                                        Label_0622: {
                                            while (p5 != null) {
                                                d = (d)p5.c();
                                                f = x.f(d);
                                                if (x2) {
                                                    break Label_0622;
                                                }
                                                Label_0118: {
                                                    if (!f) {
                                                        x.e(d);
                                                        i = x.b((Object)d);
                                                        i.clearPoints();
                                                        if (!x2) {
                                                            break Label_0118;
                                                        }
                                                    }
                                                    i = x.b((Object)d);
                                                }
                                                d2 = ds.d.b(d.c());
                                                list.clear();
                                            Label_0363_Outer:
                                                while (d2 != null) {
                                                    b = x.b((Object)d2);
                                                    c = d2.c();
                                                    c2 = d.c();
                                                    if (x2) {
                                                        break Label_0669;
                                                    }
                                                    Label_0238: {
                                                        if (c == c2) {
                                                            i.setSourcePoint(b.getSourcePoint());
                                                            if (!x2) {
                                                                break Label_0238;
                                                            }
                                                        }
                                                        p6 = x.p(d2);
                                                        list.add(p6);
                                                        if (ds.b.size() > 1) {
                                                            set.add(new dr(d, p6, null));
                                                        }
                                                    }
                                                    j = 0;
                                                    while (true) {
                                                        while (true) {
                                                            while (j < b.pointCount()) {
                                                                list.add(b.getPoint(j));
                                                                ++j;
                                                                if (!x2) {
                                                                    if (x2) {
                                                                        break;
                                                                    }
                                                                    continue Label_0566_Outer;
                                                                }
                                                                else {
                                                                    q = x.q(d2);
                                                                    list.add(q);
                                                                    if (ds.b.size() > 1) {
                                                                        set.add(new dr(d, q, null));
                                                                    }
                                                                    d2 = this.a(d2.d(), d);
                                                                    if (x2) {
                                                                        break Label_0363_Outer;
                                                                    }
                                                                    continue Label_0363_Outer;
                                                                }
                                                            }
                                                            if (d2.d() != d.d()) {
                                                                continue Label_0363_Outer;
                                                            }
                                                            i.setTargetPoint(b.getTargetPoint());
                                                            if (x2) {
                                                                continue Label_0363_Outer;
                                                            }
                                                            break;
                                                        }
                                                        continue Label_1197_Outer;
                                                    }
                                                }
                                                p7 = x.p(d);
                                                l = 0;
                                                while (l < list.size()) {
                                                    t = list.get(l);
                                                    contains = set.contains(new dr(d, t, null));
                                                    if (x2) {
                                                        break Label_0622;
                                                    }
                                                    if (contains && t.b < p7.b) {
                                                        t = new t(t.a, p7.b);
                                                        set.add(new dr(d, t, null));
                                                    }
                                                    if (!p7.equals(t)) {
                                                        i.addPoint(t.a, t.b);
                                                    }
                                                    p7 = t;
                                                    ++l;
                                                    if (x2) {
                                                        break;
                                                    }
                                                }
                                                p5 = p5.a();
                                                if (x2) {
                                                    break;
                                                }
                                            }
                                            p4 = p4.a();
                                            if (x2) {
                                                break;
                                            }
                                            continue Label_0566_Outer;
                                        Label_0923:
                                            while (true) {
                                                d3 = c.a(c2);
                                                list.clear();
                                            Label_0905_Outer:
                                                while (d3 != null) {
                                                    b2 = x.b((Object)d3);
                                                    d4 = d3.d();
                                                    d5 = d.d();
                                                    if (x2) {
                                                        continue Label_0669;
                                                    }
                                                    Label_0779: {
                                                        if (d4 == d5) {
                                                            i.setTargetPoint(b2.getTargetPoint());
                                                            if (!x2) {
                                                                break Label_0779;
                                                            }
                                                        }
                                                        q2 = x.q(d3);
                                                        list.add(q2);
                                                        if (ds.b.size() > 1) {
                                                            set.add(new dr(d, q2, null));
                                                        }
                                                    }
                                                    n = b2.pointCount() - 1;
                                                    while (true) {
                                                        while (true) {
                                                            while (n >= 0) {
                                                                list.add(b2.getPoint(n));
                                                                --n;
                                                                if (!x2) {
                                                                    if (x2) {
                                                                        break;
                                                                    }
                                                                    continue Label_0566_Outer;
                                                                }
                                                                else {
                                                                    p8 = x.p(d3);
                                                                    list.add(p8);
                                                                    if (ds.b.size() > 1) {
                                                                        set.add(new dr(d, p8, null));
                                                                    }
                                                                    d3 = this.b(d3.c(), d);
                                                                    if (x2) {
                                                                        break Label_0923;
                                                                    }
                                                                    continue Label_0905_Outer;
                                                                }
                                                            }
                                                            if (d3.c() != d.c()) {
                                                                continue Label_0905_Outer;
                                                            }
                                                            i.setSourcePoint(b2.getSourcePoint());
                                                            if (x2) {
                                                                continue Label_0905_Outer;
                                                            }
                                                            break;
                                                        }
                                                        continue Label_1197_Outer;
                                                    }
                                                }
                                                break;
                                            }
                                            t2 = ((i.pointCount() > 0) ? i.getPoint(i.pointCount() - 1) : x.p(d));
                                            n2 = list.size() - 1;
                                            while (n2 >= 0) {
                                                t3 = list.get(n2);
                                                contains2 = set.contains(new dr(d, t3, null));
                                                if (x2) {
                                                    break Label_0622;
                                                }
                                                if (contains2 && t3.b < t2.b) {
                                                    t3 = new t(t3.a, t2.b);
                                                    set.add(new dr(d, t3, null));
                                                }
                                                if (!t2.equals(t3)) {
                                                    i.addPoint(t3.a, t3.b);
                                                }
                                                t2 = t3;
                                                --n2;
                                                if (x2) {
                                                    break;
                                                }
                                            }
                                            p5 = p5.a();
                                            if (x2) {
                                                break Label_0669;
                                            }
                                            Label_0596: {
                                                break Label_0596;
                                                if (p4 == null) {
                                                    break Label_0669_Outer;
                                                }
                                                ds = (ds)p4.c();
                                                m = ds.b.k();
                                                if (x2) {
                                                    break Label_1136;
                                                }
                                                p5 = m;
                                            }
                                            if (p5 == null) {
                                                break Label_0669;
                                            }
                                            d = (d)p5.c();
                                            c3 = x;
                                            if (x2) {
                                                break Label_1207;
                                            }
                                            x.f(d);
                                        }
                                        Label_0659: {
                                            if (!f) {
                                                x.e(d);
                                                i = x.b((Object)d);
                                                i.clearPoints();
                                                if (!x2) {
                                                    break Label_0659;
                                                }
                                            }
                                            i = x.b((Object)d);
                                        }
                                        d6 = ds.d;
                                        d.d();
                                        continue Label_0669;
                                    }
                                    p4 = p4.a();
                                    if (!x2) {
                                        continue Label_0669_Outer;
                                    }
                                    break;
                                }
                                this.b.k();
                            }
                            p4 = m;
                            while (p4 != null) {
                                q3 = ((ds)p4.c()).d;
                                f2 = x.f(q3);
                                if (x2) {
                                    break Label_1221;
                                }
                                if (f2) {
                                    x.a(q3);
                                }
                                p4 = p4.a();
                                if (x2) {
                                    break;
                                }
                            }
                            p4 = this.c.k();
                            if (p4 == null) {
                                return;
                            }
                            c3 = p4.c();
                        }
                        q3 = ((ds)c3).d;
                        x.f(q3);
                    }
                    if (f2) {
                        x.a(q3);
                    }
                    p4 = p4.a();
                    if (!x2) {
                        continue;
                    }
                    break;
                }
                return;
            }
            this.c.k();
            continue;
        }
    }
    
    private static boolean a(final t t, final t t2) {
        return Math.abs(t.a - t2.a) < 0.001 && t.b < t2.b;
    }
    
    private static boolean b(final t t, final t t2) {
        return Math.abs(t.b - t2.b) < 0.001;
    }
    
    public void a(final X x, final aV av, final HashSet set) {
        final boolean x2 = N.x;
        final e p3 = x.p();
        while (p3.f()) {
            final d a = p3.a();
            final A a2 = av.a(a);
            if (!a.e() && !a(a, av) && (a2.g() != null || a2.h() != null) && a(av, a)) {
                a(a, x, av, set);
            }
            p3.g();
            if (x2) {
                break;
            }
        }
    }
    
    private static boolean a(final d d, final aV av) {
        return av.a(d.c()).j() == av.a(d.d()).j();
    }
    
    private static void a(final D d, final t t) {
        if (d.isEmpty() || !d.i().equals(t)) {
            d.add(t);
        }
    }
    
    private static void a(final D d, final double n, final double n2) {
        final t t = (t)d.i();
        if (t == null || t.a != n || t.b != n2) {
            d.add(new t(n, n2));
        }
    }
    
    private static boolean b(final d d, final aV av) {
        return av != null && av.a(d) != null && av.a(d).k() != null && av.a(d).k().h().c() == 1;
    }
    
    private static void a(final d d, final X x, final aV av, final HashSet set) {
        final boolean x2 = N.x;
        final D m = x.m(d);
        if (m.size() < 4) {
            return;
        }
        final t[] array = (t[])m.toArray(new t[m.size()]);
        final boolean b = b(d, av);
        final double n = b(av, d) / dp.a;
        final D d2 = new D();
        t t = array[0];
        t t2 = array[1];
        int n2 = 2;
        while (n2 + 1 < array.length) {
            final t t3 = array[n2];
            final t t4 = array[n2 + 1];
            if (x2) {
                return;
            }
            Label_0451: {
                if ((b || set.contains(new dr(d, t2, null)) || set.contains(new dr(d, t3, null))) && a(t, t2) && b(t2, t3) && a(t3, t4)) {
                    final double abs = Math.abs(t2.a - t3.a);
                    if (abs > 2.0 * n) {
                        a(d2, t);
                        a(d2, t2.a, t2.b - n);
                        Label_0332: {
                            if (t2.a < t3.a) {
                                a(d2, t2.a + n, t2.b);
                                a(d2, t3.a - n, t3.b);
                                if (!x2) {
                                    break Label_0332;
                                }
                            }
                            a(d2, t2.a - n, t2.b);
                            a(d2, t3.a + n, t3.b);
                        }
                        t = new t(t3.a, t3.b + n);
                        a(d2, t);
                        if (!x2) {
                            break Label_0451;
                        }
                    }
                    final double n3 = abs / 2.0;
                    a(d2, t);
                    a(d2, t2.a, t2.b - n3);
                    t = new t(t3.a, t3.b + n3);
                    a(d2, t);
                    if (!x2) {
                        break Label_0451;
                    }
                }
                a(d2, t);
                a(d2, t2);
                t = t3;
            }
            t2 = t4;
            if (n2 + 3 >= array.length) {
                a(d2, t);
                a(d2, t2);
                if (n2 + 2 < array.length) {
                    a(d2, array[n2 + 2]);
                }
            }
            n2 += 2;
            if (x2) {
                break;
            }
        }
        x.a(d, a(d2));
    }
    
    private static D a(final D d) {
        final boolean x = N.x;
        if (d.size() < 3) {
            return d;
        }
        final D d2 = new D();
        final C m = d.m();
        final t t = (t)m.d();
        d2.add(t);
        m.g();
        double a = t.a();
        double b = t.b();
        if (m.f()) {
            t t2 = (t)m.d();
            double a2 = t2.a();
            double b2 = t2.b();
            m.g();
            while (m.f()) {
                final t t3 = (t)m.d();
                final double a3 = t3.a();
                final double b3 = t3.b();
                final double n = dcmpl(Math.abs((a - a3) * (b2 - b3) / (b - b3) + a3 - a2), 0.5);
                if (x) {
                    return d2;
                }
                if (n > 0) {
                    d2.add(t2);
                    a = a2;
                    b = b2;
                }
                t2 = t3;
                a2 = a3;
                b2 = b3;
                m.g();
                if (x) {
                    break;
                }
            }
            d2.add(t2);
            return d2;
        }
        return d2;
    }
    
    private d a(final q q, final d d) {
        if (q == d.d()) {
            return null;
        }
        final ds ds = this.d.get(q);
        if (ds == null) {
            return null;
        }
        d e = ds.i.get(d);
        if (e == null) {
            e = ds.e;
        }
        return e;
    }
    
    private d b(final q q, final d d) {
        if (q == d.c()) {
            return null;
        }
        final ds ds = this.e.get(q);
        if (ds == null) {
            return null;
        }
        d f = ds.i.get(d);
        if (f == null) {
            f = ds.f;
        }
        if (f != null && this.d.containsKey(f.c())) {
            return null;
        }
        return f;
    }
    
    public void a(final X x) {
        this.d = null;
        this.e = null;
        this.b = null;
        this.c = null;
    }
    
    static {
        a = Math.sqrt(2.0);
    }
}
