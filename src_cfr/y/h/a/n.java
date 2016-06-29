/*
 * Decompiled with CFR 0_115.
 */
package y.h.a;

import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.JComponent;
import y.c.i;
import y.c.q;
import y.h.a.v;
import y.h.bu;
import y.h.c;
import y.h.ch;
import y.h.cm;
import y.h.dw;
import y.h.fj;

public abstract class n
extends c {
    private final fj a;
    private final ch b;

    protected n(fj fj2, ch ch2) {
        this.a = fj2;
        this.b = ch2;
    }

    @Override
    public boolean a(dw dw2) {
        return this.a(this.a, dw2.a(), dw2.b());
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void b(dw var1_1) {
        if (!this.a(this.a, var1_1.a(), var1_1.b())) {
            this.e();
            return;
        }
        if (var1_1.c() != 500) return;
        var2_2 = this.a.getNode();
        if (var2_2 == null) return;
        if (var2_2.e() == null) {
            return;
        }
        var3_3 = v.a(this.b.getGraph2D());
        if (var3_3 == null) return;
        if (var3_3.d(var2_2.e()) == false) return;
        var4_4 = false;
        if (!var3_3.j(var2_2)) ** GOTO lbl-1000
        this.a(var2_2, var3_3);
        var4_4 = true;
        if (v.a != 0) lbl-1000: // 2 sources:
        {
            if (var3_3.k(var2_2)) {
                this.b(var2_2, var3_3);
                var4_4 = true;
            }
            if (var4_4 == false) return;
        }
        this.e();
    }

    protected abstract boolean a(fj var1, double var2, double var4);

    protected void a(q q2, v v2) {
        n.a(q2, cm.z, this.b);
    }

    protected void b(q q2, v v2) {
        n.a(q2, cm.A, this.b);
    }

    private static void a(q q2, Object object, ch ch2) {
        Action action = n.a(object, ch2);
        if (action == null) return;
        if (q2 != null) {
            bu bu2 = ch2.getGraph2D();
            bu2.N();
            bu2.a(q2, true);
        }
        action.actionPerformed(new ActionEvent(ch2, 1001, ""));
    }

    private static Action a(Object object, ch ch2) {
        ActionMap actionMap = ch2.getCanvasComponent().getActionMap();
        if (actionMap == null) return new cm(ch2).v().get(object);
        Action action = actionMap.get(object);
        if (action == null) return new cm(ch2).v().get(object);
        return action;
    }
}

