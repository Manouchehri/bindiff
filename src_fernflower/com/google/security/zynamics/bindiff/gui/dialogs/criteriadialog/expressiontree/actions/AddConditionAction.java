package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumWrapper;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JComboBox;

public class AddConditionAction extends AbstractAction {
   private final ICriteriumCreator condition;
   private final ExpressionTreeActionProvider actionProvider;

   public AddConditionAction(ICriteriumCreator var1, ExpressionTreeActionProvider var2) {
      super(var1.getCriteriumDescription());
      this.condition = var1;
      this.actionProvider = var2;
   }

   public AddConditionAction(JComboBox var1, ExpressionTreeActionProvider var2) {
      this.condition = (ICriteriumCreator)((CriteriumWrapper)var1.getSelectedItem()).getObject();
      this.actionProvider = var2;
      if(this.condition != null) {
         this.putValue("Name", this.condition.getCriteriumDescription());
      }

   }

   public void actionPerformed(ActionEvent var1) {
      this.actionProvider.appendCriterium(this.condition.createCriterium());
   }
}
