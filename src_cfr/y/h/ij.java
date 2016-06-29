/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import y.d.e;
import y.d.p;
import y.d.t;
import y.h.aB;
import y.h.dr;
import y.h.eU;
import y.h.fL;
import y.h.fj;
import y.h.h;
import y.h.hC;
import y.h.x;
import y.h.z;

class ij {
    /*
     * Unable to fully structure code
     */
    public static byte a(aB var0, GeneralPath var1_1, GeneralPath var2_2, Point2D var3_3, Point2D var4_4) {
        block46 : {
            block45 : {
                block44 : {
                    block43 : {
                        block42 : {
                            var48_5 = fj.z;
                            var5_6 = 0;
                            var6_7 = var0.getLineType().getLineWidth();
                            if ((double)var6_7 != 1.0) {
                                var6_7 = 1.0f + (var6_7 - 1.0f) / 8.0f;
                            }
                            var7_8 = var1_1.getPathIterator(null, 0.5);
                            var8_9 = var0.getSourceRealizer();
                            var9_10 = var0.getTargetRealizer();
                            var10_11 = var8_9.b(var0.vb);
                            var11_12 = var9_10.b(var0.zb);
                            if (var10_11 != null) {
                                var13_13 = eU.b(var10_11);
                                v0 = var12_16 = t.a(var13_13, var14_15 = var0.getSourcePoint()) < 1.0E-12;
                                if (!var48_5) break block42;
                            }
                            var12_16 = false;
                        }
                        if (var11_12 != null) {
                            var14_15 = eU.b(var11_12);
                            v1 = var13_14 = t.a(var14_15, var15_17 = var0.getTargetPoint()) < 1.0E-12 ? 1 : 0;
                            if (!var48_5) break block43;
                        }
                        var13_14 = 0;
                    }
                    var14_15 = ij.a(var12_16, var12_16 != false ? var10_11 : var0.getSourcePort(), var8_9);
                    var15_18 = (float)var14_15.a();
                    var16_19 = (float)var14_15.b();
                    var17_20 = new float[2];
                    if (!var7_8.isDone()) {
                        var7_8.currentSegment(var17_20);
                        var15_18 = var17_20[0];
                        var16_19 = var17_20[1];
                    }
                    var18_21 = new Point2D.Double();
                    var19_22 = var12_16 != false ? 1 : 3;
                    v2 = var20_23 = var12_16 != false ? var10_11 : var8_9;
                    while (!var7_8.isDone()) {
                        var7_8.currentSegment(var17_20);
                        var7_8.next();
                        v3 = (int)ij.a(var12_16, var20_23, var17_20[0], var17_20[1]) ? 1 : 0;
                        if (!var48_5) {
                            if (v3 == 0) break;
                            var15_18 = var17_20[0];
                            var16_19 = var17_20[1];
                            if (!var48_5) continue;
                        }
                        break block44;
                    }
                    v3 = 32;
                }
                var21_24 = new float[v3];
                var22_25 = 0;
                if (!ij.a(var19_22, var20_23, var8_9, var15_18, var16_19, var17_20[0], var17_20[1], var18_21)) ** GOTO lbl-1000
                var21_24[var22_25++] = (float)var18_21.getX();
                var21_24[var22_25++] = (float)var18_21.getY();
                var3_3.setLocation(var18_21);
                var21_24[var22_25++] = var17_20[0];
                var21_24[var22_25++] = var17_20[1];
                if (var48_5) lbl-1000: // 2 sources:
                {
                    var21_24[var22_25++] = var17_20[0];
                    var21_24[var22_25++] = var17_20[1];
                    var3_3.setLocation(var17_20[0], var17_20[1]);
                }
                var23_26 = ij.a((boolean)var13_14, var13_14 != 0 ? var11_12 : var0.getTargetPort(), var9_10);
                var17_20[0] = (float)var23_26.a();
                var17_20[1] = (float)var23_26.b();
                while (!var7_8.isDone()) {
                    var7_8.currentSegment(var17_20);
                    var7_8.next();
                    v4 = var22_25;
                    if (!var48_5) {
                        if (v4 == var21_24.length) {
                            var24_27 = new float[var21_24.length * 2];
                            System.arraycopy(var21_24, 0, var24_27, 0, var21_24.length);
                            var21_24 = var24_27;
                        }
                        var21_24[var22_25++] = var17_20[0];
                        var21_24[var22_25++] = var17_20[1];
                        if (!var48_5) continue;
                    }
                    break block45;
                }
                var15_18 = var17_20[0];
                var16_19 = var17_20[1];
                v4 = var13_14;
            }
            var24_28 = v4 != 0 ? 1 : 3;
            var25_29 = var13_14 != 0 ? var11_12 : var9_10;
            var26_30 = var22_25;
            while (var26_30 > 1) {
                var17_20[1] = var21_24[--var26_30];
                var17_20[0] = var21_24[--var26_30];
                v5 = (int)ij.a((boolean)var13_14, var25_29, var17_20[0], var17_20[1]) ? 1 : 0;
                if (!var48_5) {
                    if (v5 == 0) {
                        if (ij.a(var24_28, var25_29, var9_10, var15_18, var16_19, var17_20[0], var17_20[1], var18_21)) {
                            if (++var26_30 + 2 > var21_24.length) {
                                var27_31 = new float[var26_30 + 4];
                                System.arraycopy(var21_24, 0, var27_31, 0, var21_24.length);
                                var21_24 = var27_31;
                            }
                            var21_24[++var26_30] = (float)var18_21.x;
                            var21_24[++var26_30] = (float)var18_21.y;
                            var4_4.setLocation(var18_21);
                            if (!var48_5) break;
                        }
                        ++var26_30;
                        var4_4.setLocation(var15_18, var16_19);
                        if (!var48_5) break;
                    }
                    var15_18 = var17_20[0];
                    var16_19 = var17_20[1];
                    if (!var48_5) continue;
                }
                break block46;
            }
            v5 = 0;
        }
        if ((var27_32 = v5) < (var28_33 = var26_30 - 1) && (var29_34 = (float)var0.getSourceArrow().d()) > 0.0f) {
            var30_36 = 0.0f;
            while (var27_32 < var28_33) {
                v6 = (int)(var30_36 FCMPG var29_34);
                if (!var48_5) {
                    if (v6 >= 0) break;
                    var31_37 = var21_24[var27_32 + 2] - var21_24[var27_32];
                    var32_38 = var21_24[var27_32 + 3] - var21_24[var27_32 + 1];
                    var33_39 = (float)Math.sqrt(var31_37 * var31_37 + var32_38 * var32_38);
                    if ((var30_36 += var33_39) > var29_34) {
                        var21_24[var27_32] = var21_24[var27_32 + 2] - (var30_36 - var29_34) * var31_37 / var33_39;
                        var21_24[var27_32 + 1] = var21_24[var27_32 + 3] - (var30_36 - var29_34) * var32_38 / var33_39;
                        if (!var48_5) break;
                    }
                    var27_32 += 2;
                    if (!var48_5) continue;
                }
                break;
            }
        } else {
            v6 = var27_32;
        }
        if (v6 < var28_33 && (var29_34 = (float)var0.getTargetArrow().d()) > 0.0f) {
            var30_36 = 0.0f;
            while (var27_32 < var28_33) {
                v7 = (int)(var30_36 FCMPG var29_34);
                if (!var48_5) {
                    if (v7 >= 0) break;
                    var31_37 = var21_24[var28_33 - 2] - var21_24[var28_33];
                    var32_38 = var21_24[var28_33 - 1] - var21_24[var28_33 + 1];
                    var33_39 = (float)Math.sqrt(var31_37 * var31_37 + var32_38 * var32_38);
                    if ((var30_36 += var33_39) > var29_34) {
                        var21_24[var28_33] = var21_24[var28_33 - 2] - (var30_36 - var29_34) * var31_37 / var33_39;
                        var21_24[var28_33 + 1] = var21_24[var28_33 - 1] - (var30_36 - var29_34) * var32_38 / var33_39;
                        if (!var48_5) break;
                    }
                    var28_33 -= 2;
                    if (!var48_5) continue;
                }
                break;
            }
        } else {
            v7 = var27_32;
        }
        if (v7 < var28_33 && (var29_34 = (float)var0.getSourceArrow().c() * var6_7) > 0.0f) {
            var30_36 = var21_24[var27_32];
            var31_37 = var21_24[var27_32 + 1];
            var32_38 = var29_34 * var29_34;
            while (var27_32 < var28_33) {
                var33_39 = var21_24[var27_32] - var30_36;
                var34_40 = var21_24[var27_32 + 1] - var31_37;
                var35_41 = var33_39 * var33_39 + var34_40 * var34_40;
                var36_42 = var21_24[var27_32 + 2] - var30_36;
                var37_43 = var21_24[var27_32 + 3] - var31_37;
                var38_44 = var36_42 * var36_42 + var37_43 * var37_43;
                v8 = (int)(var38_44 FCMPL var32_38);
                if (!var48_5) {
                    if (v8 >= 0) {
                        var39_45 = var21_24[var27_32 + 2] - var21_24[var27_32];
                        var40_46 = var21_24[var27_32 + 3] - var21_24[var27_32 + 1];
                        var42_48 = 2.0f * (var33_39 * var39_45 + var34_40 * var40_46);
                        var41_47 = var39_45 * var39_45 + var40_46 * var40_46;
                        var43_49 = var33_39 * var33_39 + var34_40 * var34_40 - var32_38;
                        var44_50 = var42_48 * var42_48 - 4.0f * var41_47 * var43_49;
                        if (var44_50 >= 0.0f && (var46_52 = (- var42_48 + (var45_51 = (float)Math.sqrt(var44_50))) / (2.0f * var41_47)) >= 0.0f && var46_52 <= 1.0f) {
                            v9 = var21_24;
                            v10 = var27_32;
                            v9[v10] = v9[v10] + var39_45 * var46_52;
                            v11 = var21_24;
                            v12 = var27_32 + 1;
                            v11[v12] = v11[v12] + var40_46 * var46_52;
                            if (var35_41 > 0.0f && var27_32 >= 2) {
                                var47_53 = (float)Math.sqrt(var35_41);
                                var21_24[var27_32 - 2] = var21_24[var27_32] - var33_39 * 0.1f / var47_53;
                                var21_24[var27_32 - 1] = var21_24[var27_32 + 1] - var34_40 * 0.1f / var47_53;
                                var27_32 -= 2;
                            }
                        }
                        var5_6 = (byte)(var5_6 | 4);
                        if (!var48_5) break;
                    }
                    var27_32 += 2;
                    if (!var48_5) continue;
                }
                break;
            }
        } else {
            v8 = var27_32;
        }
        if (v8 < var28_33 && (var29_34 = (float)var0.getTargetArrow().c() * var6_7) > 0.0f) {
            var30_36 = var21_24[var28_33];
            var31_37 = var21_24[var28_33 + 1];
            var32_38 = var29_34 * var29_34;
            while (var27_32 < var28_33) {
                var33_39 = var21_24[var28_33] - var30_36;
                var34_40 = var21_24[var28_33 + 1] - var31_37;
                var35_41 = var33_39 * var33_39 + var34_40 * var34_40;
                var36_42 = var21_24[var28_33 - 2] - var30_36;
                var37_43 = var21_24[var28_33 - 1] - var31_37;
                var38_44 = var36_42 * var36_42 + var37_43 * var37_43;
                v13 = (int)(var38_44 FCMPL var32_38);
                if (!var48_5) {
                    if (v13 >= 0) {
                        var39_45 = var21_24[var28_33 - 2] - var21_24[var28_33];
                        var40_46 = var21_24[var28_33 - 1] - var21_24[var28_33 + 1];
                        var42_48 = 2.0f * (var33_39 * var39_45 + var34_40 * var40_46);
                        var41_47 = var39_45 * var39_45 + var40_46 * var40_46;
                        var43_49 = var33_39 * var33_39 + var34_40 * var34_40 - var32_38;
                        var44_50 = var42_48 * var42_48 - 4.0f * var41_47 * var43_49;
                        if (var44_50 >= 0.0f && (var46_52 = (- var42_48 + (var45_51 = (float)Math.sqrt(var44_50))) / (2.0f * var41_47)) >= 0.0f && var46_52 <= 1.0f) {
                            v14 = var21_24;
                            v15 = var28_33;
                            v14[v15] = v14[v15] + var39_45 * var46_52;
                            v16 = var21_24;
                            v17 = var28_33 + 1;
                            v16[v17] = v16[v17] + var40_46 * var46_52;
                            if (var35_41 > 0.0f && var28_33 < var21_24.length + 3) {
                                var47_53 = (float)Math.sqrt(var35_41);
                                var21_24[var28_33 + 2] = var21_24[var28_33] - var33_39 * 0.1f / var47_53;
                                var21_24[var28_33 + 3] = var21_24[var28_33 + 1] - var34_40 * 0.1f / var47_53;
                                var28_33 += 2;
                            }
                        }
                        var5_6 = (byte)(var5_6 | 8);
                        if (!var48_5) break;
                    }
                    var28_33 -= 2;
                    if (!var48_5) continue;
                }
                break;
            }
        } else {
            var2_2.reset();
            v13 = var27_32;
        }
        if (v13 >= var28_33) return var5_6;
        var2_2.moveTo(var21_24[var27_32++], var21_24[var27_32++]);
        var29_35 = var27_32;
        do {
            if (var29_35 > var28_33) return var5_6;
            var2_2.lineTo(var21_24[var29_35++], var21_24[var29_35++]);
        } while (!var48_5);
        return var5_6;
    }

    /*
     * Unable to fully structure code
     */
    public static byte a(aB var0, GeneralPath var1_1, Point2D var2_2, Point2D var3_3) {
        block44 : {
            block43 : {
                var50_4 = fj.z;
                var4_5 = 0;
                var5_6 = var0.bends;
                var6_7 = hC.a().i;
                var6_7.y = 0.0;
                var6_7.x = 0.0;
                var7_8 = var0.getSourceRealizer();
                var8_9 = var0.getTargetRealizer();
                var9_10 = var0.getSourcePort();
                var10_11 = var0.getTargetPort();
                var11_12 = false;
                var1_1.reset();
                var12_13 = var7_8.b(var0.vb);
                var13_14 = var8_9.b(var0.zb);
                if (var12_13 != null) {
                    var15_15 = eU.b(var12_13);
                    v0 = var14_18 = t.a(var15_15, (t)(var16_17 = var0.getSourcePoint())) < 1.0E-12;
                    if (!var50_4) break block43;
                }
                var14_18 = false;
            }
            if (var13_14 != null) {
                var16_17 = eU.b(var13_14);
                v1 = var15_16 = t.a((t)var16_17, (t)(var17_19 = var0.getTargetPoint())) < 1.0E-12;
                if (!var50_4) break block44;
            }
            var15_16 = false;
        }
        var16_17 = var14_18 != false ? var12_13 : var9_10;
        var17_19 = var15_16 != false ? var13_14 : var10_11;
        var18_20 = 0;
        var19_21 = ij.a(var14_18, var16_17, var7_8);
        var20_22 = var19_21.a();
        var22_23 = var19_21.b();
        var24_24 = ij.a(var15_16, var17_19, var8_9);
        var25_25 = var24_24.a();
        var27_26 = var24_24.b();
        if (ij.a(var14_18, var14_18 != false ? var12_13 : var7_8, var20_22, var22_23)) {
            block45 : {
                var30_28 = var20_22;
                var32_30 = var22_23;
                v2 = var34_31 = var14_18 != false ? 1 : 2;
                for (var29_27 = var5_6.k(); var29_27 != null; var29_27 = var29_27.a(), ++var18_20) {
                    var35_34 = (x)var29_27.c();
                    v3 = var11_12 = ij.a(var34_31, var16_17, var7_8, var30_28, var32_30, var35_34.b(), var35_34.c(), var6_7);
                    if (!var50_4) {
                        if (v3) {
                            var20_22 = var6_7.x;
                            var22_23 = var6_7.y;
                            if (!var50_4) break;
                        }
                        var30_28 = var35_34.b();
                        var32_30 = var35_34.c();
                        if (!var50_4) continue;
                    }
                    break block45;
                }
                v3 = var11_12;
            }
            if (!v3 && var29_27 == null && (var11_12 = ij.a(var34_31, var16_17, var7_8, var30_28, var32_30, var25_25, var27_26, var6_7))) {
                var20_22 = var6_7.x;
                var22_23 = var6_7.y;
            }
            if (!var11_12) {
                return var4_5;
            }
        }
        var2_2.setLocation(var20_22, var22_23);
        var11_12 = false;
        var30_29 = var5_6.size();
        if (!ij.a(var15_16, var15_16 != false ? var13_14 : var8_9, var25_25, var27_26)) ** GOTO lbl98
        var32_30 = var25_25;
        var34_32 = var27_26;
        v4 = var36_36 = var15_16 != false ? 1 : 2;
        for (var31_35 = var5_6.l(); var31_35 != null; var31_35 = var31_35.b(), --var30_29) {
            v5 = var18_20;
            v6 = var30_29;
            if (!var50_4) {
                if (v5 == v6) {
                    var37_41 = var20_22;
                    var39_42 = var22_23;
                    var11_12 = ij.a(var36_36, var17_19, var8_9, var32_30, var34_32, var37_41, var39_42, var6_7);
                    if (var11_12) {
                        var25_25 = var6_7.x;
                        var27_26 = var6_7.y;
                        if (!var50_4) break;
                    }
                    var1_1.reset();
                    return var4_5;
                }
                var41_43 = (x)var31_35.c();
                var37_41 = var41_43.b();
                var11_12 = ij.a(var36_36, var17_19, var8_9, var32_30, var34_32, var37_41, var39_42 = var41_43.c(), var6_7);
                if (var11_12) {
                    var25_25 = var6_7.x;
                    var27_26 = var6_7.y;
                    if (!var50_4) break;
                }
                var32_30 = var37_41;
                var34_32 = var39_42;
                if (!var50_4) continue;
            }
            ** GOTO lbl227
        }
        if (!var11_12 && (var11_12 = ij.a(var36_36, var17_19, var8_9, var32_30, var34_32, var20_22, var22_23, var6_7))) {
            if (ij.a(var14_18, var14_18 != false ? var12_13 : var7_8, var6_7.x, var6_7.y)) {
                var11_12 = false;
            }
            var25_25 = var6_7.x;
            var27_26 = var6_7.y;
        }
        if (!var11_12) {
            return var4_5;
        }
lbl98: // 3 sources:
        var3_3.setLocation(var25_25, var27_26);
        var32_30 = var0.getArrowScaleFactor();
        var34_32 = var0.getSourceArrow().d();
        if (var34_32 <= 0.0) ** GOTO lbl148
        if (var18_20 != var30_29) ** GOTO lbl-1000
        var36_37 = var25_25;
        var38_44 = var27_26;
        if (var50_4) lbl-1000: // 2 sources:
        {
            var40_45 /* !! */  = (x)var29_27.c();
            var36_37 = var40_45 /* !! */ .b();
            var38_44 = var40_45 /* !! */ .c();
        }
        if ((var44_51 = Math.sqrt((var40_46 = var36_37 - var20_22) * var40_46 + (var42_50 = var38_44 - var22_23) * var42_50)) <= var34_32) ** GOTO lbl-1000
        var46_54 = var34_32 / var44_51;
        var20_22 += var40_46 * var46_54;
        var22_23 += var42_50 * var46_54;
        if (var50_4) lbl-1000: // 2 sources:
        {
            if (var18_20 >= var30_29) {
                return var4_5;
            }
            if (var18_20 <= var30_29) {
                block46 : {
                    var36_37 = var20_22;
                    var38_44 = var22_23;
                    var46_54 = 0.0;
                    while (var18_20 < var30_29) {
                        v7 = (int)(var46_54 DCMPG var34_32);
                        if (!var50_4) {
                            if (v7 >= 0) break;
                            var48_55 = (x)var29_27.c();
                            var40_47 = var48_55.b() - var36_37;
                            var44_51 = Math.sqrt(var40_47 * var40_47 + (var42_50 = var48_55.c() - var38_44) * var42_50);
                            if ((var46_54 += var44_51) >= var34_32) {
                                var20_22 = var48_55.b() - var40_47 * (var46_54 - var34_32) / var44_51;
                                var22_23 = var48_55.c() - var42_50 * (var46_54 - var34_32) / var44_51;
                                if (!var50_4) break;
                            }
                            var36_37 = var48_55.b();
                            var38_44 = var48_55.c();
                            var29_27 = var29_27.a();
                            ++var18_20;
                            if (!var50_4) continue;
                        }
                        break block46;
                    }
                    v7 = var18_20;
                }
                if (v7 == var30_29 && var46_54 < var34_32) {
                    var40_48 = var25_25 - var36_37;
                    var42_50 = var27_26 - var38_44;
                    var44_51 = Math.sqrt(var40_48 * var40_48 + var42_50 * var42_50);
                    if ((var46_54 += var44_51) < var34_32) return var4_5;
                    var20_22 = var25_25 - var40_48 * (var46_54 - var34_32) / var44_51;
                    var22_23 = var27_26 - var42_50 * (var46_54 - var34_32) / var44_51;
                    if (var50_4) {
                        return var4_5;
                    }
                }
            }
        }
lbl148: // 9 sources:
        if ((var34_32 = var0.getTargetArrow().d()) <= 0.0) ** GOTO lbl195
        if (var18_20 != var30_29) ** GOTO lbl-1000
        var36_38 = var20_22;
        var38_44 = var22_23;
        if (var50_4) lbl-1000: // 2 sources:
        {
            var40_49 = (x)var31_35.c();
            var36_38 = var40_49.b();
            var38_44 = var40_49.c();
        }
        if ((var44_51 = Math.sqrt((double)((var40_45 /* !! */  = (x)(var36_38 - var25_25)) * var40_45 /* !! */  + (var42_50 = var38_44 - var27_26) * var42_50))) <= var34_32) ** GOTO lbl-1000
        var46_54 = var34_32 / var44_51;
        var25_25 += var40_45 /* !! */  * var46_54;
        var27_26 += var42_50 * var46_54;
        if (var50_4) lbl-1000: // 2 sources:
        {
            if (var18_20 >= var30_29) {
                return var4_5;
            }
            if (var18_20 != var30_29) {
                block47 : {
                    var36_38 = var25_25;
                    var38_44 = var27_26;
                    var46_54 = 0.0;
                    while (var18_20 < var30_29) {
                        v8 = (int)(var46_54 DCMPG var34_32);
                        if (!var50_4) {
                            if (v8 >= 0) break;
                            var48_55 = (x)var31_35.c();
                            var40_45 /* !! */  = (x)(var48_55.b() - var36_38);
                            var44_51 = Math.sqrt((double)(var40_45 /* !! */  * var40_45 /* !! */  + (var42_50 = var48_55.c() - var38_44) * var42_50));
                            if ((var46_54 += var44_51) >= var34_32) {
                                var25_25 = var48_55.b() - var40_45 /* !! */  * (var46_54 - var34_32) / var44_51;
                                var27_26 = var48_55.c() - var42_50 * (var46_54 - var34_32) / var44_51;
                                if (!var50_4) break;
                            }
                            var36_38 = var48_55.b();
                            var38_44 = var48_55.c();
                            --var30_29;
                            var31_35 = var31_35.b();
                            if (!var50_4) continue;
                        }
                        break block47;
                    }
                    v8 = var18_20;
                }
                if (v8 == var30_29 && var46_54 < var34_32) {
                    var40_45 /* !! */  = (x)(var20_22 - var36_38);
                    var42_50 = var22_23 - var38_44;
                    var44_51 = Math.sqrt((double)(var40_45 /* !! */  * var40_45 /* !! */  + var42_50 * var42_50));
                    if ((var46_54 += var44_51) < var34_32) return var4_5;
                    var25_25 = var20_22 - (var46_54 - var34_32) * var40_45 /* !! */  / var44_51;
                    var27_26 = var22_23 - (var46_54 - var34_32) * var42_50 / var44_51;
                    if (var50_4) {
                        return var4_5;
                    }
                }
            }
        }
lbl195: // 9 sources:
        if ((var34_32 = var0.getSourceArrow().c() * var32_30) <= 0.0) ** GOTO lbl209
        var36_39 = var20_22;
        var38_44 = var22_23;
        if (var29_27 != null) ** GOTO lbl-1000
        var40_45 /* !! */  = (x)var25_25;
        var42_50 = var27_26;
        if (var50_4) lbl-1000: // 2 sources:
        {
            var44_52 = (x)var29_27.c();
            var40_45 /* !! */  = (x)var44_52.b();
            var42_50 = var44_52.c();
        }
        if ((var48_56 = Math.sqrt((double)((var44_51 = (Object)(var40_45 /* !! */  - var36_39)) * var44_51 + (var46_54 = var42_50 - var38_44) * var46_54))) > var34_32) {
            var20_22 += var44_51 * var34_32 / var48_56;
            var22_23 += var46_54 * var34_32 / var48_56;
            var4_5 = (byte)(var4_5 | 4);
        }
lbl209: // 4 sources:
        if ((var34_32 = var0.getTargetArrow().c() * var32_30) <= 0.0) ** GOTO lbl223
        var36_40 = var25_25;
        var38_44 = var27_26;
        if (var31_35 != null) ** GOTO lbl-1000
        var40_45 /* !! */  = (x)var20_22;
        var42_50 = var22_23;
        if (var50_4) lbl-1000: // 2 sources:
        {
            var44_53 = (x)var31_35.c();
            var40_45 /* !! */  = (x)var44_53.b();
            var42_50 = var44_53.c();
        }
        if ((var48_57 = Math.sqrt((double)((var44_51 = var40_45 /* !! */  - var36_40) * var44_51 + (var46_54 = var42_50 - var38_44) * var46_54))) > var34_32) {
            var25_25 += var44_51 * var34_32 / var48_57;
            var27_26 += var46_54 * var34_32 / var48_57;
            var4_5 = (byte)(var4_5 | 8);
        }
lbl223: // 4 sources:
        var1_1.moveTo((float)var20_22, (float)var22_23);
        if (var31_35 != null && var29_27 != null) {
            v5 = var18_20;
            v6 = var30_29;
lbl227: // 2 sources:
            if (v5 < v6) {
                var31_35 = var31_35.a();
                while (var29_27 != var31_35) {
                    var34_33 = (x)var29_27.c();
                    var1_1.lineTo((float)var34_33.b(), (float)var34_33.c());
                    var29_27 = var29_27.a();
                    if (var50_4 != false) return var4_5;
                    if (!var50_4) continue;
                }
            }
        }
        var1_1.lineTo((float)var25_25, (float)var27_26);
        return var4_5;
    }

    private static boolean a(byte by2, Object object, fj fj2, double d2, double d3, double d4, double d5, Point2D.Double double_) {
        switch (by2) {
            case 1: {
                return ((eU)object).a(d2, d3, d4, d5, double_);
            }
            case 2: {
                return ((fL)object).a(fj2, d2, d3, d4, d5, double_);
            }
            case 3: {
                return ((fj)object).findIntersection(d2, d3, d4, d5, double_);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Invalid type: ").append(by2).toString());
    }

    private static boolean a(boolean bl2, Object object, double d2, double d3) {
        if (!bl2) return ((fj)object).contains(d2, d3);
        return ((eU)object).a(d2, d3);
    }

    private static t a(boolean bl2, Object object, fj fj2) {
        if (bl2) {
            return ((eU)object).h();
        }
        fL fL2 = (fL)object;
        return new t(fL2.a(fj2), fL2.b(fj2));
    }

    /*
     * Unable to fully structure code
     */
    public static byte b(aB var0, GeneralPath var1_1, Point2D var2_2, Point2D var3_3) {
        var40_4 = fj.z;
        var5_5 = var0.getSourceRealizer();
        var6_6 = var0.getBend(0);
        if (var5_5.b(var0.vb) == null && var5_5.b(var0.zb) == null) ** GOTO lbl-1000
        var19_7 = var0.getSourcePort();
        var20_8 = new t(var19_7.a(var5_5), var19_7.b(var5_5));
        if (!e.d((t)var20_8, var22_10 = new t((var21_9 = var0.getTargetPort()).a(var5_5), var21_9.b(var5_5)), var23_12 = new t(var6_6.b(), var6_6.c()))) ** GOTO lbl22
        var7_13 = var20_8.a();
        var9_14 = var20_8.b();
        var11_15 = (var23_12.a() + var7_13) * 0.5;
        var13_16 = (var23_12.b() + var9_14) * 0.5;
        var15_17 = Point2D.distance(var11_15, var13_16, var7_13, var9_14);
        var17_18 = 360.0;
        var24_19 = var22_10.a() - var7_13;
        if (var24_19 * var24_19 + (var26_21 = var22_10.b() - var9_14) * var26_21 > 1.0E-12) {
            var1_1.reset();
            var1_1.moveTo((float)var7_13, (float)var9_14);
            var1_1.lineTo((float)var23_12.a(), (float)var23_12.b());
            var1_1.lineTo((float)var22_10.a(), (float)var22_10.b());
            return ij.a(var0, var1_1, var1_1, var2_2, var3_3);
        }
        ** GOTO lbl53
lbl22: // 1 sources:
        var24_20 = new p((t)var20_8, var22_10, var23_12);
        var25_23 = var24_20.a();
        var11_15 = var25_23.a();
        var13_16 = var25_23.b();
        var15_17 = var24_20.b();
        var7_13 = var20_8.a();
        var9_14 = var20_8.b();
        var26_22 = e.a((t)var20_8, var23_12, var22_10);
        if (var26_22 != 0) ** GOTO lbl33
        var17_18 = 360.0;
        if (!var40_4) ** GOTO lbl53
lbl33: // 2 sources:
        if ((var27_24 = e.a((t)var20_8, var25_23, var22_10)) != 0) ** GOTO lbl36
        var28_25 = 180.0;
        if (!var40_4) ** GOTO lbl45
lbl36: // 2 sources:
        var30_26 = var20_8.a() - var11_15;
        var32_27 = var20_8.b() - var13_16;
        var34_28 = var22_10.a() - var11_15;
        var36_29 = var22_10.b() - var13_16;
        var38_30 = e.b(Math.acos((var30_26 * var34_28 + var32_27 * var36_29) / (Math.sqrt(var30_26 * var30_26 + var32_27 * var32_27) * Math.sqrt(var34_28 * var34_28 + var36_29 * var36_29))));
        if (var27_24 != var26_22) ** GOTO lbl-1000
        var28_25 = 360.0 - var38_30;
        if (var40_4) lbl-1000: // 2 sources:
        {
            var28_25 = var38_30;
        }
lbl45: // 4 sources:
        var17_18 = (double)(- var26_22) * var28_25;
        if (var40_4) lbl-1000: // 2 sources:
        {
            var7_13 = var0.getSourcePort().a(var5_5);
            var9_14 = var0.getSourcePort().b(var5_5);
            var11_15 = (var6_6.b() + var7_13) / 2.0;
            var13_16 = (var6_6.c() + var9_14) / 2.0;
            var15_17 = Point2D.distance(var11_15, var13_16, var7_13, var9_14);
            var17_18 = 360.0;
        }
lbl53: // 5 sources:
        var19_7 = new Arc2D.Float(0);
        var19_7.setFrameFromCenter(var11_15, var13_16, var11_15 - var15_17, var13_16 - var15_17);
        var19_7.setAngleStart(new Point2D.Double(var7_13, var9_14));
        var19_7.setAngleExtent(var17_18);
        var20_8 = var19_7.getPathIterator(null, 0.20000000298023224);
        var21_9 = new GeneralPath(1, 2);
        var21_9.append((PathIterator)var20_8, false);
        v0 = var21_9;
        var21_9 = new GeneralPath(1, var0.bendCount() + 4);
        var22_11 = ij.a(var0, (GeneralPath)v0, (GeneralPath)var21_9, var2_2, var3_3);
        var20_8 = var21_9.getPathIterator(null);
        var1_1.reset();
        var1_1.append((PathIterator)var20_8, false);
        return var22_11;
    }

    public static byte c(aB aB2, GeneralPath generalPath, Point2D point2D, Point2D point2D2) {
        byte by2 = ij.a(aB2, generalPath, point2D, point2D2);
        ij.a(aB2, generalPath);
        return by2;
    }

    public static void a(aB aB2, GeneralPath generalPath) {
        PathIterator pathIterator;
        block5 : {
            boolean bl2 = fj.z;
            int n2 = aB2.bendCount();
            if (n2 <= 0) return;
            pathIterator = generalPath.getPathIterator(null);
            if (pathIterator.isDone()) {
                return;
            }
            GeneralPath generalPath2 = new GeneralPath(1, aB2.bendCount() + 2);
            float[] arrf = new float[2];
            float[] arrf2 = new float[2];
            float[] arrf3 = new float[2];
            float[] arrf4 = new float[2];
            float[] arrf5 = new float[2];
            pathIterator.currentSegment(arrf2);
            pathIterator.next();
            generalPath2.moveTo(arrf2[0], arrf2[1]);
            pathIterator.currentSegment(arrf3);
            pathIterator.next();
            ij.a(arrf2, arrf3, arrf5);
            while (!pathIterator.isDone()) {
                pathIterator.currentSegment(arrf4);
                pathIterator.next();
                if (!bl2) {
                    if (arrf4[0] != arrf3[0] || arrf4[1] != arrf3[1]) {
                        arrf[0] = arrf2[0];
                        arrf[1] = arrf2[1];
                        arrf2[0] = arrf3[0];
                        arrf2[1] = arrf3[1];
                        arrf3[0] = arrf4[0];
                        arrf3[1] = arrf4[1];
                        if (e.a(arrf[0], arrf[1], arrf3[0], arrf3[1], arrf2[0], arrf2[1]) != 0) {
                            generalPath2.lineTo(arrf2[0] - arrf5[0], arrf2[1] - arrf5[1]);
                            ij.a(arrf2, arrf3, arrf5);
                            generalPath2.quadTo(arrf2[0], arrf2[1], arrf2[0] + arrf5[0], arrf2[1] + arrf5[1]);
                            if (!bl2) continue;
                        }
                        ij.a(arrf2, arrf3, arrf5);
                        if (!bl2) continue;
                    }
                    arrf5[0] = 0.0f;
                    arrf5[1] = 0.0f;
                    if (!bl2) continue;
                }
                break block5;
            }
            generalPath2.lineTo(arrf3[0], arrf3[1]);
            generalPath.reset();
            pathIterator = generalPath2.getPathIterator(null, 1.0);
        }
        generalPath.append(pathIterator, false);
    }

    private static void a(float[] arrf, float[] arrf2, float[] arrf3) {
        arrf3[0] = arrf2[0] - arrf[0];
        arrf3[1] = arrf2[1] - arrf[1];
        float f2 = (float)Math.sqrt(arrf3[0] * arrf3[0] + arrf3[1] * arrf3[1]);
        float f3 = f2 < 20.0f ? 0.5f : 10.0f / f2;
        arrf3[0] = f3 * arrf3[0];
        arrf3[1] = f3 * arrf3[1];
    }

    public static GeneralPath a(GeneralPath generalPath) {
        float[] arrf;
        float[] arrf2;
        boolean bl2 = fj.z;
        PathIterator pathIterator = generalPath.getPathIterator(null, 0.1);
        float[] arrf3 = new float[60];
        int n2 = 0;
        float[] arrf4 = new float[2];
        while (!pathIterator.isDone()) {
            pathIterator.currentSegment(arrf4);
            arrf3[n2++] = arrf4[0];
            arrf3[n2++] = arrf4[1];
            if (n2 == arrf3.length) {
                arrf = new float[Math.min(arrf3.length * 2, arrf3.length + 300)];
                System.arraycopy(arrf3, 0, arrf, 0, arrf3.length);
                arrf3 = arrf;
            }
            pathIterator.next();
            if (!bl2) continue;
        }
        arrf = new float[](1, n2 / 2 + 5);
        arrf.moveTo(arrf4[0], arrf4[1]);
        int n3 = n2 - 3;
        while (n3 >= 0) {
            float f2 = arrf3[n3--];
            float f3 = arrf3[n3--];
            arrf2 = arrf;
            if (bl2) return arrf2;
            arrf2.lineTo(f3, f2);
            if (!bl2) continue;
        }
        arrf2 = arrf;
        return arrf2;
    }
}

