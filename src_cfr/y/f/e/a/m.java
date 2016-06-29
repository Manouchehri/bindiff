/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.f.e.a.Y;

class M
implements Y {
    M() {
    }

    @Override
    public double a(double d2) {
        if (!this.b(d2)) return Math.sqrt(1.0 - d2);
        return 0.0;
    }

    @Override
    public boolean b(double d2) {
        if (d2 < 1.0) return false;
        return true;
    }
}

