package y.f.c.a;

import y.d.*;
import java.util.*;
import y.f.*;
import java.awt.geom.*;
import y.c.*;

class bP
{
    private static final double a;
    private f b;
    private aV c;
    private aP d;
    private double e;
    private double f;
    
    public bP(final aV c, final aP d) {
        this.e = 10.0;
        this.f = 0.0;
        this.b = new f();
        this.c = c;
        this.d = d;
    }
    
    void a(final Map map) {
        final Number value = map.get("SameLayerEdgeSupport.minimumEdgeDistance");
        if (value instanceof Number) {
            this.a(value.doubleValue());
        }
        final Number value2 = map.get("SameLayerEdgeSupport.defaultThickness");
        if (value2 instanceof Number) {
            this.f = value2.doubleValue();
        }
    }
    
    public void a(final X x) {
        final boolean x2 = N.x;
        final e p = x.p();
        while (p.f()) {
            final d a = p.a();
            if (this.c.a(a.c()).j() == this.c.a(a.d()).j()) {
                this.a(x, a);
            }
            p.g();
            if (x2) {
                break;
            }
        }
    }
    
    public void a(final X x, final d d) {
        if (x.f(d)) {
            x.d(d);
        }
        this.d.b(d);
        this.b.add(d);
    }
    
    public void b(final X x, final d d) {
        if (!x.f(d)) {
            x.e(d);
        }
    }
    
    public void b(final X x) {
        final boolean x2 = N.x;
        p p = this.b.k();
        while (p != null) {
            this.b.h(p);
            this.b(x, (d)p.c());
            p = p.a();
            if (x2) {
                break;
            }
        }
    }
    
    public void a(final X x, final aV av, final c c, final q q, final am am, final aX ax, final double n, final boolean b) {
    }
    
    void a(final X x, final c c, final aQ aq, final aV av, final double n, final Map map) {
        final boolean x2 = N.x;
        final cB b = cB.b((i)x);
    Label_0387_Outer:
        for (final d d : aq.f()) {
            final A a = av.a(d);
            final I b2 = x.b((Object)d);
            final int pointCount = b2.pointCount();
            if (a.a() == 4) {
                double n2 = 0.0;
                double n3 = 0.0;
                if (map.containsKey(d)) {
                    final q q = map.get(d);
                    final an an = (an)av.a(q);
                    final am a2 = x.a((Object)q);
                    n2 = a2.getX() - an.c;
                    n3 = a2.getY() - an.b;
                }
                final ArrayList list = new ArrayList<t>(pointCount + 2);
                final t p6 = x.p(d);
                final t q2 = x.q(d);
                final double a3 = p6.a();
                final double a4 = q2.a();
                final double[] array = new double[2];
                if (b != null) {
                    b.a(x, d, (byte)0, array, true, a3 < a4);
                }
                final double n4 = array[1];
                Label_0520: {
                    Label_0392: {
                        if (a3 < a4) {
                            list.add(new t(p6.a(), p6.b() + n4 + n));
                            int i = 0;
                            while (true) {
                                while (i < pointCount) {
                                    final t point = b2.getPoint(i);
                                    list.add(new t(n2 + point.a(), n3 + point.b() + n4 + n));
                                    ++i;
                                    if (!x2) {
                                        if (x2) {
                                            break;
                                        }
                                        continue Label_0387_Outer;
                                    }
                                    else {
                                        if (x2) {
                                            break Label_0392;
                                        }
                                        break Label_0520;
                                    }
                                }
                                list.add(new t(q2.a(), q2.b() + n4 + n));
                                continue;
                            }
                        }
                    }
                    list.add(new t(q2.a(), q2.b() + n4 + n));
                    int j = pointCount - 1;
                    while (j >= 0) {
                        final t point2 = b2.getPoint(j);
                        list.add(new t(n2 + point2.a(), n3 + point2.b() + n4 + n));
                        --j;
                        if (x2) {
                            break Label_0520;
                        }
                        if (x2) {
                            break;
                        }
                    }
                    list.add(new t(p6.a(), p6.b() + n4 + n));
                }
                c.a(this.a(list));
                if (!x2) {
                    continue;
                }
            }
            if (pointCount >= 2) {
                final ArrayList list2 = new ArrayList<t>(pointCount);
                final double a5 = b2.getPoint(0).a();
                final double a6 = b2.getPoint(pointCount - 1).a();
                final double[] array2 = new double[2];
                if (b != null) {
                    b.a(x, d, (byte)0, array2, true, a5 < a6);
                }
                final double n5 = array2[1];
                Label_0756: {
                    Label_0695: {
                        if (a5 < a6) {
                            int k = 0;
                            while (k < pointCount) {
                                final t point3 = b2.getPoint(k);
                                list2.add(new t(point3.a(), point3.b() + n5));
                                ++k;
                                if (x2) {
                                    continue Label_0387_Outer;
                                }
                                if (x2) {
                                    break Label_0695;
                                }
                            }
                            break Label_0756;
                        }
                    }
                    int l = pointCount - 1;
                    while (l >= 0) {
                        final t point4 = b2.getPoint(l);
                        list2.add(new t(point4.a(), point4.b() + n5));
                        --l;
                        if (x2) {
                            continue Label_0387_Outer;
                        }
                        if (x2) {
                            break;
                        }
                    }
                }
                c.a(this.a(list2));
                if (x2) {
                    break;
                }
                continue;
            }
        }
    }
    
    private c a(final List list) {
        final boolean x = N.x;
        if (list.isEmpty()) {
            return null;
        }
        final c c = new c(-1.7976931348623157E308);
        final c c2 = new c(-1.7976931348623157E308);
        t t = null;
        for (final t t2 : list) {
            if (t != null) {
                final double min = Math.min(t.a(), t2.a());
                final double max = Math.max(t.a(), t2.a());
                if (min != max) {
                    final double n = (t.a() < t2.a()) ? t.b() : t2.b();
                    final double n2 = (t.a() < t2.a()) ? t2.b() : t.b();
                    c2.a(min, max, n, (n2 == n) ? 0.0 : ((n2 - n) / (max - min)));
                    c.a(c2);
                    c2.c(-1.7976931348623157E308, Double.MAX_VALUE, -1.7976931348623157E308);
                }
            }
            t = t2;
            if (x) {
                break;
            }
        }
        return c;
    }
    
    public int a(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        int n = 0;
        final ArrayList<Object> list = new ArrayList<Object>(120);
        int n2 = 0;
    Label_0783:
        do {
        Block_3:
            while (true) {
                int b = au.b();
                int i = 0;
            Label_0030:
                while (i < b) {
                    final aQ a = au.a(n2);
                    final int e;
                    final byte b2 = (byte)(e = a.e());
                    if (x2) {
                        return e;
                    }
                    if (b2 == 1) {
                        break Block_3;
                    }
                    list.clear();
                    p p4 = a.d().k();
                    while (p4 != null) {
                        final q q = (q)p4.c();
                        final aX a2 = av.a(q);
                        i = a2.e();
                        if (x2) {
                            continue Block_3;
                        }
                        if (i > 0) {
                            p p5 = a2.d();
                        Label_0717_Outer:
                            while (p5 != null) {
                                final d d = (d)p5.c();
                                final A a3 = av.a(d);
                                final byte a4;
                                final byte b3 = a4 = a3.a();
                                final int n3 = b = 4;
                                if (x2) {
                                    continue Label_0030;
                                }
                                Label_0741: {
                                    if (b3 != n3) {
                                        final q a5 = d.a(q);
                                        final aX a6 = av.a(a5);
                                        if (a6.b() == 0 || a6.b() == 12 || a6.b() == 13 || a6.b() == 15) {
                                            final int k = av.a(a5).k();
                                            if (k < list.size() && (a3.c() == null || a3.c().g() || a3.c().e() || a3.c().f()) && (a3.e() == null || a3.e().g() || a3.e().e() || a3.e().f())) {
                                                ++n;
                                                p p7;
                                                final p p6 = p7 = list.get(k);
                                                p p8 = p4;
                                                Label_0524: {
                                                    if (d.c() == a5) {
                                                        if (a3.c() == null || !a3.c().f()) {
                                                            p7 = p6.a();
                                                        }
                                                        if (a3.e() == null || !a3.e().e()) {
                                                            break Label_0524;
                                                        }
                                                        p8 = p8.a();
                                                        if (!x2) {
                                                            break Label_0524;
                                                        }
                                                    }
                                                    if (a3.e() == null || !a3.e().f()) {
                                                        p7 = p6.a();
                                                    }
                                                    if (a3.c() != null && a3.c().e()) {
                                                        p8 = p8.a();
                                                    }
                                                }
                                                int n4 = 0;
                                                int n5 = 0;
                                                while (true) {
                                                    while (p7 != p8) {
                                                        final q q2 = (q)p7.c();
                                                        n4 += q2.b();
                                                        n5 += q2.c();
                                                        final aX a7 = av.a(q2);
                                                        final int e2 = a7.e();
                                                        int n6 = 0;
                                                        Label_0719: {
                                                            if (!x2) {
                                                                if (e2 > 0) {
                                                                    p p9 = a7.d();
                                                                    while (p9 != null) {
                                                                        final d d2 = (d)p9.c();
                                                                        final int j = av.a(d2.a(q2)).k();
                                                                        n6 = k;
                                                                        if (x2) {
                                                                            break Label_0719;
                                                                        }
                                                                        Label_0691: {
                                                                            if (j < n6 || j > list.size()) {
                                                                                if (av.a(d2).j()) {
                                                                                    ++n4;
                                                                                    if (!x2) {
                                                                                        break Label_0691;
                                                                                    }
                                                                                }
                                                                                ++n5;
                                                                            }
                                                                        }
                                                                        p9 = p9.a();
                                                                        if (x2) {
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                                p7 = p7.a();
                                                                if (!x2) {
                                                                    continue Label_0717_Outer;
                                                                }
                                                            }
                                                            else {}
                                                        }
                                                        if (e2 != n6) {
                                                            a3.a(n4 < n5);
                                                        }
                                                        break Label_0741;
                                                    }
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                }
                                p5 = p5.a();
                                if (x2) {
                                    break;
                                }
                            }
                        }
                        list.add(p4);
                        p4 = p4.a();
                        if (x2) {
                            break;
                        }
                    }
                    break Block_3;
                }
                break Label_0783;
            }
            ++n2;
        } while (!x2);
        return n;
    }
    
    public void a(final X x, final cr cr, final aQ aq, final aV av, final boolean b, final double n) {
        final boolean x2 = N.x;
        final cB b2 = cB.b((i)x);
        p p6 = aq.d().k();
        while (p6 != null) {
            final q q = (q)p6.c();
        Label_0035:
            while (true) {
                q c = null;
                final q q2 = c;
                final aX a = av.a(q2);
                if (a.e() > 0) {
                    p p7 = a.d();
                    while (p7 != null) {
                        final d d = (d)p7.c();
                        c = d.c();
                        if (x2) {
                            continue Label_0035;
                        }
                        Label_0634: {
                            if (c == q2 && b == this.a(av, d)) {
                                double min = Double.MAX_VALUE;
                                double max = -1.7976931348623157E308;
                                final A a2 = av.a(d);
                                if (a2.a() != 4) {
                                    final aE c2 = a2.c();
                                    t t = null;
                                    Label_0292: {
                                        if (c2 != null && (c2.b() == 4 || c2.b() == 8)) {
                                            t = x.b((Object)d).getPoint(0);
                                            if (!x2) {
                                                break Label_0292;
                                            }
                                        }
                                        t = x.p(d);
                                        if (b) {
                                            if (!a(av.a(d.c()))) {
                                                break Label_0292;
                                            }
                                            min = t.b + n - this.a(av, d, true);
                                            if (!x2) {
                                                break Label_0292;
                                            }
                                        }
                                        if (a(av.a(d.c()))) {
                                            max = t.b + this.a(av, d, true);
                                        }
                                    }
                                    final aE e = a2.e();
                                    t t2 = null;
                                    Label_0457: {
                                        if (e != null && (e.b() == 4 || e.b() == 8)) {
                                            final I b3 = x.b((Object)d);
                                            t2 = b3.getPoint(b3.pointCount() - 1);
                                            if (!x2) {
                                                break Label_0457;
                                            }
                                        }
                                        t2 = x.q(d);
                                        if (b) {
                                            if (!a(av.a(d.d()))) {
                                                break Label_0457;
                                            }
                                            min = Math.min(min, t2.b + n - this.a(av, d, false));
                                            if (!x2) {
                                                break Label_0457;
                                            }
                                        }
                                        if (a(av.a(d.d()))) {
                                            max = Math.max(max, t2.b + this.a(av, d, false));
                                        }
                                    }
                                    final double a3 = this.a(x, av, d);
                                    final double[] array = new double[2];
                                    b2.a(x, d, (byte)0, array, true, t.a < t2.a);
                                    final cy a4 = cr.a(d, this.f, Math.max(a3, array[0] * 2.0), Math.max(a3, array[1] * 2.0), t.a, !b, t2.a, !b, !this.b(av, d), av.a(d).k().i());
                                    if (b) {
                                        a4.l = min;
                                        if (!x2) {
                                            break Label_0634;
                                        }
                                    }
                                    a4.k = max;
                                }
                            }
                        }
                        p7 = p7.a();
                        if (x2) {
                            break;
                        }
                    }
                    break;
                }
                break;
            }
            p6 = p6.a();
            if (x2) {
                break;
            }
        }
    }
    
    private static final boolean a(final aX ax) {
        return ax.b() == 0 || ax.b() == 5;
    }
    
    private final double a(final aV av, final d d, final boolean b) {
        final A a = av.a(d);
        final B k = a.k();
        if (k != null) {
            if (b) {
                return a.i() ? k.b() : k.a();
            }
            return a.i() ? k.a() : k.b();
        }
        else {
            if (b) {
                return a.i() ? 15.0 : 10.0;
            }
            return a.i() ? 10.0 : 15.0;
        }
    }
    
    private y.d.q a(final i i) {
        final y.c.c c = i.c(N.u);
        if (c == null) {
            return null;
        }
        return (y.d.q)c.b(i);
    }
    
    protected double a(final X x, final aV av, final d d) {
        double n = 0.0;
        final y.d.q a = this.a((i)x);
        if (a != null) {
            final byte b = av.a(d.c()).b();
            final byte b2 = av.a(d.d()).b();
            if (b == 15 || b2 == 15) {
                n = a.b * 0.5;
            }
        }
        final B k = av.a(d).k();
        return n + ((k != null) ? k.d() : this.e);
    }
    
    public Rectangle2D.Double a(final X x, final aV av, final q q, final q q2, final List list) {
        final boolean x2 = N.x;
        if (list.size() > 0) {
            final am a = x.a((Object)q);
            final am a2 = x.a((Object)q2);
            final cr cr = new cr();
            double n = 0.0;
            cr.a(0.0);
            cr.a(true);
            cr.b(Double.NaN);
            double n2 = Double.MAX_VALUE;
            double n3 = -1.7976931348623157E308;
            final cB b = cB.b((i)x);
            int i = 0;
            while (true) {
                while (i < list.size()) {
                    final d d = list.get(i);
                    final I b2 = x.b((Object)d);
                    b2.clearPoints();
                    final double a3 = this.a(x, av, d);
                    final double f = this.f;
                    final double[] array = new double[2];
                    y.d.q q3 = new y.d.q(0.0, 0.0);
                    final double[] array2 = new double[2];
                    y.d.q q4 = new y.d.q(0.0, 0.0);
                    if (!x2) {
                        Label_0893: {
                            if (d.c() == q) {
                                if (b != null) {
                                    q3 = b.a(x, d, (byte)0, array, true, true, (byte)2);
                                    q4 = b.a(x, d, (byte)0, array2, true, true, (byte)1);
                                }
                                final double n4 = a.getY() + a.getHeight() * 0.5 + b2.getSourcePoint().b;
                                final double n5 = a2.getY() + a2.getHeight() * 0.5 + b2.getTargetPoint().b;
                                double max = 0.0;
                                double max2 = 0.0;
                                Label_0376: {
                                    if (n4 >= n5) {
                                        max = Math.max(array[1], array2[1] - n4 + n5);
                                        max2 = -Math.max(array2[0], array[0] - n4 + n5);
                                        if (!x2) {
                                            break Label_0376;
                                        }
                                    }
                                    max = -Math.max(array[0], array2[0] - n5 + n4);
                                    max2 = Math.max(array2[1], array[1] - n5 + n4);
                                }
                                n2 = Math.min(n2, Math.min(n4 + max, n5 + max2));
                                n3 = Math.max(n3, Math.max(n4 + max, n5 + max2));
                                final B k = av.a(d).k();
                                final double n6 = k.i() / bP.a;
                                final double n7 = this.b(av, d) ? 0.0 : n6;
                                cr.a(d, f, Math.max(a3, q3.a) + n7, Math.max(a3, q4.a) + n7, n4 + max, true, n5 + max2, false, false, 0.0);
                                if (k == null) {
                                    break Label_0893;
                                }
                                n = Math.max(n, k.c() - Math.abs(n4 - n5));
                                if (!x2) {
                                    break Label_0893;
                                }
                            }
                            if (b != null) {
                                q3 = b.a(x, d, (byte)0, array, true, false, (byte)2);
                                q4 = b.a(x, d, (byte)0, array2, true, false, (byte)1);
                            }
                            final double n8 = a.getY() + a.getHeight() * 0.5 + b2.getTargetPoint().b;
                            final double n9 = a2.getY() + a2.getHeight() * 0.5 + b2.getSourcePoint().b;
                            double max3 = 0.0;
                            double max4 = 0.0;
                            Label_0733: {
                                if (n9 < n8) {
                                    max3 = -Math.max(array[0], array2[0] - n8 + n9);
                                    max4 = Math.max(array2[1], array[1] - n8 + n9);
                                    if (!x2) {
                                        break Label_0733;
                                    }
                                }
                                max3 = Math.max(array[1], array2[1] - n9 + n8);
                                max4 = -Math.max(array2[0], array[0] - n9 + n8);
                            }
                            n2 = Math.min(n2, Math.min(n9 + max3, n8 + max4));
                            n3 = Math.max(n3, Math.max(n9 + max3, n8 + max4));
                            final B j = av.a(d).k();
                            final double n10 = j.i() / bP.a;
                            final double n11 = this.b(av, d) ? 0.0 : n10;
                            cr.a(d, f, Math.max(a3, q4.a) + n11, Math.max(a3, q3.a) + n11, n8 + max4, true, n9 + max3, false, false, 0.0);
                            if (j != null) {
                                n = Math.max(n, j.c() - Math.abs(n9 - n8));
                            }
                        }
                        ++i;
                        if (x2) {
                            break;
                        }
                        continue;
                    }
                    else {
                        double min = Double.MAX_VALUE;
                        double max5 = -1.7976931348623157E308;
                        int l = 0;
                        while (l < list.size()) {
                            final d d2 = list.get(l);
                            final I b3 = x.b((Object)d2);
                            final cy a4 = cr.a(d2);
                            if (x2) {
                                return new Rectangle2D.Double(min, n2, Math.max(n, max5 - min), n3 - n2);
                            }
                            Label_1955: {
                                if (a4 != null && !Double.isNaN(a4.d)) {
                                    min = Math.min(min, a4.d - a4.f);
                                    max5 = Math.max(max5, a4.d + a4.g);
                                    final double d3 = a4.d;
                                    final t sourcePoint = b3.getSourcePoint();
                                    final t targetPoint = b3.getTargetPoint();
                                    if (this.b(av, d2)) {
                                        if (d2.c() == q) {
                                            b3.addPoint(d3, a.getY() + a.getHeight() * 0.5 + sourcePoint.b);
                                            b3.addPoint(d3, a2.getY() + a2.getHeight() * 0.5 + targetPoint.b);
                                            if (!x2) {
                                                break Label_1955;
                                            }
                                        }
                                        b3.addPoint(d3, a2.getY() + a2.getHeight() * 0.5 + sourcePoint.b);
                                        b3.addPoint(d3, a.getY() + a.getHeight() * 0.5 + targetPoint.b);
                                        if (!x2) {
                                            break Label_1955;
                                        }
                                    }
                                    if (d2.c() == q) {
                                        final double n12 = a.getY() + a.getHeight() * 0.5 + sourcePoint.b;
                                        final double n13 = a2.getY() + a2.getHeight() * 0.5 + targetPoint.b;
                                        final double n14 = av.a(d2).k().i() / bP.a;
                                        if (a4.a() == 2) {
                                            if (n13 - n12 <= 2.0 * n14) {
                                                b3.addPoint(a4.d - (n13 - n12) * 0.5, n12);
                                                b3.addPoint(a4.d + (n13 - n12) * 0.5, n13);
                                                if (!x2) {
                                                    break Label_1955;
                                                }
                                            }
                                            b3.addPoint(a4.d - n14, n12);
                                            b3.addPoint(a4.d, n12 + n14);
                                            b3.addPoint(a4.d, n13 - n14);
                                            b3.addPoint(a4.d + n14, n13);
                                            if (!x2) {
                                                break Label_1955;
                                            }
                                        }
                                        if (n12 - n13 <= 2.0 * n14) {
                                            b3.addPoint(a4.d - (n12 - n13) * 0.5, n12);
                                            b3.addPoint(a4.d + (n12 - n13) * 0.5, n13);
                                            if (!x2) {
                                                break Label_1955;
                                            }
                                        }
                                        b3.addPoint(a4.d - n14, n12);
                                        b3.addPoint(a4.d, n12 - n14);
                                        b3.addPoint(a4.d, n13 + n14);
                                        b3.addPoint(a4.d + n14, n13);
                                        if (!x2) {
                                            break Label_1955;
                                        }
                                    }
                                    final double n15 = a2.getY() + a2.getHeight() * 0.5 + sourcePoint.b;
                                    final double n16 = a.getY() + a.getHeight() * 0.5 + targetPoint.b;
                                    final double n17 = av.a(d2).k().i() / bP.a;
                                    if (2 != a4.a()) {
                                        if (n16 - n15 <= 2.0 * n17) {
                                            b3.addPoint(a4.d + (n16 - n15) * 0.5, n15);
                                            b3.addPoint(a4.d - (n16 - n15) * 0.5, n16);
                                            if (!x2) {
                                                break Label_1955;
                                            }
                                        }
                                        b3.addPoint(a4.d + n17, n15);
                                        b3.addPoint(a4.d, n15 + n17);
                                        b3.addPoint(a4.d, n16 - n17);
                                        b3.addPoint(a4.d - n17, n16);
                                        if (!x2) {
                                            break Label_1955;
                                        }
                                    }
                                    if (n15 - n16 <= 2.0 * n17) {
                                        b3.addPoint(a4.d + (n15 - n16) * 0.5, n15);
                                        b3.addPoint(a4.d - (n15 - n16) * 0.5, n16);
                                        if (!x2) {
                                            break Label_1955;
                                        }
                                    }
                                    b3.addPoint(a4.d + n17, n15);
                                    b3.addPoint(a4.d, n15 - n17);
                                    b3.addPoint(a4.d, n16 + n17);
                                    b3.addPoint(a4.d - n17, n16);
                                }
                            }
                            ++l;
                            if (x2) {
                                break;
                            }
                        }
                        if (min > max5) {
                            return new Rectangle2D.Double(0.0, n2, n, n3 - n2);
                        }
                        return new Rectangle2D.Double(min, n2, Math.max(n, max5 - min), n3 - n2);
                    }
                }
                cr.j();
                continue;
            }
        }
        return null;
    }
    
    private boolean b(final aV av, final d d) {
        if (av == null || av.a(d) == null || av.a(d).k() == null) {
            return true;
        }
        final bs h = av.a(d).k().h();
        if (b(d, av)) {
            return h.a() == 0;
        }
        if (a(d, av)) {
            return h.d() == 0;
        }
        return h.c() == 0;
    }
    
    private static boolean a(final d d, final aV av) {
        final d b = av.a(d).b();
        final aX a = av.a(d.c());
        final aX a2 = av.a(d.d());
        if (b == null) {
            return a.j() == a2.j();
        }
        final aX a3 = av.a(b.c());
        final aX a4 = av.a(b.d());
        return !b(a) && !b(a2) && !b(a3) && !b(a4) && a3.j() == a4.j();
    }
    
    private static boolean b(final aX ax) {
        return ax != null && ax.b() == 15;
    }
    
    private static boolean b(final d d, final aV av) {
        final aX a = av.a(d.c());
        final aX a2 = av.a(d.d());
        final d b = av.a(d).b();
        final aX ax = (b == null) ? null : av.a(b.c());
        final aX ax2 = (b == null) ? null : av.a(b.d());
        return a.b() == 8 || a.b() == 9 || a2.b() == 8 || a2.b() == 9 || b(a) || b(a2) || b(ax) || b(ax2);
    }
    
    public void b(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        int n = 0;
    Label_0514:
        do {
        Block_2:
            while (true) {
                au.b();
                int i = 0;
                int n2 = 0;
            Label_0016:
                while (i < n2) {
                    final aQ a = au.a(n);
                    if (a.e() == 1) {
                        break Block_2;
                    }
                    int n3 = 0;
                    final y d = a.d();
                    int n4 = -1;
                    p p4 = d.k();
                    while (p4 != null) {
                        final q q = (q)p4.c();
                        final aX a2 = av.a(q);
                        final byte b = a2.b();
                        final byte b3;
                        final byte b2 = b3 = b;
                        if (x2) {
                            continue Block_2;
                        }
                        if (b2 == 0 || b == 12 || b == 13 || b == 15) {
                            p p5 = a2.d();
                            while (p5 != null) {
                                final d d2 = (d)p5.c();
                                final aX a3 = av.a(d2.a(q));
                                i = a3.k();
                                n2 = n3;
                                if (x2) {
                                    continue Label_0016;
                                }
                                Label_0470: {
                                    if (i < n2 && n4 <= a3.k()) {
                                        final A a4 = av.a(d2);
                                        final boolean b4 = d2.c() == q;
                                        aE ae = null;
                                        aE ae2 = null;
                                        Label_0275: {
                                            if (b4) {
                                                ae = a4.c();
                                                ae2 = a4.e();
                                                if (!x2) {
                                                    break Label_0275;
                                                }
                                            }
                                            ae = a4.e();
                                            ae2 = a4.c();
                                        }
                                        if ((ae == null || ae.g() || ae.f()) && (ae2 == null || ae2.g() || ae2.e())) {
                                            ap.d(d2);
                                            if (b4) {
                                                ap.a(d2, true, aE.a((byte)8, ae != null && ae.a()));
                                                ap.a(d2, false, aE.a((byte)4, ae2 != null && ae2.a()));
                                                if (!x2) {
                                                    break Label_0470;
                                                }
                                            }
                                            ap.a(d2, false, aE.a((byte)8, ae != null && ae.a()));
                                            ap.a(d2, true, aE.a((byte)4, ae2 != null && ae2.a()));
                                        }
                                    }
                                }
                                p5 = p5.a();
                                if (x2) {
                                    break;
                                }
                            }
                        }
                        if (b == 0) {
                            n4 = n3;
                        }
                        p4 = p4.a();
                        ++n3;
                        if (x2) {
                            break;
                        }
                    }
                    break Block_2;
                }
                break Label_0514;
            }
            ++n;
        } while (!x2);
    }
    
    public void b(final X x, final cr cr, final aQ aq, final aV av, final boolean b, final double n) {
        final boolean x2 = N.x;
        p p6 = aq.d().k();
        while (p6 != null) {
            final q q = (q)p6.c();
        Label_0029:
            while (true) {
                q c = null;
                final q q2 = c;
                final aX a = av.a(q2);
                if (a.e() > 0) {
                    p p7 = a.d();
                    while (p7 != null) {
                        final d d = (d)p7.c();
                        c = d.c();
                        if (x2) {
                            continue Label_0029;
                        }
                        Label_1126: {
                            if (c == q2 && b == this.a(av, d)) {
                                x.e(d);
                                final I b2 = x.b((Object)d);
                                final A a2 = av.a(d);
                                if (a2.a() == 4) {
                                    x.d(d);
                                    if (!x2) {
                                        break Label_1126;
                                    }
                                }
                                final aE c2 = a2.c();
                                final boolean b3 = c2 != null && (c2.b() == 4 || c2.b() == 8);
                                final aE e = a2.e();
                                final boolean b4 = e != null && (e.b() == 4 || e.b() == 8);
                                Label_1120: {
                                    if (this.b(av, d)) {
                                        double n2 = 0.0;
                                        Label_0298: {
                                            if (b3) {
                                                n2 = b2.getPoint(0).a;
                                                b2.setPoint(0, n2, x.p(d).b + n);
                                                if (!x2) {
                                                    break Label_0298;
                                                }
                                            }
                                            n2 = x.p(d).a;
                                        }
                                        if (b4) {
                                            final double a3 = b2.getPoint(b2.pointCount() - 1).a;
                                            b2.setPoint(b2.pointCount() - 1, n2, cr.d(d));
                                            b2.addPoint(a3, cr.d(d));
                                            b2.addPoint(a3, x.q(d).b + n);
                                            if (!x2) {
                                                break Label_1120;
                                            }
                                        }
                                        final double a4 = x.q(d).a;
                                        b2.addPoint(n2, cr.d(d));
                                        b2.addPoint(a4, cr.d(d));
                                        if (!x2) {
                                            break Label_1120;
                                        }
                                    }
                                    final double n3 = b3 ? b2.getPoint(0).a : x.p(d).a;
                                    final double n4 = b4 ? b2.getPoint(b2.pointCount() - 1).a : x.q(d).a;
                                    final double n5 = av.a(d).k().i() / bP.a;
                                    final cy a5 = cr.a(d);
                                    final boolean b5 = a5.a() == 0;
                                    final double n6 = b5 ? (a5.d - (a5.p - a5.b)) : (a5.d + (a5.p - a5.b));
                                    final double n7 = b5 ? (a5.d - (a5.c - a5.q)) : (a5.d + (a5.c - a5.q));
                                    b2.clearPoints();
                                    final boolean b6 = n3 < n4;
                                    final double n8 = b6 ? n6 : n7;
                                    final double n9 = b6 ? n7 : n6;
                                    Label_0875: {
                                        if (b3) {
                                            final double n10 = x.p(d).b + n;
                                            final boolean b7 = c2.b() == 4;
                                            final double abs = Math.abs(n10 - n8);
                                            if (abs > n5) {
                                                b2.addPoint(b7 ? (n3 - n5) : (n3 + n5), n10);
                                                b2.addPoint(n3, b5 ? (n10 + n5) : (n10 - n5));
                                                b2.addPoint(n3, n8);
                                                if (!x2) {
                                                    break Label_0875;
                                                }
                                            }
                                            b2.addPoint(b7 ? (n3 - abs) : (n3 + abs), n10);
                                            if (b6 == b7) {
                                                break Label_0875;
                                            }
                                            b2.addPoint(n3, n8);
                                            if (!x2) {
                                                break Label_0875;
                                            }
                                        }
                                        b2.addPoint(n3, n8);
                                    }
                                    b2.addPoint(b6 ? a5.p : a5.q, a5.d);
                                    b2.addPoint(b6 ? a5.q : a5.p, a5.d);
                                    if (b4) {
                                        final double n11 = x.q(d).b + n;
                                        final boolean b8 = e.b() == 8;
                                        final double abs2 = Math.abs(n11 - n9);
                                        if (abs2 > n5) {
                                            b2.addPoint(n4, n9);
                                            b2.addPoint(n4, b5 ? (n11 + n5) : (n11 - n5));
                                            b2.addPoint(b8 ? (n4 + n5) : (n4 - n5), n11);
                                            if (!x2) {
                                                break Label_1120;
                                            }
                                        }
                                        if (b6 != b8) {
                                            b2.addPoint(n4, n9);
                                        }
                                        b2.addPoint(b8 ? (n4 + abs2) : (n4 - abs2), n11);
                                        if (!x2) {
                                            break Label_1120;
                                        }
                                    }
                                    b2.addPoint(n4, n9);
                                }
                                x.d(d);
                            }
                        }
                        p7 = p7.a();
                        if (x2) {
                            break;
                        }
                    }
                    break;
                }
                break;
            }
            p6 = p6.a();
            if (x2) {
                break;
            }
        }
    }
    
    public boolean a(final aV av, final d d) {
        return av.a(d).j();
    }
    
    public f a() {
        return this.b;
    }
    
    public void a(final double e) {
        this.e = e;
    }
    
    static {
        a = Math.sqrt(2.0);
    }
}
