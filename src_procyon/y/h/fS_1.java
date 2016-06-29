package y.h;

import java.awt.event.*;

class fS implements ActionListener
{
    private final fQ a;
    
    fS(final fQ a) {
        this.a = a;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final boolean z = fj.z;
        if (fQ.access$000(this.a).getSelectedIndex() == 0) {
            this.a.zoomToFit();
            if (!z) {
                return;
            }
        }
        if (fQ.access$000(this.a).getSelectedIndex() == 1) {
            this.a.zoomToFitWidth();
            if (!z) {
                return;
            }
        }
        String s = fQ.access$000(this.a).getSelectedItem().toString().trim();
        if (s.indexOf(37) > 0) {
            s = s.substring(0, s.indexOf(37)).trim();
        }
        try {
            fQ.access$100(this.a).e((int)(Double.parseDouble(s) * 10.0));
        }
        catch (Exception ex) {
            final int b = fQ.access$100(this.a).b();
            fQ.access$000(this.a).setSelectedItem(String.valueOf(b / 10) + "." + String.valueOf(b % 10) + "%");
        }
    }
}
