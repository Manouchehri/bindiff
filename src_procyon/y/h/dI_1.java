package y.h;

import y.d.*;
import java.beans.*;
import java.awt.event.*;
import y.g.*;
import y.c.*;
import java.util.*;
import java.awt.geom.*;
import y.h.a.*;
import java.awt.*;

public class dI extends gX
{
    double a;
    double b;
    protected fL c;
    dN d;
    protected D e;
    fj f;
    aB g;
    private boolean h;
    private boolean i;
    private boolean j;
    private dO k;
    private boolean l;
    private t m;
    private double n;
    private t o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private t t;
    private boolean u;
    private dU v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;
    private o A;
    private PropertyChangeListener B;
    private int C;
    private final Ellipse2D D;
    
    public dI() {
        this(null);
    }
    
    public dI(final gU gu) {
        super(gu);
        this.h = true;
        this.k = new dO();
        this.n = 10.0;
        this.p = true;
        this.q = true;
        this.r = true;
        this.s = true;
        this.C = 2;
        this.D = new Ellipse2D.Double();
        (this.v = new dU(null)).b(false);
        this.v.d(false);
        this.v.c(true);
        this.v.g(true);
        this.v.b(10.0);
        this.v.c(20.0);
        this.B = new dJ(this);
    }
    
    public void a(final boolean w) {
        this.w = w;
    }
    
    public boolean a() {
        return this.p;
    }
    
    public boolean c() {
        return this.q;
    }
    
    public int e() {
        return this.C;
    }
    
    protected boolean a(final MouseEvent mouseEvent) {
        return (mouseEvent.getModifiers() & this.e()) != 0x0;
    }
    
    public boolean f() {
        return this.j;
    }
    
    protected cW getHitInfo(final double n, final double n2) {
        final cW lastHitInfo = new cW(this.view, n, n2, true, 0);
        this.setLastHitInfo(lastHitInfo);
        return lastHitInfo;
    }
    
    public void mousePressedLeft(final double a, final double b) {
        final boolean z = fj.z;
        final cW hitInfo = this.getHitInfo(a, b);
        Label_1018: {
            if (hitInfo.q()) {
                final bu graph2D = this.getGraph2D();
                this.setEditing(true);
                this.c = hitInfo.n();
                final C f = hitInfo.f();
                while (true) {
                    while (f.f()) {
                        final fL c = (fL)f.d();
                        if (!z) {
                            if (c == c.d().getTargetPort()) {
                                this.c = c;
                                if (!z) {
                                    break;
                                }
                            }
                            f.g();
                            if (z) {
                                break;
                            }
                            continue;
                        }
                        else {
                            final d edge = this.g.getEdge();
                            this.l = false;
                            this.k.j();
                            final boolean f2 = this.f();
                            if (f2) {
                                graph2D.r();
                                this.l = true;
                                this.view.addDrawable(this.k);
                            }
                            graph2D.a(new f(edge).a());
                            this.g = this.c.d();
                            Label_0570: {
                                if (this.c == this.g.getSourcePort()) {
                                    this.i = true;
                                    this.f = this.g.getSourceRealizer();
                                    this.o = graph2D.p(edge);
                                    this.t = ((this.g.bendCount() == 0) ? graph2D.q(this.g.getEdge()) : new t(this.g.firstBend().b(), this.g.firstBend().c()));
                                    if (!f2) {
                                        break Label_0570;
                                    }
                                    this.k.i(this.k.a(this.k.a(this.a(a, b + 50.0)), this.k.a(this.a(this.g.getTargetRealizer())), this.a(this.g))).getSourcePort().b(0.0, 0.0);
                                    if (!z) {
                                        break Label_0570;
                                    }
                                }
                                this.i = false;
                                this.f = this.g.getTargetRealizer();
                                this.o = graph2D.q(edge);
                                this.t = ((this.g.bendCount() == 0) ? graph2D.p(this.g.getEdge()) : new t(this.g.lastBend().b(), this.g.lastBend().c()));
                                if (f2) {
                                    this.k.i(this.k.a(this.k.a(this.a(this.g.getSourceRealizer())), this.k.a(this.a(a, b + 50.0)), this.a(this.g))).getTargetPort().b(0.0, 0.0);
                                }
                            }
                            this.a(this.f, edge);
                            graph2D.N();
                            this.g.setSelected(true);
                            this.g.setVisible(!f2);
                            this.u = this.a(this.g.getEdge());
                            this.d(a, b);
                            Label_0950: {
                                if (this.u && this.w) {
                                    final aB ab = this.k.i() ? this.g : this.k.i(this.k.l());
                                    if (ab.bendCount() == 0) {
                                        this.d(a + 10.0, b + 10.0);
                                        this.d(a, b);
                                    }
                                    final t t = new t(a, b);
                                    x x = null;
                                    Label_0743: {
                                        if (this.i) {
                                            x = ab.firstBend();
                                            if (!z) {
                                                break Label_0743;
                                            }
                                        }
                                        x = ab.lastBend();
                                    }
                                    if (x == null) {
                                        break Label_0950;
                                    }
                                    byte b2 = 0;
                                    Label_0769: {
                                        if (x.b() == a) {
                                            b2 = 1;
                                            if (!z) {
                                                break Label_0769;
                                            }
                                        }
                                        b2 = 2;
                                    }
                                    final em em = new em(this.c, t, (byte)3);
                                    final ek ek = new ek(x, new t(x.b(), x.c()), b2);
                                    final t t2 = new t(a, b);
                                    this.v.a(this.view);
                                    this.v.i();
                                    this.v.b();
                                    this.v.a(t2, Collections.EMPTY_LIST, Collections.singletonList(ek), Collections.singletonList(em), y.g.q.a((Object)null));
                                    if (this.x) {
                                        this.a(b2);
                                    }
                                    if (this.s) {
                                        this.v.a(new dK(this, 0.9, null, t2, ek));
                                    }
                                    this.v.a(new dL(this, 0.9));
                                    if (!z) {
                                        break Label_0950;
                                    }
                                }
                                this.v.f();
                            }
                            if (this.A == null) {
                                graph2D.a(this.A = new dM(this, edge));
                            }
                            this.view.addPropertyChangeListener("Graph2D", this.B);
                            this.view.setDrawingMode(1);
                            this.view.setViewCursor(this.h());
                            if (z) {
                                break Label_1018;
                            }
                            return;
                        }
                    }
                    this.a(this.c);
                    this.a = a;
                    this.b = b;
                    this.g = this.c.d();
                    continue;
                }
            }
        }
        this.c = null;
        this.reactivateParent();
    }
    
    private void j() {
        this.view.removeDrawable(this.k);
        this.k.j();
        this.k();
        if (this.l) {
            this.getGraph2D().s();
            this.l = false;
        }
        if (this.isEditing()) {
            this.setEditing(false);
        }
        this.reactivateParent();
    }
    
    private void a(final byte b) {
        final boolean z = fj.z;
        final double centerY = this.f.getCenterY();
        final double centerX = this.f.getCenterX();
        Label_0244: {
            if (b == 1) {
                final double m = this.v.m();
                if (m > 0.0 && this.f.getWidth() / m < 40.0) {
                    final double n = this.f.getY() - 5.0;
                    final double n2 = this.f.getY() + this.f.getHeight() + 5.0;
                    double n3 = centerX;
                    while (true) {
                        while (n3 > this.f.getX()) {
                            this.v.a(new gy((byte)1, (byte)16, new t(n3, centerY), n, n2, this.f, 0.01));
                            n3 -= m;
                            if (z) {
                                while (n3 < this.f.getX() + this.f.getWidth()) {
                                    this.v.a(new gy((byte)1, (byte)16, new t(n3, centerY), n, n2, this.f, 0.01));
                                    n3 += m;
                                    if (z) {
                                        break Label_0244;
                                    }
                                }
                                return;
                            }
                            if (z) {
                                break;
                            }
                        }
                        n3 = centerX + m;
                        continue;
                    }
                }
                return;
            }
        }
        final double i = this.v.m();
        if (i > 0.0 && this.f.getHeight() / i < 40.0) {
            final double n4 = this.f.getX() - 5.0;
            final double n5 = this.f.getX() + this.f.getWidth() + 5.0;
            double n6 = centerY;
            while (true) {
                while (n6 > this.f.getY()) {
                    this.v.a(new gy((byte)0, (byte)16, new t(centerX, n6), n4, n5, this.f, 0.01));
                    n6 -= i;
                    if (z) {
                        while (n6 < this.f.getY() + this.f.getHeight()) {
                            this.v.a(new gy((byte)0, (byte)16, new t(centerX, n6), n4, n5, this.f, 0.01));
                            n6 += i;
                            if (z) {
                                break;
                            }
                        }
                        return;
                    }
                    if (z) {
                        break;
                    }
                }
                n6 = centerY + i;
                continue;
            }
        }
    }
    
    protected aB a(final aB ab) {
        return ab.createCopy();
    }
    
    protected fj a(final fj fj) {
        return fj.createCopy();
    }
    
    protected fj a(final double n, final double n2) {
        final gn gn = new gn();
        gn.setSize(0.1, 0.1);
        gn.setVisible(false);
        gn.setCenter(n, n2);
        gn.setShapeType((byte)0);
        return gn;
    }
    
    private void a(final fj fj, final d d) {
        final boolean z = fj.z;
        this.view.getGraph2D();
        if (this.d != null) {
            this.view.removeDrawable(this.d);
        }
        double gridResolution = this.view.getGridResolution();
        if (gridResolution <= 0.0) {
            gridResolution = 20.0;
        }
        this.e = this.a(fj.getNode(), d, gridResolution);
        final Rectangle2D.Double double1 = new Rectangle2D.Double(fj.getX() - 10.0, fj.getY() - 10.0, fj.getWidth() + 20.0, fj.getHeight() + 20.0);
        final C m = this.e.m();
        while (m.f()) {
            final t t = (t)m.d();
            double1.add(new Rectangle2D.Double(t.a - 10.0, t.b - 10.0, 20.0, 20.0));
            m.g();
            if (z) {
                return;
            }
            if (z) {
                break;
            }
        }
        this.d = new dN(this, this.e, double1, fj.getNode(), d);
        this.view.addDrawable(this.d);
        this.view.updateView();
    }
    
    protected D a(final y.c.q q, final d d, final double n) {
        if (!this.p) {
            return this.a(q, d);
        }
        if (this.c()) {
            return this.b(q, d);
        }
        return this.view.getGraph2D().t(q).getPortCandidates(n);
    }
    
    private D b(final y.c.q q, final d d) {
        final boolean z = fj.z;
        final D d2 = new D();
        final fj t = this.view.getGraph2D().t(q);
        D d3 = null;
        if (t.portCount() > 0) {
            final Iterator ports = t.ports();
            while (ports.hasNext()) {
                d3 = d2;
                if (z) {
                    break;
                }
                d3.add(ports.next().h());
                if (z) {
                    break;
                }
            }
        }
        return d3;
    }
    
    protected D a(final y.c.q q, final d d) {
        final D d2 = new D();
        final fj t = this.view.getGraph2D().t(q);
        final double centerX = t.getCenterX();
        final double centerY = t.getCenterY();
        if (t.contains(centerX, centerY)) {
            d2.add(new t(centerX, centerY));
            final Point2D.Double double1 = new Point2D.Double();
            if (t.findIntersection(centerX, centerY, t.getX() - 10.0, centerY, double1)) {
                d2.add(new t(double1.x, double1.y));
            }
            if (t.findIntersection(centerX, centerY, t.getX() + t.getWidth() + 10.0, centerY, double1)) {
                d2.add(new t(double1.x, double1.y));
            }
            if (t.findIntersection(centerX, centerY, centerX, t.getY() - 10.0, double1)) {
                d2.add(new t(double1.x, double1.y));
            }
            if (t.findIntersection(centerX, centerY, centerX, t.getY() + t.getHeight() + 10.0, double1)) {
                d2.add(new t(double1.x, double1.y));
            }
        }
        if (this.i && d.c() == q) {
            d2.add(this.o);
        }
        if (!this.i && d.d() == q) {
            d2.add(this.o);
        }
        return d2;
    }
    
    public void mouseDraggedLeft(double a, double b) {
        if (this.c != null) {
            Label_0145: {
                if (this.f()) {
                    final y.c.q b2 = this.b(a, b);
                    if (b2 == null || b2 == this.f.getNode()) {
                        break Label_0145;
                    }
                    this.f = this.view.getGraph2D().t(b2);
                    final Rectangle bounds = this.d.getBounds();
                    this.a(this.f, this.c.d().getEdge());
                    bounds.add(this.d.getBounds());
                    this.view.updateView(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
                    if (!fj.z) {
                        break Label_0145;
                    }
                }
                this.a(this.f, this.c.d().getEdge());
            }
            this.a = a;
            this.b = b;
            final t a2 = this.a(a, b, this.a(this.lastDragEvent), !this.isModifierPressed(this.lastDragEvent) ^ this.y);
            a = a2.a;
            b = a2.b;
            this.d(this.a = a, this.b = b);
            this.view.updateView();
        }
    }
    
    protected t a(double a, double b, final boolean b2, final boolean b3) {
        if (b3) {
            if (this.v.l()) {
                this.v.h();
            }
            this.m = this.a(a, b, Double.MAX_VALUE);
            if (this.m != null) {
                return this.m;
            }
            return new t(a, b);
        }
        else {
            this.m = null;
            if (b2) {
                if (this.v.l()) {
                    this.v.h();
                }
                return new t(a, b);
            }
            final t a2 = this.a(a, b, this.n);
            if (a2 != null) {
                return this.m = a2;
            }
            if (this.v.l()) {
                final t b4 = this.v.b(new t(a, b));
                a = b4.a;
                b = b4.b;
                return b4;
            }
            final double n = this.n / this.view.getZoom();
            if (this.s) {
                return this.a(a, b, n, this.f, this.t);
            }
            return new t(a, b);
        }
    }
    
    private t a(final double n, final double n2, final double n3) {
        final boolean z = fj.z;
        final t t = new t(n, n2);
        double n4 = n3;
        if (n4 < Double.MAX_VALUE) {
            n4 /= this.view.getZoom();
        }
        final C m = this.e.m();
        t t3 = null;
        while (m.f()) {
            final t t2 = (t)m.d();
            t3 = t;
            if (z) {
                return t3;
            }
            final double a = y.d.t.a(t3, t2);
            if (a < n4) {
                n4 = a;
            }
            m.g();
            if (z) {
                break;
            }
        }
        return t3;
    }
    
    protected y.c.q b(final double n, final double n2) {
        if (this.i) {
            if (this.c.d().getSourceRealizer().contains(n, n2)) {
                return this.c.d().getEdge().c();
            }
        }
        else if (this.c.d().getTargetRealizer().contains(n, n2)) {
            return this.c.d().getEdge().d();
        }
        return this.c(n, n2).i();
    }
    
    protected cW c(final double n, final double n2) {
        return this.b(n, n2, 4, true);
    }
    
    protected void d(final double n, final double n2) {
        final boolean z = fj.z;
        bu bu = null;
        aB ab = null;
        Label_0057: {
            if (this.k.i()) {
                bu = this.getGraph2D();
                ab = this.c.d();
                if (!z) {
                    break Label_0057;
                }
            }
            bu = this.k;
            ab = this.k.i(this.k.l());
        }
        Label_0107: {
            if (this.i) {
                bu.c(ab.getEdge(), new t(n, n2));
                if (!z) {
                    break Label_0107;
                }
            }
            bu.d(ab.getEdge(), new t(n, n2));
        }
        if (this.u) {
            ic.a(this.view, ab, n, n2, this.i);
        }
    }
    
    private t a(double a, double b, final double n, final fj fj, final t t) {
        t t2 = null;
        final boolean contains = fj.contains(a, b);
        final double n2 = a;
        final double n3 = b;
        if (this.r) {
            if (Math.abs(t.a - a) < n) {
                a = t.a;
            }
            if (Math.abs(t.b - b) < n) {
                b = t.b;
            }
        }
        if (this.s) {
            final double n4 = a - t.a;
            final double n5 = b - t.b;
            final double sqrt = Math.sqrt(n4 * n4 + n5 * n5);
            if (sqrt > 0.0) {
                final boolean contains2 = fj.contains(a, b);
                final double n6 = a - n * n4 / sqrt;
                final double n7 = b - n * n5 / sqrt;
                if (fj.contains(n6, n7) != contains2) {
                    final Point2D.Double double1 = new Point2D.Double();
                    if (contains2) {
                        if (fj.findIntersection(a, b, n6, n7, double1)) {
                            t2 = new t(double1.x, double1.y);
                        }
                    }
                    else if (fj.findIntersection(n6, n7, a, b, double1)) {
                        t2 = new t(double1.x, double1.y);
                    }
                }
                else {
                    final double n8 = a + n * n4 / sqrt;
                    final double n9 = b + n * n5 / sqrt;
                    if (fj.contains(n8, n9) != contains2) {
                        final Point2D.Double double2 = new Point2D.Double();
                        if (contains2) {
                            if (fj.findIntersection(a, b, n8, n9, double2)) {
                                t2 = new t(double2.x, double2.y);
                            }
                        }
                        else if (fj.findIntersection(n8, n9, a, b, double2)) {
                            t2 = new t(double2.x, double2.y);
                        }
                    }
                }
            }
        }
        if (t2 == null && contains && (n2 != a || n3 != b) && !fj.contains(a, b)) {
            return new t(n2, n3);
        }
        return (t2 != null) ? t2 : new t(a, b);
    }
    
    protected boolean a(final d d) {
        return aC.b(d, this.getGraph2D());
    }
    
    public void mouseShiftReleasedLeft(final double n, final double n2) {
        if (this.h) {
            this.mouseReleasedLeft(n, n2);
            if (!fj.z) {
                return;
            }
        }
        this.a(n, n2, this.y);
    }
    
    private void k() {
        if (this.v != null) {
            this.v.f();
        }
        this.view.setViewCursor(this.i());
        this.view.setDrawingMode(0);
        this.view.removeDrawable(this.d);
        this.d = null;
        this.setEditing(false);
        final bu graph2D = this.getGraph2D();
        if (this.A != null) {
            graph2D.b(this.A);
            this.A = null;
        }
        this.view.removePropertyChangeListener("Graph2D", this.B);
        graph2D.T();
    }
    
    private void l() {
        final boolean z = fj.z;
        if (this.f()) {
            final bu graph2D = this.getGraph2D();
            final v c = graph2D.C();
            final d edge = this.c.d().getEdge();
            if (this.i) {
                if (this.c.d().getSourceRealizer() == this.f) {
                    return;
                }
                final y.c.q node = this.f.getNode();
                final y.c.q d = edge.d();
                Label_0128: {
                    if (c != null && c.e(edge)) {
                        final y.c.q c2 = c.c(edge);
                        c.d(edge).b("HierarchyManager.InterEdgeData.SOURCE_PORT");
                        c.a(edge, node, c2);
                        if (!z) {
                            break Label_0128;
                        }
                    }
                    graph2D.a(edge, node, d);
                }
                this.b(edge);
                if (!z) {
                    return;
                }
            }
            if (this.c.d().getTargetRealizer() != this.f) {
                final y.c.q node2 = this.f.getNode();
                final y.c.q c3 = edge.c();
                Label_0226: {
                    if (c != null && c.e(edge)) {
                        final y.c.q b = c.b(edge);
                        c.d(edge).b("HierarchyManager.InterEdgeData.TARGET_PORT");
                        c.a(edge, b, node2);
                        if (!z) {
                            break Label_0226;
                        }
                    }
                    graph2D.a(edge, c3, node2);
                }
                this.b(edge);
            }
        }
    }
    
    public void mouseReleasedRight(final double n, final double n2) {
        this.mouseReleasedLeft(n, n2);
    }
    
    public void mouseShiftReleasedRight(final double n, final double n2) {
        this.mouseShiftReleasedLeft(n, n2);
    }
    
    public void mouseReleasedLeft(final double n, final double n2) {
        this.a(n, n2, !this.y);
    }
    
    private void a(double a, double b, final boolean b2) {
        if (this.c != null) {
            final t a2 = this.a(a, b, this.a(this.lastReleaseEvent), b2);
            a = a2.a;
            b = a2.b;
            this.d(a, b);
            this.l();
            this.m();
            this.d(a, b);
            this.a(this.c, a, b);
            this.k();
        }
        if (this.l) {
            this.getGraph2D().s();
            this.l = false;
        }
        if (this.isEditing()) {
            this.setEditing(false);
        }
        this.reactivateParent();
    }
    
    protected void b(final d d) {
    }
    
    protected void a(final fL fl) {
    }
    
    protected void a(final fL fl, final double n, final double n2) {
        if (this.a() && this.c()) {
            final aB d = fl.d();
            final eU e = this.e(n, n2);
            if (e != null) {
                if (this.i) {
                    e.a(d);
                    if (!fj.z) {
                        return;
                    }
                }
                e.c(d);
            }
        }
    }
    
    private eU e(final double n, final double n2) {
        return eU.a(this.f, n, n2);
    }
    
    private void m() {
        final boolean z = fj.z;
        if (!this.k.i()) {
            final aB i = this.k.i(this.k.l());
            int j = 0;
            while (true) {
                while (j < i.bendCount()) {
                    final x bend = i.getBend(j);
                    final aB g = this.g;
                    if (z) {
                        g.setVisible(true);
                        this.view.removeDrawable(this.k);
                        this.k.j();
                        return;
                    }
                    Label_0101: {
                        if (g.bendCount() <= j) {
                            this.g.addPoint(bend.b(), bend.c());
                            if (!z) {
                                break Label_0101;
                            }
                        }
                        this.g.getBend(j).a(bend.b(), bend.c());
                    }
                    ++j;
                    if (z) {
                        break;
                    }
                }
                final aB g2 = this.g;
                continue;
            }
        }
    }
    
    protected void a(final Graphics2D graphics2D, final t t, final y.c.q q, final d d) {
        this.a(graphics2D, t, q, d, this.g() || (!this.isModifierPressed(this.lastDragEvent) ^ this.y), t.equals(this.m));
    }
    
    protected void a(final Graphics2D graphics2D, final t t, final y.c.q q, final d d, final boolean b, final boolean b2) {
        final boolean z = fj.z;
        Label_0054: {
            if (b) {
                if (b2) {
                    graphics2D.setColor(Color.green);
                    if (!z) {
                        break Label_0054;
                    }
                }
                graphics2D.setColor(Color.red);
                if (!z) {
                    break Label_0054;
                }
            }
            if (this.y) {
                return;
            }
            graphics2D.setColor(Color.gray);
        }
        this.D.setFrame(t.a() - 3.0, t.b() - 3.0, 6.0, 6.0);
        graphics2D.fill(this.D);
        graphics2D.setColor(Color.black);
        graphics2D.draw(this.D);
    }
    
    public boolean g() {
        return this.h;
    }
    
    public void cancelEditing() {
        if (this.isEditing()) {
            this.mouseReleasedLeft(this.a, this.b);
        }
    }
    
    protected void a(final Graphics2D graphics2D, final fj fj) {
        b(graphics2D, fj);
    }
    
    static void b(final Graphics2D graphics2D, final fj fj) {
        a(graphics2D, (int)fj.getX(), (int)fj.getY(), (int)fj.getWidth(), (int)fj.getHeight());
    }
    
    static void a(final Graphics2D graphics2D, final int n, final int n2, final int n3, final int n4) {
        final Color color = graphics2D.getColor();
        graphics2D.setColor(Color.black);
        a(graphics2D, n, n2, n3, n4, 5);
        a(graphics2D, n, n2, n3, n4, 3);
        graphics2D.setColor(Color.white);
        a(graphics2D, n, n2, n3, n4, 4);
        graphics2D.setColor(color);
    }
    
    private static void a(final Graphics2D graphics2D, final int n, final int n2, final int n3, final int n4, final int n5) {
        graphics2D.drawLine(n - n5, n2 - n5, n, n2 - n5);
        graphics2D.drawLine(n - n5, n2 - n5, n - n5, n2);
        final int n6 = n + n3;
        graphics2D.drawLine(n6 + n5, n2 - n5, n6, n2 - n5);
        graphics2D.drawLine(n6 + n5, n2 - n5, n6 + n5, n2);
        final int n7 = n2 + n4;
        graphics2D.drawLine(n - n5, n7 + n5, n, n7 + n5);
        graphics2D.drawLine(n - n5, n7 + n5, n - n5, n7);
        final int n8 = n + n3;
        graphics2D.drawLine(n8 + n5, n7 + n5, n8, n7 + n5);
        graphics2D.drawLine(n8 + n5, n7 + n5, n8 + n5, n7);
    }
    
    private Rectangle2D n() {
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        if (this.f != null) {
            this.f.calcUnionRect(double1);
        }
        return double1;
    }
    
    public Cursor h() {
        return Cursor.getPredefinedCursor(13);
    }
    
    public Cursor i() {
        return Cursor.getPredefinedCursor(0);
    }
    
    static o a(final dI di) {
        return di.A;
    }
    
    static o a(final dI di, final o a) {
        return di.A = a;
    }
    
    static double b(final dI di) {
        return di.n;
    }
    
    static t a(final dI di, final double n, final double n2, final double n3, final fj fj, final t t) {
        return di.a(n, n2, n3, fj, t);
    }
    
    static t a(final dI di, final double n, final double n2, final double n3) {
        return di.a(n, n2, n3);
    }
    
    static void c(final dI di) {
        di.j();
    }
    
    static boolean d(final dI di) {
        return di.z;
    }
    
    static Rectangle2D e(final dI di) {
        return di.n();
    }
}
