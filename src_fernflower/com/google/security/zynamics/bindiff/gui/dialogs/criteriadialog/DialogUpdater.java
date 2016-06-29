package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.DialogUpdater$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.DialogUpdater$InternalCriteriumTreeListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.DialogUpdater$InternalTreeSelectionListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.CriteriumTreeNode;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class DialogUpdater {
   private static final Color INVALID_OPERATOR_COLOR = new Color(160, 0, 0);
   private static final Color VALID_OPERATOR_COLOR = new Color(0, 0, 0);
   private final JCriteriumTree jtree;
   private final DialogUpdater$InternalTreeSelectionListener treeSelectionListener = new DialogUpdater$InternalTreeSelectionListener(this, (DialogUpdater$1)null);
   private final DialogUpdater$InternalCriteriumTreeListener treeCriteriumlListener = new DialogUpdater$InternalCriteriumTreeListener(this, (DialogUpdater$1)null);
   private final CriteriumTree ctree;
   private final JPanel defineConditionPanel;
   private final JButton addConditionButton;
   private final JButton okButton;

   public DialogUpdater(JCriteriumTree var1, CriteriumTree var2, JPanel var3, JButton var4, JButton var5) {
      this.jtree = var1;
      this.ctree = var2;
      this.defineConditionPanel = var3;
      this.addConditionButton = var4;
      this.okButton = var5;
      this.jtree.addTreeSelectionListener(this.treeSelectionListener);
      this.ctree.addListener(this.treeCriteriumlListener);
   }

   private void updateDefineConditionPanel(AbstractCriteriumTreeNode var1) {
      JPanel var2 = null;
      if(var1 instanceof CriteriumTreeNode) {
         var2 = var1.getCriterium().getCriteriumPanel();
      }

      this.defineConditionPanel.removeAll();
      this.defineConditionPanel.setBorder((Border)null);
      if(var2 != null) {
         this.defineConditionPanel.add(var2);
      } else {
         JPanel var3 = new JPanel(new BorderLayout());
         var3.setBorder(new TitledBorder("Define Condition"));
         this.defineConditionPanel.add(var3, "Center");
      }

      this.defineConditionPanel.updateUI();
   }

   public void delete() {
      this.jtree.removeTreeSelectionListener(this.treeSelectionListener);
      this.ctree.removeListener(this.treeCriteriumlListener);
   }

   // $FF: synthetic method
   static JCriteriumTree access$200(DialogUpdater var0) {
      return var0.jtree;
   }

   // $FF: synthetic method
   static JButton access$300(DialogUpdater var0) {
      return var0.okButton;
   }

   // $FF: synthetic method
   static void access$400(DialogUpdater var0, AbstractCriteriumTreeNode var1) {
      var0.updateDefineConditionPanel(var1);
   }

   // $FF: synthetic method
   static Color access$500() {
      return VALID_OPERATOR_COLOR;
   }

   // $FF: synthetic method
   static Color access$600() {
      return INVALID_OPERATOR_COLOR;
   }

   // $FF: synthetic method
   static JButton access$700(DialogUpdater var0) {
      return var0.addConditionButton;
   }
}
