package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public abstract class AbstractOperatorPanel extends JPanel {
   private final JTextArea infoField = new JTextArea();

   public AbstractOperatorPanel() {
      super(new BorderLayout());
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new TitledBorder(this.getBorderTitle()));
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new EmptyBorder(5, 5, 5, 5));
      this.infoField.setBackground(var2.getBackground());
      this.infoField.setLineWrap(true);
      this.infoField.setWrapStyleWord(true);
      this.infoField.setEditable(false);
      var2.add(this.infoField, "Center");
      var1.add(var2, "Center");
      this.add(var1, "Center");
   }

   public abstract String getBorderTitle();

   public JTextArea getInfoField() {
      return this.infoField;
   }

   public abstract String getInvalidInfoString();

   public abstract String getValidInfoString();
}
