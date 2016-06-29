/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y.c.C;
import y.c.D;
import y.c.d;
import y.c.p;
import y.c.q;
import y.c.y;
import y.d.c;
import y.d.t;
import y.f.I;
import y.f.X;
import y.f.aE;
import y.f.ae;
import y.f.am;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.an;
import y.f.c.a.bK;
import y.f.c.a.bP;
import y.f.c.a.bZ;
import y.f.c.a.bk;
import y.f.c.a.bs;
import y.f.c.a.bt;
import y.f.c.a.cT;
import y.f.c.a.cY;
import y.f.c.a.ca;
import y.f.c.a.cr;
import y.f.c.a.cy;
import y.f.c.a.dC;
import y.g.e;

class bY
implements dC {
    private static final double a = Math.sqrt(2.0);
    private bP b;
    private E c;
    private boolean d;
    private boolean e = true;
    private boolean f;
    private double g = 0.2;
    private double h = 150.0;
    private double i = 10.0;
    private double j = 20.0;
    private double k = 10.0;
    private double l = 15.0;
    private double m = 0.0;
    private boolean n = false;
    private double o = 10.0;
    private boolean p = false;
    private double q = 10.0;
    private boolean r;
    private Map s;
    private long t = Long.MAX_VALUE;
    private List u = new ArrayList();
    private List v = new ArrayList();
    private List w = new ArrayList();
    private List x;
    private List y;
    private Map z;
    private bt A;
    private bt B;

    bY(bP bP2, E e2) {
        this.b = bP2;
        this.c = e2;
    }

    public void a(boolean bl2) {
        this.f = bl2;
    }

    public void b(boolean bl2) {
        this.r = bl2;
    }

    void a(Map map) {
        this.s = map;
        Object v2 = map.get("DefaultEdgeRouter.minimumNodeToEdgeDistance");
        if (v2 instanceof Number) {
            this.a(((Number)v2).doubleValue());
        }
        if ((v2 = map.get("DefaultEdgeRouter.enforceExactLayering")) instanceof Boolean) {
            this.b((Boolean)v2);
        }
        if ((v2 = map.get("DefaultEdgeRouter.minimumEdgeDistance")) instanceof Number) {
            this.b(((Number)v2).doubleValue());
        }
        if ((v2 = map.get("DefaultEdgeRouter.polygonalGroupRoutingEnabled")) instanceof Boolean) {
            this.a((Boolean)v2);
        }
        if ((v2 = map.get("DefaultEdgeRouter.polygonalRoutingEnabled")) instanceof Boolean) {
            this.e = (Boolean)v2;
        }
        if ((v2 = map.get("DefaultEdgeRouter.defaultMaxBonusDist")) instanceof Number) {
            this.h = ((Number)v2).doubleValue();
        }
        if ((v2 = map.get("DefaultEdgeRouter.defaultMinPolyDistance")) instanceof Number) {
            this.i = ((Number)v2).doubleValue();
        }
        if ((v2 = map.get("DefaultEdgeRouter.defaultMinLayerDistance")) instanceof Number) {
            this.j = ((Number)v2).doubleValue();
        }
        if ((v2 = map.get("DefaultEdgeRouter.defaultMinPolyDistance")) instanceof Number) {
            this.i = ((Number)v2).doubleValue();
        }
        if ((v2 = map.get("DefaultEdgeRouter.defaultMinimumSlope")) instanceof Number) {
            this.g = ((Number)v2).doubleValue();
        }
        if ((v2 = map.get("DefaultEdgeRouter.defaultMinimumFirstSegmentLength")) instanceof Number) {
            this.k = ((Number)v2).doubleValue();
        }
        if ((v2 = map.get("DefaultEdgeRouter.defaultMinimumLastSegmentLength")) instanceof Number) {
            this.l = ((Number)v2).doubleValue();
        }
        if ((v2 = map.get("DefaultEdgeRouter.fromSketchMode")) instanceof Boolean) {
            this.n = (Boolean)v2;
        }
        if (!((v2 = map.get("DefaultEdgeRouter.assignLaneToProxyNodes")) instanceof Boolean)) return;
        this.p = (Boolean)v2;
    }

    @Override
    public void a(X x2, aU aU2, aV aV2) {
        boolean bl2 = N.x;
        this.z = new HashMap();
        this.b(x2, aU2, aV2);
        for (Map.Entry entry : this.z.entrySet()) {
            d d2 = (d)entry.getKey();
            D d3 = (D)entry.getValue();
            I i2 = x2.b(d2);
            i2.clearPoints();
            for (p p2 = d3.k(); p2 != null; p2 = p2.a()) {
                Point2D.Double double_ = (Point2D.Double)p2.c();
                i2.addPoint(double_.x, double_.y);
                if (bl2) return;
                if (bl2) return;
                if (!bl2) continue;
            }
        }
        this.z = null;
    }

    private static bK a(d d2, q q2, aV aV2) {
        bK bK2 = aV2.a(q2).h();
        aX aX2 = aV2.a(d2.a(q2));
        if (aX2.b() == 2) {
            return bK2;
        }
        bK bK3 = aX2.h();
        if (bK2 == null) return null;
        if (!bK2.equals(bK3)) return null;
        bK bK4 = bK2;
        return bK4;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void a(X var1_1, aU var2_2, aV var3_3, aP var4_4) {
        var37_5 = N.x;
        ae.a(var1_1, false);
        this.u.clear();
        this.v.clear();
        this.w.clear();
        var5_6 = new ArrayList<d>(32);
        var6_7 = new ArrayList<d>(32);
        var7_8 = new ArrayList<d>(32);
        var8_9 = new ArrayList<d>(32);
        var9_10 = new ArrayList<reference>(32);
        var10_11 = new ArrayList<reference>(32);
        var11_12 = new ArrayList<reference>(32);
        var12_13 = new ArrayList<reference>(32);
        var13_14 = new ArrayList<reference>(32);
        var14_15 = new ArrayList<reference>(32);
        var15_16 = new ArrayList<reference>(32);
        var16_17 = new ArrayList<reference>(32);
        var17_18 = new ArrayList<Object>(32);
        var18_19 = new cY(var1_1, var2_2, var3_3);
        var19_20 = new cT(var1_1, var2_2, var3_3);
        var20_21 = new ca(var1_1);
        var21_22 = 0;
        do {
            v0 = var21_22;
            block1 : do lbl-1000: // 3 sources:
            {
                if (v0 >= var2_2.b()) return;
                var22_23 = var2_2.a(var21_22);
                var23_24 = 0;
                var24_25 = var22_23.d();
                var25_26 = null;
                block2 : for (var26_27 = var24_25.k(); var26_27 != null; var26_27 = var26_27.a(), ++var23_24) {
                    v1 = var26_27.c();
                    block3 : do lbl-1000: // 3 sources:
                    {
                        block92 : {
                            var27_28 = (q)v1;
                            var28_29 = var3_3.a(var27_28);
                            v0 = var28_29.b();
                            if (var37_5) ** GOTO lbl-1000
                            if (v0 != 0 && var28_29.b() != 12 && var28_29.b() != 13 && var28_29.b() != 15) continue block2;
                            if (var17_18.size() != 0 && (var29_30 = this.b.a(var1_1, var3_3, var25_26, var27_28, var17_18)) != null) {
                                this.w.add(var4_4.a(var22_23, (Rectangle2D.Double)var29_30, var17_18.toArray(new d[var17_18.size()])));
                                var30_31 = var24_25.l();
                                var24_25.h(var30_31);
                                var24_25.a((p)var30_31, (p)var26_27);
                            }
                            var20_21.a = var27_28;
                            var25_26 = var27_28;
                            var17_18.clear();
                            var9_10.clear();
                            var11_12.clear();
                            var10_11.clear();
                            var12_13.clear();
                            var13_14.clear();
                            var15_16.clear();
                            var14_15.clear();
                            var16_17.clear();
                            for (var29_30 = var28_29.d(); var29_30 != null; var29_30 = var29_30.a()) {
                                var30_31 = (d)var29_30.c();
                                var31_35 = var30_31.a(var27_28);
                                var32_36 = var3_3.a(var30_31);
                                var33_37 = var1_1.b(var30_31);
                                var35_39 = var3_3.a((q)var31_35).k() - var28_29.k();
                                v2 = var30_31.c();
                                if (!var37_5) {
                                    block91 : {
                                        v3 = var36_40 = v2 == var27_28;
                                        if (var36_40) {
                                            var34_38 = var32_36.c();
                                            if (!var37_5) break block91;
                                        }
                                        var34_38 = var32_36.e();
                                    }
                                    if (var3_3.a(var30_31).a() == 4) {
                                        if (var35_39 <= 0) continue;
                                        var17_18.add(var30_31);
                                        if (!var37_5) continue;
                                    }
                                    var33_37.clearPoints();
                                    if (var34_38 == null || var34_38.c() || var34_38.d() || var34_38.g()) continue;
                                    if (var34_38.e()) {
                                        if (var35_39 < 0) {
                                            if (var32_36.j()) {
                                                var10_11.add(var30_31);
                                                if (!var37_5) continue;
                                            }
                                            var14_15.add(var30_31);
                                            if (!var37_5) continue;
                                        }
                                        if (var32_36.j()) {
                                            var12_13.add(var30_31);
                                            if (!var37_5) continue;
                                        }
                                        var16_17.add(var30_31);
                                        if (!var37_5) continue;
                                    }
                                    if (var35_39 > 0) {
                                        if (var32_36.j()) {
                                            var9_10.add(var30_31);
                                            if (!var37_5) continue;
                                        }
                                        var13_14.add(var30_31);
                                        if (!var37_5) continue;
                                    }
                                    if (var32_36.j()) {
                                        var11_12.add(var30_31);
                                        if (!var37_5) continue;
                                    }
                                    var15_16.add(var30_31);
                                    if (!var37_5) continue;
                                }
                                break block92;
                            }
                            var5_6.clear();
                            var6_7.clear();
                            var29_30 = var26_27;
                            v2 = var27_28;
                        }
                        for (var30_32 = (v1283594).g(); var30_32 != null; var30_32 = var30_32.h()) {
                            var31_35 = var3_3.a(var30_32);
                            v1 = var31_35.e();
                            if (var37_5) ** GOTO lbl-1000
                            if (v1 == null || var31_35.e().c()) continue;
                            if (var31_35.e().f()) {
                                var5_6.add(var30_32);
                                if (!var37_5) continue;
                            }
                            if (!var31_35.e().e()) continue;
                            var6_7.add(var30_32);
                            if (!var37_5) continue;
                        }
                        var7_8.clear();
                        var8_9.clear();
                        for (var30_33 = var27_28.f(); var30_33 != null; var30_33 = var30_33.g()) {
                            var31_35 = var3_3.a(var30_33);
                            v1 = var31_35.c();
                            if (var37_5) continue block3;
                            if (v1 == null || var31_35.c().d()) continue;
                            if (var31_35.c().f()) {
                                var7_8.add(var30_33);
                                if (!var37_5) continue;
                            }
                            if (!var31_35.c().e()) continue;
                            var8_9.add(var30_33);
                            if (!var37_5) continue;
                        }
                        break;
                    } while (true);
                    if (var15_16.size() > 0) {
                        e.a(var15_16, (Comparator)var20_21);
                        for (var30_34 = var15_16.size() - 1; var30_34 >= 0; --var30_34) {
                            var31_35 = (d)var15_16.get(var30_34);
                            v4 = this.p;
                            if (!var37_5) {
                                block93 : {
                                    if (v4 != 0) {
                                        this.v.add(var4_4.a(var22_23, var27_28, (d)var31_35, bY.a((d)var31_35, var27_28, var3_3)));
                                        if (!var37_5) break block93;
                                    }
                                    this.v.add(var4_4.a(var22_23, var27_28, (d)var31_35));
                                }
                                var32_36 = var24_25.l();
                                var24_25.h((p)var32_36);
                                var24_25.a((p)var32_36, (p)var26_27);
                                if (!var37_5) continue;
                            }
                            break;
                        }
                    } else {
                        v4 = var7_8.size();
                    }
                    if (v4 > 0) {
                        e.a(var7_8, (Comparator)var19_20);
                        for (var30_31 = (reference)false ? 1 : 0; var30_31 < var7_8.size(); ++var30_31) {
                            var31_35 = (d)var7_8.get((int)var30_31);
                            v5 = this.p;
                            if (!var37_5) {
                                block94 : {
                                    if (v5 != 0) {
                                        this.u.add(var4_4.a((d)var31_35, true, bY.a((d)var31_35, var27_28, var3_3)));
                                        if (!var37_5) break block94;
                                    }
                                    this.u.add(var4_4.a((d)var31_35, true));
                                }
                                var32_36 = var24_25.l();
                                var24_25.h((p)var32_36);
                                var24_25.a((p)var32_36, (p)var26_27);
                                if (!var37_5) continue;
                            }
                            break;
                        }
                    } else {
                        v5 = var13_14.size();
                    }
                    if (v5 > 0) {
                        e.a(var13_14, (Comparator)var20_21);
                        for (var30_31 = (reference)(var13_14.size() - 1); var30_31 >= 0; --var30_31) {
                            var31_35 = (d)var13_14.get((int)var30_31);
                            v6 = this.p;
                            if (!var37_5) {
                                block95 : {
                                    if (v6 != 0) {
                                        this.v.add(var4_4.a(var22_23, var27_28, (d)var31_35, bY.a((d)var31_35, var27_28, var3_3)));
                                        if (!var37_5) break block95;
                                    }
                                    this.v.add(var4_4.a(var22_23, var27_28, (d)var31_35));
                                }
                                var32_36 = var24_25.l();
                                var24_25.h((p)var32_36);
                                var24_25.a((p)var32_36, (p)var26_27);
                                if (!var37_5) continue;
                            }
                            break;
                        }
                    } else {
                        v6 = var11_12.size();
                    }
                    if (v6 > 0) {
                        e.a(var11_12, (Comparator)var20_21);
                        for (var30_31 = (reference)false ? 1 : 0; var30_31 < var11_12.size(); ++var30_31) {
                            var31_35 = (d)var11_12.get((int)var30_31);
                            v7 = this.p;
                            if (!var37_5) {
                                block96 : {
                                    if (v7 != 0) {
                                        this.v.add(var4_4.a(var22_23, var27_28, (d)var31_35, bY.a((d)var31_35, var27_28, var3_3)));
                                        if (!var37_5) break block96;
                                    }
                                    this.v.add(var4_4.a(var22_23, var27_28, (d)var31_35));
                                }
                                var32_36 = var24_25.l();
                                var24_25.h((p)var32_36);
                                var24_25.a((p)var32_36, (p)var26_27);
                                if (!var37_5) continue;
                            }
                            break;
                        }
                    } else {
                        v7 = var5_6.size();
                    }
                    if (v7 > 0) {
                        e.a(var5_6, (Comparator)var18_19);
                        for (var30_31 = (reference)false ? 1 : 0; var30_31 < var5_6.size(); ++var30_31) {
                            var31_35 = (d)var5_6.get((int)var30_31);
                            v8 = this.p;
                            if (!var37_5) {
                                block97 : {
                                    if (v8 != 0) {
                                        this.u.add(var4_4.a((d)var31_35, false, bY.a((d)var31_35, var27_28, var3_3)));
                                        if (!var37_5) break block97;
                                    }
                                    this.u.add(var4_4.a((d)var31_35, false));
                                }
                                var32_36 = var24_25.l();
                                var24_25.h((p)var32_36);
                                var24_25.a((p)var32_36, (p)var26_27);
                                if (!var37_5) continue;
                            }
                            break;
                        }
                    } else {
                        v8 = var9_10.size();
                    }
                    if (v8 > 0) {
                        e.a(var9_10, (Comparator)var20_21);
                        for (var30_31 = (reference)false ? 1 : 0; var30_31 < var9_10.size(); ++var30_31) {
                            var31_35 = (d)var9_10.get((int)var30_31);
                            v9 = this.p;
                            if (!var37_5) {
                                block98 : {
                                    if (v9 != 0) {
                                        this.v.add(var4_4.a(var22_23, var27_28, (d)var31_35, bY.a((d)var31_35, var27_28, var3_3)));
                                        if (!var37_5) break block98;
                                    }
                                    this.v.add(var4_4.a(var22_23, var27_28, (d)var31_35));
                                }
                                var32_36 = var24_25.l();
                                var24_25.h((p)var32_36);
                                var24_25.a((p)var32_36, (p)var26_27);
                                if (!var37_5) continue;
                            }
                            break;
                        }
                    } else {
                        v9 = var10_11.size();
                    }
                    if (v9 > 0) {
                        e.a(var10_11, (Comparator)var20_21);
                        for (var30_31 = (reference)(var10_11.size() - 1); var30_31 >= 0; --var30_31) {
                            var31_35 = (d)var10_11.get((int)var30_31);
                            v10 = this.p;
                            if (!var37_5) {
                                block99 : {
                                    if (v10 != 0) {
                                        this.v.add(var4_4.a(var22_23, var27_28, (d)var31_35, bY.a((d)var31_35, var27_28, var3_3)));
                                        if (!var37_5) break block99;
                                    }
                                    this.v.add(var4_4.a(var22_23, var27_28, (d)var31_35));
                                }
                                var32_36 = var24_25.l();
                                var24_25.h((p)var32_36);
                                var24_25.b((p)var32_36, (p)var29_30);
                                var29_30 = var32_36;
                                if (!var37_5) continue;
                            }
                            break;
                        }
                    } else {
                        v10 = var6_7.size();
                    }
                    if (v10 > 0) {
                        e.a(var6_7, (Comparator)var18_19);
                        for (var30_31 = (reference)false ? 1 : 0; var30_31 < var6_7.size(); ++var30_31) {
                            var31_35 = (d)var6_7.get((int)var30_31);
                            v11 = this.p;
                            if (!var37_5) {
                                block100 : {
                                    if (v11 != 0) {
                                        this.u.add(var4_4.a((d)var31_35, false, bY.a((d)var31_35, var27_28, var3_3)));
                                        if (!var37_5) break block100;
                                    }
                                    this.u.add(var4_4.a((d)var31_35, false));
                                }
                                var32_36 = var24_25.l();
                                var24_25.h((p)var32_36);
                                var24_25.b((p)var32_36, (p)var29_30);
                                var29_30 = var32_36;
                                if (!var37_5) continue;
                            }
                            break;
                        }
                    } else {
                        v11 = var12_13.size();
                    }
                    if (v11 > 0) {
                        e.a(var12_13, (Comparator)var20_21);
                        for (var30_31 = (reference)(var12_13.size() - 1); var30_31 >= 0; --var30_31) {
                            var31_35 = (d)var12_13.get((int)var30_31);
                            v12 = this.p;
                            if (!var37_5) {
                                block101 : {
                                    if (v12 != 0) {
                                        this.v.add(var4_4.a(var22_23, var27_28, (d)var31_35, bY.a((d)var31_35, var27_28, var3_3)));
                                        if (!var37_5) break block101;
                                    }
                                    this.v.add(var4_4.a(var22_23, var27_28, (d)var31_35));
                                }
                                var32_36 = var24_25.l();
                                var24_25.h((p)var32_36);
                                var24_25.b((p)var32_36, (p)var29_30);
                                var29_30 = var32_36;
                                if (!var37_5) continue;
                            }
                            break;
                        }
                    } else {
                        v12 = var14_15.size();
                    }
                    if (v12 > 0) {
                        e.a(var14_15, (Comparator)var20_21);
                        for (var30_31 = (reference)false ? 1 : 0; var30_31 < var14_15.size(); ++var30_31) {
                            var31_35 = (d)var14_15.get((int)var30_31);
                            v13 = this.p;
                            if (!var37_5) {
                                block102 : {
                                    if (v13 != 0) {
                                        this.v.add(var4_4.a(var22_23, var27_28, (d)var31_35, bY.a((d)var31_35, var27_28, var3_3)));
                                        if (!var37_5) break block102;
                                    }
                                    this.v.add(var4_4.a(var22_23, var27_28, (d)var31_35));
                                }
                                var32_36 = var24_25.l();
                                var24_25.h((p)var32_36);
                                var24_25.b((p)var32_36, (p)var29_30);
                                var29_30 = var32_36;
                                if (!var37_5) continue;
                            }
                            break;
                        }
                    } else {
                        v13 = var8_9.size();
                    }
                    if (v13 > 0) {
                        e.a(var8_9, (Comparator)var19_20);
                        for (var30_31 = (reference)false ? 1 : 0; var30_31 < var8_9.size(); ++var30_31) {
                            var31_35 = (d)var8_9.get((int)var30_31);
                            v14 = this.p;
                            if (!var37_5) {
                                block103 : {
                                    if (v14 != 0) {
                                        this.u.add(var4_4.a((d)var31_35, true, bY.a((d)var31_35, var27_28, var3_3)));
                                        if (!var37_5) break block103;
                                    }
                                    this.u.add(var4_4.a((d)var31_35, true));
                                }
                                var32_36 = var24_25.l();
                                var24_25.h((p)var32_36);
                                var24_25.b((p)var32_36, (p)var29_30);
                                var29_30 = var32_36;
                                if (!var37_5) continue;
                            }
                            break;
                        }
                    } else {
                        v14 = var16_17.size();
                    }
                    if (v14 > 0) {
                        e.a(var16_17, (Comparator)var20_21);
                        for (var30_31 = (reference)false ? 1 : 0; var30_31 < var16_17.size(); ++var30_31) {
                            block104 : {
                                var31_35 = (d)var16_17.get((int)var30_31);
                                v0 = this.p;
                                if (var37_5) continue block1;
                                if (v0 != 0) {
                                    this.v.add(var4_4.a(var22_23, var27_28, (d)var31_35, bY.a((d)var31_35, var27_28, var3_3)));
                                    if (!var37_5) break block104;
                                }
                                this.v.add(var4_4.a(var22_23, var27_28, (d)var31_35));
                            }
                            var32_36 = var24_25.l();
                            var24_25.h((p)var32_36);
                            var24_25.b((p)var32_36, (p)var29_30);
                            var29_30 = var32_36;
                            if (!var37_5) continue;
                        }
                    }
                    var26_27 = var29_30;
                    if (!var37_5) continue;
                }
                break;
            } while (true);
            ++var21_22;
        } while (!var37_5);
    }

    @Override
    public void b(X x2, aU aU2, aV aV2, aP aP2) {
        boolean bl2 = N.x;
        for (int i2 = 0; i2 < this.u.size(); ++i2) {
            q q2 = (q)this.u.get(i2);
            aP2.b(q2);
            if (bl2) return;
            if (!bl2) continue;
        }
        this.u.clear();
    }

    /*
     * Exception decompiling
     */
    @Override
    public void c(X var1_1, aU var2_2, aV var3_3, aP var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:420)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:219)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:619)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:45)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:681)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public void d(X x2, aU aU2, aV aV2, aP aP2) {
        boolean bl2 = N.x;
        for (int i2 = 0; i2 < this.w.size(); ++i2) {
            q q2 = (q)this.w.get(i2);
            aP2.e(q2);
            if (bl2) return;
            if (!bl2) continue;
        }
        this.w.clear();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void e(X var1_1, aU var2_2, aV var3_3, aP var4_4) {
        var14_5 = N.x;
        this.x = new ArrayList<E>(62);
        this.y = new ArrayList<E>(62);
        var5_6 = 0;
        do {
            v0 = var5_6;
            block1 : do {
                v1 = var2_2.b();
                block2 : do lbl-1000: // 3 sources:
                {
                    if (v0 >= v1) return;
                    var6_7 = var2_2.a(var5_6);
                    for (var7_8 = var6_7.d().k(); var7_8 != null; var7_8 = var7_8.a()) {
                        var8_9 = (q)var7_8.c();
                        var9_10 = var3_3.a(var8_9).b();
                        v0 = var9_10;
                        if (var14_5) continue block1;
                        if (v0 != 0 && var9_10 != 15) continue;
                        var10_11 = var8_9.i();
                        while (var10_11 != null) {
                            block9 : {
                                var11_12 = var10_11.j();
                                var12_13 = var3_3.a(var10_11);
                                var13_14 = var3_3.a(var10_11.c());
                                v0 = var13_14.j();
                                v1 = var5_6;
                                if (var14_5) ** GOTO lbl-1000
                                if (v0 == v1) {
                                    this.a(var1_1, var6_7, var12_13, var4_4, var8_9, var10_11);
                                    if (!var14_5) break block9;
                                }
                                this.b(var1_1, var6_7, var12_13, var4_4, var8_9, var10_11);
                            }
                            var10_11 = var11_12;
                            if (!var14_5) continue;
                        }
                        var10_11 = var8_9.h();
                        while (var10_11 != null) {
                            var11_12 = var10_11.i();
                            var12_13 = var3_3.a(var10_11);
                            var13_14 = var3_3.a(var10_11.d());
                            v0 = var13_14.j();
                            v1 = var5_6;
                            if (var14_5) continue block2;
                            if (v0 != v1) {
                                this.b(var1_1, var6_7, var12_13, var4_4, var8_9, var10_11);
                            }
                            var10_11 = var11_12;
                            if (!var14_5) continue;
                        }
                        if (!var14_5) continue;
                    }
                    break;
                } while (true);
                break;
            } while (true);
            ++var5_6;
        } while (!var14_5);
    }

    public void a(X x2, aQ aQ2, A a2, aP aP2, q q2, d d2) {
        aE aE2 = a2.c();
        aE aE3 = a2.e();
        if (aE2 == null) return;
        if (aE3 == null) return;
        if (!aE2.d() || !aE3.c()) {
            if (!aE2.c()) return;
            if (!aE3.d()) return;
        }
        this.y.add(aP2.b(aQ2, d2));
    }

    public void b(X x2, aQ aQ2, A a2, aP aP2, q q2, d d2) {
        d d3;
        if (q2 == d2.d()) {
            if (a2.e() == null) return;
            if (!a2.e().d()) return;
            d3 = aP2.a(aQ2, d2, q2);
            this.x.add(d3);
            if (!N.x) return;
        }
        if (a2.c() == null) return;
        if (!a2.c().c()) return;
        d3 = aP2.a(aQ2, d2, q2);
        this.x.add(d3);
    }

    @Override
    public void f(X x2, aU aU2, aV aV2, aP aP2) {
        boolean bl2;
        int n2;
        block3 : {
            bl2 = N.x;
            for (n2 = 0; n2 < this.x.size(); ++n2) {
                d d2 = (d)this.x.get(n2);
                aP2.c(d2);
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block3;
            }
            n2 = 0;
        }
        while (n2 < this.y.size()) {
            q q2 = (q)this.y.get(n2);
            aP2.d(q2);
            ++n2;
            if (bl2) return;
            if (!bl2) continue;
        }
        this.y.clear();
        this.y = null;
        this.x.clear();
        this.x = null;
    }

    private boolean a(aQ aQ2, aQ aQ3) {
        bt bt2 = aQ2.b();
        bt bt3 = aQ3.b();
        if (bt2 != null && bt3 != null) {
            if (bt2 == bt3) return false;
            return true;
        }
        if (bt2 == null && bt3 == null) {
            return false;
        }
        if (bt2 == null) {
            if (bt3 != this.B) return true;
        }
        if (bt3 != null) return false;
        if (bt2 == this.B) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private D a(bt var1_1, bt var2_2, X var3_3) {
        var9_4 = N.x;
        var4_5 = bk.c(var3_3);
        var5_6 = new D();
        if (var4_5 == null || var1_1 == null && var2_2 == null) ** GOTO lbl26
        if (var1_1 != null) ** GOTO lbl12
        var6_7 = var2_2.a();
        for (var7_8 = 0; var7_8 < var6_7; ++var7_8) {
            v0 = var5_6;
            if (var9_4 != false) return v0;
            v0.b(var4_5.a(var7_8));
            if (!var9_4) continue;
lbl12: // 2 sources:
            if (var2_2 != null) ** GOTO lbl19
            var6_7 = var1_1.a();
            for (var7_8 = var6_7 + 1; var7_8 < var4_5.e().size(); ++var7_8) {
                v0 = var5_6;
                if (var9_4 != false) return v0;
                v0.b(var4_5.a(var7_8));
                if (!var9_4) continue;
lbl19: // 2 sources:
                var6_7 = Math.min(var1_1.a(), var2_2.a());
                var7_8 = Math.max(var1_1.a(), var2_2.a());
                for (var8_9 = var6_7 + 1; var8_9 < var7_8; ++var8_9) {
                    v0 = var5_6;
                    if (var9_4 != false) return v0;
                    v0.b(var4_5.a(var8_9));
                    if (!var9_4) continue;
                }
            }
        }
lbl26: // 5 sources:
        v0 = var5_6;
        return v0;
    }

    private void a(bt bt2, X x2) {
        boolean bl2 = N.x;
        D d2 = this.a(null, bt2, x2);
        if (d2.isEmpty()) return;
        d2.n();
        double d3 = bt2.h();
        C c2 = d2.m();
        do {
            if (!c2.f()) return;
            bt bt3 = (bt)c2.d();
            bt3.g(d3 -= bt3.b());
            bt3.d(bt3.b());
            c2.g();
        } while (!bl2);
    }

    private void b(bt bt2, X x2) {
        boolean bl2 = N.x;
        D d2 = this.a(bt2, null, x2);
        if (d2.isEmpty()) return;
        double d3 = bt2.h() + bt2.e();
        C c2 = d2.m();
        do {
            if (!c2.f()) return;
            bt bt3 = (bt)c2.d();
            bt3.g(d3);
            bt3.d(bt3.b());
            d3 += bt3.e();
            c2.g();
        } while (!bl2);
    }

    private double b(bt bt2, bt bt3, X x2) {
        double d2;
        boolean bl2 = N.x;
        double d3 = bt2.h() + bt2.e();
        D d4 = this.a(bt2, bt3, x2);
        C c2 = d4.m();
        while (c2.f()) {
            bt bt4 = (bt)c2.d();
            bt4.g(d3);
            bt4.d(bt4.b());
            d2 = d3 + bt4.e();
            if (bl2) return d2;
            d3 = d2;
            c2.g();
            if (!bl2) continue;
        }
        d2 = d3;
        return d2;
    }

    private double c(bt bt2, bt bt3, X x2) {
        double d2;
        boolean bl2 = N.x;
        double d3 = 0.0;
        D d4 = this.a(bt2, bt3, x2);
        if (!d4.isEmpty()) {
            C c2 = d4.m();
            while (c2.f()) {
                bt bt4 = (bt)c2.d();
                d2 = d3 + bt4.b();
                if (bl2) return d2;
                d3 = d2;
                c2.g();
                if (!bl2) continue;
            }
        }
        d2 = d3;
        return d2;
    }

    private boolean a(X x2, aV aV2) {
        boolean bl2 = N.x;
        if (aV2 == null) {
            return false;
        }
        y.c.e e2 = x2.p();
        do {
            if (!e2.f()) return true;
            A a2 = aV2.a(e2.a());
            if (a2 == null) return false;
            if (a2.k() == null) return false;
            if (a2.k().h().b() != 2) {
                return false;
            }
            e2.g();
        } while (!bl2);
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private void b(X var1_1, aU var2_2, aV var3_3) {
        block119 : {
            var57_4 = N.x;
            var5_5 = new ArrayList<Object>(120);
            var6_6 = 0.0;
            var8_7 = new cr();
            var9_8 = System.currentTimeMillis();
            var11_9 = this.t == Long.MAX_VALUE ? Long.MAX_VALUE : this.t / (long)var2_2.b();
            var8_7.a(var11_9);
            if (this.t >= 10) ** GOTO lbl-1000
            var8_7.a(0);
            var8_7.b(0);
            var8_7.c(0);
            if (var57_4) lbl-1000: // 2 sources:
            {
                var8_7.a(Integer.MAX_VALUE);
                var8_7.b(Integer.MAX_VALUE);
                var8_7.c(Integer.MAX_VALUE);
            }
            if (this.s != null) {
                var13_10 = this.s.get("ChannelRouter.maximalConstraintSimplexDuration");
                if (var13_10 instanceof Number) {
                    var8_7.a(((Number)var13_10).longValue());
                }
                if ((var13_11 = this.s.get("ChannelRouter.segmentMisgraphEdgeLimit")) instanceof Number) {
                    var8_7.a(((Number)var13_11).intValue());
                }
                if ((var13_12 = this.s.get("ChannelRouter.maxConstraintsCount")) instanceof Number) {
                    var8_7.c(((Number)var13_12).intValue());
                }
                if ((var13_13 = this.s.get("ChannelRouter.segmentMisGraphLimit")) instanceof Number) {
                    var8_7.b(((Number)var13_13).intValue());
                }
            }
            var13_14 = new HashMap<d, q>();
            for (q var15_16 : this.w) {
                var16_18 = (an)var3_3.a(var15_16);
                for (var17_20 = 0; var17_20 < var16_18.a.length; ++var17_20) {
                    var18_23 = var16_18.a[var17_20];
                    var13_14.put((d)var18_23, var15_16);
                    if (!var57_4 && !var57_4) {
                        if (!var57_4) continue;
                    }
                    break block119;
                }
            }
            var8_7.c(0.0);
        }
        var14_15 = new c(-1.7976931348623157E308, Double.MAX_VALUE, -1.7976931348623157E308);
        var15_17 = this.a(var1_1, var3_3);
        var16_19 = 0;
        do {
            block123 : {
                block122 : {
                    block121 : {
                        block120 : {
                            if (var16_19 >= var2_2.b()) return;
                            var17_22 = var2_2.a(var16_19);
                            var18_23 = var17_22.d();
                            var19_24 = new c(-1.7976931348623157E308, Double.MAX_VALUE, Double.MAX_VALUE);
                            var20_25 = -1.7976931348623157E308;
                            for (var22_27 = var18_23.l(); var22_27 != null; var22_27 = var22_27.b()) {
                                var23_29 = (q)var22_27.c();
                                var24_30 = var1_1.a(var23_29);
                                var24_30.setLocation(var24_30.getX(), var24_30.getY() + var6_6);
                                v0 = var16_19;
                                if (!var57_4) {
                                    if (v0 == 0) {
                                        this.a(var1_1, var3_3, var19_24, var23_29, (am)var24_30, 0.0, true);
                                    }
                                    this.a(var1_1, var3_3, var14_15, var23_29, (am)var24_30, 0.0, false);
                                    var20_25 = Math.max(var20_25, var24_30.getY() + var24_30.getHeight());
                                    if (!var57_4) continue;
                                }
                                break block120;
                            }
                            var8_7.b(var14_15);
                            v0 = var16_19;
                        }
                        if (v0 == 0) {
                            var8_7.a(var19_24);
                            this.b.a(var1_1, var8_7, var17_22, var3_3, true, var6_6);
                            this.c.a(var8_7, var17_22, true, var6_6);
                            this.A = var17_22.b();
                            if (this.A != null) {
                                var8_7.a(this.A, 0.0, 0.0, this.A.c(), -1.7976931348623157E308, false, Double.MAX_VALUE, false);
                            }
                            var8_7.j();
                            this.b.b(var1_1, var8_7, var17_22, var3_3, true, 0.0);
                            this.b.a(var1_1, var14_15, var17_22, var3_3, 0.0, var13_14);
                            this.c.b(var8_7, var17_22, true, 0.0);
                            if (this.A != null) {
                                var22_28 = var8_7.d(this.A);
                                this.A.g(var22_28);
                                this.a(this.A, var1_1);
                                this.B = this.A;
                            }
                        }
                        var8_7.a();
                        if (System.currentTimeMillis() - var9_8 > this.t) {
                            var8_7.a(100);
                            var8_7.b(20);
                            var8_7.c(500);
                        }
                        this.b.a(var1_1, var8_7, var17_22, var3_3, false, var6_6);
                        this.c.a(var8_7, var17_22, false, var6_6);
                        var22_26 = var14_15.d();
                        var8_7.b(var22_26);
                        var5_5.clear();
                        if (var16_19 >= var2_2.b() - 1) ** GOTO lbl-1000
                        var24_30 = var2_2.a(var16_19 + 1);
                        var25_32 = 0.0;
                        if (var16_19 < var2_2.b() - 2) {
                            var27_33 = var2_2.a(var16_19 + 2);
                            if (!var57_4) break block121;
                        }
                        var27_33 = null;
                    }
                    if (!this.f && !var15_17) ** GOTO lbl100
                    var29_35 = false;
                    var28_34 = false;
                    if (!var57_4) ** GOTO lbl116
lbl100: // 2 sources:
                    if ((var30_37 = var24_30.e()) != 2) ** GOTO lbl104
                    var28_34 = true;
                    v1 = var29_35 = var27_33 != null && var27_33.e() == 3;
                    if (!var57_4) ** GOTO lbl110
lbl104: // 2 sources:
                    if (var30_37 != 3) ** GOTO lbl108
                    var28_34 = false;
                    var29_35 = true;
                    if (!var57_4) ** GOTO lbl-1000
lbl108: // 2 sources:
                    var28_34 = false;
                    var29_35 = false;
lbl110: // 2 sources:
                    if (!var28_34 || !var29_35) ** GOTO lbl-1000
                    var16_19 += 2;
                    if (var57_4) lbl-1000: // 2 sources:
                    {
                        ** if (!var28_34 && !var29_35) goto lbl116
                    }
                    ** GOTO lbl116
lbl-1000: // 2 sources:
                    {
                        ++var16_19;
                    }
lbl116: // 4 sources:
                    var30_36 = var2_2.a(var16_19 + 1);
                    this.A = null;
                    if (this.a(var17_22, var30_36)) {
                        this.A = var30_36.b();
                        var31_38 = this.c(this.B, this.A, var1_1);
                        var33_39 = var8_7.a(this.A, var31_38, this.B.d(), this.A.c(), -1.7976931348623157E308, false, Double.MAX_VALUE, true);
                        var33_39.i = var33_39.k = this.B.h() + this.B.b() + var31_38 * 0.5;
                    }
                    var31_38 = Double.MAX_VALUE;
                    var33_39 = new c(-1.7976931348623157E308, Double.MAX_VALUE, Double.MAX_VALUE);
                    for (var34_41 = var30_36.d().l(); var34_41 != null; var34_41 = var34_41.b()) {
                        var35_42 = (q)var34_41.c();
                        var36_43 = var1_1.a(var34_41.c());
                        var31_38 = Math.min(var31_38, var36_43.getY() + var6_6);
                        this.a(var1_1, var3_3, (c)var33_39, var35_42, (am)var36_43, var6_6, true);
                        if (!var57_4) {
                            if (!var57_4) continue;
                        }
                        break block122;
                    }
                    var8_7.a((c)var33_39);
                }
                var34_40 = - var14_15.c((c)var33_39) + this.b();
                this.b.a(var1_1, var8_7, var30_36, var3_3, true, var6_6);
                this.c.a(var8_7, var30_36, true, var6_6);
                if (var28_34 || var29_35) ** GOTO lbl205
                for (var36_43 = var18_23.k(); var36_43 != null; var36_43 = var36_43.a()) {
                    var37_44 = (q)var36_43.c();
                    v2 = var37_44.f();
                    if (var57_4) ** GOTO lbl664
                    if (v2 == null || (var38_45 = var3_3.a(var37_44).b()) == 12 || var38_45 == 13) continue;
                    var39_54 = var37_44.f();
                    while (var39_55 != null) {
                        var40_76 = var1_1.p((d)var39_55);
                        var41_77 = var1_1.q((d)var39_55);
                        v3 = var40_76.a DCMPL var41_77.a;
                        if (var57_4) break block123;
                        if (!v3) ** GOTO lbl163
                        if (!this.d(var3_3, (d)var39_55)) ** GOTO lbl-1000
                        var5_5.add(var39_55);
                        if (var57_4) lbl-1000: // 2 sources:
                        {
                            var42_89 = this.a(var1_1, var3_3, (d)var39_55);
                            var44_113 = var3_3.a((d)var39_55).k();
                            var45_118 = var8_7.a(var39_55, this.m, var42_89, var40_76.a, true, var41_77.a, false, this.b(var3_3, (d)var39_55), var44_113.i());
                            if (bY.a(var3_3.a(var39_55.c()))) {
                                var45_118.k = var40_76.b + this.a(var3_3, (d)var39_55, true);
                                var45_118.i = var40_76.b;
                            }
                            if (bY.a(var3_3.a(var39_55.d()))) {
                                var45_118.l = var41_77.b + var6_6 - this.a(var3_3, (d)var39_55, false);
                                var45_118.j = var41_77.b + var6_6;
                            }
                        }
lbl163: // 6 sources:
                        if (bY.a(var3_3.a(var39_55.c())) && bY.a(var3_3.a(var39_55.d()))) {
                            var34_40 = this.a(var1_1, var3_3, (d)var39_55, var40_76.a, var40_76.b, var41_77.a, var41_77.b + var6_6, var6_6, var34_40);
                        }
                        var39_56 = var39_55.g();
                        if (!var57_4) continue;
                    }
                    if (!var57_4) continue;
                }
                var25_32 += this.a(var1_1, var3_3, var17_22, var20_25, var30_36, var31_38, var8_7, var5_5, var6_6, var34_40);
                for (var36_43 = var18_23.k(); var36_43 != null; var36_43 = var36_43.a()) {
                    var37_44 = (q)var36_43.c();
                    v2 = var37_44.f();
                    if (var57_4) ** GOTO lbl664
                    if (v2 == null || (var38_45 = var3_3.a(var37_44).b()) == 12 || var38_45 == 13) continue;
                    var39_57 = var37_44.f();
                    while (var39_58 != null) {
                        var40_76 = var1_1.p((d)var39_58);
                        var41_77 = var1_1.q((d)var39_58);
                        v3 = var40_76.a DCMPL var41_77.a;
                        if (var57_4) break block123;
                        if (!v3 || this.d(var3_3, (d)var39_58)) ** GOTO lbl202
                        var42_90 = this.a((d)var39_58);
                        if (!this.b(var3_3, (d)var39_58)) ** GOTO lbl-1000
                        var43_101 = var8_7.a(var39_58);
                        if (Double.isNaN(var43_101.d)) ** GOTO lbl202
                        if (var43_101.a() != 1) ** GOTO lbl-1000
                        var42_90.add(new Point2D.Double(var40_76.a, var43_101.d - (var40_76.a - var43_101.q)));
                        if (var43_101.p != var43_101.q) {
                            var42_90.add(new Point2D.Double(var43_101.q, var43_101.d));
                            var42_90.add(new Point2D.Double(var43_101.p, var43_101.d));
                        }
                        var42_90.add(new Point2D.Double(var41_77.a, var43_101.d + (var43_101.p - var41_77.a)));
                        if (var57_4) lbl-1000: // 2 sources:
                        {
                            var42_90.add(new Point2D.Double(var40_76.a, var43_101.d - (var43_101.p - var40_76.a)));
                            if (var43_101.p != var43_101.q) {
                                var42_90.add(new Point2D.Double(var43_101.p, var43_101.d));
                                var42_90.add(new Point2D.Double(var43_101.q, var43_101.d));
                            }
                            var42_90.add(new Point2D.Double(var41_77.a, var43_101.d + (var41_77.a - var43_101.q)));
                            ** if (!var57_4) goto lbl202
                        }
                        ** GOTO lbl202
lbl-1000: // 2 sources:
                        {
                            if (!Double.isNaN(var43_102 = var8_7.d(var39_58))) {
                                var42_90.add(new Point2D.Double(var40_76.a, var43_102));
                                var42_90.add(new Point2D.Double(var41_77.a, var43_102));
                            }
                        }
lbl202: // 7 sources:
                        var39_59 = var39_58.g();
                        if (!var57_4) continue;
                    }
                    if (!var57_4) continue;
lbl205: // 2 sources:
                    if (!var28_34 || !var29_35) ** GOTO lbl455
                    for (var36_43 = var24_30.d().k(); var36_43 != null; var36_43 = var36_43.a()) {
                        var37_44 = (q)var36_43.c();
                        v3 = this.c.e(var37_44);
                        if (var57_4) break block123;
                        if (v3) continue;
                        var38_46 = bY.a(var37_44, var3_3);
                        if (var38_46 != null) ** GOTO lbl236
                        var39_60 = var37_44.f().d();
                        var40_76 = bY.a(var39_60, var3_3);
                        if (var40_76 != null) continue;
                        var41_77 = var37_44.g();
                        var42_91 = var1_1.p((d)var41_77);
                        var43_101 = var1_1.q(var39_60.f());
                        if (var42_91.a == var43_101.a) ** GOTO lbl233
                        if (!this.d(var3_3, (d)var41_77)) ** GOTO lbl-1000
                        var5_5.add(var41_77);
                        if (var57_4) lbl-1000: // 2 sources:
                        {
                            var44_114 = this.a(var1_1, var3_3, (d)var41_77);
                            var46_126 = this.b(var3_3, (d)var41_77);
                            var47_141 = this.a(var3_3, (d)var41_77);
                            var49_159 = var8_7.a(var41_77, this.m, var44_114, var42_91.a, true, var43_101.a, false, (boolean)var46_126, var47_141);
                            if (bY.a(var3_3.a(var41_77.c()))) {
                                var49_159.k = var42_91.b + this.a(var3_3, (d)var41_77, true);
                                var49_159.i = var42_91.b;
                            }
                            if (bY.a(var3_3.a(var39_60.f().d()))) {
                                var49_159.l = var43_101.b + var6_6 - this.a(var3_3, var39_60.f(), false);
                                var49_159.j = var43_101.b + var6_6;
                            }
                        }
lbl233: // 6 sources:
                        if (!bY.a(var3_3.a(var41_77.c())) || !bY.a(var3_3.a(var39_60.f().d()))) continue;
                        var34_40 = this.a(var1_1, var3_3, (d)var41_77, var42_91.a, var42_91.b, var43_101.a, var43_101.b + var6_6, var6_6, var34_40);
                        if (!var57_4) continue;
lbl236: // 2 sources:
                        var39_61 = -1.7976931348623157E308;
                        var41_78 = -1.7976931348623157E308;
                        var43_103 = var1_1.j(var37_44);
                        for (var45_118 = var37_44.g(); var45_118 != null; var45_118 = var45_118.h()) {
                            var46_127 = var1_1.p((d)var45_118);
                            var47_142 = this.c(var3_3, (d)var45_118);
                            var48_151 = this.a(var3_3, (d)var45_118);
                            v3 = var46_127.a DCMPL var43_103;
                            if (!var57_4) {
                                if (v3) {
                                    var50_164 = this.a(var1_1, var3_3, (d)var45_118);
                                    var52_172 = var8_7.a(var45_118, var38_46, this.m, var50_164, var46_127.a, true, var43_103, true, var47_142, var48_151);
                                    if (!bY.a(var3_3.a(var45_118.c()))) continue;
                                    var52_172.k = var46_127.b + this.a(var3_3, (d)var45_118, true);
                                    var52_172.i = var46_127.b;
                                    if (!var57_4) continue;
                                }
                                var39_62 = Math.max(var39_62, var46_127.b + this.a(var3_3, (d)var45_118, true));
                                var41_78 = Math.max(var39_62, var46_127.b);
                                if (!var57_4) continue;
                            }
                            break block123;
                        }
                        var45_118 = null;
                        var45_118 = new Object();
                        for (var46_128 = var37_44.f(); var46_128 != null; var46_128 = var46_128.g()) {
                            var47_143 = var46_128.d();
                            v2 = var48_152 = bY.a(var47_143, var3_3);
                            if (!var57_4) {
                                if (v2 == null) {
                                    var49_159 = var47_143.f();
                                    var50_165 = var1_1.q((d)var49_159);
                                    if (var50_165.a == var43_103) continue;
                                    var51_168 = this.a(var1_1, var3_3, var46_128);
                                    var53_176 = this.c(var3_3, var46_128);
                                    var54_178 = this.a(var3_3, var46_128);
                                    var56_180 = var8_7.a((Object)var46_128, var45_118, this.m, var51_168, var43_103, true, var50_165.a, false, var53_176, var54_178);
                                    if (bY.a(var3_3.a(var49_159.d()))) {
                                        var56_180.l = var50_165.b + var6_6 - this.a(var3_3, (d)var49_159, false);
                                        var56_180.j = var50_165.b + var6_6;
                                    }
                                    var56_180.k = var39_62;
                                    var56_180.i = var41_78;
                                    if (!var57_4) continue;
                                }
                                if (var48_152.equals(var38_46) || var43_103 == (var49_160 = var1_1.j(var47_143))) continue;
                                var51_169 = this.c(var3_3, var46_128);
                                var52_173 = this.a(var3_3, var46_128);
                                var8_7.a(var46_128, var43_103, true, var49_160, false, var51_169, var52_173);
                                if (!var57_4) continue;
                            }
                            ** GOTO lbl664
                        }
                        if (!var57_4) continue;
                    }
                    for (var36_43 = var27_33.d().k(); var36_43 != null; var36_43 = var36_43.a()) {
                        var37_44 = (q)var36_43.c();
                        v3 = this.c.e(var37_44);
                        if (var57_4) break block123;
                        if (v3 || (var38_47 = bY.a(var37_44, var3_3)) == null) continue;
                        var39_63 = Double.MAX_VALUE;
                        var41_79 = Double.MAX_VALUE;
                        var43_104 = var1_1.j(var37_44);
                        for (var45_118 = var37_44.f(); var45_118 != null; var45_118 = var45_118.g()) {
                            var46_129 = var1_1.q((d)var45_118);
                            v3 = var43_104 DCMPL var46_129.a;
                            if (!var57_4) {
                                if (v3) {
                                    var47_141 = this.a(var1_1, var3_3, (d)var45_118);
                                    var49_161 = this.c(var3_3, (d)var45_118);
                                    var50_164 = this.a(var3_3, (d)var45_118);
                                    var52_172 = var8_7.a(var45_118, var38_47, this.m, var47_141, var43_104, false, var46_129.a, false, var49_161, var50_164);
                                    if (!bY.a(var3_3.a(var45_118.d()))) continue;
                                    var52_172.l = var46_129.b + var6_6 - this.a(var3_3, (d)var45_118, false);
                                    var52_172.j = var46_129.b + var6_6;
                                    if (!var57_4) continue;
                                }
                                var39_64 = Math.min(var39_64, var46_129.b + var6_6 - this.a(var3_3, (d)var45_118, false));
                                var41_79 = Math.min(var39_64, var46_129.b + var6_6);
                                if (!var57_4) continue;
                            }
                            break block123;
                        }
                        var45_118 = null;
                        var45_118 = new Object();
                        for (var46_130 = var37_44.g(); var46_130 != null; var46_130 = var46_130.h()) {
                            var47_144 = var46_130.c();
                            v2 = var48_153 = bY.a(var47_144, var3_3);
                            if (!var57_4) {
                                if (v2 != null) continue;
                                var49_159 = var47_144.g();
                                var50_166 = var1_1.p((d)var49_159);
                                if (var50_166.a == var43_104) continue;
                                var51_168 = this.a(var1_1, var3_3, (d)var49_159);
                                var53_176 = this.c(var3_3, (d)var49_159);
                                var54_178 = this.a(var3_3, (d)var49_159);
                                var56_180 = var8_7.a(var49_159, var45_118, this.m, var51_168, var50_166.a, true, var43_104, false, var53_176, var54_178);
                                if (bY.a(var3_3.a(var49_159.c()))) {
                                    var56_180.k = var50_166.b + this.a(var3_3, (d)var49_159, true);
                                    var56_180.i = var50_166.b;
                                }
                                var56_180.l = var39_64;
                                var56_180.j = var41_79;
                                if (!var57_4) continue;
                            }
                            ** GOTO lbl664
                        }
                        if (!var57_4) continue;
                    }
                    var25_32 += this.a(var1_1, var3_3, var17_22, var20_25, var30_36, var31_38, var8_7, var5_5, var6_6, var34_40);
                    for (var36_43 = var24_30.d().k(); var36_43 != null; var36_43 = var36_43.a()) {
                        var37_44 = (q)var36_43.c();
                        v3 = this.c.e(var37_44);
                        if (var57_4) break block123;
                        if (v3) continue;
                        var38_48 = var1_1.j(var37_44);
                        var40_76 = bY.a(var37_44, var3_3);
                        if (var40_76 != null) ** GOTO lbl378
                        var41_77 = var37_44.f();
                        var42_92 = var41_77.d();
                        var43_101 = bY.a(var42_92, var3_3);
                        if (var43_101 != null) ** GOTO lbl376
                        var44_113 = var37_44.g();
                        var45_118 = var42_92.f();
                        if (this.d(var3_3, (d)var44_113)) continue;
                        var46_131 = var1_1.p((d)var44_113);
                        var47_145 = var1_1.q((d)var45_118);
                        var1_1.a(var37_44, var46_131.a, var22_26);
                        var1_1.a(var42_92, var47_145.a, var22_26);
                        if (var46_131.a == var47_145.a) ** GOTO lbl373
                        var48_154 = var8_7.a(var44_113);
                        var49_162 = var48_154.d;
                        if (Double.isNaN(var49_162)) ** GOTO lbl373
                        if (!var48_154.n) ** GOTO lbl-1000
                        var51_170 = this.a((d)var44_113);
                        if (var46_131.a >= var47_145.a) ** GOTO lbl-1000
                        var51_170.add(new Point2D.Double(var46_131.a, var49_162 - (var48_154.p - var48_154.b)));
                        if (var48_154.p != var48_154.q) {
                            var51_170.add(new Point2D.Double(var48_154.p, var49_162));
                            var51_170.add(new Point2D.Double(var48_154.q, var49_162));
                        }
                        var52_174 = var49_162 + (var48_154.c - var48_154.q);
                        if (var57_4) lbl-1000: // 2 sources:
                        {
                            var51_170.add(new Point2D.Double(var46_131.a, var49_162 - (var48_154.c - var48_154.q)));
                            if (var48_154.p != var48_154.q) {
                                var51_170.add(new Point2D.Double(var48_154.q, var49_162));
                                var51_170.add(new Point2D.Double(var48_154.p, var49_162));
                            }
                            var52_174 = var49_162 + (var48_154.p - var48_154.b);
                        }
                        var1_1.d((d)var44_113, new t(var47_145.a, var52_174));
                        var1_1.c((d)var45_118, new t(var47_145.a, var52_174));
                        if (var57_4) lbl-1000: // 2 sources:
                        {
                            var1_1.d((d)var44_113, new t(var46_131.a, var49_162));
                            var1_1.c((d)var45_118, new t(var47_145.a, var49_162));
                        }
lbl373: // 5 sources:
                        var1_1.c((d)var41_77, var1_1.q((d)var44_113));
                        var1_1.d((d)var41_77, var1_1.p(var42_92.f()));
                        if (!var57_4) continue;
lbl376: // 2 sources:
                        var1_1.a(var37_44, var38_48, var22_26);
                        if (!var57_4) continue;
lbl378: // 2 sources:
                        var1_1.a(var37_44, var38_48, var22_26);
                        if (var8_7.c(var40_76)) {
                            var41_80 = var8_7.e(var40_76);
                            var1_1.a(var37_44, var38_48, var41_80);
                            for (var43_101 = var37_44.g(); var43_101 != null; var43_101 = var43_101.h()) {
                                var44_113 = var1_1.p((d)var43_101);
                                v3 = var44_113.a DCMPL var38_48;
                                if (!var57_4) {
                                    if (v3) {
                                        var45_119 = var8_7.d(var43_101);
                                        if (!Double.isNaN(var45_119)) {
                                            var1_1.d((d)var43_101, new t(var44_113.a, var45_119));
                                            if (!var57_4) continue;
                                        }
                                        var1_1.d((d)var43_101, new t(var44_113.a, var41_80));
                                        if (!var57_4) continue;
                                    }
                                    var1_1.d((d)var43_101, new t(var44_113.a, var41_80));
                                    if (!var57_4) continue;
                                }
                                break block123;
                            }
                        }
                        for (var41_77 = var37_44.f(); var41_77 != null; var41_77 = var41_77.g()) {
                            var42_93 = var41_77.d();
                            v2 = var43_101 = bY.a(var42_93, var3_3);
                            if (!var57_4) {
                                if (v2 == null) {
                                    var44_113 = var1_1.q(var42_93.f());
                                    var1_1.a(var42_93, var38_48, var22_26);
                                    if (var44_113.a == var38_48 || Double.isNaN(var45_120 = var8_7.d(var41_77))) continue;
                                    var1_1.d((d)var41_77, new t(var38_48, var45_120));
                                    var1_1.c(var42_93.f(), new t(var44_113.a, var45_120));
                                    if (!var57_4) continue;
                                }
                                var44_115 = var1_1.j(var42_93);
                                var1_1.a(var42_93, var44_115, var22_26);
                                if (var43_101.equals(var40_76) || var38_48 == var44_115 || Double.isNaN(var46_132 = var8_7.d(var41_77))) continue;
                                var48_155 = this.a((d)var41_77);
                                var48_155.add(new Point2D.Double(var38_48, var46_132));
                                var48_155.add(new Point2D.Double(var44_115, var46_132));
                                if (!var57_4) continue;
                            }
                            ** GOTO lbl664
                        }
                        if (!var57_4) continue;
                    }
                    for (var36_43 = var27_33.d().k(); var36_43 != null; var36_43 = var36_43.a()) {
                        var37_44 = (q)var36_43.c();
                        v3 = this.c.e(var37_44);
                        if (var57_4) break block123;
                        if (v3 || (var38_49 = bY.a(var37_44, var3_3)) == null) continue;
                        var39_65 = var1_1.j(var37_44);
                        if (!var8_7.c(var38_49)) ** GOTO lbl436
                        var41_81 = var8_7.e(var38_49);
                        var1_1.a(var37_44, var39_65, var41_81);
                        for (var43_101 = var37_44.f(); var43_101 != null; var43_101 = var43_101.g()) {
                            var44_113 = var1_1.q((d)var43_101);
                            v3 = var44_113.a DCMPL var39_65;
                            if (!var57_4) {
                                if (v3) {
                                    var45_121 = var8_7.d(var43_101);
                                    var1_1.c((d)var43_101, new t(var44_113.a, var45_121));
                                    if (!var57_4) continue;
                                }
                                var1_1.c((d)var43_101, new t(var44_113.a, var41_81));
                                if (!var57_4) continue;
                            }
                            break block123;
lbl436: // 2 sources:
                            var1_1.a(var37_44, var39_65, var22_26);
                            break;
                        }
                        for (var41_82 = var37_44.g(); var41_82 != null; var41_82 = var41_82.h()) {
                            var42_94 = var41_82.c();
                            v2 = var43_101 = bY.a(var42_94, var3_3);
                            if (!var57_4) {
                                if (v2 != null) continue;
                                var44_113 = var42_94.g();
                                var45_118 = var1_1.p((d)var44_113);
                                if (var45_118.a != var39_65) {
                                    var46_133 = var8_7.d(var44_113);
                                    if (Double.isNaN(var46_133)) continue;
                                    var1_1.d((d)var44_113, new t(var45_118.a, var46_133));
                                    var1_1.c(var41_82, new t(var39_65, var46_133));
                                    if (!var57_4) continue;
                                }
                                var1_1.a(var42_94, new t(var39_65, var22_26));
                                if (!var57_4) continue;
                            }
                            ** GOTO lbl664
                        }
                        if (!var57_4) continue;
lbl455: // 2 sources:
                        if (!var28_34) ** GOTO lbl594
                        for (var36_43 = var24_30.d().k(); var36_43 != null; var36_43 = var36_43.a()) {
                            var37_44 = (q)var36_43.c();
                            v3 = this.c.e(var37_44);
                            if (var57_4) break block123;
                            if (v3) continue;
                            var38_50 = bY.a(var37_44, var3_3);
                            if (var38_50 != null) ** GOTO lbl484
                            var39_66 = var37_44.g();
                            var40_76 = var1_1.p(var39_66);
                            var41_77 = var37_44.f();
                            var42_95 = var1_1.q((d)var41_77);
                            if (var40_76.a == var42_95.a) ** GOTO lbl481
                            if (!this.d(var3_3, var39_66)) ** GOTO lbl-1000
                            var5_5.add(var39_66);
                            if (var57_4) lbl-1000: // 2 sources:
                            {
                                var43_105 = this.a(var1_1, var3_3, var39_66);
                                var45_122 = this.b(var3_3, var39_66);
                                var46_134 = this.a(var3_3, var39_66);
                                var48_156 = var8_7.a(var39_66, this.m, var43_105, var40_76.a, true, var42_95.a, false, var45_122, var46_134);
                                if (bY.a(var3_3.a(var39_66.c()))) {
                                    var48_156.k = var40_76.b + this.a(var3_3, var39_66, true);
                                    var48_156.i = var40_76.b;
                                }
                                if (bY.a(var3_3.a(var41_77.d()))) {
                                    var48_156.l = var42_95.b + var6_6 - this.a(var3_3, (d)var41_77, false);
                                    var48_156.j = var42_95.b + var6_6;
                                }
                            }
lbl481: // 6 sources:
                            if (!bY.a(var3_3.a(var39_66.c())) || !bY.a(var3_3.a(var41_77.d()))) continue;
                            var34_40 = this.a(var1_1, var3_3, var39_66, var40_76.a, var40_76.b, var42_95.a, var42_95.b + var6_6, var6_6, var34_40);
                            if (!var57_4) continue;
lbl484: // 2 sources:
                            var39_67 = -1.7976931348623157E308;
                            var41_83 = -1.7976931348623157E308;
                            var43_106 = var1_1.j(var37_44);
                            for (var45_118 = var37_44.g(); var45_118 != null; var45_118 = var45_118.h()) {
                                var46_135 = var1_1.p((d)var45_118);
                                var47_146 = this.c(var3_3, (d)var45_118);
                                var48_151 = this.a(var3_3, (d)var45_118);
                                v3 = var46_135.a DCMPL var43_106;
                                if (!var57_4) {
                                    if (v3) {
                                        var50_164 = this.a(var1_1, var3_3, (d)var45_118);
                                        var52_172 = var8_7.a(var45_118, var38_50, this.m, var50_164, var46_135.a, true, var43_106, false, var47_146, var48_151);
                                        if (!bY.a(var3_3.a(var45_118.c()))) continue;
                                        var52_172.k = var46_135.b + this.a(var3_3, (d)var45_118, true);
                                        var52_172.i = var46_135.b;
                                        if (!var57_4) continue;
                                    }
                                    if (!bY.a(var3_3.a(var45_118.c()))) continue;
                                    var39_68 = Math.max(var39_68, var46_135.b + this.a(var3_3, (d)var45_118, true));
                                    var41_83 = Math.max(var39_68, var46_135.b);
                                    if (!var57_4) continue;
                                }
                                break block123;
                            }
                            var45_118 = null;
                            var45_118 = new Object();
                            for (var46_136 = var37_44.f(); var46_136 != null; var46_136 = var46_136.g()) {
                                var47_147 = var46_136.d();
                                var48_157 = var1_1.q(var46_136);
                                v3 = var48_157.a DCMPL var43_106;
                                if (!var57_4) {
                                    if (!v3) continue;
                                    var49_163 = this.a(var1_1, var3_3, var46_136);
                                    var51_171 = this.c(var3_3, var46_136);
                                    var52_175 = this.a(var3_3, var46_136);
                                    var54_179 = var8_7.a((Object)var46_136, var45_118, this.m, var49_163, var43_106, false, var48_157.a, false, var51_171, var52_175);
                                    if (bY.a(var3_3.a(var47_147))) {
                                        var54_179.l = var48_157.b + var6_6 - this.a(var3_3, var46_136, false);
                                        var54_179.j = var48_157.b + var6_6;
                                    }
                                    var54_179.k = var39_68;
                                    var54_179.i = var41_83;
                                    if (!var57_4) continue;
                                }
                                break block123;
                            }
                            if (!var57_4) continue;
                        }
                        var25_32 += this.a(var1_1, var3_3, var17_22, var20_25, var30_36, var31_38, var8_7, var5_5, var6_6, var34_40);
                        for (var36_43 = var24_30.d().k(); var36_43 != null; var36_43 = var36_43.a()) {
                            var37_44 = (q)var36_43.c();
                            v3 = this.c.e(var37_44);
                            if (var57_4) break block123;
                            if (v3) continue;
                            var38_51 = bY.a(var37_44, var3_3);
                            if (var38_51 != null) ** GOTO lbl563
                            var39_69 = var37_44.g();
                            var40_76 = var1_1.p(var39_69);
                            var41_77 = var37_44.f();
                            var42_96 = var1_1.q((d)var41_77);
                            if (this.d(var3_3, var39_69) && var40_76.a != var42_96.a) continue;
                            var1_1.a(var37_44, var40_76.a, var22_26);
                            if (var40_76.a == var42_96.a) continue;
                            var43_101 = var8_7.a(var39_69);
                            var44_116 = var43_101.d;
                            if (Double.isNaN(var44_116)) continue;
                            if (!var43_101.n) ** GOTO lbl560
                            var46_137 = this.a(var39_69);
                            if (var40_76.a >= var42_96.a) ** GOTO lbl-1000
                            var46_137.add(new Point2D.Double(var40_76.a, var44_116 - (var43_101.p - var43_101.b)));
                            if (var43_101.p != var43_101.q) {
                                var46_137.add(new Point2D.Double(var43_101.p, var44_116));
                                var46_137.add(new Point2D.Double(var43_101.q, var44_116));
                            }
                            var47_141 = var44_116 + (var43_101.c - var43_101.q);
                            if (var57_4) lbl-1000: // 2 sources:
                            {
                                var46_137.add(new Point2D.Double(var40_76.a, var44_116 - (var43_101.c - var43_101.q)));
                                if (var43_101.p != var43_101.q) {
                                    var46_137.add(new Point2D.Double(var43_101.q, var44_116));
                                    var46_137.add(new Point2D.Double(var43_101.p, var44_116));
                                }
                                var47_141 = var44_116 + (var43_101.p - var43_101.b);
                            }
                            var1_1.d(var39_69, new t(var42_96.a, var47_141));
                            var1_1.c((d)var41_77, new t(var42_96.a, var47_141));
                            if (!var57_4) continue;
lbl560: // 2 sources:
                            var1_1.d(var39_69, new t(var40_76.a, var44_116));
                            var1_1.c((d)var41_77, new t(var42_96.a, var44_116));
                            if (!var57_4) continue;
lbl563: // 2 sources:
                            var39_70 = var1_1.j(var37_44);
                            if (!var8_7.c(var38_51)) ** GOTO lbl581
                            var41_84 = var8_7.e(var38_51);
                            var1_1.a(var37_44, var39_70, var41_84);
                            for (var43_101 = var37_44.g(); var43_101 != null; var43_101 = var43_101.h()) {
                                var44_113 = var1_1.p((d)var43_101);
                                v3 = var44_113.a DCMPL var39_70;
                                if (!var57_4) {
                                    if (v3) {
                                        var45_123 = var8_7.d(var43_101);
                                        if (!Double.isNaN(var45_123)) {
                                            var1_1.d((d)var43_101, new t(var44_113.a, var45_123));
                                            if (!var57_4) continue;
                                        }
                                        var1_1.d((d)var43_101, new t(var44_113.a, var41_84));
                                        if (!var57_4) continue;
                                    }
                                    var1_1.d((d)var43_101, new t(var44_113.a, var41_84));
                                    if (!var57_4) continue;
                                }
                                break block123;
lbl581: // 2 sources:
                                var1_1.a(var37_44, var39_70, var22_26);
                                break;
                            }
                            for (var41_85 = var37_44.f(); var41_85 != null; var41_85 = var41_85.g()) {
                                var42_97 = var1_1.q(var41_85);
                                v3 = var42_97.a DCMPL var39_70;
                                if (!var57_4) {
                                    if (!v3 || Double.isNaN(var43_107 = var8_7.d(var41_85))) continue;
                                    var45_118 = this.a(var41_85);
                                    var45_118.add(new Point2D.Double(var39_70, var43_107));
                                    var45_118.add(new Point2D.Double(var42_97.a, var43_107));
                                    if (!var57_4) continue;
                                }
                                break block123;
                            }
                            if (!var57_4) continue;
lbl594: // 6 sources:
                            for (var36_43 = var24_30.d().k(); var36_43 != null; var36_43 = var36_43.a()) {
                                var37_44 = (q)var36_43.c();
                                v3 = this.c.e(var37_44);
                                if (var57_4) break block123;
                                if (v3) continue;
                                var38_52 = bY.a(var37_44, var3_3);
                                if (var38_52 != null) ** GOTO lbl622
                                var39_71 = var37_44.g();
                                var40_76 = var1_1.p(var39_71);
                                var41_77 = var37_44.f();
                                var42_98 = var1_1.q((d)var41_77);
                                if (var40_76.a == var42_98.a) ** GOTO lbl619
                                if (!this.d(var3_3, var39_71)) ** GOTO lbl-1000
                                var5_5.add(var39_71);
                                if (var57_4) lbl-1000: // 2 sources:
                                {
                                    var43_108 = this.a(var1_1, var3_3, var39_71);
                                    var45_124 = this.b(var3_3, var39_71);
                                    var46_138 = this.a(var3_3, var39_71);
                                    var48_158 = var8_7.a(var41_77, this.m, var43_108, var40_76.a, true, var42_98.a, false, var45_124, var46_138);
                                    if (bY.a(var3_3.a(var39_71.c()))) {
                                        var48_158.k = var40_76.b + this.a(var3_3, var39_71, true);
                                        var48_158.i = var40_76.b;
                                    }
                                    if (bY.a(var3_3.a(var41_77.d()))) {
                                        var48_158.l = var42_98.b + var6_6 - this.a(var3_3, (d)var41_77, false);
                                        var48_158.j = var42_98.b + var6_6;
                                    }
                                }
lbl619: // 6 sources:
                                if (!bY.a(var3_3.a(var39_71.c())) || !bY.a(var3_3.a(var41_77.d()))) continue;
                                var34_40 = this.a(var1_1, var3_3, var39_71, var40_76.a, var40_76.b, var42_98.a, var42_98.b + var6_6, var6_6, var34_40);
                                if (!var57_4) continue;
lbl622: // 2 sources:
                                var39_72 = Double.MAX_VALUE;
                                var41_86 = Double.MAX_VALUE;
                                var43_109 = var1_1.j(var37_44);
                                for (var45_118 = var37_44.f(); var45_118 != null; var45_118 = var45_118.g()) {
                                    var46_139 = var1_1.q((d)var45_118);
                                    var47_148 = this.c(var3_3, (d)var45_118);
                                    var48_151 = this.a(var3_3, (d)var45_118);
                                    v3 = var43_109 DCMPL var46_139.a;
                                    if (!var57_4) {
                                        if (v3) {
                                            var50_164 = this.a(var1_1, var3_3, (d)var45_118);
                                            var52_172 = var8_7.a(var45_118, var38_52, this.m, var50_164, var43_109, false, var46_139.a, false, var47_148, var48_151);
                                            if (!bY.a(var3_3.a(var45_118.d()))) continue;
                                            var52_172.l = var46_139.b + var6_6 - this.a(var3_3, (d)var45_118, false);
                                            var52_172.j = var46_139.b + var6_6;
                                            if (!var57_4) continue;
                                        }
                                        var39_73 = Math.min(var39_73, var46_139.b + var6_6 - this.a(var3_3, (d)var45_118, false));
                                        var41_86 = Math.min(var41_86, var46_139.b + var6_6);
                                        if (!var57_4) continue;
                                    }
                                    break block123;
                                }
                                var45_118 = null;
                                var45_118 = new Object();
                                for (var46_140 = var37_44.g(); var46_140 != null; var46_140 = var46_140.h()) {
                                    var47_149 = var1_1.p(var46_140);
                                    v3 = var47_149.a DCMPL var43_109;
                                    if (!var57_4) {
                                        if (!v3) continue;
                                        var48_151 = this.a(var1_1, var3_3, var46_140);
                                        var50_167 = this.c(var3_3, var46_140);
                                        var51_168 = this.a(var3_3, var46_140);
                                        var53_177 = var8_7.a((Object)var46_140, var45_118, this.m, var48_151, var47_149.a, true, var43_109, false, var50_167, var51_168);
                                        if (bY.a(var3_3.a(var46_140.c()))) {
                                            var53_177.k = var47_149.b + this.a(var3_3, var46_140, true);
                                            var53_177.i = var47_149.b;
                                        }
                                        var53_177.l = var39_73;
                                        var53_177.j = var41_86;
                                        if (!var57_4) continue;
                                    }
                                    break block123;
                                }
                                if (!var57_4) continue;
                            }
                            var25_32 += this.a(var1_1, var3_3, var17_22, var20_25, var30_36, var31_38, var8_7, var5_5, var6_6, var34_40);
                            for (var36_43 = var24_30.d().k(); var36_43 != null; var36_43 = var36_43.a()) {
                                v2 = var36_43.c();
lbl664: // 7 sources:
                                var37_44 = (q)v2;
                                v3 = this.c.e(var37_44);
                                if (var57_4) break block123;
                                if (v3) continue;
                                var38_53 = bY.a(var37_44, var3_3);
                                if (var38_53 != null) ** GOTO lbl700
                                var39_74 = var37_44.f();
                                var40_76 = var1_1.q(var39_74);
                                var41_77 = var37_44.g();
                                var42_99 = var1_1.p((d)var41_77);
                                if (this.d(var3_3, var39_74) && var42_99.a != var40_76.a) continue;
                                var1_1.a(var37_44, var42_99.a, var22_26);
                                if (var42_99.a == var40_76.a) continue;
                                var43_110 = var8_7.a(var39_74);
                                var44_117 = var43_110.d;
                                if (Double.isNaN(var44_117)) continue;
                                if (!var43_110.n) ** GOTO lbl697
                                var46_126 = this.a((d)var41_77);
                                if (var42_99.a >= var40_76.a) ** GOTO lbl-1000
                                var46_126.add(new Point2D.Double(var42_99.a, var44_117 - (var43_110.p - var43_110.b)));
                                if (var43_110.p != var43_110.q) {
                                    var46_126.add(new Point2D.Double(var43_110.p, var44_117));
                                    var46_126.add(new Point2D.Double(var43_110.q, var44_117));
                                }
                                var47_150 = var44_117 + (var43_110.c - var43_110.q);
                                if (var57_4) lbl-1000: // 2 sources:
                                {
                                    var46_126.add(new Point2D.Double(var42_99.a, var44_117 - (var43_110.c - var43_110.q)));
                                    if (var43_110.p != var43_110.q) {
                                        var46_126.add(new Point2D.Double(var43_110.q, var44_117));
                                        var46_126.add(new Point2D.Double(var43_110.p, var44_117));
                                    }
                                    var47_150 = var44_117 + (var43_110.p - var43_110.b);
                                }
                                var1_1.d((d)var41_77, new t(var40_76.a, var47_150));
                                var1_1.c(var39_74, new t(var40_76.a, var47_150));
                                if (!var57_4) continue;
lbl697: // 2 sources:
                                var1_1.d((d)var41_77, new t(var42_99.a, var44_117));
                                var1_1.c(var39_74, new t(var40_76.a, var44_117));
                                if (!var57_4) continue;
lbl700: // 2 sources:
                                var39_75 = var1_1.j(var37_44);
                                if (!var8_7.c(var38_53)) ** GOTO lbl718
                                var41_87 = var8_7.e(var38_53);
                                var1_1.a(var37_44, var39_75, var41_87);
                                for (var43_111 = var37_44.f(); var43_111 != null; var43_111 = var43_111.g()) {
                                    var44_113 = var1_1.q(var43_111);
                                    v3 = var44_113.a DCMPL var39_75;
                                    if (!var57_4) {
                                        if (v3) {
                                            var45_125 = var8_7.d(var43_111);
                                            if (!Double.isNaN(var45_125)) {
                                                var1_1.c(var43_111, new t(var44_113.a, var45_125));
                                                if (!var57_4) continue;
                                            }
                                            var1_1.c(var43_111, new t(var44_113.a, var41_87));
                                            if (!var57_4) continue;
                                        }
                                        var1_1.c(var43_111, new t(var44_113.a, var41_87));
                                        if (!var57_4) continue;
                                    }
                                    break block123;
lbl718: // 2 sources:
                                    var1_1.a(var37_44, var39_75, var22_26);
                                    break;
                                }
                                for (var41_88 = var37_44.g(); var41_88 != null; var41_88 = var41_88.h()) {
                                    var42_100 = var1_1.p(var41_88);
                                    v3 = var42_100.a DCMPL var39_75;
                                    if (!var57_4) {
                                        if (!v3 || Double.isNaN(var43_112 = var8_7.d(var41_88))) continue;
                                        var45_118 = this.a(var41_88);
                                        var45_118.add(new Point2D.Double(var42_100.a, var43_112));
                                        var45_118.add(new Point2D.Double(var39_75, var43_112));
                                        if (!var57_4) continue;
                                    }
                                    break block123;
                                }
                                if (!var57_4) continue;
                            }
                        }
                    }
                }
                v3 = this.r;
            }
            if (!v3) {
                var6_6 += var25_32;
            }
            this.b.b(var1_1, var8_7, var30_36, var3_3, true, var6_6);
            this.b.a(var1_1, var14_15, var30_36, var3_3, var6_6, var13_14);
            this.c.b(var8_7, var30_36, true, var6_6);
            if (var57_4) lbl-1000: // 2 sources:
            {
                this.A = var17_22.b();
                if (this.A != null) {
                    var24_30 = var8_7.a(this.A, 0.0, this.A.d(), 0.0, -1.7976931348623157E308, true, Double.MAX_VALUE, true);
                    var24_30.i = var24_30.k = this.A.h() + this.A.b();
                }
                var8_7.j();
                this.b.a(var1_1, var14_15, var17_22, var3_3, var6_6, var13_14);
                if (this.A != null) {
                    var24_31 = var8_7.d(this.A);
                    this.A.d(var24_31 - this.A.h());
                    this.b(this.A, var1_1);
                }
            }
            this.b.b(var1_1, var8_7, var17_22, var3_3, false, 0.0);
            this.b.a(var1_1, var14_15, var17_22, var3_3, 0.0, var13_14);
            this.c.b(var8_7, var17_22, false, 0.0);
            ++var16_19;
        } while (!var57_4);
    }

    private double a(aV aV2, d d2) {
        if (this.d) {
            return 0.0;
        }
        double d3 = aV2.a(d2).k().i();
        return d3;
    }

    private boolean b(aV aV2, d d2) {
        if (this.d) return false;
        if (aV2 == null) return false;
        if (aV2.a(d2).k() == null) {
            return false;
        }
        bs bs2 = aV2.a(d2).k().h();
        if (bs2.c() != 1) return false;
        return true;
    }

    private boolean c(aV aV2, d d2) {
        if (this.d) return false;
        if (aV2 == null) return false;
        if (aV2.a(d2).k() == null) {
            return false;
        }
        bs bs2 = aV2.a(d2).k().h();
        if (bs2.b() == 0) return false;
        return true;
    }

    private final double a(X x2, aV aV2, d d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        B b2 = aV2.a(d2).k();
        if (b2 == null) return d8;
        return Math.max(d8, b2.c() - Math.abs(d3 - d5) - (d6 - d4));
    }

    protected double a(X x2, aV aV2, d d2) {
        double d3;
        B b2 = aV2.a(d2).k();
        if (b2 != null) {
            d3 = b2.d();
            return d3;
        }
        d3 = this.q;
        return d3;
    }

    private final boolean d(aV aV2, d d2) {
        if (this.d) {
            return false;
        }
        B b2 = aV2.a(d2).k();
        byte by2 = aV2.a(d2.c()).b();
        if (by2 == 6 || by2 == 7) {
            if (this.f) return true;
            if (b2 == null) return false;
            if (b2.h().b() != 2) return false;
            return true;
        }
        byte by3 = aV2.a(d2.d()).b();
        if (by3 == 6 || by3 == 7) {
            if (this.f) return true;
            if (b2 == null) return false;
            if (b2.h().b() != 2) return false;
            return true;
        }
        if (b2 == null) return this.e;
        if (b2.h().c() != 2) return false;
        return true;
    }

    private final double a(aV aV2, d d2, boolean bl2) {
        double d3;
        A a2 = aV2.a(d2);
        B b2 = a2.k();
        if (b2 != null) {
            double d4;
            if (bl2) {
                double d5;
                if (a2.i()) {
                    d5 = b2.b();
                    return d5;
                }
                d5 = b2.a();
                return d5;
            }
            if (a2.i()) {
                d4 = b2.a();
                return d4;
            }
            d4 = b2.b();
            return d4;
        }
        if (bl2) {
            double d6;
            if (a2.i()) {
                d6 = this.l;
                return d6;
            }
            d6 = this.k;
            return d6;
        }
        if (a2.i()) {
            d3 = this.k;
            return d3;
        }
        d3 = this.l;
        return d3;
    }

    private final double e(aV aV2, d d2) {
        double d3;
        B b2 = aV2.a(d2).k();
        if (b2 != null) {
            d3 = b2.e();
            return d3;
        }
        d3 = this.g;
        return d3;
    }

    private final double f(aV aV2, d d2) {
        double d3;
        B b2 = aV2.a(d2).k();
        if (b2 != null) {
            d3 = b2.c();
            return d3;
        }
        d3 = this.i;
        return d3;
    }

    private final double a(X x2, aV aV2, aQ aQ2, aQ aQ3) {
        return this.h;
    }

    private final double b(X x2, aV aV2, aQ aQ2, aQ aQ3) {
        return this.j;
    }

    /*
     * Unable to fully structure code
     */
    private final double a(X var1_1, aV var2_2, aQ var3_3, double var4_4, aQ var6_5, double var7_6, cr var9_7, List var10_8, double var11_9, double var13_10) {
        block26 : {
            block24 : {
                block23 : {
                    var53_11 = N.x;
                    var15_12 = var6_5.c() - var3_3.c() - 1;
                    var16_13 = 0.0;
                    var18_14 = 0.0;
                    if (var10_8.size() <= 0) ** GOTO lbl102
                    var9_7.d();
                    var9_7.f();
                    var9_7.g();
                    var20_15 = new bZ[var10_8.size() * 2];
                    for (var21_17 = 0; var21_17 < var10_8.size(); ++var21_17) {
                        var22_18 = (d)var10_8.get(var21_17);
                        var23_21 = var1_1.p((d)var22_18).a;
                        var25_23 = var1_1.q((d)bY.a((d)var22_18, (int)var15_12)).a;
                        var20_15[var21_17 * 2] = new bZ(var23_21, var22_18);
                        var20_15[var21_17 * 2 + 1] = new bZ(var25_23, var22_18);
                        if (!var53_11) {
                            if (!var53_11) continue;
                        }
                        break block23;
                    }
                    var21_17 = var10_8.size() * 2;
                }
                var22_19 = 0;
                var23_22 = new ArrayList<Object>(var10_8.size());
                e.a(var20_15, 0, var21_17, null);
                var24_25 = new BitSet(var1_1.h());
                var25_24 = 0;
                var26_27 = -1.7976931348623157E308;
                var28_28 = Double.MAX_VALUE;
                for (var30_33 = 0; var30_33 < var21_17; ++var30_33) {
                    block25 : {
                        var31_37 = (d)var20_15[var30_33].b;
                        if (var53_11) break block24;
                        if (!var24_25.get(var31_37.b())) ** GOTO lbl75
                        if (--var22_19 != 0) ** GOTO lbl73
                        var32_38 = var20_15[var25_24].a;
                        var34_46 = var20_15[var30_33].a;
                        var36_51 = var9_7.b(var32_38, var34_46, 0.0);
                        if (Double.isNaN(var36_51)) {
                            var36_51 = var4_4;
                        }
                        var36_51 = Math.min(var28_28, var36_51);
                        var38_54 = var9_7.a(var32_38, var34_46, 0.0);
                        if (Double.isNaN(var38_54)) {
                            var38_54 = var7_6;
                        }
                        var38_54 = Math.max(var26_27, var38_54);
                        for (var40_55 = 0; var40_55 < var23_22.size(); ++var40_55) {
                            var41_56 = (d)var23_22.get(var40_55);
                            var42_57 = var1_1.p(var41_56);
                            var43_58 = var1_1.q(bY.a(var41_56, var15_12));
                            var44_59 = this.a(var41_56);
                            v0 = (int)(var38_54 DCMPL var42_57.b);
                            if (var53_11) break block25;
                            if (v0 <= 0) ** GOTO lbl-1000
                            var45_60 = var38_54;
                            var44_59.add(new Point2D.Double(var42_57.a, var45_60));
                            if (var53_11) lbl-1000: // 2 sources:
                            {
                                var45_60 = var42_57.b;
                                var44_59.add(new Point2D.Double(var42_57.a, var45_60));
                            }
                            if (var36_51 >= var43_58.b + var11_9) ** GOTO lbl-1000
                            var47_61 = var36_51;
                            var44_59.add(new Point2D.Double(var43_58.a, var47_61));
                            if (var53_11) lbl-1000: // 2 sources:
                            {
                                var47_61 = var43_58.b + var11_9;
                                var44_59.add(new Point2D.Double(var43_58.a, var47_61));
                            }
                            var49_62 = Math.abs(var42_57.a - var43_58.a);
                            var51_63 = var47_61 - var45_60;
                            var16_13 = Math.max(var16_13, this.f(var2_2, var41_56) - var51_63);
                            var18_14 = Math.max(var18_14, var49_62 * this.e(var2_2, var41_56) - var51_63);
                            if (!var53_11) continue;
                        }
                        var26_27 = -1.7976931348623157E308;
                        var28_28 = Double.MAX_VALUE;
                        var23_22.clear();
                        v0 = var30_33 + 1;
                    }
                    var25_24 = v0;
lbl73: // 2 sources:
                    var24_25.clear(var31_37.b());
                    if (!var53_11) continue;
lbl75: // 2 sources:
                    var24_25.set(var31_37.b());
                    ++var22_19;
                    var23_22.add(var31_37);
                    var32_39 = bY.a((d)var31_37, var15_12);
                    if (!bY.a(var2_2.a(var31_37.c()))) ** GOTO lbl-1000
                    if (!this.n) ** GOTO lbl-1000
                    var33_42 = var1_1.p((d)var31_37).b + this.a(var2_2, (d)var31_37, true);
                    var35_48 = (var1_1.p((d)var31_37).b + var7_6) * 0.4;
                    var26_27 = Math.max(var26_27, Math.min(var33_42, var35_48));
                    if (var53_11) lbl-1000: // 2 sources:
                    {
                        var26_27 = Math.max(var26_27, var1_1.p((d)var31_37).b + this.a(var2_2, (d)var31_37, true));
                        ** if (!var53_11) goto lbl89
                    }
                    ** GOTO lbl89
lbl-1000: // 2 sources:
                    {
                        var26_27 = Math.max(var26_27, var1_1.p((d)var31_37).b);
                    }
lbl89: // 3 sources:
                    if (bY.a(var2_2.a(var32_39.d()))) {
                        if (this.n) {
                            var33_42 = var1_1.q((d)var32_39).b + var11_9 - this.a(var2_2, (d)var31_37, false);
                            var35_48 = (var1_1.q((d)var32_39).b + var4_4) * 0.6;
                            var28_28 = Math.min(var28_28, Math.max(var33_42, var35_48));
                            if (!var53_11) continue;
                        }
                        var28_28 = Math.min(var28_28, var1_1.q((d)var32_39).b + var11_9 - this.a(var2_2, (d)var31_37, false));
                        if (!var53_11) continue;
                    }
                    var28_28 = Math.min(var28_28, var1_1.q((d)var32_39).b + var11_9);
                    if (!var53_11) continue;
                }
                var9_7.h();
            }
            if (!var53_11) ** GOTO lbl106
lbl102: // 2 sources:
            if (!this.n) ** GOTO lbl-1000
            var9_7.i();
            if (var53_11) lbl-1000: // 2 sources:
            {
                var9_7.j();
            }
lbl106: // 4 sources:
            var20_16 = var7_6 - var4_4;
            var22_20 = this.b(var1_1, var2_2, var3_3, var6_5);
            var24_26 = var22_20 - var20_16;
            v1 = var26_27 = this.n != false ? var9_7.e() : var9_7.d(var22_20);
            if (!this.n) {
                var28_28 = var18_14 - var16_13;
                var28_28 = Math.min(this.a(var1_1, var2_2, var3_3, var6_5), var28_28);
                var26_27 = Math.max(Math.max(Math.max(var13_10, var26_27), var24_26), Math.max(var16_13, var16_13 + var28_28));
            }
            if (var15_12 != 0) ** GOTO lbl-1000
            if (var26_27 != 0.0) {
                block3 : for (var28_29 = 0; var28_29 < var10_8.size(); ((Point2D.Double)this.a((d)((d)var10_8.get((int)var28_29))).i()).y += var26_27, ++var28_29) {
                    if (!var53_11) {
                        if (!var53_11) continue;
                    }
                    break block26;
                }
            }
            ** GOTO lbl154
lbl-1000: // 2 sources:
            {
                if (var15_12 != 2) ** GOTO lbl141
                for (var28_30 = 0; var28_30 < var10_8.size(); ++var28_30) {
                    var29_64 = (d)var10_8.get(var28_30);
                    var30_34 = this.a(var29_64);
                    var31_37 = (Point2D.Double)var30_34.f();
                    var32_40 = (Point2D.Double)var30_34.i();
                    var30_34.clear();
                    var33_44 = var29_64.d();
                    var34_47 = var33_44.f();
                    var35_50 = var34_47.d();
                    var36_53 = var35_50.f();
                    var1_1.b(var29_64, t.c);
                    var1_1.a(var34_47, t.c);
                    var1_1.b(var34_47, t.c);
                    var1_1.a(var36_53, t.c);
                    var1_1.a(var33_44, var31_37.x, var31_37.y);
                    var1_1.a(var35_50, var32_40.x, var32_40.y + var26_27);
                    if (!var53_11) {
                        if (!var53_11) continue;
                    }
                    break block26;
lbl141: // 2 sources:
                    if (var15_12 != 1) break block3;
                    for (var28_31 = 0; var28_31 < var10_8.size(); var31_37.y += var26_27, ++var28_31) {
                        var29_64 = (d)var10_8.get(var28_31);
                        var30_35 = this.a(var29_64);
                        var31_37 = (Point2D.Double)var30_35.i();
                        var32_41 = var29_64.d();
                        var33_45 = var32_41.f();
                        var1_1.b(var29_64, t.c);
                        var1_1.a(var33_45, t.c);
                        var1_1.a(var32_41, var31_37.x, var31_37.y);
                        if (!var53_11) {
                            if (!var53_11) continue;
                        }
                        break block26;
                    }
                }
            }
lbl154: // 6 sources:
            if (var26_27 != 0.0) {
                var9_7.e(var26_27);
            }
            var26_27 = this.c.a(var9_7, var22_20, var26_27);
        }
        if (this.A == null) return var26_27;
        var28_32 = var9_7.d(this.A);
        var30_36 = this.c(this.B, this.A, var1_1);
        if (var30_36 <= 0.0) ** GOTO lbl-1000
        this.B.d(var28_32 - var30_36 * 0.5 - this.B.h());
        this.b(this.B, this.A, var1_1);
        this.A.g(var28_32 + var30_36 * 0.5);
        var30_36 = 0.0;
        if (var53_11) lbl-1000: // 2 sources:
        {
            this.B.d(var28_32 - this.B.h());
            this.A.g(var28_32);
        }
        this.B = this.A;
        return var26_27;
    }

    private static final d a(d d2, int n2) {
        switch (n2) {
            default: {
                return d2;
            }
            case 1: {
                return d2.d().f();
            }
            case 2: 
        }
        return d2.d().f().d().f();
    }

    private static final boolean a(aX aX2) {
        if (aX2.b() == 0) return true;
        if (aX2.b() == 5) return true;
        return false;
    }

    private static final Object a(q q2, aV aV2) {
        if (q2.a() == 2) {
            return null;
        }
        Object object = aV2.a(q2).a();
        return object;
    }

    private final D a(d d2) {
        D d3 = (D)this.z.get(d2);
        if (d3 != null) return d3;
        d3 = new D();
        this.z.put(d2, d3);
        return d3;
    }

    private void a(X x2, aV aV2, c c2, q q2, am am2, double d2, boolean bl2) {
        d d3;
        t t2;
        c c3;
        boolean bl3 = N.x;
        aX aX2 = aV2.a(q2);
        byte by2 = aX2.b();
        if (by2 == 2 || by2 == 3) {
            boolean bl4;
            B b2 = aV2.a(aX2.g()).k();
            q q3 = aX2.f();
            t t3 = x2.l(q2);
            double d4 = x2.j(q3);
            bs bs2 = b2.h();
            boolean bl5 = bl4 = by2 == 3 && bs2.d() == 1 || by2 == 2 && bs2.c() == 1;
            if (bl4) {
                c c4;
                double d5 = b2.i() / a;
                if (bl2) {
                    if (d4 > t3.a) {
                        c4 = new c(t3.a, d4, t3.b + d2);
                        c4.a(t3.a, t3.a + d5, t3.b + d2 - d5, 1.0);
                        c2.b(c4);
                        if (!bl3) return;
                    }
                    c4 = new c(d4, t3.a, t3.b + d2);
                    c4.a(t3.a - d5, t3.a, t3.b + d2, -1.0);
                    c2.b(c4);
                    if (!bl3) return;
                }
                if (d4 > t3.a) {
                    c4 = new c(t3.a, d4, t3.b + d2);
                    c4.a(t3.a, t3.a + d5, t3.b + d2 + d5, -1.0);
                    c2.a(c4);
                    if (!bl3) return;
                }
                c4 = new c(d4, t3.a, t3.b + d2);
                c4.a(t3.a - d5, t3.a, t3.b + d2, 1.0);
                c2.a(c4);
                if (!bl3) return;
            }
            if (bl2) {
                if (d4 > t3.a) {
                    c2.a(t3.a, d4 + 1.0, t3.b + d2);
                    if (!bl3) return;
                }
                c2.a(d4, t3.a + 1.0, t3.b + d2);
                if (!bl3) return;
            }
            if (d4 > t3.a) {
                c2.b(t3.a, d4 + 1.0, t3.b + d2);
                if (!bl3) return;
            }
            c2.b(d4, t3.a + 1.0, t3.b + d2);
            return;
        }
        double d6 = this.a();
        this.b.a(x2, aV2, c2, q2, am2, aX2, d2, bl2);
        if (bl2) {
            c2.a(am2.getX() - d6, am2.getX() + am2.getWidth() + d6, d2 + am2.getY());
            c3 = aX2.a(0);
            if (c3 != null) {
                c3.b(am2.getX());
                c3.a(am2.getY() + d2);
                c2.b(c3);
                c3.a(- am2.getY() + d2);
                c3.b(- am2.getX());
            }
            d3 = q2.g();
            do {
                if (d3 == null) return;
                t2 = x2.q(d3);
                if (t2.a < am2.getX() - d6 || t2.a > am2.getX() + am2.getWidth() + d6) {
                    c2.a(t2.a - d6, t2.a + d6, d2 + am2.getY());
                }
                d3 = d3.h();
            } while (!bl3);
        }
        c2.b(am2.getX() - d6, am2.getX() + am2.getWidth() + d6, d2 + am2.getY() + am2.getHeight());
        c3 = aX2.a(2);
        if (c3 != null) {
            c3.b(am2.getX());
            c3.a(am2.getY() + d2);
            c2.a(c3);
            c3.a(- am2.getY() + d2);
            c3.b(- am2.getX());
        }
        d3 = q2.f();
        do {
            if (d3 == null) return;
            t2 = x2.p(d3);
            if (t2.a < am2.getX() - d6 || t2.a > am2.getX() + am2.getWidth() + d6) {
                c2.b(t2.a - d6, t2.a + d6, d2 + am2.getY() + am2.getHeight());
            }
            d3 = d3.g();
        } while (!bl3);
    }

    static final int a(byte by2, int n2) {
        switch (by2) {
            default: {
                return n2;
            }
            case 1: {
                return 0;
            }
            case 4: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 8: 
        }
        return 3;
    }

    static final int a(aE aE2, int n2) {
        if (aE2 != null) return bY.a(aE2.b(), n2);
        return n2;
    }

    public double a() {
        return this.o;
    }

    public void a(double d2) {
        this.o = d2;
    }

    public double b() {
        return this.q;
    }

    public void b(double d2) {
        this.q = d2;
        this.b.a(d2);
    }

    public void a(long l2) {
        this.t = Math.max(0, l2);
    }
}

