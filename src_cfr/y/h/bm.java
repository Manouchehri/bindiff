/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.h.bS;

class bM
implements Runnable {
    private final bS a;

    bM(bS bS2) {
        this.a = bS2;
    }

    @Override
    public void run() {
        this.a.a();
    }
}

