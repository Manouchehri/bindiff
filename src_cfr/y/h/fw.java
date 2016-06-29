/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Component;
import java.awt.print.PrinterException;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import y.h.fQ;
import y.h.fX;
import y.h.gb;
import y.h.gc;

class fW
extends Thread {
    private final gb a;
    private final fQ b;
    private final boolean c;
    private final JRootPane d;
    private final gc e;

    fW(gc gc2, gb gb2, fQ fQ2, boolean bl2, JRootPane jRootPane) {
        this.e = gc2;
        this.a = gb2;
        this.b = fQ2;
        this.c = bl2;
        this.d = jRootPane;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            if (fQ.access$400(gc.a(this.e)).printDialog()) {
                try {
                    fQ.access$400(gc.a(this.e)).print();
                    SwingUtilities.invokeLater(new fX(this));
                }
                catch (PrinterException var1_1) {
                    var1_1.printStackTrace();
                }
            }
            java.lang.Object var3_2 = null;
            if (!this.c) return;
            if (this.d == null) return;
            if (this.d.getGlassPane() == null) return;
            this.d.getGlassPane().setVisible(this.c);
            return;
        }
        catch (Throwable var2_4) {
            java.lang.Object var3_3 = null;
            if (!this.c) throw var2_4;
            if (this.d == null) throw var2_4;
            if (this.d.getGlassPane() == null) throw var2_4;
            this.d.getGlassPane().setVisible(this.c);
            throw var2_4;
        }
    }

    static gb a(fW fW2) {
        return fW2.a;
    }

    static fQ b(fW fW2) {
        return fW2.b;
    }
}

