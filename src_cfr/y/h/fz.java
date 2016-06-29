/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import y.h.gb;

class fZ
extends AbstractAction {
    private final gb a;

    fZ(gb gb2, String string) {
        super(string);
        this.a = gb2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.a.e(this.a.b() / 2);
    }
}

