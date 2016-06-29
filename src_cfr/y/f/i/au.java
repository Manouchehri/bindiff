/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.util.HashMap;
import y.c.q;
import y.g.p;

class au
extends p {
    private HashMap a = new HashMap();

    @Override
    public Object b(Object object) {
        return this.a.get(object);
    }

    public void a(q q2, Object object) {
        this.a.put(q2, object);
    }
}

