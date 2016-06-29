package y.h;

import javax.swing.*;
import java.awt.print.*;

class fW extends Thread
{
    private final gb a;
    private final fQ b;
    private final boolean c;
    private final JRootPane d;
    private final gc e;
    
    fW(final gc e, final gb a, final fQ b, final boolean c, final JRootPane d) {
        this.e = e;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public void run() {
        try {
            if (fQ.access$400(gc.a(this.e)).printDialog()) {
                try {
                    fQ.access$400(gc.a(this.e)).print();
                    SwingUtilities.invokeLater(new fX(this));
                }
                catch (PrinterException ex) {
                    ex.printStackTrace();
                }
            }
        }
        finally {
            if (this.c && this.d != null && this.d.getGlassPane() != null) {
                this.d.getGlassPane().setVisible(this.c);
            }
        }
    }
    
    static gb a(final fW fw) {
        return fw.a;
    }
    
    static fQ b(final fW fw) {
        return fw.b;
    }
}
