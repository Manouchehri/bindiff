/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Comparator;
import y.c.c;
import y.c.d;
import y.c.q;
import y.d.t;
import y.f.aE;
import y.f.c.a;
import y.f.c.ap;
import y.f.c.x;
import y.g.e;
import y.g.g;

class as
implements Comparator,
g {
    private q a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    private c g;
    private final ap h;

    as(ap ap2, c c2) {
        this.h = ap2;
        this.g = c2;
    }

    void a(q q2, int n2) {
        this.a = q2;
        this.d = this.g.a(this.a);
        this.b = n2 / 3;
        this.f = n2 > 3 && n2 < 11;
        this.c = this.f ? 2 : 0;
        switch (n2) {
            case 0: 
            case 3: 
            case 5: 
            case 8: {
                this.e = false;
                if (!a.i) return;
            }
            case 2: 
            case 6: 
            case 9: 
            case 11: {
                this.e = true;
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public int compare(Object var1_1, Object var2_2) {
        block12 : {
            var20_3 = a.i;
            if (this.e) {
                var5_4 = var2_2;
                var2_2 = var1_1;
                var1_1 = var5_4;
            }
            var5_4 = (d)var1_1;
            var6_5 = (d)var2_2;
            if (var5_4.c() != this.a) ** GOTO lbl-1000
            var7_6 = var5_4.d();
            var9_7 = this.h.b((d)var5_4);
            var13_8 = x.a(var9_7.b(), this.c);
            var3_9 = ap.a(this.h).o((d)var5_4);
            var11_10 = false;
            if (var20_3) lbl-1000: // 2 sources:
            {
                var7_6 = var5_4.c();
                var9_7 = this.h.a((d)var5_4);
                var13_8 = x.a(var9_7.b(), this.c);
                var3_9 = ap.a(this.h).n((d)var5_4);
                v0 = var11_10 = (this.b ^ var13_8) == 2 && (this.b | var13_8) == 2;
            }
            if (var6_5.c() != this.a) ** GOTO lbl-1000
            var8_11 = var6_5.d();
            var10_12 = this.h.b(var6_5);
            var4_13 = ap.a(this.h).o(var6_5);
            var14_14 = x.a(var10_12.b(), this.c);
            var12_15 = false;
            if (var20_3) lbl-1000: // 2 sources:
            {
                var8_11 = var6_5.c();
                var10_12 = this.h.a(var6_5);
                var14_14 = x.a(var10_12.b(), this.c);
                var4_13 = ap.a(this.h).n(var6_5);
                var12_15 = (this.b ^ var14_14) == 2 && (this.b | var14_14) == 2;
            }
            var15_16 = this.g.a(var7_6);
            var16_17 = this.g.a(var8_11);
            var17_18 = e.a(var16_17, var15_16);
            if (var17_18 == 0) {
                if (var12_15 != var11_10) {
                    if ((var11_10 ^ this.e) == false) return 1;
                    return -1;
                }
                v1 = var18_19 = var15_16 > this.d;
                if (var18_19) {
                    if (this.f) {
                        var19_20 = 1;
                        if (var20_3 == false) return this.a(var19_20, var13_8, var14_14, this.f, var3_9, var4_13);
                    }
                    var19_20 = 2;
                    if (var20_3 == false) return this.a(var19_20, var13_8, var14_14, this.f, var3_9, var4_13);
                }
                if (this.f) {
                    var19_20 = 3;
                    if (var20_3 == false) return this.a(var19_20, var13_8, var14_14, this.f, var3_9, var4_13);
                }
                var19_20 = 3;
                return this.a(var19_20, var13_8, var14_14, this.f, var3_9, var4_13);
            }
            if (var12_15 != var11_10) {
                if ((var11_10 ^ this.e) == false) return 1;
                return -1;
            }
            if (var15_16 < this.d) {
                var15_16 = this.d - var15_16;
                if (!var20_3) break block12;
            }
            var15_16 = Integer.MAX_VALUE - var15_16;
        }
        if (var16_17 < this.d) {
            var16_17 = this.d - var16_17;
            if (var20_3 == false) return e.a(var15_16, var16_17);
        }
        var16_17 = Integer.MAX_VALUE - var16_17;
        return e.a(var15_16, var16_17);
    }

    private int a(int n2, int n3, int n4, boolean bl2, t t2, t t3) {
        int n5;
        boolean bl3 = a.i;
        if (bl2) {
            int n6;
            int n7;
            if (n3 > n2) {
                n3 -= 4;
            }
            if (n4 > n2) {
                n4 -= 4;
            }
            if ((n6 = e.a(n3, n4)) != 0) return n6;
            switch (4 + n3 & 3) {
                case 0: {
                    n7 = e.a(t3.a, t2.a);
                    if (!bl3) return - n7;
                }
                case 1: {
                    n7 = e.a(t3.b, t2.b);
                    if (!bl3) return - n7;
                }
                case 2: {
                    n7 = e.a(t2.a, t3.a);
                    if (!bl3) return - n7;
                }
            }
            n7 = e.a(t2.b, t3.b);
            return - n7;
        }
        if (n3 < n2) {
            n3 += 4;
        }
        if (n4 < n2) {
            n4 += 4;
        }
        if ((n5 = e.a(n4, n3)) != 0) return n5;
        switch (4 + n3 & 3) {
            int n8;
            case 0: {
                n8 = e.a(t3.a, t2.a);
                if (!bl3) return n8;
            }
            case 1: {
                n8 = e.a(t3.b, t2.b);
                if (!bl3) return n8;
            }
            case 2: {
                n8 = e.a(t2.a, t3.a);
                if (!bl3) return n8;
            }
        }
        return e.a(t2.b, t3.b);
    }
}

