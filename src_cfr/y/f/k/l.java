/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import y.a.A;
import y.a.g;
import y.c.D;
import y.c.c;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.t;
import y.f.I;
import y.f.X;
import y.f.aN;
import y.f.ad;
import y.f.ah;
import y.f.am;
import y.f.k.M;
import y.f.k.N;
import y.f.k.d;

public class L
implements ad {
    public static final Object a = "y.layout.tree.TreeComponentLayouter.DUMMY_NODE_DPKEY";
    private ah b;
    private ah c;
    private boolean d;

    public L(ah ah2) {
        this.c = ah2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void c(X var1_1) {
        block49 : {
            block47 : {
                block46 : {
                    var38_2 = d.g;
                    var2_3 = A.a(var1_1);
                    if (var2_3.length == 1 && var2_3[0].size() == var1_1.f()) {
                        if (g.e(var1_1)) {
                            this.c.c(var1_1);
                            if (var38_2 == 0) return;
                        }
                        new aN(this.c).c(var1_1);
                        return;
                    }
                    if (g.d(var1_1)) {
                        this.c.c(var1_1);
                        return;
                    }
                    var3_4 = var1_1.p();
                    while (var3_4.f()) {
                        v0 = var1_1;
                        if (var38_2 == 0) {
                            v0.c(var3_4.a());
                            var3_4.g();
                            if (var38_2 == 0) continue;
                        }
                        break block46;
                    }
                    v0 = var1_1;
                }
                var3_4 = A.a(v0);
                var4_5 = var1_1.p();
                while (var4_5.f()) {
                    var1_1.c(var4_5.a());
                    var4_5.g();
                    if (var38_2 == 0) {
                        if (var38_2 == 0) continue;
                    }
                    break block47;
                }
                if (var3_4.length == 1 && var3_4[0].size() == var1_1.f()) {
                    if (g.e(var1_1)) {
                        this.c.c(var1_1);
                        if (var38_2 == 0) return;
                    }
                    new aN(this.c).c(var1_1);
                    return;
                }
            }
            var4_5 = new y.g.I(var1_1);
            var5_6 = new HashSet<Object>();
            var6_7 = A.a((i)var1_1, var2_3);
            var7_8 = new ArrayList<Object>();
            var4_5.a();
            var8_9 = 0;
            block2 : do {
                v1 = var8_9;
                block3 : while (v1 < var2_3.length) {
                    var9_11 = var2_3[var8_9];
                    var10_13 = var6_7[var8_9];
                    var11_15 = var9_11.b();
                    v2 = var9_11.size();
                    v3 = 2;
                    if (var38_2 != 0) ** GOTO lbl112
                    if (v2 > v3) {
                        y.g.I.a(var1_1, var10_13.a());
                        var12_18 = var1_1.a();
                        this.c.c(var1_1);
                        var15_22 = Double.MAX_VALUE;
                        var13_19 = Double.MAX_VALUE;
                        var19_30 = -1.7976931348623157E308;
                        var17_26 = -1.7976931348623157E308;
                        var21_33 = var9_11.a();
                        var21_33.g();
                        while (var21_33.f()) {
                            var22_36 = var1_1.a(var21_33.e());
                            var13_19 = Math.min(var13_19, var22_36.getX());
                            var15_22 = Math.min(var15_22, var22_36.getY());
                            var17_26 = Math.max(var17_26, var22_36.getX() + var22_36.getWidth());
                            var19_30 = Math.max(var19_30, var22_36.getY() + var22_36.getHeight());
                            var21_33.g();
                            if (var38_2 != 0) continue block2;
                            if (var38_2 == 0) continue;
                        }
                        var22_36 = var10_13.a();
                        while (var22_36.f()) {
                            block48 : {
                                var23_37 = var1_1.b(var22_36.a());
                                v1 = 0;
                                if (var38_2 != 0) continue block3;
                                for (var24_40 = v2038382; var24_40 < var23_37.pointCount(); ++var24_40) {
                                    var25_42 = var23_37.getPoint(var24_40);
                                    var13_19 = Math.min(var13_19, var25_42.a);
                                    var15_22 = Math.min(var15_22, var25_42.b);
                                    var17_26 = Math.max(var17_26, var25_42.a);
                                    var19_30 = Math.max(var19_30, var25_42.b);
                                    if (var38_2 == 0) {
                                        if (var38_2 == 0) continue;
                                    }
                                    break block48;
                                }
                                var22_36.g();
                            }
                            if (var38_2 == 0) continue;
                        }
                        var21_33 = var9_11.a();
                        var21_33.g();
                        var22_36 = var1_1.d();
                        var5_6.add(var22_36);
                        var23_37 = var1_1.a(var22_36);
                        var23_37.setSize(var17_26 - var13_19, var19_30 - var15_22);
                        var23_37.setLocation(var12_18.x, var12_18.y);
                        var24_41 = var1_1.a(var9_11.b(), (q)var22_36);
                        var4_5.a((y)var9_11);
                        var4_5.a();
                        var25_42 = new N();
                        var25_42.b = var24_41;
                        var25_42.a = var22_36;
                        var25_42.c = new Rectangle2D.Double(var13_19, var15_22, var17_26 - var13_19, var19_30 - var15_22);
                        var25_42.d = var9_11;
                        var25_42.e = var6_7[var8_9];
                        var7_8.add(var25_42);
                    }
                    ++var8_9;
                    if (var38_2 == 0) continue block2;
                }
                break block2;
                break;
            } while (true);
            var4_5.f();
            var8_9 = 0;
            block7 : do {
                v2 = var8_9;
                v3 = var7_8.size();
lbl112: // 2 sources:
                if (v2 >= v3) break;
                var9_11 = (N)var7_8.get(var8_9);
                var10_13 = var9_11.d.a();
                var10_13.g();
                while (var10_13.f()) {
                    var4_5.a(var10_13.e());
                    var10_13.g();
                    if (var38_2 != 0) continue block7;
                    if (var38_2 == 0) continue;
                }
                ++var8_9;
            } while (var38_2 == 0);
            var8_10 = new M(var5_6);
            this.a(var1_1, var8_10);
            var4_5.f();
            var9_12 = 0;
            var10_14 = 0;
            var11_16 = 0;
            block9 : do {
                v4 = var11_16;
                block10 : while (v4 < var7_8.size()) {
                    var12_18 = (N)var7_8.get(var11_16);
                    var13_21 = var1_1.b(var12_18.b).getSourcePoint();
                    var14_43 = var1_1.b(var12_18.b);
                    v5 = var14_43.pointCount();
                    if (var38_2 != 0) break block49;
                    if (v5 <= 0) ** GOTO lbl-1000
                    var16_44 = var1_1.p(var12_18.b);
                    var17_27 = var14_43.getPoint(0);
                    v6 = var15_24 = Math.abs(var16_44.a - var17_27.a) > Math.abs(var16_44.b - var17_27.b);
                    if (var38_2 != 0) lbl-1000: // 2 sources:
                    {
                        var16_44 = var1_1.p(var12_18.b);
                        var17_27 = var1_1.q(var12_18.b);
                        var15_24 = Math.abs(var16_44.a - var17_27.a) > Math.abs(var16_44.b - var17_27.b);
                    }
                    var16_44 = var1_1.a(var12_18.a);
                    var17_26 = var12_18.c.getCenterX();
                    var19_30 = var12_18.c.getCenterY();
                    var21_35 = var16_44.getX() + var16_44.getWidth() / 2.0;
                    var23_39 = var16_44.getY() + var16_44.getHeight() / 2.0;
                    var25_42 = var12_18.d.a();
                    var26_45 = var1_1.a(var25_42.e());
                    var27_46 = var1_1.q((y.c.d)var12_18.b).a < var1_1.p((y.c.d)var12_18.b).a ? 1 : 0;
                    var28_47 = var1_1.q((y.c.d)var12_18.b).b < var1_1.p((y.c.d)var12_18.b).b;
                    var1_1.a(var12_18.b);
                    var9_12 += var27_46 != 0 ? - var12_18.d.size() : var12_18.d.size();
                    var10_14 += var28_47 != false ? - var12_18.d.size() : var12_18.d.size();
                    var25_42.g();
                    while (var25_42.f()) {
                        block51 : {
                            block50 : {
                                var29_48 = var1_1.a(var25_42.e());
                                var30_50 = var29_48.getX() + var29_48.getWidth() / 2.0;
                                var32_52 = var29_48.getY() + var29_48.getHeight() / 2.0;
                                v4 = var27_46;
                                if (var38_2 != 0) continue block10;
                                if (v4 != 0) {
                                    var30_50 = var21_35 - (var30_50 - var17_26);
                                    if (var38_2 == 0) break block50;
                                }
                                var30_50 = var21_35 + (var30_50 - var17_26);
                            }
                            if (var28_47) {
                                var32_52 = var23_39 - (var32_52 - var19_30);
                                if (var38_2 == 0) break block51;
                            }
                            var32_52 = var23_39 + (var32_52 - var19_30);
                        }
                        var29_48.setLocation(var30_50 - var29_48.getWidth() / 2.0, var32_52 - var29_48.getHeight() / 2.0);
                        var25_42.g();
                        if (var38_2 == 0) continue;
                    }
                    var29_48 = new ArrayList<E>(6);
                    var30_49 = var12_18.e.a();
                    while (var30_49.f()) {
                        block54 : {
                            var29_48.clear();
                            var31_51 = var1_1.b(var30_49.a());
                            var29_48.clear();
                            v4 = 0;
                            if (var38_2 != 0) continue block10;
                            for (var32_53 = v2038576; var32_53 < var31_51.pointCount(); ++var32_53) {
                                var33_55 = var31_51.getPoint(var32_53);
                                var34_56 = var33_55.a;
                                var36_59 = var33_55.b;
                                v7 = var27_46;
                                if (var38_2 == 0) {
                                    block53 : {
                                        block52 : {
                                            if (v7 != 0) {
                                                var34_56 = var21_35 - (var34_56 - var17_26);
                                                if (var38_2 == 0) break block52;
                                            }
                                            var34_56 = var21_35 + (var34_56 - var17_26);
                                        }
                                        if (var28_47) {
                                            var36_59 = var23_39 - (var36_59 - var19_30);
                                            if (var38_2 == 0) break block53;
                                        }
                                        var36_59 = var23_39 + (var36_59 - var19_30);
                                    }
                                    var29_48.add(new t(var34_56, var36_59));
                                    if (var38_2 == 0) continue;
                                }
                                break block54;
                            }
                            var31_51.clearPoints();
                            v7 = var32_53 = 0;
                        }
                        while (var32_53 < var29_48.size()) {
                            var33_55 = (t)var29_48.get(var32_53);
                            var31_51.addPoint(var33_55.a, var33_55.b);
                            ++var32_53;
                            if (var38_2 == 0) {
                                if (var38_2 == 0) continue;
                            }
                            ** GOTO lbl-1000
                        }
                        if (var30_49.a().c() == var12_18.d.b()) {
                            block55 : {
                                var32_54 = var31_51.getTargetPoint();
                                var31_51.setTargetPoint(new t(var27_46 != 0 ? - var32_54.a : var32_54.a, var28_47 != false ? - var32_54.b : var32_54.b));
                                var31_51.setSourcePoint(var13_21);
                                var33_55 = var1_1.p(var30_49.a());
                                var34_57 = var31_51.pointCount() > 0 ? var31_51.getPoint(0) : var1_1.q(var30_49.a());
                                var35_58 = var1_1.k(var30_49.a());
                                if (var15_24) {
                                    var35_58.a(new t(var34_57.a, var33_55.b));
                                    if (var38_2 == 0) break block55;
                                }
                                var35_58.a(new t(var33_55.a, var34_57.b));
                            }
                            var1_1.b(var30_49.a(), var35_58);
                        } else lbl-1000: // 2 sources:
                        {
                            var32_54 = var31_51.getSourcePoint();
                            var31_51.setSourcePoint(new t(var27_46 != 0 ? - var32_54.a : var32_54.a, var28_47 != false ? - var32_54.b : var32_54.b));
                        }
                        var30_49.g();
                        if (var38_2 == 0) continue;
                    }
                    var1_1.a(var12_18.a);
                    ++var11_16;
                    if (var38_2 == 0) continue block9;
                }
                break block9;
                break;
            } while (true);
            v5 = this.b();
        }
        if (v5 != 0 && (var9_12 < 0 || var10_14 < 0)) {
            var11_17 = var1_1.o();
            while (var11_17.f()) {
                block56 : {
                    var12_18 = var11_17.e();
                    var13_20 = var1_1.a(var12_18);
                    if (var38_2 != 0) return;
                    if (var9_12 < 0) {
                        var13_20.setLocation(- var13_20.getX() - var13_20.getWidth(), var13_20.getY());
                    }
                    if (var10_14 < 0) {
                        var13_20.setLocation(var13_20.getX(), - var13_20.getY() - var13_20.getHeight());
                    }
                    var14_43 = var12_18.l();
                    while (var14_43.f()) {
                        var15_25 = var14_43.a();
                        var16_44 = var1_1.b(var15_25);
                        var17_29 = var16_44.getSourcePoint();
                        if (var38_2 == 0) {
                            var16_44.setSourcePoint(new t(var9_12 < 0 ? - var17_29.a : var17_29.a, var10_14 < 0 ? - var17_29.b : var17_29.b));
                            var17_29 = var16_44.getTargetPoint();
                            var16_44.setTargetPoint(new t(var9_12 < 0 ? - var17_29.a : var17_29.a, var10_14 < 0 ? - var17_29.b : var17_29.b));
                            var17_29 = var1_1.k(var15_25);
                            v8 = var18_60 = var17_29.k();
                            while (var18_60 != null) {
                                var19_32 = (t)var18_60.c();
                                v8 = var18_60;
                                if (var38_2 != 0) continue;
                                v8.a(new t(var9_12 < 0 ? - var19_32.a : var19_32.a, var10_14 < 0 ? - var19_32.b : var19_32.b));
                                var18_60 = var18_60.a();
                                if (var38_2 == 0) continue;
                            }
                            var1_1.b(var15_25, (D)var17_29);
                            var14_43.g();
                            if (var38_2 == 0) continue;
                        }
                        break block56;
                    }
                    var11_17.g();
                }
                if (var38_2 == 0) continue;
            }
        }
        var7_8.clear();
    }

    protected void a(X x2, c c2) {
        ah ah2 = this.a();
        x2.a(a, c2);
        ah2.c(x2);
        x2.d_(a);
    }

    @Override
    public ah a() {
        return this.b;
    }

    @Override
    public void a(ah ah2) {
        this.b = ah2;
    }

    public boolean b() {
        return this.d;
    }

    public void a(boolean bl2) {
        this.d = bl2;
    }
}

