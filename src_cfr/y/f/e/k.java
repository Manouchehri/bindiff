/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import y.c.q;
import y.f.X;
import y.f.ad;
import y.f.ah;
import y.f.am;
import y.f.e.i;
import y.f.e.l;
import y.g.ar;

public class k
implements ad {
    private ah h;
    protected X a;
    protected ar b;
    protected double[] c;
    protected double[] d;
    protected double[] e;
    protected double[] f;
    protected q[] g;
    private int i = 0;
    private double n;

    public k(ar ar2, double d2) {
        if (ar2 == null) {
            ar2 = new ar();
        }
        this.b = ar2;
        this.n = d2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void c(X var1_1) {
        block12 : {
            var34_2 = i.b;
            if (this.h != null) {
                this.h.c(var1_1);
            }
            if (var1_1.e() < 1) {
                return;
            }
            this.a = var1_1;
            this.g = var1_1.m();
            this.c = new double[this.g.length];
            this.d = new double[this.g.length];
            this.e = new double[this.g.length];
            this.f = new double[this.g.length];
            var2_3 = 0.0;
            var4_4 = 0.0;
            var8_5 = Double.MAX_VALUE;
            var6_6 = Double.MAX_VALUE;
            var12_7 = -1.7976931348623157E308;
            var10_8 = -1.7976931348623157E308;
            var14_9 = this.n * 2.0;
            for (var16_10 = this.g.length - 1; var16_10 >= 0; --var16_10) {
                var17_12 = var1_1.a(this.g[var16_10]);
                v0 = this.n;
                v1 = 0.0;
                if (var34_2) break block12;
                if (v0 <= v1) ** GOTO lbl-1000
                this.e[var16_10] = var17_12.getWidth() + this.n;
                this.f[var16_10] = var17_12.getHeight() + this.n;
                if (var34_2) lbl-1000: // 2 sources:
                {
                    this.e[var16_10] = var17_12.getWidth();
                    this.f[var16_10] = var17_12.getHeight();
                }
                var18_13 = var17_12.getX() + var17_12.getWidth() / 2.0;
                var20_15 = var17_12.getY() + var17_12.getHeight() / 2.0;
                this.c[var16_10] = var18_13;
                var2_3 += this.c[var16_10];
                this.d[var16_10] = var20_15;
                var4_4 += this.d[var16_10];
                var22_17 = 0.5 * var17_12.getWidth();
                var24_18 = 0.5 * var17_12.getHeight();
                if (var18_13 + var22_17 > var10_8) {
                    var10_8 = var18_13 + var22_17;
                }
                if (var20_15 + var24_18 > var12_7) {
                    var12_7 = var20_15 + var24_18;
                }
                if (var18_13 - var22_17 < var6_6) {
                    var6_6 = var18_13 - var22_17;
                }
                if (var20_15 - var24_18 >= var8_5) continue;
                var8_5 = var20_15 - var24_18;
                if (!var34_2) continue;
            }
            v0 = (var10_8 - var6_6) * (var12_7 - var8_5);
            v1 = 1.0;
        }
        var16_11 = Math.max(v0, v1);
        var18_14 = new l();
        var18_14.a(this.n);
        var18_14.a(false);
        var18_14.b(true);
        var18_14.a(2);
        var20_16 = 10;
        block1 : do {
            var18_14.c(var1_1);
            var21_20 = 0.0;
            var23_21 = 0.0;
            do {
                block13 : {
                    for (var25_23 = this.g.length - 1; var25_23 >= 0; var21_20 += var26_24 * var26_24 + var28_26 * var28_26, --var25_23) {
                        var26_24 = this.c[var25_23] - var1_1.j(this.g[var25_23]);
                        var28_26 = this.d[var25_23] - var1_1.k(this.g[var25_23]);
                        var23_21 = Math.max(var23_21, var26_24 * var26_24 + var28_26 * var28_26);
                        if (!var34_2) {
                            if (!var34_2) continue;
                        }
                        break block13;
                    }
                    var21_20 /= (double)this.g.length;
                }
                if ((var25_22 = Math.sqrt(var21_20) / (Math.sqrt(var16_11) * 0.025)) <= 1.01) return;
                if (var20_16-- <= 0) return;
                if (Math.sqrt(var23_21) < this.n) return;
                v2 = var19_19 = true;
                if (!var19_19) continue block1;
                var27_25 = var2_3 / (double)this.g.length;
                var29_27 = var4_4 / (double)this.g.length;
                var4_4 = 0.0;
                var2_3 = 0.0;
                var31_28 = Math.min(2.0, 1.05 + Math.sqrt(var25_22) * 0.05);
                var16_11 *= var31_28 * var31_28;
                for (var33_29 = this.g.length - 1; var33_29 >= 0; var2_3 += this.c[var33_29], var4_4 += this.d[var33_29], --var33_29) {
                    this.c[var33_29] = var27_25 + (this.c[var33_29] - var27_25) * var31_28;
                    this.d[var33_29] = var27_25 + (this.d[var33_29] - var29_27) * var31_28;
                    var1_1.a(this.g[var33_29], this.c[var33_29], this.d[var33_29]);
                    if (var34_2) ** continue;
                    if (!var34_2) continue;
                }
                break;
            } while (true);
        } while (var19_19);
    }

    @Override
    public ah a() {
        return this.h;
    }

    @Override
    public void a(ah ah2) {
        this.h = ah2;
    }
}

