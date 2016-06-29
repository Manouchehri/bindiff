/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.gui.license.CExpiryDialog;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class CExpiryDialog$InternalButtonListener
extends AbstractAction {
    private static final long serialVersionUID = -3774947758218736158L;
    final /* synthetic */ CExpiryDialog this$0;

    public CExpiryDialog$InternalButtonListener(CExpiryDialog cExpiryDialog) {
        this.this$0 = cExpiryDialog;
        super("OK");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.this$0.dispose();
    }
}

