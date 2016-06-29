/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.ArrayList;
import y.c.d;
import y.c.e;
import y.h.bu;
import y.h.fj;
import y.h.hO;

final class X
extends hO {
    private final e a;
    private final boolean b;

    X(bu bu2, int n2, boolean bl2) {
        super(bu2, n2);
        this.a = bu2.p();
        this.b = bl2;
        if (bl2) return;
        this.a.j();
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
            if (this.a.f() == false) return;
            var1_2 = this.a.a();
            if (!this.b) ** GOTO lbl10
            this.a.g();
            this.a(var1_2);
            if (!var2_1) ** GOTO lbl-1000
lbl10: // 2 sources:
            this.a.h();
            this.b(var1_2);
        } while (!var2_1);
    }
}

