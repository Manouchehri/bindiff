package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog$1;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import javax.swing.JDialog;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class BaseDialog extends JDialog {
   public BaseDialog(Window var1, String var2) {
      super(var1, ModalityType.APPLICATION_MODAL);
      this.init();
      this.setTitle(var2);
   }

   public BaseDialog(Window var1, String var2, int var3, int var4) {
      this(var1, var2);
      this.setSize(var3, var4);
      this.setMinimumSize(new Dimension(var3, var4));
   }

   private void init() {
      this.getRootPane().registerKeyboardAction(new BaseDialog$1(this), "doEscape", KeyStroke.getKeyStroke(27, 0, false), 2);
   }

   public void setVisible(boolean var1) {
      if(var1) {
         UIManager.put("TabbedPane.tabAreaInsets", new Insets(2, 2, 0, 2));
         UIManager.put("TabbedPane.contentBorderInsets", new Insets(4, 2, 3, 2));
         SwingUtilities.updateComponentTreeUI(this);
      }

      super.setVisible(var1);
   }
}
