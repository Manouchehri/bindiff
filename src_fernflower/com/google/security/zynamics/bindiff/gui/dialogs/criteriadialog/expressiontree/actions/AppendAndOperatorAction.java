package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.AndCriterium;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class AppendAndOperatorAction extends AbstractAction {
   private final ExpressionTreeActionProvider actionProvider;

   public AppendAndOperatorAction(ExpressionTreeActionProvider var1) {
      super("Append AND");
      this.actionProvider = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.actionProvider.appendCriterium(new AndCriterium());
   }
}
