/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import y.h.fQ;

class fR
implements PropertyChangeListener {
    private final fQ a;

    fR(fQ fQ2) {
        this.a = fQ2;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        int n2 = ((Number)propertyChangeEvent.getNewValue()).intValue();
        String string = new StringBuffer().append(String.valueOf(n2 / 10)).append(".").append(String.valueOf(n2 % 10)).append("%").toString();
        fQ.access$000(this.a).setSelectedItem(string);
    }
}

