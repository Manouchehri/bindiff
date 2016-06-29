/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.util.Comparator;
import y.d.t;
import y.f.i.ao;
import y.f.i.v;

class aD
implements Comparator {
    private t a;

    public aD(t t2) {
        this.a = t2;
    }

    public int compare(Object object, Object object2) {
        double d2;
        double d3;
        block9 : {
            int n2;
            ao ao2;
            block8 : {
                n2 = v.f;
                ao ao3 = (ao)object;
                ao2 = (ao)object2;
                if (ao3 == null && ao2 == null) {
                    return 0;
                }
                if (ao3 == null) {
                    return -1;
                }
                if (ao2 == null) {
                    return 1;
                }
                if (ao3.x()) {
                    d2 = Math.abs(ao3.r() - this.a.a);
                    if (n2 == 0) break block8;
                }
                d2 = Math.abs(ao3.s() - this.a.b);
            }
            if (ao2.x()) {
                d3 = Math.abs(ao2.r() - this.a.a);
                if (n2 == 0) break block9;
            }
            d3 = Math.abs(ao2.s() - this.a.b);
        }
        if (d2 < d3) {
            return -1;
        }
        if (d2 <= d3) return 0;
        return 1;
    }
}

