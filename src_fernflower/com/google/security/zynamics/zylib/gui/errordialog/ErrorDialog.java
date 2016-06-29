package com.google.security.zynamics.zylib.gui.errordialog;

import com.google.security.zynamics.zylib.general.StackTrace;
import com.google.security.zynamics.zylib.gui.CDialogEscaper;
import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog$1;
import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog$CloseButtonListener;
import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog$ReportAction;
import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog$SendAction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.io.PrintStream;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public abstract class ErrorDialog extends JDialog {
   private static final long serialVersionUID = -2246347447228688878L;
   private final String m_description;
   private final Throwable m_exception;
   private final String m_message;

   public ErrorDialog(Window var1, String var2, String var3) {
      this(var1, var2, var3, (Throwable)null);
   }

   public ErrorDialog(Window var1, String var2, String var3, Throwable var4) {
      super(var1, ModalityType.APPLICATION_MODAL);
      this.m_message = var2;
      this.m_description = var3;
      this.m_exception = var4;
      new CDialogEscaper(this);
      this.setLayout(new BorderLayout());
      this.createGui();
      this.setMinimumSize(new Dimension(600, 400));
      this.setSize(600, 400);
   }

   private void createGui() {
      JPanel var1 = new JPanel(new BorderLayout());
      JPanel var2 = new JPanel(new BorderLayout());
      JTextField var3 = new JTextField();
      var3.setEditable(false);
      var3.setText(this.m_message);
      var3.setBackground(Color.WHITE);
      var2.add(var3);
      var2.setBorder(new TitledBorder("Error Message"));
      var1.add(var2, "North");
      JTabbedPane var4 = new JTabbedPane();
      JTextArea var5 = new JTextArea();
      var5.setEditable(false);
      var5.setText(this.m_description);
      var5.setLineWrap(true);
      var5.setWrapStyleWord(true);
      var4.addTab("Description", var5);
      if(this.m_exception != null) {
         JTextArea var6 = new JTextArea();
         var6.setEditable(false);
         var6.setText(StackTrace.toString(this.m_exception.getStackTrace()));
         var4.addTab("Stack Trace", new JScrollPane(var6));
      }

      this.add(var1, "North");
      this.add(var4);
      JPanel var12 = new JPanel(new BorderLayout());
      JPanel var7 = new JPanel();
      JButton var8 = new JButton(new ErrorDialog$SendAction(this, (ErrorDialog$1)null));
      var8.setMinimumSize(new Dimension(180, var8.getHeight()));
      JButton var9 = new JButton(new ErrorDialog$ReportAction(this, (ErrorDialog$1)null));
      var7.add(var8);
      var7.add(var9);
      var12.add(var7, "West");
      JPanel var10 = new JPanel();
      JButton var11 = new JButton(new ErrorDialog$CloseButtonListener(this, (ErrorDialog$1)null));
      this.getRootPane().setDefaultButton(var11);
      var10.add(var11);
      var12.add(var10, "East");
      this.add(var12, "South");
   }

   protected ImageIcon createImageIcon(String var1, String var2) {
      // $FF: Couldn't be decompiled
   }

   protected abstract void report();

   protected abstract void send(String var1, String var2, Throwable var3);

   // $FF: synthetic method
   static String access$300(ErrorDialog var0) {
      return var0.m_description;
   }

   // $FF: synthetic method
   static String access$400(ErrorDialog var0) {
      return var0.m_message;
   }

   // $FF: synthetic method
   static Throwable access$500(ErrorDialog var0) {
      return var0.m_exception;
   }
}
