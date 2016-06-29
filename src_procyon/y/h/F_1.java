package y.h;

import java.beans.*;
import java.util.*;
import java.awt.event.*;
import y.c.*;
import java.awt.geom.*;
import java.awt.*;
import y.d.*;

public class F extends gX
{
    private q a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private KeyListener h;
    private o i;
    private PropertyChangeListener j;
    private int k;
    private L l;
    private q m;
    private q n;
    private d o;
    private boolean p;
    private boolean q;
    private boolean r;
    private double s;
    private boolean t;
    private int u;
    private boolean v;
    private List w;
    private List x;
    private boolean y;
    private dU z;
    private en A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private q F;
    private boolean G;
    private boolean H;
    private boolean I;
    private eU J;
    private eU K;
    private eU L;
    private int M;
    
    public F(final gU gu) {
        super(gu);
        this.c = true;
        this.e = true;
        this.f = true;
        this.k = 27;
        this.l = new L(this);
        this.t = true;
        this.u = 10;
        this.v = true;
        this.I = true;
        this.M = 2;
        this.g = false;
        this.j = new G(this);
    }
    
    public dU a() {
        if (this.z == null) {
            this.z = this.c();
        }
        return this.z;
    }
    
    protected dU c() {
        final dU du = new dU(this.view);
        du.c(true);
        du.g(true);
        du.b(15.0);
        du.c(20.0);
        return du;
    }
    
    public F() {
        this(null);
    }
    
    public void init() {
        this.c = true;
    }
    
    public boolean e() {
        return this.I;
    }
    
    public boolean f() {
        return this.D;
    }
    
    public void a(final boolean d) {
        this.D = d;
    }
    
    public void a(final double s) {
        this.s = s;
    }
    
    public void b(final boolean e) {
        this.e = e;
    }
    
    public void mousePressedLeft(final double n, final double n2) {
        this.g = true;
        this.a(n, n2, false);
    }
    
    public void mouseShiftPressedLeft(final double n, final double n2) {
        this.a(n, n2, this.g = true);
    }
    
    static int a(final byte b, final fj fj) {
        final boolean z = fj.z;
        int n = 0;
        final e j = fj.getNode().j();
        final bu d = fj.d();
        final e e = j;
        do {
            Label_0024: {
                e.f();
            }
            boolean contains = false;
            Label_0031:
            while (contains) {
                final d a = e.a();
                final aB i = d.i(a);
                final q node = fj.getNode();
                final v l = d.l(a);
                double n3 = 0.0;
                double n4 = 0.0;
                Label_0295: {
                    if (a.c() == node) {
                        int n2 = -1;
                        while (n2 + 1 < i.bendCount()) {
                            contains = fj.contains(i.getBend(n2 + 1).b(), i.getBend(n2 + 1).c());
                            if (z) {
                                continue Label_0031;
                            }
                            if (!contains) {
                                break;
                            }
                            ++n2;
                            if (z) {
                                break;
                            }
                        }
                        final m a2 = l.a(n2 + 1);
                        n3 = a2.d().a - a2.c().a;
                        n4 = a2.d().b - a2.c().b;
                        if (!z) {
                            break Label_0295;
                        }
                    }
                    int bendCount = i.bendCount();
                    while (bendCount - 1 >= 0) {
                        final boolean contains2 = fj.contains(i.getBend(bendCount - 1).b(), i.getBend(bendCount - 1).c());
                        if (z) {
                            continue Label_0031;
                        }
                        if (!contains2) {
                            break;
                        }
                        --bendCount;
                        if (z) {
                            break;
                        }
                    }
                    final m a3 = l.a(bendCount);
                    n3 = a3.c().a - a3.d().a;
                    n4 = a3.c().b - a3.d().b;
                }
                byte b2 = -1;
                Label_0371: {
                    if (Math.abs(n3) > Math.abs(n4)) {
                        if (Math.abs(n4) >= 0.001) {
                            break Label_0371;
                        }
                        b2 = (byte)((n3 > 0.0) ? 1 : 3);
                        if (!z) {
                            break Label_0371;
                        }
                    }
                    if (Math.abs(n3) < 0.001) {
                        b2 = (byte)((n4 > 0.0) ? 2 : 0);
                    }
                }
                if (b == b2) {
                    ++n;
                }
                e.g();
                continue Label_0024;
            }
            break;
        } while (!z);
        return n;
    }
    
    void a(final double n, final double n2, final boolean c) {
        final boolean z = fj.z;
        this.C = c;
        if (this.c) {
            this.F = null;
            this.L = null;
            this.J = null;
            this.K = null;
            final bu graph2D = this.getGraph2D();
            this.a = this.a(n, n2);
            if (this.a == null) {
                this.reactivateParent();
                return;
            }
            if (!this.d(this.a, n, n2)) {
                this.c(this.a, n, n2);
                return;
            }
            if (this.a(graph2D, this.a)) {
                this.J = this.a(this.a, n, n2);
                if (!this.b(this.a, this.J, n, n2)) {
                    this.a(this.a, this.J, n, n2);
                    return;
                }
            }
            else {
                this.J = null;
            }
            if (this.h == null) {
                this.h = new H(this);
                this.view.getCanvasComponent().addKeyListener(this.h);
            }
            if (this.i == null) {
                graph2D.a(this.i = new I(this));
            }
            this.view.addPropertyChangeListener("Graph2D", this.j);
            this.l.j();
            this.F = null;
            this.L = null;
            this.view.addDrawable(this.l);
            this.setEditing(true);
            this.n = this.l.a(this.a(graph2D.t(this.a)));
            this.m = this.l.a(this.b(n, n2));
            this.o = this.l.a(this.n, this.m, this.g());
            this.d = false;
            graph2D.b((byte)1);
            this.view.setDrawingMode(3);
            this.b = true;
            this.c = false;
            this.p = true;
            this.q = false;
            final fj t = this.l.t(this.n);
            final double n3 = n - t.getCenterX();
            final double n4 = n2 - t.getCenterY();
            this.a(graph2D);
            final dU a = this.a();
            a.a(this.view);
            final List empty_LIST = Collections.EMPTY_LIST;
            final List<q> list = a.n() ? Collections.singletonList(this.m) : empty_LIST;
            Label_0501: {
                if ((this.j() && this.f()) || a.n()) {
                    a.a(new t(n, n2), list, empty_LIST, Collections.EMPTY_SET, y.g.q.a((Object)null));
                    if (!z) {
                        break Label_0501;
                    }
                }
                a.f();
            }
            if (this.j() && this.f()) {
                a.b(this.A);
                this.A = null;
            }
            if (this.J != null) {
                this.l.t(this.n).getPort(eU.e(this.J)).a(this.l.i(this.o));
                if (!z) {
                    return;
                }
            }
            final t a2 = this.a(c, this.a, n3, n4);
            this.l.i(this.o).getSourcePort().b(a2.a, a2.b);
        }
    }
    
    protected q a(final double n, final double n2) {
        if (!this.e()) {
            return this.getHitInfo(n, n2).i();
        }
        final cW hitInfo = this.getHitInfo(n, n2);
        if (hitInfo.t()) {
            return hitInfo.i();
        }
        if (hitInfo.p()) {
            return hitInfo.o().b().getNode();
        }
        return null;
    }
    
    private void a(final bu bu) {
        final boolean z = fj.z;
        if (!this.y) {
            final List list = null;
            this.x = list;
            this.w = list;
        }
        this.w = new ArrayList();
        final x o = bu.o();
        while (true) {
            while (o.f()) {
                final fj t = bu.t(o.e());
                final F f = this;
                if (z) {
                    y.g.e.a(f.x, new K(this));
                    return;
                }
                if (this.view.getVisibleRect().intersects(t.getX(), t.getY(), t.getWidth(), t.getHeight())) {
                    this.w.add(t);
                }
                o.g();
                if (z) {
                    break;
                }
            }
            y.g.e.a(this.w, new J(this));
            this.x = new ArrayList(this.w);
            final F f = this;
            continue;
        }
    }
    
    private fj a(final double n, final List list) {
        final boolean z = fj.z;
        if (list == null || list.size() <= 0) {
            return null;
        }
        int i = 0;
        int n2 = list.size() - 1;
        if (list.get(i).getCenterX() > n) {
            return list.get(i);
        }
        if (list.get(n2).getCenterX() < n) {
            return list.get(n2);
        }
        while (true) {
            while (i < n2 - 1) {
                final int n3 = (i + n2) / 2;
                final fj fj = list.get(n3);
                final double centerX = fj.getCenterX();
                final double n4 = n;
                if (!z) {
                    if (centerX == n) {
                        return fj;
                    }
                    if (fj.getCenterX() < n) {
                        i = n3;
                        if (!z) {
                            continue;
                        }
                    }
                    n2 = n3;
                    if (z) {
                        break;
                    }
                    continue;
                }
                else {
                    if (Math.abs(centerX - n4) < Math.abs(list.get(n2).getCenterX() - n)) {
                        return list.get(i);
                    }
                    return list.get(n2);
                }
            }
            list.get(i).getCenterX();
            final double n4 = n;
            continue;
        }
    }
    
    private fj b(final double n, final List list) {
        final boolean z = fj.z;
        if (list == null || list.size() <= 0) {
            return null;
        }
        int i = 0;
        int n2 = list.size() - 1;
        if (list.get(i).getCenterY() > n) {
            return list.get(i);
        }
        if (list.get(n2).getCenterY() < n) {
            return list.get(n2);
        }
        while (true) {
            while (i < n2 - 1) {
                final int n3 = (i + n2) / 2;
                final fj fj = list.get(n3);
                final double centerY = fj.getCenterY();
                final double n4 = n;
                if (!z) {
                    if (centerY == n) {
                        return fj;
                    }
                    if (fj.getCenterY() < n) {
                        i = n3;
                        if (!z) {
                            continue;
                        }
                    }
                    n2 = n3;
                    if (z) {
                        break;
                    }
                    continue;
                }
                else {
                    if (Math.abs(centerY - n4) < Math.abs(list.get(n2).getCenterY() - n)) {
                        return list.get(i);
                    }
                    return list.get(n2);
                }
            }
            list.get(i).getCenterY();
            final double n4 = n;
            continue;
        }
    }
    
    protected t a(final boolean b, final q q, final double n, final double n2) {
        if (b) {
            final fj t = this.getGraph2D().t(q);
            return new t(this.getGridX(t.getCenterX() + n) - t.getCenterX(), this.getGridY(t.getCenterY() + n2) - t.getCenterY());
        }
        return y.d.t.c;
    }
    
    private boolean a(final bu bu, final q q) {
        return this.e() && q != null && bu.t(q).portCount() > 0;
    }
    
    protected eU a(final q q, final double n, final double n2) {
        return this.g(q, n, n2);
    }
    
    private eU g(final q q, final double n, final double n2) {
        return eU.a(this.view.getGraph2D().t(q), n, n2);
    }
    
    protected aB g() {
        return this.getGraph2D().G().createCopy();
    }
    
    protected aB h() {
        if (this.l == null || this.l.g() < 1) {
            throw new IllegalStateException("EdgeRealizer not yet created!");
        }
        return this.l.i(this.o);
    }
    
    protected fj a(final fj fj) {
        return fj.createCopy();
    }
    
    protected fj b(final double n, final double n2) {
        final gn gn = new gn();
        gn.setSize(0.1, 0.1);
        gn.setVisible(false);
        gn.setCenter(n, n2);
        gn.setShapeType((byte)0);
        return gn;
    }
    
    public void mouseReleasedRight(final double n, final double n2) {
        this.g = false;
        if (!this.p) {
            return;
        }
        final bu graph2D = this.getGraph2D();
        final aB i = this.l.i(this.o);
        final int bendCount = i.bendCount();
        if (bendCount > Math.max(i.getMinBendCount(), this.j() ? 1 : 0)) {
            this.a(i, bendCount - 1);
            this.a(i);
            if (this.a().l()) {
                this.a().b(this.A);
                this.A = null;
                final y.h.x lastBend = this.h().lastBend();
                if (lastBend != null) {
                    final t k = this.a().k();
                    final t t = new t(n - (n - k.a), n2 - (n2 - k.b));
                    final boolean b = this.B != (this.h().bendCount() % 2 == 1);
                    this.A = this.a().a(new ek(null, b ? new t(t.a(), lastBend.c()) : new t(lastBend.b(), t.b()), (byte)(b ? 1 : 2)), new ek(null, t, (byte)3));
                }
                this.a().h();
            }
            this.view.updateView();
            if (!fj.z) {
                return;
            }
        }
        this.n();
        graph2D.T();
        this.reactivateParent();
    }
    
    protected void a(final aB ab, final int n) {
        ab.removeBend(ab.getBend(n));
    }
    
    private void a(final aB ab) {
        final fj targetRealizer = ab.getTargetRealizer();
        final fL targetPort = ab.getTargetPort();
        this.a(targetPort.a(targetRealizer), targetPort.b(targetRealizer), ab);
    }
    
    public void mouseShiftReleasedLeft(final double n, final double n2) {
        this.g = false;
        this.c(n, n2, true);
    }
    
    public void mouseReleasedLeft(final double n, final double n2) {
        this.c(n, n2, this.g = false);
    }
    
    public int i() {
        return this.M;
    }
    
    protected boolean a(final MouseEvent mouseEvent) {
        return (mouseEvent.getModifiers() & this.i()) != 0x0;
    }
    
    void c(final double n, final double n2, final boolean c) {
        final boolean z = fj.z;
        if (!this.p) {
            return;
        }
        if (this.C != c) {
            this.C = c;
        }
        final Point2D.Double double1 = new Point2D.Double(n, n2);
        double1.x = this.getGridX(double1.x);
        double1.y = this.getGridY(double1.y);
        final boolean a = this.a(double1, this.h(), this.a(this.lastReleaseEvent));
        final double x = double1.x;
        final double y = double1.y;
        final bu graph2D = this.getGraph2D();
        final q d = this.d(n, n2);
        final aB i = this.l.i(this.o);
        if (this.a(this.a, d, double1.x, double1.y)) {
            if (!this.e) {
                return;
            }
            this.a(i, x, y);
            this.mouseMoved(n, n2);
            if (this.a().l()) {
                this.a().b(this.A);
                this.A = null;
                final y.h.x lastBend = this.h().lastBend();
                if (lastBend != null) {
                    final t k = this.a().k();
                    final t t = new t(double1.x - (n - k.a), double1.y - (n2 - k.b));
                    final boolean b = this.B != (this.h().bendCount() % 2 == 1);
                    this.A = this.a().a(new ek(null, b ? new t(t.a(), lastBend.c()) : new t(lastBend.b(), t.b()), (byte)(b ? 1 : 2)), new ek(null, t, (byte)3));
                    this.a().h();
                }
            }
            graph2D.T();
            if (!z) {
                return;
            }
        }
        if (!this.q) {
            if (this.k()) {
                this.n();
            }
            return;
        }
        if (this.a == d && !this.f) {
            return;
        }
        final q q = this.d ? this.a : d;
        if (!this.f(q, double1.x, double1.y)) {
            this.e(q, double1.x, double1.y);
            return;
        }
        if (this.a(graph2D, q)) {
            this.K = this.b(q, x, y);
            if (!this.d(q, this.K, x, y)) {
                this.c(q, this.K, x, y);
                return;
            }
        }
        else {
            this.K = null;
        }
        this.view.removeDrawable(this.l);
        this.l.a(this.o);
        graph2D.b((byte)0);
        this.view.setDrawingMode(0);
        final d a2 = this.a(graph2D, this.a, q, i);
        final List list = null;
        this.x = list;
        this.w = list;
        this.a().f();
        if (a2 != null) {
            final aB j = graph2D.i(a2);
            final fj t2 = graph2D.t(q);
            final double n3 = x - t2.getCenterX();
            final double n4 = y - t2.getCenterY();
            t t3 = null;
            Label_0716: {
                if (this.K != null) {
                    t3 = eU.b(this.K);
                    if (!z) {
                        break Label_0716;
                    }
                }
                t3 = this.a(a2, c, q, n3, n4, a, x, y);
            }
            j.getTargetPort().b(t3.a, t3.b);
            this.a(graph2D.q(a2).a, graph2D.q(a2).b, j);
            this.b(a2);
            this.a(a2);
        }
        this.setEditing(false);
        graph2D.T();
        this.reactivateParent();
    }
    
    protected cW c(final double n, final double n2) {
        int n3 = 1;
        if (this.e()) {
            n3 |= 0x40;
        }
        return this.view.getHitInfoFactory().a(n, n2, n3, true);
    }
    
    protected q d(final double n, final double n2) {
        if (!this.e()) {
            return this.c(n, n2).i();
        }
        final cW c = this.c(n, n2);
        if (c.t()) {
            return c.i();
        }
        if (c.p()) {
            return c.o().b().getNode();
        }
        return null;
    }
    
    private void b(final d d) {
        final boolean z = fj.z;
        final aB i = this.getGraph2D().i(d);
        if (i.getMinBendCount() > 0) {
            return;
        }
        final fj targetRealizer = i.getTargetRealizer();
        if (this.j()) {
            Label_0421: {
                if (d.e()) {
                    final t p = this.getGraph2D().p(d);
                    if (i.bendCount() == 0) {
                        final y.h.x appendBend = i.appendBend(p.a, targetRealizer.getY() - 15.0);
                        if (appendBend == null) {
                            break Label_0421;
                        }
                        final y.h.x appendBend2 = i.appendBend(targetRealizer.getX() + targetRealizer.getWidth() + 15.0, appendBend.c());
                        if (appendBend2 == null) {
                            break Label_0421;
                        }
                        i.appendBend(appendBend2.b(), this.getGraph2D().q(d).b);
                        if (!z) {
                            break Label_0421;
                        }
                    }
                    if (i.bendCount() == 1) {
                        final y.h.x firstBend = i.firstBend();
                        final double n = p.a - firstBend.b();
                        double n2 = p.b - firstBend.c();
                        if (n == 0.0 && n2 == 0.0) {
                            firstBend.a(p.a, targetRealizer.getY() - 15.0);
                            n2 = p.b - firstBend.c();
                        }
                        if (Math.abs(n) > Math.abs(n2)) {
                            final y.h.x appendBend3 = i.appendBend(firstBend.b(), targetRealizer.getY() - Math.abs(Math.max(15.0, (n > 0.0) ? (firstBend.b() - (targetRealizer.getX() + targetRealizer.getWidth())) : (firstBend.b() - targetRealizer.getX()))));
                            if (appendBend3 == null) {
                                break Label_0421;
                            }
                            i.appendBend(this.getGraph2D().q(d).a, appendBend3.c());
                            if (!z) {
                                break Label_0421;
                            }
                        }
                        final y.h.x appendBend4 = i.appendBend(targetRealizer.getX() - Math.abs(Math.max(15.0, (n2 > 0.0) ? (firstBend.c() - (targetRealizer.getY() + targetRealizer.getHeight())) : (firstBend.c() - targetRealizer.getY()))), firstBend.c());
                        if (appendBend4 != null) {
                            i.appendBend(appendBend4.b(), this.getGraph2D().q(d).b);
                        }
                    }
                }
            }
            fu.a(i);
        }
        if (this.E) {
            fu.c(i);
        }
    }
    
    protected void a(final aB ab, final double n, final double n2) {
        ab.appendBend(n, n2);
    }
    
    protected t b(final boolean b, final q q, final double n, final double n2) {
        if (b) {
            final fj t = this.getGraph2D().t(q);
            return new t(this.getGridX(t.getCenterX() + n) - t.getCenterX(), this.getGridY(t.getCenterY() + n2) - t.getCenterY());
        }
        return y.d.t.c;
    }
    
    protected eU b(final q q, final double n, final double n2) {
        return this.g(q, n, n2);
    }
    
    protected t a(final d d, final boolean b, final q q, final double n, final double n2, final boolean b2, final double n3, final double n4) {
        final aB i = this.getGraph2D().i(d);
        final t t = (i.bendCount() > 0) ? i.lastBend().e() : this.getGraph2D().p(d);
        final fj targetRealizer = i.getTargetRealizer();
        final t t2 = b2 ? new t(n3, n4) : new t(targetRealizer.getCenterX() + n, targetRealizer.getCenterY() + n2);
        final double n5 = t.a - t2.a;
        final double n6 = t.b - t2.b;
        if (!this.H || (Math.abs(n5) >= 0.1 && Math.abs(n6) >= 0.1)) {
            return this.b(b, q, n, n2);
        }
        byte b3 = 0;
        Label_0197: {
            if (Math.abs(n5) > Math.abs(n6)) {
                b3 = (byte)((n5 > 0.0) ? 1 : 3);
                if (!fj.z) {
                    break Label_0197;
                }
            }
            b3 = (byte)((n6 > 0.0) ? 2 : 0);
        }
        final i a = d.a();
        a.d(d);
        final int n7 = (b3 >= 0) ? a(b3, targetRealizer) : 0;
        a.e(d);
        if (n7 == 0) {
            return this.b(b, q, n, n2);
        }
        return new t(n3 - targetRealizer.getCenterX(), n4 - targetRealizer.getCenterY());
    }
    
    protected d a(final bu bu, final q q, final q q2, final aB ab) {
        if (bu != q.e() || bu != q2.e()) {
            final y.h.a.v c = bu.C();
            if (c != null) {
                bu.r();
                d a;
                try {
                    a = c.a(q, q2);
                    bu.a(a, ab);
                }
                finally {
                    bu.s();
                }
                return a;
            }
        }
        return bu.a(q, q2, ab);
    }
    
    protected boolean a(final q q, final q q2, final double n, final double n2) {
        final boolean z = fj.z;
        final boolean b = q2 == null;
        if (!b) {
            final y.h.a.v a = y.h.a.v.a(this.getGraph2D());
            if (a != null) {
                final fj t = this.getGraph2D().t(q2);
                if (a.k(q2)) {
                    if (this.m()) {
                        final C g = this.e(n, n2).g();
                        while (g.f()) {
                            final eR er = (eR)g.d();
                            if (z) {
                                return b;
                            }
                            if (er.f() == q2 && t.getLabel(0) == er) {
                                return false;
                            }
                            g.g();
                            if (z) {
                                break;
                            }
                        }
                    }
                    final int l = this.l();
                    if (n >= t.getX() + l && n <= t.getX() + t.getWidth() - l && n2 >= t.getY() + l && n2 <= t.getY() + t.getHeight() - l) {
                        return true;
                    }
                }
            }
        }
        return b;
    }
    
    public void mouseDraggedLeft(final double n, final double n2) {
        final boolean z = fj.z;
        if (!this.p) {
            return;
        }
        MouseEvent mouseEvent = this.lastDragEvent;
        if (this.lastDragEvent != null && this.lastMoveEvent != null && this.lastMoveEvent.getWhen() > this.lastDragEvent.getWhen()) {
            mouseEvent = this.lastMoveEvent;
        }
        final boolean b = this.B;
        if (mouseEvent != null && this.C != this.isModifierPressed(mouseEvent)) {
            this.C = !this.C;
            if (this.C && this.h().bendCount() == 1) {
                this.B = !this.B;
            }
        }
        if (this.h().bendCount() < 2 && this.j() && this.lastPressEvent != null && mouseEvent != null && this.lastPressEvent.getWhen() + 200L > mouseEvent.getWhen()) {
            this.B = this.a(mouseEvent.getX() - this.lastPressEvent.getX(), mouseEvent.getY() - this.lastPressEvent.getY(), this.a);
        }
        final bu graph2D = this.getGraph2D();
        final Point2D.Double double1 = new Point2D.Double(n, n2);
        final q a = this.a(graph2D, double1.x, double1.y);
        if (a != this.a) {
            this.q = true;
        }
        final boolean a2 = this.a(graph2D, a);
        this.F = null;
        this.L = null;
        if (this.G && (this.q || this.d) && !this.a(this.a, a, n, n2) && this.f(a, double1.x, double1.y)) {
            this.F = a;
            if (a2) {
                this.L = this.b(a, n, n2);
                if (!this.d(this.F, this.L, n, n2)) {
                    this.F = null;
                    this.L = null;
                }
            }
        }
        double1.x = this.getGridX(double1.x);
        double1.y = this.getGridY(double1.y);
        final aB h = this.h();
        this.a(double1, h, this.o());
        Label_0715: {
            if (a == this.a && this.f && (!a2 || this.L != null)) {
                if (!this.b) {
                    this.b = true;
                    if (h.bendCount() != h.getMinBendCount()) {
                        break Label_0715;
                    }
                    this.l.a(this.o);
                    this.o = this.l.a(this.n, this.n, h);
                    this.d = true;
                    if (!a2 || this.L == null) {
                        break Label_0715;
                    }
                    this.l.t(this.n).getPort(eU.e(this.L)).c(h);
                    if (!z) {
                        break Label_0715;
                    }
                }
                if (!this.d || !a2) {
                    break Label_0715;
                }
                this.l.t(this.n).getPort(eU.e(this.L)).c(h);
                if (!z) {
                    break Label_0715;
                }
            }
            if (this.b) {
                this.b = false;
                if (this.d) {
                    this.l.a(this.o);
                    h.clearBends();
                    this.o = this.l.a(this.n, this.m, h);
                    this.d = false;
                    eU.b(null, h);
                    h.setTargetPoint(y.d.t.c);
                }
            }
        }
        this.l.t(this.m).setCenter(double1.x, double1.y);
        this.a(double1);
        this.f(double1.x, double1.y);
        if ((this.B != b || this.A == null) && this.a().l()) {
            this.a().b(this.A);
            this.A = null;
            final y.h.x lastBend = this.h().lastBend();
            if (lastBend != null) {
                final t k = this.a().k();
                final t t = new t(double1.x - (n - k.a), double1.y - (n2 - k.b));
                this.A = this.a().a(new ek(null, this.B ? new t(lastBend.b(), t.b()) : new t(t.a(), lastBend.c()), (byte)(this.B ? 2 : 1)), new ek(null, t, (byte)3));
            }
            this.a().h();
        }
        this.view.updateView();
    }
    
    protected boolean a(final int n, final int n2, final q q) {
        byte b = 0;
        Label_0041: {
            if (Math.abs(n) > Math.abs(n2)) {
                b = (byte)((n > 0) ? 1 : 3);
                if (!fj.z) {
                    break Label_0041;
                }
            }
            b = (byte)((n2 > 0) ? 2 : 0);
        }
        if (a(b, this.getGraph2D().t(q)) == 0) {
            return Math.abs(n2) > Math.abs(n);
        }
        return Math.abs(n) > Math.abs(n2);
    }
    
    private boolean a(final Point2D.Double double1, final aB ab, final boolean b) {
        final boolean z = fj.z;
        if (b) {
            this.a().h();
            return false;
        }
        if (this.a().l()) {
            final t t = new t(double1.x, double1.y);
            final t b2 = this.a().b(t);
            double1.x = b2.a;
            double1.y = b2.b;
            return t != b2;
        }
        if (this.s > 0.0 && !this.j()) {
            double x = 0.0;
            double y = 0.0;
            Label_0166: {
                if (ab.bendCount() > 0) {
                    x = ab.lastBend().b();
                    y = ab.lastBend().c();
                    if (!z) {
                        break Label_0166;
                    }
                }
                final t p3 = ((bu)ab.getEdge().a()).p(ab.getEdge());
                x = p3.a;
                y = p3.b;
            }
            final double abs = Math.abs(double1.x - x);
            final double abs2 = Math.abs(double1.y - y);
            int n = 0;
            int n2 = 0;
            Label_0263: {
                if (abs < abs2) {
                    if (abs * this.view.getZoom() >= this.s) {
                        break Label_0263;
                    }
                    double1.x = x;
                    n = 1;
                    if (!z) {
                        break Label_0263;
                    }
                }
                if (abs2 * this.view.getZoom() < this.s) {
                    double1.y = y;
                    n2 = 1;
                }
            }
            if (this.y) {
                if (n == 0) {
                    final fj a = this.a(double1.x, this.w);
                    if (a != null && Math.abs(a.getCenterX() - double1.x) < this.s) {
                        double1.x = a.getCenterX();
                        n = 1;
                    }
                }
                if (n2 == 0) {
                    final fj b3 = this.b(double1.y, this.x);
                    if (b3 != null && Math.abs(b3.getCenterY() - double1.y) < this.s) {
                        double1.y = b3.getCenterY();
                        n2 = 1;
                    }
                }
            }
            return n != 0 || n2 != 0;
        }
        return false;
    }
    
    private void a(final Point2D.Double double1) {
        this.a(double1.x, double1.y, this.h());
    }
    
    protected q a(final bu bu, final double n, final double n2) {
        if (bu.t(this.a).contains(n, n2)) {
            return this.a;
        }
        return this.d(n, n2);
    }
    
    public void mouseMoved(final double n, final double n2) {
        this.mouseDraggedLeft(n, n2);
    }
    
    public void reactivateParent() {
        this.p();
        this.p = false;
        this.c = true;
        final List list = null;
        this.x = list;
        this.w = list;
        super.reactivateParent();
    }
    
    public boolean j() {
        return this.r;
    }
    
    public boolean k() {
        return this.t;
    }
    
    public int l() {
        return this.u;
    }
    
    public boolean m() {
        return this.v;
    }
    
    protected cW e(final double n, final double n2) {
        return new cW(this.view, n, n2, false, 5);
    }
    
    protected Rectangle2D b(final fj fj) {
        return new Rectangle2D.Double(fj.getX() - 10.0, fj.getY() - 10.0, fj.getWidth() + 20.0, fj.getHeight() + 20.0);
    }
    
    protected void a(final Graphics2D graphics2D, final fj fj) {
        dI.b(graphics2D, fj);
    }
    
    protected void a(final Graphics2D graphics2D, final eU eu) {
        final y k = this.L.k();
        dI.a(graphics2D, (int)Math.floor(k.c()), (int)Math.floor(k.d()), (int)Math.ceil(k.a()), (int)Math.ceil(k.b()));
    }
    
    protected void f(final double n, final double n2) {
    }
    
    private void a(final double n, final double n2, final aB ab) {
        final boolean z = fj.z;
        if (!this.j()) {
            return;
        }
        final Point2D.Double double1 = new Point2D.Double(n, n2);
        if (ab.bendCount() == 0) {
            final fj sourceRealizer = ab.getSourceRealizer();
            final double a = ab.getSourcePort().a(sourceRealizer);
            final double b = ab.getSourcePort().b(sourceRealizer);
            final double n3 = double1.x - a;
            final double n4 = double1.y - b;
            Label_0129: {
                if (this.B) {
                    double1.x = a + n3;
                    double1.y = b;
                    if (!z) {
                        break Label_0129;
                    }
                }
                double1.x = a;
                double1.y = b + n4;
            }
            if (n == double1.x && n2 == double1.y) {
                return;
            }
            ab.createBend(double1.x, double1.y, ab.lastBend(), 0);
            if (!z) {
                return;
            }
        }
        final y.h.x lastBend = ab.lastBend();
        double n5 = 0.0;
        double n6 = 0.0;
        Label_0256: {
            if (ab.bendCount() > 1) {
                final t point = ab.getPoint(ab.bendCount() - 2);
                n5 = point.a;
                n6 = point.b;
                if (!z) {
                    break Label_0256;
                }
            }
            final fj sourceRealizer2 = ab.getSourceRealizer();
            n5 = ab.getSourcePort().a(sourceRealizer2);
            n6 = ab.getSourcePort().b(sourceRealizer2);
        }
        final double n7 = double1.x - n5;
        final double n8 = double1.y - n6;
        Label_0397: {
            if (ab.bendCount() > 1) {
                if (ab.bendCount() % 2 == 0 == this.B) {
                    double1.x = n5 + n7;
                    double1.y = n6;
                    if (!z) {
                        break Label_0397;
                    }
                }
                double1.x = n5;
                double1.y = n6 + n8;
                if (!z) {
                    break Label_0397;
                }
            }
            if (!this.B) {
                double1.x = n5 + n7;
                double1.y = n6;
                if (!z) {
                    break Label_0397;
                }
            }
            double1.x = n5;
            double1.y = n6 + n8;
        }
        lastBend.a(double1.x, double1.y);
    }
    
    private boolean o() {
        boolean b = false;
        if (this.lastMoveEvent != null && this.lastDragEvent != null) {
            if (this.lastDragEvent.getWhen() > this.lastMoveEvent.getWhen()) {
                b = this.a(this.lastDragEvent);
                if (!fj.z) {
                    return b;
                }
            }
            b = this.a(this.lastMoveEvent);
        }
        return b;
    }
    
    protected void a(final d d) {
        if (this.e()) {
            final aB i = this.view.getGraph2D().i(d);
            eU.a(this.J, i);
            eU.b(this.K, i);
        }
    }
    
    protected void n() {
        this.a().f();
        final List list = null;
        this.x = list;
        this.w = list;
        this.l.j();
        this.F = null;
        this.p();
        this.getGraph2D().b((byte)0);
        this.view.setDrawingMode(0);
        this.view.removeDrawable(this.l);
        this.view.updateView();
        this.setEditing(false);
        this.reactivateParent();
    }
    
    protected void c(final q q, final double n, final double n2) {
        this.reactivateParent();
    }
    
    protected boolean d(final q q, final double n, final double n2) {
        return true;
    }
    
    protected void a(final q q, final eU eu, final double n, final double n2) {
        this.reactivateParent();
    }
    
    protected boolean b(final q q, final eU eu, final double n, final double n2) {
        return true;
    }
    
    protected void e(final q q, final double n, final double n2) {
    }
    
    protected boolean f(final q q, final double n, final double n2) {
        return true;
    }
    
    protected void c(final q q, final eU eu, final double n, final double n2) {
    }
    
    protected boolean d(final q q, final eU eu, final double n, final double n2) {
        return true;
    }
    
    public void cancelEditing() {
        if (this.isEditing()) {
            this.n();
        }
    }
    
    private void p() {
        if (this.h != null) {
            this.view.getCanvasComponent().removeKeyListener(this.h);
            this.h = null;
        }
        if (this.i != null) {
            this.getGraph2D().b(this.i);
            this.i = null;
        }
        this.view.removePropertyChangeListener("Graph2D", this.j);
    }
    
    static o a(final F f) {
        return f.i;
    }
    
    static o a(final F f, final o i) {
        return f.i = i;
    }
    
    static boolean b(final F f) {
        return f.C;
    }
    
    static boolean c(final F f) {
        return f.g;
    }
    
    static boolean d(final F f) {
        return f.p;
    }
    
    static int e(final F f) {
        return f.k;
    }
    
    static KeyListener a(final F f, final KeyListener h) {
        return f.h = h;
    }
    
    static q f(final F f) {
        return f.a;
    }
    
    static boolean g(final F f) {
        return f.G;
    }
    
    static eU h(final F f) {
        return f.L;
    }
    
    static q i(final F f) {
        return f.F;
    }
}
