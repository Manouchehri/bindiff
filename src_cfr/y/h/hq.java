/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.ArrayList;
import java.util.Iterator;
import y.c.d;
import y.c.q;
import y.h.bu;
import y.h.fj;
import y.h.hO;

final class hQ
extends hO {
    private final Iterator a;
    private final boolean b;

    hQ(bu bu2, Iterator iterator, int n2, boolean bl2) {
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
        do lbl-1000: // 6 sources:
        {
            if (this.f.isEmpty() == false) return;
            if (this.a.hasNext() == false) return;
            var1_2 = this.a.next();
            if (!(var1_2 instanceof d)) ** GOTO lbl12
            if (!this.b) ** GOTO lbl10
            this.a((d)var1_2);
            if (!var2_1) ** GOTO lbl-1000
lbl10: // 2 sources:
            this.b((d)var1_2);
            if (!var2_1) ** GOTO lbl-1000
lbl12: // 2 sources:
            if (!(var1_2 instanceof q)) ** GOTO lbl-1000
            if (!this.b) ** GOTO lbl16
            this.a((q)var1_2);
            if (!var2_1) ** GOTO lbl-1000
lbl16: // 2 sources:
            this.b((q)var1_2);
        } while (!var2_1);
    }
}

