/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.ActionEvent;
import y.c.f;
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

public class cL
extends cA {
    public cL() {
        this(null);
    }

    public cL(ch ch2) {
        super(cm.y.toString(), ch2);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ch ch2 = this.a(actionEvent);
        if (ch2 == null) return;
        this.a(ch2);
        ch2.getGraph2D().T();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(ch ch2) {
        Object object;
        bu bu2;
        Object object2;
        boolean bl2;
        bl2 = fj.z;
        bu2 = ch2.getGraph2D();
        v v2 = this.a(bu2);
        if (v2 == null) return;
        y y2 = new y();
        object2 = bu2.o();
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
        if (!y2.isEmpty() && !v2.g(bu2)) {
            bu2.r();
            try {
                object = this.a(y2, bu2);
                v2.a((i)bu2, y2);
                this.a((f)object, bu2);
            }
            finally {
                bu2.s();
            }
        }
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

    protected boolean a(bu bu2, q q2) {
        return bu2.v(q2);
    }

    protected f a(y y2, bu bu2) {
        return new f();
    }

    protected void a(f f2, bu bu2) {
    }
}

