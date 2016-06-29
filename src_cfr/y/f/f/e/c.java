/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.e;

import y.c.A;
import y.c.q;
import y.f.h.p;
import y.f.h.r;

class c
extends y.g.p {
    r a;
    A b;

    c(r r2, A a2) {
        this.a = r2;
        this.b = a2;
    }

    @Override
    public Object b(Object object) {
        if (object instanceof p) {
            return this.a.b(object);
        }
        if (!(object instanceof q)) throw new IllegalStateException(new StringBuffer().append("Illegal Type ").append(object).toString());
        return this.b.b(object);
    }
}

