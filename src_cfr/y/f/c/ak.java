/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Comparator;
import y.c.c;
import y.g.e;

class ak
implements Comparator {
    private final c a;

    ak(c c2) {
        this.a = c2;
    }

    public int compare(Object object, Object object2) {
        return e.a(- this.a.c(object), - this.a.c(object2));
    }
}

