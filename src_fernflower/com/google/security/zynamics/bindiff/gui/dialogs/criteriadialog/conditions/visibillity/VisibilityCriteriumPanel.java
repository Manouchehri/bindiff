package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityCriteriumPanel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityCriteriumPanel$InternalComboboxListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityState;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class VisibilityCriteriumPanel extends JPanel {
   private final JComboBox visibilityBox = new JComboBox();
   private final VisibilityCriteriumPanel$InternalComboboxListener comboboxListner = new VisibilityCriteriumPanel$InternalComboboxListener(this, (VisibilityCriteriumPanel$1)null);
   private final VisibilityCriterium criterium;

   public VisibilityCriteriumPanel(VisibilityCriterium var1) {
      super(new BorderLayout());
      this.criterium = var1;
      this.visibilityBox.addActionListener(this.comboboxListner);
      this.initPanel();
   }

   private void initPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new TitledBorder("Edit Visibility Condition"));
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new EmptyBorder(5, 5, 5, 5));
      this.visibilityBox.addItem(VisibilityState.VISIBLE.toString());
      this.visibilityBox.addItem(VisibilityState.UNVISIBLE.toString());
      var2.add(this.visibilityBox, "Center");
      var1.add(var2, "North");
      this.add(var1, "Center");
   }

   public void delete() {
      this.visibilityBox.removeActionListener(this.comboboxListner);
   }

   public VisibilityState getVisibilityState() {
      return (VisibilityState)this.visibilityBox.getSelectedItem();
   }

   // $FF: synthetic method
   static VisibilityCriterium access$100(VisibilityCriteriumPanel var0) {
      return var0.criterium;
   }
}
