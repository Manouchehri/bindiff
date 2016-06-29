package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ResourceBundle;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import org.jfree.ui.IntegerDocument;

public class InsetsChooserPanel extends JPanel {
   private JTextField topValueEditor;
   private JTextField leftValueEditor;
   private JTextField bottomValueEditor;
   private JTextField rightValueEditor;
   protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.ui.LocalizationBundle");

   public InsetsChooserPanel() {
      this(new Insets(0, 0, 0, 0));
   }

   public InsetsChooserPanel(Insets var1) {
      var1 = var1 == null?new Insets(0, 0, 0, 0):var1;
      this.topValueEditor = new JTextField(new IntegerDocument(), "" + var1.top, 0);
      this.leftValueEditor = new JTextField(new IntegerDocument(), "" + var1.left, 0);
      this.bottomValueEditor = new JTextField(new IntegerDocument(), "" + var1.bottom, 0);
      this.rightValueEditor = new JTextField(new IntegerDocument(), "" + var1.right, 0);
      JPanel var2 = new JPanel(new GridBagLayout());
      var2.setBorder(new TitledBorder(localizationResources.getString("Insets")));
      var2.add(new JLabel(localizationResources.getString("Top")), new GridBagConstraints(1, 0, 3, 1, 0.0D, 0.0D, 10, 0, new Insets(0, 0, 0, 0), 0, 0));
      var2.add(new JLabel(" "), new GridBagConstraints(1, 1, 1, 1, 0.0D, 0.0D, 10, 1, new Insets(0, 12, 0, 12), 8, 0));
      var2.add(this.topValueEditor, new GridBagConstraints(2, 1, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(0, 0, 0, 0), 0, 0));
      var2.add(new JLabel(" "), new GridBagConstraints(3, 1, 1, 1, 0.0D, 0.0D, 10, 1, new Insets(0, 12, 0, 11), 8, 0));
      var2.add(new JLabel(localizationResources.getString("Left")), new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 10, 1, new Insets(0, 4, 0, 4), 0, 0));
      var2.add(this.leftValueEditor, new GridBagConstraints(1, 2, 1, 1, 0.0D, 0.0D, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
      var2.add(new JLabel(" "), new GridBagConstraints(2, 2, 1, 1, 0.0D, 0.0D, 10, 0, new Insets(0, 12, 0, 12), 8, 0));
      var2.add(this.rightValueEditor, new GridBagConstraints(3, 2, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(0, 0, 0, 0), 0, 0));
      var2.add(new JLabel(localizationResources.getString("Right")), new GridBagConstraints(4, 2, 1, 1, 0.0D, 0.0D, 10, 0, new Insets(0, 4, 0, 4), 0, 0));
      var2.add(this.bottomValueEditor, new GridBagConstraints(2, 3, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(0, 0, 0, 0), 0, 0));
      var2.add(new JLabel(localizationResources.getString("Bottom")), new GridBagConstraints(1, 4, 3, 1, 0.0D, 0.0D, 10, 0, new Insets(0, 0, 0, 0), 0, 0));
      this.setLayout(new BorderLayout());
      this.add(var2, "Center");
   }

   public Insets getInsetsValue() {
      return new Insets(Math.abs(this.stringToInt(this.topValueEditor.getText())), Math.abs(this.stringToInt(this.leftValueEditor.getText())), Math.abs(this.stringToInt(this.bottomValueEditor.getText())), Math.abs(this.stringToInt(this.rightValueEditor.getText())));
   }

   protected int stringToInt(String var1) {
      var1 = var1.trim();
      if(var1.length() == 0) {
         return 0;
      } else {
         try {
            return Integer.parseInt(var1);
         } catch (NumberFormatException var3) {
            return 0;
         }
      }
   }

   public void removeNotify() {
      super.removeNotify();
      this.removeAll();
   }
}
