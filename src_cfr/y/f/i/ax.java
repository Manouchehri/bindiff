/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.c.D;
import y.f.i.av;
import y.f.i.ay;
import y.f.i.az;
import y.f.i.v;
import y.g.d;

class ax {
    private az a;
    private int b;
    private ay c;
    private final av d;

    public ax(av av2, ay ay2) {
        this.d = av2;
        this.c = ay2;
        this.a = null;
        this.b = 0;
    }

    /*
     * Unable to fully structure code
     */
    public boolean a(double var1_1, Object var3_2) {
        block5 : {
            var8_3 = v.f;
            var4_4 = false;
            if (this.b == 0) {
                this.a = new az(this.d, var1_1, var3_2);
                if (this.a == null) return var4_4;
                var4_4 = true;
                ++this.b;
                return var4_4;
            }
            var5_5 = this.a;
            var6_6 = this.a;
            while (var6_6 != null) {
                v0 = var6_6;
                if (var8_3 == 0) {
                    var5_5 = v0;
                    if (var1_1 < az.a(var6_6)) {
                        var6_6 = az.b(var6_6);
                        if (var8_3 == 0) continue;
                    }
                    var6_6 = az.c(var6_6);
                    if (var8_3 == 0) continue;
                }
                break block5;
            }
            v0 = new az(this.d, var1_1, var3_2);
        }
        if ((var7_7 = v0) == null) ** GOTO lbl29
        var4_4 = true;
        if (var1_1 >= az.a(var5_5)) ** GOTO lbl-1000
        az.a(var5_5, var7_7);
        if (var8_3 != 0) lbl-1000: // 2 sources:
        {
            az.b(var5_5, var7_7);
        }
lbl29: // 4 sources:
        ++this.b;
        return var4_4;
    }

    private az[] a(az az2, double d2) {
        az[] arraz;
        int n2;
        az az3;
        boolean bl2;
        az az4;
        block5 : {
            n2 = v.f;
            arraz = new az[2];
            az4 = az2;
            az3 = az2;
            boolean bl3 = false;
            while (az3 != null) {
                bl2 = bl3;
                if (n2 == 0) {
                    if (bl2) break;
                    if (d2 == az.a(az3)) {
                        bl3 = true;
                        if (n2 == 0) continue;
                    }
                    az4 = az3;
                    if (d2 < az.a(az3)) {
                        az3 = az.b(az3);
                        if (n2 == 0) continue;
                    }
                    az3 = az.c(az3);
                    if (n2 == 0) continue;
                }
                break block5;
            }
            bl2 = bl3;
        }
        if (!bl2) {
            arraz[0] = null;
            arraz[1] = null;
            if (n2 == 0) return arraz;
        }
        arraz[0] = az4;
        arraz[1] = az3;
        return arraz;
    }

    /*
     * Unable to fully structure code
     */
    public Object b(double var1_1, Object var3_2) {
        block9 : {
            var10_3 = v.f;
            if (this.b == 0) {
                return null;
            }
            var4_4 = false;
            var6_5 = this.a;
            var7_6 = this.a;
            while (var7_6 != null) {
                v0 = var4_4;
                if (var10_3 == 0) {
                    if (v0 || (var5_7 = this.a(var7_6, var1_1))[0] == null && var5_7[1] == null) break;
                    if (var5_7[0] != var5_7[1]) {
                        var6_5 = var5_7[0];
                    }
                    if (this.c.a(var3_2, az.d(var7_6 = var5_7[1]))) {
                        var4_4 = true;
                        if (var10_3 == 0) continue;
                    }
                    var6_5 = var7_6;
                    var7_6 = az.c(var7_6);
                    if (var10_3 == 0) continue;
                }
                break block9;
            }
            v0 = var4_4;
        }
        if (v0 == false) return null;
        var9_8 = var7_6;
        if (az.c(var9_8) != null) ** GOTO lbl27
        var7_6 = az.b(var7_6);
        if (var10_3 == 0) ** GOTO lbl42
lbl27: // 2 sources:
        if (az.b(az.c(var9_8)) != null) ** GOTO lbl-1000
        var7_6 = az.c(var7_6);
        az.a(var7_6, az.b(var9_8));
        if (var10_3 != 0) lbl-1000: // 2 sources:
        {
            block10 : {
                var8_9 = az.c(var7_6);
                while (az.b(az.b(var8_9)) != null) {
                    var8_9 = az.b(var8_9);
                    if (var10_3 == 0) {
                        if (var10_3 == 0) continue;
                    }
                    break block10;
                }
                var7_6 = az.b(var8_9);
                az.a(var8_9, az.c(var7_6));
                az.a(var7_6, az.b(var9_8));
            }
            az.b(var7_6, az.c(var9_8));
        }
lbl42: // 4 sources:
        if (var6_5 != var9_8) ** GOTO lbl45
        this.a = var7_6;
        if (var10_3 == 0) ** GOTO lbl49
lbl45: // 2 sources:
        if (az.a(var9_8) >= az.a(var6_5)) ** GOTO lbl-1000
        az.a(var6_5, var7_6);
        if (var10_3 != 0) lbl-1000: // 2 sources:
        {
            az.b(var6_5, var7_6);
        }
lbl49: // 4 sources:
        --this.b;
        return az.d(var9_8);
    }

    /*
     * Unable to fully structure code
     */
    public D a() {
        var4_1 = v.f;
        var1_2 = new D();
        var2_3 = new d(this.b);
        var3_4 = this.a;
        do lbl-1000: // 3 sources:
        {
            if (var3_4 == null) ** GOTO lbl11
            var2_3.a(var3_4);
            var3_4 = az.b(var3_4);
            if (var4_1 != 0) continue;
            if (var4_1 == 0) ** GOTO lbl-1000
lbl11: // 2 sources:
            if (var2_3.c()) {
                return var1_2;
            }
            var3_4 = (az)var2_3.b();
            var1_2.add(az.d(var3_4));
            var3_4 = az.c(var3_4);
        } while (var4_1 == 0);
        return var1_2;
    }
}

