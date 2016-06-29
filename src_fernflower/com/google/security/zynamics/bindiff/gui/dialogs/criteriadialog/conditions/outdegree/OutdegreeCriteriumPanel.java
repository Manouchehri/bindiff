package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumPanel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumPanel$InternalComboboxListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumPanel$InternalTextListener;
import com.google.security.zynamics.zylib.gui.CDecFormatter;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class OutdegreeCriteriumPanel extends JPanel {
   private final OutdegreeCriterium criterium;
   private final JFormattedTextField inputField = new JFormattedTextField(new CDecFormatter(8));
   private final JComboBox operatorBox = new JComboBox();
   private final OutdegreeCriteriumPanel$InternalComboboxListener comboboxListener = new OutdegreeCriteriumPanel$InternalComboboxListener(this, (OutdegreeCriteriumPanel$1)null);
   private final OutdegreeCriteriumPanel$InternalTextListener textFieldListener = new OutdegreeCriteriumPanel$InternalTextListener(this, (OutdegreeCriteriumPanel$1)null);

   public OutdegreeCriteriumPanel(OutdegreeCriterium var1) {
      super(new BorderLayout());
      this.criterium = var1;
      this.operatorBox.addActionListener(this.comboboxListener);
      this.inputField.addKeyListener(this.textFieldListener);
      this.initPanel();
   }

   private void initPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new TitledBorder("Edit Outdegree Condition"));
      this.operatorBox.addItem("<");
      this.operatorBox.addItem("=");
      this.operatorBox.addItem(">");
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new EmptyBorder(5, 5, 5, 5));
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(new EmptyBorder(5, 0, 5, 5));
      var2.add(this.operatorBox, "Center");
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

   public String getOperator() {
      return this.operatorBox.getSelectedItem().toString();
   }

   public int getOutdegree() {
      return this.inputField.getText().isEmpty()?0:Integer.valueOf(this.inputField.getText()).intValue();
   }

   // $FF: synthetic method
   static OutdegreeCriterium access$200(OutdegreeCriteriumPanel var0) {
      return var0.criterium;
   }
}
