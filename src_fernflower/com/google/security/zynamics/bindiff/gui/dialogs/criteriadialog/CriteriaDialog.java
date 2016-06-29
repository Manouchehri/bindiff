package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.AddConditionButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.ConditionBox;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.CriteriaDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.CriteriaDialog$InternalOkCancelButttonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.CriteriaFactory;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.DialogUpdater;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.CriteriumTreeNode;
import com.google.security.zynamics.zylib.gui.CPanelTwoButtons;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Window;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public final class CriteriaDialog extends BaseDialog {
   private final CriteriumTree ctree;
   private boolean selectNodes;
   private final DialogUpdater updater;
   private final JCriteriumTree jtree;

   public CriteriaDialog(Window var1, CriteriaFactory var2) {
      super(var1, "Select by Criteria");
      this.setModal(true);
      if(var2 == null) {
         throw new IllegalArgumentException("Condition factory argument can not be null");
      } else {
         List var3 = var2.getConditions();
         this.ctree = new CriteriumTree();
         this.jtree = new JCriteriumTree(this.ctree, var3);
         ExpressionTreeActionProvider var4 = new ExpressionTreeActionProvider(this.jtree, this.ctree);
         CriteriumTreeNode var5 = new CriteriumTreeNode(this.ctree.getRootCriterium(), var3, var4);
         this.jtree.getModel().setRoot(var5);
         ConditionBox var6 = new ConditionBox(var3);
         AddConditionButtonListener var7 = new AddConditionButtonListener(this.jtree, var6, var4);
         JButton var8 = new JButton(var7);
         CPanelTwoButtons var9 = new CPanelTwoButtons(new CriteriaDialog$InternalOkCancelButttonListener(this, (CriteriaDialog$1)null), "Execute", "Cancel");
         JPanel var10 = new JPanel(new BorderLayout());
         this.initDialog(var1, this.jtree, var6, var10, var9, var8);
         this.updater = new DialogUpdater(this.jtree, this.ctree, var10, var8, var9.getFirstButton());
      }
   }

   private void initDialog(Window var1, JCriteriumTree var2, ConditionBox var3, JPanel var4, CPanelTwoButtons var5, JButton var6) {
      JPanel var7 = new JPanel(new BorderLayout());
      JPanel var8 = new JPanel(new BorderLayout());
      var8.setBorder(new EmptyBorder(2, 2, 2, 2));
      JPanel var9 = new JPanel(new GridLayout(1, 2));
      JPanel var10 = new JPanel(new BorderLayout());
      var10.setBorder(new TitledBorder("Expression Tree"));
      JPanel var11 = new JPanel(new BorderLayout());
      JPanel var12 = new JPanel(new BorderLayout());
      var12.setBorder(new TitledBorder("Create Condition"));
      JPanel var13 = new JPanel(new BorderLayout());
      var13.setBorder(new EmptyBorder(1, 5, 5, 5));
      JPanel var14 = new JPanel(new BorderLayout());
      var14.setBorder(new EmptyBorder(1, 0, 5, 5));
      var7.add(var8, "Center");
      var7.add(var5, "South");
      var5.getFirstButton().setEnabled(var2.getSelectionPath() != null);
      var8.add(var9, "Center");
      var9.add(var10);
      var9.add(var11);
      JScrollPane var15 = new JScrollPane(var2);
      var15.setVerticalScrollBarPolicy(20);
      var15.setHorizontalScrollBarPolicy(30);
      var10.add(var15, "Center");
      var4.setBorder(new TitledBorder("Define Condition"));
      var11.add(var12, "North");
      var11.add(var4, "Center");
      var12.add(var13, "Center");
      var12.add(var14, "East");
      var13.add(var3, "Center");
      var6.setText("Add");
      var6.setEnabled(false);
      var14.add(var6, "Center");
      this.add(var7);
      this.setIconImage((Image)null);
      this.pack();
      GuiHelper.centerChildToParent(var1, this, true);
   }

   public void delete() {
      this.updater.delete();
   }

   public boolean doSelectNodes() {
      return this.selectNodes;
   }

   public CriteriumTree getCriteriumTree() {
      return this.ctree;
   }

   // $FF: synthetic method
   static boolean access$102(CriteriaDialog var0, boolean var1) {
      return var0.selectNodes = var1;
   }
}
