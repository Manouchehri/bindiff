/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import java.util.Collections;
import java.util.List;
import y.c.c;
import y.c.q;
import y.f.X;
import y.f.e.a.i;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.w;

abstract class ab
extends i {
    ab() {
    }

    @Override
    protected List a(m m2, l l2) {
        X x2 = l2.b().f();
        c c2 = this.a(x2);
        if (c2 == null) {
            return Collections.EMPTY_LIST;
        }
        List list = (List)c2.b(m2.j());
        if (list != null) return list;
        return Collections.EMPTY_LIST;
    }

    protected abstract c a(X var1);
}

