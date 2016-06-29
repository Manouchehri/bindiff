package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumPanel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumPanel$InternalComboboxListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumPanel$InternalTextListener;
import com.google.security.zynamics.zylib.gui.CDecFormatter;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class IndegreeCriteriumPanel extends JPanel {
   private final IndegreeCriterium criterium;
   private final JFormattedTextField inputField = new JFormattedTextField(new CDecFormatter(8));
   private final JComboBox operatorBox = new JComboBox();
   private final IndegreeCriteriumPanel$InternalComboboxListener comboboxListener = new IndegreeCriteriumPanel$InternalComboboxListener(this, (IndegreeCriteriumPanel$1)null);
   private final IndegreeCriteriumPanel$InternalTextListener textFieldListener = new IndegreeCriteriumPanel$InternalTextListener(this, (IndegreeCriteriumPanel$1)null);

   public IndegreeCriteriumPanel(IndegreeCriterium var1) {
      super(new BorderLayout());
      this.criterium = var1;
      this.operatorBox.addActionListener(this.comboboxListener);
      this.inputField.addKeyListener(this.textFieldListener);
      this.initPanel();
   }

   private void initPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new TitledBorder("Edit Indegree Condition"));
      this.operatorBox.addItem("<");
      this.operatorBox.addItem("=");
      this.operatorBox.addItem(">");
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new EmptyBorder(5, 5, 5, 5));
      var2.add(this.operatorBox, "Center");
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(new EmptyBorder(5, 0, 5, 5));
      var3.add(this.inputField, "Center");
      JPanel var4 = new JPanel(new BorderLayout());
      var4.add(var2, "West");
      var4.add(var3, "Center");
      var1.add(var4, "North");
      this.add(var1, "Center");
   }

   public void delete() {
      this.operatorBox.removeActionListener(this.comboboxListener);
      this.inputField.removeKeyListener(this.textFieldListener);
   }

   public int getIndegree() {
      return this.inputField.getText().isEmpty()?0:Integer.valueOf(this.inputField.getText()).intValue();
   }

   public String getOperator() {
      return this.operatorBox.getSelectedItem().toString();
   }

   // $FF: synthetic method
   static IndegreeCriterium access$200(IndegreeCriteriumPanel var0) {
      return var0.criterium;
   }
}
