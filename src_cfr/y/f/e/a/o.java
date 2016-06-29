/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.f.e.a.Y;

class O
implements Y {
    O() {
    }

    @Override
    public double a(double d2) {
        if (!this.b(d2)) return 4.0 * d2 - 3.0;
        return 0.0;
    }

    @Override
    public boolean b(double d2) {
        if (d2 > 0.75) return false;
        return true;
    }
}

