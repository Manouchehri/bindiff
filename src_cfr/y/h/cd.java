/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.HashSet;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.h.a.a;
import y.h.a.h;
import y.h.a.v;
import y.h.bu;
import y.h.cA;
import y.h.ch;
import y.h.cm;
import y.h.fj;
import y.h.gd;

public class cD
extends cA {
    private boolean b;
    private boolean c = false;

    public cD() {
        this(null);
    }

    public cD(ch ch2) {
        super(cm.A.toString(), ch2);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ch ch2 = this.a(actionEvent);
        if (ch2 == null) return;
        this.a(ch2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public void a(ch var1_1) {
        var12_2 = fj.z;
        var2_3 = var1_1.getGraph2D();
        var3_4 = this.a(var2_3);
        if (var3_4 == null) return;
        var4_5 = new y();
        var5_6 = var3_4.e(var2_3);
        this.a(var3_4, var5_6, var4_5, var2_3);
        var6_7 = new y(var2_3.J());
        var2_3.r();
        try {
            var7_8 = new HashSet<q>(var4_5);
            var8_9 = new y(var4_5);
            var9_10 = var4_5.a();
            while (var9_10.f()) {
                v0 = var10_11 = var3_4.n(var9_10.e());
                if (!var12_2) {
                    if (v0 != null && var7_8.add((q)var10_11)) {
                        var8_9.add(var10_11);
                    }
                    var9_10.g();
                    if (!var12_2) continue;
                }
                ** GOTO lbl26
            }
            var2_3.a(var8_9.a());
            var9_10 = var4_5.a();
            while (var9_10.f()) {
                v0 = var9_10.e();
lbl26: // 2 sources:
                var10_11 = v0;
                v1 = var2_3.f(var10_11);
                if (!var12_2) {
                    if (v1) {
                        this.c(var10_11, var2_3);
                    }
                    var9_10.g();
                    if (!var12_2) continue;
                }
            }
        }
        catch (Throwable var11_12) {
            var2_3.s();
            throw var11_12;
        }
        var2_3.s();
        v1 = this.b();
        if (v1 == false) return;
        var7_8 = var6_7.a();
        do {
            if (var7_8.f() == false) return;
            var8_9 = var7_8.e();
            if (var2_3.f((q)var8_9)) {
                var2_3.a((q)var8_9, true);
            }
            var7_8.g();
        } while (!var12_2);
    }

    /*
     * Unable to fully structure code
     */
    private void a(v var1_1, q var2_2, y var3_3, bu var4_4) {
        var7_5 = fj.z;
        var5_6 = var1_1.p(var2_2);
        do {
            if (var5_6.f() == false) return;
            var6_7 = var5_6.e();
            if (!this.a(var4_4, var6_7)) ** GOTO lbl-1000
            if (this.c && var1_1.k(var6_7)) {
                this.a(var1_1, var6_7, var3_3, var4_4);
            }
            var3_3.add(var6_7);
            if (var7_5) lbl-1000: // 2 sources:
            {
                if (var1_1.k(var6_7)) {
                    this.a(var1_1, var6_7, var3_3, var4_4);
                }
            }
            var5_6.g();
        } while (!var7_5);
    }

    protected boolean a(bu bu2, q q2) {
        v v2 = this.a(bu2);
        if (!bu2.v(q2)) return false;
        if (!v2.k(q2)) return false;
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void c(q q2, bu bu2) {
        bu2.r();
        try {
            v v2 = this.a(bu2);
            q q3 = v2.n(q2);
            a a2 = null;
            boolean bl2 = false;
            if (q3 != null) {
                a2 = bu2.t(q3).getAutoBoundsFeature();
                boolean bl3 = bl2 = a2 != null && a2.isAutoBoundsEnabled();
                if (bl2) {
                    a2.setAutoBoundsEnabled(false);
                }
            }
            try {
                this.a(q2, bu2);
                this.b(bu2, q2);
                this.b(q2, bu2);
            }
            finally {
                if (bl2) {
                    a2.setAutoBoundsEnabled(true);
                }
            }
        }
        finally {
            bu2.s();
        }
        bu2.T();
    }

    private void b(bu bu2, q q2) {
        this.a(bu2).e(q2);
        this.a(bu2.t(q2));
    }

    protected void a(fj fj2) {
        if (fj2 instanceof gd) {
            gd gd2 = (gd)fj2;
            boolean bl2 = gd2.isSelected();
            fj2 = gd2.a(1);
            gd2.b(fj2);
            if (this.c()) {
                gd2.setSelected(bl2);
            }
            fj2.setLocation(gd2.a(0).getX(), gd2.a(0).getY());
            if (!(fj2 instanceof h)) return;
            if (((h)((Object)fj2)).isGroupClosed()) return;
            ((h)((Object)fj2)).setGroupClosed(true);
            if (!fj.z) return;
        }
        if (!(fj2 instanceof h)) return;
        if (((h)((Object)fj2)).isGroupClosed()) return;
        ((h)((Object)fj2)).setGroupClosed(true);
    }

    public boolean c() {
        return this.b;
    }
}

