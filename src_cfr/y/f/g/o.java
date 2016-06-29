/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import java.util.Comparator;
import y.c.D;
import y.f.g.q;
import y.g.e;

class o
implements Comparator {
    public int compare(Object object, Object object2) {
        int n2 = e.a(((q)object2).d.size(), ((q)object).d.size());
        if (n2 == 0) return e.a(((q)object).c, ((q)object2).c);
        return n2;
    }
}

