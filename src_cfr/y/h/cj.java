/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.t;
import y.f.X;
import y.f.ae;
import y.h.a.a;
import y.h.a.h;
import y.h.a.v;
import y.h.bu;
import y.h.cA;
import y.h.ch;
import y.h.cm;
import y.h.fj;
import y.h.gd;

public class cJ
extends cA {
    private boolean b;

    public cJ() {
        this(null);
    }

    public cJ(ch ch2) {
        super(cm.z.toString(), ch2);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ch ch2 = this.a(actionEvent);
        if (ch2 == null) return;
        this.a(ch2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(ch ch2) {
        Object object;
        boolean bl2 = fj.z;
        bu bu2 = ch2.getGraph2D();
        v v2 = this.a(bu2);
        if (v2 == null) return;
        y y2 = new y();
        Object object2 = bu2.o();
        while (object2.f()) {
            object = object2.e();
            if (bl2) return;
            if (this.a(bu2, (q)object)) {
                y2.add(object);
            }
            object2.g();
            if (!bl2) continue;
        }
        object2 = new y(bu2.J());
        bu2.r();
        try {
            bu2.a(y2.a());
            object = y2.a();
            while (object.f()) {
                q q2 = object.e();
                q q3 = v2.n(q2);
                if (!bl2) {
                    if (q3 != null) {
                        boolean bl3;
                        a a2 = bu2.t(q3).getAutoBoundsFeature();
                        boolean bl4 = bl3 = a2 != null && a2.isAutoBoundsEnabled();
                        if (bl3) {
                            a2.setAutoBoundsEnabled(false);
                        }
                        try {
                            this.c(q2, bu2);
                        }
                        finally {
                            if (bl3) {
                                a2.setAutoBoundsEnabled(true);
                            }
                        }
                    } else {
                        this.c(q2, bu2);
                    }
                    object.g();
                    if (!bl2) continue;
                }
            }
        }
        catch (Throwable var12_13) {
            bu2.s();
            throw var12_13;
        }
        bu2.s();
        if (!this.b()) return;
        object = object2.a();
        do {
            if (!object.f()) return;
            bu2.a(object.e(), true);
            object.g();
        } while (!bl2);
    }

    protected boolean a(bu bu2, q q2) {
        v v2 = this.a(bu2);
        if (!bu2.v(q2)) return false;
        if (!v2.j(q2)) return false;
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void c(q q2, bu bu2) {
        bu2.r();
        try {
            this.a(q2, bu2);
            this.b(bu2, q2);
            this.b(q2, bu2);
        }
        finally {
            bu2.s();
        }
        bu2.T();
    }

    private void b(bu bu2, q q2) {
        v v2 = this.a(bu2);
        bu bu3 = (bu)v2.m(q2);
        t t2 = bu2.o(q2);
        y y2 = new y(bu3.o());
        v2.f(q2);
        fj fj2 = bu2.t(q2);
        this.a(fj2);
        fj2.calcUnionRect(new Rectangle2D.Double());
        Rectangle2D.Double double_ = fj2.getBoundingBox();
        if (y2.size() > 0) {
            y2.add(q2);
            ae.a((X)bu2, y2.a(), t2.a - double_.x, t2.b - double_.y);
            if (!fj.z) return;
        }
        ae.a((X)bu2, q2, t2.a - double_.x, t2.b - double_.y);
    }

    protected void a(fj fj2) {
        if (fj2 instanceof gd) {
            gd gd2 = (gd)fj2;
            boolean bl2 = gd2.isSelected();
            fj2 = gd2.a(0);
            gd2.b(fj2);
            if (this.c()) {
                gd2.setSelected(bl2);
            }
            if (!(fj2 instanceof h)) return;
            if (!((h)((Object)fj2)).isGroupClosed()) return;
            ((h)((Object)fj2)).setGroupClosed(false);
            if (!fj.z) return;
        }
        if (!(fj2 instanceof h)) return;
        if (!((h)((Object)fj2)).isGroupClosed()) return;
        ((h)((Object)fj2)).setGroupClosed(false);
    }

    public boolean c() {
        return this.b;
    }
}

