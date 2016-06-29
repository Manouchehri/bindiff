package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.ICriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider$InternalCriteriumListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import java.util.Iterator;
import javax.swing.tree.TreePath;

public class ExpressionTreeActionProvider {
   private final JCriteriumTree jtree;
   private final CriteriumTree ctree;
   private final ICriteriumListener internalCriteriumListener = new ExpressionTreeActionProvider$InternalCriteriumListener(this, (ExpressionTreeActionProvider$1)null);

   public ExpressionTreeActionProvider(JCriteriumTree var1, CriteriumTree var2) {
      this.jtree = var1;
      this.ctree = var2;
      var1.getModel().setActionProvider(this);
   }

   private ICriteriumTreeNode findNode(ICriteriumTreeNode var1, ICriterium var2) {
      if(var1.getCriterium() == var2) {
         return var1;
      } else {
         Iterator var3 = var1.getChildren().iterator();

         ICriteriumTreeNode var5;
         do {
            if(!var3.hasNext()) {
               return null;
            }

            ICriteriumTreeNode var4 = (ICriteriumTreeNode)var3.next();
            var5 = this.findNode(var4, var2);
         } while(var5 == null);

         return var5;
      }
   }

   public void appendCriterium(ICriterium var1) {
      TreePath var2 = this.jtree.getCurrentCriteriumPath();
      if(var2 != null) {
         var1.addListener(this.internalCriteriumListener);
         AbstractCriteriumTreeNode var3 = (AbstractCriteriumTreeNode)var2.getLastPathComponent();
         ICriteriumTreeNode var4 = this.findNode(this.ctree.getRoot(), var3.getCriterium());
         this.ctree.appendNode(var4, new CriteriumTreeNode(var1));
      }
   }

   public CriteriumTree getCriteriumTree() {
      return this.ctree;
   }

   public JCriteriumTree getJTree() {
      return this.jtree;
   }

   public void insertCriterium(ICriterium var1) {
      TreePath var2 = this.jtree.getCurrentCriteriumPath();
      if(var2 != null) {
         var1.addListener(this.internalCriteriumListener);
         AbstractCriteriumTreeNode var3 = (AbstractCriteriumTreeNode)var2.getLastPathComponent();
         ICriteriumTreeNode var4 = this.findNode(this.ctree.getRoot(), var3.getCriterium());
         this.ctree.insertNode(var4, new CriteriumTreeNode(var1));
      }
   }

   public void remove(TreePath var1) {
      if(var1 != null) {
         AbstractCriteriumTreeNode var2 = (AbstractCriteriumTreeNode)var1.getLastPathComponent();
         ICriteriumTreeNode var3 = this.findNode(this.ctree.getRoot(), var2.getCriterium());
         this.ctree.removeNode(var3);
      }
   }

   public void removeAll() {
      this.ctree.removeAll();
   }

   // $FF: synthetic method
   static JCriteriumTree access$100(ExpressionTreeActionProvider var0) {
      return var0.jtree;
   }
}
