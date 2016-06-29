/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import java.awt.Color;
import java.awt.Stroke;
import y.d.r;
import y.h.b.Y;
import y.h.b.a;
import y.h.b.i;
import y.h.dr;
import y.h.fj;

class N
implements Y {
    private final boolean a;

    N(boolean bl2) {
        this.a = bl2;
    }

    @Override
    public Stroke a(fj fj2) {
        if (!this.h(fj2)) return null;
        return this.g(fj2);
    }

    @Override
    public Color b(fj fj2) {
        if (!this.h(fj2)) return null;
        return fj2.getLineColor();
    }

    @Override
    public Color c(fj fj2) {
        return fj2.getFillColor();
    }

    @Override
    public Stroke d(fj fj2) {
        if (!this.h(fj2)) return this.g(fj2);
        return null;
    }

    @Override
    public Color e(fj fj2) {
        if (!this.h(fj2)) return fj2.getLineColor();
        return null;
    }

    @Override
    public Color f(fj fj2) {
        return fj2.getFillColor();
    }

    private Stroke g(fj fj2) {
        dr dr2 = fj2.getLineType();
        if (!this.a) return dr2;
        return dr.a((int)Math.ceil(dr2.getLineWidth()) + 2, dr2.a());
    }

    private boolean h(fj fj2) {
        r r2 = this.i(fj2);
        if (r2.a > 0.0) return true;
        if (r2.b > 0.0) return true;
        if (r2.c > 0.0) return true;
        if (r2.d > 0.0) return true;
        return false;
    }

    private r i(fj fj2) {
        if (!(fj2 instanceof a)) return null;
        return ((a)fj2).l().d();
    }
}

