package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.ConditionBox;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.AddConditionAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.tree.TreePath;

public class AddConditionButtonListener extends AbstractAction {
   private final JCriteriumTree jtree;
   private final ConditionBox selectionBox;
   private final ExpressionTreeActionProvider actionProvider;

   public AddConditionButtonListener(JCriteriumTree var1, ConditionBox var2, ExpressionTreeActionProvider var3) {
      this.jtree = var1;
      this.selectionBox = var2;
      this.actionProvider = var3;
   }

   public void actionPerformed(ActionEvent var1) {
      TreePath var2 = this.jtree.getSelectionPath();
      boolean var3 = var2.getPathCount() == 1;
      if(!var3 && ((AbstractCriteriumTreeNode)var2.getLastPathComponent()).getCriterium().getType() == CriteriumType.CONDITION) {
         this.jtree.setCurrentCriteriumPath(var2.getParentPath());
      } else {
         this.jtree.setCurrentCriteriumPath(var2);
      }

      (new AddConditionAction(this.selectionBox, this.actionProvider)).actionPerformed(var1);
   }
}
