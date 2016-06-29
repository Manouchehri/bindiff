package y.h;

import y.d.*;
import y.c.*;

public class dH extends gX
{
    protected eU a;
    private ih b;
    private boolean c;
    
    public dH() {
        this(null);
    }
    
    public dH(final gU gu) {
        super(gu);
    }
    
    protected boolean a(final d d) {
        return aC.b(d, this.getGraph2D());
    }
    
    public void mousePressedLeft(final double n, final double n2) {
        this.c = false;
        final eU d = this.d(n, n2);
        if (d == null) {
            this.reactivateParent();
            if (!fj.z) {
                return;
            }
        }
        this.setEditing(true);
        this.b = new ih();
        this.a(this.a = d);
    }
    
    public void mouseDraggedLeft(final double n, final double n2) {
        if (this.a != null) {
            if (!this.c) {
                this.c = true;
                final bu graph2D = this.getGraph2D();
                graph2D.r();
                final q b = b(this.a);
                if (b != null && b.e() == graph2D) {
                    this.b.b(graph2D, b);
                    this.b.a(graph2D, b);
                    graph2D.a(this.a.c());
                    this.b.a(this.view, new y(b).a(), this.a.c());
                }
            }
            final t a = this.a(n, n2);
            this.b(a.a(), a.b());
            this.view.updateView();
        }
    }
    
    public void mouseReleasedLeft(final double n, final double n2) {
        this.c(n, n2);
    }
    
    private void c(final double n, final double n2) {
        if (this.a != null) {
            final t a = this.a(n, n2);
            this.b(a.a(), a.b());
            this.a(this.a, a.a(), a.b());
            this.view.updateView();
            this.a = null;
        }
        if (this.c) {
            this.getGraph2D().s();
        }
        this.c = false;
        this.view.setDrawingMode(0);
        this.b.a();
        this.b = null;
        if (this.isEditing()) {
            this.setEditing(false);
        }
        this.reactivateParent();
    }
    
    public void cancelEditing() {
        this.c(this.translateX(this.lastPressEvent.getX()), this.translateY(this.lastPressEvent.getY()));
    }
    
    protected void a(final eU eu) {
    }
    
    protected void a(final eU eu, final double n, final double n2) {
    }
    
    protected t a(final double n, final double n2) {
        return this.b(this.a, n, n2);
    }
    
    protected t b(final eU eu, final double n, final double n2) {
        final fO a = eu.g().a();
        return a.a(eu, a.a(eu.b(), new t(n, n2)));
    }
    
    protected void b(final double n, final double n2) {
        this.c(this.a, n, n2);
    }
    
    protected void c(final eU eu, final double n, final double n2) {
        this.d(eu, n, n2);
        this.b.a(this.getGraph2D());
    }
    
    private void d(final eU eu, final double n, final double n2) {
        final boolean z = fj.z;
        eu.a(eu.g().a().a(eu.b(), new t(n, n2)));
        final bu graph2D = this.getGraph2D();
        final q b = b(eu);
        final e c = eu.c();
        while (c.f()) {
            final d a = c.a();
            if (this.a(a)) {
                final aB i = graph2D.i(a);
                if (a.c() == b) {
                    ic.a(this.view, i, n, n2, true);
                }
                if (a.d() == b) {
                    ic.a(this.view, i, n, n2, false);
                }
            }
            c.g();
            if (z) {
                break;
            }
        }
    }
    
    private eU d(final double n, final double n2) {
        return this.getHitInfo(n, n2).o();
    }
    
    protected cW getHitInfo(final double n, final double n2) {
        final cW b = this.b(n, n2, 6, true);
        this.setLastHitInfo(b);
        return b;
    }
    
    private static q b(final eU eu) {
        final fj b = eu.b();
        return (b == null) ? null : b.getNode();
    }
}
