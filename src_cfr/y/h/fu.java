/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.print.PageFormat;
import y.h.fT;

class fU
implements Runnable {
    private final PageFormat a;
    private final fT b;

    fU(fT fT2, PageFormat pageFormat) {
        this.b = fT2;
        this.a = pageFormat;
    }

    @Override
    public void run() {
        fT.a(this.b).setPageFormat(this.a);
    }
}

