/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import java.util.Iterator;
import y.c.D;
import y.c.c;
import y.c.h;
import y.c.i;
import y.c.q;
import y.d.n;
import y.f.F;
import y.f.S;
import y.f.U;
import y.f.X;
import y.f.aE;
import y.f.aG;
import y.f.am;
import y.f.k.A;
import y.f.k.R;
import y.f.k.d;
import y.f.k.x;
import y.f.y;

class Q {
    private q a;
    private X b;

    Q(q q2, X x2) {
        this.a = q2;
        this.b = x2;
    }

    /*
     * Unable to fully structure code
     */
    void a(A var1_1, byte var2_2, double var3_3, F var5_4) {
        block31 : {
            var40_5 = d.g;
            var6_6 = this.a.g();
            if (var6_6 == null) {
                return;
            }
            var7_7 = this.b.c(U.a);
            if (var7_7 == null) {
                return;
            }
            var8_8 = (S[])var7_7.b(var6_6);
            if (var8_8 == null) {
                return;
            }
            if (var8_8.length == 0) {
                return;
            }
            if (var8_8.length == 1 && var8_8[0].b() == 0.0) {
                return;
            }
            if (var2_2 < 0) {
                var9_9 = aE.e(this.b, var6_6);
                if (var9_9 == null) {
                    var9_9 = aE.a(0);
                }
                var10_11 = var9_9.b();
                switch (var10_11) {
                    default: {
                        var2_2 = 0;
                        if (var40_5 == 0) break;
                    }
                    case 4: {
                        var2_2 = 1;
                        if (var40_5 == 0) break;
                    }
                    case 2: {
                        var2_2 = (byte)2;
                        if (var40_5 == 0) break;
                    }
                    case 8: {
                        var2_2 = (byte)3;
                    }
                }
            }
            var9_10 = var1_1.b();
            var11_12 = var1_1.c();
            var13_13 = var9_10;
            var15_14 = var11_12;
            var17_15 = this.b.a(this.a);
            var18_16 = this.a(var6_6, var2_2);
            var19_17 = new D();
            for (var20_18 = 0; var20_18 < var8_8.length; ++var20_18) {
                var5_4.a((i)this.b, var8_8[var20_18], var18_16);
                var19_17.add(new y.f.k.S(var8_8[var20_18], var20_18, null));
                if (var40_5 == 0) {
                    if (var40_5 == 0) continue;
                }
                break block31;
            }
            var19_17.o();
        }
        var20_19 = var19_17.iterator();
        while (var20_19.hasNext()) {
            var21_20 = (y.f.k.S)var20_19.next();
            var22_21 = var21_20.a;
            var23_22 = var20_19.hasNext() == false;
            var24_23 = var22_21.b();
            var26_24 = var22_21.c();
            var28_25 = Math.max(0.0, var22_21.f().h());
            var30_26 = this.a(var22_21, var18_16);
            switch (var2_2) {
                default: {
                    throw new IllegalStateException("Should not reach");
                }
                case 0: {
                    var33_28 = var1_1.f() - var26_24 - var3_3;
                    if (var30_26 != 3) ** GOTO lbl64
                    var31_27 = var9_10 - var24_23 - var28_25;
                    if (var40_5 == 0) ** GOTO lbl68
lbl64: // 2 sources:
                    if (var30_26 != 2) ** GOTO lbl-1000
                    var31_27 = var9_10 + var28_25;
                    if (var40_5 != 0) lbl-1000: // 2 sources:
                    {
                        var31_27 = var9_10 - var24_23 * 0.5;
                    }
lbl68: // 4 sources:
                    var11_12 = var1_1.f() - var26_24 - var3_3;
                    var1_1.a(var9_10, var11_12);
                    if (var40_5 == 0) break;
                }
                case 1: {
                    var31_27 = var1_1.g() + var3_3;
                    if (var30_26 != 0) ** GOTO lbl76
                    var33_28 = var11_12 - var26_24 - var28_25;
                    if (var40_5 == 0) ** GOTO lbl80
lbl76: // 2 sources:
                    if (var30_26 != 1) ** GOTO lbl-1000
                    var33_28 = var11_12 + var28_25;
                    if (var40_5 != 0) lbl-1000: // 2 sources:
                    {
                        var33_28 = var11_12 - var26_24 * 0.5;
                    }
lbl80: // 4 sources:
                    var9_10 = var1_1.g() + var24_23 + var3_3;
                    var1_1.a(var9_10, var11_12);
                    if (var40_5 == 0) break;
                }
                case 2: {
                    var33_28 = var1_1.h() + var3_3;
                    if (var30_26 != 2) ** GOTO lbl88
                    var31_27 = var9_10 + var28_25;
                    if (var40_5 == 0) ** GOTO lbl92
lbl88: // 2 sources:
                    if (var30_26 != 3) ** GOTO lbl-1000
                    var31_27 = var9_10 - var24_23 - var28_25;
                    if (var40_5 != 0) lbl-1000: // 2 sources:
                    {
                        var31_27 = var9_10 - var24_23 * 0.5;
                    }
lbl92: // 4 sources:
                    var11_12 = var1_1.h() + var26_24 + var3_3;
                    var1_1.a(var9_10, var11_12);
                    if (var40_5 == 0) break;
                }
                case 3: {
                    var31_27 = var1_1.e() - var24_23 - var3_3;
                    if (var30_26 != 1) ** GOTO lbl100
                    var33_28 = var11_12 + var28_25;
                    if (var40_5 == 0) ** GOTO lbl104
lbl100: // 2 sources:
                    if (var30_26 != 0) ** GOTO lbl-1000
                    var33_28 = var11_12 - var26_24 - var28_25;
                    if (var40_5 != 0) lbl-1000: // 2 sources:
                    {
                        var33_28 = var11_12 - var26_24 * 0.5;
                    }
lbl104: // 4 sources:
                    var9_10 = var1_1.e() - var24_23 - var3_3;
                    var1_1.a(var9_10, var11_12);
                }
            }
            var22_21.a(var31_27 - var17_15.getX(), var33_28 - var17_15.getY());
            var35_29 = new n(var22_21.a());
            var35_29.d(var17_15.getX(), var17_15.getY());
            var1_1.a(var35_29);
            if (!var23_22) continue;
            var36_30 = 0.0;
            var38_31 = 0.0;
            if (var40_5 != 0) return;
            switch (var2_2) {
                case 0: {
                    var38_31 = - var3_3;
                    if (var40_5 == 0) break;
                }
                case 1: {
                    var36_30 = var3_3;
                    if (var40_5 == 0) break;
                }
                case 2: {
                    var38_31 = var3_3;
                    if (var40_5 == 0) break;
                }
                case 3: {
                    var36_30 = - var3_3;
                }
            }
            var35_29.d(var36_30, var38_31);
            var1_1.a(var35_29);
            var9_10 += var36_30;
            var11_12 += var38_31;
            if (var40_5 == 0) continue;
        }
        var1_1.a(var13_13, var15_14, var9_10, var11_12);
    }

    private y a(y.c.d d2, byte by2) {
        h h2 = (h)this.b.c(x.q);
        boolean bl2 = h2.b(d2) != null;
        switch (by2) {
            case 0: {
                y y2;
                if (bl2) {
                    y2 = y.a;
                    return y2;
                }
                y2 = y.c;
                return y2;
            }
            case 1: {
                y y3;
                if (bl2) {
                    y3 = y.b;
                    return y3;
                }
                y3 = y.d;
                return y3;
            }
            case 2: {
                y y4;
                if (bl2) {
                    y4 = y.c;
                    return y4;
                }
                y4 = y.a;
                return y4;
            }
            case 3: {
                y y5;
                if (bl2) {
                    y5 = y.d;
                    return y5;
                }
                y5 = y.b;
                return y5;
            }
        }
        throw new IllegalStateException(new StringBuffer().append("Unknown node placer direction ").append(by2).toString());
    }

    private int a(S s2, y y2) {
        boolean bl2;
        aG aG2 = s2.f();
        if (aG2.m()) return 4;
        boolean bl3 = y2 == y.d || y2 == y.b;
        boolean bl4 = bl2 = y2 == y.a || y2 == y.c;
        if (aG2.u() && y2 == y.a) {
            if (aG2.l()) return 3;
        }
        if (aG2.u() && y2 == y.c) {
            if (aG2.n()) return 3;
        }
        if (aG2.v() && bl2) {
            if (aG2.l()) return 3;
        }
        if (aG2.w() && bl2 && aG2.l()) {
            return 3;
        }
        if (aG2.u() && y2 == y.a) {
            if (aG2.n()) return 2;
        }
        if (aG2.u() && y2 == y.c) {
            if (aG2.l()) return 2;
        }
        if (aG2.v() && bl2) {
            if (aG2.n()) return 2;
        }
        if (aG2.w() && bl2 && aG2.n()) {
            return 2;
        }
        if (aG2.u() && y2 == y.d) {
            if (aG2.n()) return 0;
        }
        if (aG2.u() && y2 == y.b) {
            if (aG2.l()) return 0;
        }
        if (aG2.v() && bl3) {
            if (aG2.l()) return 0;
        }
        if (aG2.w() && bl3 && aG2.n()) {
            return 0;
        }
        if (aG2.u() && y2 == y.d) {
            if (aG2.l()) return 1;
        }
        if (aG2.u() && y2 == y.b) {
            if (aG2.n()) return 1;
        }
        if (aG2.v() && bl3) {
            if (aG2.n()) return 1;
        }
        if (!aG2.w()) return 4;
        if (!bl3) return 4;
        if (!aG2.l()) return 4;
        return 1;
    }

    void a(A a2) {
        int n2 = d.g;
        am am2 = this.b.a(this.a);
        c c2 = this.b.c(U.b);
        if (c2 == null) return;
        S[] arrs = (S[])c2.b(this.a);
        if (arrs == null) return;
        double d2 = am2.getX() + am2.getWidth() / 2.0;
        double d3 = am2.getY() + am2.getHeight() / 2.0;
        int n3 = 0;
        do {
            if (n3 >= arrs.length) return;
            S s2 = arrs[n3];
            y.d.y y2 = s2.a().h();
            a2.b(y2.c + d2, y2.d + d3, y2.a, y2.b);
            ++n3;
        } while (n2 == 0);
    }
}

