/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.util.Comparator;
import y.c.c;
import y.c.d;
import y.c.q;
import y.f.i.aM;
import y.f.i.aP;

class aE
implements Comparator {
    private q a;
    private c b;

    public aE(q q2, c c2) {
        this.a = q2;
        this.b = c2;
    }

    public int compare(Object object, Object object2) {
        d d2 = (d)object;
        d d3 = (d)object2;
        q q2 = d2.a(this.a);
        q q3 = d3.a(this.a);
        aM aM2 = (aM)this.b.b(q2);
        aM aM3 = (aM)this.b.b(q3);
        double d4 = ((aP)aM2.a()).b;
        double d5 = ((aP)aM3.a()).b;
        if (d4 < d5) {
            return -1;
        }
        if (d4 <= d5) return 0;
        return 1;
    }
}

