/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import java.util.Comparator;
import y.c.A;
import y.f.aT;

class aS
implements Comparator {
    private final A a;

    aS(A a2) {
        this.a = a2;
    }

    public int compare(Object object, Object object2) {
        aT aT2 = (aT)this.a.b(object);
        aT aT3 = (aT)this.a.b(object2);
        if (aT2.a() > aT3.a()) {
            return 1;
        }
        if (aT2.a() >= aT3.a()) return 0;
        return -1;
    }
}

