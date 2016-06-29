/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.ArrayList;
import java.util.Iterator;
import y.a.u;
import y.c.A;
import y.c.c;
import y.c.d;
import y.c.h;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.y;
import y.f.X;
import y.f.c.R;
import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aS;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.ba;
import y.f.c.a.x;
import y.f.c.aj;
import y.g.J;

public class bL
implements aT {
    private aT a = new ba(new aj());
    private aS b = new x();

    /*
     * Unable to fully structure code
     */
    @Override
    public void a(X var1_1, aU var2_2, aV var3_3) {
        block34 : {
            block33 : {
                block32 : {
                    var30_4 = N.x;
                    var4_5 = var1_1.c(N.t);
                    if (var4_5 == null) {
                        return;
                    }
                    var5_6 = new ArrayList<Object>(64);
                    var6_7 = var1_1.o();
                    while (var6_7.f()) {
                        var7_8 = var6_7.e();
                        if (var4_5.d(var7_8)) {
                            var5_6.add(var7_8);
                        }
                        var6_7.g();
                        if (!var30_4) continue;
                    }
                    var6_7 = new i();
                    var7_8 = var1_1.t();
                    var8_9 = y.a.h.a((i)var1_1, (A)var7_8);
                    var9_10 = new int[var8_9];
                    var10_11 = 0;
                    while (var10_11 < var9_10.length) {
                        var9_10[var10_11] = var10_11++;
                        if (!var30_4) continue;
                    }
                    var10_12 = new q[var1_1.e()];
                    var11_13 = var6_7.u();
                    var12_14 = var6_7.u();
                    var13_15 = var6_7.t();
                    var14_16 = var6_7.t();
                    var15_17 = new q[var2_2.b()];
                    var17_18 = var2_2.b() + var5_6.size() + 2;
                    var18_19 = var2_2.b() > 0 ? var7_8.a(var2_2.a(0).d().b()) : -1;
                    var19_20 = var17_18;
                    var20_21 = 0;
                    while (var20_21 < var15_17.length) {
                        block31 : {
                            var15_17[var20_21] = var21_23 = var6_7.d();
                            var22_25 = 0;
                            for (var23_29 = var2_2.a((int)var20_21).d().k(); var23_29 != null; var22_25 += var24_34.b(), var23_29 = var23_29.a()) {
                                var24_34 = (q)var23_29.c();
                                var10_12[var24_34.d()] = var21_23;
                                var9_10[var7_8.a((Object)var24_34)] = var18_19;
                                if (!var30_4) {
                                    if (!var30_4) continue;
                                }
                                break block31;
                            }
                            if (var20_21 > 0) {
                                var23_29 = var15_17[var20_21 - 1];
                                var24_35 = var6_7.a((q)var23_29, (q)var21_23);
                                var12_14.a((Object)var24_35, 1);
                                var11_13.a((Object)var24_35, var22_25);
                                var19_20 = Math.max(var19_20, var22_25);
                            }
                            ++var20_21;
                        }
                        if (!var30_4) continue;
                    }
                    var20_22 = var1_1.o();
                    while (var20_22.f()) {
                        var21_23 = var20_22.e();
                        if (var9_10[var7_8.a(var21_23)] == var18_19) {
                            var7_8.a(var21_23, var18_19);
                        }
                        var20_22.g();
                        if (!var30_4) continue;
                    }
                    var20_22 = new ArrayList<E>(var5_6.size() + 32);
                    var21_23 = var5_6.iterator();
                    block5 : do lbl-1000: // 3 sources:
                    {
                        v0 = var21_23.hasNext();
                        block6 : while (v0) {
                            var22_27 = (q)var21_23.next();
                            if (var7_8.a(var22_27) != var18_19) ** GOTO lbl-1000
                            var10_12[var22_27.d()] = var23_29 = var6_7.d();
                            v1 = 0;
                            if (var30_4) break block32;
                            var24_36 = v1;
                            for (var25_44 = var22_27.g(); var25_44 != null; var25_44 = var25_44.h()) {
                                v0 = var25_44.e();
                                if (var30_4) continue block6;
                                if (v0) continue;
                                ++var24_37;
                                var26_48 = var25_44.c();
                                var27_51 = var10_12[var26_48.d()];
                                if (var27_51 == null) continue;
                                var28_52 = var27_51.a((q)var23_29);
                                if (var28_52 == null) {
                                    var29_53 = var6_7.a(var27_51, (q)var23_29);
                                    var20_22.add(var29_53);
                                    var11_13.a((Object)var29_53, 1);
                                    if (!var30_4) continue;
                                }
                                var11_13.a((Object)var28_52, var11_13.a(var28_52) + 1);
                                if (!var30_4) continue;
                            }
                            var25_44 = var22_27.f();
                            do {
                                if (var25_44 == null) continue block5;
                                v0 = var25_44.e();
                                if (var30_4) continue block6;
                                if (v0) ** GOTO lbl101
                                ++var24_38;
                                var26_48 = var25_44.d();
                                var27_51 = var10_12[var26_48.d()];
                                if (var27_51 == null) ** GOTO lbl101
                                var28_52 = var23_29.a(var27_51);
                                if (var28_52 != null) ** GOTO lbl-1000
                                var29_53 = var6_7.a((q)var23_29, var27_51);
                                var20_22.add(var29_53);
                                var11_13.a((Object)var29_53, 1);
                                if (var30_4) lbl-1000: // 2 sources:
                                {
                                    var11_13.a((Object)var28_52, var11_13.a(var28_52) + 1);
                                }
lbl101: // 5 sources:
                                var25_44 = var25_44.g();
                            } while (!var30_4);
                        }
                        break block5;
                        break;
                    } while (true);
                    v1 = var21_24 = 0;
                }
                while (var21_24 < var20_22.size()) {
                    var22_26 = (d)var20_22.get(var21_24);
                    var23_31 = var11_13.a(var22_26) * var19_20;
                    var24_39 = var6_7.d();
                    var14_16.a((Object)var24_39, true);
                    var25_44 = var6_7.a(var24_39, var22_26.d());
                    var12_14.a((Object)var25_44, 1);
                    var11_13.a((Object)var25_44, var23_31);
                    var11_13.a(var22_26, var17_18 * var23_31);
                    var6_7.a((d)var22_26, var24_39, var22_26.c());
                    ++var21_24;
                    if (!var30_4) {
                        if (!var30_4) continue;
                    }
                    break block33;
                }
                u.a((i)var6_7, var13_15, var11_13, var12_14);
                var21_24 = Integer.MAX_VALUE;
            }
            var22_26 = var6_7.o();
            while (var22_26.f()) {
                v2 = var14_16.d(var22_26.e());
                if (!var30_4) {
                    if (v2 == 0) {
                        var21_24 = Math.min(var21_24, var13_15.a(var22_26.e()));
                    }
                    var22_26.g();
                    if (!var30_4) continue;
                }
                break block34;
            }
            v2 = 0;
        }
        var22_28 = v2;
        var23_30 = 0;
        while (var23_30 < var15_17.length) {
            block35 : {
                var24_40 = var15_17[var23_30];
                var25_46 = var13_15.a(var24_40) - var21_24;
                while (var25_46 > var22_28) {
                    var2_2.a(0, var22_28);
                    ++var22_28;
                    if (!var30_4) {
                        if (!var30_4) continue;
                    }
                    break block35;
                }
                ++var23_30;
                ++var22_28;
            }
            if (!var30_4) continue;
        }
        for (q var24_41 : var5_6) {
            if (var7_8.a(var24_41) != var18_19) continue;
            var25_45 = var10_12[var24_41.d()];
            if (var25_45 != null) {
                block36 : {
                    var26_50 = var13_15.a(var25_45) - var21_24;
                    while (var26_50 >= var2_2.b()) {
                        var2_2.a(0, var2_2.b());
                        if (!var30_4) {
                            if (!var30_4) continue;
                        }
                        break block36;
                    }
                    var2_2.a(var26_50).a(var24_41);
                }
                if (!var30_4) continue;
            }
            if (var2_2.b() == 0) {
                var2_2.a(0, 0);
            }
            var2_2.a(0).a(var24_41);
            if (!var30_4) continue;
        }
        var23_32 = new J(var1_1, (c)var7_8);
        var24_42 = false;
        while (var24_43 < var9_10.length) {
            var25_47 = var9_10[var24_43];
            if (var30_4 != false) return;
            if (var25_47 != var18_19) {
                var23_32.c(new Integer(var25_47));
                var26_49 = var2_2.a();
                this.a.a(var1_1, var26_49, var3_3);
                this.b.a(var1_1, var3_3, var26_49, var2_2);
            }
            ++var24_43;
            if (!var30_4) continue;
        }
        var23_32.b();
        var1_1.a((A)var7_8);
    }
}

