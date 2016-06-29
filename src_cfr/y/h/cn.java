/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.AbstractAction;
import y.c.A;
import y.c.d;
import y.c.q;
import y.c.x;
import y.c.y;
import y.h.a.v;
import y.h.bu;
import y.h.ch;
import y.h.cm;
import y.h.fj;
import y.h.hV;

class cN
extends AbstractAction {
    ch a;
    boolean b;

    public cN(ch ch2, boolean bl2) {
        this.a = ch2;
        this.b = bl2;
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
        bu bu2 = ch2.getGraph2D();
        y y2 = this.a(bu2);
        if (y2.isEmpty()) return;
        bu2.r();
        try {
            y y3 = this.a(bu2, y2);
            this.a(bu2, y3, y2);
            this.b(bu2, y3, y2);
        }
        finally {
            bu2.s();
        }
        ch2.updateWorldRect();
        ch2.updateView();
    }

    /*
     * Unable to fully structure code
     */
    protected y a(bu var1_1, y var2_2) {
        block6 : {
            var14_3 = fj.z;
            var3_4 = new y();
            if (var2_2.size() <= 0) return var3_4;
            var4_5 = var1_1.d();
            var3_4.add(var4_5);
            var5_6 = var1_1.t();
            var6_7 = new ArrayList<Iterator<E>>();
            var7_8 = var1_1.C();
            var8_9 = 0;
            var9_10 = var2_2.a();
            while (var9_10.f()) {
                block7 : {
                    var10_12 = var9_10.e();
                    v0 = this.b;
                    if (var14_3) break block6;
                    if (v0 != 0) {
                        var1_1.a(var10_12, var4_5);
                        if (!var14_3) break block7;
                    }
                    var1_1.a(var4_5, var10_12);
                }
                v1 = var11_13 = var7_8 == null ? null : var7_8.n(var10_12);
                if (var11_13 != null) ** GOTO lbl-1000
                ++var8_9;
                if (var14_3) lbl-1000: // 2 sources:
                {
                    if ((var12_14 = var5_6.a(var11_13)) == 0) {
                        var6_7.add(var11_13);
                    }
                    var5_6.a((Object)var11_13, ++var12_14);
                }
                var9_10.g();
                if (!var14_3) continue;
            }
            v0 = 0;
        }
        var9_11 = v0;
        var10_12 = null;
        for (q var12_16 : var6_7) {
            var13_17 = var5_6.a(var12_16);
            if (var9_11 >= var13_17) continue;
            var9_11 = var13_17;
            var10_12 = var12_16;
            if (var14_3 != false) return var3_4;
            if (!var14_3) continue;
        }
        if (var9_11 <= var8_9) return var3_4;
        var7_8.b(var3_4, var10_12);
        return var3_4;
    }

    protected y a(bu bu2) {
        boolean bl2 = fj.z;
        y y2 = new y();
        x x2 = bu2.o();
        do {
            if (!x2.f()) return y2;
            q q2 = x2.e();
            if (bu2.v(q2)) {
                y2.add(q2);
            }
            x2.g();
        } while (!bl2);
        return y2;
    }

    protected void a(bu bu2, y y2, y y3) {
        hV.a(bu2, y2);
    }

    protected void b(bu bu2, y y2, y y3) {
        boolean bl2 = fj.z;
        bu2.N();
        x x2 = y2.a();
        do {
            if (!x2.f()) return;
            q q2 = x2.e();
            bu2.a(q2, true);
            x2.g();
        } while (!bl2);
    }

    protected ch a(ActionEvent actionEvent) {
        return cm.a(actionEvent, this.a);
    }
}

