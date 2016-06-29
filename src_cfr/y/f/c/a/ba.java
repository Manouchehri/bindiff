/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.d;
import y.c.q;
import y.f.c.a.aX;
import y.f.c.a.by;
import y.g.e;

class bA
implements Comparator {
    private final by a;

    bA(by by2) {
        this.a = by2;
    }

    public int compare(Object object, Object object2) {
        return e.a(by.a(this.a).a(((d)object).c()).k(), by.a(this.a).a(((d)object2).c()).k());
    }
}

