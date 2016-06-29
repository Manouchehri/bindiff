/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.h.bS;

class bK
implements Runnable {
    private final bS a;

    bK(bS bS2) {
        this.a = bS2;
    }

    @Override
    public void run() {
        this.a.c();
    }
}

