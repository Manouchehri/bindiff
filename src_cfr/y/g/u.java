/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.util.Map;
import y.c.c;

class U
implements c {
    Map a;

    U(Map map) {
        this.a = map;
    }

    @Override
    public Object b(Object object) {
        return this.a.get(object);
    }

    @Override
    public int a(Object object) {
        Object v2 = this.a.get(object);
        if (!(v2 instanceof Number)) return 0;
        int n2 = ((Number)v2).intValue();
        return n2;
    }

    @Override
    public double c(Object object) {
        Object v2 = this.a.get(object);
        if (!(v2 instanceof Number)) return 0.0;
        double d2 = ((Number)v2).doubleValue();
        return d2;
    }

    @Override
    public boolean d(Object object) {
        return Boolean.TRUE.equals(this.a.get(object));
    }
}

