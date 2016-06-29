/*
 * Decompiled with CFR 0_115.
 */
package y.b;

import y.b.d;

final class j
implements Runnable {
    private final d a;
    private double b;

    public j(d d2) {
        this.a = d2;
        this.b = 0.0;
    }

    public void a(double d2) {
        this.b = d2;
    }

    @Override
    public void run() {
        this.a.calcFrame(this.b);
    }
}

