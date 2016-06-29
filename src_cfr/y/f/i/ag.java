/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.util.Collection;
import java.util.Comparator;
import y.c.d;
import y.c.q;
import y.f.X;
import y.f.ax;
import y.f.i.ad;
import y.f.i.v;
import y.g.e;

class aG
implements Comparator {
    private X a;
    private v b;

    public aG(X x2, v v2) {
        this.a = x2;
        this.b = v2;
    }

    public int compare(Object object, Object object2) {
        return e.a(this.a((d)object), this.a((d)object2));
    }

    /*
     * Unable to fully structure code
     */
    private int a(d var1_1) {
        var2_2 = 0;
        if (!this.b.b(var1_1.c())) ** GOTO lbl-1000
        var2_2 -= 128;
        if (v.f != 0) lbl-1000: // 2 sources:
        {
            if (this.b.b(var1_1.d())) {
                var2_2 -= 64;
            }
        }
        var2_2 += this.a(ad.a(this.a, var1_1, true));
        return var2_2 += this.a(ad.a(this.a, var1_1, false));
    }

    private int a(Collection collection) {
        int n2;
        int n3 = v.f;
        int n4 = 0;
        if (collection != null && !collection.isEmpty()) {
            for (ax ax2 : collection) {
                int n5;
                block8 : {
                    n5 = 0;
                    n2 = (int)ax2.b() ? 1 : 0;
                    if (n3 != 0) return n2;
                    if (n2 != 0) {
                        n5 = -16;
                        if (n3 == 0) break block8;
                    }
                    n5 = -4;
                }
                if (ax2.a(1)) {
                    ++n5;
                }
                if (ax2.a(2)) {
                    ++n5;
                }
                if (ax2.a(8)) {
                    ++n5;
                }
                if (ax2.a(4)) {
                    ++n5;
                }
                n4 = Math.min(n5, n4);
                if (n3 == 0) continue;
            }
        }
        n2 = n4;
        return n2;
    }
}

