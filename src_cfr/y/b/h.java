/*
 * Decompiled with CFR 0_115.
 */
package y.b;

import y.b.d;
import y.b.e;

final class h {
    private final d a;
    private long b;
    private long c;
    private final e d;

    h(e e2, d d2) {
        this.d = e2;
        this.a = d2;
        this.b = -1;
        this.c = -1;
    }

    boolean a() {
        double d2;
        if (this.c < 0) {
            long l2 = this.a.preferredDuration();
            this.b = 0 < l2 ? (long)((double)l2 / e.a(this.d)) : 0;
            this.c = System.currentTimeMillis();
        }
        double d3 = d2 = 0 < this.b ? (double)(System.currentTimeMillis() - this.c) / (double)this.b : 1.0;
        if (d2 < 1.0) {
            this.a.calcFrame(d2);
            return false;
        }
        this.a.calcFrame(1.0);
        this.a.disposeAnimation();
        return true;
    }
}

