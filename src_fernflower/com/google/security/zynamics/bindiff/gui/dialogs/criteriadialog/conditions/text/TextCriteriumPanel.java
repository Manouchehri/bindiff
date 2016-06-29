package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text.TextCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text.TextCriteriumPanel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text.TextCriteriumPanel$InternalTextListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class TextCriteriumPanel extends JPanel {
   private final JTextField inputField = new JTextField("");
   private final JCheckBox caseSensitiveBox = new JCheckBox("Case Sensitive");
   private final JCheckBox regExBox = new JCheckBox("Regular Expression");
   private final TextCriterium criterium;

   public TextCriteriumPanel(TextCriterium var1) {
      super(new BorderLayout());
      this.criterium = var1;
      this.initPanel();
   }

   private void initPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new TitledBorder("Edit Text Condition"));
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new EmptyBorder(5, 5, 5, 5));
      this.inputField.addKeyListener(new TextCriteriumPanel$InternalTextListener(this, (TextCriteriumPanel$1)null));
      this.inputField.setPreferredSize(new Dimension(this.inputField.getPreferredSize().width, 23));
      var2.add(this.inputField, "North");
      JPanel var3 = new JPanel(new GridLayout(2, 1));
      var3.setBorder(new EmptyBorder(5, 0, 0, 0));
      var3.add(this.caseSensitiveBox);
      var3.add(this.regExBox);
      var2.add(var3, "Center");
      var1.add(var2, "North");
      this.add(var1, "Center");
   }

   public String getText() {
      return this.inputField.getText();
   }

   public boolean isCaseSensitive() {
      return this.caseSensitiveBox.isSelected();
   }

   public boolean isRegularExpression() {
      return this.regExBox.isSelected();
   }

   // $FF: synthetic method
   static TextCriterium access$100(TextCriteriumPanel var0) {
      return var0.criterium;
   }
}
