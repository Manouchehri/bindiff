package org.jfree.ui.tabbedui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JPanel;
import org.jfree.ui.tabbedui.AbstractTabbedUI;
import org.jfree.ui.tabbedui.TabbedDialog$1;
import org.jfree.ui.tabbedui.TabbedDialog$MenuBarChangeListener;

public class TabbedDialog extends JDialog {
   private AbstractTabbedUI tabbedUI;

   public TabbedDialog() {
   }

   public TabbedDialog(Dialog var1) {
      super(var1);
   }

   public TabbedDialog(Dialog var1, boolean var2) {
      super(var1, var2);
   }

   public TabbedDialog(Dialog var1, String var2) {
      super(var1, var2);
   }

   public TabbedDialog(Dialog var1, String var2, boolean var3) {
      super(var1, var2, var3);
   }

   public TabbedDialog(Frame var1) {
      super(var1);
   }

   public TabbedDialog(Frame var1, boolean var2) {
      super(var1, var2);
   }

   public TabbedDialog(Frame var1, String var2) {
      super(var1, var2);
   }

   public TabbedDialog(Frame var1, String var2, boolean var3) {
      super(var1, var2, var3);
   }

   protected final AbstractTabbedUI getTabbedUI() {
      return this.tabbedUI;
   }

   public void init(AbstractTabbedUI var1) {
      this.tabbedUI = var1;
      this.tabbedUI.addPropertyChangeListener("jMenuBar", new TabbedDialog$MenuBarChangeListener(this));
      this.addWindowListener(new TabbedDialog$1(this));
      JPanel var2 = new JPanel();
      var2.setLayout(new BorderLayout());
      var2.add(var1, "Center");
      this.setContentPane(var2);
      this.setJMenuBar(var1.getJMenuBar());
   }
}
