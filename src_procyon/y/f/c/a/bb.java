package y.f.c.a;

import y.a.*;
import y.d.*;
import y.f.*;
import y.c.*;
import java.util.*;
import y.g.*;

public class bb extends a
{
    private static final aE a;
    private static final aE b;
    private static final aE c;
    private static final aE d;
    private static final aE e;
    private static final aE f;
    private static final aE g;
    private static final aE h;
    private double i;
    private double j;
    private double k;
    private A l;
    private boolean m;
    
    public bb() {
        this.i = 10.0;
        this.j = 1.0;
        this.k = 100.0;
        this.m = true;
    }
    
    public double c() {
        return this.j;
    }
    
    private static boolean a(final d d, final aV av) {
        return av.a(d).i();
    }
    
    private static boolean b(final d d, final aV av) {
        return av.a(d.c()).j() == av.a(d.d()).j();
    }
    
    private boolean a(final ax ax) {
        final byte b = this.b();
        return ((b == 2 || b == 0) && (ax.a(1) || ax.a(2))) || ((b == 1 || b == 3) && (ax.a(8) || ax.a(4)));
    }
    
    private boolean a(final boolean b, final ax ax) {
        return !ax.a(this.a(!b));
    }
    
    private static int a(final byte b, final boolean b2) {
        if (!b2) {
            switch (b) {
                default: {
                    return 1;
                }
                case 2: {
                    return 2;
                }
                case 1: {
                    return 8;
                }
                case 3: {
                    return 4;
                }
            }
        }
        else {
            switch (b) {
                default: {
                    return 2;
                }
                case 2: {
                    return 1;
                }
                case 1: {
                    return 4;
                }
                case 3: {
                    return 8;
                }
            }
        }
    }
    
    private boolean b(final boolean b, final ax ax) {
        return ax.a(a(this.b(), b));
    }
    
    private static boolean a(final q q, final c c) {
        final boolean x = N.x;
        ax ax = null;
        final e l = q.l();
        while (l.f()) {
            final ax ax2 = (ax)c.b(l.a().d());
            if (ax2 != null) {
                if (ax != null && ax.a() != ax2.a()) {
                    return false;
                }
                ax = ax2;
            }
            l.g();
            if (x) {
                break;
            }
        }
        return true;
    }
    
    private boolean a(final q q, final c c, final int n) {
        final boolean x = N.x;
        final HashSet set = new HashSet<ax>(8);
        final e l = q.l();
        while (l.f()) {
            final ax ax = (ax)c.b(l.a().d());
            if (ax != null) {
                if ((n & ax.b(this.b())) != 0x0) {
                    set.add(ax);
                }
                if (set.size() > 1) {
                    return true;
                }
            }
            l.g();
            if (x) {
                break;
            }
        }
        return false;
    }
    
    private static boolean b(final ax ax) {
        final int a = ax.a();
        return a == 4 || a == 8 || a == 1 || a == 2;
    }
    
    private double a(final ax ax, final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        final double n = ax.b() ? 0.5 : 0.0;
        if (b3) {
            if (this.b(!b4, ax)) {
                return n + 2.0;
            }
            if (this.b(b4, ax)) {
                return n + 4.0;
            }
            return n;
        }
        else {
            if (this.a(b, ax)) {
                return n + (b2 ? 3 : 5) + 6.0 * this.c();
            }
            if (this.b(b, ax)) {
                return n;
            }
            return n + 1.0;
        }
    }
    
    private void a(final q q, final X x, final aV av, final aP ap) {
        final boolean x2 = N.x;
        final i i = new i();
        final q d = i.d();
        final q d2 = i.d();
        final h b = M.b();
        final h b2 = M.b();
        final A a = M.a();
        final c c = x.c(ay.a);
        final y y = new y();
        h h = null;
        Label_0221: {
            if (c != null && c.b(q) != null) {
                final Iterator a2 = ((ay)c.b(q)).a();
                while (a2.hasNext()) {
                    final aA aa = a2.next();
                    final q d3 = i.d();
                    a.a(d3, aa.a());
                    y.add(d3);
                    final d a3 = i.a(d3, d2);
                    b.a(a3, aa.b());
                    h = b2;
                    if (x2) {
                        break Label_0221;
                    }
                    h.a(a3, Math.min(1000.0, 6.0 * (1.0 + aa.a().f())));
                    if (x2) {
                        break;
                    }
                }
            }
            M.b();
        }
        final h h2 = h;
        final e j = q.j();
        do {
            Label_0229: {
                j.f();
            }
            boolean b3 = false;
            Label_0236:
            while (b3) {
                final d a4 = j.a();
                final y.f.c.a.A a5 = av.a(a4);
                final boolean a6 = a(a4, av);
                a4.c();
                Label_0271:
                Label_0824: {
                    boolean equals;
                    boolean b4;
                    boolean l;
                    boolean b5;
                    q d4;
                    HashMap<Object, Object> hashMap;
                    while (true) {
                        q q2 = null;
                        equals = q2.equals(q);
                        b4 = b(a4, av);
                        l = av.a(a4).l();
                        final Collection collection = equals ? a5.d() : a5.f();
                        b5 = (collection != null && !collection.isEmpty());
                        if (y.isEmpty() && !b5) {
                            break Label_0824;
                        }
                        d4 = i.d();
                        h2.a(a4, d4);
                        final d a7 = i.a(d, d4);
                        b.a(a7, 1);
                        b2.a(a7, 0.0);
                        final d a8 = i.a(d4, d2);
                        b.a(a8, 1);
                        b2.a(a8, 100000.0);
                        hashMap = new HashMap<Object, Object>();
                        if (b5) {
                            for (final ax ax : collection) {
                                q d5 = q2 = hashMap.get(bg.a(ax));
                                if (x2) {
                                    continue Label_0271;
                                }
                                if (q2 == null) {
                                    d5 = i.d();
                                    hashMap.put(bg.a(ax), d5);
                                    a.a(d5, ax);
                                    final d a9 = i.a(d5, d2);
                                    b.a(a9, Integer.MAX_VALUE);
                                    b2.a(a9, Math.min(1000.0, 6.0 * (1.0 + ax.f())));
                                }
                                final d a10 = i.a(d4, d5);
                                b.a(a10, 1);
                                b2.a(a10, Math.min(1000.0, this.a(ax, equals, a6, b4, l)));
                                if (x2) {
                                    break;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    if (!y.isEmpty()) {
                        final x a11 = y.a();
                        while (a11.f()) {
                            final q e = a11.e();
                            final ax ax2 = (ax)a.b(e);
                            final q q3 = hashMap.get(bg.a(ax2));
                            b3 = b5;
                            if (x2) {
                                continue Label_0236;
                            }
                            if (!b3 || q3 != null) {
                                final d a12 = i.a(d4, e);
                                b.a(a12, 1);
                                b2.a(a12, Math.min(1000.0, this.a(ax2, equals, a6, b4, l)));
                                if (q3 != null && i.f(q3)) {
                                    i.a(q3);
                                }
                            }
                            a11.g();
                            if (x2) {
                                break;
                            }
                        }
                    }
                }
                j.g();
                continue Label_0229;
            }
            break;
        } while (!x2);
        final h b6 = M.b();
        y.a.l.a(i, d, d2, b, b2, b6, null);
        final byte b7 = this.b();
        final int a13 = this.a();
        boolean b8 = true;
        final ArrayList<ax> list = new ArrayList<ax>();
        final e k = q.j();
        while (true) {
            do {
                Label_0888: {
                    k.f();
                }
                int a14 = 0;
                Label_0895:
                while (a14 != 0) {
                    final d a15 = k.a();
                    final q q4 = (q)h2.b(a15);
                    if (!x2) {
                        if (q4 != null) {
                            final boolean equals2 = a15.c().equals(q);
                            final e m = q4.l();
                            while (m.f()) {
                                a14 = b6.a(m.a());
                                if (x2) {
                                    continue Label_0895;
                                }
                                if (a14 > 0) {
                                    if (b2.c(m.a()) < 100000.0) {
                                        final ax ax3 = (ax)a.b(m.a().d());
                                        list.add(ax3);
                                        if (!this.a(equals2, ax3) && (!b(ax3) || !a(q4, a)) && (!b(a15, av) || !this.a(ax3))) {
                                            break;
                                        }
                                        final boolean b9 = ax3.b() && !this.a(q4, a, ax3.b(b7));
                                        Label_1191: {
                                            if (b9) {
                                                final double a16 = ax3.a(b7, a13);
                                                final double b10 = ax3.b(b7, a13);
                                                if (equals2) {
                                                    x.a(a15, new t(a16, b10));
                                                    if (!x2) {
                                                        break Label_1191;
                                                    }
                                                }
                                                x.b(a15, new t(a16, b10));
                                            }
                                        }
                                        ap.a(a15, equals2, this.a(ax3, equals2, b9));
                                        if (!x2) {
                                            break;
                                        }
                                    }
                                    b8 = false;
                                    if (!x2) {
                                        break;
                                    }
                                }
                                m.g();
                                if (x2) {
                                    break;
                                }
                            }
                        }
                        k.g();
                        continue Label_0888;
                    }
                    this.l.a(q, list);
                    return;
                }
                break;
            } while (!x2);
            if (b8) {
                continue;
            }
            this.l.a(q, null);
            if (x2) {
                continue;
            }
            break;
        }
    }
    
    public void optimizeAfterLayering(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        this.l = M.a();
        final x o = x.o();
        while (o.f()) {
            this.a(o.e(), x, av, ap);
            o.g();
            if (x2) {
                break;
            }
        }
    }
    
    private static boolean b(final aE ae) {
        return ae != null && (ae == bb.f || ae == bb.b || ae == bb.e || ae == bb.a || ae == bb.g || ae == bb.c || ae == bb.h || ae == bb.d);
    }
    
    protected c a(final X x) {
        return x.c(ay.a);
    }
    
    private static az a(final c c, final q q) {
        if (c == null) {
            return null;
        }
        final ay ay = (ay)c.b(q);
        return (ay == null) ? null : ay.b();
    }
    
    protected void a(final q q, final Comparator comparator, final Comparator comparator2, final X x, final aV av, final aP ap) {
        final boolean x2 = N.x;
        if (q.a() == 0) {
            return;
        }
        int n = 0;
        int n2 = 0;
        final e j = q.j();
        while (j.f()) {
            final d a = j.a();
            final Collection collection = a.d().equals(q) ? av.a(a).f() : av.a(a).d();
            if (collection != null) {
                final int size = collection.size();
                n += size;
                if (size > 1) {
                    n2 += size - 1;
                }
            }
            j.g();
            if (x2) {
                break;
            }
        }
        final d[] e = new f(q.k()).e();
        y.g.e.a(e, comparator);
        final f f = new f(q.l());
        f.sort(comparator2);
        f.n();
        final d[] e2 = f.e();
        if (n == 0 && this.l != null && this.l.b(q) != null) {
            final Collection collection2 = (Collection)this.l.b(q);
            if (collection2.size() != q.a()) {
                return;
            }
            final ArrayList[] array = new ArrayList[4];
            int i = 0;
            while (i < 4) {
                array[i] = new ArrayList();
                ++i;
                if (x2) {
                    break;
                }
            }
            final D d = new D();
            while (true) {
                for (final ax ax : collection2) {
                    final int n4;
                    final int n3 = n4 = (b(ax) ? 1 : 0);
                    if (x2) {
                        int n5 = n4;
                        int size2 = array[1].size();
                        int k = e.length - array[0].size();
                        while (true) {
                            while (k > 0) {
                                final boolean empty = d.isEmpty();
                                if (x2) {
                                    if (!empty) {
                                        array[2].addAll(d);
                                    }
                                    int l = 0;
                                    while (true) {
                                        while (l < array.length) {
                                            Collections.sort((List<Object>)array[l], new bd(this, l));
                                            ++l;
                                            if (x2) {
                                                int n6 = n5;
                                                while (true) {
                                                    while (n6 < array[3].size()) {
                                                        this.a(x, e[l++], (ax)array[3].get(n6), false, ap);
                                                        ++n6;
                                                        if (x2) {
                                                            while (l < e.length) {
                                                                this.a(x, e[l++], (ax)array[1].get(n6++), false, ap);
                                                                if (x2) {
                                                                    break;
                                                                }
                                                            }
                                                            int n7 = 0;
                                                            int n8 = n6;
                                                            while (n8 < array[1].size()) {
                                                                this.a(x, e2[n7++], (ax)array[1].get(n8), true, ap);
                                                                ++n8;
                                                                if (x2) {
                                                                    break;
                                                                }
                                                            }
                                                            Iterator iterator2 = array[2].iterator();
                                                            while (true) {
                                                                while (iterator2.hasNext()) {
                                                                    this.a(x, e2[n7++], iterator2.next(), true, ap);
                                                                    if (x2) {
                                                                        while (iterator2.hasNext() && n7 < e2.length) {
                                                                            this.a(x, e2[n7++], iterator2.next(), true, ap);
                                                                            if (x2) {
                                                                                break;
                                                                            }
                                                                        }
                                                                        return;
                                                                    }
                                                                    if (x2) {
                                                                        break;
                                                                    }
                                                                }
                                                                iterator2 = array[3].iterator();
                                                                continue;
                                                            }
                                                        }
                                                        if (x2) {
                                                            break;
                                                        }
                                                    }
                                                    final Iterator iterator3 = array[0].iterator();
                                                    while (iterator3.hasNext()) {
                                                        this.a(x, e[l++], iterator3.next(), false, ap);
                                                        if (x2) {
                                                            break;
                                                        }
                                                    }
                                                    n6 = 0;
                                                    continue;
                                                }
                                            }
                                            if (x2) {
                                                break;
                                            }
                                        }
                                        l = 0;
                                        continue;
                                    }
                                }
                                Label_0462: {
                                    if (!empty) {
                                        array[0].add(d.g());
                                        if (!x2) {
                                            break Label_0462;
                                        }
                                    }
                                    if (n5 > size2) {
                                        --n5;
                                        if (!x2) {
                                            break Label_0462;
                                        }
                                    }
                                    --size2;
                                }
                                --k;
                                if (x2) {
                                    break;
                                }
                            }
                            d.isEmpty();
                            continue;
                        }
                    }
                    if (n3 != 0) {
                        array[this.a(1, 2, 1, 4, 8, 2, ax)].add(ax);
                        if (!x2) {
                            continue;
                        }
                    }
                    d.add(ax);
                    if (x2) {
                        break;
                    }
                }
                int n4 = array[3].size();
                continue;
            }
        }
        else {
            if (n2 > 0 || n != q.a()) {
                this.a(q, e, e2, x, av, ap);
                return;
            }
            if (n > 0) {
                int n9 = 0;
                while (true) {
                    while (n9 < e.length) {
                        d d2 = e[n9];
                        ArrayList list = (ArrayList)av.a(d2).f();
                        ArrayList list3;
                        final ArrayList<ax> list2 = (ArrayList<ax>)(list3 = list);
                        if (!x2) {
                            if (list2 != null && list.size() > 0) {
                                this.a(x, d2, list.get(0), false, ap);
                            }
                            ++n9;
                            if (x2) {
                                break;
                            }
                            continue;
                        }
                        else {
                            while (true) {
                                if (list3 != null && list.size() > 0) {
                                    this.a(x, d2, list.get(0), true, ap);
                                }
                                ++n9;
                                if (x2) {
                                    return;
                                }
                                if (n9 < e2.length) {
                                    d2 = e2[n9];
                                    list = (list3 = (ArrayList)av.a(d2).d());
                                    continue;
                                }
                                break;
                            }
                            return;
                        }
                    }
                    n9 = 0;
                    continue;
                }
            }
        }
    }
    
    private void a(final q q, final d[] array, final d[] array2, final X x, final aV av, final aP ap) {
        final boolean x2 = N.x;
        final i i = new i();
        final d[] array3 = new d[array.length + array2.length];
        System.arraycopy(array, 0, array3, 0, array.length);
        System.arraycopy(array2, 0, array3, array.length, array2.length);
        final int a = this.a(true);
        final int a2 = this.a(false);
        final h u = i.u();
        final d[] array4 = new d[array3.length];
        final A t = i.t();
        final HashMap<bg, ax> hashMap = new HashMap<bg, ax>();
        final ArrayList<Object> list = new ArrayList<Object>();
        final ArrayList<q> list2 = new ArrayList<q>();
        final c a3 = this.a(x);
        c c = null;
        q q2 = null;
        Label_0259: {
            if (a3 != null) {
                final ay ay = (ay)a3.b(q);
                if (ay != null) {
                    final Iterator a4 = ay.a();
                    while (a4.hasNext()) {
                        final aA aa = a4.next();
                        if (hashMap.get(bg.a(aa.a())) == null) {
                            final q d = i.d();
                            hashMap.put(bg.a(aa.a()), (ax)d);
                            final A a5 = (A)(c = t);
                            q2 = d;
                            if (x2) {
                                break Label_0259;
                            }
                            a5.a(q2, aa);
                            list2.add(d);
                            list.add(aa);
                            if (x2) {
                                break;
                            }
                            continue;
                        }
                    }
                }
            }
            c = a3;
        }
        final az a6 = a(c, q2);
        int n2 = 0;
        Label_0594: {
            if (a6 != null) {
                final f f = new f(array3);
                f.sort(new bf(q, av, null));
                final e a7 = f.a();
                while (a7.f()) {
                    final d a8 = a7.a();
                    final boolean equals = a8.d().equals(q);
                    final y.f.c.a.A a9 = av.a(a8);
                    final int n = n2 = (equals ? 1 : 0);
                    if (x2) {
                        break Label_0594;
                    }
                    final Collection collection = (n != 0) ? a9.f() : a9.d();
                    if (collection != null && !collection.isEmpty()) {
                        int n3 = 0;
                        Label_0480: {
                            if (equals && b(a9.e())) {
                                n3 = this.b(a9.e().b());
                                if (!x2) {
                                    break Label_0480;
                                }
                            }
                            if (!equals && b(a9.c())) {
                                n3 = this.b(a9.c().b());
                                if (!x2) {
                                    break Label_0480;
                                }
                            }
                            n3 = (equals ? a : a2);
                        }
                        final aA a10 = a6.a(a8, !equals, n3);
                        if (hashMap.get(bg.a(a10.a())) == null) {
                            final q d2 = i.d();
                            hashMap.put(bg.a(a10.a()), (ax)d2);
                            t.a(d2, a10);
                            list2.add(d2);
                            list.add(a10);
                        }
                    }
                    a7.g();
                    if (x2) {
                        break;
                    }
                }
            }
            n2 = 0;
        }
        int j = n2;
        while (true) {
        Label_1730_Outer:
            while (j < array3.length) {
                final d d3 = array3[j];
                final int equals2 = d3.d().equals(q) ? 1 : 0;
                final y.f.c.a.A a11 = av.a(d3);
                final int n4 = equals2;
                if (x2) {
                    final q[] array5 = new q[n4];
                    list2.toArray(array5);
                    final q[] array6 = new q[array3.length];
                    final int[] array7 = new int[i.e()];
                    double n5 = 0.0;
                    final d[][] array8 = new d[array3.length][];
                    int k = 0;
                Label_1063:
                    while (true) {
                        d d4;
                        int equals3;
                        y.f.c.a.A a12;
                        int n6;
                        int n7 = 0;
                        q d5;
                        double n8;
                        Collection collection2;
                        int n9;
                        q q3;
                        d a13;
                        double f2;
                        double n10 = 0.0;
                        q c2;
                        int[] array9;
                        int d6;
                        int[] array10;
                        int d7;
                        int l;
                        ax a14;
                        int a15;
                        boolean b;
                        q q4;
                        d a16;
                        double f3;
                        q c3;
                        int[] array11;
                        int d8;
                        int[] array12;
                        int d9;
                        q c4;
                        d d10;
                        d d11;
                        int n11;
                        A a17;
                        A a18;
                        A a19;
                        int n12;
                        q q5;
                        Object b2;
                        int n13;
                        h b3;
                        e p6;
                        d a20;
                        aA aa2;
                        Label_1593_Outer:Label_1720_Outer:
                        while (k < array3.length) {
                            d4 = array3[k];
                            equals3 = (d4.d().equals(q) ? 1 : 0);
                            a12 = av.a(d4);
                            n6 = equals3;
                            if (!x2) {
                                Label_1197: {
                                    if (n6 != 0 && b(a12.e())) {
                                        n7 = this.b(a12.e().b());
                                        if (!x2) {
                                            break Label_1197;
                                        }
                                    }
                                    if (equals3 == 0 && b(a12.c())) {
                                        n7 = this.b(a12.c().b());
                                        if (!x2) {
                                            break Label_1197;
                                        }
                                    }
                                    n7 = ((equals3 != 0) ? a : a2);
                                }
                                d5 = i.d();
                                array6[k] = d5;
                                n8 = Double.MAX_VALUE;
                                collection2 = ((equals3 != 0) ? a12.f() : a12.d());
                                n9 = 0;
                                if (collection2 != null && collection2.size() > 0) {
                                    for (final ax ax : collection2) {
                                        if (ax.a(n7)) {
                                            n9 = 1;
                                            q3 = hashMap.get(bg.a(ax));
                                            a13 = i.a(q3, d5);
                                            f2 = ax.f();
                                            u.a(a13, f2);
                                            n10 = dcmpg(f2, n8);
                                            if (x2) {
                                                break;
                                            }
                                            if (n10 >= 0) {
                                                continue Label_1720_Outer;
                                            }
                                            if (array4[k] != null) {
                                                c2 = array4[k].c();
                                                array9 = array7;
                                                d6 = c2.d();
                                                --array9[d6];
                                            }
                                            array4[k] = a13;
                                            n8 = f2;
                                            array10 = array7;
                                            d7 = q3.d();
                                            ++array10[d7];
                                            if (x2) {
                                                break;
                                            }
                                            continue Label_1720_Outer;
                                        }
                                    }
                                }
                                Label_1646: {
                                    if (n10 == 0) {
                                        l = 0;
                                        while (true) {
                                            while (l < list.size()) {
                                                a14 = list.get(l).a();
                                                b = ((a15 = (a14.a(n7) ? 1 : 0)) != 0);
                                                if (!x2) {
                                                    if (b) {
                                                        n9 = 1;
                                                        q4 = hashMap.get(bg.a(a14));
                                                        a16 = i.a(q4, d5);
                                                        f3 = a14.f();
                                                        u.a(a16, f3);
                                                        if (f3 < n8) {
                                                            if (array4[k] != null) {
                                                                c3 = array4[k].c();
                                                                array11 = array7;
                                                                d8 = c3.d();
                                                                --array11[d8];
                                                            }
                                                            array4[k] = a16;
                                                            n8 = f3;
                                                            array12 = array7;
                                                            d9 = q4.d();
                                                            ++array12[d9];
                                                        }
                                                    }
                                                    ++l;
                                                    if (x2) {
                                                        break;
                                                    }
                                                    continue Label_1593_Outer;
                                                }
                                                else {
                                                    if (a15 == 0) {
                                                        c4 = array4[k].c();
                                                        d10 = array4[k];
                                                        i.a(d10, c4, d5);
                                                        u.a(d10, 0.0);
                                                        n8 = 0.0;
                                                        array7[c4.d()] = 1;
                                                    }
                                                    break Label_1646;
                                                }
                                            }
                                            a15 = n9;
                                            continue Label_1720_Outer;
                                        }
                                    }
                                }
                                array8[k] = new d[d5.b()];
                                d11 = d5.g();
                                n11 = 0;
                                while (true) {
                                    while (n11 < array8[k].length) {
                                        array8[k][n11] = d11;
                                        ++n11;
                                        d11 = d11.h();
                                        if (!x2) {
                                            if (x2) {
                                                break;
                                            }
                                            continue Label_1720_Outer;
                                        }
                                        else {
                                            if (x2) {
                                                break Label_1593_Outer;
                                            }
                                            continue Label_1063;
                                        }
                                    }
                                    n5 += n8;
                                    ++k;
                                    continue Label_1730_Outer;
                                }
                            }
                            a17 = M.a(new Object[n6]);
                            a18 = M.a(new int[i.f()]);
                            a19 = M.a(new int[i.f()]);
                            n12 = 0;
                            while (true) {
                                while (n12 < array5.length) {
                                    q5 = array5[n12];
                                    b2 = t.b(q5);
                                    n13 = ((b2 instanceof aA) ? 1 : 0);
                                    if (x2) {
                                        b3 = M.b(new double[n13]);
                                        p6 = i.p();
                                        while (p6.f()) {
                                            a20 = p6.a();
                                            b3.a(a20, u.c(a20));
                                            p6.g();
                                            if (x2) {
                                                return;
                                            }
                                            if (x2) {
                                                break;
                                            }
                                        }
                                        this.a(q, i, array6, array5, array3, array4, b3, array7, a18, a17, a19, n5, array8);
                                        this.a(q, i, array6, array5, array3, array4, b3, array7, a18, a17, a19);
                                        this.a(q, array3, array4, t, x, ap);
                                        return;
                                    }
                                    Label_1871: {
                                        if (n13 != 0) {
                                            aa2 = (aA)b2;
                                            a17.a(q5, aa2.a());
                                            a18.a(q5, aa2.b());
                                            if (!x2) {
                                                break Label_1871;
                                            }
                                        }
                                        a17.a(q5, b2);
                                        a18.a(q5, Integer.MAX_VALUE);
                                    }
                                    a19.a(array5[n12], n12);
                                    ++n12;
                                    if (x2) {
                                        break;
                                    }
                                }
                                i.h();
                                continue;
                            }
                        }
                        i.f();
                        continue;
                    }
                }
                int n14 = 0;
                Label_0730: {
                    if (n4 != 0 && b(a11.e())) {
                        n14 = this.b(a11.e().b());
                        if (!x2) {
                            break Label_0730;
                        }
                    }
                    if (equals2 == 0 && b(a11.c())) {
                        n14 = this.b(a11.c().b());
                        if (!x2) {
                            break Label_0730;
                        }
                    }
                    n14 = ((equals2 != 0) ? a : a2);
                }
                final Collection collection3 = (equals2 != 0) ? a11.f() : a11.d();
                int n15 = 0;
                if (collection3 != null && collection3.size() > 0) {
                    final Iterator<ax> iterator2 = collection3.iterator();
                Label_0781:
                    while (iterator2.hasNext()) {
                        iterator2.next();
                        Object value = null;
                        ax ax2;
                        do {
                            ax2 = (ax)value;
                            if (!ax2.a(n14)) {
                                continue Label_0781;
                            }
                            ++n15;
                            value = hashMap.get(bg.a(ax2));
                        } while (x2);
                        if (value == null) {
                            final q d12 = i.d();
                            hashMap.put(bg.a(ax2), (ax)d12);
                            t.a(d12, ax2);
                            list2.add(d12);
                            if (x2) {
                                break;
                            }
                            continue;
                        }
                    }
                }
                if (n15 == 0 && list.isEmpty()) {
                    final q d13 = i.d();
                    final ax b4 = ax.b((equals2 != 0) ? a : a2);
                    hashMap.put(bg.a(b4), (ax)d13);
                    t.a(d13, b4);
                    list2.add(d13);
                    final d a21 = i.a(d13, d13);
                    u.a(a21, 0.0);
                    array4[j] = a21;
                }
                ++j;
                if (x2) {
                    break;
                }
            }
            Collections.sort((List<Object>)list2, new be(this, t));
            list2.size();
            continue;
        }
    }
    
    private void a(final q q, final i i, final q[] array, final q[] array2, final d[] array3, final d[] array4, final c c, final int[] array5, final c c2, final c c3, final c c4) {
        final boolean x = N.x;
        double a = this.a(q, array, array2, array3, array4, c, array5, c2, c3, c4);
        int j = 0;
        while (j < array.length) {
            final q q2 = array[j];
            array4[j].a(q2);
        Label_0055:
            while (true) {
                q q4 = null;
                q q3 = q4;
                int k = j;
                while (k < array.length) {
                    final q q5 = array[k];
                    final q a2 = array4[k].a(q5);
                    q4 = q3;
                    if (x) {
                        continue Label_0055;
                    }
                    Label_0206: {
                        if (q4 != a2 && i.b(q3, q5) && i.b(a2, q2)) {
                            final d d = array4[j];
                            array4[j] = array4[k];
                            array4[k] = d;
                            final double a3 = this.a(q, array, array2, array3, array4, c, array5, c2, c3, c4);
                            if (a3 < a) {
                                a = a3;
                                q3 = a2;
                                if (!x) {
                                    break Label_0206;
                                }
                            }
                            array4[k] = array4[j];
                            array4[j] = d;
                        }
                    }
                    ++k;
                    if (x) {
                        break;
                    }
                }
                break;
            }
            ++j;
            if (x) {
                break;
            }
        }
    }
    
    private int b(final int n) {
        final byte b = this.b();
        if (b == 0) {
            return n;
        }
        if (b == 2) {
            if (n == 1) {
                return 2;
            }
            if (n == 2) {
                return 1;
            }
            if (n == 8) {
                return 8;
            }
            if (n == 4) {
                return 4;
            }
            return 255;
        }
        else if (b == 1) {
            if (n == 1) {
                return 8;
            }
            if (n == 2) {
                return 4;
            }
            if (n == 8) {
                return 2;
            }
            if (n == 4) {
                return 1;
            }
            return 255;
        }
        else {
            if (n == 1) {
                return 4;
            }
            if (n == 2) {
                return 8;
            }
            if (n == 8) {
                return 1;
            }
            if (n == 4) {
                return 2;
            }
            return 255;
        }
    }
    
    private int a(final boolean b) {
        if (b) {
            switch (this.b()) {
                default: {
                    return 237;
                }
                case 2: {
                    return 238;
                }
                case 1: {
                    return 235;
                }
                case 3: {
                    return 231;
                }
            }
        }
        else {
            switch (this.b()) {
                default: {
                    return 222;
                }
                case 2: {
                    return 221;
                }
                case 1: {
                    return 215;
                }
                case 3: {
                    return 219;
                }
            }
        }
    }
    
    private void a(final q q, final i i, final q[] array, final q[] array2, final d[] array3, final d[] array4, final c c, final int[] array5, final c c2, final c c3, final c c4, final double n, final d[][] array6) {
        final boolean x = N.x;
        double a2;
        double a = a2 = this.a(q, array, array2, array3, array4, c, array5, c2, c3, c4);
        final int[] array7 = new int[array5.length];
        System.arraycopy(array5, 0, array7, 0, array5.length);
        final d[] array8 = new d[array4.length];
        System.arraycopy(array4, 0, array8, 0, array4.length);
        final int[] array9 = new int[array5.length];
        final d[] array10 = new d[array4.length];
        final ar ar = this.m ? new ar(4242L) : new ar();
        double n2 = i.g();
        int n3 = 0;
        while (true) {
            do {
                double n4 = 0.0;
                Label_0126: {
                    n4 = n3;
                }
                Label_0128:
                while (n4 < 20) {
                    final double n5 = dcmpl(a, n);
                    if (x) {
                        if (n5 > 0) {
                            System.arraycopy(array7, 0, array5, 0, array5.length);
                            System.arraycopy(array8, 0, array4, 0, array4.length);
                        }
                        return;
                    }
                    if (n5 > 0) {
                        int a3 = 1;
                        int j = 20 * i.g();
                        while (j > 0) {
                            final double n6 = n4 = dcmpl(a, n);
                            if (x) {
                                continue Label_0128;
                            }
                            if (n6 <= 0) {
                                break;
                            }
                            final double n7 = a;
                            if (a3 != 0) {
                                System.arraycopy(array5, 0, array9, 0, array5.length);
                                System.arraycopy(array4, 0, array10, 0, array4.length);
                            }
                            if ((a3 = (a(array, array4, array6, array5, ar) ? 1 : 0)) != 0) {
                                a = this.a(q, array, array2, array3, array4, c, array5, c2, c3, c4);
                                final double n8 = a - n7;
                                if (n8 > 0.0 && ar.nextDouble() < 1.0 - Math.exp(-n8 / n2)) {
                                    System.arraycopy(array9, 0, array5, 0, array5.length);
                                    System.arraycopy(array10, 0, array4, 0, array4.length);
                                    a = n7;
                                }
                                if (a < a2) {
                                    a2 = a;
                                    System.arraycopy(array5, 0, array7, 0, array5.length);
                                    System.arraycopy(array4, 0, array8, 0, array4.length);
                                }
                            }
                            --j;
                            if (x) {
                                break;
                            }
                        }
                        n2 *= 0.85;
                        ++n3;
                        continue Label_0126;
                    }
                    break;
                }
                break;
            } while (!x);
            final double n9 = dcmpl(a, a2);
            continue;
        }
    }
    
    private void a(final q q, final d[] array, final d[] array2, final c c, final X x, final aP ap) {
        final boolean x2 = N.x;
        int i = 0;
        while (i < array.length) {
            final d d = array[i];
            final Object b = c.b(array2[i].c());
            ax a = null;
            Label_0073: {
                if (b instanceof aA) {
                    a = ((aA)b).a();
                    if (!x2) {
                        break Label_0073;
                    }
                }
                a = (ax)b;
            }
            this.a(x, d, a, d.c().equals(q), ap);
            ++i;
            if (x2) {
                break;
            }
        }
    }
    
    private void a(final X x, final d d, final ax ax, final boolean b, final aP ap) {
        if (a(ax, this.a(!b)) || (!ax.b() && ax.a() == 255)) {
            return;
        }
        ap.a(d, b, this.a(ax, b));
        if (ax.b()) {
            final t t = new t(ax.a(this.b(), this.a()), ax.b(this.b(), this.a()));
            if (b) {
                x.a(d, t);
                if (!N.x) {
                    return;
                }
            }
            x.b(d, t);
        }
    }
    
    private aE a(final ax ax, final boolean b) {
        switch (b ? this.a(1, 2, 1, 8, 4, 2, ax) : this.a(1, 1, 2, 8, 4, 1, ax)) {
            default: {
                return aE.a((byte)1, ax.b());
            }
            case 1: {
                return aE.a((byte)4, ax.b());
            }
            case 2: {
                return aE.a((byte)2, ax.b());
            }
            case 3: {
                return aE.a((byte)8, ax.b());
            }
        }
    }
    
    private aE a(final ax ax, final boolean b, final boolean b2) {
        switch (b ? this.a(1, 2, 1, 8, 4, 2, ax) : this.a(1, 1, 2, 8, 4, 1, ax)) {
            default: {
                if (b2) {
                    return bb.f;
                }
                return bb.b;
            }
            case 1: {
                if (b2) {
                    return bb.h;
                }
                return bb.d;
            }
            case 2: {
                if (b2) {
                    return bb.e;
                }
                return bb.a;
            }
            case 3: {
                if (b2) {
                    return bb.g;
                }
                return bb.c;
            }
        }
    }
    
    private static boolean a(final q[] array, final d[] array2, final d[][] array3, final int[] array4, final ar ar) {
        final boolean x = N.x;
        int i = 0;
        int length = 0;
        while (i < array.length) {
            final int n = length = array3[i].length;
            if (x) {
                return length != 0;
            }
            if (length > 1) {
                final d d = array3[i][ar.nextInt(n)];
                final d d2 = array2[i];
                if (d2 != d) {
                    final int d3 = d2.c().d();
                    --array4[d3];
                    array2[i] = d;
                    final int d4 = d.c().d();
                    ++array4[d4];
                }
            }
            ++i;
            if (x) {
                break;
            }
        }
        return length != 0;
    }
    
    private double a(final q q, final q[] array, final q[] array2, final d[] array3, final d[] array4, final c c, final int[] array5, final c c2, final c c3, final c c4) {
        final boolean x = N.x;
        final int a = this.a(true);
        final int a2 = this.a(false);
        double n = 0.0;
        int i = 0;
        while (true) {
            while (i < array.length) {
                final d d = array4[i];
                n += c.c(d);
                final q d2;
                q q2 = d2 = array3[i].d();
                if (x) {
                    while (true) {
                        final q q3 = q2;
                        final int n2 = array5[q3.d()] - c2.a(q3);
                        if (n2 > 0) {
                            n += n2 * this.k;
                        }
                        ++i;
                        if (!x) {
                            if (i < array2.length) {
                                q2 = array2[i];
                                continue;
                            }
                        }
                        break;
                    }
                    return n;
                }
                q q4 = q;
                Label_0348: {
                    int n3;
                    while (true) {
                        q d3 = null;
                        final boolean b = d3 == q4;
                        final ax ax = (ax)c3.b(d.c());
                        if (a(ax, a)) {
                            break Label_0348;
                        }
                        n3 = 0;
                        int j = i + 1;
                        while (j < array.length) {
                            d3 = array3[j].d();
                            q4 = q;
                            if (x) {
                                continue Label_0348;
                            }
                            final boolean b2 = d3 == q;
                            final ax ax2 = (ax)c3.b(array4[j].c());
                            Label_0327: {
                                if (!a(ax2, a2)) {
                                    final int a3 = y.g.e.a(c4.a(d.c()), c4.a(array4[j].c()));
                                    if (!b && !b2) {
                                        if (a3 <= 0) {
                                            break Label_0327;
                                        }
                                        ++n3;
                                        if (!x) {
                                            break Label_0327;
                                        }
                                    }
                                    if (b && !b2) {
                                        if (!ax.a(8)) {
                                            if (a3 <= 0) {
                                                break Label_0327;
                                            }
                                            ++n3;
                                            if (!x) {
                                                break Label_0327;
                                            }
                                        }
                                        if (a3 >= 0) {
                                            break Label_0327;
                                        }
                                        ++n3;
                                        if (!x) {
                                            break Label_0327;
                                        }
                                    }
                                    if (ax.a(8) != ax2.a(8)) {
                                        if (a3 >= 0) {
                                            break Label_0327;
                                        }
                                        ++n3;
                                        if (!x) {
                                            break Label_0327;
                                        }
                                    }
                                    if (a3 > 0) {
                                        ++n3;
                                    }
                                }
                            }
                            ++j;
                            if (x) {
                                break;
                            }
                        }
                        break;
                    }
                    n += this.i * n3;
                }
                ++i;
                if (x) {
                    break;
                }
            }
            i = 0;
            continue;
        }
    }
    
    private static boolean a(final ax ax, final int n) {
        return !ax.b() && ax.a() == n;
    }
    
    final int a(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final ax ax) {
        final boolean x = N.x;
        int n7 = 0;
        int b = ax.b(this.b());
        Label_0106: {
            switch (b) {
                case 255: {
                    b = n6;
                    if (x) {
                        break Label_0106;
                    }
                    break;
                }
                case 32: {
                    b = n3;
                    if (x) {
                        break Label_0106;
                    }
                    break;
                }
                case 16: {
                    b = n2;
                    if (x) {
                        break Label_0106;
                    }
                    break;
                }
                case 128: {
                    b = n4;
                    if (x) {
                        break Label_0106;
                    }
                    break;
                }
                case 64: {
                    b = n5;
                    break;
                }
            }
        }
        Label_0184: {
            switch (b) {
                case 1: {
                    n7 = 0;
                    if (x) {
                        break Label_0184;
                    }
                    break;
                }
                case 4: {
                    n7 = 1;
                    if (x) {
                        break Label_0184;
                    }
                    break;
                }
                case 2: {
                    n7 = 2;
                    if (x) {
                        break Label_0184;
                    }
                    break;
                }
                case 8: {
                    n7 = 3;
                    break;
                }
            }
        }
        int n8 = 0;
        int n9 = n;
        Label_0278: {
            switch (n9) {
                case 255: {
                    n9 = n6;
                    if (x) {
                        break Label_0278;
                    }
                    break;
                }
                case 32: {
                    n9 = n3;
                    if (x) {
                        break Label_0278;
                    }
                    break;
                }
                case 16: {
                    n9 = n2;
                    if (x) {
                        break Label_0278;
                    }
                    break;
                }
                case 128: {
                    n9 = n4;
                    if (x) {
                        break Label_0278;
                    }
                    break;
                }
                case 64: {
                    n9 = n5;
                    break;
                }
            }
        }
        Label_0356: {
            switch (n9) {
                case 1: {
                    n8 = 0;
                    if (x) {
                        break Label_0356;
                    }
                    break;
                }
                case 4: {
                    n8 = 1;
                    if (x) {
                        break Label_0356;
                    }
                    break;
                }
                case 2: {
                    n8 = 2;
                    if (x) {
                        break Label_0356;
                    }
                    break;
                }
                case 8: {
                    n8 = 3;
                    break;
                }
            }
        }
        if (n7 < n8) {
            n7 += 4;
        }
        return n7 - n8;
    }
    
    static boolean a(final aE ae) {
        return b(ae);
    }
    
    static {
        a = new aE((byte)2, false);
        b = new aE((byte)1, false);
        c = new aE((byte)8, false);
        d = new aE((byte)4, false);
        e = new aE((byte)2, true);
        f = new aE((byte)1, true);
        g = new aE((byte)8, true);
        h = new aE((byte)4, true);
    }
}
