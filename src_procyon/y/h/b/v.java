package y.h.b;

import y.h.*;
import java.awt.geom.*;
import y.g.*;
import java.util.*;
import y.d.*;
import y.f.c.a.*;
import y.c.*;

public class v
{
    private I a;
    private A b;
    private c c;
    private c d;
    private Map e;
    private boolean f;
    private bk g;
    private Map h;
    private Map i;
    private boolean j;
    private boolean k;
    private double l;
    private HashSet m;
    
    public v() {
        this.k = false;
        this.f = true;
        this.l = 30.0;
    }
    
    public double a() {
        return this.l;
    }
    
    public boolean b() {
        return this.j;
    }
    
    public void a(final boolean j) {
        this.j = j;
    }
    
    public boolean c() {
        return this.f;
    }
    
    public void a(final bu bu) {
        this.b(bu);
        this.c(bu);
    }
    
    public void b(final bu bu) {
        final int h = y.h.b.a.H;
        this.m = new HashSet();
        final y.h.a.v c = bu.C();
        final x p = c.p(null);
        while (p.f()) {
            final q e = p.e();
            if (c.k(e)) {
                final fj c2 = c(bu, e);
                if (c2 instanceof a) {
                    final a a = (a)c2;
                    if (a.k()) {
                        a.c(false);
                        this.m.add(a);
                    }
                }
            }
            p.g();
            if (h != 0) {
                break;
            }
        }
    }
    
    public void c(final bu bu) {
        this.a = I.a(bu);
        if (this.a != null) {
            this.g(bu);
        }
    }
    
    private void g(final bu bu) {
        final int h = y.h.b.a.H;
        this.b = bu.t();
        this.e = new HashMap();
        this.h = new HashMap();
        this.i = new HashMap();
        final HashMap<i, Integer> hashMap = new HashMap<i, Integer>();
        final boolean b = !this.b();
        int n = 0;
        int size = 0;
        int size2 = 0;
        int n2 = 0;
        double n3 = 0.0;
        double n4 = 0.0;
        final ArrayList<Object> list = new ArrayList<Object>(this.a.b());
        if (this.k) {
            Collections.sort(list, new y.h.b.A(b, this.a, bu));
        }
    Label_0648_Outer:
        while (true) {
            while (true) {
                for (final i i : list) {
                    final B b2 = new B();
                    final G g = new G(null, b2);
                    this.a(i.o(), g, b2);
                    this.h.put(i, b2);
                    final B b3 = new B();
                    final H h2 = new H(null, b3);
                    this.a(i.l(), h2, b3);
                    this.i.put(i, b3);
                    ++n;
                    B b4 = null;
                    C c = null;
                    Label_0367: {
                        if (b) {
                            if (size2 < b2.e.size()) {
                                size2 = b2.e.size();
                            }
                            size += b3.e.size();
                            b4 = b3;
                            c = g;
                            if (h == 0) {
                                break Label_0367;
                            }
                        }
                        if (size < b3.e.size()) {
                            size = b3.e.size();
                        }
                        size2 += b2.e.size();
                        b4 = b2;
                        c = h2;
                    }
                    hashMap.put(i, new Integer(n2));
                    n2 += b4.e.size() + 3;
                    final r d = i.d();
                    if (n3 < b4.b + c.c(d)) {
                        n3 = b4.b + c.c(d);
                    }
                    if (n4 < b4.d + c.d(d)) {
                        n4 = b4.d + c.d(d);
                        if (h != 0) {
                            final l b5 = this.g.b(0);
                            b5.a(n3);
                            b5.a(true);
                            final l b6 = this.g.b(size + 1);
                            b6.a(n4);
                            b6.a(true);
                            final ArrayList<i> list2 = new ArrayList<i>(this.a.b());
                            y.g.e.a(list2, new w(this, b));
                        Label_1264:
                            for (final i j : list2) {
                                final int intValue = hashMap.get(j);
                                Label_0771: {
                                    if (intValue > 0) {
                                        if (b) {
                                            this.g.b(intValue - 1).a(this.a());
                                            if (h == 0) {
                                                break Label_0771;
                                            }
                                        }
                                        this.g.a(intValue - 1).a(this.a());
                                    }
                                }
                                final q a = this.a.a(j);
                                final ArrayList<q> list3 = new ArrayList<q>();
                                a(y.h.a.v.a(bu), a, list3);
                                final fj t = bu.t(a);
                                final Rectangle2D.Double double1 = new Rectangle2D.Double(t.getX(), t.getY(), t.getWidth(), t.getHeight());
                                final B b7 = this.h.get(j);
                                final B b8 = this.i.get(j);
                                y.g.e.a(list3, new y.h.b.x(this, bu));
                                final HashMap<Object, bt> hashMap2 = new HashMap<Object, bt>();
                                final G g2 = new G(double1, b7);
                                Label_0982: {
                                    if (b) {
                                        this.a(g2, new D(this.g), j.d().a + b8.b, list3, hashMap2, bu);
                                        if (h == 0) {
                                            break Label_0982;
                                        }
                                    }
                                    this.a(g2, new D(this.g), j, intValue, list3, b8, hashMap2, bu);
                                }
                                y.g.e.a(list3, new y(this, bu));
                                final HashMap<Object, l> hashMap3 = new HashMap<Object, l>();
                                final H h3 = new H(double1, b8);
                                Label_1093: {
                                    if (b) {
                                        this.a(h3, new z(this.g), j, intValue, list3, b7, hashMap3, bu);
                                        if (h == 0) {
                                            break Label_1093;
                                        }
                                    }
                                    this.a(h3, new z(this.g), j.d().b + b7.b, list3, hashMap3, bu);
                                }
                                Label_1182: {
                                    if (b) {
                                        this.b.a(a, this.g.a(0, intValue, size2 + 1, intValue + b8.e.size() + 1));
                                        if (h == 0) {
                                            break Label_1182;
                                        }
                                    }
                                    this.b.a(a, this.g.a(intValue, 0, intValue + b7.e.size() + 1, size + 1));
                                }
                                for (final q q : list3) {
                                    this.b.a(q, this.g.a(hashMap2.get(q), hashMap3.get(q)));
                                    if (h != 0) {
                                        break Label_1264;
                                    }
                                    if (h != 0) {
                                        return;
                                    }
                                    if (h != 0) {
                                        break Label_1264;
                                    }
                                }
                            }
                            if (!this.a.a().isEmpty()) {
                                if (b) {
                                    this.g.c().a(this.a());
                                    final bh a2 = this.g.a(this.g.c(), this.g.b(1));
                                    final Iterator<Object> iterator4 = (Iterator<Object>)this.a.a().iterator();
                                    while (iterator4.hasNext()) {
                                        this.b.a(iterator4.next(), a2);
                                        if (h == 0) {
                                            continue Label_0648_Outer;
                                        }
                                        return;
                                    }
                                }
                                else {
                                    this.g.d().a(this.a());
                                    final bh a3 = this.g.a(this.g.a(1), this.g.d());
                                    final Iterator<Object> iterator5 = (Iterator<Object>)this.a.a().iterator();
                                    while (iterator5.hasNext()) {
                                        this.b.a(iterator5.next(), a3);
                                        if (h != 0) {
                                            return;
                                        }
                                        if (h != 0) {
                                            break;
                                        }
                                    }
                                }
                            }
                            this.c = bu.c(bk.a);
                            bu.a(bk.a, y.g.q.a(this.g));
                            this.d = bu.c(bk.b);
                            bu.a(bk.b, this.b);
                            return;
                        }
                        if (h != 0) {
                            break;
                        }
                        continue Label_0648_Outer;
                    }
                }
                if (b) {
                    this.g = new bk(size2 + 2, size + 3 * n - 1);
                    final bt a4 = this.g.a(0);
                    a4.a(n3);
                    a4.a(true);
                    final bt a5 = this.g.a(size2 + 1);
                    a5.a(n4);
                    a5.a(true);
                    continue;
                }
                break;
            }
            this.g = new bk(size2 + 3 * n - 1, size + 2);
            continue Label_0648_Outer;
        }
    }
    
    private void a(final C c, final F f, final double n, final List list, final Map map, final bu bu) {
        final int h = y.h.b.a.H;
        double n2 = c.a();
        final Object a = f.a(0);
        Label_0083: {
            if (a instanceof l) {
                final l l = (l)a;
                l.e(l.b());
                l.f(n2);
                if (h == 0) {
                    break Label_0083;
                }
            }
            final bt bt = (bt)a;
            bt.f(bt.b());
            bt.e(n2);
        }
        int i = 0;
        int n3 = 1;
        double n4 = n;
        Object o = c.c().iterator();
        while (true) {
            while (((Iterator)o).hasNext()) {
                final Object next = ((Iterator<Object>)o).next();
                final Object a2 = f.a(n3);
                f.a(a2, true);
                final r c2 = c.c(next);
                final double max = Math.max(c.c(c2), 0.0);
                final double max2 = Math.max(c.d(c2), 0.0);
                final boolean c3 = this.c();
                if (h != 0) {
                    if (c3) {
                        final l j = (l)o;
                        j.e(j.b());
                        j.f(n2);
                        if (h == 0) {
                            return;
                        }
                    }
                    final bt bt2 = (bt)o;
                    bt2.f(bt2.b());
                    bt2.e(n2);
                    return;
                }
                double max3 = Math.max(c3 ? c.b(next) : c.a(next), max + max2);
            Label_0294:
                while (true) {
                    Label_0321: {
                        if (!((Iterator)o).hasNext()) {
                            int k = n3 + 1;
                            while (k < f.a() - 1) {
                                max3 -= f.a(f.a(k));
                                ++k;
                                if (h != 0) {
                                    break Label_0321;
                                }
                                if (h != 0) {
                                    break;
                                }
                            }
                        }
                        final int n5;
                        final boolean b;
                        if (n5 == (b ? 1 : 0)) {
                            max3 -= f.a(f.a(0)) - n;
                        }
                    }
                    double n6 = max;
                    double n7 = max2;
                    final r f2 = c.f(next);
                    Label_0441: {
                        if (f2 != null) {
                            final double c4 = c.c(f2);
                            final double d = c.d(f2);
                            n6 += c4;
                            n7 += d;
                            max3 += c4 + d;
                            this.e.put(next, new E(a2, c4, d));
                            if (h == 0) {
                                break Label_0441;
                            }
                        }
                        this.e.put(next, new E(a2, 0.0, 0.0));
                    }
                    if (f.b(a2) < n6) {
                        f.b(a2, n6);
                    }
                    if (f.c(a2) < n7) {
                        f.c(a2, n7);
                    }
                    if (f.a(a2) < max3) {
                        f.a(a2, max3);
                    }
                    final double n8 = n2;
                    Label_0571: {
                        if (((Iterator)o).hasNext()) {
                            n2 += n4 + n6 - max + c.a(next) + n7 - max2;
                            n4 = 0.0;
                            if (h == 0) {
                                break Label_0571;
                            }
                        }
                        n2 = c.b();
                    }
                    Label_0664: {
                        if (a2 instanceof l) {
                            final l m = (l)a2;
                            final double a3 = c.a(next);
                            m.e(a3);
                            m.f(n2 - a3 - n7 + max2);
                            if (h == 0) {
                                break Label_0664;
                            }
                        }
                        final bt bt3 = (bt)a2;
                        final double a4 = c.a(next);
                        bt3.f(a4);
                        bt3.e(n2 - a4 - n7 + max2);
                    }
                    while (i < list.size()) {
                        final q q = list.get(i);
                        final double a5 = c.a(bu, q);
                        final int n5 = n3;
                        final boolean b = true;
                        if (h != 0) {
                            continue Label_0294;
                        }
                        if ((n5 != (b ? 1 : 0) && n8 > a5) || (((Iterator)o).hasNext() && a5 >= n2)) {
                            break;
                        }
                        map.put(q, a2);
                        ++i;
                        if (h != 0) {
                            break;
                        }
                    }
                    break;
                }
                ++n3;
                if (h != 0) {
                    break;
                }
            }
            o = f.a(n3);
            final boolean b2 = o instanceof l;
            continue;
        }
    }
    
    private void a(final C c, final F f, final i i, final int n, final List list, final B b, final Map map, final bu bu) {
        final int j = y.h.b.a.H;
        double n2 = c.c(i.d()) + b.b;
        double n3 = c.a();
        final Object a = f.a(n);
        f.a(a, n2);
        f.a(a, true);
        Label_0117: {
            if (a instanceof l) {
                final l l = (l)a;
                l.e(n2);
                l.f(n3);
                if (j == 0) {
                    break Label_0117;
                }
            }
            final bt bt = (bt)a;
            bt.f(n2);
            bt.e(n3);
        }
        int n4 = 0;
        int n5 = n + 1;
        final Iterator iterator = c.c().iterator();
        while (true) {
            while (iterator.hasNext()) {
                final Object next = iterator.next();
                final Object a2 = f.a(n5);
                f.a(a2, true);
                final r c2 = c.c(next);
                final double max = Math.max(c.c(c2), 0.0);
                final double max2 = Math.max(c.d(c2), 0.0);
                final Object a3 = this;
                if (j != 0) {
                    final Object o = a3;
                    final double n6 = c.d(i.d()) + b.d;
                    f.a(o, n6);
                    f.a(o, true);
                    if (o instanceof l) {
                        final l k = (l)o;
                        k.e(n6);
                        k.f(n3);
                        if (j == 0) {
                            return;
                        }
                    }
                    final bt bt2 = (bt)o;
                    bt2.f(n6);
                    bt2.e(n3);
                    return;
                }
                double max3 = Math.max(this.c() ? c.b(next) : c.a(next), max + max2);
                double n7 = max;
                double n8 = max2;
                final r f2 = c.f(next);
                Label_0376: {
                    if (f2 != null) {
                        final double c3 = c.c(f2);
                        final double d = c.d(f2);
                        n7 += c3;
                        n8 += d;
                        max3 += c3 + d;
                        this.e.put(next, new E(a2, c3, d));
                        if (j == 0) {
                            break Label_0376;
                        }
                    }
                    this.e.put(next, new E(a2, 0.0, 0.0));
                }
                f.b(a2, n7);
                f.c(a2, n8);
                f.a(a2, max3);
                final double n9 = n3;
                Label_0464: {
                    if (iterator.hasNext()) {
                        n3 += n2 + n7 - max + c.a(next) + n8 - max2;
                        n2 = 0.0;
                        if (j == 0) {
                            break Label_0464;
                        }
                    }
                    n3 = c.b();
                }
                Label_0557: {
                    if (a2 instanceof l) {
                        final l m = (l)a2;
                        final double a4 = c.a(next);
                        m.e(a4);
                        m.f(n3 - a4 - n8 + max2);
                        if (j == 0) {
                            break Label_0557;
                        }
                    }
                    final bt bt3 = (bt)a2;
                    final double a5 = c.a(next);
                    bt3.f(a5);
                    bt3.e(n3 - a5 - n8 + max2);
                }
                list.size();
                do {
                    int n10 = 0;
                    int n11 = 0;
                    while (n10 < n11) {
                        final q q = list.get(n4);
                        final double a6 = c.a(bu, q);
                        n10 = n5;
                        n11 = n + 1;
                        if (j == 0) {
                            if ((n10 != n11 && n9 > a6) || (iterator.hasNext() && a6 >= n3)) {
                                break;
                            }
                            map.put(q, a2);
                            ++n4;
                        }
                    }
                    break;
                } while (j == 0);
                ++n5;
                if (j != 0) {
                    break;
                }
            }
            final Object a3 = f.a(n5);
            continue;
        }
    }
    
    private static void a(final y.h.a.v v, final q q, final Collection collection) {
        final int h = a.H;
        final x p3 = v.p(q);
        while (p3.f()) {
            final q e = p3.e();
            Label_0072: {
                if (v.k(e) && v.p(e).f()) {
                    a(v, e, collection);
                    if (h == 0) {
                        break Label_0072;
                    }
                }
                collection.add(e);
            }
            p3.g();
            if (h != 0) {
                break;
            }
        }
    }
    
    private void a(final Collection collection, final C c, final B b) {
        final int h = y.h.b.a.H;
        double b2 = 0.0;
        double d = 0.0;
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.a(iterator.next(), c, b);
            if (b2 < b.b) {
                b2 = b.b;
            }
            if (d < b.d) {
                d = b.d;
                if (h != 0) {
                    return;
                }
                if (h != 0) {
                    break;
                }
                continue;
            }
        }
        b.b = b2;
        b.d = d;
    }
    
    private void a(final Object o, final C c, final B b) {
        final int h = y.h.b.a.H;
        final r c2 = c.c(o);
        if (c.d(o) == 0) {
            b.e.add(o);
            b.f.put(o, c.a(b.a, b.c));
            b.b = c.a(c2);
            b.d = c.b(c2);
            if (h == 0) {
                return;
            }
        }
        double b2 = 0.0;
        double d = 0.0;
        final double a = b.a;
        final double c3 = b.c;
        int n = 1;
        final Iterator iterator = c.e(o).iterator();
        while (true) {
            while (iterator.hasNext()) {
                final Object next = iterator.next();
                Label_0176: {
                    if (n != 0) {
                        b.a = c.c(c2) + a;
                        n = 0;
                        if (h == 0) {
                            break Label_0176;
                        }
                    }
                    b.a = 0.0;
                }
                Label_0211: {
                    if (iterator.hasNext()) {
                        b.c = 0.0;
                        if (h == 0) {
                            break Label_0211;
                        }
                    }
                    b.c = c.d(c2) + c3;
                }
                this.a(next, c, b);
                if (b2 < b.b) {
                    b2 = b.b;
                }
                if (d < b.d) {
                    d = b.d;
                    if (h != 0) {
                        b.d = c.b(c2) + d;
                        return;
                    }
                    if (h != 0) {
                        break;
                    }
                    continue;
                }
            }
            b.a = a;
            b.c = c3;
            b.b = c.a(c2) + b2;
            continue;
        }
    }
    
    public void d(final bu bu) {
        this.f(bu);
        this.e(bu);
    }
    
    public void e(final bu bu) {
        final int h = y.h.b.a.H;
        if (this.m != null) {
            final Iterator<a> iterator = this.m.iterator();
            while (iterator.hasNext()) {
                iterator.next().c(true);
                if (h != 0) {
                    return;
                }
                if (h != 0) {
                    break;
                }
            }
        }
        this.m = null;
    }
    
    public void f(final bu bu) {
        if (this.a != null) {
            this.h(bu);
            this.a = null;
        }
    }
    
    private void h(final bu bu) {
        final int h = y.h.b.a.H;
        final boolean b = !this.b();
        final double n = b ? this.g.a(0).e() : this.g.b(0).e();
        final y.c.D d = b ? this.g.e() : this.g.f();
        if (!this.a.a().isEmpty()) {
            d.remove(d.size() - 1);
            d.remove(d.size() - 1);
        }
    Label_0872:
        while (true) {
        Label_0855:
            for (final i i : this.a.b()) {
                final q a = this.a.a(i);
                Label_0754: {
                    if (b) {
                        final List e = this.h.get(i).e;
                        final int size = e.size();
                        final a b2 = b(bu, a);
                        final double t = b2.t();
                        if (t < n) {
                            final f f = e.get(0);
                            final E e2 = this.e.get(f);
                            this.e.put(f, new E(e2.a, e2.b - n + t, e2.c));
                        }
                        p p = d.k();
                        int j = 0;
                        while (j < size + 1) {
                            p = p.a();
                            ++j;
                            if (h != 0) {
                                continue Label_0872;
                            }
                            if (h != 0) {
                                break;
                            }
                        }
                        double n2 = 0.0;
                        while (p != null) {
                            n2 += ((bt)p.c()).e();
                            p = p.a();
                            if (h != 0) {
                                continue Label_0872;
                            }
                            if (h != 0) {
                                break;
                            }
                        }
                        final double u = b2.u();
                        if (u >= n2) {
                            break Label_0754;
                        }
                        final f f2 = e.get(size - 1);
                        final E e3 = this.e.get(f2);
                        this.e.put(f2, new E(e3.a, e3.b, e3.c - n2 + u));
                        if (h == 0) {
                            break Label_0754;
                        }
                    }
                    final List e4 = this.i.get(i).e;
                    final int size2 = e4.size();
                    final a b3 = b(bu, a);
                    final double v = b3.v();
                    if (v < n) {
                        final y.h.b.c c = e4.get(0);
                        final E e5 = this.e.get(c);
                        this.e.put(c, new E(e5.a, e5.b - n + v, e5.c));
                    }
                    p p2 = d.k();
                    int k = 0;
                    while (k < size2 + 1) {
                        p2 = p2.a();
                        ++k;
                        if (h != 0) {
                            continue Label_0872;
                        }
                        if (h != 0) {
                            break;
                        }
                    }
                    double n3 = 0.0;
                    while (p2 != null) {
                        n3 += ((l)p2.c()).e();
                        p2 = p2.a();
                        if (h != 0) {
                            continue Label_0872;
                        }
                        if (h != 0) {
                            break;
                        }
                    }
                    final double w = b3.w();
                    if (w < n3) {
                        final y.h.b.c c2 = e4.get(size2 - 1);
                        final E e6 = this.e.get(c2);
                        this.e.put(c2, new E(e6.a, e6.b, e6.c - n3 + w));
                    }
                }
                Iterator iterator2 = i.o().iterator();
                while (true) {
                    while (iterator2.hasNext()) {
                        this.a(iterator2.next());
                        if (h != 0) {
                            while (iterator2.hasNext()) {
                                this.a((y.h.b.c)iterator2.next());
                                if (h != 0 || h != 0) {
                                    break Label_0872;
                                }
                                if (h != 0) {
                                    break Label_0855;
                                }
                            }
                            continue Label_0872;
                        }
                        if (h != 0) {
                            break;
                        }
                    }
                    iterator2 = i.l().iterator();
                    continue;
                }
                if (this.c != null) {
                    bu.a(bk.a, this.c);
                    this.c = null;
                }
                bu.d_(bk.b);
                bu.a(this.b);
                this.b = null;
                if (this.d != null) {
                    bu.a(bk.b, this.d);
                    this.d = null;
                }
                return;
            }
            this.i = null;
            this.h = null;
            bu.d_(bk.a);
            continue Label_0872;
        }
    }
    
    private void a(final f f) {
        final int h = y.h.b.a.H;
        if (f.n() == 0) {
            final E e = this.e.get(f);
            f.b(((bt)e.a).e() - e.b - e.c);
            if (h == 0) {
                return;
            }
        }
        double n = 0.0;
        for (final f f2 : f.o()) {
            this.a(f2);
            n += f2.g();
            if (h != 0) {
                return;
            }
            if (h != 0) {
                break;
            }
        }
        f.b(f.i().a + n + f.i().c);
    }
    
    private void a(final y.h.b.c c) {
        final int h = y.h.b.a.H;
        if (c.k() == 0) {
            final E e = this.e.get(c);
            c.b(((l)e.a).e() - e.b - e.c);
            if (h == 0) {
                return;
            }
        }
        double n = 0.0;
        for (final y.h.b.c c2 : c.l()) {
            this.a(c2);
            n += c2.g();
            if (h != 0) {
                return;
            }
            if (h != 0) {
                break;
            }
        }
        c.b(c.i().b + n + c.i().d);
    }
    
    private static a b(final bu bu, final q q) {
        return (a)c(bu, q);
    }
    
    private static fj c(final bu bu, final q q) {
        return aa.a(bu, q);
    }
    
    static Map a(final v v) {
        return v.h;
    }
    
    static Map b(final v v) {
        return v.i;
    }
    
    static fj a(final bu bu, final q q) {
        return c(bu, q);
    }
}
