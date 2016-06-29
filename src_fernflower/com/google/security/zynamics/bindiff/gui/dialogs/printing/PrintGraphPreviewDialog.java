package com.google.security.zynamics.bindiff.gui.dialogs.printing;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphPreviewDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphPreviewDialog$CGraph2DPrintPreviewPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphPreviewDialog$InternalButtonListener;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.print.PrinterJob;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import y.h.bW;
import y.h.ch;

public class PrintGraphPreviewDialog extends BaseDialog {
   private final ActionListener buttonListener = new PrintGraphPreviewDialog$InternalButtonListener(this, (PrintGraphPreviewDialog$1)null);
   private final PrinterJob printJob;
   private final bW printer;
   private final ch view;
   private final JButton cancelButton;
   private PrintGraphPreviewDialog$CGraph2DPrintPreviewPanel hiddenPrinterPreviewPanel;
   private JButton pageSetupButton;
   private JButton printButton;
   private JButton zoomInButton;
   private JButton zoomOutButton;
   private final JButton optionsButton;
   private JComboBox zoomComboBox;
   private JScrollPane previewPane;

   public PrintGraphPreviewDialog(JFrame var1, ch var2) {
      super(var1, "Print View");
      this.view = var2;
      this.printJob = PrinterJob.getPrinterJob();
      this.printer = new bW(var2);
      this.cancelButton = new JButton();
      this.cancelButton.addActionListener(this.buttonListener);
      this.optionsButton = new JButton();
      this.optionsButton.addActionListener(this.buttonListener);
      this.extractComponents();
      this.printButton.addActionListener(this.buttonListener);
      this.init();
      this.pack();
      GuiHelper.centerChildToParent(var1, this, true);
      this.setVisible(true);
   }

   private void extractComponents() {
      this.hiddenPrinterPreviewPanel = new PrintGraphPreviewDialog$CGraph2DPrintPreviewPanel(this, this.printJob, this.printer, this.printJob.defaultPage());
   }

   private void init() {
      this.pageSetupButton.setText("Page Setup");
      this.printButton.setText("Print");
      this.zoomOutButton.setText("Zoom In");
      this.zoomInButton.setText("Zoom Out");
      this.optionsButton.setText("Options");
      this.cancelButton.setText("Cancel");
      JPanel var1 = new JPanel(new BorderLayout());
      JPanel var2 = new JPanel(new BorderLayout());
      JPanel var3 = new JPanel(new GridLayout(1, 4, 5, 5));
      var3.setBorder(new EmptyBorder(5, 5, 5, 5));
      var3.add(this.zoomComboBox);
      var3.add(this.zoomOutButton);
      var3.add(this.zoomInButton);
      var3.add(this.optionsButton);
      var2.add(var3, "North");
      JPanel var4 = new JPanel(new BorderLayout());
      var4.setBorder(new EmptyBorder(0, 5, 0, 4));
      var4.add(this.previewPane, "Center");
      JPanel var5 = new JPanel(new BorderLayout());
      var5.setBorder(new EmptyBorder(10, 10, 10, 10));
      JPanel var6 = new JPanel(new BorderLayout());
      var6.add(this.pageSetupButton, "West");
      JPanel var7 = new JPanel(new GridLayout(1, 2, 5, 5));
      var7.add(this.printButton);
      var7.add(this.cancelButton);
      var5.add(var6, "West");
      var5.add(var7, "East");
      var1.add(var2, "North");
      var1.add(var4, "Center");
      var1.add(var5, "South");
      this.add(var1, "Center");
   }

   public void dispose() {
      this.cancelButton.removeActionListener(this.buttonListener);
      this.optionsButton.removeActionListener(this.buttonListener);
      this.printButton.removeActionListener(this.buttonListener);
      super.dispose();
   }

   // $FF: synthetic method
   static JComboBox access$102(PrintGraphPreviewDialog var0, JComboBox var1) {
      return var0.zoomComboBox = var1;
   }

   // $FF: synthetic method
   static JScrollPane access$202(PrintGraphPreviewDialog var0, JScrollPane var1) {
      return var0.previewPane = var1;
   }

   // $FF: synthetic method
   static JButton access$302(PrintGraphPreviewDialog var0, JButton var1) {
      return var0.pageSetupButton = var1;
   }

   // $FF: synthetic method
   static JButton access$402(PrintGraphPreviewDialog var0, JButton var1) {
      return var0.printButton = var1;
   }

   // $FF: synthetic method
   static JButton access$502(PrintGraphPreviewDialog var0, JButton var1) {
      return var0.zoomOutButton = var1;
   }

   // $FF: synthetic method
   static JButton access$602(PrintGraphPreviewDialog var0, JButton var1) {
      return var0.zoomInButton = var1;
   }

   // $FF: synthetic method
   static JButton access$700(PrintGraphPreviewDialog var0) {
      return var0.cancelButton;
   }

   // $FF: synthetic method
   static JButton access$400(PrintGraphPreviewDialog var0) {
      return var0.printButton;
   }

   // $FF: synthetic method
   static JButton access$800(PrintGraphPreviewDialog var0) {
      return var0.optionsButton;
   }

   // $FF: synthetic method
   static bW access$900(PrintGraphPreviewDialog var0) {
      return var0.printer;
   }

   // $FF: synthetic method
   static PrintGraphPreviewDialog$CGraph2DPrintPreviewPanel access$1000(PrintGraphPreviewDialog var0) {
      return var0.hiddenPrinterPreviewPanel;
   }
}
