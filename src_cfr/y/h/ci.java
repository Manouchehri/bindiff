/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.h.a.v;
import y.h.bu;
import y.h.cA;
import y.h.ch;
import y.h.cm;
import y.h.fj;
import y.h.gd;

public class cI
extends cA {
    private boolean b = false;

    public cI() {
        this(null);
    }

    public cI(ch ch2) {
        super(cm.v.toString(), ch2);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ch ch2 = this.a(actionEvent);
        if (ch2 == null) return;
        this.a(ch2);
        ch2.getGraph2D().T();
    }

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
        this.a(y2, ch2);
        object = object2.a();
        do {
            if (!object.f()) return;
            q q2 = object.e();
            if (this.b()) {
                bu2.a(q2, true);
            }
            object.g();
        } while (!bl2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected q a(y y2, ch ch2) {
        bu bu2 = ch2.getGraph2D();
        bu2.r();
        try {
            q q2 = null;
            if (y2.isEmpty()) {
                if (this.c()) {
                    q2 = this.b(ch2);
                }
            } else {
                q2 = this.b(y2, ch2);
            }
            if (q2 != null) {
                this.a(q2, ch2);
            }
            q q3 = q2;
            return q3;
        }
        finally {
            bu2.s();
        }
    }

    protected void a(q q2, ch ch2) {
        fj fj2 = ch2.getGraph2D().t(q2);
        if (fj2 instanceof gd) {
            gd gd2 = (gd)fj2;
            gd2.a(0).setLabelText(this.c(q2, ch2));
            gd2.a(1).setLabelText(this.b(q2, ch2));
            if (!fj.z) return;
        }
        fj2.setLabelText(this.c(q2, ch2));
    }

    protected String b(q q2, ch ch2) {
        return "Folder";
    }

    protected String c(q q2, ch ch2) {
        return "Group";
    }

    protected q b(ch ch2) {
        bu bu2 = ch2.getGraph2D();
        q q2 = this.a(bu2).c(bu2);
        double d2 = ch2.getCenter().getX();
        double d3 = ch2.getCenter().getY();
        bu2.a(q2, d2, d3);
        return q2;
    }

    protected q b(y y2, ch ch2) {
        bu bu2 = ch2.getGraph2D();
        q q2 = this.a(bu2).a(y2);
        q q3 = this.a(bu2).b(q2);
        this.a(q3, bu2);
        this.a(bu2).c(y2, q3);
        this.b(q3, bu2);
        return q3;
    }

    protected boolean a(bu bu2, q q2) {
        return bu2.v(q2);
    }

    @Override
    protected void a(q q2, bu bu2) {
    }

    @Override
    protected void b(q q2, bu bu2) {
    }

    public boolean c() {
        return this.b;
    }
}

