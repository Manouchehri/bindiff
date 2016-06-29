/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.HashMap;
import java.util.Map;
import y.c.c;
import y.c.d;
import y.c.i;
import y.c.x;
import y.f.b.f;
import y.g.C;
import y.g.F;
import y.g.q;
import y.h.a.v;
import y.h.bD;
import y.h.bu;
import y.h.fj;

public class bE
extends F {
    private c a;
    private v b;

    public bE() {
        this(new bD());
    }

    public bE(C c2) {
        super(c2);
    }

    @Override
    protected void b(i i2, i i3) {
        boolean bl2;
        block3 : {
            bl2 = fj.z;
            super.b(i2, i3);
            v v2 = this.a(i2);
            if (v2 != null) {
                this.a = v2.e();
                if (!bl2) break block3;
            }
            this.a = i2.c(f.d);
        }
        if (this.a == null) {
            this.a = q.a(Boolean.FALSE);
            if (!bl2) return;
        }
        this.b = this.a(i3);
        if (this.b != null) return;
        this.b = new v(i3);
        ((bu)i3).a(this.b);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void a(i var1_1, i var2_2, Map var3_3, Map var4_4) {
        var15_5 = fj.z;
        super.a(var1_1, var2_2, var3_3, var4_4);
        var7_6 = this.a(var1_1);
        if (var7_6 == null) ** GOTO lbl-1000
        var5_7 = var7_6.c();
        var6_8 = var7_6.d();
        if (var15_5) lbl-1000: // 2 sources:
        {
            var5_7 = var1_1.c(f.b);
            var6_8 = var1_1.c(f.c);
        }
        if (this.b != null && var5_7 != null && var6_8 != null) {
            block9 : {
                block8 : {
                    var8_9 = new HashMap<Object, y.c.q>();
                    var9_10 = new HashMap<y.c.q, V>();
                    var10_11 = var1_1.o();
                    while (var10_11.f()) {
                        var11_12 = var10_11.e();
                        var8_9.put(var5_7.b(var11_12), var11_12);
                        var10_11.g();
                        if (!var15_5) {
                            if (!var15_5) continue;
                        }
                        break block8;
                    }
                    var10_11 = var1_1.o();
                }
                while (var10_11.f()) {
                    var11_12 = var10_11.e();
                    var12_13 = var6_8.b(var11_12);
                    var9_10.put(var11_12, var8_9.get(var12_13));
                    var10_11.g();
                    if (!var15_5) {
                        if (!var15_5) continue;
                    }
                    break block9;
                }
                var10_11 = var1_1.o();
            }
            while (var10_11.f()) {
                var11_12 = var10_11.e();
                var12_13 = (y.c.q)var9_10.get(var11_12);
                if (var15_5 != false) return;
                if (var12_13 != null && (var13_14 = (y.c.q)var3_3.get(var11_12)) != null && (var14_15 = (y.c.q)var3_3.get(var12_13)) != null) {
                    this.b.c(var13_14, var14_15);
                }
                var10_11.g();
                if (!var15_5) continue;
            }
        }
        this.b = null;
        this.a = null;
    }

    private v a(i i2) {
        v v2 = null;
        if (i2 instanceof bu) {
            return ((bu)i2).C();
        }
        if (v.a(i2) == null) return v2;
        return v.a(i2);
    }

    @Override
    protected void a(y.c.q q2, y.c.q q3) {
        super.a(q2, q3);
        boolean bl2 = this.a.d(q2);
        if (!bl2) return;
        this.b.c(q3);
    }

    @Override
    protected void a(d d2, d d3) {
        super.a(d2, d3);
    }
}

