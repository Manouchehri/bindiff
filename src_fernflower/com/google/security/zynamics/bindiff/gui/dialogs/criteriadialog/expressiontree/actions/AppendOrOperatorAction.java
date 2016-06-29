package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.OrCriterium;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class AppendOrOperatorAction extends AbstractAction {
   private final ExpressionTreeActionProvider actionProvider;

   public AppendOrOperatorAction(ExpressionTreeActionProvider var1) {
      super("Append OR");
      this.actionProvider = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.actionProvider.appendCriterium(new OrCriterium());
   }
}
