package com.google.security.zynamics.bindiff.gui.dialogs.printing;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import java.awt.print.*;
import y.h.*;
import com.google.security.zynamics.zylib.gui.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

class PrintGraphPreviewDialog$InternalButtonListener implements ActionListener
{
    final /* synthetic */ PrintGraphPreviewDialog this$0;
    
    private PrintGraphPreviewDialog$InternalButtonListener(final PrintGraphPreviewDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.this$0.cancelButton || actionEvent.getSource() == this.this$0.printButton) {
            this.this$0.dispose();
        }
        else if (actionEvent.getSource() == this.this$0.optionsButton && new PrintGraphOptionsDialog(this.this$0, this.this$0.printer).isOkPressed()) {
            this.this$0.hiddenPrinterPreviewPanel.setPages(0, this.this$0.printer.c(), this.this$0.printer.c() * this.this$0.printer.b());
        }
    }
}
