package y.f.i;

import java.awt.geom.*;
import y.d.*;
import y.c.*;
import y.f.*;
import y.g.*;
import java.util.*;

public class X extends a
{
    private int a;
    
    public X(final ah ah) {
        this.a = 1000;
        this.a(ah);
    }
    
    public int b() {
        return this.a;
    }
    
    public void c(final y.f.X x) {
        final int f = v.f;
        final v c = this.c();
        if (c == null) {
            throw new IllegalStateException("No OrthogonalEdgeRouter in coreLayouter");
        }
        if (!this.a(x, c)) {
            this.a().c(x);
            return;
        }
        final A t = x.t();
        int size = Integer.MAX_VALUE;
        while (true) {
            int i = 0;
            int min;
            while (i <= Math.max(i = (min = Math.min(this.b() / 4, 200)), 2000)) {
                final int n = x.e() / this.a(x, t, i);
                final Set a;
                final Set set = a = this.a(x, t);
                if (f != 0) {
                    final Set<Rectangle2D> set2 = (Set<Rectangle2D>)a;
                    final A t2 = x.t();
                    final h u = x.u();
                    final f f2 = new f();
                    final y y = new y();
                    final e p = x.p();
                    while (p.f()) {
                        final d a2 = p.a();
                        if (t.a(a2.c()) != t.a(a2.d())) {
                            u.a(a2, true);
                            f2.add(a2);
                            t2.a(a2.c(), true);
                            t2.a(a2.d(), true);
                        }
                        p.g();
                        if (f != 0) {
                            break;
                        }
                    }
                    final I j = new I(x);
                    final e p2 = x.p();
                    while (p2.f()) {
                        if (!u.d(p2.a())) {
                            j.a(p2.a());
                        }
                        p2.g();
                        if (f != 0) {
                            break;
                        }
                    }
                    final I k = new I(x);
                    final x o = x.o();
                    while (o.f()) {
                        if (!t2.d(o.e())) {
                            k.a(o.e());
                        }
                        o.g();
                        if (f != 0) {
                            break;
                        }
                    }
                    ArrayList list = null;
                    Label_0583: {
                        if (set2 != null) {
                            list = new ArrayList<Object>(set2.size());
                            for (final Rectangle2D rectangle2D : set2) {
                                final q d = x.d();
                                list.add(d);
                                x.b(d, rectangle2D.getWidth(), rectangle2D.getHeight());
                                x.c(d, rectangle2D.getX(), rectangle2D.getY());
                                if (f != 0) {
                                    break Label_0583;
                                }
                                if (f != 0) {
                                    break;
                                }
                            }
                        }
                        this.a().c(x);
                    }
                    Label_0641: {
                        if (list != null) {
                            final Iterator<q> iterator2 = (Iterator<q>)list.iterator();
                            while (iterator2.hasNext()) {
                                x.a(iterator2.next());
                                if (f != 0) {
                                    break Label_0641;
                                }
                                if (f != 0) {
                                    break;
                                }
                            }
                        }
                        k.f();
                        j.f();
                    }
                    final byte p3 = c.p();
                    final Object c2 = c.c();
                    final c c3 = x.c(c2);
                    c.b((byte)2);
                    x.a(c2, y.g.q.a(u));
                    final J l = new J(x, t);
                    l.a();
                    final y y2 = new y();
                    final f f3 = new f();
                    int n2 = 0;
                    while (true) {
                        while (n2 < i) {
                            final Integer n3 = new Integer(n2);
                            l.b(n3);
                            this.a(f3, y2, f2, x);
                            this.a().c(x);
                            this.a(f3, y2, x);
                            l.a(n3);
                            ++n2;
                            if (f != 0) {
                                Label_0818: {
                                    if (c3 != null) {
                                        x.a(c2, c3);
                                        if (f == 0) {
                                            break Label_0818;
                                        }
                                    }
                                    x.d_(c2);
                                }
                                c.b(p3);
                                x.a(u);
                                x.a(t2);
                                x.a(t);
                                return;
                            }
                            if (f != 0) {
                                break;
                            }
                        }
                        l.b();
                        continue;
                    }
                }
                if (a != null && set.size() < size && n < size) {
                    size = set.size();
                    min = i;
                }
                i *= (int)2.0;
                if (f != 0) {
                    break;
                }
            }
            i = this.a(x, t, min);
            this.a(x, t);
            continue;
        }
    }
    
    v c() {
        final int f = v.f;
        ah ah = this.a();
        while (ah instanceof ad) {
            if (ah instanceof v) {
                return (v)ah;
            }
            ah = ((v)ah).a();
            if (f != 0) {
                break;
            }
        }
        return null;
    }
    
    void a(final f f, final y y, final y.f.X x) {
        final int f2 = v.f;
        while (!f.isEmpty()) {
            x.d(f.d());
            if (f2 != 0) {
                return;
            }
            if (f2 != 0) {
                break;
            }
        }
        while (!y.isEmpty()) {
            x.c(y.d());
            if (f2 != 0) {
                break;
            }
        }
    }
    
    void a(final f f, final y y, final f f2, final y.f.X x) {
        final int i = v.f;
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        f.clear();
        y.clear();
        final Rectangle2D a = ae.a(x, x.o());
        a.setFrame(a.getX() - 10.0, a.getY() - 10.0, a.getWidth() + 20.0, a.getHeight() + 20.0);
        final e a2 = f2.a();
        do {
            Label_0081: {
                a2.f();
            }
            boolean contains = false;
            Label_0088:
            while (contains) {
                final d a3 = a2.a();
                final C m = x.m(a3).m();
                while (m.f()) {
                    final t t = (t)m.d();
                    contains = a.contains(t.a, t.b);
                    if (i != 0) {
                        continue Label_0088;
                    }
                    if (contains) {
                        f.add(a3);
                        if (a3.c().e() == null) {
                            x.d(a3.c());
                            y.add(a3.c());
                        }
                        if (a3.d().e() == null) {
                            x.d(a3.d());
                            y.add(a3.d());
                        }
                        x.e(a3);
                        if (i == 0) {
                            break;
                        }
                    }
                    m.g();
                    if (i != 0) {
                        break;
                    }
                }
                final am h = x.h(a3.c());
                double1.setFrame(h.getX(), h.getY(), h.getWidth(), h.getHeight());
                if (a3.c().e() == null && a.intersects(double1)) {
                    x.d(a3.c());
                    y.add(a3.c());
                }
                final am h2 = x.h(a3.d());
                double1.setFrame(h2.getX(), h2.getY(), h2.getWidth(), h2.getHeight());
                if (a3.d().e() == null && a.intersects(double1)) {
                    x.d(a3.d());
                    y.add(a3.d());
                }
                a2.g();
                continue Label_0081;
            }
            break;
        } while (i == 0);
    }
    
    int a(final y.f.X x, final A a, final int n) {
        final q[] m = x.m();
        return this.a(a, n, m, 0, m.length, new aa(x, true), new aa(x, false), true, 0);
    }
    
    int a(final A a, final int n, final q[] array, final int n2, final int n3, final Comparator comparator, final Comparator comparator2, final boolean b, int n4) {
        final int f = v.f;
        final int n5 = n3 - n2 - 1;
        Label_0064: {
            if (n5 < n) {
                int i = n2;
                while (true) {
                    while (i < n3) {
                        a.a(array[i], n4);
                        ++i;
                        if (f == 0) {
                            if (f != 0) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (f != 0) {
                                break Label_0064;
                            }
                            return n4;
                        }
                    }
                    ++n4;
                    continue;
                }
            }
        }
        y.g.e.a(array, n2, n3, b ? comparator : comparator2);
        n4 = this.a(a, n, array, n2, n2 + n5 / 2, comparator, comparator2, !b, n4);
        n4 = this.a(a, n, array, n2 + n5 / 2, n3, comparator, comparator2, !b, n4);
        return n4;
    }
    
    double b(final y.f.X x) {
        final int f = v.f;
        double n = 0.0;
        if (x.i()) {
            return 0.0;
        }
        final x o = x.o();
        double n2 = 0.0;
        while (o.f()) {
            n2 = n + x.p(o.e()) + x.q(o.e());
            if (f != 0) {
                return n2;
            }
            n = n2;
            o.g();
            if (f != 0) {
                break;
            }
        }
        final double n3 = n / (2.0 * x.e());
        return n2;
    }
    
    Set a(final y.f.X x, final c c) {
        final int f = v.f;
        final double b = this.b(x);
        final A a = M.a(new boolean[x.e()]);
        final e p2 = x.p();
        while (p2.f()) {
            final d a2 = p2.a();
            if (c.a(a2.c()) != c.a(a2.d())) {
                a.a(a2.c(), true);
                a.a(a2.d(), true);
            }
            p2.g();
            if (f != 0) {
                break;
            }
        }
        final Set a3 = this.a(x, a, b);
        if (a3 == null) {
            return null;
        }
        double n = b;
        double n2 = a3.size();
        double n3 = b / 2.0;
        Set a4 = null;
        while (n3 > 10.0) {
            final Set set = a4 = this.a(x, a, n3);
            if (f != 0) {
                return a4;
            }
            if (a4 != null && set.size() < n2) {
                n2 = set.size();
                n = n3;
            }
            n3 /= 2.0;
            if (f != 0) {
                break;
            }
        }
        double n4 = b * 2.0;
        while (n4 < 1000.0) {
            final Set a5;
            final Set set2 = a5 = this.a(x, a, n4);
            if (f != 0) {
                return a4;
            }
            if (a5 != null && set2.size() < n2) {
                n2 = set2.size();
                n = n4;
            }
            n4 *= 2.0;
            if (f != 0) {
                break;
            }
        }
        this.a(x, a, n);
        return a4;
    }
    
    Set a(final y.f.X x, final c c, final double n) {
        final int i = v.f;
        final HashSet set = new HashSet<Rectangle2D.Double>();
        final HashSet set2 = new HashSet<Rectangle2D>();
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        x x2 = x.o();
        while (true) {
        Label_0240_Outer:
            while (x2.f()) {
                final q e = x2.e();
                final boolean d = c.d(e);
                boolean d2 = false;
                Label_0472: {
                Label_0308_Outer:
                    while (true) {
                        if (i != 0) {
                            break Label_0240;
                        }
                    Label_0308:
                        while (true) {
                            if (d) {
                                final double n2 = x.m(e);
                                final double n3 = x.n(e);
                                final double n4 = x.p(e);
                                final double n5 = x.q(e);
                                double n6 = (int)(n2 / n) * n;
                                do {
                                    double contains = 0.0;
                                    Label_0115: {
                                        contains = dcmpg(n6, n2 + n4);
                                    }
                                    Label_0123:
                                    while (contains < 0) {
                                        final double n7 = (int)(n3 / n) * n;
                                        if (i == 0) {
                                            double n8 = n7;
                                            while (n8 < n3 + n5) {
                                                double1.setFrame(n6, n8, n, n);
                                                final int n9 = (int)(contains = (set2.contains(double1) ? 1 : 0));
                                                if (i != 0) {
                                                    continue Label_0123;
                                                }
                                                if (n9 == 0) {
                                                    set2.add(double1.getBounds2D());
                                                }
                                                n8 += n;
                                                if (i != 0) {
                                                    break;
                                                }
                                            }
                                            n6 += n;
                                            continue Label_0115;
                                        }
                                        break Label_0308;
                                    }
                                    break;
                                } while (i == 0);
                            }
                            x2.g();
                            if (i != 0) {
                                break;
                            }
                            continue Label_0240_Outer;
                            while (true) {
                                final double n7;
                                double n10 = n7;
                                do {
                                    final double n2;
                                    final double n4;
                                    double contains2 = 0.0;
                                    Label_0310: {
                                        contains2 = dcmpg(n10, n2 + n4);
                                    }
                                    Label_0318:
                                    while (contains2 < 0) {
                                        final double n3;
                                        final double n11 = (int)(n3 / n) * n;
                                        if (i == 0) {
                                            double n12 = n11;
                                            final double n5;
                                            while (n12 < n3 + n5) {
                                                double1.setFrame(n10, n12, n, n);
                                                final int n13 = (int)(contains2 = (set2.contains(double1) ? 1 : 0));
                                                if (i != 0) {
                                                    continue Label_0318;
                                                }
                                                if (n13 != 0) {
                                                    double1.setFrame(n2, n3, n4, n5);
                                                    set.add((Rectangle2D.Double)double1.getBounds2D());
                                                    if (i == 0) {
                                                        break Label_0308;
                                                    }
                                                }
                                                if (!set.contains(double1)) {
                                                    set.add((Rectangle2D.Double)double1.getBounds2D());
                                                }
                                                n12 += n;
                                                if (i != 0) {
                                                    break;
                                                }
                                            }
                                            n10 += n;
                                            continue Label_0310;
                                        }
                                        continue Label_0308;
                                    }
                                    break;
                                } while (i == 0);
                                break Label_0308;
                            }
                            if (!d) {
                                break Label_0308_Outer;
                            }
                            final q e2 = x2.e();
                            d2 = c.d(e2);
                            if (i != 0) {
                                break Label_0472;
                            }
                            if (!d2) {
                                final double n2 = x.m(e2);
                                final double n3 = x.n(e2);
                                final double n4 = x.p(e2);
                                final double n5 = x.q(e2);
                                final double n14 = (int)(n2 / n) * n;
                                continue Label_0308;
                            }
                            break;
                        }
                        x2.g();
                        if (i == 0) {
                            x2.f();
                            continue Label_0308_Outer;
                        }
                        break;
                    }
                    set.isEmpty();
                }
                if (d2) {
                    return null;
                }
                Rectangle2D.Double[] array = set.toArray(new Rectangle2D.Double[set.size()]);
                y.g.e.a(array, new Y(this));
                Rectangle2D.Double double2 = array[0];
                int j = 1;
                while (true) {
                    while (j < array.length) {
                        final Rectangle2D.Double double3 = array[j];
                        final double n15 = dcmpl(double2.getMaxX(), double3.getMinX());
                        if (i != 0) {
                            double n16 = n15;
                            while (n16 < array.length) {
                                final Rectangle2D.Double double4 = array[n16];
                                Label_0818: {
                                    if (double2.getMaxY() == double4.getMinY() && double2.getMinX() == double4.getMinX() && double2.getMaxX() == double4.getMaxX()) {
                                        set.remove(double2);
                                        set.remove(double4);
                                        double2.setFrame(double2.x, double2.y, double2.width, double2.height + double4.height);
                                        set.add(double2);
                                        if (i == 0) {
                                            break Label_0818;
                                        }
                                    }
                                    double2 = double4;
                                }
                                ++n16;
                                if (i != 0) {
                                    break;
                                }
                            }
                            return set;
                        }
                        Label_0639: {
                            if (n15 == 0 && double2.getMinY() == double3.getMinY()) {
                                set.remove(double2);
                                set.remove(double3);
                                double2.setFrame(double2.x, double2.y, double2.width + double3.width, double2.height);
                                set.add(double2);
                                if (i == 0) {
                                    break Label_0639;
                                }
                            }
                            double2 = double3;
                        }
                        ++j;
                        if (i != 0) {
                            break;
                        }
                    }
                    array = set.toArray(new Rectangle2D.Double[set.size()]);
                    y.g.e.a(array, new Z(this));
                    double2 = array[0];
                    continue;
                }
            }
            x2 = x.o();
            continue;
        }
    }
    
    boolean a(final y.f.X x, final v v) {
        return v.p() == 0 && x.e() + x.g() >= this.b();
    }
}
