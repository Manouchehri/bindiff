/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import y.c.d;
import y.c.p;
import y.c.q;
import y.d.t;
import y.f.X;
import y.f.aE;
import y.f.c.a.A;
import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.cH;
import y.f.c.a.cI;
import y.f.c.a.cJ;
import y.f.c.a.cK;
import y.f.c.a.cL;
import y.f.c.a.cM;
import y.f.c.a.cN;
import y.f.c.a.cO;
import y.f.c.a.cP;
import y.f.c.a.cQ;
import y.f.c.a.cS;
import y.f.c.a.cU;
import y.f.c.a.cV;
import y.f.c.a.cW;
import y.f.c.a.cX;
import y.f.c.a.cZ;
import y.g.e;

final class cF {
    private final Comparator a;
    private final Comparator b;
    private final Comparator c;
    private final Comparator d;
    private final Comparator e;
    private final Comparator f;
    private final int[] g;

    public static cF a(int[] arrn, int[] arrn2, byte[] arrby, int[] arrn3, byte[] arrby2, int[] arrn4, byte by2, byte by3) {
        void var10_14;
        Comparator comparator32;
        void var11_18;
        Comparator comparator222;
        boolean bl2 = N.x;
        switch (by2) {
            Comparator comparator32;
            Comparator comparator222;
            default: {
                comparator32 = new cL(arrby);
                comparator222 = new cL(arrby2);
                if (!bl2) break;
            }
            case 2: {
                comparator32 = new cN(arrby);
                comparator222 = new cN(arrby2);
                if (!bl2) break;
            }
            case 0: {
                comparator32 = new cX(arrby);
                comparator222 = new cX(arrby2);
                if (!bl2) break;
            }
            case 3: {
                comparator32 = new cM(arrby);
                comparator222 = new cM(arrby2);
            }
        }
        switch (by3) {
            case 1: {
                cJ cJ3 = new cJ(arrn3);
                cJ cJ2 = new cJ(arrn4);
                if (!bl2) return new cF(arrn, new cO(arrn), new cP(arrn2), comparator32, (Comparator)var10_14, comparator222, (Comparator)var11_18);
            }
            default: {
                cZ cZ2 = new cZ(arrn3);
                cZ cZ3 = new cZ(arrn4);
                if (!bl2) return new cF(arrn, new cO(arrn), new cP(arrn2), comparator32, (Comparator)var10_14, comparator222, (Comparator)var11_18);
            }
            case 3: 
        }
        cW cW2 = new cW(arrn3);
        cW cW3 = new cW(arrn4);
        return new cF(arrn, new cO(arrn), new cP(arrn2), comparator32, (Comparator)var10_14, comparator222, (Comparator)var11_18);
    }

    /*
     * Unable to fully structure code
     */
    public static cF a(X var0, aU var1_1, aV var2_2, int[] var3_3, int[] var4_4, byte[] var5_5, int[] var6_6, byte[] var7_7, int[] var8_8, byte var9_9, byte var10_10) {
        var33_11 = N.x;
        var11_12 = new d[var0.g()];
        var12_13 = new ArrayList<d>(31);
        var13_14 = new ArrayList<d>(31);
        var14_15 = new ArrayList<d>(31);
        var15_16 = new cV(var0, true, true);
        var16_17 = new cV(var0, true, false);
        var17_18 = new cV(var0, false, true);
        var18_19 = new cV(var0, false, false);
        if (var5_5 == null) {
            var5_5 = new byte[var0.h()];
        }
        Arrays.fill(var5_5, -2);
        if (var8_8 == null) {
            var6_6 = new int[var0.h()];
        }
        if (var7_7 == null) {
            var7_7 = new byte[var0.h()];
        }
        Arrays.fill(var7_7, -2);
        if (var8_8 == null) {
            var8_8 = new int[var0.h()];
        }
        var19_20 = 0;
        block0 : do {
            v0 = var19_20;
            block1 : do {
                if (v0 >= var1_1.b()) return cF.a(var3_3, var4_4, var5_5, var6_6, var7_7, var8_8, var9_9, var10_10);
                var20_21 = var1_1.a(var19_20);
                var21_22 = 0;
                for (var22_23 = var20_21.d().k(); var22_23 != null; var22_23 = var22_23.a(), ++var21_22) {
                    block48 : {
                        v1 = var22_23.c();
                        block3 : do lbl-1000: // 3 sources:
                        {
                            var23_24 = (q)v1;
                            var24_25 = var23_24.d();
                            var3_3[var24_25] = var19_20;
                            var4_4[var24_25] = var21_22;
                            var12_13.clear();
                            var13_14.clear();
                            var14_15.clear();
                            var25_26 = var23_24.a() + 1;
                            if (var33_11) continue block0;
                            for (var26_27 = var23_24.f(); var26_27 != null; var26_27 = var26_27.g()) {
                                var27_31 = var26_27.b();
                                v1 = var28_34 = var2_2.a(var26_27).c();
                                if (var33_11) ** GOTO lbl-1000
                                if (v1 == null || var28_34.g()) {
                                    var5_5[var27_31] = -2;
                                    if (!var33_11) continue;
                                }
                                if (var28_34 == null) continue;
                                if (!var28_34.a()) {
                                    if (var28_34.e()) {
                                        var5_5[var27_31] = 1;
                                        if (!var33_11) continue;
                                    }
                                    if (var28_34.f()) {
                                        var5_5[var27_31] = -1;
                                        if (!var33_11) continue;
                                    }
                                    var5_5[var27_31] = 0;
                                    if (!var33_11) continue;
                                }
                                if (var28_34.e()) {
                                    var5_5[var27_31] = 1;
                                    var12_13.add(var26_27);
                                    if (!var33_11) continue;
                                }
                                if (var28_34.f()) {
                                    var5_5[var27_31] = -1;
                                    var13_14.add(var26_27);
                                    if (!var33_11) continue;
                                }
                                var5_5[var27_31] = 0;
                                var14_15.add(var26_27);
                                if (!var33_11) continue;
                            }
                            if (var12_13.size() > 0) {
                                var12_13.toArray(var11_12);
                                e.a(var11_12, 0, var12_13.size(), var16_17);
                                var26_28 = 0;
                                var27_32 = -1.7976931348623157E308;
                                for (var29_35 = 0; var29_35 < var12_13.size(); ++var29_35) {
                                    var30_36 = var11_12[var29_35];
                                    var31_37 = var0.n((d)var30_36).b;
                                    v2 = (int)(var31_37 DCMPL var27_32);
                                    if (!var33_11) {
                                        if (v2 != 0) {
                                            var27_32 = var31_37;
                                            var26_28 += var25_26;
                                        }
                                        var6_6[var30_36.b()] = var26_28;
                                        if (!var33_11) continue;
                                    }
                                    break;
                                }
                            } else {
                                v2 = var13_14.size();
                            }
                            if (v2 > 0) {
                                var13_14.toArray(var11_12);
                                e.a(var11_12, 0, var13_14.size(), var16_17);
                                var26_27 = (reference)false ? 1 : 0;
                                var27_31 = (int)-1.7976931348623157E308;
                                for (var29_35 = var13_14.size() - 1; var29_35 >= 0; --var29_35) {
                                    var30_36 = var11_12[var29_35];
                                    var31_37 = var0.n((d)var30_36).b;
                                    v3 = (int)(var31_37 DCMPL var27_31);
                                    if (!var33_11) {
                                        if (v3 != 0) {
                                            var27_31 = (int)var31_37;
                                            var26_27 += var25_26;
                                        }
                                        var6_6[var30_36.b()] = var26_27;
                                        if (!var33_11) continue;
                                    }
                                    break;
                                }
                            } else {
                                v3 = var14_15.size();
                            }
                            if (v3 > 0) {
                                var14_15.toArray(var11_12);
                                e.a(var11_12, 0, var14_15.size(), var15_16);
                                var26_27 = (reference)false ? 1 : 0;
                                var27_31 = (int)-1.7976931348623157E308;
                                for (var29_35 = var14_15.size() - 1; var29_35 >= 0; --var29_35) {
                                    var30_36 = var11_12[var29_35];
                                    var31_37 = var0.n((d)var30_36).a;
                                    v4 = (int)(var31_37 DCMPL var27_31);
                                    if (!var33_11) {
                                        if (v4 != 0) {
                                            var27_31 = (int)var31_37;
                                            var26_27 += var25_26;
                                        }
                                        var6_6[var30_36.b()] = var26_27;
                                        if (!var33_11) continue;
                                    }
                                    break block48;
                                }
                            }
                            var12_13.clear();
                            var13_14.clear();
                            var14_15.clear();
                            for (var26_29 = var23_24.g(); var26_29 != null; var26_29 = var26_29.h()) {
                                var27_33 = var26_29.b();
                                v1 = var28_34 = var2_2.a(var26_29).e();
                                if (var33_11) continue block3;
                                if (v1 == null || var28_34.g()) {
                                    var7_7[var27_33] = -2;
                                    if (!var33_11) continue;
                                }
                                if (var28_34 == null) continue;
                                if (!var28_34.a()) {
                                    if (var28_34.e()) {
                                        var7_7[var27_33] = 1;
                                        if (!var33_11) continue;
                                    }
                                    if (var28_34.f()) {
                                        var7_7[var27_33] = -1;
                                        if (!var33_11) continue;
                                    }
                                    var7_7[var27_33] = 0;
                                    if (!var33_11) continue;
                                }
                                if (var28_34.e()) {
                                    var7_7[var27_33] = 1;
                                    var12_13.add(var26_29);
                                    if (!var33_11) continue;
                                }
                                if (var28_34.f()) {
                                    var7_7[var27_33] = -1;
                                    var13_14.add(var26_29);
                                    if (!var33_11) continue;
                                }
                                var7_7[var27_33] = 0;
                                var14_15.add(var26_29);
                                if (!var33_11) continue;
                            }
                            break;
                        } while (true);
                        if (var12_13.size() > 0) {
                            var12_13.toArray(var11_12);
                            e.a(var11_12, 0, var12_13.size(), var18_19);
                            var26_30 = 0;
                            var27_31 = (int)-1.7976931348623157E308;
                            for (var29_35 = var12_13.size() - 1; var29_35 >= 0; --var29_35) {
                                var30_36 = var11_12[var29_35];
                                var31_37 = var0.o((d)var30_36).b;
                                v4 = (int)(var31_37 DCMPL var27_31);
                                if (!var33_11) {
                                    if (v4 != 0) {
                                        var27_31 = (int)var31_37;
                                        var26_30 += var25_26;
                                    }
                                    var8_8[var30_36.b()] = var26_30;
                                    if (!var33_11) continue;
                                }
                                break;
                            }
                        } else {
                            v4 = var13_14.size();
                        }
                    }
                    if (v4 > 0) {
                        var13_14.toArray(var11_12);
                        e.a(var11_12, 0, var13_14.size(), var18_19);
                        var26_27 = (reference)false ? 1 : 0;
                        var27_31 = (int)-1.7976931348623157E308;
                        for (var29_35 = 0; var29_35 < var13_14.size(); ++var29_35) {
                            var30_36 = var11_12[var29_35];
                            var31_37 = var0.o((d)var30_36).b;
                            v5 = (int)(var31_37 DCMPL var27_31);
                            if (!var33_11) {
                                if (v5 != 0) {
                                    var27_31 = (int)var31_37;
                                    var26_27 += var25_26;
                                }
                                var8_8[var30_36.b()] = var26_27;
                                if (!var33_11) continue;
                            }
                            break;
                        }
                    } else {
                        v5 = var14_15.size();
                    }
                    if (v5 <= 0) continue;
                    var14_15.toArray(var11_12);
                    e.a(var11_12, 0, var14_15.size(), var17_18);
                    var26_27 = (reference)false ? 1 : 0;
                    var27_31 = (int)-1.7976931348623157E308;
                    for (var29_35 = var14_15.size() - 1; var29_35 >= 0; --var29_35) {
                        var30_36 = var11_12[var29_35];
                        var31_37 = var0.o((d)var30_36).a;
                        v0 = (int)(var31_37 DCMPL var27_31);
                        if (var33_11) continue block1;
                        if (v0 != 0) {
                            var27_31 = (int)var31_37;
                            var26_27 += var25_26;
                        }
                        var8_8[var30_36.b()] = var26_27;
                        if (!var33_11) continue;
                    }
                    if (!var33_11) continue;
                }
                break;
            } while (true);
            ++var19_20;
        } while (!var33_11);
        return cF.a(var3_3, var4_4, var5_5, var6_6, var7_7, var8_8, var9_9, var10_10);
    }

    private cF(int[] arrn, Comparator comparator, Comparator comparator2, Comparator comparator3, Comparator comparator4, Comparator comparator5, Comparator comparator6) {
        this.a = comparator;
        this.g = arrn;
        this.b = comparator2;
        this.c = comparator3;
        this.d = comparator5;
        this.e = comparator4;
        this.f = comparator6;
    }

    public Comparator a(boolean bl2) {
        if (!bl2) return new cQ(this.g, this.b, this.d, this.f);
        return new cK(this.g, this.b, this.c, this.e);
    }

    public Comparator b(boolean bl2) {
        if (!bl2) return new cU(this.g, this.a, this.b, this.d, this.f, this.c, this.e);
        return new cI(this.g, this.a, this.b, this.c, this.e, this.d, this.f);
    }

    public Comparator c(boolean bl2) {
        if (!bl2) return new cS(this.g, this.a, this.b, this.d, this.f, this.c, this.e);
        return new cH(this.g, this.a, this.b, this.c, this.e, this.d, this.f);
    }
}

