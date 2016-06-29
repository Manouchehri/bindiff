package y.h;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

final class ga extends AbstractAction
{
    private final fQ a;
    
    public ga(final fQ a) {
        super("Format ...");
        this.a = a;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        fQ.access$100(this.a);
        final fQ a = this.a;
        final JRootPane rootPane = SwingUtilities.getRootPane(fQ.access$100(this.a));
        boolean b = false;
        Label_0074: {
            if (rootPane != null) {
                b = (rootPane.getGlassPane() != null && rootPane.getGlassPane().isVisible());
                rootPane.getGlassPane().setVisible(true);
                if (!fj.z) {
                    break Label_0074;
                }
            }
            b = false;
        }
        new fT(this, a, b, rootPane).start();
    }
    
    static fQ a(final ga ga) {
        return ga.a;
    }
}
