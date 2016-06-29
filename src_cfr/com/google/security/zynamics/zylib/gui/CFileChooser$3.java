/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CFileChooser;
import com.google.security.zynamics.zylib.gui.GuiHelper$ComponentFilter;
import javax.swing.JButton;
import javax.swing.JComponent;

class CFileChooser$3
implements GuiHelper$ComponentFilter {
    final /* synthetic */ String val$approve;
    final /* synthetic */ CFileChooser this$0;

    CFileChooser$3(CFileChooser cFileChooser, String string) {
        this.this$0 = cFileChooser;
        this.val$approve = string;
    }

    @Override
    public boolean accept(JComponent jComponent) {
        if (!(jComponent instanceof JButton)) {
            return false;
        }
        String string = ((JButton)jComponent).getText();
        if (string == null) {
            if (this.val$approve != null) return false;
            return true;
        }
        if (this.val$approve != null) return ((JButton)jComponent).getText().equals(this.val$approve);
        if (string != null) return false;
        return true;
    }
}

