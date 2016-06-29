/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.d.t;
import y.h.eU;
import y.h.em;
import y.h.fL;
import y.h.fO;
import y.h.fP;
import y.h.fj;

final class fA
extends em {
    private final eU c;

    fA(eU eU2, fL fL2, t t2, byte by2) {
        super(fL2, t2, by2);
        this.c = eU2;
    }

    t c(double d2, double d3) {
        fO fO2 = this.c.g().a();
        return fO2.a(this.c, this.d(d2, d3));
    }

    boolean e() {
        if (this.c == null) return false;
        return true;
    }

    @Override
    public void a(double d2, double d3) {
        super.a(d2, d3);
        if (!this.e()) return;
        this.c.a(this.d(d2, d3));
    }

    private fP d(double d2, double d3) {
        eU eU2 = this.c;
        fO fO2 = eU2.g().a();
        return fO2.a(eU2.b(), new t(this.a(d2), this.b(d3)));
    }
}

