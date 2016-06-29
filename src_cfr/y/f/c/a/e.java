/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.i;
import y.c.p;
import y.c.x;
import y.d.c;
import y.d.m;
import y.d.n;
import y.d.q;
import y.d.r;
import y.d.t;
import y.d.y;
import y.f.C;
import y.f.X;
import y.f.aE;
import y.f.b.b;
import y.f.b.f;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.F;
import y.f.c.a.G;
import y.f.c.a.H;
import y.f.c.a.I;
import y.f.c.a.J;
import y.f.c.a.L;
import y.f.c.a.M;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.as;
import y.f.c.a.bK;
import y.f.c.a.cd;
import y.f.c.a.cp;
import y.f.c.a.cr;
import y.f.c.a.da;
import y.f.c.a.dd;
import y.f.c.a.dg;

public class E {
    final y.c.f a = new y.c.f();
    X b;
    aV c;
    y.c.c d;
    b e;
    y.c.c f;
    private D h = new D();
    private y.g.I i;
    private dd j;
    private double k = 0.0;
    private final h l;
    private final h m;
    private final Map n;
    private Random o = new Random(0);
    y.c.c g;

    E(X x2, aV aV2, y.c.c c2) {
        this.b = x2;
        this.c = aV2;
        this.d = c2;
        this.j = new dd(this, x2, aV2);
        this.n = new HashMap();
        this.l = y.g.M.b();
        this.m = y.g.M.b();
        this.f = x2.c(f.d);
        if (this.f == null) return;
        F f2 = new F(this);
        x2.a(f.d, f2);
    }

    boolean a() {
        if (this.d == null) return false;
        return true;
    }

    public void b() {
        boolean bl2 = N.x;
        if (!this.k()) {
            this.e = new b();
            this.e.b(this.b);
            if (!bl2) return;
        }
        this.i = new y.g.I(this.b);
        int n2 = 0;
        do {
            if (n2 >= this.j.d.size()) return;
            dg dg2 = (dg)this.j.d.get(n2);
            if (dg2.f != null && dg2.f.e() != null) {
                this.i.a(dg2.f);
            }
            ++n2;
        } while (!bl2);
    }

    public void c() {
        if (!this.k()) {
            this.e.d(this.b);
            if (!N.x) return;
        }
        if (this.i == null) return;
        this.i.f();
        this.i = null;
    }

    void a(aU aU2) {
        this.a(aU2, (y.c.A)null);
    }

    void a(aU aU2, y.c.A a2) {
        if (!this.k()) {
            return;
        }
        this.j.a(aU2, a2);
    }

    void b(aU aU2) {
        if (!this.k()) {
            return;
        }
        this.j.a(this.c);
    }

    void c(aU aU2) {
        if (!this.k()) {
            return;
        }
        this.j.a(aU2, this.c, this.j);
    }

    void d(aU aU2) {
        if (!this.k()) {
            return;
        }
        this.j.d(aU2, this.c);
    }

    /*
     * Unable to fully structure code
     */
    void e(aU var1_1) {
        var10_2 = N.x;
        if (!this.k()) {
            return;
        }
        var2_3 = 0;
        block0 : do {
            v0 = var2_3;
            v1 = var1_1.b();
            block1 : while (v0 < v1) {
                var3_5 = var1_1.a(var2_3);
                if (var3_5.e() != 2 && var3_5.e() != 3) {
                    for (var4_6 = var3_5.d().k(); var4_6 != null; var4_6 = var4_6.a()) {
                        block10 : {
                            var5_7 = (y.c.q)var4_6.c();
                            var6_8 = this.c.a(var5_7);
                            v0 = var6_8.b();
                            v1 = 12;
                            if (var10_2) continue block1;
                            if (v0 != v1 && var6_8.b() != 13) continue;
                            var7_9 = this.b.m(var5_7);
                            if (var6_8.b() == 13) {
                                var7_9 += this.b.p(var5_7);
                            }
                            var9_10 = this.f(var6_8.l());
                            if (var9_10.w == null) {
                                var9_10.w = new Rectangle2D.Double(var7_9, this.b.n(var5_7), 0.0, 0.0);
                                if (!var10_2) break block10;
                            }
                            var9_10.w.add(var7_9, this.b.n(var5_7));
                        }
                        if (var6_8.b() == 12 && var9_10.A == var3_5) {
                            var9_10.w.add(var7_9, this.b.n(var5_7) - var9_10.x);
                        }
                        if (var6_8.b() != 12 || var9_10.B != var3_5) continue;
                        var9_10.w.add(var7_9, this.b.n(var5_7) + var9_10.y);
                        if (!var10_2) continue;
                    }
                }
                ++var2_3;
                if (!var10_2) continue block0;
            }
            break block0;
            break;
        } while (true);
        var2_4 = this.j.d.iterator();
        do lbl-1000: // 3 sources:
        {
            if (var2_4.hasNext() == false) return;
            var3_5 = (dg)var2_4.next();
            if (var3_5 == this.j) ** GOTO lbl-1000
            this.b.b(var3_5.f, var3_5.w.getWidth(), var3_5.w.getHeight());
            this.b.c(var3_5.f, var3_5.w.getX(), var3_5.w.getY());
        } while (!var10_2);
    }

    /*
     * Unable to fully structure code
     */
    void f(aU var1_1) {
        var6_2 = N.x;
        if (this.k() == false) return;
        if (!this.a()) {
            return;
        }
        var2_3 = new y.c.y();
        this.a(this.j, (J)new G(this, var2_3));
        var3_4 = new HashSet<y.c.q>();
        for (Object var5_7 : var2_3) {
            if (var3_4.contains(var5_7)) continue;
            var3_4.add((y.c.q)var5_7);
            if (!this.d((y.c.q)var5_7)) continue;
            this.a((y.c.q)var5_7, var1_1);
            if (!var6_2) continue;
        }
        var4_6 = var1_1.b();
        do lbl-1000: // 3 sources:
        {
            if (var4_6-- <= 0) return;
            var5_7 = var1_1.a(var4_6);
            if (!var5_7.d().isEmpty()) ** GOTO lbl-1000
            var1_1.b(var4_6);
        } while (!var6_2);
    }

    /*
     * Unable to fully structure code
     */
    private void a(y.c.q var1_1, aU var2_2) {
        block44 : {
            block46 : {
                block52 : {
                    block47 : {
                        block48 : {
                            block45 : {
                                var30_3 = N.x;
                                var3_4 = this.f(var1_1);
                                if (var3_4 == null) {
                                    return;
                                }
                                var4_5 = this.i(var1_1);
                                var5_6 = this.a(var1_1);
                                var6_7 = var5_6 != null ? var5_6.j() : 0;
                                var5_6 = this.b(var1_1);
                                var7_8 = var5_6 != null ? var5_6.j() : 0;
                                var8_9 = var3_4.h.c();
                                var9_10 = var3_4.g.c();
                                var10_11 = new D[var8_9 - var9_10 + 1];
                                var11_12 = Integer.MAX_VALUE;
                                var12_13 = Integer.MIN_VALUE;
                                var13_14 = new y.c.y();
                                var14_15 = new HashSet<Object>();
                                var15_16 = new y.c.y();
                                var16_17 = new HashSet<Object>();
                                var17_18 = var9_10;
                                var18_20 = var8_9 + 1;
                                block0 : do {
                                    v0 = var17_18;
                                    block1 : while (v0 < var18_20) {
                                        var10_11[var17_18 - var9_10] = new D();
                                        var19_21 = var2_2.a(var17_18);
                                        v1 = var19_21.d().a();
                                        if (var30_3) break block44;
                                        var20_23 = v1;
                                        while (var20_23.f()) {
                                            var21_25 = var20_23.e();
                                            var5_6 = this.c.a((y.c.q)var21_25).h();
                                            v0 = (int)this.a((y.c.q)var21_25, var1_1) ? 1 : 0;
                                            if (var30_3) continue block1;
                                            if (v0 == 0) ** GOTO lbl37
                                            var10_11[var17_18 - var9_10].add(var21_25);
                                            if (!var30_3) ** GOTO lbl64
lbl37: // 2 sources:
                                            if (var5_6 == null) ** GOTO lbl64
                                            var22_26 = var5_6.j();
                                            var23_28 = false;
                                            if (var6_7 >= var22_26 || var7_8 <= var22_26) ** GOTO lbl43
                                            var23_28 = true;
                                            if (!var30_3) ** GOTO lbl-1000
lbl43: // 2 sources:
                                            if (var6_7 != var7_8 && (var24_32 = this.i((y.c.q)var21_25)) != null) {
                                                if (var6_7 == var22_26) {
                                                    var25_33 = this.b((y.c.q)var24_32);
                                                    var23_28 |= var25_33 != null && var25_33.j() > var6_7;
                                                }
                                                if (var7_8 == var22_26) {
                                                    var25_33 = this.a((y.c.q)var24_32);
                                                    var23_28 |= var25_33 != null && var25_33.j() < var7_8;
                                                }
                                            }
                                            if (var23_28) lbl-1000: // 2 sources:
                                            {
                                                if (!var14_15.contains(var21_25)) {
                                                    var13_14.add(var21_25);
                                                    var14_15.add(var21_25);
                                                    var24_32 = this.i((y.c.q)var21_25);
                                                    if (var24_32 != null && var24_32 != var4_5 && !var16_17.contains(var24_32)) {
                                                        var15_16.add(var24_32);
                                                        var16_17.add(var24_32);
                                                        var25_33 = this.f((y.c.q)var24_32);
                                                        if (var25_33 != null) {
                                                            if (var11_12 > var25_33.g.c()) {
                                                                var11_12 = var25_33.g.c();
                                                            }
                                                            if (var12_13 < var25_33.h.c()) {
                                                                var12_13 = var25_33.h.c();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
lbl64: // 13 sources:
                                            var20_23.g();
                                            if (!var30_3) continue;
                                        }
                                        ++var17_18;
                                        if (!var30_3) continue block0;
                                    }
                                    break block0;
                                    break;
                                } while (true);
                                if (var13_14.isEmpty()) ** GOTO lbl191
                                var17_18 = 0;
                                var18_20 = 0;
                                var19_22 = Integer.MIN_VALUE;
                                var20_24 = Integer.MAX_VALUE;
                                var21_25 = new HashSet<E>();
                                for (var22_26 = 0; var22_26 < var10_11.length; ++var22_26) {
                                    var21_25.addAll(var10_11[var22_26]);
                                    if (!var30_3) {
                                        if (!var30_3) continue;
                                    }
                                    break block45;
                                }
                                for (y.c.q var23_30 : var13_14) {
                                    var24_32 = this.i(var23_30);
                                    if (var24_32 != null && var24_32 != var4_5) continue;
                                    var25_35 = this.c.a(var23_30).j();
                                    if (this.a((Set)var21_25, var23_30)) {
                                        var17_18 = 1;
                                        if (var19_22 >= var25_35) continue;
                                        var19_22 = var25_35;
                                        if (!var30_3) continue;
                                    }
                                    var18_20 = 1;
                                    if (var20_24 <= var25_35) continue;
                                    var20_24 = var25_35;
                                    if (!var30_3) {
                                        if (!var30_3) continue;
                                    }
                                    break block46;
                                }
                                var22_26 = var12_13 - var11_12 + 1;
                            }
                            var23_31 = new D[var22_26];
                            var24_32 = new D[var22_26];
                            for (var25_36 = 0; var25_36 < var22_26; ++var25_36) {
                                var23_31[var25_36] = new D();
                                var24_32[var25_36] = new D();
                                if (!var30_3) {
                                    if (!var30_3) continue;
                                }
                                break block47;
                            }
                            for (reference var26_38 : var15_16) {
                                v2 = (int)this.a((y.c.q)var26_38, var16_17) ? 1 : 0;
                                if (!var30_3) {
                                    if (v2 != 0) continue;
                                    if (this.a(this.g(var26_38), var9_10, var8_9)) {
                                        this.a((y.c.q)var26_38, var2_2, var23_31, var11_12);
                                        if (!var30_3) continue;
                                    }
                                    this.a((y.c.q)var26_38, var2_2, var24_32, var11_12);
                                    if (!var30_3) continue;
                                }
                                break block48;
                            }
                            v2 = var17_18;
                        }
                        var25_36 = v2 != 0 && var18_20 != 0 ? ((var26_39 = var19_22 + var20_24) % 2 == 0 ? var26_39 / 2 : var26_39 / 2 + 1) : (var17_18 != 0 ? var19_22 + 1 : (var18_20 != 0 ? var20_24 : var9_10));
                    }
                    if (var17_18 != 0 || var18_20 != 0) {
                        block50 : {
                            block49 : {
                                var27_40 = 0;
                                while (var27_40 < var10_11.length) {
                                    v3 = var10_11[var27_40].isEmpty();
                                    if (!var30_3) {
                                        if (!v3) {
                                            var28_41 = var2_2.a(var9_10 + var27_40);
                                            var29_42 = var10_11[var27_40].m();
                                            while (var29_42.f()) {
                                                var28_41.b((y.c.q)var29_42.d());
                                                var29_42.g();
                                                if (!var30_3) {
                                                    if (!var30_3) continue;
                                                }
                                                break;
                                            }
                                        } else {
                                            ++var27_40;
                                        }
                                        if (!var30_3) continue;
                                    }
                                    break block49;
                                }
                                v3 = false;
                            }
                            var26_38 = (reference)v3 ? 1 : 0;
                            var27_40 = 0;
                            while (var27_40 < var10_11.length) {
                                block51 : {
                                    v4 = (reference)var10_11[var27_40].isEmpty() ? 1 : 0;
                                    if (var30_3) break block50;
                                    if (v4 == false) {
                                        var28_41 = var2_2.a(0, var25_36 + var26_38);
                                        var29_42 = var10_11[var27_40].m();
                                        while (var29_42.f()) {
                                            var28_41.a((y.c.q)var29_42.d());
                                            var29_42.g();
                                            if (!var30_3) {
                                                if (!var30_3) continue;
                                            }
                                            break block51;
                                        }
                                        ++var26_38;
                                    }
                                    ++var27_40;
                                }
                                if (!var30_3) continue;
                            }
                            v4 = var26_38 = var26_38 + var25_36;
                        }
                        if (!var30_3) break block52;
                    }
                    var26_38 = (reference)(var8_9 + 1);
                }
                var27_40 = 0;
                while (var27_40 < var22_26) {
                    var28_41 = var2_2.a(0, (int)(var26_38 + var27_40));
                    v5 = var24_32[var27_40].m();
                    if (!var30_3) {
                        block53 : {
                            var29_42 = v5;
                            while (var29_42.f()) {
                                var28_41.a((y.c.q)var29_42.d());
                                var29_42.g();
                                if (!var30_3) {
                                    if (!var30_3) continue;
                                }
                                break block53;
                            }
                            ++var27_40;
                        }
                        if (!var30_3) continue;
                    }
                    ** GOTO lbl181
                }
                var27_40 = 0;
                while (var27_40 < var22_26) {
                    block54 : {
                        var28_41 = var2_2.a(0, var25_36 + var27_40);
                        if (var30_3) break block46;
                        v5 = var29_42 = var23_31[var27_40].m();
lbl181: // 3 sources:
                        while (var29_42.f()) {
                            var28_41.a((y.c.q)var29_42.d());
                            var29_42.g();
                            if (!var30_3) {
                                if (!var30_3) continue;
                            }
                            break block54;
                        }
                        ++var27_40;
                    }
                    if (!var30_3) continue;
                }
                this.a(var2_2);
            }
            v1 = this.h(var1_1).a();
        }
        var17_19 = v1;
        do {
            if (var17_19.f() == false) return;
            if (this.d(var17_19.e())) {
                this.a(var17_19.e(), var2_2);
            }
            var17_19.g();
        } while (!var30_3);
    }

    /*
     * Unable to fully structure code
     */
    private boolean a(Set var1_1, y.c.q var2_2) {
        block5 : {
            var9_3 = N.x;
            var3_4 = 0;
            var4_5 = 0;
            var5_6 = this.c.a(var2_2).j();
            var6_7 = var2_2.k();
            while (var6_7.f()) {
                var7_8 = var6_7.a().c();
                v0 = var1_1.contains(var7_8);
                if (!var9_3) {
                    if (v0 && (var8_9 = this.c.a(var7_8).j()) <= var5_6) {
                        ++var3_4;
                    }
                    var6_7.g();
                    if (!var9_3) continue;
                }
                ** GOTO lbl18
            }
            var6_7 = var2_2.l();
            do {
                v0 = var6_7.f();
lbl18: // 2 sources:
                if (!v0) break;
                var7_8 = var6_7.a().d();
                v1 = var1_1.contains(var7_8);
                if (var9_3) break block5;
                if (v1 != 0 && (var8_9 = this.c.a(var7_8).j()) >= var5_6) {
                    ++var4_5;
                }
                var6_7.g();
            } while (!var9_3);
            v1 = var3_4;
        }
        if (v1 > var4_5) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private boolean a(y.c.y var1_1, int var2_2, int var3_3) {
        var12_4 = N.x;
        var4_5 = 0;
        var5_6 = 0;
        var6_7 = new HashSet<E>(var1_1);
        var7_8 = var1_1.a();
        block0 : do {
            v0 = var7_8.f();
            block1 : while (v0) {
                var8_9 = this.c.a(var7_8.e()).j();
                if (var12_4 != false) return false;
                var9_10 = var7_8.e().k();
                while (var9_10.f()) {
                    var10_11 = var9_10.a().c();
                    v1 = var6_7.contains(var10_11);
                    if (!var12_4) {
                        if (!v1 && (var11_12 = this.c.a(var10_11).j()) >= var2_2 && var11_12 <= var8_9) {
                            ++var4_5;
                        }
                        var9_10.g();
                        if (!var12_4) continue;
                    }
                    ** GOTO lbl24
                }
                var9_10 = var7_8.e().l();
                do {
                    v1 = var9_10.f();
lbl24: // 2 sources:
                    if (!v1) break;
                    var10_11 = var9_10.a().d();
                    v0 = var6_7.contains(var10_11);
                    if (var12_4) continue block1;
                    if (!v0 && (var11_12 = this.c.a(var10_11).j()) <= var3_3 && var11_12 >= var8_9) {
                        ++var5_6;
                    }
                    var9_10.g();
                } while (!var12_4);
                var7_8.g();
                if (!var12_4) continue block0;
            }
            break block0;
            break;
        } while (true);
        if (var4_5 > var5_6) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private void a(y.c.q var1_1, aU var2_2, D[] var3_3, int var4_4) {
        var8_5 = N.x;
        var5_6 = this.h(var1_1).a();
        do {
            if (var5_6.f() == false) return;
            var6_7 = var5_6.e();
            if (!this.d(var6_7)) ** GOTO lbl-1000
            this.a(var6_7, var2_2, var3_3, var4_4);
            if (var8_5) lbl-1000: // 2 sources:
            {
                var7_8 = this.c.a(var6_7).j();
                var2_2.a(var7_8).b(var6_7);
                var3_3[var7_8 - var4_4].add(var6_7);
            }
            var5_6.g();
        } while (!var8_5);
    }

    private boolean a(y.c.q q2, Set set) {
        boolean bl2 = N.x;
        y.c.q q3 = this.i(q2);
        do {
            if (q3 == null) return false;
            boolean bl3 = set.contains(q3);
            if (bl2) return bl3;
            if (bl3) {
                return true;
            }
            q3 = this.i(q3);
        } while (!bl2);
        return false;
    }

    bK a(y.c.q q2) {
        if (!this.a()) return null;
        this.j(q2);
        return ((bK[])this.n.get(q2))[0];
    }

    bK b(y.c.q q2) {
        if (!this.a()) return null;
        this.j(q2);
        return ((bK[])this.n.get(q2))[1];
    }

    /*
     * Exception decompiling
     */
    private void j(y.c.q var1_1) {
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

    void g(aU aU2) {
        boolean bl2 = N.x;
        if (!this.k()) {
            return;
        }
        float[] arrf = new float[this.b.e()];
        this.a(0, aU2.b());
        if (this.j.g == null) return;
        if (this.j.h == null) {
            return;
        }
        int n2 = this.j.g.c();
        int n3 = this.j.h.c();
        int n4 = n2;
        while (n4 <= n3) {
            block5 : {
                y.c.y y2 = aU2.a(n4).d();
                int n5 = 0;
                if (bl2) return;
                for (p p2 = y2.k(); p2 != null; p2 = p2.a(), ++n5) {
                    y.c.q q2 = (y.c.q)p2.c();
                    arrf[q2.d()] = n5;
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block5;
                }
                this.j.a(n4, arrf, this.d(), this.c, true);
                this.j.a(n4, true, this.d());
                this.j.a(n4, y2.k());
                ++n4;
            }
            if (!bl2) continue;
        }
        this.g();
    }

    void a(y.c.c c2) {
        this.g = c2;
    }

    y.c.c d() {
        return this.g;
    }

    void a(int n2) {
        if (!this.k()) {
            return;
        }
        this.j.a(n2);
    }

    /*
     * Unable to fully structure code
     */
    void a(D[] var1_1, int[] var2_2, boolean var3_3) {
        block6 : {
            var10_4 = N.x;
            if (!this.k()) {
                return;
            }
            var4_5 = this.d();
            var5_6 = new float[this.b.e()];
            if (!var3_3) ** GOTO lbl12
            for (var6_7 = 0; var6_7 < var5_6.length; ++var6_7) {
                var5_6[var6_7] = var2_2[var6_7];
                if (!var10_4) {
                    if (!var10_4) continue;
                }
                break block6;
lbl12: // 3 sources:
                for (var6_7 = 0; var6_7 < var5_6.length; ++var6_7) {
                    var5_6[var6_7] = this.o.nextFloat();
                    if (!var10_4) {
                        if (!var10_4) continue;
                    }
                    break block6;
                }
            }
            this.a(0, var1_1.length);
            var6_7 = this.j.g.c();
        }
        var7_8 = this.j.h.c();
        for (var8_9 = var6_7; var8_9 <= var7_8; ++var8_9) {
            var9_10 = var1_1[var8_9];
            this.j.a(var8_9, var5_6, var4_5, this.c, true);
            this.j.a(var8_9, true, var4_5);
            this.j.a(var8_9, var9_10.k());
            this.a(var9_10, var2_2);
            if (var10_4 != false) return;
            if (!var10_4) continue;
        }
        this.g();
    }

    void a(int n2, int n3) {
        boolean bl2 = N.x;
        if (!this.k()) {
            return;
        }
        ArrayList arrayList = this.j.d;
        int n4 = arrayList.size() - 1;
        do {
            if (n4 < 0) return;
            dg dg2 = (dg)arrayList.get(n4);
            if (dg2.g != null && dg2.h != null && dg2.g.c() >= n2 && dg2.h.c() <= n3) {
                dg2.r = -1;
            }
            --n4;
        } while (!bl2);
    }

    private void a(D d2, int[] arrn) {
        boolean bl2 = N.x;
        if (!this.k()) {
            return;
        }
        int n2 = 0;
        p p2 = d2.k();
        do {
            if (p2 == null) return;
            y.c.q q2 = (y.c.q)p2.c();
            arrn[q2.d()] = n2++;
            p2 = p2.a();
        } while (!bl2);
    }

    void a(D d2, int n2, float[] arrf, int[] arrn, boolean bl2) {
        if (!this.k()) {
            return;
        }
        y.c.c c2 = this.d();
        this.j.a(n2, arrf, c2, this.c, bl2);
        this.j.a(n2, bl2, c2);
        this.j.a(n2, d2.k());
        this.a(d2, arrn);
    }

    void e() {
        if (!this.k()) {
            return;
        }
        this.j.c();
    }

    void f() {
        this.j = null;
        if (this.f == null) return;
        this.b.a(f.d, this.f);
    }

    void a(aU aU2, aP aP2) {
        boolean bl2 = N.x;
        if (!this.k()) {
            return;
        }
        HashMap<y.c.q, y.c.q> hashMap = new HashMap<y.c.q, y.c.q>();
        HashMap<y.c.q, y.c.q> hashMap2 = new HashMap<y.c.q, y.c.q>();
        int n2 = 0;
        do {
            int n3 = n2;
            int n4 = aU2.b();
            block1 : do {
                if (n3 >= n4) return;
                aQ aQ2 = aU2.a(n2);
                y.c.y y2 = aQ2.d();
                for (p p2 = y2.k(); p2 != null; p2 = p2.a()) {
                    y.c.q q2;
                    y.c.q q3;
                    y.c.q q4 = (y.c.q)p2.c();
                    aX aX2 = this.c.a(q4);
                    byte by2 = aX2.b();
                    n3 = aX2.b();
                    n4 = 12;
                    if (bl2) continue block1;
                    if (n3 == n4) {
                        q3 = aX2.f();
                        q2 = (y.c.q)hashMap.get(q3);
                        if (q2 != null && q2.a(q4) == null) {
                            aP2.a(q2, q4);
                        }
                        hashMap.put(q3, q4);
                    }
                    if (aX2.b() != 13) continue;
                    q3 = aX2.f();
                    q2 = (y.c.q)hashMap2.get(q3);
                    if (q2 != null && q2.a(q4) == null) {
                        aP2.a(q2, q4);
                    }
                    hashMap2.put(q3, q4);
                    if (!bl2) continue;
                }
                break;
            } while (true);
            ++n2;
        } while (!bl2);
    }

    void b(aU aU2, aP aP2) {
        if (!this.k()) {
            return;
        }
        this.g();
        this.j.a(aU2, aP2);
    }

    void g() {
        boolean bl2 = N.x;
        this.j.b();
        Iterator iterator = this.j.d.iterator();
        do {
            if (!iterator.hasNext()) return;
            dg dg2 = (dg)iterator.next();
            dg2.b();
        } while (!bl2);
    }

    void h(aU aU2) {
        Object object;
        boolean bl2;
        block6 : {
            bl2 = N.x;
            if (!this.k()) {
                return;
            }
            int n2 = 0;
            block0 : do {
                int n3 = n2;
                int n4 = aU2.b();
                block1 : while (n3 < n4) {
                    object = aU2.a(n2);
                    y.c.y y2 = object.d();
                    if (bl2) break block6;
                    for (p p2 = y2.k(); p2 != null; p2 = p2.a()) {
                        y.c.q q2 = (y.c.q)p2.c();
                        byte by2 = this.c.a(q2).b();
                        n3 = by2;
                        n4 = 12;
                        if (bl2) continue block1;
                        if (n3 != n4 && by2 != 13) continue;
                        y2.h(p2);
                        if (!bl2) continue;
                    }
                    object.a(y2);
                    ++n2;
                    if (!bl2) continue block0;
                }
                break block0;
                break;
            } while (true);
            this.j.b(this.c);
        }
        x x2 = this.b.o();
        do {
            if (!x2.f()) return;
            object = x2.e();
            byte by3 = this.c.a((y.c.q)object).b();
            if (by3 == 12 || by3 == 13) {
                this.b.a((y.c.q)object);
            }
            x2.g();
        } while (!bl2);
    }

    r c(y.c.q q2) {
        if (!this.k()) {
            return null;
        }
        r r2 = null;
        y.c.c c2 = this.b.c(f.e);
        if (c2 == null) return new r(0.0, 0.0, 0.0, 0.0);
        r2 = r.a(c2.b(q2));
        if (r2 != null) return r2;
        return new r(0.0, 0.0, 0.0, 0.0);
    }

    void a(cr cr2, aQ aQ2, boolean bl2, double d2) {
        if (!this.k()) {
            return;
        }
        this.j.a(cr2, aQ2, bl2, d2);
    }

    /*
     * Exception decompiling
     */
    void b(cr var1_1, aQ var2_2, boolean var3_3, double var4_4) {
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

    public double h() {
        return this.k;
    }

    public void a(double d2) {
        this.k = d2;
    }

    void i(aU aU2) {
        if (!this.k()) return;
        this.j.a(aU2, this.c);
    }

    void j(aU aU2) {
        if (!this.k()) return;
        this.j.b(aU2, this.c);
    }

    /*
     * Unable to fully structure code
     */
    void b(aU var1_1, y.c.A var2_2) {
        var7_3 = N.x;
        if (!this.k()) {
            return;
        }
        var3_4 = this.b.o();
        while (var3_4.f()) {
            var4_5 = var3_4.e();
            var5_6 = this.c.a(var4_5);
            v0 = var5_6.b();
            v1 = 12;
            if (!var7_3) {
                if (v0 == v1 || var5_6.b() == 13) {
                    var2_2.a((Object)var4_5, true);
                }
                var3_4.g();
                if (!var7_3) continue;
            }
            ** GOTO lbl25
        }
        this.a(var1_1, var2_2);
        this.c(var1_1);
        var3_4 = this.b.o();
        do {
            if (var3_4.f() == false) return;
            var4_5 = var3_4.e();
            var5_6 = this.c.a(var4_5);
            v0 = var5_6.b();
            v1 = 12;
lbl25: // 2 sources:
            if (v0 == v1 || var5_6.b() == 13) {
                var6_7 = this.f(var5_6.l());
                if (var6_7.g != null && var6_7.h != null && var6_7.g.c() <= var5_6.j() && var6_7.h.c() >= var5_6.j()) {
                    var2_2.a((Object)var4_5, false);
                }
            }
            var3_4.g();
        } while (!var7_3);
    }

    public void k(aU aU2) {
        if (!this.k()) {
            return;
        }
        this.j.a(aU2);
    }

    public boolean d(y.c.q q2) {
        if (!this.k()) {
            return false;
        }
        if (this.j.c.b(q2) == null) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    void c(aU var1_1, aP var2_2) {
        block40 : {
            var24_3 = N.x;
            if (!this.k()) {
                return;
            }
            this.c();
            var3_4 = new HashMap<Object, Object>();
            var4_5 = new y.c.y();
            var5_6 = this.b.p();
            while (var5_6.f()) {
                block41 : {
                    var6_7 = var5_6.a();
                    var7_9 = this.c.a(var6_7);
                    var8_10 = var6_7.c();
                    var9_11 = var6_7.d();
                    v0 = this;
                    if (var24_3) break block40;
                    if (!v0.d((y.c.q)var8_10)) ** GOTO lbl94
                    var10_12 = null;
                    var11_13 = null;
                    if (var7_9.g() == null) ** GOTO lbl23
                    var11_13 = new L(this, var8_10, var7_9.g());
                    if (var11_13 != null) {
                        var10_12 = (y.c.q)var3_4.get(var11_13);
                    }
                    if (var10_12 != null) ** GOTO lbl90
lbl23: // 2 sources:
                    var12_14 = var8_10;
                    var13_15 = var9_11;
                    var14_16 = this.f((y.c.q)var12_14);
                    var15_17 = var14_16.g;
                    var16_18 = var14_16.h;
                    var17_19 = this.c.a((y.c.q)var13_15);
                    if (var17_19 == null) throw new IllegalStateException(new StringBuffer().append("nodeData == null for node ").append(var13_15).toString());
                    v1 = var18_20 = var7_9.c() != null && var7_9.c().g() == false ? var7_9.c() : null;
                    if (var18_20 != null) {
                        var2_2.a(var6_7, true, aE.a(var18_20.b()));
                    }
                    if (var18_20 == null || !var18_20.c()) ** GOTO lbl36
                    var19_21 = var15_17;
                    if (!var24_3) ** GOTO lbl83
lbl36: // 2 sources:
                    if (var18_20 == null || !var18_20.d()) ** GOTO lbl39
                    var19_21 = var16_18;
                    if (!var24_3) ** GOTO lbl83
lbl39: // 2 sources:
                    if (this.d((y.c.q)var13_15)) ** GOTO lbl55
                    if (var15_17.c() <= var17_19.j()) ** GOTO lbl43
                    var19_21 = var15_17;
                    if (!var24_3) ** GOTO lbl83
lbl43: // 2 sources:
                    if (var16_18.c() >= var17_19.j()) ** GOTO lbl46
                    var19_21 = var16_18;
                    if (!var24_3) ** GOTO lbl83
lbl46: // 2 sources:
                    if (var18_20 != null || !this.a((y.c.q)var13_15, (y.c.q)var12_14)) ** GOTO lbl53
                    var19_21 = var16_18;
                    var2_2.a(var6_7, true, aE.a(2));
                    v2 = var20_22 = var7_9.e() != null && var7_9.e().g() == false ? var7_9.e() : null;
                    if (var20_22 != null) ** GOTO lbl83
                    var2_2.a(var6_7, false, aE.a(1));
                    if (!var24_3) ** GOTO lbl83
lbl53: // 2 sources:
                    var19_21 = var1_1.a(var17_19.j());
                    if (!var24_3) ** GOTO lbl83
lbl55: // 2 sources:
                    var20_22 = this.f((y.c.q)var13_15);
                    if (!this.a((y.c.q)var13_15, (y.c.q)var12_14) && !this.a((y.c.q)var12_14, var20_22.f)) ** GOTO lbl61
                    var19_21 = var16_18;
                    if (var18_20 != null) ** GOTO lbl83
                    var2_2.a(var6_7, true, aE.a(2));
                    if (!var24_3) ** GOTO lbl83
lbl61: // 2 sources:
                    if (var12_14 != var20_22.f) ** GOTO lbl71
                    v3 = var21_23 = var7_9.e() != null && var7_9.e().g() == false ? var7_9.e() : null;
                    if (var18_20 != null && var21_23 != null && var21_23.d() && (var18_20.e() || var18_20.f())) {
                        var19_21 = var16_18;
                        if (!var24_3) break block41;
                    }
                    var19_21 = var15_17;
                }
                if (var18_20 != null) ** GOTO lbl83
                var2_2.a(var6_7, true, aE.a(2));
                if (!var24_3) ** GOTO lbl83
lbl71: // 2 sources:
                if (var15_17.c() <= var20_22.h.c()) ** GOTO lbl74
                var19_21 = var15_17;
                if (!var24_3) ** GOTO lbl83
lbl74: // 2 sources:
                if (var16_18.c() >= var20_22.g.c()) ** GOTO lbl-1000
                var19_21 = var16_18;
                if (var24_3) lbl-1000: // 2 sources:
                {
                    var21_24 = Math.max(var15_17.c(), var20_22.g.c());
                    var22_26 = Math.min(var16_18.c(), var20_22.h.c());
                    if (var22_26 < var21_24) {
                        throw new IllegalStateException("huh?");
                    }
                    var23_27 = (var21_24 + var22_26) / 2;
                    var19_21 = var1_1.a(var23_27);
                }
lbl83: // 15 sources:
                var10_12 = var2_2.a((y.c.q)var12_14, var14_16, var19_21, var6_7);
                if (var11_13 != null) {
                    var3_4.put(var11_13, var10_12);
                }
                var4_5.add(var10_12);
                this.j.a(var10_12, var14_16);
                if (var24_3) {
                    throw new IllegalStateException(new StringBuffer().append("nodeData == null for node ").append(var13_15).toString());
                }
lbl90: // 3 sources:
                var12_14 = this.b.p(var6_7);
                this.b.a(var6_7, (y.c.q)var10_12, var6_7.d());
                this.b.a((y.c.q)var10_12, (t)var12_14);
                this.b.a(var6_7, t.c);
lbl94: // 2 sources:
                if (!this.d((y.c.q)var9_11)) ** GOTO lbl170
                var10_12 = null;
                var11_13 = null;
                if (var7_9.h() == null) ** GOTO lbl-1000
                var11_13 = new L(this, var9_11, var7_9.h());
                if (var11_13 != null) {
                    var10_12 = (y.c.q)var3_4.get(var11_13);
                }
                if (var10_12 == null) lbl-1000: // 2 sources:
                {
                    var12_14 = var9_11;
                    var13_15 = var8_10;
                    var14_16 = this.f((y.c.q)var12_14);
                    var15_17 = var14_16.g;
                    var16_18 = var14_16.h;
                    var17_19 = this.c.a((y.c.q)var13_15);
                    if (var17_19 == null) throw new IllegalStateException(new StringBuffer().append("nodeData == null for node ").append(var13_15).toString());
                    var18_20 = null;
                    v4 = var19_21 = var7_9.e() != null && var7_9.e().g() == false ? var7_9.e() : null;
                    if (var19_21 != null) {
                        var2_2.a(var6_7, false, aE.a(var19_21.b()));
                    }
                    if (var19_21 != null && var19_21.c()) {
                        var18_20 = var15_17;
                    } else if (var19_21 != null && var19_21.d()) {
                        var18_20 = var16_18;
                    } else if (!this.d((y.c.q)var13_15)) {
                        if (var15_17.c() > var17_19.j()) {
                            var18_20 = var15_17;
                        } else if (var16_18.c() < var17_19.j()) {
                            var18_20 = var16_18;
                        } else if (var19_21 == null && this.a((y.c.q)var13_15, (y.c.q)var12_14)) {
                            var18_20 = var15_17;
                            v5 = var20_22 = var7_9.c() != null && var7_9.c().g() == false ? var7_9.c() : null;
                            if (var20_22 == null) {
                                var2_2.a(var6_7, true, aE.a(2));
                            }
                            var2_2.a(var6_7, false, aE.a(1));
                        } else {
                            var18_20 = var1_1.a(var17_19.j());
                        }
                    } else {
                        var20_22 = this.f((y.c.q)var13_15);
                        if (this.a((y.c.q)var13_15, (y.c.q)var12_14) || this.a((y.c.q)var12_14, var20_22.f)) {
                            var18_20 = var15_17;
                            if (var19_21 == null) {
                                var2_2.a(var6_7, false, aE.a(1));
                            }
                        } else if (var12_14 == var20_22.f) {
                            var21_23 = var7_9.c() != null && var7_9.c().g() == false ? var7_9.c() : null;
                            var18_20 = var21_23 != null && var19_21 != null && var21_23.d() != false && (var19_21.e() != false || var19_21.f() != false) ? var16_18 : var15_17;
                            if (var19_21 == null) {
                                var2_2.a(var6_7, false, aE.a(1));
                            }
                        } else if (var15_17.c() > var20_22.h.c()) {
                            var18_20 = var15_17;
                        } else if (var16_18.c() < var20_22.g.c()) {
                            var18_20 = var16_18;
                        } else {
                            var21_25 = Math.max(var15_17.c(), var20_22.g.c());
                            var22_26 = Math.min(var16_18.c(), var20_22.h.c());
                            if (var22_26 < var21_25) {
                                throw new IllegalStateException("huh?");
                            }
                            var23_27 = (var21_25 + var22_26) / 2;
                            var18_20 = var1_1.a(var23_27);
                        }
                    }
                    var10_12 = var2_2.a((y.c.q)var12_14, var14_16, (aQ)var18_20, var6_7);
                    if (var11_13 != null) {
                        var3_4.put(var11_13, var10_12);
                    }
                    var4_5.add(var10_12);
                    this.j.a(var10_12, var14_16);
                    if (var24_3) {
                        throw new IllegalStateException(new StringBuffer().append("nodeData == null for node ").append(var13_15).toString());
                    }
                }
                var12_14 = this.b.q(var6_7);
                this.b.a(var6_7, var6_7.c(), (y.c.q)var10_12);
                this.b.a((y.c.q)var10_12, (t)var12_14);
                this.b.b(var6_7, t.c);
lbl170: // 2 sources:
                var5_6.g();
                if (!var24_3) continue;
            }
            this.b();
            v0 = this;
        }
        if ((var5_6 = v0.l()) == null) return;
        var6_8 = var5_6.a * 0.5;
        var8_10 = (y.c.A)this.b.c(cp.a);
        var9_11 = (y.c.A)this.b.c(cp.b);
        var10_12 = var4_5.a();
        do {
            if (var10_12.f() == false) return;
            var11_13 = var10_12.e();
            var8_10.a(var11_13, var6_8);
            var9_11.a(var11_13, var6_8);
            var10_12.g();
        } while (!var24_3);
    }

    private q l() {
        y.c.c c2 = this.b.c(N.u);
        if (c2 != null) return (q)c2.b(this.b);
        return null;
    }

    private boolean a(y.c.q q2, d d2, aV aV2) {
        return this.a(q2, d2, aV2, 8);
    }

    private boolean b(y.c.q q2, d d2, aV aV2) {
        return this.a(q2, d2, aV2, 4);
    }

    private boolean a(y.c.q q2, d d2, aV aV2, byte by2) {
        boolean bl2 = q2 == d2.c();
        A a2 = aV2.a(d2);
        aE aE2 = bl2 ? a2.c() : a2.e();
        if (aE2 == null) return false;
        if (aE2.b() != by2) return false;
        return true;
    }

    private y.c.q a(y.c.q q2, D d2, aV aV2) {
        y.c.q q3 = (y.c.q)d2.f();
        if (aV2.a(q3).b() != 12) return this.a(q2, d2, aV2, 12);
        return q3;
    }

    private y.c.q b(y.c.q q2, D d2, aV aV2) {
        y.c.q q3 = (y.c.q)d2.i();
        if (aV2.a(q3).b() != 13) return this.a(q2, d2, aV2, 13);
        return q3;
    }

    private y.c.q a(y.c.q q2, D d2, aV aV2, byte by2) {
        boolean bl2 = N.x;
        p p2 = d2.k();
        do {
            aX aX2;
            y.c.q q3;
            if (p2 == null) return null;
            if (p2.c() instanceof y.c.q && (aX2 = aV2.a(q3 = (y.c.q)p2.c())).l() == q2 && aX2.b() == by2) {
                return q3;
            }
            p2 = p2.a();
        } while (!bl2);
        return null;
    }

    void i() {
        boolean bl2 = N.x;
        if (!this.k()) {
            return;
        }
        y.c.C c2 = this.h.m();
        do {
            if (!c2.f()) return;
            M m2 = (M)c2.d();
            M.a(m2);
            c2.g();
        } while (!bl2);
    }

    void a(X x2, aV aV2) {
        boolean bl2 = N.x;
        this.a.clear();
        e e2 = x2.p();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            A a2 = aV2.a(d2);
            aX aX2 = aV2.a(d2.c());
            aX aX3 = aV2.a(d2.d());
            aE aE2 = a2.c();
            if (aX2.b() == 15 && aX3.b() == aX2.b() && aX2.l() == aX3.l() && aE2 != null && aE2 == a2.e() && (aE2.e() || aE2.f())) {
                this.a.add(d2);
                x2.d(d2);
            }
            e2.g();
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    private double a(d var1_1) {
        var13_2 = N.x;
        var2_3 = this.c.a(var1_1).k();
        var3_4 = var2_3 != null ? Math.max(var2_3.a(), var2_3.b()) : 15.0;
        var5_5 = 0.0;
        var7_6 = this.b.d(var1_1);
        if (var7_6 == null) ** GOTO lbl12
        for (var8_7 = 0; var8_7 < var7_6.length; ++var8_7) {
            var5_5 = Math.max(var5_5, var7_6[var8_7].getBox().a());
            if (!var13_2) {
                if (!var13_2) continue;
            }
            ** GOTO lbl-1000
        }
lbl12: // 3 sources:
        if (var2_3 != null) {
            v0 = var2_3.d();
        } else lbl-1000: // 2 sources:
        {
            v0 = 5.0;
        }
        var8_8 = v0;
        var10_9 = this.l();
        var11_10 = var10_9 != null ? var10_9.a * 0.5 : 0.0;
        return var11_10 + var8_8 + Math.max(var5_5, var3_4);
    }

    /*
     * Unable to fully structure code
     */
    private double a(d var1_1, y.c.q var2_2) {
        var3_3 = 0.0;
        var5_4 = this.c.a(var1_1).k();
        if (var5_4 == null) ** GOTO lbl9
        var6_5 = this.c.a(var1_1).i();
        if ((var1_1.c() != var2_2 || var6_5) && (var1_1.d() != var2_2 || !var6_5)) ** GOTO lbl-1000
        var3_3 = var5_4.a();
        if (N.x) lbl-1000: // 2 sources:
        {
            var3_3 = var5_4.b();
        }
lbl9: // 4 sources:
        var6_6 = var5_4 != null ? var5_4.d() : 5.0;
        var8_7 = this.l();
        var9_8 = var8_7 != null ? var8_7.a * 0.5 : 0.0;
        return var9_8 + var6_6 + var3_3;
    }

    /*
     * Unable to fully structure code
     */
    void a(aU var1_1, cd var2_2) {
        block18 : {
            var23_3 = N.x;
            if (!this.k()) {
                return;
            }
            this.h.clear();
            var3_4 = (y.c.A)this.b.c(cp.a);
            var4_5 = (y.c.A)this.b.c(cp.b);
            var5_6 = this.a.a();
            while (var5_6.f()) {
                var6_8 = var5_6.a();
                this.b.e((d)var6_8);
                var7_9 = var6_8.c();
                var8_11 = this.c.a(var7_9);
                var9_12 = var6_8.d();
                var10_13 = this.c.a(var9_12);
                var11_14 = this.a(var7_9, (d)var6_8, this.c);
                var12_16 = var8_11.f();
                var13_17 = this.f((y.c.q)var12_16);
                var14_18 = var13_17.b(var8_11.j());
                v0 = (int)var11_14 ? 1 : 0;
                if (var23_3) break block18;
                var15_21 = v0 != 0 ? this.a((y.c.q)var12_16, var14_18, this.c) : this.b((y.c.q)var12_16, var14_18, this.c);
                this.h.add(new M(this, (d)var6_8, var7_9, var15_21));
                this.h.add(new M(this, (d)var6_8, var9_12, var15_21));
                this.b.a((d)var6_8, var15_21, var15_21);
                var16_24 = var1_1.a(var8_11.j());
                if (var7_9.a() == 0 && var8_11.e() == 0) {
                    this.b.c(var7_9);
                    var16_24.d().remove(var7_9);
                    var17_25 = this.f(var8_11.l());
                    var18_27 = var17_25.b(var8_11.j());
                    var18_27.remove(var7_9);
                }
                var16_24.a(var16_24.d());
                var17_25 = var1_1.a(var10_13.j());
                if (var9_12.a() == 0 && var10_13.e() == 0) {
                    this.b.c(var9_12);
                    var17_25.d().remove(var9_12);
                    var18_27 = this.f(var10_13.l());
                    var19_30 = var18_27.b(var10_13.j());
                    var19_30.remove(var9_12);
                }
                var17_25.a(var17_25.d());
                if (!var11_14) ** GOTO lbl-1000
                var18_26 = var3_4.c(var15_21);
                var3_4.a((Object)var15_21, Math.max(var18_26, this.a((d)var6_8)));
                if (var23_3) lbl-1000: // 2 sources:
                {
                    var18_26 = var4_5.c(var15_21);
                    var4_5.a((Object)var15_21, Math.max(var18_26, this.a((d)var6_8)));
                }
                var2_2.a(this.b, (d)var6_8);
                var5_6.g();
                if (!var23_3) continue;
            }
            v0 = 0;
        }
        var5_7 = v0;
        do {
            block19 : {
                v1 = var5_7;
                v2 = var1_1.b();
                block2 : do {
                    if (v1 >= v2) return;
                    var6_8 = var1_1.a(var5_7);
                    var7_10 = false;
                    for (var8_11 = var6_8.d().k(); var8_11 != null; var8_11 = var8_11.a()) {
                        var9_12 = (y.c.q)var8_11.c();
                        var10_13 = this.c.a(var9_12);
                        v1 = var10_13.b();
                        v2 = 15;
                        if (var23_3) continue block2;
                        if (v1 != v2) continue;
                        var11_15 = (as)var10_13;
                        var12_16 = var9_12.j();
                        while (var12_16.f()) {
                            block20 : {
                                var13_17 = var12_16.a();
                                var14_19 = this.a(var9_12, (d)var13_17, this.c);
                                var15_22 = this.b(var9_12, (d)var13_17, this.c);
                                v3 = var14_19;
                                if (var23_3) break block19;
                                if (!v3 && !var15_22) ** GOTO lbl100
                                var16_24 = var11_15.f();
                                var17_25 = this.f((y.c.q)var16_24);
                                var18_28 = var17_25.b(var11_15.j());
                                var19_30 = var14_19 != false ? this.a((y.c.q)var16_24, var18_28, this.c) : this.b((y.c.q)var16_24, var18_28, this.c);
                                this.h.add(new M(this, (d)var13_17, var9_12, (y.c.q)var19_30));
                                if (var13_17.c() == var9_12) {
                                    this.b.a((d)var13_17, (y.c.q)var19_30, var13_17.d());
                                    if (!var23_3) break block20;
                                }
                                this.b.a((d)var13_17, var13_17.c(), (y.c.q)var19_30);
                            }
                            var20_31 = this.c.a((d)var13_17).k();
                            if (!var14_19) ** GOTO lbl-1000
                            var21_32 = var3_4.c(var19_30);
                            var3_4.a(var19_30, Math.max(var21_32, this.a((d)var13_17, var9_12)));
                            if (var23_3) lbl-1000: // 2 sources:
                            {
                                var21_32 = var4_5.c(var19_30);
                                var4_5.a(var19_30, Math.max(var21_32, this.a((d)var13_17, var9_12)));
                            }
                            if (var9_12.a() == 0 && var10_13.e() == 0) {
                                this.b.c(var9_12);
                                var6_8.d().h((p)var8_11);
                                var7_10 = true;
                                var21_33 = this.f(var11_15.l());
                                var22_35 = var21_33.b(var11_15.j());
                                var22_35.remove(var9_12);
                            }
lbl100: // 4 sources:
                            var12_16.g();
                            if (!var23_3) continue;
                        }
                        for (var12_16 = var10_13.d(); var12_16 != null; var12_16 = var12_16.a()) {
                            block21 : {
                                var13_17 = (d)var12_16.c();
                                var14_20 = this.a(var9_12, (d)var13_17, this.c);
                                var15_23 = this.b(var9_12, (d)var13_17, this.c);
                                v3 = var14_20;
                                if (var23_3) break block19;
                                if (!v3 && !var15_23) continue;
                                var16_24 = var11_15.f();
                                var17_25 = this.f((y.c.q)var16_24);
                                var18_29 = var17_25.b(var11_15.j());
                                var19_30 = var14_20 != false ? this.a((y.c.q)var16_24, var18_29, this.c) : this.b((y.c.q)var16_24, var18_29, this.c);
                                var20_31 = (as)this.c.a((y.c.q)var19_30);
                                var20_31.a((d)var13_17);
                                var11_15.a((p)var12_16);
                                this.h.add(new M(this, (d)var13_17, var9_12, (y.c.q)var19_30));
                                if (var13_17.c() == var9_12) {
                                    this.b.a((d)var13_17, (y.c.q)var19_30, var13_17.d());
                                    if (!var23_3) break block21;
                                }
                                this.b.a((d)var13_17, var13_17.c(), (y.c.q)var19_30);
                            }
                            if (!var14_20) ** GOTO lbl-1000
                            var21_32 = var3_4.c(var19_30);
                            var3_4.a(var19_30, Math.max(var21_32, this.a((d)var13_17, var9_12)));
                            if (var23_3) lbl-1000: // 2 sources:
                            {
                                var21_32 = var4_5.c(var19_30);
                                var4_5.a(var19_30, Math.max(var21_32, this.a((d)var13_17, var9_12)));
                            }
                            if (var9_12.a() != 0 || var10_13.e() != 0) continue;
                            this.b.c(var9_12);
                            var6_8.d().h((p)var8_11);
                            var7_10 = true;
                            var21_34 = this.f(var11_15.l());
                            var22_35 = var21_34.b(var11_15.j());
                            var22_35.remove(var9_12);
                            if (!var23_3) continue;
                        }
                        if (!var23_3) continue;
                    }
                    break;
                } while (true);
                v3 = var7_10;
            }
            if (v3) {
                var6_8.a(var6_8.d());
            }
            ++var5_7;
        } while (!var23_3);
    }

    void a(X x2) {
        boolean bl2 = N.x;
        if (!this.k()) {
            return;
        }
        e e2 = x2.p();
        do {
            Object object;
            if (!e2.f()) return;
            d d2 = e2.a();
            y.c.q q2 = (y.c.q)this.l.b(d2);
            if (q2 != null) {
                if (!x2.f(q2)) {
                    x2.d(q2);
                }
                object = x2.p(d2);
                x2.a(q2, x2.l(d2.c()));
                x2.a(d2, q2, d2.d());
                x2.c(d2, (t)object);
            }
            if ((object = (y.c.q)this.m.b(d2)) != null) {
                if (!x2.f((y.c.q)object)) {
                    x2.d((y.c.q)object);
                }
                t t2 = x2.q(d2);
                x2.a((y.c.q)object, x2.l(d2.d()));
                x2.a(d2, d2.c(), (y.c.q)object);
                x2.d(d2, t2);
            }
            e2.g();
        } while (!bl2);
    }

    /*
     * Exception decompiling
     */
    void l(aU var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[DOLOOP]], but top level block is 2[WHILELOOP]
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

    void m(aU aU2) {
        boolean bl2 = N.x;
        if (!this.k()) {
            return;
        }
        this.j.c(aU2, this.c);
        int n2 = 0;
        do {
            if (n2 >= aU2.b()) return;
            y.c.y y2 = aU2.a(n2).d();
            this.j.a(n2, y2.k());
            aU2.a(n2).a(y2);
            ++n2;
        } while (!bl2);
    }

    /*
     * Exception decompiling
     */
    void j() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[DOLOOP]], but top level block is 5[WHILELOOP]
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

    void n(aU aU2) {
        boolean bl2;
        q q2;
        E e2;
        block7 : {
            bl2 = N.x;
            if (!this.k()) {
                return;
            }
            for (int i2 = 0; i2 < aU2.b(); ++i2) {
                e2 = this;
                if (!bl2) {
                    e2.j.a(aU2.a(i2), this.b);
                    if (!bl2) continue;
                }
                break block7;
            }
            e2 = this;
        }
        if ((q2 = e2.l()) == null) return;
        x x2 = this.b.o();
        do {
            int n2;
            if (!x2.f()) return;
            y.c.q q3 = x2.e();
            int n3 = n2 = this.c.a(q3).b();
            int n4 = 12;
            block2 : while (n3 == n4 || n2 == 13) {
                int n5 = 0;
                e e3 = q3.j();
                while (e3.f()) {
                    int n6;
                    d d2 = e3.a();
                    n3 = n6 = this.c.a(d2).a();
                    n4 = 6;
                    if (bl2) continue block2;
                    if (n3 != n4) {
                        ++n5;
                    }
                    e3.g();
                    if (!bl2) continue;
                }
                double d3 = Math.max((double)n5 * q2.b, this.b.q(q3));
                this.b.a(q3, new q(this.b.p(q3), d3));
                break;
            }
            x2.g();
        } while (!bl2);
    }

    void o(aU aU2) {
        boolean bl2 = N.x;
        if (!this.k()) {
            return;
        }
        int n2 = 0;
        do {
            int n3 = n2;
            block1 : do {
                if (n3 >= aU2.b()) return;
                aQ aQ2 = aU2.a(n2);
                int n4 = 0;
                for (p p2 = aQ2.d().k(); p2 != null; p2 = p2.a(), ++n4) {
                    y.c.q q2 = (y.c.q)p2.c();
                    aX aX2 = this.c.a(q2);
                    n3 = aX2 instanceof as;
                    if (bl2) continue block1;
                    if (n3 == 0) continue;
                    as as2 = (as)aX2;
                    as2.b(n4);
                    if (!bl2) continue;
                }
                break;
            } while (true);
            ++n2;
        } while (!bl2);
    }

    void a(D d2, boolean bl2, boolean bl3, y y2) {
        t t2;
        boolean bl4;
        int n2;
        t t3;
        boolean bl5 = N.x;
        if (d2.size() < 2) {
            return;
        }
        D d3 = new D(d2.m());
        if (bl2) {
            t2 = null;
            t3 = null;
            while (!d2.isEmpty()) {
                bl4 = y2.a((t)d2.f());
                if (!bl5) {
                    if (bl4) {
                        t2 = (t)d2.g();
                        if (!bl5) continue;
                    }
                    t3 = (t)d2.f();
                    if (t2 == null) break;
                    d2.a(this.a(t2, t3, y2));
                    break;
                }
                break;
            }
        } else {
            bl4 = bl3;
        }
        if (bl4) {
            t2 = null;
            t3 = null;
            while (!d2.isEmpty()) {
                n2 = (int)y2.a((t)d2.i()) ? 1 : 0;
                if (!bl5) {
                    if (n2 != 0) {
                        t2 = (t)d2.j();
                        if (!bl5) continue;
                    }
                    t3 = (t)d2.i();
                    if (t2 == null) break;
                    d2.b(this.a(t2, t3, y2));
                    break;
                }
                break;
            }
        } else {
            n2 = d2.size();
        }
        if (n2 >= 2) return;
        d2.clear();
        d2.a(d3);
    }

    private static boolean a(t t2, t t3) {
        double d2;
        double d3 = Math.abs(t2.a - t3.a);
        if (Math.abs(d3 - (d2 = Math.abs(t2.b - t3.b))) >= 0.001) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private t a(t var1_1, t var2_2, y var3_3) {
        var8_4 = N.x;
        if (var1_1 == null) return null;
        if (var2_2 == null) return null;
        if (E.a(var1_1, var2_2)) {
            return n.b(new n(var3_3), new m(var1_1, var2_2), 0.001);
        }
        var4_5 = var1_1.a();
        var6_6 = var1_1.b();
        if (var2_2.a >= var3_3.c()) ** GOTO lbl-1000
        var4_5 = var3_3.c();
        if (var8_4) lbl-1000: // 2 sources:
        {
            if (var2_2.a > var3_3.c() + var3_3.a()) {
                var4_5 = var3_3.c() + var3_3.a();
            }
        }
        if (var2_2.b < var3_3.d()) {
            var6_6 = var3_3.d();
            if (var8_4 == false) return new t(var4_5, var6_6);
        }
        if (var2_2.b <= var3_3.d() + var3_3.b()) return new t(var4_5, var6_6);
        var6_6 = var3_3.d() + var3_3.b();
        return new t(var4_5, var6_6);
    }

    public void d(aU aU2, aP aP2) {
        byte by2;
        block7 : {
            boolean bl2 = N.x;
            if (!this.k()) {
                return;
            }
            byte by3 = 0;
            int n2 = 0;
            block0 : do {
                int n3 = n2;
                int n4 = aU2.b();
                block1 : while (n3 < n4) {
                    aQ aQ2 = aU2.a(n2);
                    by2 = aQ2.e();
                    if (bl2) break block7;
                    if (by2 == 1) {
                        by3 = 1;
                        dg dg2 = this.j;
                        D d2 = new D();
                        d2.add(dg2);
                        for (p p2 = aQ2.d().k(); p2 != null; p2 = p2.a()) {
                            y.c.q q2 = (y.c.q)p2.c();
                            as as2 = (as)this.c.a(q2);
                            n3 = as2.b();
                            n4 = 1;
                            if (bl2) continue block1;
                            if (n3 == n4 || as2.b() == 4) {
                                as2.a(dg2.f);
                                dg2.b(q2);
                                this.j.a(dg2.f, as2);
                                if (!bl2) continue;
                            }
                            if (as2.b() == 12) {
                                dg2 = this.f(as2.l());
                                d2.c(dg2);
                                if (!bl2) continue;
                            }
                            if (as2.b() != 13) continue;
                            d2.g();
                            dg2 = (dg)d2.h();
                            if (!bl2) continue;
                        }
                    }
                    ++n2;
                    if (!bl2) continue block0;
                }
                break block0;
                break;
            } while (true);
            by2 = by3;
        }
        if (by2 == 0) return;
        this.d(aU2);
        this.o(aU2);
    }

    boolean e(y.c.q q2) {
        byte by2 = this.c.a(q2).b();
        if (by2 == 12) return true;
        if (by2 == 13) return true;
        return false;
    }

    double a(cr cr2, double d2, double d3) {
        c c2;
        if (!this.k()) return d3;
        c c3 = cr2.c().a(false, false);
        double d4 = c3.c(c2 = cr2.b().a(false, false));
        if (d4 >= d2) return d3;
        double d5 = d2 - d4;
        cr2.e(d5);
        d3 += d5;
        return d3;
    }

    void a(D[] arrd, int[] arrn, int[] arrn2) {
        H h2;
        ArrayList arrayList;
        boolean bl2;
        int[] arrn3;
        int[] arrn4;
        block3 : {
            bl2 = N.x;
            arrn3 = new int[this.j.d.size()];
            arrn4 = new int[this.j.d.size()];
            h2 = new H(this, arrn, arrn3, arrn4);
            int n2 = 0;
            while (n2 < this.j.d.size()) {
                arrayList = this.j.d;
                if (!bl2) {
                    dg dg2 = (dg)arrayList.get(n2);
                    dg2.u = n2++;
                    if (!bl2) continue;
                }
                break block3;
            }
            arrayList = new ArrayList();
        }
        ArrayList arrayList2 = arrayList;
        int n3 = 0;
        do {
            if (n3 >= arrd.length) return;
            dd dd2 = this.j;
            this.a(dd2, arrn, n3, arrn3, arrn4);
            int[] arrn5 = arrn2;
            int n4 = n3;
            arrn5[n4] = arrn5[n4] + this.a(dd2, n3, arrn, arrn3, arrn4, h2, 0);
            ++n3;
        } while (!bl2);
    }

    /*
     * Exception decompiling
     */
    private int a(dg var1_1, int var2_2, int[] var3_3, int[] var4_4, int[] var5_5, Comparator var6_6, int var7_7) {
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

    /*
     * Exception decompiling
     */
    private void a(dg var1_1, int[] var2_2, int var3_3, int[] var4_4, int[] var5_5) {
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

    dg f(y.c.q q2) {
        if (this.k()) return (dg)this.j.c.b(q2);
        return null;
    }

    public boolean k() {
        return this.j.a();
    }

    public void a(y.c.q q2, J j2) {
        if (!this.k()) {
            return;
        }
        dg dg2 = this.f(q2);
        this.a(dg2, j2);
    }

    /*
     * Unable to fully structure code
     */
    private void a(dg var1_1, J var2_2) {
        var6_3 = N.x;
        if (!this.k()) {
            return;
        }
        var3_4 = var1_1.f().iterator();
        do lbl-1000: // 4 sources:
        {
            if (var3_4.hasNext() == false) return;
            var4_5 = var3_4.next();
            if (!(var4_5 instanceof y.c.q)) ** GOTO lbl11
            var2_2.a((y.c.q)var4_5, var1_1.f);
            if (!var6_3) ** GOTO lbl-1000
lbl11: // 2 sources:
            if (!(var4_5 instanceof dg)) ** GOTO lbl-1000
            var5_6 = (dg)var4_5;
            this.a(var5_6, var2_2);
        } while (!var6_3);
    }

    public y.c.y g(y.c.q q2) {
        if (!this.k()) {
            return null;
        }
        y.c.y y2 = new y.c.y();
        this.a(this.f(q2), (J)new I(this, y2));
        return y2;
    }

    /*
     * Unable to fully structure code
     */
    public y.c.y h(y.c.q var1_1) {
        var7_2 = N.x;
        if (!this.k()) {
            return null;
        }
        var2_3 = this.f(var1_1);
        var3_4 = new y.c.y();
        var4_5 = var2_3.f().iterator();
        do lbl-1000: // 3 sources:
        {
            if (var4_5.hasNext() == false) return var3_4;
            var5_6 = var4_5.next();
            if (!(var5_6 instanceof y.c.q)) ** GOTO lbl13
            var3_4.add(var5_6);
            if (!var7_2) ** GOTO lbl-1000
lbl13: // 2 sources:
            var6_7 = (dg)var5_6;
            var3_4.add(var6_7.f);
        } while (!var7_2);
        return var3_4;
    }

    public y.c.q i(y.c.q q2) {
        if (this.k()) return this.j.a((Object)q2).f;
        return null;
    }

    public boolean a(y.c.q q2, y.c.q q3) {
        y.c.q q4;
        block2 : {
            boolean bl2 = N.x;
            y.c.q q5 = this.i(q2);
            while (q3 != q5) {
                q4 = q5;
                if (!bl2) {
                    if (q4 == null) break;
                    q5 = this.i(q5);
                    if (!bl2) continue;
                }
                break block2;
            }
            q4 = q5;
        }
        if (q4 != q3) return false;
        return true;
    }
}

