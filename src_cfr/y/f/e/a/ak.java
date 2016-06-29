/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import java.util.HashMap;
import java.util.Map;
import y.f.e.a.al;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.s;

class ak
implements s {
    double a;
    double b;
    double c;
    double d;
    private Map e = new HashMap();

    ak() {
        this(0.01, 0.04, 0.01, 0.04);
    }

    ak(double d2, double d3, double d4, double d5) {
        this.d = d4;
        this.a = d3;
        this.b = d2;
        this.c = d5;
    }

    @Override
    public double a(m m2, l l2) {
        if (m2.g() == 1.0) {
            return 0.0;
        }
        double d2 = this.a(m2);
        double d3 = m2.e() + d2;
        return Math.max(0.0, Math.min(d3, 1.0));
    }

    double a(m m2) {
        al al2 = this.b(m2);
        al2.a(m2.f());
        double d2 = al2.a();
        double d3 = al2.b();
        if (d3 * d2 >= 0.0) {
            if (d2 <= 0.0) return this.c * d2;
            return this.a * d2;
        }
        if (d2 <= 0.0) return this.d * d2;
        return this.b * d2;
    }

    al b(m m2) {
        al al2 = (al)this.e.get(m2);
        if (al2 != null) return al2;
        al2 = new al();
        this.e.put(m2, al2);
        return al2;
    }
}

