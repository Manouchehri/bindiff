package y.h;

import java.awt.event.*;
import java.awt.*;
import y.d.*;
import y.c.*;
import y.f.*;

public class dB extends gX
{
    private static final Color f;
    double a;
    double b;
    double c;
    double d;
    gZ e;
    private D g;
    private dG h;
    private byte i;
    private boolean j;
    private al k;
    private E l;
    private ih m;
    private dE n;
    private dh o;
    private boolean p;
    private int q;
    
    public dB() {
        this.j = true;
        this.p = true;
        this.a(2);
    }
    
    public void a(final int q) {
        this.q = q;
    }
    
    public int a() {
        return this.q;
    }
    
    protected boolean a(final MouseEvent mouseEvent) {
        return (mouseEvent.getModifiers() & this.a()) != 0x0;
    }
    
    public dh c() {
        if (this.o == null) {
            this.o = this.f();
        }
        return this.o;
    }
    
    public boolean e() {
        return this.p;
    }
    
    protected dh f() {
        return new dh(this.view);
    }
    
    public boolean g() {
        return this.j;
    }
    
    public void mousePressedLeft(final double n, final double n2) {
        final boolean z = fj.z;
        if (this.m != null) {
            this.m.a();
        }
        this.m = new ih();
        this.c = n;
        this.a = n;
        this.d = n2;
        this.b = n2;
        final bu graph2D = this.getGraph2D();
        final gZ e = this.e;
        final byte i = this.i;
        final al k = this.k;
        final E l = this.l;
        this.e = null;
        this.g = null;
        if (this.h != null) {
            this.view.removeDrawable(this.h);
            this.h = null;
        }
        if (this.n != null) {
            this.n.a();
            this.n = null;
        }
        Label_0243: {
            if (e != null) {
                this.c().f();
                final n orientedBox = e.getOrientedBox();
                e.setModel(i);
                if (e instanceof eR) {
                    final eR er = (eR)e;
                    er.a(k, k.a(orientedBox, er.g()));
                    if (!z) {
                        break Label_0243;
                    }
                }
                final aA aa = (aA)e;
                final aB realizer = aa.getRealizer();
                aa.setLabelModel(l, l.a(orientedBox, realizer, realizer.getSourceRealizer(), realizer.getTargetRealizer()));
            }
        }
        final cW hitInfo = this.getHitInfo(n, n2);
        Label_0364: {
            if (hitInfo.l() != null) {
                this.setEditing(true);
                final eR j = hitInfo.l();
                this.i = j.getModel();
                this.k = j.a();
                this.a(graph2D, j, n, n2);
                this.e = j;
                if (!z) {
                    break Label_0364;
                }
            }
            if (hitInfo.m() != null) {
                this.setEditing(true);
                final aA m = hitInfo.m();
                this.i = m.getModel();
                this.l = m.getLabelModel();
                this.a(graph2D, m, n, n2);
                this.e = m;
            }
        }
        if (e != null && this.e == null) {
            this.i = i;
            this.k = k;
            this.l = l;
            Label_0433: {
                if (e instanceof eR) {
                    this.a(graph2D, (eR)e, n, n2);
                    if (!z) {
                        break Label_0433;
                    }
                }
                this.a(graph2D, (aA)e, n, n2);
            }
            this.e = e;
        }
        if (this.e != null) {
            Label_0485: {
                if (this.n == null) {
                    this.i();
                    if (!z) {
                        break Label_0485;
                    }
                }
                this.n.a(this.a(this.e, this.lastPressEvent, n, n2));
            }
            this.view.updateView();
            this.m.a(this.view, this.e);
            this.view.setViewCursor(Cursor.getPredefinedCursor(13));
        }
    }
    
    private void a(final bu bu, final eR er, final double n, final double n2) {
        final q f = er.f();
        this.m.a(bu, f);
        this.g = this.k.a(er, bu.t(f));
        this.a(bu, f);
        this.m.b(bu, f);
        this.n = this.a(er);
        if (this.n == null) {
            if (this.e()) {
                final dh c = this.c();
                c.a(this.view);
                c.a(new t(n, n2), er);
            }
            er.setModel((byte)4);
        }
    }
    
    private void a(final bu bu, final aA aa, final double n, final double n2) {
        final d edge = aa.getEdge();
        this.g = this.l.a(aa, bu.i(edge), bu.t(edge.c()), bu.t(edge.d()));
        this.a(bu, edge);
        this.m.a(bu, edge);
        this.n = this.a(aa);
        if (this.n == null) {
            if (this.e()) {
                final dh c = this.c();
                c.a(this.view);
                c.a(new t(n, n2), aa);
            }
            aa.setModel((byte)4);
        }
    }
    
    protected dE a(final gZ gz) {
        if (gz instanceof aA) {
            final E labelModel = ((aA)gz).getLabelModel();
            if (labelModel instanceof dF) {
                return ((dF)labelModel).a();
            }
        }
        else if (gz instanceof eR) {
            final al a = ((eR)gz).a();
            if (a instanceof dF) {
                return ((dF)a).a();
            }
        }
        return null;
    }
    
    private void i() {
        final boolean z = fj.z;
        if (this.i == 4 || this.i == 4) {
            this.g = null;
        }
        if (this.g != null) {
            byte b = 0;
            Label_0064: {
                if (this.e instanceof eR) {
                    b = this.a(this.k);
                    if (!z) {
                        break Label_0064;
                    }
                }
                b = this.a(this.l);
            }
            Label_0137: {
                switch (b) {
                    case 0: {
                        this.h = null;
                        if (z) {
                            break Label_0137;
                        }
                        return;
                    }
                    case 2: {
                        (this.h = new dG(this, null)).a(true);
                        this.view.addDrawable(this.h);
                        if (z) {
                            break Label_0137;
                        }
                        return;
                    }
                    case 1: {
                        (this.h = new dG(this, null)).a(false);
                        this.view.addDrawable(this.h);
                        if (z) {
                            break;
                        }
                        return;
                    }
                }
            }
            throw new IllegalStateException("Unknown Candidates Type");
        }
    }
    
    protected void a(final bu bu, final q q) {
        if (this.g()) {
            this.a(bu, q, true);
        }
    }
    
    protected void a(final bu bu, final d d) {
        if (this.g()) {
            this.a(bu, d, true);
        }
    }
    
    protected void a(final bu bu, final d d, final boolean b) {
        bu.a(d, b);
    }
    
    protected void a(final bu bu, final q q, final boolean b) {
        if (b) {
            gg.a(bu, q);
            if (!fj.z) {
                return;
            }
        }
        gg.b(bu, q);
    }
    
    public void mouseReleasedRight(final double n, final double n2) {
        this.mouseReleasedLeft(n, n2);
    }
    
    public void mouseReleasedLeft(final double n, final double n2) {
        this.a(n, n2, false);
    }
    
    private void a(final double n, final double n2, final boolean b) {
        final boolean z = fj.z;
        if (this.e != null) {
            Label_0075: {
                if (this.n == null) {
                    this.j();
                    if (!z) {
                        break Label_0075;
                    }
                }
                Label_0070: {
                    if (b) {
                        this.n.a();
                        if (!z) {
                            break Label_0070;
                        }
                    }
                    this.n.c(this.a(this.e, this.lastReleaseEvent, n, n2));
                }
                this.n = null;
            }
            final bu graph2D = this.getGraph2D();
            this.m.a(graph2D);
            this.c().f();
            this.view.updateWorldRect();
            this.view.setDrawingMode(0);
            this.a(n - this.a, n2 - this.b, n, n2);
            this.setEditing(false);
            graph2D.T();
        }
        this.i = 0;
        this.e = null;
        this.l = null;
        this.k = null;
        this.g = null;
        if (this.m != null) {
            this.m.a();
        }
        this.m = null;
        this.reactivateParent();
    }
    
    private void j() {
        final boolean z = fj.z;
        if (this.h != null) {
            this.view.removeDrawable(this.h);
            this.h = null;
        }
        final n orientedBox = this.e.getOrientedBox();
        final boolean b = this.e instanceof eR;
        byte b2 = 0;
        Label_0073: {
            if (b) {
                b2 = this.a(this.k);
                if (!z) {
                    break Label_0073;
                }
            }
            b2 = this.a(this.l);
        }
        Object o = null;
        Label_0246: {
            Label_0156: {
                switch (b2) {
                    case 0:
                    case 2: {
                        if (b) {
                            o = this.a(this.k, orientedBox, this.l().g(), this.lastReleaseEvent);
                            if (!z) {
                                break Label_0246;
                            }
                        }
                        o = this.a(this.l, orientedBox, this.k().getRealizer(), this.lastReleaseEvent);
                        if (z) {
                            break Label_0156;
                        }
                        break Label_0246;
                    }
                    case 1: {
                        final Q a = this.a(orientedBox);
                        if (a == null) {
                            if (b) {
                                o = this.a(this.k, orientedBox, this.l().g(), this.lastReleaseEvent);
                                if (!z) {
                                    break Label_0246;
                                }
                            }
                            o = this.a(this.l, orientedBox, this.k().getRealizer(), this.lastReleaseEvent);
                            if (!z) {
                                break Label_0246;
                            }
                        }
                        o = a.b();
                        if (z) {
                            break;
                        }
                        break Label_0246;
                    }
                }
            }
            throw new IllegalStateException("Unknown Candidates Type");
        }
        this.e.setModel(this.i);
        if (b) {
            this.l().a(this.k, o);
            if (!z) {
                return;
            }
        }
        this.k().setLabelModel(this.l, o);
    }
    
    private aA k() {
        return (aA)this.e;
    }
    
    private eR l() {
        return (eR)this.e;
    }
    
    private boolean b(final MouseEvent mouseEvent) {
        return this.e() && !this.a(mouseEvent);
    }
    
    public void mouseDraggedRight(final double n, final double n2) {
        this.mouseDraggedLeft(n, n2);
    }
    
    public void mouseDraggedLeft(final double n, final double n2) {
        if (this.e != null) {
            Label_0049: {
                if (this.n == null) {
                    this.a(n, n2);
                    if (!fj.z) {
                        break Label_0049;
                    }
                }
                this.n.b(this.a(this.e, this.lastDragEvent, n, n2));
            }
            this.m.a(this.view.getGraph2D());
            this.view.updateView();
        }
    }
    
    private void a(final double c, final double d) {
        final boolean z = fj.z;
        final double n = c - this.c;
        final double n2 = d - this.d;
        this.c = c;
        this.d = d;
        byte b = 0;
        Label_0066: {
            if (this.e instanceof eR) {
                b = this.a(this.k);
                if (!z) {
                    break Label_0066;
                }
            }
            b = this.a(this.l);
        }
        Label_0223: {
            Label_0168: {
                switch (b) {
                    case 0: {
                        if (this.h == null) {
                            break Label_0223;
                        }
                        this.view.removeDrawable(this.h);
                        this.h = null;
                        if (z) {
                            break Label_0168;
                        }
                        break Label_0223;
                    }
                    case 2: {
                        if (this.h != null) {
                            break Label_0223;
                        }
                        this.h = new dG(this, null);
                        this.view.addDrawable(this.h);
                        this.h.a(true);
                        if (z) {
                            break Label_0168;
                        }
                        break Label_0223;
                    }
                    case 1: {
                        if (this.h != null) {
                            break Label_0223;
                        }
                        this.h = new dG(this, null);
                        this.view.addDrawable(this.h);
                        this.h.a(false);
                        if (z) {
                            break;
                        }
                        break Label_0223;
                    }
                }
            }
            throw new IllegalStateException("Unknown Candidates Type");
        }
        final n f = this.e.getOrientedBox().f(n, n2);
        Label_0312: {
            if (this.b(this.lastDragEvent)) {
                final t b2 = this.c().b(f.k());
                f.b(b2);
                this.c = b2.a();
                this.d = b2.b();
                if (!z) {
                    break Label_0312;
                }
            }
            if (this.e()) {
                this.c().h();
            }
        }
        this.b(f);
    }
    
    private Q a(final n n) {
        return this.a(n, this.g);
    }
    
    protected Q a(final n n, final D d) {
        return this.a(n.k(), d);
    }
    
    private Q a(final t t, final D d) {
        final boolean z = fj.z;
        if (d == null) {
            return null;
        }
        double n = Double.MAX_VALUE;
        final y.c.C m = d.m();
        Q q = null;
        while (m.f()) {
            q = (Q)m.d();
            if (z) {
                return q;
            }
            final double a = t.a(t, q.d().k());
            if (a < n) {
                n = a;
            }
            m.g();
            if (z) {
                break;
            }
        }
        return q;
    }
    
    private void b(final n n) {
        final boolean z = fj.z;
        final MouseEvent lastDragEvent = this.lastDragEvent;
        Label_0107: {
            if (this.e instanceof eR) {
                final eR l = this.l();
                this.e.setModelParameter(this.a(l.a(), n, l.g(), lastDragEvent));
                if (!z) {
                    break Label_0107;
                }
            }
            if (this.e instanceof aA) {
                final aA k = this.k();
                this.e.setModelParameter(this.a(k.getLabelModel(), n, k.getRealizer(), lastDragEvent));
            }
        }
        if (this.h != null) {
            dG.a(this.h, this.a(n));
            if (this.h.a()) {
                if (this.e instanceof eR) {
                    dG.a(this.h, this.a(this.k, n, this.l().g(), lastDragEvent));
                    if (!z) {
                        return;
                    }
                }
                if (this.e instanceof aA) {
                    dG.a(this.h, this.a(this.l, n, this.k().getRealizer(), lastDragEvent));
                }
            }
        }
    }
    
    protected void a(final double n, final double n2, final double n3, final double n4) {
    }
    
    public void cancelEditing() {
        if (this.isEditing()) {
            this.a(this.c, this.d, true);
        }
    }
    
    protected byte a(final al al) {
        if (al instanceof gw) {
            return 0;
        }
        if (al instanceof M) {
            return 0;
        }
        return 1;
    }
    
    protected byte a(final E e) {
        if (e instanceof gu) {
            return 0;
        }
        if (e instanceof K) {
            return 0;
        }
        return 1;
    }
    
    protected Object a(final al al, final n n, final fj fj, final MouseEvent mouseEvent) {
        return al.a(n, fj);
    }
    
    protected Object a(final E e, final n n, final aB ab, final MouseEvent mouseEvent) {
        return e.a(n, ab, ab.getSourceRealizer(), ab.getTargetRealizer());
    }
    
    private dD a(final gZ gz, final MouseEvent mouseEvent, final double n, final double n2) {
        return new dD(this, gz, mouseEvent.getModifiersEx(), n, n2, this.b(mouseEvent));
    }
    
    static eR a(final dB db) {
        return db.l();
    }
    
    static aA b(final dB db) {
        return db.k();
    }
    
    static Color h() {
        return dB.f;
    }
    
    static D c(final dB db) {
        return db.g;
    }
    
    static E d(final dB db) {
        return db.l;
    }
    
    static al e(final dB db) {
        return db.k;
    }
    
    static {
        f = new Color(51, 51, 51);
    }
}
