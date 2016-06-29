/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y.a.g;
import y.c.a;
import y.c.d;
import y.c.f;
import y.c.h;
import y.c.i;
import y.c.p;
import y.c.x;
import y.d.t;
import y.d.v;
import y.f.F;
import y.f.I;
import y.f.U;
import y.f.V;
import y.f.X;
import y.f.aE;
import y.f.ad;
import y.f.an;
import y.f.ay;
import y.f.c;
import y.f.c.M;
import y.f.c.R;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.C;
import y.f.c.a.E;
import y.f.c.a.J;
import y.f.c.a.O;
import y.f.c.a.S;
import y.f.c.a.T;
import y.f.c.a.Z;
import y.f.c.a.aB;
import y.f.c.a.aD;
import y.f.c.a.aF;
import y.f.c.a.aH;
import y.f.c.a.aO;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aR;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aW;
import y.f.c.a.aX;
import y.f.c.a.aZ;
import y.f.c.a.ac;
import y.f.c.a.ah;
import y.f.c.a.al;
import y.f.c.a.au;
import y.f.c.a.ax;
import y.f.c.a.az;
import y.f.c.a.bK;
import y.f.c.a.bP;
import y.f.c.a.bQ;
import y.f.c.a.bR;
import y.f.c.a.bS;
import y.f.c.a.bT;
import y.f.c.a.bY;
import y.f.c.a.ba;
import y.f.c.a.bh;
import y.f.c.a.bk;
import y.f.c.a.bq;
import y.f.c.a.br;
import y.f.c.a.bt;
import y.f.c.a.bw;
import y.f.c.a.bx;
import y.f.c.a.by;
import y.f.c.a.cB;
import y.f.c.a.cd;
import y.f.c.a.cp;
import y.f.c.a.cq;
import y.f.c.a.dC;
import y.f.c.a.db;
import y.f.c.a.de;
import y.f.c.a.dp;
import y.f.c.a.dt;
import y.f.c.a.m;
import y.f.c.a.q;
import y.f.c.a.r;
import y.f.c.a.y;
import y.f.c.a.z;
import y.f.c.af;
import y.f.c.aj;
import y.f.l;
import y.g.ap;
import y.g.e;

public class N
extends c {
    private aT y;
    private bx z;
    private bq A;
    private br B;
    private z C;
    private aZ D;
    private Map E = new HashMap();
    public static final Object n = "y.layout.hierarchic.incremental.HierarchicLayouter.INCREMENTAL_HINTS_DPKEY";
    public static final Object o = "y.layout.hierarchic.incremental.HierarchicLayouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY";
    public static final Object p = "y.layout.hierarchic.incremental.HierarchicLayouter.NODE_LAYOUT_DESCRIPTOR_DPKEY";
    public static final Object q = "y.layout.hierarchic.incremental.HierarchicLayouter.SWIMLANE_DESCRIPTOR_DPKEY";
    public static final Object r = "y.layout.hierarchic.incremental.HierarchicLayouter.LAYER_VALUE_HOLDER_DPKEY";
    public static final Object s = "y.layout.hierarchic.incremental.HierarchicLayouter.SEQUENCE_VALUE_HOLDER_DPKEY";
    public static final Object t = "y.layout.hierarchic.incremental.HierarchicLayouter.INCREMENTAL_NODES_DPKEY";
    static final Object u = "y.layout.hierarchic.incremental.HierarchicLayouter.NODE_PORT_SIZE_DPKEY";
    static final Object v = "y.layout.hierarchic.incremental.HierarchicLayouter.constraintSupport_DPKEY";
    static final Object w = "groupingSupport";
    private long F = Long.MAX_VALUE;
    public static boolean x;

    public N() {
        this.f(false);
        this.b(false);
        this.e(false);
        this.d(false);
        ad ad2 = this.a();
        this.c(ad2);
        if (ad2 != null) {
            this.c(true);
        }
        an an2 = new an();
        an2.a(false);
        this.e(an2);
    }

    protected ad a() {
        V v2 = new V();
        v2.b(false);
        v2.c(true);
        return v2;
    }

    protected aT n() {
        return new aW(new aj());
    }

    public void a(long l2) {
        this.F = Math.max(0, l2);
    }

    protected bx o() {
        return new r();
    }

    protected z p() {
        return new q();
    }

    protected bq q() {
        return new y();
    }

    protected br r() {
        return null;
    }

    protected aZ s() {
        return new by();
    }

    public void a(aT aT2) {
        if (aT2 == null) {
            throw new NullPointerException();
        }
        this.y = aT2;
    }

    public aT t() {
        if (this.y != null) return this.y;
        this.y = this.n();
        return this.y;
    }

    public void a(bx bx2) {
        if (bx2 == null) {
            throw new NullPointerException();
        }
        this.z = bx2;
    }

    public bx u() {
        if (this.z != null) return this.z;
        this.z = this.o();
        return this.z;
    }

    public aZ v() {
        if (this.D != null) return this.D;
        this.D = this.s();
        return this.D;
    }

    public bq w() {
        if (this.A != null) return this.A;
        this.A = this.q();
        return this.A;
    }

    public void a(br br2) {
        this.B = br2;
    }

    public br x() {
        if (this.B != null) return this.B;
        this.B = this.r();
        return this.B;
    }

    public z y() {
        if (this.C != null) return this.C;
        this.C = this.p();
        return this.C;
    }

    @Override
    public boolean b(X x2) {
        return true;
    }

    public Object a(Object object) {
        return this.E.get(object);
    }

    public void a(Object object, Object object2) {
        if (object2 == null) {
            this.E.remove(object);
            if (!x) return;
        }
        this.E.put(object, object2);
    }

    /*
     * Unable to fully structure code
     */
    private static f a(l var0) {
        block13 : {
            var9_1 = N.x;
            if (g.a(var0)) {
                return new f();
            }
            var1_2 = var0.c(M.n);
            if (var1_2 == null) {
                var1_2 = y.g.q.a(new Integer(1));
            }
            var2_3 = y.g.M.b();
            var3_4 = var0.p();
            while (var3_4.f()) {
                var4_5 = var3_4.a();
                var2_3.a(var4_5, var1_2.a(var4_5));
                var3_4.g();
                if (!var9_1) continue;
            }
            var4_5 = new f();
            block1 : do lbl-1000: // 3 sources:
            {
                var3_4 = y.a.c.a((i)var0, true);
                v0 = var3_4.isEmpty();
                block2 : while (v0 == 0) {
                    v1 = var3_4.size();
                    v2 = 1;
                    block3 : do {
                        if (v1 != v2) ** GOTO lbl27
                        var5_6 = var3_4.b();
                        var4_5.add(var5_6);
                        var0.a(var5_6);
                        if (!var9_1) ** GOTO lbl-1000
lbl27: // 2 sources:
                        var5_7 = Integer.MAX_VALUE;
                        var6_9 = var3_4.a();
                        while (var6_9.f()) {
                            v1 = var7_10 = var2_3.a(var6_9.a());
                            v2 = var5_7;
                            if (var9_1) continue block3;
                            if (v1 < v2) {
                                var5_7 = var7_10;
                            }
                            var6_9.g();
                            if (!var9_1) continue;
                        }
                        break block3;
                        break;
                    } while (true);
                    var6_9 = var3_4.a();
                    do {
                        if (!var6_9.f()) continue block1;
                        var7_11 = var6_9.a();
                        var8_12 = var2_3.a(var7_11) - var5_7;
                        var2_3.a((Object)var7_11, var8_12);
                        if (var9_1) break block13;
                        v0 = var8_12;
                        if (var9_1) continue block2;
                        if (v0 == 0) {
                            var4_5.add(var7_11);
                            var0.a(var7_11);
                        }
                        var6_9.g();
                    } while (!var9_1);
                }
                break block1;
                break;
            } while (true);
            var4_5.sort(new aF(var1_2));
        }
        var5_8 = var4_5.a();
        do {
            block14 : {
                if (var5_8.f() == false) return var4_5;
                var6_9 = var5_8.a();
                var0.b((d)var6_9);
                if (!g.a(var0)) {
                    var0.a((d)var6_9);
                    if (!var9_1) break block14;
                }
                var4_5.b(var5_8);
            }
            var5_8.g();
        } while (!var9_1);
        return var4_5;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public void a(X var1_1) {
        var64_2 = N.x;
        if (var1_1 == null) return;
        if (var1_1.i()) {
            return;
        }
        var2_3 = System.currentTimeMillis();
        var4_4 = var1_1.c(M.n);
        var5_5 = new f();
        if (var4_4 != null) {
            var6_6 = new l(var1_1);
            var7_7 = N.a((l)var6_6);
            var8_8 = var7_7.a();
            while (var8_8.f()) {
                var9_9 = (d)var6_6.i(var8_8.a());
                v0 = var1_1;
                if (!var64_2) {
                    v0.c((d)var9_9);
                    var5_5.add(var9_9);
                    var8_8.g();
                    if (!var64_2) continue;
                }
                break;
            }
        } else {
            v0 = var1_1;
        }
        var6_6 = v0.u();
        var7_7 = var1_1.t();
        var8_8 = new ax((y.c.A)var7_7, (h)var6_6);
        var9_9 = this.a((aV)var8_8);
        var10_10 = this.G();
        var11_11 = this.j(var1_1);
        var12_12 = this.a(var1_1, this.g(var1_1));
        var13_13 = var1_1.c(U.a);
        var14_14 = null;
        var15_15 = null;
        if (var13_13 != null) {
            var15_15 = var1_1.u();
            var14_14 = new ap(var15_15, var1_1, U.a);
        }
        var16_16 = new au(var1_1, (aU)var9_9, (aV)var8_8, var10_10, (y.c.A)var7_7, (h)var6_6, this.f(var1_1), this.e(var1_1), var12_12, var11_11, var15_15, var14_14);
        var17_17 = this.D();
        this.a(var1_1, (aP)var16_16);
        var18_18 = var1_1.t();
        var1_1.a(cp.a, var18_18);
        var19_19 = var1_1.t();
        var1_1.a(cp.b, var19_19);
        var20_20 = this.a(var1_1, (aV)var8_8, var12_12);
        var21_21 = this.A();
        var22_22 = this.a((aV)var8_8, (aP)var16_16);
        var23_23 = this.E();
        var24_24 = this.F();
        var25_25 = this.B();
        var26_26 = this.a(var22_22, var20_20);
        var27_27 = this.z();
        var28_28 = this.t();
        var29_29 = this.u();
        var30_30 = this.v();
        var31_31 = this.y();
        var32_32 = this.w();
        if (var32_32 instanceof y) {
            ((y)var32_32).a(var22_22);
            ((y)var32_32).a(var21_21);
        }
        var33_33 = this.x();
        var34_34 = new F();
        var34_34.b(var1_1);
        var35_35 = this.a(var34_34);
        cB.a(var35_35, var1_1);
        var36_36 = this.C();
        var23_23.a(var36_36);
        var16_16.a(var26_26);
        var16_16.a(var24_24);
        var16_16.a(var21_21);
        var16_16.a(var22_22);
        var16_16.a(var23_23);
        var16_16.a(var20_20);
        var37_37 = Boolean.TRUE.equals(this.a("HierarchicLayouter.considerNodeLabelsForSelfloops"));
        var38_38 = Boolean.TRUE.equals(this.a("HierarchicLayouter.considerNodeLabelsForDrawing"));
        var39_39 = Boolean.TRUE.equals(this.a("HierarchicLayouter.considerNodeLabelsForRouting"));
        var40_40 = Boolean.TRUE.equals(this.a("y.layout.hierarchic.incremental.HierarchicLayouter.automaticEdgeGroupingEnabled"));
        var41_41 = Boolean.TRUE.equals(this.a("y.layout.hierarchic.incremental.HierarchicLayouter.backloopRoutingEnabled"));
        var42_42 = Boolean.TRUE.equals(this.a("HierarchicLayouter.keepLayeringForGroupsWithSwimlanes"));
        var43_43 = Boolean.TRUE.equals(this.a("HierarchicLayouter.stopAfterLayering"));
        var44_44 = Boolean.TRUE.equals(this.a("HierarchicLayouter.stopAfterSequencing"));
        var45_45 = var1_1.t();
        var1_1.a(N.t, var45_45);
        var1_1.a(N.w, y.g.q.a(var20_20));
        var46_46 = this.h(var1_1);
        var1_1.a(N.v, y.g.q.a(var46_46));
        try {
            block58 : {
                block57 : {
                    var47_47 = y.g.M.a();
                    if (this.K() && this.H()) {
                        block56 : {
                            var48_48 = new y.f.b.c(var1_1);
                            var49_49 = var1_1.o();
                            while (var49_49.f()) {
                                var50_51 = var49_49.e();
                                v1 = var48_48;
                                if (!var64_2) {
                                    if (v1.d(var50_51)) {
                                        var47_47.a((Object)var50_51, var1_1.r(var50_51));
                                        var1_1.b(var50_51, 1.0, 1.0);
                                    }
                                    var49_49.g();
                                    if (!var64_2) continue;
                                }
                                break block56;
                            }
                            v1 = var48_48;
                        }
                        v1.c();
                    }
                    var20_20.b();
                    var21_21.a(var1_1);
                    var48_48 = bk.c(var1_1);
                    var49_50 = this.F == Long.MAX_VALUE ? Long.MAX_VALUE : (long)((double)this.F * 0.2);
                    this.a(var28_28, var49_50);
                    if (!this.H()) ** GOTO lbl-1000
                    var51_52 = var48_48 != null && var20_20.k() != false;
                    var52_55 = null;
                    var53_57 = var1_1.c(bk.b);
                    var54_60 = var1_1.c(y.f.b.f.c);
                    if (var51_52) {
                        var20_20.c();
                        var55_65 = y.g.M.a();
                        var56_67 = y.g.M.a();
                        var52_55 = this.a(var1_1, (bk)var48_48, (y.c.A)var55_65, (y.c.A)var56_67);
                        var57_70 = new O(this, (y.c.c)var53_57, (y.c.A)var56_67);
                        var1_1.a(bk.b, (y.c.c)var57_70);
                        var58_72 = new Object();
                        var59_73 = new S(this, (y.c.A)var55_65, var58_72, var54_60);
                        var1_1.a(y.f.b.f.c, (y.c.c)var59_73);
                        var20_20.b();
                    }
                    var55_65 = new al(this, var28_28, var17_17, var11_11, var45_45, false);
                    var55_65.a(var1_1, (aU)var9_9, (aV)var8_8);
                    if (!this.K()) ** GOTO lbl-1000
                    var20_20.c();
                    var56_67 = var1_1.o();
                    while (var56_67.f()) {
                        var57_70 = var56_67.e();
                        v2 = var47_47;
                        if (!var64_2) {
                            if (v2.b(var57_70) != null) {
                                var1_1.a((y.c.q)var57_70, (y.d.q)var47_47.b(var57_70));
                            }
                            var56_67.g();
                            if (!var64_2) continue;
                        }
                        break block57;
                    }
                    var20_20.b();
                    if (var64_2) lbl-1000: // 2 sources:
                    {
                        if (this.J()) {
                            var56_67 = new aD(null);
                            var56_67.a(var1_1, (aU)var9_9, (aV)var8_8);
                        }
                    }
                    if (var51_52) {
                        var20_20.c();
                        var52_55.f();
                        var1_1.a(bk.b, (y.c.c)var53_57);
                        var1_1.a(y.f.b.f.c, var54_60);
                        var20_20.b();
                        ** if (!var64_2) goto lbl151
                    }
                    ** GOTO lbl151
lbl-1000: // 2 sources:
                    {
                        this.a(var1_1, var11_11, var28_28, (aU)var9_9, (aV)var8_8, var17_17, var45_45, var20_20);
                    }
lbl151: // 3 sources:
                    v2 = var4_4;
                }
                if (v2 != null) {
                    var51_53 = var5_5.a();
                    while (var51_53.f()) {
                        var1_1.c(var51_53.a());
                        var51_53.g();
                        if (!var64_2) {
                            if (!var64_2) continue;
                        }
                        break;
                    }
                } else {
                    this.b(var1_1, (aU)var9_9);
                    var20_20.a((aU)var9_9);
                    var36_36.b(var1_1, (aU)var9_9, (aV)var8_8);
                }
                v3 = var51_54 = bk.d(var1_1) != false || var1_1.c(aR.a) != null;
                if (!var51_54 && !var42_42) {
                    var20_20.f((aU)var9_9);
                    var20_20.a((aU)var9_9);
                }
                if (var48_48 == null) ** GOTO lbl-1000
                var52_55 = var1_1.c(bk.b);
                if (var48_48 != null && var52_55 != null) {
                    var53_57 = var48_48.a(0);
                    var54_61 = 0;
                    block9 : while (var54_61 < var9_9.b()) {
                        var55_65 = var9_9.a(var54_61);
                        var56_67 = null;
                        if (!var64_2) {
                            var57_70 = var55_65.d().a();
                            while (var57_70.f()) {
                                var58_72 = var57_70.e();
                                var59_73 = (bh)var52_55.b(var58_72);
                                if (var64_2) continue block9;
                                if (var59_73 != null) {
                                    var56_67 = var59_73.c();
                                    break;
                                }
                                var57_70.g();
                            }
                            if (var56_67 == null) {
                                var56_67 = var53_57;
                            }
                            var55_65.a((bt)var56_67);
                            var53_57 = var56_67;
                            ++var54_61;
                            if (!var64_2) continue;
                        }
                        break;
                    }
                } else lbl-1000: // 4 sources:
                {
                    var20_20.c((aU)var9_9, var16_16);
                    var20_20.a(var1_1, (aV)var8_8);
                }
                if (var41_41) {
                    bS.a(var1_1, (aU)var9_9, (aV)var8_8, var16_16);
                }
                if (var40_40) {
                    bQ.a(var1_1, (aU)var9_9, (aV)var8_8, var16_16);
                }
                var10_10.a(var1_1, (aV)var8_8);
                var23_23.a(var1_1, (aU)var9_9, (aV)var8_8, var16_16, var15_15, var14_14);
                N.a(var33_33, var1_1, (aU)var9_9, (aV)var8_8, var16_16);
                var20_20.a((aU)var9_9);
                var26_26.e(var1_1, (aU)var9_9, (aV)var8_8, var16_16);
                var20_20.i((aU)var9_9);
                var20_20.j((aU)var9_9);
                var20_20.k((aU)var9_9);
                var20_20.a((aU)var9_9);
                var22_22.a(var1_1);
                var24_24.a(var1_1, (aU)var9_9, (aV)var8_8, var16_16);
                var20_20.b((aU)var9_9);
                var20_20.c((aU)var9_9);
                var20_20.b((aU)var9_9, var16_16);
                var20_20.a((aU)var9_9, var16_16);
                var20_20.a((aU)var9_9, var21_21);
                if (!var43_43) {
                    var53_58 = System.currentTimeMillis();
                    var55_66 = this.F - (var53_58 - var2_3);
                    var57_71 = this.F == Long.MAX_VALUE ? Long.MAX_VALUE : (long)Math.max(Math.floor((double)var55_66 * 0.4), Math.floor((double)this.F * 0.3));
                    this.a(var29_29, var57_71);
                    var59_73 = null;
                    if (var11_11 != null) {
                        var59_73 = this.a(var1_1, (aU)var9_9, (aV)var8_8, var11_11, var20_20);
                    }
                    var29_29.a(var1_1, (aU)var9_9, (aV)var8_8, var16_16);
                    var20_20.g((aU)var9_9);
                    var36_36.a(var1_1, (aU)var9_9, (aV)var8_8);
                    if (var46_46 != null) {
                        var46_46.a((i)var1_1, (aU)var9_9, (aV)var8_8);
                    }
                    if (var59_73 != null) {
                        var20_20.a(var45_45);
                        var20_20.e();
                        this.a((ah)var59_73, var45_45, var1_1, (aU)var9_9, (aV)var8_8);
                        var20_20.a((aU)var9_9);
                        var20_20.c((aU)var9_9);
                        var20_20.g((aU)var9_9);
                    }
                    var59_74 = var57_71 == Long.MAX_VALUE ? Long.MAX_VALUE : Math.max(0, var57_71 - System.currentTimeMillis() + var53_58);
                    this.a(var27_27, var59_74);
                    var27_27.a(var1_1, (aU)var9_9, (aV)var8_8, var16_16);
                    var20_20.o((aU)var9_9);
                    var52_56 = var22_22.a(var1_1, (aU)var9_9, (aV)var8_8, var16_16);
                    this.b(var33_33, var1_1, (aU)var9_9, (aV)var8_8, var16_16);
                    if (!var64_2) break block58;
                }
                var52_56 = 0;
            }
            var53_59 = var35_35.a(var1_1, (aU)var9_9, (aV)var8_8, var16_16);
            var20_20.d((aU)var9_9, var16_16);
            var20_20.m((aU)var9_9);
            var36_36.a(var1_1, (aU)var9_9, (aV)var8_8);
            if (var46_46 != null) {
                var46_46.a((i)var1_1, (aU)var9_9, (aV)var8_8);
            }
            var22_22.b(var1_1, (aU)var9_9, (aV)var8_8, var16_16);
            if (var52_56 > 0) {
                var22_22.a(var1_1, (aU)var9_9, (aV)var8_8, var16_16);
            }
            var20_20.l((aU)var9_9);
            var36_36.a(var1_1, (aU)var9_9, (aV)var8_8);
            if (var46_46 != null) {
                var46_46.a((i)var1_1, (aU)var9_9, (aV)var8_8);
            }
            var20_20.n((aU)var9_9);
            var21_21.a(var1_1, (aV)var8_8);
            var32_32.a(var1_1, (aU)var9_9, (aV)var8_8, var16_16);
            var25_25.a(var1_1, (aV)var8_8, 1, var37_37);
            var21_21.a(var1_1, (aU)var9_9, (aV)var8_8);
            var30_30.a(var1_1, (aV)var8_8, (aU)var9_9);
            var26_26.a(var1_1, (aU)var9_9, (aV)var8_8, var16_16);
            var25_25.a(var1_1, (aV)var8_8, 2, var38_38);
            if (!var43_43 && !var44_44) {
                var31_31.a(var1_1, (aU)var9_9, (aV)var8_8);
                var54_62 = this.F - (System.currentTimeMillis() - var2_3);
                var56_68 = this.F == Long.MAX_VALUE ? Long.MAX_VALUE : (long)Math.max(Math.floor((double)var54_62 * 0.7), Math.floor((double)this.F * 0.3));
                this.a(var30_30, var56_68);
                try {
                    var30_30.a(var1_1, (aV)var8_8, (aU)var9_9, var31_31);
                }
                finally {
                    var34_34.c(var1_1);
                    var31_31.b(var1_1, (aU)var9_9, (aV)var8_8);
                }
            }
            var26_26.c(var1_1, (aU)var9_9, (aV)var8_8, var16_16);
            if (!var43_43 && !var44_44) {
                var25_25.a(var1_1, (aV)var8_8, 3, var39_39);
                var54_63 = this.F - (System.currentTimeMillis() - var2_3);
                var56_69 = this.F == Long.MAX_VALUE ? Long.MAX_VALUE : (long)Math.max((double)var54_63, Math.floor((double)this.F * 0.2));
                this.a(var26_26, var56_69);
                var26_26.a(var1_1, (aU)var9_9, (aV)var8_8);
            }
            var26_26.b(var1_1, (aU)var9_9, (aV)var8_8, var16_16);
            var22_22.b(var1_1);
            var26_26.d(var1_1, (aU)var9_9, (aV)var8_8, var16_16);
            var35_35.a(var1_1, (aU)var9_9, (aV)var8_8, var16_16, var53_59);
            var20_20.i();
            var24_24.a(var1_1, (aV)var8_8);
            var20_20.a(var1_1);
            var26_26.f(var1_1, (aU)var9_9, (aV)var8_8, var16_16);
            var54_64 = new HashSet<E>();
            var23_23.a(var1_1, (aU)var9_9, (aV)var8_8, var54_64);
            var35_35.b(var1_1, (aU)var9_9, (aV)var8_8);
            this.i(var1_1);
            var23_23.a(var1_1, (aV)var8_8, var54_64);
            var10_10.b(var1_1, (aV)var8_8);
            var20_20.c();
            var20_20.e((aU)var9_9);
            var21_21.b(var1_1);
            var21_21.b(var1_1, (aU)var9_9, (aV)var8_8);
            var20_20.j();
            var20_20.h((aU)var9_9);
            var35_35.a(var1_1, (aU)var9_9, (aV)var8_8);
            this.a(var1_1, (aU)var9_9);
            this.a(var1_1, (aU)var9_9, (aV)var8_8);
            var63_76 = null;
            if (var46_46 != null) {
                var46_46.a();
            }
            if (var20_20 != null) {
                var20_20.f();
            }
            if (var23_23 != null) {
                var23_23.a(var1_1);
            }
            cB.a(var1_1);
            if (var14_14 != null) {
                var14_14.b();
                var1_1.a(var15_15);
                var15_15 = null;
                var14_14 = null;
            }
            var1_1.a((h)var6_6);
            var1_1.a((y.c.A)var7_7);
            var1_1.a(var45_45);
            var1_1.d_(N.t);
            var1_1.d_(N.v);
            var1_1.d_(N.w);
            var1_1.d_(cp.a);
            var1_1.a(var18_18);
            var1_1.d_(cp.b);
            var1_1.a(var19_19);
            return;
        }
        catch (Throwable var62_78) {
            var63_77 = null;
            if (var46_46 != null) {
                var46_46.a();
            }
            if (var20_20 != null) {
                var20_20.f();
            }
            if (var23_23 != null) {
                var23_23.a(var1_1);
            }
            cB.a(var1_1);
            if (var14_14 != null) {
                var14_14.b();
                var1_1.a(var15_15);
                var15_15 = null;
                var14_14 = null;
            }
            var1_1.a((h)var6_6);
            var1_1.a((y.c.A)var7_7);
            var1_1.a(var45_45);
            var1_1.d_(N.t);
            var1_1.d_(N.v);
            var1_1.d_(N.w);
            var1_1.d_(cp.a);
            var1_1.a(var18_18);
            var1_1.d_(cp.b);
            var1_1.a(var19_19);
            throw var62_78;
        }
    }

    private void b(X x2, aU aU2) {
        y.c.c c2;
        int[] arrn;
        Object object;
        y.c.A a2;
        boolean bl2;
        Object object2;
        int n2;
        block8 : {
            bl2 = x;
            if (!bk.d(x2)) return;
            c2 = x2.c(bk.b);
            a2 = y.g.M.a();
            arrn = new int[aU2.b()];
            int n3 = 0;
            int n4 = 0;
            while (n4 < aU2.b()) {
                block9 : {
                    object = aU2.a(n4);
                    n2 = 0;
                    int n5 = 0;
                    if (bl2) break block8;
                    x x3 = object.d().a();
                    while (x3.f()) {
                        object2 = x3.e();
                        a2.a(object2, n4);
                        bh bh2 = (bh)c2.b(object2);
                        if (!bl2) {
                            if (bh2 != null) {
                                n5 += bh2.c().a();
                                ++n2;
                            }
                            x3.g();
                            if (!bl2) continue;
                        }
                        break block9;
                    }
                    if (n2 > 0) {
                        n3 = n5 / n2;
                    }
                    arrn[n4] = n3;
                    ++n4;
                }
                if (!bl2) continue;
            }
            while (aU2.b() > 0) {
                aU2.b(0);
                if (bl2) return;
                if (!bl2) continue;
            }
        }
        Object[] arrobject = x2.m();
        object = new aH(c2, a2, arrn);
        e.a(arrobject, (Comparator)object);
        n2 = 0;
        aQ aQ2 = aU2.a(0, n2);
        int n6 = 0;
        do {
            if (n6 >= arrobject.length) return;
            object2 = arrobject[n6];
            if (n6 > 0 && object.compare(arrobject[n6 - 1], object2) != 0) {
                aQ2 = aU2.a(0, ++n2);
            }
            aQ2.a((y.c.q)object2);
            ++n6;
        } while (!bl2);
    }

    private void a(dC dC2, long l2) {
        if (!(dC2 instanceof bY)) return;
        bY bY2 = (bY)dC2;
        bY2.a(l2);
    }

    private void a(aT aT2, long l2) {
        Object object = aT2;
        if (object instanceof aW) {
            object = ((aW)object).a();
        }
        if (object instanceof ba) {
            object = ((ba)object).a();
        }
        if (!(object instanceof aj)) return;
        ((aj)object).a(l2);
    }

    private void a(bx bx2, long l2) {
        if (bx2 instanceof r) {
            ((r)bx2).a(l2);
            if (!x) return;
        }
        if (!(bx2 instanceof bT)) return;
        ((bT)bx2).a(l2);
    }

    private void a(aZ aZ2, long l2) {
        if (!(aZ2 instanceof by)) return;
        ((by)aZ2).a(l2);
    }

    /*
     * Unable to fully structure code
     */
    private void a(X var1_1, y.c.c var2_2, aT var3_3, aU var4_4, aV var5_5, aT var6_6, y.c.A var7_7, E var8_8) {
        block6 : {
            block5 : {
                var16_9 = N.x;
                var9_10 = new f();
                var10_11 = new f();
                var11_12 = y.g.M.b();
                if (this.I() && var8_8 != null && var8_8.k()) {
                    var8_8.c();
                    this.a(var1_1, var10_11, var8_8, null);
                    this.a(var1_1, var9_10, var10_11, var8_8, null, var11_12);
                    var8_8.b();
                }
                var12_13 = this.a(var1_1, var2_2, var8_8, var11_12);
                var13_14 = y.g.M.a();
                if (!(var3_3 instanceof m)) ** GOTO lbl28
                for (y.c.q var15_16 : var12_13.a) {
                    var1_1.d(var15_16);
                    var13_14.a((Object)var15_16, true);
                    if (!var16_9) {
                        if (!var16_9) continue;
                    }
                    break block5;
                }
                ((m)var3_3).a(var13_14);
                var3_3.a(var1_1, var4_4, var5_5);
            }
            for (y.c.q var15_16 : var12_13.a) {
                var13_14.a((Object)var15_16, false);
                var1_1.c(var15_16);
                if (!var16_9) {
                    if (!var16_9) continue;
                }
                break block6;
lbl28: // 2 sources:
                var1_1.a("AspectRatioComponentLayerer.GROUPING_SUPPORT", y.g.q.a(var8_8));
                var3_3.a(var1_1, var4_4, var5_5);
                var1_1.d_("AspectRatioComponentLayerer.GROUPING_SUPPORT");
                break;
            }
            this.b(var1_1, var4_4);
            this.a(var6_6, var1_1, var4_4, var5_5, var12_13, var7_7, var13_14);
        }
        if (this.I() == false) return;
        if (var8_8 == null) return;
        if (var8_8.k() == false) return;
        var8_8.c();
        this.a(var1_1, var9_10, var10_11);
        var8_8.b();
    }

    private void a(X x2, f f2, f f3) {
        d d2;
        y.c.e e2;
        boolean bl2;
        block3 : {
            bl2 = x;
            e2 = f2.a();
            while (e2.f()) {
                d2 = e2.a();
                x2.a(d2);
                e2.g();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block3;
            }
            e2 = f3.a();
        }
        do {
            if (!e2.f()) return;
            d2 = e2.a();
            x2.e(d2);
            e2.g();
        } while (!bl2);
    }

    /*
     * Exception decompiling
     */
    private void a(X var1_1, f var2_2, f var3_3, E var4_4, y.c.q var5_5, h var6_6) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [12[SIMPLE_IF_TAKEN]], but top level block is 1[WHILELOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
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

    /*
     * Unable to fully structure code
     */
    private void a(X var1_1, f var2_2, E var3_3, y.c.q var4_4) {
        block8 : {
            var9_5 = N.x;
            if (var4_4 == null) ** GOTO lbl36
            var5_6 = this.a(var3_3, var4_4);
            var5_6.add(var4_4);
            var6_7 = new f();
            for (var7_8 = var4_4.g(); var7_8 != null; var7_8 = var7_8.h()) {
                v0 = var5_6.contains(var7_8.c());
                if (!var9_5) {
                    if (!v0) continue;
                    var6_7.add(var7_8);
                    if (!var9_5) continue;
                }
                ** GOTO lbl26
            }
            var7_8 = var6_7.a();
            while (var7_8.f()) {
                var8_9 = var7_8.a();
                var2_2.add(var8_9);
                var1_1.d(var8_9);
                var7_8.g();
                if (!var9_5) {
                    if (!var9_5) continue;
                }
                break block8;
            }
            var6_7 = new f();
        }
        for (var7_8 = var4_4.f(); var7_8 != null; var7_8 = var7_8.g()) {
            v0 = var5_6.contains(var7_8.d());
lbl26: // 2 sources:
            if (!v0) continue;
            var6_7.add(var7_8);
            if (!var9_5) continue;
        }
        var7_8 = var6_7.a();
        while (var7_8.f()) {
            var8_9 = var7_8.a();
            var2_2.add(var8_9);
            var1_1.d(var8_9);
            var7_8.g();
            if (!var9_5) continue;
        }
lbl36: // 3 sources:
        var5_6 = var3_3.h(var4_4).a();
        do {
            if (var5_6.f() == false) return;
            var6_7 = var5_6.e();
            if (var3_3.d((y.c.q)var6_7)) {
                this.a(var1_1, var2_2, var3_3, (y.c.q)var6_7);
            }
            var5_6.g();
        } while (!var9_5);
    }

    private Set a(E e2, y.c.q q2) {
        if (!e2.k()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        e2.a(q2, (J)new T(this, q2, hashSet));
        return hashSet;
    }

    private void a(y.c.y y2, X x2, y.c.q q2, f f2, h h2, boolean bl2) {
        boolean bl3 = x;
        x x3 = y2.a();
        do {
            if (!x3.f()) return;
            y.c.q q3 = x3.e();
            if (q3 != q2) {
                d d2;
                block4 : {
                    if (bl2) {
                        d2 = x2.a(q2, q3);
                        if (!bl3) break block4;
                    }
                    d2 = x2.a(q3, q2);
                }
                f2.add(d2);
                h2.a((Object)d2, true);
            }
            x3.g();
        } while (!bl3);
    }

    private y.c.c j(X x2) {
        y.c.c c2 = this.d(x2);
        if (c2 == null) return null;
        return new az(c2, null);
    }

    protected y.c.c d(X x2) {
        return x2.c(n);
    }

    protected y.c.c e(X x2) {
        return x2.c(o);
    }

    protected y.c.c f(X x2) {
        return x2.c(p);
    }

    protected y.c.c g(X x2) {
        return x2.c(q);
    }

    private y.c.c a(X x2, y.c.c c2) {
        boolean bl2 = x;
        if (c2 == null) return null;
        y.c.c c3 = x2.c(y.f.b.f.b);
        y.c.c c4 = x2.c(y.f.b.f.c);
        y.c.c c5 = x2.c(y.f.b.f.d);
        if (c3 == null) return c2;
        if (c4 == null) return c2;
        if (c5 == null) return c2;
        aB aB2 = new aB(x2, c2, c5, null);
        aB2.a(x2, c3, c4);
        x x3 = aB2.a();
        while (x3.f()) {
            aB2.b(x3.e(), aB2.a(x3.e()));
            x3.g();
            if (bl2) return aB.a(aB2);
            if (!bl2) continue;
        }
        aB2.a(x2);
        return aB.a(aB2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void a(X x2, aP aP2) {
        boolean bl2 = x;
        y.f.b.c c2 = new y.f.b.c(x2);
        y.c.c c3 = x2.c(y.f.b.f.d);
        y.f.c.a.U u2 = new y.f.c.a.U(this, c2);
        x2.a(y.f.b.f.d, u2);
        try {
            block10 : {
                x x3 = x2.o();
                while (x3.f()) {
                    block9 : {
                        y.c.q q2 = x3.e();
                        aP2.c(q2);
                        for (d d2 = q2.f(); d2 != null; d2 = d2.g()) {
                            aP2.a(d2);
                            if (!bl2) {
                                if (!bl2) continue;
                            }
                            break block9;
                        }
                        x3.g();
                    }
                    if (!bl2) continue;
                    break;
                }
                Object var10_10 = null;
                if (c3 != null) {
                    x2.a(y.f.b.f.d, c3);
                    if (!bl2) break block10;
                }
                x2.d_(y.f.b.f.d);
            }
            c2.c();
            return;
        }
        catch (Throwable var9_12) {
            block11 : {
                Object var10_11 = null;
                if (c3 != null) {
                    x2.a(y.f.b.f.d, c3);
                    if (!bl2) break block11;
                }
                x2.d_(y.f.b.f.d);
            }
            c2.c();
            throw var9_12;
        }
    }

    protected bx z() {
        bT bT2 = new bT();
        bT2.a(this.E);
        return bT2;
    }

    protected aU a(aV aV2) {
        return new ac(aV2);
    }

    cd A() {
        return new cd();
    }

    bP a(aV aV2, aP aP2) {
        bP bP2 = new bP(aV2, aP2);
        bP2.a(this.E);
        return bP2;
    }

    E a(X x2, aV aV2, y.c.c c2) {
        E e2 = new E(x2, aV2, c2);
        Object object = this.a("GroupingSupport.minimumGroupDistance");
        if (!(object instanceof Number)) return e2;
        e2.a(((Number)object).doubleValue());
        return e2;
    }

    de B() {
        return new de();
    }

    cB a(F f2) {
        return new cB(f2);
    }

    db C() {
        return new db();
    }

    bR h(X x2) {
        if (x2.c(bw.a) == null) {
            return null;
        }
        boolean bl2 = Boolean.TRUE.equals(this.a("HierarchicLayouter.keepInterGroupConstraints"));
        return new dt(bl2);
    }

    dC a(bP bP2, E e2) {
        bY bY2 = new bY(bP2, e2);
        bY2.a(this.E);
        return bY2;
    }

    protected aT D() {
        return new m(new af());
    }

    dp E() {
        return new dp();
    }

    cq F() {
        return new cq();
    }

    protected C G() {
        return new y.f.c.a.ay();
    }

    /*
     * Unable to fully structure code
     */
    private static void a(br var0, X var1_1, aU var2_2, aV var3_3, aP var4_4) {
        var16_5 = N.x;
        if (var0 != null) {
            var0.optimizeAfterLayering(var1_1, var2_2, var3_3, var4_4);
        }
        var5_6 = aE.a(2, true);
        var6_7 = aE.a(1, true);
        var7_8 = aE.a(2, false);
        var8_9 = aE.a(1, false);
        var9_10 = var1_1.p();
        do {
            if (var9_10.f() == false) return;
            var10_11 = var9_10.a();
            var11_12 = var3_3.a(var10_11);
            var12_13 = var3_3.a(var10_11.c());
            var13_14 = var3_3.a(var10_11.d());
            var14_15 = var13_14.j() - var12_13.j();
            if (var14_15 == 0) ** GOTO lbl28
            var15_16 = var11_12.k();
            if (var12_13.b() != 0 || N.a(var10_11.c()) || var11_12.d() != null && var0 != null || var15_16 != null && var15_16.f() || var11_12.c() != null && !var11_12.c().g()) ** GOTO lbl23
            if (var11_12.c() == null || !var11_12.c().a()) ** GOTO lbl-1000
            var4_4.a(var10_11, true, var14_15 > 0 ? var5_6 : var6_7);
            if (var16_5) lbl-1000: // 2 sources:
            {
                var4_4.a(var10_11, true, var14_15 > 0 ? var7_8 : var8_9);
            }
lbl23: // 4 sources:
            if (var13_14.b() != 0 || var11_12.f() != null && var0 != null || N.a(var10_11.d()) || var15_16 != null && var15_16.g() || var11_12.e() != null && !var11_12.e().g()) ** GOTO lbl28
            if (var11_12.e() == null || !var11_12.e().a()) ** GOTO lbl-1000
            var4_4.a(var10_11, false, var14_15 > 0 ? var6_7 : var5_6);
            if (var16_5) lbl-1000: // 2 sources:
            {
                var4_4.a(var10_11, false, var14_15 > 0 ? var8_9 : var7_8);
            }
lbl28: // 5 sources:
            var9_10.g();
        } while (!var16_5);
    }

    private static boolean a(y.c.q q2) {
        y.c.c c2 = q2.e().c(ay.a);
        if (c2 == null) return false;
        if (c2.b(q2) == null) return false;
        return true;
    }

    private void b(br br2, X x2, aU aU2, aV aV2, aP aP2) {
        if (br2 == null) return;
        br2.optimizeAfterSequencing(x2, aU2, aV2, aP2);
    }

    /*
     * Unable to fully structure code
     */
    private ah a(X var1_1, aU var2_2, aV var3_3, y.c.c var4_4, E var5_5) {
        block25 : {
            var14_6 = N.x;
            var6_7 = new ah();
            var7_8 = var1_1.t();
            var8_9 = 0;
            block0 : do {
                v0 = var8_9;
                block1 : while (v0 < var2_2.b()) {
                    var9_12 = var2_2.a(var8_9);
                    var10_13 = var9_12.d();
                    v1 = var10_13.k();
                    if (var14_6) ** GOTO lbl94
                    for (var11_14 = v1165347; var11_14 != null; var11_14 = var11_14.a()) {
                        var12_15 = (y.c.q)var11_14.c();
                        var13_16 = var3_3.a(var12_15);
                        v0 = var13_16.b();
                        if (var14_6) continue block1;
                        if (v0 != 0 || var13_16.c().a() != 0 && var13_16.c().a() != 1) continue;
                        var7_8.a((Object)var12_15, true);
                        if (!var14_6) continue;
                    }
                    ++var8_9;
                    if (!var14_6) continue block0;
                }
                break block0;
                break;
            } while (true);
            var8_9 = 0;
            block3 : do {
                v2 = var8_9;
                block4 : while (v2 < var2_2.b()) {
                    var9_12 = var2_2.a(var8_9);
                    var10_13 = var9_12.d();
                    v1 = var10_13.k();
                    if (var14_6) ** GOTO lbl94
                    for (var11_14 = v1165347; var11_14 != null; var11_14 = var11_14.a()) {
                        var12_15 = (y.c.q)var11_14.c();
                        v2 = (int)N.b(var12_15, var3_3.a(var12_15), var3_3, var4_4, var7_8) ? 1 : 0;
                        if (var14_6) continue block4;
                        if (v2 == 0) continue;
                        var7_8.a((Object)var12_15, true);
                        if (!var14_6) continue;
                    }
                    ++var8_9;
                    if (!var14_6) continue block3;
                }
                break block3;
                break;
            } while (true);
            var8_9 = 0;
            block6 : do {
                v3 = var8_9;
                block7 : while (v3 < var2_2.b()) {
                    var9_12 = var2_2.a(var8_9);
                    var10_13 = var9_12.d();
                    v1 = var10_13.k();
                    if (var14_6) ** GOTO lbl94
                    for (var11_14 = v1165347; var11_14 != null; var11_14 = var11_14.a()) {
                        var12_15 = (y.c.q)var11_14.c();
                        v3 = (int)N.a(var12_15, var3_3.a(var12_15), var3_3, var4_4, var7_8) ? 1 : 0;
                        if (var14_6) continue block7;
                        if (v3 == 0) continue;
                        var7_8.a((Object)var12_15, true);
                        if (!var14_6) continue;
                    }
                    ++var8_9;
                    if (!var14_6) continue block6;
                }
                break block6;
                break;
            } while (true);
            var8_9 = 0;
            block9 : do {
                v4 = var8_9;
                block10 : while (v4 < var2_2.b()) {
                    var9_12 = var2_2.a(var8_9);
                    var10_13 = var9_12.d();
                    v1 = var10_13.k();
                    if (var14_6) ** GOTO lbl94
                    for (var11_14 = v1165347; var11_14 != null; var11_14 = var11_14.a()) {
                        var12_15 = (y.c.q)var11_14.c();
                        v4 = (int)N.c(var12_15, var3_3.a(var12_15), var3_3, var4_4, var7_8) ? 1 : 0;
                        if (var14_6) continue block10;
                        if (v4 == 0) continue;
                        var7_8.a((Object)var12_15, true);
                        if (!var14_6) continue;
                    }
                    ++var8_9;
                    if (!var14_6) continue block9;
                }
                break block9;
                break;
            } while (true);
            var5_5.b(var2_2, var7_8);
            var8_10 = var1_1.p();
            while (var8_10.f()) {
                var9_12 = var8_10.a();
                v5 = (int)var7_8.d(var9_12.c()) ? 1 : 0;
                if (!var14_6) {
                    if (v5 != 0 || var7_8.d(var9_12.d())) {
                        var1_1.d((d)var9_12);
                        var6_7.d.add(var9_12);
                    }
                    var8_10.g();
                    if (!var14_6) continue;
                }
                break block25;
            }
            v5 = 0;
        }
        var8_9 = v5;
        block13 : do {
            v6 = var8_9;
            block14 : while (v6 < var2_2.b()) {
                var9_12 = var2_2.a(var8_9);
                var10_13 = var9_12.d();
                v1 = var11_14 = var10_13.k();
lbl94: // 6 sources:
                while (var11_14 != null) {
                    var12_15 = (y.c.q)var11_14.c();
                    v6 = (int)var7_8.d(var12_15) ? 1 : 0;
                    if (var14_6) continue block14;
                    if (v6 != 0) {
                        block27 : {
                            block26 : {
                                for (var13_16 = var12_15.g(); var13_16 != null; var13_16 = var13_16.h()) {
                                    var1_1.d((d)var13_16);
                                    var6_7.d.add(var13_16);
                                    if (!var14_6) {
                                        if (!var14_6) continue;
                                    }
                                    break block26;
                                }
                                var13_16 = var12_15.f();
                            }
                            while (var13_16 != null) {
                                var1_1.d((d)var13_16);
                                var6_7.d.add(var13_16);
                                var13_16 = var13_16.g();
                                if (!var14_6) {
                                    if (!var14_6) continue;
                                }
                                break block27;
                            }
                            var1_1.c(var12_15);
                            var10_13.h(var11_14);
                        }
                        var6_7.b.add(var12_15);
                    }
                    var11_14 = var11_14.a();
                    if (!var14_6) continue;
                }
                ++var8_9;
                if (!var14_6) continue block13;
            }
            break block13;
            break;
        } while (true);
        var8_11 = var1_1.p();
        while (var8_11.f()) {
            var9_12 = var8_11.a();
            if (var14_6 != false) return var6_7;
            if (var4_4.b(var9_12) != null) {
                var1_1.d((d)var9_12);
                var6_7.d.add(var9_12);
            }
            var8_11.g();
            if (!var14_6) continue;
        }
        var5_5.c(var2_2);
        var1_1.a(var7_8);
        return var6_7;
    }

    private static final boolean a(y.c.q q2, aX aX2, aV aV2, y.c.c c2, y.c.A a2) {
        boolean bl2;
        boolean bl3;
        boolean bl4 = x;
        if (aX2.b() != 6) {
            if (aX2.b() != 7) return false;
            if (a2.d(q2)) {
                return true;
            }
            bl3 = false;
        } else {
            boolean bl5;
            if (a2.d(q2)) {
                return true;
            }
            boolean bl6 = false;
            for (d d2 = q2.g(); d2 != null; d2 = d2.h()) {
                boolean bl7;
                bl5 = bl7 = a2.d(d2.c());
                if (bl4) return bl5;
                if (!bl5) {
                    d d3 = aV2.a(d2).b();
                    boolean bl8 = bl7 = a2.d(d3.d()) || N.a(d3.c(), aV2.a(d3.c()), aV2, c2, a2);
                    if (!bl7) {
                        boolean bl9 = bl7 = c2.b(d3) != null;
                    }
                }
                if (bl7) {
                    bl6 = true;
                    if (!bl4) continue;
                }
                bl6 = false;
                if (!bl4) break;
                if (!bl4) continue;
            }
            bl5 = bl6;
            return bl5;
        }
        for (d d4 = q2.f(); d4 != null; d4 = d4.g()) {
            boolean bl10;
            bl2 = bl10 = a2.d(d4.d());
            if (bl4) return bl2;
            if (!bl2) {
                d d5 = aV2.a(d4).b();
                boolean bl11 = bl10 = a2.d(d5.c()) || N.a(d5.d(), aV2.a(d5.d()), aV2, c2, a2);
                if (!bl10) {
                    boolean bl12 = bl10 = c2.b(d5) != null;
                }
            }
            if (bl10) {
                bl3 = true;
                if (!bl4) continue;
            }
            bl3 = false;
            if (!bl4) break;
            if (!bl4) continue;
        }
        bl2 = bl3;
        return bl2;
    }

    private static final boolean b(y.c.q q2, aX aX2, aV aV2, y.c.c c2, y.c.A a2) {
        if (aX2.b() == 8) {
            boolean bl2 = a2.d(aX2.f()) || a2.d(aX2.g().c()) || a2.d(aX2.g().d());
            if (bl2) return bl2;
            d d2 = aX2.g();
            bl2 = c2.b(d2) != null;
            if (bl2) return bl2;
            A a3 = aV2.a(d2);
            if (a3 == null) return bl2;
            if (a3.b() == null) return bl2;
            if (c2.b(a3.b()) == null) return false;
            return true;
        }
        if (aX2.b() != 9) return false;
        boolean bl3 = a2.d(aX2.f()) || a2.d(aX2.g().c()) || a2.d(aX2.g().d());
        if (bl3) return bl3;
        d d3 = aX2.g();
        bl3 = c2.b(d3) != null;
        if (bl3) return bl3;
        A a4 = aV2.a(d3);
        if (a4 == null) return bl3;
        if (a4.b() == null) return bl3;
        if (c2.b(a4.b()) == null) return false;
        return true;
    }

    private static final boolean c(y.c.q q2, aX aX2, aV aV2, y.c.c c2, y.c.A a2) {
        Object object;
        boolean bl2 = x;
        boolean bl3 = false;
        switch (aX2.b()) {
            Object object2;
            Object object3;
            default: {
                return false;
            }
            case 8: {
                bl3 = a2.d(aX2.f());
                if (bl3) return bl3;
                object = aX2.g();
                object3 = (Z)c2.b(object);
                bl3 = object3 != null;
                if (bl3) return bl3;
                object2 = ((d)aX2.d().c()).c();
                bl3 = a2.d(object2);
                if (!bl2) return bl3;
            }
            case 9: {
                bl3 = a2.d(aX2.f());
                if (bl3) return bl3;
                object = aX2.g();
                object3 = (Z)c2.b(object);
                bl3 = object3 != null;
                if (bl3) return bl3;
                object2 = ((d)aX2.d().c()).d();
                bl3 = a2.d(object2);
                if (!bl2) return bl3;
            }
            case 10: {
                if (c2.b(aX2.g()) != null) {
                    return true;
                }
                object = aX2.d();
                object3 = (d)object.c();
                object2 = (Z)c2.b(object3);
                bl3 = object2 != null;
                if (bl3) return bl3;
                y.c.q q3 = object3.a(q2);
                bl3 = a2.d(q3);
                if (bl3) return bl3;
                object3 = (d)(object = object.a()).c();
                object2 = (Z)c2.b(object3);
                bl3 = object2 != null;
                if (bl3) return bl3;
                q3 = object3.a(q2);
                bl3 = a2.d(q3);
                if (!bl2) return bl3;
            }
            case 1: 
        }
        object = aX2.g();
        bl3 = c2.b(object) != null;
        if (bl3) return bl3;
        if (a2.d(object.c())) return true;
        if (!a2.d(object.d())) return false;
        return true;
    }

    private void a(ah ah2, a a2, X x2, aU aU2, aV aV2) {
        boolean bl2;
        int n2;
        int n3;
        block3 : {
            bl2 = x;
            for (n2 = 0; n2 < ah2.b.size(); ++n2) {
                y.c.q q2 = (y.c.q)ah2.b.get(n2);
                n3 = (int)x2.f(q2) ? 1 : 0;
                if (!bl2) {
                    if (n3 != 0) continue;
                    x2.d(q2);
                    aU2.a(aV2.a(q2).j()).a(q2);
                    a2.a((Object)q2, true);
                    if (!bl2) continue;
                }
                break block3;
            }
            n3 = 0;
        }
        n2 = n3;
        do {
            if (n2 >= ah2.d.size()) return;
            d d2 = (d)ah2.d.get(n2);
            x2.e(d2);
            x2.b(d2).clearPoints();
            ++n2;
        } while (!bl2);
    }

    protected void a(X x2, aU aU2) {
        boolean bl2 = x;
        y.c.c c2 = x2.c(r);
        if (c2 == null) return;
        int n2 = c2 instanceof a;
        int n3 = 0;
        int n4 = 0;
        do {
            block4 : {
                int n5 = n4;
                block1 : do {
                    if (n5 >= aU2.b()) return;
                    aQ aQ2 = aU2.a(n4);
                    if (aQ2.e() == 2 || aQ2.e() == 3) break block4;
                    for (p p2 = aQ2.d().k(); p2 != null; p2 = p2.a()) {
                        Object object;
                        y.c.q q2 = (y.c.q)p2.c();
                        n5 = n2;
                        if (bl2) continue block1;
                        if (n5 != 0) {
                            ((a)((Object)c2)).a((Object)q2, n3);
                            if (!bl2) continue;
                        }
                        if (!((object = c2.b(q2)) instanceof aO)) continue;
                        ((aO)object).a(n3);
                        if (!bl2) continue;
                    }
                    break;
                } while (true);
                ++n3;
            }
            ++n4;
        } while (!bl2);
    }

    protected void a(X x2, aU aU2, aV aV2) {
        boolean bl2 = x;
        y.c.c c2 = x2.c(s);
        if (c2 == null) return;
        boolean bl3 = c2 instanceof a;
        int n2 = 0;
        do {
            int n3 = n2;
            block1 : do {
                if (n3 >= aU2.b()) return;
                aQ aQ2 = aU2.a(n2);
                if (aQ2.e() == 2 || aQ2.e() == 3) break;
                int n4 = 0;
                for (p p2 = aQ2.d().k(); p2 != null; p2 = p2.a()) {
                    Object object;
                    y.c.q q2 = (y.c.q)p2.c();
                    aX aX2 = aV2.a(q2);
                    n3 = aX2.b();
                    if (bl2) continue block1;
                    if (n3 != 0) continue;
                    if (bl3) {
                        ((a)((Object)c2)).a((Object)q2, n4);
                        ++n4;
                        if (!bl2) continue;
                    }
                    if (!((object = c2.b(q2)) instanceof aO)) continue;
                    ((aO)object).a(n4);
                    ++n4;
                    if (!bl2) continue;
                }
                break;
            } while (true);
            ++n2;
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    private ah a(X var1_1, y.c.c var2_2, E var3_3, y.c.c var4_4) {
        block12 : {
            var10_5 = N.x;
            var5_6 = new ah();
            if (var2_2 == null) return var5_6;
            var6_7 = var1_1.o();
            while (var6_7.f()) {
                var7_10 = var6_7.e();
                if (var10_5 != false) return var5_6;
                if (var3_3 != null && var3_3.d(var7_10) || (var8_17 = (Z)var2_2.b(var7_10)) == null) ** GOTO lbl14
                if (var8_17.g != 0) ** GOTO lbl-1000
                var5_6.a.add(var7_10);
                if (var10_5) lbl-1000: // 2 sources:
                {
                    if (var8_17.g == 1) {
                        var5_6.b.add(var7_10);
                    }
                }
lbl14: // 6 sources:
                var6_7.g();
                if (!var10_5) continue;
            }
            var6_8 = 0;
            while (var6_8 < var5_6.a.size()) {
                block13 : {
                    var7_12 = (y.c.q)var5_6.a.get(var6_8);
                    v0 = var7_12.j();
                    if (var10_5) break block12;
                    var8_17 = v0;
                    while (var8_17.f()) {
                        var9_18 = var8_17.a();
                        var5_6.c.add(var9_18);
                        var1_1.d(var9_18);
                        var8_17.g();
                        if (!var10_5) {
                            if (!var10_5) continue;
                        }
                        break block13;
                    }
                    var1_1.c(var7_12);
                    ++var6_8;
                }
                if (!var10_5) continue;
            }
            var6_8 = 0;
            block3 : do {
                v1 = var6_8;
                block4 : while (v1 < var5_6.b.size()) {
                    var7_14 = (y.c.q)var5_6.b.get(var6_8);
                    v0 = var7_14.j();
                    if (var10_5) break block12;
                    var8_17 = v0;
                    while (var8_17.f()) {
                        var9_18 = var8_17.a();
                        v1 = (int)var4_4.d(var9_18) ? 1 : 0;
                        if (var10_5) continue block4;
                        if (v1 == 0) {
                            var5_6.d.add(var9_18);
                            var1_1.d(var9_18);
                        }
                        var8_17.g();
                        if (!var10_5) continue;
                    }
                    ++var6_8;
                    if (!var10_5) continue block3;
                }
                break block3;
                break;
            } while (true);
            v0 = var1_1.p();
        }
        var6_9 = v0;
        do {
            if (var6_9.f() == false) return var5_6;
            var7_16 = var6_9.a();
            var8_17 = (Z)var2_2.b(var7_16);
            if (var4_4.d(var7_16) || var8_17 == null) ** GOTO lbl67
            if (var8_17.g != 1) ** GOTO lbl-1000
            var5_6.d.add(var7_16);
            var1_1.d(var7_16);
            if (var10_5) lbl-1000: // 2 sources:
            {
                var5_6.c.add(var7_16);
                var1_1.d(var7_16);
            }
lbl67: // 4 sources:
            var6_9.g();
        } while (!var10_5);
        return var5_6;
    }

    private ah b(X x2, y.c.c c2) {
        y.c.e e2;
        ah ah2;
        boolean bl2;
        Object object;
        block7 : {
            bl2 = x;
            ah2 = new ah();
            if (c2 == null) return ah2;
            x x3 = x2.o();
            while (x3.f()) {
                y.c.q q2 = x3.e();
                object = (Z)c2.b(q2);
                if (bl2) return ah2;
                if (object != null && object.g == 0) {
                    ah2.a.add(q2);
                }
                x3.g();
                if (!bl2) continue;
            }
            int n2 = 0;
            while (n2 < ah2.a.size()) {
                block8 : {
                    y.c.q q2 = (y.c.q)ah2.a.get(n2);
                    e2 = q2.j();
                    if (bl2) break block7;
                    object = e2;
                    while (object.f()) {
                        d d2 = object.a();
                        ah2.c.add(d2);
                        x2.d(d2);
                        object.g();
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block8;
                    }
                    x2.c(q2);
                    ++n2;
                }
                if (!bl2) continue;
            }
            e2 = x2.p();
        }
        y.c.e e3 = e2;
        do {
            if (!e3.f()) return ah2;
            d d3 = e3.a();
            object = (Z)c2.b(d3);
            if (object != null && object.g != 1) {
                ah2.c.add(d3);
                x2.d(d3);
            }
            e3.g();
        } while (!bl2);
        return ah2;
    }

    /*
     * Unable to fully structure code
     */
    private void a(aT var1_1, X var2_2, aU var3_3, aV var4_4, ah var5_5, a var6_6, y.c.A var7_7) {
        var10_8 = N.x;
        for (y.c.q var9_11 : var5_5.a) {
            var2_2.d(var9_11);
            var6_6.a((Object)var9_11, true);
            if (!var10_8) continue;
        }
        var8_10 = 0;
        while (var8_10 < var5_5.c.size()) {
            v0 = var9_13 = (d)var5_5.c.get(var8_10);
            if (!var10_8) {
                if (v0 != null && var2_2.f(var9_13.c()) && var2_2.f(var9_13.d())) {
                    var2_2.e(var9_13);
                    var5_5.c.remove(var8_10);
                    if (!var10_8) continue;
                }
                ++var8_10;
                if (!var10_8) continue;
            }
            ** GOTO lbl25
        }
        if (var5_5.a.size() > 0) {
            if (var1_1 instanceof m) {
                ((m)var1_1).a(var7_7);
            }
            var1_1.a(var2_2, var3_3, var4_4);
        }
        var8_10 = 0;
        do lbl-1000: // 3 sources:
        {
            if (var8_10 >= var5_5.d.size()) return;
            v0 = (d)var5_5.d.get(var8_10);
lbl25: // 2 sources:
            if (!var2_2.f((var9_15 = v0).c()) || !var2_2.f(var9_15.d())) ** GOTO lbl29
            var2_2.e(var9_15);
            var5_5.d.remove(var8_10);
            if (!var10_8) ** GOTO lbl-1000
lbl29: // 2 sources:
            ++var8_10;
        } while (!var10_8);
    }

    /*
     * Unable to fully structure code
     */
    private void a(aT var1_1, X var2_2, aU var3_3, aV var4_4, ah var5_5, a var6_6, y.f.b.c var7_7, y.c.q var8_8) {
        var11_9 = N.x;
        for (y.c.q var10_12 : var5_5.a) {
            if (var7_7.a(var10_12) != var8_8) continue;
            var2_2.d(var10_12);
            var6_6.a((Object)var10_12, true);
            if (!var11_9) continue;
        }
        var9_11 = 0;
        while (var9_11 < var5_5.c.size()) {
            v0 = var10_14 = (d)var5_5.c.get(var9_11);
            if (!var11_9) {
                if (v0 != null && var2_2.f(var10_14.c()) && var2_2.f(var10_14.d())) {
                    var2_2.e(var10_14);
                    var5_5.c.remove(var9_11);
                    if (!var11_9) continue;
                }
                ++var9_11;
                if (!var11_9) continue;
            }
            ** GOTO lbl24
        }
        if (var5_5.a.size() > 0) {
            var1_1.a(var2_2, var3_3, var4_4);
        }
        var9_11 = 0;
        do lbl-1000: // 3 sources:
        {
            if (var9_11 >= var5_5.d.size()) return;
            v0 = (d)var5_5.d.get(var9_11);
lbl24: // 2 sources:
            if (!var2_2.f((var10_16 = v0).c()) || !var2_2.f(var10_16.d())) ** GOTO lbl28
            var2_2.e(var10_16);
            var5_5.d.remove(var9_11);
            if (!var11_9) ** GOTO lbl-1000
lbl28: // 2 sources:
            ++var9_11;
        } while (!var11_9);
    }

    protected void i(X x2) {
        boolean bl2 = x;
        y.c.e e2 = x2.p();
        block0 : do {
            if (!e2.f()) return;
            d d2 = e2.a();
            I i2 = x2.g(d2);
            if (i2.pointCount() > 0) {
                int n2;
                ArrayList<t> arrayList = new ArrayList<t>(i2.pointCount());
                v v2 = x2.l(d2);
                y.c.C c2 = v2.a();
                t t2 = (t)c2.d();
                c2.g();
                double d3 = t2.a();
                double d4 = t2.b();
                if (c2.f()) {
                    t2 = (t)c2.d();
                    double d5 = t2.a();
                    double d6 = t2.b();
                    c2.g();
                    while (c2.f()) {
                        t t3 = (t)c2.d();
                        double d7 = t3.a();
                        double d8 = t3.b();
                        double d9 = (d3 - d7) * (d6 - d8) / (d4 - d8) + d7;
                        n2 = (int)(Math.abs(d9 - d5) DCMPL 0.5);
                        if (!bl2) {
                            if (n2 > 0) {
                                arrayList.add(t2);
                                d3 = d5;
                                d4 = d6;
                            }
                            t2 = t3;
                            d5 = d7;
                            d6 = d8;
                            c2.g();
                            if (!bl2) continue;
                        }
                        break;
                    }
                } else {
                    n2 = arrayList.size();
                }
                if (n2 < i2.pointCount()) {
                    i2.clearPoints();
                    for (int i3 = 0; i3 < arrayList.size(); ++i3) {
                        t t4 = (t)arrayList.get(i3);
                        i2.addPoint(t4.a, t4.b);
                        if (bl2) continue block0;
                        if (!bl2) continue;
                    }
                }
            }
            e2.g();
        } while (!bl2);
    }

    private boolean H() {
        return Boolean.TRUE.equals(this.a("y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.enabled"));
    }

    private boolean I() {
        return Boolean.TRUE.equals(this.a("y.layout.hierarchic.incremental.HierarchicLayouter.considerGroupNodeEdges"));
    }

    private boolean J() {
        return Boolean.TRUE.equals(this.a("y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.compactionEnabled"));
    }

    private boolean K() {
        return Boolean.TRUE.equals(this.a("y.layout.hierarchic.incremental.HierarchicLayouter.useAspectRatioLayerer"));
    }

    private byte L() {
        return ((Number)this.a("y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.alignment")).byteValue();
    }

    /*
     * Exception decompiling
     */
    private y.g.I a(X var1_1, bk var2_2, y.c.A var3_3, y.c.A var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [11[SIMPLE_IF_TAKEN]], but top level block is 2[WHILELOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
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

    static void a(N n2, X x2, y.c.c c2, aT aT2, aU aU2, aV aV2, aT aT3, y.c.A a2, E e2) {
        n2.a(x2, c2, aT2, aU2, aV2, aT3, a2, e2);
    }

    static byte a(N n2) {
        return n2.L();
    }

    static ah a(N n2, X x2, y.c.c c2) {
        return n2.b(x2, c2);
    }

    static void a(N n2, X x2, aU aU2) {
        n2.b(x2, aU2);
    }

    static void a(N n2, aT aT2, X x2, aU aU2, aV aV2, ah ah2, a a2, y.f.b.c c2, y.c.q q2) {
        n2.a(aT2, x2, aU2, aV2, ah2, a2, c2, q2);
    }

    static void a(N n2, aT aT2, X x2, aU aU2, aV aV2, ah ah2, a a2, y.c.A a3) {
        n2.a(aT2, x2, aU2, aV2, ah2, a2, a3);
    }
}

