/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Comparator;
import java.util.Map;
import y.f.c.aB;
import y.f.c.aD;
import y.g.e;

final class aC
implements Comparator {
    private final aB a;

    aC(aB aB2) {
        this.a = aB2;
    }

    public int compare(Object object, Object object2) {
        return e.a((Integer)this.a.a.a.get(this.a.c(object)), (Integer)this.a.a.a.get(this.a.c(object2)));
    }
}

