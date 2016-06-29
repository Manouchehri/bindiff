package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionCriteriumPanel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionCriteriumPanel$InternalComboboxListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionState;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class RecursionCriteriumPanel extends JPanel {
   private final JComboBox recursionBox = new JComboBox();
   private final RecursionCriteriumPanel$InternalComboboxListener comboboxListner = new RecursionCriteriumPanel$InternalComboboxListener(this, (RecursionCriteriumPanel$1)null);
   private final RecursionCriterium criterium;

   public RecursionCriteriumPanel(RecursionCriterium var1) {
      super(new BorderLayout());
      this.criterium = var1;
      this.recursionBox.addActionListener(this.comboboxListner);
      this.initPanel();
   }

   private void initPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new TitledBorder("Edit Recursion Condition"));
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new EmptyBorder(5, 5, 5, 5));
      this.recursionBox.addItem(RecursionState.IS_RECURSION.toString());
      this.recursionBox.addItem(RecursionState.IS_NOT_RECURSION.toString());
      var2.add(this.recursionBox, "Center");
      var1.add(var2, "North");
      this.add(var1, "Center");
   }

   public void delete() {
      this.recursionBox.removeActionListener(this.comboboxListner);
   }

   public RecursionState getRecursionState() {
      return (RecursionState)this.recursionBox.getSelectedItem();
   }

   // $FF: synthetic method
   static RecursionCriterium access$100(RecursionCriteriumPanel var0) {
      return var0.criterium;
   }
}
