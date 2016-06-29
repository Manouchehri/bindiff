package y.f.j;

import java.util.*;
import y.f.b.*;
import java.awt.*;
import y.d.*;
import java.awt.geom.*;
import y.f.*;
import y.c.*;

public class a extends c implements ad
{
    private int o;
    private double p;
    private boolean q;
    private double r;
    private double s;
    private double t;
    private double u;
    private boolean v;
    private double w;
    private double x;
    private ah y;
    public static boolean n;
    
    public a() {
        final boolean n = a.n;
        this.o = 3;
        this.p = 0.0;
        this.q = false;
        this.r = 1.0;
        this.s = 1.0;
        this.t = 0.0;
        this.u = 0.0;
        this.v = false;
        this.w = 1.41;
        this.x = 1.0;
        this.e(false);
        this.b(false);
        this.f(false);
        this.d(false);
        if (n) {
            y.c.i.g = !y.c.i.g;
        }
    }
    
    public void a(final ah y) {
        this.y = y;
    }
    
    public ah a() {
        return this.y;
    }
    
    public void a(final int o) {
        this.o = o;
        if (o != 2) {
            this.v = false;
        }
    }
    
    public void a(final double p) {
        this.p = p;
    }
    
    public void g(final boolean q) {
        this.q = q;
    }
    
    public void b(final double n) {
        this.s = n;
        this.r = n;
    }
    
    public void a(final double r, final double s) {
        this.r = r;
        this.s = s;
    }
    
    public double n() {
        return this.t;
    }
    
    public double o() {
        return this.u;
    }
    
    public boolean b(final X x) {
        return true;
    }
    
    public void a(final X x) {
        final boolean n = a.n;
        if (this.a() != null) {
            this.a().c(x);
        }
        final Rectangle a = x.a();
        if (a.width <= 0 || a.height <= 0) {
            return;
        }
        boolean q2 = false;
        Label_1126: {
            X x2 = null;
            Label_1123: {
                Label_1106: {
                    switch (this.o) {
                        case 0: {
                            final x o = x.o();
                            while (o.f()) {
                                final q e = o.e();
                                x.a(e, a(x.l(e), a));
                                o.g();
                                if (n) {
                                    break Label_1106;
                                }
                                if (n) {
                                    break;
                                }
                            }
                            final e p = x.p();
                        Label_0314_Outer:
                            while (p.f()) {
                                final d a2 = p.a();
                                final t n2 = x.n(a2);
                                x.a(a2, new t(n2.a(), -n2.b()));
                                final t o2 = x.o(a2);
                                x.b(a2, new t(o2.a(), -o2.b()));
                                final ArrayList<t> list = new ArrayList<t>();
                                x2 = x;
                                if (!n) {
                                    final u b = x.j(a2).b();
                                    while (true) {
                                        while (b.f()) {
                                            list.add(a(b.a(), a));
                                            b.g();
                                            if (!n) {
                                                if (n) {
                                                    break;
                                                }
                                                continue Label_0314_Outer;
                                            }
                                            else {
                                                if (n) {
                                                    break Label_1106;
                                                }
                                                continue Label_0314_Outer;
                                            }
                                        }
                                        x.b(a2, new v(list));
                                        p.g();
                                        continue;
                                    }
                                }
                                break Label_1123;
                            }
                            break;
                        }
                        case 1: {
                            final x o3 = x.o();
                            while (o3.f()) {
                                final q e2 = o3.e();
                                x.a(e2, b(x.l(e2), a));
                                o3.g();
                                if (n) {
                                    break Label_1106;
                                }
                                if (n) {
                                    break;
                                }
                            }
                            final ArrayList<t> list2 = new ArrayList<t>();
                            final e p2 = x.p();
                        Label_0558_Outer:
                            while (p2.f()) {
                                final d a3 = p2.a();
                                final t n3 = x.n(a3);
                                x.a(a3, new t(-n3.a(), n3.b()));
                                final t o4 = x.o(a3);
                                x.b(a3, new t(-o4.a(), o4.b()));
                                list2.clear();
                                x2 = x;
                                if (!n) {
                                    final u b2 = x.j(a3).b();
                                    while (true) {
                                        while (b2.f()) {
                                            list2.add(b(b2.a(), a));
                                            b2.g();
                                            if (!n) {
                                                if (n) {
                                                    break;
                                                }
                                                continue Label_0558_Outer;
                                            }
                                            else {
                                                if (n) {
                                                    break Label_1106;
                                                }
                                                continue Label_0558_Outer;
                                            }
                                        }
                                        x.b(a3, new v(list2));
                                        p2.g();
                                        continue;
                                    }
                                }
                                break Label_1123;
                            }
                            break;
                        }
                        case 2: {
                            if (this.v) {
                                a(x, this.w, this.x);
                                if (!n) {
                                    break;
                                }
                            }
                            a(x, this.p, a);
                            if (n) {
                                break Label_1106;
                            }
                            break;
                        }
                        case 3: {
                            final AffineTransform affineTransform = new AffineTransform();
                            final double n4 = a.x + a.width / 2;
                            final double n5 = a.y + a.height / 2;
                            final Point2D.Double double1 = new Point2D.Double();
                            affineTransform.translate(n4, n5);
                            affineTransform.scale(this.r, this.s);
                            affineTransform.translate(-n4, -n5);
                            final x o5 = x.o();
                            while (o5.f()) {
                                o5.e();
                                q q = null;
                            Label_0700:
                                while (true) {
                                    q c = null;
                                    q = c;
                                    double1.setLocation(x.j(q), x.k(q));
                                    affineTransform.transform(double1, double1);
                                    q2 = this.q;
                                    if (n) {
                                        break Label_1126;
                                    }
                                    if (q2) {
                                        x.b(q, x.p(q) * this.r, x.q(q) * this.s);
                                        final e j = q.j();
                                        while (j.f()) {
                                            final d a4 = j.a();
                                            c = a4.c();
                                            if (n) {
                                                continue Label_0700;
                                            }
                                            if (c == q) {
                                                final t n6 = x.n(a4);
                                                x.a(a4, new t(n6.a * this.r, n6.b * this.s));
                                            }
                                            if (a4.d() == q) {
                                                final t o6 = x.o(a4);
                                                x.b(a4, new t(o6.a * this.r, o6.b * this.s));
                                            }
                                            j.g();
                                            if (n) {
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    break;
                                }
                                x.a(q, double1.getX(), double1.getY());
                                o5.g();
                                if (n) {
                                    break;
                                }
                            }
                            final ArrayList<t> list3 = new ArrayList<t>();
                            final e p3 = x.p();
                        Label_1101_Outer:
                            while (p3.f()) {
                                final d a5 = p3.a();
                                list3.clear();
                                x2 = x;
                                if (!n) {
                                    final u b3 = x.j(a5).b();
                                    while (true) {
                                        while (b3.f()) {
                                            final t a6 = b3.a();
                                            double1.setLocation(a6.a(), a6.b());
                                            affineTransform.transform(double1, double1);
                                            list3.add(new t(double1.getX(), double1.getY()));
                                            b3.g();
                                            if (!n) {
                                                if (n) {
                                                    break;
                                                }
                                                continue Label_1101_Outer;
                                            }
                                            else {
                                                if (n) {
                                                    break Label_1106;
                                                }
                                                continue Label_1101_Outer;
                                            }
                                        }
                                        x.b(a5, new v(list3));
                                        p3.g();
                                        continue;
                                    }
                                }
                                break Label_1123;
                            }
                            break;
                        }
                        case 4: {
                            ae.a(x, x.o(), this.n(), this.o());
                            break;
                        }
                    }
                }
                x2 = x;
            }
            y.f.b.c.c(x2);
        }
        if (!q2) {
            new j().c(x);
        }
    }
    
    private static void a(final X x, final double n, final Rectangle rectangle) {
        final boolean n2 = a.n;
        final AffineTransform affineTransform = new AffineTransform();
        final double n3 = rectangle.x + rectangle.width / 2;
        final double n4 = rectangle.y + rectangle.height / 2;
        final Point2D.Double double1 = new Point2D.Double();
        affineTransform.translate(n3, n4);
        affineTransform.rotate(y.d.e.a(n));
        affineTransform.translate(-n3, -n4);
        final x o = x.o();
        while (o.f()) {
            final q e = o.e();
            double1.setLocation(x.j(e), x.k(e));
            affineTransform.transform(double1, double1);
            x.a(e, double1.getX(), double1.getY());
            o.g();
            if (n2) {
                break;
            }
        }
        final ArrayList<t> list = new ArrayList<t>();
        final e p3 = x.p();
    Label_0316_Outer:
        while (p3.f()) {
            final d a = p3.a();
            list.clear();
            final u b = x.j(a).b();
            while (true) {
                while (b.f()) {
                    final t a2 = b.a();
                    double1.setLocation(a2.a(), a2.b());
                    affineTransform.transform(double1, double1);
                    list.add(new t(double1.getX(), double1.getY()));
                    b.g();
                    if (!n2) {
                        if (n2) {
                            break;
                        }
                        continue Label_0316_Outer;
                    }
                    else {
                        if (n2) {
                            break Label_0316_Outer;
                        }
                        continue Label_0316_Outer;
                    }
                }
                x.b(a, new v(list));
                p3.g();
                continue;
            }
        }
    }
    
    public static double a(final X x, final double n, final double n2) {
        final double b = b(x, n, n2);
        a(x, b, x.a());
        return b;
    }
    
    public static double b(final X x, final double n, final double n2) {
        final boolean n3 = a.n;
        if (x.f() > 1) {
            final D d = d(x);
            double n4 = Double.MAX_VALUE;
            double n5 = 0.0;
            double abs = 0.0;
            while (n5 < 360.0) {
                final y.d.q a = a(d, n5);
                final double n6 = abs = Math.abs(a.a() * n2 - n * a.b());
                if (n3) {
                    return abs;
                }
                if (abs < n4) {
                    n4 = n6;
                }
                n5 += 10.0;
                if (n3) {
                    break;
                }
            }
            return abs;
        }
        return 0.0;
    }
    
    public static void a(final X x, final double n, final double n2, double n3, double n4) {
        final boolean n5 = a.n;
        final Rectangle2D.Double double1 = new Rectangle2D.Double(n, n2, n3, n4);
        if (x.e() == 0) {
            return;
        }
        double min = Double.MAX_VALUE;
        double min2 = Double.MAX_VALUE;
        double max = -1.7976931348623157E308;
        double max2 = -1.7976931348623157E308;
        final x o = x.o();
        while (true) {
        Label_0391_Outer:
            while (o.f()) {
                final q e = o.e();
                final double p5 = x.p(e);
                final double n6 = n3;
                if (!n5) {
                    if (p5 > n6 || x.q(e) > n4) {
                        return;
                    }
                    min = Math.min(min, x.j(e));
                    min2 = Math.min(min2, x.k(e));
                    max = Math.max(max, x.j(e));
                    max2 = Math.max(max2, x.k(e));
                    o.g();
                    if (n5) {
                        break;
                    }
                    continue;
                }
                else {
                    final double n7 = p5 + n6;
                    final double n8 = min2 + (max2 - min2) / 2.0;
                    n3 /= 2.0;
                    n4 /= 2.0;
                    double min3 = 1.0;
                    double min4 = 1.0;
                    final x o2 = x.o();
                    while (true) {
                        while (true) {
                            while (o2.f()) {
                                final q e2 = o2.e();
                                final double abs = Math.abs(n7 - x.j(e2));
                                final double abs2 = Math.abs(n8 - x.k(e2));
                                final double n9 = n3 - x.p(e2) / 2.0;
                                final double n10 = n4 - x.q(e2) / 2.0;
                                min3 = Math.min(min3, n9 / abs);
                                min4 = Math.min(min4, n10 / abs2);
                                o2.g();
                                if (n5) {
                                    final a a = new a();
                                    a.a(3);
                                    a.a(min3, min4);
                                    a.g(false);
                                    a.a(x);
                                    final Rectangle2D a2 = ae.a(x, x.o(), x.p());
                                    if (!double1.contains(a2)) {
                                        ae.a(x, x.o(), double1.getCenterX() - a2.getCenterX(), double1.getCenterY() - a2.getCenterY());
                                    }
                                    return;
                                }
                                if (n5) {
                                    break;
                                }
                            }
                            if (min3 < 1.0 || min4 < 1.0) {
                                continue Label_0391_Outer;
                            }
                            break;
                        }
                        continue;
                    }
                }
            }
            continue;
        }
    }
    
    public static void c(final X x, final double n, final double n2) {
        final boolean n3 = a.n;
        final x o = x.o();
        while (o.f()) {
            final q e = o.e();
            x.a(e, x.j(e) + n, x.k(e) + n2);
            o.g();
            if (n3) {
                break;
            }
        }
        final ArrayList<t> list = new ArrayList<t>();
        final e p3 = x.p();
    Label_0199_Outer:
        while (p3.f()) {
            final d a = p3.a();
            list.clear();
            final u b = x.j(a).b();
            while (true) {
                while (b.f()) {
                    final t a2 = b.a();
                    list.add(new t(a2.a + n, a2.b + n2));
                    b.g();
                    if (!n3) {
                        if (n3) {
                            break;
                        }
                        continue Label_0199_Outer;
                    }
                    else {
                        if (n3) {
                            break Label_0199_Outer;
                        }
                        continue Label_0199_Outer;
                    }
                }
                x.b(a, new v(list));
                p3.g();
                continue;
            }
        }
    }
    
    private static t a(final t t, final Rectangle rectangle) {
        return new t(t.a, 2 * rectangle.y + rectangle.height - t.b);
    }
    
    private static t b(final t t, final Rectangle rectangle) {
        return new t(2 * rectangle.x + rectangle.width - t.a, t.b);
    }
    
    private static D d(final X x) {
        final boolean n = a.n;
        final D d = new D();
        final x o = x.o();
        while (true) {
            while (o.f()) {
                final X x2 = x;
                if (n) {
                    final e p = x2.p();
                Label_0171_Outer:
                    while (p.f()) {
                        final I g = x.g(p.a());
                        int i = 0;
                        while (true) {
                            while (i < g.pointCount()) {
                                d.add(g.getPoint(i));
                                ++i;
                                if (!n) {
                                    if (n) {
                                        break;
                                    }
                                    continue Label_0171_Outer;
                                }
                                else {
                                    if (n) {
                                        break Label_0171_Outer;
                                    }
                                    continue Label_0171_Outer;
                                }
                            }
                            p.g();
                            continue;
                        }
                    }
                    return y.d.e.a(d);
                }
                final am h = x.h(o.e());
                d.add(new t(h.getX() + h.getWidth() / 2.0, h.getY() + h.getHeight() / 2.0));
                o.g();
                if (n) {
                    break;
                }
            }
            final X x2 = x;
            continue;
        }
    }
    
    private static y.d.q a(final D d, double a) {
        final boolean n = a.n;
        a = y.d.e.a(a);
        double n2 = Double.MAX_VALUE;
        double n3 = -1.7976931348623157E308;
        double n4 = Double.MAX_VALUE;
        double n5 = -1.7976931348623157E308;
        final double cos = Math.cos(a);
        final double sin = Math.sin(a);
        final C m = d.m();
        while (m.f()) {
            final t t = (t)m.d();
            final double n6 = t.a() * cos - t.b() * sin;
            final double n7 = t.a() * sin + t.b() * cos;
            if (n6 < n2) {
                n2 = n6;
            }
            if (n7 < n4) {
                n4 = n7;
            }
            if (n6 > n3) {
                n3 = n6;
            }
            if (n7 > n5) {
                n5 = n7;
            }
            m.g();
            if (n) {
                break;
            }
        }
        return new y.d.q(n3 - n2, n5 - n4);
    }
}
