/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import java.util.Iterator;
import y.f.h.D;
import y.f.h.a.a;
import y.f.h.a.b;
import y.f.h.a.c;
import y.f.h.a.f;
import y.f.h.a.i;
import y.f.h.a.j;
import y.f.h.a.m;
import y.f.h.a.n;
import y.f.h.a.o;
import y.f.h.a.p;
import y.f.h.a.r;
import y.f.h.a.s;

public class e
extends b {
    int[] h;

    @Override
    boolean b() {
        boolean bl2 = b.g;
        boolean bl3 = super.b();
        this.h = new int[this.c.length];
        int n2 = 0;
        do {
            if (n2 >= this.h.length) return bl3;
            this.h[n2] = -1;
            ++n2;
        } while (!bl2);
        return bl3;
    }

    int a(n n2) {
        boolean bl2 = b.g;
        if (this.h[n2.f()] != -1) return this.h[n2.f()];
        int n3 = 0;
        if (n2.h() != null) {
            block0 : for (i i2 : n2.h()) {
                m m2 = i2.s();
                r r2 = m2.a(i2);
                n3 += m2.a();
                while (r2 != i2) {
                    n3 += this.a((n)r2);
                    m2 = r2.c(m2);
                    n3 += m2.a();
                    r2 = m2.a(r2);
                    if (bl2) break block0;
                    if (bl2) return this.h[n2.f()];
                    if (!bl2) continue;
                }
            }
        }
        this.h[n2.f()] = n3;
        return this.h[n2.f()];
    }

    @Override
    protected void a(n n2, int n3, int n4) {
        boolean bl2 = b.g;
        do {
            if (!n2.d(n4)) return;
            ((a)n2.a(n2.c().c(), n3 ^ 1, n3)).a(2 + this.a(n2));
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected boolean a(n var1_1, n var2_2, m var3_3) {
        var25_4 = b.g;
        var4_5 = var1_1.f();
        var5_6 = false;
        var6_7 = 0;
        var7_8 = new int[2];
        var8_9 = new boolean[2];
        var9_10 = var2_2;
        var10_11 = null;
        var11_12 = 0;
        var12_13 = var9_10;
        var13_14 = 0;
        this.d[0].b();
        this.d[1].b();
        this.e.b();
        this.e.a(var3_3);
        var14_15 = 0;
        var15_16 = false;
        var16_17 = false;
        while (!var5_6 && var6_7 < 2) {
            block32 : {
                block31 : {
                    block30 : {
                        block28 : {
                            var15_16 = var15_16 != false || var16_17 != false || var9_10.c(var4_5) != false;
                            var8_9[0] = var9_10.u() == false;
                            var8_9[1] = false;
                            var7_8[0] = 0;
                            var7_8[1] = 0;
                            var17_18 = null;
                            var18_19 = null;
                            var19_20 = null;
                            var20_21 = 0;
                            if (!var15_16 && var9_10.d(var4_5)) {
                                this.a(var9_10, 1, var4_5);
                            }
                            var21_22 = 0;
                            block1 : do {
                                v0 = var21_22;
                                block2 : while (v0 < 2) {
                                    v1 = var8_9[var21_22];
                                    if (var25_4) break block28;
                                    if (v1 != 0) ** GOTO lbl122
                                    var12_13 = var9_10;
                                    var13_14 = var21_22;
                                    if (var21_22 != 1 || var15_16 || var10_11 == null) ** GOTO lbl-1000
                                    var17_18 = var9_10;
                                    var14_15 = var21_22;
                                    var18_19 = var9_10.f(var21_22 ^ 1);
                                    if (var25_4) lbl-1000: // 2 sources:
                                    {
                                        var18_19 = var9_10.f(var21_22);
                                        var17_18 = var18_19.a(var9_10);
                                        v2 = var7_8;
                                        v3 = var21_22;
                                        v2[v3] = v2[v3] + var18_19.a();
                                        v4 = var7_8;
                                        v5 = var21_22;
                                        v4[v5] = v4[v5] + this.a(var9_10);
                                    }
                                    var22_23 = false;
                                    while (!var22_23 && !var8_9[var21_22]) {
                                        if (!(var17_18 instanceof i)) ** GOTO lbl79
                                        var23_25 = (i)var17_18;
                                        var22_23 = true;
                                        if (!var15_16) ** GOTO lbl67
                                        if (var21_22 != 1 || var8_9[0]) ** GOTO lbl76
                                        if (var7_8[0] < var7_8[1]) ** GOTO lbl64
                                        e.a(var9_10, (r)var19_20, 0, var20_21, var7_8[0]);
                                        var8_9[0] = true;
                                        if (!var25_4) ** GOTO lbl76
lbl64: // 2 sources:
                                        var18_19 = var19_20.c(e.a((r)var12_13, (r)var19_20, var13_14, var20_21 ^ 1, var7_8[1]));
                                        var8_9[1] = true;
                                        if (!var25_4) ** GOTO lbl76
lbl67: // 2 sources:
                                        if (var21_22 != 1) ** GOTO lbl-1000
                                        if (!var8_9[0] && var7_8[0] < var7_8[1]) ** GOTO lbl-1000
                                        var8_9[0] = true;
                                        if (var25_4) lbl-1000: // 2 sources:
                                        {
                                            var8_9[1] = true;
                                            var18_19 = var19_20.c(e.a((r)var12_13, (r)var19_20, var13_14, var20_21 ^ 1, var7_8[1]));
                                            ** if (!var25_4) goto lbl76
                                        }
                                        ** GOTO lbl76
lbl-1000: // 2 sources:
                                        {
                                            var18_19 = e.a((r)var12_13, (r)var23_25, var13_14, var23_25.a(var18_19, var21_22 ^ 1), var7_8[0]);
                                        }
lbl76: // 6 sources:
                                        var19_20 = var23_25;
                                        var20_21 = var23_25.a(var18_19, var21_22 ^ 1);
                                        if (!var25_4) continue;
lbl79: // 2 sources:
                                        if (!(var17_18 instanceof n)) continue;
                                        var23_25 = var17_18;
                                        v6 = var7_8;
                                        v7 = var21_22;
                                        v6[v7] = v6[v7] + this.a((n)var23_25);
                                        v0 = (int)var23_25.c(var4_5) ? 1 : 0;
                                        if (var25_4) continue block2;
                                        if (v0 != 0) {
                                            ++var6_7;
                                            var8_9[var21_22] = true;
                                            e.a((r)var12_13, var17_18, var13_14, var23_25.a(var18_19, 1 ^ var14_15), var7_8[var21_22]);
                                            var7_8[var21_22] = 0;
                                            var16_17 = true;
                                            v8 = var22_23 = var8_9[0] == false;
                                            if (!var25_4) break;
                                        }
                                        if (var23_25.e(var4_5)) {
                                            var14_15 = var23_25.a(var18_19, var14_15 ^ 1) ^ 1;
                                            if (var23_25.d(var4_5)) {
                                                this.a((n)var23_25, var14_15, var4_5);
                                            }
                                            if (!var23_25.m().isEmpty()) {
                                                block29 : {
                                                    var24_26 = var23_25.o();
                                                    var13_14 = var14_15;
                                                    var12_13 = var23_25;
                                                    var7_8[var21_22] = 0;
                                                    if (var13_14 == 1) {
                                                        var23_25.e(var24_26);
                                                        if (!var25_4) break block29;
                                                    }
                                                    var23_25.d(var24_26);
                                                }
                                                var18_19 = var24_26;
                                                this.d[var21_22].a(var24_26);
                                                if (var15_16) {
                                                    if (var21_22 == 1 && !var8_9[0]) {
                                                        e.a(var9_10, (r)var19_20, 0, var20_21, var7_8[0]);
                                                    }
                                                    if (!var8_9[var21_22 ^ 1]) {
                                                        ++var6_7;
                                                    }
                                                    var8_9[var21_22 ^ 1] = true;
                                                }
                                            }
                                        }
                                        var18_19 = var17_18.c(var18_19);
                                        var17_18 = var18_19.a(var17_18);
                                        v9 = var7_8;
                                        v10 = var21_22;
                                        v9[v10] = v9[v10] + var18_19.a();
                                        if (!var25_4) continue;
                                    }
lbl122: // 4 sources:
                                    ++var21_22;
                                    if (!var25_4) continue block1;
                                }
                                break block1;
                                break;
                            } while (true);
                            v1 = var6_7;
                        }
                        if (v1 >= 2) continue;
                        v11 = var8_9[0];
                        if (var25_4 != false) return v11;
                        v12 = var21_22 = v11 == false ? 0 : 1;
                        if (var10_11 == null) ** GOTO lbl-1000
                        if (var11_12 == var21_22) {
                            var10_11.d();
                        }
                        if (var21_22 != 0) ** GOTO lbl-1000
                        var9_10.r().b(var10_11.r());
                        if (var25_4) lbl-1000: // 2 sources:
                        {
                            var9_10.r().a(var10_11.r());
                            if (var25_4) {
                                ** if (var21_22 != 0) goto lbl142
                            }
                        }
                        ** GOTO lbl145
lbl-1000: // 2 sources:
                        {
                            var9_10.e(var3_3);
                            if (!var25_4) break block30;
                        }
lbl142: // 2 sources:
                        var9_10.d(var3_3);
                    }
                    var9_10.o();
lbl145: // 2 sources:
                    this.e.a(this.d[var21_22]);
                    if (!var15_16) {
                        this.e.d(this.d[var21_22 ^ 1]);
                    }
                    if (var19_20.f() != var4_5) ** GOTO lbl-1000
                    var5_6 = true;
                    var22_24 = this.e.d();
                    while (var22_24.hasNext()) {
                        var23_25 = (m)var22_24.next();
                        var23_25.b((r)var19_20);
                        var23_25.j();
                        if (!var25_4) {
                            if (!var25_4) continue;
                        }
                        break block31;
                    }
                    if (var20_21 == 0) {
                        var19_20.r().b(this.e);
                        if (!var25_4) break block32;
                    }
                }
                var19_20.r().c(this.e);
            }
            this.e.b();
            if (var25_4) lbl-1000: // 2 sources:
            {
                var19_20.e();
                var10_11 = var19_20;
                var11_12 = var20_21;
                var9_10 = var19_20.b();
                var6_7 = 0;
            }
            this.d[0].b();
            this.d[1].b();
            if (!var25_4) continue;
        }
        v11 = var5_6;
        return v11;
    }

    @Override
    public boolean a(D d2) {
        this.f = new j();
        if (!super.a(d2)) return false;
        this.f = new c(d2);
        return super.a(d2);
    }
}

