/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import java.awt.Color;
import java.awt.Stroke;
import y.h.b.Y;
import y.h.dr;
import y.h.fj;

class O
implements Y {
    private final boolean a;

    O(boolean bl2) {
        this.a = bl2;
    }

    @Override
    public Stroke a(fj fj2) {
        return null;
    }

    @Override
    public Color b(fj fj2) {
        return null;
    }

    @Override
    public Color c(fj fj2) {
        return null;
    }

    @Override
    public Stroke d(fj fj2) {
        dr dr2 = fj2.getLineType();
        if (!this.a) return dr2;
        return dr.a((int)Math.ceil(dr2.getLineWidth()) + 2, dr2.a());
    }

    @Override
    public Color e(fj fj2) {
        return fj2.getLineColor();
    }

    @Override
    public Color f(fj fj2) {
        return fj2.getFillColor2();
    }
}

