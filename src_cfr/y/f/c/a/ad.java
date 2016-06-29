/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import y.c.A;
import y.c.C;
import y.c.a;
import y.c.c;
import y.c.d;
import y.c.h;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.X;
import y.f.ah;
import y.f.b.f;
import y.f.c.D;
import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.O;
import y.f.c.a.P;
import y.f.c.a.Q;
import y.f.c.a.R;
import y.f.c.a.W;
import y.f.c.a.Y;
import y.f.c.a.aQ;
import y.f.c.a.aR;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.bh;
import y.f.c.a.bk;
import y.f.c.a.bt;
import y.f.c.a.co;
import y.f.c.r;
import y.f.c.s;
import y.g.e;

class aD {
    private c b;
    c a;

    private aD() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public void a(X var1_1, aU var2_2, aV var3_3) {
        block32 : {
            block31 : {
                block30 : {
                    var31_4 = N.x;
                    var4_5 = var1_1.c(N.w);
                    if (var4_5 == null) {
                        return;
                    }
                    this.a = new W(this);
                    var5_6 = (E)var4_5.b(var1_1);
                    var5_6.c();
                    if (!var5_6.k() || y.f.b.c.c(var1_1)) {
                        var5_6.b();
                        return;
                    }
                    this.b = var1_1.c("y.layout.hierarchic.incremental.LayerCompactor.KEEP_LAYERS_DPKEY");
                    var6_7 = var1_1.t();
                    var7_8 = var1_1.t();
                    var8_9 = var1_1.t();
                    var9_10 = var1_1.u();
                    var10_11 = var1_1.u();
                    var11_12 = new y[var2_2.b()];
                    var12_13 = 0;
                    while (var12_13 < var2_2.b()) {
                        block27 : {
                            var11_12[var12_13] = var13_15 = var2_2.a(var12_13).d();
                            var14_16 = var13_15.a();
                            while (var14_16.f()) {
                                block29 : {
                                    block28 : {
                                        var15_17 = var14_16.e();
                                        var8_9.a(var15_17, var15_17.d());
                                        var16_18 = 0;
                                        if (var31_4) break block27;
                                        for (var17_20 = var15_17.f(); var17_20 != null; ++var16_18, var17_20 = var17_20.g()) {
                                            var9_10.a(var17_20, var16_18);
                                            if (!var31_4) {
                                                if (!var31_4) continue;
                                            }
                                            break block28;
                                        }
                                        var16_18 = 0;
                                    }
                                    for (var17_20 = var15_17.g(); var17_20 != null; ++var16_18, var17_20 = var17_20.h()) {
                                        var10_11.a(var17_20, var16_18);
                                        if (!var31_4) {
                                            if (!var31_4) continue;
                                        }
                                        break block29;
                                    }
                                    var14_16.g();
                                }
                                if (!var31_4) continue;
                            }
                            ++var12_13;
                        }
                        if (!var31_4) continue;
                    }
                    var12_14 = new r();
                    var13_15 = r.a(var1_1);
                    var14_16 = new y();
                    var15_17 = var1_1.t();
                    var16_19 = var1_1.c(f.b);
                    var17_20 = new y.f.c.a.X(this, var16_19);
                    var1_1.a(f.b, (c)var17_20);
                    this.a(var1_1, (s)var13_15, var3_3, null, var6_7, var7_8, (y)var14_16, (A)var15_17);
                    this.a(var1_1, (s)var13_15, var3_3);
                    this.a(var1_1, var6_7, var7_8, var3_3, (s)var13_15, (A)var15_17);
                    var18_21 = this.a(var1_1, var6_7, var7_8, (s)var13_15);
                    this.a(var1_1, var6_7, var7_8, (s)var13_15, var3_3, var2_2.b());
                    var1_1.a(f.b, var16_19);
                    var5_6.b();
                    var19_22 = var1_1.t();
                    var20_23 = new y.c.f();
                    var12_14.a(true);
                    var22_24 = var1_1.c(ah.f_);
                    var1_1.a(ah.f_, this.a);
                    try {
                        var21_25 = var12_14.a(var1_1, var19_22, var20_23);
                        var24_26 = null;
                        var1_1.d_(ah.f_);
                        if (var22_24 != null) {
                            var1_1.a(ah.f_, var22_24);
                        }
                    }
                    catch (Throwable var23_33) {
                        var24_27 = null;
                        var1_1.d_(ah.f_);
                        if (var22_24 == null) throw var23_33;
                        var1_1.a(ah.f_, var22_24);
                        throw var23_33;
                    }
                    var23_34 = var20_23.a();
                    while (var23_34.f()) {
                        var24_29 = var23_34.a();
                        var1_1.c(var24_29);
                        var23_34.g();
                        if (!var31_4) {
                            if (!var31_4) continue;
                        }
                        ** GOTO lbl-1000
                    }
                    var23_34 = var14_16.a();
                    while (var23_34.f()) {
                        var24_31 = var23_34.e();
                        var1_1.a(var24_31);
                        var23_34.g();
                        if (!var31_4) {
                            if (!var31_4) continue;
                        }
                        ** GOTO lbl-1000
                    }
                    if (var18_21 != null) {
                        for (var23_35 = 0; var23_35 < var18_21.length; ++var23_35) {
                            v0 = var1_1;
                            if (!var31_4) {
                                v0.a(var18_21[var23_35]);
                                if (!var31_4) continue;
                            }
                            break;
                        }
                    } else lbl-1000: // 5 sources:
                    {
                        v0 = var1_1;
                    }
                    var23_36 = v0.t();
                    var21_25 = new D().a((i)var1_1, (c)var19_22, var23_36);
                    var24_32 = var2_2.b();
                    for (var25_37 = 0; var25_37 < var24_32; ++var25_37) {
                        var2_2.b(0);
                        if (!var31_4) {
                            if (!var31_4) continue;
                        }
                        break block30;
                    }
                    var25_37 = 0;
                }
                while (var25_37 < var21_25) {
                    var2_2.a(0, 0);
                    ++var25_37;
                    if (!var31_4) {
                        if (!var31_4) continue;
                    }
                    break block31;
                }
                var25_37 = 0;
            }
            while (var25_37 < var11_12.length) {
                block33 : {
                    var26_39 = var11_12[var25_37];
                    v1 = var26_39.a();
                    if (var31_4) break block32;
                    var27_40 = v1;
                    while (var27_40.f()) {
                        var28_41 = var27_40.e();
                        var29_42 = var23_36.a(var28_41);
                        var30_43 = var2_2.a(var29_42);
                        var30_43.a(var28_41);
                        var27_40.g();
                        if (!var31_4) {
                            if (!var31_4) continue;
                        }
                        break block33;
                    }
                    ++var25_37;
                }
                if (!var31_4) continue;
            }
            var13_15.a();
            var1_1.a(var19_22);
            var1_1.a(var23_36);
            var1_1.a((A)var15_17);
            var1_1.b(new Y(this, var8_9));
            v1 = var25_38 = var1_1.o();
        }
        while (var25_38.f()) {
            var26_39 = var25_38.e();
            var26_39.b(new P(this, var9_10));
            var26_39.a(new Q(this, var10_11));
            var25_38.g();
            if (var31_4 != false) return;
            if (!var31_4) continue;
        }
        var1_1.a(var8_9);
        var1_1.a(var9_10);
        var1_1.a(var10_11);
        var1_1.a(var7_8);
        var1_1.a(var6_7);
    }

    /*
     * Unable to fully structure code
     */
    protected void a(X var1_1, A var2_2, A var3_3, aV var4_4, s var5_5, A var6_6) {
        block11 : {
            var25_7 = N.x;
            var7_8 = new y.f.b.c(var1_1);
            var8_9 = var1_1.u();
            var9_10 = var1_1.o();
            block0 : do {
                v0 = var9_10.f();
                block1 : while (v0) {
                    var10_11 = var9_10.e();
                    v1 = var7_8;
                    if (var25_7) break block11;
                    if (!v1.d(var10_11)) ** GOTO lbl67
                    var11_12 = (q)var2_2.b(var10_11);
                    var12_13 = (q)var3_3.b(var10_11);
                    if (var11_12 == null || var12_13 == null) ** GOTO lbl67
                    var13_14 = var6_6.a(var11_12);
                    var14_15 = var6_6.a(var12_13);
                    var15_16 = new y.c.f(var10_11.j());
                    var16_17 = var15_16.a();
                    while (var16_17.f()) {
                        block12 : {
                            var17_18 = var16_17.a();
                            v0 = var8_9.d(var17_18);
                            if (var25_7) continue block1;
                            if (v0) ** GOTO lbl65
                            var18_19 = var17_18.a(var10_11);
                            var19_20 = var7_8.b(var10_11, var18_19);
                            if (var19_20 != var10_11 && var19_20 != var18_19 && (!this.a(var7_8.a(var10_11), var1_1, var7_8) || !this.a(var7_8.a(var18_19), var1_1, var7_8))) ** GOTO lbl29
                            var8_9.a((Object)var17_18, true);
                            if (!var25_7) ** GOTO lbl65
lbl29: // 2 sources:
                            var20_21 = var18_19;
                            var21_22 = var18_19;
                            if (!var7_8.d(var18_19)) ** GOTO lbl-1000
                            var24_25 = (q)var2_2.b(var18_19);
                            if (var24_25 != null) {
                                var20_21 = var24_25;
                                var22_23 = var6_6.a(var20_21);
                                if (!var25_7) break block12;
                            }
                            var22_23 = var4_4.a(var18_19).j();
                        }
                        if ((var24_25 = (q)var3_3.b(var18_19)) == null) ** GOTO lbl-1000
                        var21_22 = var24_25;
                        var23_24 = var6_6.a(var21_22);
                        if (var25_7) lbl-1000: // 2 sources:
                        {
                            var23_24 = var4_4.a(var18_19).j();
                            ** if (!var25_7) goto lbl48
                        }
                        ** GOTO lbl48
lbl-1000: // 2 sources:
                        {
                            var22_23 = var4_4.a(var20_21).j();
                            var23_24 = var4_4.a(var21_22).j();
                        }
lbl48: // 3 sources:
                        if (var14_15 >= var22_23) ** GOTO lbl51
                        var5_5.a(this.a.b(var12_13), this.a.b(var20_21), 1);
                        if (!var25_7) ** GOTO lbl64
lbl51: // 2 sources:
                        if (var23_24 >= var13_14) ** GOTO lbl54
                        var5_5.a(this.a.b(var21_22), this.a.b(var11_12), 1);
                        if (!var25_7) ** GOTO lbl64
lbl54: // 2 sources:
                        if (var13_14 >= var22_23) ** GOTO lbl-1000
                        var5_5.a(this.a.b(var11_12), this.a.b(var20_21), 0);
                        if (var25_7) lbl-1000: // 2 sources:
                        {
                            if (var13_14 > var22_23) {
                                var5_5.b(this.a.b(var11_12), this.a.b(var20_21), 0);
                            }
                        }
                        if (var14_15 >= var23_24) ** GOTO lbl-1000
                        var5_5.a(this.a.b(var12_13), this.a.b(var21_22), 0);
                        if (var25_7) lbl-1000: // 2 sources:
                        {
                            if (var14_15 > var23_24) {
                                var5_5.b(this.a.b(var12_13), this.a.b(var21_22), 0);
                            }
                        }
lbl64: // 7 sources:
                        var8_9.a((Object)var17_18, true);
lbl65: // 3 sources:
                        var16_17.g();
                        if (!var25_7) continue;
                    }
lbl67: // 4 sources:
                    var9_10.g();
                    if (!var25_7) continue block0;
                }
                break block0;
                break;
            } while (true);
            var1_1.a(var8_9);
            v1 = var7_8;
        }
        v1.c();
    }

    protected void a(X x2, s s2, aV aV2, q q2, A a2, A a3, y y2, A a4) {
        y.f.b.c c2;
        block2 : {
            c2 = new y.f.b.c(x2);
            if (this.a(q2, x2, c2)) {
                this.a(x2, s2, c2, aV2, q2, a2, a3, y2, a4);
                if (!N.x) break block2;
            }
            this.a(c2, q2, x2, s2, aV2, a2, a3, y2, a4);
        }
        c2.c();
    }

    /*
     * Unable to fully structure code
     */
    private void a(y.f.b.c var1_1, q var2_2, X var3_3, s var4_4, aV var5_5, A var6_6, A var7_7, y var8_8, A var9_9) {
        block4 : {
            var18_10 = N.x;
            var10_11 = var1_1.b(var2_2).a();
            while (var10_11.f()) {
                var11_12 = var10_11.e();
                if (var18_10 != false) return;
                if (var1_1.d(var11_12)) {
                    this.a(var3_3, var4_4, var5_5, var11_12, var6_6, var7_7, var8_8, var9_9);
                }
                var10_11.g();
                if (!var18_10) continue;
            }
            if (var2_2 == null) return;
            var10_11 = var3_3.d();
            var3_3.b((q)var10_11, 0.0, 0.0);
            var11_12 = var3_3.d();
            var3_3.b(var11_12, 0.0, 0.0);
            var6_6.a((Object)var2_2, var10_11);
            var7_7.a((Object)var2_2, var11_12);
            var8_8.add(var10_11);
            var8_8.add(var11_12);
            var12_13 = Integer.MAX_VALUE;
            var13_14 = 0;
            var14_15 = var1_1.b(var2_2).a();
            while (var14_15.f()) {
                var15_16 = var14_15.e();
                if (var18_10) break block4;
                if (var1_1.d(var15_16)) ** GOTO lbl-1000
                var4_4.a(this.a.b(var10_11), this.a.b(var15_16), 0);
                var4_4.b(this.a.b(var11_12), this.a.b(var15_16), 0);
                var12_13 = Math.min(var12_13, var5_5.a(var15_16).j());
                var13_14 = Math.max(var13_14, var5_5.a(var15_16).j());
                if (var18_10) lbl-1000: // 2 sources:
                {
                    var16_17 = (q)var6_6.b(var15_16);
                    var4_4.a(this.a.b(var10_11), this.a.b(var16_17), 0);
                    var17_18 = (q)var7_7.b(var15_16);
                    var4_4.b(this.a.b(var11_12), this.a.b(var17_18), 0);
                    var12_13 = Math.min(var12_13, var9_9.a(var16_17));
                    var13_14 = Math.max(var13_14, var9_9.a(var17_18));
                }
                var14_15.g();
                if (!var18_10) continue;
            }
            var4_4.a(this.a.b(var10_11), this.a.b(var11_12), 0, var3_3.g() * 1000);
            var9_9.a(var10_11, var12_13);
        }
        var9_9.a((Object)var11_12, var13_14);
    }

    /*
     * Unable to fully structure code
     */
    private void a(X var1_1, s var2_2, y.f.b.c var3_3, aV var4_4, q var5_5, A var6_6, A var7_7, y var8_8, A var9_9) {
        block3 : {
            var16_10 = N.x;
            this.a(var1_1, var5_5, var3_3, var4_4, var6_6, var7_7, var9_9);
            var10_11 = var3_3.c(var5_5);
            var11_12 = new HashMap<Integer, Object[]>();
            var12_13 = var10_11.a();
            while (var12_13.f()) {
                var13_14 = var12_13.e();
                v0 = (int)var3_3.d((q)var13_14) ? 1 : 0;
                if (var16_10) break block3;
                if (v0 != 0) ** GOTO lbl17
                var14_15 = new Integer(var4_4.a((q)var13_14).j());
                var15_17 = (q)var11_12.get(var14_15);
                if (var15_17 == null) ** GOTO lbl-1000
                var2_2.b(this.a.b(var15_17), this.a.b(var13_14));
                if (var16_10) lbl-1000: // 2 sources:
                {
                    var11_12.put(var14_15, var13_14);
                }
lbl17: // 4 sources:
                var12_13.g();
                if (!var16_10) continue;
            }
            v0 = var11_12.size();
        }
        if (v0 <= 0) return;
        var12_13 = var11_12.values();
        var13_14 = var12_13.toArray(new q[var12_13.size()]);
        e.a(var13_14, (Comparator)new R(this, var4_4));
        if (var13_14.length <= 1) return;
        var14_16 = 1;
        do {
            if (var14_16 >= var13_14.length) return;
            var15_17 = var13_14[var14_16];
            var2_2.a(this.a.b(var13_14[var14_16 - 1]), this.a.b(var15_17), 1, Math.min(1000 * var1_1.g(), 2147483646));
            ++var14_16;
        } while (!var16_10);
    }

    /*
     * Unable to fully structure code
     */
    private void a(X var1_1, q var2_2, y.f.b.c var3_3, aV var4_4, A var5_5, A var6_6, A var7_7) {
        var18_8 = N.x;
        var8_9 = null;
        var9_10 = null;
        var10_11 = Integer.MAX_VALUE;
        var11_12 = -1;
        var12_13 = var3_3.b(var2_2).a();
        while (var12_13.f()) {
            var13_14 = var12_13.e();
            if (var18_8 != false) return;
            if (!var3_3.d(var13_14)) ** GOTO lbl-1000
            this.a(var1_1, var13_14, var3_3, var4_4, var5_5, var6_6, var7_7);
            var14_15 = (q)var5_5.b(var13_14);
            var15_16 = (q)var6_6.b(var13_14);
            var16_17 = var7_7.a(var14_15);
            var17_18 = var7_7.a(var15_16);
            if (var18_8) lbl-1000: // 2 sources:
            {
                var14_15 = var15_16 = var13_14;
                var16_17 = var17_18 = var4_4.a(var13_14).j();
            }
            if (var17_18 > var11_12) {
                var9_10 = var15_16;
                var11_12 = var17_18;
            }
            if (var16_17 < var10_11) {
                var8_9 = var14_15;
                var10_11 = var16_17;
            }
            var12_13.g();
            if (!var18_8) continue;
        }
        if (var2_2 == null) return;
        var5_5.a((Object)var2_2, var8_9);
        var6_6.a((Object)var2_2, var9_10);
        var7_7.a((Object)var8_9, var10_11);
        var7_7.a((Object)var9_10, var11_12);
    }

    private int a(q q2, y.f.b.c c2, aV aV2) {
        Object object;
        boolean bl2 = N.x;
        q q3 = q2;
        if (c2 != null && c2.d(q2)) {
            object = c2.c(q2);
            x x2 = object.a();
            while (x2.f()) {
                q q4 = x2.e();
                if (!c2.d(q4)) {
                    q3 = q4;
                    if (!bl2) break;
                }
                x2.g();
                if (!bl2) continue;
            }
        }
        if ((object = aV2.a(q3)) == null) return -1;
        return object.j();
    }

    private q[] a(X x2, A a2, A a3, s s2) {
        c c2;
        boolean bl2 = N.x;
        bk bk2 = bk.c(x2);
        if (bk2 == null) return null;
        y.f.b.c c3 = new y.f.b.c(x2);
        q[] arrq = x2.m();
        int n2 = bk2.e().size();
        q[] arrq2 = new q[n2 - 1];
        for (int i2 = 0; i2 < arrq2.length; ++i2) {
            arrq2[i2] = x2.d();
            if (i2 <= 0) continue;
            s2.a(arrq2[i2 - 1], arrq2[i2]);
            if (!bl2) continue;
        }
        if ((c2 = x2.c(bk.b)) != null) {
            for (int i3 = 0; i3 < arrq.length; ++i3) {
                bt bt2;
                q q2 = arrq[i3];
                bh bh2 = (bh)c2.b(q2);
                if (bl2) return arrq2;
                if (bh2 == null || (bt2 = bh2.c()) == null) continue;
                if (c3.d(q2)) {
                    if (bt2.a() > 0) {
                        s2.b(a2.b(q2), arrq2[bt2.a() - 1], 1);
                    }
                    if (bt2.a() >= n2 - 1) continue;
                    s2.a(a3.b(q2), arrq2[bt2.a()], 1);
                    if (!bl2) continue;
                }
                if (bt2.a() > 0) {
                    s2.b(q2, arrq2[bt2.a() - 1], 1);
                }
                if (bt2.a() >= n2 - 1) continue;
                s2.a(q2, arrq2[bt2.a()], 1);
                if (!bl2) continue;
            }
        }
        c3.c();
        return arrq2;
    }

    /*
     * Unable to fully structure code
     */
    private void a(X var1_1, A var2_2, A var3_3, s var4_4, aV var5_5, int var6_6) {
        var27_7 = N.x;
        var7_8 = var1_1.c(aR.a);
        if (var7_8 == null) {
            return;
        }
        var8_9 = (c)var7_8.b(var1_1);
        if (var8_9 == null) {
            return;
        }
        var9_10 = var1_1.c(ah.f_);
        var10_11 = new HashMap<q, Object>();
        if (var9_10 == null) ** GOTO lbl18
        var11_12 = var1_1.o();
        while (var11_12.f()) {
            var12_13 = var11_12.e();
            var13_14 = var9_10.b(var12_13) != null ? var9_10.b(var12_13) : var12_13;
            var10_11.put((q)var13_14, var12_13);
            var11_12.g();
            if (!var27_7) continue;
lbl18: // 2 sources:
            var11_12 = var1_1.o();
            while (var11_12.f()) {
                var12_13 = var11_12.e();
                var10_11.put((q)var12_13, (q)var12_13);
                var11_12.g();
                if (!var27_7) continue;
            }
            break block0;
        }
        var11_12 = new y.f.b.c(var1_1);
        var12_13 = var1_1.o();
        block2 : do {
            v0 = var12_13.f();
            block3 : while (v0) {
                var13_14 = var12_13.e();
                if (var27_7 != false) return;
                var14_15 = var9_10 != null && var9_10.b(var13_14) != null ? var9_10.b(var13_14) : var13_14;
                var15_16 = (y.c.D)var8_9.b(var14_15);
                if (var15_16 == null) ** GOTO lbl126
                var16_17 = this.a((q)var13_14, (y.f.b.c)var11_12, var5_5);
                var17_18 = var15_16.m();
                while (var17_18.f()) {
                    var18_19 = var17_18.d();
                    v0 = var18_19 instanceof co;
                    if (var27_7) continue block3;
                    if (!v0) ** GOTO lbl124
                    var19_20 = (co)var18_19;
                    var20_21 = var19_20.d();
                    var21_22 = (q)var10_11.get(var20_21);
                    var22_23 = var19_20.c();
                    if (var22_23 != 0) ** GOTO lbl66
                    var23_24 = this.a(var21_22, (y.f.b.c)var11_12, var5_5);
                    if (var16_17 != var23_24) ** GOTO lbl124
                    if (!var11_12.d((q)var13_14) || !var11_12.d(var21_22)) ** GOTO lbl54
                    var24_27 = (q)var2_2.b(var13_14);
                    var25_30 = (q)var2_2.b(var21_22);
                    if (var24_27 == null || var25_30 == null) ** GOTO lbl124
                    var4_4.b(var25_30, var24_27);
                    if (!var27_7) ** GOTO lbl124
lbl54: // 2 sources:
                    if (!var11_12.d((q)var13_14)) ** GOTO lbl59
                    var24_27 = (q)var2_2.b(var13_14);
                    if (var24_27 == null) ** GOTO lbl124
                    var4_4.b(var21_22, var24_27);
                    if (!var27_7) ** GOTO lbl124
lbl59: // 2 sources:
                    if (!var11_12.d(var21_22)) ** GOTO lbl64
                    var24_27 = (q)var2_2.b(var21_22);
                    if (var24_27 == null) ** GOTO lbl124
                    var4_4.b(var24_27, var13_14);
                    if (!var27_7) ** GOTO lbl124
lbl64: // 2 sources:
                    var4_4.b(var21_22, var13_14);
                    if (!var27_7) ** GOTO lbl124
lbl66: // 2 sources:
                    if (var22_23 != -1) ** GOTO lbl88
                    var23_24 = this.a(var21_22, (y.f.b.c)var11_12, var5_5);
                    if (var23_24 < var16_17) ** GOTO lbl124
                    var24_28 = Math.min(var19_20.e(), var23_24 - var16_17);
                    if (!var11_12.d((q)var13_14) || !var11_12.d(var21_22)) ** GOTO lbl76
                    var25_30 = (q)var3_3.b(var13_14);
                    var26_31 = (q)var2_2.b(var21_22);
                    if (var25_30 == null || var26_31 == null) ** GOTO lbl124
                    var4_4.b(var26_31, var25_30, var24_28, var19_20.a());
                    if (!var27_7) ** GOTO lbl124
lbl76: // 2 sources:
                    if (!var11_12.d((q)var13_14)) ** GOTO lbl81
                    var25_30 = (q)var3_3.b(var13_14);
                    if (var25_30 == null) ** GOTO lbl124
                    var4_4.b(var21_22, var25_30, var24_28, var19_20.a());
                    if (!var27_7) ** GOTO lbl124
lbl81: // 2 sources:
                    if (!var11_12.d(var21_22)) ** GOTO lbl86
                    var25_30 = (q)var2_2.b(var21_22);
                    if (var25_30 == null) ** GOTO lbl124
                    var4_4.b(var25_30, var13_14, var24_28, var19_20.a());
                    if (!var27_7) ** GOTO lbl124
lbl86: // 2 sources:
                    var4_4.b(var21_22, var13_14, var24_28, var19_20.a());
                    if (!var27_7) ** GOTO lbl124
lbl88: // 2 sources:
                    if (var22_23 != 1) ** GOTO lbl110
                    var23_24 = this.a(var21_22, (y.f.b.c)var11_12, var5_5);
                    if (var23_24 > var16_17) ** GOTO lbl124
                    var24_29 = Math.min(var19_20.e(), var16_17 - var23_24);
                    if (!var11_12.d((q)var13_14) || !var11_12.d(var21_22)) ** GOTO lbl98
                    var25_30 = (q)var2_2.b(var13_14);
                    var26_31 = (q)var3_3.b(var21_22);
                    if (var25_30 == null || var26_31 == null) ** GOTO lbl124
                    var4_4.a(var26_31, var25_30, var24_29, var19_20.a());
                    if (!var27_7) ** GOTO lbl124
lbl98: // 2 sources:
                    if (!var11_12.d((q)var13_14)) ** GOTO lbl103
                    var25_30 = (q)var2_2.b(var13_14);
                    if (var25_30 == null) ** GOTO lbl124
                    var4_4.a(var21_22, var25_30, var24_29, var19_20.a());
                    if (!var27_7) ** GOTO lbl124
lbl103: // 2 sources:
                    if (!var11_12.d(var21_22)) ** GOTO lbl108
                    var25_30 = (q)var3_3.b(var21_22);
                    if (var25_30 == null) ** GOTO lbl124
                    var4_4.a(var25_30, var13_14, var24_29, var19_20.a());
                    if (!var27_7) ** GOTO lbl124
lbl108: // 2 sources:
                    var4_4.a(var21_22, var13_14, var24_29, var19_20.a());
                    if (!var27_7) ** GOTO lbl124
lbl110: // 2 sources:
                    if (var22_23 != 2) ** GOTO lbl118
                    if (var16_17 != 0 || var11_12.a((q)var13_14) != null) ** GOTO lbl124
                    if (!var11_12.d((q)var13_14)) ** GOTO lbl116
                    var23_25 = (q)var2_2.b(var13_14);
                    var4_4.a(var23_25);
                    if (!var27_7) ** GOTO lbl124
lbl116: // 2 sources:
                    var4_4.a(var13_14);
                    if (!var27_7) ** GOTO lbl124
lbl118: // 2 sources:
                    if (var22_23 != -2 || var16_17 != var6_6 - 1 || var11_12.a((q)var13_14) != null) ** GOTO lbl124
                    if (!var11_12.d((q)var13_14)) ** GOTO lbl-1000
                    var23_26 = (q)var2_2.b(var13_14);
                    var4_4.b(var23_26);
                    if (var27_7) lbl-1000: // 2 sources:
                    {
                        var4_4.b(var13_14);
                    }
lbl124: // 32 sources:
                    var17_18.g();
                    if (!var27_7) continue;
                }
lbl126: // 3 sources:
                var12_13.g();
                if (!var27_7) continue block2;
            }
            break block2;
            break;
        } while (true);
        var11_12.c();
    }

    /*
     * Unable to fully structure code
     */
    protected void a(X var1_1, s var2_2, aV var3_3) {
        var17_4 = N.x;
        var4_5 = new y.f.b.c(var1_1);
        var5_6 = var1_1.p();
        while (var5_6.f()) {
            var6_7 = var5_6.a();
            var7_8 = var6_7.c();
            var8_9 = var6_7.d();
            var9_10 = var3_3.a(var7_8);
            var10_11 = var3_3.a(var8_9);
            if (var17_4 != false) return;
            if (var9_10 == null || var10_11 == null || var4_5.d(var7_8) || var4_5.d(var8_9)) ** GOTO lbl35
            var11_12 = var9_10.j();
            var12_13 = var10_11.j();
            var13_14 = var4_5.a(var7_8);
            var14_15 = var4_5.a(var8_9);
            var15_16 = this.a.b(var7_8);
            var16_17 = this.a.b(var8_9);
            if (var13_14 != var14_15 || this.a(var13_14, var1_1, var4_5)) ** GOTO lbl27
            if (var11_12 >= var12_13) ** GOTO lbl22
            var2_2.a(var15_16, var16_17, 1, 100 * var1_1.g());
            if (!var17_4) ** GOTO lbl35
lbl22: // 2 sources:
            if (var12_13 >= var11_12) ** GOTO lbl25
            var2_2.a(var16_17, var15_16, 1);
            if (!var17_4) ** GOTO lbl35
lbl25: // 2 sources:
            var2_2.b(var15_16, var16_17);
            if (!var17_4) ** GOTO lbl35
lbl27: // 2 sources:
            if (var13_14 == var14_15 || this.a(var13_14, var1_1, var4_5) && this.a(var14_15, var1_1, var4_5)) ** GOTO lbl35
            if (var11_12 >= var12_13) ** GOTO lbl31
            var2_2.a(var15_16, var16_17, 1);
            if (!var17_4) ** GOTO lbl35
lbl31: // 2 sources:
            if (var12_13 >= var11_12) ** GOTO lbl-1000
            var2_2.a(var16_17, var15_16, 1);
            if (var17_4) lbl-1000: // 2 sources:
            {
                var2_2.b(var15_16, var16_17);
            }
lbl35: // 9 sources:
            var5_6.g();
            if (!var17_4) continue;
        }
        var4_5.c();
    }

    private boolean a(q q2, i i2, y.f.b.c c2) {
        if (this.b == null) {
            return false;
        }
        if (q2 == null) {
            return this.b.d(i2);
        }
        if (this.b.d(q2)) return true;
        if (this.a(c2.a(q2), i2, c2)) return true;
        return false;
    }

    aD(O o2) {
        this();
    }
}

