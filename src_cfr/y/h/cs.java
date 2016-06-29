/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.b.d;
import y.h.az;
import y.h.cQ;
import y.h.cT;
import y.h.ch;
import y.h.gW;

class cS
implements d {
    double a;
    double b;
    ch c;
    boolean d;
    cT e;
    az f;
    private final cQ g;

    cS(cQ cQ2, ch ch2, boolean bl2) {
        this.g = cQ2;
        this.e = new cT(this);
        this.c = ch2;
        this.d = bl2;
    }

    @Override
    public void calcFrame(double d2) {
        if (d2 > 0.0) {
            d2 = 1.0 - 1.0 / ((1.0 + d2) * (1.0 + d2) * (1.0 + d2) * (1.0 + d2));
        }
        double d3 = this.d ? 50.0 + 50.0 * (1.0 - d2) : 50.0 + 50.0 * d2;
        this.e.setFrame(this.a - 0.5 * d3, this.b - 0.5 * d3, d3, d3);
        this.e.a = d2;
    }

    @Override
    public void disposeAnimation() {
        this.c.removeDrawable(this.f);
        cQ.access$202(this.g, null);
    }

    @Override
    public void initAnimation() {
        this.f = new gW(this.c, this.e);
        this.c.addDrawable(this.f);
    }

    @Override
    public long preferredDuration() {
        return 500;
    }

    static cQ a(cS cS2) {
        return cS2.g;
    }
}

