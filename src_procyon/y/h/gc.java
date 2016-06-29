package y.h;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

final class gc extends AbstractAction
{
    private final fQ a;
    
    public gc(final fQ a) {
        super("Print ...");
        this.a = a;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        fQ.access$400(this.a).setPrintable(fQ.access$800(this.a), fQ.access$300(this.a));
        final gb access$100 = fQ.access$100(this.a);
        final fQ a = this.a;
        final JRootPane rootPane = SwingUtilities.getRootPane(fQ.access$100(this.a));
        boolean b = false;
        Label_0098: {
            if (rootPane != null) {
                rootPane.getGlassPane().setVisible(true);
                b = (rootPane.getGlassPane() != null && rootPane.getGlassPane().isVisible());
                if (!fj.z) {
                    break Label_0098;
                }
            }
            b = false;
        }
        new fW(this, access$100, a, b, rootPane).start();
    }
    
    static fQ a(final gc gc) {
        return gc.a;
    }
}
