/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.p;
import y.c.q;
import y.c.x;
import y.d.t;
import y.d.y;
import y.f.X;
import y.f.a;
import y.f.ah;
import y.f.am;

public class aN
extends a {
    private f b = new f();
    public static final Object a = "y.layout.SelfLoopLayouter.KEEP_SELF_LOOP_LAYOUT_DPKEY";
    private byte c = 0;
    private boolean d = true;
    private double e = 5.0;
    private int f = 2;
    private Map g;
    private int h = 0;
    private int i = 1;
    private int n = 2;
    private int o = 3;
    private boolean p;

    public aN() {
    }

    public aN(ah ah2) {
        this();
        this.a(ah2);
    }

    public void a(boolean bl2) {
        this.d = bl2;
    }

    public void a(byte by2) {
        this.c = by2;
    }

    @Override
    public void c(X x2) {
        block6 : {
            boolean bl2 = X.j;
            c c2 = x2.c(a);
            if (c2 != null || this.p) {
                this.g = new HashMap();
                x x3 = x2.o();
                while (x3.f()) {
                    this.g.put(x3.e(), x2.l(x3.e()));
                    x3.g();
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break;
                }
            } else if (this.a() != null) {
                this.d(x2);
                this.a(x2);
                this.e(x2);
                this.b(x2);
                if (!bl2) break block6;
            }
            this.b(x2);
        }
        this.g = null;
    }

    /*
     * Unable to fully structure code
     */
    private D a(int var1_1, t var2_2, double var3_3, boolean var5_4, int var6_5) {
        var16_6 = X.j;
        var7_7 = new D();
        if (var1_1 != this.h) ** GOTO lbl6
        var8_8 = 3 * (var6_5 - 1);
        if (!var16_6) ** GOTO lbl13
lbl6: // 2 sources:
        if (var1_1 != this.i) ** GOTO lbl9
        var8_8 = 2 * (var6_5 - 1);
        if (!var16_6) ** GOTO lbl13
lbl9: // 2 sources:
        if (var1_1 != this.n) ** GOTO lbl-1000
        var8_8 = var6_5 - 1;
        if (var16_6) lbl-1000: // 2 sources:
        {
            var8_8 = 0;
        }
lbl13: // 5 sources:
        var9_9 = 3.141592653589793 / (double)(2 * (var6_5 - 1));
        if (!var5_4) ** GOTO lbl22
        for (var11_10 = var8_8; var11_10 < var8_8 + var6_5; ++var11_10) {
            var12_11 = Math.cos((double)var11_10 * var9_9) * var3_3 + var2_2.a();
            var14_12 = Math.sin((double)var11_10 * var9_9) * var3_3 + var2_2.b();
            v0 = var7_7;
            if (var16_6 != false) return v0;
            v0.add(new t(var12_11, var14_12));
            if (!var16_6) continue;
lbl22: // 3 sources:
            for (var11_10 = var8_8 + var6_5 - 1; var11_10 >= var8_8; --var11_10) {
                var12_11 = Math.cos((double)var11_10 * var9_9) * var3_3 + var2_2.a();
                var14_12 = Math.sin((double)var11_10 * var9_9) * var3_3 + var2_2.b();
                v0 = var7_7;
                if (var16_6 != false) return v0;
                v0.add(new t(var12_11, var14_12));
                if (!var16_6) continue;
            }
        }
        v0 = var7_7;
        return v0;
    }

    /*
     * Unable to fully structure code
     */
    protected void b(X var1_1) {
        var46_2 = X.j;
        if (this.g == null && !this.p) ** GOTO lbl32
        var2_3 = var1_1.o();
        block0 : do {
            v0 = var2_3.f();
            block1 : while (v0) {
                var3_4 = var1_1.l(var2_3.e());
                var4_5 = (t)this.g.get(var2_3.e());
                v1 = var3_4.equals(var4_5);
                if (var46_2) ** GOTO lbl35
                if (!v1 && var4_5 != null) {
                    var5_6 = var3_4.a - var4_5.a;
                    var7_9 = var3_4.b - var4_5.b;
                    var9_11 = var2_3.e().k();
                    while (var9_11.f()) {
                        block21 : {
                            v0 = var9_11.a().e();
                            if (var46_2) continue block1;
                            if (v0 && !this.a(var1_1, var9_11.a()) && (var10_12 = var1_1.k(var9_11.a())).size() > 0) {
                                for (var11_14 = var10_12.k(); var11_14 != null; var11_14 = var11_14.a()) {
                                    var12_15 = (t)var11_14.c();
                                    var12_15 = new t(var12_15.a + var5_6, var12_15.b + var7_9);
                                    var11_14.a(var12_15);
                                    if (!var46_2) {
                                        if (!var46_2) continue;
                                    }
                                    break block21;
                                }
                                var1_1.b(var9_11.a(), var10_12);
                            }
                            var9_11.g();
                        }
                        if (!var46_2) continue;
                    }
                }
                var2_3.g();
                if (!var46_2) continue block0;
            }
            break block0;
            break;
        } while (true);
lbl32: // 3 sources:
        var2_3 = var1_1.o();
        do {
            block22 : {
                v1 = var2_3.f();
lbl35: // 2 sources:
                if (v1 == false) return;
                var3_4 = var2_3.e();
                var4_5 = new f();
                var5_7 = var3_4.l();
                while (var5_7.f()) {
                    var6_18 = var5_7.a();
                    v2 = var6_18.e();
                    if (!var46_2) {
                        if (v2 && this.a(var1_1, (d)var6_18)) {
                            var4_5.add(var6_18);
                        }
                        var5_7.g();
                        if (!var46_2) continue;
                    }
                    break block22;
                }
                v2 = var4_5.isEmpty();
            }
            if (v2) ** GOTO lbl208
            var5_8 = var4_5.size();
            var6_18 = var4_5.e();
            var7_10 = var1_1.h((q)var3_4);
            var8_19 = var7_10.getX();
            var10_13 = var7_10.getY();
            var12_17 = var7_10.getX() + var7_10.getWidth();
            var14_20 = var7_10.getY() + var7_10.getHeight();
            var16_21 = var7_10.getWidth() * 0.5;
            var18_22 = var7_10.getHeight() * 0.5;
            var20_23 = Math.min(var16_21 / (double)(var5_8 + 1), this.e);
            var22_24 = Math.min(var18_22 / (double)(var5_8 + 1), this.e);
            var24_25 = Math.min(var22_24, var20_23);
            var26_26 = (var16_21 - (double)(var5_8 - 1) * var24_25) / 2.0;
            var28_27 = (var18_22 - (double)(var5_8 - 1) * var24_25) / 2.0;
            v3 = this.c;
            v4 = 1;
            block6 : do lbl-1000: // 5 sources:
            {
                if (v3 == v4) {
                    var26_26 = (var16_21 - (double)(var5_8 - 1) * var20_23) / 2.0;
                    var28_27 = (var18_22 - (double)(var5_8 - 1) * var22_24) / 2.0;
                }
                var30_28 = 6.0;
                var32_29 = 12.0;
                var34_30 = var30_28 + Math.max(15.0, var30_28 + var32_29 - var28_27);
                var36_31 = var30_28 + Math.max(15.0, var30_28 + var32_29 - var26_26);
                var38_32 = this.a(var1_1, (q)var3_4);
                if (this.d && var38_32 != this.i) ** GOTO lbl109
                for (var39_33 = 0; var39_33 < var6_18.length; ++var39_33) {
                    var40_34 = var6_18[var39_33];
                    v3 = this.c;
                    v4 = 1;
                    if (var46_2) ** GOTO lbl-1000
                    if (v3 == v4) {
                        var41_35 = new t[5];
                        var41_35[0] = new t(var8_19 + var26_26 + (double)var39_33 * var20_23, var10_13);
                        var41_35[1] = new t(var41_35[0].a(), var10_13 - var34_30 - (double)var39_33 * this.e);
                        var41_35[4] = new t(var8_19, var10_13 + var28_27 + (double)var39_33 * var22_24);
                        var41_35[3] = new t(var8_19 - var36_31 - (double)var39_33 * this.e, var41_35[4].b());
                        var41_35[2] = new t(var41_35[3].a(), var41_35[1].b());
                        var42_40 = var30_28 + 0.25 * (double)var39_33 * (var20_23 + var22_24);
                        var44_42 = new D();
                        var44_42.add(var41_35[0]);
                        var44_42.a(this.a(var41_35[1], var42_40, this.h, false, this.f));
                        var44_42.a(this.a(var41_35[2], var42_40, this.i, false, this.f));
                        var44_42.a(this.a(var41_35[3], var42_40, this.n, false, this.f));
                        var44_42.add(var41_35[4]);
                        var1_1.a(var40_34, (D)var44_42);
                        if (!var46_2) continue;
                    }
                    var41_36 = (double)var39_33 * var24_25;
                    var43_41 = new D();
                    var44_42 = new t(var8_19 + var26_26 + var41_36, var10_13);
                    var43_41.add(var44_42);
                    var43_41.add(new t(var8_19 + var26_26 + var41_36, var10_13 - 15.0 - var41_36));
                    var43_41.add(new t(var8_19 - 15.0 - var41_36, var10_13 - 15.0 - var41_36));
                    var43_41.add(new t(var8_19 - 15.0 - var41_36, var10_13 + var28_27 + var41_36));
                    var45_43 = new t(var8_19, var10_13 + var28_27 + var41_36);
                    var43_41.add(var45_43);
                    var1_1.a(var40_34, var43_41);
                    if (!var46_2) continue;
lbl109: // 2 sources:
                    if (var38_32 != this.n) ** GOTO lbl142
                    for (var39_33 = 0; var39_33 < var6_18.length; ++var39_33) {
                        var40_34 = var6_18[var39_33];
                        v3 = this.c;
                        v4 = 1;
                        if (var46_2) ** GOTO lbl-1000
                        if (v3 == v4) {
                            var41_35 = new t[5];
                            var41_35[0] = new t(var8_19 + var26_26 + (double)var39_33 * var20_23, var14_20);
                            var41_35[1] = new t(var41_35[0].a(), var14_20 + var34_30 + (double)var39_33 * this.e);
                            var41_35[4] = new t(var8_19, var14_20 - var28_27 - (double)var39_33 * var22_24);
                            var41_35[3] = new t(var8_19 - var36_31 - (double)var39_33 * this.e, var41_35[4].b());
                            var41_35[2] = new t(var41_35[3].a(), var41_35[1].b());
                            var42_40 = var30_28 + 0.25 * (double)var39_33 * (var20_23 + var22_24);
                            var44_42 = new D();
                            var44_42.add(var41_35[0]);
                            var44_42.a(this.a(var41_35[1], var42_40, this.o, true, this.f));
                            var44_42.a(this.a(var41_35[2], var42_40, this.n, true, this.f));
                            var44_42.a(this.a(var41_35[3], var42_40, this.i, true, this.f));
                            var44_42.add(var41_35[4]);
                            var1_1.a(var40_34, (D)var44_42);
                            if (!var46_2) continue;
                        }
                        var41_37 = (double)var39_33 * var24_25;
                        var43_41 = new D();
                        var44_42 = new t(var8_19 + var26_26 + var41_37, var14_20);
                        var43_41.add(var44_42);
                        var43_41.add(new t(var8_19 + var26_26 + var41_37, var14_20 + 15.0 + var41_37));
                        var43_41.add(new t(var8_19 - 15.0 - var41_37, var14_20 + 15.0 + var41_37));
                        var43_41.add(new t(var8_19 - 15.0 - var41_37, var14_20 - var28_27 - var41_37));
                        var45_43 = new t(var8_19, var14_20 - var28_27 - var41_37);
                        var43_41.add(var45_43);
                        var1_1.a(var40_34, var43_41);
                        if (!var46_2) continue;
lbl142: // 2 sources:
                        if (var38_32 != this.h) ** GOTO lbl175
                        for (var39_33 = 0; var39_33 < var6_18.length; ++var39_33) {
                            var40_34 = var6_18[var39_33];
                            v3 = this.c;
                            v4 = 1;
                            if (var46_2) ** GOTO lbl-1000
                            if (v3 == v4) {
                                var41_35 = new t[5];
                                var41_35[0] = new t(var12_17 - var26_26 - (double)var39_33 * var20_23, var10_13);
                                var41_35[1] = new t(var41_35[0].a(), var10_13 - var34_30 - (double)var39_33 * this.e);
                                var41_35[4] = new t(var12_17, var10_13 + var28_27 + (double)var39_33 * var22_24);
                                var41_35[3] = new t(var12_17 + var36_31 + (double)var39_33 * this.e, var41_35[4].b());
                                var41_35[2] = new t(var41_35[3].a(), var41_35[1].b());
                                var42_40 = var30_28 + 0.25 * (double)var39_33 * (var20_23 + var22_24);
                                var44_42 = new D();
                                var44_42.add(var41_35[0]);
                                var44_42.a(this.a(var41_35[1], var42_40, this.i, true, this.f));
                                var44_42.a(this.a(var41_35[2], var42_40, this.h, true, this.f));
                                var44_42.a(this.a(var41_35[3], var42_40, this.o, true, this.f));
                                var44_42.add(var41_35[4]);
                                var1_1.a(var40_34, (D)var44_42);
                                if (!var46_2) continue;
                            }
                            var41_38 = (double)var39_33 * var24_25;
                            var43_41 = new D();
                            var44_42 = new t(var12_17 - var26_26 - var41_38, var10_13);
                            var43_41.add(var44_42);
                            var43_41.add(new t(var12_17 - var26_26 - var41_38, var10_13 - 15.0 - var41_38));
                            var43_41.add(new t(var12_17 + 15.0 + var41_38, var10_13 - 15.0 - var41_38));
                            var43_41.add(new t(var12_17 + 15.0 + var41_38, var10_13 + var28_27 + var41_38));
                            var45_43 = new t(var12_17, var10_13 + var28_27 + var41_38);
                            var43_41.add(var45_43);
                            var1_1.a(var40_34, var43_41);
                            if (!var46_2) continue;
lbl175: // 2 sources:
                            if (var38_32 != this.o) break block6;
                            for (var39_33 = 0; var39_33 < var6_18.length; ++var39_33) {
                                var40_34 = var6_18[var39_33];
                                v3 = this.c;
                                v4 = 1;
                                if (var46_2) continue block6;
                                if (v3 == v4) {
                                    var41_35 = new t[5];
                                    var41_35[0] = new t(var12_17 - var26_26 - (double)var39_33 * var20_23, var14_20);
                                    var41_35[1] = new t(var41_35[0].a(), var14_20 + var34_30 + (double)var39_33 * this.e);
                                    var41_35[4] = new t(var12_17, var14_20 - var28_27 - (double)var39_33 * var22_24);
                                    var41_35[3] = new t(var12_17 + var36_31 + (double)var39_33 * this.e, var41_35[4].b());
                                    var41_35[2] = new t(var41_35[3].a(), var41_35[1].b());
                                    var42_40 = var30_28 + 0.25 * (double)var39_33 * (var20_23 + var22_24);
                                    var44_42 = new D();
                                    var44_42.add(var41_35[0]);
                                    var44_42.a(this.a(var41_35[1], var42_40, this.n, false, this.f));
                                    var44_42.a(this.a(var41_35[2], var42_40, this.o, false, this.f));
                                    var44_42.a(this.a(var41_35[3], var42_40, this.h, false, this.f));
                                    var44_42.add(var41_35[4]);
                                    var1_1.a(var40_34, (D)var44_42);
                                    if (!var46_2) continue;
                                }
                                var41_39 = (double)var39_33 * var24_25;
                                var43_41 = new D();
                                var44_42 = new t(var12_17 - var26_26 - var41_39, var14_20);
                                var43_41.add(var44_42);
                                var43_41.add(new t(var12_17 - var26_26 - var41_39, var14_20 + 15.0 + var41_39));
                                var43_41.add(new t(var12_17 + 15.0 + var41_39, var14_20 + 15.0 + var41_39));
                                var43_41.add(new t(var12_17 + 15.0 + var41_39, var14_20 - var28_27 - var41_39));
                                var45_43 = new t(var12_17, var14_20 - var28_27 - var41_39);
                                var43_41.add(var45_43);
                                var1_1.a(var40_34, var43_41);
                                if (!var46_2) continue;
                            }
                        }
                    }
                }
                break;
            } while (true);
lbl208: // 7 sources:
            var2_3.g();
        } while (!var46_2);
    }

    private D a(t t2, double d2, int n2, boolean bl2, int n3) {
        D d3 = new D();
        if (n3 < 2) {
            d3.add(t2);
            if (!X.j) return d3;
        }
        if (n2 == this.h) {
            return this.a(this.h, t2.b(- d2, d2), d2, bl2, n3);
        }
        if (n2 == this.i) {
            return this.a(this.i, t2.b(d2, d2), d2, bl2, n3);
        }
        if (n2 == this.n) {
            return this.a(this.n, t2.b(d2, - d2), d2, bl2, n3);
        }
        if (n2 == this.o) {
            return this.a(this.o, t2.b(- d2, - d2), d2, bl2, n3);
        }
        if (!bl2) return d3;
        d3.n();
        return d3;
    }

    /*
     * Unable to fully structure code
     */
    private int a(X var1_1, q var2_2) {
        block4 : {
            var17_3 = X.j;
            var3_4 = var1_1.l(var2_2);
            var4_5 = var1_1.s(var2_2);
            var5_6 = new int[4];
            var6_7 = var2_2.j();
            while (var6_7.f()) {
                var7_9 = var6_7.a();
                v0 = (int)var7_9.e() ? 1 : 0;
                if (var17_3) break block4;
                if (v0 != 0 && this.a(var1_1, var7_9)) ** GOTO lbl36
                var8_10 = var1_1.m(var7_9);
                var9_11 = (t)(var7_9.c() == var2_2 ? var8_10.f() : var8_10.i());
                var10_12 = (t)(var7_9.c() == var2_2 ? var8_10.get(1) : var8_10.get(var8_10.size() - 2));
                var11_13 = aN.a(var4_5, var9_11, var10_12);
                var12_14 = var11_13 != null ? var11_13 : var9_11;
                var13_15 = var12_14.a() - var3_4.a();
                var15_16 = var12_14.b() - var3_4.b();
                if (var13_15 <= 0.0 || var15_16 <= 0.0) ** GOTO lbl23
                v1 = var5_6;
                v2 = this.o;
                v1[v2] = v1[v2] + 1;
                if (!var17_3) ** GOTO lbl36
lbl23: // 2 sources:
                if (var13_15 <= 0.0 || var15_16 >= 0.0) ** GOTO lbl28
                v3 = var5_6;
                v4 = this.h;
                v3[v4] = v3[v4] + 1;
                if (!var17_3) ** GOTO lbl36
lbl28: // 2 sources:
                if (var13_15 >= 0.0 || var15_16 >= 0.0) ** GOTO lbl-1000
                v5 = var5_6;
                v6 = this.i;
                v5[v6] = v5[v6] + 1;
                if (var17_3) lbl-1000: // 2 sources:
                {
                    v7 = var5_6;
                    v8 = this.n;
                    v7[v8] = v7[v8] + 1;
                }
lbl36: // 6 sources:
                var6_7.g();
                if (!var17_3) continue;
            }
            v0 = this.h;
        }
        if (var5_6[this.i] < var5_6[var6_8 = v0]) {
            var6_8 = this.i;
        }
        if (var5_6[this.n] < var5_6[var6_8]) {
            var6_8 = this.n;
        }
        if (var5_6[this.o] >= var5_6[var6_8]) return var6_8;
        return this.o;
    }

    private static t a(y y2, t t2, t t3) {
        if (!y2.a(t2)) return null;
        if (y2.a(t3)) {
            return null;
        }
        Point2D.Double double_ = aN.a(y2.c, y2.d, y2.a(), y2.b(), t2.a, t2.b, t3.a, t3.b, null);
        return new t(double_.x, double_.y);
    }

    private static Point2D.Double a(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, Point2D.Double double_) {
        if (double_ == null) {
            double_ = new Point2D.Double();
        }
        if (d6 >= d2 && d7 >= d3 && d6 <= d2 + d4 && d7 <= d3 + d5) {
            double d10 = d8 - d6;
            double d11 = d9 - d7;
            if (d10 == 0.0) {
                if (d11 < 0.0) {
                    double_.x = d6;
                    double_.y = d3;
                    return double_;
                }
                double_.x = d6;
                double_.y = d3 + d5;
                return double_;
            }
            if (d11 == 0.0) {
                if (d10 < 0.0) {
                    double_.x = d2;
                    double_.y = d7;
                    return double_;
                }
                double_.x = d2 + d4;
                double_.y = d7;
                return double_;
            }
            double d12 = d11 / d10;
            if (d10 > 0.0) {
                double d13 = d7 + d12 * (d2 + d4 - d6);
                if (d13 < d3) {
                    double_.x = d6 + (d3 - d7) / d12;
                    double_.y = d3;
                    return double_;
                }
                if (d13 <= d3 + d5) {
                    double_.x = d2 + d4;
                    double_.y = d13;
                    return double_;
                }
                double_.x = d6 + (d3 + d5 - d7) / d12;
                double_.y = d3 + d5;
                return double_;
            }
            double d14 = d7 + d12 * (d2 - d6);
            if (d14 < d3) {
                double_.x = d6 + (d3 - d7) / d12;
                double_.y = d3;
                return double_;
            }
            if (d14 <= d3 + d5) {
                double_.x = d2;
                double_.y = d14;
                return double_;
            }
            double_.x = d6 + (d3 + d5 - d7) / d12;
            double_.y = d3 + d5;
            return double_;
        }
        double_.x = d6;
        double_.y = d7;
        return double_;
    }

    private boolean a(X x2, d d2) {
        if (this.p) {
            return false;
        }
        if (this.g == null) return true;
        c c2 = x2.c(a);
        if (c2 == null) return true;
        if (!c2.d(d2)) return true;
        return false;
    }

    private void d(X x2) {
        boolean bl2 = X.j;
        e e2 = x2.p();
        do {
            if (!e2.f()) return;
            if (e2.a().e()) {
                this.b.c(e2.a());
                x2.d(e2.a());
            }
            e2.g();
        } while (!bl2);
    }

    private void e(X x2) {
        boolean bl2 = X.j;
        do {
            if (this.b.isEmpty()) return;
            x2.e(this.b.d());
        } while (!bl2);
    }
}

