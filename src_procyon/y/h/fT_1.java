package y.h;

import javax.swing.*;

class fT extends Thread
{
    private final fQ a;
    private final boolean b;
    private final JRootPane c;
    private final ga d;
    
    fT(final ga d, final fQ a, final boolean b, final JRootPane c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public void run() {
        try {
            SwingUtilities.invokeLater(new fU(this, fQ.access$400(ga.a(this.d)).pageDialog(fQ.access$300(ga.a(this.d)))));
        }
        finally {
            SwingUtilities.invokeLater(new fV(this));
        }
    }
    
    static fQ a(final fT ft) {
        return ft.a;
    }
    
    static boolean b(final fT ft) {
        return ft.b;
    }
    
    static JRootPane c(final fT ft) {
        return ft.c;
    }
}
