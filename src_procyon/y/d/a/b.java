package y.d.a;

import y.f.h.*;
import y.d.b.*;
import y.g.*;
import y.c.*;
import java.util.*;

public class b
{
    protected int a;
    private l c;
    private k d;
    private i e;
    private h f;
    private A g;
    private y.d.a.i h;
    public static int b;
    
    public void a(final k d) {
        this.d = d;
    }
    
    public void a(final l l, final Collection collection, final N n, final A g, final h f) {
        int b = y.d.a.b.b;
        (this.e = n.g()).j();
        this.g = g;
        this.f = f;
        this.a = 0;
        this.a(l, collection);
        final ArrayList<d> list = new ArrayList<d>(this.e.h());
        final y.c.e p5 = this.e.p();
        while (true) {
            while (p5.f()) {
                list.add(p5.a());
                p5.g();
                if (b != 0) {
                    int i = 0;
                    while (i < list.size()) {
                        final d d = list.get(i);
                        final d a = this.e.a(d.d(), d.d().f(), d.c(), null, 1, 1);
                        n.b(d, a);
                        final e e = (e)f.b(d);
                        Label_0225: {
                            if (e.a()) {
                                n.m(d);
                                if (b == 0) {
                                    break Label_0225;
                                }
                            }
                            n.m(a);
                        }
                        f.a(d, e.e);
                        f.a(a, e.e);
                        ++i;
                        if (b != 0) {
                            break;
                        }
                    }
                    if (y.c.i.g) {
                        y.d.a.b.b = ++b;
                    }
                    return;
                }
                if (b != 0) {
                    break;
                }
            }
            y.g.e.a(list, new g(this, f));
            continue;
        }
    }
    
    public void a(final l l, final Collection collection, final i e, final A g, final h f) {
        final int b = y.d.a.b.b;
        (this.e = e).j();
        this.g = g;
        this.f = f;
        this.a = 0;
        this.a(l, collection);
        final y.c.e p5 = e.p();
        while (p5.f()) {
            final d a = p5.a();
            f.a(a, ((e)f.b(a)).e);
            p5.g();
            if (b != 0) {
                break;
            }
        }
    }
    
    public void a(final l c, final Collection collection) {
        final int i = y.d.a.b.b;
        this.c = c;
        final TreeMap<Object, j> treeMap = new TreeMap<Object, j>(c.c());
        final y.d.a.h h = new y.d.a.h(this, null);
        this.a(collection, treeMap, h);
        final e[] array = new e[2];
        final ArrayList<e> list = new ArrayList<e>();
        q d = null;
        do {
            Label_0061: {
                treeMap.isEmpty();
            }
            boolean b = false;
            Label_0065:
        Label_0242_Outer:
            while (!b) {
                final Object firstKey = treeMap.firstKey();
                final j j = treeMap.get(firstKey);
                final Object c2 = j.c;
                treeMap.remove(firstKey);
                if (this.d != null) {
                    this.d.a(j);
                }
                h.a(c2, list, array);
            Label_0242:
                while (true) {
                    if (this.a == 0) {
                        d = this.e.d();
                        this.g.a(d, c2);
                        int k = 0;
                        while (k < list.size()) {
                            final e e = list.get(k);
                            this.f.a(this.e.a(d, d.f(), e.a, null, 1, 1), e);
                            e.a = d;
                            ++k;
                            if (i != 0) {
                                break Label_0242;
                            }
                            if (i != 0) {
                                break;
                            }
                        }
                    }
                    Label_0239: {
                        break Label_0239;
                        while (true) {
                            int k = 0;
                            while (k < j.b.size()) {
                                h.a((e)j.b.get(k));
                                ++k;
                                if (i == 0) {
                                    if (i != 0) {
                                        break;
                                    }
                                    continue Label_0242_Outer;
                                }
                                else {
                                    int l = 0;
                                Label_0459:
                                    while (true) {
                                        while (l < j.a.size()) {
                                            final e e2 = j.a.get(l);
                                            e2.a = d;
                                            h.a(c2, e2);
                                            ++l;
                                            if (i != 0) {
                                                this.a(c2, treeMap, array[0], h.b(array[0]));
                                                this.a(c2, treeMap, h.c(array[1]), array[1]);
                                                continue Label_0061;
                                            }
                                            if (i != 0) {
                                                break;
                                            }
                                        }
                                        if (this.a == 1) {
                                            list.addAll(j.a);
                                            int n = 0;
                                            Label_0379:
                                            while (n < list.size()) {
                                                final e value = list.get(n);
                                                b = false;
                                                if (i == 0) {
                                                    int n2 = b ? 1 : 0;
                                                    while (true) {
                                                        while (n2 < list.size()) {
                                                            this.h.a(value, list.get(n2));
                                                            ++n2;
                                                            if (i == 0) {
                                                                if (i != 0) {
                                                                    break;
                                                                }
                                                                continue Label_0242_Outer;
                                                            }
                                                            else {
                                                                if (i != 0) {
                                                                    continue Label_0459;
                                                                }
                                                                continue Label_0379;
                                                            }
                                                        }
                                                        ++n;
                                                        continue;
                                                    }
                                                }
                                                continue Label_0065;
                                            }
                                        }
                                        continue Label_0459;
                                    }
                                }
                            }
                            h.a(c2);
                            continue;
                        }
                    }
                    int k = 0;
                    continue Label_0242;
                }
            }
            break;
        } while (i == 0);
    }
    
    private void a(final Collection collection, final TreeMap treeMap, final y.d.a.h h) {
        final int b = y.d.a.b.b;
        int n = 0;
        final Comparator c = this.c.c();
        double n2 = 1.0;
        Object o = collection.iterator();
        while (true) {
            while (((Iterator)o).hasNext()) {
                final Object o2 = ((Iterator<Object>)o).next();
                Object o3 = this.c.c(o2);
                Object o4 = this.c.d(o2);
                final Object c2;
                final Comparator comparator = (Comparator)(c2 = c);
                if (b != 0) {
                    final Object o5 = c2;
                    final Object c3 = this.c.c(o3, o4);
                    final e e = new e(this, o, o2, o5, n++);
                    final e e2 = new e(this, o3, o4, c3, n++);
                    h.a(o, e);
                    h.a(o3, e2);
                    return;
                }
                if (comparator.compare(o3, o4) > 0) {
                    final Object o6 = o4;
                    o4 = o3;
                    o3 = o6;
                }
                double e3 = this.c.k(o3).e();
                double e4 = this.c.l(o3).e();
                double e5 = this.c.k(o4).e();
                double e6 = this.c.l(o4).e();
                if (e3 < 0.0) {
                    e3 = -e3;
                }
                if (e4 < 0.0) {
                    e4 = -e4;
                }
                if (e5 < 0.0) {
                    e5 = -e5;
                }
                if (e6 < 0.0) {
                    e6 = -e6;
                }
                Label_0276: {
                    while (e3 < n2) {
                        final double n3 = e4;
                        final double n4 = n2;
                        if (b == 0 && (n3 < n4 && e5 < n2 && e6 < n2)) {
                            break Label_0276;
                        }
                        n2 = n3 * n4;
                        if (b != 0) {
                            break Label_0276;
                        }
                    }
                    goto Label_0263;
                }
                j j = treeMap.get(o3);
                if (j == null) {
                    j = new j(o3);
                    treeMap.put(o3, j);
                }
                j i = treeMap.get(o4);
                if (i == null) {
                    i = new j(o4);
                    treeMap.put(o4, i);
                }
                if (o3.equals(o4)) {
                    continue;
                }
                final e e7 = new e(this, o3, o4, o2, n++);
                j.a.add(e7);
                i.b.add(e7);
                if (b != 0) {
                    break;
                }
            }
            o = this.c.a(-n2, n2);
            final Object o2 = this.c.a(n2, n2);
            Object o3 = this.c.a(-n2, -n2);
            Object o4 = this.c.a(n2, -n2);
            Object c2 = this.c.c(o, o2);
            continue;
        }
    }
    
    protected void a(final Object o, final TreeMap treeMap, e h, e h2) {
        final int b = y.d.a.b.b;
        final Object f = this.c.f(h.g, h2.g);
        if (f == null) {
            return;
        }
        if (this.c.c().compare(o, f) < 0) {
            boolean b2 = false;
            boolean b3 = false;
        Label_0091_Outer:
            while (true) {
                if (this.c.c().compare(f, h.d) < 0) {
                    b2 = true;
                }
                h = h.h;
                while (true) {
                    Label_0094: {
                        if (h == null) {
                            break Label_0094;
                        }
                        if (!b3) {
                            continue Label_0091_Outer;
                        }
                    }
                    b3 = false;
                    if (b == 0) {
                        break;
                    }
                    continue;
                }
            }
            boolean b4 = b3;
            boolean b5 = false;
        Label_0143_Outer:
            while (true) {
                if (this.c.c().compare(f, h2.d) < 0) {
                    b4 = true;
                }
                h2 = h2.h;
                while (true) {
                    Label_0146: {
                        if (h2 == null) {
                            break Label_0146;
                        }
                        if (!b5) {
                            continue Label_0143_Outer;
                        }
                    }
                    b5 = b2;
                    if (b == 0) {
                        break;
                    }
                    continue;
                }
            }
            if (b5 && b4 && !treeMap.containsKey(f)) {
                treeMap.put(f, new j(f));
            }
        }
    }
    
    public void a(final l l, final Collection collection, final i i, final A a, final h h, final boolean b) {
        final int j = b.b;
        final Object k = l.i(l.a(new v(0L), new v(0L)), l.a(new v(0L), new v(-1L)));
        final Comparator c = l.c();
        final x o = i.o();
    Label_0389_Outer:
        while (true) {
            while (true) {
                do {
                    double f = 0.0;
                    Label_0073: {
                        f = (o.f() ? 1 : 0);
                    }
                    Label_0080:
                    while (f != 0) {
                        final q e = o.e();
                        final Object b2 = a.b(e);
                        double n = -1.7976931348623157E308;
                        e e2 = null;
                        if (j == 0) {
                            final y.c.e m = e.l();
                            while (m.f()) {
                                final d a2 = m.a();
                                final e e3 = (e)h.b(a2);
                                final Object b3 = a.b(a2.d());
                                double h2 = l.h(k, l.i(b2, b3));
                                final double n2 = f = dcmpl(h2, 0.0);
                                if (j != 0) {
                                    continue Label_0080;
                                }
                                if (n2 == 0) {
                                    h2 = 6.283185307179586;
                                }
                                if (h2 < n) {
                                    y.g.o.a((Object)("Error: Edge: " + a2 + " Angle: " + h2 / 3.141592653589793 * 2.0 + " !!"));
                                }
                                Label_0347: {
                                    if (h2 == n) {
                                        if (c.compare(b2, b3) > 0) {
                                            if (e3.b() <= e2.b()) {
                                                break Label_0347;
                                            }
                                            y.g.o.a((Object)"Error  ....>");
                                            if (j == 0) {
                                                break Label_0347;
                                            }
                                            i.g = !i.g;
                                        }
                                        if (e3.b() < e2.b()) {
                                            y.g.o.a((Object)"Error  ....>");
                                        }
                                    }
                                }
                                n = h2;
                                e2 = e3;
                                m.g();
                                if (j != 0) {
                                    break;
                                }
                            }
                            o.g();
                            continue Label_0073;
                        }
                        final int n3 = 1;
                        final int n4 = n3;
                        final TreeMap<Object, q> treeMap = new TreeMap<Object, q>(l.c());
                        final x o2 = i.o();
                        while (o2.f()) {
                            final q e4 = o2.e();
                            final Object b4 = a.b(e4);
                            if (treeMap.put(b4, e4) != null) {
                                y.g.o.a((Object)("Points is double mentioned :" + b4));
                            }
                            o2.g();
                            if (j != 0) {
                                break;
                            }
                        }
                        final Object[] array = collection.toArray();
                        int n5 = 0;
                        do {
                            int a3 = 0;
                            Label_0507:
                            while (a3 < array.length - 1) {
                                final Object o3 = array[n5];
                                int n6 = n5 + 1;
                                while (n6 < array.length) {
                                    final Object o4 = array[n6];
                                    final Object c2 = l.c(o3);
                                    final Object c3 = l.c(o4);
                                    final Object d = l.d(o3);
                                    final Object d2 = l.d(o4);
                                    a3 = (l.a(o3) ? 1 : 0);
                                    if (j != 0) {
                                        continue Label_0507;
                                    }
                                    final int n7 = (a3 == 0) ? 1 : 0;
                                    final int n8 = l.a(o4) ? 0 : 1;
                                    boolean b5 = false;
                                    if (l.b(o3, c3)) {
                                        b5 = true;
                                        this.a(treeMap, h, c3, o3, o4, 2, n8, n4);
                                    }
                                    if (l.b(o3, d2)) {
                                        b5 = true;
                                        this.a(treeMap, h, d2, o3, o4, 2, n8, n4);
                                    }
                                    if (l.b(o4, c2)) {
                                        b5 = true;
                                        this.a(treeMap, h, c2, o3, o4, n7, 2, n4);
                                    }
                                    if (l.b(o4, d)) {
                                        b5 = true;
                                        this.a(treeMap, h, d, o3, o4, n7, 2, n4);
                                    }
                                    Label_0861: {
                                        if (!b5) {
                                            final Object g = l.g(o3, o4);
                                            if (g != null) {
                                                if (c2.equals(g) || d.equals(g)) {
                                                    if (c3.equals(g)) {
                                                        break Label_0861;
                                                    }
                                                    if (d2.equals(g)) {
                                                        break Label_0861;
                                                    }
                                                }
                                                this.a(treeMap, h, g, o3, o4, 2, 2, n4);
                                            }
                                        }
                                    }
                                    ++n6;
                                    if (j != 0) {
                                        break;
                                    }
                                }
                                ++n5;
                            }
                            break;
                        } while (j == 0);
                        return;
                    }
                    break;
                } while (j == 0);
                if (b) {
                    final int n3 = 2;
                    continue;
                }
                break;
            }
            continue Label_0389_Outer;
        }
    }
    
    protected boolean a(final TreeMap treeMap, final h h, final Object o, final Object o2, final Object o3, final int n, final int n2, final int n3) {
        final int b = y.d.a.b.b;
        final q q = treeMap.get(o);
        if (q == null) {
            o.a((Object)"Crossing not found: ");
            o.a(o2);
            o.a(o3);
            o.a(o);
            return false;
        }
        int n4 = 0;
        int n5 = 0;
        final y.c.e j = q.j();
        while (true) {
            while (j.f()) {
                final Object b2 = h.b(j.a());
                if (b != 0) {
                    if (n4 != n * n3) {
                        o.a((Object)("Is: " + n4 + " Should: " + n + " Seg: " + o2));
                    }
                    if (n5 != n2 * n3) {
                        o.a((Object)("Is: " + n5 + " Should: " + n2 + " Seg: " + o3));
                    }
                    return false;
                }
                if (b2 == o2) {
                    ++n4;
                }
                if (b2 == o3) {
                    ++n5;
                }
                j.g();
                if (b != 0) {
                    break;
                }
            }
            if (n4 != n * n3 || n5 != n2 * n3) {
                o.a((Object)"Crossing found, but not for this segments:");
                o.a((Object)("at " + o));
                continue;
            }
            break;
        }
        return true;
    }
    
    static l a(final b b) {
        return b.c;
    }
}
