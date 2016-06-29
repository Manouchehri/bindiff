/*
 * Decompiled with CFR 0_115.
 */
package y.b;

import java.util.List;
import y.b.d;
import y.b.e;
import y.b.s;

final class r
extends s {
    boolean[] d = null;
    double[] e = null;

    @Override
    public void initAnimation() {
        int n2 = e.a;
        this.b = true;
        if (this.a.isEmpty()) {
            return;
        }
        this.d = new boolean[this.a.size()];
        this.e = new double[this.a.size()];
        double d2 = this.preferredDuration();
        int n3 = 0;
        int n4 = this.a.size();
        do {
            if (n3 >= n4) return;
            d d3 = (d)this.a.get(n3);
            d3.initAnimation();
            this.d[n3] = false;
            this.e[n3] = 0.0 < d2 ? (double)d3.preferredDuration() / d2 : 0.0;
            ++n3;
        } while (n2 == 0);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void calcFrame(double var1_1) {
        var7_2 = e.a;
        if (this.a.isEmpty()) {
            return;
        }
        var3_3 = 0;
        var4_4 = this.a.size();
        do {
            if (var3_3 >= var4_4) return;
            if (var1_1 > this.e[var3_3]) ** GOTO lbl-1000
            v0 = var5_5 = 0.0 < this.e[var3_3] ? var1_1 / this.e[var3_3] : 1.0;
            if (1.0 >= var5_5) ** GOTO lbl-1000
            var5_5 = 1.0;
            if (var7_2 != 0) lbl-1000: // 2 sources:
            {
                if (0.0 > var5_5) {
                    var5_5 = 0.0;
                }
            }
            ((d)this.a.get(var3_3)).calcFrame(var5_5);
            if (1.0 == var5_5) {
                this.d[var3_3] = true;
                ** if (var7_2 == 0) goto lbl23
            }
            ** GOTO lbl23
lbl-1000: // 2 sources:
            {
                if (!this.d[var3_3]) {
                    ((d)this.a.get(var3_3)).calcFrame(1.0);
                    this.d[var3_3] = true;
                }
            }
lbl23: // 5 sources:
            ++var3_3;
        } while (var7_2 == 0);
    }
}

