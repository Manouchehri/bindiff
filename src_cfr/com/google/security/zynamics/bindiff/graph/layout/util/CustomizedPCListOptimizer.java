/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.util;

import com.google.security.zynamics.bindiff.graph.layout.util.CustomizedPCListOptimizer$1;
import com.google.security.zynamics.bindiff.graph.layout.util.CustomizedPCListOptimizer$EdgeOrderComparator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.t;
import y.f.X;
import y.f.aE;
import y.f.ax;
import y.f.c.a.A;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.br;
import y.g.M;

public class CustomizedPCListOptimizer
implements br {
    private boolean backloopRouting = false;

    private static boolean isBackwardEdge(d d2, y.c.A a2) {
        if (a2.a(d2.c()) <= a2.a(d2.d())) return false;
        return true;
    }

    private void assignEdgePorts(q q2, f f2, X x2, boolean bl2, aP aP2) {
        f f3 = new f();
        f f4 = new f();
        f f5 = new f();
        e e2 = f2.a();
        do {
            double d2;
            if (!e2.f()) {
                double d3 = x2.p(q2) * 0.5;
                d2 = d3 / 3.0;
                this.distributeEdges(f3, - d3, - d2, q2, x2, aP2, bl2);
                this.distributeEdges(f4, - d2, d2, q2, x2, aP2, bl2);
                this.distributeEdges(f5, d2, d3, q2, x2, aP2, bl2);
                return;
            }
            d d4 = e2.a();
            double d5 = d2 = bl2 ? x2.n(d4).a() : x2.o(d4).a();
            if (d2 < 0.0) {
                f3.add(d4);
            } else if (d2 > 0.0) {
                f5.add(d4);
            } else {
                f4.add(d4);
            }
            e2.g();
        } while (true);
    }

    private void distributeEdges(f f2, double d2, double d3, q q2, X x2, aP aP2, boolean bl2) {
        double d4 = x2.q(q2) * 0.5;
        double d5 = (d3 - d2) / (double)(f2.size() + 1);
        double d6 = d2 + d5;
        e e2 = f2.a();
        while (e2.f()) {
            d d7 = e2.a();
            if (bl2) {
                x2.a(d7, new t(d6, d4));
            } else {
                x2.b(d7, new t(d6, - d4));
            }
            byte by2 = bl2 ? 2 : 1;
            aP2.a(d7, bl2, aE.a(by2, true));
            e2.g();
            d6 += d5;
        }
    }

    private ax getCandidateWithDirection(Collection collection, byte by2) {
        ax ax2;
        if (collection == null) {
            return null;
        }
        Iterator iterator = collection.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while ((ax2 = (ax)iterator.next()).a() != by2);
        return ax2;
    }

    private aE transformToPortConstraint(ax ax2, d d2, boolean bl2, X x2) {
        if (!ax2.b()) return ax2.e();
        t t2 = new t(ax2.c(), ax2.d());
        if (bl2) {
            x2.a(d2, t2);
            return ax2.e();
        }
        x2.b(d2, t2);
        return ax2.e();
    }

    public boolean isBackloopRouting() {
        return this.backloopRouting;
    }

    @Override
    public void optimizeAfterLayering(X x2, aU aU2, aV aV2, aP aP2) {
        Object object;
        Object object2;
        y.c.A a2 = M.a();
        for (int i2 = 0; i2 < aU2.b(); ++i2) {
            object2 = aU2.a(i2);
            object = object2.d().a();
            while (object.f()) {
                a2.a((Object)object.e(), i2);
                object.g();
            }
        }
        e e2 = x2.p();
        while (e2.f()) {
            object2 = e2.a();
            if (!object2.e()) {
                object = aV2.a((d)object2);
                byte by2 = !this.backloopRouting && CustomizedPCListOptimizer.isBackwardEdge((d)object2, a2) ? 1 : 2;
                ax ax2 = this.getCandidateWithDirection(object.d(), by2);
                if (ax2 != null) {
                    aP2.a((d)object2, true, this.transformToPortConstraint(ax2, (d)object2, true, x2));
                } else {
                    aP2.a((d)object2, true, aE.a(by2));
                }
                byte by3 = !this.backloopRouting && CustomizedPCListOptimizer.isBackwardEdge((d)object2, a2) ? 2 : 1;
                ax ax3 = this.getCandidateWithDirection(object.f(), by3);
                if (ax3 != null) {
                    aP2.a((d)object2, false, this.transformToPortConstraint(ax3, (d)object2, false, x2));
                } else {
                    aP2.a((d)object2, false, aE.a(by3));
                }
            }
            e2.g();
        }
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void optimizeAfterSequencing(X var1_1, aU var2_2, aV var3_3, aP var4_4) {
        var5_5 = new ArrayList<q>(64);
        var6_6 = M.a();
        var7_7 = 0;
        var8_8 = var1_1.o();
        while (var8_8.f()) {
            var9_10 = var3_3.a(var8_8.e());
            var7_7 += var9_10.e();
            var8_8.g();
        }
        var8_9 = var1_1.e();
        var9_10 = new d[var7_7 / 2];
        var10_11 = 2;
        var11_12 = 0;
        block1 : do {
            if (var11_12 >= var2_2.b()) {
                var11_13 = var1_1.o();
                while (var11_13.f()) {
                    var12_15 = var11_13.e();
                    if (!var6_6.d(var12_15) && var3_3.a((q)var12_15).b() == 0) {
                        var13_16 = new f(var12_15.k());
                        var13_16.sort(new CustomizedPCListOptimizer$EdgeOrderComparator(this, var6_6, (q)var12_15, var3_3, null));
                        this.assignEdgePorts((q)var12_15, (f)var13_16, var1_1, false, var4_4);
                        var14_17 = new f(var12_15.l());
                        var14_17.sort(new CustomizedPCListOptimizer$EdgeOrderComparator(this, var6_6, (q)var12_15, var3_3, null));
                        this.assignEdgePorts((q)var12_15, (f)var14_17, var1_1, true, var4_4);
                    }
                    var11_13.g();
                }
                break;
            }
            var12_15 = var2_2.a(var11_12);
            var13_16 = var12_15.d().k();
            do {
                if (var13_16 == null) ** GOTO lbl37
                var14_17 = (q)var13_16.c();
                var15_18 = var3_3.a((q)var14_17);
                if (var15_18.e() <= 0) ** GOTO lbl57
                ** GOTO lbl39
lbl37: // 1 sources:
                ++var11_12;
                continue block1;
lbl39: // 3 sources:
                for (var16_19 = var15_18.d(); var16_19 != null; var16_19 = var16_19.a()) {
                    var17_20 = (d)var16_19.c();
                    if (var17_20.c() != var14_17) continue;
                    var18_21 = var1_1.d();
                    var6_6.a(var18_21, true);
                    var19_22 = var3_3.a((d)var17_20);
                    var5_5.add((q)var18_21);
                    if (var19_22.j()) {
                        var4_4.b((q)var18_21, (q)var14_17, (d)var17_20, false, true);
                        var4_4.a((q)var18_21, var17_20.d(), (d)var17_20, false, true);
                        var10_11 = Math.max(var10_11, var17_20.d().b());
                    } else {
                        var4_4.a((q)var14_17, (q)var18_21, (d)var17_20, true, false);
                        var4_4.b(var17_20.d(), (q)var18_21, (d)var17_20, true, false);
                        var10_11 = Math.max(var10_11, var17_20.d().c());
                    }
                    var10_11 = Math.max(2, var10_11);
                    var9_10[var18_21.d() - var8_9] = var17_20;
                }
lbl57: // 2 sources:
                var10_11 = Math.max(var10_11, Math.max(var14_17.b(), var14_17.c()));
                var13_16 = var13_16.a();
            } while (true);
            break;
        } while (true);
        for (var11_14 = 0; var11_14 < var5_5.size(); ++var11_14) {
            var12_15 = (q)var5_5.get(var11_14);
            var13_16 = var9_10[var12_15.d() - var8_9];
            var1_1.e((d)var13_16);
            var14_17 = var3_3.a((d)var13_16);
            if (var12_15.c() > 0) {
                var15_18 = var12_15.f();
                var16_19 = var12_15.h();
                var17_20 = var3_3.a((d)var15_18);
                var18_21 = var3_3.a((d)var16_19);
                if (var15_18.d() == var13_16.c()) {
                    if (var17_20.e() != var14_17.c()) {
                        var14_17 = var4_4.a((d)var13_16, true, var17_20.e());
                    }
                    if (var18_21.e() != var14_17.e()) {
                        var14_17 = var4_4.a((d)var13_16, false, var18_21.e());
                    }
                    var1_1.a((d)var13_16, var1_1.o((d)var15_18));
                    var1_1.b((d)var13_16, var1_1.o((d)var16_19));
                } else {
                    if (var18_21.e() != var14_17.c()) {
                        var14_17 = var4_4.a((d)var13_16, true, var18_21.e());
                    }
                    if (var17_20.e() != var14_17.e()) {
                        var14_17 = var4_4.a((d)var13_16, false, var17_20.e());
                    }
                    var1_1.a((d)var13_16, var1_1.o((d)var16_19));
                    var1_1.b((d)var13_16, var1_1.o((d)var15_18));
                }
            } else {
                var15_18 = var12_15.g();
                var16_19 = var12_15.i();
                var17_20 = var3_3.a((d)var15_18);
                var18_21 = var3_3.a((d)var16_19);
                if (var15_18.c() == var13_16.c()) {
                    if (var17_20.c() != var14_17.c()) {
                        var14_17 = var4_4.a((d)var13_16, true, var17_20.c());
                    }
                    if (var18_21.c() != var14_17.e()) {
                        var14_17 = var4_4.a((d)var13_16, false, var18_21.c());
                    }
                    var1_1.a((d)var13_16, var1_1.n((d)var15_18));
                    var1_1.b((d)var13_16, var1_1.n((d)var16_19));
                } else {
                    if (var18_21.c() != var14_17.c()) {
                        var14_17 = var4_4.a((d)var13_16, true, var18_21.c());
                    }
                    if (var17_20.c() != var14_17.e()) {
                        var14_17 = var4_4.a((d)var13_16, false, var17_20.c());
                    }
                    var1_1.a((d)var13_16, var1_1.n((d)var16_19));
                    var1_1.b((d)var13_16, var1_1.n((d)var15_18));
                }
            }
            var1_1.d((d)var13_16);
        }
        var11_14 = 0;
        while (var11_14 < var5_5.size()) {
            var12_15 = (q)var5_5.get(var11_14);
            var1_1.a((q)var12_15);
            ++var11_14;
        }
    }

    public void setBackloopRouting(boolean bl2) {
        this.backloopRouting = bl2;
    }
}

