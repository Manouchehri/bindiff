/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import y.h.fQ;
import y.h.fj;

class fS
implements ActionListener {
    private final fQ a;

    fS(fQ fQ2) {
        this.a = fQ2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string;
        boolean bl2 = fj.z;
        if (fQ.access$000(this.a).getSelectedIndex() == 0) {
            this.a.zoomToFit();
            if (!bl2) return;
        }
        if (fQ.access$000(this.a).getSelectedIndex() == 1) {
            this.a.zoomToFitWidth();
            if (!bl2) return;
        }
        if ((string = fQ.access$000(this.a).getSelectedItem().toString().trim()).indexOf(37) > 0) {
            string = string.substring(0, string.indexOf(37)).trim();
        }
        try {
            double d2 = Double.parseDouble(string);
            fQ.access$100(this.a).e((int)(d2 * 10.0));
            return;
        }
        catch (Exception var3_5) {
            int n2 = fQ.access$100(this.a).b();
            String string2 = new StringBuffer().append(String.valueOf(n2 / 10)).append(".").append(String.valueOf(n2 % 10)).append("%").toString();
            fQ.access$000(this.a).setSelectedItem(string2);
        }
    }
}

