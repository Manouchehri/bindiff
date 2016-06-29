/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.Comparator;
import y.f.i.a.M;
import y.f.i.a.ai;
import y.f.i.a.bN;
import y.f.i.a.w;

class bM
implements Comparator {
    private final bN a;

    bM(bN bN2) {
        this.a = bN2;
    }

    public int compare(Object object, Object object2) {
        double d2;
        M m2;
        double d3;
        M m3 = ((w)object).a(this.a.b).c();
        double d4 = m3.a();
        if (d4 < (d2 = (m2 = ((w)object2).a(this.a.b).c()).a())) {
            return -1;
        }
        if (d4 > d2) {
            return 1;
        }
        double d5 = m3.b();
        if (d5 > (d3 = m2.b())) {
            return -1;
        }
        if (d5 >= d3) return 0;
        return 1;
    }
}

