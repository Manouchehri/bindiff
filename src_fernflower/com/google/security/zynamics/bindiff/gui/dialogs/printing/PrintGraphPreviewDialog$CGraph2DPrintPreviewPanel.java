package com.google.security.zynamics.bindiff.gui.dialogs.printing;

import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphPreviewDialog;
import java.awt.Component;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import y.h.bW;
import y.h.fQ;

class PrintGraphPreviewDialog$CGraph2DPrintPreviewPanel extends fQ {
   // $FF: synthetic field
   final PrintGraphPreviewDialog this$0;

   public PrintGraphPreviewDialog$CGraph2DPrintPreviewPanel(PrintGraphPreviewDialog var1, PrinterJob var2, bW var3, PageFormat var4) {
      super(var2, var3, var3.c(), var3.c() * var3.b(), var4);
      this.this$0 = var1;
      JButton[] var5 = new JButton[4];
      int var6 = 0;

      for(int var7 = 0; var7 < this.getComponentCount(); ++var7) {
         Component var8 = this.getComponent(var7);

         for(int var9 = 0; var9 < ((JPanel)var8).getComponentCount(); ++var9) {
            Component var10 = ((JPanel)var8).getComponent(var9);
            if(var10 instanceof JButton) {
               var5[var6++] = (JButton)var10;
            } else if(var10 instanceof JComboBox) {
               PrintGraphPreviewDialog.access$102(var1, (JComboBox)var10);
            } else if(var10 instanceof JScrollPane) {
               PrintGraphPreviewDialog.access$202(var1, (JScrollPane)var10);
            }
         }
      }

      PrintGraphPreviewDialog.access$302(var1, var5[0]);
      PrintGraphPreviewDialog.access$402(var1, var5[1]);
      PrintGraphPreviewDialog.access$502(var1, var5[2]);
      PrintGraphPreviewDialog.access$602(var1, var5[3]);
   }
}
