/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import java.util.Comparator;
import y.d.t;
import y.d.z;
import y.f.d.D;
import y.f.d.a;

class E
implements Comparator {
    private t a;
    private static final z b = new z(0.0, -1.0);

    private E(t[] arrt) {
        int n2 = a.f;
        double d2 = 0.0;
        double d3 = 0.0;
        for (int i2 = 0; i2 < arrt.length; d2 += arrt[i2].a, d3 += arrt[i2].b, ++i2) {
            if (n2 != 0) return;
            if (n2 == 0) continue;
        }
        this.a = new t(d2 / (double)arrt.length, d3 / (double)arrt.length);
    }

    public int compare(Object object, Object object2) {
        double d2;
        z z2 = new z(this.a, (t)object);
        z z3 = new z(this.a, (t)object2);
        double d3 = z.d(b, z2);
        if (d3 < (d2 = z.d(b, z3))) {
            return -1;
        }
        if (d3 <= d2) return 0;
        return 1;
    }

    E(t[] arrt, D d2) {
        this(arrt);
    }
}

