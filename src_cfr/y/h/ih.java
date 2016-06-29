/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.r;
import y.h.a.a;
import y.h.a.v;
import y.h.aA;
import y.h.aB;
import y.h.bu;
import y.h.ch;
import y.h.eR;
import y.h.fj;
import y.h.gZ;

class ih {
    private Map a;

    ih() {
    }

    void a(bu bu2, q q2) {
        boolean bl2 = fj.z;
        this.a = null;
        v v2 = bu2.C();
        if (v2 == null) return;
        q q3 = v2.n(q2);
        do {
            if (q3 == null) return;
            if (this.a == null) {
                this.a = new LinkedHashMap();
            }
            this.a.put(q3, bu2.t(q3).getBoundingBox());
            q3 = v2.n(q3);
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    void a(bu var1_1) {
        var16_2 = fj.z;
        if (this.a == null) return;
        var2_3 = this.a.entrySet().iterator();
        do lbl-1000: // 3 sources:
        {
            if (var2_3.hasNext() == false) return;
            var3_4 = var2_3.next();
            var4_5 = var1_1.t((q)var3_4.getKey());
            var5_6 = var4_5.getAutoBoundsFeature();
            if (var5_6 == null) ** GOTO lbl-1000
            var6_7 = (Rectangle2D)var3_4.getValue();
            var7_8 = var5_6.getMinimalAutoBounds();
            var8_9 = Math.max(0.0, var7_8.getX() - var6_7.getX());
            var10_10 = Math.max(0.0, var7_8.getY() - var6_7.getY());
            var12_11 = Math.max(0.0, var6_7.getMaxX() - var7_8.getMaxX());
            var14_12 = Math.max(0.0, var6_7.getMaxY() - var7_8.getMaxY());
            var5_6.setAutoBoundsInsets(new r(var10_10, var8_9, var14_12, var12_11));
        } while (!var16_2);
    }

    void a() {
        this.a = null;
    }

    void b(bu bu2, q q2) {
        boolean bl2 = fj.z;
        y y2 = new y(q2);
        v v2 = bu2.C();
        if (v2 != null) {
            q q3 = v2.n(q2);
            while (q3 != null) {
                y2.add(q3);
                q3 = v2.n(q3);
                if (bl2) return;
                if (!bl2) continue;
            }
        }
        bu2.a(y2.a());
    }

    void a(bu bu2, d d2) {
        bu2.a(new f(d2).a());
    }

    void a(ch ch2, gZ gZ2) {
        if (gZ2 instanceof eR) {
            this.a(ch2, ((eR)gZ2).f());
            if (!fj.z) return;
        }
        if (!(gZ2 instanceof aA)) return;
        this.a(ch2, ((aA)gZ2).getEdge());
    }

    void a(ch ch2, q q2) {
        this.a(ch2, new y(q2).a(), null);
    }

    void a(ch ch2, d d2) {
        this.a(ch2, null, new f(d2).a());
    }

    /*
     * Unable to fully structure code
     */
    void a(ch var1_1, x var2_2, e var3_3) {
        var8_4 = fj.z;
        var4_5 = var1_1.getGraph2D();
        var4_5.b(1);
        if (var2_2 == null || !var2_2.f()) ** GOTO lbl25
        var5_6 = var4_5.C();
        if (var5_6 != null) ** GOTO lbl12
        while (var2_2.f()) {
            var4_5.t(var2_2.e()).setLayer(0);
            var2_2.g();
            if (var8_4 != false) return;
            if (!var8_4) continue;
lbl12: // 2 sources:
            var6_7 = new HashSet<q>();
            var6_7.add(null);
            while (var2_2.f()) {
                block6 : {
                    var7_8 = var2_2.e();
                    while (var6_7.add(var7_8)) {
                        var4_5.t(var7_8).setLayer(0);
                        var7_8 = var5_6.n(var7_8);
                        if (!var8_4) {
                            if (!var8_4) continue;
                        }
                        break block6;
                    }
                    var2_2.g();
                }
                if (!var8_4) continue;
            }
            break block0;
        }
lbl25: // 4 sources:
        if (var3_3 != null && var3_3.f()) {
            while (var3_3.f()) {
                var4_5.i(var3_3.a()).setLayer(0);
                var3_3.g();
                if (var8_4 != false) return;
                if (!var8_4) continue;
            }
        }
        var1_1.setDrawingMode(3);
    }
}

