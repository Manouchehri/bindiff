/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.bI;
import y.f.c.a.by;
import y.g.e;

class bB
implements Comparator {
    private final by a;

    bB(by by2) {
        this.a = by2;
    }

    public int compare(Object object, Object object2) {
        return e.a(((bI)object).c, ((bI)object2).c);
    }
}

