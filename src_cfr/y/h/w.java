/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.ArrayList;
import java.util.Iterator;
import y.c.i;
import y.c.q;
import y.c.x;
import y.g.l;
import y.h.a.v;
import y.h.bu;
import y.h.fj;
import y.h.hO;

final class W
extends hO {
    private final Iterator a;
    private final boolean b;

    W(bu bu2, v v2, int n2, boolean bl2) {
        this(bu2, bl2 ? v2.h(v2.e(bu2)) : v2.i(v2.e(bu2)), n2, bl2);
    }

    W(bu bu2, int n2, boolean bl2) {
        this(bu2, bl2 ? l.a(bu2.o()) : l.b(bu2.o()), n2, bl2);
    }

    private W(bu bu2, Iterator iterator, int n2, boolean bl2) {
        super(bu2, n2);
        this.a = iterator;
        this.b = bl2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    void a() {
        var2_1 = fj.z;
        do lbl-1000: // 3 sources:
        {
            if (this.f.isEmpty() == false) return;
            if (this.a.hasNext() == false) return;
            var1_2 = (q)this.a.next();
            if (!this.b) ** GOTO lbl9
            this.a(var1_2);
            if (!var2_1) ** GOTO lbl-1000
lbl9: // 2 sources:
            this.b(var1_2);
        } while (!var2_1);
    }
}

