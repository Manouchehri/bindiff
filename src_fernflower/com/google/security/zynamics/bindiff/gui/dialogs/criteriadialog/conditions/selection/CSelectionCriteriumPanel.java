package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.CSelectionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.CSelectionCriteriumPanel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.CSelectionCriteriumPanel$InternalComboboxListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.SelectionState;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class CSelectionCriteriumPanel extends JPanel {
   private final JComboBox selectionBox = new JComboBox();
   private final CSelectionCriteriumPanel$InternalComboboxListener comboboxListner = new CSelectionCriteriumPanel$InternalComboboxListener(this, (CSelectionCriteriumPanel$1)null);
   private final CSelectionCriterium criterium;

   public CSelectionCriteriumPanel(CSelectionCriterium var1) {
      super(new BorderLayout());
      this.criterium = var1;
      this.selectionBox.addActionListener(this.comboboxListner);
      this.initPanel();
   }

   private void initPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new TitledBorder("Edit Selection Condition"));
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new EmptyBorder(5, 5, 5, 5));
      this.selectionBox.addItem(SelectionState.SELECTED.toString());
      this.selectionBox.addItem(SelectionState.UNSELECTED.toString());
      var2.add(this.selectionBox, "Center");
      var1.add(var2, "North");
      this.add(var1, "Center");
   }

   public void delete() {
      this.selectionBox.removeActionListener(this.comboboxListner);
   }

   public SelectionState getSelectionState() {
      return (SelectionState)this.selectionBox.getSelectedItem();
   }

   // $FF: synthetic method
   static CSelectionCriterium access$100(CSelectionCriteriumPanel var0) {
      return var0.criterium;
   }
}
