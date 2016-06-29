/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.c;
import y.c.d;
import y.d.q;
import y.d.r;
import y.f.X;
import y.f.b.f;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.aY;
import y.f.c.a.z;

public class bM
implements z {
    private double a = 30.0;
    private double b = 15.0;
    private double c = 10.0;
    private double d = 15.0;

    /*
     * Unable to fully structure code
     */
    @Override
    public double a(X var1_1, aQ var2_2, aV var3_3, y.c.q var4_4, y.c.q var5_5) {
        var20_6 = N.x;
        if (var4_4 == null) return 0.0;
        if (var5_5 == null) {
            return 0.0;
        }
        var6_7 = var3_3.a(var4_4);
        var7_8 = var3_3.a(var5_5);
        var8_9 = var6_7.b();
        var9_10 = var7_8.b();
        var11_11 = 0.0;
        var13_12 = null;
        switch (var8_9) {
            default: {
                var10_13 = 0;
                if (!var20_6) break;
            }
            case 12: {
                var10_13 = 4;
                if (!var20_6) break;
            }
            case 13: {
                var10_13 = 5;
                if (!var20_6) break;
            }
            case 15: {
                var10_13 = 6;
                if (!var20_6) break;
            }
            case 2: {
                var13_12 = var6_7.g();
                if (var6_7.f() != var5_5 || (var14_14 = var3_3.a(var13_12).k()) == null) ** GOTO lbl31
                if (!(var4_4.b() == 0 ^ var3_3.a(var13_12).i())) ** GOTO lbl-1000
                var11_11 = var14_14.a();
                if (var20_6) lbl-1000: // 2 sources:
                {
                    var11_11 = var14_14.b();
                }
lbl31: // 4 sources:
                var10_13 = 1;
                break;
            }
            case 3: {
                var13_12 = var6_7.g();
                var14_14 = var3_3.a(var13_12).k();
                if (var14_14 == null || var6_7.f() != var5_5) ** GOTO lbl41
                if (!(var13_12.c() == var5_5 ^ var3_3.a(var13_12).i())) ** GOTO lbl-1000
                var11_11 = var14_14.a();
                if (var20_6) lbl-1000: // 2 sources:
                {
                    var11_11 = var14_14.b();
                }
            }
lbl41: // 5 sources:
            case 1: 
            case 8: 
            case 9: 
            case 10: {
                var13_12 = var6_7.g();
            }
            case 6: 
            case 7: {
                var10_13 = 1;
                break;
            }
            case 4: {
                var10_13 = 2;
                if (!var20_6) break;
            }
            case 11: {
                var10_13 = 3;
            }
        }
        var15_16 = null;
        switch (var9_10) {
            default: {
                var14_15 = 0;
                if (!var20_6) break;
            }
            case 13: {
                var14_15 = 4;
                if (!var20_6) break;
            }
            case 12: {
                var14_15 = 5;
                if (!var20_6) break;
            }
            case 15: {
                var14_15 = 6;
                if (!var20_6) break;
            }
            case 2: {
                var15_16 = var7_8.g();
                if (var7_8.f() != var4_4 || (var16_17 = var3_3.a(var15_16).k()) == null) ** GOTO lbl72
                if (!(var5_5.b() == 0 ^ var3_3.a(var15_16).i())) ** GOTO lbl-1000
                var11_11 = var16_17.a();
                if (var20_6) lbl-1000: // 2 sources:
                {
                    var11_11 = var16_17.b();
                }
lbl72: // 4 sources:
                var14_15 = 1;
                break;
            }
            case 3: {
                var15_16 = var7_8.g();
                var16_17 = var3_3.a(var15_16).k();
                if (var16_17 == null || var7_8.f() != var4_4) ** GOTO lbl82
                if (!(var15_16.c() == var4_4 ^ var3_3.a(var15_16).i())) ** GOTO lbl-1000
                var11_11 = var16_17.a();
                if (var20_6) lbl-1000: // 2 sources:
                {
                    var11_11 = var16_17.b();
                }
            }
lbl82: // 5 sources:
            case 1: 
            case 8: 
            case 9: 
            case 10: {
                var15_16 = var7_8.g();
            }
            case 6: 
            case 7: {
                var14_15 = 1;
                break;
            }
            case 4: {
                var14_15 = 2;
                if (!var20_6) break;
            }
            case 11: {
                var14_15 = 3;
            }
        }
        if (var10_13 == 4 && var14_15 == 4) {
            var16_17 = var1_1.c(f.f);
            var17_21 = var1_1.c(f.e);
            var18_23 = null;
            if (var16_17 != null) {
                var18_23 = (q)var16_17.b(var6_7.l());
            }
            var19_25 = null;
            if (var17_21 != null) {
                var19_25 = r.a(var17_21.b(var6_7.l()));
            }
            v0 = var18_23 != null ? var18_23.a : 0.0;
            if (var19_25 != null) {
                v1 = var19_25.b + var19_25.d;
                return Math.max(v0, v1);
            }
            v1 = this.a;
            return Math.max(v0, v1);
        }
        if ((var10_13 == 4 || var14_15 == 4) && (var16_17 = var1_1.c(f.e)) != null) {
            if (var10_13 == 4 && (var17_22 = r.a(var16_17.b(var6_7.l()))) != null) {
                return var17_22.b;
            }
            if (var14_15 == 4 && (var17_22 = r.a(var16_17.b(var7_8.l()))) != null) {
                return var17_22.d;
            }
        }
        if (var10_13 == 5 || var14_15 == 5) {
            block49 : {
                if (var10_13 == 5) {
                    var18_24 = var3_3.a(var6_7.l()).i();
                    if (!var20_6) break block49;
                }
                var18_24 = var3_3.a(var7_8.l()).i();
            }
            var16_18 = var18_24 != null ? var18_24.d() : 0.0;
            if (var14_15 == 1) return Math.max(this.b, var16_18);
            if (var10_13 == 1) {
                return Math.max(this.b, var16_18);
            }
            if (var14_15 == 2) return Math.max(this.a, var16_18);
            if (var14_15 == 1) return Math.max(this.a, var16_18);
            if (var14_15 == 0) return Math.max(this.a, var16_18);
            if (var10_13 == 0) {
                return Math.max(this.a, var16_18);
            }
        }
        if (var10_13 == 6 || var14_15 == 6) {
            if (var10_13 == 0) return this.b;
            if (var14_15 != 0) return this.c;
            return this.b;
        }
        if (var10_13 == var14_15) {
            switch (var10_13) {
                default: {
                    return this.a;
                }
                case 1: {
                    var16_19 = this.c;
                    if (var13_12 != null && (var18_24 = var3_3.a(var13_12)) != null && (var19_26 = var18_24.k()) != null) {
                        var16_19 = Math.max(var16_19, var19_26.d());
                    }
                    if (var15_16 == null) return Math.max(var11_11, var16_19);
                    var18_24 = var3_3.a(var15_16);
                    if (var18_24 == null) return Math.max(var11_11, var16_19);
                    var19_26 = var18_24.k();
                    if (var19_26 == null) return Math.max(var11_11, var16_19);
                    var16_19 = Math.max(var16_19, var19_26.d());
                    return Math.max(var11_11, var16_19);
                }
                case 2: 
                case 3: 
            }
            return 0.0;
        }
        if (var10_13 == 3 && var14_15 == 3) {
            return this.d;
        }
        if (var10_13 == 2) return 0.0;
        if (var14_15 == 2) {
            return 0.0;
        }
        var16_20 = this.b;
        if (var13_12 != null && (var18_24 = var3_3.a(var13_12)) != null && (var19_27 = var18_24.k()) != null) {
            var16_20 = Math.max(var16_20, var19_27.d());
        }
        if (var15_16 == null) return Math.max(var11_11, var16_20);
        var18_24 = var3_3.a(var15_16);
        if (var18_24 == null) return Math.max(var11_11, var16_20);
        var19_27 = var18_24.k();
        if (var19_27 == null) return Math.max(var11_11, var16_20);
        var16_20 = Math.max(var16_20, var19_27.d());
        return Math.max(var11_11, var16_20);
    }

    public void a(double d2) {
        this.a = d2;
    }

    public void b(double d2) {
        this.b = d2;
    }

    public void c(double d2) {
        this.c = d2;
    }

    @Override
    public void b(X x2, aU aU2, aV aV2) {
    }

    @Override
    public void a(X x2, aU aU2, aV aV2) {
    }
}

