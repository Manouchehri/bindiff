package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import org.jfree.ui.FontChooserPanel;
import org.jfree.ui.StandardDialog;

public class FontChooserDialog extends StandardDialog {
   private FontChooserPanel fontChooserPanel;

   public FontChooserDialog(Dialog var1, String var2, boolean var3, Font var4) {
      super(var1, var2, var3);
      this.setContentPane(this.createContent(var4));
   }

   public FontChooserDialog(Frame var1, String var2, boolean var3, Font var4) {
      super(var1, var2, var3);
      this.setContentPane(this.createContent(var4));
   }

   public Font getSelectedFont() {
      return this.fontChooserPanel.getSelectedFont();
   }

   private JPanel createContent(Font var1) {
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      if(var1 == null) {
         var1 = new Font("Dialog", 10, 0);
      }

      this.fontChooserPanel = new FontChooserPanel(var1);
      var2.add(this.fontChooserPanel);
      JPanel var3 = this.createButtonPanel();
      var3.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
      var2.add(var3, "South");
      return var2;
   }
}
