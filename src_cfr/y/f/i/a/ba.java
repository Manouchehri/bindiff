/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.Comparator;
import y.f.i.a.bB;
import y.f.i.a.bz;
import y.g.e;

class bA
implements Comparator {
    private final bz a;

    bA(bz bz2) {
        this.a = bz2;
    }

    public int compare(Object object, Object object2) {
        bB bB2 = (bB)object;
        bB bB3 = (bB)object2;
        if (Math.abs(bB2.a - bB3.a) >= 1.0E-6) return e.a(bB2.a, bB3.a);
        return e.a(bB3.b, bB2.b);
    }
}

