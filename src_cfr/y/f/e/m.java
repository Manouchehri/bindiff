/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import java.awt.Rectangle;
import y.d.g;
import y.f.e.i;
import y.f.e.l;
import y.f.e.o;

class m
implements g {
    private final l a;

    m(l l2) {
        this.a = l2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void a(Object var1_1, Object var2_2) {
        var9_3 = i.b;
        var3_4 = ((o)var1_1).a;
        var4_5 = ((o)var2_2).a;
        var5_6 = var3_4.intersection(var4_5);
        if (var5_6.width == 0) return;
        if (var5_6.height == 0) return;
        if (l.b(this.a) != 0) ** GOTO lbl10
        v0 = var6_7 = var5_6.width < var5_6.height;
        if (!var9_3) ** GOTO lbl27
lbl10: // 2 sources:
        if (l.b(this.a) != 1) ** GOTO lbl13
        v1 = var6_7 = Math.abs(var3_4.x - var4_5.x + (var3_4.width - var4_5.width) / 2) > Math.abs(var3_4.y - var4_5.y + (var3_4.height - var4_5.height) / 2);
        if (!var9_3) ** GOTO lbl27
lbl13: // 2 sources:
        if (!l.a(var3_4, var4_5)) ** GOTO lbl18
        var7_8 = Math.min(var4_5.y + var4_5.height - var3_4.y, var3_4.y + var3_4.height - var4_5.y);
        var8_9 = Math.min(var4_5.x + var4_5.width - var3_4.x, var3_4.x + var3_4.width - var4_5.x);
        v2 = var6_7 = var8_9 < var7_8;
        if (!var9_3) ** GOTO lbl27
lbl18: // 2 sources:
        if (!l.a(var4_5, var3_4)) ** GOTO lbl-1000
        var7_8 = Math.min(var3_4.y + var3_4.height - var4_5.y, var4_5.y + var4_5.height - var3_4.y);
        var8_9 = Math.min(var3_4.x + var3_4.width - var4_5.x, var4_5.x + var4_5.width - var3_4.x);
        v3 = var6_7 = var8_9 < var7_8;
        if (var9_3) lbl-1000: // 2 sources:
        {
            if (var5_6.width >= var5_6.height) return;
            v4 = true;
            var6_7 = v4;
            if (var6_7 == false) return;
        }
lbl27: // 6 sources:
        if (var4_5.x >= var3_4.x && var4_5.x < var3_4.x + var3_4.width) {
            var7_8 = (1 + var3_4.x + var3_4.width - var4_5.x) / 2;
            if (var7_8 >= var3_4.width) return;
            if (var7_8 >= var4_5.width) return;
            var3_4.width -= var7_8;
            var4_5.x += var7_8;
            var4_5.width -= var7_8;
            if (var9_3 == false) return;
        }
        if (var3_4.x < var4_5.x) return;
        if (var3_4.x >= var4_5.x + var4_5.width) return;
        var7_8 = (1 + var4_5.x + var4_5.width - var3_4.x) / 2;
        if (var7_8 >= var3_4.width) return;
        if (var7_8 >= var4_5.width) return;
        var4_5.width -= var7_8;
        var3_4.x += var7_8;
        var3_4.width -= var7_8;
    }
}

