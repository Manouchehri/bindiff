package y.f.c;

import y.f.b.*;
import y.g.*;
import y.f.*;
import y.d.*;
import java.awt.geom.*;
import y.c.*;
import java.util.*;

public class E extends K
{
    private y.f.b.c u;
    private J v;
    private I w;
    private X x;
    private h y;
    private A z;
    private A A;
    A n;
    private h B;
    private h C;
    private h D;
    private h E;
    private y.c.c F;
    private y.c.c G;
    private y.c.c H;
    private y.c.c I;
    private A J;
    private A K;
    private h L;
    private y.c.c M;
    private y.c.c N;
    private h O;
    private static final aE P;
    private static final aE Q;
    private a R;
    private ah S;
    private boolean T;
    private boolean U;
    
    public E() {
        this.S = new H(this);
        this.T = true;
        this.d(false);
        this.U = true;
        this.v = new J(this);
        this.R = new y.f.b.h();
        this.v.c = super.a();
        this.v.d = super.n();
        this.v.e = super.o();
        super.a((R)this.v);
        super.a((Q)this.v);
        super.a((v)this.v);
    }
    
    public boolean b(final X x) {
        return true;
    }
    
    public void a(final X x) {
        final boolean i = y.f.c.a.i;
        if (!this.u() && c.c(x)) {
            try {
                super.a(this.v.d);
                super.a(this.v.c);
                super.a(this.v.e);
                super.a(x);
                return;
            }
            finally {
                super.a((R)this.v);
                super.a((v)this.v);
                super.a((Q)this.v);
            }
        }
        this.u = new y.f.b.c(x);
        this.y = x.u();
        this.z = x.t();
        this.A = x.t();
        this.n = x.t();
        this.J = x.t();
        this.x = x;
        this.w = new I(x);
        final x o = this.x.o();
        while (true) {
        Label_0673_Outer:
            while (o.f()) {
                this.J.a(o.e(), y.f.c.K.p);
                o.g();
                if (i) {
                    ap ap;
                    if (x.c(y.f.U.a) != null) {
                        this.O = x.u();
                        ap = new ap(this.O, x, y.f.U.a);
                    }
                    else {
                        ap = null;
                    }
                    this.B = x.u();
                    final ap ap2 = new ap(this.B, x, aF.a);
                    this.F = ap2.c();
                    this.C = x.u();
                    final ap ap3 = new ap(this.C, x, aF.b);
                    this.G = ap3.c();
                    final y.c.c c = x.c(aF.c);
                    this.H = c;
                    ap ap4 = null;
                    ap ap5 = null;
                    Label_0555: {
                        if (c != null) {
                            this.D = x.u();
                            ap4 = new ap(this.D, x, aF.c);
                            if ((this.I = x.c(aF.d)) != null) {
                                this.E = x.u();
                                ap5 = new ap(this.E, x, aF.d);
                                if (!i) {
                                    break Label_0555;
                                }
                            }
                            throw new IllegalStateException("No DataProvider " + aF.d + " bound to graph!");
                        }
                        if (x.c(aF.d) != null) {
                            throw new IllegalStateException("No DataProvider " + aF.c + " bound to graph!");
                        }
                        ap5 = (ap4 = null);
                    }
                    this.M = x.c(ah.f_);
                    this.N = x.c(ah.k);
                    boolean b = false;
                    Label_0765: {
                        Label_0762: {
                            if (this.M == null && this.N == null && this.p()) {
                                this.M = x.t();
                                final x o2 = x.o();
                                while (true) {
                                    while (o2.f()) {
                                        ((A)this.M).a(o2.e(), o2.e());
                                        o2.g();
                                        if (i) {
                                            final e p = x.p();
                                            while (true) {
                                                while (p.f()) {
                                                    ((h)this.N).a(p.a(), p.a());
                                                    p.g();
                                                    if (!i) {
                                                        if (i) {
                                                            break;
                                                        }
                                                        continue Label_0673_Outer;
                                                    }
                                                    else {
                                                        b = true;
                                                        if (i) {
                                                            break Label_0762;
                                                        }
                                                        break Label_0765;
                                                    }
                                                }
                                                x.a(ah.f_, this.M);
                                                x.a(ah.k, this.N);
                                                continue;
                                            }
                                        }
                                        if (i) {
                                            break;
                                        }
                                    }
                                    this.N = x.u();
                                    continue;
                                }
                            }
                        }
                        b = false;
                    }
                    ap ap6 = null;
                    Label_0821: {
                        if (this.M != null && (b || this.u() || this.p())) {
                            ap6 = new ap(this.K = x.t(), x, ah.f_);
                            if (!i) {
                                break Label_0821;
                            }
                        }
                        ap6 = null;
                    }
                    ap ap7 = null;
                    Label_0955: {
                        if (this.N != null && (b || this.u() || this.p())) {
                            if (ap6 == null) {
                                throw new IllegalStateException("No DataProvider " + ah.f_ + " bound to graph!");
                            }
                            ap7 = new ap(this.L = x.u(), x, ah.k);
                            if (!i) {
                                break Label_0955;
                            }
                        }
                        ap7 = null;
                        if (ap6 != null) {
                            throw new IllegalStateException("No DataProvider " + ah.k + " bound to graph!");
                        }
                    }
                    final x o3 = x.o();
                Label_1073_Outer:
                    while (o3.f()) {
                        final q e = o3.e();
                        this.z.a(e, new G());
                        if (!i) {
                            d d = e.f();
                            while (true) {
                                while (d != null) {
                                    final y.f.c.I j = new y.f.c.I();
                                    this.a(d, j);
                                    this.y.a(d, j);
                                    d = d.g();
                                    if (!i) {
                                        if (i) {
                                            break;
                                        }
                                        continue Label_1073_Outer;
                                    }
                                    else {
                                        if (i) {
                                            break Label_1073_Outer;
                                        }
                                        continue Label_1073_Outer;
                                    }
                                }
                                o3.g();
                                continue;
                            }
                        }
                        return;
                    }
                    try {
                        Y t = null;
                        boolean b2;
                        Object b3;
                        boolean a;
                        boolean a2;
                        boolean b4;
                        if (this.U) {
                            b2 = !this.u();
                            t = this.t();
                            b3 = t.b();
                            a = t.a((byte)1);
                            a2 = t.a((byte)2);
                            b4 = !a2;
                        }
                        else {
                            b2 = false;
                            b4 = false;
                            b3 = null;
                            a2 = false;
                            a = false;
                        }
                        if (b4) {
                            final Object a3 = t.a();
                            t.b(a3);
                            t.a((byte)1, false);
                            t.a((byte)2, false);
                            final Map x2 = this.x();
                            final aD ad = new aD();
                            ad.a = x2;
                            ((Map<String, aD>)a3).put("y.layout.hierarchic.MementoSequencer.SequencerMemento", ad);
                            Label_1423: {
                                if (b3 != null) {
                                    Label_1319: {
                                        if (!a2) {
                                            final aD ad2 = (aD)((Map<String, aJ>)b3).get("y.layout.hierarchic.MementoSequencer.SequencerMemento");
                                            if (ad2 != null) {
                                                ad2.a.putAll(ad.a);
                                                if (!i) {
                                                    break Label_1319;
                                                }
                                            }
                                            ((Map<String, aD>)b3).put("y.layout.hierarchic.MementoSequencer.SequencerMemento", ad);
                                        }
                                    }
                                    if (!a) {
                                        final aJ aj = ((Map<String, aJ>)b3).get("y.layout.hierarchic.MementoLayerer.LayerMemento");
                                        final aJ aj2 = ((Map<K, aJ>)a3).get("y.layout.hierarchic.MementoLayerer.LayerMemento");
                                        if (aj != null) {
                                            aj.a = Math.max(aj.a, aj2.a);
                                            aj.b.putAll(aj2.b);
                                            if (!i) {
                                                break Label_1423;
                                            }
                                        }
                                        ((Map<String, aJ>)b3).put("y.layout.hierarchic.MementoLayerer.LayerMemento", aj2);
                                    }
                                }
                            }
                            t.a((byte)1, true);
                            t.a((byte)2, true);
                        }
                        this.a(this.u.b(), this.u.b(this.u.b()), false);
                        if (b4) {
                            t.a((byte)1, a);
                            t.a((byte)2, a2);
                            t.b(b3);
                        }
                        if (b2) {
                            this.v();
                        }
                        this.a(this.u.b(), 0.0, 0.0);
                        this.w();
                    }
                    finally {
                        if (ap6 != null) {
                            ap6.b();
                            x.a(this.K);
                            this.K = null;
                        }
                        if (ap7 != null) {
                            ap7.b();
                            x.a(this.L);
                            this.L = null;
                        }
                        x.a(this.y);
                        x.a(this.z);
                        x.a(this.A);
                        x.a(this.n);
                        if (b) {
                            x.d_(ah.f_);
                            x.d_(ah.k);
                            x.a(this.K);
                            x.a(this.L);
                        }
                        x.d_(y.f.c.K.o);
                        x.a(this.J);
                        this.J = null;
                        if (ap != null) {
                            ap.b();
                            x.a(this.O);
                            this.O = null;
                        }
                        ap2.b();
                        this.x.a(this.B);
                        this.B = null;
                        ap3.b();
                        this.x.a(this.C);
                        this.C = null;
                        if (ap4 != null) {
                            ap4.b();
                            this.x.a(this.D);
                            this.D = null;
                        }
                        if (ap5 != null) {
                            ap5.b();
                            this.x.a(this.E);
                            this.E = null;
                        }
                        this.H = null;
                        this.I = null;
                        this.F = null;
                        this.G = null;
                        this.A = null;
                        this.n = null;
                        this.w = null;
                        this.x = null;
                        this.y = null;
                        this.z = null;
                        if (this.u != null) {
                            this.u.c();
                        }
                        this.u = null;
                    }
                    return;
                }
                if (i) {
                    break;
                }
            }
            x.a(y.f.c.K.o, this.J);
            continue;
        }
    }
    
    private void a(final d d, final y.f.c.I i) {
        final boolean j = y.f.c.a.i;
        if (this.u.a(d)) {
            return;
        }
        final y.c.c c = this.x.c(y.f.U.a);
        if (c != null) {
            final S[] array = (S[])c.b(d);
            if (array == null) {
                return;
            }
            final ArrayList list = new ArrayList<S>(4);
            final ArrayList list2 = new ArrayList<S>(4);
            final ArrayList list3 = new ArrayList<S>(4);
            int k = 0;
            while (true) {
                while (k < array.length) {
                    final S s = array[k];
                    final aG f = s.f();
                    final int l = f.i() ? 1 : 0;
                    if (!j) {
                        Label_0166: {
                            if (l != 0) {
                                list.add(s);
                                if (!j) {
                                    break Label_0166;
                                }
                            }
                            if (f.k()) {
                                list2.add(s);
                                if (!j) {
                                    break Label_0166;
                                }
                            }
                            list3.add(s);
                        }
                        ++k;
                        if (j) {
                            break;
                        }
                        continue;
                    }
                    else {
                        if (l > 0) {
                            i.g = (S[])list.toArray(new S[list.size()]);
                        }
                        if (list2.size() > 0) {
                            i.h = (S[])list2.toArray(new S[list2.size()]);
                        }
                        if (list3.size() > 0) {
                            i.i = (S[])list3.toArray(new S[list3.size()]);
                        }
                        return;
                    }
                }
                list.size();
                continue;
            }
        }
    }
    
    private S[] a(final S[] array, final S[] array2) {
        if (array == null || array.length == 0) {
            return array2;
        }
        if (array2 == null || array2.length == 0) {
            return array;
        }
        final S[] array3 = new S[array.length + array2.length];
        System.arraycopy(array, 0, array3, 0, array.length);
        System.arraycopy(array2, 0, array3, array.length, array2.length);
        return array3;
    }
    
    private void a(final q q, final double n, final double n2) {
        final boolean i = y.f.c.a.i;
        p p3 = this.u.b(q).k();
    Label_0294:
        while (true) {
            while (p3 != null) {
                final q q2 = (q)p3.c();
                this.x.d(q2, n, n2);
                final G g = (G)this.z.b(q2);
                Object o;
                final y.f.b.c c = (y.f.b.c)(o = this.u);
                if (!i) {
                    Label_0157: {
                        if (c.d(q2)) {
                            final am a = this.x.a((Object)q2);
                            if (g.a != null) {
                                this.a(q2, a.getX() - g.a.getX(), a.getY() - g.a.getY());
                                if (!i) {
                                    break Label_0157;
                                }
                            }
                            this.a(q2, n, n2);
                        }
                    }
                    d d = q2.f();
                    q a2 = null;
                    while (d != null) {
                        a2 = this.u.a(d.d());
                        if (i) {
                            break Label_0294;
                        }
                        Label_0276: {
                            if (a2 == q) {
                                final y.f.I b = this.x.b((Object)d);
                                int j = b.pointCount() - 1;
                                while (j >= 0) {
                                    final t point = b.getPoint(j);
                                    b.setPoint(j, point.a + n, point.b + n2);
                                    --j;
                                    if (i) {
                                        break Label_0276;
                                    }
                                    if (i) {
                                        break;
                                    }
                                }
                            }
                            d = d.g();
                        }
                        if (i) {
                            break;
                        }
                    }
                    p3 = p3.a();
                    if (!i) {
                        continue;
                    }
                    if (a2 == null) {
                        return;
                    }
                    o = this.z.b(q);
                }
                final List b2 = ((G)o).b;
                if (b2 != null) {
                    int k = b2.size() - 1;
                    while (k >= 0) {
                        final S s = b2.get(k);
                        s.a(s.d() + n, s.e() + n2);
                        --k;
                        if (i) {
                            break;
                        }
                    }
                }
                return;
            }
            continue Label_0294;
        }
    }
    
    private void w() {
        final boolean i = y.f.c.a.i;
        final D d = new D();
        final D d2 = new D();
        final D d3 = new D();
        final x o = this.x.o();
    Label_0991:
        do {
            boolean f = o.f();
        Label_0045:
            while (f) {
                final q e = o.e();
                final am a = this.x.a((Object)e);
                d d4 = e.f();
                while (d4 != null) {
                    final y.f.c.I j = (y.f.c.I)this.y.b(d4);
                    final List a2 = j.a;
                    final List b = j.b;
                    if (i) {
                        continue Label_0991;
                    }
                    Label_0979: {
                        Label_0972: {
                            if (a2 == null || a2.size() < 1) {
                                if (b == null) {
                                    break Label_0972;
                                }
                                if (b.size() < 1) {
                                    break Label_0972;
                                }
                            }
                            final am a3 = this.x.a((Object)d4.d());
                            final y.f.I b2 = this.x.b((Object)d4);
                            b2.clearPoints();
                            d3.clear();
                            if (a2 != null && a2.size() > 0) {
                                final Point2D.Double double1 = a2.get(0);
                                b2.setSourcePoint(new t(double1.x, double1.y));
                                final Point2D.Double double2 = double1;
                                double2.x += a.getX() + a.getWidth() * 0.5;
                                final Point2D.Double double3 = double1;
                                double3.y += a.getY() + a.getHeight() * 0.5;
                                int k = 1;
                                while (k < a2.size()) {
                                    final Point2D.Double double5;
                                    final Point2D.Double double4 = double5 = a2.get(k);
                                    final Point2D.Double double6 = double1;
                                    final double n = double6.x + double4.x;
                                    double6.x = n;
                                    double5.x = n;
                                    final Point2D.Double double7 = double4;
                                    final Point2D.Double double8 = double1;
                                    final double n2 = double8.y + double4.y;
                                    double8.y = n2;
                                    double7.y = n2;
                                    d3.add(double4);
                                    ++k;
                                    if (i) {
                                        break Label_0979;
                                    }
                                    if (i) {
                                        break;
                                    }
                                }
                            }
                            final p l = d3.l();
                            if (b != null && b.size() > 0) {
                                final Point2D.Double double9 = b.get(0);
                                b2.setTargetPoint(new t(double9.x, double9.y));
                                final Point2D.Double double10 = double9;
                                double10.x += a3.getX() + a3.getWidth() * 0.5;
                                final Point2D.Double double11 = double9;
                                double11.y += a3.getY() + a3.getHeight() * 0.5;
                                int n3 = 1;
                                while (n3 < b.size()) {
                                    final Point2D.Double double13;
                                    final Point2D.Double double12 = double13 = b.get(n3);
                                    final Point2D.Double double14 = double9;
                                    final double n4 = double14.x + double12.x;
                                    double14.x = n4;
                                    double13.x = n4;
                                    final Point2D.Double double15 = double12;
                                    final Point2D.Double double16 = double9;
                                    final double n5 = double16.y + double12.y;
                                    double16.y = n5;
                                    double15.y = n5;
                                    d3.b(double12, l);
                                    ++n3;
                                    if (i) {
                                        break Label_0979;
                                    }
                                    if (i) {
                                        break;
                                    }
                                }
                            }
                            final t p = this.x.p(d4);
                            double n6 = p.a;
                            double n7 = p.b;
                            boolean b3 = false;
                            boolean b4 = false;
                            final t q = this.x.q(d4);
                            d3.add(new Point2D.Double(q.a, q.b));
                            p p2 = d3.k();
                            while (p2 != null) {
                                final Point2D.Double double17 = (Point2D.Double)p2.c();
                                final double n8 = (f = dcmpg(Math.abs(double17.x - n6), 0.001)) ? 1 : 0;
                                if (i) {
                                    continue Label_0045;
                                }
                                Label_0896: {
                                    if (n8 < 0 && Math.abs(double17.y - n7) < 0.001) {
                                        if (p2.b() != null) {
                                            d3.h(p2.b());
                                            if (!i) {
                                                break Label_0896;
                                            }
                                        }
                                        d3.h(p2);
                                        if (!i) {
                                            break Label_0896;
                                        }
                                    }
                                    Label_0832: {
                                        if (b3 && Math.abs(n7 - double17.y) < 0.001) {
                                            d3.h(p2.b());
                                            if (!i) {
                                                break Label_0832;
                                            }
                                        }
                                        if (b4 && Math.abs(n6 - double17.x) < 0.001) {
                                            d3.h(p2.b());
                                        }
                                    }
                                    b3 = (Math.abs(n7 - double17.y) < 0.001);
                                    b4 = (Math.abs(n6 - double17.x) < 0.001);
                                    n6 = double17.x;
                                    n7 = double17.y;
                                }
                                p2 = p2.a();
                                if (i) {
                                    break;
                                }
                            }
                            d3.h(d3.l());
                            p p3 = d3.k();
                            while (p3 != null) {
                                final Point2D.Double double18 = (Point2D.Double)p3.c();
                                b2.addPoint(double18.x, double18.y);
                                p3 = p3.a();
                                if (i) {
                                    break Label_0979;
                                }
                                if (i) {
                                    break;
                                }
                            }
                        }
                        d4 = d4.g();
                    }
                    if (i) {
                        break;
                    }
                }
                o.g();
                continue Label_0991;
            }
            break;
        } while (!i);
    }
    
    protected Rectangle2D a(final q q, final y y, final boolean b) {
        final boolean i = y.f.c.a.i;
        if (y.isEmpty()) {
            return null;
        }
        final Object o = (q != null) ? ((this.M != null) ? this.M.b(q) : null) : null;
        final Object a = y.g.am.a("SourceOutEdge", o);
        final Object a2 = y.g.am.a("TargetInEdge", o);
        final HashSet<d> set = new HashSet<d>();
        p p3 = y.k();
    Label_0478:
        while (true) {
        Label_1736_Outer:
            while (p3 != null) {
                Object c = p3.c();
                Label_0459: {
                    q q2;
                    while (true) {
                        q2 = (q)c;
                        final HashSet<d> set3;
                        final HashSet<d> set2 = set3 = set;
                        if (i) {
                            break Label_0478;
                        }
                        set2.add((d)q2);
                        if (!this.u.d(q2) || b) {
                            break Label_0459;
                        }
                        final Rectangle2D a3 = this.a(q2, this.u.b(q2), false);
                        if (a3 == null) {
                            break Label_0459;
                        }
                        if (!this.T) {
                            break;
                        }
                        final am a4 = this.x.a((Object)q2);
                        final double n = a3.getWidth() / a4.getWidth();
                        final double n2 = a3.getHeight() / a4.getHeight();
                        if (this.G != null) {
                            d d = q2.g();
                            while (d != null) {
                                final aE ae = (aE)this.G.b(d);
                                final q q3 = (q)(c = ae);
                                if (i) {
                                    continue Label_0459;
                                }
                                if (q3 != null && ae.a()) {
                                    final t o2 = this.x.o(d);
                                    this.x.b(d, new t(o2.a * n, o2.b * n2));
                                }
                                d = d.h();
                                if (i) {
                                    break;
                                }
                            }
                        }
                        if (this.F != null) {
                            d d2 = q2.f();
                            while (d2 != null) {
                                final aE ae2 = (aE)this.F.b(d2);
                                final q q4 = (q)(c = ae2);
                                if (i) {
                                    continue Label_0459;
                                }
                                if (q4 != null && ae2.a()) {
                                    final t n3 = this.x.n(d2);
                                    this.x.a(d2, new t(n3.a * n, n3.b * n2));
                                }
                                d2 = d2.g();
                                if (i) {
                                    break;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    final y.d.q r = this.x.r(q2);
                    if (r.b <= 1.0 || r.b <= 1.0) {
                        this.x.b(q2, 1.01, 1.01);
                    }
                }
                p3 = p3.a();
                if (i) {
                    break;
                }
                continue Label_1736_Outer;
                HashSet<d> set3 = null;
                final HashSet<d> set4 = set3;
                final f f = new f();
                p p4 = y.k();
                while (true) {
                    while (p4 != null) {
                        final q q5 = (q)p4.c();
                        final E e = this;
                        if (i) {
                            final x o3 = e.x.o();
                            while (o3.f()) {
                                final q e2 = o3.e();
                                if (!set.contains(e2)) {
                                    this.w.a(e2);
                                }
                                o3.g();
                                if (i) {
                                    break;
                                }
                            }
                            final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                            final y y2 = new y();
                            p p5 = this.u.f(q).k();
                            while (true) {
                            Label_4186_Outer:
                                while (p5 != null) {
                                    final d d3 = (d)p5.c();
                                    final y.f.c.I j = (y.f.c.I)this.y.b(d3);
                                    final q d4 = d3.d();
                                    final q a5 = this.u.a(d4, q);
                                    q d5 = null;
                                    final E e3 = this;
                                    if (i) {
                                        e3.v.a(y2);
                                        hashMap.clear();
                                        final y y3 = new y();
                                        p p6 = this.u.g(q).k();
                                        Label_3019: {
                                            while (p6 != null) {
                                                final d d6 = (d)p6.c();
                                                final y.f.c.I k = (y.f.c.I)this.y.b(d6);
                                                final q c2 = d6.c();
                                                final q a6 = this.u.a(c2, q);
                                                q d7 = null;
                                                final E e4 = this;
                                                if (i) {
                                                    break Label_3019;
                                                }
                                                final Object o4 = (this.H != null) ? this.H.b(d6) : null;
                                                if (o4 != null) {
                                                    d7 = hashMap.get(o4);
                                                }
                                                Label_2688: {
                                                    if (d7 == null) {
                                                        d7 = this.x.d();
                                                        this.J.a(d7, y.f.c.K.r);
                                                        this.x.b(d7, 0.0, 0.0);
                                                        y3.add(d7);
                                                        if (o4 != null) {
                                                            hashMap.put(o4, d7);
                                                            if (this.K == null) {
                                                                break Label_2688;
                                                            }
                                                            this.K.a(d7, y.g.am.a("LowerGroupNode", o4, this.M.b(q)));
                                                            if (!i) {
                                                                break Label_2688;
                                                            }
                                                        }
                                                        if (this.K != null) {
                                                            this.K.a(d7, y.g.am.a("LowerDummyNode", this.N.b(d6), this.M.b(q)));
                                                        }
                                                    }
                                                }
                                                final d a7 = this.x.a(a6, d7);
                                                if (this.L != null) {
                                                    this.L.a(a7, y.g.am.a("OutEdge", this.N.b(d6), this.M.b(a6), this.M.b(q)));
                                                }
                                                if (this.D != null) {
                                                    final Object b2 = this.H.b(d6);
                                                    if (b2 != null) {
                                                        Label_2824: {
                                                            if (a6 == c2) {
                                                                this.D.a(a7, b2);
                                                                if (!i) {
                                                                    break Label_2824;
                                                                }
                                                            }
                                                            a(this.D, a7, a, this.H, d6);
                                                        }
                                                        this.E.a(a7, b2);
                                                    }
                                                }
                                                Label_2984: {
                                                    if (a6 != c2) {
                                                        this.x.b((Object)a7).setSourcePoint(new t(k.c.x, k.c.y));
                                                        this.B.a(a7, y.f.c.E.Q);
                                                        if (!i) {
                                                            break Label_2984;
                                                        }
                                                    }
                                                    if (this.F != null) {
                                                        this.B.a(a7, this.F.b(d6));
                                                        this.x.a(a7, this.x.n(d6));
                                                    }
                                                    if (k.g != null && k.g.length > 0) {
                                                        this.O.a(a7, k.g);
                                                    }
                                                }
                                                this.y.a(a7, d6);
                                                p6 = p6.a();
                                                if (i) {
                                                    break;
                                                }
                                            }
                                            this.v.b(y3);
                                            try {
                                                final E e4 = this;
                                                if (e4.K != null && q != null) {
                                                    ((L)this.t()).a(this.K.b(q));
                                                }
                                                this.S.c(this.x);
                                            }
                                            finally {
                                                if (this.K != null && q != null) {
                                                    ((L)this.t()).a(null);
                                                }
                                            }
                                        }
                                        Rectangle2D a8 = null;
                                        Label_4474: {
                                            if (b) {
                                                a8 = null;
                                                p p7 = f.k();
                                                while (true) {
                                                    while (p7 != null) {
                                                        this.x.a((d)p7.c());
                                                        p7 = p7.a();
                                                        if (i) {
                                                            while (true) {
                                                                while (p7 != null) {
                                                                    this.x.a((q)p7.c());
                                                                    p7 = p7.a();
                                                                    if (i) {
                                                                        while (p7 != null) {
                                                                            this.x.a((q)p7.c());
                                                                            p7 = p7.a();
                                                                        }
                                                                        break Label_4474;
                                                                    }
                                                                    if (i) {
                                                                        break;
                                                                    }
                                                                }
                                                                p7 = y2.k();
                                                                continue Label_4186_Outer;
                                                            }
                                                        }
                                                        if (i) {
                                                            break;
                                                        }
                                                    }
                                                    p7 = y3.k();
                                                    continue Label_4186_Outer;
                                                }
                                            }
                                            final y.c.c c3 = this.x.c(y.f.U.a);
                                            if (q != null) {
                                                a8 = this.R.a(this.x, q, y);
                                                final G g = (G)this.z.b(q);
                                                g.a = a8;
                                                if (c3 != null) {
                                                    final ArrayList<S> b3 = new ArrayList<S>(10);
                                                    final x o5 = this.x.o();
                                                Label_3473:
                                                    while (o5.f()) {
                                                        d d8 = o5.e().f();
                                                        while (true) {
                                                            while (d8 != null) {
                                                                final S[] array = (S[])c3.b(d8);
                                                                if (!i) {
                                                                    Label_3456: {
                                                                        if (array != null) {
                                                                            int l = array.length - 1;
                                                                            while (l >= 0) {
                                                                                b3.add(array[l]);
                                                                                --l;
                                                                                if (i) {
                                                                                    break Label_3456;
                                                                                }
                                                                                if (i) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                        d8 = d8.g();
                                                                    }
                                                                    if (i) {
                                                                        break;
                                                                    }
                                                                    continue Label_1736_Outer;
                                                                }
                                                                else {
                                                                    if (i) {
                                                                        break Label_3473;
                                                                    }
                                                                    continue Label_3473;
                                                                }
                                                            }
                                                            o5.g();
                                                            continue Label_4186_Outer;
                                                        }
                                                    }
                                                    g.b = b3;
                                                }
                                            }
                                            else {
                                                a8 = new Rectangle2D.Double();
                                            }
                                            final double centerX = a8.getCenterX();
                                            final double centerY = a8.getCenterY();
                                            p p8 = f.k();
                                        Label_3513:
                                            while (true) {
                                            Label_4186:
                                                while (true) {
                                                Label_4243:
                                                    while (true) {
                                                    Label_3833:
                                                        while (p8 != null) {
                                                            final d d9 = (d)p8.c();
                                                            final d d10 = (d)this.y.b(d9);
                                                            final List a9 = this.a(d10);
                                                            final y.f.I b4 = this.x.b((Object)d9);
                                                            final t sourcePoint = b4.getSourcePoint();
                                                            final q c4 = d9.c();
                                                            if (!i) {
                                                                if (c4 == d10.c()) {
                                                                    a9.add(new Point2D.Double(sourcePoint.a, sourcePoint.b));
                                                                }
                                                                t p9 = this.x.p(d9);
                                                                int n4 = 0;
                                                            Label_3812_Outer:
                                                                while (true) {
                                                                    while (true) {
                                                                        while (n4 < b4.pointCount()) {
                                                                            final t point = b4.getPoint(n4);
                                                                            a9.add(new Point2D.Double(point.a - p9.a, point.b - p9.b));
                                                                            p9 = point;
                                                                            ++n4;
                                                                            if (!i) {
                                                                                if (i) {
                                                                                    break;
                                                                                }
                                                                                continue Label_1736_Outer;
                                                                            }
                                                                            else {
                                                                                final t q6 = this.x.q(d9);
                                                                                a9.add(new Point2D.Double(q6.a - p9.a, q6.b - p9.b));
                                                                                this.x.a(d9);
                                                                                p8 = p8.a();
                                                                                if (i) {
                                                                                    break Label_3833;
                                                                                }
                                                                                continue Label_3513;
                                                                            }
                                                                        }
                                                                        if (d9.d() == d10.d()) {
                                                                            final List b5 = this.b(d10);
                                                                            final t targetPoint = b4.getTargetPoint();
                                                                            b5.add(new Point2D.Double(targetPoint.a, targetPoint.b));
                                                                            continue Label_4186_Outer;
                                                                        }
                                                                        break;
                                                                    }
                                                                    continue Label_3812_Outer;
                                                                }
                                                            }
                                                            else {
                                                            Label_4183_Outer:
                                                                while (true) {
                                                                    final q q7 = c4;
                                                                    if (i) {
                                                                        return a8;
                                                                    }
                                                                    while (true) {
                                                                        q c5 = null;
                                                                        c5.g();
                                                                        final d f2;
                                                                        d d11 = f2;
                                                                    Label_4188:
                                                                        while (true) {
                                                                            if (d11 != null) {
                                                                                final d d12 = (d)this.y.b(d11);
                                                                                final List list = this.a(d12);
                                                                                final y.f.I m = this.x.b((Object)d11);
                                                                                c5 = d11.c();
                                                                                if (i) {
                                                                                    continue Label_4186_Outer;
                                                                                }
                                                                                d12.c();
                                                                                final q d13;
                                                                                final q d14;
                                                                                if (d13 == d14) {
                                                                                    final t sourcePoint2 = m.getSourcePoint();
                                                                                    list.add(new Point2D.Double(sourcePoint2.a, sourcePoint2.b));
                                                                                }
                                                                                t p10 = this.x.p(d11);
                                                                                int n5 = 0;
                                                                                while (n5 < m.pointCount()) {
                                                                                    final t point2 = m.getPoint(n5);
                                                                                    list.add(new Point2D.Double(point2.a - p10.a, point2.b - p10.b));
                                                                                    p10 = point2;
                                                                                    ++n5;
                                                                                    if (i) {
                                                                                        continue Label_4188;
                                                                                    }
                                                                                    if (i) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                final t q8 = this.x.q(d11);
                                                                                list.add(new Point2D.Double(q8.a - p10.a, q8.b - p10.b));
                                                                                this.a(d12, q8.a - centerX, q8.b - centerY);
                                                                                d11 = d11.h();
                                                                                if (!i) {
                                                                                    continue Label_4188;
                                                                                }
                                                                            }
                                                                            break;
                                                                        }
                                                                        break;
                                                                    }
                                                                    this.x.a(q7);
                                                                    p8 = p8.a();
                                                                    if (i) {
                                                                        break Label_4474;
                                                                    }
                                                                    if (p8 != null) {
                                                                        final q q9 = (q)p8.c();
                                                                        continue Label_4183_Outer;
                                                                    }
                                                                    break;
                                                                }
                                                                break Label_4474;
                                                            }
                                                        }
                                                        p8 = y2.k();
                                                        while (p8 != null) {
                                                            final q q7 = (q)p8.c();
                                                            final d f2 = q7.f();
                                                            if (i) {
                                                                continue Label_4186;
                                                            }
                                                            d d11 = f2;
                                                        Label_3867:
                                                            while (d11 != null) {
                                                                final d d12 = (d)this.y.b(d11);
                                                                final List list = this.b(d12);
                                                                final y.f.I m = this.x.b((Object)d11);
                                                                final q d13 = d11.d();
                                                                final q d14 = d12.d();
                                                                if (i) {
                                                                    continue Label_4243;
                                                                }
                                                                if (d13 == d14) {
                                                                    final t targetPoint2 = m.getTargetPoint();
                                                                    list.add(new Point2D.Double(targetPoint2.a, targetPoint2.b));
                                                                }
                                                                t q10 = this.x.q(d11);
                                                                int n6 = m.pointCount() - 1;
                                                                while (n6 >= 0) {
                                                                    final t point3 = m.getPoint(n6);
                                                                    list.add(new Point2D.Double(point3.a - q10.a, point3.b - q10.b));
                                                                    q10 = point3;
                                                                    --n6;
                                                                    if (i) {
                                                                        continue Label_3867;
                                                                    }
                                                                    if (i) {
                                                                        break;
                                                                    }
                                                                }
                                                                final t p11 = this.x.p(d11);
                                                                list.add(new Point2D.Double(p11.a - q10.a, p11.b - q10.b));
                                                                this.b(d12, p11.a - centerX, p11.b - centerY);
                                                                d11 = d11.g();
                                                                if (i) {
                                                                    break;
                                                                }
                                                            }
                                                            this.x.a(q7);
                                                            p8 = p8.a();
                                                            if (i) {
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    break;
                                                }
                                                p8 = y3.k();
                                                continue;
                                            }
                                        }
                                        this.w.f();
                                        return a8;
                                    }
                                    final Object o6 = (this.I != null) ? this.I.b(d3) : null;
                                    if (o6 != null) {
                                        d5 = hashMap.get(o6);
                                    }
                                    Label_2078: {
                                        if (d5 == null) {
                                            d5 = this.x.d();
                                            this.J.a(d5, y.f.c.K.r);
                                            this.x.b(d5, 0.0, 0.0);
                                            y2.add(d5);
                                            if (o6 != null) {
                                                hashMap.put(o6, d5);
                                                if (this.K == null) {
                                                    break Label_2078;
                                                }
                                                this.K.a(d5, y.g.am.a("UpperGroupNode", o6, this.M.b(q)));
                                                if (!i) {
                                                    break Label_2078;
                                                }
                                            }
                                            if (this.K != null) {
                                                this.K.a(d5, y.g.am.a("UpperDUmmyNode", this.N.b(d3), this.M.b(q)));
                                            }
                                        }
                                    }
                                    final d a10 = this.x.a(d5, a5);
                                    if (this.L != null) {
                                        this.L.a(a10, y.g.am.a("InEdge", this.N.b(d3), this.M.b(q), this.M.b(a5)));
                                    }
                                    Label_2227: {
                                        if (this.D != null) {
                                            final Object b6 = this.I.b(d3);
                                            if (b6 != null) {
                                                this.D.a(a10, b6);
                                                if (a5 == d4) {
                                                    this.E.a(a10, b6);
                                                    if (!i) {
                                                        break Label_2227;
                                                    }
                                                }
                                                a(this.E, a10, a2, this.I, d3);
                                            }
                                        }
                                    }
                                    Label_2374: {
                                        if (a5 != d4) {
                                            this.x.b((Object)a10).setTargetPoint(new t(j.d.x, j.d.y));
                                            this.C.a(a10, y.f.c.E.P);
                                            if (!i) {
                                                break Label_2374;
                                            }
                                        }
                                        if (this.G != null) {
                                            this.C.a(a10, this.G.b(d3));
                                            this.x.b(a10, this.x.o(d3));
                                        }
                                        if (j.h != null && j.h.length > 0) {
                                            this.O.a(a10, j.h);
                                        }
                                    }
                                    this.y.a(a10, d3);
                                    p5 = p5.a();
                                    if (i) {
                                        break;
                                    }
                                }
                                final E e3 = this;
                                continue;
                            }
                        }
                        this.u.d(q5);
                        boolean contains = false;
                    Label_0524:
                        while (contains) {
                            p p12 = this.u.f(q5).k();
                            while (p12 != null) {
                                final d d15 = (d)p12.c();
                                contains = set4.contains(d15);
                                if (i) {
                                    continue Label_0524;
                                }
                                if (!contains) {
                                    final y.f.c.I i2 = (y.f.c.I)this.y.b(d15);
                                    final q c6 = d15.c();
                                    final q a11 = this.u.a(c6, q);
                                    if (a11 != null && this.u.a(a11) == q) {
                                        final d a12 = this.x.a(a11, q5);
                                        if (this.L != null) {
                                            this.L.a(a12, y.g.am.a("InEdge", this.N.b(d15), this.M.b(a11), this.M.b(q5)));
                                        }
                                        final y.f.I b7 = this.x.b((Object)a12);
                                        b7.setTargetPoint(new t(i2.d.x, i2.d.y));
                                        this.C.a(a12, y.f.c.E.P);
                                        a(this.E, a12, a2, this.I, d15);
                                        Label_1082: {
                                            if (a11 != c6) {
                                                a(this.D, a12, a, this.H, d15);
                                                this.B.a(a12, y.f.c.E.Q);
                                                b7.setSourcePoint(new t(i2.c.x, i2.c.y));
                                                if (i2.i == null || i2.i.length <= 0) {
                                                    break Label_1082;
                                                }
                                                this.O.a(a12, i2.i);
                                                if (!i) {
                                                    break Label_1082;
                                                }
                                            }
                                            a(this.D, a12, this.H, d15);
                                            Label_1009: {
                                                if ((i2.g != null && i2.g.length > 0) || (i2.i != null && i2.i.length > 0)) {
                                                    if (i2.g != null) {
                                                        if (i2.i != null) {
                                                            this.O.a(a12, this.a(i2.g, i2.i));
                                                            if (!i) {
                                                                break Label_1009;
                                                            }
                                                        }
                                                        this.O.a(a12, i2.g);
                                                        if (!i) {
                                                            break Label_1009;
                                                        }
                                                    }
                                                    this.O.a(a12, i2.i);
                                                }
                                            }
                                            Object o7 = null;
                                            if (this.F != null) {
                                                this.x.a(a12, this.x.n(d15));
                                                o7 = this.F.b(d15);
                                            }
                                            if (a11 == q5 && o7 == null) {
                                                o7 = aE.a((byte)2, false);
                                            }
                                            this.B.a(a12, o7);
                                        }
                                        f.add(a12);
                                        set4.add(d15);
                                        this.y.a(a12, d15);
                                    }
                                }
                                p12 = p12.a();
                                if (i) {
                                    break;
                                }
                            }
                            p p13 = this.u.g(q5).k();
                            while (p13 != null) {
                                final d d16 = (d)p13.c();
                                final boolean contains2 = set4.contains(d16);
                                if (i) {
                                    continue Label_0524;
                                }
                                if (!contains2) {
                                    final y.f.c.I i3 = (y.f.c.I)this.y.b(d16);
                                    final q d17 = d16.d();
                                    final q a13 = this.u.a(d17, q);
                                    if (a13 != null && this.u.a(a13) == q) {
                                        final d a14 = this.x.a(q5, a13);
                                        if (this.L != null) {
                                            this.L.a(a14, y.g.am.a("OutEdge", this.N.b(d16), this.M.b(q5), this.M.b(a13)));
                                        }
                                        final y.f.I b8 = this.x.b((Object)a14);
                                        b8.setSourcePoint(new t(i3.c.x, i3.c.y));
                                        this.B.a(a14, y.f.c.E.Q);
                                        a(this.D, a14, a, this.H, d16);
                                        Label_1680: {
                                            if (a13 != d17) {
                                                a(this.E, a14, a2, this.I, d16);
                                                this.C.a(a14, y.f.c.E.P);
                                                b8.setTargetPoint(new t(i3.d.x, i3.d.y));
                                                if (i3.i == null || i3.i.length <= 0) {
                                                    break Label_1680;
                                                }
                                                this.O.a(a14, i3.i);
                                                if (!i) {
                                                    break Label_1680;
                                                }
                                            }
                                            a(this.E, a14, this.I, d16);
                                            Label_1607: {
                                                if ((i3.h != null && i3.h.length > 0) || (i3.i != null && i3.i.length > 0)) {
                                                    if (i3.h != null) {
                                                        if (i3.i != null) {
                                                            this.O.a(a14, this.a(i3.i, i3.h));
                                                            if (!i) {
                                                                break Label_1607;
                                                            }
                                                        }
                                                        this.O.a(a14, i3.h);
                                                        if (!i) {
                                                            break Label_1607;
                                                        }
                                                    }
                                                    this.O.a(a14, i3.i);
                                                }
                                            }
                                            Object o8 = null;
                                            if (this.G != null) {
                                                this.x.b(a14, this.x.o(d16));
                                                o8 = this.G.b(d16);
                                            }
                                            if (a13 == q5 && o8 == null) {
                                                o8 = aE.a((byte)1, false);
                                            }
                                            this.C.a(a14, o8);
                                        }
                                        f.add(a14);
                                        set4.add(d16);
                                        this.y.a(a14, d16);
                                    }
                                }
                                p13 = p13.a();
                                if (i) {
                                    break;
                                }
                            }
                            break;
                        }
                        p4 = p4.a();
                        if (i) {
                            break;
                        }
                    }
                    final E e = this;
                    continue;
                }
            }
            HashSet<d> set3 = new HashSet<d>();
            continue Label_0478;
        }
    }
    
    private Map x() {
        final boolean i = y.f.c.a.i;
        final at at = new at(this.n());
        final ah s = this.S;
        final J v = this.v;
        final v o = this.o();
        try {
            final F f = new F(this, at);
            f.e = v.e;
            f.d = v.d;
            f.c = v.c;
            super.a((v)(this.v = f));
            super.a((Q)this.v);
            super.a((R)this.v);
            this.S = f;
            p p = this.u.c(this.u.b()).l();
            while (true) {
                while (p != null) {
                    final q q = (q)p.c();
                    final E e = this;
                    if (i) {
                        e.a(this.u.b(), this.u.b(this.u.b()), true);
                        at.a((Object)null);
                        return at.a();
                    }
                    if (this.u.d(q)) {
                        final y b = this.u.b(q);
                        if (b.size() > 0) {
                            f.b = this.M.b(q);
                            this.a(q, b, true);
                        }
                    }
                    p = p.b();
                    if (i) {
                        break;
                    }
                }
                f.b = null;
                final E e = this;
                continue;
            }
        }
        finally {
            this.S = s;
            super.a((v)(this.v = v));
            super.a((Q)this.v);
            super.a((R)this.v);
            this.a(o);
        }
    }
    
    private static final void a(final h h, final Object o, final Object o2, final y.c.c c, final Object o3) {
        if (h != null && c != null) {
            final Object b = c.b(o3);
            if (b != null) {
                h.a(o, y.g.am.a(o2, b));
            }
        }
    }
    
    private static final void a(final h h, final Object o, final y.c.c c, final Object o2) {
        if (h != null && c != null) {
            final Object b = c.b(o2);
            if (b != null) {
                h.a(o, b);
            }
        }
    }
    
    public void c(final X x) {
        super.c(x);
    }
    
    private void a(final d d, final double x, final double y) {
        final y.f.c.I i = (y.f.c.I)this.y.b(d);
        i.c.x = x;
        i.c.y = y;
    }
    
    private void b(final d d, final double x, final double y) {
        final y.f.c.I i = (y.f.c.I)this.y.b(d);
        i.d.x = x;
        i.d.y = y;
    }
    
    private List a(final d d) {
        final y.f.c.I i = (y.f.c.I)this.y.b(d);
        if (i.a == null) {
            i.a = new ArrayList();
        }
        return i.a;
    }
    
    private List b(final d d) {
        final y.f.c.I i = (y.f.c.I)this.y.b(d);
        if (i.b == null) {
            i.b = new ArrayList();
        }
        return i.b;
    }
    
    public void a(final Q d) {
        this.v.d = d;
        super.a((Q)this.v);
    }
    
    public void a(final R c) {
        this.v.c = c;
        super.a((R)this.v);
    }
    
    public R a() {
        return this.v.c;
    }
    
    public Q n() {
        return this.v.d;
    }
    
    public void a(final v e) {
        this.v.e = e;
        super.a((v)this.v);
    }
    
    public v o() {
        return this.v.e;
    }
    
    public void b(final byte b) {
        super.b(b);
        if (this.v != null) {
            this.a(super.o());
        }
    }
    
    public void c(final byte b) {
        super.c(b);
        if (this.v != null) {
            this.a(super.a());
        }
    }
    
    void d(final X x) {
        super.a(x);
    }
    
    protected y[] a(final X x, final A a, final int n) {
        final boolean i = a.i;
        if (this.z != null) {
            final x o = x.o();
            while (o.f()) {
                final q e = o.e();
                final E e2 = this;
                if (i) {
                    return e2.a(x, a, n);
                }
                final G g = (G)this.z.b(e);
                if (g != null) {
                    final Rectangle2D a2 = g.a;
                    if (a2 != null) {
                        this.x.b(e, a2.getWidth(), a2.getHeight());
                    }
                }
                o.g();
                if (i) {
                    break;
                }
            }
        }
        final E e2 = this;
        return e2.a(x, a, n);
    }
    
    public boolean p() {
        return this.U;
    }
    
    static X a(final E e) {
        return e.x;
    }
    
    static {
        P = aE.a((byte)1, true);
        Q = aE.a((byte)2, true);
    }
}
