/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.h.fW;

class fX
implements Runnable {
    private final fW a;

    fX(fW fW2) {
        this.a = fW2;
    }

    @Override
    public void run() {
        fW.a(this.a).a();
        fW.b(this.a).repaint();
    }
}

