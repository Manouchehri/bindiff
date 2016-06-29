package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class RemoveAllAction extends AbstractAction {
   private final ExpressionTreeActionProvider actionProvider;

   public RemoveAllAction(ExpressionTreeActionProvider var1) {
      super("Remove All");
      this.actionProvider = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.actionProvider.removeAll();
   }
}
