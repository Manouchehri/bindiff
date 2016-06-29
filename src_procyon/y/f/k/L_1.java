package y.f.k;

import y.a.*;
import y.g.*;
import java.util.*;
import y.d.*;
import java.awt.geom.*;
import y.f.*;
import y.c.*;
import java.awt.*;

public class L implements ad
{
    public static final Object a;
    private ah b;
    private ah c;
    private boolean d;
    
    public L(final ah c) {
        this.c = c;
    }
    
    public void c(final X x) {
        final int i = y.f.k.d.g;
        final y[] a = A.a(x);
        if (a.length == 1 && a[0].size() == x.f()) {
            if (g.e(x)) {
                this.c.c(x);
                if (i == 0) {
                    return;
                }
            }
            new aN(this.c).c(x);
            return;
        }
        if (g.d(x)) {
            this.c.c(x);
            return;
        }
        final e p = x.p();
        while (true) {
        Label_0231_Outer:
            while (p.f()) {
                final X x2 = x;
                if (i == 0) {
                    x.c(p.a());
                    p.g();
                    if (i != 0) {
                        break;
                    }
                    continue;
                }
                else {
                    final y[] a2 = A.a(x2);
                    final e p2 = x.p();
                    while (true) {
                    Label_0807_Outer:
                        while (p2.f()) {
                            x.c(p2.a());
                            p2.g();
                            if (i != 0) {
                                final I j = new I(x);
                                final HashSet<q> set = new HashSet<q>();
                                final f[] a3 = A.a(x, a);
                                final ArrayList list = new ArrayList<N>();
                                j.a();
                                int n = 0;
                            Label_0807:
                                while (true) {
                                    do {
                                        int k = 0;
                                    Label_0276:
                                        while (k < a.length) {
                                            final y d = a[n];
                                            final f f = a3[n];
                                            d.b();
                                            final int size = d.size();
                                            final int n2 = 2;
                                            if (i != 0) {
                                            Label_0892_Outer:
                                                while (true) {
                                                    if (size < n2) {
                                                        final x a4 = list.get(n).d.a();
                                                        a4.g();
                                                        while (true) {
                                                            while (a4.f()) {
                                                                j.a(a4.e());
                                                                a4.g();
                                                                if (i == 0) {
                                                                    if (i != 0) {
                                                                        break;
                                                                    }
                                                                    continue Label_0231_Outer;
                                                                }
                                                                else {
                                                                    if (i != 0) {
                                                                        break Label_0892_Outer;
                                                                    }
                                                                    break Label_0807;
                                                                }
                                                            }
                                                            Label_0889: {
                                                                break Label_0889;
                                                                list.size();
                                                                continue Label_0892_Outer;
                                                            }
                                                            ++n;
                                                            continue Label_0807_Outer;
                                                        }
                                                    }
                                                    break;
                                                }
                                                this.a(x, new M(set));
                                                j.f();
                                                int n3 = 0;
                                                int n4 = 0;
                                                int n5 = 0;
                                                while (true) {
                                                    do {
                                                        int l = 0;
                                                    Label_0931:
                                                        while (l < list.size()) {
                                                            final N n6 = list.get(n5);
                                                            final t sourcePoint = x.b((Object)n6.b).getSourcePoint();
                                                            final y.f.I b = x.b((Object)n6.b);
                                                            final int pointCount = b.pointCount();
                                                            if (i != 0) {
                                                                Label_2531: {
                                                                    if (pointCount != 0 && (n3 < 0 || n4 < 0)) {
                                                                        final x o = x.o();
                                                                    Label_2139:
                                                                        while (o.f()) {
                                                                            final q e = o.e();
                                                                            final am a5 = x.a((Object)e);
                                                                            if (i == 0) {
                                                                                if (n3 < 0) {
                                                                                    a5.setLocation(-a5.getX() - a5.getWidth(), a5.getY());
                                                                                }
                                                                                if (n4 < 0) {
                                                                                    a5.setLocation(a5.getX(), -a5.getY() - a5.getHeight());
                                                                                }
                                                                                final e m = e.l();
                                                                                while (true) {
                                                                                    while (m.f()) {
                                                                                        final y.c.d a6 = m.a();
                                                                                        final y.f.I b2 = x.b((Object)a6);
                                                                                        final t sourcePoint2 = b2.getSourcePoint();
                                                                                        if (i == 0) {
                                                                                            b2.setSourcePoint(new t((n3 < 0) ? (-sourcePoint2.a) : sourcePoint2.a, (n4 < 0) ? (-sourcePoint2.b) : sourcePoint2.b));
                                                                                            final t targetPoint = b2.getTargetPoint();
                                                                                            b2.setTargetPoint(new t((n3 < 0) ? (-targetPoint.a) : targetPoint.a, (n4 < 0) ? (-targetPoint.b) : targetPoint.b));
                                                                                            final D k2 = x.k(a6);
                                                                                            k2.k();
                                                                                        Label_2415:
                                                                                            while (true) {
                                                                                                p p3 = null;
                                                                                                p a7 = p3;
                                                                                                while (a7 != null) {
                                                                                                    final t t = (t)a7.c();
                                                                                                    p3 = a7;
                                                                                                    if (i != 0) {
                                                                                                        continue Label_2415;
                                                                                                    }
                                                                                                    p3.a(new t((n3 < 0) ? (-t.a) : t.a, (n4 < 0) ? (-t.b) : t.b));
                                                                                                    a7 = a7.a();
                                                                                                    if (i != 0) {
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                                break;
                                                                                            }
                                                                                            x.b(a6, k2);
                                                                                            m.g();
                                                                                            if (i != 0) {
                                                                                                break;
                                                                                            }
                                                                                            continue Label_0231_Outer;
                                                                                        }
                                                                                        else {
                                                                                            if (i != 0) {
                                                                                                break Label_2531;
                                                                                            }
                                                                                            continue Label_2139;
                                                                                        }
                                                                                    }
                                                                                    o.g();
                                                                                    continue;
                                                                                }
                                                                            }
                                                                            return;
                                                                        }
                                                                    }
                                                                }
                                                                list.clear();
                                                                return;
                                                            }
                                                            boolean b3 = false;
                                                            Label_1123: {
                                                                if (pointCount > 0) {
                                                                    final t p4 = x.p(n6.b);
                                                                    final t point = b.getPoint(0);
                                                                    b3 = (Math.abs(p4.a - point.a) > Math.abs(p4.b - point.b));
                                                                    if (i == 0) {
                                                                        break Label_1123;
                                                                    }
                                                                }
                                                                final t p5 = x.p(n6.b);
                                                                final t q = x.q(n6.b);
                                                                b3 = (Math.abs(p5.a - q.a) > Math.abs(p5.b - q.b));
                                                            }
                                                            final am a8 = x.a((Object)n6.a);
                                                            final double centerX = n6.c.getCenterX();
                                                            final double centerY = n6.c.getCenterY();
                                                            final double n7 = a8.getX() + a8.getWidth() / 2.0;
                                                            final double n8 = a8.getY() + a8.getHeight() / 2.0;
                                                            final x a9 = n6.d.a();
                                                            x.a((Object)a9.e());
                                                            final int n9 = (x.q(n6.b).a < x.p(n6.b).a) ? 1 : 0;
                                                            final boolean b4 = x.q(n6.b).b < x.p(n6.b).b;
                                                            x.a(n6.b);
                                                            n3 += ((n9 != 0) ? (-n6.d.size()) : n6.d.size());
                                                            n4 += (b4 ? (-n6.d.size()) : n6.d.size());
                                                            a9.g();
                                                            while (a9.f()) {
                                                                final am a10 = x.a((Object)a9.e());
                                                                double n10 = a10.getX() + a10.getWidth() / 2.0;
                                                                double n11 = a10.getY() + a10.getHeight() / 2.0;
                                                                l = n9;
                                                                if (i != 0) {
                                                                    continue Label_0931;
                                                                }
                                                                Label_1465: {
                                                                    if (l != 0) {
                                                                        n10 = n7 - (n10 - centerX);
                                                                        if (i == 0) {
                                                                            break Label_1465;
                                                                        }
                                                                    }
                                                                    n10 = n7 + (n10 - centerX);
                                                                }
                                                                Label_1495: {
                                                                    if (b4) {
                                                                        n11 = n8 - (n11 - centerY);
                                                                        if (i == 0) {
                                                                            break Label_1495;
                                                                        }
                                                                    }
                                                                    n11 = n8 + (n11 - centerY);
                                                                }
                                                                a10.setLocation(n10 - a10.getWidth() / 2.0, n11 - a10.getHeight() / 2.0);
                                                                a9.g();
                                                                if (i != 0) {
                                                                    break;
                                                                }
                                                            }
                                                            final ArrayList<Object> list2 = new ArrayList<Object>(6);
                                                            final e a11 = n6.e.a();
                                                        Label_2099:
                                                            while (a11.f()) {
                                                                list2.clear();
                                                                final y.f.I b5 = x.b((Object)a11.a());
                                                                list2.clear();
                                                                final int n12 = 0;
                                                                if (i == 0) {
                                                                    int n13 = n12;
                                                                    while (true) {
                                                                        while (n13 < b5.pointCount()) {
                                                                            final t point2 = b5.getPoint(n13);
                                                                            double a12 = point2.a;
                                                                            double b6 = point2.b;
                                                                            final int n14 = n9;
                                                                            if (i == 0) {
                                                                                Label_1680: {
                                                                                    if (n14 != 0) {
                                                                                        a12 = n7 - (a12 - centerX);
                                                                                        if (i == 0) {
                                                                                            break Label_1680;
                                                                                        }
                                                                                    }
                                                                                    a12 = n7 + (a12 - centerX);
                                                                                }
                                                                                Label_1710: {
                                                                                    if (b4) {
                                                                                        b6 = n8 - (b6 - centerY);
                                                                                        if (i == 0) {
                                                                                            break Label_1710;
                                                                                        }
                                                                                    }
                                                                                    b6 = n8 + (b6 - centerY);
                                                                                }
                                                                                list2.add(new t(a12, b6));
                                                                                ++n13;
                                                                                if (i != 0) {
                                                                                    break;
                                                                                }
                                                                                continue Label_0231_Outer;
                                                                            }
                                                                            else {
                                                                                int n15 = n14;
                                                                            Label_2087_Outer:
                                                                                while (true) {
                                                                                    while (true) {
                                                                                        while (n15 < list2.size()) {
                                                                                            final t t2 = list2.get(n15);
                                                                                            b5.addPoint(t2.a, t2.b);
                                                                                            ++n15;
                                                                                            if (i == 0) {
                                                                                                if (i != 0) {
                                                                                                    break;
                                                                                                }
                                                                                                continue Label_0231_Outer;
                                                                                            }
                                                                                            else {
                                                                                                final t sourcePoint3 = b5.getSourcePoint();
                                                                                                b5.setSourcePoint(new t((n9 != 0) ? (-sourcePoint3.a) : sourcePoint3.a, b4 ? (-sourcePoint3.b) : sourcePoint3.b));
                                                                                                a11.g();
                                                                                                if (i != 0) {
                                                                                                    break Label_2099;
                                                                                                }
                                                                                                continue Label_2099;
                                                                                            }
                                                                                        }
                                                                                        if (a11.a().c() == n6.d.b()) {
                                                                                            final t targetPoint2 = b5.getTargetPoint();
                                                                                            b5.setTargetPoint(new t((n9 != 0) ? (-targetPoint2.a) : targetPoint2.a, b4 ? (-targetPoint2.b) : targetPoint2.b));
                                                                                            b5.setSourcePoint(sourcePoint);
                                                                                            final t p6 = x.p(a11.a());
                                                                                            final t t3 = (b5.pointCount() > 0) ? b5.getPoint(0) : x.q(a11.a());
                                                                                            final D k3 = x.k(a11.a());
                                                                                            Label_2010: {
                                                                                                if (b3) {
                                                                                                    k3.a(new t(t3.a, p6.b));
                                                                                                    if (i == 0) {
                                                                                                        break Label_2010;
                                                                                                    }
                                                                                                }
                                                                                                k3.a(new t(p6.a, t3.b));
                                                                                            }
                                                                                            x.b(a11.a(), k3);
                                                                                            continue;
                                                                                        }
                                                                                        break;
                                                                                    }
                                                                                    continue Label_2087_Outer;
                                                                                }
                                                                            }
                                                                        }
                                                                        b5.clearPoints();
                                                                        continue;
                                                                    }
                                                                }
                                                                continue Label_0931;
                                                            }
                                                            x.a(n6.a);
                                                            ++n5;
                                                        }
                                                        break;
                                                    } while (i == 0);
                                                    this.b();
                                                    continue;
                                                }
                                            }
                                            if (size > n2) {
                                                I.a(x, f.a());
                                                final Rectangle a13 = x.a();
                                                this.c.c(x);
                                                double n17;
                                                double n16 = n17 = Double.MAX_VALUE;
                                                double n19;
                                                double n18 = n19 = -1.7976931348623157E308;
                                                final x a14 = d.a();
                                                a14.g();
                                                while (a14.f()) {
                                                    final am a15 = x.a((Object)a14.e());
                                                    n17 = Math.min(n17, a15.getX());
                                                    n16 = Math.min(n16, a15.getY());
                                                    n19 = Math.max(n19, a15.getX() + a15.getWidth());
                                                    n18 = Math.max(n18, a15.getY() + a15.getHeight());
                                                    a14.g();
                                                    if (i != 0) {
                                                        continue Label_0807;
                                                    }
                                                    if (i != 0) {
                                                        break;
                                                    }
                                                }
                                                final e a16 = f.a();
                                            Label_0616:
                                                while (a16.f()) {
                                                    final y.f.I b7 = x.b((Object)a16.a());
                                                    k = 0;
                                                    if (i == 0) {
                                                        int n20 = k;
                                                        while (true) {
                                                            while (n20 < b7.pointCount()) {
                                                                final t point3 = b7.getPoint(n20);
                                                                n17 = Math.min(n17, point3.a);
                                                                n16 = Math.min(n16, point3.b);
                                                                n19 = Math.max(n19, point3.a);
                                                                n18 = Math.max(n18, point3.b);
                                                                ++n20;
                                                                if (i == 0) {
                                                                    if (i != 0) {
                                                                        break;
                                                                    }
                                                                    continue Label_0231_Outer;
                                                                }
                                                                else {
                                                                    if (i != 0) {
                                                                        break Label_0616;
                                                                    }
                                                                    continue Label_0616;
                                                                }
                                                            }
                                                            a16.g();
                                                            continue;
                                                        }
                                                    }
                                                    continue Label_0276;
                                                }
                                                d.a().g();
                                                final q d2 = x.d();
                                                set.add(d2);
                                                final am a17 = x.a((Object)d2);
                                                a17.setSize(n19 - n17, n18 - n16);
                                                a17.setLocation(a13.x, a13.y);
                                                final y.c.d a18 = x.a(d.b(), d2);
                                                j.a(d);
                                                j.a();
                                                final N n21 = new N();
                                                n21.b = a18;
                                                n21.a = d2;
                                                n21.c = new Rectangle2D.Double(n17, n16, n19 - n17, n18 - n16);
                                                n21.d = d;
                                                n21.e = a3[n];
                                                list.add(n21);
                                            }
                                            ++n;
                                        }
                                        break;
                                    } while (i == 0);
                                    j.f();
                                    n = 0;
                                    continue Label_0807;
                                }
                            }
                            if (i != 0) {
                                break;
                            }
                        }
                        if (a2.length == 1 && a2[0].size() == x.f()) {
                            if (g.e(x)) {
                                this.c.c(x);
                                if (i == 0) {
                                    return;
                                }
                            }
                            new aN(this.c).c(x);
                            return;
                        }
                        continue;
                    }
                }
            }
            final X x2 = x;
            continue;
        }
    }
    
    protected void a(final X x, final c c) {
        final ah a = this.a();
        x.a(L.a, c);
        a.c(x);
        x.d_(L.a);
    }
    
    public ah a() {
        return this.b;
    }
    
    public void a(final ah b) {
        this.b = b;
    }
    
    public boolean b() {
        return this.d;
    }
    
    public void a(final boolean d) {
        this.d = d;
    }
    
    static {
        a = "y.layout.tree.TreeComponentLayouter.DUMMY_NODE_DPKEY";
    }
}
