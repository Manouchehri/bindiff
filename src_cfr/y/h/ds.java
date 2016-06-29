/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.Set;
import y.g.z;
import y.h.dP;

class dS
implements z {
    private final Set a;
    private final dP b;

    dS(dP dP2, Set set) {
        this.b = dP2;
        this.a = set;
    }

    @Override
    public boolean a(Object object) {
        return this.a.contains(object);
    }
}

