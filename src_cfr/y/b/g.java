/*
 * Decompiled with CFR 0_115.
 */
package y.b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import y.b.e;
import y.b.f;
import y.b.h;
import y.c.D;
import y.c.p;

final class g
implements ActionListener {
    private final e a;

    private g(e e2) {
        this.a = e2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n2 = e.a;
        boolean bl2 = true;
        D d2 = e.b(this.a);
        synchronized (d2) {
            boolean bl3;
            if (e.b(this.a) == null) {
                return;
            }
            boolean bl4 = bl2 = !e.b(this.a).isEmpty();
            if (bl2) {
                for (p p2 = e.b((e)this.a).k(); p2 != null; p2 = p2.a()) {
                    h h2 = (h)p2.c();
                    bl3 = h2.a();
                    if (n2 == 0) {
                        if (!bl3) continue;
                        e.b(this.a).h(p2);
                        if (n2 == 0) continue;
                    }
                    break;
                }
            } else {
                // MONITOREXIT [1, 6] lbl18 : MonitorExitStatement: MONITOREXIT : var3_4
                bl3 = bl2;
            }
            if (bl3) {
                e.a(this.a, e.c(this.a));
                if (n2 == 0) return;
            }
            e.d(this.a);
            return;
        }
    }

    g(e e2, f f2) {
        this(e2);
    }
}

