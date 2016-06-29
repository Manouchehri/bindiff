package com.google.security.zynamics.bindiff.gui.dialogs.printing;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import y.h.*;
import com.google.security.zynamics.zylib.gui.ColorPanel.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.zylib.gui.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;

final class PrintGraphOptionsDialog$InteneralButtonListener implements ActionListener
{
    final /* synthetic */ PrintGraphOptionsDialog this$0;
    
    private PrintGraphOptionsDialog$InteneralButtonListener(final PrintGraphOptionsDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.this$0.okButton) {
            if (Integer.parseInt(this.this$0.posterRows.getText()) < 0) {
                CMessageBox.showInformation(this.this$0, "Poster rows value must be greater than 0.");
                return;
            }
            if (Integer.parseInt(this.this$0.posterCols.getText()) < 0) {
                CMessageBox.showInformation(this.this$0, "Poster columns value must be greater than 0.");
                return;
            }
            if (Integer.parseInt(this.this$0.fontSize.getText()) < 0) {
                CMessageBox.showInformation(this.this$0, "Font size value must be greater than 0.");
                return;
            }
            this.this$0.okPressed = true;
            this.this$0.printer.a(Integer.parseInt(this.this$0.posterRows.getText()));
            this.this$0.printer.b(Integer.parseInt(this.this$0.posterCols.getText()));
            this.this$0.printer.a((byte)((this.this$0.ClipArea.getSelectedIndex() == 0) ? 1 : 0));
            this.this$0.printer.a(this.this$0.posterCoords.getSelectedIndex() == 0);
            final bZ bz = new bZ();
            bz.a(this.this$0.titel.getText());
            bz.b(this.this$0.titleTextColor.getColor());
            bz.a(this.this$0.titleBarColor.getColor());
            bz.a(new Font("Dialog", 0, Integer.parseInt(this.this$0.fontSize.getText())));
            this.this$0.printer.a(bz);
        }
        this.this$0.dispose();
    }
}
