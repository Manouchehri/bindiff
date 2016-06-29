/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.printing;

import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphPreviewDialog;
import java.awt.Component;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import y.h.bW;
import y.h.fQ;

class PrintGraphPreviewDialog$CGraph2DPrintPreviewPanel
extends fQ {
    final /* synthetic */ PrintGraphPreviewDialog this$0;

    public PrintGraphPreviewDialog$CGraph2DPrintPreviewPanel(PrintGraphPreviewDialog printGraphPreviewDialog, PrinterJob printerJob, bW bW2, PageFormat pageFormat) {
        this.this$0 = printGraphPreviewDialog;
        super(printerJob, bW2, bW2.c(), bW2.c() * bW2.b(), pageFormat);
        JButton[] arrjButton = new JButton[4];
        int n2 = 0;
        int n3 = 0;
        do {
            if (n3 >= this.getComponentCount()) {
                PrintGraphPreviewDialog.access$302(printGraphPreviewDialog, arrjButton[0]);
                PrintGraphPreviewDialog.access$402(printGraphPreviewDialog, arrjButton[1]);
                PrintGraphPreviewDialog.access$502(printGraphPreviewDialog, arrjButton[2]);
                PrintGraphPreviewDialog.access$602(printGraphPreviewDialog, arrjButton[3]);
                return;
            }
            Component component = this.getComponent(n3);
            for (int i2 = 0; i2 < ((JPanel)component).getComponentCount(); ++i2) {
                Component component2 = ((JPanel)component).getComponent(i2);
                if (component2 instanceof JButton) {
                    arrjButton[n2++] = (JButton)component2;
                    continue;
                }
                if (component2 instanceof JComboBox) {
                    PrintGraphPreviewDialog.access$102(printGraphPreviewDialog, (JComboBox)component2);
                    continue;
                }
                if (!(component2 instanceof JScrollPane)) continue;
                PrintGraphPreviewDialog.access$202(printGraphPreviewDialog, (JScrollPane)component2);
            }
            ++n3;
        } while (true);
    }
}

