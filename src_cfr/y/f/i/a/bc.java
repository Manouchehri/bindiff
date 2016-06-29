/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.c.d;
import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.ab;
import y.f.i.a.bD;
import y.f.i.a.bE;
import y.f.i.a.v;
import y.f.y;

class bC {
    private v c;
    private static final Object d = "LEFT_SIDE";
    private static final Object e = "RIGHT_SIDE";
    private static final Object f = "BOTH_SIDES";
    private boolean g;
    private Object[] h;
    private M[] i;
    boolean a;
    private M[] j;
    boolean b;

    /*
     * Unable to fully structure code
     */
    public bC(v var1_1) {
        var14_2 = ab.a;
        super();
        this.h = new Object[4];
        this.i = new M[4];
        this.j = new M[4];
        this.c = var1_1;
        var2_3 = var1_1.k();
        var3_4 = var1_1.l();
        if (var2_3 == null || var3_4 == null) {
            this.g = true;
            return;
        }
        var4_5 = var2_3.f();
        if (var4_5 != (var5_6 = var3_4.c().f())) ** GOTO lbl39
        var6_7 = this.c.i().e();
        if (var6_7.a(var7_9 = this.c.j().e(), Math.min(1.0E-6, Math.min(var6_7.d(), var7_9.d())))) {
            this.g = true;
            if (var14_2 == 0) return;
        }
        var8_11 = var2_3 == y.b || var2_3 == y.a ? 1 : 0;
        var9_13 = var8_11 != 0 && var6_7.a() < var7_9.a() || var8_11 == 0 && var6_7.b() > var7_9.b();
        var10_15 = var9_13 != false ? bC.d : bC.e;
        var11_16 = 0;
        do {
            if (var11_16 >= 4) return;
            if (var4_5 == var11_16) ** GOTO lbl27
            this.h[var11_16] = var10_15;
            if (var14_2 == 0) ** GOTO lbl37
lbl27: // 2 sources:
            var12_17 = M.c(var6_7, var7_9);
            var13_18 = M.b(var6_7, var7_9);
            if (!var9_13) ** GOTO lbl-1000
            this.a = true;
            this.i[var11_16] = var12_17;
            this.j[var11_16] = var13_18;
            if (var14_2 != 0) lbl-1000: // 2 sources:
            {
                this.b = true;
                this.j[var11_16] = var12_17;
                this.i[var11_16] = var13_18;
            }
lbl37: // 4 sources:
            ++var11_16;
        } while (var14_2 == 0);
lbl39: // 2 sources:
        var6_8 = var5_6 < var4_5 ? var5_6 + 4 : var5_6;
        for (var7_10 = var4_5 + 1; var7_10 < var6_8; ++var7_10) {
            this.h[var7_10 % 4] = bC.d;
            if (var14_2 == 0) {
                if (var14_2 == 0) continue;
            }
            ** GOTO lbl-1000
        }
        if (var4_5 < var5_6) {
            v0 = var4_5 + 4;
        } else lbl-1000: // 2 sources:
        {
            v0 = var4_5;
        }
        var7_10 = v0;
        for (var8_11 = var5_6 + 1; var8_11 < var7_10; ++var8_11) {
            this.h[var8_11 % 4] = bC.e;
            if (var14_2 != 0) return;
            if (var14_2 == 0) continue;
        }
        var8_12 = this.c.h().g();
        switch (var4_5) {
            case 0: {
                var9_14 = new M(var8_12.c(), this.c.i().c());
                var10_15 = new M(this.c.i().b(), var8_12.c() + var8_12.a());
                if (var14_2 == 0) ** GOTO lbl74
            }
            case 1: {
                var9_14 = new M(var8_12.d(), this.c.i().c());
                var10_15 = new M(this.c.i().b(), var8_12.d() + var8_12.b());
                if (var14_2 == 0) ** GOTO lbl74
            }
            case 2: {
                var9_14 = new M(this.c.i().b(), var8_12.c() + var8_12.a());
                var10_15 = new M(var8_12.c(), this.c.i().c());
                if (var14_2 == 0) ** GOTO lbl74
            }
            case 3: {
                var9_14 = new M(this.c.i().b(), var8_12.d() + var8_12.b());
                var10_15 = new M(var8_12.d(), this.c.i().c());
                if (var14_2 == 0) ** GOTO lbl74
            }
        }
        var9_14 = null;
        var10_15 = null;
lbl74: // 5 sources:
        this.i[var4_5] = var9_14;
        this.j[var4_5] = var10_15;
        switch (var5_6) {
            case 0: {
                var10_15 = new M(var8_12.c(), this.c.j().c());
                var9_14 = new M(this.c.j().b(), var8_12.c() + var8_12.a());
                if (var14_2 == 0) ** GOTO lbl95
            }
            case 1: {
                var10_15 = new M(var8_12.d(), this.c.j().c());
                var9_14 = new M(this.c.j().b(), var8_12.d() + var8_12.b());
                if (var14_2 == 0) ** GOTO lbl95
            }
            case 2: {
                var10_15 = new M(this.c.j().b(), var8_12.c() + var8_12.a());
                var9_14 = new M(var8_12.c(), this.c.j().c());
                if (var14_2 == 0) ** GOTO lbl95
            }
            case 3: {
                var10_15 = new M(this.c.j().b(), var8_12.d() + var8_12.b());
                var9_14 = new M(var8_12.d(), this.c.j().c());
                if (var14_2 == 0) ** GOTO lbl95
            }
        }
        var9_14 = null;
        var10_15 = null;
lbl95: // 5 sources:
        this.i[var5_6] = var9_14;
        this.j[var5_6] = var10_15;
    }

    private int a(y y2, boolean bl2) {
        if (!bl2) return (y2.f() + 2) % 4;
        return y2.f();
    }

    /*
     * Unable to fully structure code
     */
    public bE a(v var1_1, bD var2_2) {
        var15_3 = ab.a;
        if (this.g != false) return new bE(0);
        if (var1_1.k() == null) {
            return new bE(0);
        }
        var3_4 = null;
        var4_5 = this.a(var1_1.k(), true);
        if (this.h[var4_5] == null) ** GOTO lbl-1000
        var5_6 = this.h[var4_5];
        if (var15_3 != 0) lbl-1000: // 2 sources:
        {
            block12 : {
                if (var1_1.c() != 0) {
                    var6_7 = var1_1.i().e();
                    if (var15_3 == 0) break block12;
                }
                var6_7 = var3_4 = M.a(var1_1.i().e(), var1_1.j().e());
            }
            var7_9 = var6_7.d() > 1.0E-6 ? 1.0E-6 : 0.0;
            var9_11 = this.i[var4_5].a(var6_7, var7_9);
            var9_11 = this.a ? !var9_11 : var9_11;
            var10_15 = this.j[var4_5].a(var6_7, var7_9);
            v0 = this.b ? !var10_15 : (var10_15 = var10_15);
            v1 = var9_11 ? (var10_15 ? bC.f : bC.d) : (var5_6 = bC.e);
        }
        if (this.h[var6_8 = this.a(var1_1.l(), false)] == null) ** GOTO lbl-1000
        var7_10 = this.h[var6_8];
        if (var15_3 != 0) lbl-1000: // 2 sources:
        {
            block13 : {
                if (var1_1.c() != 0) {
                    var8_17 = var1_1.j().e();
                    if (var15_3 == 0) break block13;
                }
                var8_17 = var3_4 != null ? var3_4 : M.a(var1_1.i().e(), var1_1.j().e());
            }
            var9_12 = var8_17.d() > 1.0E-6 ? 1.0E-6 : 0.0;
            var11_20 = this.i[var6_8].a((M)var8_17, var9_12);
            var11_20 = this.a ? !var11_20 : var11_20;
            var12_22 = this.j[var6_8].a((M)var8_17, var9_12);
            v2 = this.b ? !var12_22 : (var12_22 = var12_22);
            v3 = var11_20 ? (var12_22 ? bC.f : bC.d) : bC.e;
            var7_10 = v3;
        }
        if (var5_6 == null) return new bE(0);
        if (var7_10 == null) {
            return new bE(0);
        }
        if (var5_6 == bC.f && var7_10 == bC.f) {
            return new bE(0, var2_2);
        }
        if (var5_6 == bC.f || var7_10 == bC.f) {
            var8_17 = var5_6 != bC.f ? var5_6 : var7_10;
            var9_13 = new bD(var1_1.g(), this.c.g(), var8_17, 1);
            var10_16 = new bE(0, var9_13);
            var10_16.a(var2_2);
            return var10_16;
        }
        if (var5_6 != var7_10) ** GOTO lbl69
        var8_18 = var2_2 != null && bD.b(var2_2).equals(var5_6) == false ? var2_2.c() : 0;
        if (this.c.c() != 2) return new bE(var8_18);
        if (var1_1.c() != 2) return new bE(var8_18);
        if (this.h[var4_5] == null) return new bE(var8_18);
        if (this.h[var6_8] == null) return new bE(var8_18);
        if (!var1_1.k().d()) ** GOTO lbl-1000
        var9_14 = var1_1.j().e().c(var1_1.i().f());
        var11_21 = var1_1.i().e().c(var1_1.j().f());
        var14_23 = var1_1.k().c().f();
        var13_24 = var1_1.l().f();
        if (var15_3 != 0) lbl-1000: // 2 sources:
        {
            var9_14 = var1_1.i().e().c(var1_1.j().f());
            var11_21 = var1_1.j().e().c(var1_1.i().f());
            var13_24 = var1_1.k().c().f();
            var14_23 = var1_1.l().f();
        }
        if (var5_6 != bC.d || this.i[var14_23].a(var11_21) || this.i[var13_24].a(var9_14)) {
            if (var5_6 != bC.e) return new bE(var8_18);
            if (this.j[var14_23].a(var11_21) != false) return new bE(var8_18);
            if (this.j[var13_24].a(var9_14) != false) return new bE(var8_18);
        }
        var8_18 += 2;
        return new bE(var8_18);
lbl69: // 1 sources:
        var8_19 = var2_2 != null && bD.b(var2_2).equals(var5_6) == false ? var2_2.c() : 0;
        return new bE(1 + var8_19);
    }
}

