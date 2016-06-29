package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.DialogUpdater;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.DialogUpdater$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

class DialogUpdater$InternalTreeSelectionListener implements TreeSelectionListener {
   // $FF: synthetic field
   final DialogUpdater this$0;

   private DialogUpdater$InternalTreeSelectionListener(DialogUpdater var1) {
      this.this$0 = var1;
   }

   public void valueChanged(TreeSelectionEvent var1) {
      TreePath var2 = var1.getPath();
      if(var2 == null) {
         DialogUpdater.access$700(this.this$0).setEnabled(false);
         DialogUpdater.access$400(this.this$0, (AbstractCriteriumTreeNode)DialogUpdater.access$200(this.this$0).getModel().getRoot());
      } else {
         AbstractCriteriumTreeNode var3 = (AbstractCriteriumTreeNode)var2.getLastPathComponent();
         boolean var4 = var3.allowAppend(CriteriumType.CONDITION);
         if(!var4 && var3.getLevel() > 0) {
            AbstractCriteriumTreeNode var5 = (AbstractCriteriumTreeNode)var3.getParent();
            if(var5.getLevel() != 0 && var5.getCriterium().getType() != CriteriumType.NOT && var3.getCriterium().getType() != CriteriumType.NOT) {
               var4 = true;
            }
         }

         DialogUpdater.access$700(this.this$0).setEnabled(var4);
         DialogUpdater.access$400(this.this$0, var3);
      }

   }

   // $FF: synthetic method
   DialogUpdater$InternalTreeSelectionListener(DialogUpdater var1, DialogUpdater$1 var2) {
      this(var1);
   }
}
