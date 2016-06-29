package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.DialogUpdater;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.DialogUpdater$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.ICriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeValidator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ICriteriumTreeListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.AbstractOperatorPanel;
import java.util.Enumeration;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class DialogUpdater$InternalCriteriumTreeListener implements ICriteriumTreeListener {
   // $FF: synthetic field
   final DialogUpdater this$0;

   private DialogUpdater$InternalCriteriumTreeListener(DialogUpdater var1) {
      this.this$0 = var1;
   }

   private void update() {
      this.updateInfoField();
      DialogUpdater.access$300(this.this$0).setEnabled(ExpressionTreeValidator.isValid(DialogUpdater.access$200(this.this$0)));
   }

   private void updateCurrentCriteriumPath() {
      if(DialogUpdater.access$200(this.this$0).getSelectionPath() != null) {
         DialogUpdater.access$200(this.this$0).setCurrentCriteriumPath(DialogUpdater.access$200(this.this$0).getSelectionPath());
      } else {
         DialogUpdater.access$200(this.this$0).setCurrentCriteriumPath(DialogUpdater.access$200(this.this$0).getPathForRow(0));
      }

      DialogUpdater.access$400(this.this$0, (AbstractCriteriumTreeNode)DialogUpdater.access$200(this.this$0).getCurrentCriteriumPath().getLastPathComponent());
   }

   private void updateInfoField() {
      JPanel var3;
      for(Enumeration var1 = ((AbstractCriteriumTreeNode)DialogUpdater.access$200(this.this$0).getModel().getRoot()).breadthFirstEnumeration(); var1.hasMoreElements(); var3.updateUI()) {
         AbstractCriteriumTreeNode var2 = (AbstractCriteriumTreeNode)var1.nextElement();
         var3 = var2.getCriterium().getCriteriumPanel();
         if(var3 instanceof AbstractOperatorPanel) {
            int var4 = var2.getChildCount();
            CriteriumType var5 = var2.getCriterium().getType();
            JTextArea var6 = ((AbstractOperatorPanel)var3).getInfoField();
            if((var4 != 1 || var5 != CriteriumType.NOT && var2.getLevel() != 0) && (var4 <= 1 || var5 == CriteriumType.NOT)) {
               var6.setForeground(DialogUpdater.access$600());
               var6.setText(((AbstractOperatorPanel)var3).getInvalidInfoString());
            } else {
               var6.setForeground(DialogUpdater.access$500());
               var6.setText(((AbstractOperatorPanel)var3).getValidInfoString());
            }
         }
      }

   }

   public void nodeAppended(CriteriumTree var1, ICriteriumTreeNode var2, ICriteriumTreeNode var3) {
      this.update();
   }

   public void nodeInserted(CriteriumTree var1, ICriteriumTreeNode var2, ICriteriumTreeNode var3) {
      this.update();
   }

   public void nodeRemoved(CriteriumTree var1, ICriteriumTreeNode var2) {
      this.updateCurrentCriteriumPath();
      this.update();
   }

   public void removedAll(CriteriumTree var1) {
      this.updateCurrentCriteriumPath();
      this.update();
   }

   // $FF: synthetic method
   DialogUpdater$InternalCriteriumTreeListener(DialogUpdater var1, DialogUpdater$1 var2) {
      this(var1);
   }
}
