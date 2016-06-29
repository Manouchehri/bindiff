package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ICriteriumTreeListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTreeModel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTreeModel$CriteriumTreeListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class JCriteriumTreeModel extends DefaultTreeModel {
   private final CriteriumTree criteriumTree;
   private final List criteria;
   private ExpressionTreeActionProvider actionProvider;
   private final JTree jtree;
   private final ICriteriumTreeListener internalTreeListener = new JCriteriumTreeModel$CriteriumTreeListener(this, (JCriteriumTreeModel$1)null);

   public JCriteriumTreeModel(JTree var1, CriteriumTree var2, List var3) {
      super((TreeNode)null);
      this.jtree = var1;
      this.criteriumTree = var2;
      this.criteria = var3;
      this.criteriumTree.addListener(this.internalTreeListener);
   }

   private AbstractCriteriumTreeNode findParentNode(AbstractCriteriumTreeNode var1, ICriterium var2) {
      if(var1.getCriterium() == var2) {
         return var1;
      } else {
         for(int var3 = 0; var3 < var1.getChildCount(); ++var3) {
            AbstractCriteriumTreeNode var4 = (AbstractCriteriumTreeNode)var1.getChildAt(var3);
            AbstractCriteriumTreeNode var5 = this.findParentNode(var4, var2);
            if(var5 != null) {
               return var5;
            }
         }

         return null;
      }
   }

   public void nodeStructureChanged(TreeNode var1) {
      HashSet var2 = new HashSet();
      Enumeration var3 = this.jtree.getExpandedDescendants(new TreePath(this.getRoot()));
      AbstractCriteriumTreeNode var5;
      if(var3 != null) {
         while(var3.hasMoreElements()) {
            TreePath var4 = (TreePath)var3.nextElement();
            var5 = (AbstractCriteriumTreeNode)var4.getLastPathComponent();
            var2.add(var5.getCriterium());
         }
      }

      super.nodeStructureChanged(var1);
      Enumeration var6 = ((AbstractCriteriumTreeNode)this.getRoot()).breadthFirstEnumeration();

      while(var6.hasMoreElements()) {
         var5 = (AbstractCriteriumTreeNode)var6.nextElement();
         if(var2.contains(var5.getCriterium())) {
            this.jtree.expandPath(new TreePath(var5.getPath()));
         }
      }

      this.jtree.updateUI();
   }

   public void setActionProvider(ExpressionTreeActionProvider var1) {
      this.actionProvider = var1;
   }

   public void sortChildren(AbstractCriteriumTreeNode var1) {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      Enumeration var5 = var1.children();

      while(var5.hasMoreElements()) {
         AbstractCriteriumTreeNode var6 = (AbstractCriteriumTreeNode)var5.nextElement();
         CriteriumType var7 = var6.getCriterium().getType();
         if(var7 == CriteriumType.CONDITION) {
            var3.add(var6);
         } else {
            var2.add(var6);
         }
      }

      var1.removeAllChildren();
      Iterator var8 = var2.iterator();

      AbstractCriteriumTreeNode var9;
      while(var8.hasNext()) {
         var9 = (AbstractCriteriumTreeNode)var8.next();
         var1.add(var9);
         var9.setParent(var1);
      }

      var8 = var3.iterator();

      while(var8.hasNext()) {
         var9 = (AbstractCriteriumTreeNode)var8.next();
         var1.add(var9);
         var9.setParent(var1);
      }

      var8 = var4.iterator();

      while(var8.hasNext()) {
         var9 = (AbstractCriteriumTreeNode)var8.next();
         var1.add(var9);
         var9.setParent(var1);
      }

   }

   // $FF: synthetic method
   static AbstractCriteriumTreeNode access$100(JCriteriumTreeModel var0, AbstractCriteriumTreeNode var1, ICriterium var2) {
      return var0.findParentNode(var1, var2);
   }

   // $FF: synthetic method
   static List access$200(JCriteriumTreeModel var0) {
      return var0.criteria;
   }

   // $FF: synthetic method
   static ExpressionTreeActionProvider access$300(JCriteriumTreeModel var0) {
      return var0.actionProvider;
   }

   // $FF: synthetic method
   static JTree access$400(JCriteriumTreeModel var0) {
      return var0.jtree;
   }
}
