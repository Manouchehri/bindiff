package com.google.security.zynamics.bindiff.gui.dialogs.printing;

import java.awt.print.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import java.awt.event.*;
import y.h.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import javax.swing.border.*;

class PrintGraphPreviewDialog$CGraph2DPrintPreviewPanel extends fQ
{
    final /* synthetic */ PrintGraphPreviewDialog this$0;
    
    public PrintGraphPreviewDialog$CGraph2DPrintPreviewPanel(final PrintGraphPreviewDialog this$0, final PrinterJob printerJob, final bW bw, final PageFormat pageFormat) {
        this.this$0 = this$0;
        super(printerJob, bw, bw.c(), bw.c() * bw.b(), pageFormat);
        final JButton[] array = new JButton[4];
        int n = 0;
        for (int i = 0; i < this.getComponentCount(); ++i) {
            final Component component = this.getComponent(i);
            for (int j = 0; j < ((JPanel)component).getComponentCount(); ++j) {
                final Component component2 = ((JPanel)component).getComponent(j);
                if (component2 instanceof JButton) {
                    array[n++] = (JButton)component2;
                }
                else if (component2 instanceof JComboBox) {
                    this$0.zoomComboBox = (JComboBox)component2;
                }
                else if (component2 instanceof JScrollPane) {
                    this$0.previewPane = (JScrollPane)component2;
                }
            }
        }
        this$0.pageSetupButton = array[0];
        this$0.printButton = array[1];
        this$0.zoomOutButton = array[2];
        this$0.zoomInButton = array[3];
    }
}
