package org.jfree.ui;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import org.jfree.ui.L1R2ButtonPanel;

public class StandardDialog extends JDialog implements ActionListener {
   private boolean cancelled = false;
   protected static final ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.ui.LocalizationBundle");

   public StandardDialog(Frame var1, String var2, boolean var3) {
      super(var1, var2, var3);
   }

   public StandardDialog(Dialog var1, String var2, boolean var3) {
      super(var1, var2, var3);
   }

   public boolean isCancelled() {
      return this.cancelled;
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = var1.getActionCommand();
      if(!var2.equals("helpButton")) {
         if(var2.equals("okButton")) {
            this.cancelled = false;
            this.setVisible(false);
         } else if(var2.equals("cancelButton")) {
            this.cancelled = true;
            this.setVisible(false);
         }
      }

   }

   protected JPanel createButtonPanel() {
      L1R2ButtonPanel var1 = new L1R2ButtonPanel(localizationResources.getString("Help"), localizationResources.getString("OK"), localizationResources.getString("Cancel"));
      JButton var2 = var1.getLeftButton();
      var2.setActionCommand("helpButton");
      var2.addActionListener(this);
      JButton var3 = var1.getRightButton1();
      var3.setActionCommand("okButton");
      var3.addActionListener(this);
      JButton var4 = var1.getRightButton2();
      var4.setActionCommand("cancelButton");
      var4.addActionListener(this);
      var1.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
      return var1;
   }
}
