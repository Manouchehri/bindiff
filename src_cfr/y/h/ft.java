/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.print.PageFormat;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import y.h.fQ;
import y.h.fU;
import y.h.fV;
import y.h.ga;

class fT
extends Thread {
    private final fQ a;
    private final boolean b;
    private final JRootPane c;
    private final ga d;

    fT(ga ga2, fQ fQ2, boolean bl2, JRootPane jRootPane) {
        this.d = ga2;
        this.a = fQ2;
        this.b = bl2;
        this.c = jRootPane;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            PageFormat pageFormat = fQ.access$400(ga.a(this.d)).pageDialog(fQ.access$300(ga.a(this.d)));
            SwingUtilities.invokeLater(new fU(this, pageFormat));
            return;
        }
        finally {
            SwingUtilities.invokeLater(new fV(this));
        }
    }

    static fQ a(fT fT2) {
        return fT2.a;
    }

    static boolean b(fT fT2) {
        return fT2.b;
    }

    static JRootPane c(fT fT2) {
        return fT2.c;
    }
}

