/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.util.Comparator;
import y.f.i.ag;
import y.g.e;

class aB
implements Comparator {
    aB() {
    }

    public int compare(Object object, Object object2) {
        int n2 = e.a(((ag)object).a(), ((ag)object2).a());
        if (n2 != 0) {
            return n2;
        }
        n2 = e.a(((ag)object).b(), ((ag)object2).b());
        if (n2 == 0) return e.a(((ag)object).c(), ((ag)object2).c());
        return n2;
    }
}

