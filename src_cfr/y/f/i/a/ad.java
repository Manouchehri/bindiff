/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.d.t;
import y.d.y;
import y.f.X;
import y.f.aA;
import y.f.am;
import y.f.ax;
import y.f.ay;
import y.f.i.a.I;
import y.f.i.a.K;
import y.f.i.a.N;
import y.f.i.a.Z;
import y.f.i.a.aE;
import y.f.i.a.aF;
import y.f.i.a.ab;

class aD
extends K {
    aD() {
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void a(Z var1_1, I var2_2) {
        var17_3 = ab.a;
        super.a(var1_1, var2_2);
        var3_4 = var1_1.a();
        var4_5 = var3_4.c(ay.a);
        var5_6 = var3_4.c(ax.a);
        var6_7 = var3_4.c(ax.b);
        if (var3_4.c(y.f.aF.a) == null && var3_4.c(y.f.aF.b) == null && var4_5 == null && var5_6 == null && var6_7 == null) {
            return;
        }
        var7_8 = var3_4.p();
        do lbl-1000: // 3 sources:
        {
            v0 = var7_8.f();
            block1 : do {
                block12 : {
                    if (v0 == false) return;
                    var8_9 = var7_8.a();
                    var9_10 = var8_9.c();
                    var10_11 = var8_9.d();
                    var11_12 = new D();
                    var12_13 = new D();
                    if (!this.a(var3_4, var8_9)) ** GOTO lbl26
                    var13_14 = y.f.aE.d(var3_4, var8_9);
                    if (var13_14 != null) {
                        var11_12.add(this.a((y.f.aE)var13_14, var3_4, var8_9, true));
                    }
                    if ((var14_15 = y.f.aE.e(var3_4, var8_9)) == null) ** GOTO lbl50
                    var12_13.add(this.a((y.f.aE)var14_15, var3_4, var8_9, false));
                    if (var17_3 == 0) ** GOTO lbl50
lbl26: // 2 sources:
                    if (!this.b(var3_4, var8_9)) ** GOTO lbl32
                    if (var5_6 != null && var5_6.b(var8_9) != null && !(var13_14 = (List)var5_6.b(var8_9)).isEmpty()) {
                        var11_12.addAll((Collection)var13_14);
                    }
                    if (var6_7 == null || var6_7.b(var8_9) == null || (var13_14 = (List)var6_7.b(var8_9)).isEmpty()) ** GOTO lbl50
                    var12_13.addAll((Collection)var13_14);
                    if (var17_3 == 0) ** GOTO lbl50
lbl32: // 2 sources:
                    if (!this.c(var3_4, var8_9)) ** GOTO lbl50
                    if (var4_5 != null && var4_5.b(var9_10) != null) {
                        var13_14 = (ay)var4_5.b(var9_10);
                        var14_15 = var13_14.a();
                        while (var14_15.hasNext()) {
                            var15_16 = ((aA)var14_15.next()).a();
                            var11_12.add(var15_16);
                            if (var17_3 == 0) {
                                if (var17_3 == 0) continue;
                            }
                            break block12;
                        }
                    }
                    if (var4_5 == null || var4_5.b(var10_11) == null) ** GOTO lbl50
                    var13_14 = (ay)var4_5.b(var10_11);
                    var14_15 = var13_14.a();
                    while (var14_15.hasNext()) {
                        var15_16 = ((aA)var14_15.next()).a();
                        var12_13.add(var15_16);
                        if (var17_3 != 0) ** GOTO lbl-1000
                        if (var17_3 == 0) continue;
                    }
                }
                var13_14 = var11_12.iterator();
                while (var13_14.hasNext()) {
                    var14_15 = (ax)var13_14.next();
                    if (!var14_15.b()) continue;
                    v1 = this.a(var3_4, var9_10, (ax)var14_15);
                    if (var17_3 == 0) {
                        if (!v1) continue;
                        var15_16 = aD.a((ax)var14_15, var9_10);
                        var16_17 = new y(var15_16.a() - 0.5, var15_16.b() - 0.5, 1.0, 1.0);
                        this.b().a(var16_17, new aF(null));
                        if (var17_3 == 0) continue;
                    }
                    ** GOTO lbl66
                }
                var13_14 = var12_13.iterator();
                do lbl-1000: // 4 sources:
                {
                    v1 = var13_14.hasNext();
lbl66: // 2 sources:
                    if (!v1) break block1;
                    var14_15 = (ax)var13_14.next();
                    if (!var14_15.b()) ** GOTO lbl-1000
                    v0 = this.a(var3_4, var10_11, (ax)var14_15);
                    if (var17_3 != 0) continue block1;
                    if (!v0) ** GOTO lbl-1000
                    var15_16 = aD.a((ax)var14_15, var10_11);
                    var16_17 = new y(var15_16.a() - 0.5, var15_16.b() - 0.5, 1.0, 1.0);
                    this.b().a(var16_17, new aF(null));
                } while (var17_3 == 0);
                break;
            } while (true);
            var7_8.g();
        } while (var17_3 == 0);
    }

    private boolean a(X x2, d d2) {
        return y.f.aE.a(x2, d2);
    }

    private boolean b(X x2, d d2) {
        c c2 = x2.c(ax.a);
        c c3 = x2.c(ax.b);
        if (c2 != null) {
            if (c2.b(d2) != null) return true;
        }
        if (c3 == null) return false;
        if (c3.b(d2) == null) return false;
        return true;
    }

    private boolean c(X x2, d d2) {
        c c2 = x2.c(ay.a);
        if (c2 == null) return false;
        if (c2.b(d2.c()) != null) return true;
        if (c2.b(d2.d()) == null) return false;
        return true;
    }

    static t a(ax ax2, q q2) {
        X x2 = (X)q2.e();
        t t2 = x2.l(q2);
        double d2 = t2.a() + ax2.c();
        double d3 = t2.b() + ax2.d();
        return new t(d2, d3);
    }

    private boolean a(X x2, q q2, ax ax2) {
        am am2 = x2.a(q2);
        y y2 = new y(am2.getX() - 1.0E-6, am2.getY() - 1.0E-6, am2.getWidth() + 2.0E-6, am2.getHeight() + 2.0E-6);
        t t2 = x2.l(q2);
        t t3 = new t(t2.a() + ax2.c(), t2.b() + ax2.d());
        if (y.a(y2.c(), y2.d(), y2.a(), y2.b(), t3.a(), t3.b(), true)) return false;
        return true;
    }

    private ax a(y.f.aE aE2, X x2, d d2, boolean bl2) {
        t t2 = bl2 ? x2.n(d2) : x2.o(d2);
        if (!aE2.a()) return ax.a(aE2);
        return ax.a(t2.a(), t2.b(), aE2.b());
    }
}

