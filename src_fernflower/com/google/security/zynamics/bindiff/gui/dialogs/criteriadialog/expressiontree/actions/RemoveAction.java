package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.tree.TreePath;

public class RemoveAction extends AbstractAction {
   private final AbstractCriteriumTreeNode node;
   private final ExpressionTreeActionProvider actionProvider;

   public RemoveAction(AbstractCriteriumTreeNode var1, ExpressionTreeActionProvider var2) {
      super("Remove");
      this.node = var1;
      this.actionProvider = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      this.actionProvider.remove(new TreePath(this.node.getPath()));
   }
}
