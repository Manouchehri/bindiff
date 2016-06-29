/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.f.i.av;

class az {
    private az a;
    private az b;
    private double c;
    private Object d;
    private final av e;

    public az(av av2, double d2, Object object) {
        this.e = av2;
        this.a = null;
        this.b = null;
        this.c = d2;
        this.d = object;
    }

    static double a(az az2) {
        return az2.c;
    }

    static az b(az az2) {
        return az2.a;
    }

    static az c(az az2) {
        return az2.b;
    }

    static az a(az az2, az az3) {
        az2.a = az3;
        return az2.a;
    }

    static az b(az az2, az az3) {
        az2.b = az3;
        return az2.b;
    }

    static Object d(az az2) {
        return az2.d;
    }
}

