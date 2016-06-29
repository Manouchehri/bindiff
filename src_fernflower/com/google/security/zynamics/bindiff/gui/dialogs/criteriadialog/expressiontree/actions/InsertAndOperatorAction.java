package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.AndCriterium;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class InsertAndOperatorAction extends AbstractAction {
   private final ExpressionTreeActionProvider actionProvider;

   public InsertAndOperatorAction(ExpressionTreeActionProvider var1) {
      super("Insert AND");
      this.actionProvider = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.actionProvider.insertCriterium(new AndCriterium());
   }
}
