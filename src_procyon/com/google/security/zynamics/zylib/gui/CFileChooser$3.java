package com.google.security.zynamics.zylib.gui;

import javax.swing.*;

class CFileChooser$3 implements GuiHelper$ComponentFilter
{
    final /* synthetic */ String val$approve;
    final /* synthetic */ CFileChooser this$0;
    
    CFileChooser$3(final CFileChooser this$0, final String val$approve) {
        this.this$0 = this$0;
        this.val$approve = val$approve;
    }
    
    @Override
    public boolean accept(final JComponent component) {
        if (!(component instanceof JButton)) {
            return false;
        }
        final String text = ((JButton)component).getText();
        if (text == null) {
            return this.val$approve == null;
        }
        if (this.val$approve == null) {
            return text == null;
        }
        return ((JButton)component).getText().equals(this.val$approve);
    }
}
