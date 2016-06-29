/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.MouseEvent;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.t;
import y.h.aB;
import y.h.aC;
import y.h.bu;
import y.h.cW;
import y.h.ch;
import y.h.eU;
import y.h.fO;
import y.h.fP;
import y.h.fj;
import y.h.gU;
import y.h.gX;
import y.h.ic;
import y.h.ih;

public class dH
extends gX {
    protected eU a;
    private ih b;
    private boolean c;

    public dH() {
        this(null);
    }

    public dH(gU gU2) {
        super(gU2);
    }

    protected boolean a(d d2) {
        return aC.b(d2, this.getGraph2D());
    }

    @Override
    public void mousePressedLeft(double d2, double d3) {
        this.c = false;
        eU eU2 = this.d(d2, d3);
        if (eU2 == null) {
            this.reactivateParent();
            if (!fj.z) return;
        }
        this.setEditing(true);
        this.b = new ih();
        this.a = eU2;
        this.a(eU2);
    }

    @Override
    public void mouseDraggedLeft(double d2, double d3) {
        Object object;
        if (this.a == null) return;
        if (!this.c) {
            this.c = true;
            object = this.getGraph2D();
            object.r();
            q q2 = dH.b(this.a);
            if (q2 != null && q2.e() == object) {
                this.b.b((bu)object, q2);
                this.b.a((bu)object, q2);
                object.a(this.a.c());
                this.b.a(this.view, new y(q2).a(), this.a.c());
            }
        }
        object = this.a(d2, d3);
        this.b(object.a(), object.b());
        this.view.updateView();
    }

    @Override
    public void mouseReleasedLeft(double d2, double d3) {
        this.c(d2, d3);
    }

    private void c(double d2, double d3) {
        if (this.a != null) {
            t t2 = this.a(d2, d3);
            this.b(t2.a(), t2.b());
            this.a(this.a, t2.a(), t2.b());
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

    @Override
    public void cancelEditing() {
        this.c(this.translateX(this.lastPressEvent.getX()), this.translateY(this.lastPressEvent.getY()));
    }

    protected void a(eU eU2) {
    }

    protected void a(eU eU2, double d2, double d3) {
    }

    protected t a(double d2, double d3) {
        return this.b(this.a, d2, d3);
    }

    protected t b(eU eU2, double d2, double d3) {
        fO fO2 = eU2.g().a();
        fP fP2 = fO2.a(eU2.b(), new t(d2, d3));
        return fO2.a(eU2, fP2);
    }

    protected void b(double d2, double d3) {
        this.c(this.a, d2, d3);
    }

    protected void c(eU eU2, double d2, double d3) {
        this.d(eU2, d2, d3);
        this.b.a(this.getGraph2D());
    }

    private void d(eU eU2, double d2, double d3) {
        boolean bl2 = fj.z;
        fO fO2 = eU2.g().a();
        fP fP2 = fO2.a(eU2.b(), new t(d2, d3));
        eU2.a(fP2);
        bu bu2 = this.getGraph2D();
        q q2 = dH.b(eU2);
        e e2 = eU2.c();
        do {
            if (!e2.f()) return;
            d d4 = e2.a();
            if (this.a(d4)) {
                aB aB2 = bu2.i(d4);
                if (d4.c() == q2) {
                    ic.a(this.view, aB2, d2, d3, true);
                }
                if (d4.d() == q2) {
                    ic.a(this.view, aB2, d2, d3, false);
                }
            }
            e2.g();
        } while (!bl2);
    }

    private eU d(double d2, double d3) {
        return this.getHitInfo(d2, d3).o();
    }

    @Override
    protected cW getHitInfo(double d2, double d3) {
        cW cW2 = this.b(d2, d3, 6, true);
        this.setLastHitInfo(cW2);
        return cW2;
    }

    private static q b(eU eU2) {
        fj fj2 = eU2.b();
        if (fj2 == null) {
            return null;
        }
        q q2 = fj2.getNode();
        return q2;
    }
}

