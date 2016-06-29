/*
 * Decompiled with CFR 0_115.
 */
package y.h.a;

import y.c.i;
import y.c.q;
import y.h.a.h;
import y.h.a.t;
import y.h.a.u;
import y.h.a.v;
import y.h.bu;
import y.h.fj;
import y.h.gd;

public class s
implements u {
    boolean a = true;
    boolean b;

    public boolean a() {
        return this.b;
    }

    @Override
    public void a(t t2) {
        v v2 = (v)t2.getSource();
        if (t2.a() == 6) {
            this.a = v2.l((q)t2.b());
            if (v.a == 0) return;
        }
        if (t2.a() != 4) return;
        q q2 = (q)t2.b();
        bu bu2 = (bu)q2.e();
        fj fj2 = bu2.t(q2);
        if (v2.l(q2)) return;
        h h2 = null;
        if (fj2 instanceof h) {
            h2 = (h)((Object)fj2);
            h2.setGroupClosed(v2.j(q2));
            return;
        }
        if (!(fj2 instanceof gd)) return;
        gd gd2 = (gd)fj2;
        boolean bl2 = gd2.isSelected();
        if (v2.k(q2)) {
            fj2 = gd2.a(0);
            gd2.b(fj2);
            if (this.a()) {
                gd2.setSelected(bl2);
            }
            if (!(fj2 instanceof h)) return;
            h2 = (h)((Object)fj2);
            h2.setGroupClosed(false);
            return;
        }
        fj2 = gd2.a(1);
        gd2.b(fj2);
        if (this.a()) {
            gd2.setSelected(bl2);
        }
        if (!this.a) {
            fj2.setLocation(gd2.a(0).getX(), gd2.a(0).getY());
        }
        if (!(fj2 instanceof h)) return;
        h2 = (h)((Object)fj2);
        h2.setGroupClosed(true);
    }
}

