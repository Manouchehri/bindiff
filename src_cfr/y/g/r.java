/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.util.Map;
import y.c.A;
import y.c.b;
import y.c.h;
import y.g.U;

class R
extends U
implements A,
b,
h {
    R(Map map) {
        super(map);
    }

    @Override
    public void a(Object object, Object object2) {
        this.a.put(object, object2);
    }

    @Override
    public void a(Object object, int n2) {
        this.a.put(object, new Integer(n2));
    }

    @Override
    public void a(Object object, double d2) {
        this.a.put(object, new Double(d2));
    }

    @Override
    public void a(Object object, boolean bl2) {
        this.a.put(object, bl2 ? Boolean.TRUE : Boolean.FALSE);
    }
}

