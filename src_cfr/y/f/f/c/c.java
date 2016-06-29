/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.c;

import java.util.Comparator;
import y.f.f.c.b;
import y.f.f.c.d;
import y.f.f.c.g;

public class c
implements Comparator {
    private final b a;

    public c(b b2) {
        this.a = b2;
    }

    public int compare(Object object, Object object2) {
        d d2 = (d)object;
        d d3 = (d)object2;
        if (d2.a() < d3.a()) {
            return -1;
        }
        if (d2.a() > d3.a()) {
            return 1;
        }
        if (d2.b() == 1 && d3.b() == 0) {
            return 1;
        }
        if (d2.b() == 0 && d3.b() == 1) {
            return -1;
        }
        if (d2.c().i() < d3.c().i()) {
            return -1;
        }
        if (d2.c().i() <= d3.c().i()) return 0;
        return 1;
    }
}

