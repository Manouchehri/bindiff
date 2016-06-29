/*
 * Decompiled with CFR 0_115.
 */
package y.b;

import y.b.d;

final class k
implements Runnable {
    private final d a;

    public k(d d2) {
        this.a = d2;
    }

    @Override
    public void run() {
        this.a.initAnimation();
    }
}

