package y.h;

import y.b.*;
import java.awt.geom.*;
import y.g.*;
import y.d.*;
import y.c.*;
import java.awt.*;
import y.f.*;
import java.util.*;

final class dl implements d
{
    final bu a;
    final O b;
    Point2D c;
    double[] d;
    double[] e;
    double[] f;
    double[] g;
    boolean[] h;
    double[][] i;
    double[][] j;
    t[] k;
    t[] l;
    Point2D m;
    double n;
    q o;
    ch p;
    boolean q;
    boolean r;
    int[][] s;
    Map t;
    long u;
    private boolean x;
    private final dj y;
    private d z;
    int v;
    int w;
    
    public dl(final ch p3, final O o, final dj y) {
        this.y = y;
        this.a = p3.getGraph2D();
        this.p = p3;
        this.b = new dm(this.a, o);
        this.u = 300L;
        this.x = true;
    }
    
    public void a(final boolean x) {
        this.x = x;
    }
    
    public long preferredDuration() {
        return this.u;
    }
    
    public void a(final long u) {
        this.u = u;
    }
    
    public void a(final q o) {
        this.o = o;
    }
    
    public void b(final boolean q) {
        this.q = q;
    }
    
    public void initAnimation() {
        final boolean z = fj.z;
        this.c = this.p.getCenter();
        this.n = 0.0;
        this.v = this.p.getVerticalScrollBarPolicy();
        this.w = this.p.getHorizontalScrollBarPolicy();
        final int f = this.a.f();
        this.d = new double[f];
        this.e = new double[f];
        this.f = new double[f];
        this.g = new double[f];
        this.h = new boolean[f];
        final x x = new x();
        final dn dn = new dn(null);
        int n = 0;
        final y.c.x o = this.a.o();
        while (true) {
            do {
                Label_0115: {
                    o.f();
                }
                boolean a = false;
                Label_0122:
            Label_1794_Outer:
                while (a) {
                    final q e = o.e();
                    final am a2 = this.b.a(o.e());
                    this.d[n] = this.a.m(e);
                    this.e[n] = this.a.n(e);
                    this.f[n] = this.a.p(e);
                    this.g[n] = this.a.q(e);
                    final dl dl = this;
                    if (!z) {
                        this.h[n] = (a2.getWidth() != this.f[n] || a2.getHeight() != this.g[n]);
                        final aj[] a_ = this.b.a_(e);
                        if (a_ != null) {
                            final fj t = this.a.t(e);
                            x.setSize(t.getWidth(), t.getHeight());
                            x.setLocation(t.getX(), t.getY());
                            int i = 0;
                            while (i < t.labelCount()) {
                                final eR label = t.getLabel(i);
                                a = a(label.getModelParameter(), a_[i].getModelParameter());
                                if (z) {
                                    continue Label_0122;
                                }
                                Label_0505: {
                                    if (!a) {
                                        final n orientedBox = label.getOrientedBox();
                                        final y.d.q q = new y.d.q(orientedBox.e(), orientedBox.f());
                                        if (label.a().a(q, x, label.getModelParameter()).equals(orientedBox)) {
                                            label.a(dn, new do(orientedBox, a_[i].a().a(q, a2, a_[i].getModelParameter())));
                                            if (!z) {
                                                break Label_0505;
                                            }
                                        }
                                        label.setModelParameter(a_[i].getModelParameter());
                                    }
                                }
                                ++i;
                                if (z) {
                                    break;
                                }
                            }
                        }
                        o.g();
                        ++n;
                        continue Label_0115;
                    }
                    final int h = dl.a.h();
                    this.i = new double[h][];
                    this.j = new double[h][];
                    this.s = new int[h][];
                    this.k = new t[h];
                    this.l = new t[h];
                    final dp dp = new dp(null);
                    (this.t = new LinkedHashMap()).put(null, null);
                    int n2 = 0;
                    final Rectangle2D.Double double1 = new Rectangle2D.Double();
                    final e p = this.a.p();
                    Label_1779:
                    while (true) {
                        do {
                            p.f();
                            boolean a3 = false;
                            Label_0643:
                            while (a3) {
                                final y.c.d a4 = p.a();
                                final aB j = this.a.i(a4);
                                j.calcUnionRect(double1);
                                final I b;
                                final I k = b = this.b.b(a4);
                                if (!z) {
                                    Label_1769: {
                                        if (b == null) {
                                            y.g.o.a((Object)("EdgeLayout is null! " + a4));
                                            if (!z) {
                                                break Label_1769;
                                            }
                                        }
                                        final int bendCount = j.bendCount();
                                        final int pointCount = k.pointCount();
                                        this.k[n2] = j.getSourcePoint();
                                        this.l[n2] = j.getTargetPoint();
                                        final eU b2 = eU.b(j);
                                        if (!this.t.containsKey(b2)) {
                                            this.t.put(b2, b2.g());
                                            b2.a(dp.a(this.k[n2], k.getSourcePoint()));
                                        }
                                        final eU d = eU.d(j);
                                        if (!this.t.containsKey(d)) {
                                            this.t.put(d, d.g());
                                            d.a(dp.a(this.l[n2], k.getTargetPoint()));
                                        }
                                        Label_0893:
                                        Label_1590: {
                                            Label_1465: {
                                                int n7 = 0;
                                                Label_1443: {
                                                Label_1015_Outer:
                                                    while (true) {
                                                        Label_1206: {
                                                            int n3 = 0;
                                                            int n4 = 0;
                                                            if (n3 > n4) {
                                                                this.i[n2] = new double[pointCount];
                                                                this.j[n2] = new double[pointCount];
                                                                Arrays.fill(this.s[n2] = new int[pointCount], -1);
                                                                int a5 = 0;
                                                                int l = 0;
                                                                final int pointCount2 = j.pointCount();
                                                                while (true) {
                                                                    while (l < pointCount2) {
                                                                        a5 = this.a(j.getPoint(l), k, a5, pointCount2 - l - 1);
                                                                        this.s[n2][a5] = l;
                                                                        ++l;
                                                                        ++a5;
                                                                        if (z) {
                                                                            int n5 = 0;
                                                                            while (n5 < this.s[n2].length) {
                                                                                n3 = this.s[n2][n5];
                                                                                n4 = -1;
                                                                                if (z) {
                                                                                    continue Label_0893;
                                                                                }
                                                                                if (n3 > n4) {
                                                                                    this.a(j, k, n2, l, n5);
                                                                                    l = n5;
                                                                                }
                                                                                ++n5;
                                                                                if (z) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                            this.a(j, k, n2, l, pointCount);
                                                                            int n6 = 0;
                                                                            final y bends = j.bends();
                                                                            while (true) {
                                                                                while (bends.f()) {
                                                                                    final t point = k.getPoint(n6);
                                                                                    this.i[n2][n6] = point.a - bends.a().b();
                                                                                    this.j[n2][n6] = point.b - bends.a().c();
                                                                                    bends.g();
                                                                                    ++n6;
                                                                                    if (!z) {
                                                                                        if (z) {
                                                                                            break;
                                                                                        }
                                                                                        continue Label_1015_Outer;
                                                                                    }
                                                                                    else {
                                                                                        if (z) {
                                                                                            break Label_1206;
                                                                                        }
                                                                                        break Label_1590;
                                                                                    }
                                                                                }
                                                                                this.s[n2] = null;
                                                                                continue Label_1794_Outer;
                                                                            }
                                                                        }
                                                                        if (z) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    l = -1;
                                                                    continue Label_1794_Outer;
                                                                }
                                                            }
                                                        }
                                                        if (pointCount < bendCount) {
                                                            this.i[n2] = new double[bendCount];
                                                            this.j[n2] = new double[bendCount];
                                                            Arrays.fill(this.s[n2] = new int[bendCount], -1);
                                                            int a6 = 0;
                                                            n7 = 0;
                                                            while (true) {
                                                                while (n7 < pointCount) {
                                                                    final t point2 = k.getPoint(n7);
                                                                    a6 = this.a(point2, j, a6, pointCount - n7 - 1);
                                                                    this.s[n2][a6] = n7;
                                                                    final y.h.x bend = j.getBend(a6);
                                                                    this.i[n2][a6] = point2.a() - bend.b();
                                                                    this.j[n2][a6] = point2.b() - bend.c();
                                                                    ++n7;
                                                                    ++a6;
                                                                    if (z) {
                                                                        int n8 = 0;
                                                                        while (n8 < this.s[n2].length) {
                                                                            final int n9 = this.s[n2][n8];
                                                                            final int n10 = -1;
                                                                            if (z) {
                                                                                continue Label_0893;
                                                                            }
                                                                            if (n9 > n10) {
                                                                                this.a(k, j, n2, n7, n8);
                                                                                n7 = n8;
                                                                            }
                                                                            ++n8;
                                                                            if (z) {
                                                                                break;
                                                                            }
                                                                        }
                                                                        break Label_1443;
                                                                    }
                                                                    if (z) {
                                                                        break;
                                                                    }
                                                                }
                                                                n7 = -1;
                                                                continue Label_1794_Outer;
                                                            }
                                                        }
                                                        break Label_1465;
                                                    }
                                                }
                                                this.a(k, j, n2, n7, j.pointCount());
                                                if (!z) {
                                                    break Label_1590;
                                                }
                                            }
                                            this.i[n2] = new double[bendCount];
                                            this.j[n2] = new double[bendCount];
                                            int n11 = 0;
                                            final y bends2 = j.bends();
                                            while (bends2.f()) {
                                                final t point3 = k.getPoint(n11);
                                                this.i[n2][n11] = point3.a() - bends2.a().b();
                                                this.j[n2][n11] = point3.b() - bends2.a().c();
                                                bends2.g();
                                                ++n11;
                                                if (z) {
                                                    continue Label_1779;
                                                }
                                                if (z) {
                                                    break;
                                                }
                                            }
                                        }
                                        final C[] d2 = this.b.d(a4);
                                        if (d2 != null) {
                                            int n12 = 0;
                                            while (n12 < j.labelCount()) {
                                                final aA label2 = j.getLabel(n12);
                                                a3 = a(label2.getModelParameter(), d2[n12].getModelParameter());
                                                if (z) {
                                                    continue Label_0643;
                                                }
                                                if (!a3) {
                                                    final n orientedBox2 = label2.getOrientedBox();
                                                    label2.setLabelModel(dn, new do(orientedBox2, d2[n12].getLabelModel().a(new y.d.q(orientedBox2.e(), orientedBox2.f()), k, this.b.a(a4.c()), this.b.a(a4.d()), d2[n12].getModelParameter())));
                                                }
                                                ++n12;
                                                if (z) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    p.g();
                                    ++n2;
                                    continue Label_1779;
                                }
                                if (this.o != null) {
                                    final am a7 = this.b.a(this.o);
                                    this.m = new Point2D.Double(a7.getX() + a7.getWidth() * 0.5, a7.getY() + a7.getHeight() * 0.5);
                                }
                                else if (this.q) {
                                    this.p.setScrollBarPolicy(21, 31);
                                    this.p.adjustScrollBarVisibility();
                                    final Rectangle a8 = this.b.a();
                                    this.a(this.a, this.b, a8);
                                    this.m = new Point2D.Double(a8.getX() + a8.getWidth() * 0.5, a8.getY() + a8.getHeight() * 0.5);
                                    final Rectangle visibleRect = this.p.getVisibleRect();
                                    final double zoom = this.p.getZoom();
                                    this.p.fitRectangle(a8);
                                    final double zoom2 = this.p.getZoom();
                                    this.p.fitRectangle(visibleRect);
                                    this.p.setZoom(zoom);
                                    (this.z = new gJ(this.p).a(zoom2, y.g.w.a(this.m), this.u)).initAnimation();
                                }
                                else {
                                    if (this.r) {
                                        this.p.setScrollBarPolicy(21, 31);
                                        this.p.adjustScrollBarVisibility();
                                        if (!z) {
                                            return;
                                        }
                                    }
                                    final Rectangle a9 = this.b.a();
                                    if (a9 != null) {
                                        this.a(this.a, this.b, a9);
                                        this.p.setScrollBarPolicy(21, 31);
                                        this.p.adjustScrollBarVisibility();
                                        this.p.fitRectangle(a9);
                                    }
                                }
                                return;
                            }
                            break;
                        } while (!z);
                        this.t.remove(null);
                        continue;
                    }
                }
                break;
            } while (!z);
            final dl dl = this;
            continue;
        }
    }
    
    private static boolean a(final Object o, final Object o2) {
        return (o == null) ? (o == o2) : o.equals(o2);
    }
    
    private void a(final aB ab, final I i, final int n, final int n2, final int n3) {
        final boolean z = fj.z;
        if (n2 >= n3 - 1) {
            return;
        }
        t point = null;
        Label_0084: {
            if (n2 == -1) {
                final fj sourceRealizer = ab.getSourceRealizer();
                final t sourcePoint = ab.getSourcePoint();
                point = new t(sourcePoint.a() + sourceRealizer.getCenterX(), sourcePoint.b() + sourceRealizer.getCenterY());
                if (!z) {
                    break Label_0084;
                }
            }
            point = ab.getPoint(this.s[n][n2]);
        }
        t point2 = null;
        Label_0158: {
            if (i.pointCount() == n3) {
                final fj targetRealizer = ab.getTargetRealizer();
                final t targetPoint = ab.getTargetPoint();
                point2 = new t(targetPoint.a() + targetRealizer.getCenterX(), targetPoint.b() + targetRealizer.getCenterY());
                if (!z) {
                    break Label_0158;
                }
            }
            point2 = ab.getPoint(this.s[n][n3]);
        }
        Label_0238: {
            if (ab.bendCount() == 0 || i.pointCount() == n3) {
                int j = n2 + 1;
                while (j < n3) {
                    final t a = a(i.getPoint(j), point, point2);
                    if (ab.appendBend(a.a(), a.b()) == null) {
                        break;
                    }
                    ++j;
                    if (z) {
                        break Label_0238;
                    }
                }
                return;
            }
        }
        final y.h.x bend = ab.getBend(this.s[n][n3]);
        int k = n2 + 1;
        while (k < n3) {
            final t a2 = a(i.getPoint(k), point, point2);
            if (ab.createBend(a2.a(), a2.b(), bend, 1) == null) {
                break;
            }
            ++k;
            if (z) {
                break;
            }
        }
    }
    
    private void a(final I i, final aB ab, final int n, final int n2, final int n3) {
        final boolean z = fj.z;
        if (n2 >= n3 - 1) {
            return;
        }
        t point = null;
        Label_0128: {
            if (-1 == n2) {
                final am a = this.b.a(ab.getEdge().c());
                final t sourcePoint = i.getSourcePoint();
                point = new t(sourcePoint.a() + a.getX() + a.getWidth() * 0.5, sourcePoint.b() + a.getY() + a.getHeight() * 0.5);
                if (!z) {
                    break Label_0128;
                }
            }
            point = i.getPoint(this.s[n][n2]);
        }
        t point2 = null;
        Label_0244: {
            if (ab.pointCount() == n3) {
                final am a2 = this.b.a(ab.getEdge().d());
                final t targetPoint = i.getTargetPoint();
                point2 = new t(targetPoint.a() + a2.getX() + a2.getWidth() * 0.5, targetPoint.b() + a2.getY() + a2.getHeight() * 0.5);
                if (!z) {
                    break Label_0244;
                }
            }
            point2 = i.getPoint(this.s[n][n3]);
        }
        int j = n2 + 1;
        while (j < n3) {
            final y.h.x bend = ab.getBend(j);
            final t a3 = a(bend.b(), bend.c(), point, point2);
            this.i[n][j] = a3.a() - bend.b();
            this.j[n][j] = a3.b() - bend.c();
            ++j;
            if (z) {
                break;
            }
        }
    }
    
    private int a(final t t, final I i, final int n, final int n2) {
        final boolean z = fj.z;
        double n3 = Double.MAX_VALUE;
        int n4 = n;
        final int pointCount = i.pointCount();
        while (n4 + n2 < pointCount) {
            final int n5 = n4;
            if (z || n5 >= pointCount) {
                return n5;
            }
            final t point = i.getPoint(n4);
            final double n6 = t.a() - point.a();
            final double n7 = t.b() - point.b();
            final double n8 = n6 * n6 + n7 * n7;
            if (n3 > n8) {
                n3 = n8;
            }
            ++n4;
            if (z) {
                goto Label_0117;
            }
        }
        goto Label_0117;
    }
    
    Rectangle2D a(final i i, final O o, final Rectangle2D rectangle2D) {
        return this.y.calcBoundingBox(i, o, rectangle2D);
    }
    
    public void calcFrame(final double n) {
        final boolean z = fj.z;
        final double n2 = n - this.n;
        final double n3 = 1.0 - n;
        this.n = n;
        Label_1164: {
            Label_1105: {
                Label_0686: {
                    if (n < 1.0) {
                        int n4 = 0;
                        final y.c.x o = this.a.o();
                        while (true) {
                            do {
                                Label_0040: {
                                    o.f();
                                }
                                boolean b = false;
                                Label_0047:
                                while (b) {
                                    final q e = o.e();
                                    final am a = this.b.a(e);
                                    final fj t = this.a.t(e);
                                    final int n6;
                                    final int n5 = n6 = (this.h[n4] ? 1 : 0);
                                    if (!z) {
                                        if (n5 != 0) {
                                            t.setSize(n3 * this.f[n4] + n * a.getWidth(), n3 * this.g[n4] + n * a.getHeight());
                                        }
                                        t.setLocation(n3 * this.d[n4] + n * a.getX(), n3 * this.e[n4] + n * a.getY());
                                        int i = 0;
                                        while (i < t.labelCount()) {
                                            final eR label = t.getLabel(i);
                                            final Object modelParameter = label.getModelParameter();
                                            b = (modelParameter instanceof do);
                                            if (z) {
                                                continue Label_0047;
                                            }
                                            if (b) {
                                                ((do)modelParameter).a(n3, n);
                                                label.setOffsetDirty();
                                            }
                                            ++i;
                                            if (z) {
                                                break;
                                            }
                                        }
                                        o.g();
                                        ++n4;
                                        continue Label_0040;
                                    }
                                    int n7 = n6;
                                    final e p = this.a.p();
                                    do {
                                        Label_0285:
                                        p.f();
                                        boolean b2 = false;
                                        Label_0292:
                                        while (b2) {
                                            final y.c.d a2 = p.a();
                                            final I b3 = this.b.b(a2);
                                            final aB j = this.a.i(a2);
                                            final t sourcePoint = b3.getSourcePoint();
                                            final t t2 = this.k[n7];
                                            j.getSourcePort().b(n3 * t2.a() + n * sourcePoint.a(), n3 * t2.b() + n * sourcePoint.b());
                                            final t targetPoint = b3.getTargetPoint();
                                            final t t3 = this.l[n7];
                                            j.getTargetPort().b(n3 * t3.a() + n * targetPoint.a(), n3 * t3.b() + n * targetPoint.b());
                                            int k = 0;
                                            if (!z) {
                                                final y bends = j.bends();
                                                while (true) {
                                                    while (bends.f()) {
                                                        bends.a().b(n2 * this.i[n7][k], n2 * this.j[n7][k]);
                                                        bends.g();
                                                        ++k;
                                                        if (z) {
                                                            while (k < j.labelCount()) {
                                                                final aA label2 = j.getLabel(k);
                                                                final Object modelParameter2 = label2.getModelParameter();
                                                                b2 = (modelParameter2 instanceof do);
                                                                if (z) {
                                                                    continue Label_0292;
                                                                }
                                                                if (b2) {
                                                                    ((do)modelParameter2).a(n3, n);
                                                                    label2.setOffsetDirty();
                                                                }
                                                                ++k;
                                                                if (z) {
                                                                    break;
                                                                }
                                                            }
                                                            p.g();
                                                            ++n7;
                                                            continue Label_0285;
                                                        }
                                                        if (z) {
                                                            break;
                                                        }
                                                    }
                                                    k = 0;
                                                    continue;
                                                }
                                            }
                                            break Label_1105;
                                        }
                                        break;
                                    } while (!z);
                                    if (!this.t.isEmpty()) {
                                        final Iterator<eU> iterator = this.t.keySet().iterator();
                                        while (iterator.hasNext()) {
                                            ((dq)iterator.next().g()).a(n3, n);
                                            if (z) {
                                                break Label_1164;
                                            }
                                            if (z) {
                                                break Label_0686;
                                            }
                                        }
                                    }
                                    break Label_1105;
                                }
                                break;
                            } while (!z);
                            int n6 = 0;
                            continue;
                        }
                    }
                }
                final y.c.x o2 = this.a.o();
                while (o2.f()) {
                    final q e2 = o2.e();
                    final aj[] a_ = this.b.a_(e2);
                    if (z) {
                        break Label_1105;
                    }
                    Label_0819: {
                        if (a_ != null) {
                            final fj t4 = this.a.t(e2);
                            int l = 0;
                            while (l < t4.labelCount()) {
                                t4.getLabel(l).a(a_[l].a(), a_[l].getModelParameter());
                                ++l;
                                if (z) {
                                    break Label_0819;
                                }
                                if (z) {
                                    break;
                                }
                            }
                        }
                        o2.g();
                    }
                    if (z) {
                        break;
                    }
                }
                final e p2 = this.a.p();
                while (true) {
                    while (p2.f()) {
                        final y.c.d a3 = p2.a();
                        final C[] d = this.b.d(a3);
                        if (!z) {
                            Label_0957: {
                                if (d != null) {
                                    final aB m = this.a.i(a3);
                                    int n8 = 0;
                                    while (n8 < m.labelCount()) {
                                        m.getLabel(n8).setLabelModel(d[n8].getLabelModel(), d[n8].getModelParameter());
                                        ++n8;
                                        if (z) {
                                            break Label_0957;
                                        }
                                        if (z) {
                                            break;
                                        }
                                    }
                                }
                                p2.g();
                            }
                            if (z) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (!this.t.isEmpty()) {
                                for (final Map.Entry<eU, V> entry : this.t.entrySet()) {
                                    final eU eu = entry.getKey();
                                    ((dq)eu.g()).a(0.0, 1.0);
                                    eu.a(entry.getValue().a().a(eu.b(), eu.h()));
                                    if (z) {
                                        break Label_1164;
                                    }
                                    if (z) {
                                        break;
                                    }
                                }
                            }
                            break Label_1105;
                        }
                    }
                    ae.a(this.a, this.b);
                    continue;
                }
            }
            if (this.o != null) {
                this.p.setCenter(n3 * this.c.getX() + n * this.m.getX(), n3 * this.c.getY() + n * this.m.getY());
                if (!z) {
                    return;
                }
            }
        }
        if (this.q && this.z != null) {
            this.z.calcFrame(n);
        }
    }
    
    public void disposeAnimation() {
        this.t = null;
        if (this.z != null) {
            this.z.disposeAnimation();
        }
        this.p.fitWorldRect();
        this.p.updateWorldRect();
        this.p.setScrollBarPolicy(this.v, this.w);
        this.p.q();
        this.p.adjustScrollBarVisibility();
    }
    
    private static t a(final t t, final t t2, final t t3) {
        return y.d.e.b(t.a(), t.b(), t2.a(), t2.b(), t3.a(), t3.b());
    }
    
    private static t a(final double n, final double n2, final t t, final t t2) {
        return y.d.e.b(n, n2, t.a(), t.b(), t2.a(), t2.b());
    }
    
    public void c(final boolean r) {
        this.r = r;
    }
}
